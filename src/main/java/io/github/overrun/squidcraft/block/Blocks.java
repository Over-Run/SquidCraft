package io.github.overrun.squidcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

/**
 * @author squid233
 * @since 2020/12/19
 */
public final class Blocks {
    public static final Block SOUL_JACK_O_LANTERN = register(
            "soul_jack_o_lantern",
            new CarvedPumpkinBlock(Block.Settings.of(Material.GOURD, MaterialColor.ORANGE)
                    .strength(1.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .luminance(state -> 15)
                    .allowsSpawning((state, world, pos, type) -> true)
            ) {});

    public static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, id, block);
    }
}
