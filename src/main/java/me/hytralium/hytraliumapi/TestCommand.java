package me.hytralium.hytraliumapi;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ((Player) commandSender).sendMessage("debug");
        HytraliumAPI.sendToServer((Player) commandSender, "survival");
        return true;
    }
}