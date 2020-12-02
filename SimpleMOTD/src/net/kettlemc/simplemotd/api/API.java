package net.kettlemc.simplemotd.api;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.kettlemc.simplemotd.SimpleMOTD;
import net.md_5.bungee.api.ChatColor;

public class API {

	private SimpleMOTD plugin;

	public API(SimpleMOTD plugin) {
		this.plugin = plugin;
	}

	// Sends the MOTD to a player with a delay

	public void sendMOTD(Player player, int delay) {
		Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, new Runnable() {

			@Override
			public void run() {
				for (String message : plugin.getConfiguration().getMotd())
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', message.replace("%player%", player.getName())));
			}

		}, delay);
	}

	// Sends the MOTD to a player

	public void sendMOTD(Player player) {
		sendMOTD(player, 0);
	}

	// Returns a list of all motd lines (without replaced placeholders or colorcodes)

	public List<String> getMOTDList() {
		return plugin.getConfiguration().getMotd();
	}

	// Returns a the motd message (without replaced placeholders)

	public String getMOTD() {
		StringBuilder sb = new StringBuilder();
		for (String message : getMOTDList()) {
			sb.append(message + "\n");
		}
		return ChatColor.translateAlternateColorCodes('&', sb.toString());
	}

}
