package io.github.overrun.squidcraft.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import static io.github.overrun.squidcraft.block.Blocks.MILK;
import static io.github.overrun.squidcraft.fluid.Fluids.FLOWING_MILK;
import static io.github.overrun.squidcraft.fluid.Fluids.STILL_MILK;
import static io.github.overrun.squidcraft.item.Items.MILK_BUCKET;

/**
 * @author squid233
 * @since 0.12.0
 */
public abstract class MilkFluid extends FlowableFluid {
    @Override
    public Fluid getFlowing() {
        return FLOWING_MILK;
    }

    @Override
    public Fluid getStill() {
        return STILL_MILK;
    }

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    protected boolean isInfinite() {
        return true;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world,
                                       BlockPos pos,
                                       BlockState state) {
        Block.dropStacks(state,
                world,
                pos,
                state.getBlock().hasBlockEntity()
                        ? world.getBlockEntity(pos)
                        : null);
    }

    @Override
    protected int getFlowSpeed(WorldView world) {
        return 3;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return 1;
    }

    @Override
    public Item getBucketItem() {
        return MILK_BUCKET;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state,
                                        BlockView world,
                                        BlockPos pos,
                                        Fluid fluid,
                                        Direction direction) {
        return false;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 5;
    }

    @Override
    protected float getBlastResistance() {
        return 100;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return MILK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    public static class Flowing extends MilkFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends MilkFluid {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}
