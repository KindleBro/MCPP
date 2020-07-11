package com.eonzenx.mcppmod.objects.tiers;

import com.eonzenx.mcppmod.util.ItemRegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.Ingredient;

public class VolatileItemTier implements IItemTier {

    public static float AXE_ATTACK_SPEED = 1.0f;
    public static int AXE_ATTACK_DAMAGE = 7;

    public static float HOE_ATTACK_SPEED = 1.0f;

    public static float PICKAXE_ATTACK_SPEED = 1.2f;
    public static int PICKAXE_ATTACK_DAMAGE = 2;

    public static float SHOVEL_ATTACK_SPEED = 1.6f;
    public static int SHOVEL_ATTACK_DAMAGE = 3;

    public static float SWORD_ATTACK_SPEED = 1.0f;
    public static int SWORD_ATTACK_DAMAGE = 5;

    public static float EXPLOSION_POWER = 5f;

    @Override
    public int getMaxUses() {
        return 1;
    }

    @Override
    public float getEfficiency() {
        return ItemTier.GOLD.getEfficiency();
    }

    @Override
    public float getAttackDamage() {
        return ItemTier.GOLD.getAttackDamage();
    }

    @Override
    public int getHarvestLevel() {
        return ItemTier.GOLD.getHarvestLevel();
    }

    @Override
    public int getEnchantability() {
        return ItemTier.GOLD.getEnchantability();
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ItemRegistryHandler.ALCHEMISTS_GOLD_INGOT.get());
    }
}