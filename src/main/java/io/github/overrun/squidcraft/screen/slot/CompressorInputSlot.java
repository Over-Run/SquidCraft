package io.github.overrun.squidcraft.screen.slot;

import io.github.overrun.squidcraft.config.CompressorRecipe;
import io.github.overrun.squidcraft.config.Configs;
import io.github.overrun.squidcraft.screen.CompressorScreenHandler;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;

/**
 * @author squid233
 * @since 2020/12/27
 */
public class CompressorInputSlot extends Slot {
    private final CompressorScreenHandler handler;

    public CompressorInputSlot(CompressorScreenHandler handler, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.handler = handler;
    }

    @Override
    public void markDirty() {
        if (hasStack()) {
            for (CompressorRecipe recipe : Configs.getConfigurator().getRecipes()) {
                if (getStack().getItem() == recipe.getInput().getAsItem()
                        && getStack().getCount() >= recipe.getInput().getCount()
                        && recipe.getOutput().getAsItem() != Items.AIR) {
                    Slot slot = handler.getSlot(1);
                    ItemStack stack = slot.getStack();
                    if (!slot.hasStack()) {
                        getStack().decrement(recipe.getInput().getCount());
                        slot.setStack(new ItemStack(recipe.getOutput().getAsItem(), recipe.getOutput().getCount()));
                        markDirty();
                        break;
                    } else if (stack.getItem() == recipe.getOutput().getAsItem()
                            && stack.getCount() + recipe.getOutput().getCount() <= stack.getMaxCount()) {
                        getStack().decrement(recipe.getInput().getCount());
                        stack.increment(recipe.getOutput().getCount());
                        markDirty();
                        break;
                    }
                }
            }
        }
        super.markDirty();
    }
}
