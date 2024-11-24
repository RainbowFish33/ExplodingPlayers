package me.honeyberries.explodingPlayers;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExplodingPlayers extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Exploding Players has been enabled. Players can now explode!");
        getServer().getPluginManager().registerEvents(new EntityListener(), this);
        getServer().getPluginCommand("explodingPlayers").setExecutor(new ExplodingPlayersCommand());
        ExplodingPlayersSettings.getInstance().load();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getLogger().info("Exploding Players has been disabled!");
    }

    public static ExplodingPlayers getInstance() {
        return getPlugin(ExplodingPlayers.class);
    }
}