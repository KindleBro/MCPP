package com.eonzenx.mcppmod.objects.tiers;

import com.eonzenx.mcppmod.util.registry_handlers.ItemRegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum MMItemMaterials implements IItemTier {

    VOLATILE(1, 12.0f, 0.0f, 0, 22,
            Ingredient.fromItems(ItemRegistryHandler.ALCHEMISTS_GOLD_INGOT.get()));


    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int harvestLevel;
    private final int enchantibility;
    private final Ingredient repairMaterial;

    public final static float VOLATILE_EXPLOSION_POWER = 5.0f;


    MMItemMaterials(int maxUses, float efficiency, float attackDamage, int harvestLevel, int enchantibility, Ingredient repairMaterial) {
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.harvestLevel = harvestLevel;
        this.enchantibility = enchantibility;
        this.repairMaterial = repairMaterial;
    }


    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantibility;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial;
    }
}
