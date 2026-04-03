// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.ui.gui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.event.EventHandler;
import pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsCostumeEditorController1;
import org.bukkit.plugin.Plugin;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.event.inventory.ClickType;
import pl.ziffy.STORMSZAFKA.ui.menu.UiGuiView1;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Collection;
import java.util.ArrayList;
import pl.ziffy.STORMSZAFKA.pets.PetsPetService4;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import java.util.List;
import java.util.UUID;
import java.util.Map;
import org.bukkit.event.Listener;

public class UiGuiListener1 implements Listener
{
    private static final Map<UUID, Integer> UiGuiListener1;
    private static final Map<UUID, Integer> C;
    private static final String E = "&x&F&F&F&9&1&UiGuiListener1\u26a1 &8\u1d07\u1d05\u028f\u1d04\u1d0a\u1d00 \u1d18\u0280\u1d22\u1d07\u1d05\u1d0d\u026a\u1d0f\u1d1b\u00f3\u1d21";
    private static final List<String> UiGuiView1;
    private static final List<String> D;
    
    public static void openEditorMenu(final Player player) {
        openEditorMenu(player, 1, 1);
    }
    
    public static void openEditorMenu(final Player player, final int i, final int j) {
        pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.UiGuiListener1.put(player.getUniqueId(), i);
        pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.C.put(player.getUniqueId(), j);
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 54, ChatColor.translateAlternateColorCodes('&', C("&x&F&F&F&9&1&UiGuiListener1\u26a1 &8\u1d07\u1d05\u028f\u1d04\u1d0a\u1d00 \u1d18\u0280\u1d22\u1d07\u1d05\u1d0d\u026a\u1d0f\u1d1b\u00f3\u1d21")));
        final int[] array = { 10, 11, 12, 19, 20, 21 };
        final int length = array.length;
        final int n = (i - 1) * length;
        for (int min = Math.min(n + length, pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.UiGuiView1.size()), k = n; k < min; ++k) {
            inventory.setItem(array[k - n], UiGuiView1(pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.UiGuiView1.get(k)));
        }
        final int[] array2 = { 14, 15, 16, 23, 24, 25 };
        final int length2 = array2.length;
        final int n2 = (j - 1) * length2;
        for (int min2 = Math.min(n2 + length2, pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.D.size()), l = n2; l < min2; ++l) {
            inventory.setItem(array2[l - n2], E(pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.D.get(l)));
        }
        inventory.setItem(28, E());
        inventory.setItem(29, C());
        inventory.setItem(30, D());
        inventory.setItem(32, UiGuiView1());
        inventory.setItem(33, F());
        inventory.setItem(34, G());
        inventory.setItem(49, UiGuiListener1());
        player.openInventory(inventory);
    }
    
    private static ItemStack UiGuiView1(final String s) {
        final ItemStack a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.UiGuiListener1(s, "brak", false);
        if (a != null && a.hasItemMeta()) {
            final ItemMeta itemMeta = a.getItemMeta();
            final ArrayList lore = itemMeta.hasLore() ? new ArrayList(itemMeta.getLore()) : new ArrayList();
            lore.removeIf(s2 -> ChatColor.stripColor(s2).contains("Kliknij prawym"));
            lore.add((Object)C("&7"));
            lore.add((Object)C("&7\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a &#21FB08&n\u029f\u1d07\u1d21\u028f\u1d0d&7, \u1d00\u0299\u028f \u1d07\u1d05\u028f\u1d1b\u1d0f\u1d21\u1d00\u0107 \u1d18\u0280\u1d22\u1d07\u1d05\u1d0d\u026a\u1d0f\u1d1b!"));
            lore.add((Object)C("&7\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a &#FF0000&n\ua731\u029c\u026a\ua730\u1d1b + \u1d18\u0280\u1d00\u1d21\u028f&7, \u1d00\u0299\u028f \u1d22\u0280\u1d07\ua731\u1d07\u1d1b\u1d0f\u1d21\u1d00\u0107!"));
            itemMeta.setLore((List)lore);
            a.setItemMeta(itemMeta);
        }
        return a;
    }
    
    private static ItemStack E(final String s) {
        final ItemStack a = L.UiGuiListener1(s, "brak", false);
        if (a != null && a.hasItemMeta()) {
            final ItemMeta itemMeta = a.getItemMeta();
            final ArrayList lore = itemMeta.hasLore() ? new ArrayList(itemMeta.getLore()) : new ArrayList();
            lore.removeIf(s2 -> ChatColor.stripColor(s2).contains("Kliknij prawym"));
            lore.add((Object)C("&7"));
            lore.add((Object)C("&7\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a &#21FB08&n\u029f\u1d07\u1d21\u028f\u1d0d&7, \u1d00\u0299\u028f \u1d07\u1d05\u028f\u1d1b\u1d0f\u1d21\u1d00\u0107 \u1d18\u0280\u1d22\u1d07\u1d05\u1d0d\u026a\u1d0f\u1d1b!"));
            lore.add((Object)C("&7\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a &#FF0000&n\ua731\u029c\u026a\ua730\u1d1b + \u1d18\u0280\u1d00\u1d21\u028f&7, \u1d00\u0299\u028f \u1d22\u0280\u1d07\ua731\u1d07\u1d1b\u1d0f\u1d21\u1d00\u0107!"));
            itemMeta.setLore((List)lore);
            a.setItemMeta(itemMeta);
        }
        return a;
    }
    
    private static ItemStack E() {
        final ItemStack itemStack = new ItemStack(Material.LIGHT_BLUE_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(C("&#1A99FFPoprzednia strona"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack D() {
        final ItemStack itemStack = new ItemStack(Material.LIME_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(C("&#1DFF1ANast\u0119pna strona"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack C() {
        final ItemStack itemStack = new ItemStack(Material.YELLOW_BANNER);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(C("&#FFD700Dodaj nowego peta"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack UiGuiView1() {
        final ItemStack itemStack = new ItemStack(Material.LIGHT_BLUE_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(C("&#1A99FFPoprzednia strona"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack F() {
        final ItemStack itemStack = new ItemStack(Material.YELLOW_BANNER);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(C("&#FFD700Dodaj nowego kostiumu"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack G() {
        final ItemStack itemStack = new ItemStack(Material.LIME_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(C("&#1DFF1ANast\u0119pna strona"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack UiGuiListener1() {
        final ItemStack itemStack = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(C("&#FF0000Powr\u00f3t do poprzedniego menu"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        if (!inventoryClickEvent.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', C("&x&F&F&F&9&1&UiGuiListener1\u26a1 &8\u1d07\u1d05\u028f\u1d04\u1d0a\u1d00 \u1d18\u0280\u1d22\u1d07\u1d05\u1d0d\u026a\u1d0f\u1d1b\u00f3\u1d21")))) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if (currentItem == null || currentItem.getType() == Material.AIR) {
            return;
        }
        final int rawSlot = inventoryClickEvent.getRawSlot();
        final int intValue = pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.UiGuiListener1.getOrDefault(player.getUniqueId(), 1);
        final int intValue2 = pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.C.getOrDefault(player.getUniqueId(), 1);
        final int n = (int)Math.ceil(pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.UiGuiView1.size() / 6.0);
        final int n2 = (int)Math.ceil(pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.D.size() / 6.0);
        if (rawSlot == 28) {
            int n3 = intValue - 1;
            if (n3 < 1) {
                n3 = n;
            }
            openEditorMenu(player, n3, intValue2);
            return;
        }
        if (rawSlot == 29) {
            player.closeInventory();
            player.sendTitle("", C("&#FFD700To zostanie wprowadzone w nast\u0119pnych aktualizacjach!"), 10, 70, 20);
            return;
        }
        if (rawSlot == 30) {
            int n4 = intValue + 1;
            if (n4 > n) {
                n4 = 1;
            }
            openEditorMenu(player, n4, intValue2);
            return;
        }
        if (rawSlot == 32) {
            int n5 = intValue2 - 1;
            if (n5 < 1) {
                n5 = n2;
            }
            openEditorMenu(player, intValue, n5);
            return;
        }
        if (rawSlot == 33) {
            player.closeInventory();
            player.sendTitle("", C("&#FFD700To zostanie wprowadzone w nast\u0119pnych aktualizacjach!"), 10, 70, 20);
            return;
        }
        if (rawSlot == 34) {
            int n6 = intValue2 + 1;
            if (n6 > n2) {
                n6 = 1;
            }
            openEditorMenu(player, intValue, n6);
            return;
        }
        if (rawSlot == 49) {
            pl.ziffy.STORMSZAFKA.ui.menu.UiGuiView1.openMainPanel(player);
            return;
        }
        final int[] array = { 10, 11, 12, 19, 20, 21 };
        boolean b = false;
        int n7 = -1;
        for (int i = 0; i < array.length; ++i) {
            if (rawSlot == array[i]) {
                b = true;
                n7 = i;
                break;
            }
        }
        if (b) {
            final int n8 = (intValue - 1) * 6 + n7;
            if (n8 < pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.UiGuiView1.size()) {
                final String s = pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.UiGuiView1.get(n8);
                if (inventoryClickEvent.getClick() == ClickType.RIGHT) {
                    final ItemStack a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.UiGuiListener1(s, "brak", false);
                    if (a != null) {
                        if (a.hasItemMeta() && a.getItemMeta().hasDisplayName()) {
                            a.getItemMeta().getDisplayName();
                        }
                        if (player.getInventory().firstEmpty() != -1) {
                            player.getInventory().addItem(new ItemStack[] { a });
                            player.sendMessage(C("&8» &7Dodano przedmiot peta &f" + s + " &#27FF00do ekwipunku&7!"));
                        }
                        else {
                            player.getWorld().dropItemNaturally(player.getLocation(), a);
                            player.sendMessage(C("&8» &7Przedmiot peta &f" + s + " &7zosta\u0142 &#FFD700upuszczony&7!"));
                        }
                    }
                    else {
                        player.sendMessage(C("&8» &7B\u0142\u0105d podczas tworzenia przedmiotu &#FF0000peta&7!"));
                    }
                    return;
                }
                if (inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT) {
                    pl.ziffy.STORMSZAFKA.pets.editors.UiGuiListener1.F(s);
                    player.sendMessage(C("&8» &7Pomy\u015blnie zresetowano peta &f" + s + " &#27FF00do domy\u015blnych&7!"));
                    Bukkit.getScheduler().runTaskLater((Plugin)Main.getInstance(), () -> openEditorMenu(player2, n11, n12), 1L);
                    return;
                }
                if (inventoryClickEvent.getClick() == ClickType.LEFT) {
                    pl.ziffy.STORMSZAFKA.pets.editors.UiGuiView1.openPetEditor(player, s);
                    return;
                }
            }
        }
        final int[] array2 = { 14, 15, 16, 23, 24, 25 };
        boolean b2 = false;
        int n9 = -1;
        for (int j = 0; j < array2.length; ++j) {
            if (rawSlot == array2[j]) {
                b2 = true;
                n9 = j;
                break;
            }
        }
        if (b2) {
            final int n10 = (intValue2 - 1) * 6 + n9;
            if (n10 < pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.D.size()) {
                final String s2 = pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1.D.get(n10);
                if (inventoryClickEvent.getClick() == ClickType.RIGHT) {
                    final ItemStack a2 = L.UiGuiListener1(s2, "brak", false);
                    if (a2 != null) {
                        if (player.getInventory().firstEmpty() != -1) {
                            player.getInventory().addItem(new ItemStack[] { a2 });
                            player.sendMessage(C("&8» &7Dodano przedmiot kostiumu &f" + s2 + " &#27FF00do ekwipunku&7!"));
                        }
                        else {
                            player.getWorld().dropItemNaturally(player.getLocation(), a2);
                            player.sendMessage(C("&8» &7Przedmiot kostiumu &f" + s2 + " &7zosta\u0142 &#FFD700upuszczony&7!"));
                        }
                    }
                    else {
                        player.sendMessage(C("&8» &7B\u0142\u0105d podczas tworzenia przedmiotu &#FF0000kostiumu&7!"));
                    }
                    return;
                }
                if (inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT) {
                    pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsCostumeEditorController1.D(s2);
                    player.sendMessage(C("&8» &7Pomy\u015blnie zresetowano kostium &f" + s2 + " &#27FF00do domy\u015blnych&7!"));
                    Bukkit.getScheduler().runTaskLater((Plugin)Main.getInstance(), () -> openEditorMenu(player3, n13, n14), 1L);
                    return;
                }
                if (inventoryClickEvent.getClick() == ClickType.LEFT) {
                    pl.ziffy.STORMSZAFKA.costumes.editors.UiGuiListener1.openCostumeEditor(player, s2);
                }
            }
        }
    }
    
    private static String C(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = Pattern.compile("&#([UiGuiListener1-Fa-f0-9]{6})").matcher(s);
        final StringBuilder sb = new StringBuilder();
        int end = 0;
        while (matcher.find()) {
            sb.append(s, end, matcher.start());
            final String group = matcher.group(1);
            sb.append("§x");
            final char[] charArray = group.toCharArray();
            for (int length = charArray.length, i = 0; i < length; ++i) {
                sb.append("§").append(charArray[i]);
            }
            end = matcher.end();
        }
        sb.append(s.substring(end));
        return ChatColor.translateAlternateColorCodes('&', sb.toString());
    }
    
    static {
        UiGuiListener1 = new HashMap<UUID, Integer>();
        C = new HashMap<UUID, Integer>();
        UiGuiView1 = Arrays.asList("aniolek", "balwanek", "biznesmenik", "bobas", "cukiereczek", "cyber-obronca", "discordzik", "drakula", "duszek", "elfik", "enderman", "eustachy", "glodomorek", "golemik", "leniuszek", "nietoperek", "paczus", "pajak", "pancernik", "pedziwiatr", "pierniczek", "pisklak", "pudzianek", "reniferek", "rozdymek", "skalniaczek", "sowa", "telekrolik", "zajaczek");
        D = Arrays.asList("malyurwis", "mima", "nurekglebinowy", "pirata", "przeciwzakazeniowy", "walentynkowy", "wampir", "zabojczykrolik");
    }
}
