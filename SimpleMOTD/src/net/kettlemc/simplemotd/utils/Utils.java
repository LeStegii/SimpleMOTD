package net.kettlemc.simplemotd.utils;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {

	public static ArrayList<Player> getOnlinePlayers() {
		ArrayList<Player> players = new ArrayList<Player>();
		for (Player player : Bukkit.getOnlinePlayers())
			players.add(player);
		return players;
	}
	
	public static int getPlayerCount() {
		return getOnlinePlayers().size();
	}

}
