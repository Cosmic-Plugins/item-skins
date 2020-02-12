package me.randomhashtags.itemskins;

import com.sun.istack.internal.NotNull;
import me.randomhashtags.itemskins.addon.ItemSkin;
import me.randomhashtags.itemskins.addon.FileItemSkin;
import me.randomhashtags.itemskins.universal.UInventory;
import me.randomhashtags.itemskins.universal.UVersionable;
import me.randomhashtags.itemskins.util.RPItemStack;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public enum ItemSkinsAPI implements Listener, CommandExecutor, UVersionable, RPItemStack {
    INSTANCE;

    private boolean isEnabled;

    private ItemStack item;
    private ItemMeta itemMeta;
    private List<String> lore;

    public YamlConfiguration CONFIG;

    private UInventory gui;
    private ItemStack skin;
    private String appliedLore;
    private HashMap<String, String> materials;
    private HashMap<ItemSkin, ItemStack> cache;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
        }
        return true;
    }

    public void load() {
        if(isEnabled) {
            return;
        }
        isEnabled = true;
        final long started = System.currentTimeMillis();

        PLUGIN_MANAGER.registerEvents(this, ITEM_SKINS);
        item = new ItemStack(Material.APPLE);
        itemMeta = item.getItemMeta();
        lore = new ArrayList<>();

        if(!otherdata.getBoolean("saved default item skins")) {
            final String[] defaultSkins = new String[] {
                    "DEATH_KNIGHT_SKULL_BLADE",
                    "FLAMING_HALO",
                    "JOLLY_CANDY_SWORD",
                    "KOALA",
                    "MEAT_CLEAVER_AXE",
                    "REINDEER_ANTLERS",
                    "SANTA_HAT",
            };
            for(String s : defaultSkins) {
                save("skins", s + ".yml");
            }
            otherdata.set("saved default item skins", true);
            saveOtherData();
        }

        gui = new UInventory(null, CONFIG.getInt("gui.size"), colorize(CONFIG.getString("gui.title")));
        skin = d(CONFIG, "item");
        appliedLore = colorize(CONFIG.getString("item.applied lore"));
        materials = new HashMap<>();
        for(String s : getConfigurationSectionKeys(CONFIG, "materials", false)) {
            materials.put(s, colorize(CONFIG.getString("materials." + s)));
        }

        cache = new HashMap<>();
        final List<ItemStack> list = new ArrayList<>();
        for(File f : getFilesInFolder(DATA_FOLDER + SEPARATOR + "skins")) {
            if(!f.getAbsoluteFile().getName().equals("_settings.yml")) {
                final ItemSkin skin = new FileItemSkin(f);
                list.add(getItemSkinItem(skin, false));
            }
        }
        sendConsoleDidLoadFeature("ItemSkinsAPI with x Item Skins", started);
    }
    public void unload() {
        if(isEnabled) {
            isEnabled = false;
            HandlerList.unregisterAll(this);
        }
    }

    public ItemStack getItemSkinItem(@NotNull ItemSkin skin, boolean fromCache) {
        if(fromCache) {
            return cache.getOrDefault(skin, null);
        }
        final String name = skin.getName(), material = getItemSkinMaterialString(skin);
        final ItemStack is = getClone(this.skin);
        itemMeta = is.getItemMeta();
        itemMeta.setDisplayName(itemMeta.getDisplayName().replace("{NAME}", name).replace("{MATERIAL}", material));
        lore.clear();
        for(String s : itemMeta.getLore()) {
            lore.add(s.replace("{NAME}", name).replace("{MATERIAL}", material));
        }
        itemMeta.setLore(lore);
        lore.clear();
        is.setItemMeta(itemMeta);
        cache.put(skin, is);
        return is;
    }
    public String getItemSkinMaterialString(@NotNull ItemSkin skin) {
        return materials.get(skin.getMaterial());
    }
    public ItemSkin valueOfItemSkin(@NotNull ItemStack is) {
        return isItemSkin(is) ? getItemSkin(getRPItemStackValue(is, "AppliedItemSkin")) : null;
    }
    public ItemSkin valueOfItemSkinApplied(@NotNull ItemStack is) {
        if(is != null && is.hasItemMeta() && is.getItemMeta().hasLore()) {
            final List<String> lore = is.getItemMeta().getLore();
            for(ItemSkin skin : getAllItemSkins().values()) {
                if(lore.contains(appliedLore.replace("{NAME}", skin.getName()))) {
                    return skin;
                }
            }
        }
        return null;
    }

    public boolean isItemSkin(@NotNull ItemStack is) {
        return getRPItemStackValue(is, "AppliedItemSkin") != null;
    }
    public boolean applyItemSkin(@NotNull ItemStack is, @NotNull ItemSkin skin) {
        if(isItemSkin(is) && is.getType().name().endsWith(skin.getMaterial())) {
            final ItemMeta meta = is.getItemMeta();
            final List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            lore.add(appliedLore.replace("{NAME}", skin.getName()));
            meta.setLore(lore); lore.clear();
            is.setItemMeta(meta);
            addRPItemStackValue(is, "AppliedItemSkin", skin.getIdentifier());
            return true;
        }
        return false;
    }
    public boolean removeItemSkin(@NotNull ItemStack is, @NotNull ItemSkin appliedSkin) {
        if(!isItemSkin(is)) {
            final ItemMeta meta = is.getItemMeta();
            final List<String> lore = meta.getLore();
            lore.remove(appliedLore.replace("{NAME}", appliedSkin.getName()));
            meta.setLore(lore);
            removeRPItemStackValue(is, "AppliedItemSkin");
            return true;
        }
        return false;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    private void inventoryClickEvent(InventoryClickEvent event) {
        final ItemStack current = event.getCurrentItem(), cursor = event.getCursor();
        final String click = event.getClick().name();
        if(current == null || current.getType().equals(Material.AIR) || !(click.contains("RIGHT") || click.contains("LEFT"))) {
            return;
        }
        final Player player = (Player) event.getWhoClicked();
        final ItemSkin skin = valueOfItemSkin(cursor), applied = valueOfItemSkinApplied(current);
        if(skin != null && applied == null) {
            if(applyItemSkin(current, skin)) {
                event.setCurrentItem(current);
                final int amount = cursor.getAmount();
                if(amount == 1) {
                    event.setCursor(new ItemStack(Material.AIR));
                } else {
                    cursor.setAmount(amount-1);
                }
            } else {
                return;
            }
        } else if(applied != null) {
            if(click.contains("RIGHT")) {
                removeItemSkin(current, applied);
                event.setCurrentItem(current);
                event.setCursor(getItemSkinItem(applied, true));
            } else {
                return;
            }
        } else {
            return;
        }
        event.setCancelled(true);
        player.updateInventory();
    }
}
