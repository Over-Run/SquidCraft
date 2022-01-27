package io.github.overrun.squidcraft.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.Precipitation;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.SpawnSettings.SpawnEntry;

import static io.github.overrun.squidcraft.world.Biomes.getSkyColor;
import static net.minecraft.entity.EntityType.*;
import static net.minecraft.entity.SpawnGroup.WATER_AMBIENT;
import static net.minecraft.entity.SpawnGroup.WATER_CREATURE;
import static net.minecraft.world.gen.GenerationStep.Feature.VEGETAL_DECORATION;
import static net.minecraft.world.gen.feature.DefaultBiomeFeatures.*;
import static net.minecraft.world.gen.feature.OceanPlacedFeatures.*;

/**
 * @author squid233
 * @since 0.12.0
 */
public class SquidBiome {


    public static Biome create() {
        SpawnSettings.Builder spawn = new SpawnSettings.Builder()
                .spawn(WATER_CREATURE, new SpawnEntry(SQUID, 25, 4, 8))
                .spawn(WATER_AMBIENT, new SpawnEntry(COD, 8, 4, 6))
                .spawn(WATER_AMBIENT, new SpawnEntry(SALMON, 8, 4, 6))
                .spawn(WATER_AMBIENT, new SpawnEntry(TROPICAL_FISH, 10, 6, 8))
                .spawn(WATER_CREATURE, new SpawnEntry(DOLPHIN, 2, 1, 2));
        GenerationSettings.Builder gen = new GenerationSettings.Builder()
                .feature(VEGETAL_DECORATION, WARM_OCEAN_VEGETATION)
                .feature(VEGETAL_DECORATION, SEAGRASS_WARM)
                .feature(VEGETAL_DECORATION, SEA_PICKLE);
        addDefaultOres(gen);
        addEmeraldOre(gen);
        addLessKelp(gen);
        addFrozenTopLayer(gen);
        return new Biome.Builder()
                .precipitation(Precipitation.RAIN)
                .category(Category.OCEAN)
                .temperature(0.5f)
                .downfall(0.5f)
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x43d5ee)
                        .waterFogColor(0x41f33)
                        .fogColor(0xc0d8ff)
                        .skyColor(getSkyColor(0.5f))
                        .build()
                )
                .spawnSettings(spawn.build())
                .generationSettings(gen.build())
                .build();
    }
}
