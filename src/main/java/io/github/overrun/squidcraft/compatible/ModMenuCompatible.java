package io.github.overrun.squidcraft.compatible;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;

/**
 * @author squid233
 * @since 2021/01/02
 */
public final class ModMenuCompatible implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return SquidCraftConfigScreen::new;
    }
}
