package org.waterhappy.game.mwingame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.waterhappy.game.mwingame.Commands.SetMaxPlayers;


public class Main extends JavaPlugin{
	public void onEnable() {
		for(Player p:getServer().getOnlinePlayers()) {
			p.kickPlayer(ChatColor.GREEN + "伺服器已經重新啟動!請重新加入!");
		}
		getServer().getPluginCommand("setmaxplayers").setExecutor(new SetMaxPlayers(this));
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD +  "================================");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD +  "");
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "  Water Happy's Modern Warfare");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "      主要插件啟用中...");

		this.saveDefaultConfig();
		
		getServer().getPluginManager().registerEvents(new org.waterhappy.game.mwingame.Events.JoinLeaveMessage(this),this);
		getServer().getPluginManager().registerEvents(new ChatEvent(this), this);
		
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "     遊戲插件啟用完畢!!!");
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "插件名稱 : WHMW In-Game");
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[PRIVATE]");
		getServer().getConsoleSender().sendMessage(ChatColor.RED +    "這代表這是私人插件，請勿公開!!");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD +  "");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD +  "================================");
		getConfig().set("rules.max", 10);
		Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
		Team red = board.registerNewTeam("Red");
		Team blue = board.registerNewTeam("Blue");
		red.setPrefix(ChatColor.RED + "" + ChatColor.BOLD + "RED ");
		blue.setPrefix(ChatColor.BLUE + "" + ChatColor.BOLD + "BLUE ");
	}

}
