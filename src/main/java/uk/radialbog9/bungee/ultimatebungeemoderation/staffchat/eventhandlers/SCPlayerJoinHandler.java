package uk.radialbog9.bungee.ultimatebungeemoderation.staffchat.eventhandlers;

import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import uk.radialbog9.bungee.ultimatebungeemoderation.BungeeMain;

public class SCPlayerJoinHandler implements Listener {
    public void playerJoinEvent(PostLoginEvent e) {
        if (e.getPlayer().hasPermission(BungeeMain.getInstance().config.getString("permissions.sc.onjoin")) && BungeeMain.getInstance().config.getBoolean("features.staffchat")) {

        }
    }
}
