package io.github.overrun.squidcraft.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.overrun.squidcraft.config.CompressorRecipe.Entry;

import java.io.*;

import static io.github.overrun.squidcraft.SquidCraft.logger;
import static io.github.overrun.squidcraft.item.Items.COMPRESSED_SQUID_BLOCK;
import static io.github.overrun.squidcraft.item.Items.SQUID_BLOCK;
import static net.minecraft.block.Blocks.*;

/**
 * @author squid233
 * @since 2020/12/27
 */
public final class Configs {
    public static final File CFG_FILE = new File("config/squidcraft/config.json");
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .registerTypeAdapter(Configurator.class, new Configurator.Serializer())
            .create();
    private static Configurator configurator =
            new Configurator(new CobblestoneFarmRoll[0], new CompressorRecipe[0]);
    public static final boolean FAILED = false;
    public static final boolean SUCCESS = true;

    public static boolean init() {
        logger.info("Loading configs!");
        File parent = CFG_FILE.getParentFile();
        if (!parent.exists()) {
            parent.mkdirs();
            configurator = new Configurator(
                    new CobblestoneFarmRoll[]{
                            new CobblestoneFarmRoll(OBSIDIAN, 1),
                            new CobblestoneFarmRoll(ANCIENT_DEBRIS, 2),
                            new CobblestoneFarmRoll(DIAMOND_ORE, 3),
                            new CobblestoneFarmRoll(EMERALD_ORE, 4),
                            new CobblestoneFarmRoll(NETHER_QUARTZ_ORE, 5),
                            new CobblestoneFarmRoll(NETHER_GOLD_ORE, 6),
                            new CobblestoneFarmRoll(GOLD_ORE, 7),
                            new CobblestoneFarmRoll(REDSTONE_ORE, 8),
                            new CobblestoneFarmRoll(LAPIS_ORE, 9),
                            new CobblestoneFarmRoll(IRON_ORE, 10),
                            new CobblestoneFarmRoll(COAL_ORE, 11),
                            new CobblestoneFarmRoll(STONE, 50),
                            new CobblestoneFarmRoll(COBBLESTONE, 100)
                    },
                    new CompressorRecipe[]{
                            new CompressorRecipe(
                                    new Entry(SQUID_BLOCK, 9),
                                    new Entry(COMPRESSED_SQUID_BLOCK)
                            )
                    }
            );
            store();
        } else {
            try (Reader r = new FileReader(CFG_FILE)) {
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
        try (Writer w = new FileWriter(CFG_FILE)) {
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
