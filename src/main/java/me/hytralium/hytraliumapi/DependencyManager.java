package me.hytralium.hytraliumapi;

import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.team.UnlimitedNametagManager;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;

public class DependencyManager {
    public static String getPrefix(Player p) {

        User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(p);
        String prefix = user.getCachedData().getMetaData().getPrefix();
        if (prefix == null) prefix = "";
        return Colorize.color(prefix);
    }

    public static void setBelowName(Player p, String goal) {
        if (!HytraliumAPI.getInstance().getServer().getPluginManager().isPluginEnabled("TAB")) return;
        if (TabAPI.getInstance().getTeamManager() instanceof UnlimitedNametagManager) {
            UnlimitedNametagManager unm = (UnlimitedNametagManager) TabAPI.getInstance().getTeamManager();
            unm.setLine(TabAPI.getInstance().getPlayer(p.getUniqueId()), "belowname", goal);
        }
    }
    public static void resetBelowName(Player p) {
        if (!HytraliumAPI.getInstance().getServer().getPluginManager().isPluginEnabled("TAB")) return;
        if (TabAPI.getInstance().getTeamManager() instanceof UnlimitedNametagManager) {
            UnlimitedNametagManager unm = (UnlimitedNametagManager) TabAPI.getInstance().getTeamManager();
            unm.resetLine(TabAPI.getInstance().getPlayer(p.getUniqueId()), "belowname");
        }
    }
}
