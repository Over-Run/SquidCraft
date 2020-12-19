package io.github.overrun.squidcraft.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

/**
 * @author squid233
 * @since 2020/12/19
 */
public final class ItemGroups {
    public static final ItemGroup SQUIDCRAFT = new ItemGroup(5, "squidcraft") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.SHREDDED_SQUID);
        }
    };
}
