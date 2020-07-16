package com.eonzenx.mcppmod.util.registry_handlers;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.items.AlchemistsGoldIngot;
import com.eonzenx.mcppmod.objects.items.CharredWood;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistryHandler
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MCPPMod.MOD_ID);

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Item> ALCHEMISTS_GOLD_INGOT = ITEMS.register("alchemists_gold_ingot", AlchemistsGoldIngot::new);
    public static final RegistryObject<Item> CHARRED_WOOD = ITEMS.register("charred_wood", CharredWood::new);
}
