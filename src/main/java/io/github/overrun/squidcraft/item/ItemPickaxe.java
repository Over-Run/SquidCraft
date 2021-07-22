package io.github.overrun.squidcraft.item;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

/**
 * @author squid233
 * @since 0.12.0
 */
public class ItemPickaxe extends PickaxeItem {
    public ItemPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
