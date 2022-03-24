package com.github.huda0209.irongolemspawncanceller.listener;

import com.github.huda0209.irongolemspawncanceller.IronGolemSpawnCanceller;
import com.github.huda0209.irongolemspawncanceller.configload;
import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class IronGolemSpawnEvent implements Listener {

    private final IronGolemSpawnCanceller plugin;
    public IronGolemSpawnEvent(IronGolemSpawnCanceller pl) {
        this.plugin = pl;
    }

    @EventHandler
    public void IronGolemSpawnEvent(EntitySpawnEvent event){
        Entity entity = event.getEntity();

        if(!configload.IronGolemSpawnCancellMode) return;
        if(!(entity instanceof IronGolem)) return;

        IronGolem ig = (IronGolem) entity;

        if(!ig.isPlayerCreated()) event.setCancelled(true);
        plugin.getLogger().info("------------------------------------------");
        plugin.getLogger().info("To spawn IronGolem successful Cancelled.");
        plugin.getLogger().info("World : " +entity.getWorld().getName());
        plugin.getLogger().info("Location: ("+entity.getLocation().getX()+", "+entity.getLocation().getY()+", "+entity.getLocation().getZ()+")");
        plugin.getLogger().info("------------------------------------------");

    }
}
