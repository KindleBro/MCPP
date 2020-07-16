package com.eonzenx.mcppmod.objects.items;

import com.eonzenx.mcppmod.util.registry_handlers.CustomItemGroups;
import net.minecraft.item.Item;

public class AlchemistsGoldIngot extends Item {
    public AlchemistsGoldIngot() {
        super(new Properties().group(CustomItemGroups.CRAFTING_TAB));
    }
}
