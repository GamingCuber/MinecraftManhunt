package mcplugins.io.github.GamingCuber.MinecraftManhunt.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mcplugins.io.github.GamingCuber.MinecraftManhunt.Main;
import mcplugins.io.github.GamingCuber.MinecraftManhunt.TabCompletion.HunterAndRunnerCommandCompleter;

public class HunterCommand implements CommandExecutor {

	private Main plugin;
	private static ArrayList<Player> HunterList = new ArrayList<>();

	public HunterCommand(Main plugin) {

		this.plugin = plugin;
		plugin.HunterList = HunterList;
		plugin.getCommand("hunter").setExecutor(this);
		plugin.getCommand("hunter").setTabCompleter(new HunterAndRunnerCommandCompleter(plugin));

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		String FirstArg = args[0];
		String SecondArg = args[1];
		Server Serv = sender.getServer();

		if (FirstArg.equalsIgnoreCase("add")) {

			Player NewHunter = Serv.getPlayer(SecondArg);
			HunterList.add(NewHunter);
			Serv.broadcastMessage(ChatColor.AQUA + NewHunter.getName() + " was added to the hunters!");

		} else if (FirstArg.equalsIgnoreCase("remove")) {

			Player RemovedHunter = Serv.getPlayer(SecondArg);
			HunterList.remove(RemovedHunter);
			Serv.broadcastMessage(ChatColor.DARK_RED + RemovedHunter.getName() + " has been removed from the hunters");

		} else {

			// the logic for when the command is inputted wrong or with incorrect args
			sender.sendMessage(ChatColor.RED + "You have entered the command wrong.");

		}

		try {

			Player NewHunter = Serv.getPlayer(SecondArg);
			Player RemovedHunter = Serv.getPlayer(SecondArg);

		} catch (Exception e) {

			sender.sendMessage(ChatColor.RED + "You have entered someone's name that doesn't exist");

		}

		return false;

	}

}
