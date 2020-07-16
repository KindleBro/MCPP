package com.eonzenx.mcppmod.util.registry_handlers;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.blocks.*;
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
    public static final RegistryObject<Block> SOUP_POT_BLOCK = BLOCKS.register("soup_pot", SoupPotBlock::new);
    public static final RegistryObject<Block> SNOW_BERRY_BUSH = BLOCKS.register("snow_berry_bush", SnowBerryBush::new);
    public static final RegistryObject<Block> GOURD_VINE = BLOCKS.register("gourd_vine", GourdVine::new);
    public static final RegistryObject<Block> JALAPENO_PLANT = BLOCKS.register("jalapeno_plant", JalapenoPlant::new);
    public static final RegistryObject<Block> PEACH_SAPLING = BLOCKS.register("peach_sapling", PeachSapling::new);
    public static final RegistryObject<Block> SOURSOP_TREE = BLOCKS.register("soursop_tree", SoursopTree::new);
    public static final RegistryObject<Block> DRAGONFRUIT_TREE = BLOCKS.register("dragonfruit_tree", DragonfruitTree::new);

    // Block Items
    public static final RegistryObject<Item> H_NUKE_BLOCK_ITEM = ItemRegistryHandler.ITEMS.register("h_nuke",
            () -> new BlockItem(H_NUKE_BLOCK.get(), new Item.Properties().group(CustomItemGroups.CRAFTING_TAB))
    );
    public static final RegistryObject<Item> SOUP_POT_BLOCK_ITEM = ItemRegistryHandler.ITEMS.register("soup_pot",
            () -> new BlockItem(SOUP_POT_BLOCK.get(), new Item.Properties().group(CustomItemGroups.CRAFTING_TAB))
    );
}
