// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class ListenersListener3 implements Listener
{
    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent playerInteractEvent) {
        final ItemStack itemInMainHand = playerInteractEvent.getPlayer().getInventory().getItemInMainHand();
        if (itemInMainHand == null || itemInMainHand.getItemMeta() == null) {
            return;
        }
        final ItemMeta itemMeta = itemInMainHand.getItemMeta();
        if (itemMeta.hasDisplayName()) {
            final String lowerCase = itemMeta.getDisplayName().toLowerCase();
            if ((!lowerCase.contains("head") && !lowerCase.contains("g\u0142owa")) || playerInteractEvent.getAction().toString().contains("RIGHT_CLICK")) {}
        }
    }
}
