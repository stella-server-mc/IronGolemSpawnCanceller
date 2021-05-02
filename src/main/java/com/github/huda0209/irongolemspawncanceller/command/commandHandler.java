package com.github.huda0209.irongolemspawncanceller.command;

import com.github.huda0209.irongolemspawncanceller.IronGolemSpawnCanceller;
import com.github.huda0209.irongolemspawncanceller.configload;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class commandHandler implements CommandExecutor {

    private final IronGolemSpawnCanceller plugin;
    public commandHandler(IronGolemSpawnCanceller pl){
        this.plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(args.length==0) return false;
        switch (args[0].toLowerCase(Locale.ROOT)){
            case "setmode" :
                if(!sender.hasPermission("IronGolemSpawnCanceller.SetMode")){
                    sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§c You don't have permission!");
                    return true;
                }
                if(args.length!=2){
                    return false;
                }
                if(!args[1].equalsIgnoreCase("true") && !args[1].equalsIgnoreCase("false")){
                    sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§c Please specify SetMode with true or false.");
                    return true;
                }

                Boolean mode = args[1].equalsIgnoreCase("true");

                sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§a IronGolemSpawnCancellMode set to "+ mode.toString() +".");
                configload.setIronGolemSpawnCancellMode(mode,plugin);
                break;

            case "reload":
                if(!sender.hasPermission("IronGolemSpawnCanceller.Reload")){
                    sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§c You don't have permission!");
                    return true;
                }
                try {
                    configload.loadConfig(plugin);
                    sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§a Reload the config file.");
                }catch(Exception e){
                    sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§c While reload the config file, occurred error. Please check console.");
                    System.out.println(e.toString());
                }
                break;

            default:
                sender.sendMessage("§9[" + plugin.getDescription().getName() + "]§c Unknown command.");
                break;
        }
        return true;
    }
}
