package me.hytralium.hytraliumapi;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Debug {

    public static void info(String msg) {
        if (HytraliumAPI.getInstance().getConfig().getBoolean("debug-mode")) Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + msg);
    }
}
