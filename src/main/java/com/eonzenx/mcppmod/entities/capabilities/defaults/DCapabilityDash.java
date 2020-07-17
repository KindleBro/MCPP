package com.eonzenx.mcppmod.entities.capabilities.defaults;

import com.eonzenx.mcppmod.entities.capabilities.interfaces.IDash;

public class DCapabilityDash implements IDash {

    private int currentCooldown = 0;
    private boolean canDash = true;

    @Override
    public boolean canDash() {
        return canDash;
    }

    @Override
    public int getCooldown() {
        return currentCooldown;
    }

    @Override
    public void setCooldown(int cd) {
        currentCooldown = cd;
        canDash = false;
    }

    @Override
    public void reduceCooldown() {
        currentCooldown--;
        if (currentCooldown <= 0) {
            this.resetCooldown();
        }
    }

    @Override
    public void resetCooldown() {
        currentCooldown = 0;
        canDash = true;
    }
}
