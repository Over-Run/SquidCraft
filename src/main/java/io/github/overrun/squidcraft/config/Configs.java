package io.github.overrun.squidcraft.config;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.github.overrun.squidcraft.SquidCraft.logger;

/**
 * @author squid233
 * @since 2020/12/27
 */
public final class Configs {
    public static final Properties CONFIG = new Properties(
            /* IMPORTANT: DON'T PUT IN NUMBER - WON'T COMPILE */
    );
    public static final Map<ItemStack, ItemStack> COMPRESSOR_RECIPES = new HashMap<>(16);
    public static final boolean FAILED = false;
    public static final boolean SUCCESS = true;

    public static boolean init() {
        logger.info("Loading configs!");
        File cfg = new File("config/squidcraft");
        File cfgF = new File("config/squidcraft/config.properties");
        if (!cfg.exists()) {
            if (cfg.mkdirs()) {
                try (Writer w = new FileWriter(cfgF)) {
                    CONFIG.put("compress+squidcraft:squid_block+9", "squidcraft:compression_squid_block+1");
                    CONFIG.store(w, null);
                } catch (IOException e) {
                    logger.error("Can't write configs to local!", e);
                    return FAILED;
                }
            }
        }
        try (Reader r = new FileReader(cfgF)) {
            CONFIG.load(r);
        } catch (IOException e) {
            logger.error("Can't read configs!", e);
            return FAILED;
        }
        logger.info("Loaded all configs");
        return SUCCESS;
    }

    public static void loadRecipes() {
        logger.info("Reading compressor recipes");
        for (Map.Entry<Object, Object> entry : CONFIG.entrySet()) {
            String k = entry.getKey().toString();
            if (k.startsWith("compress+")) {
                String[] i = k.split("\\+");
                Item itemI;
                try {
                    itemI = Registry.ITEM.get(new Identifier(i[1]));
                } catch (Throwable t) {
                    printRecipeError(t);
                    itemI = Items.AIR;
                }
                int amountI;
                try {
                    amountI = i.length > 2 ? Integer.parseInt(i[2]) : 1;
                } catch (Throwable t) {
                    printRecipeError(t);
                    amountI = 1;
                }
                String[] o = entry.getValue().toString().split("\\+");
                Item itemO;
                try {
                    itemO = Registry.ITEM.get(new Identifier(o[0]));
                } catch (Throwable t) {
                    printRecipeError(t);
                    itemO = Items.AIR;
                }
                int amountO;
                try {
                    amountO = o.length > 1 ? Integer.parseInt(o[1]) : 1;
                } catch (Throwable t) {
                    printRecipeError(t);
                    amountO = 1;
                }
                COMPRESSOR_RECIPES.put(new ItemStack(itemI, amountI), new ItemStack(itemO, amountO));
                logger.info("Added compressor recipe: \"{}={}\"", String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }
        }
    }

    public static void store() {
        try (Writer w = new FileWriter("config/squidcraft/config.properties")) {
            CONFIG.store(w, null);
        } catch (IOException e) {
            logger.error("Can't write configs to local!", e);
        }
    }

    private static void printRecipeError(Throwable t) {
        logger.error("Parsing error while loading compressor recipe; skipped");
        logger.catching(t);
    }
}
