package com.eonzenx.mcppmod.entities.capabilities.interfaces;

public interface IDash {

    boolean canDash();
    int getCooldown();
    void setCooldown(int cd);
    void reduceCooldown();
    void resetCooldown();

}
