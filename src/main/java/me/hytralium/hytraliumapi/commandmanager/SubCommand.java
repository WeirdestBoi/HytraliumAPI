package me.hytralium.hytraliumapi.commandmanager;

import org.bukkit.entity.Player;

import java.util.List;

public interface SubCommand {
    String name();
    String permission();
    String usage();
    boolean execute(Player p, List<String> args);
}
