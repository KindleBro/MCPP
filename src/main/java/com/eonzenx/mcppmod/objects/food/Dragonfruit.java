package com.eonzenx.mcppmod.objects.food;

import com.eonzenx.mcppmod.util.registry_handlers.BlockRegistryHandler;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Dragonfruit extends FoodBase
{
    public Dragonfruit()
    {
        super(BlockRegistryHandler.DRAGONFRUIT_TREE.get(),
                new Item.Properties()
                    .food(new Food.Builder()
                            .hunger(2)
                            .saturation(0.5f)
                            .effect(new EffectInstance(Effects.JUMP_BOOST, 40, 1), 1.f)
                            .fastToEat()
                            .setAlwaysEdible()
                            .build())
                    .maxStackSize(32)
        );
    }
}
