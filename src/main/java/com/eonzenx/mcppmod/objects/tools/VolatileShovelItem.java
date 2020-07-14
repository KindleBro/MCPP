package com.eonzenx.mcppmod.objects.tools;

import com.eonzenx.mcppmod.objects.tiers.VolatileItemTier;
import com.eonzenx.mcppmod.util.CustomItemGroups;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class VolatileShovelItem extends ShovelItem {
    public VolatileShovelItem() {
        super(new VolatileItemTier(), VolatileItemTier.SHOVEL_ATTACK_DAMAGE, VolatileItemTier.SHOVEL_ATTACK_SPEED, new Properties().group(CustomItemGroups.CRAFTING_TAB));
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        entityLiving.getEntityWorld().createExplosion(entityLiving, entityLiving.getPosX(), entityLiving.getPosY(), entityLiving.getPosZ(), VolatileItemTier.EXPLOSION_POWER, Explosion.Mode.BREAK);
        if (!worldIn.isRemote) {
            stack.damageItem(1, entityLiving, (player) -> {
                player.sendBreakAnimation(EquipmentSlotType.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.getEntityWorld().createExplosion(attacker, target.getPosX(), target.getPosY(), target.getPosZ(), VolatileItemTier.EXPLOSION_POWER, Explosion.Mode.BREAK);
        return super.hitEntity(stack, target, attacker);
    }
}
