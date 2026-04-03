// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets;

import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import java.util.ArrayList;
import pl.ziffy.STORMSZAFKA.utils.time.A;
import java.util.List;
import java.io.IOException;
import java.util.Iterator;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import pl.ziffy.STORMSZAFKA.Main;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.Map;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class G
{
    private Plugin B;
    private FileConfiguration D;
    private Map<String, FileConfiguration> C;
    private static final Pattern A;
    
    public G(final Plugin b) {
        this.C = new HashMap<String, FileConfiguration>();
        this.B = b;
        this.I();
    }
    
    public void I() {
        final File file = new File(((Main)this.B).getCustomDataFolder(), "pets");
        if (!file.exists()) {
            file.mkdirs();
        }
        final File file2 = new File(((Main)this.B).getCustomDataFolder(), "pets.yml");
        if (!file2.exists()) {
            this.B("pets.yml");
        }
        this.D = (FileConfiguration)YamlConfiguration.loadConfiguration(file2);
        final Iterator iterator = this.D.getStringList("enabled_pets").iterator();
        while (iterator.hasNext()) {
            this.F((String)iterator.next());
        }
    }
    
    private void B(final String child) {
        if (!new File(((Main)this.B).getCustomDataFolder(), child).exists()) {
            ((Main)this.B).copyResourceToCustomFolder(child);
        }
    }
    
    private void F(final String s) {
        final File file = new File(((Main)this.B).getCustomDataFolder(), "pets/" + s + ".yml");
        if (!file.exists()) {
            this.B("pets/" + s + ".yml");
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
        this.C.put(s, (FileConfiguration)loadConfiguration);
        ((FileConfiguration)loadConfiguration).getBoolean("enabled", true);
    }
    
    public void J(final String s) {
        this.F(s);
    }
    
    public void E(final String s) {
        final File file = new File(((Main)this.B).getCustomDataFolder(), "pets/" + s + ".yml");
        if (file.exists()) {
            this.C.put(s, (FileConfiguration)YamlConfiguration.loadConfiguration(file));
        }
    }
    
    public void A() {
        this.C.clear();
        this.I();
    }
    
    public boolean H(final String s) {
        if (!this.C.containsKey(s)) {
            this.F(s);
            if (!this.C.containsKey(s)) {
                return true;
            }
        }
        return this.C.get(s).getBoolean("enabled", true);
    }
    
    public boolean A(final String s, final boolean b) {
        try {
            if (!this.C.containsKey(s)) {
                this.F(s);
                if (!this.C.containsKey(s)) {
                    return false;
                }
            }
            final FileConfiguration fileConfiguration = this.C.get(s);
            fileConfiguration.set("enabled", (Object)b);
            fileConfiguration.save(new File(((Main)this.B).getCustomDataFolder(), "pets/" + s + ".yml"));
            final List stringList = this.D.getStringList("enabled_pets");
            if (b && !stringList.contains(s)) {
                stringList.add(s);
                this.D.set("enabled_pets", (Object)stringList);
            }
            else if (!b && stringList.contains(s)) {
                stringList.remove(s);
                this.D.set("enabled_pets", (Object)stringList);
            }
            this.D.save(new File(((Main)this.B).getCustomDataFolder(), "pets.yml"));
            return true;
        }
        catch (final IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public FileConfiguration G(final String key) {
        return this.C.getOrDefault(key, null);
    }
    
    public Object B(final String s, final String s2) {
        final FileConfiguration g = this.G(s);
        if (g == null) {
            return null;
        }
        return g.get(s2);
    }
    
    public String L(final String s) {
        final FileConfiguration g = this.G(s);
        if (g == null) {
            return "&7Pet &7" + s;
        }
        return g.getString("item.display_name", "&7Pet &7" + s);
    }
    
    public String A(final String s, final String s2) {
        String s3 = this.L(s);
        if (s3 == null) {
            return "&7Pet &b" + s + " &7na czas " + pl.ziffy.STORMSZAFKA.utils.time.A.A();
        }
        if (s3.contains("{time}")) {
            String replacement;
            if (s2 == null || s2.equals("brak") || s2.equals("INFINITE")) {
                replacement = pl.ziffy.STORMSZAFKA.utils.time.A.A();
            }
            else {
                replacement = pl.ziffy.STORMSZAFKA.utils.time.A.G(s2);
            }
            s3 = s3.replace("{time}", replacement);
        }
        return s3;
    }
    
    public List<String> I(final String s) {
        final FileConfiguration g = this.G(s);
        if (g == null) {
            return new ArrayList<String>();
        }
        return g.getStringList("item.lore");
    }
    
    public String K(final String s) {
        final FileConfiguration g = this.G(s);
        if (g == null) {
            return null;
        }
        return g.getString("item.texture.value");
    }
    
    public Map<String, Object> A(final String s) {
        final HashMap hashMap = new HashMap();
        final FileConfiguration g = this.G(s);
        if (g == null) {
            hashMap.put((Object)"text", "&b" + s);
            hashMap.put("height", 2.3);
            return hashMap;
        }
        final String string = g.getString("hologram.text", "&b" + s);
        final double double1 = g.getDouble("hologram.height", 2.3);
        hashMap.put("text", string);
        hashMap.put("height", double1);
        return hashMap;
    }
    
    public Map<String, Object> D(final String s, final String s2) {
        final HashMap hashMap = new HashMap();
        final FileConfiguration g = this.G(s);
        if (g == null) {
            hashMap.put("level", 1);
            hashMap.put("visible", false);
            return hashMap;
        }
        final ConfigurationSection configurationSection = g.getConfigurationSection("effects." + s2);
        if (configurationSection == null) {
            hashMap.put("level", 1);
            hashMap.put("visible", false);
            return hashMap;
        }
        final int int1 = configurationSection.getInt("level", 1);
        final boolean boolean1 = configurationSection.getBoolean("visible", false);
        hashMap.put("level", int1);
        hashMap.put("visible", boolean1);
        return hashMap;
    }
    
    public Map<String, Object> D(final String s) {
        final HashMap hashMap = new HashMap();
        final FileConfiguration g = this.G(s);
        if (g == null) {
            hashMap.put("height", 1.0);
            hashMap.put("speed", 0.025);
            hashMap.put("distance", 1.0);
            return hashMap;
        }
        final double double1 = g.getDouble("animation.height", 1.0);
        final double double2 = g.getDouble("animation.speed", 0.025);
        final double double3 = g.getDouble("animation.distance", 1.0);
        hashMap.put("height", double1);
        hashMap.put("speed", double2);
        hashMap.put("distance", double3);
        return hashMap;
    }
    
    public static String C(final String input) {
        if (input == null) {
            return "";
        }
        final Matcher matcher = G.A.matcher(input);
        final StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            final String group = matcher.group(1);
            final StringBuilder sb2 = new StringBuilder("&x");
            final char[] charArray = group.toCharArray();
            for (int length = charArray.length, i = 0; i < length; ++i) {
                sb2.append("&").append(charArray[i]);
            }
            matcher.appendReplacement(sb, sb2.toString());
        }
        matcher.appendTail(sb);
        return ChatColor.translateAlternateColorCodes('&', sb.toString());
    }
    
    public Map<String, Object> G() {
        final HashMap hashMap = new HashMap();
        final FileConfiguration config = this.B.getConfig();
        hashMap.put("floating_enabled", config.getBoolean("pets.animation.floating_enabled", true));
        hashMap.put("rotate_with_player", config.getBoolean("pets.animation.rotate_with_player", true));
        hashMap.put("hide_when_player_invisible", config.getBoolean("pets.animation.hide_when_player_invisible", true));
        hashMap.put("default_position", config.getString("pets.animation.default_position", "RIGHT"));
        hashMap.put("default_distance", config.getDouble("pets.animation.default_distance", 1.0));
        hashMap.put("particles_enabled", config.getBoolean("pets.animation.particles_enabled", false));
        hashMap.put("sounds_enabled", config.getBoolean("pets.animation.sounds_enabled", false));
        hashMap.put("teleport_when_far", config.getBoolean("pets.animation.teleport_when_far", true));
        hashMap.put("teleport_distance", config.getDouble("pets.animation.teleport_distance", 10.0));
        return hashMap;
    }
    
    public String F(final String s, final String replacement) {
        final String string = ((FileConfiguration)YamlConfiguration.loadConfiguration(new File(((Main)this.B).getCustomDataFolder(), "config.yml"))).getString("messages.pet_equipped." + s, "");
        if (string == null || string.isEmpty() || string.equals("&7")) {
            return null;
        }
        return C(string.replace("%pet_name%", replacement));
    }
    
    public String E(final String s, final String replacement) {
        final String string = ((FileConfiguration)YamlConfiguration.loadConfiguration(new File(((Main)this.B).getCustomDataFolder(), "config.yml"))).getString("messages.pet_removed." + s, "");
        if (string == null || string.isEmpty() || string.equals("&7")) {
            return null;
        }
        return C(string.replace("%pet_name%", replacement));
    }
    
    public int[] C() {
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(new File(((Main)this.B).getCustomDataFolder(), "config.yml"));
        return new int[] { ((FileConfiguration)loadConfiguration).getInt("messages.pet_equipped.title_fade_in", 10), ((FileConfiguration)loadConfiguration).getInt("messages.pet_equipped.title_stay", 30), ((FileConfiguration)loadConfiguration).getInt("messages.pet_equipped.title_fade_out", 10) };
    }
    
    public int[] B() {
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(new File(((Main)this.B).getCustomDataFolder(), "config.yml"));
        return new int[] { ((FileConfiguration)loadConfiguration).getInt("messages.pet_removed.title_fade_in", 10), ((FileConfiguration)loadConfiguration).getInt("messages.pet_removed.title_stay", 30), ((FileConfiguration)loadConfiguration).getInt("messages.pet_removed.title_fade_out", 10) };
    }
    
    public String C(final String s, final String replacement) {
        final String string = ((FileConfiguration)YamlConfiguration.loadConfiguration(new File(((Main)this.B).getCustomDataFolder(), "config.yml"))).getString("messages.pet_expired." + s, "");
        if (string == null || string.isEmpty() || string.equals("&7")) {
            return null;
        }
        return C(string.replace("%pet_name%", replacement));
    }
    
    public int[] K() {
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(new File(((Main)this.B).getCustomDataFolder(), "config.yml"));
        return new int[] { ((FileConfiguration)loadConfiguration).getInt("messages.pet_expired.title_fade_in", 10), ((FileConfiguration)loadConfiguration).getInt("messages.pet_expired.title_stay", 40), ((FileConfiguration)loadConfiguration).getInt("messages.pet_expired.title_fade_out", 10) };
    }
    
    public Map<String, Object> F() {
        final HashMap hashMap = new HashMap();
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(new File(((Main)this.B).getCustomDataFolder(), "config.yml"));
        hashMap.put("enabled", ((FileConfiguration)loadConfiguration).getBoolean("messages.pet_equipped.sound.enabled", true));
        hashMap.put("type", ((FileConfiguration)loadConfiguration).getString("messages.pet_equipped.sound.type", "ENTITY_PLAYER_LEVELUP"));
        hashMap.put("volume", ((FileConfiguration)loadConfiguration).getDouble("messages.pet_equipped.sound.volume", 0.5));
        hashMap.put("pitch", ((FileConfiguration)loadConfiguration).getDouble("messages.pet_equipped.sound.pitch", 1.0));
        return hashMap;
    }
    
    public Map<String, Object> H() {
        final HashMap hashMap = new HashMap();
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(new File(((Main)this.B).getCustomDataFolder(), "config.yml"));
        hashMap.put("enabled", ((FileConfiguration)loadConfiguration).getBoolean("messages.pet_removed.sound.enabled", true));
        hashMap.put("type", ((FileConfiguration)loadConfiguration).getString("messages.pet_removed.sound.type", "BLOCK_FIRE_EXTINGUISH"));
        hashMap.put("volume", ((FileConfiguration)loadConfiguration).getDouble("messages.pet_removed.sound.volume", 0.5));
        hashMap.put("pitch", ((FileConfiguration)loadConfiguration).getDouble("messages.pet_removed.sound.pitch", 1.0));
        return hashMap;
    }
    
    public Map<String, Object> J() {
        final HashMap hashMap = new HashMap();
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(new File(((Main)this.B).getCustomDataFolder(), "config.yml"));
        hashMap.put("enabled", ((FileConfiguration)loadConfiguration).getBoolean("messages.pet_expired.sound.enabled", true));
        hashMap.put("type", ((FileConfiguration)loadConfiguration).getString("messages.pet_expired.sound.type", "ENTITY_WITHER_SPAWN"));
        hashMap.put("volume", ((FileConfiguration)loadConfiguration).getDouble("messages.pet_expired.sound.volume", 0.3));
        hashMap.put("pitch", ((FileConfiguration)loadConfiguration).getDouble("messages.pet_expired.sound.pitch", 0.8));
        return hashMap;
    }
    
    public String D() {
        return Main.getInstance().getConfig().getString("pets.preview.extension_cost_line", "&7Koszt przed\u0142u\u017cenia: &c{cost} serc na dzie\u0144!");
    }
    
    public String E() {
        return Main.getInstance().getConfig().getString("pets.preview.extension_cost_prefix", "&7");
    }
    
    static {
        A = Pattern.compile("&#([A-Fa-f0-9]{6})");
    }
}
