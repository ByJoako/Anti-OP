package net.helydev.com;

import org.bukkit.plugin.java.JavaPlugin;

import net.helydev.com.commands.AntiOPCommand;
import net.helydev.com.runtask.CheckOP;

public class Antiop extends JavaPlugin {
	private static Antiop instance;

	public void onEnable() {
		instance=this;
		saveDefaultConfig();
		reloadConfig();
        this.getCommand("antiop").setExecutor(new AntiOPCommand());
        runTaskTimer(CheckOP::run
		,0L, 20L * 5L);
		System.out.println("["+Antiop.getPlugin().getName()+"] Author: ByJoako");
	}

	public void onDisable() {
		instance=null;
	}

	public static Antiop getPlugin() {
		return Antiop.instance;
	}


	public static void runTaskTimer(Runnable runnable, long delay, long timer) {
		Antiop.getPlugin().getServer().getScheduler().runTaskTimerAsynchronously(Antiop.getPlugin(), runnable, delay, timer);
	}
}
