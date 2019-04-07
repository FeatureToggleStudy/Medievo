package org.elmedievo.medievo.Commands.Clans.Methods;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.elmedievo.medievo.Database.Getters.ClanLeaderGetter;
import org.elmedievo.medievo.Database.Getters.PlayerClanGetter;

import java.util.Objects;

import static org.elmedievo.medievo.util.Generic.WARNING_ICON;
import static org.elmedievo.medievo.util.Methods.PlayerIsOnline.playerIsOnline;

public class Info {
    public static void getClanInfo(Player player) {
        //TODO: Add members to information display
        String players_clan = PlayerClanGetter.getPlayerClan(player.getUniqueId());
        if (!Objects.requireNonNull(players_clan).equals("none")) {
            String players_clan_leader = ClanLeaderGetter.getClanLeaderName(players_clan);
            if (!playerIsOnline(players_clan_leader)) {
                player.sendMessage(ChatColor.RED + "########## " + ChatColor.AQUA + ChatColor.BOLD + "CLAN INFO" + ChatColor.RESET + ChatColor.RED + " ##########" + "\n"
                        + ChatColor.GRAY + "Your clan: " + ChatColor.GREEN + players_clan + "\n"
                        + ChatColor.GRAY + "Your leader: " + ChatColor.DARK_AQUA + players_clan_leader + "\n"
                        + ChatColor.RED + "##############################"
                );
            } else {
                Player leader = Bukkit.getPlayer(players_clan_leader);
                player.sendMessage(ChatColor.RED + "######### " + ChatColor.AQUA + ChatColor.BOLD + "CLAN INFO" + ChatColor.RESET + ChatColor.RED + " ##########" + "\n"
                        + ChatColor.GRAY + "Your clan: " + ChatColor.GREEN + players_clan + "\n"
                        + ChatColor.GRAY + "Your leader: " + leader.getDisplayName() + "\n"
                        + ChatColor.RED + "##############################"
                );
            }
        } else {
            player.sendMessage(WARNING_ICON + ChatColor.RED + "You are not in a clan!");
        }
    }
}