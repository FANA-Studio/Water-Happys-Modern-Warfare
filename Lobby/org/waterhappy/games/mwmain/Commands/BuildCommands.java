package org.waterhappy.games.mwmain.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.waterhappy.games.mwmain.Main;

public class BuildCommands implements CommandExecutor {
	Main plugin;
	public BuildCommands(Main instance) {
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		if(sender instanceof Player) {
			if(sender.isOp()) {
				Player p = (Player) sender;
				if(plugin.getConfig().getBoolean("players." + p.getName() + ".build")) {
					plugin.getConfig().set("players." + p.getName() + ".build", false);
					p.sendMessage(ChatColor.RED + "�w�g�����A��BUILD�v��!");
				} else if (!(plugin.getConfig().getBoolean("players." + p.getName() + ".build"))){
					plugin.getConfig().set("players." + p.getName() + ".build", true);
					p.sendMessage(ChatColor.GREEN + "�w�g�����ABUILD�v��!");
				} else {
					plugin.getConfig().set("players." + p.getName() + ".build", true);
					p.sendMessage(ChatColor.GREEN + "�w�g�����ABUILD�v��!");
				}
				
			} else {
				sender.sendMessage(ChatColor.RED + "�u���޲z���Ϊ֦̾����v�������a��o�˰�!");
			}
		}
		return true;
	}

}
