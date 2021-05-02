package com.github.huda0209.irongolemspawncanceller;

import org.bukkit.configuration.Configuration;

public class configload {

    public static Boolean IronGolemSpawnCancellMode = false;
    private static Configuration config;

    public static void loadConfig(IronGolemSpawnCanceller pl){
        try{
            config = pl.getConfig();
        }catch (Exception exception){
            System.out.println("While load the config file, occurred error.");
            return;
        }

        IronGolemSpawnCancellMode = config.getBoolean("IronGolemSpawnCancellMode");
    }

    public static void setIronGolemSpawnCancellMode(Boolean bool,IronGolemSpawnCanceller pl){
        IronGolemSpawnCancellMode = bool;
        config.set("IronGolemSpawnCancellMode",bool);
        pl.saveConfig();
    }
}
