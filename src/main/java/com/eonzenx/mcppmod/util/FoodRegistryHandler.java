package com.eonzenx.mcppmod.util;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.food.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FoodRegistryHandler
{
    public static final DeferredRegister<Item> FOOD = DeferredRegister.create(ForgeRegistries.ITEMS, MCPPMod.MOD_ID);

    public static void init()
    {
        FOOD.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Food
    public static final RegistryObject<Item> SNOW_BERRIES = FOOD.register("snow_berries", SnowBerries::new);
    public static final RegistryObject<Item> WILD_SOURSOP = FOOD.register("wild_soursop", WildSoursop::new);
    public static final RegistryObject<Item> PEACH = FOOD.register("peach", Peach::new);
    public static final RegistryObject<Item> GOURD = FOOD.register("gourd", Gourd::new);
    public static final RegistryObject<Item> JALAPENOS = FOOD.register("jalapenos", Jalapenos::new);
    public static final RegistryObject<Item> DRAGON_FRUIT = FOOD.register("dragonfruit", Dragonfruit::new);
}
