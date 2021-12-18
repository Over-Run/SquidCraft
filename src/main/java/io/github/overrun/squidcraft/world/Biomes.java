package io.github.overrun.squidcraft.world;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

import static io.github.overrun.squidcraft.SquidCraft.ID;
import static net.minecraft.util.math.MathHelper.clamp;
import static net.minecraft.util.math.MathHelper.hsvToRgb;

/**
 * @author squid233
 * @since 0.12.0
 */
public class Biomes {
    public static final RegistryKey<Biome> SQUID_BIOME_KEY =
            RegistryKey.of(Registry.BIOME_KEY, new Identifier(ID, "squid_biome"));
    private static final Biome SQUID_BIOME = SquidBiome.create();

    public static int getSkyColor(float temperature) {
        float f = temperature / 3.0f;
        f = clamp(f, -1, 1);
        return hsvToRgb(0.62222224F - f * 0.05f, 0.5f + f * 0.1f, 1);
    }

    public static void register() {
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(ID, "squid_block"), SquidBiome.SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, SQUID_BIOME_KEY.getValue(), SQUID_BIOME);
        OverworldBiomes.addContinentalBiome(SQUID_BIOME_KEY, OverworldClimate.TEMPERATE, 1D);
    }
}
