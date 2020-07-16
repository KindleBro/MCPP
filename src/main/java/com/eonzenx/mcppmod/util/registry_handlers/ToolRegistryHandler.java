package com.eonzenx.mcppmod.util.registry_handlers;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.tools.shields.CustomShield;
import com.eonzenx.mcppmod.objects.tiers.MMShieldTier;
import com.eonzenx.mcppmod.objects.tools.volatile_items.*;
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

    // Combat
    public static final RegistryObject<Item> WOODEN_SHIELD = TOOLS.register("wooden_shield", () -> new CustomShield(MMShieldTier.WOOD, new Item.Properties()));
    public static final RegistryObject<Item> STONE_SHIELD = TOOLS.register("stone_shield", () -> new CustomShield(MMShieldTier.STONE, new Item.Properties()));
    public static final RegistryObject<Item> IRON_SHIELD = TOOLS.register("iron_shield", () -> new CustomShield(MMShieldTier.IRON, new Item.Properties()));
    public static final RegistryObject<Item> GOLD_SHIELD = TOOLS.register("gold_shield", () -> new CustomShield(MMShieldTier.GOLD, new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SHIELD = TOOLS.register("diamond_shield", () -> new CustomShield(MMShieldTier.DIAMOND, new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_SHIELD = TOOLS.register("netherite_shield", () -> new CustomShield(MMShieldTier.NETHERITE, new Item.Properties()));
}
