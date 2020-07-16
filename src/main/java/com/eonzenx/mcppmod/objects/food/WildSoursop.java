package com.eonzenx.mcppmod.objects.food;

import com.eonzenx.mcppmod.util.registry_handlers.BlockRegistryHandler;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class WildSoursop extends FoodBase
{
    public WildSoursop()
    {
        super(BlockRegistryHandler.SOURSOP_TREE.get(),
                new Item.Properties()
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

    @Override
    public int getUseDuration(ItemStack stack) {
        // Default is 16 || 32
        return 20;
    }
}
