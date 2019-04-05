package com.bgmbox.medievo.Commands.Chat.Methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import static com.bgmbox.medievo.util.Fixes.ADMIN_CHAT_PREFIX;

public class SendAdminMessage {

    public static void sendMessageInAdminChat(Player sender, String msg) {
        for (Player playerInstance : Bukkit.getServer().getOnlinePlayers()) {
            String colored_msg = (ChatColor.translateAlternateColorCodes ('&', msg));
            if (playerInstance.hasPermission("medievo.chat.admin")) {
                if (sender.hasPermission("medievo.chat.color")) {
                    playerInstance.sendMessage(ADMIN_CHAT_PREFIX + sender.getDisplayName() + ChatColor.RESET + ": " + colored_msg);
                    return;
                }
                playerInstance.sendMessage(ADMIN_CHAT_PREFIX + sender.getDisplayName() + ChatColor.RESET + ": " + msg);
            }
        }
    }
}
