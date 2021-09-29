package io.github.overrun.squidcraft.block.entity;

import io.github.overrun.squidcraft.api.registry.AutoRegistry;
import net.minecraft.block.entity.BlockEntityType;

import static io.github.overrun.squidcraft.SquidCraft.ID;
import static io.github.overrun.squidcraft.block.Blocks.COMPRESSOR_BLOCK;

/**
 * @author squid233
 * @since 0.12.0
 */
@AutoRegistry.ModID(ID)
public class BlockEntityTypes {
    @AutoRegistry.Name("compressor_block")
    public static final BlockEntityType<CompressorBlockEntity> COMPRESSOR_BLOCK_ENTITY =
            BlockEntityType.Builder
                    .create(CompressorBlockEntity::new, COMPRESSOR_BLOCK)
                    .build(null);
}
