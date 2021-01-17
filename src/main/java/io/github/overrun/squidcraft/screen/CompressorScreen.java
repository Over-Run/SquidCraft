package io.github.overrun.squidcraft.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static io.github.overrun.squidcraft.SquidCraft.MODID;

/**
 * @author squid233
 * @since 2020/12/27
 */
public class CompressorScreen extends HandledScreenImpl<ScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(MODID, "textures/gui/compressor.png");

    public CompressorScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title, TEXTURE);
    }
}
