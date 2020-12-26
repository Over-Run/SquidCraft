package io.github.overrun.squidcraft.item;

import io.github.overrun.squidcraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Consumer;

import static io.github.overrun.squidcraft.SquidCraft.MODID;
import static io.github.overrun.squidcraft.item.ItemGroups.MISC;
import static io.github.overrun.squidcraft.item.ItemGroups.SQUIDCRAFT;

/**
 * @author squid233
 * @since 2020/12/19
 */
@SuppressWarnings("unused")
public final class Items {
    public static final Item SHREDDED_SQUID = createMeat(2, 0.2f)
            .build("shredded_squid", s -> s.group(SQUIDCRAFT));
    public static final Item COOKED_SHREDDED_SQUID = createMeat(5, 0.6f)
            .build("cooked_shredded_squid", s -> s.group(SQUIDCRAFT));
    public static final Item SQUID_COOKIE = createBigMeat(20, 1.0f)
            .build("squid_cookie", s -> s.group(SQUIDCRAFT));

    public static final Item XMAS_HAT = register("xmas_hat", new ArmorItem(ArmorMaterials.XMAS, EquipmentSlot.HEAD, getMisc()));

    public static final Item SQUID_HELMET = register("squid_helmet", new ArmorItem(ArmorMaterials.SQUID, EquipmentSlot.HEAD, getDefault()));
    public static final Item SQUID_CHESTPLATE = register("squid_chestplate", new ArmorItem(ArmorMaterials.SQUID, EquipmentSlot.CHEST, getDefault()));
    public static final Item SQUID_LEGGINGS = register("squid_leggings", new ArmorItem(ArmorMaterials.SQUID, EquipmentSlot.LEGS, getDefault()));
    public static final Item SQUID_BOOTS = register("squid_boots", new ArmorItem(ArmorMaterials.SQUID, EquipmentSlot.FEET, getDefault()));

    // Block Items

    public static final Item SOUL_JACK_O_LANTERN = register("soul_jack_o_lantern", new BlockItem(Blocks.SOUL_JACK_O_LANTERN, getMisc()));
    public static final Item SQUID_BLOCK = createBlockMeat(50, 1.4f, "squid_block", Blocks.SQUID_BLOCK, getDefault());

    public static final Item VERTICAL_OAK_SLAB = register("vertical_oak_slab", new BlockItem(Blocks.VERTICAL_OAK_SLAB, getMisc()));
    public static final Item VERTICAL_SPRUCE_SLAB = register("vertical_spruce_slab", new BlockItem(Blocks.VERTICAL_SPRUCE_SLAB, getMisc()));
    public static final Item VERTICAL_BIRCH_SLAB = register("vertical_birch_slab", new BlockItem(Blocks.VERTICAL_BIRCH_SLAB, getMisc()));
    public static final Item VERTICAL_JUNGLE_SLAB = register("vertical_jungle_slab", new BlockItem(Blocks.VERTICAL_JUNGLE_SLAB, getMisc()));
    public static final Item VERTICAL_ACACIA_SLAB = register("vertical_acacia_slab", new BlockItem(Blocks.VERTICAL_ACACIA_SLAB, getMisc()));
    public static final Item VERTICAL_DARK_OAK_SLAB = register("vertical_dark_oak_slab", new BlockItem(Blocks.VERTICAL_DARK_OAK_SLAB, getMisc()));
    public static final Item VERTICAL_CRIMSON_SLAB = register("vertical_crimson_slab", new BlockItem(Blocks.VERTICAL_CRIMSON_SLAB, getMisc()));
    public static final Item VERTICAL_WARPED_SLAB = register("vertical_warped_slab", new BlockItem(Blocks.VERTICAL_WARPED_SLAB, getMisc()));
    public static final Item VERTICAL_PETRIFIED_OAK_SLAB = register("vertical_petrified_oak_slab", new BlockItem(Blocks.VERTICAL_PETRIFIED_OAK_SLAB, getMisc()));
    public static final Item VERTICAL_STONE_SLAB = register("vertical_stone_slab", new BlockItem(Blocks.VERTICAL_STONE_SLAB, getMisc()));
    public static final Item VERTICAL_SMOOTH_STONE_SLAB = register("vertical_smooth_stone_slab", new BlockItem(Blocks.VERTICAL_SMOOTH_STONE_SLAB, getMisc()));
    public static final Item VERTICAL_COBBLESTONE_SLAB = register("vertical_cobblestone_slab", new BlockItem(Blocks.VERTICAL_COBBLESTONE_SLAB, getMisc()));
    public static final Item VERTICAL_MOSSY_COBBLESTONE_SLAB = register("vertical_mossy_cobblestone_slab", new BlockItem(Blocks.VERTICAL_MOSSY_COBBLESTONE_SLAB, getMisc()));
    public static final Item VERTICAL_STONE_BRICK_SLAB = register("vertical_stone_brick_slab", new BlockItem(Blocks.VERTICAL_STONE_BRICK_SLAB, getMisc()));
    public static final Item VERTICAL_MOSSY_STONE_BRICK_SLAB = register("vertical_mossy_stone_brick_slab", new BlockItem(Blocks.VERTICAL_MOSSY_STONE_BRICK_SLAB, getMisc()));
    public static final Item VERTICAL_ANDESITE_SLAB = register("vertical_andesite_slab", new BlockItem(Blocks.VERTICAL_ANDESITE_SLAB, getMisc()));

    // Block Items End

    private static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MODID, id), item);
    }

    private static FoodItem createMeat(int hunger, float sat, boolean isBig) {
        Consumer<FoodComponent.Builder> consumer = b -> {
            b.hunger(hunger).saturationModifier(sat).meat();
            if (isBig) { b.alwaysEdible(); }
        };
        return FoodItem.of(consumer);
    }

    public static Item createBlockMeat(int hunger, float sat, String id, Block block, Item.Settings settings) {
        return register(id, new BlockItem(block, settings.food(new FoodComponent.Builder()
                .hunger(hunger).saturationModifier(sat)
                .meat().alwaysEdible().build())));
    }

    public static FoodItem createBigMeat(int hunger, float sat) {
        return createMeat(hunger, sat, true);
    }

    public static FoodItem createMeat(int hunger, float sat) {
        return createMeat(hunger, sat, false);
    }

    public static Item.Settings getDefault() {
        return new Item.Settings().group(SQUIDCRAFT);
    }

    public static Item.Settings getMisc() {
        return new Item.Settings().group(MISC);
    }
}
