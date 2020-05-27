package org.waterhappy.games.mwmain.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.waterhappy.games.mwmain.Main;

public class ChatEvents implements Listener {
	Main plugin;
	public ChatEvents(Main instance) {
		plugin = instance;
	}
	@EventHandler
	public void onChat(PlayerChatEvent event) {
		event.setCancelled(true);
		String format = event.getPlayer().getDisplayName() + ": " + "¡±r" + ChatColor.WHITE + event.getMessage();
		plugin.getServer().broadcastMessage(format);
	}
}
