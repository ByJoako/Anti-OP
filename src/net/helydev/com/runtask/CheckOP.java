package net.helydev.com.runtask;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.helydev.com.Antiop;

public class CheckOP{

	public static void run() {
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(Antiop.getPlugin().getConfig().getBoolean("Anti-OP.enable")) {
				if(player.isOp()) {
					if(!Antiop.getPlugin().getConfig().getStringList("List").contains(player.getName())){
						for(String command : Antiop.getPlugin().getConfig().getStringList("Command-execute")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%args-1%", player.getName()));
						}
					}
				}


				if(Antiop.getPlugin().getConfig().getBoolean("Anti-Permission.enable")) {
					if(player.isPermissionSet(Antiop.getPlugin().getConfig().getString("Anti-Permission.permission"))) {
						if(!Antiop.getPlugin().getConfig().getStringList("List").contains(player.getName())){
							for(String command : Antiop.getPlugin().getConfig().getStringList("Command-execute")) {
		                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%args-1%", player.getName()));
							}
						}
					}
				}
			}
		}
	}
}