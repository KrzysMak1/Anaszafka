// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Iterator;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import pl.ziffy.STORMSZAFKA.messages.CostumesListener1;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.event.Listener;

public class CostumesListener3 implements Listener
{
    private final Main CostumesListener1;
    
    public CostumesListener3(final Main a) {
        this.CostumesListener1 = a;
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final int slot = inventoryClickEvent.getSlot();
        final boolean b = slot >= 36 && slot <= 39;
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        final ItemStack cursor = inventoryClickEvent.getCursor();
        if (b && cursor != null && cursor.hasItemMeta() && this.CostumesCostumeService1(cursor)) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if ((inventoryClickEvent.getClick() == ClickType.SHIFT_LEFT || inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT) && currentItem != null && currentItem.hasItemMeta() && this.CostumesCostumeService1(currentItem)) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if (inventoryClickEvent.getClick() == ClickType.NUMBER_KEY && b) {
            final ItemStack item = inventoryClickEvent.getWhoClicked().getInventory().getItem(inventoryClickEvent.getHotbarButton());
            if (item != null && item.hasItemMeta() && this.CostumesCostumeService1(item)) {
                inventoryClickEvent.setCancelled(true);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClickMonitor(final InventoryClickEvent inventoryClickEvent) {
        if (inventoryClickEvent.isCancelled()) {
            return;
        }
        final int slot = inventoryClickEvent.getSlot();
        if (slot != 36 && slot != 37 && slot != 38 && slot != 39) {
            return;
        }
        final ItemStack cursor = inventoryClickEvent.getCursor();
        if (cursor == null || !cursor.hasItemMeta()) {
            return;
        }
        if (!this.CostumesCostumeService1(cursor)) {
            return;
        }
        this.CostumesListener2((Player)inventoryClickEvent.getWhoClicked());
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerInteractLowest(final PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR && playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        final ItemStack item = playerInteractEvent.getItem();
        if (item == null || !item.hasItemMeta()) {
            return;
        }
        if (this.CostumesCostumeService1(item)) {
            playerInteractEvent.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(final PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR && playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        final Player player = playerInteractEvent.getPlayer();
        final ItemStack item = playerInteractEvent.getItem();
        if (item == null) {
            return;
        }
        if (item.getType().name().contains("SHULKER_BOX") && "wampir".equals(CostumesCostumeService6.CostumesListener3(player))) {
            return;
        }
        if (!this.CostumesCostumeService1(item)) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        this.CostumesListener2(player);
        this.CostumesListener1.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.CostumesListener1, () -> this.CostumesListener2(player2), 1L);
        ItemStack e = null;
        if (CostumesCostumeService6.CostumesListener4(player)) {
            if (!this.CostumesListener1.getConfig().getBoolean("activation.allow_costume_swap", false)) {
                pl.ziffy.STORMSZAFKA.messages.CostumesListener1.CostumesCostumeService2().CostumesListener1(player, "costume.already-active-item");
                return;
            }
            e = CostumesCostumeService6.CostumesCostumeService2(player);
            CostumesCostumeService6.CostumesListener1(player, false, false);
        }
        final String a = this.CostumesListener1(item);
        if (a != null && this.CostumesListener1(a)) {
            pl.ziffy.STORMSZAFKA.messages.CostumesListener1.CostumesCostumeService2().CostumesListener1(player, "costume.expired-item");
            if (player.getInventory().getItemInMainHand().equals((Object)item)) {
                player.getInventory().setItemInMainHand((ItemStack)null);
            }
            else if (player.getInventory().getItemInOffHand().equals((Object)item)) {
                player.getInventory().setItemInOffHand((ItemStack)null);
            }
            if (e != null) {
                CostumesCostumeService6.CostumesListener1(player, e);
            }
            return;
        }
        final String d = this.CostumesListener3(item);
        if (d == null) {
            pl.ziffy.STORMSZAFKA.messages.CostumesListener1.CostumesCostumeService2().CostumesListener1(player, "costume.invalid-type-item");
            if (e != null) {
                CostumesCostumeService6.CostumesListener1(player, e);
            }
            return;
        }
        final String a2 = this.CostumesListener1(item);
        final String b = this.CostumesListener2(item);
        boolean b2;
        if (a2 != null) {
            b2 = CostumesCostumeService6.CostumesListener1(player, d, b, a2);
        }
        else {
            b2 = CostumesCostumeService6.CostumesListener1(player, d, b);
        }
        if (b2) {
            if (player.getInventory().getItemInMainHand().equals((Object)item)) {
                player.getInventory().setItemInMainHand(e);
            }
            else if (player.getInventory().getItemInOffHand().equals((Object)item)) {
                player.getInventory().setItemInOffHand(e);
            }
        }
        else {
            pl.ziffy.STORMSZAFKA.messages.CostumesListener1.CostumesCostumeService2().CostumesListener1(player, "costume.activation-failed");
            if (e != null) {
                CostumesCostumeService6.CostumesListener1(player, e);
            }
        }
    }
    
    private boolean CostumesCostumeService1(final ItemStack itemStack) {
        if (!itemStack.hasItemMeta()) {
            return false;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        try {
            if (itemMeta.getPersistentDataContainer().has(new NamespacedKey((Plugin)this.CostumesListener1, "costume_type"), PersistentDataType.STRING)) {
                return true;
            }
        }
        catch (final Exception ex) {}
        if (!itemMeta.hasDisplayName()) {
            return false;
        }
        final String lowerCase = ChatColor.stripColor(itemStack.getItemMeta().getDisplayName()).toLowerCase();
        if (!lowerCase.contains("kostium")) {
            return false;
        }
        if (lowerCase.startsWith("zbroja")) {
            return false;
        }
        final String[] array = { "zab\u00f3jczego kr\u00f3lika", "zabojczego krolika", "walentynkowy", "przeciwzaka\u017ceniowy", "przeciwzakazeniowy", "ma\u0142ego urwisa", "malogo urwisa", "pirata", "nurka g\u0142\u0119binowego", "nurka glebinowego", "mima", "wampira", "wampir" };
        for (int length = array.length, i = 0; i < length; ++i) {
            if (lowerCase.contains(array[i])) {
                return true;
            }
        }
        return false;
    }
    
    private String CostumesListener3(final ItemStack itemStack) {
        if (!itemStack.hasItemMeta()) {
            return null;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        try {
            final PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
            final NamespacedKey namespacedKey = new NamespacedKey((Plugin)this.CostumesListener1, "costume_type");
            if (persistentDataContainer.has(namespacedKey, PersistentDataType.STRING)) {
                return (String)persistentDataContainer.get(namespacedKey, PersistentDataType.STRING);
            }
        }
        catch (final Exception ex) {}
        if (!itemMeta.hasDisplayName()) {
            return null;
        }
        final String lowerCase = ChatColor.stripColor(itemMeta.getDisplayName()).toLowerCase();
        if (lowerCase.contains("zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("zabojczego krolika")) {
            return "zabojczykrolik";
        }
        if (lowerCase.contains("walentynkowy")) {
            return "walentynkowy";
        }
        if (lowerCase.contains("przeciwzaka\u017ceniowy") || lowerCase.contains("przeciwzakazeniowy")) {
            return "przeciwzakazeniowy";
        }
        if (lowerCase.contains("ma\u0142ego urwisa") || lowerCase.contains("malogo urwisa")) {
            return "malyurwis";
        }
        if (lowerCase.contains("pirata")) {
            return "pirata";
        }
        if (lowerCase.contains("nurka g\u0142\u0119binowego") || lowerCase.contains("nurka glebinowego")) {
            return "nurekglebinowy";
        }
        if (lowerCase.contains("mima")) {
            return "mima";
        }
        if (lowerCase.contains("wampira") || lowerCase.contains("wampir")) {
            return "wampir";
        }
        return null;
    }
    
    private String CostumesListener2(final ItemStack itemStack) {
        if (!itemStack.hasItemMeta() || !itemStack.getItemMeta().hasDisplayName()) {
            return "brak";
        }
        final String stripColor = ChatColor.stripColor(itemStack.getItemMeta().getDisplayName());
        if (stripColor.contains("NA ZAWSZE") || stripColor.contains("ZAWSZE")) {
            return "INFINITE";
        }
        final String[] split = stripColor.split(" ");
        for (int i = 0; i < split.length - 1; ++i) {
            final String s = split[i];
            final String s2 = split[i + 1];
            if (s.matches("\\d+")) {
                final String s3 = s;
                if (s2.equals("dzie\u0144") || s2.equals("dni")) {
                    return s3;
                }
                if (s2.equals("godzina") || s2.equals("godziny") || s2.equals("godzin")) {
                    return s3;
                }
                if (s2.equals("minuta") || s2.equals("minuty") || s2.equals("minut")) {
                    return s3;
                }
                if (s2.equals("sekunda") || s2.equals("sekundy") || s2.equals("sekund")) {
                    return s3;
                }
            }
        }
        return "brak";
    }
    
    private String CostumesListener1(final ItemStack itemStack) {
        if (!itemStack.hasItemMeta() || !itemStack.getItemMeta().hasLore()) {
            return null;
        }
        final Iterator iterator = itemStack.getItemMeta().getLore().iterator();
        while (iterator.hasNext()) {
            final String stripColor = ChatColor.stripColor((String)iterator.next());
            if (stripColor.contains("Kostium wyga\u015bnie:")) {
                return stripColor.replace("Kostium wyga\u015bnie:", "").trim();
            }
        }
        return null;
    }
    
    private boolean CostumesListener1(final String text) {
        try {
            return LocalDateTime.now().isAfter(LocalDateTime.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    private void CostumesListener2(final Player player) {
        final ItemStack helmet = player.getInventory().getHelmet();
        if (helmet != null && this.CostumesCostumeService1(helmet)) {
            player.getInventory().setHelmet((ItemStack)null);
        }
        final ItemStack chestplate = player.getInventory().getChestplate();
        if (chestplate != null && this.CostumesCostumeService1(chestplate)) {
            player.getInventory().setChestplate((ItemStack)null);
        }
        final ItemStack leggings = player.getInventory().getLeggings();
        if (leggings != null && this.CostumesCostumeService1(leggings)) {
            player.getInventory().setLeggings((ItemStack)null);
        }
        final ItemStack boots = player.getInventory().getBoots();
        if (boots != null && this.CostumesCostumeService1(boots)) {
            player.getInventory().setBoots((ItemStack)null);
        }
    }
}
