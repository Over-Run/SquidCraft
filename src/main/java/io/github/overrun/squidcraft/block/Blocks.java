package io.github.overrun.squidcraft.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.overrun.squidcraft.SquidCraft.MODID;
import static net.minecraft.block.AbstractBlock.Settings.of;
import static net.minecraft.block.Material.*;
import static net.minecraft.block.Material.STONE;
import static net.minecraft.block.Material.WOOD;
import static net.minecraft.block.MaterialColor.*;

/**
 * Don't {@code implement} this class.
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

    // Vertical slab blocks

    Block VERTICAL_OAK_SLAB = registerWoodVerticalSlabBlock("oak", MaterialColor.WOOD);
    Block VERTICAL_SPRUCE_SLAB = registerWoodVerticalSlabBlock("spruce", SPRUCE);
    Block VERTICAL_BIRCH_SLAB = registerWoodVerticalSlabBlock("birch", SAND);
    Block VERTICAL_JUNGLE_SLAB = registerWoodVerticalSlabBlock("jungle", DIRT);
    Block VERTICAL_ACACIA_SLAB = registerWoodVerticalSlabBlock("acacia", ORANGE);
    Block VERTICAL_DARK_OAK_SLAB = registerWoodVerticalSlabBlock("dark_oak", BROWN);
    Block VERTICAL_CRIMSON_SLAB = registerVerticalSlabBlock(
            "crimson", of(NETHER_WOOD, field_25703).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD)
    );
    Block VERTICAL_WARPED_SLAB = registerVerticalSlabBlock(
            "warped", of(NETHER_WOOD, field_25706).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD)
    );
    Block VERTICAL_PETRIFIED_OAK_SLAB = registerVerticalSlabBlock(
            "petrified_oak", of(STONE, MaterialColor.WOOD).requiresTool().strength(2.0f, 6.0f)
    );
    Block VERTICAL_STONE_SLAB = registerStoneVerticalSlabBlock("stone");
    Block VERTICAL_SMOOTH_STONE_SLAB = registerStoneVerticalSlabBlock("smooth_stone");
    Block VERTICAL_COBBLESTONE_SLAB = registerStoneVerticalSlabBlock("cobblestone");
    Block VERTICAL_MOSSY_COBBLESTONE_SLAB = registerStoneVerticalSlabBlock("mossy_cobblestone");
    Block VERTICAL_STONE_BRICK_SLAB = registerStoneVerticalSlabBlock("stone_brick");
    Block VERTICAL_MOSSY_STONE_BRICK_SLAB = registerSoftStoneVerticalSlabBlock("mossy_stone_brick");
    Block VERTICAL_ANDESITE_SLAB = registerSoftStoneVerticalSlabBlock("andesite");

    static Block registerSoftStoneVerticalSlabBlock(String type) {
        return registerVerticalSlabBlock(type, of(STONE).requiresTool().strength(1.5f, 6.0f));
    }

    static Block registerStoneVerticalSlabBlock(String type) {
        return registerVerticalSlabBlock(type, of(STONE).requiresTool().strength(2.0f, 6.0f));
    }

    static Block registerWoodVerticalSlabBlock(String type, MaterialColor color) {
        return registerVerticalSlabBlock(type, of(WOOD, color).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
    }

    static Block registerVerticalSlabBlock(String type, AbstractBlock.Settings settings) {
        return register(String.format("vertical_%s_slab", type), new VerticalSlabBlock(settings));
    }

    static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(MODID, id), block);
    }
}
