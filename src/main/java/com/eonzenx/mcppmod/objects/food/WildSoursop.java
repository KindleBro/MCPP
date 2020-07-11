package com.eonzenx.mcppmod.objects.food;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class WildSoursop extends FoodBase
{
    public WildSoursop()
    {
        super(new Properties()
                .food(new Food.Builder()
                        .hunger(2)
                        .saturation(1.f)
                        .effect(new EffectInstance(Effects.STRENGTH, 150, 0), 1.f)
                        .fastToEat()
                        .setAlwaysEdible()
                        .build())
                .maxStackSize(32)
        );
    }
}
