package com.eonzenx.mcppmod.events.handlers;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.client.KeyBindings;
import com.eonzenx.mcppmod.events.OnDashEvent;
import com.eonzenx.mcppmod.util.Direction;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyBindingMap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;


@Mod.EventBusSubscriber(modid = MCPPMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KeyInputEventHandler {

    @SubscribeEvent
    public static void keyPress(InputEvent.KeyInputEvent event)
    {
        if (event.getAction() == GLFW.GLFW_PRESS) {     // If the event is the start of a key down
            if (KeyBindings.DASH.getKey().getKeyCode() == event.getKey()) {

                Minecraft mc_instance = Minecraft.getInstance();
                long mc_handle = mc_instance.getMainWindow().getHandle();;

                if (InputMappings.isKeyDown(mc_handle,          // Forward key down
                        mc_instance.gameSettings.keyBindForward.getKey().getKeyCode()  // Get key id for movement
                )) {
                    if (InputMappings.isKeyDown(mc_handle,        // Left key down
                            mc_instance.gameSettings.keyBindLeft.getKey().getKeyCode()
                    )) {
                        MinecraftForge.EVENT_BUS.post(new OnDashEvent(Direction.FORWARD_LEFT, mc_instance.player));
                    } else if (InputMappings.isKeyDown(mc_handle, // Right key down
                            mc_instance.gameSettings.keyBindRight.getKey().getKeyCode()
                    )) {
                        MinecraftForge.EVENT_BUS.post(new OnDashEvent(Direction.FORWARD_RIGHT, mc_instance.player));
                    } else {    // Only moving forward
                        MinecraftForge.EVENT_BUS.post(new OnDashEvent(Direction.FORWARD, mc_instance.player));
                    }
                }
                else if (InputMappings.isKeyDown( mc_handle,    // Backward key down
                        mc_instance.gameSettings.keyBindBack.getKey().getKeyCode()  // Get key id for movement
                )) {
                    if (InputMappings.isKeyDown(mc_handle,        // Left key down
                            mc_instance.gameSettings.keyBindLeft.getKey().getKeyCode()
                    )) {
                        MinecraftForge.EVENT_BUS.post(new OnDashEvent(Direction.BACKWARD_LEFT, mc_instance.player));
                    } else if (InputMappings.isKeyDown(mc_handle, // Right key down
                            mc_instance.gameSettings.keyBindRight.getKey().getKeyCode()
                    )) {
                        MinecraftForge.EVENT_BUS.post(new OnDashEvent(Direction.BACKWARD_RIGHT, mc_instance.player));
                    } else {    // Only moving backward
                        MinecraftForge.EVENT_BUS.post(new OnDashEvent(Direction.BACKWARD, mc_instance.player));
                    }
                }
                else if (InputMappings.isKeyDown(mc_handle,     // Just Left
                        mc_instance.gameSettings.keyBindLeft.getKey().getKeyCode()
                )) {
                    MinecraftForge.EVENT_BUS.post(new OnDashEvent(Direction.LEFT, mc_instance.player));
                }
                else if (InputMappings.isKeyDown(mc_handle,     // Just Right
                        mc_instance.gameSettings.keyBindRight.getKey().getKeyCode()
                )) {
                    MinecraftForge.EVENT_BUS.post(new OnDashEvent(Direction.RIGHT, mc_instance.player));
                }
            }
        }
    }
}
