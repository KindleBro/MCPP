package com.eonzenx.mcppmod.entities.capabilities.providers;

import com.eonzenx.mcppmod.entities.capabilities.MMCapabilityHandler;
import com.eonzenx.mcppmod.entities.capabilities.interfaces.IDash;
import net.minecraft.nbt.INBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class DashProvider implements ICapabilitySerializable<INBT> {

    @CapabilityInject(IDash.class)
    public static final Capability<IDash> DASH_CAP = null;

    private IDash instance = DASH_CAP.getDefaultInstance();
    private LazyOptional<IDash> handler = LazyOptional.of(() -> instance);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap.equals(DASH_CAP)) {
            return handler.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public INBT serializeNBT() {
        return DASH_CAP.getStorage().writeNBT(DASH_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        DASH_CAP.getStorage().readNBT(DASH_CAP, this.instance, null, nbt);
    }
}
