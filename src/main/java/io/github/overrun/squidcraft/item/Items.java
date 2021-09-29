package io.github.overrun.squidcraft.item;

import io.github.overrun.squidcraft.api.registry.AutoRegistry;
import io.github.overrun.squidcraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.FoodComponent.Builder;

import static io.github.overrun.squidcraft.SquidCraft.ID;
import static io.github.overrun.squidcraft.item.ItemGroups.MISC;

/**
 * @author squid233
 * @since 2020/12/19
 */
@SuppressWarnings("unused")
@AutoRegistry.ModID(ID)
public final class Items {
    public static final Item SHREDDED_SQUID = new Item(settings()
            .food(Food.of(2, 0.2f, true)));
    public static final Item COOKED_SHREDDED_SQUID = new Item(settings()
            .food(Food.of(5, 0.6f, true)));
    public static final Item SQUID_COOKIE = new Item(settings()
            .food(Food.of(20, 1.0f, true, Builder::alwaysEdible)));
    public static final Item IRON_PLATE = item();
    public static final Item SIZZLING_SQUID = new SizzlingSquidItem(settings()
            .food(Food.of(30, 2.0f, true, Builder::alwaysEdible)));

    public static final Item XMAS_HAT = new ArmorItem(ArmorMaterials.XMAS, EquipmentSlot.HEAD, misc());
    public static final Item MINER_HAT = new ArmorItem(ArmorMaterials.MINER, EquipmentSlot.HEAD, misc());

    public static final Item SQUID_HELMET = new ArmorItem(ArmorMaterials.SQUID, EquipmentSlot.HEAD, settings());
    public static final Item SQUID_CHESTPLATE = new ArmorItem(ArmorMaterials.SQUID, EquipmentSlot.CHEST, settings());
    public static final Item SQUID_LEGGINGS = new ArmorItem(ArmorMaterials.SQUID, EquipmentSlot.LEGS, settings());
    public static final Item SQUID_BOOTS = new ArmorItem(ArmorMaterials.SQUID, EquipmentSlot.FEET, settings());
    public static final Item SQUID_AXE = new ItemAxe(ToolMaterials.SQUID, 6.0f, -3.1f, settings());
    public static final Item SQUID_HOE = new ItemHoe(ToolMaterials.SQUID, -2, -1.0f, settings());
    public static final Item SQUID_PICKAXE = new ItemPickaxe(ToolMaterials.SQUID, 1, -2.8f, settings());
    public static final Item SQUID_SHOVEL = new ShovelItem(ToolMaterials.SQUID, 1.5f, -3.0f, settings());
    public static final Item SQUID_SWORD = new SwordItem(ToolMaterials.SQUID, 3, -2.4f, settings());

    // Block Items

    public static final Item SOUL_JACK_O_LANTERN = blockItem(Blocks.SOUL_JACK_O_LANTERN, misc());
    public static final Item SQUID_BLOCK = blockItem(Blocks.SQUID_BLOCK, settings()
            .food(Food.of(50, 1.4f, true)));
    public static final Item COMPRESSED_SQUID_BLOCK = blockItem(Blocks.COMPRESSED_SQUID_BLOCK, settings()
            .food(Food.of(70, 2.5f, true)));

    public static final Item VERTICAL_OAK_SLAB = vtcSlbItm(Blocks.VERTICAL_OAK_SLAB);
    public static final Item VERTICAL_SPRUCE_SLAB = vtcSlbItm(Blocks.VERTICAL_SPRUCE_SLAB);
    public static final Item VERTICAL_BIRCH_SLAB = vtcSlbItm(Blocks.VERTICAL_BIRCH_SLAB);
    public static final Item VERTICAL_JUNGLE_SLAB = vtcSlbItm(Blocks.VERTICAL_JUNGLE_SLAB);
    public static final Item VERTICAL_ACACIA_SLAB = vtcSlbItm(Blocks.VERTICAL_ACACIA_SLAB);
    public static final Item VERTICAL_DARK_OAK_SLAB = vtcSlbItm(Blocks.VERTICAL_DARK_OAK_SLAB);
    public static final Item VERTICAL_CRIMSON_SLAB = vtcSlbItm(Blocks.VERTICAL_CRIMSON_SLAB);
    public static final Item VERTICAL_WARPED_SLAB = vtcSlbItm(Blocks.VERTICAL_WARPED_SLAB);
    public static final Item VERTICAL_PETRIFIED_OAK_SLAB = vtcSlbItm(Blocks.VERTICAL_PETRIFIED_OAK_SLAB);
    public static final Item VERTICAL_STONE_SLAB = vtcSlbItm(Blocks.VERTICAL_STONE_SLAB);
    public static final Item VERTICAL_SMOOTH_STONE_SLAB = vtcSlbItm(Blocks.VERTICAL_SMOOTH_STONE_SLAB);
    public static final Item VERTICAL_COBBLESTONE_SLAB = vtcSlbItm(Blocks.VERTICAL_COBBLESTONE_SLAB);
    public static final Item VERTICAL_MOSSY_COBBLESTONE_SLAB = vtcSlbItm(Blocks.VERTICAL_MOSSY_COBBLESTONE_SLAB);
    public static final Item VERTICAL_STONE_BRICK_SLAB = vtcSlbItm(Blocks.VERTICAL_STONE_BRICK_SLAB);
    public static final Item VERTICAL_MOSSY_STONE_BRICK_SLAB = vtcSlbItm(Blocks.VERTICAL_MOSSY_STONE_BRICK_SLAB);
    public static final Item VERTICAL_ANDESITE_SLAB = vtcSlbItm(Blocks.VERTICAL_ANDESITE_SLAB);
    public static final Item VERTICAL_POLISHED_ANDESITE_SLAB = vtcSlbItm(Blocks.VERTICAL_POLISHED_ANDESITE_SLAB);
    public static final Item VERTICAL_DIORITE_SLAB = vtcSlbItm(Blocks.VERTICAL_DIORITE_SLAB);
    public static final Item VERTICAL_POLISHED_DIORITE_SLAB = vtcSlbItm(Blocks.VERTICAL_POLISHED_DIORITE_SLAB);
    public static final Item VERTICAL_GRANITE_SLAB = vtcSlbItm(Blocks.VERTICAL_GRANITE_SLAB);
    public static final Item VERTICAL_POLISHED_GRANITE_SLAB = vtcSlbItm(Blocks.VERTICAL_POLISHED_GRANITE_SLAB);
    public static final Item VERTICAL_SANDSTONE_SLAB = vtcSlbItm(Blocks.VERTICAL_SANDSTONE_SLAB);
    public static final Item VERTICAL_CUT_SANDSTONE_SLAB = vtcSlbItm(Blocks.VERTICAL_CUT_SANDSTONE_SLAB);
    public static final Item VERTICAL_SMOOTH_SANDSTONE_SLAB = vtcSlbItm(Blocks.VERTICAL_SMOOTH_SANDSTONE_SLAB);
    public static final Item VERTICAL_RED_SANDSTONE_SLAB = vtcSlbItm(Blocks.VERTICAL_RED_SANDSTONE_SLAB);
    public static final Item VERTICAL_CUT_RED_SANDSTONE_SLAB = vtcSlbItm(Blocks.VERTICAL_CUT_RED_SANDSTONE_SLAB);
    public static final Item VERTICAL_SMOOTH_RED_SANDSTONE_SLAB = vtcSlbItm(Blocks.VERTICAL_SMOOTH_RED_SANDSTONE_SLAB);
    public static final Item VERTICAL_BRICK_SLAB = vtcSlbItm(Blocks.VERTICAL_BRICK_SLAB);
    public static final Item VERTICAL_PRISMARINE_SLAB = vtcSlbItm(Blocks.VERTICAL_PRISMARINE_SLAB);
    public static final Item VERTICAL_PRISMARINE_BRICK_SLAB = vtcSlbItm(Blocks.VERTICAL_PRISMARINE_BRICK_SLAB);
    public static final Item VERTICAL_DARK_PRISMARINE_SLAB = vtcSlbItm(Blocks.VERTICAL_DARK_PRISMARINE_SLAB);
    public static final Item VERTICAL_NETHER_BRICK_SLAB = vtcSlbItm(Blocks.VERTICAL_NETHER_BRICK_SLAB);
    public static final Item VERTICAL_RED_NETHER_BRICK_SLAB = vtcSlbItm(Blocks.VERTICAL_RED_NETHER_BRICK_SLAB);
    public static final Item VERTICAL_QUARTZ_SLAB = vtcSlbItm(Blocks.VERTICAL_QUARTZ_SLAB);
    public static final Item VERTICAL_SMOOTH_QUARTZ_SLAB = vtcSlbItm(Blocks.VERTICAL_SMOOTH_QUARTZ_SLAB);
    public static final Item VERTICAL_PURPUR_SLAB = vtcSlbItm(Blocks.VERTICAL_PURPUR_SLAB);
    public static final Item VERTICAL_END_STONE_BRICK_SLAB = vtcSlbItm(Blocks.VERTICAL_END_STONE_BRICK_SLAB);
    public static final Item VERTICAL_BLACKSTONE_SLAB = vtcSlbItm(Blocks.VERTICAL_BLACKSTONE_SLAB);
    public static final Item VERTICAL_POLISHED_BLACKSTONE_SLAB = vtcSlbItm(Blocks.VERTICAL_POLISHED_BLACKSTONE_SLAB);
    public static final Item VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB = vtcSlbItm(Blocks.VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB);

    public static final Item COMPRESSOR_BLOCK = blockItem(Blocks.COMPRESSOR_BLOCK, settings());

    // Block Items End

    public static BlockItem blockItem(Block block, Item.Settings settings) {
        return new BlockItem(block, settings);
    }

    private static Item vtcSlbItm(Block block) {
        return blockItem(block, misc());
    }

    private static Item.Settings settings() {
        return new Item.Settings();
    }

    private static Item.Settings misc() {
        return settings().group(MISC);
    }

    private static Item item() {
        return new Item(settings());
    }
}
