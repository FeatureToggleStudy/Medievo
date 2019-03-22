package com.bgmbox.medievo.util;

import com.bgmbox.medievo.Medievo;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.Contract;

import java.io.File;

public class Generic {

    @Contract(pure = true)
    public static File getMedievoFolder() {
        return Medievo.instance.getDataFolder();
    }

    private static String chatErrorPrefix = ChatColor.YELLOW + "⚠ " + ChatColor.RED;
    private static String consoleErrorPrefix = ChatColor.RED + "";
    public static String
            NO_CONSOLE = chatErrorPrefix + "You must be a player to execute this command",
            TOO_MANY_ARGS = chatErrorPrefix + "Too many arguments",
            TOO_FEW_ARGS = chatErrorPrefix + "Too few arguments",
            NO_PERMISSION = chatErrorPrefix + "You do not have permission",
            SQL_CANNOT_CONNECT = consoleErrorPrefix + "An internal error has occurred while connecting to the SQL Database.",
            RANKS_CANNOT_CREATE = consoleErrorPrefix + "An internal error has occurred while generating the server ranks file",
            RANKS_DATA_CANNOT_CREATE = consoleErrorPrefix + "An internal error has occurred while generating the ranks data file",
            RANKS_DATA_CANNOT_SAVE = consoleErrorPrefix + "An internal error has occurred while saving the ranks data file";

    private static String successPrefix = ChatColor.GREEN + "";
    public static String
            LOADED_CONFIG = successPrefix + "Plugin configuration was successfully loaded",
            RANKS_FILE_FOUND = successPrefix + "Successfully loaded the ranks file.",
            RANKS_FILE_NOT_FOUND = successPrefix + "Ranks file not found. Creating one...",
            RANKS_DATA_FILE_FOUND = successPrefix + "Successfully loaded the ranks data file.",
            RANKS_DATA_FILE_NOT_FOUND = successPrefix + "Ranks data file not found. Creating one...",
            SQL_CONNECT_SUCCESS = successPrefix + "Connected to SQL database successfully";

}