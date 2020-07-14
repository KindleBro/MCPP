package com.eonzenx.mcppmod.util;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.objects.tileentities.SoupPotBlockTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityRegisterHandler {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MCPPMod.MOD_ID);

    public static void init()
    {
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<TileEntityType<SoupPotBlockTileEntity>> SOUP_POT_TILE_ENTITY = TILE_ENTITIES.register("soup_pot",
            () -> TileEntityType.Builder.create(SoupPotBlockTileEntity::new, BlockRegistryHandler.SOUP_POT_BLOCK.get()).build(null)
    );
}
