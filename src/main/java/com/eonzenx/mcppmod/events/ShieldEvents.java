package com.eonzenx.mcppmod.events;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.tools.shields.CustomShield;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = MCPPMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ShieldEvents {

    public static DamageSource SHIELD_SOURCE = new DamageSource("blockDamage");

    @SubscribeEvent
    public static void attackEvent(LivingAttackEvent e) {
        if(e.getSource().damageType == "blockDamage"){
            System.out.println("Took damage through shield "+e.getAmount());
            return;
        }

        float damage = e.getAmount();
        if(damage > 0 && e.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) e.getEntityLiving();
            if(player.world.isRemote) return;
            ItemStack activeItemStack = player.getActiveItemStack();
            if(!activeItemStack.isEmpty() && activeItemStack.getItem() instanceof CustomShield && canBlockDamageSource(player, e.getSource())) {

                e.setCanceled(true);
                System.out.println("Blocked damage with shield!");
                float reducedDamage = e.getAmount() * ((CustomShield) activeItemStack.getItem()).getTier().getDamageReduction();
                player.attackEntityFrom(SHIELD_SOURCE, reducedDamage);

                activeItemStack.damageItem(1 + MathHelper.floor(damage), player, (playerEntity)->{
                    System.out.println("Shield broke");
                });
                if (activeItemStack.isEmpty()) {
                    Hand hand = player.getActiveHand();
                    net.minecraftforge.event.ForgeEventFactory.onPlayerDestroyItem(player, activeItemStack, hand);
                    player.setHeldItem(hand, ItemStack.EMPTY);
                    player.world.playSound(null, player.getPosX(), player.getPosY(), player.getPosZ(),
                            SoundEvents.ITEM_SHIELD_BREAK,
                            SoundCategory.PLAYERS,
                            0.6F + player.getRNG().nextFloat() * 0.4F, 0.8F + player.getRNG().nextFloat() * 0.4F);
                }
            }


        }
    }

    /**
     * Determines whether the entity can block the damage source based on the damage source's location, whether the
     * damage source is blockable.
     *
     * Mostly stolen from LivingEntity
     */
    public static boolean canBlockDamageSource(LivingEntity livingEntity, DamageSource damageSourceIn) {
        Entity entity = damageSourceIn.getImmediateSource();
        boolean flag = false;
        if (entity instanceof AbstractArrowEntity) {
            AbstractArrowEntity abstractarrowentity = (AbstractArrowEntity)entity;
            if (abstractarrowentity.getPierceLevel() > 0) {
                flag = true;
            }
        }

        if (!damageSourceIn.isUnblockable() && !flag) {
            Vector3d vector3d2 = damageSourceIn.getDamageLocation();
            if (vector3d2 != null) {
                Vector3d vector3d = livingEntity.getLook(1.0F);
                Vector3d vector3d1 = vector3d2.subtractReverse(livingEntity.getPositionVec()).normalize();
                vector3d1 = new Vector3d(vector3d1.x, 0.0D, vector3d1.z);
                if (vector3d1.dotProduct(vector3d) < 0.0D) {
                    return true;
                }
            }
        }

        return false;
    }
}
