package me.gamingcuber.minecraftmanhunt.listeners;

import me.gamingcuber.minecraftmanhunt.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World.Environment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class CompassClickListener implements Listener {

    private Main plugin;

    public CompassClickListener (Main plugin) {

        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {

        Player ClickedPlayer = event.getPlayer();

        if (!ClickedPlayer.equals(plugin.Runner)) {

            if (event.getItem() != null && event.getItem().equals(plugin.getHunterCompass())) {

                if (inSameDimension(ClickedPlayer, plugin.Runner)) {

                    ClickedPlayer.sendMessage(ChatColor.GREEN + "Tracking " + plugin.Runner.getName());
                    ClickedPlayer.setCompassTarget(plugin.Runner.getLocation());

                } else {

                    ClickedPlayer.sendMessage(ChatColor.RED + "No players to track");

                }

            }

        }

    }

    private boolean inSameDimension(Player Hunter, Player Runner) {

        Environment RunnerDimension = Runner.getWorld().getEnvironment();
        Environment HunterDimension = Hunter.getWorld().getEnvironment();

        return RunnerDimension == HunterDimension;

    }

}
