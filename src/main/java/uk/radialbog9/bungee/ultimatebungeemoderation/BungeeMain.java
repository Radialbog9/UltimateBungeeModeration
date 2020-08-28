package uk.radialbog9.bungee.ultimatebungeemoderation;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import uk.radialbog9.bungee.ultimatebungeemoderation.api.UBMConfigProvider;
import uk.radialbog9.bungee.ultimatebungeemoderation.utils.UBMCommandRegisterer;
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

    public File dataFolder = getDataFolder();

    public String plVersion = "${projVersion}";


    public static BungeeMain getInstance() {
        return BungeeMain.instance;
    }
    public static void setInstance(BungeeMain instance) {
        BungeeMain.instance = instance;
    }

    @Override
    public void onEnable() {
        /*
        try {
            plVersion = UBMUtils.getInstance().readFromInputStream(getResourceAsStream("version.txt"));
        } catch (IOException e) {
            getLogger().log(Level.SEVERE, "Error while finding plugin version!");
            e.printStackTrace();
        }
        */
        UBMConfigProvider.loadConfig();
        UBMCommandRegisterer.registerCommands();
    }
}
