// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

import org.bukkit.Material;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import java.util.Collection;
import java.util.ArrayList;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.event.Listener;

public class H implements Listener
{
    private final Main C;
    private boolean B;
    private boolean A;
    
    public H(final Main c) {
        this.C = c;
        this.A();
        if (this.B) {
            Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)c);
        }
    }
    
    private void A() {
        final ConfigurationSection configurationSection = this.C.getConfig().getConfigurationSection("costumes.sakiewka_dropu");
        if (configurationSection == null) {
            this.B = true;
            this.A = false;
            return;
        }
        this.B = configurationSection.getBoolean("enabled", true);
        this.A = configurationSection.getBoolean("debug", false);
    }
    
    public void reloadConfig() {
        this.A();
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerDeath(final PlayerDeathEvent playerDeathEvent) {
        if (!this.B) {
            return;
        }
        final Player entity = playerDeathEvent.getEntity();
        if (!L.F(entity)) {
            return;
        }
        final I playerArmorSnapshot = J.getPlayerArmorSnapshot(entity.getUniqueId());
        if (playerArmorSnapshot == null) {
            return;
        }
        final List drops = playerDeathEvent.getDrops();
        final ArrayList list = new ArrayList(drops);
        for (int i = 0; i < list.size(); ++i) {
            final ItemStack itemStack = (ItemStack)list.get(i);
            if (itemStack != null) {
                if (this.A(itemStack)) {
                    final ItemStack a = this.A(itemStack, playerArmorSnapshot);
                    if (a != null) {
                        final int index = drops.indexOf(itemStack);
                        if (index != -1) {
                            drops.set(index, a);
                        }
                    }
                }
            }
        }
    }
    
    private boolean A(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if ((itemStack.getType() == Material.PLAYER_HEAD || itemStack.getType() == Material.LEATHER_CHESTPLATE || itemStack.getType() == Material.LEATHER_LEGGINGS || itemStack.getType() == Material.LEATHER_BOOTS) && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            final String lowerCase = itemStack.getItemMeta().getDisplayName().toLowerCase();
            return lowerCase.contains("kostium") || lowerCase.contains("costume") || lowerCase.contains("zbroja") || lowerCase.contains("zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("zabojczego krolika") || lowerCase.contains("zbroja zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("walentynkowy") || lowerCase.contains("valentine") || lowerCase.contains("przeciwzaka\u017ceniowy") || lowerCase.contains("przeciwzakazeniowy") || lowerCase.contains("ma\u0142ego urwisa") || lowerCase.contains("malogo urwisa");
        }
        return false;
    }
    
    private ItemStack A(final ItemStack itemStack, final I i) {
        if (itemStack == null || i == null) {
            return null;
        }
        switch (H$1.A[itemStack.getType().ordinal()]) {
            case 1:
            case 2: {
                return i.C();
            }
            case 3: {
                return i.E();
            }
            case 4: {
                return i.B();
            }
            case 5: {
                return i.A();
            }
            default: {
                return null;
            }
        }
    }
}
