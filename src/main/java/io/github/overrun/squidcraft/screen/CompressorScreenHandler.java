package io.github.overrun.squidcraft.screen;

import io.github.overrun.squidcraft.api.screen.GeneralScreenHandler;
import io.github.overrun.squidcraft.screen.slot.CompressorInputSlot;
import io.github.overrun.squidcraft.screen.slot.CompressorOutputSlot;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;

/**
 * @author squid233
 * @since 2021/01/23
 */
public class CompressorScreenHandler extends GeneralScreenHandler {
    public CompressorScreenHandler(int syncId, PlayerInventory pInv) {
        this(syncId, pInv, new SimpleInventory(2));
    }

    public CompressorScreenHandler(int syncId, PlayerInventory pInv, Inventory inv) {
        super(ScreenHandlers.COMPRESSOR_SCREEN_HANDLER, syncId, 2, inv);
        inv.onOpen(pInv.player);
        addSlot(new CompressorInputSlot(this, inv, 0, 48, 35));
        addSlot(new CompressorOutputSlot(this, inv, 1, 108, 35));
        addPlayerSlots(pInv);
    }
}
