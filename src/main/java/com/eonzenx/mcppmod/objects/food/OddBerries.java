package com.eonzenx.mcppmod.objects.food;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class OddBerries extends FoodBase
{
    public OddBerries()
    {
        super(new Properties()
                .food(new Food.Builder()
                        .hunger(2)
                        .saturation(0.5f)
                        .effect(new EffectInstance(Effects.JUMP_BOOST, 30, 1), 1.f)
                        .fastToEat()
                        .setAlwaysEdible()
                        .build())
                .maxStackSize(32)
        );
    }
}
