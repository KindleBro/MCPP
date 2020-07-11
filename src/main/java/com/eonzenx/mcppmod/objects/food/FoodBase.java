package com.eonzenx.mcppmod.objects.food;

import com.eonzenx.mcppmod.util.CustomItemGroups;
import net.minecraft.item.Item;

public class FoodBase extends Item
{
    public FoodBase(Properties props) {
        super(props.group(CustomItemGroups.FARMING_TAB));
    }
}
