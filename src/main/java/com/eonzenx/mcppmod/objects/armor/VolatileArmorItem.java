package com.eonzenx.mcppmod.objects.armor;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.tiers.VolatileArmorMaterial;
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

public class VolatileArmorItem extends ArmorItem {

    public VolatileArmorItem(EquipmentSlotType slot) {
        super(new VolatileArmorMaterial(), slot, new Properties().group(CustomItemGroups.CRAFTING_TAB));
    }


    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        entity.getEntityWorld().createExplosion(entity, entity.getPosX(), entity.getPosY(), entity.getPosZ(), VolatileItemTier.EXPLOSION_POWER, Explosion.Mode.BREAK);
        return amount;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        switch(slot){
            case HEAD:
            case CHEST:
            case FEET:
                return MCPPMod.MOD_ID+":textures/models/armor/volatile_layer_1.png";
            case LEGS:
                return MCPPMod.MOD_ID+":textures/models/armor/volatile_layer_2.png";
        }
        return MCPPMod.MOD_ID+":textures/models/armor/volatile_layer_1.png";
    }
}
