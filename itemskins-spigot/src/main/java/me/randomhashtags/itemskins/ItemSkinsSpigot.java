package me.randomhashtags.itemskins;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemSkinsSpigot extends JavaPlugin {

    public static ItemSkinsSpigot getPlugin;
    public boolean placeholderapi;

    @Override
    public void onEnable() {
        getPlugin = this;
        enable();
    }

    @Override
    public void onDisable() {
        disable();
    }

    public void enable() {
        saveDefaultConfig();
        placeholderapi = Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI");
        ItemSkinsAPI.INSTANCE.load();
    }
    public void disable() {
        placeholderapi = false;
        ItemSkinsAPI.INSTANCE.unload();
    }

    public void reload() {
        disable();
        enable();
    }
}
