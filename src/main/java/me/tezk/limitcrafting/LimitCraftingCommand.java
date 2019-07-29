package me.tezk.limitcrafting;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Tom Micallef on 23/12/2015.
 * Altered by Pizza on 29/07/2019.
 */

@SuppressWarnings("unused")
public class LimitCraftingCommand implements CommandExecutor {
	
	private final LimitCraftingPlugin plugin;
	public LimitCraftingCommand(final LimitCraftingPlugin pl) {
		this.plugin = pl;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender.hasPermission("limitcrafting.reload"))) {
			sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
			return true;
		}
		if (!(args.length == 1) || !(args[0].equalsIgnoreCase("reload"))) {
			sender.sendMessage(ChatColor.GREEN + "/limitcrafting reload " + ChatColor.GRAY + "- reloads configuration");
			return true;
		}
		plugin.reloadConfig();
		plugin.load();
		sender.sendMessage(ChatColor.GREEN + "Configuration " + ChatColor.GRAY + "reloaded for " + ChatColor.GREEN +
				plugin.getName() + " " + plugin.getDescription().getVersion());
		return true;
	}
}
