package com.eonzenx.mcppmod.objects.tiers;

import net.minecraft.item.crafting.Ingredient;

public interface IShieldTier {

    int getMaxUses();
    int getEnchantability();
    Ingredient getRepairMaterial();
    float getDamageReduction();

}