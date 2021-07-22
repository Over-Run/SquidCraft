package io.github.overrun.squidcraft.item;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

/**
 * @author squid233
 * @since 0.12.0
 */
public class ItemAxe extends AxeItem {
    public ItemAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
