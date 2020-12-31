package io.github.overrun.squidcraft.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

/**
 * @author squid233
 * @since 2020/12/27
 */
public final class ScreenHandlers {
    public static final ScreenHandlerType<CompressorScreenHandler> COMPRESSOR_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("squidcraft", "compressor_block"), CompressorScreenHandler::new);
}
