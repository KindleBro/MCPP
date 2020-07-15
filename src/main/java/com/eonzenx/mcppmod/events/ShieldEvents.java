package com.eonzenx.mcppmod.events;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.tools.shields.CustomShield;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = MCPPMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ShieldEvents {

    @SubscribeEvent
    public static void livingAttacked(LivingAttackEvent event) {

        float dmg = event.getAmount();
        LivingEntity entity = event.getEntityLiving();

        if (dmg > 0.0f && entity instanceof PlayerEntity) {

            PlayerEntity plyr = (PlayerEntity) entity;

            if (plyr.world.isRemote) { return; }
            ItemStack activeStack = plyr.getActiveItemStack();

            if (!activeStack.isEmpty() && activeStack.getItem() instanceof CustomShield) {
                activeStack.damageItem(1 + MathHelper.floor(dmg), plyr, (temp_var_shield_break) -> {});
                plyr.attackEntityFrom(event.getSource(), dmg * ((CustomShield)activeStack.getItem()).getTier().getDamageReduction());
                System.out.println("Tried to attack the player");

                if (activeStack.isEmpty()) {
                    Hand hand = plyr.getActiveHand();
                    ForgeEventFactory.onPlayerDestroyItem(plyr, activeStack, hand);
                    plyr.setHeldItem(hand, ItemStack.EMPTY);

                    plyr.world.playSound(
                            plyr, plyr.serverPosX, plyr.serverPosY, plyr.serverPosZ,
                            SoundEvents.ITEM_SHIELD_BREAK, SoundCategory.PLAYERS,
                            0.6f + plyr.getRNG().nextFloat() * 0.4f,
                            0.8f + plyr.getRNG().nextFloat() * 0.4f
                    );
                }
            }
        }
    }

}
