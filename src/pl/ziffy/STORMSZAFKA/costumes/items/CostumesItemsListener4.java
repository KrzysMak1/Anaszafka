// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.items;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.block.BlockState;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.block.ShulkerBox;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import java.util.Collection;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import pl.ziffy.STORMSZAFKA.utils.CostumesItemsListener3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemStack;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService4;
import org.bukkit.entity.Player;
import org.bukkit.configuration.ConfigurationSection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.ChatColor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.charset.StandardCharsets;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.Main;
import java.util.UUID;
import java.util.Map;
import org.bukkit.Sound;
import org.bukkit.Color;
import java.util.List;
import org.bukkit.Material;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService5;

public class CostumesItemsListener4 extends J implements Listener
{
    private FileConfiguration \u00fd;
    private File \u010a;
    private double \u00f3;
    private double \u00fa;
    private double \u00e5;
    private double \u00fb;
    private int \u0106;
    private boolean \u0109;
    private boolean \u00e1;
    private Material \u0105;
    private String \u0102;
    private String \u00e9;
    private String \u00eb;
    private String \u00f2;
    private List<String> \u0107;
    private List<String> \u00f9;
    private List<String> \u0103;
    private List<String> \u00ec;
    private int \u00f8;
    private boolean \u0108;
    private boolean \u00f0;
    private Color \u00f1;
    private Color \u00ef;
    private Color \u00ff;
    private Color \u00ea;
    private Sound \u00fc;
    private Sound \u00e2;
    private float \u00e0;
    private float \u00fe;
    private float \u00ed;
    private float \u00e4;
    private static final Map<UUID, Long> \u010b;
    private static final Map<UUID, Boolean> \u00e3;
    private boolean \u00f5;
    private int \u00e6;
    private int \u00df;
    private int \u00e7;
    private static final Map<UUID, Long> \u0104;
    private String \u00e8;
    private String \u00ee;
    private String \u00f6;
    private String \u0101;
    private String \u00de;
    private static boolean \u0100;
    private static final Map<UUID, Integer> \u00f4;
    
    public CostumesItemsListener4() {
        super("wampir", "Kostium Wampira");
        this.\u010a = new File(Main.getInstance().getCustomDataFolder(), "costumes/KostiumWampira.yml");
        this.L();
        if (this.plugin != null && !CostumesItemsListener4.\u0100) {
            Bukkit.getPluginManager().registerEvents((Listener)this, this.plugin);
            CostumesItemsListener4.\u0100 = true;
        }
    }
    
    private void L() {
        if (!this.\u010a.exists()) {
            this.K();
        }
        this.\u00fd = (FileConfiguration)YamlConfiguration.loadConfiguration(this.\u010a);
        this.M();
    }
    
    private void K() {
        try {
            final File parentFile = this.\u010a.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            Files.write(this.\u010a.toPath(), """
                                              costume:
                                                type: "wampir"
                                                enabled: true
                                                effects:
                                                  health_bonus: 8
                                                  damage_bonus: 10
                                                  vampire_kiss:
                                                    enabled: true
                                                    chance: 30
                                                    heal_percentage: 7
                                                    cooldown: 20
                                                  shulker_opening: true
                                              activation_item:
                                                material: LEATHER_CHESTPLATE
                                                display_name: "&7Kostium &cwampira &7na &3{time}"
                                                preview_display_name: "&7Kostium &cwampira"
                                                lore:
                                                  - "&8Unikatowa wersja!"
                                                  - "&7Zosta\u0142 on wydany w trakcie &fwydarzenia"
                                                  - "&fz okazji dnia dziecka 2025&7."
                                                  - "&7"
                                                  - "&7Dzi\u0119ki temu przedmiotowi otrzymasz"
                                                  - "&funikatowy &7wygl\u0105d oraz &fepickie &7bonusy."
                                                  - "&7"
                                                  - "&7Lista bonus\u00f3w:"
                                                  - "&8 » &7Otrzymujesz otwieranie &bshulker\u00f3w &7w ka\u017cdym miejscu!"
                                                  - "&8 » &c10% &7dodatkowych obra\u017ce\u0144"
                                                  - "&8 » &cPoca\u0142unek wampira &7leczy &e7% &7zadanych obra\u017ce\u0144"
                                                  - "&8 » &4+4 &7serca"
                                                custom_model_data: 0
                                                unbreakable: true
                                                item_flags: ["HIDE_ATTRIBUTES","HIDE_ENCHANTS","HIDE_UNBREAKABLE","HIDE_POTION_EFFECTS","HIDE_DYE"]
                                                leather_color:
                                                  red: 197
                                                  green: 115
                                                  blue: 102
                                              armor:
                                                display_name: "&7Zbroja &cwampira"
                                                base_lore:
                                                  - "&7"
                                                  - "&e&lKliknij&r &7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 &fzbroj\u0119&7!"
                                                colors:
                                                  chestplate: {red: 197, green: 115, blue: 102}
                                                  leggings: {red: 197, green: 115, blue: 102}
                                                  boots: {red: 197, green: 115, blue: 102}
                                                helmet_texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTNkMzg1MTIxMjI4MGU3Mzk2NjhkMDZhYjQ0NTM1ODFlZWVmNzlhNjNhZWZhNjA5YzJkNTgxOGI4MzJlM2RlZSJ9fX0="
                                                unbreakable: true
                                                item_flags: ["HIDE_ATTRIBUTES","HIDE_ENCHANTS","HIDE_UNBREAKABLE"]
                                              sounds:
                                                equip: {sound: "ENTITY_EXPERIENCE_ORB_PICKUP", volume: 1.0, pitch: 1.0}
                                                effect: {sound: "ENTITY_PLAYER_LEVELUP", volume: 0.8, pitch: 1.5}
                                              """.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
        }
        catch (final Exception ex) {
            Main.getInstance().getLogger().severe("Nie uda\u0142o si\u0119 stworzy\u0107 konfiguracji KostiumWampira: " + ex.getMessage());
        }
    }
    
    private void M() {
        try {
            this.\u00f3 = this.\u00fd.getDouble("costume.effects.health_bonus", 8.0);
            this.\u00fa = this.\u00fd.getDouble("costume.effects.damage_bonus", 10.0);
            this.\u0109 = this.\u00fd.getBoolean("costume.effects.vampire_kiss.enabled", true);
            this.\u00e5 = this.\u00fd.getDouble("costume.effects.vampire_kiss.chance", 30.0);
            this.\u00fb = this.\u00fd.getDouble("costume.effects.vampire_kiss.heal_percentage", 7.0);
            this.\u0106 = this.\u00fd.getInt("costume.effects.vampire_kiss.cooldown", 20);
            this.\u00f5 = this.\u00fd.getBoolean("costume.effects.vampirism.enabled", true);
            this.\u00e6 = this.\u00fd.getInt("costume.effects.vampirism.percentage", 150);
            this.\u00df = this.\u00fd.getInt("costume.effects.vampirism.chance", 100);
            this.\u00e7 = this.\u00fd.getInt("costume.effects.vampirism.cooldown", 20);
            this.\u00e1 = this.\u00fd.getBoolean("costume.effects.shulker_opening", true);
            this.\u0105 = Material.valueOf(this.\u00fd.getString("activation_item.material", "LEATHER_CHESTPLATE"));
            this.\u0102 = this.I(this.\u00fd.getString("activation_item.display_name", "&7Kostium &cwampira &7na czas &3{time}"));
            this.\u00e9 = this.I(this.\u00fd.getString("activation_item.preview_display_name", "&7Kostium &cwampira"));
            this.\u0107 = new ArrayList<String>();
            final Iterator iterator = this.\u00fd.getStringList("activation_item.lore").iterator();
            while (iterator.hasNext()) {
                this.\u0107.add(this.I((String)iterator.next()));
            }
            this.\u00f8 = this.\u00fd.getInt("activation_item.custom_model_data", 0);
            this.\u0108 = this.\u00fd.getBoolean("activation_item.unbreakable", true);
            this.\u00f9 = this.\u00fd.getStringList("activation_item.item_flags");
            this.\u00f1 = this.CostumesItemsListener1(this.\u00fd.getConfigurationSection("activation_item.leather_color"));
            this.\u00eb = this.I(this.\u00fd.getString("armor.display_name", "&7Zbroja &cwampira"));
            this.\u0103 = new ArrayList<String>();
            final Iterator iterator2 = this.\u00fd.getStringList("armor.base_lore").iterator();
            while (iterator2.hasNext()) {
                this.\u0103.add(this.I((String)iterator2.next()));
            }
            this.\u00ef = this.CostumesItemsListener1(this.\u00fd.getConfigurationSection("armor.colors.chestplate"));
            this.\u00ff = this.CostumesItemsListener1(this.\u00fd.getConfigurationSection("armor.colors.leggings"));
            this.\u00ea = this.CostumesItemsListener1(this.\u00fd.getConfigurationSection("armor.colors.boots"));
            this.\u00f2 = this.\u00fd.getString("armor.helmet_texture", "");
            this.\u00f0 = this.\u00fd.getBoolean("armor.unbreakable", true);
            this.\u00ec = this.\u00fd.getStringList("armor.item_flags");
            this.\u00fc = Sound.valueOf(this.\u00fd.getString("effects.sounds.equip", "ENTITY_EXPERIENCE_ORB_PICKUP"));
            this.\u00e0 = (float)this.\u00fd.getDouble("effects.sounds.equip_volume", 1.0);
            this.\u00fe = (float)this.\u00fd.getDouble("effects.sounds.equip_pitch", 1.0);
            this.\u00e2 = Sound.valueOf(this.\u00fd.getString("effects.sounds.vampire_kiss", "ENTITY_PLAYER_LEVELUP"));
            this.\u00ed = (float)this.\u00fd.getDouble("effects.sounds.vampire_kiss_volume", 0.8);
            this.\u00e4 = (float)this.\u00fd.getDouble("effects.sounds.vampire_kiss_pitch", 1.5);
            this.\u00e8 = this.I(this.\u00fd.getString("messages.costume_equipped", "&7Za\u0142o\u017cono kostium &cwampira&7!"));
            this.\u00ee = this.I(this.\u00fd.getString("messages.costume_removed", "&7Zdj\u0119to kostium &cwampira&7!"));
            this.\u00f6 = this.I(this.\u00fd.getString("messages.vampire_kiss_activated", "&cPoca\u0142unek wampira &7aktywowany!"));
            this.\u0101 = this.I(this.\u00fd.getString("messages.vampirism_activated", "&cVampiryzm &7aktywowany!"));
            this.\u00de = this.I(this.\u00fd.getString("messages.shulker_opened", "&bShulker &7otworzony!"));
        }
        catch (final Exception ex) {
            this.J();
        }
    }
    
    private void J() {
        this.\u00f3 = 8.0;
        this.\u00fa = 10.0;
        this.\u0109 = true;
        this.\u00e5 = 30.0;
        this.\u00fb = 7.0;
        this.\u0106 = 20;
        this.\u00f5 = true;
        this.\u00e6 = 150;
        this.\u00df = 100;
        this.\u00e7 = 20;
        this.\u00e1 = true;
        this.\u0105 = Material.LEATHER_CHESTPLATE;
        this.\u0102 = "§7Kostium §cwampira §7na §3{time}";
        this.\u00e9 = "§7Kostium §cwampira";
        this.\u0107 = Arrays.asList("§8Unikatowa wersja!", "§7Zosta\u0142 on wydany w trakcie §fwydarzenia", "§fz okazji dnia dziecka 2025§7.", "§7", "§7Dzi\u0119ki temu przedmiotowi otrzymasz", "§funikatowy §7wygl\u0105d oraz §fepickie §7bonusy.", "§7", "§7Lista bonus\u00f3w:", "§8 » §7Otrzymujesz otwieranie §bshulker\u00f3w §7w ka\u017cdym miejscu!", "§8 » §c10% §7dodatkowych obra\u017ce\u0144", "§8 » §cPoca\u0142unek wampira §7leczy §e7% §7zadanych obra\u017ce\u0144", "§8 » §4+4 §7serca");
        this.\u00f8 = 0;
        this.\u0108 = true;
        this.\u00f9 = Arrays.asList("HIDE_ATTRIBUTES", "HIDE_ENCHANTS", "HIDE_UNBREAKABLE", "HIDE_POTION_EFFECTS");
        this.\u00f1 = Color.fromRGB(197, 115, 102);
        this.\u00eb = "§7Zbroja §cwampira";
        this.\u0103 = Arrays.asList("§7", "§e§lKliknij§r §7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 §fzbroj\u0119§7!");
        this.\u00ef = Color.fromRGB(197, 115, 102);
        this.\u00ff = Color.fromRGB(197, 115, 102);
        this.\u00ea = Color.fromRGB(197, 115, 102);
        this.\u00f2 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTNkMzg1MTIxMjI4MGU3Mzk2NjhkMDZhYjQ0NTM1ODFlZWVmNzlhNjNhZWZhNjA5YzJkNTgxOGI4MzJlM2RlZSJ9fX0=";
        this.\u00f0 = true;
        this.\u00ec = Arrays.asList("HIDE_ATTRIBUTES", "HIDE_ENCHANTS", "HIDE_UNBREAKABLE");
        this.\u00fc = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
        this.\u00e0 = 1.0f;
        this.\u00fe = 1.0f;
        this.\u00e2 = Sound.ENTITY_PLAYER_LEVELUP;
        this.\u00ed = 0.8f;
        this.\u00e4 = 1.5f;
        this.\u00e8 = "§7Za\u0142o\u017cono kostium §cwampira§7!";
        this.\u00ee = "§7Zdj\u0119to kostium §cwampira§7!";
        this.\u00f6 = "§cPoca\u0142unek wampira §7aktywowany!";
        this.\u0101 = "§cVampiryzm §7aktywowany!";
        this.\u00de = "§bShulker §7otworzony!";
    }
    
    private String I(String h) {
        if (h == null) {
            return null;
        }
        h = this.CostumesItemsListener8(h);
        return ChatColor.translateAlternateColorCodes('&', h);
    }
    
    private String CostumesItemsListener8(final String s) {
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
    
    private Color CostumesItemsListener1(final ConfigurationSection configurationSection) {
        if (configurationSection == null) {
            return Color.fromRGB(197, 115, 102);
        }
        return Color.fromRGB(configurationSection.getInt("red", 197), configurationSection.getInt("green", 115), configurationSection.getInt("blue", 102));
    }
    
    public void apply(final Player player) {
        this.takeArmorSnapshot(player);
        final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
        final ItemStack customHead = this.createCustomHead(this.\u00f2);
        final ItemStack coloredArmor = this.createColoredArmor(Material.LEATHER_CHESTPLATE, this.\u00ef);
        final ItemStack coloredArmor2 = this.createColoredArmor(Material.LEATHER_LEGGINGS, this.\u00ff);
        final ItemStack coloredArmor3 = this.createColoredArmor(Material.LEATHER_BOOTS, this.\u00ea);
        if (playerArmorSnapshot != null) {
            if (playerArmorSnapshot.CostumesItemsListener3() != null) {
                this.CostumesItemsListener3(playerArmorSnapshot.CostumesItemsListener3(), customHead);
            }
            if (playerArmorSnapshot.CostumesItemsListener5() != null) {
                this.CostumesItemsListener3(playerArmorSnapshot.CostumesItemsListener5(), coloredArmor);
            }
            if (playerArmorSnapshot.CostumesItemsListener2() != null) {
                this.CostumesItemsListener3(playerArmorSnapshot.CostumesItemsListener2(), coloredArmor2);
            }
            if (playerArmorSnapshot.CostumesItemsListener1() != null) {
                this.CostumesItemsListener3(playerArmorSnapshot.CostumesItemsListener1(), coloredArmor3);
            }
        }
        this.CostumesItemsListener1(customHead);
        this.CostumesItemsListener1(coloredArmor);
        this.CostumesItemsListener1(coloredArmor2);
        this.CostumesItemsListener1(coloredArmor3);
        player.getInventory().setHelmet(customHead);
        if (playerArmorSnapshot == null || !playerArmorSnapshot.CostumesItemsListener4()) {
            player.getInventory().setChestplate(coloredArmor);
        }
        player.getInventory().setLeggings(coloredArmor2);
        player.getInventory().setBoots(coloredArmor3);
        this.applyEffects(player);
        if (this.\u00fc != null) {
            player.playSound(player.getLocation(), this.\u00fc, this.\u00e0, this.\u00fe);
        }
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
    
    private void CostumesItemsListener1(final ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return;
        }
        itemMeta.setDisplayName(this.\u00eb);
        itemMeta.setUnbreakable(this.\u00f0);
        for (final String s : this.\u00ec) {
            try {
                itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
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
        CostumesItemsListener4.playerArmorMap.remove(player.getUniqueId());
        CostumesItemsListener4.\u00e3.remove(player.getUniqueId());
        CostumesItemsListener4.\u010b.remove(player.getUniqueId());
    }
    
    public void update() {
    }
    
    public ItemStack getCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u0105);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u0102);
            itemMeta.setLore((List)new ArrayList(this.\u0107));
            if (this.\u00f8 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u00f8));
            }
            itemMeta.setUnbreakable(this.\u0108);
            for (final String s : this.\u00f9) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u00f1);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public ItemStack getPreviewCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u0105);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u00e9);
            itemMeta.setLore((List)new ArrayList(this.\u0107));
            if (this.\u00f8 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u00f8));
            }
            itemMeta.setUnbreakable(this.\u0108);
            for (final String s : this.\u00f9) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u00f1);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public void showOriginalArmor(final Player player) {
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        final I i = CostumesItemsListener4.playerArmorMap.get(player.getUniqueId());
        if (i == null) {
            return;
        }
        player.getInventory().setHelmet((i.CostumesItemsListener3() != null) ? i.CostumesItemsListener3().clone() : null);
        if (!i.CostumesItemsListener4()) {
            player.getInventory().setChestplate((i.CostumesItemsListener5() != null) ? i.CostumesItemsListener5().clone() : null);
        }
        player.getInventory().setLeggings((i.CostumesItemsListener2() != null) ? i.CostumesItemsListener2().clone() : null);
        player.getInventory().setBoots((i.CostumesItemsListener1() != null) ? i.CostumesItemsListener1().clone() : null);
    }
    
    public void restoreCostume(final Player player) {
        this.apply(player);
    }
    
    public void applyEffects(final Player player) {
        if (CostumesItemsListener4.\u00e3.containsKey(player.getUniqueId())) {
            return;
        }
        CostumesItemsListener4.\u00e3.put(player.getUniqueId(), true);
        if (this.\u00f3 > 0.0) {
            final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            if (attribute != null) {
                attribute.setBaseValue(20.0 + this.\u00f3);
            }
        }
    }
    
    public void removeEffects(final Player player) {
        CostumesItemsListener4.\u00e3.remove(player.getUniqueId());
        final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (attribute != null) {
            attribute.setBaseValue(20.0);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!(entityDamageByEntityEvent.getDamager() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityDamageByEntityEvent.getDamager();
        if (!"wampir".equals(L.CostumesItemsListener4(player))) {
            return;
        }
        final double damage = entityDamageByEntityEvent.getDamage();
        entityDamageByEntityEvent.setDamage(damage * (1.0 + this.\u00fa / 100.0));
        if (this.\u0109 && entityDamageByEntityEvent.getEntity() instanceof Player) {
            this.CostumesItemsListener1(player, (Player)entityDamageByEntityEvent.getEntity(), damage);
        }
    }
    
    private void CostumesItemsListener1(final Player player, final Player player2, final double n) {
        final UUID uniqueId = player.getUniqueId();
        final long currentTimeMillis = System.currentTimeMillis();
        if (CostumesItemsListener4.\u010b.containsKey(uniqueId) && currentTimeMillis - CostumesItemsListener4.\u010b.get(uniqueId) < this.\u0106 * 1000L) {
            return;
        }
        if (Math.random() * 100.0 > this.\u00e5) {
            return;
        }
        player.setHealth(Math.min(player.getHealth() + n * (this.\u00fb / 100.0), player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        CostumesItemsListener4.\u010b.put(uniqueId, currentTimeMillis);
        if (this.\u00e2 != null) {
            player.playSound(player.getLocation(), this.\u00e2, this.\u00ed, this.\u00e4);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(final PlayerInteractEvent playerInteractEvent) {
        if (!this.\u00e1) {
            return;
        }
        final Player player = playerInteractEvent.getPlayer();
        if (!"wampir".equals(L.CostumesItemsListener4(player))) {
            return;
        }
        if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR) {
            final ItemStack item = playerInteractEvent.getItem();
            if (item != null && item.getType().name().contains("SHULKER_BOX")) {
                playerInteractEvent.setCancelled(true);
                this.CostumesItemsListener1(player, item);
            }
        }
    }
    
    private void CostumesItemsListener1(final Player player, final ItemStack itemStack) {
        if (itemStack == null || !itemStack.getType().name().contains("SHULKER_BOX")) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (!(itemMeta instanceof BlockStateMeta)) {
            return;
        }
        final BlockStateMeta blockStateMeta = (BlockStateMeta)itemMeta;
        if (!(blockStateMeta.getBlockState() instanceof ShulkerBox)) {
            return;
        }
        final ShulkerBox shulkerBox = (ShulkerBox)blockStateMeta.getBlockState();
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)player, 27, itemMeta.hasDisplayName() ? itemMeta.getDisplayName() : "Shulker Box");
        inventory.setContents(shulkerBox.getInventory().getContents());
        int heldItemSlot = player.getInventory().getHeldItemSlot();
        if (player.getInventory().getItemInOffHand().equals((Object)itemStack)) {
            heldItemSlot = 40;
        }
        CostumesItemsListener4.\u00f4.put(player.getUniqueId(), heldItemSlot);
        player.openInventory(inventory);
        player.playSound(player.getLocation(), Sound.BLOCK_SHULKER_BOX_OPEN, 1.0f, 1.0f);
    }
    
    @EventHandler
    public void onInventoryClose(final InventoryCloseEvent inventoryCloseEvent) {
        if (!(inventoryCloseEvent.getPlayer() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryCloseEvent.getPlayer();
        if (!CostumesItemsListener4.\u00f4.containsKey(player.getUniqueId())) {
            return;
        }
        final int intValue = CostumesItemsListener4.\u00f4.remove(player.getUniqueId());
        ItemStack itemInOffHand;
        if (intValue == 40) {
            itemInOffHand = player.getInventory().getItemInOffHand();
        }
        else {
            itemInOffHand = player.getInventory().getItem(intValue);
        }
        if (itemInOffHand == null || !itemInOffHand.getType().name().contains("SHULKER_BOX")) {
            return;
        }
        final ItemMeta itemMeta = itemInOffHand.getItemMeta();
        if (!(itemMeta instanceof BlockStateMeta)) {
            return;
        }
        final BlockStateMeta itemMeta2 = (BlockStateMeta)itemMeta;
        if (!(itemMeta2.getBlockState() instanceof ShulkerBox)) {
            return;
        }
        final ShulkerBox blockState = (ShulkerBox)itemMeta2.getBlockState();
        blockState.getInventory().setContents(inventoryCloseEvent.getInventory().getContents());
        itemMeta2.setBlockState((BlockState)blockState);
        itemInOffHand.setItemMeta((ItemMeta)itemMeta2);
        if (intValue == 40) {
            player.getInventory().setItemInOffHand(itemInOffHand);
        }
        else {
            player.getInventory().setItem(intValue, itemInOffHand);
        }
        player.playSound(player.getLocation(), Sound.BLOCK_SHULKER_BOX_CLOSE, 1.0f, 1.0f);
    }
    
    @EventHandler
    public void onPlayerDropItem(final PlayerDropItemEvent playerDropItemEvent) {
        final Player player = playerDropItemEvent.getPlayer();
        if (!"wampir".equals(L.CostumesItemsListener4(player))) {
            return;
        }
        if (!CostumesItemsListener4.\u00f4.containsKey(player.getUniqueId())) {
            return;
        }
        final ItemStack itemStack = playerDropItemEvent.getItemDrop().getItemStack();
        if (itemStack == null || !itemStack.getType().name().contains("SHULKER_BOX")) {
            return;
        }
        playerDropItemEvent.setCancelled(true);
    }
    
    private void CostumesItemsListener3(final ItemStack itemStack, final ItemStack itemStack2) {
        if (itemStack == null || itemStack2 == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        final ItemMeta itemMeta2 = itemStack2.getItemMeta();
        if (itemMeta == null || itemMeta2 == null) {
            return;
        }
        if (itemMeta.hasEnchants()) {
            for (final Enchantment enchantment : itemMeta.getEnchants().keySet()) {
                itemMeta2.addEnchant(enchantment, itemMeta.getEnchantLevel(enchantment), true);
            }
        }
        if (itemMeta.hasLore()) {
            itemMeta2.setLore((List)new ArrayList(itemMeta.getLore()));
        }
        this.copyCustomEnchantsToLore(itemStack, itemStack2);
        itemStack2.setItemMeta(itemMeta2);
    }
    
    @EventHandler
    public void onVampirismDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!this.\u00f5) {
            return;
        }
        if (!(entityDamageByEntityEvent.getDamager() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityDamageByEntityEvent.getDamager();
        if (!"wampir".equals(L.CostumesItemsListener4(player))) {
            return;
        }
        if (Math.random() * 100.0 > this.\u00df) {
            return;
        }
        final UUID uniqueId = player.getUniqueId();
        final long currentTimeMillis = System.currentTimeMillis();
        if (CostumesItemsListener4.\u0104.containsKey(uniqueId) && currentTimeMillis - CostumesItemsListener4.\u0104.get(uniqueId) < this.\u00e7 * 1000L) {
            return;
        }
        player.setHealth(Math.min(player.getHealth() + entityDamageByEntityEvent.getDamage() * (this.\u00e6 / 100.0), player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        CostumesItemsListener4.\u0104.put(uniqueId, currentTimeMillis);
    }
    
    public Color getChestplateColor() {
        return this.\u00ef;
    }
    
    public Color getLeggingsColor() {
        return this.\u00ff;
    }
    
    public Color getBootsColor() {
        return this.\u00ea;
    }
    
    public String getHelmetTexture() {
        return this.\u00f2;
    }
    
    static {
        \u010b = new ConcurrentHashMap<UUID, Long>();
        \u00e3 = new HashMap<UUID, Boolean>();
        \u0104 = new ConcurrentHashMap<UUID, Long>();
        CostumesItemsListener4.\u0100 = false;
        \u00f4 = new ConcurrentHashMap<UUID, Integer>();
    }
}
