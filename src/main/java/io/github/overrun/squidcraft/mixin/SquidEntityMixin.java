package io.github.overrun.squidcraft.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

/**
 * @author squid233
 * @since 0.12.0
 */
@Mixin(SquidEntity.class)
public class SquidEntityMixin extends WaterCreatureEntity {
    protected SquidEntityMixin(EntityType<? extends WaterCreatureEntity> entityType,
                               World world) {
        super(entityType, world);
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (stack.getItem() == Items.BUCKET) {
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
            ItemStack stack1 = ItemUsage.method_30012(stack, player, Items.MILK_BUCKET.getDefaultStack());
            player.setStackInHand(hand, stack1);
            return ActionResult.success(world.isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }
}
