package com.eonzenx.mcppmod.objects.tools.shields;

import com.eonzenx.mcppmod.util.IShieldTier;
import com.eonzenx.mcppmod.util.registry_handlers.ItemRegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;

public enum ShieldTier implements IShieldTier {

    WOOD(10, 30, 15, Ingredient.fromItems(Items.OAK_PLANKS)),
    STONE(20, 40, 5, Ingredient.fromItems(Items.COBBLESTONE)),  // I assume this is stone because stone tools have this tag
    IRON(35, 60, 14, Ingredient.fromItems(Items.IRON_INGOT)),
    GOLD(15, 60, 22, Ingredient.fromItems(Items.GOLD_INGOT)),
    DIAMOND(50, 75, 10, Ingredient.fromItems(Items.DIAMOND)),
    NETHERITE(50, 75, 15, Ingredient.fromItems(Items.NETHERITE_INGOT)),
    VOLATILE(1, 100, 22, Ingredient.fromItems(ItemRegistryHandler.ALCHEMISTS_GOLD_INGOT.get()));

    private final int maxUses;
    private final float damageReduction;
    private final int enchantability;
    private final Ingredient repairableMaterial;

    ShieldTier(int maxUses, int damageReduction, int enchantability, Ingredient repairableMaterial) {
        this.maxUses = maxUses;
        this.damageReduction = damageReduction / 100.f;
        this.enchantability = enchantability;
        this.repairableMaterial = repairableMaterial;
    }

    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getDamageReduction() {
        return this.damageReduction;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairableMaterial;
    }
}
