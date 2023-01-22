package me.gamingcuber.minecraftmanhunt.commands;

import me.gamingcuber.minecraftmanhunt.Main;
import me.gamingcuber.minecraftmanhunt.tabcompleter.RunnerTabCompleter;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RunnerCommand implements CommandExecutor {

    private Main plugin;

    public RunnerCommand(Main plugin) {

        this.plugin = plugin;
        plugin.getCommand("runner").setExecutor(this);
        plugin.getCommand("runner").setTabCompleter(new RunnerTabCompleter(plugin));

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Server Serv = sender.getServer();
            String FirstArgument = args[0];

            if (FirstArgument.equalsIgnoreCase("set")) {

                String SecondArgument = args[1];

                Player Runner = Serv.getPlayer(SecondArgument);

                //checks whether the SecondArgument is a player
                if (Serv.getOnlinePlayers().contains(Runner)) {

                    plugin.Runner = Runner;
                    sender.sendMessage(ChatColor.GREEN + Runner.getName() + " is now the runner!");

                } else {

                    sender.sendMessage(ChatColor.RED + SecondArgument + " is not a player on the server, make sure to set a runner");

                }

            }

            //argument for when sender wants to clear the Runner
            if (FirstArgument.equalsIgnoreCase("clear")) {

                if (plugin.Runner == null) {

                    sender.sendMessage(ChatColor.RED + "There is no runner set yet!");

                } else {

                    plugin.Runner = null;
                    sender.sendMessage(ChatColor.AQUA + "The runner has been cleared, make sure to set a runner before you start!");

                }

            }

            if (FirstArgument.equalsIgnoreCase("list")) {

                if (plugin.Runner == null) {

                    sender.sendMessage(ChatColor.RED + "There is no runner set yet!");

                } else {

                    sender.sendMessage(ChatColor.AQUA + plugin.Runner.getName() + " is the runner currently");

                }

            }


        } else {

            sender.sendMessage(ChatColor.RED + "You have to be a player to send commands!");

        }


        return false;
    }
}
