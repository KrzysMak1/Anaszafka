// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.regions;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class RegionsListener1 implements Listener
{
    private final RegionsRegionService2 RegionsRegionService2;
    private final RegionsRegionService1 RegionsRegionService1;
    
    public RegionsListener1(final RegionsRegionService2 b, final RegionsRegionService1 a) {
        this.RegionsRegionService2 = b;
        this.RegionsRegionService1 = a;
    }
    
    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent playerInteractEvent) {
        final ItemStack item = playerInteractEvent.getItem();
        if (item == null || !this.RegionsRegionService1.RegionsRegionService1(item)) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        if (playerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK) {
            this.RegionsRegionService2.RegionsRegionService2(playerInteractEvent.getPlayer(), playerInteractEvent.getClickedBlock().getLocation());
        }
        else if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            this.RegionsRegionService2.RegionsRegionService1(playerInteractEvent.getPlayer(), playerInteractEvent.getClickedBlock().getLocation());
        }
    }
}
