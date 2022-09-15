package me.hytralium.hytraliumapi.commandmanager;

import org.bukkit.entity.Player;

import java.util.List;

public interface SubCommand {
    String name();
    void execute(Player p, List<String> args);
}
