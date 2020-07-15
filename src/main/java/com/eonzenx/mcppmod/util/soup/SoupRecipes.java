package com.eonzenx.mcppmod.util.soup;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.ArrayList;
import java.util.List;

public class SoupRecipes {
    public static final List<SoupRecipe> RECIPES = new ArrayList<>();

    public static void init(){
        RECIPES.add(
                new SoupRecipe(new ItemStack[]{
                    new ItemStack(Items.RED_MUSHROOM, 1),
                    new ItemStack(Items.BROWN_MUSHROOM, 1)
                }, new ItemStack(Items.MUSHROOM_STEW, 1))
        );
    }
}
