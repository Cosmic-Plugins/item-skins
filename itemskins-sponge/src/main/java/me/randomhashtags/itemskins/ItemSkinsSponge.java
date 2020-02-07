package me.randomhashtags.itemskins;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "itemskins",
        name = "ItemSkins",
        description = "Special item skins that change their texture to a custom one. Requires \"Custom Items\" (https://www.spigotmc.org/resources/6384) installed to work properly!",
        authors = {
                "RandomHashTags"
        }
)
public class ItemSkinsSponge {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
    }
}
