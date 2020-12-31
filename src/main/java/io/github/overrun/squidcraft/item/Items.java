package io.github.overrun.squidcraft.item;

import io.github.overrun.squidcraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
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
    public static final Item SQUID_AXE = register("squid_axe", new AxeItem(ToolMaterials.SQUID, 6.0f, -3.1f, getDefault()) {});
    public static final Item SQUID_HOE = register("squid_hoe", new HoeItem(ToolMaterials.SQUID, -2, -1.0f, getDefault()) {});
    public static final Item SQUID_PICKAXE = register("squid_pickaxe", new PickaxeItem(ToolMaterials.SQUID, 1, -2.8f, getDefault()) {});
    public static final Item SQUID_SHOVEL = register("squid_shovel", new ShovelItem(ToolMaterials.SQUID, 1.5f, -3.0f, getDefault()));
    public static final Item SQUID_SWORD = register("squid_sword", new SwordItem(ToolMaterials.SQUID, 3, -2.4f, getDefault()));

    // Block Items

    public static final Item SOUL_JACK_O_LANTERN = register(Blocks.SOUL_JACK_O_LANTERN, getMisc());
    public static final Item SQUID_BLOCK = createBlockMeat(50, 1.4f, Blocks.SQUID_BLOCK, getDefault());
    public static final Item COMPRESS_SQUID_BLOCK = createBlockMeat(70, 2.5f, Blocks.COMPRESS_SQUID_BLOCK, getDefault());

    public static final Item VERTICAL_OAK_SLAB = registerVtcSlbItm(Blocks.VERTICAL_OAK_SLAB);
    public static final Item VERTICAL_SPRUCE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_SPRUCE_SLAB);
    public static final Item VERTICAL_BIRCH_SLAB = registerVtcSlbItm(Blocks.VERTICAL_BIRCH_SLAB);
    public static final Item VERTICAL_JUNGLE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_JUNGLE_SLAB);
    public static final Item VERTICAL_ACACIA_SLAB = registerVtcSlbItm(Blocks.VERTICAL_ACACIA_SLAB);
    public static final Item VERTICAL_DARK_OAK_SLAB = registerVtcSlbItm(Blocks.VERTICAL_DARK_OAK_SLAB);
    public static final Item VERTICAL_CRIMSON_SLAB = registerVtcSlbItm(Blocks.VERTICAL_CRIMSON_SLAB);
    public static final Item VERTICAL_WARPED_SLAB = registerVtcSlbItm(Blocks.VERTICAL_WARPED_SLAB);
    public static final Item VERTICAL_PETRIFIED_OAK_SLAB = registerVtcSlbItm(Blocks.VERTICAL_PETRIFIED_OAK_SLAB);
    public static final Item VERTICAL_STONE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_STONE_SLAB);
    public static final Item VERTICAL_SMOOTH_STONE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_SMOOTH_STONE_SLAB);
    public static final Item VERTICAL_COBBLESTONE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_COBBLESTONE_SLAB);
    public static final Item VERTICAL_MOSSY_COBBLESTONE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_MOSSY_COBBLESTONE_SLAB);
    public static final Item VERTICAL_STONE_BRICK_SLAB = registerVtcSlbItm(Blocks.VERTICAL_STONE_BRICK_SLAB);
    public static final Item VERTICAL_MOSSY_STONE_BRICK_SLAB = registerVtcSlbItm(Blocks.VERTICAL_MOSSY_STONE_BRICK_SLAB);
    public static final Item VERTICAL_ANDESITE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_ANDESITE_SLAB);
    public static final Item VERTICAL_POLISHED_ANDESITE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_POLISHED_ANDESITE_SLAB);
    public static final Item VERTICAL_DIORITE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_DIORITE_SLAB);
    public static final Item VERTICAL_POLISHED_DIORITE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_POLISHED_DIORITE_SLAB);
    public static final Item VERTICAL_GRANITE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_GRANITE_SLAB);
    public static final Item VERTICAL_POLISHED_GRANITE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_POLISHED_GRANITE_SLAB);
    public static final Item VERTICAL_SANDSTONE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_SANDSTONE_SLAB);
    public static final Item VERTICAL_CUT_SANDSTONE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_CUT_SANDSTONE_SLAB);
    public static final Item VERTICAL_SMOOTH_SANDSTONE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_SMOOTH_SANDSTONE_SLAB);
    public static final Item VERTICAL_RED_SANDSTONE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_RED_SANDSTONE_SLAB);
    public static final Item VERTICAL_CUT_RED_SANDSTONE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_CUT_RED_SANDSTONE_SLAB);
    public static final Item VERTICAL_SMOOTH_RED_SANDSTONE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_SMOOTH_RED_SANDSTONE_SLAB);
    public static final Item VERTICAL_BRICK_SLAB = registerVtcSlbItm(Blocks.VERTICAL_BRICK_SLAB);
    public static final Item VERTICAL_PRISMARINE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_PRISMARINE_SLAB);
    public static final Item VERTICAL_PRISMARINE_BRICK_SLAB = registerVtcSlbItm(Blocks.VERTICAL_PRISMARINE_BRICK_SLAB);
    public static final Item VERTICAL_DARK_PRISMARINE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_DARK_PRISMARINE_SLAB);
    public static final Item VERTICAL_NETHER_BRICK_SLAB = registerVtcSlbItm(Blocks.VERTICAL_NETHER_BRICK_SLAB);
    public static final Item VERTICAL_RED_NETHER_BRICK_SLAB = registerVtcSlbItm(Blocks.VERTICAL_RED_NETHER_BRICK_SLAB);
    public static final Item VERTICAL_QUARTZ_SLAB = registerVtcSlbItm(Blocks.VERTICAL_QUARTZ_SLAB);
    public static final Item VERTICAL_SMOOTH_QUARTZ_SLAB = registerVtcSlbItm(Blocks.VERTICAL_SMOOTH_QUARTZ_SLAB);
    public static final Item VERTICAL_PURPUR_SLAB = registerVtcSlbItm(Blocks.VERTICAL_PURPUR_SLAB);
    public static final Item VERTICAL_END_STONE_BRICK_SLAB = registerVtcSlbItm(Blocks.VERTICAL_END_STONE_BRICK_SLAB);
    public static final Item VERTICAL_BLACKSTONE_SLAB = registerVtcSlbItm(Blocks.VERTICAL_BLACKSTONE_SLAB);
    public static final Item VERTICAL_POLISHED_BLACKSTONE = registerVtcSlbItm(Blocks.VERTICAL_POLISHED_BLACKSTONE);
    public static final Item VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB = registerVtcSlbItm(Blocks.VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB);

    public static final Item COMPRESSOR_BLOCK = register(Blocks.COMPRESSOR_BLOCK, getDefault());

    // Block Items End

    public static Item register(Block block, Item.Settings settings) {
        return register(Registry.BLOCK.getId(block).getPath(), new BlockItem(block, settings));
    }

    public static Item registerVtcSlbItm(Block block) {
        return register(block, getMisc());
    }

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

    public static Item createBlockMeat(int hunger, float sat, Block block, Item.Settings settings) {
        return register(Registry.BLOCK.getId(block).getPath(), new BlockItem(block, settings.food(new FoodComponent.Builder()
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
