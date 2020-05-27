package org.waterhappy.games.mwmain;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.waterhappy.games.mwmain.Commands.BuildCommands;
import org.waterhappy.games.mwmain.Commands.HubCommands;
import org.waterhappy.games.mwmain.Commands.SetLobbyCommands;
import org.waterhappy.games.mwmain.Events.ChatEvents;
import org.waterhappy.games.mwmain.Events.JoinLeaveMessage;
import org.waterhappy.games.mwmain.Events.LobbyProtection;

public class Main extends JavaPlugin{
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD +  "================================");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD +  "");
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "  Water Happy's Modern Warfare");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "      主要插件啟用中...");

		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new JoinLeaveMessage(this), this);
		getServer().getPluginManager().registerEvents(new ChatEvents(this), this);
		getServer().getPluginManager().registerEvents(new LobbyProtection(this), this);
		
		getServer().getPluginCommand("setlobby").setExecutor(new SetLobbyCommands(this));
		getServer().getPluginCommand("hub").setExecutor(new HubCommands(this));
		getServer().getPluginCommand("lobby").setExecutor(new HubCommands(this));
		getServer().getPluginCommand("build").setExecutor(new BuildCommands(this));
		
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "     主要插件啟用完畢!!!");
		getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "插件名稱 : WHMW Main");
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "[PRIVATE]");
		getServer().getConsoleSender().sendMessage(ChatColor.RED +    "這代表這是私人插件，請勿公開!!");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD +  "");
		getServer().getConsoleSender().sendMessage(ChatColor.GOLD +  "================================");
	}

}
