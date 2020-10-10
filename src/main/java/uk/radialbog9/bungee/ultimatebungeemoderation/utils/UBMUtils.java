package uk.radialbog9.bungee.ultimatebungeemoderation.utils;

import net.md_5.bungee.api.ChatColor;
import uk.radialbog9.bungee.ultimatebungeemoderation.BungeeMain;
import uk.radialbog9.bungee.ultimatebungeemoderation.CmdUBM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UBMUtils {
    public static String strSan(String inString) {
        String sanitizedString;
        sanitizedString = inString;
        sanitizedString = ChatColor.translateAlternateColorCodes('&', sanitizedString);
        return sanitizedString;
    }

    public static String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public static void registerCommands() {
        BungeeMain.getInstance().getProxy().getPluginManager().registerCommand(BungeeMain.getInstance(), new CmdUBM("ultimatebungeemoderation"));
        BungeeMain.getInstance().getProxy().getPluginManager().registerCommand(BungeeMain.getInstance(), new CmdUBM("ubm"));
        BungeeMain.getInstance().getProxy().getPluginManager().registerCommand(BungeeMain.getInstance(), new CmdUBM("bungeemoderation"));
    }
}
