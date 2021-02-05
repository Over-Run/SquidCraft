package io.github.overrun.squidcraft.compatible;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

/**
 * @author squid233
 * @since 2021/01/02
 */
public final class ModMenuCompatible implements ModMenuApi {
    @Override
    public ConfigScreenFactory<SquidCraftConfigScreen> getModConfigScreenFactory() {
        return SquidCraftConfigScreen::new;
    }
}
