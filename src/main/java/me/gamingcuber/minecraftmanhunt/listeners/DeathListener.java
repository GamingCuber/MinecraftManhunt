package me.gamingcuber.minecraftmanhunt.listeners;

import me.gamingcuber.minecraftmanhunt.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeathListener implements Listener {

    private Main plugin;

    public DeathListener(Main plugin) {

        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {

        Entity DeadEntity = event.getEntity();

        //checks whether the player that just died was the runner or not
        if (DeadEntity.equals(plugin.Runner)) {

            for (Player Hunter : plugin.getHunterList()) {

                Hunter.playSound(Hunter.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 5.0F, 1.0F);
                Hunter.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "YOU WON!");

            }

            plugin.Runner.setGameMode(GameMode.SPECTATOR);
            plugin.Runner.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You lost :(");

        }

        //logic for when the runner wins
        if (DeadEntity.getType() == EntityType.ENDER_DRAGON) {

            for (Player Hunter : plugin.getHunterList()) {

                Hunter.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You lost :(");

            }

            plugin.Runner.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "YOU WON!");
            plugin.Runner.playSound(plugin.Runner.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 5.0F, 1.0F);

        }

    }

}
