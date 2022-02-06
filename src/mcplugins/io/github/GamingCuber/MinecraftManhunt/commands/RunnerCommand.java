package mcplugins.io.github.GamingCuber.MinecraftManhunt.commands;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mcplugins.io.github.GamingCuber.MinecraftManhunt.Main;
import mcplugins.io.github.GamingCuber.MinecraftManhunt.TabCompletion.HunterAndRunnerCommandCompleter;

public class RunnerCommand implements CommandExecutor {

	private Main plugin;

	public RunnerCommand(Main plugin) {

		this.plugin = plugin;
		plugin.getCommand("runner").setExecutor(this);
		plugin.getCommand("runner").setTabCompleter(new HunterAndRunnerCommandCompleter(plugin));

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Server Serv = sender.getServer();
		String FirstArg = args[0];
		Player Runner = Serv.getPlayer(args[1]);

		if (FirstArg.equalsIgnoreCase("add")) {

			plugin.Runner = Runner;
			Serv.broadcastMessage(ChatColor.YELLOW + Runner.getName() + " has become the runner!");

		} else if (FirstArg.equalsIgnoreCase("remove")) {

			plugin.Runner = null;
			Serv.broadcastMessage(ChatColor.YELLOW + args[1] + " has been removed as the runner!");

		} else {

			sender.sendMessage(ChatColor.RED + "You have entered in the wrong parameters.");

		}

		return false;

	}

}
