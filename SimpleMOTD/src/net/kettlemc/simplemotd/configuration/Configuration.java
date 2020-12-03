package net.kettlemc.simplemotd.configuration;

import java.util.Arrays;
import java.util.List;

public class Configuration {

	private BasicConfigurationHandler config;

	private List<String> motd;
	private boolean useBypassPerm;
	private String bypassPerm;
	private int delay;

	public Configuration() {
		this.config = new BasicConfigurationHandler("plugins/SimpleMOTD/config.yml");
		loadConfig();
	}

	@SuppressWarnings("unchecked")
	private void loadConfig() {
		this.motd = (List<String>) config.getValue("motd", Arrays.asList("&7Welcome to the server, &a%player%&7.", "&7Have fun while playing!", "&a%currentPlayers%&8/&a%maxPlayers% &7players are online right now."));
		this.useBypassPerm = config.getBool("settings.bypass.usePerm", false);
		this.bypassPerm = config.getString("settings.bypass.permission", "SimpleMOTD.bypass");
		this.delay = config.getInt("settings.delay.seconds", 0);
	}

	public List<String> getMotd() {
		return motd;
	}

	public boolean useBypassPerm() {
		return useBypassPerm;
	}

	public String getBypassPerm() {
		return bypassPerm;
	}

	public int getDelay() {
		return delay;
	}

}
