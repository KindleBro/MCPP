package com.eonzenx.mcppmod.objects.tools.volatile_items;

import com.eonzenx.mcppmod.objects.tiers.MMItemMaterials;
import com.eonzenx.mcppmod.util.registry_handlers.CustomItemGroups;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class VolatilePickaxeItem extends PickaxeItem {
    public VolatilePickaxeItem() {
        super(MMItemMaterials.VOLATILE, 1, -2.8f, new Item.Properties().group(CustomItemGroups.CRAFTING_TAB));
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        entityLiving.getEntityWorld().createExplosion(entityLiving, entityLiving.getPosX(), entityLiving.getPosY(), entityLiving.getPosZ(), MMItemMaterials.VOLATILE_EXPLOSION_POWER, Explosion.Mode.BREAK);
        if (!worldIn.isRemote) {
            stack.damageItem(1, entityLiving, (player) -> {
                player.sendBreakAnimation(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.getEntityWorld().createExplosion(attacker, target.getPosX(), target.getPosY(), target.getPosZ(), MMItemMaterials.VOLATILE_EXPLOSION_POWER, Explosion.Mode.BREAK);
        return super.hitEntity(stack, target, attacker);
    }
}
