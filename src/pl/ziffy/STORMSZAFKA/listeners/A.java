// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.listeners;

import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import java.time.LocalDateTime;
import org.bukkit.Sound;
import pl.ziffy.STORMSZAFKA.pets.E;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import pl.ziffy.STORMSZAFKA.ui.gui.B;
import pl.ziffy.STORMSZAFKA.pets.editors.C;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.event.inventory.InventoryClickEvent;
import java.util.UUID;
import java.util.HashMap;
import org.bukkit.event.Listener;

public class A implements Listener
{
    private HashMap<UUID, Long> B;
    private static final long A = 200L;
    
    public A() {
        this.B = new HashMap<UUID, Long>();
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        String t = "§8Lista pet\u00f3w";
        final B menuConfigManager = Main.getMenuConfigManager();
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
        if (this.A(player.getUniqueId())) {
            return;
        }
        this.B(player.getUniqueId());
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
            b = menuConfigManager.B("previous_page", 48);
            b2 = menuConfigManager.B("return", 49);
            b3 = menuConfigManager.B("next_page", 50);
        }
        if (rawSlot == b && int1 > 1) {
            C.A(player, int1 - 1);
            return;
        }
        if (rawSlot == b2) {
            pl.ziffy.STORMSZAFKA.ui.menu.A.openMainMenu(player);
            return;
        }
        if (rawSlot == b3) {
            C.A(player, int1 + 1);
        }
    }
    
    private boolean A(final UUID uuid) {
        return this.B.containsKey(uuid) && System.currentTimeMillis() - this.B.get(uuid) < 200L;
    }
    
    private void B(final UUID key) {
        this.B.put(key, System.currentTimeMillis());
    }
    
    private void A(final Player player) {
        final E._A a = E.F.get(player.getUniqueId());
        if (a == null) {
            player.sendMessage(pl.ziffy.STORMSZAFKA.utils.B.A("&8» &7Nie masz &#FF0000aktywnego &7peta!"));
            return;
        }
        final String a2 = E.A(a.A);
        final int b = pl.ziffy.STORMSZAFKA.fragments.B.B(a2);
        final int a3 = pl.ziffy.STORMSZAFKA.fragments.B.A(player);
        if (a3 < b) {
            player.sendMessage(pl.ziffy.STORMSZAFKA.utils.B.A("&8» &7Nie masz wystarczaj\u0105cej ilo\u015bci &#FF0000serc&7! Potrzebujesz: &f" + b + "&7, masz: &f" + a3));
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
            return;
        }
        if (!pl.ziffy.STORMSZAFKA.fragments.B.B(player, b)) {
            player.sendMessage(pl.ziffy.STORMSZAFKA.utils.B.A("&8» &7B\u0142\u0105d podczas usuwania &#FF0000serc&7!"));
            return;
        }
        final String b2 = a.B;
        LocalDateTime localDateTime;
        if (a.F != null) {
            localDateTime = a.F.plusDays(1L);
        }
        else {
            localDateTime = LocalDateTime.now().plusDays(1L);
        }
        E.A(player, false, false);
        E.A(player, a2, b2, pl.ziffy.STORMSZAFKA.utils.time.A.A(localDateTime));
        player.sendMessage(pl.ziffy.STORMSZAFKA.utils.B.A("&8» &7Pomy\u015blnie przed\u0142u\u017cono peta o &f1 dzie\u0144 &#27FF00sukces&7!"));
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.5f);
        player.closeInventory();
        Bukkit.getScheduler().runTaskLater((Plugin)Main.getInstance(), () -> pl.ziffy.STORMSZAFKA.ui.menu.A.openMainMenu(player2), 2L);
    }
}
