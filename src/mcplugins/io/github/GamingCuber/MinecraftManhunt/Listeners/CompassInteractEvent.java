package mcplugins.io.github.GamingCuber.MinecraftManhunt.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import mcplugins.io.github.GamingCuber.MinecraftManhunt.Main;

public class CompassInteractEvent implements Listener {

	private Main plugin;

	public CompassInteractEvent(Main plugin) {

		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler
	public void onClick(PlayerInteractEvent e, EntityPortalEvent PortalEvent) {

		Player Runner = plugin.Runner;
		Action Act = e.getAction();
		if (!plugin.HuntEnd) {
			for (Player Hunter : plugin.HunterList) {
				if (e.getMaterial() == Material.COMPASS && !plugin.HuntEnd && !(plugin.Runner == null)) {

					Environment HunterEnv = Hunter.getWorld().getEnvironment();
					Environment RunnerEnv = Hunter.getWorld().getEnvironment();

					if (Act == Action.RIGHT_CLICK_AIR || Act == Action.RIGHT_CLICK_BLOCK || Act == Action.PHYSICAL) {
						// logic for when both the hunter and runner are in the same dimension
						if (HunterEnv == RunnerEnv) {

							Hunter.setCompassTarget(Runner.getLocation());
							Hunter.sendMessage(ChatColor.GREEN + "Tracking " + Runner.getName());

						}
						// logic for when the runner enters a new dimension
						if (PortalEvent.getEntity().equals(Runner)) {

							if (HunterEnv == Environment.NORMAL && RunnerEnv == Environment.NETHER) {

								Hunter.setCompassTarget(PortalEvent.getFrom());
								Hunter.sendMessage(ChatColor.GREEN + "Tracking " + Runner.getName() + "'s Portal");

							} else if (HunterEnv == Environment.NORMAL && RunnerEnv == Environment.THE_END) {

								Hunter.setCompassTarget(PortalEvent.getFrom());
								Hunter.sendMessage(ChatColor.GREEN + "Tracking " + Runner.getName() + "'s End Portal");

							}
						}
					}
				}

			}
		}

	}

}
