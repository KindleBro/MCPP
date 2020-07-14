package com.eonzenx.mcppmod.objects.tileentities;

import com.eonzenx.mcppmod.objects.blocks.SoupPotBlock;
import com.eonzenx.mcppmod.util.ItemRegistryHandler;
import com.eonzenx.mcppmod.util.TileEntityRegisterHandler;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SoupPotBlockTileEntity extends TileEntity implements ITickableTileEntity {

    private boolean isCooking = false;
    private int ticksLeft = 0;

    private ItemStackHandler itemHandler = createHandler();
    private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public SoupPotBlockTileEntity() {
        super(TileEntityRegisterHandler.SOUP_POT_TILE_ENTITY.get());
    }

    @Override
    public void tick() {
        if(world.isRemote){
            return;
        }

        if(isCooking){
            ticksLeft--;
            if(ticksLeft <= 0){
                isCooking = false;

                System.out.println("Cooked!");

                // put cooking result in the slot
                itemHandler.insertItem(5, new ItemStack(Items.COOKED_PORKCHOP, 4), false);
                markDirty();
            }
        }
    }

    /**
     * Create the item stack handler.
     * @return
     */
    private ItemStackHandler createHandler() {
        return new ItemStackHandler(6) {

            @Override
            protected void onContentsChanged(int slot) {
                // To make sure the TE persists when the chunk is saved later we need to
                // mark it dirty every time the item handler changes
                if(slot == 5){
                    if(getStackInSlot(5).isEmpty()){
                        getWorld().setBlockState(getPos(), getBlockState().with(SoupPotBlock.STATUS, SoupPotBlock.Status.EMPTY));
                    } else {
                        getWorld().setBlockState(getPos(), getBlockState().with(SoupPotBlock.STATUS, SoupPotBlock.Status.FULL));
                    }
                }
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return super.isItemValid(slot, stack);
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    /**
     * Read CompoundNBT tag.
     * @param state Block state of the block attached to this tile entity.
     * @param tag CompoundNBT tag.
     */
    public void read(BlockState state, CompoundNBT tag) {
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
        isCooking = tag.getBoolean("is_cooking");
        ticksLeft = tag.getInt("ticks_left");
        super.read(state, tag);
    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        tag.putBoolean("is_cooking", isCooking);
        tag.putInt("ticks_left", ticksLeft);
        return super.write(tag);
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap.equals(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

    public void startCooking(){
        isCooking = true;
        ticksLeft = 100;
        getWorld().setBlockState(getPos(), getBlockState().with(SoupPotBlock.STATUS, SoupPotBlock.Status.CLOSED));
    }

    public boolean isCooking(){
        return isCooking;
    }
}
