package com.eonzenx.mcppmod.util;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.tools.VolatilePickaxe;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ToolRegistryHandler
{
    public static final DeferredRegister<Item> TOOLS = DeferredRegister.create(ForgeRegistries.ITEMS, MCPPMod.MOD_ID);

    public static void init()
    {
        TOOLS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Tools
    public static final RegistryObject<Item> VOLATILE_PICKAXE = TOOLS.register("volatile_pickaxe", VolatilePickaxe::new);
}
