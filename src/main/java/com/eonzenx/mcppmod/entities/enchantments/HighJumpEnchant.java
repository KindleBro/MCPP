package com.eonzenx.mcppmod.entities.enchantments;

import com.eonzenx.mcppmod.util.registry_handlers.EnchantRegistryHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class HighJumpEnchant extends Enchantment {

    /*
        Increase dash height.
     */

    public HighJumpEnchant() {
        super(Rarity.UNCOMMON, EnchantmentType.ARMOR_FEET, new EquipmentSlotType[] { EquipmentSlotType.FEET });
    }

    @Override
    public int getMinLevel() { return 1; }

    @Override
    public int getMaxLevel() { return 3; }

    @Override
    public boolean isAllowedOnBooks() { return true; }
}
