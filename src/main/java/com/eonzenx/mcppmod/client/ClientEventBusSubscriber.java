package com.eonzenx.mcppmod.client;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.client.gui.SoupPotBlockScreen;
import com.eonzenx.mcppmod.entities.capabilities.defaults.DCapabilityDash;
import com.eonzenx.mcppmod.entities.capabilities.interfaces.IDash;
import com.eonzenx.mcppmod.entities.capabilities.storage.DashStorage;
import com.eonzenx.mcppmod.util.registry_handlers.BlockRegistryHandler;
import com.eonzenx.mcppmod.util.registry_handlers.ContainerRegistryHandler;
import com.eonzenx.mcppmod.util.registry_handlers.ToolRegistryHandler;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MCPPMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {

        // Allows shields to animate the block correctly
        ItemModelsProperties.func_239418_a_(ToolRegistryHandler.WOODEN_SHIELD.get(),
                new ResourceLocation(MCPPMod.MOD_ID, "blocking"),
                (itemStack, world, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == itemStack ? 1.0F : 0.0F
        );

        ScreenManager.registerFactory(ContainerRegistryHandler.SOUP_POT_CONTAINER.get(), SoupPotBlockScreen::new);


        // Allows the crops to have transparency
        RenderTypeLookup.setRenderLayer(BlockRegistryHandler.SNOW_BERRY_BUSH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockRegistryHandler.JALAPENO_PLANT.get(), RenderType.getCutout());

        // Key bindings
        ClientRegistry.registerKeyBinding(KeyBindings.DASH);
    }

}