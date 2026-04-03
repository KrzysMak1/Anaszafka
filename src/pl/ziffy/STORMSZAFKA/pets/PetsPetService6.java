// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets;

import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import java.util.ArrayList;
import pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1;
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

public class PetsPetService6
{
    private Plugin PetsPetService2;
    private FileConfiguration PetsPetService3;
    private Map<String, FileConfiguration> PetsListener1;
    private static final Pattern PetsPetService1;
    
    public PetsPetService6(final Plugin b) {
        this.PetsListener1 = new HashMap<String, FileConfiguration>();
        this.PetsPetService2 = b;
        this.I();
    }
    
    public void I() {
        final File file = new File(((Main)this.PetsPetService2).getCustomDataFolder(), "pets");
        if (!file.exists()) {
            file.mkdirs();
        }
        final File file2 = new File(((Main)this.PetsPetService2).getCustomDataFolder(), "pets.yml");
        if (!file2.exists()) {
            this.PetsPetService2("pets.yml");
        }
        this.PetsPetService3 = (FileConfiguration)YamlConfiguration.loadConfiguration(file2);
        final Iterator iterator = this.PetsPetService3.getStringList("enabled_pets").iterator();
        while (iterator.hasNext()) {
            this.PetsPetService5((String)iterator.next());
        }
    }
    
    private void PetsPetService2(final String child) {
        if (!new File(((Main)this.PetsPetService2).getCustomDataFolder(), child).exists()) {
            ((Main)this.PetsPetService2).copyResourceToCustomFolder(child);
        }
    }
    
    private void PetsPetService5(final String s) {
        final File file = new File(((Main)this.PetsPetService2).getCustomDataFolder(), "pets/" + s + ".yml");
        if (!file.exists()) {
            this.PetsPetService2("pets/" + s + ".yml");
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
        this.PetsListener1.put(s, (FileConfiguration)loadConfiguration);
        ((FileConfiguration)loadConfiguration).getBoolean("enabled", true);
    }
    
    public void J(final String s) {
        this.PetsPetService5(s);
    }
    
    public void PetsPetService4(final String s) {
        final File file = new File(((Main)this.PetsPetService2).getCustomDataFolder(), "pets/" + s + ".yml");
        if (file.exists()) {
            this.PetsListener1.put(s, (FileConfiguration)YamlConfiguration.loadConfiguration(file));
        }
    }
    
    public void PetsPetService1() {
        this.PetsListener1.clear();
        this.I();
    }
    
    public boolean H(final String s) {
        if (!this.PetsListener1.containsKey(s)) {
            this.PetsPetService5(s);
            if (!this.PetsListener1.containsKey(s)) {
                return true;
            }
        }
        return this.PetsListener1.get(s).getBoolean("enabled", true);
    }
    
    public boolean PetsPetService1(final String s, final boolean b) {
        try {
            if (!this.PetsListener1.containsKey(s)) {
                this.PetsPetService5(s);
                if (!this.PetsListener1.containsKey(s)) {
                    return false;
                }
            }
            final FileConfiguration fileConfiguration = this.PetsListener1.get(s);
            fileConfiguration.set("enabled", (Object)b);
            fileConfiguration.save(new File(((Main)this.PetsPetService2).getCustomDataFolder(), "pets/" + s + ".yml"));
            final List stringList = this.PetsPetService3.getStringList("enabled_pets");
            if (b && !stringList.contains(s)) {
                stringList.add(s);
                this.PetsPetService3.set("enabled_pets", (Object)stringList);
            }
            else if (!b && stringList.contains(s)) {
                stringList.remove(s);
                this.PetsPetService3.set("enabled_pets", (Object)stringList);
            }
            this.PetsPetService3.save(new File(((Main)this.PetsPetService2).getCustomDataFolder(), "pets.yml"));
            return true;
        }
        catch (final IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public FileConfiguration PetsPetService6(final String key) {
        return this.PetsListener1.getOrDefault(key, null);
    }
    
    public Object PetsPetService2(final String s, final String s2) {
        final FileConfiguration g = this.PetsPetService6(s);
        if (g == null) {
            return null;
        }
        return g.get(s2);
    }
    
    public String L(final String s) {
        final FileConfiguration g = this.PetsPetService6(s);
        if (g == null) {
            return "&7Pet &7" + s;
        }
        return g.getString("item.display_name", "&7Pet &7" + s);
    }
    
    public String PetsPetService1(final String s, final String s2) {
        String s3 = this.L(s);
        if (s3 == null) {
            return "&7Pet &b" + s + " &7na czas " + pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.PetsPetService1();
        }
        if (s3.contains("{time}")) {
            String replacement;
            if (s2 == null || s2.equals("brak") || s2.equals("INFINITE")) {
                replacement = pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.PetsPetService1();
            }
            else {
                replacement = pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.PetsPetService6(s2);
            }
            s3 = s3.replace("{time}", replacement);
        }
        return s3;
    }
    
    public List<String> I(final String s) {
        final FileConfiguration g = this.PetsPetService6(s);
        if (g == null) {
            return new ArrayList<String>();
        }
        return g.getStringList("item.lore");
    }
    
    public String K(final String s) {
        final FileConfiguration g = this.PetsPetService6(s);
        if (g == null) {
            return null;
        }
        return g.getString("item.texture.value");
    }
    
    public Map<String, Object> PetsPetService1(final String s) {
        final HashMap hashMap = new HashMap();
        final FileConfiguration g = this.PetsPetService6(s);
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
    
    public Map<String, Object> PetsPetService3(final String s, final String s2) {
        final HashMap hashMap = new HashMap();
        final FileConfiguration g = this.PetsPetService6(s);
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
    
    public Map<String, Object> PetsPetService3(final String s) {
        final HashMap hashMap = new HashMap();
        final FileConfiguration g = this.PetsPetService6(s);
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
    
    public static String PetsListener1(final String input) {
        if (input == null) {
            return "";
        }
        final Matcher matcher = PetsPetService6.PetsPetService1.matcher(input);
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
    
    public Map<String, Object> PetsPetService6() {
        final HashMap hashMap = new HashMap();
        final FileConfiguration config = this.PetsPetService2.getConfig();
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
    
    public String PetsPetService5(final String s, final String replacement) {
        final String string = ((FileConfiguration)YamlConfiguration.loadConfiguration(new File(((Main)this.PetsPetService2).getCustomDataFolder(), "config.yml"))).getString("messages.pet_equipped." + s, "");
        if (string == null || string.isEmpty() || string.equals("&7")) {
            return null;
        }
        return PetsListener1(string.replace("%pet_name%", replacement));
    }
    
    public String PetsPetService4(final String s, final String replacement) {
        final String string = ((FileConfiguration)YamlConfiguration.loadConfiguration(new File(((Main)this.PetsPetService2).getCustomDataFolder(), "config.yml"))).getString("messages.pet_removed." + s, "");
        if (string == null || string.isEmpty() || string.equals("&7")) {
            return null;
        }
        return PetsListener1(string.replace("%pet_name%", replacement));
    }
    
    public int[] PetsListener1() {
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(new File(((Main)this.PetsPetService2).getCustomDataFolder(), "config.yml"));
        return new int[] { ((FileConfiguration)loadConfiguration).getInt("messages.pet_equipped.title_fade_in", 10), ((FileConfiguration)loadConfiguration).getInt("messages.pet_equipped.title_stay", 30), ((FileConfiguration)loadConfiguration).getInt("messages.pet_equipped.title_fade_out", 10) };
    }
    
    public int[] PetsPetService2() {
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(new File(((Main)this.PetsPetService2).getCustomDataFolder(), "config.yml"));
        return new int[] { ((FileConfiguration)loadConfiguration).getInt("messages.pet_removed.title_fade_in", 10), ((FileConfiguration)loadConfiguration).getInt("messages.pet_removed.title_stay", 30), ((FileConfiguration)loadConfiguration).getInt("messages.pet_removed.title_fade_out", 10) };
    }
    
    public String PetsListener1(final String s, final String replacement) {
        final String string = ((FileConfiguration)YamlConfiguration.loadConfiguration(new File(((Main)this.PetsPetService2).getCustomDataFolder(), "config.yml"))).getString("messages.pet_expired." + s, "");
        if (string == null || string.isEmpty() || string.equals("&7")) {
            return null;
        }
        return PetsListener1(string.replace("%pet_name%", replacement));
    }
    
    public int[] K() {
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(new File(((Main)this.PetsPetService2).getCustomDataFolder(), "config.yml"));
        return new int[] { ((FileConfiguration)loadConfiguration).getInt("messages.pet_expired.title_fade_in", 10), ((FileConfiguration)loadConfiguration).getInt("messages.pet_expired.title_stay", 40), ((FileConfiguration)loadConfiguration).getInt("messages.pet_expired.title_fade_out", 10) };
    }
    
    public Map<String, Object> PetsPetService5() {
        final HashMap hashMap = new HashMap();
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(new File(((Main)this.PetsPetService2).getCustomDataFolder(), "config.yml"));
        hashMap.put("enabled", ((FileConfiguration)loadConfiguration).getBoolean("messages.pet_equipped.sound.enabled", true));
        hashMap.put("type", ((FileConfiguration)loadConfiguration).getString("messages.pet_equipped.sound.type", "ENTITY_PLAYER_LEVELUP"));
        hashMap.put("volume", ((FileConfiguration)loadConfiguration).getDouble("messages.pet_equipped.sound.volume", 0.5));
        hashMap.put("pitch", ((FileConfiguration)loadConfiguration).getDouble("messages.pet_equipped.sound.pitch", 1.0));
        return hashMap;
    }
    
    public Map<String, Object> H() {
        final HashMap hashMap = new HashMap();
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(new File(((Main)this.PetsPetService2).getCustomDataFolder(), "config.yml"));
        hashMap.put("enabled", ((FileConfiguration)loadConfiguration).getBoolean("messages.pet_removed.sound.enabled", true));
        hashMap.put("type", ((FileConfiguration)loadConfiguration).getString("messages.pet_removed.sound.type", "BLOCK_FIRE_EXTINGUISH"));
        hashMap.put("volume", ((FileConfiguration)loadConfiguration).getDouble("messages.pet_removed.sound.volume", 0.5));
        hashMap.put("pitch", ((FileConfiguration)loadConfiguration).getDouble("messages.pet_removed.sound.pitch", 1.0));
        return hashMap;
    }
    
    public Map<String, Object> J() {
        final HashMap hashMap = new HashMap();
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(new File(((Main)this.PetsPetService2).getCustomDataFolder(), "config.yml"));
        hashMap.put("enabled", ((FileConfiguration)loadConfiguration).getBoolean("messages.pet_expired.sound.enabled", true));
        hashMap.put("type", ((FileConfiguration)loadConfiguration).getString("messages.pet_expired.sound.type", "ENTITY_WITHER_SPAWN"));
        hashMap.put("volume", ((FileConfiguration)loadConfiguration).getDouble("messages.pet_expired.sound.volume", 0.3));
        hashMap.put("pitch", ((FileConfiguration)loadConfiguration).getDouble("messages.pet_expired.sound.pitch", 0.8));
        return hashMap;
    }
    
    public String PetsPetService3() {
        return Main.getInstance().getConfig().getString("pets.preview.extension_cost_line", "&7Koszt przed\u0142u\u017cenia: &c{cost} serc na dzie\u0144!");
    }
    
    public String PetsPetService4() {
        return Main.getInstance().getConfig().getString("pets.preview.extension_cost_prefix", "&7");
    }
    
    static {
        PetsPetService1 = Pattern.compile("&#([PetsPetService1-Fa-f0-9]{6})");
    }
}
