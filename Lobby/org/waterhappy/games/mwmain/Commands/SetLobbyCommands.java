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
			sender.sendMessage(ChatColor.GOLD + "���b�N�j�U�]�m�b" + x + ", " + y + "," + z + " !");
			plugin.getConfig().set("lobby.x", x);
			plugin.getConfig().set("lobby.y", y);
			plugin.getConfig().set("lobby.z", z);
			plugin.getConfig().set("lobby.world", world.getName());
			plugin.saveConfig();
			sender.sendMessage(ChatColor.GREEN + "���\�]�m�j�U�y��!!");
		}
		else {
			sender.sendMessage(ChatColor.RED + "�u���޲z���Ϊ֦̾����v�������a��o�˰�!");
		}
		return true;
	}

}
