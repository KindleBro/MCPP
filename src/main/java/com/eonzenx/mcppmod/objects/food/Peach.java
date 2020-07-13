package com.eonzenx.mcppmod.objects.food;

import com.eonzenx.mcppmod.util.BlockRegistryHandler;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Peach extends FoodBase
{
    public Peach()
    {
        super(BlockRegistryHandler.PEACH_SAPLING.get(),
                new Item.Properties()
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(1.f)
                            .effect(new EffectInstance(Effects.ABSORPTION, 150, 0), 1.f)
                            .fastToEat()
                            .setAlwaysEdible()
                            .build())
                    .maxStackSize(32)
        );
    }
}
