package com.eonzenx.mcppmod.events.handlers;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.entities.capabilities.providers.DashProvider;
import com.eonzenx.mcppmod.events.OnDashEvent;
import net.minecraft.entity.player.PlayerEntity;
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

        if (!canDash.get()) { return; }

        float dashReduction;
        float dashReductionMajor = 0.35f;
        float dashReductionMinor = 0.60f;
        float dashUpForce = 0.35f;
        int dashCooldownTicks = 20;


        // Minimum dash amount
        Vector3d playerMovement = player.getMotion();
        if (playerMovement.length() < 0.1) {
            dashReduction = dashReductionMinor;
        } else {
            dashReduction = dashReductionMajor;
        }

        Vector3d playerDashedMovement;
        float yaw = player.getPitchYaw().y;

        // 8 way direction
        switch (event.getDirection()) {
            case FORWARD:
                playerDashedMovement = playerMovement.add(                          // Take in consideration the players current movement
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw))          // Create a 3D vector from yaw
                                .mul(dashReduction, dashReduction, dashReduction)); // Reduce dash force by uniform amount
                break;
            case FORWARD_LEFT:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw - 45))
                                .mul(dashReduction, dashReduction, dashReduction));
                break;
            case FORWARD_RIGHT:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw + 45))
                                .mul(dashReduction, dashReduction, dashReduction));
                break;
            case BACKWARD:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw - 180))
                                .mul(dashReduction, dashReduction, dashReduction));
                break;
            case BACKWARD_LEFT:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw - 90 - 45))
                                .mul(dashReduction, dashReduction, dashReduction));
                break;
            case BACKWARD_RIGHT:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw + 90 + 45))
                                .mul(dashReduction, dashReduction, dashReduction));
                break;
            case LEFT:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw - 90))
                                .mul(dashReduction, dashReduction, dashReduction));
                break;
            case RIGHT:
                playerDashedMovement = playerMovement.add(
                        Vector3d.fromPitchYaw(new Vector2f(0.0f, yaw + 90))
                                .mul(dashReduction, dashReduction, dashReduction));
                break;
            default:
                playerDashedMovement = playerMovement.add(new Vector3d(0.0f, 1.0f, 0.0f));
        }

        player.setMotion(playerDashedMovement.x, playerDashedMovement.y + dashUpForce, playerDashedMovement.z);

        player.getCapability(DashProvider.DASH_CAP).ifPresent((handler) -> {handler.setCooldown(dashCooldownTicks);});
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
