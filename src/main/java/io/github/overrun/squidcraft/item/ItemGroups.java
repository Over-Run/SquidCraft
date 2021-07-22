package io.github.overrun.squidcraft.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.List;

import static io.github.overrun.squidcraft.SquidCraft.MODID;
import static io.github.overrun.squidcraft.item.Items.*;
import static net.minecraft.item.Items.SQUID_SPAWN_EGG;

/**
 * @author squid233
 * @since 2020/12/19
 */
public final class ItemGroups {
    @SuppressWarnings("unused")
    public static final ItemGroup SQUIDCRAFT = FabricItemGroupBuilder.create(new Identifier(MODID, "squidcraft"))
            .icon(() -> new ItemStack(SQUID_COOKIE))
            .appendItems(stacks -> addAll(stacks, SQUID_SPAWN_EGG,
                    SHREDDED_SQUID, COOKED_SHREDDED_SQUID, SQUID_COOKIE,
                    IRON_PLATE, SIZZLING_SQUID,
                    SQUID_HELMET, SQUID_CHESTPLATE, SQUID_LEGGINGS, SQUID_BOOTS,
                    SQUID_AXE, SQUID_HOE, SQUID_PICKAXE, SQUID_SHOVEL, SQUID_SWORD,
                    SQUID_BLOCK, COMPRESSOR_BLOCK, COMPRESSED_SQUID_BLOCK))
            .build();
    public static final ItemGroup MISC = FabricItemGroupBuilder.build(new Identifier(MODID, "misc"),
            () -> new ItemStack(SOUL_JACK_O_LANTERN));

    public static void addAll(List<ItemStack> stacks, Item... items) {
        for (Item item : items) {
            stacks.add(new ItemStack(item));
        }
    }
}
