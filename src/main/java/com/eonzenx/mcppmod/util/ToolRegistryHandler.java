package com.eonzenx.mcppmod.util;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.tools.*;
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
    public static final RegistryObject<Item> VOLATILE_SWORD = TOOLS.register("volatile_sword", VolatileSwordItem::new);
    public static final RegistryObject<Item> VOLATILE_HOE = TOOLS.register("volatile_hoe", VolatileHoeItem::new);
    public static final RegistryObject<Item> VOLATILE_AXE = TOOLS.register("volatile_axe", VolatileAxeItem::new);
    public static final RegistryObject<Item> VOLATILE_PICKAXE = TOOLS.register("volatile_pickaxe", VolatilePickaxeItem::new);
    public static final RegistryObject<Item> VOLATILE_SHOVEL = TOOLS.register("volatile_shovel", VolatileShovelItem::new);
}
