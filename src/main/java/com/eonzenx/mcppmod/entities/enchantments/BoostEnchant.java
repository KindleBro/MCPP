package com.eonzenx.mcppmod.entities.enchantments;

import com.eonzenx.mcppmod.util.registry_handlers.EnchantRegistryHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class BoostEnchant extends Enchantment {

    /*
        Increase dash force.
     */

    public BoostEnchant() {
        super(Rarity.UNCOMMON, EnchantmentType.ARMOR_LEGS, new EquipmentSlotType[] { EquipmentSlotType.LEGS });
    }

    @Override
    public int getMinLevel() { return 1; }

    @Override
    public int getMaxLevel() { return 3; }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return !ench.equals(EnchantRegistryHandler.AGILE.get());
    }

    @Override
    public boolean isAllowedOnBooks() { return true; }
}
