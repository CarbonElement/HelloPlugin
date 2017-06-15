package com.wellintlabs.hello;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class MyFirstPlugin extends JavaPlugin {

	@Override
	public void onEnable(){
		getLogger().info("HelloPlugin by MrCoolKhaled has been activated. Have fun using it!");
		getLogger().info("Loading Config....");
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		getLogger().info("Config Loaded!");
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Thank you for using HelloPlugin");
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("hello")) {
			
			if(args.length == 0) {
			
			if (sender instanceof Player) {		
				
				Player player = (Player) sender;
				
			String message = getConfig().getString("message");
					if(message.contains("%playername%")) {
						message = message.replace("%playername%", player.getName());
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
					} else {
						player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
					}
			
			return true;
			
			} else {
				sender.sendMessage(ChatColor.RED + "This command is for players only");
			}
			
			} else if(args.length == 1 && args[0].equalsIgnoreCase("reload")) {
				
				if(sender instanceof Player) {
					
					Player player = (Player) sender;
					
					reloadConfig();
					player.sendMessage(ChatColor.GREEN + "[HelloPlugin] Config has been reloaded!");
				} else {
					reloadConfig();
					getLogger().info("Config has been reloaded!");
				}
			}
			
			
		}
		
		
		return false;
		
	}
	
}
