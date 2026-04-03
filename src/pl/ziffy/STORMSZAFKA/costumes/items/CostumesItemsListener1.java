// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.items;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.ItemFlag;
import java.util.Collection;
import org.bukkit.inventory.meta.ItemMeta;
import pl.ziffy.STORMSZAFKA.utils.CostumesItemsListener3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemStack;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService4;
import org.bukkit.entity.Player;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.ChatColor;
import java.util.Arrays;
import org.bukkit.configuration.ConfigurationSection;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.charset.StandardCharsets;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Sound;
import java.util.Map;
import org.bukkit.Color;
import java.util.List;
import org.bukkit.Material;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.UUID;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService5;

public class CostumesItemsListener1 extends J implements Listener
{
    private static final UUID \u01aa;
    private static final UUID \u01b8;
    private FileConfiguration \u01bf;
    private File \u01c9;
    private double \u01b6;
    private double \u01bc;
    private boolean \u01a7;
    private double \u01ba;
    private boolean \u01ca;
    private Material \u01c6;
    private String \u01c3;
    private String \u01ab;
    private List<String> \u01c7;
    private int \u01b9;
    private boolean \u01c8;
    private List<String> \u01bb;
    private Color \u01b4;
    private String \u01ae;
    private List<String> \u01c4;
    private Color \u01b2;
    private Color \u01c1;
    private Color \u01ac;
    private String \u01b5;
    private Map<String, String> \u01ad;
    private String \u01b7;
    private boolean \u01b3;
    private List<String> \u01af;
    private Sound \u01be;
    private float \u01a5;
    private float \u01c0;
    private Sound \u01a6;
    private float \u01b1;
    private float \u01a9;
    private boolean \u01b0;
    private boolean \u01c5;
    private boolean \u01bd;
    private static final Map<UUID, Boolean> \u01a8;
    private static boolean \u01c2;
    
    public CostumesItemsListener1() {
        super("walentynkowy", "Kostium Walentynkowy");
        this.\u01c9 = new File(Main.getInstance().getCustomDataFolder(), "costumes/KostiumWalentynkowy.yml");
        this.c();
        if (this.plugin != null && !CostumesItemsListener1.\u01c2) {
            Bukkit.getPluginManager().registerEvents((Listener)this, this.plugin);
            CostumesItemsListener1.\u01c2 = true;
        }
    }
    
    private void c() {
        if (Main.getInstance() == null) {
            return;
        }
        if (!this.\u01c9.exists()) {
            this.b();
        }
        this.\u01bf = (FileConfiguration)YamlConfiguration.loadConfiguration(this.\u01c9);
        this.d();
    }
    
    private void b() {
        try {
            final File parentFile = this.\u01c9.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            Files.write(this.\u01c9.toPath(), """
                                              # ========= KostiumWalentynkowy.yml =========
                                              # Konfiguracja kostiumu Walentynkowy
                                              # ============================================
                                              
                                              
                                              # Podstawowe ustawienia kostiumu
                                              costume:
                                                # Nazwa typu kostiumu (u\u017cywana w kodzie)
                                                type: "walentynkowy"
                                                
                                                # Czy kostium jest aktywny
                                                enabled: true
                                                
                                                # Efekty kostiumu
                                                effects:
                                                  # Bonus do zdrowia (hearts)
                                                  health_bonus: 10 # +5 serc = +10 HP
                                                  
                                                  # Bonus do obra\u017ce\u0144 (w procentach)
                                                  damage_bonus: 12
                                                  
                                                  # Ochrona przed upadkiem
                                                  fall_damage_protection: true
                                                  
                                                  # Bonus do obrony (w procentach)
                                                  defense_bonus: 5
                                                  
                                                  # Czy bonusy s\u0105 sta\u0142e
                                                  permanent_effects: true
                                              
                                              # Przedmiot aktywacyjny kostiumu
                                              activation_item:
                                                # Materia\u0142 przedmiotu
                                                material: LEATHER_CHESTPLATE
                                                
                                                # Nazwa wy\u015bwietlana
                                                display_name: "&7Kostium &dwalentynkowy &7na czas &3{time}"
                                                
                                                # Nazwa dla podgl\u0105du (bez czasu trwania)
                                                preview_display_name: "&7Kostium &dwalentynkowy"
                                                
                                                # Czas trwania
                                                duration: "ZAWSZE"
                                                
                                                # Opis przedmiotu
                                                lore:
                                                  - "&8Unikatowa wersja!"
                                                  - "&7Zosta\u0142 on wydany jako pierwszy w historii serwer\u00f3w"
                                                  - "&7w dniu &aWalentynek (2025)&7, aby uczci\u0107 mi\u0142o\u015b\u0107!"
                                                  - "&7"
                                                  - "&7Dzi\u0119ki temu przedmiotowi otrzymasz"
                                                  - "&funikatowy &7wygl\u0105d oraz &fepickie &7bonusy."
                                                  - "&7"
                                                  - "&7Lista bonus\u00f3w:"
                                                  - "&8 » &4+5 &7serc"
                                                  - "&8 » &c12% &7dodatkowych obra\u017ce\u0144"
                                                  - "&8 » &e100% &7odporno\u015bci od upadku"
                                                  - "&8 » &b+5% &7obrony"
                                                  - "&7"
                                                  - "&8\u25ba &7Kliknij &fPRAWYM &7przyciskiem myszy, aby za\u0142o\u017cy\u0107!"
                                                
                                                # Dane niestandardowe modelu
                                                custom_model_data: 0
                                                
                                                # Czy przedmiot jest niezniszczalny
                                                unbreakable: true
                                                
                                                # Flagi przedmiotu
                                                item_flags:
                                                  - "HIDE_ATTRIBUTES"
                                                  - "HIDE_ENCHANTS"
                                                  - "HIDE_UNBREAKABLE"
                                                  - "HIDE_POTION_EFFECTS"
                                                  - "HIDE_DYE"
                                                
                                                # Kolor sk\u00f3rzanej zbroi (r\u00f3\u017cowy/walentynkowy)
                                                leather_color:
                                                  red: 255
                                                  green: 105
                                                  blue: 180
                                              
                                              # Konfiguracja pancerza kostiumu
                                              armor:
                                                # Nazwa wy\u015bwietlana dla cz\u0119\u015bci pancerza
                                                display_name: "&7Zbroja &dwalentynkowa"
                                                
                                                # Podstawowy opis
                                                base_lore:
                                                  - "&7"
                                                  - "&e&lKliknij&r &7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 &fzbroj\u0119&7!"
                                                
                                                # Kolory pancerza (r\u00f3\u017cowe odcienie walentynkowe)
                                                colors:
                                                  chestplate:
                                                    red: 255
                                                    green: 105
                                                    blue: 180
                                                  leggings:
                                                    red: 255
                                                    green: 105
                                                    blue: 180
                                                  boots:
                                                    red: 255
                                                    green: 105
                                                    blue: 180
                                                
                                                # Tekstura he\u0142mu (serce)
                                                helmet_texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmZhNWMyNmQ3ODIxYmEwNzgzZTQ3NzA1NTUzMTQxYjZkNDdmYjNkODQ4ODVhODUxZWYwNTM1YzRlM2FmYzY4OCJ9fX0="
                                                
                                                # Czy pancerz jest niezniszczalny
                                                unbreakable: true
                                                
                                                # Flagi przedmiotu
                                                item_flags:
                                                  - "HIDE_ATTRIBUTES"
                                                  - "HIDE_ENCHANTS"
                                                  - "HIDE_UNBREAKABLE"
                                                  - "HIDE_POTION_EFFECTS"
                                                  - "HIDE_DYE"
                                              
                                              # CostumesItemsListener4\u017awi\u0119ki kostiumu
                                              sounds:
                                                # CostumesItemsListener4\u017awi\u0119k za\u0142o\u017cenia kostiumu
                                                equip:
                                                  sound: "ENTITY_EXPERIENCE_ORB_PICKUP"
                                                  volume: 1.0
                                                  pitch: 1.2
                                                
                                                # CostumesItemsListener4\u017awi\u0119k specjalnych efekt\u00f3w
                                                effect:
                                                  sound: "ENTITY_PLAYER_LEVELUP"
                                                  volume: 0.8
                                                  pitch: 1.5
                                              debug:
                                                enabled: false
                                              """.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
        }
        catch (final IOException ex) {
            Main.getInstance().getLogger().severe("Failed to create default configuration for KostiumWalentynkowy: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void d() {
        try {
            this.\u01b6 = this.\u01bf.getDouble("costume.effects.health_bonus", 10.0);
            this.\u01bc = this.\u01bf.getDouble("costume.effects.damage_bonus", 12.0);
            this.\u01a7 = this.\u01bf.getBoolean("costume.effects.fall_damage_protection", true);
            this.\u01ba = this.\u01bf.getDouble("costume.effects.defense_bonus", 5.0);
            this.\u01ca = this.\u01bf.getBoolean("costume.effects.permanent_effects", true);
            this.\u01c6 = Material.valueOf(this.\u01bf.getString("activation_item.material", "LEATHER_CHESTPLATE"));
            this.\u01c3 = this.Y(this.\u01bf.getString("activation_item.display_name", "&7Kostium &dwalentynkowy &7na czas &3{time}"));
            this.\u01ab = this.Y(this.\u01bf.getString("activation_item.preview_display_name", "&7Kostium &dwalentynkowy"));
            this.\u01c7 = new ArrayList<String>();
            final Iterator iterator = this.\u01bf.getStringList("activation_item.lore").iterator();
            while (iterator.hasNext()) {
                this.\u01c7.add(this.Y((String)iterator.next()));
            }
            this.\u01b9 = this.\u01bf.getInt("activation_item.custom_model_data", 0);
            this.\u01c8 = this.\u01bf.getBoolean("activation_item.unbreakable", true);
            this.\u01bb = this.\u01bf.getStringList("activation_item.item_flags");
            this.\u01b4 = this.CostumesItemsListener2(this.\u01bf.getConfigurationSection("activation_item.leather_color"));
            final ConfigurationSection configurationSection = this.\u01bf.getConfigurationSection("armor_appearance");
            if (configurationSection != null) {
                this.\u01ae = this.Y(configurationSection.getString("display_name", "&7Zbroja &dWalentynkowa"));
                this.\u01c4 = new ArrayList<String>();
                final Iterator iterator2 = configurationSection.getStringList("base_lore").iterator();
                while (iterator2.hasNext()) {
                    this.\u01c4.add(this.Y((String)iterator2.next()));
                }
            }
            else {
                this.\u01ae = this.Y(this.\u01bf.getString("armor.display_name", "&7Kostium &dwalentynkowy"));
                this.\u01c4 = new ArrayList<String>();
                final Iterator iterator3 = this.\u01bf.getStringList("armor.base_lore").iterator();
                while (iterator3.hasNext()) {
                    this.\u01c4.add(this.Y((String)iterator3.next()));
                }
            }
            if (configurationSection != null) {
                final ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection("armor_colors");
                if (configurationSection2 != null) {
                    this.\u01b2 = this.W(configurationSection2.getString("chestplate", "255,105,180"));
                    this.\u01c1 = this.W(configurationSection2.getString("leggings", "255,105,180"));
                    this.\u01ac = this.W(configurationSection2.getString("boots", "255,105,180"));
                }
                else {
                    this.\u01b2 = this.CostumesItemsListener2(this.\u01bf.getConfigurationSection("armor.colors.chestplate"));
                    this.\u01c1 = this.CostumesItemsListener2(this.\u01bf.getConfigurationSection("armor.colors.leggings"));
                    this.\u01ac = this.CostumesItemsListener2(this.\u01bf.getConfigurationSection("armor.colors.boots"));
                }
                final ConfigurationSection configurationSection3 = configurationSection.getConfigurationSection("helmet");
                if (configurationSection3 != null) {
                    this.\u01b5 = configurationSection3.getString("primary_texture", "");
                }
                else {
                    this.\u01b5 = this.\u01bf.getString("armor.helmet_texture", "");
                }
            }
            else {
                this.\u01b2 = this.CostumesItemsListener2(this.\u01bf.getConfigurationSection("armor.colors.chestplate"));
                this.\u01c1 = this.CostumesItemsListener2(this.\u01bf.getConfigurationSection("armor.colors.leggings"));
                this.\u01ac = this.CostumesItemsListener2(this.\u01bf.getConfigurationSection("armor.colors.boots"));
                this.\u01b5 = this.\u01bf.getString("armor.helmet_texture", "");
            }
            this.\u01ad = new HashMap<String, String>();
            if (this.\u01bf.getConfigurationSection("armor.alternative_textures") != null) {
                for (String s : this.\u01bf.getConfigurationSection("armor.alternative_textures").getKeys(false)) {
                    this.\u01ad.put(s, this.\u01bf.getString("armor.alternative_textures." + s));
                }
            }
            this.\u01b7 = this.\u01bf.getString("armor.active_texture", "default");
            this.\u01b3 = this.\u01bf.getBoolean("armor.unbreakable", true);
            this.\u01af = this.\u01bf.getStringList("armor.item_flags");
            this.\u01be = Sound.valueOf(this.\u01bf.getString("sounds.equip.sound", "ENTITY_EXPERIENCE_ORB_PICKUP"));
            this.\u01a5 = (float)this.\u01bf.getDouble("sounds.equip.volume", 1.0);
            this.\u01c0 = (float)this.\u01bf.getDouble("sounds.equip.pitch", 1.2);
            this.\u01a6 = Sound.valueOf(this.\u01bf.getString("sounds.effect.sound", "ENTITY_PLAYER_LEVELUP"));
            this.\u01b1 = (float)this.\u01bf.getDouble("sounds.effect.volume", 0.8);
            this.\u01a9 = (float)this.\u01bf.getDouble("sounds.effect.pitch", 1.5);
        }
        catch (final Exception ex) {
            this.a();
        }
    }
    
    private void a() {
        this.\u01b6 = 10.0;
        this.\u01bc = 12.0;
        this.\u01a7 = true;
        this.\u01ba = 5.0;
        this.\u01ca = true;
        this.\u01c6 = Material.LEATHER_CHESTPLATE;
        this.\u01c3 = "§7Kostium §dwalentynkowy §7na NA ZAWSZE";
        this.\u01ab = "§7Kostium §dwalentynkowy";
        this.\u01c7 = Arrays.asList("§8Unikatowa wersja!", "§7Zosta\u0142 on wydany jako pierwszy w historii serwer\u00f3w", "§7w dniu §aWalentynek (2025)§7, aby uczci\u0107 mi\u0142o\u015b\u0107!", "§7", "§7Dzi\u0119ki temu przedmiotowi otrzymasz", "§funikatowy §7wygl\u0105d oraz §fepickie §7bonusy.", "§7", "§7Lista bonus\u00f3w:", "§8 » §4+5 §7serc", "§8 » §c12% §7dodatkowych obra\u017ce\u0144", "§8 » §e100% §7odporno\u015bci od upadku", "§8 » §b+5% §7obrony", "§7", "§8\u25ba §7Kliknij §fPRAWYM §7przyciskiem myszy, aby za\u0142o\u017cy\u0107!");
        this.\u01b9 = 0;
        this.\u01c8 = true;
        this.\u01bb = Arrays.asList("HIDE_ATTRIBUTES", "HIDE_ENCHANTS", "HIDE_UNBREAKABLE", "HIDE_POTION_EFFECTS");
        this.\u01b4 = Color.fromRGB(255, 105, 180);
        this.\u01ae = "§7Kostium §dwalentynkowy";
        this.\u01c4 = Arrays.asList("§8Unikatowa wersja!", "§7Zosta\u0142 on wydany jako pierwszy w historii serwer\u00f3w", "§7w dniu §aWalentynek (2025)§7, aby uczci\u0107 mi\u0142o\u015b\u0107!", "§7", "§7Lista bonus\u00f3w:", "§8 » §4+5 §7serc", "§8 » §c12% §7dodatkowych obra\u017ce\u0144", "§8 » §e100% §7odporno\u015bci od upadku", "§8 » §b+5% §7obrony");
        this.\u01b2 = Color.fromRGB(255, 105, 180);
        this.\u01c1 = Color.fromRGB(255, 20, 147);
        this.\u01ac = Color.fromRGB(220, 20, 60);
        this.\u01b5 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHBzOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2Y5NzM3MmU5MjQ0NDI2YWIzN2Y4ZWRkMWY4NzE5MzdjYzIzM2YzNjVmODJkNTYzNDkzNmE3MTRhZGRjMDUxMjcifX19";
        (this.\u01ad = new HashMap<String, String>()).put("default", this.\u01b5);
        this.\u01ad.put("heart", this.\u01b5);
        this.\u01b7 = "default";
        this.\u01b3 = true;
        this.\u01af = Arrays.asList("HIDE_ATTRIBUTES", "HIDE_ENCHANTS", "HIDE_UNBREAKABLE", "HIDE_POTION_EFFECTS");
        this.\u01be = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
        this.\u01a5 = 1.0f;
        this.\u01c0 = 1.2f;
        this.\u01a6 = Sound.ENTITY_PLAYER_LEVELUP;
        this.\u01b1 = 0.8f;
        this.\u01a9 = 1.5f;
        this.\u01b0 = false;
        this.\u01c5 = false;
        this.\u01bd = false;
    }
    
    private String Y(String x) {
        if (x == null) {
            return null;
        }
        x = this.X(x);
        return ChatColor.translateAlternateColorCodes('&', x);
    }
    
    private String X(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = Pattern.compile("&#([CostumesItemsListener1-Fa-f0-9]{6})").matcher(s);
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
    
    private Color CostumesItemsListener2(final ConfigurationSection configurationSection) {
        if (configurationSection == null) {
            return Color.fromRGB(255, 105, 180);
        }
        return Color.fromRGB(configurationSection.getInt("red", 255), configurationSection.getInt("green", 105), configurationSection.getInt("blue", 180));
    }
    
    private Color W(final String s) {
        if (s == null || s.isEmpty()) {
            return Color.fromRGB(255, 105, 180);
        }
        try {
            final String[] split = s.split(",");
            if (split.length == 3) {
                return Color.fromRGB(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()), Integer.parseInt(split[2].trim()));
            }
        }
        catch (final Exception ex) {}
        return Color.fromRGB(255, 105, 180);
    }
    
    public void apply(final Player player) {
        this.takeArmorSnapshot(player);
        final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
        final ItemStack customHead = this.createCustomHead(this.\u01b5);
        final ItemStack coloredArmor = this.createColoredArmor(Material.LEATHER_CHESTPLATE, this.\u01b2);
        final ItemStack coloredArmor2 = this.createColoredArmor(Material.LEATHER_LEGGINGS, this.\u01c1);
        final ItemStack coloredArmor3 = this.createColoredArmor(Material.LEATHER_BOOTS, this.\u01ac);
        if (playerArmorSnapshot != null) {
            if (playerArmorSnapshot.CostumesItemsListener3() != null) {
                this.I(playerArmorSnapshot.CostumesItemsListener3(), customHead);
            }
            if (playerArmorSnapshot.CostumesItemsListener5() != null) {
                this.I(playerArmorSnapshot.CostumesItemsListener5(), coloredArmor);
            }
            if (playerArmorSnapshot.CostumesItemsListener2() != null) {
                this.I(playerArmorSnapshot.CostumesItemsListener2(), coloredArmor2);
            }
            if (playerArmorSnapshot.CostumesItemsListener1() != null) {
                this.I(playerArmorSnapshot.CostumesItemsListener1(), coloredArmor3);
            }
        }
        this.CostumesItemsListener2(customHead, "helmet", true);
        this.CostumesItemsListener2(coloredArmor, "chestplate", true);
        this.CostumesItemsListener2(coloredArmor2, "leggings", true);
        this.CostumesItemsListener2(coloredArmor3, "boots", true);
        player.getInventory().setHelmet(customHead);
        if (playerArmorSnapshot == null || !playerArmorSnapshot.CostumesItemsListener4()) {
            player.getInventory().setChestplate(coloredArmor);
        }
        player.getInventory().setLeggings(coloredArmor2);
        player.getInventory().setBoots(coloredArmor3);
        this.applyEffects(player);
    }
    
    public ItemStack createCustomHead(final String s) {
        if (s == null || s.isEmpty()) {
            return new ItemStack(Material.PLAYER_HEAD);
        }
        final ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        final SkullMeta itemMeta = (SkullMeta)itemStack.getItemMeta();
        if (itemMeta != null) {
            pl.ziffy.STORMSZAFKA.utils.CostumesItemsListener3.CostumesItemsListener4(itemMeta, s);
            itemStack.setItemMeta((ItemMeta)itemMeta);
        }
        return itemStack;
    }
    
    private void CostumesItemsListener2(final ItemStack itemStack, final String s, final boolean b) {
        if (itemStack == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return;
        }
        itemMeta.setDisplayName(this.\u01ae);
        if (b) {
            itemMeta.setLore((List)new ArrayList(this.\u01c4));
        }
        itemMeta.setUnbreakable(this.\u01b3);
        for (final String s2 : this.\u01af) {
            try {
                itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s2) });
            }
            catch (final IllegalArgumentException ex) {}
        }
        if (itemStack.getType().name().contains("LEATHER")) {
            itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_DYE });
        }
        itemStack.setItemMeta(itemMeta);
    }
    
    public void remove(final Player player) {
        this.removeEffects(player);
        this.restoreArmorFromSnapshot(player);
        CostumesItemsListener1.playerArmorMap.remove(player.getUniqueId());
        CostumesItemsListener1.\u01a8.remove(player.getUniqueId());
    }
    
    public void update() {
    }
    
    public ItemStack getCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u01c6);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u01c3);
            itemMeta.setLore((List)new ArrayList(this.\u01c7));
            if (this.\u01b9 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u01b9));
            }
            if (this.\u01c8) {
                itemMeta.setUnbreakable(true);
            }
            for (final String s : this.\u01bb) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u01b4);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public ItemStack getPreviewCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u01c6);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u01ab);
            final ArrayList lore = new ArrayList((Collection<? extends CostumesItemsListener5>)this.\u01c7);
            lore.removeIf(s2 -> {
                ChatColor.stripColor(s2);
                final String s3;
                return s3.contains("Kliknij") || s3.contains("przyciskiem");
            });
            itemMeta.setLore((List)lore);
            if (this.\u01b9 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u01b9));
            }
            if (this.\u01c8) {
                itemMeta.setUnbreakable(true);
            }
            for (final String s : this.\u01bb) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u01b4);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public void showOriginalArmor(final Player player) {
        this.restoreArmorFromSnapshot(player);
    }
    
    public void restoreCostume(final Player player) {
        this.apply(player);
    }
    
    private boolean CostumesItemsListener4(final ItemStack itemStack) {
        if (itemStack == null || !itemStack.hasItemMeta()) {
            return false;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (!itemMeta.hasDisplayName()) {
            return false;
        }
        final String displayName = itemMeta.getDisplayName();
        return displayName.contains("Kostium") && displayName.contains("walentynkowy");
    }
    
    private boolean CostumesItemsListener8(final ItemStack itemStack, final ItemStack itemStack2) {
        return (itemStack == null && itemStack2 == null) || (itemStack != null && itemStack2 != null && itemStack.getType() == itemStack2.getType());
    }
    
    public void applyEffects(final Player player) {
        CostumesItemsListener1.\u01a8.put(player.getUniqueId(), true);
        final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (attribute != null) {
            for (final AttributeModifier attributeModifier : attribute.getModifiers()) {
                if (attributeModifier.getUniqueId().equals(CostumesItemsListener1.\u01aa)) {
                    attribute.removeModifier(attributeModifier);
                    break;
                }
            }
            attribute.addModifier(new AttributeModifier(CostumesItemsListener1.\u01aa, "valentine_health_bonus", this.\u01b6, AttributeModifier.Operation.ADD_NUMBER));
            final double health = player.getHealth();
            final double value = attribute.getValue();
            if (health > value) {
                player.setHealth(value);
            }
        }
    }
    
    public void removeEffects(final Player player) {
        final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (attribute != null) {
            for (final AttributeModifier attributeModifier : attribute.getModifiers()) {
                if (attributeModifier.getUniqueId().equals(CostumesItemsListener1.\u01aa)) {
                    attribute.removeModifier(attributeModifier);
                    break;
                }
            }
        }
        CostumesItemsListener1.\u01a8.remove(player.getUniqueId());
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onFallDamage(final EntityDamageEvent entityDamageEvent) {
        if (!(entityDamageEvent.getEntity() instanceof Player)) {
            return;
        }
        if (entityDamageEvent.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        final Player player = (Player)entityDamageEvent.getEntity();
        if (L.CostumesItemsListener6(player) && L.CostumesItemsListener1(player) instanceof CostumesItemsListener1 && this.\u01a7) {
            entityDamageEvent.setCancelled(true);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!(entityDamageByEntityEvent.getDamager() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityDamageByEntityEvent.getDamager();
        if (L.CostumesItemsListener6(player) && L.CostumesItemsListener1(player) instanceof CostumesItemsListener1 && this.\u01bc > 0.0) {
            final double damage = entityDamageByEntityEvent.getDamage();
            entityDamageByEntityEvent.setDamage(damage + damage * (this.\u01bc / 100.0));
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerTakeDamage(final EntityDamageEvent entityDamageEvent) {
        if (!(entityDamageEvent.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityDamageEvent.getEntity();
        if (L.CostumesItemsListener6(player) && L.CostumesItemsListener1(player) instanceof CostumesItemsListener1 && this.\u01ba > 0.0) {
            final double damage = entityDamageEvent.getDamage();
            entityDamageEvent.setDamage(damage - damage * (this.\u01ba / 100.0));
        }
    }
    
    public String getHelmetTexture() {
        return this.\u01ad.getOrDefault(this.\u01b7, this.\u01b5);
    }
    
    public Color getChestplateColor() {
        return this.\u01b2;
    }
    
    public Color getLeggingsColor() {
        return this.\u01c1;
    }
    
    public Color getBootsColor() {
        return this.\u01ac;
    }
    
    private void I(final ItemStack itemStack, final ItemStack itemStack2) {
        if (itemStack == null || itemStack2 == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        final ItemMeta itemMeta2 = itemStack2.getItemMeta();
        if (itemMeta == null || itemMeta2 == null) {
            return;
        }
        try {
            if (itemMeta.hasAttributeModifiers()) {
                for (final Attribute attribute : itemMeta.getAttributeModifiers().keySet()) {
                    final Iterator iterator2 = itemMeta.getAttributeModifiers(attribute).iterator();
                    while (iterator2.hasNext()) {
                        itemMeta2.addAttributeModifier(attribute, (AttributeModifier)iterator2.next());
                    }
                }
            }
            final double p2 = this.P(itemStack.getType());
            final double o = this.O(itemStack.getType());
            final double n = this.N(itemStack.getType());
            if (p2 > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "costume_armor", p2, AttributeModifier.Operation.ADD_NUMBER, this.M(itemStack2.getType())));
            }
            if (o > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "costume_toughness", o, AttributeModifier.Operation.ADD_NUMBER, this.M(itemStack2.getType())));
            }
            if (n > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "costume_knockback_resistance", n, AttributeModifier.Operation.ADD_NUMBER, this.M(itemStack2.getType())));
            }
            if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasEnchants()) {
                for (final Enchantment enchantment : itemStack.getEnchantments().keySet()) {
                    itemMeta2.addEnchant(enchantment, itemStack.getEnchantmentLevel(enchantment), true);
                }
            }
            itemStack2.setItemMeta(itemMeta2);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private double P(final Material material) {
        switch (CostumesItemsListener1$1.CostumesItemsListener1[material.ordinal()]) {
            case 1: {
                return 1.0;
            }
            case 2: {
                return 3.0;
            }
            case 3: {
                return 2.0;
            }
            case 4: {
                return 1.0;
            }
            case 5: {
                return 2.0;
            }
            case 6: {
                return 5.0;
            }
            case 7: {
                return 4.0;
            }
            case 8: {
                return 1.0;
            }
            case 9: {
                return 2.0;
            }
            case 10: {
                return 6.0;
            }
            case 11: {
                return 5.0;
            }
            case 12: {
                return 2.0;
            }
            case 13: {
                return 2.0;
            }
            case 14: {
                return 5.0;
            }
            case 15: {
                return 3.0;
            }
            case 16: {
                return 1.0;
            }
            case 17: {
                return 3.0;
            }
            case 18: {
                return 8.0;
            }
            case 19: {
                return 6.0;
            }
            case 20: {
                return 3.0;
            }
            case 21: {
                return 3.0;
            }
            case 22: {
                return 8.0;
            }
            case 23: {
                return 6.0;
            }
            case 24: {
                return 3.0;
            }
            case 25: {
                return 2.0;
            }
            default: {
                return 0.0;
            }
        }
    }
    
    private double O(final Material material) {
        switch (CostumesItemsListener1$1.CostumesItemsListener1[material.ordinal()]) {
            case 17:
            case 18:
            case 19:
            case 20: {
                return 2.0;
            }
            case 21:
            case 22:
            case 23:
            case 24: {
                return 3.0;
            }
            default: {
                return 0.0;
            }
        }
    }
    
    private double N(final Material material) {
        switch (CostumesItemsListener1$1.CostumesItemsListener1[material.ordinal()]) {
            case 21:
            case 22:
            case 23:
            case 24: {
                return 0.1;
            }
            default: {
                return 0.0;
            }
        }
    }
    
    private EquipmentSlot M(final Material material) {
        final String name = material.name();
        if (name.contains("HELMET") || name.equals("TURTLE_HELMET") || material == Material.PLAYER_HEAD) {
            return EquipmentSlot.HEAD;
        }
        if (name.contains("CHESTPLATE")) {
            return EquipmentSlot.CHEST;
        }
        if (name.contains("LEGGINGS")) {
            return EquipmentSlot.LEGS;
        }
        if (name.contains("BOOTS")) {
            return EquipmentSlot.FEET;
        }
        return EquipmentSlot.CHEST;
    }
    
    static {
        \u01aa = UUID.fromString("11111111-2222-3333-4444-555555555555");
        \u01b8 = UUID.fromString("66666666-7777-8888-9999-aaaaaaaaaaaa");
        \u01a8 = new HashMap<UUID, Boolean>();
        CostumesItemsListener1.\u01c2 = false;
    }
}
