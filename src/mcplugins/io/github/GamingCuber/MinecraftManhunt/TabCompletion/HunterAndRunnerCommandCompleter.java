package mcplugins.io.github.GamingCuber.MinecraftManhunt.TabCompletion;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import mcplugins.io.github.GamingCuber.MinecraftManhunt.Main;

public class HunterAndRunnerCommandCompleter implements TabCompleter {

	private Main plugin;

	public HunterAndRunnerCommandCompleter(Main plugin) {

		this.plugin = plugin;

	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {

		if (args.length == 1) {

			List<String> FirstArgList = new ArrayList<>();
			FirstArgList.add("add");
			FirstArgList.add("remove");
			return FirstArgList;

		}

		return null;
	}

}
