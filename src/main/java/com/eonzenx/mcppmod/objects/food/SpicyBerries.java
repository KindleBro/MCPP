package com.eonzenx.mcppmod.objects.food;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SpicyBerries extends FoodBase
{
    public SpicyBerries()
    {
        super(new Item.Properties()
                .food(new Food.Builder()
                        .hunger(2)
                        .saturation(1.f)
                        .effect(new EffectInstance(Effects.SPEED, 40, 1), 1.f)
                        .fastToEat()
                        .setAlwaysEdible()
                        .build())
                .maxStackSize(32)
        );
    }
}
