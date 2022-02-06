package mcplugins.io.github.GamingCuber.MinecraftManhunt.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import mcplugins.io.github.GamingCuber.MinecraftManhunt.Main;
import mcplugins.io.github.GamingCuber.MinecraftManhunt.TabCompletion.ManhuntCommandCompleter;

public class ManhuntCommand implements CommandExecutor {

	private Main plugin;

	public ManhuntCommand(Main plugin) {

		this.plugin = plugin;
		plugin.getCommand("manhunt").setExecutor(this);
		plugin.getCommand("manhunt").setTabCompleter(new ManhuntCommandCompleter(plugin));

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		String FirstArg = args[0];
		Server Serv = sender.getServer();

		for (Player Hunter : plugin.HunterList) {

			if (FirstArg.equalsIgnoreCase("start")) {

				ItemStack HunterCompass = new ItemStack(Material.COMPASS);
				HunterCompass.addEnchantment(Enchantment.VANISHING_CURSE, 1);

				Hunter.getInventory().addItem(HunterCompass);
				Serv.broadcastMessage(ChatColor.BLUE + "The Manhunt has started!");
				plugin.HuntEnd = false;

			} else if (FirstArg.equalsIgnoreCase("stop")) {

				Hunter.getInventory().remove(Material.COMPASS);
				Serv.broadcastMessage(ChatColor.RED + "The Manhunt has ended!");
				plugin.HuntEnd = true;
				plugin.Runner = null;
				plugin.HunterList.clear();

			} else {

				sender.sendMessage(ChatColor.RED + "You have entered the command wrong.");

			}

		}

		return false;
	}

}
