// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.ui.menu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.bukkit.enchantments.Enchantment;
import java.util.ArrayList;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.ChatColor;
import java.util.Iterator;
import org.bukkit.event.EventHandler;
import net.milkbowl.vault.economy.Economy;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import org.bukkit.plugin.Plugin;
import org.bukkit.Sound;
import org.bukkit.OfflinePlayer;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.metadata.MetadataValue;
import pl.ziffy.STORMSZAFKA.pets.editors.C;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import java.util.List;
import java.util.Map;
import org.bukkit.inventory.Inventory;
import pl.ziffy.STORMSZAFKA.costumes.editors.D;
import pl.ziffy.STORMSZAFKA.costumes.L;
import pl.ziffy.STORMSZAFKA.pets.E;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.ziffy.STORMSZAFKA.ui.gui.B;
import org.bukkit.event.Listener;

public class A implements Listener
{
    private static B A;
    
    public static void setConfigManager(final B a) {
        pl.ziffy.STORMSZAFKA.ui.menu.A.A = a;
    }
    
    public static B getConfigManager() {
        return pl.ziffy.STORMSZAFKA.ui.menu.A.A;
    }
    
    public static void openMainMenu(final Player player) {
        int l = 45;
        String c = "§8System szafki";
        if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
            l = pl.ziffy.STORMSZAFKA.ui.menu.A.A.L();
            c = pl.ziffy.STORMSZAFKA.ui.menu.A.A.C();
        }
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, l, c);
        E.I(player);
        try {
            if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
                final Map<List<Integer>, ItemStack> a = pl.ziffy.STORMSZAFKA.ui.menu.A.A.A();
                if (a != null) {
                    A(inventory, a);
                }
            }
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
        final int n = 40;
        if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
            final int f = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("close", 40);
            final ItemStack e = pl.ziffy.STORMSZAFKA.ui.menu.A.A.E("close");
            if (e != null) {
                inventory.setItem(f, e);
            }
            else {
                inventory.setItem(f, H());
            }
        }
        else {
            inventory.setItem(n, H());
        }
        int f2 = 15;
        if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
            f2 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("pet_display", 15);
        }
        if (E.K(player)) {
            final E._A a2 = E.F.get(player.getUniqueId());
            if (a2 != null) {
                final ItemStack a3 = A(a2);
                if (a3 != null) {
                    inventory.setItem(f2, a3);
                }
                else {
                    inventory.setItem(f2, C());
                }
            }
            else {
                inventory.setItem(f2, C());
            }
        }
        else if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
            final ItemStack e2 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.E("no_pet");
            if (e2 != null) {
                inventory.setItem(f2, e2);
            }
            else {
                inventory.setItem(f2, C());
            }
        }
        else {
            inventory.setItem(f2, C());
        }
        if (E.K(player)) {
            inventory.setItem(14, F());
            inventory.setItem(24, F(player));
        }
        else {
            final int n2 = 24;
            if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
                final int f3 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("no_pet_info", 24);
                final ItemStack e3 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.E("no_pet_info");
                if (e3 != null) {
                    inventory.setItem(f3, e3);
                }
                else {
                    inventory.setItem(f3, G());
                }
            }
            else {
                inventory.setItem(n2, G());
            }
        }
        int d = 11;
        if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
            d = pl.ziffy.STORMSZAFKA.ui.menu.A.A.D("costume_display", 11);
        }
        if (L.F(player)) {
            inventory.setItem(d, H(player));
        }
        else if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
            final ItemStack b = pl.ziffy.STORMSZAFKA.ui.menu.A.A.B("no_costume");
            if (b != null) {
                inventory.setItem(d, b);
            }
            else {
                inventory.setItem(d, D());
            }
        }
        else {
            inventory.setItem(d, D());
        }
        if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
            pl.ziffy.STORMSZAFKA.ui.menu.A.A.D("remove_costume", 20);
        }
        final int n3 = 10;
        if (L.F(player)) {
            if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
                final ItemStack b2 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.B("remove_costume");
                if (b2 != null) {
                    inventory.setItem(n3, b2);
                }
                else {
                    inventory.setItem(n3, B());
                }
            }
            else {
                inventory.setItem(n3, B());
            }
            inventory.setItem(20, D(player));
        }
        else if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
            final ItemStack b3 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.B("no_costume_info");
            if (b3 != null) {
                inventory.setItem(20, b3);
            }
            else {
                inventory.setItem(20, E());
            }
        }
        else {
            inventory.setItem(20, E());
        }
        if (L.F(player) && D.A()) {
            inventory.setItem(12, E(player));
        }
        final int n4 = 44;
        if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
            final int f4 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("preview_pets", 44);
            final ItemStack e4 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.E("preview_pets");
            if (e4 != null) {
                inventory.setItem(f4, e4);
            }
            else {
                inventory.setItem(f4, I());
            }
        }
        else {
            inventory.setItem(n4, I());
        }
        if (E.K(player) && pl.ziffy.STORMSZAFKA.fragments.B.G()) {
            inventory.setItem(16, B(player));
        }
        final int n5 = 36;
        try {
            if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
                final int f5 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("preview_costumes", 36);
                final ItemStack e5 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.E("preview_costumes");
                if (e5 != null) {
                    inventory.setItem(f5, e5);
                }
                else {
                    inventory.setItem(f5, J());
                }
            }
            else {
                inventory.setItem(n5, J());
            }
        }
        catch (final Exception ex2) {
            inventory.setItem(36, J());
        }
        if (E.K(player)) {
            final boolean b4 = !E.I(player);
            final int n6 = 41;
            if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
                if (b4) {
                    final int f6 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("visibility_visible", 41);
                    final ItemStack e6 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.E("visibility_visible");
                    if (e6 != null) {
                        inventory.setItem(f6, e6);
                    }
                    else {
                        inventory.setItem(f6, A(b4));
                    }
                }
                else {
                    final int f7 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("visibility_hidden", 41);
                    final ItemStack e7 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.E("visibility_hidden");
                    if (e7 != null) {
                        inventory.setItem(f7, e7);
                    }
                    else {
                        inventory.setItem(f7, A(b4));
                    }
                }
            }
            else {
                inventory.setItem(n6, A(b4));
            }
        }
        player.openInventory(inventory);
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        String c = "§8System szafki";
        if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
            c = pl.ziffy.STORMSZAFKA.ui.menu.A.A.C();
        }
        if (!inventoryClickEvent.getView().getTitle().equals(c)) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if (currentItem == null) {
            return;
        }
        int f = 40;
        int f2 = 23;
        int f3 = 44;
        int f4 = 36;
        int f5 = 41;
        int f6 = 41;
        int d = 11;
        if (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null) {
            f = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("close", 40);
            f2 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("hide_pet", 23);
            pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("no_pet_info", 25);
            f3 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("preview_pets", 44);
            f4 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("preview_costumes", 36);
            f5 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("visibility_visible", 41);
            f6 = pl.ziffy.STORMSZAFKA.ui.menu.A.A.F("visibility_hidden", 41);
            d = pl.ziffy.STORMSZAFKA.ui.menu.A.A.D("costume_display", 11);
            pl.ziffy.STORMSZAFKA.ui.menu.A.A.D("remove_costume", 20);
        }
        if (inventoryClickEvent.getSlot() == f && (currentItem.getType() == Material.BARRIER || (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null && pl.ziffy.STORMSZAFKA.ui.menu.A.A.E("close") != null))) {
            player.closeInventory();
            return;
        }
        if (inventoryClickEvent.getSlot() == 14 && currentItem.getType() == Material.RED_DYE && E.K(player)) {
            E.L(player);
            Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> {
                if (player2.isOnline()) {
                    openMainMenu(player2);
                }
            }, 2L);
            return;
        }
        if (inventoryClickEvent.getSlot() == 16 && currentItem.getType() == Material.LIME_DYE && E.K(player)) {
            final E._A obj = E.F.get(player.getUniqueId());
            if (obj != null && obj.F != null) {
                final int b = pl.ziffy.STORMSZAFKA.fragments.B.B(E.A(obj.A));
                final int a = pl.ziffy.STORMSZAFKA.fragments.B.A(player);
                if (a >= b) {
                    pl.ziffy.STORMSZAFKA.fragments.B.B(player, b);
                    final LocalDateTime plusDays = obj.F.plusDays(1L);
                    try {
                        final Field declaredField = E._A.class.getDeclaredField("expirationTime");
                        declaredField.setAccessible(true);
                        declaredField.set(obj, plusDays);
                    }
                    catch (final Exception ex) {
                        ex.printStackTrace();
                    }
                    player.sendMessage(A("&8» &7Pomy\u015blnie przed\u0142u\u017cono peta o &f1 dzie\u0144 &#27FF00sukces&7!"));
                    player.closeInventory();
                }
                else {
                    player.sendMessage(A("&8» &7Nie masz wystarczaj\u0105cej ilo\u015bci &#FF0000serc&7! Potrzebujesz: &f" + b + "&7, masz: &f" + a));
                }
            }
            return;
        }
        if (inventoryClickEvent.getSlot() == f2 && (currentItem.getType() == Material.RED_DYE || (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null && pl.ziffy.STORMSZAFKA.ui.menu.A.A.E("hide_pet") != null))) {
            if (E.K(player)) {
                E.H(player);
                player.closeInventory();
            }
            return;
        }
        if (inventoryClickEvent.getSlot() == f3 && (currentItem.getType() == Material.EGG || (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null && pl.ziffy.STORMSZAFKA.ui.menu.A.A.E("preview_pets") != null))) {
            C.A(player);
            return;
        }
        if (inventoryClickEvent.getSlot() == f4 && (currentItem.getType() == Material.ARMOR_STAND || (pl.ziffy.STORMSZAFKA.ui.menu.A.A != null && pl.ziffy.STORMSZAFKA.ui.menu.A.A.E("preview_costumes") != null))) {
            pl.ziffy.STORMSZAFKA.costumes.preview.A.openPreviewMenu(player);
            return;
        }
        if (inventoryClickEvent.getSlot() == 10 && currentItem.getType() == Material.RED_DYE && L.F(player)) {
            if (L.F(player)) {
                String s = null;
                final pl.ziffy.STORMSZAFKA.costumes.C a2 = L.A(player);
                if (a2 != null) {
                    s = a2.getType();
                }
                if (s == null && player.hasMetadata("costume_item_type")) {
                    s = player.getMetadata("costume_item_type").get(0).asString();
                    player.removeMetadata("costume_item_type", Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
                }
                if (s == null) {}
                L.C(player);
                Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> {
                    if (player3.isOnline()) {
                        openMainMenu(player3);
                    }
                }, 2L);
            }
            return;
        }
        if (inventoryClickEvent.getSlot() == 12 && currentItem.getType() == Material.LIME_DYE && L.F(player)) {
            if (!D.A()) {
                player.sendMessage(A("&8» &7System przed\u0142u\u017cania kostium\u00f3w jest &fwy\u0142\u0105czony&7!"));
                return;
            }
            final pl.ziffy.STORMSZAFKA.utils.D economyManager = Main.getInstance().getEconomyManager();
            if (economyManager == null || !economyManager.B()) {
                player.sendMessage(A("&8» &7System przed\u0142u\u017cania kostium\u00f3w wymaga pluginu &fVault&7!"));
                return;
            }
            final pl.ziffy.STORMSZAFKA.costumes.C a3 = L.A(player);
            if (a3 == null) {
                player.sendMessage(A("&8» &7B\u0142\u0105d: Nie znaleziono aktywnego kostiumu!"));
                return;
            }
            final int g = D.G(a3.getType());
            final Economy c2 = economyManager.C();
            if (!c2.has((OfflinePlayer)player, (double)g)) {
                player.sendMessage(A("&8» &7Nie masz wystarczaj\u0105co pieni\u0119dzy! Potrzebujesz &#FF0000" + g + "$&7, a posiadasz &f" + (int)c2.getBalance((OfflinePlayer)player)));
                return;
            }
            c2.withdrawPlayer((OfflinePlayer)player, (double)g);
            L.A(player, 1);
            player.sendMessage(A("&8» &7Pomy\u015blnie przed\u0142u\u017cy\u0142e\u015b kostium o &f1 dzie\u0144&7! Zap\u0142acono &#18FF00" + g));
            player.sendTitle("", A("&#18FF00Pomy\u015blnie&7 przed\u0142u\u017cono &f1 dzie\u0144&7!"), 10, 30, 15);
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
            Bukkit.getScheduler().runTaskLater((Plugin)Main.getInstance(), () -> openMainMenu(player4), 2L);
        }
        else {
            if (inventoryClickEvent.getSlot() == d) {
                return;
            }
            if (inventoryClickEvent.getSlot() == f5 || inventoryClickEvent.getSlot() == f6) {
                if (E.K(player)) {
                    if (E.I(player)) {
                        E.E(player);
                        player.sendTitle("", "§7Tw\u00f3j §fpet§7 jest teraz §x§1§2§F§B§0§8widoczny§7!", 10, 30, 15);
                    }
                    else {
                        E.D(player);
                        player.sendTitle("", "§7Tw\u00f3j §fpet§7 jest teraz §x§F§F§0§0§0§0niewidoczny§7!", 10, 30, 15);
                    }
                    final Inventory inventory = inventoryClickEvent.getInventory();
                    final boolean b2 = !E.I(player);
                    inventory.setItem(b2 ? f5 : f6, A(b2));
                }
            }
        }
    }
    
    private static void A(final Inventory inventory, final Map<List<Integer>, ItemStack> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            for (final Map.Entry entry : map.entrySet()) {
                final List list = (List)entry.getKey();
                final ItemStack itemStack = (ItemStack)entry.getValue();
                if (list != null) {
                    if (itemStack == null) {
                        continue;
                    }
                    for (final int intValue : list) {
                        if (intValue >= 0 && intValue < inventory.getSize()) {
                            inventory.setItem(intValue, itemStack);
                        }
                    }
                }
            }
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static ItemStack A(final E._A a) {
        if (a == null) {
            return null;
        }
        return E.A(a.C, a.B, a.F);
    }
    
    private static ItemStack H() {
        final ItemStack itemStack = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cZamknij"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack C() {
        final ItemStack itemStack = new ItemStack(Material.SKELETON_SKULL);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(E.Y("&cBrak peta"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack A() {
        final ItemStack itemStack = new ItemStack(Material.RED_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(E.Y("&cUkryj peta"));
        final ArrayList lore = new ArrayList();
        lore.add(E.Y("&7Kliknij, aby ukry\u0107 peta"));
        lore.add(E.Y("&7Pet zniknie bez dawania przedmiotu"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack G() {
        final ItemStack itemStack = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(E.Y("&cPeta mo\u017cesz zdoby\u0107 poprzez zakup"));
        final ArrayList lore = new ArrayList();
        lore.add(E.Y("&4klucza&c w sklepie za czas lub"));
        lore.add(E.Y("&cna naszej stronie &4www.popmc.pl&c."));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack I() {
        final ItemStack itemStack = new ItemStack(Material.EGG);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(E.Y("&6Pety"));
        final ArrayList lore = new ArrayList();
        lore.add(E.Y("&8 » &7W tym miejscu odnajdziesz pe\u0142n\u0105 list\u0119"));
        lore.add(E.Y("&8 » &7wszystkich dost\u0119pnych &ezwierz\u0105t"));
        lore.add(E.Y("&8 » &etowarzysz\u0105cych&7 wraz z ich efektami"));
        lore.add(E.Y("&8 » &7dodatkowymi!"));
        lore.add(E.Y("&r"));
        lore.add(E.Y("&8 » &aKliknij &2LEWYM&a, aby przej\u015b\u0107!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack A(final boolean b) {
        final ItemStack itemStack = new ItemStack(Material.REDSTONE_TORCH);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(E.Y("&aWidoczno\u015b\u0107 peta"));
        itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        final ArrayList lore = new ArrayList();
        lore.add(E.Y("&r"));
        lore.add(E.Y(" &8» &7Denerwuje ciebie tw\u00f3j zwierzak?"));
        lore.add(E.Y(" &8» &7Je\u017celi tak to wystarczy, \u017ce ukryjesz"));
        lore.add(E.Y(" &8» &7go t\u0105 funckj\u0105!"));
        lore.add(E.Y("&r"));
        if (b) {
            lore.add(E.Y("&8» &7Status: &awidoczny"));
            lore.add(E.Y("&8» &aKliknij, aby ukry\u0107"));
        }
        else {
            lore.add(E.Y("&8» &7Status: &cniewidoczny"));
            lore.add(E.Y("&8» &cKliknij, aby pokaza\u0107"));
        }
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack H(final Player player) {
        if (L.F(player)) {
            final ItemStack costumeItem = L.A(player).getCostumeItem();
            if (costumeItem != null && costumeItem.hasItemMeta()) {
                final ItemMeta itemMeta = costumeItem.getItemMeta();
                if (itemMeta != null && itemMeta.hasDisplayName()) {
                    final String displayName = itemMeta.getDisplayName();
                    if (displayName.contains("{time}")) {
                        final String h = L.H(player);
                        String replacement;
                        if (h != null && !h.equals("brak") && !h.equals("INFINITE")) {
                            replacement = pl.ziffy.STORMSZAFKA.utils.time.A.G(h);
                        }
                        else {
                            replacement = pl.ziffy.STORMSZAFKA.utils.time.A.A();
                        }
                        itemMeta.setDisplayName(displayName.replace("{time}", replacement));
                        costumeItem.setItemMeta(itemMeta);
                    }
                }
            }
            return costumeItem;
        }
        return D();
    }
    
    private static ItemStack D() {
        final ItemStack itemStack = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(A("&cBrak kostiumu"));
        final ArrayList lore = new ArrayList();
        lore.add(A("&7Nie masz aktywnego kostiumu!"));
        lore.add(A("&7Kostiumy mo\u017cesz zdoby\u0107 przez specjalne"));
        lore.add(A("&7wydarzenia lub zakupi\u0107 w sklepie."));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack B() {
        final ItemStack itemStack = new ItemStack(Material.RED_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(A("&cZdejmij kostium"));
        final ArrayList lore = new ArrayList();
        lore.add(A("&7Kliknij, aby zdj\u0105\u0107 kostium."));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack E() {
        final ItemStack itemStack = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(A("&cKostiumy"));
        final ArrayList lore = new ArrayList();
        lore.add(A("&7Kostiumy mo\u017cesz zdoby\u0107 przez specjalne"));
        lore.add(A("&7wydarzenia lub zakupi\u0107 w sklepie."));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack J() {
        final ItemStack itemStack = new ItemStack(Material.ARMOR_STAND);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(E.Y("&6Kostiumy"));
        final ArrayList lore = new ArrayList();
        lore.add(E.Y("&8 » &7W tym miejscu odnajdziesz pe\u0142n\u0105 list\u0119"));
        lore.add(E.Y("&8 » &7wszystkich dost\u0119pnych &ekostium\u00f3w"));
        lore.add(E.Y("&8 » &7wraz z ich efektami dodatkowymi!"));
        lore.add(E.Y("&7"));
        lore.add(E.Y("&8 » &aKliknij &2LEWYM&a, aby przej\u015b\u0107!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack F() {
        final ItemStack itemStack = new ItemStack(Material.RED_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(A("&cZdejmij peta"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack B(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.LIME_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(A("&aPrzed\u0142u\u017c peta"));
        final ArrayList lore = new ArrayList();
        lore.add(A("&7"));
        final E._A a = E.F.get(player.getUniqueId());
        if (a != null) {
            lore.add(A("&8 » &7Ten pet potrzebuje &c" + pl.ziffy.STORMSZAFKA.fragments.B.B(E.A(a.A)) + " serc&7,"));
            lore.add(A("&8 » &7aby przed\u0142u\u017cy\u0107 dzia\u0142anie "));
            lore.add(A("&8 » &7peta o &f1 dzie\u0144&7!"));
        }
        else {
            lore.add(A("&8 » &7Ten pet potrzebuje &c0 serc&7,"));
            lore.add(A("&8 » &7aby przed\u0142u\u017cy\u0107 dzia\u0142anie "));
            lore.add(A("&8 » &7peta o &f1 dzie\u0144&7!"));
        }
        lore.add(A("&7"));
        lore.add(A("&aKliknij &2LEWYM&a, aby przed\u0142u\u017cy\u0107!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack F(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        final E._A a = E.F.get(player.getUniqueId());
        String displayName = "Pet";
        String format = "Brak daty";
        if (a != null && a.A != null) {
            displayName = a.A.getDisplayName();
            if (a.F != null) {
                format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Timestamp.valueOf(a.F));
            }
        }
        itemMeta.setDisplayName(A("&aPet wyga\u015bnie &2" + format));
        final ArrayList lore = new ArrayList();
        lore.add(A("&7"));
        lore.add(A("&8 » &7Aby przed\u0142u\u017cy\u0107 czas \u017cywotno\u015bci"));
        lore.add(A("&8 » &7peta '" + displayName + "&7' u\u017cyj &fprzycisku"));
        lore.add(A("&8 » &fobok&7!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack D(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        final pl.ziffy.STORMSZAFKA.costumes.C a = L.A(player);
        String displayName = "Kostium";
        String format = "Brak daty";
        if (a != null) {
            displayName = a.getDisplayName();
            final L._A a2 = L.C.get(player.getUniqueId());
            if (a2 != null && a2.C != null) {
                format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Timestamp.valueOf(a2.C));
            }
        }
        itemMeta.setDisplayName(A("&aKostium wyga\u015bnie &2" + format));
        final ArrayList lore = new ArrayList();
        lore.add(A("&7"));
        lore.add(A("&8 » &7Aby przed\u0142u\u017cy\u0107 czas \u017cywotno\u015bci"));
        lore.add(A("&8 » &7kostiumu '" + displayName + "&7' u\u017cyj &fprzycisku"));
        lore.add(A("&8 » &fobok&7!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack E(final Player player) {
        final ItemStack itemStack = new ItemStack(Material.LIME_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(A("&aPrzed\u0142u\u017c kostium"));
        final ArrayList lore = new ArrayList();
        lore.add(A("&7"));
        final pl.ziffy.STORMSZAFKA.costumes.C a = L.A(player);
        if (a != null) {
            final int g = D.G(a.getType());
            final String b = B(g);
            final String a2 = A(g);
            lore.add(A("&8 » &7Koszt przed\u0142u\u017cenia:"));
            lore.add(A("&8 » &c" + b + " waluty serwerowej&7."));
            lore.add(A("&7"));
            lore.add(A("&8 » &a" + a2 + " &7przed\u0142u\u017cy okres"));
            lore.add(A("&8 » &7wa\u017cno\u015bci kostiumu o &f1 dzie\u0144&7!"));
        }
        lore.add(A("&7"));
        lore.add(A("&aKliknij &2LEWYM&a, aby przed\u0142u\u017cy\u0107!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static String B(final int i) {
        final String value = String.valueOf(i);
        final StringBuilder sb = new StringBuilder();
        int n = 0;
        for (int j = value.length() - 1; j >= 0; --j) {
            if (n == 3) {
                sb.insert(0, ",");
                n = 0;
            }
            sb.insert(0, value.charAt(j));
            ++n;
        }
        return sb.toString();
    }
    
    private static String A(final int i) {
        if (i >= 1000000) {
            return i / 1000000 + "MLN";
        }
        if (i >= 1000) {
            return "" + i / 1000;
        }
        return String.valueOf(i);
    }
    
    private static String A(String b) {
        if (b == null) {
            return null;
        }
        b = B(b);
        return ChatColor.translateAlternateColorCodes('&', b);
    }
    
    private static String B(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = Pattern.compile("&#([A-Fa-f0-9]{6})").matcher(s);
        final StringBuilder sb = new StringBuilder();
        int end = 0;
        while (matcher.find()) {
            sb.append(s, end, matcher.start());
            final String group = matcher.group(1);
            final StringBuilder s2 = new StringBuilder("§x");
            final char[] charArray = group.toCharArray();
            for (int length = charArray.length, i = 0; i < length; ++i) {
                s2.append("§").append(Character.toLowerCase(charArray[i]));
            }
            sb.append((CharSequence)s2);
            end = matcher.end();
        }
        sb.append(s.substring(end));
        return sb.toString();
    }
}
