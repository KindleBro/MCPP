package com.eonzenx.mcppmod.util.soup;

import net.minecraft.item.ItemStack;

public class SoupRecipe {

    private ItemStack result;
    private ItemStack[] ingredients;

    public SoupRecipe(ItemStack[] ingredients, ItemStack result){
        this.ingredients = ingredients;
        this.result = result;
    }

    public ItemStack getResult() {
        return result;
    }

    public ItemStack[] getIngredients() {
        return ingredients;
    }
}
