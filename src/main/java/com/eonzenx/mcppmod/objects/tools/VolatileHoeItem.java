package com.eonzenx.mcppmod.objects.tools;


import com.eonzenx.mcppmod.objects.tiers.VolatileItemTier;
import com.eonzenx.mcppmod.util.CustomItemGroups;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class VolatileHoeItem extends HoeItem {
    public VolatileHoeItem() {
        super(new VolatileItemTier(), VolatileItemTier.HOE_ATTACK_DAMAGE, VolatileItemTier.HOE_ATTACK_SPEED, new Properties().group(CustomItemGroups.CRAFTING_TAB));
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        entityLiving.getEntityWorld().createExplosion(entityLiving, entityLiving.getPosX(), entityLiving.getPosY(), entityLiving.getPosZ(), VolatileItemTier.EXPLOSION_POWER, Explosion.Mode.BREAK);
        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.getEntityWorld().createExplosion(attacker, target.getPosX(), target.getPosY(), target.getPosZ(), VolatileItemTier.EXPLOSION_POWER, Explosion.Mode.BREAK);
        return super.hitEntity(stack, target, attacker);
    }
}
