package com.eonzenx.mcppmod.objects.food;

import com.eonzenx.mcppmod.util.BlockRegistryHandler;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class SnowBerries extends FoodBase
{
    public SnowBerries()
    {
        super(BlockRegistryHandler.SNOW_BERRY_BUSH.get(),
                new Item.Properties()
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.5f)
                            .effect(new EffectInstance(Effects.FIRE_RESISTANCE, 20, 0), 1.f)
                            .fastToEat()
                            .setAlwaysEdible()
                            .build())
                    .maxStackSize(32)
        );
    }
}
