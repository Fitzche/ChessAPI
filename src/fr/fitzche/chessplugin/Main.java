package fr.fitzche.chessplugin;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public static JavaPlugin plug;


	@Override
	public void onEnable() {
		this.plug = this.getPlugin();
		getCommand("chess").setExecutor(new Chess());

		
	}
	
	@Override 
	public void onDisable() {
		
	}
	public JavaPlugin getPlugin() {
		return this;
	}
}


