package com.eonzenx.mcppmod.entities.enchantments;

import com.eonzenx.mcppmod.util.registry_handlers.EnchantRegistryHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class AgileEnchant extends Enchantment {

    /*
        Reduces cooldown of dash.
     */

    public AgileEnchant() {
        super(Rarity.UNCOMMON, EnchantmentType.ARMOR_LEGS, new EquipmentSlotType[] { EquipmentSlotType.LEGS });
    }

    @Override
    public int getMinLevel() { return 1; }

    @Override
    public int getMaxLevel() { return 4; }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return !ench.equals(EnchantRegistryHandler.BOOST.get());
    }

    @Override
    public boolean isAllowedOnBooks() { return true; }
}
