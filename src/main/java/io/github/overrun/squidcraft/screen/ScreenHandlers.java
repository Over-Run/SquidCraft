package io.github.overrun.squidcraft.screen;

import io.github.overrun.squidcraft.SquidCraft;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.Generic3x3ContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

/**
 * @author squid233
 * @since 2020/12/27
 */
public final class ScreenHandlers {
    public static final ScreenHandlerType<CompressorScreenHandler> COMPRESSOR_SCREEN_HANDLER =
            register("compressor_block", CompressorScreenHandler::new);
    public static final ScreenHandlerType<Generic3x3ContainerScreenHandler> BIN_SCREEN_HANDLER =
            register("bin_block", Generic3x3ContainerScreenHandler::new);

    private static <T extends ScreenHandler> ScreenHandlerType<T>
        register(String id,
                 ScreenHandlerRegistry.SimpleClientHandlerFactory<T> factory) {
        return ScreenHandlerRegistry.registerSimple(new Identifier(SquidCraft.MODID, id), factory);
    }
}
