package com.eonzenx.mcppmod.objects.food;

import com.eonzenx.mcppmod.util.registry_handlers.BlockRegistryHandler;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

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


    @Override
    public int getUseDuration(ItemStack stack) {
        // Default is 16 || 32
        return 10;
    }
}
