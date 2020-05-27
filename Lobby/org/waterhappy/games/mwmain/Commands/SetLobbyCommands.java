package org.waterhappy.games.mwmain.Commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.waterhappy.games.mwmain.Main;

public class SetLobbyCommands implements CommandExecutor {
	Main plugin;
	public SetLobbyCommands(Main instance) {
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.isOp() && sender instanceof Player) {
			Player p = (Player) sender;
			int x = p.getLocation().getBlockX();
			int y = p.getLocation().getBlockY();
			int z = p.getLocation().getBlockZ();
			World world = p.getLocation().getWorld();
			sender.sendMessage(ChatColor.GOLD + "正在將大廳設置在" + x + ", " + y + "," + z + " !");
			plugin.getConfig().set("lobby.x", x);
			plugin.getConfig().set("lobby.y", y);
			plugin.getConfig().set("lobby.z", z);
			plugin.getConfig().set("lobby.world", world.getName());
			plugin.saveConfig();
			sender.sendMessage(ChatColor.GREEN + "成功設置大廳座標!!");
		}
		else {
			sender.sendMessage(ChatColor.RED + "只有管理員或者擁有更高權限的玩家能這樣做!");
		}
		return true;
	}

}
