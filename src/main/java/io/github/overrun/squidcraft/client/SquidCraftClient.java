package io.github.overrun.squidcraft.client;

import io.github.overrun.squidcraft.block.Blocks;
import io.github.overrun.squidcraft.screen.CompressorScreen;
import io.github.overrun.squidcraft.screen.ScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

/**
 * @author squid233
 * @since 2020/12/27
 */
public class SquidCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ScreenHandlers.COMPRESSOR_SCREEN_HANDLER, CompressorScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.COMPRESSOR_BLOCK, RenderLayer.getCutout());
    }
}
