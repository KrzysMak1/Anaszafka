// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.utils;

import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import java.text.SimpleDateFormat;
import pl.ziffy.STORMSZAFKA.Main;
import java.util.Collection;
import pl.ziffy.STORMSZAFKA.pets.PetsPetService4;
import java.util.Iterator;
import java.util.Map;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import java.util.UUID;
import java.util.HashMap;
import pl.ziffy.STORMSZAFKA.ui.gui.UtilsUtilityService1;
import org.bukkit.event.Listener;

public class UtilsListener1 implements Listener
{
    private static final String E = "§8StormSzafka v1.0";
    private static final int UtilsUtilityService2 = 27;
    private static UtilsUtilityService1 UtilsUtilityService1;
    private static HashMap<UUID, Inventory> UtilsUtilityService3;
    private static final String[] UtilsListener1;
    
    public static void setConfigManager(final UtilsUtilityService1 b) {
        pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService1 = b;
    }
    
    public static void openGui(final Player player) {
        if (pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService3.containsKey(player.getUniqueId())) {
            player.openInventory((Inventory)pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService3.get(player.getUniqueId()));
            return;
        }
        String s = "§8StormSzafka v1.0";
        int n = 27;
        if (pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService1 != null) {
            final String q = pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService1.Q();
            final int n2 = pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService1.N();
            if (q != null && !q.isEmpty()) {
                s = q;
            }
            if (n2 > 0) {
                n = n2;
            }
        }
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, n, s);
        UtilsListener1(inventory, player);
        if (pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService1 != null) {
            UtilsListener1(inventory, pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService1.K());
        }
        final ItemStack itemStack = new ItemStack(Material.RED_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cWy\u0142\u0105cz przed\u0142u\u017canie kostium\u00f3w"));
        final ArrayList lore = new ArrayList();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7Kliknij, aby wy\u0142\u0105czy\u0107"));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&7przed\u0142u\u017canie kostium\u00f3w dla wszystkich."));
        itemMeta.setLore((List)lore);
        inventory.setItem(47, itemStack);
        final ItemStack itemStack2 = new ItemStack(Material.BARRIER);
        itemStack2.getItemMeta().setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cPowr\u00f3t"));
        inventory.setItem(49, itemStack2);
        final ItemStack itemStack3 = new ItemStack(Material.RED_DYE);
        final ItemMeta itemMeta2 = itemStack3.getItemMeta();
        itemMeta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cWy\u0142\u0105cz przed\u0142u\u017canie pet\u00f3w"));
        final ArrayList lore2 = new ArrayList();
        lore2.add(ChatColor.translateAlternateColorCodes('&', "&7Kliknij, aby wy\u0142\u0105czy\u0107"));
        lore2.add(ChatColor.translateAlternateColorCodes('&', "&7przed\u0142u\u017canie pet\u00f3w dla wszystkich."));
        itemMeta2.setLore((List)lore2);
        inventory.setItem(51, itemStack3);
        pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService3.put(player.getUniqueId(), inventory);
        player.openInventory(inventory);
    }
    
    private static void UtilsListener1(final Inventory inventory, final Player player) {
        for (int n = 0; n < pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsListener1.length && n < inventory.getSize(); ++n) {
            if (inventory.getItem(n) == null) {
                final ItemStack a = UtilsListener1(pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsListener1[n], player);
                if (a != null) {
                    inventory.setItem(n, a);
                }
            }
        }
    }
    
    private static void UtilsListener1(final Inventory inventory, final HashMap<List<Integer>, ItemStack> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        for (final Map.Entry entry : hashMap.entrySet()) {
            final List list = (List)entry.getKey();
            final ItemStack itemStack = (ItemStack)entry.getValue();
            for (final int intValue : list) {
                if (intValue >= 0 && intValue < inventory.getSize()) {
                    inventory.setItem(intValue, itemStack);
                }
            }
        }
    }
    
    private static ItemStack UtilsListener1(final String anotherString, final Player player) {
        boolean b = false;
        String s = "brak";
        if (pl.ziffy.STORMSZAFKA.pets.PetsPetService4.K(player)) {
            final String g = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.G(player);
            if (g != null && g.equalsIgnoreCase(anotherString)) {
                b = true;
                final E._A a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.F.get(player.getUniqueId());
                if (a != null && a.UtilsUtilityService1 != null) {
                    s = a.UtilsUtilityService1;
                }
                else {
                    s = pl.ziffy.STORMSZAFKA.utils.time.UtilsListener1.UtilsUtilityService1();
                }
            }
        }
        else {
            s = pl.ziffy.STORMSZAFKA.utils.time.UtilsListener1.UtilsUtilityService1();
        }
        final String lowerCase = anotherString.toLowerCase();
        ItemStack itemStack = null;
        switch (lowerCase) {
            case "pedziwiatr": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.Q(s);
                break;
            }
            case "aniolek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.V(s);
                break;
            }
            case "pancernik": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.H(s);
                break;
            }
            case "pudzianek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.P(s);
                break;
            }
            case "glodomorek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.N(s);
                break;
            }
            case "skalniaczek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.S(s);
                break;
            }
            case "biznesmenik": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.a(s);
                break;
            }
            case "discordzik": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.L(s);
                break;
            }
            case "duszek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.UtilsUtilityService2(s);
                break;
            }
            case "nietoperek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.b(s);
                break;
            }
            case "reniferek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.Z(s);
                break;
            }
            case "balwanek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.J(s);
                break;
            }
            case "golemik": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.R(s);
                break;
            }
            case "eustachy": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.M(s);
                break;
            }
            case "enderman": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.U(s);
                break;
            }
            case "zajaczek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.E(s);
                break;
            }
            case "pisklak": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.UtilsUtilityService1(s);
                break;
            }
            case "cukiereczek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.UtilsListener1(s);
                break;
            }
            case "rozdymek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4._(s);
                break;
            }
            case "pajak": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.W(s);
                break;
            }
            case "sowa": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.d(s);
                break;
            }
            case "drakula": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.c(s);
                break;
            }
            case "leniuszek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.G(s);
                break;
            }
            case "elfik": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.T(s);
                break;
            }
            case "pierniczek": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.UtilsUtilityService3(s);
                break;
            }
            case "paczus": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.I(s);
                break;
            }
            case "telekrolik": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.O(s);
                break;
            }
            case "bobas": {
                itemStack = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.X(s);
                break;
            }
            default: {
                return null;
            }
        }
        if (itemStack != null && itemStack.hasItemMeta() && itemStack.getItemMeta().hasLore()) {
            final ItemMeta itemMeta = itemStack.getItemMeta();
            final ArrayList lore = new ArrayList(itemMeta.getLore());
            lore.removeIf(s2 -> ChatColor.stripColor(s2).contains("Kliknij prawym"));
            if (b) {
                lore.add((Object)pl.ziffy.STORMSZAFKA.pets.PetsPetService4.Y("&cKliknij prawym, aby zdj\u0105\u0107!"));
            }
            else {
                lore.add((Object)pl.ziffy.STORMSZAFKA.pets.PetsPetService4.Y("&aKliknij prawym, aby aktywowa\u0107!"));
            }
            if (b && Main.savedPetMap.containsKey(player.getUniqueId())) {
                final pl.ziffy.STORMSZAFKA.pets.UtilsListener1 a2 = Main.savedPetMap.get(player.getUniqueId());
                if (a2.UtilsUtilityService1 != null && !a2.UtilsUtilityService1.equals("INFINITE")) {
                    try {
                        lore.add((Object)pl.ziffy.STORMSZAFKA.pets.PetsPetService4.Y("&8» &7Wygasa: &c" + pl.ziffy.STORMSZAFKA.utils.time.UtilsListener1.UtilsUtilityService2(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(a2.UtilsUtilityService1))));
                    }
                    catch (final Exception ex) {}
                }
            }
            itemMeta.setLore((List)lore);
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        String anObject = "§8StormSzafka v1.0";
        if (pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService1 != null) {
            final String q = pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService1.Q();
            if (q != null && !q.isEmpty()) {
                anObject = q;
            }
        }
        if (!inventoryClickEvent.getView().getTitle().equals(anObject)) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if (currentItem == null || !currentItem.hasItemMeta() || !currentItem.getItemMeta().hasDisplayName()) {
            return;
        }
        final String displayName = currentItem.getItemMeta().getDisplayName();
        final String[] a = pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsListener1;
        final int length = a.length;
        int i = 0;
        while (i < length) {
            final String anotherString = a[i];
            if (displayName.toLowerCase().contains(anotherString.toLowerCase()) || displayName.toLowerCase().contains(anotherString.replace("\u0105", "a").replace("\u0119", "e").replace("\u0142", "l").replace("\u0107", "c").replace("\u0144", "n").replace("\u00f3", "o").replace("\u015b", "s").replace("\u017a", "z").replace("\u017c", "z"))) {
                if (!pl.ziffy.STORMSZAFKA.pets.PetsPetService4.K(player)) {
                    break;
                }
                final String g = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.G(player);
                if (g != null && g.equalsIgnoreCase(anotherString)) {
                    pl.ziffy.STORMSZAFKA.pets.PetsPetService4.L(player);
                    Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> {
                        if (player2.isOnline() && player2.getOpenInventory() != null) {
                            openGui(player2);
                        }
                    }, 1L);
                    return;
                }
                break;
            }
            else {
                ++i;
            }
        }
        if (inventoryClickEvent.getSlot() == 47 && currentItem.getType() == Material.RED_DYE) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cTa funkcja zostanie wprowadzona w nast\u0119pnych aktualizacjach!"));
            return;
        }
        if (inventoryClickEvent.getSlot() == 49 && currentItem.getType() == Material.BARRIER) {
            player.closeInventory();
            return;
        }
        if (inventoryClickEvent.getSlot() == 51 && currentItem.getType() == Material.RED_DYE) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cTa funkcja zostanie wprowadzona w nast\u0119pnych aktualizacjach!"));
        }
    }
    
    @EventHandler
    public void onInventoryClose(final InventoryCloseEvent inventoryCloseEvent) {
        if (!(inventoryCloseEvent.getPlayer() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryCloseEvent.getPlayer();
        String anObject = "§8StormSzafka v1.0";
        if (pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService1 != null) {
            final String q = pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService1.Q();
            if (q != null && !q.isEmpty()) {
                anObject = q;
            }
        }
        if (!inventoryCloseEvent.getView().getTitle().equals(anObject)) {
            return;
        }
    }
    
    static {
        pl.ziffy.STORMSZAFKA.utils.UtilsListener1.UtilsUtilityService3 = new HashMap<UUID, Inventory>();
        UtilsListener1 = new String[] { "pedziwiatr", "aniolek", "pancernik", "pudzianek", "glodomorek", "skalniaczek", "biznesmenik", "discordzik", "duszek", "nietoperek", "reniferek", "balwanek", "golemik", "eustachy", "enderman", "zajaczek", "pisklak", "cukiereczek", "rozdymek", "pajak", "sowa", "drakula", "leniuszek", "elfik", "pierniczek", "paczus", "telekrolik" };
    }
}
