package org.waterhappy.game.mwingame.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.waterhappy.game.mwingame.Main;

public class SetMaxPlayers implements CommandExecutor {	
	Main plugin;
	public SetMaxPlayers(Main instance) {
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if(sender.isOp()) {
			if(args.length >= 1) {
				Integer i = Integer.valueOf(args[0]);
				plugin.getConfig().set("rules.max", i);
				sender.sendMessage(ChatColor.GREEN + "成功將伺服器最多人數設定為 " + i);
			} else {
				sender.sendMessage(ChatColor.RED + "語法不正確!");
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + "只有管理員或管理員以上的人能使用此指令!");
		}
		return true;
	}

}
