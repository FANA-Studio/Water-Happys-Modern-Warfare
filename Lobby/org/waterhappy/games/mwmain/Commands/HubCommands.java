package org.waterhappy.games.mwmain.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.waterhappy.games.mwmain.Main;

public class HubCommands implements CommandExecutor {
	Main plugin;
	public HubCommands(Main instance) {
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			sender.sendMessage(ChatColor.GREEN + "正在將您傳送回主大廳...");
			Player p = (Player) sender;
			int x = plugin.getConfig().getInt("lobby.x");
			int y = plugin.getConfig().getInt("lobby.y");
			int z = plugin.getConfig().getInt("lobby.z");
			World world = plugin.getServer().getWorld(plugin.getConfig().getString("lobby.world"));
			Location loc = new Location(world, x, y, z);
			p.teleport(loc);
		}
		return true;
	}

}
