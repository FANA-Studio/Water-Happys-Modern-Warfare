package org.waterhappy.games.mwmain.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.waterhappy.games.mwmain.Main;

public class JoinLeaveMessage implements Listener {
	Main plugin;
	public JoinLeaveMessage(Main instance) {
		plugin = instance;
	}
	@EventHandler
	public void JoinMessage(PlayerJoinEvent event) {
		
		event.setJoinMessage("");
		if(event.getPlayer().getName().equalsIgnoreCase("xd_Tropicalfan")) {
			event.getPlayer().setDisplayName(ChatColor.GOLD + "�i���A���jxd_Tropicalfan");
			event.getPlayer().setPlayerListName(ChatColor.GOLD + "�i���A���jxd_Tropicalfan");
		}
		else if(event.getPlayer().getName().equalsIgnoreCase("xd_FanaOwner")) {
			event.getPlayer().setDisplayName(ChatColor.AQUA + "�i�}�o�̡jxd_FanaOwner");
			event.getPlayer().setPlayerListName(ChatColor.AQUA + "�i�}�o�̡jxd_FanaOwner");
		}
		else if(event.getPlayer().getName().equalsIgnoreCase("waterdropyea")) {
			event.getPlayer().setDisplayName(ChatColor.RED + "�i���w�jwaterdropyea");
			event.getPlayer().setPlayerListName(ChatColor.RED + "�i���w�jwaterdropyea");
		} else {
			event.getPlayer().setDisplayName(ChatColor.GRAY + "" + event.getPlayer().getName());
			event.getPlayer().setPlayerListName(ChatColor.GRAY + "" + event.getPlayer().getName());
		}
		event.getPlayer().getServer().broadcastMessage(ChatColor.GREEN + "[+] " + event.getPlayer().getDisplayName() + ChatColor.GREEN + "�[�J�F���A��!");
	}
	@EventHandler
	public void LeaveMessage(PlayerQuitEvent event) {
		event.setQuitMessage("");
		event.getPlayer().getServer().broadcastMessage(ChatColor.RED + "[-] " + event.getPlayer().getDisplayName() + ChatColor.RED + "���}�F���A��!");
	}

}
