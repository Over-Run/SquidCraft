package io.github.overrun.squidcraft.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static io.github.overrun.squidcraft.SquidCraft.MODID;

/**
 * @author squid233
 * @since 2020/12/27
 */
public class CompressorScreen extends HandledScreen<ScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(MODID, "textures/gui/compressor.png");

    public CompressorScreen(ScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        client.getTextureManager().bindTexture(TEXTURE);
        drawTexture(matrices, width - backgroundWidth >> 1, height - backgroundHeight >> 1, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void init() {
        super.init();
        // Center the title
        titleX = backgroundWidth - textRenderer.getWidth(title) >> 1;
    }
}
