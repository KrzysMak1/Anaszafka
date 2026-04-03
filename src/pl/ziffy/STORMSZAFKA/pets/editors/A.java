// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.editors;

import org.bukkit.configuration.file.FileConfiguration;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.CopyOption;
import pl.ziffy.STORMSZAFKA.pets.G;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import pl.ziffy.STORMSZAFKA.Main;

public class A
{
    private static final Main A;
    
    public static String E(final String s) {
        final File file = new File(pl.ziffy.STORMSZAFKA.pets.editors.A.A.getDataFolder(), "pets/" + s + ".yml");
        if (!file.exists()) {
            return s;
        }
        return ((FileConfiguration)YamlConfiguration.loadConfiguration(file)).getString("item.display_name", s);
    }
    
    public static List<String> C(final String s) {
        final File file = new File(pl.ziffy.STORMSZAFKA.pets.editors.A.A.getDataFolder(), "pets/" + s + ".yml");
        if (!file.exists()) {
            return new ArrayList<String>();
        }
        return ((FileConfiguration)YamlConfiguration.loadConfiguration(file)).getStringList("item.lore");
    }
    
    public static String A(final String s) {
        final File file = new File(pl.ziffy.STORMSZAFKA.pets.editors.A.A.getDataFolder(), "pets/" + s + ".yml");
        if (!file.exists()) {
            return "&7Brak hologramu";
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
        if (((FileConfiguration)loadConfiguration).isConfigurationSection("hologram")) {
            return ((FileConfiguration)loadConfiguration).getString("hologram.text", "&7Brak hologramu");
        }
        return ((FileConfiguration)loadConfiguration).getString("hologram", "&7Brak hologramu");
    }
    
    public static String B(final String s) {
        final File file = new File(pl.ziffy.STORMSZAFKA.pets.editors.A.A.getDataFolder(), "pets/" + s + ".yml");
        if (!file.exists()) {
            return "";
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
        final String string = ((FileConfiguration)loadConfiguration).getString("item.texture.value", "");
        if (!string.isEmpty()) {
            return string;
        }
        return ((FileConfiguration)loadConfiguration).getString("item.texture", "");
    }
    
    public static boolean C(final String s, final String s2) {
        if (!s2.contains("{time}")) {
            return false;
        }
        final File file = new File(pl.ziffy.STORMSZAFKA.pets.editors.A.A.getDataFolder(), "pets/" + s + ".yml");
        if (!file.exists()) {
            return false;
        }
        try {
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
            ((FileConfiguration)loadConfiguration).set("item.display_name", (Object)s2);
            ((FileConfiguration)loadConfiguration).save(file);
            final G petConfigManager = Main.getPetConfigManager();
            if (petConfigManager != null) {
                petConfigManager.E(s);
            }
            return true;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean B(final String s, final String s2) {
        final File file = new File(pl.ziffy.STORMSZAFKA.pets.editors.A.A.getDataFolder(), "pets/" + s + ".yml");
        if (!file.exists()) {
            return false;
        }
        try {
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
            ((FileConfiguration)loadConfiguration).set("item.texture.value", (Object)s2);
            ((FileConfiguration)loadConfiguration).save(file);
            final G petConfigManager = Main.getPetConfigManager();
            if (petConfigManager != null) {
                petConfigManager.E(s);
            }
            return true;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean A(final String s, final String s2) {
        final File file = new File(pl.ziffy.STORMSZAFKA.pets.editors.A.A.getDataFolder(), "pets/" + s + ".yml");
        if (!file.exists()) {
            return false;
        }
        try {
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
            if (((FileConfiguration)loadConfiguration).isConfigurationSection("hologram")) {
                ((FileConfiguration)loadConfiguration).set("hologram.text", (Object)s2);
            }
            else {
                ((FileConfiguration)loadConfiguration).set("hologram", (Object)s2);
            }
            ((FileConfiguration)loadConfiguration).save(file);
            final G petConfigManager = Main.getPetConfigManager();
            if (petConfigManager != null) {
                petConfigManager.E(s);
            }
            return true;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static void F(final String s) {
        final File file = new File(pl.ziffy.STORMSZAFKA.pets.editors.A.A.getDataFolder(), "pets/" + s + ".yml");
        try {
            final InputStream resource = pl.ziffy.STORMSZAFKA.pets.editors.A.A.getResource("pets/" + s + ".yml");
            if (resource == null) {
                return;
            }
            Files.copy(resource, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            resource.close();
            final G petConfigManager = Main.getPetConfigManager();
            if (petConfigManager != null) {
                petConfigManager.E(s);
            }
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static FileConfiguration D(final String s) {
        final File file = new File(pl.ziffy.STORMSZAFKA.pets.editors.A.A.getDataFolder(), "pets/" + s + ".yml");
        if (!file.exists()) {
            return null;
        }
        return (FileConfiguration)YamlConfiguration.loadConfiguration(file);
    }
    
    public static void A(final String s, final FileConfiguration fileConfiguration) {
        final File file = new File(pl.ziffy.STORMSZAFKA.pets.editors.A.A.getDataFolder(), "pets/" + s + ".yml");
        try {
            fileConfiguration.save(file);
            final G petConfigManager = Main.getPetConfigManager();
            if (petConfigManager != null) {
                petConfigManager.E(s);
            }
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    static {
        A = Main.getInstance();
    }
}
