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
        if (event.getAction() == GLFW.GLFW_PRESS) {  // If the event is the start of a key down
            if (KeyBindings.DASH.getKey().getKeyCode() == event.getKey()) {
                if (InputMappings.isKeyDown(
                        Minecraft.getInstance().getMainWindow().getHandle(),  // Get game window ID
                        Minecraft.getInstance().gameSettings.keyBindForward.getKey().getKeyCode()  // Get key id for movement
                )) {
                    MinecraftForge.EVENT_BUS.post(new OnDashEvent(Direction.FORWARD, Minecraft.getInstance().player));
                    System.out.println("Dashed forward!");
                }
                else if (InputMappings.isKeyDown(
                        Minecraft.getInstance().getMainWindow().getHandle(),  // Get game window ID
                        Minecraft.getInstance().gameSettings.keyBindBack.getKey().getKeyCode()  // Get key id for movement
                )) {
                    MinecraftForge.EVENT_BUS.post(new OnDashEvent(Direction.BACKWARD, Minecraft.getInstance().player));
                    System.out.println("Dashed backward!");
                }
                else if (InputMappings.isKeyDown(
                        Minecraft.getInstance().getMainWindow().getHandle(),  // Get game window ID
                        Minecraft.getInstance().gameSettings.keyBindLeft.getKey().getKeyCode()  // Get key id for movement
                )) {
                    MinecraftForge.EVENT_BUS.post(new OnDashEvent(Direction.LEFT, Minecraft.getInstance().player));
                    System.out.println("Dashed left!");
                }
                else if (InputMappings.isKeyDown(
                        Minecraft.getInstance().getMainWindow().getHandle(),  // Get game window ID
                        Minecraft.getInstance().gameSettings.keyBindRight.getKey().getKeyCode()  // Get key id for movement
                )) {
                    MinecraftForge.EVENT_BUS.post(new OnDashEvent(Direction.RIGHT, Minecraft.getInstance().player));
                    System.out.println("Dashed right!");
                }
            }
        }
    }
}
