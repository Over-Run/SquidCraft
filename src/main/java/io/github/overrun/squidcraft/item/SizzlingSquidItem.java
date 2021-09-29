package io.github.overrun.squidcraft.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static io.github.overrun.squidcraft.item.Items.IRON_PLATE;

/**
 * @author squid233
 * @since 0.12.0
 */
public class SizzlingSquidItem extends Item {
    public SizzlingSquidItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof PlayerEntity) {
            ((PlayerEntity) user).giveItemStack(new ItemStack(IRON_PLATE));
        }
        return stack;
    }
}
