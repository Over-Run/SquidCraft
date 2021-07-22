package io.github.overrun.squidcraft.item;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

/**
 * @author squid233
 * @since 0.12.0
 */
public class ItemHoe extends HoeItem {
    public ItemHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
