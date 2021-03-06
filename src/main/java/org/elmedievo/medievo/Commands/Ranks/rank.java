package org.elmedievo.medievo.Commands.Ranks;

import org.elmedievo.medievo.Commands.TabComplete.RanksTabComplete;
import org.elmedievo.medievo.Medievo;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.elmedievo.medievo.Ranks.Methods.checkRankExistence;
import org.elmedievo.medievo.Ranks.Methods.rankAdd;
import org.elmedievo.medievo.Ranks.Methods.rankRemove;

import static org.elmedievo.medievo.util.Fixes.CONSOLE_PREFIX;
import static org.elmedievo.medievo.util.Generic.*;
import static org.elmedievo.medievo.util.Methods.PlayerIsOnline.playerIsOnline;

public class rank implements CommandExecutor {

    private final Medievo plugin;

    private rank(Medievo instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("rank") && sender.hasPermission("medievo.rank")) {
            if (args.length == 3) {
                String givenPlayerName = args[1];
                String givenRank = args[2];
                if (playerIsOnline(givenPlayerName)) {
                    Player receiver = Bukkit.getServer().getPlayer(args[1]);
                    if (checkRankExistence.rankExists(givenRank)) {
                        String giver;
                        if (sender instanceof Player) {
                            Player player = (Player) sender;
                            giver = player.getDisplayName();
                        } else {
                            giver = CONSOLE_PREFIX;
                        }
                        switch (args[0]) {
                            case "add":
                                rankAdd.addRank(receiver, givenRank);
                                sender.sendMessage(ChatColor.GREEN + "Rank successfully added");
                                receiver.sendMessage(ChatColor.GREEN + "You have been granted the " + ChatColor.AQUA + givenRank + ChatColor.GREEN + " rank by: " + ChatColor.RESET + giver);
                                break;
                            case "remove":
                                rankRemove.removeRank(receiver, givenRank);
                                sender.sendMessage(ChatColor.RED + "Rank successfully removed");
                                receiver.sendMessage(ChatColor.RED + "You have been demoted from " + ChatColor.AQUA + givenRank + ChatColor.RED + " by: " + ChatColor.RESET + giver);
                                break;
                            default:
                                sender.sendMessage(GENERIC_SYNTAX_ERROR);
                        }
                    } else {
                        sender.sendMessage(WARNING_ICON + ChatColor.AQUA + givenRank + ChatColor.RED + " is not a rank.");
                    }
                } else {
                    sender.sendMessage(WARNING_ICON + ChatColor.DARK_AQUA + givenPlayerName + ChatColor.RED + " is currently Offline or is not a valid player.");
                }
            } else if (args.length <= 2) {
                sender.sendMessage(TOO_FEW_ARGS);
            } else {
                sender.sendMessage(TOO_MANY_ARGS);
            }
        } else {
            sender.sendMessage(NO_PERMISSION);
        }
        return true;
    }

    public static void registerRankCommand() {
        Medievo.instance.getCommand("rank").setExecutor(new rank(Medievo.instance));
        Medievo.instance.getCommand("rank").setTabCompleter(new RanksTabComplete(Medievo.instance));
    }
}
