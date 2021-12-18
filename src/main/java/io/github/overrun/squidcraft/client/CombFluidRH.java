package io.github.overrun.squidcraft.client;

import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.Pair;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

/**
 * @author squid233
 * @since 0.12.0
 */
@FunctionalInterface
public interface CombFluidRH extends FluidRenderHandler {
    Pair<Sprite[], Integer> pair(BlockRenderView view,
                                 BlockPos pos,
                                 FluidState state);

    @Override
    default Sprite[] getFluidSprites(@Nullable BlockRenderView view,
                                     @Nullable BlockPos pos,
                                     FluidState state) {
        return pair(view, pos, state).getLeft();
    }

    @Override
    default int getFluidColor(@Nullable BlockRenderView view,
                              @Nullable BlockPos pos,
                              FluidState state) {
        return pair(view, pos, state).getRight();
    }
}
