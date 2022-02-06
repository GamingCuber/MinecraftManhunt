package mcplugins.io.github.GamingCuber.MinecraftManhunt.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import mcplugins.io.github.GamingCuber.MinecraftManhunt.Main;

public class DeathListener implements Listener {

	private Main plugin;

	public DeathListener(Main plugin) {

		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler
	public void onDeath(EntityDeathEvent e) {

		if (!plugin.HuntEnd) {
			if (e.getEntityType() == EntityType.PLAYER) {

				for (Player Hunter : plugin.HunterList) {
					
					Server Serv = e.getEntity().getServer();
					Player DeadPlayer = (Player) e.getEntity();
					Player Runner = plugin.Runner;
					// logic for whenever the hunters win
					if (DeadPlayer.equals(plugin.Runner)) {

						plugin.HuntEnd = true;
						plugin.Runner = null;
						plugin.HunterList.clear();
						Serv.broadcastMessage(ChatColor.YELLOW + "The Manhunt has ended! The hunters have WON!");
						// logic for sending runner a title that tells them they lost
						Runner.sendTitle(ChatColor.RED + "You lost :(", ChatColor.RED + "GG", 10, 100, 20);
						Runner.playSound(DeadPlayer.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
						// logic for sending them a title saying congrats, you won
						Hunter.sendTitle(ChatColor.GOLD + "YOU WON!", "", 10, 100, 20);
						Hunter.playSound(Hunter.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1, 1);

						

					}

					// logic for whenever the runner wins
					if (e.getEntityType() == EntityType.ENDER_DRAGON) {

						plugin.HuntEnd = true;
						plugin.Runner = null;
						plugin.HunterList.clear();
						Serv.broadcastMessage(ChatColor.YELLOW + "The Manhunt has ended! The runner has WON!");
						Runner.sendTitle(ChatColor.RED + "YOU WON!", ChatColor.RED + "GG", 10, 100, 20);
						Runner.playSound(DeadPlayer.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1, 1);
						
						Hunter.sendTitle(ChatColor.GOLD + "You lost :(", "", 10, 100, 20);
						Hunter.playSound(Hunter.getLocation(), Sound.AMBIENT_CAVE, 1, 1);
						
					}
					
				}

			}
		}
	}
}
