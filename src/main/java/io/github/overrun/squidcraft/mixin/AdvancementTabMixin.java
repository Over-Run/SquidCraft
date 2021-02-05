package io.github.overrun.squidcraft.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.advancement.AdvancementTab;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author squid233
 * @since 2021/02/02
 */
@Mixin(AdvancementTab.class)
public class AdvancementTabMixin extends DrawableHelper {
    @SuppressWarnings("deprecation")
    @Inject(method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/math/MathHelper;floor(D)I",
                    ordinal = 0))
    public void render(MatrixStack matrixStack, CallbackInfo ci) {
        RenderSystem.color4f(1, 1, 1, 1);
    }
}
