package me.hytralium.hytraliumapi.events;

import me.hytralium.hytraliumapi.HytraliumGameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class QueueJoinEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    Player player;
    HytraliumGameMode gameMode;

    public Player getPlayer() {
        return player;
    }

    public HytraliumGameMode getGameMode() {
        return gameMode;
    }

    public QueueJoinEvent(Player player, HytraliumGameMode gameMode) {
        this.player = player;
        this.gameMode = gameMode;
    }
}
