package org.waterhappy.game.mwingame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ChatEvent implements Listener {
	Main plugin;
	public ChatEvent(Main instance) {
		plugin = instance;
	}
	@EventHandler
	public void onChat(PlayerChatEvent event) {
		Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
		Team red = board.getTeam("Red");
		Team blue = board.getTeam("Blue");
		String team = "red";
		event.setCancelled(true);
		if(event.getMessage().startsWith("!")) {
			event.getPlayer().getServer().broadcastMessage(ChatColor.YELLOW + "【全體訊息】 " + event.getPlayer().getDisplayName()+ ChatColor.WHITE + ": " + event.getMessage());
		} else {
			for(OfflinePlayer p:red.getPlayers()) {
				if(p.getUniqueId().equals(event.getPlayer().getUniqueId())) {
					team = "red";
				}
			}
			for(OfflinePlayer p:blue.getPlayers()) {
				if(p.getUniqueId().equals(event.getPlayer().getUniqueId())) {
					team = "blue";
				}
			}
			if(team.equalsIgnoreCase("blue")) {
				for(OfflinePlayer p:blue.getPlayers()) {
					if(p.isOnline()) {
						Player player = (Player) p;
						player.sendMessage(ChatColor.BLUE + "【團隊】 " + event.getPlayer().getDisplayName() + ChatColor.WHITE + ": " + event.getMessage());
					}
				}
			}
			if(team.equalsIgnoreCase("red")) {
				for(OfflinePlayer p:red.getPlayers()) {
					if(p.isOnline()) {
						Player player = (Player) p;
						player.sendMessage(ChatColor.RED + "【團隊】 " + event.getPlayer().getDisplayName() + ChatColor.WHITE + ": " + event.getMessage());
					}
				}
			}
		}
	}
}
