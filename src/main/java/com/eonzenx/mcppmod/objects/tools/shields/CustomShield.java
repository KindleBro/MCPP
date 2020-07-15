package com.eonzenx.mcppmod.objects.tools.shields;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.util.registry_handlers.CustomItemGroups;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

public class CustomShield extends ShieldItem {

    private final ShieldTier tier;

    public CustomShield(ShieldTier tier, Item.Properties properties) {
        super(properties.group(CustomItemGroups.COMBAT_TAB));
        this.tier = tier;
    }

    public ShieldTier getTier() {
        return tier;
    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable LivingEntity entity) {
        return true;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public boolean getIsRepairable(@Nullable ItemStack toRepair, @Nullable ItemStack repair) {
        return tier.getRepairMaterial() == Ingredient.fromStacks(repair);
    }
}
