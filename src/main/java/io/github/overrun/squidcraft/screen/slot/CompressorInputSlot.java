package io.github.overrun.squidcraft.screen.slot;

import io.github.overrun.squidcraft.config.Configs;
import io.github.overrun.squidcraft.screen.CompressorScreenHandler;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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
            for (Map.Entry<Object, Object> entry : Configs.CONFIG.entrySet()) {
                String k = entry.getKey().toString();
                if (k.startsWith("compress+")) {
                    String[] i = k.split("\\+");
                    Item itemI;
                    try {
                        itemI = Registry.ITEM.get(new Identifier(i[1]));
                    } catch (Throwable t) {
                        itemI = Items.AIR;
                    }
                    int amountI;
                    try {
                        amountI = i.length > 2 ? Integer.parseInt(i[2]) : 1;
                    } catch (Throwable t) {
                        amountI = 1;
                    }
                    if (getStack().getItem() == itemI && getStack().getCount() >= amountI) {
                        String[] o = entry.getValue().toString().split("\\+");
                        Item itemO = Registry.ITEM.get(new Identifier(o[0]));
                        int amountO;
                        try {
                            amountO = o.length > 1 ? Integer.parseInt(o[1]) : 1;
                        } catch (Throwable t) {
                            amountO = 1;
                        }
                        Slot slot = handler.getSlot(1);
                        ItemStack stack = slot.getStack();
                        if (!slot.hasStack()) {
                            getStack().decrement(amountI);
                            slot.setStack(new ItemStack(itemO, amountO));
                            markDirty();
                            break;
                        } else if (stack.getItem() == itemO && stack.getCount() + amountO <= stack.getMaxCount()) {
                            getStack().decrement(amountI);
                            stack.increment(amountO);
                            markDirty();
                            break;
                        }
                    }
                }
            }
        }
        super.markDirty();
    }
}
