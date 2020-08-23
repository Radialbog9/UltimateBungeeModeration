package uk.radialbog9.bungee.ultimatebungeemoderation.utils;

import net.md_5.bungee.api.ChatColor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UBMUtils {
    private static UBMUtils instance;
    public static UBMUtils getInstance() {
        return UBMUtils.instance;
    }
    public static void setInstance(UBMUtils instance) {
        UBMUtils.instance = instance;
    }

    public String strSan(String inString) {
        String sanitizedString;
        sanitizedString = inString;
        sanitizedString = ChatColor.translateAlternateColorCodes('&', sanitizedString);
        return sanitizedString;
    }

    public String readFromInputStream(InputStream inputStream)
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
}
