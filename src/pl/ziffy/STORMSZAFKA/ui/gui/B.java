// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.ui.gui;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.enchantments.Enchantment;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.bukkit.Material;
import java.util.Iterator;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.configuration.ConfigurationSection;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class B
{
    private final Plugin D;
    private FileConfiguration A;
    private FileConfiguration B;
    private FileConfiguration C;
    
    public B(final Plugin d) {
        this.D = d;
        this.U();
    }
    
    public void U() {
        final File file = new File(((Main)this.D).getCustomDataFolder(), "MenuConfig.yml");
        if (!file.exists()) {
            ((Main)this.D).copyResourceToCustomFolder("MenuConfig.yml");
        }
        this.A = (FileConfiguration)YamlConfiguration.loadConfiguration(file);
        final File file2 = new File(((Main)this.D).getCustomDataFolder(), "PetMenuConfig.yml");
        if (!file2.exists()) {
            ((Main)this.D).copyResourceToCustomFolder("PetMenuConfig.yml");
        }
        this.B = (FileConfiguration)YamlConfiguration.loadConfiguration(file2);
        try {
            final File file3 = new File(((Main)this.D).getCustomDataFolder(), "CostumeMenuConfig.yml");
            if (!file3.exists()) {
                ((Main)this.D).copyResourceToCustomFolder("CostumeMenuConfig.yml");
            }
            this.C = (FileConfiguration)YamlConfiguration.loadConfiguration(file3);
        }
        catch (final Exception ex) {
            this.C = null;
        }
    }
    
    public void J() {
        this.A = (FileConfiguration)YamlConfiguration.loadConfiguration(new File(((Main)this.D).getCustomDataFolder(), "MenuConfig.yml"));
        this.B = (FileConfiguration)YamlConfiguration.loadConfiguration(new File(((Main)this.D).getCustomDataFolder(), "PetMenuConfig.yml"));
        this.C = (FileConfiguration)YamlConfiguration.loadConfiguration(new File(((Main)this.D).getCustomDataFolder(), "CostumeMenuConfig.yml"));
    }
    
    public String C() {
        return ChatColor.translateAlternateColorCodes('&', this.A.getString("gui.title", "&8System szafki"));
    }
    
    public int L() {
        return Math.max(9, this.A.getInt("gui.size", 45) / 9 * 9);
    }
    
    public String T() {
        return ChatColor.translateAlternateColorCodes('&', this.B.getString("gui.title", "&8Lista pet\u00f3w"));
    }
    
    public int G() {
        return Math.max(9, this.B.getInt("gui.size", 54) / 9 * 9);
    }
    
    public boolean O() {
        return this.B.getBoolean("pagination.enabled", true);
    }
    
    public int M() {
        return this.B.getInt("pagination.pets_per_page", 28);
    }
    
    public List<Integer> S() {
        final List integerList = this.B.getIntegerList("pagination.pet_slots");
        if (integerList.isEmpty()) {
            return Arrays.asList(10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43);
        }
        return integerList;
    }
    
    public List<String> I() {
        final ConfigurationSection configurationSection = this.B.getConfigurationSection("available_pets");
        if (configurationSection != null && !configurationSection.getKeys(false).isEmpty()) {
            return new ArrayList<String>(configurationSection.getKeys(false));
        }
        final List stringList = this.B.getStringList("available_pets");
        if (!stringList.isEmpty()) {
            return stringList;
        }
        return Arrays.asList("aniolek", "balwanek", "biznesmenik", "bobas", "cukiereczek", "cyber-obronca", "discordzik", "drakula", "duszek", "elfik", "enderman", "eustachy", "glodomorek", "golemik", "leniuszek", "nietoperek", "paczus", "pajak", "pancernik", "pedziwiatr", "pierniczek", "pisklak", "pudzianek", "reniferek", "rozdymek", "skalniaczek", "sowa", "telekrolik", "zajaczek");
    }
    
    public int D(final String s) {
        final ConfigurationSection configurationSection = this.B.getConfigurationSection("available_pets");
        if (configurationSection != null && configurationSection.contains(s)) {
            final Object value = configurationSection.get(s);
            if (value instanceof final Number n) {
                return n.intValue();
            }
        }
        return -1;
    }
    
    public ItemStack A(final String s) {
        final ConfigurationSection configurationSection = this.B.getConfigurationSection("preview.disabled_pet_item");
        if (configurationSection == null || !configurationSection.getBoolean("enabled", true)) {
            return null;
        }
        final ItemStack a = this.A(configurationSection);
        if (a != null && a.hasItemMeta()) {
            final ItemMeta itemMeta = a.getItemMeta();
            if (itemMeta.hasDisplayName()) {
                itemMeta.setDisplayName(itemMeta.getDisplayName().replace("{pet}", s));
            }
            if (itemMeta.hasLore()) {
                final ArrayList lore = new ArrayList();
                final Iterator iterator = itemMeta.getLore().iterator();
                while (iterator.hasNext()) {
                    lore.add(((String)iterator.next()).replace("{pet}", s));
                }
                itemMeta.setLore((List)lore);
            }
            a.setItemMeta(itemMeta);
        }
        return a;
    }
    
    public String R() {
        if (this.C == null) {
            return ChatColor.translateAlternateColorCodes('&', "&8Lista kostium\u00f3w");
        }
        return ChatColor.translateAlternateColorCodes('&', this.C.getString("gui.title", "&8Lista kostium\u00f3w"));
    }
    
    public int H() {
        if (this.C == null) {
            return 54;
        }
        return Math.max(9, this.C.getInt("gui.size", 54) / 9 * 9);
    }
    
    public ItemStack A(final ConfigurationSection configurationSection) {
        if (configurationSection == null) {
            return null;
        }
        final String string = configurationSection.getString("material", "STONE");
        Material material;
        try {
            material = Material.valueOf(string.toUpperCase());
        }
        catch (final IllegalArgumentException ex) {
            material = Material.STONE;
        }
        final ItemStack itemStack = new ItemStack(material);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            if (configurationSection.contains("name")) {
                itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', configurationSection.getString("name")));
            }
            if (configurationSection.contains("lore")) {
                itemMeta.setLore((List)configurationSection.getStringList("lore").stream().map(s2 -> ChatColor.translateAlternateColorCodes('&', s2)).collect(Collectors.toList()));
            }
            if (configurationSection.getBoolean("glow", false)) {
                itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            }
            final int int1 = configurationSection.getInt("model_data", 0);
            if (int1 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(int1));
            }
            if (configurationSection.contains("flags")) {
                for (final String s : configurationSection.getStringList("flags")) {
                    try {
                        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s.toUpperCase()) });
                    }
                    catch (final IllegalArgumentException ex2) {}
                }
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public int F(final String s, final int n) {
        final ConfigurationSection configurationSection = this.A.getConfigurationSection("items." + s);
        return (configurationSection != null) ? configurationSection.getInt("slot", n) : n;
    }
    
    public ItemStack E(final String s) {
        return this.A(this.A.getConfigurationSection("items." + s));
    }
    
    public int D(final String s, final int n) {
        final ConfigurationSection configurationSection = this.A.getConfigurationSection("costume_items." + s);
        return (configurationSection != null) ? configurationSection.getInt("slot", n) : n;
    }
    
    public ItemStack B(final String s) {
        return this.A(this.A.getConfigurationSection("costume_items." + s));
    }
    
    public int B(final String s, final int n) {
        final ConfigurationSection configurationSection = this.B.getConfigurationSection("items." + s);
        return (configurationSection != null) ? configurationSection.getInt("slot", n) : n;
    }
    
    public ItemStack G(final String s) {
        return this.A(this.B.getConfigurationSection("items." + s));
    }
    
    public int E(final String s, final int n) {
        if (this.C == null) {
            return n;
        }
        final ConfigurationSection configurationSection = this.C.getConfigurationSection("items." + s);
        return (configurationSection != null) ? configurationSection.getInt("slot", n) : n;
    }
    
    public ItemStack C(final String s) {
        if (this.C == null) {
            return null;
        }
        return this.A(this.C.getConfigurationSection("items." + s));
    }
    
    public boolean P() {
        return this.B.getBoolean("preview.show_disabled_pets", true);
    }
    
    public int B() {
        return this.B.getInt("preview.pet_display.start_slot", 10);
    }
    
    public int C(final String s, final int n) {
        if (this.C == null) {
            return n;
        }
        return this.C.getInt("preview.costume_display.custom_slots." + s, n);
    }
    
    public Map<String, Integer> V() {
        final HashMap hashMap = new HashMap();
        if (this.C == null) {
            return hashMap;
        }
        final ConfigurationSection configurationSection = this.C.getConfigurationSection("preview.costume_display.custom_slots");
        if (configurationSection != null) {
            for (final String s : configurationSection.getKeys(false)) {
                hashMap.put(s, configurationSection.getInt(s));
            }
        }
        return hashMap;
    }
    
    public int A(final String s, final int n) {
        final ConfigurationSection configurationSection = this.B.getConfigurationSection("preview.pet_display.custom_slots");
        return (configurationSection != null && configurationSection.contains(s)) ? configurationSection.getInt(s, n) : n;
    }
    
    public boolean F() {
        return this.B.getBoolean("preview.pet_display.show_unavailable_message", true);
    }
    
    public String W() {
        return ChatColor.translateAlternateColorCodes('&', this.B.getString("preview.pet_display.unavailable_message", "&cPet niedost\u0119pny"));
    }
    
    public Map<List<Integer>, ItemStack> A() {
        final HashMap hashMap = new HashMap();
        if (!this.A.getBoolean("decorations.enabled", true)) {
            return hashMap;
        }
        final ConfigurationSection configurationSection = this.A.getConfigurationSection("decorations.items");
        if (configurationSection == null) {
            return hashMap;
        }
        final Iterator iterator = configurationSection.getKeys(false).iterator();
        while (iterator.hasNext()) {
            final ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection((String)iterator.next());
            if (configurationSection2 == null) {
                continue;
            }
            final ItemStack a = this.A(configurationSection2);
            if (a == null) {
                continue;
            }
            final List integerList = configurationSection2.getIntegerList("slots");
            if (integerList.isEmpty()) {
                continue;
            }
            hashMap.put(integerList, a);
        }
        return hashMap;
    }
    
    public Map<List<Integer>, ItemStack> D() {
        final HashMap hashMap = new HashMap();
        if (!this.B.getBoolean("decorations.enabled", true)) {
            return hashMap;
        }
        final ConfigurationSection configurationSection = this.B.getConfigurationSection("decorations.items");
        if (configurationSection == null) {
            return hashMap;
        }
        final Iterator iterator = configurationSection.getKeys(false).iterator();
        while (iterator.hasNext()) {
            final ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection((String)iterator.next());
            if (configurationSection2 == null) {
                continue;
            }
            final ItemStack a = this.A(configurationSection2);
            if (a == null) {
                continue;
            }
            final List integerList = configurationSection2.getIntegerList("slots");
            if (integerList.isEmpty()) {
                continue;
            }
            hashMap.put(integerList, a);
        }
        return hashMap;
    }
    
    public Map<List<Integer>, ItemStack> E() {
        final HashMap hashMap = new HashMap();
        if (this.C == null) {
            return hashMap;
        }
        if (!this.C.getBoolean("decorations.enabled", true)) {
            return hashMap;
        }
        final ConfigurationSection configurationSection = this.C.getConfigurationSection("decorations.items");
        if (configurationSection == null) {
            return hashMap;
        }
        final Iterator iterator = configurationSection.getKeys(false).iterator();
        while (iterator.hasNext()) {
            final ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection((String)iterator.next());
            if (configurationSection2 == null) {
                continue;
            }
            final ItemStack a = this.A(configurationSection2);
            if (a == null) {
                continue;
            }
            final List integerList = configurationSection2.getIntegerList("slots");
            if (integerList.isEmpty()) {
                continue;
            }
            hashMap.put(integerList, a);
        }
        return hashMap;
    }
    
    public String Q() {
        return this.A.getString("stormszafka.title", "§8StormSzafka v1.0");
    }
    
    public int N() {
        return this.A.getInt("stormszafka.size", 27);
    }
    
    public HashMap<List<Integer>, ItemStack> K() {
        return this.B(this.A.getConfigurationSection("stormszafka.decorations"));
    }
    
    private HashMap<List<Integer>, ItemStack> B(final ConfigurationSection configurationSection) {
        final HashMap hashMap = new HashMap();
        if (configurationSection == null) {
            return hashMap;
        }
        final Iterator iterator = configurationSection.getKeys(false).iterator();
        while (iterator.hasNext()) {
            final ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection((String)iterator.next());
            if (configurationSection2 == null) {
                continue;
            }
            final List integerList = configurationSection2.getIntegerList("slots");
            if (integerList.isEmpty()) {
                continue;
            }
            final ItemStack a = this.A(configurationSection2);
            if (a == null) {
                continue;
            }
            hashMap.put(integerList, a);
        }
        return hashMap;
    }
}
