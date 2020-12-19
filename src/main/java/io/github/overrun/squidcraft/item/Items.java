package io.github.overrun.squidcraft.item;

import io.github.overrun.squidcraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import java.util.function.Consumer;

import static io.github.overrun.squidcraft.item.ItemGroups.SQUIDCRAFT;

/**
 * @author squid233
 * @since 2020/12/19
 */
@SuppressWarnings("unused")
public final class Items {
    public static final Item SHREDDED_SQUID = createMeat(2, 0.2f)
            .build("squidcraft:shredded_squid", s -> s.group(SQUIDCRAFT));
    public static final Item COOKED_SHREDDED_SQUID = createMeat(5, 0.6f)
            .build("squidcraft:cooked_shredded_squid", s -> s.group(SQUIDCRAFT));

    // Blocks

    public static final Item SOUL_JACK_O_LANTERN = register("soul_jack_o_lantern",
            new BlockItem(
                    Blocks.SOUL_JACK_O_LANTERN,
                    new Item.Settings().group(SQUIDCRAFT)
            )
    );

    public static BlockItem register(String id, BlockItem blockItem) {
        return Registry.register(Registry.ITEM, id, blockItem);
    }

    private static FoodItem createMeat(int hunger, float sat, boolean isBig) {
        Consumer<FoodComponent.Builder> consumer = b -> {
            b.hunger(hunger).saturationModifier(sat).meat();
            if (isBig) { b.alwaysEdible(); }
        };
        return FoodItem.of(consumer);
    }

    public static FoodItem createBigMeat(int hunger, float sat) {
        return createMeat(hunger, sat, true);
    }

    public static FoodItem createMeat(int hunger, float sat) {
        return createMeat(hunger, sat, false);
    }
}
