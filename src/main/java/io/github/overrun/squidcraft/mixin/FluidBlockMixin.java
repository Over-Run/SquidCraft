package io.github.overrun.squidcraft.mixin;

import io.github.overrun.squidcraft.config.CobblestoneFarmRoll;
import io.github.overrun.squidcraft.config.Configs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.FluidDrainable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.lang3.RandomUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author squid233
 * @since 2021/02/02
 */
@Mixin(FluidBlock.class)
public abstract class FluidBlockMixin extends Block implements FluidDrainable {
    public FluidBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "receiveNeighborFluids",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/block/FluidBlock;playExtinguishSound(Lnet/minecraft/world/WorldAccess;Lnet/minecraft/util/math/BlockPos;)V",
                    ordinal = 0
            ))
    private void receiveNeighborFluids(World world, BlockPos pos, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        Block oreBlock = Blocks.COBBLESTONE;
        int random = RandomUtils.nextInt(1, 101);
        for (CobblestoneFarmRoll roll : Configs.getConfigurator().getRolls()) {
            if (random <= roll.getPercent()) {
                oreBlock = roll.getAsBlock();
                break;
            }
        }
        world.setBlockState(pos, (world.getFluidState(pos).isStill() ? Blocks.OBSIDIAN : oreBlock).getDefaultState());
    }
}
