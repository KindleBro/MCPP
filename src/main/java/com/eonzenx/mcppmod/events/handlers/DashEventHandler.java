package com.eonzenx.mcppmod.events.handlers;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.entities.capabilities.providers.DashProvider;
import com.eonzenx.mcppmod.events.OnDashEvent;
import com.eonzenx.mcppmod.util.config.DashConfig;
import com.eonzenx.mcppmod.util.registry_handlers.EnchantRegistryHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.atomic.AtomicBoolean;

@Mod.EventBusSubscriber(modid = MCPPMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DashEventHandler {

    @SubscribeEvent
    public static void dashPlayer(OnDashEvent event) {
        PlayerEntity player = event.getPlayer();

        AtomicBoolean canDash = new AtomicBoolean(false);
        player.getCapability(DashProvider.DASH_CAP).ifPresent((handler) -> {canDash.set(handler.canDash());});

        boolean isPlayerOnGround = player.func_233570_aj_();

        if (!canDash.get() || !isPlayerOnGround) { return; }

        // Default values
        float dashMultiplier = DashConfig.FORCE_REDUCER_MAJOR;
        float dashUpForce = DashConfig.UP_FORCE;
        int dashCooldown = DashConfig.COOLDOWN;


        // Minimum dash amount
        Vector3d playerMovement = player.getMotion();
        if (playerMovement.length() < 0.1) { dashMultiplier = DashConfig.FORCE_REDUCER_MINOR; }


        // Enchantment dash force multiplier
        float dashForceELvl = EnchantmentHelper.getMaxEnchantmentLevel(EnchantRegistryHandler.BOOST.get(), player);
        dashMultiplier *= (dashForceELvl / 2.5f) + 1;

        // Enchantment up force multiplier
        float dashJumpForceELvl = EnchantmentHelper.getMaxEnchantmentLevel(EnchantRegistryHandler.HIGH_JUMP.get(), player);
        dashUpForce *= (dashJumpForceELvl / 3.10f) + 1;

        // Enchantment cooldown multiplier
        float dashCooldownELvl = EnchantmentHelper.getMaxEnchantmentLevel(EnchantRegistryHandler.AGILE.get(), player);
        dashCooldown *= 1 - MathHelper.floor(dashCooldownELvl / 4.f);


        Vector3d playerDashedMovement;
        float yaw = player.getPitchYaw().y;

        // 8 way direction
        switch (event.getDirection()) {
            case FORWARD:
                playerDashedMovement = playerMovement.add(                              // Take in consideration the players current movement
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw))              // Create a 3D vector from yaw
                                .mul(dashMultiplier, dashMultiplier, dashMultiplier));  // Reduce dash force by uniform amount
                break;
            case FORWARD_LEFT:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw - 45))
                                .mul(dashMultiplier, dashMultiplier, dashMultiplier));
                break;
            case FORWARD_RIGHT:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw + 45))
                                .mul(dashMultiplier, dashMultiplier, dashMultiplier));
                break;
            case BACKWARD:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw - 180))
                                .mul(dashMultiplier, dashMultiplier, dashMultiplier));
                break;
            case BACKWARD_LEFT:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw - 90 - 45))
                                .mul(dashMultiplier, dashMultiplier, dashMultiplier));
                break;
            case BACKWARD_RIGHT:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw + 90 + 45))
                                .mul(dashMultiplier, dashMultiplier, dashMultiplier));
                break;
            case LEFT:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw - 90))
                                .mul(dashMultiplier, dashMultiplier, dashMultiplier));
                break;
            case RIGHT:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw + 90))
                                .mul(dashMultiplier, dashMultiplier, dashMultiplier));
                break;
            default:
                playerDashedMovement = playerMovement.add(new Vector3d(0.0f, 1.0f, 0.0f));
        }

        player.setMotion(playerDashedMovement.x, playerDashedMovement.y + dashUpForce, playerDashedMovement.z);

        int finalDashCooldown = dashCooldown;   // Recommended effectively final variable
        player.getCapability(DashProvider.DASH_CAP).ifPresent((handler) -> {handler.setCooldown(finalDashCooldown);});
    }

    @SubscribeEvent
    public static void reduceCooldown(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;

        player.getCapability(DashProvider.DASH_CAP).ifPresent(
                (handler) -> {
                    handler.reduceCooldown();
                }
        );
    }

}
