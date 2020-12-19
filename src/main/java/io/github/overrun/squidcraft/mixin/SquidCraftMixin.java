package io.github.overrun.squidcraft.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;

/**
 * @author squid233
 * @since 2020/12/19
 */
@Mixin(TitleScreen.class)
public class SquidCraftMixin extends Screen {
	protected SquidCraftMixin(Text title) {
		super(title);
	}
}
