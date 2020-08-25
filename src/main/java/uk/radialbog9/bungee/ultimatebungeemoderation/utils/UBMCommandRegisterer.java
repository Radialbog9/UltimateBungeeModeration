package uk.radialbog9.bungee.ultimatebungeemoderation.utils;

import uk.radialbog9.bungee.ultimatebungeemoderation.BungeeMain;
import uk.radialbog9.bungee.ultimatebungeemoderation.commands.CmdUBM;

public class UBMCommandRegisterer {
    public static void registerCommands() {
        BungeeMain.getInstance().getProxy().getPluginManager().registerCommand(BungeeMain.getInstance(), new CmdUBM("ultimatebungeemoderation"));
        BungeeMain.getInstance().getProxy().getPluginManager().registerCommand(BungeeMain.getInstance(), new CmdUBM("ubm"));
        BungeeMain.getInstance().getProxy().getPluginManager().registerCommand(BungeeMain.getInstance(), new CmdUBM("bungeemoderation"));
    }
}
