package me.gamingcuber.minecraftmanhunt.tabcompleter;

import me.gamingcuber.minecraftmanhunt.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class RunnerTabCompleter implements TabCompleter {

    private Main plugin;

    public RunnerTabCompleter(Main plugin) {

        this.plugin = plugin;

    }


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {

            List<String> TabList = new ArrayList<>();
            TabList.add("set");
            TabList.add("clear");
            TabList.add("list");
            return TabList;

        }


        return null;
    }
}
