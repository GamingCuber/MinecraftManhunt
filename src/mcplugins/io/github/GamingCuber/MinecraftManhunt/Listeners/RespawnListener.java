package mcplugins.io.github.GamingCuber.MinecraftManhunt.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import mcplugins.io.github.GamingCuber.MinecraftManhunt.Main;

public class RespawnListener implements Listener {

	private Main plugin;

	public RespawnListener(Main plugin) {

		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);

	}

	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {

		Player RespawnedPlayer = e.getPlayer();
		Player Hunter;
		for (Player p : plugin.HunterList) {

			Hunter = p;
			// logic for whenever a hunter dies. Gives a compass to them for the tracking
			if (RespawnedPlayer.equals(Hunter)) {

				if (!plugin.HuntEnd) {

					ItemStack HunterCompass = new ItemStack(Material.COMPASS);
					HunterCompass.addEnchantment(Enchantment.VANISHING_CURSE, 1);

					p.getInventory().addItem(HunterCompass);

				}
			}
		}
	}
}
