package com.eonzenx.mcppmod.objects.tileentities;

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

    private ItemStackHandler itemHandler = createHandler();
    private LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public SoupPotBlockTileEntity() {
        super(TileEntityRegisterHandler.SOUP_POT_TILE_ENTITY.get());
    }

    @Override
    public void tick() {

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
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return stack.getItem().isFood();
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!stack.getItem().isFood()) {
                    return stack;
                }
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
        super.read(state, tag);
    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        tag.put("inventory", itemHandler.serializeNBT());
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
}
