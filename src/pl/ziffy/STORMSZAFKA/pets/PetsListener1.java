// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Iterator;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import pl.ziffy.STORMSZAFKA.messages.PetsPetService1;
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

public class PetsListener1 implements Listener
{
    private final Main PetsPetService1;
    
    public PetsListener1(final Main a) {
        this.PetsPetService1 = a;
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
        if (b && cursor != null && cursor.getType() == Material.PLAYER_HEAD && this.PetsPetService3(cursor)) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if ((inventoryClickEvent.getClick() == ClickType.SHIFT_LEFT || inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT) && currentItem != null && currentItem.getType() == Material.PLAYER_HEAD && this.PetsPetService3(currentItem)) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if (inventoryClickEvent.getClick() == ClickType.NUMBER_KEY && b) {
            final ItemStack item = inventoryClickEvent.getWhoClicked().getInventory().getItem(inventoryClickEvent.getHotbarButton());
            if (item != null && item.getType() == Material.PLAYER_HEAD && this.PetsPetService3(item)) {
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
        if (!this.PetsPetService3(cursor)) {
            return;
        }
        this.PetsPetService5((Player)inventoryClickEvent.getWhoClicked());
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
        if (this.PetsPetService3(item)) {
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
        if (!this.PetsPetService3(item)) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        this.PetsPetService5(player);
        this.PetsPetService1.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.PetsPetService1, () -> this.PetsPetService5(player2), 1L);
        ItemStack j = null;
        if (PetsPetService4.K(player)) {
            if (!this.PetsPetService1.getConfig().getBoolean("activation.allow_pet_swap", false)) {
                pl.ziffy.STORMSZAFKA.messages.PetsPetService1.PetsPetService4().PetsPetService1(player, "pet.already-active-item");
                return;
            }
            j = PetsPetService4.J(player);
            PetsPetService4.PetsPetService1(player, false, false);
        }
        final String b = this.PetsPetService2(item);
        if (b != null && this.PetsPetService2(b)) {
            pl.ziffy.STORMSZAFKA.messages.PetsPetService1.PetsPetService4().PetsPetService1(player, "pet.expired-item");
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
        final String a = this.PetsPetService1(item);
        if (a == null) {
            pl.ziffy.STORMSZAFKA.messages.PetsPetService1.PetsPetService4().PetsPetService1(player, "pet.invalid-type-item");
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
        final Main a2 = this.PetsPetService1;
        final PetsPetService6 petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null && !petConfigManager.H(a)) {
            pl.ziffy.STORMSZAFKA.messages.PetsPetService1.PetsPetService4().PetsPetService1(player, "pet.disabled-item", "pet_type", a);
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
        final String b2 = this.PetsPetService2(item);
        final String c = this.PetsListener1(item);
        boolean b3;
        if (b2 != null) {
            b3 = PetsPetService4.PetsPetService1(player, a, c, b2);
        }
        else {
            b3 = PetsPetService4.PetsPetService1(player, a, c);
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
            pl.ziffy.STORMSZAFKA.messages.PetsPetService1.PetsPetService4().PetsPetService1(player, "pet.activation-failed");
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
    
    private boolean PetsPetService3(final ItemStack itemStack) {
        if (!itemStack.hasItemMeta()) {
            return false;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        try {
            if (itemMeta.getPersistentDataContainer().has(new NamespacedKey((Plugin)this.PetsPetService1, "pet_type"), PersistentDataType.STRING)) {
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
    
    private String PetsPetService1(final ItemStack itemStack) {
        if (!itemStack.hasItemMeta()) {
            return null;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        try {
            final PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
            final NamespacedKey namespacedKey = new NamespacedKey((Plugin)this.PetsPetService1, "pet_type");
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
    
    private String PetsListener1(final ItemStack itemStack) {
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
    
    private String PetsPetService2(final ItemStack itemStack) {
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
    
    private boolean PetsPetService2(final String text) {
        try {
            return LocalDateTime.now().isAfter(LocalDateTime.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    private String PetsPetService1(final String s) {
        return "brak";
    }
    
    private void PetsPetService5(final Player player) {
        final boolean f = L.PetsPetService5(player);
        final ItemStack helmet = player.getInventory().getHelmet();
        if (helmet != null && helmet.getType() == Material.PLAYER_HEAD && this.PetsPetService3(helmet)) {
            if (f) {
                player.getInventory().setHelmet(this.PetsPetService2(player));
            }
            else {
                player.getInventory().setHelmet((ItemStack)null);
            }
        }
        final ItemStack chestplate = player.getInventory().getChestplate();
        if (chestplate != null && chestplate.getType() == Material.PLAYER_HEAD && this.PetsPetService3(chestplate)) {
            if (f) {
                player.getInventory().setChestplate(this.PetsPetService3(player));
            }
            else {
                player.getInventory().setChestplate((ItemStack)null);
            }
        }
        final ItemStack leggings = player.getInventory().getLeggings();
        if (leggings != null && leggings.getType() == Material.PLAYER_HEAD && this.PetsPetService3(leggings)) {
            if (f) {
                player.getInventory().setLeggings(this.PetsPetService4(player));
            }
            else {
                player.getInventory().setLeggings((ItemStack)null);
            }
        }
        final ItemStack boots = player.getInventory().getBoots();
        if (boots != null && boots.getType() == Material.PLAYER_HEAD && this.PetsPetService3(boots)) {
            if (f) {
                player.getInventory().setBoots(this.PetsListener1(player));
            }
            else {
                player.getInventory().setBoots((ItemStack)null);
            }
        }
    }
    
    private ItemStack PetsPetService2(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.LEATHER_HELMET);
        final LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        itemMeta.setDisplayName("§7Zbroja kostiumu");
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        itemStack.setItemMeta((ItemMeta)itemMeta);
        return itemStack;
    }
    
    private ItemStack PetsPetService3(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.LEATHER_CHESTPLATE);
        final LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        itemMeta.setDisplayName("§7Zbroja kostiumu");
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        itemStack.setItemMeta((ItemMeta)itemMeta);
        return itemStack;
    }
    
    private ItemStack PetsPetService4(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.LEATHER_LEGGINGS);
        final LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        itemMeta.setDisplayName("§7Zbroja kostiumu");
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        itemStack.setItemMeta((ItemMeta)itemMeta);
        return itemStack;
    }
    
    private ItemStack PetsListener1(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.LEATHER_BOOTS);
        final LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        itemMeta.setDisplayName("§7Zbroja kostiumu");
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        itemStack.setItemMeta((ItemMeta)itemMeta);
        return itemStack;
    }
}
