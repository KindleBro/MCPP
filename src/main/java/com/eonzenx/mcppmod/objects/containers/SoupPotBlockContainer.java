package com.eonzenx.mcppmod.objects.containers;

import com.eonzenx.mcppmod.util.registry_handlers.ContainerRegistryHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SoupPotBlockContainer extends Container {

    private TileEntity tileEntity;

    public SoupPotBlockContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        super(ContainerRegistryHandler.SOUP_POT_CONTAINER.get(), windowId);

        this.tileEntity = world.getTileEntity(pos);

        // Inventory
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                Slot playerSlot = new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18);
                this.addSlot(playerSlot);
            }
        }

        // Inventory Hotbar
        for(int k = 0; k < 9; ++k) {
            Slot playerSlot = new Slot(playerInventory, k, 8 + k * 18, 142);
            this.addSlot(playerSlot);
        }


        if(tileEntity != null){
            tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler->{
                addSlot(new SlotItemHandler(handler, 0, 44, 23));
                addSlot(new SlotItemHandler(handler, 1, 44+1*18, 23));
                addSlot(new SlotItemHandler(handler, 2, 44+2*18, 23));
                addSlot(new SlotItemHandler(handler, 3, 44+3*18, 23));
                addSlot(new SlotItemHandler(handler, 4, 44+4*18, 23));

                addSlot(new SlotItemHandler(handler, 5, 44+2*18, 59));
            });
        }
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }

    /**
     * This needs to do something, otherwise CRASH!
     * @param playerIn
     * @param index
     * @return
     */
    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        System.out.println("Item stack at "+index+" shift clicked");
        return ItemStack.EMPTY;
    }

    public TileEntity getTileEntity() {
        return tileEntity;
    }
}
