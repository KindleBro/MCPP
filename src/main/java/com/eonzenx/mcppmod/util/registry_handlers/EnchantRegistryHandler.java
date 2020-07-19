package com.eonzenx.mcppmod.util.registry_handlers;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.entities.enchantments.AgileEnchant;
import com.eonzenx.mcppmod.entities.enchantments.BoostEnchant;
import com.eonzenx.mcppmod.entities.enchantments.HighJumpEnchant;
import com.eonzenx.mcppmod.objects.items.AlchemistsGoldIngot;
import com.eonzenx.mcppmod.objects.items.CharredWood;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EnchantRegistryHandler
{
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MCPPMod.MOD_ID);

    public static void init() { ENCHANTMENTS.register(FMLJavaModLoadingContext.get().getModEventBus()); }

    // Dash
    public static final RegistryObject<Enchantment> AGILE = ENCHANTMENTS.register("agile", AgileEnchant::new);
    public static final RegistryObject<Enchantment> BOOST = ENCHANTMENTS.register("boost", BoostEnchant::new);
    public static final RegistryObject<Enchantment> HIGH_JUMP = ENCHANTMENTS.register("high_jump", HighJumpEnchant::new);

    // Shields
}
