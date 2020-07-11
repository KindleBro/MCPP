package com.eonzenx.mcppmod.objects.tiers;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;

public class VolatileArmorMaterial implements IArmorMaterial {

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return 1;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return ArmorMaterial.GOLD.getDamageReductionAmount(slotIn);
    }

    @Override
    public int getEnchantability() {
        return ArmorMaterial.GOLD.getEnchantability();
    }

    @Override
    public SoundEvent getSoundEvent() {
        return ArmorMaterial.GOLD.getSoundEvent();
    }

    @Override
    public Ingredient getRepairMaterial() {
        return ArmorMaterial.GOLD.getRepairMaterial();
    }

    @Override
    public String getName() {
        return "Alchemist's Gold";
    }

    @Override
    public float getToughness() {
        return ArmorMaterial.GOLD.getToughness();
    }

    /**
     * This is knockback resistance.
     * @return
     */
    @Override
    public float func_230304_f_() {
        return ArmorMaterial.GOLD.func_230304_f_();
    }
}
