package com.eonzenx.mcppmod;

import com.eonzenx.mcppmod.client.gui.SoupPotBlockScreen;
import com.eonzenx.mcppmod.util.*;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("mcppmod")
public class MCPPMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mcppmod";
    public static MCPPMod instance;

    public MCPPMod()
    {
        final IEventBus mcppmodEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the setup method for modloading
        mcppmodEventBus.addListener(this::setup);
        // Register the doClientStuff method for modloading
        mcppmodEventBus.addListener(this::doClientStuff);

        TileEntityRegisterHandler.init();
        ContainerRegistryHandler.init();
        FoodRegistryHandler.init();
        ToolRegistryHandler.init();
        ArmorRegistryHandler.init();
        BlockRegistryHandler.init();
        ItemRegistryHandler.init();

        instance = this;
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        ScreenManager.registerFactory(ContainerRegistryHandler.SOUP_POT_CONTAINER.get(), SoupPotBlockScreen::new);
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {

    }

}
