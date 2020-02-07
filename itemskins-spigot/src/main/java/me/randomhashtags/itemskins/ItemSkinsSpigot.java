package me.randomhashtags.itemskins;

import org.bukkit.plugin.java.JavaPlugin;

public final class ItemSkinsSpigot extends JavaPlugin {

    public static ItemSkinsSpigot getPlugin;

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
        ItemSkinsAPI.INSTANCE.load();
    }
    public void disable() {
        ItemSkinsAPI.INSTANCE.unload();
    }

    public void reload() {
        disable();
        enable();
    }
}
