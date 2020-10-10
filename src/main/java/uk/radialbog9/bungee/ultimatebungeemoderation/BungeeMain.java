package uk.radialbog9.bungee.ultimatebungeemoderation;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import uk.radialbog9.bungee.ultimatebungeemoderation.api.UBMConfigProvider;
import uk.radialbog9.bungee.ultimatebungeemoderation.utils.UBMUtils;

public class BungeeMain extends Plugin {

    private static BungeeMain instance;

    public Configuration config;
    public Configuration language;

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
        BungeeMain.instance = this;
        UBMConfigProvider.loadConfig();
        UBMUtils.registerCommands();
    }
}
