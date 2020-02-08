package me.randomhashtags.itemskins;

import org.bukkit.plugin.java.JavaPlugin;

public final class ItemSkinsSpigot extends JavaPlugin {

    public static ItemSkinsSpigot getPlugin;

    @Override
    public void onEnable() {
        getPlugin = this;
        saveSettings();
        enable();
    }

    @Override
    public void onDisable() {
        disable();
    }

    private void saveSettings() {
        saveDefaultConfig();
    }

    public void enable() {
        saveSettings();
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
