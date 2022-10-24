package me.hytralium.hytraliumapi;

import com.connorlinfoot.bountifulapi.BountifulAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatUtil {
    public static void sendMSG(Player player, String s) {player.sendMessage(Colorize.color(s));}
    public static void sendMSG(CommandSender sender, String s) {sender.sendMessage(Colorize.color(s));}
    public static void sendTitle(Player player, String title, String subTitle) {
        BountifulAPI.sendTitle(player, 5, 30, 10, title, subTitle);
    }
    public static void sendTitle(Player player, String title, String subTitle, int fadeIn, int stay, int fadeOut) {
        BountifulAPI.sendTitle(player, fadeIn, stay, fadeOut, title, subTitle);
    }
    public static void clearTitle(Player player) {BountifulAPI.clearTitle(player);}
}
