package com.eonzenx.mcppmod.objects.armor;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.tiers.MCPPModArmorMaterials;
import com.eonzenx.mcppmod.objects.tiers.VolatileItemTier;
import com.eonzenx.mcppmod.util.CustomItemGroups;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class CharredWoodArmorItem extends ArmorItem {

    public CharredWoodArmorItem(EquipmentSlotType slot) {
        super(MCPPModArmorMaterials.CHARRED_WOOD, slot, new Properties().group(CustomItemGroups.CRAFTING_TAB));
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        switch(slot){
            case HEAD:
            case CHEST:
            case FEET:
                return MCPPMod.MOD_ID + ":textures/models/armor/charred_layer_1.png";
            case LEGS:
                return MCPPMod.MOD_ID + ":textures/models/armor/charred_layer_2.png";
        }
        return MCPPMod.MOD_ID + ":textures/models/armor/charred_layer_1.png";
    }
}
