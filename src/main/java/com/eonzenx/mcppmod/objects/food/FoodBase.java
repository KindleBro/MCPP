package com.eonzenx.mcppmod.objects.food;

import com.eonzenx.mcppmod.util.CustomItemGroups;
import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;

public class FoodBase extends BlockNamedItem
{
    public FoodBase(Block blockIn, Properties props) {
        super(blockIn, props.group(CustomItemGroups.FARMING_TAB));
    }
}
