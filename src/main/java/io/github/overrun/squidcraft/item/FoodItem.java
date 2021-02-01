package io.github.overrun.squidcraft.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

import static io.github.overrun.squidcraft.SquidCraft.MODID;

/**
 * @author squid233
 * @since 2020/12/19
 */
public final class FoodItem {
    @Nullable
    private FinishUsing finishUsing;
    private FoodComponent component;

    public static FoodItem of(@NotNull Consumer<FoodComponent.Builder> consumer) {
        FoodItem food = new FoodItem();
        FoodComponent.Builder builder = new FoodComponent.Builder();
        consumer.accept(builder);
        food.component = builder.build();
        return food;
    }

    public FoodItem onFinishUsing(FinishUsing finishUsing) {
        this.finishUsing = finishUsing;
        return this;
    }

    public Item build(String id, Item.Settings settings) {
        return Registry.register(Registry.ITEM,
                new Identifier(MODID, id),
                new Item(settings.food(component)) {
                    @Override
                    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
                        ItemStack stack1 = super.finishUsing(stack, world, user);
                        if (finishUsing != null) {
                            stack1 = finishUsing.finishUsing(stack, world, user);
                        }
                        return stack1;
                    }
                });
    }

    @FunctionalInterface
    public interface FinishUsing {
        ItemStack finishUsing(ItemStack stack, World world, LivingEntity user);
    }
}
