package com.enough.helpmessage;

import com.enough.helpmessage.command.Helpcommand;
import org.bukkit.plugin.java.JavaPlugin;


public class HelpMessage extends JavaPlugin {
  
   private static HelpMessage instance;
   
    @Override
    public void onEnable(){
        instance = this;
        
        saveDefaultConfig();
        
        getCommand("help").setExecutor(new Helpcommand(this));
    }
    
    public static HelpMessage getInstance() {
        return instance;
    }

}
