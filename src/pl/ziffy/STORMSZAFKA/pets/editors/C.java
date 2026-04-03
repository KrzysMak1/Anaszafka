// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.editors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pl.ziffy.STORMSZAFKA.pets.E;
import org.bukkit.ChatColor;
import java.util.Collection;
import java.util.ArrayList;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.Material;
import java.util.Iterator;
import pl.ziffy.STORMSZAFKA.pets.G;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import java.util.Arrays;
import org.bukkit.entity.Player;
import java.util.List;
import pl.ziffy.STORMSZAFKA.ui.gui.B;

public class C
{
    private static B B;
    private static final List<String> A;
    
    public static void A(final B b) {
        C.B = b;
    }
    
    public static void A(final Player player) {
        A(player, 1);
    }
    
    public static void A(final Player player, final int n) {
        String s = "§8Lista pet\u00f3w - Strona " + n;
        int g = 54;
        List<Integer> list = Arrays.asList(10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43);
        List<String> list2 = C.A;
        int m = 28;
        if (C.B != null) {
            s = C.B.T() + " - Strona " + n;
            g = C.B.G();
            if (C.B.O()) {
                list = C.B.S();
                m = C.B.M();
            }
            list2 = C.B.I();
        }
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, g, s);
        final int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        final int n2 = (n - 1) * m;
        final int min = Math.min(n2 + m, list2.size());
        final G petConfigManager = Main.getPetConfigManager();
        final boolean b = C.B != null && C.B.P();
        for (int i = n2; i < min; ++i) {
            final String s2 = list2.get(i);
            final ItemStack c = C(s2);
            boolean h = true;
            if (petConfigManager != null) {
                h = petConfigManager.H(s2);
            }
            int d = -1;
            if (C.B != null) {
                d = C.B.D(s2);
            }
            if (d == -1) {
                final int n3 = i - n2;
                if (n3 < array.length) {
                    d = array[n3];
                }
            }
            if (d != -1) {
                if (h) {
                    inventory.setItem(d, A(c, s2));
                }
                else if (b) {
                    ItemStack itemStack = null;
                    if (C.B != null) {
                        itemStack = C.B.A(s2);
                    }
                    if (itemStack == null) {
                        itemStack = B(s2);
                    }
                    inventory.setItem(d, itemStack);
                }
            }
        }
        final int n4 = (int)Math.ceil(list2.size() / (double)m);
        int b2 = 48;
        int b3 = 49;
        int b4 = 50;
        if (C.B != null) {
            b2 = C.B.B("previous_page", 48);
            b3 = C.B.B("return", 49);
            b4 = C.B.B("next_page", 50);
        }
        if (n > 1) {
            ItemStack b5 = (C.B != null) ? C.B.G("previous_page") : null;
            if (b5 == null) {
                b5 = B();
            }
            inventory.setItem(b2, b5);
        }
        ItemStack c2 = (C.B != null) ? C.B.G("return") : null;
        if (c2 == null) {
            c2 = C();
        }
        inventory.setItem(b3, c2);
        if (n < n4) {
            ItemStack a = (C.B != null) ? C.B.G("next_page") : null;
            if (a == null) {
                a = A();
            }
            inventory.setItem(b4, a);
        }
        if (C.B != null) {
            for (final Map.Entry entry : C.B.D().entrySet()) {
                final Iterator iterator2 = ((List)entry.getKey()).iterator();
                while (iterator2.hasNext()) {
                    inventory.setItem((int)iterator2.next(), (ItemStack)entry.getValue());
                }
            }
        }
        player.openInventory(inventory);
    }
    
    private static ItemStack B() {
        final ItemStack itemStack = new ItemStack(Material.LIGHT_BLUE_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(A("&#1A99FFPoprzednia strona"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack A() {
        final ItemStack itemStack = new ItemStack(Material.LIME_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(A("&#1DFF1ANast\u0119pna strona"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack B(final String s) {
        final ItemStack itemStack = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        final String displayName = "§cPet niedost\u0119pny: " + s;
        String w = "§cPet niedost\u0119pny";
        if (C.B != null) {
            w = C.B.W();
        }
        itemMeta.setDisplayName(displayName);
        final ArrayList lore = new ArrayList();
        lore.add(w);
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack A(final ItemStack itemStack, final String s) {
        if (itemStack == null) {
            return null;
        }
        final ItemStack clone = itemStack.clone();
        if (clone.hasItemMeta() && clone.getItemMeta().hasLore()) {
            final ItemMeta itemMeta = clone.getItemMeta();
            final ArrayList lore = new ArrayList(itemMeta.getLore());
            lore.removeIf(s2 -> ChatColor.stripColor(s2).contains("Kliknij prawym"));
            final int b = pl.ziffy.STORMSZAFKA.fragments.B.B(s);
            final G petConfigManager = Main.getPetConfigManager();
            String e = "&7";
            String d = "&7Koszt przed\u0142u\u017cenia: &c{cost} serc na dzie\u0144!";
            if (petConfigManager != null) {
                e = petConfigManager.E();
                d = petConfigManager.D();
            }
            if (e != null && !e.isEmpty()) {
                lore.add((Object)A(e));
            }
            lore.add((Object)A(d.replace("{cost}", String.valueOf(b))));
            itemMeta.setLore((List)lore);
            clone.setItemMeta(itemMeta);
        }
        return clone;
    }
    
    private static ItemStack C(final String s) {
        final ItemStack a = E.A(s, "brak");
        if (a != null && a.hasItemMeta() && a.getItemMeta().hasDisplayName()) {
            final ItemMeta itemMeta = a.getItemMeta();
            String displayName = itemMeta.getDisplayName();
            final String stripColor = ChatColor.stripColor(displayName);
            if (stripColor.contains(" na czas ")) {
                final int index = stripColor.indexOf(" na czas ");
                int n = 0;
                int endIndex = 0;
                int n2 = 0;
                for (int index2 = 0; index2 < displayName.length() && n < index; ++index2) {
                    if (displayName.charAt(index2) == '§') {
                        n2 = 1;
                        endIndex = index2;
                    }
                    else if (n2 != 0) {
                        n2 = 0;
                        endIndex = index2 + 1;
                    }
                    else {
                        ++n;
                        endIndex = index2 + 1;
                    }
                }
                displayName = displayName.substring(0, endIndex);
            }
            itemMeta.setDisplayName(displayName);
            a.setItemMeta(itemMeta);
        }
        return a;
    }
    
    private static ItemStack C() {
        final ItemStack itemStack = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(A("&#FF0000Powr\u00f3t do poprzedniego menu"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static String A(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = Pattern.compile("&#([A-Fa-f0-9]{6})").matcher(s);
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
        A = Arrays.asList("aniolek", "balwanek", "biznesmenik", "bobas", "cukiereczek", "cyber-obronca", "discordzik", "drakula", "duszek", "elfik", "enderman", "eustachy", "glodomorek", "golemik", "leniuszek", "nietoperek", "paczus", "pajak", "pancernik", "pedziwiatr", "pierniczek", "pisklak", "pudzianek", "reniferek", "rozdymek", "skalniaczek", "sowa", "telekrolik", "zajaczek");
    }
}
