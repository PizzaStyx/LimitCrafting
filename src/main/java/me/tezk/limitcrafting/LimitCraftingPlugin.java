package me.tezk.limitcrafting;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Tom Micallef on 23/12/2015.
 * Altered by Pizza on 29/07/2019.
 */

public final class LimitCraftingPlugin extends JavaPlugin {
	
	private boolean enabled;
	private String message;
	private boolean blockAll;
	private boolean notifyPlayer;
	private List<String> items;
	
	@Override
	public void onEnable() {
		load();
		saveDefaultConfig();
		
		getCommand("limitcrafting").setExecutor(new LimitCraftingCommand(this));
		getServer().getPluginManager().registerEvents(new PlayerCraftListener(this), this);
	}

	public void load() {
		this.enabled = getConfig().getBoolean("enabled");
		this.message = getConfig().getString("message");
		this.notifyPlayer = getConfig().getBoolean("notify-player");
		this.blockAll = getConfig().getBoolean("block-all-items");
		this.items = getConfig().getStringList("items");
	}

	public boolean isPlugEnabled() {
		return this.enabled;
	}

	public boolean isBlockAll() {
		return blockAll;
	}
	
	public boolean isNotified() {
		return notifyPlayer;
	}

	public List<String> getItems() {
		return this.items;
	}

	public String getMessage() {
		return this.message;
	}
}