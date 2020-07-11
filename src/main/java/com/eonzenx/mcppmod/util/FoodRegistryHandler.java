package com.eonzenx.mcppmod.util;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.food.OddBerries;
import com.eonzenx.mcppmod.objects.food.SnowBerries;
import com.eonzenx.mcppmod.objects.food.SpicyBerries;
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
    public static final RegistryObject<Item> SPICY_BERRIES = FOOD.register("spicy_berries", SpicyBerries::new);
    public static final RegistryObject<Item> ODD_BERRIES = FOOD.register("odd_berries", OddBerries::new);
}
