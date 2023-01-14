package me.gamingcuber.minecraftmanhunt;

import me.gamingcuber.minecraftmanhunt.commands.CompassCommand;
import me.gamingcuber.minecraftmanhunt.commands.RunnerCommand;
import me.gamingcuber.minecraftmanhunt.listeners.CompassClickListener;
import me.gamingcuber.minecraftmanhunt.listeners.DeathListener;
import me.gamingcuber.minecraftmanhunt.listeners.RespawnListener;
import me.gamingcuber.minecraftmanhunt.tabcompleter.RunnerTabCompleter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    public Player Runner;
    @Override
    public void onEnable() {

        new CompassCommand(this);
        new RunnerCommand(this);
        new CompassClickListener(this);
        new DeathListener(this);
        new RespawnListener(this);
        new RunnerTabCompleter(this);

    }

    @Override
    public void onDisable() {

    }


    public ItemStack getHunterCompass() {

        ItemStack HunterCompass = new ItemStack(Material.COMPASS);
        HunterCompass.addEnchantment(Enchantment.VANISHING_CURSE, 1);

        return HunterCompass;

    }

    public ArrayList <Player> getHunterList() {

            ArrayList <Player> PlayerList = new ArrayList<>(Bukkit.getOnlinePlayers());
            PlayerList.remove(Runner);
            return PlayerList;

    }
}
