package io.github.overrun.squidcraft.block;

import io.github.overrun.squidcraft.block.entity.CompressorBlockEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

import static io.github.overrun.squidcraft.SquidCraft.MODID;
import static net.minecraft.block.AbstractBlock.Settings.copy;
import static net.minecraft.block.AbstractBlock.Settings.of;
import static net.minecraft.block.Blocks.*;

/**
 * @author squid233
 * @since 2020/12/19
 */
public final class Blocks {
    public static final Material FOOD = new Material.Builder(MapColor.TERRACOTTA_WHITE).build();

    public static final Block SOUL_JACK_O_LANTERN = register(
            "soul_jack_o_lantern",
            new CarvedPumpkinBlock(copy(JACK_O_LANTERN)) {});

    public static final Block SQUID_BLOCK = register("squid_block", new Block(of(FOOD).sounds(BlockSoundGroup.SLIME)));
    public static final Block COMPRESSED_SQUID_BLOCK = register("compressed_squid_block", new Block(of(FOOD).strength(0.1f).sounds(BlockSoundGroup.SLIME)));

    // Vertical slab blocks

    public static final Block VERTICAL_OAK_SLAB = registerVsb("oak", OAK_SLAB);
    public static final Block VERTICAL_SPRUCE_SLAB = registerVsb("spruce", SPRUCE_SLAB);
    public static final Block VERTICAL_BIRCH_SLAB = registerVsb("birch", BIRCH_SLAB);
    public static final Block VERTICAL_JUNGLE_SLAB = registerVsb("jungle", JUNGLE_SLAB);
    public static final Block VERTICAL_ACACIA_SLAB = registerVsb("acacia", ACACIA_SLAB);
    public static final Block VERTICAL_DARK_OAK_SLAB = registerVsb("dark_oak", DARK_OAK_SLAB);
    public static final Block VERTICAL_CRIMSON_SLAB = registerVsb("crimson", CRIMSON_SLAB);
    public static final Block VERTICAL_WARPED_SLAB = registerVsb("warped", WARPED_SLAB);
    public static final Block VERTICAL_PETRIFIED_OAK_SLAB = registerVsb("petrified_oak", PETRIFIED_OAK_SLAB);
    public static final Block VERTICAL_STONE_SLAB = registerVsb("stone", STONE_SLAB);
    public static final Block VERTICAL_SMOOTH_STONE_SLAB = registerVsb("smooth_stone", SMOOTH_STONE_SLAB);
    public static final Block VERTICAL_COBBLESTONE_SLAB = registerVsb("cobblestone", COBBLESTONE_SLAB);
    public static final Block VERTICAL_MOSSY_COBBLESTONE_SLAB = registerVsb("mossy_cobblestone", MOSSY_COBBLESTONE_SLAB);
    public static final Block VERTICAL_STONE_BRICK_SLAB = registerVsb("stone_brick", STONE_BRICK_SLAB);
    public static final Block VERTICAL_MOSSY_STONE_BRICK_SLAB = registerVsb("mossy_stone_brick", MOSSY_STONE_BRICK_SLAB);
    public static final Block VERTICAL_ANDESITE_SLAB = registerVsb("andesite", ANDESITE_SLAB);
    public static final Block VERTICAL_POLISHED_ANDESITE_SLAB = registerVsb("polished_andesite", POLISHED_ANDESITE_SLAB);
    public static final Block VERTICAL_DIORITE_SLAB = registerVsb("diorite", DIORITE_SLAB);
    public static final Block VERTICAL_POLISHED_DIORITE_SLAB = registerVsb("polished_diorite", POLISHED_DIORITE_SLAB);
    public static final Block VERTICAL_GRANITE_SLAB = registerVsb("granite", GRANITE_SLAB);
    public static final Block VERTICAL_POLISHED_GRANITE_SLAB = registerVsb("polished_granite", POLISHED_GRANITE_SLAB);
    public static final Block VERTICAL_SANDSTONE_SLAB = registerVsb("sandstone", SANDSTONE_SLAB);
    public static final Block VERTICAL_CUT_SANDSTONE_SLAB = registerVsb("cut_sandstone", CUT_SANDSTONE_SLAB);
    public static final Block VERTICAL_SMOOTH_SANDSTONE_SLAB = registerVsb("smooth_sandstone", SMOOTH_SANDSTONE_SLAB);
    public static final Block VERTICAL_RED_SANDSTONE_SLAB = registerVsb("red_sandstone", RED_SANDSTONE_SLAB);
    public static final Block VERTICAL_CUT_RED_SANDSTONE_SLAB = registerVsb("cut_red_sandstone", CUT_RED_SANDSTONE_SLAB);
    public static final Block VERTICAL_SMOOTH_RED_SANDSTONE_SLAB = registerVsb("smooth_red_sandstone", SMOOTH_RED_SANDSTONE_SLAB);
    public static final Block VERTICAL_BRICK_SLAB = registerVsb("brick", BRICK_SLAB);
    public static final Block VERTICAL_PRISMARINE_SLAB = registerVsb("prismarine", PRISMARINE_SLAB);
    public static final Block VERTICAL_PRISMARINE_BRICK_SLAB = registerVsb("prismarine_brick", PRISMARINE_BRICK_SLAB);
    public static final Block VERTICAL_DARK_PRISMARINE_SLAB = registerVsb("dark_prismarine", DARK_PRISMARINE_SLAB);
    public static final Block VERTICAL_NETHER_BRICK_SLAB = registerVsb("nether_brick", NETHER_BRICK_SLAB);
    public static final Block VERTICAL_RED_NETHER_BRICK_SLAB = registerVsb("red_nether_brick", RED_NETHER_BRICK_SLAB);
    public static final Block VERTICAL_QUARTZ_SLAB = registerVsb("quartz", QUARTZ_SLAB);
    public static final Block VERTICAL_SMOOTH_QUARTZ_SLAB = registerVsb("smooth_quartz", SMOOTH_QUARTZ_SLAB);
    public static final Block VERTICAL_PURPUR_SLAB = registerVsb("purpur", PURPUR_SLAB);
    public static final Block VERTICAL_END_STONE_BRICK_SLAB = registerVsb("end_stone_brick", END_STONE_BRICK_SLAB);
    public static final Block VERTICAL_BLACKSTONE_SLAB = registerVsb("blackstone", BLACKSTONE_SLAB);
    public static final Block VERTICAL_POLISHED_BLACKSTONE = registerVsb("polished_blackstone", POLISHED_BLACKSTONE);
    public static final Block VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB = registerVsb("polished_blackstone_brick", POLISHED_BLACKSTONE_BRICK_SLAB);

    public static final Block COMPRESSOR_BLOCK = register("compressor_block", new CompressorBlock(copy(IRON_BLOCK)));
    public static final BlockEntityType<CompressorBlockEntity> COMPRESSOR_BLOCK_ENTITY =
            register("compressor_block", CompressorBlockEntity::new, COMPRESSOR_BLOCK);

    public static void load() {}

    private static Block registerVsb(String type, AbstractBlock block) {
        return register("vertical_" + type + "_slab", new VerticalSlabBlock(copy(block)));
    }

    private static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(MODID, id), block);
    }

    private static <T extends BlockEntity>
    BlockEntityType<T> register(String id,
                                Supplier<T> supplier,
                                Block block) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(MODID, id),
                BlockEntityType.Builder.create(supplier, block)
                        .build(null));
    }
}
