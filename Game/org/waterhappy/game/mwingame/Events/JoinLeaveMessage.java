package org.waterhappy.game.mwingame.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.waterhappy.game.mwingame.Main;

public class JoinLeaveMessage implements Listener {
	Main plugin;
	public JoinLeaveMessage(Main instance) {
		plugin = instance;
	}
	@EventHandler
	public void JoinMessage(PlayerJoinEvent event) {
		event.setJoinMessage("");
		Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
		Team red = board.getTeam("Red");
		Team blue = board.getTeam("Blue");
		int reds = 0;
		int blues = 0;
		for(OfflinePlayer p:red.getPlayers()) {
			reds += 1;
		}
		for(OfflinePlayer p:blue.getPlayers()) {
			blues += 1;
		}
		if(blues >= reds) {
			red.addPlayer(event.getPlayer());
		} else {
			blue.addPlayer(event.getPlayer());
		}
		int max = plugin.getConfig().getInt("rules.max");
		event.getPlayer().getServer().broadcastMessage(ChatColor.GRAY + event.getPlayer().getDisplayName() + ChatColor.GOLD + " 參加了這局遊戲! (" + ChatColor.AQUA + event.getPlayer().getServer().getOnlinePlayers().size() + ChatColor.GOLD + "/" + ChatColor.AQUA + max + ChatColor.GOLD + ")");
	}
}
