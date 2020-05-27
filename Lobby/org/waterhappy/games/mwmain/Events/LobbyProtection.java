package org.waterhappy.games.mwmain.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.waterhappy.games.mwmain.Main;

public class LobbyProtection implements Listener {
	Main plugin;
	public LobbyProtection(Main instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		if(plugin.getConfig().getBoolean("players." + event.getPlayer().getName() + ".build") != true) {
			event.setCancelled(true);
			if(event.getPlayer().getLocation().getWorld().getName().equals(plugin.getConfig().getString("lobby.world"))) {
				event.getPlayer().sendMessage(ChatColor.RED + "你不能破壞這裡的方塊!");
			}
		}
	}
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		if(plugin.getConfig().getBoolean("players." + event.getPlayer().getName() + ".build") != true) {
			event.setCancelled(true);
			if(event.getPlayer().getLocation().getWorld().getName().equals(plugin.getConfig().getString("lobby.world"))) {
				event.getPlayer().sendMessage(ChatColor.RED + "你不能在這裡放置方塊!");
			}
		}
	}
}
