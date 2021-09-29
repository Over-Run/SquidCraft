package io.github.overrun.squidcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import static net.minecraft.state.property.Properties.HORIZONTAL_FACING;
import static net.minecraft.state.property.Properties.WATERLOGGED;
import static net.minecraft.util.math.Direction.NORTH;

/**
 * @author squid233
 * @since 2020/12/20
 */
public class VerticalSlabBlock extends HorizontalFacingBlock implements Waterloggable {
    private static final VoxelShape NORTH_S = createCuboidShape(0.0f, 0.0f, 0.0f, 16.0f, 16.0f, 8.0f);
    private static final VoxelShape SOUTH_S = createCuboidShape(0.0f, 0.0f, 8.0f, 16.0f, 16.0f, 16.0f);
    private static final VoxelShape EAST_S = createCuboidShape(8.0f, 0.0f, 0.0f, 16.0f, 16.0f, 16.0f);
    private static final VoxelShape WEST_S = createCuboidShape(0.0f, 0.0f, 0.0f, 8.0f, 16.0f, 16.0f);

    public VerticalSlabBlock(Settings settings) {
        super(settings);
        setDefaultState(stateManager.getDefaultState()
                .with(HORIZONTAL_FACING, NORTH)
                .with(WATERLOGGED, false));
        
    }

    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        super.appendProperties(stateManager);
        stateManager.add(HORIZONTAL_FACING, WATERLOGGED);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext ctx) {
        switch (state.get(FACING)) {
            case NORTH:
                return NORTH_S;
            case SOUTH:
                return SOUTH_S;
            case EAST:
                return EAST_S;
            case WEST:
                return WEST_S;
            default:
                return VoxelShapes.fullCube();
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite()).with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (state.get(WATERLOGGED)) {
            world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }
}
