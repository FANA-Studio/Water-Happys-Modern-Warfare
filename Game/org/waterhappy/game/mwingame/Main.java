package org.waterhappy.game.mwingame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;




public class Main extends JavaPlugin{
	public void onEnable() {
		SetUpTeam();
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD +  "================================");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD +  "");
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "  Water Happy's Modern Warfare");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "      �D�n����ҥΤ�...");

		this.saveDefaultConfig();
		
		getServer().getPluginManager().registerEvents(new org.waterhappy.game.mwingame.Events.JoinLeaveMessage(this), this);
		
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "     �C������ҥΧ���!!!");
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "����W�� : WHMW In-Game");
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[PRIVATE]");
		getServer().getConsoleSender().sendMessage(ChatColor.RED +    "�o�N��o�O�p�H����A�ФŤ��}!!");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD +  "");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD +  "================================");
	}
	public void SetUpConfig() {
		if(getConfig().getIn)
	}
	public void SetUpTeam() {
		Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
		Team red = board.registerNewTeam("Red");
		Team blue = board.registerNewTeam("Blue");
		red.setPrefix(ChatColor.RED + "" + ChatColor.BOLD + "RED ");
		blue.setPrefix(ChatColor.BLUE + "" + ChatColor.BOLD + "BLUE ");
	}

}
