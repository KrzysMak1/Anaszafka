// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.fragments;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import java.util.HashMap;
import java.util.Iterator;
import org.bukkit.entity.Player;
import java.io.IOException;
import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import java.util.regex.Pattern;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.util.Map;
import org.bukkit.inventory.ItemStack;
import pl.ziffy.STORMSZAFKA.Main;

public class B
{
    private static final Main D;
    private static ItemStack C;
    private static final Map<String, Integer> B;
    private static final Map<String, Integer> A;
    private static boolean E;
    
    public static void C() {
        final File file = new File(pl.ziffy.STORMSZAFKA.fragments.B.D.getDataFolder(), "fragment.yml");
        if (!file.exists()) {
            B(pl.ziffy.STORMSZAFKA.fragments.B.C = F());
            return;
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
        try {
            pl.ziffy.STORMSZAFKA.fragments.B.C = ((FileConfiguration)loadConfiguration).getItemStack("fragment");
            if (pl.ziffy.STORMSZAFKA.fragments.B.C == null || !pl.ziffy.STORMSZAFKA.fragments.B.C.hasItemMeta()) {
                B(pl.ziffy.STORMSZAFKA.fragments.B.C = F());
            }
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            B(pl.ziffy.STORMSZAFKA.fragments.B.C = F());
        }
    }
    
    private static ItemStack F() {
        final ItemStack itemStack = new ItemStack(Material.RED_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            final String c = C("&cPrzyk\u0142adowe serce");
            final ArrayList lore = new ArrayList();
            lore.add(C("&7"));
            lore.add(C("&8 » &7Jest to przyk\u0142adowe serce,"));
            lore.add(C("&8 » &7aby je zmieni\u0107, we\u017a do r\u0119ki"));
            lore.add(C("&8 » &7przedmiot, kt\u00f3ry chcesz ustawi\u0107"));
            lore.add(C("&8 » &7i wpisz &f/stormszafka heart set&7."));
            lore.add(C("&7"));
            itemMeta.setDisplayName(c);
            itemMeta.setLore((List)lore);
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    private static String C(final String s) {
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
    
    public static void B(final ItemStack itemStack) {
        final File file = new File(pl.ziffy.STORMSZAFKA.fragments.B.D.getDataFolder(), "fragment.yml");
        final YamlConfiguration yamlConfiguration = new YamlConfiguration();
        ((FileConfiguration)yamlConfiguration).set("fragment", (Object)itemStack);
        try {
            ((FileConfiguration)yamlConfiguration).save(file);
            pl.ziffy.STORMSZAFKA.fragments.B.C = itemStack.clone();
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static ItemStack D() {
        if (pl.ziffy.STORMSZAFKA.fragments.B.C == null) {
            C();
        }
        return pl.ziffy.STORMSZAFKA.fragments.B.C.clone();
    }
    
    public static boolean A(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (pl.ziffy.STORMSZAFKA.fragments.B.C == null) {
            C();
            if (pl.ziffy.STORMSZAFKA.fragments.B.C == null) {
                return false;
            }
        }
        if (itemStack.getType() != pl.ziffy.STORMSZAFKA.fragments.B.C.getType()) {
            return false;
        }
        if (!itemStack.hasItemMeta() || !pl.ziffy.STORMSZAFKA.fragments.B.C.hasItemMeta()) {
            return false;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        final ItemMeta itemMeta2 = pl.ziffy.STORMSZAFKA.fragments.B.C.getItemMeta();
        if (!itemMeta.hasDisplayName() || !itemMeta2.hasDisplayName()) {
            return false;
        }
        final String stripColor = ChatColor.stripColor(itemMeta.getDisplayName());
        final String stripColor2 = ChatColor.stripColor(itemMeta2.getDisplayName());
        if (stripColor.contains("Serce") || stripColor.contains("serce")) {}
        return stripColor.equals(stripColor2);
    }
    
    public static int A(final Player player) {
        int n = 0;
        if (pl.ziffy.STORMSZAFKA.fragments.B.C == null || !pl.ziffy.STORMSZAFKA.fragments.B.C.hasItemMeta() || pl.ziffy.STORMSZAFKA.fragments.B.C.getItemMeta().hasDisplayName()) {}
        int n2 = 0;
        for (final ItemStack itemStack : player.getInventory().getContents()) {
            if (itemStack != null) {
                ++n2;
                if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
                    final String stripColor = ChatColor.stripColor(itemStack.getItemMeta().getDisplayName());
                    if (stripColor.contains("Serce") || stripColor.contains("serce") || stripColor.contains("Fragment") || stripColor.contains("fragment")) {}
                }
                if (A(itemStack)) {
                    n += itemStack.getAmount();
                }
            }
        }
        return n;
    }
    
    public static boolean B(final Player player, final int n) {
        int n2 = n;
        for (int i = 0; i < player.getInventory().getSize(); ++i) {
            final ItemStack item = player.getInventory().getItem(i);
            if (A(item)) {
                final int amount = item.getAmount();
                if (amount <= n2) {
                    player.getInventory().setItem(i, (ItemStack)null);
                    n2 -= amount;
                }
                else {
                    item.setAmount(amount - n2);
                    n2 = 0;
                }
                if (n2 == 0) {
                    return true;
                }
            }
        }
        return n2 == 0;
    }
    
    public static int B(final String key) {
        if (pl.ziffy.STORMSZAFKA.fragments.B.A.containsKey(key)) {
            return pl.ziffy.STORMSZAFKA.fragments.B.A.get(key);
        }
        return pl.ziffy.STORMSZAFKA.fragments.B.B.getOrDefault(key, 3);
    }
    
    public static boolean A(final String s, final int i) {
        if (i <= 0) {
            return false;
        }
        pl.ziffy.STORMSZAFKA.fragments.B.A.put(s, i);
        E();
        return true;
    }
    
    public static void A(final String s) {
        pl.ziffy.STORMSZAFKA.fragments.B.A.remove(s);
        E();
    }
    
    private static void E() {
        final File file = new File(pl.ziffy.STORMSZAFKA.fragments.B.D.getDataFolder(), "fragment_costs.yml");
        final YamlConfiguration yamlConfiguration = new YamlConfiguration();
        ((FileConfiguration)yamlConfiguration).set("extension_system_enabled", (Object)pl.ziffy.STORMSZAFKA.fragments.B.E);
        for (Map.Entry entry : pl.ziffy.STORMSZAFKA.fragments.B.A.entrySet()) {
            ((FileConfiguration)yamlConfiguration).set("costs." + (String)entry.getKey(), entry.getValue());
        }
        try {
            ((FileConfiguration)yamlConfiguration).save(file);
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void A() {
        final File file = new File(pl.ziffy.STORMSZAFKA.fragments.B.D.getDataFolder(), "fragment_costs.yml");
        if (!file.exists()) {
            return;
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
        pl.ziffy.STORMSZAFKA.fragments.B.E = ((FileConfiguration)loadConfiguration).getBoolean("extension_system_enabled", true);
        if (((FileConfiguration)loadConfiguration).isConfigurationSection("costs")) {
            for (String s : ((FileConfiguration)loadConfiguration).getConfigurationSection("costs").getKeys(false)) {
                pl.ziffy.STORMSZAFKA.fragments.B.A.put(s, ((FileConfiguration)loadConfiguration).getInt("costs." + s));
            }
        }
    }
    
    public static boolean G() {
        return pl.ziffy.STORMSZAFKA.fragments.B.E;
    }
    
    public static void A(final boolean e) {
        pl.ziffy.STORMSZAFKA.fragments.B.E = e;
        E();
    }
    
    public static void A(final Player player, final int n) {
        final ItemStack d = D();
        int min;
        for (int i = n; i > 0; i -= min) {
            min = Math.min(i, d.getMaxStackSize());
            final ItemStack clone = d.clone();
            clone.setAmount(min);
            final HashMap addItem = player.getInventory().addItem(new ItemStack[] { clone });
            if (!addItem.isEmpty()) {
                player.getWorld().dropItemNaturally(player.getLocation(), (ItemStack)addItem.get(0));
            }
        }
    }
    
    public static void A(final Plugin plugin) {
        A();
    }
    
    public static void B() {
        E();
    }
    
    static {
        D = Main.getInstance();
        pl.ziffy.STORMSZAFKA.fragments.B.C = null;
        B = new HashMap<String, Integer>();
        A = new HashMap<String, Integer>();
        pl.ziffy.STORMSZAFKA.fragments.B.E = true;
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("aniolek", 3);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("balwanek", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("biznesmenik", 4);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("bobas", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("cukiereczek", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("cyber-obronca", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("discordzik", 3);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("drakula", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("duszek", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("elfik", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("enderman", 5);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("eustachy", 5);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("glodomorek", 3);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("golemik", 4);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("leniuszek", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("nietoperek", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("paczus", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("pajak", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("pancernik", 3);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("pedziwiatr", 3);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("pierniczek", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("pisklak", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("pudzianek", 4);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("reniferek", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("rozdymek", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("skalniaczek", 3);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("sowa", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("telekrolik", 6);
        pl.ziffy.STORMSZAFKA.fragments.B.B.put("zajaczek", 6);
    }
}
