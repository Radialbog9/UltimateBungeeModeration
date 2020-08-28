package uk.radialbog9.bungee.ultimatebungeemoderation.api;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import uk.radialbog9.bungee.ultimatebungeemoderation.BungeeMain;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;


/**
 * UBMConfigProvider - Where the config for the plugin is installed
 */
public class UBMConfigProvider {
    private static Configuration config = null;
    private static Configuration language = null;

    /**
     * Loads UBM config from file
     */
    public static void loadConfig() {
        if (!BungeeMain.getInstance().dataFolder.exists()) BungeeMain.getInstance().dataFolder.mkdir();

        File file = new File(BungeeMain.getInstance().dataFolder, "config.yml");
        File file2 = new File(BungeeMain.getInstance().dataFolder, "language.yml");

        if (!file.exists()) {
            try (InputStream in = BungeeMain.getInstance().getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                BungeeMain.getInstance().getLogger().log(Level.SEVERE, "Failed to save default config!");
                e.printStackTrace();
            }
        }
        if (!file2.exists()) {
            try (InputStream in = BungeeMain.getInstance().getResourceAsStream("language.yml")) {
                Files.copy(in, file2.toPath());
            } catch (IOException e) {
                BungeeMain.getInstance().getLogger().log(Level.SEVERE, "Failed to save default language!");
                e.printStackTrace();
            }
        }

        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(BungeeMain.getInstance().getDataFolder(), "config.yml"));
        } catch (IOException e) {
            BungeeMain.getInstance().getLogger().log(Level.SEVERE, "Failed to load config!");
            e.printStackTrace();
        }
        try {
            language = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(BungeeMain.getInstance().getDataFolder(), "language.yml"));
        } catch (IOException e) {
            BungeeMain.getInstance().getLogger().log(Level.SEVERE, "Failed to load language file!");
            e.printStackTrace();
        }
    }

    /**
     * Saves UBM config to file
     */
    public static void saveConfig() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, new File(BungeeMain.getInstance().getDataFolder(), "config.yml"));
        } catch (IOException e) {
            BungeeMain.getInstance().getLogger().log(Level.SEVERE, "Failed to save config!");
            e.printStackTrace();
        }
    }

    /**
     * Returns the current configuration.
     *
     * @return Configuration or null if config hasn't loaded
     */
    public static Configuration getConfig() {
        return UBMConfigProvider.config;
    }

    /**
     * Returns the current language
     * Use {@link UBMLang#getLang} instead
     *
     * @return Language configuration or null if language config hasn't loaded.
     */
    public static Configuration getLanguage() {
        return UBMConfigProvider.language;
    }
}
