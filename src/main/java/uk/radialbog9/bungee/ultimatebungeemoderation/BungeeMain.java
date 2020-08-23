package uk.radialbog9.bungee.ultimatebungeemoderation;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import uk.radialbog9.bungee.ultimatebungeemoderation.utils.UBMUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;

public class BungeeMain extends Plugin {

    private static BungeeMain instance;

    public Configuration config;
    public Configuration language;

    public String plVersion;


    public static BungeeMain getInstance() {
        return BungeeMain.instance;
    }
    public static void setInstance(BungeeMain instance) {
        BungeeMain.instance = instance;
    }

    @Override
    public void onEnable() {
        try {
            plVersion = UBMUtils.getInstance().readFromInputStream(getResourceAsStream("version.txt"));
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "Error while finding plugin version!");
            e.printStackTrace();
        }
        loadConfig();
    }

    public void loadConfig() {
        if (!getDataFolder().exists()) getDataFolder().mkdir();

        File file = new File(getDataFolder(), "config.yml");
        File file2 = new File(getDataFolder(), "language.yml");

        if (!file.exists()) {
            try (InputStream in = getResourceAsStream("config.yml")) {
                Files.copy(in, file.toPath());
            } catch (IOException e) {
                getLogger().log(Level.SEVERE, "Failed to save default config!");
                e.printStackTrace();
            }
        }
        if (!file2.exists()) {
            try (InputStream in = getResourceAsStream("language.yml")) {
                Files.copy(in, file2.toPath());
            } catch (IOException e) {
                getLogger().log(Level.SEVERE, "Failed to save default language!");
                e.printStackTrace();
            }
        }

        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml"));
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "Failed to load config!");
            e.printStackTrace();
        }
        try {
            language = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "language.yml"));
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "Failed to load language file!");
            e.printStackTrace();
        }
    }
    public void saveConfig() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, new File(getDataFolder(), "config.yml"));
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "Failed to save config!");
            e.printStackTrace();
        }
    }
}
