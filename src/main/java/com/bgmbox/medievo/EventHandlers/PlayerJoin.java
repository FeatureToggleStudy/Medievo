package com.bgmbox.medievo.EventHandlers;

import com.bgmbox.medievo.Medievo;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

import static com.bgmbox.medievo.Database.Entires.PlayerEntry.registerPlayerInDatabase;

public class PlayerJoin implements Listener {

    private final Medievo plugin;

    private PlayerJoin(Medievo instance) {
        plugin = instance;
    }

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID player_uuid = player.getUniqueId();
        String player_name = player.getName();
        int gold = 0;

        registerPlayerInDatabase(player_uuid, player_name, gold);
    }

    public static void registerPlayerJoinEvent() {
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(Medievo.instance), Medievo.instance);
    }
}