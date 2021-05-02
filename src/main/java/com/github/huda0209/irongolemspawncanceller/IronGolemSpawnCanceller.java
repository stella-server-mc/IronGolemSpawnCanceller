package com.github.huda0209.irongolemspawncanceller;

import com.github.huda0209.irongolemspawncanceller.command.commandHandler;
import com.github.huda0209.irongolemspawncanceller.listener.IronGolemSpawnEvent;
import com.github.huda0209.irongolemspawncanceller.configload;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;


public final class IronGolemSpawnCanceller extends JavaPlugin implements CommandExecutor{

    final String pluginName = this.getDescription().getName();

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        getCommand("igsc").setExecutor(new commandHandler(this));
        getServer().getPluginManager().registerEvents(new IronGolemSpawnEvent(this),this);
        configload.loadConfig(this);

        String[] EnableMessage = {"=============================","Plugin Name : "+pluginName ,"Author : "+ this.getDescription().getAuthors(),"============================="};
        for (String s : EnableMessage) {
            getLogger().info(s);
        }
        getLogger().info("IronGolemSpawnCancellMode was "+configload.IronGolemSpawnCancellMode.toString()+" now.");
    }

    @Override
    public void onDisable() {
        getLogger().info(pluginName+"is disable");
    }

    public void logger(String msg){
        getLogger().info(msg);
    }
}
