package uk.radialbog9.bungee.ultimatebungeemoderation.api;

import uk.radialbog9.bungee.ultimatebungeemoderation.BungeeMain;
import uk.radialbog9.bungee.ultimatebungeemoderation.utils.UBMUtils;

public class UBMLang {
    /**
     * Gets the language
     *
     * @param langStr Language Key {@link UBMLangProvider}
     * @return Language
     */
    public static String getLang(UBMLangProvider langStr) {
        String endStr;
        if(langStr == UBMLangProvider.NOPERMISSION) endStr = BungeeMain.getInstance().language.getString("general.nopermission");
        else if(langStr == UBMLangProvider.CONFIGRELOADED) endStr = BungeeMain.getInstance().language.getString("general.configreloaded");
        else if(langStr == UBMLangProvider.STAFFCHATON) endStr = BungeeMain.getInstance().language.getString("staffchat.toggledon");
        else if(langStr == UBMLangProvider.STAFFCHATOFF) endStr = BungeeMain.getInstance().language.getString("staffchat.toggledoff");
        else if(langStr == UBMLangProvider.STAFFCHATPON) endStr = BungeeMain.getInstance().language.getString("staffchat.toggledpon");
        else if(langStr == UBMLangProvider.STAFFCHATPOFF) endStr = BungeeMain.getInstance().language.getString("staffchat.toggledpoff");
        else return null;
        endStr = UBMUtils.strSan(endStr);
        return endStr;
    }
}
