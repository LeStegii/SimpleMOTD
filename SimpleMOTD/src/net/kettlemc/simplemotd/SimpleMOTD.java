package net.kettlemc.simplemotd;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.kettlemc.simplemotd.api.API;
import net.kettlemc.simplemotd.configuration.Configuration;
import net.kettlemc.simplemotd.listener.PlayerJoinListener;

public class SimpleMOTD extends JavaPlugin {

	private Configuration config;

	private static API api;

	public void onEnable() {
		registerListener();
		this.config = new Configuration();
		api = new API(this);
	}

	private void registerListener() {
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
	}

	public Configuration getConfiguration() {
		return this.config;
	}

	public static API getAPI() {
		return api;
	}

}
