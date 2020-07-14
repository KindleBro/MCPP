package com.eonzenx.mcppmod.objects.blocks;

import com.eonzenx.mcppmod.objects.containers.SoupPotBlockContainer;
import com.eonzenx.mcppmod.objects.tileentities.SoupPotBlockTileEntity;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class SoupPotBlock extends ContainerBlock implements IForgeBlock {

    public enum Status implements IStringSerializable {
        CLOSED, EMPTY, FULL;

        @Override
        public String getString() {
            return toString().toLowerCase();
        }
    }

    public static final VoxelShape SOUP_POT_BB = SoupPotBlock.makeCuboidShape(2, 0, 2, 14, 9, 14);

    public static final EnumProperty<Status> STATUS = EnumProperty.create("status", Status.class);

    public static final Direction[] HORIZONTAL_DIRECTIONS = new Direction[] {Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
    public static final DirectionProperty FACING = DirectionProperty.create("facing", HORIZONTAL_DIRECTIONS);

    public SoupPotBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)
        );

        this.setDefaultState(this.getStateContainer().getBaseState().with(STATUS, Status.EMPTY).with(FACING, Direction.NORTH));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STATUS);
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
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (!world.isRemote) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof SoupPotBlockTileEntity) {
                INamedContainerProvider containerProvider = new INamedContainerProvider() {
                    @Override
                    public ITextComponent getDisplayName() {
                        return new TranslationTextComponent("screen.mcppmod.soup_pot");
                    }

                    @Override
                    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                        return new SoupPotBlockContainer(i, world, pos, playerInventory, playerEntity);
                    }
                };
                NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getPos());
            } else {
                throw new IllegalStateException("Named container provider is missing! - Soup Pot");
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SOUP_POT_BB;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new SoupPotBlockTileEntity();
    }
}
