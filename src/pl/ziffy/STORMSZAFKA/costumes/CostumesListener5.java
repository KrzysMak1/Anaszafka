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

public class CostumesListener5 implements Listener
{
    private final Main CostumesCostumeService1;
    private boolean CostumesListener2;
    private boolean CostumesListener1;
    
    public CostumesListener5(final Main c) {
        this.CostumesCostumeService1 = c;
        this.CostumesListener1();
        if (this.CostumesListener2) {
            Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)c);
        }
    }
    
    private void CostumesListener1() {
        final ConfigurationSection configurationSection = this.CostumesCostumeService1.getConfig().getConfigurationSection("costumes.sakiewka_dropu");
        if (configurationSection == null) {
            this.CostumesListener2 = true;
            this.CostumesListener1 = false;
            return;
        }
        this.CostumesListener2 = configurationSection.getBoolean("enabled", true);
        this.CostumesListener1 = configurationSection.getBoolean("debug", false);
    }
    
    public void reloadConfig() {
        this.CostumesListener1();
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerDeath(final PlayerDeathEvent playerDeathEvent) {
        if (!this.CostumesListener2) {
            return;
        }
        final Player entity = playerDeathEvent.getEntity();
        if (!CostumesCostumeService6.CostumesListener4(entity)) {
            return;
        }
        final CostumesCostumeService4 playerArmorSnapshot = CostumesCostumeService5.getPlayerArmorSnapshot(entity.getUniqueId());
        if (playerArmorSnapshot == null) {
            return;
        }
        final List drops = playerDeathEvent.getDrops();
        final ArrayList list = new ArrayList(drops);
        for (int i = 0; i < list.size(); ++i) {
            final ItemStack itemStack = (ItemStack)list.get(i);
            if (itemStack != null) {
                if (this.CostumesListener1(itemStack)) {
                    final ItemStack a = this.CostumesListener1(itemStack, playerArmorSnapshot);
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
    
    private boolean CostumesListener1(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if ((itemStack.getType() == Material.PLAYER_HEAD || itemStack.getType() == Material.LEATHER_CHESTPLATE || itemStack.getType() == Material.LEATHER_LEGGINGS || itemStack.getType() == Material.LEATHER_BOOTS) && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            final String lowerCase = itemStack.getItemMeta().getDisplayName().toLowerCase();
            return lowerCase.contains("kostium") || lowerCase.contains("costume") || lowerCase.contains("zbroja") || lowerCase.contains("zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("zabojczego krolika") || lowerCase.contains("zbroja zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("walentynkowy") || lowerCase.contains("valentine") || lowerCase.contains("przeciwzaka\u017ceniowy") || lowerCase.contains("przeciwzakazeniowy") || lowerCase.contains("ma\u0142ego urwisa") || lowerCase.contains("malogo urwisa");
        }
        return false;
    }
    
    private ItemStack CostumesListener1(final ItemStack itemStack, final CostumesCostumeService4 i) {
        if (itemStack == null || i == null) {
            return null;
        }
        switch (CostumesListener5$1.CostumesListener1[itemStack.getType().ordinal()]) {
            case 1:
            case 2: {
                return i.CostumesCostumeService1();
            }
            case 3: {
                return i.CostumesCostumeService2();
            }
            case 4: {
                return i.CostumesListener2();
            }
            case 5: {
                return i.CostumesListener1();
            }
            default: {
                return null;
            }
        }
    }
}
