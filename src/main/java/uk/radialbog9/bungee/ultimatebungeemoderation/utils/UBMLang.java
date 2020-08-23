package uk.radialbog9.bungee.ultimatebungeemoderation.utils;

import uk.radialbog9.bungee.ultimatebungeemoderation.BungeeMain;

public class UBMLang {
    private static UBMLang instance;
    private UBMLangProvider language;

    public static UBMLang getInstance() {
        return UBMLang.instance;
    }
    public static void setInstance(UBMLang instance) {
        UBMLang.instance = instance;
    }

    public String getLang(UBMLangProvider langStr) {
        String endStr;
        if(langStr == language.NOPERMISSION) endStr = BungeeMain.getInstance().language.getString("nopermission");
        else return null;
        endStr = UBMUtils.getInstance().strSan(endStr);
        return endStr;
    }
}
