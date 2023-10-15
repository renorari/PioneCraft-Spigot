package net.renroari.pionecraft;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;

public final class PioneCraft extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                String worldName = getConfig().getString("world_name");
                float volume = getConfig().getInt("volume");
                getServer().getWorld(worldName).playSound(getServer().getWorld(worldName).getSpawnLocation(), "minecraft:pione.nether", volume, 1);
            }
        }, 0L, 600L);
        getLogger().info("===================================");
        getLogger().info("PioneCraft has been enabled!");
        getLogger().info("===================================");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("===================================");
        getLogger().info("PioneCraft has been disabled!");
        getLogger().info("===================================");
    }
}