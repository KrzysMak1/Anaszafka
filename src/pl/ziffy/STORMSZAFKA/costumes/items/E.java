// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.items;

import pl.ziffy.STORMSZAFKA.costumes.F;
import pl.ziffy.STORMSZAFKA.costumes.K;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.scheduler.BukkitRunnable;
import pl.ziffy.STORMSZAFKA.messages.A;
import org.bukkit.Particle;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.EventHandler;
import pl.ziffy.STORMSZAFKA.costumes.L;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import pl.ziffy.STORMSZAFKA.utils.C;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.GameMode;
import org.bukkit.plugin.Plugin;
import org.bukkit.inventory.ItemStack;
import pl.ziffy.STORMSZAFKA.costumes.I;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.entity.Player;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.ChatColor;
import java.util.Collection;
import java.util.Iterator;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.function.Function;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.charset.StandardCharsets;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Sound;
import org.bukkit.Color;
import java.util.List;
import org.bukkit.Material;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.potion.PotionEffect;
import java.util.UUID;
import java.util.Map;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.costumes.J;

public class E extends J implements Listener
{
    private static final Map<UUID, Boolean> \u013b;
    private static final Map<UUID, PotionEffect> \u0120;
    private FileConfiguration \u012e;
    private File \u013d;
    private long \u010c;
    private int \u010d;
    private int \u0121;
    private int \u0126;
    private boolean \u0111;
    private boolean \u0110;
    private boolean \u010f;
    private boolean \u0129;
    private Material \u0138;
    private String \u0134;
    private String \u0115;
    private List<String> \u013a;
    private int \u012a;
    private boolean \u013c;
    private List<String> \u012b;
    private Color \u0125;
    private String \u0118;
    private List<String> \u0135;
    private Color \u011f;
    private Color \u0130;
    private Color \u0116;
    private String \u0127;
    private Map<String, String> \u0117;
    private String \u0128;
    private boolean \u0124;
    private List<String> \u011c;
    private Sound \u012d;
    private float \u010e;
    private float \u012f;
    private Sound \u0112;
    private float \u0123;
    private float \u0113;
    private Sound \u0131;
    private float \u0119;
    private float \u0133;
    private String \u0114;
    private String \u011e;
    private String \u0139;
    private String \u0137;
    private String \u011d;
    private String \u011b;
    private String \u011a;
    private Map<String, String> \u0122;
    private boolean \u0136;
    private boolean \u012c;
    private static boolean \u0132;
    
    public E() {
        super("zabojczykrolik", "Zab\u00f3jczy Kr\u00f3lik");
        this.\u013d = new File(Main.getInstance().getCustomDataFolder(), "costumes/KostiumZab\u00f3jczegoKr\u00f3lika.yml");
        this.P();
        if (this.plugin != null && !E.\u0132) {
            Bukkit.getPluginManager().registerEvents((Listener)this, this.plugin);
            E.\u0132 = true;
        }
    }
    
    private void P() {
        try {
            if (!this.\u013d.exists()) {
                this.Q();
            }
            this.\u012e = (FileConfiguration)YamlConfiguration.loadConfiguration(this.\u013d);
            this.N();
        }
        catch (final Exception ex) {
            this.O();
        }
    }
    
    private void Q() {
        try {
            final File parentFile = this.\u013d.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            Files.write(this.\u013d.toPath(), """
                                              # ========= KostiumZab\u00f3jczegoKr\u00f3lika.yml =========
                                              # Konfiguracja kostiumu Zab\u00f3jczego Kr\u00f3lika
                                              # Configuration for Killer Rabbit Costume
                                              # ============================================
                                              
                                              # Og\u00f3lne ustawienia kostiumu / General costume settings
                                              general:
                                                enabled: true
                                              
                                              # Ustawienia przedmiotu aktywacyjnego / Activation item settings
                                              activation_item:
                                                material: LEATHER_CHESTPLATE
                                                display_name: '&7Kostium &fzab\u00f3jczego kr\u00f3lika &7na czas &3{time}'
                                                preview_display_name: '&7Kostium &fzab\u00f3jczego kr\u00f3lika'
                                                duration: '&#F80808NA ZAWSZE'
                                                lore:
                                                - '&8Unikatowa wersja!'
                                                - '&7Zosta\u0142 on wydany w trakcie &fwydarzenia'
                                                - '&fwielkanocnego 2025&7.'
                                                - '&7'
                                                - '&7Dzi\u0119ki temu przedmiotowi otrzymasz'
                                                - '&funikatowy&7 wygl\u0105d oraz &fepickie &7bonusy.'
                                                - '&7'
                                                - '&7Lista bonus\u00f3w:'
                                                - '&8 » &e100% &7odporno\u015bci od upadku'
                                                - '&8 » &7Po p\u0119kni\u0119ciu &etotemu otrzymujesz &csi\u0142\u0119 2'
                                                - '&8 » &7Sta\u0142y efekt &eszybkiego kopania 2'
                                                - '&8 » &7Mo\u017cliwo\u015b\u0107 &bpodw\u00f3jnego skoku &7co &315 sekund'
                                                custom_model_data: 0
                                                unbreakable: true
                                                item_flags:
                                                - HIDE_ATTRIBUTES
                                                - HIDE_UNBREAKABLE
                                                - HIDE_ENCHANTS
                                                - HIDE_DYE
                                                leather_color: 255,255,255
                                              
                                              # Wygl\u0105d zbroi / Armor appearance
                                              armor_appearance:
                                                display_name: '&7Zbroja &fZab\u00f3jczego Kr\u00f3lika'
                                                base_lore:
                                                - '&7'
                                                - '&e&lKliknij&r &7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 &fzbroj\u0119&7!'
                                                armor_colors:
                                                  chestplate: 255,255,255
                                                  leggings: 255,255,255
                                                  boots: 255,255,255
                                                helmet:
                                                  primary_texture: eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWY5ODMzN2I4MjQyMjI5ZDk1ZGEyMzA5MDc1NTc4OTc3OGIxOGJmNWQwN2Q2MWY2MjBjZGJkYmJkMjlmYTYxNSJ9fX0=
                                                unbreakable: true
                                                item_flags:
                                                - HIDE_ATTRIBUTES
                                                - HIDE_UNBREAKABLE
                                                - HIDE_ENCHANTS
                                              
                                              # Efekty kostiumu / Costume effects
                                              effects:
                                                # Ochrona przed upadkiem / Fall damage protection
                                                fall_damage_protection:
                                                  enabled: true
                                                # Si\u0142a po u\u017cyciu totemu / Strength after totem use
                                                totem_strength:
                                                  enabled: true
                                                  duration: 200
                                                  amplifier: 1
                                                # Szybkie kopanie / Fast digging
                                                fast_digging:
                                                  enabled: true
                                                  amplifier: 1
                                                # Podw\u00f3jny skok / Double jump
                                                double_jump:
                                                  enabled: true
                                                  cooldown: 15000
                                                # D\u017awi\u0119ki / Sounds
                                                sounds:
                                                  equip: ITEM_ARMOR_EQUIP_LEATHER
                                                  equip_volume: 1.0
                                                  equip_pitch: 1.0
                                                  double_jump: ENTITY_ENDER_DRAGON_FLAP
                                                  double_jump_volume: 0.5
                                                  double_jump_pitch: 2.0
                                                  totem_strength: ENTITY_PLAYER_LEVELUP
                                                  totem_strength_volume: 1.0
                                                  totem_strength_pitch: 1.5
                                              debug:
                                                enabled: false
                                              """.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
        }
        catch (final IOException ex) {
            Main.getInstance().getLogger().severe("Failed to create default configuration for KostiumZab\u00f3jczegoKr\u00f3lika: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void N() {
        this.\u0111 = this.\u012e.getBoolean("effects.fall_damage_protection.enabled", true);
        this.\u0110 = this.\u012e.getBoolean("effects.totem_strength.enabled", true);
        this.\u010d = this.\u012e.getInt("effects.totem_strength.duration", 200);
        this.\u0121 = this.\u012e.getInt("effects.totem_strength.amplifier", 1);
        this.\u010f = this.\u012e.getBoolean("effects.fast_digging.enabled", true);
        this.\u0126 = this.\u012e.getInt("effects.fast_digging.amplifier", 1);
        this.\u0129 = this.\u012e.getBoolean("effects.double_jump.enabled", true);
        this.\u010c = this.\u012e.getLong("effects.double_jump.cooldown", 15000L);
        this.\u0138 = Material.valueOf(this.\u012e.getString("activation_item.material", "LEATHER_CHESTPLATE"));
        this.\u0134 = this.J(this.\u012e.getString("activation_item.display_name", "&7Kostium &fzab\u00f3jczego kr\u00f3lika &7na czas &3{time}"));
        this.\u0115 = this.J(this.\u012e.getString("activation_item.preview_display_name", "&7Kostium &fzab\u00f3jczego kr\u00f3lika"));
        this.\u013a = (List)this.\u012e.getStringList("activation_item.lore").stream().map(this::J).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.\u012a = this.\u012e.getInt("activation_item.custom_model_data", 0);
        this.\u013c = this.\u012e.getBoolean("activation_item.unbreakable", true);
        this.\u012b = this.\u012e.getStringList("activation_item.item_flags");
        this.\u0125 = this.L(this.\u012e.getString("activation_item.leather_color", "255,255,255"));
        this.\u0118 = this.J(this.\u012e.getString("armor_appearance.display_name", "&7Zbroja &fZab\u00f3jczego Kr\u00f3lika"));
        this.\u0135 = (List)this.\u012e.getStringList("armor_appearance.base_lore").stream().map(this::J).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.\u011f = this.L(this.\u012e.getString("armor_appearance.armor_colors.chestplate", "255,255,255"));
        this.\u0130 = this.L(this.\u012e.getString("armor_appearance.armor_colors.leggings", "255,255,255"));
        this.\u0116 = this.L(this.\u012e.getString("armor_appearance.armor_colors.boots", "255,255,255"));
        this.\u0128 = this.\u012e.getString("armor_appearance.helmet.active_texture", "primary_texture");
        this.\u0117 = new HashMap<String, String>();
        final String string = this.\u012e.getString("armor_appearance.helmet.primary_texture", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWY5ODMzN2I4MjQyMjI5ZDk1ZGEyMzA5MDc1NTc4OTc3OGIxOGJmNWQwN2Q2MWY2MjBjZGJkYmJkMjlmYTYxNSJ9fX0=");
        this.\u0117.put("primary_texture", string);
        if (this.\u012e.contains("armor_appearance.helmet.alternative_textures")) {
            for (String s : this.\u012e.getConfigurationSection("armor_appearance.helmet.alternative_textures").getKeys(false)) {
                final String string2 = this.\u012e.getString("armor_appearance.helmet.alternative_textures." + s);
                if (string2 != null && !string2.isEmpty()) {
                    this.\u0117.put(s, string2);
                }
            }
        }
        this.\u0127 = this.\u0117.getOrDefault(this.\u0128, string);
        this.\u0124 = this.\u012e.getBoolean("armor_appearance.unbreakable", true);
        this.\u011c = this.\u012e.getStringList("armor_appearance.item_flags");
        this.\u012d = Sound.valueOf(this.\u012e.getString("effects.sounds.equip", "ITEM_ARMOR_EQUIP_LEATHER"));
        this.\u010e = (float)this.\u012e.getDouble("effects.sounds.equip_volume", 1.0);
        this.\u012f = (float)this.\u012e.getDouble("effects.sounds.equip_pitch", 1.0);
        this.\u0112 = Sound.valueOf(this.\u012e.getString("effects.sounds.double_jump", "ENTITY_ENDER_DRAGON_FLAP"));
        this.\u0123 = (float)this.\u012e.getDouble("effects.sounds.double_jump_volume", 0.5);
        this.\u0113 = (float)this.\u012e.getDouble("effects.sounds.double_jump_pitch", 2.0);
        this.\u0131 = Sound.valueOf(this.\u012e.getString("effects.sounds.totem_strength", "ENTITY_PLAYER_LEVELUP"));
        this.\u0119 = (float)this.\u012e.getDouble("effects.sounds.totem_strength_volume", 1.0);
        this.\u0133 = (float)this.\u012e.getDouble("effects.sounds.totem_strength_pitch", 1.5);
        this.\u0114 = this.J(this.\u012e.getString("messages.costume_equipped", "&7Za\u0142o\u017cono kostium &fZab\u00f3jczego Kr\u00f3lika&7!"));
        this.\u011e = this.J(this.\u012e.getString("messages.costume_removed", "&7Zdj\u0119to kostium &fZab\u00f3jczego Kr\u00f3lika&7!"));
        this.\u0139 = this.J(this.\u012e.getString("messages.armor_toggle.show_original", "&7Prze\u0142\u0105czono na &foryginaln\u0105 zbroj\u0119"));
        this.\u0137 = this.J(this.\u012e.getString("messages.armor_toggle.show_costume", "&7Prze\u0142\u0105czono na &fkostium"));
        this.\u011d = this.J(this.\u012e.getString("messages.armor_toggle.full_costume_restored", "&7Przywr\u00f3cono pe\u0142ny &fkostium"));
        this.\u011b = this.J(this.\u012e.getString("effects.double_jump.cooldown_message", "&cPodw\u00f3jny skok b\u0119dzie dost\u0119pny za &e{time}&c sekund!"));
        this.\u011a = this.J(this.\u012e.getString("effects.double_jump.use_message", "&aPodw\u00f3jny skok aktywowany!"));
        (this.\u0122 = new HashMap<String, String>()).put("helmet", this.J(this.\u012e.getString("messages.hotbar_equip.helmet", "&7Za\u0142o\u017cono &fhe\u0142m &7pod kostium")));
        this.\u0122.put("chestplate", this.J(this.\u012e.getString("messages.hotbar_equip.chestplate", "&7Za\u0142o\u017cono &fnapier\u015bnik &7pod kostium")));
        this.\u0122.put("leggings", this.J(this.\u012e.getString("messages.hotbar_equip.leggings", "&7Za\u0142o\u017cono &fnogawice &7pod kostium")));
        this.\u0122.put("boots", this.J(this.\u012e.getString("messages.hotbar_equip.boots", "&7Za\u0142o\u017cono &fbuty &7pod kostium")));
    }
    
    private void O() {
        this.\u0111 = true;
        this.\u0110 = true;
        this.\u010d = 200;
        this.\u0121 = 1;
        this.\u010f = true;
        this.\u0126 = 1;
        this.\u0129 = true;
        this.\u010c = 15000L;
        this.\u0138 = Material.LEATHER_CHESTPLATE;
        this.\u0134 = "§7Kostium §fzab\u00f3jczego kr\u00f3lika";
        this.\u0115 = "§7Kostium §fzab\u00f3jczego kr\u00f3lika";
        this.\u013a = new ArrayList<String>(List.of("§8Unikatowa wersja!"));
        this.\u012a = 0;
        this.\u013c = true;
        this.\u012b = new ArrayList<String>(List.of("HIDE_ATTRIBUTES", "HIDE_UNBREAKABLE"));
        this.\u0125 = Color.WHITE;
        this.\u0118 = "§7Zbroja §fZab\u00f3jczego Kr\u00f3lika";
        this.\u0135 = new ArrayList<String>(List.of("§7", "§e§lKliknij§r §7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 §fzbroj\u0119§7!"));
        this.\u011f = Color.WHITE;
        this.\u0130 = Color.WHITE;
        this.\u0116 = Color.WHITE;
        this.\u0127 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWY5ODMzN2I4MjQyMjI5ZDk1ZGEyMzA5MDc1NTc4OTc3OGIxOGJmNWQwN2Q2MWY2MjBjZGJkYmJkMjlmYTYxNSJ9fX0=";
        (this.\u0117 = new HashMap<String, String>()).put("primary_texture", this.\u0127);
        this.\u0128 = "primary_texture";
        this.\u0124 = true;
        this.\u011c = new ArrayList<String>(List.of("HIDE_ATTRIBUTES", "HIDE_UNBREAKABLE"));
        this.\u012d = Sound.ITEM_ARMOR_EQUIP_LEATHER;
        this.\u010e = 1.0f;
        this.\u012f = 1.0f;
        this.\u0112 = Sound.ENTITY_ENDER_DRAGON_FLAP;
        this.\u0123 = 0.5f;
        this.\u0113 = 2.0f;
        this.\u0131 = Sound.ENTITY_PLAYER_LEVELUP;
        this.\u0119 = 1.0f;
        this.\u0133 = 1.5f;
        this.\u0114 = "§7Za\u0142o\u017cono kostium §fZab\u00f3jczego Kr\u00f3lika§7!";
        this.\u011e = "§7Zdj\u0119to kostium §fZab\u00f3jczego Kr\u00f3lika§7!";
        this.\u0139 = "§7Prze\u0142\u0105czono na §foryginaln\u0105 zbroj\u0119";
        this.\u0137 = "§7Prze\u0142\u0105czono na §fkostium";
        this.\u011d = "§7Przywr\u00f3cono pe\u0142ny §fkostium";
        this.\u011b = "§cPodw\u00f3jny skok b\u0119dzie dost\u0119pny za §e{time}§c sekund!";
        this.\u011a = "§aPodw\u00f3jny skok aktywowany!";
        (this.\u0122 = new HashMap<String, String>()).put("helmet", "§7Za\u0142o\u017cono §fhe\u0142m §7pod kostium");
        this.\u0122.put("chestplate", "§7Za\u0142o\u017cono §fnapier\u015bnik §7pod kostium");
        this.\u0122.put("leggings", "§7Za\u0142o\u017cono §fnogawice §7pod kostium");
        this.\u0122.put("boots", "§7Za\u0142o\u017cono §fbuty §7pod kostium");
        this.\u0136 = false;
        this.\u012c = false;
    }
    
    private String J(String k) {
        if (k == null) {
            return null;
        }
        k = this.K(k);
        return ChatColor.translateAlternateColorCodes('&', k);
    }
    
    private String K(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = Pattern.compile("&#([A-Fa-f0-9]{6})").matcher(s);
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
    
    private Color L(final String s) {
        try {
            final String[] split = s.split(",");
            if (split.length == 3) {
                return Color.fromRGB(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()), Integer.parseInt(split[2].trim()));
            }
        }
        catch (final Exception ex) {}
        return Color.WHITE;
    }
    
    private void A(final Player player, final String s) {
        if (player == null || !player.isOnline()) {
            return;
        }
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(s));
    }
    
    public void apply(final Player player) {
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        this.takeArmorSnapshot(player);
        final I i = E.playerArmorMap.get(player.getUniqueId());
        this.A(player, i);
        final ItemStack customHead = this.createCustomHead(this.\u0127);
        final ItemStack coloredArmor = this.createColoredArmor(Material.LEATHER_CHESTPLATE, this.\u011f);
        final ItemStack coloredArmor2 = this.createColoredArmor(Material.LEATHER_LEGGINGS, this.\u0130);
        final ItemStack coloredArmor3 = this.createColoredArmor(Material.LEATHER_BOOTS, this.\u0116);
        if (i.C() != null) {
            this.copyEnchantments(i.C(), customHead);
            this.copyCustomEnchantsToLore(i.C(), customHead);
        }
        if (i.E() != null) {
            this.copyEnchantments(i.E(), coloredArmor);
            this.copyCustomEnchantsToLore(i.E(), coloredArmor);
        }
        if (i.B() != null) {
            this.copyEnchantments(i.B(), coloredArmor2);
            this.copyCustomEnchantsToLore(i.B(), coloredArmor2);
        }
        if (i.A() != null) {
            this.copyEnchantments(i.A(), coloredArmor3);
            this.copyCustomEnchantsToLore(i.A(), coloredArmor3);
        }
        this.D(customHead, "");
        this.D(coloredArmor, "");
        this.D(coloredArmor2, "");
        this.D(coloredArmor3, "");
        player.getInventory().setHelmet(customHead);
        if (!i.D()) {
            player.getInventory().setChestplate(coloredArmor);
        }
        player.getInventory().setLeggings(coloredArmor2);
        player.getInventory().setBoots(coloredArmor3);
        this.applyEffects(player);
        if (this.\u012d != null) {
            player.playSound(player.getLocation(), this.\u012d, this.\u010e, this.\u012f);
        }
    }
    
    private void A(final Player player, final I i) {
        if (i == null) {
            return;
        }
        final ItemStack c = i.C();
        if (c != null && c.getType() == Material.GOLDEN_HELMET && c.hasItemMeta() && c.getItemMeta().hasDisplayName() && c.getItemMeta().getDisplayName().equals("§6Korona ANARCHII")) {
            final Main instance = Main.getInstance();
            if (instance != null && instance.getKoronaAnarchiiSupport() != null) {
                Bukkit.getScheduler().runTaskLater((Plugin)instance, () -> f.checkAndApplyEffects(player2), 5L);
            }
        }
    }
    
    private void E(final Player player) {
        if (player.getGameMode() != GameMode.SURVIVAL && player.getGameMode() != GameMode.ADVENTURE) {
            return;
        }
        player.setAllowFlight(true);
        if (player.isOnGround() && !this.D(player)) {
            E.\u013b.put(player.getUniqueId(), false);
            player.setFlying(false);
        }
    }
    
    public ItemStack createCustomHead(final String s) {
        final ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        final SkullMeta itemMeta = (SkullMeta)itemStack.getItemMeta();
        if (itemMeta != null) {
            pl.ziffy.STORMSZAFKA.utils.C.D(itemMeta, s);
            itemStack.setItemMeta((ItemMeta)itemMeta);
        }
        return itemStack;
    }
    
    private void A(final ItemStack itemStack, final String s, final boolean b) {
        if (itemStack == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return;
        }
        itemMeta.setDisplayName(this.\u0118);
        if (b) {
            itemMeta.setLore((List)new ArrayList(this.\u0135));
        }
        itemMeta.setUnbreakable(this.\u0124);
        for (final String s2 : this.\u011c) {
            try {
                itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s2) });
            }
            catch (final IllegalArgumentException ex) {}
        }
        itemStack.setItemMeta(itemMeta);
    }
    
    private void C(final ItemStack itemStack, final String s) {
        this.A(itemStack, s, true);
    }
    
    private void D(final ItemStack itemStack, final String s) {
        if (itemStack == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return;
        }
        itemMeta.setDisplayName(this.\u0118);
        itemMeta.setUnbreakable(this.\u0124);
        for (final String s2 : this.\u011c) {
            try {
                itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s2) });
            }
            catch (final IllegalArgumentException ex) {}
        }
        itemStack.setItemMeta(itemMeta);
    }
    
    public void remove(final Player player) {
        this.removeEffects(player);
        this.restoreArmorFromSnapshot(player);
        if (player.getGameMode() != GameMode.CREATIVE && player.getGameMode() != GameMode.SPECTATOR) {
            player.setAllowFlight(false);
            player.setFlying(false);
        }
        E.playerArmorMap.remove(player.getUniqueId());
        E.\u013b.remove(player.getUniqueId());
        E.doubleJumpCooldowns.remove(player.getUniqueId());
        E.\u0120.remove(player.getUniqueId());
    }
    
    public void update() {
    }
    
    public ItemStack getCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u0138);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u0134);
            itemMeta.setLore((List)new ArrayList(this.\u013a));
            if (this.\u012a > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u012a));
            }
            itemMeta.setUnbreakable(this.\u013c);
            for (final String s : this.\u012b) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u0125);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public ItemStack getPreviewCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u0138);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u0115);
            itemMeta.setLore((List)new ArrayList(this.\u013a));
            if (this.\u012a > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u012a));
            }
            itemMeta.setUnbreakable(this.\u013c);
            for (final String s : this.\u012b) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u0125);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public void showOriginalArmor(final Player player) {
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        final I i = E.playerArmorMap.get(player.getUniqueId());
        if (i == null) {
            return;
        }
        if (i.C() != null) {
            player.getInventory().setHelmet(i.C().clone());
        }
        else {
            player.getInventory().setHelmet((ItemStack)null);
        }
        if (!i.D()) {
            if (i.E() != null) {
                player.getInventory().setChestplate(i.E().clone());
            }
            else {
                player.getInventory().setChestplate((ItemStack)null);
            }
        }
        if (i.B() != null) {
            player.getInventory().setLeggings(i.B().clone());
        }
        else {
            player.getInventory().setLeggings((ItemStack)null);
        }
        if (i.A() != null) {
            player.getInventory().setBoots(i.A().clone());
        }
        else {
            player.getInventory().setBoots((ItemStack)null);
        }
        if (this.\u012c) {}
    }
    
    public void restoreCostume(final Player player) {
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        final I i = E.playerArmorMap.get(player.getUniqueId());
        if (i == null) {
            return;
        }
        final ItemStack customHead = this.createCustomHead(this.\u0127);
        final ItemStack coloredArmor = this.createColoredArmor(Material.LEATHER_CHESTPLATE, this.\u011f);
        final ItemStack coloredArmor2 = this.createColoredArmor(Material.LEATHER_LEGGINGS, this.\u0130);
        final ItemStack coloredArmor3 = this.createColoredArmor(Material.LEATHER_BOOTS, this.\u0116);
        if (i.C() != null) {
            this.copyEnchantments(i.C(), customHead);
            this.copyCustomEnchantsToLore(i.C(), customHead);
        }
        if (i.E() != null) {
            this.copyEnchantments(i.E(), coloredArmor);
            this.copyCustomEnchantsToLore(i.E(), coloredArmor);
        }
        if (i.B() != null) {
            this.copyEnchantments(i.B(), coloredArmor2);
            this.copyCustomEnchantsToLore(i.B(), coloredArmor2);
        }
        if (i.A() != null) {
            this.copyEnchantments(i.A(), coloredArmor3);
            this.copyCustomEnchantsToLore(i.A(), coloredArmor3);
        }
        this.D(customHead, "");
        this.D(coloredArmor, "");
        this.D(coloredArmor2, "");
        this.D(coloredArmor3, "");
        player.getInventory().setHelmet(customHead);
        if (!i.D()) {
            player.getInventory().setChestplate(coloredArmor);
        }
        player.getInventory().setLeggings(coloredArmor2);
        player.getInventory().setBoots(coloredArmor3);
        boolean b = false;
        if (this.\u010f) {
            final Iterator iterator = player.getActivePotionEffects().iterator();
            while (iterator.hasNext()) {
                if (((PotionEffect)iterator.next()).getType().equals((Object)PotionEffectType.FAST_DIGGING)) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                if (this.\u012c) {}
                this.applyEffects(player);
            }
            else if (this.\u012c) {}
        }
        if (this.\u012c) {}
    }
    
    private boolean B(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if ((itemStack.getType() == Material.PLAYER_HEAD || itemStack.getType() == Material.LEATHER_CHESTPLATE || itemStack.getType() == Material.LEATHER_LEGGINGS || itemStack.getType() == Material.LEATHER_BOOTS) && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            final String lowerCase = itemStack.getItemMeta().getDisplayName().toLowerCase();
            return lowerCase.contains("kostium") || lowerCase.contains("costume") || lowerCase.contains("zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("zabojczego krolika") || lowerCase.contains("zbroja zab\u00f3jczego kr\u00f3lika");
        }
        return false;
    }
    
    private boolean D(final ItemStack itemStack, final ItemStack itemStack2) {
        return (itemStack == null && itemStack2 == null) || (itemStack != null && itemStack2 != null && itemStack.getType() == itemStack2.getType());
    }
    
    public void applyEffects(final Player player) {
        if (this.\u012c) {}
        PotionEffect potionEffect = null;
        for (final PotionEffect potionEffect2 : player.getActivePotionEffects()) {
            if (potionEffect2.getType().equals((Object)PotionEffectType.FAST_DIGGING)) {
                potionEffect = potionEffect2;
                break;
            }
        }
        if (potionEffect != null) {
            E.\u0120.put(player.getUniqueId(), potionEffect);
            if (this.\u012c) {}
        }
        else {
            E.\u0120.remove(player.getUniqueId());
            if (this.\u012c) {}
        }
        if (this.\u010f) {
            if (this.\u012c) {}
            player.removePotionEffect(PotionEffectType.FAST_DIGGING);
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, this.\u0126, false, false));
            if (this.\u012c) {}
        }
        else if (this.\u012c) {}
        if (this.\u0129) {
            this.E(player);
            if (this.\u012c) {}
        }
    }
    
    public void removeEffects(final Player player) {
        player.removePotionEffect(PotionEffectType.FAST_DIGGING);
        final PotionEffect potionEffect = E.\u0120.get(player.getUniqueId());
        if (potionEffect != null) {
            int b = potionEffect.getDuration();
            if (b != Integer.MAX_VALUE) {
                b = Math.max(600, b);
            }
            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, b, potionEffect.getAmplifier(), potionEffect.isAmbient(), potionEffect.hasParticles(), potionEffect.hasIcon()));
            if (this.\u012c) {}
        }
        else if (this.\u012c) {}
        E.\u0120.remove(player.getUniqueId());
    }
    
    private void C(final ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return;
        }
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        itemStack.setItemMeta(itemMeta);
    }
    
    @EventHandler
    public void onFallDamage(final EntityDamageEvent entityDamageEvent) {
        if (!(entityDamageEvent.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityDamageEvent.getEntity();
        if (L.F(player) && L.A(player) instanceof E && entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALL && this.\u0111) {
            entityDamageEvent.setCancelled(true);
            if (this.\u012c) {}
        }
    }
    
    @EventHandler
    public void onTotemUse(final EntityResurrectEvent entityResurrectEvent) {
        if (!(entityResurrectEvent.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityResurrectEvent.getEntity();
        if (!entityResurrectEvent.isCancelled() && "zabojczykrolik".equals(L.D(player)) && this.\u0110) {
            player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, this.\u010d, this.\u0121, true, true));
            player.playSound(player.getLocation(), this.\u0131, this.\u0119, this.\u0133);
        }
    }
    
    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent playerMoveEvent) {
        final Player player = playerMoveEvent.getPlayer();
        if (!L.F(player) || !(L.A(player) instanceof E) || !this.\u0129) {
            return;
        }
        if (player.getGameMode() != GameMode.SURVIVAL && player.getGameMode() != GameMode.ADVENTURE) {
            return;
        }
        if (this.D(player)) {
            return;
        }
        if (player.isOnGround()) {
            E.\u013b.put(player.getUniqueId(), false);
            player.setAllowFlight(true);
            player.setFlying(false);
        }
    }
    
    @EventHandler
    public void onPlayerToggleFlight(final PlayerToggleFlightEvent playerToggleFlightEvent) {
        final Player player = playerToggleFlightEvent.getPlayer();
        if (!L.F(player) || !(L.A(player) instanceof E) || !this.\u0129) {
            return;
        }
        if (player.getGameMode() != GameMode.SURVIVAL && player.getGameMode() != GameMode.ADVENTURE) {
            return;
        }
        if (this.D(player)) {
            playerToggleFlightEvent.setCancelled(true);
            player.setAllowFlight(false);
            player.setFlying(false);
            return;
        }
        final Boolean b = E.\u013b.get(player.getUniqueId());
        if (b != null && !b) {
            playerToggleFlightEvent.setCancelled(true);
            E.\u013b.put(player.getUniqueId(), true);
            player.setVelocity(player.getLocation().getDirection().multiply(0.8).setY(0.8));
            player.setAllowFlight(false);
            player.setFlying(false);
            player.playSound(player.getLocation(), Sound.ENTITY_RABBIT_JUMP, 1.0f, 1.0f);
            player.getWorld().spawnParticle(Particle.CLOUD, player.getLocation(), 10, 0.3, 0.1, 0.3, 0.1);
            if (this.\u011a != null && !this.\u011a.isEmpty()) {
                final A languageManager = Main.getLanguageManager();
                if (languageManager != null) {
                    final String f = languageManager.F("costume.zabojczy-krolik.double-jump-used");
                    if (f != null && !f.isEmpty() && !f.contains("Missing language key")) {
                        player.sendTitle("", f, 10, 20, 5);
                    }
                    else {
                        player.sendTitle("", this.\u011a, 10, 20, 5);
                    }
                }
                else {
                    player.sendTitle("", this.\u011a, 10, 20, 5);
                }
            }
            this.F(player);
        }
    }
    
    private boolean D(final Player player) {
        if (player == null) {
            return false;
        }
        final Long n = E.doubleJumpCooldowns.get(player.getUniqueId());
        return n != null && System.currentTimeMillis() - n < this.\u010c;
    }
    
    private long C(final Player player) {
        if (player == null) {
            return 0L;
        }
        final Long n = E.doubleJumpCooldowns.get(player.getUniqueId());
        if (n == null) {
            return 0L;
        }
        return Math.max(0L, this.\u010c - (System.currentTimeMillis() - n));
    }
    
    private void F(final Player player) {
        if (player == null) {
            return;
        }
        E.doubleJumpCooldowns.put(player.getUniqueId(), System.currentTimeMillis());
        new BukkitRunnable() {
            public void run() {
                if (player.isOnline() && !E.this.D(player) && L.F(player) && L.A(player) instanceof E) {
                    player.setAllowFlight(true);
                    player.playSound(player.getLocation(), Sound.ENTITY_RABBIT_AMBIENT, 0.5f, 1.0f);
                }
            }
        }.runTaskLater(this.plugin, this.\u010c / 50L);
    }
    
    private void G(final Player player) {
        final Main instance = Main.getInstance();
        if (instance != null) {
            final pl.ziffy.STORMSZAFKA.data.E costumeDataManager = instance.getCostumeDataManager();
            if (costumeDataManager != null) {
                costumeDataManager.B(player);
            }
        }
    }
    
    @Override
    protected void copyEnchantments(final ItemStack itemStack, final ItemStack itemStack2) {
        if (itemStack == null || itemStack2 == null) {
            return;
        }
        if (itemStack.hasItemMeta()) {
            final ItemMeta itemMeta = itemStack.getItemMeta();
            final ItemMeta itemMeta2 = itemStack2.getItemMeta();
            if (itemMeta.hasEnchants()) {
                for (final Enchantment enchantment : itemMeta.getEnchants().keySet()) {
                    itemMeta2.addEnchant(enchantment, itemMeta.getEnchantLevel(enchantment), true);
                }
            }
            if (itemStack.getEnchantments() != null && !itemStack.getEnchantments().isEmpty()) {
                for (final Enchantment enchantment2 : itemStack.getEnchantments().keySet()) {
                    final int enchantmentLevel = itemStack.getEnchantmentLevel(enchantment2);
                    if (!itemMeta2.hasEnchant(enchantment2)) {
                        itemMeta2.addEnchant(enchantment2, enchantmentLevel, true);
                    }
                }
            }
            this.A(itemStack, itemStack2, itemMeta, itemMeta2);
            itemStack2.setItemMeta(itemMeta2);
            if (itemMeta.hasEnchants() && !itemStack2.getEnchantments().isEmpty()) {
                final StringBuilder sb = new StringBuilder();
                sb.append("[COSTUME] Final enchantments on costume armor: ");
                for (final Enchantment enchantment3 : itemStack2.getEnchantments().keySet()) {
                    sb.append(enchantment3.getKey().getKey()).append(":").append(itemStack2.getEnchantmentLevel(enchantment3)).append(", ");
                }
            }
            else if (itemMeta.hasEnchants()) {}
        }
    }
    
    private void A(final ItemStack itemStack, final ItemStack itemStack2, final ItemMeta itemMeta, final ItemMeta itemMeta2) {
        try {
            if (itemMeta.hasAttributeModifiers()) {
                itemMeta2.setAttributeModifiers(itemMeta.getAttributeModifiers());
            }
            final double a = this.A(itemStack.getType());
            final double b = this.B(itemStack.getType());
            if (a > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "costume_armor", a, AttributeModifier.Operation.ADD_NUMBER, this.D(itemStack2.getType())));
            }
            if (b > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "costume_toughness", b, AttributeModifier.Operation.ADD_NUMBER, this.D(itemStack2.getType())));
            }
            final double c = this.C(itemStack.getType());
            if (c > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "costume_knockback_resistance", c, AttributeModifier.Operation.ADD_NUMBER, this.D(itemStack2.getType())));
            }
        }
        catch (final Exception ex) {}
    }
    
    private double A(final Material material) {
        switch (E$2.A[material.ordinal()]) {
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
    
    private double B(final Material material) {
        switch (E$2.A[material.ordinal()]) {
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
    
    private double C(final Material material) {
        switch (E$2.A[material.ordinal()]) {
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
    
    private EquipmentSlot D(final Material material) {
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
    
    @Override
    protected void copyCustomEnchantsToLore(final ItemStack itemStack, final ItemStack itemStack2) {
        if (itemStack == null || itemStack2 == null) {
            return;
        }
        final Main instance = Main.getInstance();
        if (instance != null) {
            final K enchantedBookSupport = instance.getEnchantedBookSupport();
            if (enchantedBookSupport != null) {
                enchantedBookSupport.copyEnchantsToLore(itemStack, itemStack2);
            }
        }
    }
    
    public String getHelmetTexture() {
        return this.\u0127;
    }
    
    public Color getChestplateColor() {
        return this.\u011f;
    }
    
    public Color getLeggingsColor() {
        return this.\u0130;
    }
    
    public Color getBootsColor() {
        return this.\u0116;
    }
    
    static {
        \u013b = new HashMap<UUID, Boolean>();
        \u0120 = new HashMap<UUID, PotionEffect>();
        E.\u0132 = false;
    }
}
