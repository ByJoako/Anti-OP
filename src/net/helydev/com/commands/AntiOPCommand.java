package net.helydev.com.commands;

import net.helydev.com.Antiop;
import net.helydev.com.utils.ColorText;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AntiOPCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender.hasPermission("*") && sender.isOp()) {
			if(args.length==1||args.length==2) {
				if(args[0].equalsIgnoreCase("list")) {
					sender.sendMessage(ColorText.translate("&6&lOp list"));
	                for (final String oplist : Antiop.getPlugin().getConfig().getStringList("List")) {
						sender.sendMessage(ColorText.translate("&7- &e"+oplist));
					}
				}else if(args[0].equalsIgnoreCase("add")) {
					if(sender instanceof Player) {
						sender.sendMessage(ColorText.translate("&cUse in CONSOLE"));
						return true;
					}else {
						
					if(!(args[1]==null)) {
			            FileConfiguration config = Antiop.getPlugin().getConfig();
			            List<String> list=Antiop.getPlugin().getConfig().getStringList("List");
						String name = args[1];
			            list.add(name);
						config.set("List", list);
				        try {
				        	config.save(this.getConfigFile());
						} catch (IOException e) {
							e.printStackTrace();
						}
						sender.sendMessage(ColorText.translate("&6"+name+" &ahas been added to the OP list"));
					}
				}
				}else {
					sender.sendMessage(ColorText.translate("&cUse: /antiop list"));
					sender.sendMessage(ColorText.translate("&cUse: /antiop add <player>"));
				}
				
			}
		}else {
			sender.sendMessage(ColorText.translate("&cNo permission."));
		}
		return false;
	}
    public File getConfigFile() {
        return new File("plugins/tAnti-OP", "config.yml");
    }

}
