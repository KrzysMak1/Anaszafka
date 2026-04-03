// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.regions;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class C implements Listener
{
    private final B B;
    private final A A;
    
    public C(final B b, final A a) {
        this.B = b;
        this.A = a;
    }
    
    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent playerInteractEvent) {
        final ItemStack item = playerInteractEvent.getItem();
        if (item == null || !this.A.A(item)) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        if (playerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK) {
            this.B.B(playerInteractEvent.getPlayer(), playerInteractEvent.getClickedBlock().getLocation());
        }
        else if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            this.B.A(playerInteractEvent.getPlayer(), playerInteractEvent.getClickedBlock().getLocation());
        }
    }
}
