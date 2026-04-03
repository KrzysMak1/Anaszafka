// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.listeners;

import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import java.time.LocalDateTime;
import org.bukkit.Sound;
import pl.ziffy.STORMSZAFKA.pets.PetsPetService4;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import pl.ziffy.STORMSZAFKA.ui.gui.ListenersListener2;
import pl.ziffy.STORMSZAFKA.pets.editors.ListenersListener3;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.event.inventory.InventoryClickEvent;
import java.util.UUID;
import java.util.HashMap;
import org.bukkit.event.Listener;

public class ListenersListener1 implements Listener
{
    private HashMap<UUID, Long> ListenersListener2;
    private static final long ListenersListener1 = 200L;
    
    public ListenersListener1() {
        this.ListenersListener2 = new HashMap<UUID, Long>();
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        String t = "§8Lista pet\u00f3w";
        final ListenersListener2 menuConfigManager = Main.getMenuConfigManager();
        if (menuConfigManager != null) {
            t = menuConfigManager.T();
        }
        final String title = inventoryClickEvent.getView().getTitle();
        if (!title.startsWith(t) || title.contains("\u1d18\u1d00\u0274\u1d07\u029f \u1d18\u1d07\u1d1b\u00f3\u1d21")) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        player.setItemOnCursor((ItemStack)null);
        if (inventoryClickEvent.isShiftClick() || inventoryClickEvent.getClick().isShiftClick() || inventoryClickEvent.getClick().name().contains("SHIFT") || inventoryClickEvent.getAction().name().contains("MOVE") || inventoryClickEvent.getAction().name().contains("COLLECT")) {
            return;
        }
        if (this.ListenersListener1(player.getUniqueId())) {
            return;
        }
        this.ListenersListener2(player.getUniqueId());
        int int1 = 1;
        if (title.contains("Strona ")) {
            try {
                int1 = Integer.parseInt(title.substring(title.indexOf("Strona ") + 7).trim());
            }
            catch (final Exception ex) {
                int1 = 1;
            }
        }
        final int rawSlot = inventoryClickEvent.getRawSlot();
        int b = 48;
        int b2 = 49;
        int b3 = 50;
        if (menuConfigManager != null) {
            b = menuConfigManager.ListenersListener2("previous_page", 48);
            b2 = menuConfigManager.ListenersListener2("return", 49);
            b3 = menuConfigManager.ListenersListener2("next_page", 50);
        }
        if (rawSlot == b && int1 > 1) {
            ListenersListener3.ListenersListener1(player, int1 - 1);
            return;
        }
        if (rawSlot == b2) {
            pl.ziffy.STORMSZAFKA.ui.menu.ListenersListener1.openMainMenu(player);
            return;
        }
        if (rawSlot == b3) {
            ListenersListener3.ListenersListener1(player, int1 + 1);
        }
    }
    
    private boolean ListenersListener1(final UUID uuid) {
        return this.ListenersListener2.containsKey(uuid) && System.currentTimeMillis() - this.ListenersListener2.get(uuid) < 200L;
    }
    
    private void ListenersListener2(final UUID key) {
        this.ListenersListener2.put(key, System.currentTimeMillis());
    }
    
    private void ListenersListener1(final Player player) {
        final E._A a = E.F.get(player.getUniqueId());
        if (a == null) {
            player.sendMessage(pl.ziffy.STORMSZAFKA.utils.ListenersListener2.ListenersListener1("&8» &7Nie masz &#FF0000aktywnego &7peta!"));
            return;
        }
        final String a2 = E.ListenersListener1(a.ListenersListener1);
        final int b = pl.ziffy.STORMSZAFKA.fragments.ListenersListener2.ListenersListener2(a2);
        final int a3 = pl.ziffy.STORMSZAFKA.fragments.ListenersListener2.ListenersListener1(player);
        if (a3 < b) {
            player.sendMessage(pl.ziffy.STORMSZAFKA.utils.ListenersListener2.ListenersListener1("&8» &7Nie masz wystarczaj\u0105cej ilo\u015bci &#FF0000serc&7! Potrzebujesz: &f" + b + "&7, masz: &f" + a3));
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
            return;
        }
        if (!pl.ziffy.STORMSZAFKA.fragments.ListenersListener2.ListenersListener2(player, b)) {
            player.sendMessage(pl.ziffy.STORMSZAFKA.utils.ListenersListener2.ListenersListener1("&8» &7B\u0142\u0105d podczas usuwania &#FF0000serc&7!"));
            return;
        }
        final String b2 = a.ListenersListener2;
        LocalDateTime localDateTime;
        if (a.F != null) {
            localDateTime = a.F.plusDays(1L);
        }
        else {
            localDateTime = LocalDateTime.now().plusDays(1L);
        }
        E.ListenersListener1(player, false, false);
        E.ListenersListener1(player, a2, b2, pl.ziffy.STORMSZAFKA.utils.time.ListenersListener1.ListenersListener1(localDateTime));
        player.sendMessage(pl.ziffy.STORMSZAFKA.utils.ListenersListener2.ListenersListener1("&8» &7Pomy\u015blnie przed\u0142u\u017cono peta o &f1 dzie\u0144 &#27FF00sukces&7!"));
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.5f);
        player.closeInventory();
        Bukkit.getScheduler().runTaskLater((Plugin)Main.getInstance(), () -> pl.ziffy.STORMSZAFKA.ui.menu.ListenersListener1.openMainMenu(player2), 2L);
    }
}
