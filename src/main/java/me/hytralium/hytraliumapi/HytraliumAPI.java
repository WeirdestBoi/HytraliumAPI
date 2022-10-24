package me.hytralium.hytraliumapi;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.sk89q.worldedit.*;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import com.sk89q.worldedit.world.DataException;
import lombok.Getter;
import me.hytralium.hytraliumapi.menusystem.MenuListener;
import me.hytralium.hytraliumapi.menusystem.PlayerMenuUtility;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class HytraliumAPI extends JavaPlugin {
    @Getter private static HytraliumAPI instance;

    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    public static PlayerMenuUtility getPlayerMenuUtility(Player p) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(p))) {

            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityMap.put(p, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(p);
        }
    }



    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        instance = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // LuckPerms
        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LuckPerms api = provider.getProvider();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Scoreboard convertToScoreBoard(ArrayList<String> list) {
        // Set ScoreBoard for the First Player
        ScoreboardManager manager1 = Bukkit.getScoreboardManager();
        Scoreboard scoreboard1 = manager1.getNewScoreboard();

        Objective objective1 = scoreboard1.registerNewObjective("Title", "dummy");
        objective1.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective1.setDisplayName(Colorize.color(list.get(0)));

        int a = 0;
        for (String s : list) {
            list.set(a, Colorize.color(s));
            a++;
        }

        int j = list.size();
        for (int i = 1; i < list.size(); i++) {
            j--;
            objective1.getScore(list.get(i)).setScore(j);
        }
        return scoreboard1;
    }
    public static void sendToServer(Player player, String goalServer) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(goalServer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        player.sendPluginMessage(getInstance(), "BungeeCord", b.toByteArray());
    }
    public static String getPrefix(Player player) {
        if (getInstance().getServer().getPluginManager().isPluginEnabled("LuckPerms")) return DependencyManager.getPrefix(player);
        return "";
    }
    public static void setBelowName(Player player, String text) {
        DependencyManager.setBelowName(player, text);
    }
    public static void resetBelowName(Player player) {
        DependencyManager.resetBelowName(player);
    }
    public static void showHealth(Player player) {
        setBelowName(player, Colorize.color("&f" + Math.round(player.getHealth()) + "&c❤"));
    }
    public static ItemStack getCustomTextureHead(String value) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), "");
        profile.getProperties().put("textures", new Property("textures", value));
        Field profileField;
        try {
            profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        head.setItemMeta(meta);
        return head;
    }
    void pasteSchematic(File schematicFile, Location location, int angle, boolean noAir) {
        if (!getServer().getPluginManager().isPluginEnabled("WorldEdit")) return;

        EditSession editSession = WorldEdit.getInstance().getEditSessionFactory().getEditSession(new BukkitWorld(location.getWorld()), 10000000);
        Vector vector = new Vector(location.getX(), location.getY(), location.getZ());

        try {
            CuboidClipboard clipboard = MCEditSchematicFormat.getFormat(schematicFile).load(schematicFile);
            clipboard.rotate2D(angle);
            clipboard.paste(editSession, vector, noAir);
        } catch (MaxChangedBlocksException | DataException | IOException exception) {
            exception.printStackTrace();
        }
    }
}
