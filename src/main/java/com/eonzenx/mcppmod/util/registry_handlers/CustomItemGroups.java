package com.eonzenx.mcppmod.util.registry_handlers;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CustomItemGroups
{
    public static final ItemGroup FARMING_TAB = new ItemGroup("mcppmod_farmingTab")
    {
        @Override
        public ItemStack createIcon() { return new ItemStack(FoodRegistryHandler.SNOW_BERRIES.get()); }
    };

    public static final ItemGroup CRAFTING_TAB = new ItemGroup("mcppmod_craftingTab")
    {
        @Override
        public ItemStack createIcon() { return new ItemStack(ItemRegistryHandler.ALCHEMISTS_GOLD_INGOT.get()); }
    };

    public static final ItemGroup WORLD_TAB = new ItemGroup("mcppmod_worldTab")
    {
        @Override
        public ItemStack createIcon() { return new ItemStack(FoodRegistryHandler.SNOW_BERRIES.get()); }
    };

    public static final ItemGroup COMBAT_TAB = new ItemGroup("mcppmod_combatTab")
    {
        @Override
        public ItemStack createIcon() { return new ItemStack(FoodRegistryHandler.SNOW_BERRIES.get()); }
    };
}
