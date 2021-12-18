package io.github.overrun.squidcraft.client;

import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

/**
 * @author squid233
 * @since 0.12.0
 */
@FunctionalInterface
public interface FluidResourceRL extends SimpleSynchronousResourceReloadListener {
    Identifier gidOReload(ResourceManager manager);

    @Override
    default Identifier getFabricId() {
        return gidOReload(null);
    }

    @Override
    default void reload(ResourceManager manager) {
        gidOReload(manager);
    }
}
