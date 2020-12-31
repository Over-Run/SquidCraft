package io.github.overrun.squidcraft.config;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

import static io.github.overrun.squidcraft.SquidCraft.logger;

/**
 * @author squid233
 * @since 2020/12/27
 */
public final class Configs {
    public static final Properties CONFIG = new Properties();

    public static void init() {
        File cfg = new File("config/squidcraft");
        File cfgF = new File("config/squidcraft/config.properties");
        if (!cfg.exists()) {
            if (cfg.mkdirs()) {
                try (Writer w = new FileWriter(cfgF)) {
                    CONFIG.put("compress+squidcraft:squid_block+9", "squidcraft:compress_squid_block+1");
                    CONFIG.store(w, null);
                } catch (IOException e) {
                    logger.error("Can't write configs to local!", e);
                }
            }
        }
        try (Reader r = new FileReader(cfgF)) {
            CONFIG.load(r);
        } catch (IOException e) {
            logger.error("Can't read configs!", e);
        }
    }

    public static String get(String k, String def) {
        return CONFIG.getProperty(k, def);
    }
}
