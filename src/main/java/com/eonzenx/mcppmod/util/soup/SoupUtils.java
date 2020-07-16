package com.eonzenx.mcppmod.util.soup;

import com.eonzenx.mcppmod.objects.tileentities.SoupPotBlockTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;

import java.util.concurrent.atomic.AtomicBoolean;

public class SoupUtils {
    public static boolean attemptCooking(PlayerEntity player, SoupPotBlockTileEntity soupPotBlockTileEntity){
        AtomicBoolean success = new AtomicBoolean(false);

        soupPotBlockTileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(itemHandler -> {
            if(!itemHandler.getStackInSlot(5).isEmpty()){
                return;
            }
            for(SoupRecipe recipe : SoupRecipes.RECIPES){
                boolean recipeFound = true;
                for(ItemStack ingredient : recipe.getIngredients()){
                    boolean ingredientFound = false;
                    for(int i = 0; i < itemHandler.getSlots()-1; i++){
                        ItemStack slotStack = itemHandler.getStackInSlot(i);
                        if(ItemStack.areItemsEqual(slotStack, ingredient) && slotStack.getCount() >= ingredient.getCount()){
                            ingredientFound = true;
                        }
                    }
                    if(!ingredientFound){
                        recipeFound = false;
                    }
                }

                if(recipeFound){
                    for(ItemStack ingredient : recipe.getIngredients()){
                        for(int i = 0; i < itemHandler.getSlots()-1; i++){
                            ItemStack slotStack = itemHandler.getStackInSlot(i);
                            if(ItemStack.areItemsEqual(slotStack, ingredient) && slotStack.getCount() >= ingredient.getCount()){
                                slotStack.shrink(ingredient.getCount());
                            }
                        }
                    }

                    itemHandler.insertItem(5, recipe.getResult().copy(), false);
                    success.set(true);
                    return;
                }
            }
        });
        return success.get();
    }


}
