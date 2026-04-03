// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.editors;

import org.bukkit.configuration.file.FileConfiguration;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.CopyOption;
import org.bukkit.Color;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;
import pl.ziffy.STORMSZAFKA.Main;

public class CostumesEditorsCostumeEditorController1
{
    private static final Main CostumesEditorsListener1;
    
    public static String F(final String s) {
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return s;
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(c);
        String s2 = ((FileConfiguration)loadConfiguration).getString("activation_item.display_name");
        if (s2 == null) {
            s2 = ((FileConfiguration)loadConfiguration).getString("activation.display_name", s);
        }
        return s2;
    }
    
    public static List<String> J(final String s) {
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return new ArrayList<String>();
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(c);
        List c2 = ((FileConfiguration)loadConfiguration).getStringList("activation_item.lore");
        if (c2 == null || c2.isEmpty()) {
            c2 = ((FileConfiguration)loadConfiguration).getStringList("activation.lore");
        }
        if (c2 == null) {
            return new ArrayList<String>();
        }
        return new ArrayList<String>(c2);
    }
    
    public static Color CostumesEditorsListener2(final String s, final String s2) {
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return Color.WHITE;
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(c);
        final String string = ((FileConfiguration)loadConfiguration).getString("armor_appearance.armor_colors." + s2);
        if (string != null) {
            return CostumesEditorsListener1(string);
        }
        final String s3 = "armor." + s2 + "_color";
        if (((FileConfiguration)loadConfiguration).contains(s3 + ".red")) {
            return Color.fromRGB(((FileConfiguration)loadConfiguration).getInt(s3 + ".red", 255), ((FileConfiguration)loadConfiguration).getInt(s3 + ".green", 255), ((FileConfiguration)loadConfiguration).getInt(s3 + ".blue", 255));
        }
        final String s4 = "armor.colors." + s2;
        if (((FileConfiguration)loadConfiguration).contains(s4 + ".red")) {
            return Color.fromRGB(((FileConfiguration)loadConfiguration).getInt(s4 + ".red", 255), ((FileConfiguration)loadConfiguration).getInt(s4 + ".green", 255), ((FileConfiguration)loadConfiguration).getInt(s4 + ".blue", 255));
        }
        return Color.WHITE;
    }
    
    public static boolean CostumesEditorsListener1(final String s, final String s2) {
        if (!s2.contains("{time}")) {
            return false;
        }
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return false;
        }
        try {
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(c);
            if (((FileConfiguration)loadConfiguration).contains("activation_item.display_name")) {
                ((FileConfiguration)loadConfiguration).set("activation_item.display_name", (Object)s2);
            }
            else {
                ((FileConfiguration)loadConfiguration).set("activation.display_name", (Object)s2);
            }
            ((FileConfiguration)loadConfiguration).save(c);
            return true;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean CostumesEditorsListener1(final String s, final List<String> list) {
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return false;
        }
        try {
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(c);
            if (((FileConfiguration)loadConfiguration).contains("activation_item.lore")) {
                ((FileConfiguration)loadConfiguration).set("activation_item.lore", (Object)list);
            }
            else {
                ((FileConfiguration)loadConfiguration).set("activation.lore", (Object)list);
            }
            ((FileConfiguration)loadConfiguration).save(c);
            return true;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean CostumesEditorsListener1(final String s, final String s2, final Color color) {
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return false;
        }
        try {
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(c);
            final String s3 = "armor_appearance.armor_colors." + s2;
            final String s4 = "armor." + s2 + "_color";
            final String s5 = "armor.colors." + s2;
            if (((FileConfiguration)loadConfiguration).contains("armor_appearance.armor_colors")) {
                ((FileConfiguration)loadConfiguration).set(s3, color.getRed() + "," + color.getGreen() + "," + color.getBlue());
            }
            else if (((FileConfiguration)loadConfiguration).contains(s4 + ".red")) {
                ((FileConfiguration)loadConfiguration).set(s4 + ".red", (Object)color.getRed());
                ((FileConfiguration)loadConfiguration).set(s4 + ".green", (Object)color.getGreen());
                ((FileConfiguration)loadConfiguration).set(s4 + ".blue", (Object)color.getBlue());
            }
            else if (((FileConfiguration)loadConfiguration).contains("armor.colors")) {
                ((FileConfiguration)loadConfiguration).set(s5 + ".red", (Object)color.getRed());
                ((FileConfiguration)loadConfiguration).set(s5 + ".green", (Object)color.getGreen());
                ((FileConfiguration)loadConfiguration).set(s5 + ".blue", (Object)color.getBlue());
            }
            else {
                ((FileConfiguration)loadConfiguration).set(s3, color.getRed() + "," + color.getGreen() + "," + color.getBlue());
            }
            ((FileConfiguration)loadConfiguration).save(c);
            return true;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static Color H(final String s) {
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return Color.WHITE;
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(c);
        if (((FileConfiguration)loadConfiguration).contains("activation_item.leather_color")) {
            final String string = ((FileConfiguration)loadConfiguration).getString("activation_item.leather_color");
            if (string != null && !string.isEmpty()) {
                try {
                    final String[] split = string.split(",");
                    if (split.length == 3) {
                        return Color.fromRGB(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()), Integer.parseInt(split[2].trim()));
                    }
                }
                catch (final Exception ex) {}
            }
        }
        if (((FileConfiguration)loadConfiguration).contains("activation_item.leather_color.red")) {
            return Color.fromRGB(((FileConfiguration)loadConfiguration).getInt("activation_item.leather_color.red", 255), ((FileConfiguration)loadConfiguration).getInt("activation_item.leather_color.green", 255), ((FileConfiguration)loadConfiguration).getInt("activation_item.leather_color.blue", 255));
        }
        if (((FileConfiguration)loadConfiguration).contains("activation.leather_color")) {
            final String string2 = ((FileConfiguration)loadConfiguration).getString("activation.leather_color");
            if (string2 != null && !string2.isEmpty()) {
                try {
                    final String[] split2 = string2.split(",");
                    if (split2.length == 3) {
                        return Color.fromRGB(Integer.parseInt(split2[0].trim()), Integer.parseInt(split2[1].trim()), Integer.parseInt(split2[2].trim()));
                    }
                }
                catch (final Exception ex2) {}
            }
        }
        if (((FileConfiguration)loadConfiguration).contains("activation.leather_color.red")) {
            return Color.fromRGB(((FileConfiguration)loadConfiguration).getInt("activation.leather_color.red", 255), ((FileConfiguration)loadConfiguration).getInt("activation.leather_color.green", 255), ((FileConfiguration)loadConfiguration).getInt("activation.leather_color.blue", 255));
        }
        return Color.WHITE;
    }
    
    public static boolean CostumesEditorsListener1(final String s, final Color color) {
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return false;
        }
        try {
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(c);
            if (((FileConfiguration)loadConfiguration).contains("activation_item.leather_color")) {
                ((FileConfiguration)loadConfiguration).set("activation_item.leather_color.red", (Object)color.getRed());
                ((FileConfiguration)loadConfiguration).set("activation_item.leather_color.green", (Object)color.getGreen());
                ((FileConfiguration)loadConfiguration).set("activation_item.leather_color.blue", (Object)color.getBlue());
            }
            else if (((FileConfiguration)loadConfiguration).contains("activation.leather_color")) {
                ((FileConfiguration)loadConfiguration).set("activation.leather_color.red", (Object)color.getRed());
                ((FileConfiguration)loadConfiguration).set("activation.leather_color.green", (Object)color.getGreen());
                ((FileConfiguration)loadConfiguration).set("activation.leather_color.blue", (Object)color.getBlue());
            }
            else {
                ((FileConfiguration)loadConfiguration).set("activation.leather_color.red", (Object)color.getRed());
                ((FileConfiguration)loadConfiguration).set("activation.leather_color.green", (Object)color.getGreen());
                ((FileConfiguration)loadConfiguration).set("activation.leather_color.blue", (Object)color.getBlue());
            }
            ((FileConfiguration)loadConfiguration).save(c);
            return true;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static String CostumesEditorsListener4(final String s) {
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return null;
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(c);
        final String string = ((FileConfiguration)loadConfiguration).getString("armor_appearance.helmet.primary_texture");
        if (string != null && !string.isEmpty()) {
            return string;
        }
        final String string2 = ((FileConfiguration)loadConfiguration).getString("armor.helmet_texture");
        if (string2 != null && !string2.isEmpty()) {
            return string2;
        }
        return null;
    }
    
    public static boolean CostumesEditorsListener2(final String s) {
        final File c = CostumesEditorsListener3(s);
        return !c.exists() || ((FileConfiguration)YamlConfiguration.loadConfiguration(c)).getBoolean("costume.enabled", true);
    }
    
    public static boolean CostumesEditorsListener1(final String s, final boolean b) {
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return false;
        }
        try {
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(c);
            ((FileConfiguration)loadConfiguration).set("costume.enabled", (Object)b);
            ((FileConfiguration)loadConfiguration).save(c);
            return true;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean CostumesEditorsListener3(final String s, final String s2) {
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return false;
        }
        try {
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(c);
            if (((FileConfiguration)loadConfiguration).contains("armor_appearance.helmet.primary_texture")) {
                ((FileConfiguration)loadConfiguration).set("armor_appearance.helmet.primary_texture", (Object)s2);
            }
            else if (((FileConfiguration)loadConfiguration).contains("armor.helmet_texture")) {
                ((FileConfiguration)loadConfiguration).set("armor.helmet_texture", (Object)s2);
            }
            else {
                ((FileConfiguration)loadConfiguration).set("armor.helmet_texture", (Object)s2);
            }
            ((FileConfiguration)loadConfiguration).save(c);
            return true;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    private static File CostumesEditorsListener3(final String s) {
        final String lowerCase = s.toLowerCase();
        String s2 = null;
        switch (lowerCase) {
            case "zabojczykrolik": {
                s2 = "KostiumZab\u00f3jczegoKr\u00f3lika.yml";
                break;
            }
            case "walentynkowy": {
                s2 = "KostiumWalentynkowy.yml";
                break;
            }
            case "przeciwzakazeniowy": {
                s2 = "KostiumPrzeciwzaka\u017ceniowy.yml";
                break;
            }
            case "malyurwis": {
                s2 = "KostiumMa\u0142egoUrwisa.yml";
                break;
            }
            case "pirata": {
                s2 = "KostiumPirata.yml";
                break;
            }
            case "nurekglebinowy": {
                s2 = "KostiumNurkaG\u0142\u0119binowego.yml";
                break;
            }
            case "mima": {
                s2 = "KostiumMima.yml";
                break;
            }
            case "wampir": {
                s2 = "KostiumWampira.yml";
                break;
            }
            default: {
                s2 = "Kostium" + s.substring(0, 1).toUpperCase() + s.substring(1) + ".yml";
                break;
            }
        }
        final File file = new File(CostumesEditorsCostumeEditorController1.CostumesEditorsListener1.getDataFolder(), "costumes/" + s2);
        if (!file.exists()) {
            try {
                final InputStream resource = CostumesEditorsCostumeEditorController1.CostumesEditorsListener1.getResource("costumes/" + s2);
                if (resource != null) {
                    file.getParentFile().mkdirs();
                    Files.copy(resource, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    resource.close();
                }
            }
            catch (final Exception ex) {}
        }
        return file;
    }
    
    public static int G(final String s) {
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return 5000;
        }
        return ((FileConfiguration)YamlConfiguration.loadConfiguration(c)).getInt("extension.cost_per_day", 5000);
    }
    
    public static boolean CostumesEditorsListener1(final String s, final int i) {
        final File c = CostumesEditorsListener3(s);
        if (!c.exists()) {
            return false;
        }
        try {
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(c);
            ((FileConfiguration)loadConfiguration).set("extension.cost_per_day", (Object)i);
            ((FileConfiguration)loadConfiguration).save(c);
            return true;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    private static Color CostumesEditorsListener1(final String s) {
        try {
            final String[] split = s.split(",");
            if (split.length == 3) {
                return Color.fromRGB(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()), Integer.parseInt(split[2].trim()));
            }
        }
        catch (final Exception ex) {}
        return Color.WHITE;
    }
    
    public static void CostumesEditorsCostumeEditorController1(final String s) {
        try {
            final String lowerCase = s.toLowerCase();
            String s2 = null;
            switch (lowerCase) {
                case "zabojczykrolik": {
                    s2 = "KostiumZab\u00f3jczegoKr\u00f3lika.yml";
                    break;
                }
                case "walentynkowy": {
                    s2 = "KostiumWalentynkowy.yml";
                    break;
                }
                case "przeciwzakazeniowy": {
                    s2 = "KostiumPrzeciwzaka\u017ceniowy.yml";
                    break;
                }
                case "malyurwis": {
                    s2 = "KostiumMa\u0142egoUrwisa.yml";
                    break;
                }
                case "pirata": {
                    s2 = "KostiumPirata.yml";
                    break;
                }
                case "nurekglebinowy": {
                    s2 = "KostiumNurkaG\u0142\u0119binowego.yml";
                    break;
                }
                case "mima": {
                    s2 = "KostiumMima.yml";
                    break;
                }
                default: {
                    s2 = "Kostium" + s.substring(0, 1).toUpperCase() + s.substring(1) + ".yml";
                    break;
                }
            }
            final InputStream resource = CostumesEditorsCostumeEditorController1.CostumesEditorsListener1.getResource("costumes/" + s2);
            if (resource == null) {
                return;
            }
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration((Reader)new InputStreamReader(resource));
            resource.close();
            final File c = CostumesEditorsListener3(s);
            final YamlConfiguration loadConfiguration2 = YamlConfiguration.loadConfiguration(c);
            ((FileConfiguration)loadConfiguration2).set("activation_item.display_name", (Object)((FileConfiguration)loadConfiguration).getString("activation_item.display_name"));
            ((FileConfiguration)loadConfiguration2).set("activation_item.preview_display_name", (Object)((FileConfiguration)loadConfiguration).getString("activation_item.preview_display_name"));
            ((FileConfiguration)loadConfiguration2).set("activation_item.lore", (Object)((FileConfiguration)loadConfiguration).getStringList("activation_item.lore"));
            ((FileConfiguration)loadConfiguration2).set("activation_item.leather_color", (Object)((FileConfiguration)loadConfiguration).getString("activation_item.leather_color"));
            ((FileConfiguration)loadConfiguration2).set("activation_item.custom_model_data", (Object)((FileConfiguration)loadConfiguration).getInt("activation_item.custom_model_data"));
            ((FileConfiguration)loadConfiguration2).set("activation_item.unbreakable", (Object)((FileConfiguration)loadConfiguration).getBoolean("activation_item.unbreakable"));
            ((FileConfiguration)loadConfiguration2).set("activation_item.item_flags", (Object)((FileConfiguration)loadConfiguration).getStringList("activation_item.item_flags"));
            ((FileConfiguration)loadConfiguration2).set("armor_appearance.display_name", (Object)((FileConfiguration)loadConfiguration).getString("armor_appearance.display_name"));
            ((FileConfiguration)loadConfiguration2).set("armor_appearance.base_lore", (Object)((FileConfiguration)loadConfiguration).getStringList("armor_appearance.base_lore"));
            ((FileConfiguration)loadConfiguration2).set("armor_appearance.armor_colors", (Object)((FileConfiguration)loadConfiguration).getConfigurationSection("armor_appearance.armor_colors"));
            ((FileConfiguration)loadConfiguration2).set("armor_appearance.helmet", (Object)((FileConfiguration)loadConfiguration).getConfigurationSection("armor_appearance.helmet"));
            ((FileConfiguration)loadConfiguration2).set("armor_appearance.unbreakable", (Object)((FileConfiguration)loadConfiguration).getBoolean("armor_appearance.unbreakable"));
            ((FileConfiguration)loadConfiguration2).set("armor_appearance.item_flags", (Object)((FileConfiguration)loadConfiguration).getStringList("armor_appearance.item_flags"));
            ((FileConfiguration)loadConfiguration2).set("effects", (Object)((FileConfiguration)loadConfiguration).getConfigurationSection("effects"));
            ((FileConfiguration)loadConfiguration2).set("messages", (Object)((FileConfiguration)loadConfiguration).getConfigurationSection("messages"));
            ((FileConfiguration)loadConfiguration2).set("extension", (Object)((FileConfiguration)loadConfiguration).getConfigurationSection("extension"));
            ((FileConfiguration)loadConfiguration2).set("debug", (Object)((FileConfiguration)loadConfiguration).getConfigurationSection("debug"));
            ((FileConfiguration)loadConfiguration2).save(c);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static boolean CostumesEditorsListener1() {
        final File file = new File(CostumesEditorsCostumeEditorController1.CostumesEditorsListener1.getDataFolder(), "config.yml");
        return !file.exists() || ((FileConfiguration)YamlConfiguration.loadConfiguration(file)).getBoolean("costume.extension.enabled", true);
    }
    
    public static void CostumesEditorsListener1(final boolean b) {
        final File file = new File(CostumesEditorsCostumeEditorController1.CostumesEditorsListener1.getDataFolder(), "config.yml");
        if (!file.exists()) {
            return;
        }
        try {
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
            ((FileConfiguration)loadConfiguration).set("costume.extension.enabled", (Object)b);
            ((FileConfiguration)loadConfiguration).save(file);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static int I(final String s) {
        final File file = new File(CostumesEditorsCostumeEditorController1.CostumesEditorsListener1.getCustomDataFolder(), "CostumeMenuConfig.yml");
        if (!file.exists()) {
            return -1;
        }
        try {
            return ((FileConfiguration)YamlConfiguration.loadConfiguration(file)).getInt("preview.costume_display.custom_slots." + s, -1);
        }
        catch (final Exception ex) {
            return -1;
        }
    }
    
    public static boolean CostumesEditorsListener2(final String s, final int i) {
        final File file = new File(CostumesEditorsCostumeEditorController1.CostumesEditorsListener1.getCustomDataFolder(), "CostumeMenuConfig.yml");
        if (!file.exists()) {
            return false;
        }
        try {
            final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
            ((FileConfiguration)loadConfiguration).set("preview.costume_display.custom_slots." + s, (Object)i);
            ((FileConfiguration)loadConfiguration).save(file);
            return true;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    static {
        CostumesEditorsListener1 = Main.getInstance();
    }
}
