package me.hytralium.hytraliumapi;

import org.bukkit.ChatColor;

public class Colorize {
    public static String color(String toColor) {
        return ChatColor.translateAlternateColorCodes('&', toColor);
    }
    public static String strip(String toStripFrom) {
        return ChatColor.stripColor(toStripFrom);
    }
}
