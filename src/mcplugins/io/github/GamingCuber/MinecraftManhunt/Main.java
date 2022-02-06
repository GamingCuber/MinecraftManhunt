package mcplugins.io.github.GamingCuber.MinecraftManhunt;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import mcplugins.io.github.GamingCuber.MinecraftManhunt.Listeners.CompassInteractEvent;
import mcplugins.io.github.GamingCuber.MinecraftManhunt.Listeners.DeathListener;
import mcplugins.io.github.GamingCuber.MinecraftManhunt.Listeners.RespawnListener;
import mcplugins.io.github.GamingCuber.MinecraftManhunt.TabCompletion.HunterAndRunnerCommandCompleter;
import mcplugins.io.github.GamingCuber.MinecraftManhunt.TabCompletion.ManhuntCommandCompleter;
import mcplugins.io.github.GamingCuber.MinecraftManhunt.commands.HunterCommand;
import mcplugins.io.github.GamingCuber.MinecraftManhunt.commands.ManhuntCommand;
import mcplugins.io.github.GamingCuber.MinecraftManhunt.commands.RunnerCommand;

public class Main extends JavaPlugin {

	public Player Runner = null;
	public ArrayList<Player> HunterList = new ArrayList<>();
	public boolean HuntEnd;

	@Override
	public void onEnable() {

		new RunnerCommand(this);
		new HunterCommand(this);
		new ManhuntCommand(this);
		new HunterAndRunnerCommandCompleter(this);
		new ManhuntCommandCompleter(this);
		new DeathListener(this);
		new RespawnListener(this);
		new CompassInteractEvent(this);

	}

	@Override
	public void onDisable() {

	}

}
