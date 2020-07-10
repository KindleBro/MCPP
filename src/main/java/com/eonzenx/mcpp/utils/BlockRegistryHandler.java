package com.eonzenx.mcpp.utils;

import com.eonzenx.mcpp.MCPPBase;
import com.eonzenx.mcpp.blocks.TempBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistryHandler {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MCPPBase.MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Blocks
    public static final RegistryObject<Block> TEMP_BLOCK = BLOCKS.register("temp_block", TempBlock::new);

    // Block Items
    public static final RegistryObject<Item> TEMP_BLOCK_ITEM = ItemRegistryHandler.ITEMS.register("temp_block", () -> new BlockItemBase(TEMP_BLOCK.get()));

}
