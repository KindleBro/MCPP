package com.eonzenx.mcppmod.events;

import com.eonzenx.mcppmod.MCPPMod;
import com.eonzenx.mcppmod.util.Direction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MCPPMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnDashEvent extends Event {

    private final Direction direction;
    private final PlayerEntity player;

    public OnDashEvent(Direction direction, PlayerEntity player) {
        this.direction = direction;
        this.player = player;
    }

    public Direction getDirection() { return this.direction; }
    public PlayerEntity getPlayer() { return this.player; }

}
