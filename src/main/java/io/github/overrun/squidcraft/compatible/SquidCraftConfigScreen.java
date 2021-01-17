package io.github.overrun.squidcraft.compatible;

import io.github.overrun.squidcraft.config.Configs;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;

/**
 * @author squid233
 * @since 2021/01/02
 */
public final class SquidCraftConfigScreen extends Screen {
    private final Screen parent;

    protected SquidCraftConfigScreen(Screen parent) {
        super(new TranslatableText("options.title"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        addButton(new ButtonWidget((width >> 1) - 100,
                height / 6 + 132,
                200,
                20,
                new TranslatableText("text.squidcraft.reloadConfig"),
                b -> Configs.init()));
        addButton(new ButtonWidget((width >> 1) - 100,
                height / 6 + 168,
                200,
                20,
                ScreenTexts.DONE,
                b -> onClose()));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        drawCenteredText(matrices, textRenderer, title, width >> 1, 15, 0xffffff);
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public void onClose() {
        if (client != null) {
            client.openScreen(parent);
        }
    }
}
