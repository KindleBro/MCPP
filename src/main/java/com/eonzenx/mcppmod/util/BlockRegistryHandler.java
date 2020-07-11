package com.eonzenx.mcppmod.util;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.blocks.HNukeBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistryHandler {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MCPPMod.MOD_ID);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Blocks
    public static final RegistryObject<Block> H_NUKE_BLOCK = BLOCKS.register("h_nuke", HNukeBlock::new);

    // Block Items
    public static final RegistryObject<Item> H_NUKE_BLOCK_ITEM = ItemRegistryHandler.ITEMS.register("h_nuke", () -> new BlockItem(H_NUKE_BLOCK.get(), new Item.Properties().group(CustomItemGroups.CRAFTING_TAB)));
}
