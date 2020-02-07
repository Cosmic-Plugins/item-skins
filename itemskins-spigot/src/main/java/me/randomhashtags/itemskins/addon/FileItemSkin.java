package me.randomhashtags.itemskins.addon;

import java.io.File;
import java.util.List;

public class FileItemSkin extends ItemSkinAddon implements ItemSkin {
    public FileItemSkin(File f) {
        load(f);
        register(Feature.ITEM_SKIN, this);
    }

    public String getIdentifier() {
        return getYamlName();
    }
    public String getName() {
        return getString(yml, "name");
    }
    public String getMaterial() {
        return getString(yml, "material").toUpperCase();
    }
    public List<String> getLore() {
        return getStringList(yml, "lore");
    }
    public List<String> getAttributes() {
        return getStringList(yml, "attributes");
    }
}

