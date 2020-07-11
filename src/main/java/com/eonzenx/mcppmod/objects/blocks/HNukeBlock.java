package com.eonzenx.mcppmod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

public class HNukeBlock extends FallingBlock implements IForgeBlock {

    public static float H_NUKE_POWER = 100.0F;

    public static final VoxelShape H_NUKE_BB = HNukeBlock.makeCuboidShape(1, 0, 1, 15, 9, 15);

    public static final Direction[] HORIZONTAL_DIRECTIONS = new Direction[] {Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
    public static final DirectionProperty FACING = DirectionProperty.create("facing", HORIZONTAL_DIRECTIONS);

    public HNukeBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)
        );

        this.setDefaultState(this.getStateContainer().getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    /**
     * Direction state depends on the direction of where the player is facing.
     * @param context
     * @return
     */
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return H_NUKE_BB;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), H_NUKE_POWER, Explosion.Mode.DESTROY);
        return ActionResultType.SUCCESS;
    }


    @Override
    public void onEndFalling(World worldIn, BlockPos pos, BlockState fallingState, BlockState hitState, FallingBlockEntity p_176502_5_) {
        worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), H_NUKE_POWER, Explosion.Mode.DESTROY);
    }
}
