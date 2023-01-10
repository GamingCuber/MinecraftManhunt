package me.gamingcuber.minecraftmanhunt.commands;

import me.gamingcuber.minecraftmanhunt.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CompassCommand implements CommandExecutor {

    private Main plugin;

    public CompassCommand (Main plugin) {

        this.plugin = plugin;
        plugin.getCommand("compass").setExecutor(this);

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            if (plugin.Runner == null) {

                sender.sendMessage(ChatColor.RED + "Make sure to set a runner, then run this command!");

            } else {

                sender.sendMessage(ChatColor.GREEN + "The hunters have now been given their compasses");
                for (Player Hunter : getHunterList()) {

                    Hunter.getInventory().addItem(plugin.getHunterCompass());

                }

            }

        } else {

            sender.sendMessage(ChatColor.RED + "You have to be a player to send commands!");

        }



        return false;
    }

    private ArrayList<Player> getHunterList() {

        ArrayList <Player> PlayerList = new ArrayList<>(Bukkit.getOnlinePlayers());
        PlayerList.remove(plugin.Runner);
        return PlayerList;

    }
}
