package com.eonzenx.mcppmod.objects.items;

import com.eonzenx.mcppmod.util.CustomItemGroups;
import net.minecraft.item.Item;

public class ItemBase extends Item
{
    public ItemBase(Properties props) {
        super(props.group(CustomItemGroups.CRAFTING_TAB));
    }
}
