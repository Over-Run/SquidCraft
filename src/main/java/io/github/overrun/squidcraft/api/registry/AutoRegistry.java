package io.github.overrun.squidcraft.api.registry;

import io.github.overrun.squidcraft.SquidCraft;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.function.Function;

/**
 * @author squid233
 * @since 0.12.0
 */
public class AutoRegistry {
    private static <R> void register_(Class<?> clazz,
                                      Function<Object, R> casting,
                                      Registry<R> registry) {
        // must be public
        Field[] fields = clazz.getFields();
        String modId = null;
        ModID annId = clazz.getDeclaredAnnotation(ModID.class);
        if (annId != null) {
            modId = annId.value();
        }
        for (Field field : fields) {
            if (field.isAnnotationPresent(Ignore.class)) {
                continue;
            }
            Object o;
            try {
                o = field.get(null);
            } catch (IllegalAccessException e) {
                SquidCraft.logger.catching(e);
                continue;
            }
            R r = casting.apply(o);
            if (r == null) {
                continue;
            }
            String fid = modId;
            ModID annFId = field.getDeclaredAnnotation(ModID.class);
            if (annFId != null) {
                fid = annFId.value();
            }
            String nm = field.getName().toLowerCase();
            Name annNm = field.getDeclaredAnnotation(Name.class);
            if (annNm != null) {
                nm = annNm.value();
            }
            Registry.register(registry, fid + ":" + nm, r);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> void register(Class<?> clazz,
                                    Registry<T> registry) {
        register_(clazz, o -> {
            try {
                return (T) o;
            } catch (ClassCastException e) {
                return null;
            }
        }, registry);
    }

    public static void registerBlock(Class<?> clazz) {
        register_(clazz, o -> {
            if (o instanceof Block) {
                return (Block) o;
            }
            return null;
        }, Registry.BLOCK);
    }

    public static void registerItem(Class<?> clazz) {
        register_(clazz, o -> {
            if (o instanceof Item) {
                return (Item) o;
            }
            return null;
        }, Registry.ITEM);
    }

    public static void registerBET(Class<?> clazz) {
        register_(clazz, o -> {
            if (o instanceof BlockEntityType<?>) {
                return (BlockEntityType<?>) o;
            }
            return null;
        }, Registry.BLOCK_ENTITY_TYPE);
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE, ElementType.FIELD})
    public @interface ModID {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Ignore {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Name {
        String value();
    }
}
