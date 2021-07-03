package net.helydev.com.utils;

import org.bukkit.ChatColor;

public class ColorText {
	public static String translate(String in) {
		return ChatColor.translateAlternateColorCodes('&', in);
	}
}