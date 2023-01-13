package me.gamingcuber.minecraftmanhunt.listeners;

import me.gamingcuber.minecraftmanhunt.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RespawnListener implements Listener {

    private Main plugin;

    public RespawnListener (Main plugin) {

        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);

    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {

        Player RespawnedPlayer = event.getPlayer();

        if (!RespawnedPlayer.equals(plugin.Runner)) {

            RespawnedPlayer.getInventory().addItem(plugin.getHunterCompass());

        }

    }


}
