package io.github.overrun.squidcraft.item;

import net.minecraft.item.FoodComponent;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

/**
 * @author squid233
 * @since 0.12.0
 */
public class Food {
    public static FoodComponent.Builder builder() {
        return new FoodComponent.Builder();
    }

    public static FoodComponent of(int hun,
                                   float sat,
                                   boolean meat,
                                   @Nullable Function<
                                           FoodComponent.Builder,
                                           FoodComponent.Builder> function) {
        FoodComponent.Builder builder = builder()
                .hunger(hun)
                .saturationModifier(sat);
        if (meat) {
            builder.meat();
        }
        if (function != null) {
            builder = function.apply(builder);
        }
        return builder.build();
    }

    public static FoodComponent of(int hun,
                                   float sat,
                                   boolean meat) {
        return of(hun, sat, meat, null);
    }
}
