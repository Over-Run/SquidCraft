package io.github.overrun.squidcraft.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;

/**
 * @author squid233
 * @since 2021/02/01
 */
@Mixin(Item.class)
public abstract class ItemMixin implements ItemConvertible {
    @Shadow
    public abstract boolean isFood();
    @Shadow
    public abstract FoodComponent getFoodComponent();

    @Inject(method = "appendTooltip", at = @At("RETURN"))
    public void appendTooltip(ItemStack stack,
                              @Nullable World world,
                              List<Text> tooltip,
                              TooltipContext context,
                              CallbackInfo ci) {
        boolean shiftDown = glfwGetKey(glfwGetCurrentContext(), GLFW_KEY_LEFT_SHIFT) == GLFW_PRESS
                || glfwGetKey(glfwGetCurrentContext(), GLFW_KEY_RIGHT_SHIFT) == GLFW_PRESS;
        if (isFood() && getFoodComponent() != null) {
            Style style = Style.EMPTY.withColor(Formatting.GRAY);
            if (shiftDown) {
                tooltip.add(new TranslatableText("text.squidcraft.hun",
                        getFoodComponent().getHunger())
                        .setStyle(style));
                tooltip.add(new TranslatableText("text.squidcraft.sat",
                        getFoodComponent().getSaturationModifier())
                        .setStyle(style));
            } else {
                tooltip.add(new TranslatableText("text.squidcraft.shift").setStyle(style));
            }
        }
    }
}
