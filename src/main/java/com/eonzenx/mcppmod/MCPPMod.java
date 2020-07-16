package com.eonzenx.mcppmod;

import com.eonzenx.mcppmod.client.gui.SoupPotBlockScreen;
import com.eonzenx.mcppmod.client.KeyBindings;
import com.eonzenx.mcppmod.networking.MCPPPacketHandler;
import com.eonzenx.mcppmod.util.registry_handlers.*;
import com.eonzenx.mcppmod.util.soup.SoupRecipes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.annotation.Nullable;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("mcppmod")
public class MCPPMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "mcppmod";

    public MCPPMod()
    {
        final IEventBus mcppmodEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        mcppmodEventBus.addListener(this::setup);           // Register the setup method for modloading
        mcppmodEventBus.addListener(this::doClientStuff);   // Register the doClientStuff method for modloading

        // Register all modded stuff
        BlockRegistryHandler.init();

        ItemRegistryHandler.init();
        ToolRegistryHandler.init();
        ArmorRegistryHandler.init();

        FoodRegistryHandler.init();
        SoupRecipes.init();

        TileEntityRegisterHandler.init();
        ContainerRegistryHandler.init();


        MinecraftForge.EVENT_BUS.register(this);  // Register ourselves for server and other game events we are interested in
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        ScreenManager.registerFactory(ContainerRegistryHandler.SOUP_POT_CONTAINER.get(), SoupPotBlockScreen::new);
        MCPPPacketHandler.registerMessages();
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {

        // Allows shields to animate the block correctly
        ItemModelsProperties.func_239418_a_(ToolRegistryHandler.WOODEN_SHIELD.get(), new ResourceLocation(MOD_ID, "blocking"), new IItemPropertyGetter() {
            @Override
            public float call(ItemStack itemStack, @Nullable ClientWorld world, @Nullable LivingEntity entity) {
                return entity != null && entity.isHandActive() && entity.getActiveItemStack() == itemStack ? 1.0F : 0.0F;
            }
        });

        // Allows the crops to have transparency
        RenderTypeLookup.setRenderLayer(BlockRegistryHandler.SNOW_BERRY_BUSH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockRegistryHandler.JALAPENO_PLANT.get(), RenderType.getCutout());

        // Key bindings
        ClientRegistry.registerKeyBinding(KeyBindings.DASH);

    }

}
