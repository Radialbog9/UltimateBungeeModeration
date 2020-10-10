package uk.radialbog9.bungee.ultimatebungeemoderation;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import uk.radialbog9.bungee.ultimatebungeemoderation.api.UBMConfigProvider;
import uk.radialbog9.bungee.ultimatebungeemoderation.api.UBMLang;
import uk.radialbog9.bungee.ultimatebungeemoderation.api.UBMLangProvider;
import uk.radialbog9.bungee.ultimatebungeemoderation.utils.UBMUtils;

public class CmdUBM extends Command {
    public CmdUBM(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender.hasPermission(BungeeMain.getInstance().language.getString("permissions.general."))) {
            if(args.length == 0) {
                sender.sendMessage(new TextComponent(UBMUtils.strSan(
                        "&e&lUltimateBungeeModeration&r " +
                                "&aversion &r&c&l" + BungeeMain.getInstance().plVersion +
                                "&r &aby &r&6&lRadialbog9")));
            } else if (args[0].equals("reload")) {
                UBMConfigProvider.loadConfig();
                sender.sendMessage(new TextComponent(UBMLang.getLang(UBMLangProvider.CONFIGRELOADED)));
            }
        } else {
            sender.sendMessage(new TextComponent(UBMLang.getLang(UBMLangProvider.NOPERMISSION)));
        }
    }
}
