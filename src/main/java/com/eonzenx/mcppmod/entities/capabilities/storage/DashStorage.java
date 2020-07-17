package com.eonzenx.mcppmod.entities.capabilities.storage;

import com.eonzenx.mcppmod.entities.capabilities.interfaces.IDash;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class DashStorage implements Capability.IStorage<IDash> {

    public static final String DASH_KEY = "dash_cooldown";

    @Nullable
    @Override
    public INBT writeNBT(Capability<IDash> capability, IDash instance, Direction side) {
        CompoundNBT temp = new CompoundNBT();
        temp.putInt(DASH_KEY, instance.getCooldown());
        return temp;
    }

    @Override
    public void readNBT(Capability<IDash> capability, IDash instance, Direction side, INBT nbt) {
        instance.setCooldown(((CompoundNBT) nbt).getInt(DASH_KEY));
    }
}
