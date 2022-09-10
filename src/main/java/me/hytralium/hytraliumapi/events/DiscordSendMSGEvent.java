package me.hytralium.hytraliumapi.events;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.awt.*;
import java.util.ArrayList;

public class DiscordSendMSGEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Getter ArrayList<String> message = new ArrayList<>();
    @Getter String iconURL;
    @Getter boolean contentInAuthorLine;
    @Getter Color color;

    public DiscordSendMSGEvent(ArrayList<String> message, String iconURL, boolean contentInAuthorLine, Color color) {
        this.message = message;
        this.iconURL = iconURL;
        this.contentInAuthorLine = contentInAuthorLine;
        this.color = color;
    }
    public DiscordSendMSGEvent(String msg, String iconURL, boolean contentInAuthorLine, Color color) {
        this.message.add(msg);
        this.iconURL = iconURL;
        this.contentInAuthorLine = contentInAuthorLine;
        this.color = color;
    }
}
