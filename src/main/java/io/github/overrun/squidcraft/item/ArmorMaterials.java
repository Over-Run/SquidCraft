package io.github.overrun.squidcraft.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.ItemTags;

/**
 * @author squid233
 * @since 2020/12/26
 */
public final class ArmorMaterials {
    public static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};

    public static final ArmorMaterial XMAS = ArmorMaterials.of("xmas")
            .durabilityMultiplier(1)
            .protectionAmounts(new int[]{1, 3, 2, 1})
            .enchantability(10)
            .equipSound(SoundEvents.ITEM_ARMOR_EQUIP_LEATHER)
            .repairIngredient(Ingredient.fromTag(ItemTags.WOOL))
            .toughness(0.0f)
            .knockbackResistance(0.0f)
            .build();
    public static final ArmorMaterial SQUID = ArmorMaterials.of("squid")
            .durabilityMultiplier(2)
            .protectionAmounts(new int[]{2, 4, 3, 2})
            .enchantability(15)
            .equipSound(SoundEvents.ITEM_ARMOR_EQUIP_LEATHER)
            .repairIngredient(Ingredient.ofItems(Items.SQUID_COOKIE))
            .build();

    private final String name;
    private int durability;
    private final int[] protectionAmounts = new int[4];
    private int enchantability;
    private SoundEvent equipSound;
    private Ingredient repairIngredient;
    private float toughness;
    private float knockbackResistance;

    public ArmorMaterials(String name) {
        this.name = name;
    }

    public static ArmorMaterials of(String name) {
        return new ArmorMaterials(name);
    }

    public ArmorMaterials durabilityMultiplier(int durability) {
        this.durability = durability;
        return this;
    }

    public ArmorMaterials protectionAmounts(int[] protectionAmounts) {
        if (protectionAmounts.length >= 4) {
            return headProtection(protectionAmounts[0])
                    .chestProtection(protectionAmounts[1])
                    .legsProtection(protectionAmounts[2])
                    .feetProtection(protectionAmounts[3]);
        }
        return this;
    }

    public ArmorMaterials headProtection(int protectionAmount) {
        protectionAmounts[3] = protectionAmount;
        return this;
    }

    public ArmorMaterials chestProtection(int protectionAmount) {
        protectionAmounts[2] = protectionAmount;
        return this;
    }

    public ArmorMaterials legsProtection(int protectionAmount) {
        protectionAmounts[1] = protectionAmount;
        return this;
    }

    public ArmorMaterials feetProtection(int protectionAmount) {
        protectionAmounts[0] = protectionAmount;
        return this;
    }

    public ArmorMaterials enchantability(int enchantability) {
        this.enchantability = enchantability;
        return this;
    }

    public ArmorMaterials equipSound(SoundEvent equipSound) {
        this.equipSound = equipSound;
        return this;
    }

    public ArmorMaterials repairIngredient(Ingredient repairIngredient) {
        this.repairIngredient = repairIngredient;
        return this;
    }

    public ArmorMaterials toughness(float toughness) {
        this.toughness = toughness;
        return this;
    }

    public ArmorMaterials knockbackResistance(float knockbackResistance) {
        this.knockbackResistance = knockbackResistance;
        return this;
    }

    public ArmorMaterial build() {
        return new ArmorMaterial() {
            @Override
            public int getDurability(EquipmentSlot slot) {
                return BASE_DURABILITY[slot.getEntitySlotId()] * durability;
            }

            @Override
            public int getProtectionAmount(EquipmentSlot slot) {
                return protectionAmounts[slot.getEntitySlotId()];
            }

            @Override
            public int getEnchantability() {
                return enchantability;
            }

            @Override
            public SoundEvent getEquipSound() {
                return equipSound == null ? SoundEvents.ITEM_ARMOR_EQUIP_GENERIC : equipSound;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return repairIngredient == null ? Ingredient.EMPTY : repairIngredient;
            }

            @Override
            public String getName() {
                if (name == null) {
                    throw new IllegalStateException("ArmorMaterial name is null!");
                }
                return name;
            }

            @Override
            public float getToughness() {
                return toughness;
            }

            @Override
            public float getKnockbackResistance() {
                return knockbackResistance;
            }
        };
    }
}
