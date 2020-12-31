package io.github.overrun.squidcraft.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

/**
 * @author squid233
 * @since 2020/12/27
 */
public final class ToolMaterials {
    public static final ToolMaterial SQUID = ToolMaterials.of()
            .durability(1561)
            .miningSpeed(8.0f)
            .attackDamage(3.0f)
            .miningLevel(3)
            .enchantability(10)
            .repairIngredient(Ingredient.ofItems(Items.SQUID_COOKIE))
            .build();

    private int durability;
    private float miningSpeed;
    private float attackDamage;
    private int miningLevel;
    private int enchantability;
    private Ingredient repairIngredient;

    public static ToolMaterials of() {
        return new ToolMaterials();
    }

    public ToolMaterials durability(int durability) {
        this.durability = durability;
        return this;
    }

    public ToolMaterials miningSpeed(float miningSpeed) {
        this.miningSpeed = miningSpeed;
        return this;
    }

    public ToolMaterials attackDamage(float attackDamage) {
        this.attackDamage = attackDamage;
        return this;
    }

    public ToolMaterials miningLevel(int miningLevel) {
        this.miningLevel = miningLevel;
        return this;
    }

    public ToolMaterials enchantability(int enchantability) {
        this.enchantability = enchantability;
        return this;
    }

    public ToolMaterials repairIngredient(Ingredient repairIngredient) {
        this.repairIngredient = repairIngredient;
        return this;
    }

    public ToolMaterial build() {
        return new ToolMaterial() {
            @Override
            public int getDurability() {
                return durability;
            }

            @Override
            public float getMiningSpeedMultiplier() {
                return miningSpeed;
            }

            @Override
            public float getAttackDamage() {
                return attackDamage;
            }

            @Override
            public int getMiningLevel() {
                return miningLevel;
            }

            @Override
            public int getEnchantability() {
                return enchantability;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return repairIngredient == null ? Ingredient.EMPTY : repairIngredient;
            }
        };
    }
}
