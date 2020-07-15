package com.eonzenx.mcppmod.networking;

import com.eonzenx.mcppmod.objects.tileentities.SoupPotBlockTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketStartCookingSoup {
    private final BlockPos pos;

    public PacketStartCookingSoup(PacketBuffer buf){
        pos = buf.readBlockPos();
    }

    public PacketStartCookingSoup(BlockPos pos){
        this.pos = pos;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            TileEntity tileEntity = ctx.get().getSender().getServerWorld().getTileEntity(pos);
            if(tileEntity instanceof SoupPotBlockTileEntity){
                SoupPotBlockTileEntity soupPotBlockTileEntity = (SoupPotBlockTileEntity) tileEntity;
                soupPotBlockTileEntity.startCooking(ctx.get().getSender());
            }
        });
        return true;
    }
}
