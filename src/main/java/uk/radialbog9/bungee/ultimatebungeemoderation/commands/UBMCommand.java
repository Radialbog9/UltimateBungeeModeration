package uk.radialbog9.bungee.ultimatebungeemoderation.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;
import uk.radialbog9.bungee.ultimatebungeemoderation.BungeeMain;
import uk.radialbog9.bungee.ultimatebungeemoderation.utils.UBMLang;
import uk.radialbog9.bungee.ultimatebungeemoderation.utils.UBMLangProvider;
import uk.radialbog9.bungee.ultimatebungeemoderation.utils.UBMUtils;

public class UBMCommand extends Command {
    public UBMCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender.hasPermission("ubm.maincmd")) {
            sender.sendMessage(new TextComponent(UBMUtils.getInstance().strSan(
                    "&e&lUltimateBungeeModeration&r " +
                            "&aversion &r&c&l" + BungeeMain.getInstance().plVersion +
                            "&r &aby &r&6&lRadialbog9")));
        } else {
            sender.sendMessage(new TextComponent(UBMLang.getInstance().getLang(UBMLangProvider.NOPERMISSION)));
        }
    }
}
