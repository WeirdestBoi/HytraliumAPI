package me.hytralium.hytraliumapi.menusystem;

import org.bukkit.entity.Player;

public class PlayerMenuUtility {
    private Player owner;
    private Player playerToKill;

    public PlayerMenuUtility(Player p) {
        this.owner = p;
    }

    public Player getOwner() {
        return owner;
    }

    public Player getPlayerToKill() {
        return playerToKill;
    }

    public void setPlayerToKill(Player playerToKill) {
        this.playerToKill = playerToKill;
    }
}
