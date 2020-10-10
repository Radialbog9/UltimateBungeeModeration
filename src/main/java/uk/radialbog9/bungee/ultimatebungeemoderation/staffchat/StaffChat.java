package uk.radialbog9.bungee.ultimatebungeemoderation.staffchat;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.List;

public class StaffChat {
    private static StaffChat instance;
    private static List<ProxiedPlayer> staffChatEnabledPlayers;

    public static StaffChat getInstance() {
        return StaffChat.instance;
    }
    public static void setInstance(StaffChat instance) {
        StaffChat.instance = instance;
    }
    public static List<ProxiedPlayer> getStaffChatEnabledPlayers() {
        //decided against this approach
        return null;
    }
    public static void setStaffChatEnabledPlayers(List<ProxiedPlayer> staffChatEnabledPlayers) {
        //decided against this approach
        //StaffChat.staffChatEnabledPlayers = staffChatEnabledPlayers;
    }
    public static void makePlayerSeeStaffChat(ProxiedPlayer p) {
        //decided against this approach
        //if(!staffChatEnabledPlayers.contains(p)) {
        //    staffChatEnabledPlayers.add(p);
        //}
    }
    public static void hideStaffChatFromPlayer(ProxiedPlayer p) {
        //decided against this approach
        //if(staffChatEnabledPlayers.contains(p)) {
        //    staffChatEnabledPlayers.remove(p);
        //}
    }
}
