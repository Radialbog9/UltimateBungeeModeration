package uk.radialbog9.bungee.ultimatebungeemoderation.api;

import uk.radialbog9.bungee.ultimatebungeemoderation.BungeeMain;
import uk.radialbog9.bungee.ultimatebungeemoderation.utils.UBMUtils;

public class UBMLang {
    private static UBMLang instance;

    public static UBMLang getInstance() {
        return UBMLang.instance;
    }
    public static void setInstance(UBMLang instance) {
        UBMLang.instance = instance;
    }

    /**
     * Gets the language
     * @param langStr Language Key {@link UBMLangProvider}
     * @return Language
     */
    public String getLang(UBMLangProvider langStr) {
        String endStr;
        if(langStr == UBMLangProvider.NOPERMISSION) endStr = BungeeMain.getInstance().language.getString("nopermission");
        else return null;
        endStr = UBMUtils.getInstance().strSan(endStr);
        return endStr;
    }
}
