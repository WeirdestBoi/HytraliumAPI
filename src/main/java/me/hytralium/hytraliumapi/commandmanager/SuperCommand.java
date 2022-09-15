package me.hytralium.hytraliumapi.commandmanager;

import me.hytralium.hytraliumapi.Colorize;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class SuperCommand {
    protected abstract String name();
    public abstract String displayName();
    public abstract String author();
    public abstract String version();
    public abstract ArrayList<SubCommand> subCommands();

    public void register(JavaPlugin plugin) {
        plugin.getCommand(this.name()).setExecutor(new CommandExecutor() {
            @Override
            public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                if (!(sender instanceof Player)) return false;
                Player p = (Player) sender;
                if (args.length < 1) {
                    sender.sendMessage(Colorize.color("&9&m---------------------------------------"));
                    sender.sendMessage(Colorize.color("&e" + displayName() + " &emade by " + author()));
                    sender.sendMessage(Colorize.color("&eUse &7&l/" + name() + " help &efor help"));
                    sender.sendMessage(Colorize.color("&9&m---------------------------------------"));
                } else if (args[0].equalsIgnoreCase("help")) {
                    sender.sendMessage(Colorize.color("&9&m---------------------------------------"));
                    sender.sendMessage(Colorize.color("&e" + displayName() + " commands help&7:"));
                    for (SubCommand sub : subCommands()) sender.sendMessage(Colorize.color("&7/" + name() + " " + sub.name()));
                    sender.sendMessage(Colorize.color("&9&m---------------------------------------"));
                } else {
                    SubCommand currentSub = null;
                    for (SubCommand subs : subCommands()) if (subs.name().equalsIgnoreCase(args[0])) {
                        currentSub = subs;
                        break;
                    }
                    if (currentSub != null) currentSub.execute(p, Arrays.asList(args));
                    else if (currentSub == null) sender.sendMessage(Colorize.color("Could not find the subcommand \"" + args[0] + "\", sorry"));
                }
                return true;
            }
        });
        plugin.getCommand(this.name()).setTabCompleter(new TabCompleter() {
            @Override
            public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
                List<String> commands = new ArrayList<>();
                if (args.length == 1) {
                    List<String> arguments = new ArrayList<>();
                    arguments.add("help");
                    for (SubCommand subs : subCommands()) arguments.add(subs.name());
                    for (String s: arguments) {
                        if (s.toLowerCase().startsWith(args[0].toLowerCase())) {
                            commands.add(s);
                        }
                    }
                    return commands;
                }
                return null;
            }
        });
    }
}