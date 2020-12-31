package io.github.overrun.squidcraft.screen;

import io.github.overrun.squidcraft.screen.slot.CompressorInputSlot;
import io.github.overrun.squidcraft.screen.slot.CompressorOutputSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

/**
 * @author squid233
 * @since 2020/12/27
 */
public class CompressorScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public CompressorScreenHandler(int syncId, PlayerInventory pInv) {
        this(syncId, pInv, new SimpleInventory(2));
    }

    public CompressorScreenHandler(int syncId, PlayerInventory pInv, Inventory inv) {
        super(ScreenHandlers.COMPRESSOR_SCREEN_HANDLER, syncId);
        checkSize(inv, 2);
        inventory = inv;
        inv.onOpen(pInv.player);
        addSlot(new CompressorInputSlot(this, inv, 0, 48, 35));
        addSlot(new CompressorOutputSlot(this, inv, 1, 108, 35));
        int m;
        int l;
        //The player inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                addSlot(new Slot(pInv, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        //The player Hotbar
        for (m = 0; m < 9; ++m) {
            addSlot(new Slot(pInv, m, 8 + m * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (index < inventory.size()) {
                if (!insertItem(originalStack, inventory.size(), slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!insertItem(originalStack, 0, inventory.size(), false)) {
                return ItemStack.EMPTY;
            }
            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }
}
