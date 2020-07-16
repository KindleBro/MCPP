package com.eonzenx.mcppmod.objects.items;

import com.eonzenx.mcppmod.util.registry_handlers.CustomItemGroups;
import net.minecraft.item.Item;

public class CharredWood extends Item {
    public CharredWood() {
        super(new Item.Properties().group(CustomItemGroups.CRAFTING_TAB));
    }
}
