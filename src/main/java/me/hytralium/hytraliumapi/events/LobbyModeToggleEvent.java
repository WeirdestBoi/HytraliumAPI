package me.hytralium.hytraliumapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LobbyModeToggleEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }


    public LobbyModeToggleEvent(Player newPlayer, boolean newStatus) {
        this.player = newPlayer;
        this.status = newStatus;
    }

    Player player;
    boolean status;

    public Player getPlayer() {
        return player;
    }
    public boolean isStatus() {
        return status;
    }

}
