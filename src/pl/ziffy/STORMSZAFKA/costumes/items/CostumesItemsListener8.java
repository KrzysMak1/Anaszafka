// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.items;

import java.util.HashMap;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
import pl.ziffy.STORMSZAFKA.messages.CostumesItemsListener1;
import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import java.util.Iterator;
import org.bukkit.inventory.ItemFlag;
import java.util.Collection;
import org.bukkit.inventory.meta.ItemMeta;
import pl.ziffy.STORMSZAFKA.utils.CostumesItemsListener3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemStack;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService4;
import org.bukkit.entity.Player;
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
import java.util.Map;
import org.bukkit.Sound;
import org.bukkit.Color;
import java.util.List;
import org.bukkit.Material;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.UUID;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService5;

public class CostumesItemsListener8 extends J implements Listener
{
    private static final UUID \u0184;
    private FileConfiguration \u01a1;
    private File \u019a;
    private double \u0191;
    private double \u019d;
    private double \u018b;
    private boolean \u0196;
    private int \u0187;
    private Material \u0192;
    private String \u0197;
    private String \u0185;
    private List<String> \u0199;
    private int \u0186;
    private boolean \u0193;
    private List<String> \u019f;
    private Color \u0198;
    private String \u0194;
    private List<String> \u018d;
    private Color \u0189;
    private Color \u018a;
    private Color \u0190;
    private String \u019c;
    private boolean \u018e;
    private List<String> \u01a4;
    private Sound \u019e;
    private float \u0188;
    private float \u0195;
    private Sound \u01a0;
    private float \u018c;
    private float \u019b;
    private boolean \u01a2;
    private static final Map<UUID, Boolean> \u01a3;
    private static boolean \u018f;
    
    public CostumesItemsListener8() {
        super("malyurwis", "Kostium Ma\u0142ego Urwisa");
        this.\u019a = new File(Main.getInstance().getCustomDataFolder(), "costumes/KostiumMa\u0142egoUrwisa.yml");
        this.Z();
        if (this.plugin != null && !CostumesItemsListener8.\u018f) {
            Bukkit.getPluginManager().registerEvents((Listener)this, this.plugin);
            CostumesItemsListener8.\u018f = true;
        }
    }
    
    private void Z() {
        if (!this.\u019a.exists()) {
            this.Y();
        }
        this.\u01a1 = (FileConfiguration)YamlConfiguration.loadConfiguration(this.\u019a);
        this._();
    }
    
    private void Y() {
        try {
            final File parentFile = this.\u019a.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            Files.write(this.\u019a.toPath(), """
                                              # ========= KostiumMa\u0142egoUrwisa.yml =========
                                              # Konfiguracja kostiumu Ma\u0142ego Urwisa
                                              # ==========================================
                                              costume:
                                                type: malyurwis
                                                name: Kostium Ma\u0142ego Urwisa
                                                description: Kostium z wydarzenia Dzie\u0144 Dziecka 2025
                                              effects:
                                                extra_damage:
                                                  multiplier: 1.10
                                                fall_damage_reduction:
                                                  reduction: 0.5
                                                money_steal:
                                                  percentage: 3.0
                                                speed:
                                                  enabled: true
                                                  amplifier: 1
                                              activation_item:
                                                material: LEATHER_CHESTPLATE
                                                display_name: '&7Kostium &fma\u0142ego urwisa &7na czas &3{time}'
                                                preview_display_name: '&7Kostium &fma\u0142ego urwisa'
                                                custom_model_data: 0
                                                unbreakable: true
                                                item_flags:
                                                - HIDE_ATTRIBUTES
                                                - HIDE_ENCHANTS
                                                - HIDE_UNBREAKABLE
                                                - HIDE_DYE
                                                leather_color: '255,255,0'
                                                lore:
                                                - '&8Unikatowa wersja!'
                                                - '&7Zosta\u0142 on wydany w trakcie &fwydarzenia'
                                                - '&fz okazji dnia dziecka 2025&7.'
                                                - '&7'
                                                - '&7Dzi\u0119ki temu przedmiotowi otrzymasz'
                                                - '&funikatowy &7wygl\u0105d oraz &fepickie &7bonusy.'
                                                - '&7'
                                                - '&7Lista bonus\u00f3w:'
                                                - '&8 » &c10% &7dodatkowych obra\u017ce\u0144'
                                                - '&8 » &e50% &7odporno\u015bci od upadku'
                                                - '&8 » &7Po zabiciu gracza kradniesz mu &e3% maj\u0105tku'
                                                - '&8 » &7Sta\u0142y efekt &bszybkiego biegania 2'
                                              armor_appearance:
                                                display_name: '&7Zbroja &fMa\u0142ego Urwisa'
                                                base_lore:
                                                  - '&7'
                                                  - '&e&lKliknij&r &7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 &fzbroj\u0119&7!'
                                                unbreakable: true
                                                item_flags:
                                                - HIDE_ATTRIBUTES
                                                - HIDE_ENCHANTS
                                                - HIDE_UNBREAKABLE
                                                - HIDE_DYE
                                                armor_colors:
                                                  chestplate: '255,255,0'
                                                  leggings: '0,255,16'
                                                  boots: '255,255,255'
                                                helmet:
                                                  primary_texture: eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTQ2N2IyYThmY2E4YmQxNTljMmUxOTQ3OTQ3YmQxZDU2MmZiYzI3MTZlZmVlNDhkNTU3OTRmZTUzNWVmYmEifX19
                                              sounds:
                                                equip:
                                                  sound: ITEM_ARMOR_EQUIP_LEATHER
                                                  volume: 1.0
                                                  pitch: 1.0
                                                kill:
                                                  sound: ENTITY_PLAYER_LEVELUP
                                                  volume: 1.0
                                                  pitch: 1.5
                                              debug:
                                                enabled: false
                                              """.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
        }
        catch (final IOException ex) {
            Main.getInstance().getLogger().severe("Failed to create default configuration for KostiumMa\u0142egoUrwisa: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void _() {
        this.\u0191 = this.\u01a1.getDouble("effects.extra_damage.multiplier", 1.1) - 1.0;
        this.\u019d = this.\u01a1.getDouble("effects.fall_damage_reduction.reduction", 0.5);
        this.\u018b = this.\u01a1.getDouble("effects.money_steal.percentage", 3.0);
        this.\u0196 = this.\u01a1.getBoolean("effects.speed.enabled", true);
        this.\u0187 = this.\u01a1.getInt("effects.speed.amplifier", 1) + 1;
        final String s = this.\u01a1.contains("activation_item") ? "activation_item" : "activation";
        try {
            this.\u0192 = Material.valueOf(this.\u01a1.getString(s + ".material", "LEATHER_CHESTPLATE"));
        }
        catch (final IllegalArgumentException ex) {
            this.\u0192 = Material.LEATHER_CHESTPLATE;
        }
        this.\u0197 = this.U(this.\u01a1.getString(s + ".display_name", "&7Kostium &fma\u0142ego urwisa &7na czas &3{time}"));
        this.\u0185 = this.U(this.\u01a1.getString(s + ".preview_display_name", "&7Kostium &fma\u0142ego urwisa"));
        this.\u0199 = (List)this.\u01a1.getStringList(s + ".lore").stream().map(this::U).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.\u0186 = this.\u01a1.getInt(s + ".custom_model_data", 0);
        this.\u0193 = this.\u01a1.getBoolean(s + ".unbreakable", true);
        this.\u019f = this.\u01a1.getStringList(s + ".item_flags");
        final String string = this.\u01a1.getString(s + ".leather_color");
        if (string != null) {
            this.\u0198 = this.T(string);
        }
        else {
            this.\u0198 = Color.fromRGB(this.\u01a1.getInt(s + ".leather_color.red", 255), this.\u01a1.getInt(s + ".leather_color.green", 255), this.\u01a1.getInt(s + ".leather_color.blue", 0));
        }
        this.\u0194 = this.U(this.\u01a1.getString("armor_appearance.display_name", "&7Zbroja &fMa\u0142ego Urwisa"));
        this.\u018d = (List)this.\u01a1.getStringList("armor_appearance.base_lore").stream().map(this::U).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.\u018e = this.\u01a1.getBoolean("armor_appearance.unbreakable", true);
        this.\u01a4 = this.\u01a1.getStringList("armor_appearance.item_flags");
        this.\u0189 = this.T(this.\u01a1.getString("armor_appearance.armor_colors.chestplate", "255,255,0"));
        this.\u018a = this.T(this.\u01a1.getString("armor_appearance.armor_colors.leggings", "0,255,16"));
        this.\u0190 = this.T(this.\u01a1.getString("armor_appearance.armor_colors.boots", "255,255,255"));
        this.\u019c = this.\u01a1.getString("armor_appearance.helmet.primary_texture", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTQ2N2IyYThmY2E4YmQxNTljMmUxOTQ3OTQ3YmQxZDU2MmZiYzI3MTZlZmVlNDhkNTU3OTRmZTUzNWVmYmEifX19");
        try {
            this.\u019e = Sound.valueOf(this.\u01a1.getString("effects.sounds.equip", "ITEM_ARMOR_EQUIP_LEATHER"));
        }
        catch (final IllegalArgumentException ex2) {
            this.\u019e = Sound.ITEM_ARMOR_EQUIP_LEATHER;
        }
        this.\u0188 = (float)this.\u01a1.getDouble("effects.sounds.equip_volume", 1.0);
        this.\u0195 = (float)this.\u01a1.getDouble("effects.sounds.equip_pitch", 1.0);
        try {
            this.\u01a0 = Sound.valueOf(this.\u01a1.getString("effects.sounds.kill", "ENTITY_PLAYER_LEVELUP"));
        }
        catch (final IllegalArgumentException ex3) {
            this.\u01a0 = Sound.ENTITY_PLAYER_LEVELUP;
        }
        this.\u018c = (float)this.\u01a1.getDouble("effects.sounds.kill_volume", 1.0);
        this.\u019b = (float)this.\u01a1.getDouble("effects.sounds.kill_pitch", 1.5);
    }
    
    private String U(final String s) {
        return this.formatColors(s);
    }
    
    private Color T(final String s) {
        if (s == null || s.isEmpty()) {
            return Color.fromRGB(255, 255, 0);
        }
        try {
            final String[] split = s.split(",");
            if (split.length == 3) {
                return Color.fromRGB(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()), Integer.parseInt(split[2].trim()));
            }
        }
        catch (final NumberFormatException ex) {
            Main.getInstance().getLogger().warning("Invalid color format: " + s + ", using default");
        }
        return Color.fromRGB(255, 255, 0);
    }
    
    public void apply(final Player player) {
        this.takeArmorSnapshot(player);
        final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
        final ItemStack customHead = this.createCustomHead(this.\u019c);
        final ItemStack coloredArmor = this.createColoredArmor(Material.LEATHER_CHESTPLATE, this.\u0189);
        final ItemStack coloredArmor2 = this.createColoredArmor(Material.LEATHER_LEGGINGS, this.\u018a);
        final ItemStack coloredArmor3 = this.createColoredArmor(Material.LEATHER_BOOTS, this.\u0190);
        if (playerArmorSnapshot != null) {
            if (playerArmorSnapshot.CostumesItemsListener3() != null) {
                this.CostumesItemsListener7(playerArmorSnapshot.CostumesItemsListener3(), customHead);
            }
            if (playerArmorSnapshot.CostumesItemsListener5() != null) {
                this.CostumesItemsListener7(playerArmorSnapshot.CostumesItemsListener5(), coloredArmor);
            }
            if (playerArmorSnapshot.CostumesItemsListener2() != null) {
                this.CostumesItemsListener7(playerArmorSnapshot.CostumesItemsListener2(), coloredArmor2);
            }
            if (playerArmorSnapshot.CostumesItemsListener1() != null) {
                this.CostumesItemsListener7(playerArmorSnapshot.CostumesItemsListener1(), coloredArmor3);
            }
        }
        this.CostumesItemsListener7(customHead, "helmet");
        this.CostumesItemsListener7(coloredArmor, "chestplate");
        this.CostumesItemsListener7(coloredArmor2, "leggings");
        this.CostumesItemsListener7(coloredArmor3, "boots");
        player.getInventory().setHelmet(customHead);
        if (playerArmorSnapshot == null || !playerArmorSnapshot.CostumesItemsListener4()) {
            player.getInventory().setChestplate(coloredArmor);
        }
        player.getInventory().setLeggings(coloredArmor2);
        player.getInventory().setBoots(coloredArmor3);
        this.applyEffects(player);
        if (this.\u019e != null) {
            player.playSound(player.getLocation(), this.\u019e, this.\u0188, this.\u0195);
        }
    }
    
    public ItemStack createCustomHead(final String s) {
        final ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        final SkullMeta itemMeta = (SkullMeta)itemStack.getItemMeta();
        if (itemMeta != null) {
            pl.ziffy.STORMSZAFKA.utils.CostumesItemsListener3.CostumesItemsListener4(itemMeta, s);
            itemStack.setItemMeta((ItemMeta)itemMeta);
        }
        return itemStack;
    }
    
    private void CostumesItemsListener7(final ItemStack itemStack, final String s) {
        if (itemStack == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return;
        }
        itemMeta.setDisplayName(this.\u0194);
        itemMeta.setLore((List)new ArrayList(this.\u018d));
        itemMeta.setUnbreakable(this.\u018e);
        for (final String s2 : this.\u01a4) {
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
        CostumesItemsListener8.playerArmorMap.remove(player.getUniqueId());
        CostumesItemsListener8.\u01a3.remove(player.getUniqueId());
    }
    
    public void update() {
    }
    
    public ItemStack getCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u0192);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u0197);
            itemMeta.setLore((List)new ArrayList(this.\u0199));
            if (this.\u0186 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u0186));
            }
            if (this.\u0193) {
                itemMeta.setUnbreakable(true);
            }
            for (final String s : this.\u019f) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u0198);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public ItemStack getPreviewCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u0192);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u0185);
            final ArrayList lore = new ArrayList((Collection<? extends CostumesItemsListener5>)this.\u0199);
            lore.removeIf(s2 -> {
                ChatColor.stripColor(s2);
                final String s3;
                return s3.contains("Kliknij") || s3.contains("przyciskiem");
            });
            itemMeta.setLore((List)lore);
            if (this.\u0186 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u0186));
            }
            if (this.\u0193) {
                itemMeta.setUnbreakable(true);
            }
            for (final String s : this.\u019f) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u0198);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public void showOriginalArmor(final Player player) {
        this.restoreArmorFromSnapshot(player);
        final CostumesItemsListener1 languageManager = Main.getLanguageManager();
        if (languageManager != null) {
            final String f = languageManager.CostumesItemsListener6("costume.kostium-maly-urwis.show-original");
            if (f != null && !f.isEmpty() && !f.contains("Missing language key")) {
                player.sendMessage(f);
            }
        }
    }
    
    public void restoreCostume(final Player player) {
        this.apply(player);
        final CostumesItemsListener1 languageManager = Main.getLanguageManager();
        if (languageManager != null) {
            final String f = languageManager.CostumesItemsListener6("costume.kostium-maly-urwis.show-costume");
            if (f != null && !f.isEmpty() && !f.contains("Missing language key")) {
                player.sendMessage(f);
            }
        }
    }
    
    public void applyEffects(final Player player) {
        CostumesItemsListener8.\u01a3.put(player.getUniqueId(), true);
        if (this.\u0191 > 0.0) {
            final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
            if (attribute != null) {
                for (final AttributeModifier attributeModifier : new ArrayList(attribute.getModifiers())) {
                    if (attributeModifier.getUniqueId().equals(CostumesItemsListener8.\u0184)) {
                        attribute.removeModifier(attributeModifier);
                        break;
                    }
                }
                attribute.addModifier(new AttributeModifier(CostumesItemsListener8.\u0184, "costume_damage_bonus", this.\u0191, AttributeModifier.Operation.MULTIPLY_SCALAR_1));
            }
        }
        if (this.\u0196 && this.\u0187 > 0) {
            player.removePotionEffect(PotionEffectType.SPEED);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u0187 - 1, false, false));
        }
    }
    
    public void removeEffects(final Player player) {
        CostumesItemsListener8.\u01a3.remove(player.getUniqueId());
        final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
        if (attribute != null) {
            for (final AttributeModifier attributeModifier : attribute.getModifiers()) {
                if (attributeModifier.getUniqueId().equals(CostumesItemsListener8.\u0184)) {
                    attribute.removeModifier(attributeModifier);
                    break;
                }
            }
        }
        if (player.hasPotionEffect(PotionEffectType.SPEED)) {
            player.removePotionEffect(PotionEffectType.SPEED);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onFallDamage(final EntityDamageEvent entityDamageEvent) {
        if (!(entityDamageEvent.getEntity() instanceof Player)) {
            return;
        }
        if (!CostumesItemsListener8.\u01a3.containsKey(((Player)entityDamageEvent.getEntity()).getUniqueId())) {
            return;
        }
        if (entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALL) {
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u019d));
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerKill(final PlayerDeathEvent playerDeathEvent) {
        final Player entity = playerDeathEvent.getEntity();
        final Player killer = entity.getKiller();
        if (killer == null) {
            return;
        }
        if (!CostumesItemsListener8.\u01a3.containsKey(killer.getUniqueId())) {
            return;
        }
        final double b = this.CostumesItemsListener2(killer, entity);
        if (b > 0.0) {
            if (this.\u01a0 != null) {
                killer.playSound(killer.getLocation(), this.\u01a0, this.\u018c, this.\u019b);
            }
            final CostumesItemsListener1 languageManager = Main.getLanguageManager();
            if (languageManager != null) {
                final String replace = languageManager.CostumesItemsListener6("costume.kostium-maly-urwis.money-steal").replace("%amount%", String.format("%.2f", b)).replace("%player%", entity.getName());
                if (replace != null && !replace.isEmpty() && !replace.contains("Missing language key")) {
                    killer.sendMessage(replace);
                }
                else {
                    killer.sendMessage("&aUkrad\u0142e\u015b &e" + String.format("%.2f", b) + "$ &agraczowi &e" + entity.getName() + "&a!");
                }
                final String replace2 = languageManager.CostumesItemsListener6("costume.kostium-maly-urwis.money-steal-target").replace("%amount%", String.format("%.2f", b)).replace("%killer%", killer.getName());
                if (replace2 != null && !replace2.isEmpty() && !replace2.contains("Missing language key")) {
                    entity.sendMessage(replace2);
                }
                else {
                    entity.sendMessage("&cGracz &e" + killer.getName() + " &cukrad\u0142 ci &e" + String.format("%.2f", b) + "$&c!");
                }
            }
            else {
                killer.sendMessage("&aUkrad\u0142e\u015b &e" + String.format("%.2f", b) + "$ &agraczowi &e" + entity.getName() + "&a!");
                entity.sendMessage("&cGracz &e" + killer.getName() + " &cukrad\u0142 ci &e" + String.format("%.2f", b) + "$&c!");
            }
        }
    }
    
    private double CostumesItemsListener2(final Player player, final Player player2) {
        try {
            final Class<?> forName = Class.forName("net.milkbowl.vault.economy.Economy");
            final RegisteredServiceProvider registration = Bukkit.getServicesManager().getRegistration((Class)forName);
            if (registration == null) {
                return 0.0;
            }
            final Object provider = registration.getProvider();
            final double doubleValue = (double)forName.getMethod("getBalance", OfflinePlayer.class).invoke(provider, player2);
            if (doubleValue <= 0.0) {
                return 0.0;
            }
            final double n = doubleValue * (this.\u018b / 100.0);
            forName.getMethod("withdrawPlayer", OfflinePlayer.class, Double.TYPE).invoke(provider, player2, n);
            forName.getMethod("depositPlayer", OfflinePlayer.class, Double.TYPE).invoke(provider, player, n);
            return n;
        }
        catch (final Exception ex) {
            return 0.0;
        }
    }
    
    public String getHelmetTexture() {
        return this.\u019c;
    }
    
    public Color getChestplateColor() {
        return this.\u0189;
    }
    
    public Color getLeggingsColor() {
        return this.\u018a;
    }
    
    public Color getBootsColor() {
        return this.\u0190;
    }
    
    private void CostumesItemsListener7(final ItemStack itemStack, final ItemStack itemStack2) {
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
            final double l = this.L(itemStack.getType());
            final double k = this.K(itemStack.getType());
            final double j = this.J(itemStack.getType());
            if (l > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "costume_armor", l, AttributeModifier.Operation.ADD_NUMBER, this.I(itemStack2.getType())));
            }
            if (k > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "costume_toughness", k, AttributeModifier.Operation.ADD_NUMBER, this.I(itemStack2.getType())));
            }
            if (j > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "costume_knockback_resistance", j, AttributeModifier.Operation.ADD_NUMBER, this.I(itemStack2.getType())));
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
    
    private double L(final Material material) {
        switch (CostumesItemsListener8$1.CostumesItemsListener1[material.ordinal()]) {
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
    
    private double K(final Material material) {
        switch (CostumesItemsListener8$1.CostumesItemsListener1[material.ordinal()]) {
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
    
    private double J(final Material material) {
        switch (CostumesItemsListener8$1.CostumesItemsListener1[material.ordinal()]) {
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
    
    private EquipmentSlot I(final Material material) {
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
        \u0184 = UUID.fromString("33333333-4444-5555-6666-777777777777");
        \u01a3 = new HashMap<UUID, Boolean>();
        CostumesItemsListener8.\u018f = false;
    }
}
