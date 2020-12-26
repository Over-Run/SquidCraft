package io.github.overrun.squidcraft.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

/**
 * @author squid233
 * @since 2020/12/19
 */
public final class ItemGroups {
    public static final ItemGroup SQUIDCRAFT = FabricItemGroupBuilder.build(new Identifier("squidcraft:squidcraft"),
            () -> new ItemStack(Items.SQUID_COOKIE));
    public static final ItemGroup MISC = FabricItemGroupBuilder.build(new Identifier("squidcraft:misc"),
            () -> new ItemStack(Items.SOUL_JACK_O_LANTERN));
}
