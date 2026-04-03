// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.editors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pl.ziffy.STORMSZAFKA.pets.PetsPetService4;
import org.bukkit.ChatColor;
import java.util.Collection;
import java.util.ArrayList;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.Material;
import java.util.Iterator;
import pl.ziffy.STORMSZAFKA.pets.PetsPetService6;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import java.util.Arrays;
import org.bukkit.entity.Player;
import java.util.List;
import pl.ziffy.STORMSZAFKA.ui.gui.PetsEditorsListener1;

public class PetsEditorsPetEditorController2
{
    private static PetsEditorsListener1 PetsEditorsListener1;
    private static final List<String> PetsEditorsPetEditorController1;
    
    public static void PetsEditorsPetEditorController1(final PetsEditorsListener1 b) {
        PetsEditorsPetEditorController2.PetsEditorsListener1 = b;
    }
    
    public static void PetsEditorsPetEditorController1(final Player player) {
        PetsEditorsPetEditorController1(player, 1);
    }
    
    public static void PetsEditorsPetEditorController1(final Player player, final int n) {
        String s = "§8Lista pet\u00f3w - Strona " + n;
        int g = 54;
        List<Integer> list = Arrays.asList(10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43);
        List<String> list2 = PetsEditorsPetEditorController2.PetsEditorsPetEditorController1;
        int m = 28;
        if (PetsEditorsPetEditorController2.PetsEditorsListener1 != null) {
            s = PetsEditorsPetEditorController2.PetsEditorsListener1.T() + " - Strona " + n;
            g = PetsEditorsPetEditorController2.PetsEditorsListener1.G();
            if (PetsEditorsPetEditorController2.PetsEditorsListener1.O()) {
                list = PetsEditorsPetEditorController2.PetsEditorsListener1.S();
                m = PetsEditorsPetEditorController2.PetsEditorsListener1.M();
            }
            list2 = PetsEditorsPetEditorController2.PetsEditorsListener1.I();
        }
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, g, s);
        final int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        final int n2 = (n - 1) * m;
        final int min = Math.min(n2 + m, list2.size());
        final G petConfigManager = Main.getPetConfigManager();
        final boolean b = PetsEditorsPetEditorController2.PetsEditorsListener1 != null && PetsEditorsPetEditorController2.PetsEditorsListener1.P();
        for (int i = n2; i < min; ++i) {
            final String s2 = list2.get(i);
            final ItemStack c = PetsEditorsPetEditorController2(s2);
            boolean h = true;
            if (petConfigManager != null) {
                h = petConfigManager.H(s2);
            }
            int d = -1;
            if (PetsEditorsPetEditorController2.PetsEditorsListener1 != null) {
                d = PetsEditorsPetEditorController2.PetsEditorsListener1.PetsEditorsListener2(s2);
            }
            if (d == -1) {
                final int n3 = i - n2;
                if (n3 < array.length) {
                    d = array[n3];
                }
            }
            if (d != -1) {
                if (h) {
                    inventory.setItem(d, PetsEditorsPetEditorController1(c, s2));
                }
                else if (b) {
                    ItemStack itemStack = null;
                    if (PetsEditorsPetEditorController2.PetsEditorsListener1 != null) {
                        itemStack = PetsEditorsPetEditorController2.PetsEditorsListener1.PetsEditorsPetEditorController1(s2);
                    }
                    if (itemStack == null) {
                        itemStack = PetsEditorsListener1(s2);
                    }
                    inventory.setItem(d, itemStack);
                }
            }
        }
        final int n4 = (int)Math.ceil(list2.size() / (double)m);
        int b2 = 48;
        int b3 = 49;
        int b4 = 50;
        if (PetsEditorsPetEditorController2.PetsEditorsListener1 != null) {
            b2 = PetsEditorsPetEditorController2.PetsEditorsListener1.PetsEditorsListener1("previous_page", 48);
            b3 = PetsEditorsPetEditorController2.PetsEditorsListener1.PetsEditorsListener1("return", 49);
            b4 = PetsEditorsPetEditorController2.PetsEditorsListener1.PetsEditorsListener1("next_page", 50);
        }
        if (n > 1) {
            ItemStack b5 = (PetsEditorsPetEditorController2.PetsEditorsListener1 != null) ? PetsEditorsPetEditorController2.PetsEditorsListener1.G("previous_page") : null;
            if (b5 == null) {
                b5 = PetsEditorsListener1();
            }
            inventory.setItem(b2, b5);
        }
        ItemStack c2 = (PetsEditorsPetEditorController2.PetsEditorsListener1 != null) ? PetsEditorsPetEditorController2.PetsEditorsListener1.G("return") : null;
        if (c2 == null) {
            c2 = PetsEditorsPetEditorController2();
        }
        inventory.setItem(b3, c2);
        if (n < n4) {
            ItemStack a = (PetsEditorsPetEditorController2.PetsEditorsListener1 != null) ? PetsEditorsPetEditorController2.PetsEditorsListener1.G("next_page") : null;
            if (a == null) {
                a = PetsEditorsPetEditorController1();
            }
            inventory.setItem(b4, a);
        }
        if (PetsEditorsPetEditorController2.PetsEditorsListener1 != null) {
            for (final Map.Entry entry : PetsEditorsPetEditorController2.PetsEditorsListener1.PetsEditorsListener2().entrySet()) {
                final Iterator iterator2 = ((List)entry.getKey()).iterator();
                while (iterator2.hasNext()) {
                    inventory.setItem((int)iterator2.next(), (ItemStack)entry.getValue());
                }
            }
        }
        player.openInventory(inventory);
    }
    
    private static ItemStack PetsEditorsListener1() {
        final ItemStack itemStack = new ItemStack(Material.LIGHT_BLUE_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(PetsEditorsPetEditorController1("&#1A99FFPoprzednia strona"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack PetsEditorsPetEditorController1() {
        final ItemStack itemStack = new ItemStack(Material.LIME_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(PetsEditorsPetEditorController1("&#1DFF1ANast\u0119pna strona"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack PetsEditorsListener1(final String s) {
        final ItemStack itemStack = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        final String displayName = "§cPet niedost\u0119pny: " + s;
        String w = "§cPet niedost\u0119pny";
        if (PetsEditorsPetEditorController2.PetsEditorsListener1 != null) {
            w = PetsEditorsPetEditorController2.PetsEditorsListener1.W();
        }
        itemMeta.setDisplayName(displayName);
        final ArrayList lore = new ArrayList();
        lore.add(w);
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack PetsEditorsPetEditorController1(final ItemStack itemStack, final String s) {
        if (itemStack == null) {
            return null;
        }
        final ItemStack clone = itemStack.clone();
        if (clone.hasItemMeta() && clone.getItemMeta().hasLore()) {
            final ItemMeta itemMeta = clone.getItemMeta();
            final ArrayList lore = new ArrayList(itemMeta.getLore());
            lore.removeIf(s2 -> ChatColor.stripColor(s2).contains("Kliknij prawym"));
            final int b = pl.ziffy.STORMSZAFKA.fragments.PetsEditorsListener1.PetsEditorsListener1(s);
            final G petConfigManager = Main.getPetConfigManager();
            String e = "&7";
            String d = "&7Koszt przed\u0142u\u017cenia: &c{cost} serc na dzie\u0144!";
            if (petConfigManager != null) {
                e = petConfigManager.E();
                d = petConfigManager.PetsEditorsListener2();
            }
            if (e != null && !e.isEmpty()) {
                lore.add((Object)PetsEditorsPetEditorController1(e));
            }
            lore.add((Object)PetsEditorsPetEditorController1(d.replace("{cost}", String.valueOf(b))));
            itemMeta.setLore((List)lore);
            clone.setItemMeta(itemMeta);
        }
        return clone;
    }
    
    private static ItemStack PetsEditorsPetEditorController2(final String s) {
        final ItemStack a = E.PetsEditorsPetEditorController1(s, "brak");
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
    
    private static ItemStack PetsEditorsPetEditorController2() {
        final ItemStack itemStack = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(PetsEditorsPetEditorController1("&#FF0000Powr\u00f3t do poprzedniego menu"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static String PetsEditorsPetEditorController1(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = Pattern.compile("&#([PetsEditorsPetEditorController1-Fa-f0-9]{6})").matcher(s);
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
        PetsEditorsPetEditorController1 = Arrays.asList("aniolek", "balwanek", "biznesmenik", "bobas", "cukiereczek", "cyber-obronca", "discordzik", "drakula", "duszek", "elfik", "enderman", "eustachy", "glodomorek", "golemik", "leniuszek", "nietoperek", "paczus", "pajak", "pancernik", "pedziwiatr", "pierniczek", "pisklak", "pudzianek", "reniferek", "rozdymek", "skalniaczek", "sowa", "telekrolik", "zajaczek");
    }
}
