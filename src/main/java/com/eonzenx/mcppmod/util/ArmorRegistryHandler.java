package com.eonzenx.mcppmod.util;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.armor.VolatileArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ArmorRegistryHandler
{
    public static final DeferredRegister<Item> ARMOR = DeferredRegister.create(ForgeRegistries.ITEMS, MCPPMod.MOD_ID);

    public static void init()
    {
        ARMOR.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Item> VOLATILE_HELMET = ARMOR.register("volatile_helmet", () -> new VolatileArmorItem(EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> VOLATILE_CHESTPLATE = ARMOR.register("volatile_chestplate", () -> new VolatileArmorItem(EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> VOLATILE_LEGGINGS = ARMOR.register("volatile_leggings", () -> new VolatileArmorItem(EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> VOLATILE_BOOTS = ARMOR.register("volatile_boots", () -> new VolatileArmorItem(EquipmentSlotType.FEET));
}
