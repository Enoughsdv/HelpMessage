package com.enough.helpmessage.command;

import com.enough.helpmessage.HelpMessage;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Helpcommand implements CommandExecutor{
    
    private HelpMessage plugin;
    
    public Helpcommand(HelpMessage plugin){
        this.plugin = plugin;
    }
  
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if(!(sender instanceof Player)){
            Bukkit.getConsoleSender().sendMessage(plugin.getConfig().getString("Console_sender"));
            
            return true;
        }
        
        Player player = (Player) sender;
        
        if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            
            for(String lines: plugin.getConfig().getStringList("Messages")){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, lines)).replace("<player_name>", player.getName()));
 
                return true;
            }
            
        } else {
            
            for(String lines: plugin.getConfig().getStringList("Messages")){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', lines).replace("<player_name>", player.getName()));
                
                return true;
            }
            
        }
        
        return true;
    }   
}
