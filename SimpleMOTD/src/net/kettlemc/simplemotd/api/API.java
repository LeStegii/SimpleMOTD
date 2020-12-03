package net.kettlemc.simplemotd.api;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.kettlemc.simplemotd.SimpleMOTD;
import net.kettlemc.simplemotd.utils.Utils;
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
				player.sendMessage(getMOTD(player));
			}

		}, delay);
	}

	// Sends the MOTD to a player

	public void sendMOTD(Player player) {
		sendMOTD(player, 0);
	}

	// Returns a list of all motd lines (without replaced placeholders or
	// colorcodes)

	public List<String> getMOTDList() {
		return plugin.getConfiguration().getMotd();
	}

	// Replaces all placeholders and colorcodes in a message

	public String replacePlaceholders(String raw, Player player) {
		raw = raw.replace("%player%", player.getName());
		raw = raw.replace("%currentPlayers%", String.valueOf(Utils.getPlayerCount()));
		raw = raw.replace("%maxPlayers%", String.valueOf(Bukkit.getMaxPlayers()));
		return ChatColor.translateAlternateColorCodes('&', raw);
	}

	// Returns the full motd message

	public String getMOTD(Player player) {
		StringBuilder sb = new StringBuilder();
		for (String message : getMOTDList()) {
			sb.append(message + "\n");
		}
		return replacePlaceholders(sb.toString(), player);
	}

}
