package com.eonzenx.mcppmod.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {

    public static final KeyBinding DASH = new KeyBinding("key.dash.text", KeyConflictContext.UNIVERSAL, InputMappings.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_ALT, "key.categories.mcppmod.text");

}
