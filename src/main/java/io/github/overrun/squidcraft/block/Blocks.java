package io.github.overrun.squidcraft.block;

import io.github.overrun.squidcraft.api.registry.BulkRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;

import static io.github.overrun.squidcraft.SquidCraft.ID;
import static io.github.overrun.squidcraft.fluid.Fluids.STILL_MILK;
import static net.minecraft.block.AbstractBlock.Settings.copy;
import static net.minecraft.block.AbstractBlock.Settings.of;
import static net.minecraft.block.Blocks.*;

/**
 * @author squid233
 * @since 2020/12/19
 */
@BulkRegistry.ModID(ID)
public final class Blocks {
    @BulkRegistry.Ignore
    public static final Material FOOD = new Material.Builder(MapColor.TERRACOTTA_WHITE).build();

    public static final Block SOUL_JACK_O_LANTERN =
            new JackOLanternBlock(copy(JACK_O_LANTERN));

    public static final Block SQUID_BLOCK = new Block(of(FOOD).sounds(BlockSoundGroup.SLIME));
    public static final Block COMPRESSED_SQUID_BLOCK = new Block(of(FOOD).strength(0.1f).sounds(BlockSoundGroup.SLIME));

    // Vertical slab blocks

    public static final Block VERTICAL_OAK_SLAB = vsb(OAK_SLAB);
    public static final Block VERTICAL_SPRUCE_SLAB = vsb(SPRUCE_SLAB);
    public static final Block VERTICAL_BIRCH_SLAB = vsb(BIRCH_SLAB);
    public static final Block VERTICAL_JUNGLE_SLAB = vsb(JUNGLE_SLAB);
    public static final Block VERTICAL_ACACIA_SLAB = vsb(ACACIA_SLAB);
    public static final Block VERTICAL_DARK_OAK_SLAB = vsb(DARK_OAK_SLAB);
    public static final Block VERTICAL_CRIMSON_SLAB = vsb(CRIMSON_SLAB);
    public static final Block VERTICAL_WARPED_SLAB = vsb(WARPED_SLAB);
    public static final Block VERTICAL_PETRIFIED_OAK_SLAB = vsb(PETRIFIED_OAK_SLAB);
    public static final Block VERTICAL_STONE_SLAB = vsb(STONE_SLAB);
    public static final Block VERTICAL_SMOOTH_STONE_SLAB = vsb(SMOOTH_STONE_SLAB);
    public static final Block VERTICAL_COBBLESTONE_SLAB = vsb(COBBLESTONE_SLAB);
    public static final Block VERTICAL_MOSSY_COBBLESTONE_SLAB = vsb(MOSSY_COBBLESTONE_SLAB);
    public static final Block VERTICAL_STONE_BRICK_SLAB = vsb(STONE_BRICK_SLAB);
    public static final Block VERTICAL_MOSSY_STONE_BRICK_SLAB = vsb(MOSSY_STONE_BRICK_SLAB);
    public static final Block VERTICAL_ANDESITE_SLAB = vsb(ANDESITE_SLAB);
    public static final Block VERTICAL_POLISHED_ANDESITE_SLAB = vsb(POLISHED_ANDESITE_SLAB);
    public static final Block VERTICAL_DIORITE_SLAB = vsb(DIORITE_SLAB);
    public static final Block VERTICAL_POLISHED_DIORITE_SLAB = vsb(POLISHED_DIORITE_SLAB);
    public static final Block VERTICAL_GRANITE_SLAB = vsb(GRANITE_SLAB);
    public static final Block VERTICAL_POLISHED_GRANITE_SLAB = vsb(POLISHED_GRANITE_SLAB);
    public static final Block VERTICAL_SANDSTONE_SLAB = vsb(SANDSTONE_SLAB);
    public static final Block VERTICAL_CUT_SANDSTONE_SLAB = vsb(CUT_SANDSTONE_SLAB);
    public static final Block VERTICAL_SMOOTH_SANDSTONE_SLAB = vsb(SMOOTH_SANDSTONE_SLAB);
    public static final Block VERTICAL_RED_SANDSTONE_SLAB = vsb(RED_SANDSTONE_SLAB);
    public static final Block VERTICAL_CUT_RED_SANDSTONE_SLAB = vsb(CUT_RED_SANDSTONE_SLAB);
    public static final Block VERTICAL_SMOOTH_RED_SANDSTONE_SLAB = vsb(SMOOTH_RED_SANDSTONE_SLAB);
    public static final Block VERTICAL_BRICK_SLAB = vsb(BRICK_SLAB);
    public static final Block VERTICAL_PRISMARINE_SLAB = vsb(PRISMARINE_SLAB);
    public static final Block VERTICAL_PRISMARINE_BRICK_SLAB = vsb(PRISMARINE_BRICK_SLAB);
    public static final Block VERTICAL_DARK_PRISMARINE_SLAB = vsb(DARK_PRISMARINE_SLAB);
    public static final Block VERTICAL_NETHER_BRICK_SLAB = vsb(NETHER_BRICK_SLAB);
    public static final Block VERTICAL_RED_NETHER_BRICK_SLAB = vsb(RED_NETHER_BRICK_SLAB);
    public static final Block VERTICAL_QUARTZ_SLAB = vsb(QUARTZ_SLAB);
    public static final Block VERTICAL_SMOOTH_QUARTZ_SLAB = vsb(SMOOTH_QUARTZ_SLAB);
    public static final Block VERTICAL_PURPUR_SLAB = vsb(PURPUR_SLAB);
    public static final Block VERTICAL_END_STONE_BRICK_SLAB = vsb(END_STONE_BRICK_SLAB);
    public static final Block VERTICAL_BLACKSTONE_SLAB = vsb(BLACKSTONE_SLAB);
    public static final Block VERTICAL_POLISHED_BLACKSTONE_SLAB = vsb(POLISHED_BLACKSTONE_SLAB);
    public static final Block VERTICAL_POLISHED_BLACKSTONE_BRICK_SLAB = vsb(POLISHED_BLACKSTONE_BRICK_SLAB);

    public static final Block COMPRESSOR_BLOCK = new CompressorBlock(copy(IRON_BLOCK));

    public static final Block MILK = new FluidBlock(STILL_MILK, FabricBlockSettings.copy(WATER)) {};

    private static Block vsb(AbstractBlock block) {
        return new VerticalSlabBlock(copy(block));
    }
}
