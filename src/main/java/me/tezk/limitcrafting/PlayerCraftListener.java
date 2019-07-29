package me.tezk.limitcrafting;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Tom Micallef on 23/12/2015.
 * Altered by Pizza on 29/07/2019.
 */

public class PlayerCraftListener implements Listener {
	
	private final LimitCraftingPlugin plugin;
	public PlayerCraftListener(final LimitCraftingPlugin pl) {
		this.plugin = pl;
	}
	
	@SuppressWarnings("deprecation") @EventHandler
	public void onPlayerCraft(final CraftItemEvent e) {
		final boolean enabled = plugin.isPlugEnabled();
		final String message = plugin.getMessage();
		final boolean blockAll = plugin.isBlockAll();
		final boolean notifyPlayer = plugin.isNotified();
		final List<String> items = plugin.getItems();
		
		if (!(enabled)) return;
		if (e.getWhoClicked().hasPermission("limitcrafting.bypass")) return;
		
		if (blockAll) {
			e.setCancelled(true);
			final ItemStack is = e.getCurrentItem();
			if (notifyPlayer)
			{
				e.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', message)
						.replace("%item%", is.getData().getItemType().name().toLowerCase()));
			}
			return;
		}
		
		for (String s : items) {
			final String mat = s.split(":")[0];
			final ItemStack is;
			if (!(s.contains(":"))) {
				is = new ItemStack(Material.valueOf(mat));
			} else {
				final byte type = Byte.valueOf(s.split(":")[1]);
				is = new ItemStack(Material.valueOf(mat), 0, (short)0, type);
			}
			if (e.getRecipe().getResult().isSimilar(is)) {
				e.setCancelled(true);
				if (notifyPlayer)
				{
					e.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&', message)
							.replace("%item%", is.getData().getItemType().name().toLowerCase()));
				}
			}
		}
	}
}
