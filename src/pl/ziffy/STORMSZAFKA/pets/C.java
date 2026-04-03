// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import pl.ziffy.STORMSZAFKA.costumes.L;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Iterator;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import pl.ziffy.STORMSZAFKA.messages.A;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.event.Listener;

public class C implements Listener
{
    private final Main A;
    
    public C(final Main a) {
        this.A = a;
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
        if (b && cursor != null && cursor.getType() == Material.PLAYER_HEAD && this.D(cursor)) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if ((inventoryClickEvent.getClick() == ClickType.SHIFT_LEFT || inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT) && currentItem != null && currentItem.getType() == Material.PLAYER_HEAD && this.D(currentItem)) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if (inventoryClickEvent.getClick() == ClickType.NUMBER_KEY && b) {
            final ItemStack item = inventoryClickEvent.getWhoClicked().getInventory().getItem(inventoryClickEvent.getHotbarButton());
            if (item != null && item.getType() == Material.PLAYER_HEAD && this.D(item)) {
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
        if (cursor == null || cursor.getType() != Material.PLAYER_HEAD) {
            return;
        }
        if (!this.D(cursor)) {
            return;
        }
        this.F((Player)inventoryClickEvent.getWhoClicked());
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerInteractLowest(final PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR && playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        final ItemStack item = playerInteractEvent.getItem();
        if (item == null || item.getType() != Material.PLAYER_HEAD) {
            return;
        }
        if (this.D(item)) {
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
        if (item == null || item.getType() != Material.PLAYER_HEAD) {
            return;
        }
        if (!this.D(item)) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        this.F(player);
        this.A.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.A, () -> this.F(player2), 1L);
        ItemStack j = null;
        if (E.K(player)) {
            if (!this.A.getConfig().getBoolean("activation.allow_pet_swap", false)) {
                pl.ziffy.STORMSZAFKA.messages.A.E().A(player, "pet.already-active-item");
                return;
            }
            j = E.J(player);
            E.A(player, false, false);
        }
        final String b = this.B(item);
        if (b != null && this.B(b)) {
            pl.ziffy.STORMSZAFKA.messages.A.E().A(player, "pet.expired-item");
            if (player.getInventory().getItemInMainHand().equals((Object)item)) {
                player.getInventory().setItemInMainHand((ItemStack)null);
            }
            else if (player.getInventory().getItemInOffHand().equals((Object)item)) {
                player.getInventory().setItemInOffHand((ItemStack)null);
            }
            if (j != null) {
                if (player.getInventory().getItemInMainHand() == null) {
                    player.getInventory().setItemInMainHand(j);
                }
                else {
                    player.getInventory().addItem(new ItemStack[] { j });
                }
            }
            return;
        }
        final String a = this.A(item);
        if (a == null) {
            pl.ziffy.STORMSZAFKA.messages.A.E().A(player, "pet.invalid-type-item");
            if (j != null) {
                if (player.getInventory().getItemInMainHand() == null) {
                    player.getInventory().setItemInMainHand(j);
                }
                else {
                    player.getInventory().addItem(new ItemStack[] { j });
                }
            }
            return;
        }
        final Main a2 = this.A;
        final G petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null && !petConfigManager.H(a)) {
            pl.ziffy.STORMSZAFKA.messages.A.E().A(player, "pet.disabled-item", "pet_type", a);
            if (j != null) {
                if (player.getInventory().getItemInMainHand() == null) {
                    player.getInventory().setItemInMainHand(j);
                }
                else {
                    player.getInventory().addItem(new ItemStack[] { j });
                }
            }
            return;
        }
        final String b2 = this.B(item);
        final String c = this.C(item);
        boolean b3;
        if (b2 != null) {
            b3 = E.A(player, a, c, b2);
        }
        else {
            b3 = E.A(player, a, c);
        }
        if (b3) {
            if (player.getInventory().getItemInMainHand().equals((Object)item)) {
                player.getInventory().setItemInMainHand(j);
            }
            else if (player.getInventory().getItemInOffHand().equals((Object)item)) {
                player.getInventory().setItemInOffHand(j);
            }
        }
        else {
            pl.ziffy.STORMSZAFKA.messages.A.E().A(player, "pet.activation-failed");
            if (j != null) {
                if (player.getInventory().getItemInMainHand() == null) {
                    player.getInventory().setItemInMainHand(j);
                }
                else {
                    player.getInventory().addItem(new ItemStack[] { j });
                }
            }
        }
    }
    
    private boolean D(final ItemStack itemStack) {
        if (!itemStack.hasItemMeta()) {
            return false;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        try {
            if (itemMeta.getPersistentDataContainer().has(new NamespacedKey((Plugin)this.A, "pet_type"), PersistentDataType.STRING)) {
                return true;
            }
        }
        catch (final Exception ex) {}
        if (!itemMeta.hasDisplayName()) {
            return false;
        }
        final String lowerCase = ChatColor.stripColor(itemMeta.getDisplayName()).toLowerCase();
        if (!lowerCase.contains("pet")) {
            return false;
        }
        final String[] array = { "cyber-obro\u0144ca", "cyber-obronca", "aniolek", "anio\u0142ek", "pancernik", "pudzianek", "p\u0119dziwiatr", "pedziwiatr", "g\u0142odomorek", "glodomorek", "skalniaczek", "biznesmen", "biznesmenik", "discordzik", "duszek", "nietoperek", "reniferek", "ba\u0142wanek", "balwanek", "golemik", "eustachy", "enderman", "zaj\u0105czek", "zajaczek", "pisklak", "cukiereczek", "rozdymek", "paj\u0105k", "pajak", "sowa", "drakula", "leniuszek", "elfik", "pierniczek", "paczu\u015b", "paczus", "telekr\u00f3lik", "telekrolik", "bobas" };
        for (int length = array.length, i = 0; i < length; ++i) {
            if (lowerCase.contains(array[i])) {
                return true;
            }
        }
        return false;
    }
    
    private String A(final ItemStack itemStack) {
        if (!itemStack.hasItemMeta()) {
            return null;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        try {
            final PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
            final NamespacedKey namespacedKey = new NamespacedKey((Plugin)this.A, "pet_type");
            if (persistentDataContainer.has(namespacedKey, PersistentDataType.STRING)) {
                return (String)persistentDataContainer.get(namespacedKey, PersistentDataType.STRING);
            }
        }
        catch (final Exception ex) {}
        if (!itemMeta.hasDisplayName()) {
            return null;
        }
        final String lowerCase = ChatColor.stripColor(itemMeta.getDisplayName()).toLowerCase();
        final String[] array = { "cyber-obro\u0144ca", "cyber-obronca", "aniolek", "anio\u0142ek", "pancernik", "pudzianek", "p\u0119dziwiatr", "pedziwiatr", "g\u0142odomorek", "glodomorek", "skalniaczek", "biznesmen", "biznesmenik", "discordzik", "duszek", "nietoperek", "reniferek", "ba\u0142wanek", "balwanek", "golemik", "eustachy", "enderman", "zaj\u0105czek", "zajaczek", "pisklak", "cukiereczek", "rozdymek", "paj\u0105k", "pajak", "sowa", "drakula", "leniuszek", "elfik", "pierniczek", "paczu\u015b", "paczus", "telekr\u00f3lik", "telekrolik", "bobas" };
        final int length = array.length;
        int i = 0;
        while (i < length) {
            final String s = array[i];
            if (lowerCase.contains(s)) {
                final String s2 = s;
                switch (s2) {
                    case "cyber-obro\u0144ca": {
                        return "cyber-obronca";
                    }
                    case "anio\u0142ek": {
                        return "aniolek";
                    }
                    case "p\u0119dziwiatr": {
                        return "pedziwiatr";
                    }
                    case "g\u0142odomorek": {
                        return "glodomorek";
                    }
                    case "biznesmen": {
                        return "biznesmenik";
                    }
                    case "ba\u0142wanek": {
                        return "balwanek";
                    }
                    case "zaj\u0105czek":
                    case "zajaczek": {
                        return "zaj\u0105czek";
                    }
                    case "paj\u0105k": {
                        return "pajak";
                    }
                    case "paczu\u015b": {
                        return "paczus";
                    }
                    case "telekr\u00f3lik": {
                        return "telekrolik";
                    }
                    default: {
                        return s;
                    }
                }
            }
            else {
                ++i;
            }
        }
        return null;
    }
    
    private String C(final ItemStack itemStack) {
        if (!itemStack.hasItemMeta() || !itemStack.getItemMeta().hasDisplayName()) {
            return "brak";
        }
        final String stripColor = ChatColor.stripColor(itemStack.getItemMeta().getDisplayName());
        if (stripColor.contains("NA ZAWSZE")) {
            return "brak";
        }
        final String[] split = stripColor.split(" ");
        for (int i = 0; i < split.length - 1; ++i) {
            final String s = split[i];
            final String s2 = split[i + 1];
            if (s.matches("\\d+")) {
                final String s3 = s;
                if (s2.contains("dzie\u0144") || s2.contains("dni")) {
                    return s3;
                }
                if (s2.contains("godzin") || s2.contains("godziny")) {
                    return s3;
                }
                if (s2.contains("minut") || s2.contains("minuty")) {
                    return s3;
                }
                if (s2.contains("sekund") || s2.contains("sekundy")) {
                    return s3;
                }
            }
        }
        return "brak";
    }
    
    private String B(final ItemStack itemStack) {
        if (!itemStack.hasItemMeta() || !itemStack.getItemMeta().hasLore()) {
            return null;
        }
        final Iterator iterator = itemStack.getItemMeta().getLore().iterator();
        while (iterator.hasNext()) {
            final String stripColor = ChatColor.stripColor((String)iterator.next());
            if (stripColor.contains("Pet wyga\u015bnie:")) {
                return stripColor.replace("Pet wyga\u015bnie:", "").trim();
            }
        }
        return null;
    }
    
    private boolean B(final String text) {
        try {
            return LocalDateTime.now().isAfter(LocalDateTime.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    private String A(final String s) {
        return "brak";
    }
    
    private void F(final Player player) {
        final boolean f = L.F(player);
        final ItemStack helmet = player.getInventory().getHelmet();
        if (helmet != null && helmet.getType() == Material.PLAYER_HEAD && this.D(helmet)) {
            if (f) {
                player.getInventory().setHelmet(this.B(player));
            }
            else {
                player.getInventory().setHelmet((ItemStack)null);
            }
        }
        final ItemStack chestplate = player.getInventory().getChestplate();
        if (chestplate != null && chestplate.getType() == Material.PLAYER_HEAD && this.D(chestplate)) {
            if (f) {
                player.getInventory().setChestplate(this.D(player));
            }
            else {
                player.getInventory().setChestplate((ItemStack)null);
            }
        }
        final ItemStack leggings = player.getInventory().getLeggings();
        if (leggings != null && leggings.getType() == Material.PLAYER_HEAD && this.D(leggings)) {
            if (f) {
                player.getInventory().setLeggings(this.E(player));
            }
            else {
                player.getInventory().setLeggings((ItemStack)null);
            }
        }
        final ItemStack boots = player.getInventory().getBoots();
        if (boots != null && boots.getType() == Material.PLAYER_HEAD && this.D(boots)) {
            if (f) {
                player.getInventory().setBoots(this.C(player));
            }
            else {
                player.getInventory().setBoots((ItemStack)null);
            }
        }
    }
    
    private ItemStack B(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.LEATHER_HELMET);
        final LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        itemMeta.setDisplayName("§7Zbroja kostiumu");
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        itemStack.setItemMeta((ItemMeta)itemMeta);
        return itemStack;
    }
    
    private ItemStack D(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.LEATHER_CHESTPLATE);
        final LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        itemMeta.setDisplayName("§7Zbroja kostiumu");
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        itemStack.setItemMeta((ItemMeta)itemMeta);
        return itemStack;
    }
    
    private ItemStack E(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.LEATHER_LEGGINGS);
        final LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        itemMeta.setDisplayName("§7Zbroja kostiumu");
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        itemStack.setItemMeta((ItemMeta)itemMeta);
        return itemStack;
    }
    
    private ItemStack C(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.LEATHER_BOOTS);
        final LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        itemMeta.setDisplayName("§7Zbroja kostiumu");
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        itemStack.setItemMeta((ItemMeta)itemMeta);
        return itemStack;
    }
}
