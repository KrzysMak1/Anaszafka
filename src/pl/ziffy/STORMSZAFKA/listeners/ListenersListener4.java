// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.listeners;

import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import java.util.Iterator;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import java.util.HashSet;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.UUID;
import java.util.Set;
import org.bukkit.event.Listener;

public class ListenersListener4 implements Listener
{
    private final Set<UUID> ListenersListener2;
    private final JavaPlugin ListenersListener1;
    
    public ListenersListener4() {
        this.ListenersListener2 = new HashSet<UUID>();
        this.ListenersListener1 = (JavaPlugin)Bukkit.getPluginManager().getPlugin("STORMSZAFKA");
        Bukkit.getScheduler().runTaskTimer((Plugin)this.ListenersListener1, () -> {
            Bukkit.getOnlinePlayers().iterator();
            final Iterator iterator;
            while (iterator.hasNext()) {
                final Player player = iterator.next();
                if (player.getOpenInventory().getType() == InventoryType.CRAFTING && !player.hasMetadata("inventory_open_main") && !player.hasMetadata("right_clicked")) {
                    player.setMetadata("inventory_open_main", (MetadataValue)new FixedMetadataValue((Plugin)this.ListenersListener1, (Object)true));
                }
            }
        }, 5L, 5L);
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerInteract(final PlayerInteractEvent playerInteractEvent) {
        final Player player = playerInteractEvent.getPlayer();
        if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR || playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            player.setMetadata("right_clicked", (MetadataValue)new FixedMetadataValue((Plugin)this.ListenersListener1, (Object)true));
            Bukkit.getScheduler().runTaskLater((Plugin)this.ListenersListener1, () -> {
                if (player2.isOnline() && player2.hasMetadata("right_clicked")) {
                    player2.removeMetadata("right_clicked", (Plugin)this.ListenersListener1);
                }
            }, 5L);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClose(final InventoryCloseEvent inventoryCloseEvent) {
        if (!(inventoryCloseEvent.getPlayer() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryCloseEvent.getPlayer();
        if (inventoryCloseEvent.getView().getType() == InventoryType.CRAFTING && player.hasMetadata("inventory_open_main")) {
            player.removeMetadata("inventory_open_main", (Plugin)this.ListenersListener1);
        }
    }
}
