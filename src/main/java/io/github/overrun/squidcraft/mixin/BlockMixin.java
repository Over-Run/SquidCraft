package io.github.overrun.squidcraft.mixin;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author squid233
 * @since 0.12.0
 */
@Mixin(AbstractBlock.class)
public abstract class BlockMixin {
    @Inject(method = "onUse", at = @At("RETURN"))
    public void onUse(BlockState state,
                      World world,
                      BlockPos pos,
                      PlayerEntity player,
                      Hand hand,
                      BlockHitResult hit,
                      CallbackInfoReturnable<ActionResult> cir) {
        Block block = state.getBlock();
        if (block == Blocks.OBSIDIAN) {
            if (player.getStackInHand(hand)
                    .isItemEqual(Items.BUCKET.getDefaultStack())) {
                world.setBlockState(pos,
                        Blocks.AIR.getDefaultState());
                Items.LAVA_BUCKET.use(world, player, hand);
            }
        }
    }
}
