package io.github.overrun.squidcraft.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.overrun.squidcraft.SquidCraft.MODID;
import static net.minecraft.block.AbstractBlock.Settings.of;
import static net.minecraft.block.Blocks.*;

/**
 * Don't {@code implement} this class!
 * <p>全是{@code static}的你{@code implements}了也没用</p>
 *
 * @author squid233
 * @since 2020/12/19
 */
public interface Blocks {
    Material FOOD = new Material.Builder(MaterialColor.WHITE_TERRACOTTA).build();

    Block SOUL_JACK_O_LANTERN = register(
            "soul_jack_o_lantern",
            new CarvedPumpkinBlock(of(Material.GOURD, MaterialColor.ORANGE)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .luminance(state -> 15)
                    .allowsSpawning((state, world, pos, type) -> true)
            ) {});

    Block SQUID_BLOCK = register("squid_block", new Block(of(FOOD)));
    Block COMPRESS_SQUID_BLOCK = register("compress_squid_block", new Block(of(FOOD).strength(0.1f)));

    // Vertical slab blocks

    Block VERTICAL_OAK_SLAB = registerVerticalSlabBlock("oak", OAK_SLAB);
    Block VERTICAL_SPRUCE_SLAB = registerVerticalSlabBlock("spruce", SPRUCE_SLAB);
    Block VERTICAL_BIRCH_SLAB = registerVerticalSlabBlock("birch", BIRCH_SLAB);
    Block VERTICAL_JUNGLE_SLAB = registerVerticalSlabBlock("jungle", JUNGLE_SLAB);
    Block VERTICAL_ACACIA_SLAB = registerVerticalSlabBlock("acacia", ACACIA_SLAB);
    Block VERTICAL_DARK_OAK_SLAB = registerVerticalSlabBlock("dark_oak", DARK_OAK_SLAB);
    Block VERTICAL_CRIMSON_SLAB = registerVerticalSlabBlock("crimson", CRIMSON_SLAB);
    Block VERTICAL_WARPED_SLAB = registerVerticalSlabBlock("warped", WARPED_SLAB);
    Block VERTICAL_PETRIFIED_OAK_SLAB = registerVerticalSlabBlock("petrified_oak", PETRIFIED_OAK_SLAB);
    Block VERTICAL_STONE_SLAB = registerVerticalSlabBlock("stone", STONE_SLAB);
    Block VERTICAL_SMOOTH_STONE_SLAB = registerVerticalSlabBlock("smooth_stone", SMOOTH_STONE_SLAB);
    Block VERTICAL_COBBLESTONE_SLAB = registerVerticalSlabBlock("cobblestone", COBBLESTONE_SLAB);
    Block VERTICAL_MOSSY_COBBLESTONE_SLAB = registerVerticalSlabBlock("mossy_cobblestone", MOSSY_COBBLESTONE_SLAB);
    Block VERTICAL_STONE_BRICK_SLAB = registerVerticalSlabBlock("stone_brick", STONE_BRICK_SLAB);
    Block VERTICAL_MOSSY_STONE_BRICK_SLAB = registerVerticalSlabBlock("mossy_stone_brick", MOSSY_STONE_BRICK_SLAB);
    Block VERTICAL_ANDESITE_SLAB = registerVerticalSlabBlock("andesite", ANDESITE_SLAB);
    Block VERTICAL_POLISHED_ANDESITE_SLAB = registerVerticalSlabBlock("polished_andesite", POLISHED_ANDESITE_SLAB);
    Block VERTICAL_DIORITE_SLAB = registerVerticalSlabBlock("diorite", DIORITE_SLAB);
    Block VERTICAL_POLISHED_DIORITE_SLAB = registerVerticalSlabBlock("polished_diorite", POLISHED_DIORITE_SLAB);
    Block VERTICAL_GRANITE_SLAB = registerVerticalSlabBlock("granite", GRANITE_SLAB);
    Block VERTICAL_POLISHED_GRANITE_SLAB = registerVerticalSlabBlock("polished_granite", POLISHED_GRANITE_SLAB);
    Block VERTICAL_SANDSTONE_SLAB = registerVerticalSlabBlock("sandstone", SANDSTONE_SLAB);
    Block VERTICAL_CUT_SANDSTONE_SLAB = registerVerticalSlabBlock("cut_sandstone", CUT_SANDSTONE_SLAB);
    Block VERTICAL_SMOOTH_SANDSTONE_SLAB = registerVerticalSlabBlock("smooth_sandstone", SMOOTH_SANDSTONE_SLAB);
    Block VERTICAL_RED_SANDSTONE_SLAB = registerVerticalSlabBlock("red_sandstone", RED_SANDSTONE_SLAB);
    Block VERTICAL_CUT_RED_SANDSTONE_SLAB = registerVerticalSlabBlock("cut_red_sandstone", CUT_RED_SANDSTONE_SLAB);
    Block VERTICAL_SMOOTH_RED_SANDSTONE_SLAB = registerVerticalSlabBlock("smooth_red_sandstone", SMOOTH_RED_SANDSTONE_SLAB);
    Block VERTICAL_BRICK_SLAB = registerVerticalSlabBlock("brick", BRICK_SLAB);
    Block VERTICAL_PRISMARINE_SLAB = registerVerticalSlabBlock("prismarine", PRISMARINE_SLAB);
    Block VERTICAL_PRISMARINE_BRICK_SLAB = registerVerticalSlabBlock("prismarine_brick", PRISMARINE_BRICK_SLAB);
    Block VERTICAL_DARK_PRISMARINE_SLAB = registerVerticalSlabBlock("dark_prismarine", DARK_PRISMARINE_SLAB);
    Block VERTICAL_NETHER_BRICK_SLAB = registerVerticalSlabBlock("nether_brick", NETHER_BRICK_SLAB);
    Block VERTICAL_RED_NETHER_BRICK_SLAB = registerVerticalSlabBlock("red_nether_brick", RED_NETHER_BRICK_SLAB);
    Block VERTICAL_QUARTZ_SLAB = registerVerticalSlabBlock("quartz", QUARTZ_SLAB);
    Block VERTICAL_SMOOTH_QUARTZ_SLAB = registerVerticalSlabBlock("smooth_quartz", SMOOTH_QUARTZ_SLAB);
    Block VERTICAL_PURPUR_SLAB = registerVerticalSlabBlock("purpur", PURPUR_SLAB);
    Block VERTICAL_END_STONE_BRICK_SLAB = registerVerticalSlabBlock("end_stone_brick", END_STONE_BRICK_SLAB);
    Block VERTICAL_BLACKSTONE_SLAB = registerVerticalSlabBlock("blackstone", BLACKSTONE_SLAB);
    Block VERTICAL_POLISHED_BLACKSTONE = registerVerticalSlabBlock("polished_blackstone", POLISHED_BLACKSTONE);
    Block VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB = registerVerticalSlabBlock("polished_blackstone_brick", POLISHED_BLACKSTONE_BRICK_SLAB);

    Block COMPRESSOR_BLOCK = register("compressor_block", new CompressorBlock(AbstractBlock.Settings.copy(IRON_BLOCK)));
    BlockEntityType<CompressorBlockEntity> COMPRESSOR_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MODID, "compressor_block"), BlockEntityType.Builder.create(CompressorBlockEntity::new, COMPRESSOR_BLOCK).build(null));

    static Block registerVerticalSlabBlock(String type, AbstractBlock block) {
        return register(String.format("vertical_%s_slab", type), new VerticalSlabBlock(AbstractBlock.Settings.copy(block)));
    }

    static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(MODID, id), block);
    }
}
