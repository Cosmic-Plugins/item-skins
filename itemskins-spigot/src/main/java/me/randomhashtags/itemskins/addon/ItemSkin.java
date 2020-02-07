package me.randomhashtags.itemskins.addon;

import me.randomhashtags.itemskins.addon.util.Attributable;
import me.randomhashtags.itemskins.addon.util.Nameable;

import java.util.List;

public interface ItemSkin extends Nameable, Attributable {
    String getMaterial();
    List<String> getLore();
}
