package io.github.overrun.squidcraft.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry.SimpleClientHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static io.github.overrun.squidcraft.SquidCraft.ID;

/**
 * @author squid233
 * @since 2020/12/27
 */
public final class ScreenHandlers {
    public static final ScreenHandlerType<CompressorScreenHandler> COMPRESSOR_SCREEN_HANDLER =
            register("compressor_block", CompressorScreenHandler::new);

    private static <T extends ScreenHandler> ScreenHandlerType<T>
        register(String id,
                 SimpleClientHandlerFactory<T> factory) {
        return ScreenHandlerRegistry.registerSimple(new Identifier(ID, id), factory);
    }
}
