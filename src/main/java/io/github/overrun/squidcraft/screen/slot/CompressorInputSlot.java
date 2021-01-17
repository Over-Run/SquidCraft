package io.github.overrun.squidcraft.screen.slot;

import io.github.overrun.squidcraft.config.Configs;
import io.github.overrun.squidcraft.screen.CompressorScreenHandler;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

import java.util.Map;

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
            for (Map.Entry<ItemStack, ItemStack> entry
                    : Configs.COMPRESSOR_RECIPES.entrySet()) {
                Slot slot = handler.getSlot(1);
                ItemStack stack = slot.getStack();
                Item itemI = entry.getKey().getItem();
                int amountI = entry.getKey().getCount();
                if (getStack().getItem() == itemI
                        && getStack().getCount() >= amountI) {
                    Item itemO = entry.getValue().getItem();
                    int amountO = entry.getValue().getCount();
                    if (!slot.hasStack()) {
                        getStack().decrement(amountI);
                        slot.setStack(new ItemStack(itemO, amountO));
                        markDirty();
                        break;
                    } else if (stack.getItem() == itemO
                            && stack.getCount() + amountO <= stack.getMaxCount()) {
                        getStack().decrement(amountI);
                        stack.increment(amountO);
                        markDirty();
                        break;
                    }
                }
            }
        }
        super.markDirty();
    }
}
