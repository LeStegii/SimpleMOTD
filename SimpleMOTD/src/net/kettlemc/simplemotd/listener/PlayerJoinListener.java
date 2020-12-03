package net.kettlemc.simplemotd.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.kettlemc.simplemotd.SimpleMOTD;

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
		SimpleMOTD.getAPI().sendMOTD(player, plugin.getConfiguration().getDelay()*20);

	}

}
