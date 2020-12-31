package io.github.overrun.squidcraft.screen.slot;

import io.github.overrun.squidcraft.screen.CompressorScreenHandler;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

/**
 * @author squid233
 * @since 2020/12/27
 */
public class CompressorOutputSlot extends Slot {
    private final CompressorScreenHandler handler;

    public CompressorOutputSlot(CompressorScreenHandler handler, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.handler = handler;
    }

    @Override
    public void markDirty() {
        handler.getSlot(0).markDirty();
        super.markDirty();
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return false;
    }
}
