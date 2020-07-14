package com.eonzenx.mcppmod.objects.tiers;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.util.ItemRegistryHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum MCPPModArmorMaterials implements IArmorMaterial {

    CHARRED_WOOD(MCPPMod.MOD_ID + ":charred_wood", 5, new int [] { 1, 1, 2, 1 }, 6,
            SoundEvents.ITEM_ARMOR_EQUIP_TURTLE, 0.0f, () -> { return Ingredient.fromItems(ItemRegistryHandler.CHARRED_WOOD.get()); }, 0.0f),

    VOLATILE(MCPPMod.MOD_ID + ":volatile", 0, new int[] {1, 3, 5, 2}, 25,
            SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0f, () -> { return Ingredient.fromItems(Items.GOLD_INGOT); }, 0.0f);



    //                                             Boots, Leggings, Chestplate, Helmet
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantibility;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    private final float netheriteThing;

    MCPPModArmorMaterials(String name, int maxDamageFactor, int[] damageReductionAmountArray,
                          int enchantibility, SoundEvent soundEvent, float toughness,
                          Supplier<Ingredient> repairMaterial, float netheriteThing)
    {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantibility = enchantibility;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.netheriteThing = netheriteThing;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantibility;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float func_230304_f_() {
        return this.netheriteThing;
    }
}
