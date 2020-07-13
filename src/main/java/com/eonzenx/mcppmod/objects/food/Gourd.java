package com.eonzenx.mcppmod.objects.food;

import com.eonzenx.mcppmod.util.BlockRegistryHandler;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Gourd extends FoodBase
{
    public Gourd()
    {
        super(BlockRegistryHandler.GOURD_VINE.get(),
                new Item.Properties()
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(1.f)
                            .effect(new EffectInstance(Effects.HASTE, 200, 0), 1.f)
                            .fastToEat()
                            .setAlwaysEdible()
                            .build())
                    .maxStackSize(32)
        );
    }
}
