package net.kettlemc.simplemotd.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.kettlemc.simplemotd.SimpleMOTD;
import net.md_5.bungee.api.ChatColor;

public class PlayerJoinListener implements Listener {

	private SimpleMOTD plugin;

	public PlayerJoinListener(SimpleMOTD plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (plugin.getConfiguration().useBypassPerm() && player.hasPermission(plugin.getConfiguration().getBypassPerm()))
			return;
		Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {

			@Override
			public void run() {
				for (String message : plugin.getConfiguration().getMotd())
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.replace("%player%", player.getName())));
			}

		}, plugin.getConfiguration().getDelay() * 20);

	}

}
