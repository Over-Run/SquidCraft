package io.github.overrun.squidcraft.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

import static io.github.overrun.squidcraft.SquidCraft.MODID;
import static io.github.overrun.squidcraft.SquidCraft.logger;

/**
 * @author squid233
 * @since 2020/12/19
 */
public final class FoodItem {
    private final Item.Settings settings = new Item.Settings();
    private FoodComponent component;

    public static FoodItem of(@NotNull Consumer<FoodComponent.Builder> consumer) {
        FoodComponent.Builder builder = new FoodComponent.Builder();
        consumer.accept(builder);
        FoodItem food = new FoodItem();
        food.component = builder.build();
        return food;
    }

    public FoodItem settings(@Nullable Consumer<Item.Settings> consumer) {
        if (consumer != null) { consumer.accept(settings); }
        return this;
    }

    public Item build(@NotNull Identifier id, @Nullable Consumer<Item.Settings> consumer) {
        if (logger.isDebugEnabled()) {
            logger.debug("Registered food item {}", id);
        }
        return Registry.register(Registry.ITEM, id, build(consumer));
    }

    public Item build(@NotNull String id, @Nullable Consumer<Item.Settings> consumer) {
        return build(new Identifier(MODID, id), consumer);
    }

    public Item build(@NotNull Identifier id) {
        return build(id, null);
    }

    public Item build(@NotNull String id) {
        return build(new Identifier(id));
    }

    public Item build(@Nullable Consumer<Item.Settings> consumer) {
        return settings(consumer).build();
    }

    public Item build() {
        settings.food(component);
        return new Item(settings);
    }
}
