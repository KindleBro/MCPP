package com.eonzenx.mcppmod.entities.capabilities;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.entities.capabilities.providers.DashProvider;
import com.eonzenx.mcppmod.entities.capabilities.storage.DashStorage;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MCPPMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MMCapabilityHandler {

    public static final ResourceLocation DASH_CAP = new ResourceLocation(MCPPMod.MOD_ID, DashStorage.DASH_KEY);

    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {

        if (!(event.getObject().getEntity() instanceof PlayerEntity)) { return; }
        event.addCapability(DASH_CAP, new DashProvider());
        System.out.println("Registered cap on this dumbass or soemthing idk");
    }

}
