package io.github.overrun.squidcraft.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import static io.github.overrun.squidcraft.SquidCraft.logger;

/**
 * @author squid233
 * @since 2020/12/27
 */
public final class Configs {
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .registerTypeAdapter(Configurator.class, new Configurator.Serializer())
            .create();
    private static Configurator configurator = new Configurator(new CobblestoneFarmRoll[0], new CompressorRecipe[0]);
    public static final boolean FAILED = false;
    public static final boolean SUCCESS = true;

    public static boolean init() {
        logger.info("Loading configs!");
        File cfg = new File("config/squidcraft");
        File cfgF = new File("config/squidcraft/config.json");
        if (!cfg.exists()) {
            if (cfg.mkdirs()) {
                try (Writer w = new FileWriter(cfgF)) {
                    w.write(GSON.toJson(configurator = new Configurator(
                            new CobblestoneFarmRoll[]{
                                    new CobblestoneFarmRoll("obsidian", 1),
                                    new CobblestoneFarmRoll("ancient_debris", 2),
                                    new CobblestoneFarmRoll("diamond_ore", 3),
                                    new CobblestoneFarmRoll("emerald_ore", 4),
                                    new CobblestoneFarmRoll("nether_quartz_ore", 5),
                                    new CobblestoneFarmRoll("nether_gold_ore", 6),
                                    new CobblestoneFarmRoll("gold_ore", 7),
                                    new CobblestoneFarmRoll("redstone_ore", 8),
                                    new CobblestoneFarmRoll("lapis_ore", 9),
                                    new CobblestoneFarmRoll("iron_ore", 10),
                                    new CobblestoneFarmRoll("coal_ore", 11),
                                    new CobblestoneFarmRoll("stone", 50),
                                    new CobblestoneFarmRoll("cobblestone", 100)
                            },
                            new CompressorRecipe[]{
                                    new CompressorRecipe(
                                            new CompressorRecipe.In("squidcraft:squid_block", 9),
                                            new CompressorRecipe.Out("squidcraft:compression_squid_block")
                                    )
                            }
                    )));
                } catch (IOException e) {
                    logger.error("Can't write configs to local!");
                    logger.catching(e);
                    return FAILED;
                }
            }
        } else {
            try (Reader r = new FileReader(cfgF)) {
                configurator = GSON.fromJson(r, Configurator.class);
            } catch (IOException e) {
                logger.error("Can't read configs!");
                logger.catching(e);
                return FAILED;
            }
        }
        logger.info("Loaded all configs");
        return SUCCESS;
    }

    public static void store() {
        try (Writer w = new FileWriter("config/squidcraft/config.json")) {
            w.write(GSON.toJson(configurator));
        } catch (IOException e) {
            logger.error("Can't write configs to local!");
            logger.catching(e);
        }
    }

    public static Configurator getConfigurator() {
        return configurator;
    }
}
