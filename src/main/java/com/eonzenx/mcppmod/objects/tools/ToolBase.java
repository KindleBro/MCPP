package com.eonzenx.mcppmod.objects.tools;

import com.eonzenx.mcppmod.util.CustomItemGroups;
import net.minecraft.item.Item;

public class ToolBase extends Item
{
    public ToolBase(Properties props) {
        super(props.group(CustomItemGroups.CRAFTING_TAB));
    }
}
