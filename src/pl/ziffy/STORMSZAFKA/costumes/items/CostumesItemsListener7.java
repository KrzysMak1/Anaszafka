// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.items;

import java.util.HashMap;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scoreboard.Team;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import pl.ziffy.STORMSZAFKA.messages.CostumesItemsListener1;
import pl.ziffy.STORMSZAFKA.regions.CostumesItemsListener2;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
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

public class CostumesItemsListener7 extends J implements Listener
{
    private static final UUID \u0162;
    private static final UUID \u015e;
    private FileConfiguration \u0179;
    private File \u0183;
    private double \u0172;
    private double \u0175;
    private boolean \u017c;
    private int \u0163;
    private double \u0160;
    private int \u0177;
    private Material \u0180;
    private String \u017e;
    private String \u0165;
    private List<String> \u0181;
    private int \u0174;
    private boolean \u0182;
    private List<String> \u0176;
    private Color \u016f;
    private String \u0167;
    private List<String> \u017f;
    private Color \u016c;
    private Color \u017b;
    private Color \u0166;
    private String \u0170;
    private boolean \u016e;
    private List<String> \u0168;
    private Sound \u0178;
    private float \u015f;
    private float \u017a;
    private Sound \u016a;
    private float \u0173;
    private float \u016b;
    private boolean \u0169;
    private static final Map<UUID, Boolean> \u0161;
    private static final Map<UUID, Long> \u0171;
    private static final Map<UUID, Long> \u016d;
    private static final Map<UUID, Long> \u0164;
    private static boolean \u017d;
    
    public CostumesItemsListener7() {
        super("przeciwzakazeniowy", "Kostium Przeciwzaka\u017ceniowy");
        this.\u0183 = new File(Main.getInstance().getCustomDataFolder(), "costumes/KostiumPrzeciwzaka\u017ceniowy.yml");
        this.W();
        if (this.plugin != null && !CostumesItemsListener7.\u017d) {
            Bukkit.getPluginManager().registerEvents((Listener)this, this.plugin);
            CostumesItemsListener7.\u017d = true;
        }
    }
    
    private void W() {
        this.\u0183 = new File(Main.getInstance().getCustomDataFolder(), "costumes/KostiumPrzeciwzaka\u017ceniowy.yml");
        if (!this.\u0183.exists()) {
            this.X();
        }
        this.\u0179 = (FileConfiguration)YamlConfiguration.loadConfiguration(this.\u0183);
        this.V();
    }
    
    private void X() {
        try {
            final File parentFile = this.\u0183.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            Files.write(this.\u0183.toPath(), """
                                              # ========= KostiumPrzeciwzaka\u017ceniowy.yml =========
                                              # Konfiguracja kostiumu Przeciwzaka\u017ceniowy
                                              # ============================================
                                              costume:
                                                type: przeciwzakazeniowy
                                                name: Kostium Przeciwzaka\u017ceniowy
                                                description: Unikatowy kostium z wydarzenia ZARAZA
                                              
                                              # Efekty kostiumu
                                              effects:
                                                health_bonus: 6.0                    # Bonus do zdrowia (+3 serca)
                                                defense_bonus: 0.1                   # Bonus do obrony (+10%)
                                                immune_to_negative_effects: true     # Odporno\u015b\u0107 na negatywne efekty
                                                infection_duration: 10               # Czas trwania zara\u017cenia w sekundach
                                                infection_damage_multiplier: 1.5     # Mno\u017cnik obra\u017ce\u0144 dla zara\u017conych (1.5 = +50%)
                                                infection_cooldown: 60               # Cooldown zara\u017cenia w sekundach
                                              activation:
                                                material: LEATHER_CHESTPLATE
                                                display_name: '&7Kostium &aprzeciwzaka\u017ceniowy &7na czas &3{time}'
                                                preview_display_name: '&7Kostium &aprzeciwzaka\u017ceniowy'
                                                duration: 'ZAWSZE'
                                                custom_model_data: 0
                                                unbreakable: true
                                                item_flags:
                                                - HIDE_ATTRIBUTES
                                                - HIDE_ENCHANTS
                                                - HIDE_UNBREAKABLE
                                                - HIDE_DYE
                                                leather_color:
                                                  red: 255
                                                  green: 215
                                                  blue: 0
                                                lore:
                                                - '&8Unikatowa wersja!'
                                                - '&7Zosta\u0142 on wydany w trakcie &funikatowego'
                                                - '&7wydarzenia &f21 marca 2025 roku &8(&2ZARAZA&8)'
                                                - '&7'
                                                - '&7Dzi\u0119ki temu przedmiotowi otrzymasz'
                                                - '&funikatowy wygl\u0105d oraz epickie bonusy.'
                                                - '&7'
                                                - '&7Lista bonus\u00f3w:'
                                                - '&8 » &7Po klikni\u0119ciu &azara\u017casz &7przeciwnika,'
                                                - '&7 zadaj\u0105c mu wi\u0119ksze &cobra\u017cenia&7.'
                                                - '&8 » &4+3 &7serca'
                                                - '&8 » &b+10% &7obrony'
                                                - '&8 » &7Odporno\u015b\u0107 na &cnegatywne efekty'
                                                - '&7'
                                                - '&8 » &aKliknij prawym przyciskiem myszy, aby za\u0142o\u017cy\u0107!'
                                              armor:
                                                display_name: '&7Zbroja &aprzeciwzaka\u017ceniowa'
                                                base_lore:
                                                  - "&7"
                                                  - "&e&lKliknij&r &7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 &fzbroj\u0119&7!"
                                                unbreakable: true
                                                item_flags:
                                                - HIDE_ATTRIBUTES
                                                - HIDE_ENCHANTS
                                                - HIDE_UNBREAKABLE
                                                - HIDE_DYE
                                                chestplate_color:
                                                  red: 255
                                                  green: 215
                                                  blue: 0
                                                leggings_color:
                                                  red: 255
                                                  green: 215
                                                  blue: 0
                                                boots_color:
                                                  red: 255
                                                  green: 215
                                                  blue: 0
                                                helmet_texture: eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTI4MzA0Y2RjOTY1YzQxNzQwNWY5NjVjM2I2M2NhNGZiZjg2ZTg4ZTM0MWQ2OTMyN2NhMjdlM2EwOGMwYTIwMCJ9fX0=
                                              sounds:
                                                equip:
                                                  sound: ITEM_ARMOR_EQUIP_LEATHER
                                                  volume: 1.0
                                                  pitch: 1.0
                                                infection:
                                                  sound: ENTITY_ZOMBIE_VILLAGER_CONVERTED
                                                  volume: 1.0
                                                  pitch: 0.8
                                              debug:
                                                enabled: false
                                              """.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
        }
        catch (final IOException ex) {
            Main.getInstance().getLogger().severe("Failed to create default configuration for KostiumPrzeciwzaka\u017ceniowy: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private void V() {
        this.\u0172 = this.\u0179.getDouble("effects.extra_hearts.hearts", 3.0) * 2.0;
        this.\u0175 = this.\u0179.getDouble("effects.defense_bonus.multiplier", 0.9);
        this.\u017c = this.\u0179.getBoolean("effects.negative_effects_immunity.enabled", true);
        this.\u0163 = this.\u0179.getInt("effects.infection.duration", 10);
        this.\u0160 = this.\u0179.getDouble("effects.infection.damage_multiplier", 1.5);
        this.\u0177 = this.\u0179.getInt("effects.infection.cooldown", 60);
        try {
            this.\u0180 = Material.valueOf(this.\u0179.getString("activation_item.material", "LEATHER_CHESTPLATE"));
        }
        catch (final IllegalArgumentException ex) {
            this.\u0180 = Material.LEATHER_CHESTPLATE;
        }
        this.\u017e = this.P(this.\u0179.getString("activation_item.display_name", "&7Kostium &aprzeciwzaka\u017ceniowy &7na czas &3{time}"));
        this.\u0165 = this.P(this.\u0179.getString("activation_item.preview_display_name", "&7Kostium &aprzeciwzaka\u017ceniowy"));
        this.\u0181 = (List)this.\u0179.getStringList("activation_item.lore").stream().map(this::P).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.\u0174 = this.\u0179.getInt("activation_item.custom_model_data", 0);
        this.\u0182 = this.\u0179.getBoolean("activation_item.unbreakable", true);
        this.\u0176 = this.\u0179.getStringList("activation_item.item_flags");
        this.\u016f = this.Q(this.\u0179.getString("activation_item.leather_color", "255,215,0"));
        this.\u0167 = this.P(this.\u0179.getString("armor_appearance.display_name", "&7Zbroja &aPrzeciwzaka\u017ceniowa"));
        this.\u017f = (List)this.\u0179.getStringList("armor_appearance.base_lore").stream().map(this::P).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.\u016e = this.\u0179.getBoolean("armor_appearance.unbreakable", true);
        this.\u0168 = this.\u0179.getStringList("armor_appearance.item_flags");
        this.\u016c = this.Q(this.\u0179.getString("armor_appearance.armor_colors.chestplate", "255,215,0"));
        this.\u017b = this.Q(this.\u0179.getString("armor_appearance.armor_colors.leggings", "255,215,0"));
        this.\u0166 = this.Q(this.\u0179.getString("armor_appearance.armor_colors.boots", "255,215,0"));
        this.\u0170 = this.\u0179.getString("armor_appearance.helmet.primary_texture", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTI4MzA0Y2RjOTY1YzQxNzQwNWY5NjVjM2I2M2NhNGZiZjg2ZTg4ZTM0MWQ2OTMyN2NhMjdlM2EwOGMwYTIwMCJ9fX0=");
        try {
            this.\u0178 = Sound.valueOf(this.\u0179.getString("effects.sounds.equip", "ITEM_ARMOR_EQUIP_LEATHER"));
        }
        catch (final IllegalArgumentException ex2) {
            this.\u0178 = Sound.ITEM_ARMOR_EQUIP_LEATHER;
        }
        this.\u015f = (float)this.\u0179.getDouble("effects.sounds.equip_volume", 1.0);
        this.\u017a = (float)this.\u0179.getDouble("effects.sounds.equip_pitch", 1.0);
        try {
            this.\u016a = Sound.valueOf(this.\u0179.getString("effects.sounds.infection", "ENTITY_ZOMBIE_VILLAGER_CONVERTED"));
        }
        catch (final IllegalArgumentException ex3) {
            this.\u016a = Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED;
        }
        this.\u0173 = (float)this.\u0179.getDouble("effects.sounds.infection_volume", 1.0);
        this.\u016b = (float)this.\u0179.getDouble("effects.sounds.infection_pitch", 0.8);
    }
    
    private String P(final String s) {
        if (s == null) {
            return null;
        }
        return this.formatColors(s);
    }
    
    private Color Q(final String s) {
        if (s == null || s.isEmpty()) {
            return Color.fromRGB(255, 215, 0);
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
        return Color.fromRGB(255, 215, 0);
    }
    
    public void apply(final Player player) {
        this.takeArmorSnapshot(player);
        final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
        final ItemStack customHead = this.createCustomHead(this.\u0170);
        final ItemStack coloredArmor = this.createColoredArmor(Material.LEATHER_CHESTPLATE, this.\u016c);
        final ItemStack coloredArmor2 = this.createColoredArmor(Material.LEATHER_LEGGINGS, this.\u017b);
        final ItemStack coloredArmor3 = this.createColoredArmor(Material.LEATHER_BOOTS, this.\u0166);
        if (playerArmorSnapshot != null) {
            if (playerArmorSnapshot.CostumesItemsListener3() != null) {
                this.CostumesItemsListener6(playerArmorSnapshot.CostumesItemsListener3(), customHead);
            }
            if (playerArmorSnapshot.CostumesItemsListener5() != null) {
                this.CostumesItemsListener6(playerArmorSnapshot.CostumesItemsListener5(), coloredArmor);
            }
            if (playerArmorSnapshot.CostumesItemsListener2() != null) {
                this.CostumesItemsListener6(playerArmorSnapshot.CostumesItemsListener2(), coloredArmor2);
            }
            if (playerArmorSnapshot.CostumesItemsListener1() != null) {
                this.CostumesItemsListener6(playerArmorSnapshot.CostumesItemsListener1(), coloredArmor3);
            }
        }
        this.CostumesItemsListener6(customHead, "helmet");
        this.CostumesItemsListener6(coloredArmor, "chestplate");
        this.CostumesItemsListener6(coloredArmor2, "leggings");
        this.CostumesItemsListener6(coloredArmor3, "boots");
        player.getInventory().setHelmet(customHead);
        if (playerArmorSnapshot == null || !playerArmorSnapshot.CostumesItemsListener4()) {
            player.getInventory().setChestplate(coloredArmor);
        }
        player.getInventory().setLeggings(coloredArmor2);
        player.getInventory().setBoots(coloredArmor3);
        this.applyEffects(player);
        if (this.\u0178 != null) {
            player.playSound(player.getLocation(), this.\u0178, this.\u015f, this.\u017a);
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
    
    private void CostumesItemsListener6(final ItemStack itemStack, final String s) {
        if (itemStack == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return;
        }
        itemMeta.setDisplayName(this.\u0167);
        itemMeta.setLore((List)new ArrayList(this.\u017f));
        itemMeta.setUnbreakable(this.\u016e);
        for (final String s2 : this.\u0168) {
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
        CostumesItemsListener7.playerArmorMap.remove(player.getUniqueId());
        CostumesItemsListener7.\u0161.remove(player.getUniqueId());
    }
    
    public void update() {
        this.W();
    }
    
    public ItemStack getCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u0180);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u017e);
            itemMeta.setLore((List)new ArrayList(this.\u0181));
            if (this.\u0174 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u0174));
            }
            if (this.\u0182) {
                itemMeta.setUnbreakable(true);
            }
            for (final String s : this.\u0176) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u016f);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public ItemStack getPreviewCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u0180);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u0165);
            final ArrayList lore = new ArrayList((Collection<? extends CostumesItemsListener5>)this.\u0181);
            lore.removeIf(s2 -> {
                ChatColor.stripColor(s2);
                final String s3;
                return s3.contains("Kliknij") || s3.contains("przyciskiem");
            });
            itemMeta.setLore((List)lore);
            if (this.\u0174 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u0174));
            }
            if (this.\u0182) {
                itemMeta.setUnbreakable(true);
            }
            for (final String s : this.\u0176) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u016f);
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
    
    public void applyEffects(final Player player) {
        CostumesItemsListener7.\u0161.put(player.getUniqueId(), true);
        if (this.\u0172 > 0.0) {
            final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            if (attribute != null) {
                for (final AttributeModifier attributeModifier : new ArrayList(attribute.getModifiers())) {
                    if (attributeModifier.getUniqueId().equals(CostumesItemsListener7.\u0162)) {
                        attribute.removeModifier(attributeModifier);
                        break;
                    }
                }
                attribute.addModifier(new AttributeModifier(CostumesItemsListener7.\u0162, "costume_health_bonus", this.\u0172, AttributeModifier.Operation.ADD_NUMBER));
                player.setHealth(Math.min(player.getHealth() + this.\u0172, attribute.getValue()));
            }
        }
        if (this.\u0175 > 0.0) {
            final AttributeInstance attribute2 = player.getAttribute(Attribute.GENERIC_ARMOR);
            if (attribute2 != null) {
                for (final AttributeModifier attributeModifier2 : new ArrayList(attribute2.getModifiers())) {
                    if (attributeModifier2.getUniqueId().equals(CostumesItemsListener7.\u015e)) {
                        attribute2.removeModifier(attributeModifier2);
                        break;
                    }
                }
                attribute2.addModifier(new AttributeModifier(CostumesItemsListener7.\u015e, "costume_defense_bonus", this.\u0175, AttributeModifier.Operation.MULTIPLY_SCALAR_1));
            }
        }
    }
    
    public void removeEffects(final Player player) {
        CostumesItemsListener7.\u0161.remove(player.getUniqueId());
        final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (attribute != null) {
            for (final AttributeModifier attributeModifier : attribute.getModifiers()) {
                if (attributeModifier.getUniqueId().equals(CostumesItemsListener7.\u0162)) {
                    attribute.removeModifier(attributeModifier);
                    break;
                }
            }
        }
        final AttributeInstance attribute2 = player.getAttribute(Attribute.GENERIC_ARMOR);
        if (attribute2 != null) {
            for (final AttributeModifier attributeModifier2 : attribute2.getModifiers()) {
                if (attributeModifier2.getUniqueId().equals(CostumesItemsListener7.\u015e)) {
                    attribute2.removeModifier(attributeModifier2);
                    break;
                }
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteractEntity(final PlayerInteractEntityEvent playerInteractEntityEvent) {
        final Player player = playerInteractEntityEvent.getPlayer();
        if (!L.CostumesItemsListener6(player) || !(L.CostumesItemsListener1(player) instanceof CostumesItemsListener7)) {
            return;
        }
        if (!(playerInteractEntityEvent.getRightClicked() instanceof Player)) {
            return;
        }
        final Player player2 = (Player)playerInteractEntityEvent.getRightClicked();
        if (player2.equals((Object)player)) {
            return;
        }
        final CostumesItemsListener2 regionManager = Main.getInstance().getRegionManager();
        if (regionManager != null) {
            final boolean a = regionManager.CostumesItemsListener1(player);
            final boolean a2 = regionManager.CostumesItemsListener1(player2);
            if (a || a2) {
                final long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - CostumesItemsListener7.\u0164.getOrDefault(player.getUniqueId(), 0L) >= 500L) {
                    CostumesItemsListener7.\u0164.put(player.getUniqueId(), currentTimeMillis);
                    player.sendMessage("§cNie mo\u017cesz u\u017cy\u0107 §azara\u017cenia §cw tym regionie!");
                }
                return;
            }
        }
        if (this.I(player)) {
            final long h = this.CostumesItemsListener8(player);
            final long currentTimeMillis2 = System.currentTimeMillis();
            if (currentTimeMillis2 - CostumesItemsListener7.\u0164.getOrDefault(player.getUniqueId(), 0L) >= 500L) {
                CostumesItemsListener7.\u0164.put(player.getUniqueId(), currentTimeMillis2);
                final CostumesItemsListener1 languageManager = Main.getLanguageManager();
                if (languageManager != null) {
                    final String replace = languageManager.CostumesItemsListener6("costume.kostium-przeciwzakazeniowy.infection-cooldown").replace("%time%", String.valueOf(h));
                    if (replace != null && !replace.isEmpty() && !replace.contains("Missing language key")) {
                        player.sendMessage(replace);
                    }
                    else {
                        player.sendMessage("§cMusisz poczeka\u0107 " + h + " sekund przed ponownym u\u017cyciem zara\u017cenia!");
                    }
                }
                else {
                    player.sendMessage("§cMusisz poczeka\u0107 " + h + " sekund przed ponownym u\u017cyciem zara\u017cenia!");
                }
            }
            return;
        }
        this.CostumesItemsListener1(player, player2);
    }
    
    private void CostumesItemsListener1(final Player player, final Player player2) {
        this.L(player);
        CostumesItemsListener7.\u0171.put(player2.getUniqueId(), System.currentTimeMillis() + this.\u0163 * 1000L);
        player2.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, this.\u0163 * 20, 0, false, true));
        final Scoreboard mainScoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Team team = mainScoreboard.getTeam("infection_green");
        if (team == null) {
            team = mainScoreboard.registerNewTeam("infection_green");
            team.setColor(ChatColor.GREEN);
        }
        team.addEntry(player2.getName());
        Bukkit.getScheduler().runTaskLater((Plugin)Main.getInstance(), () -> {
            if (team2 != null) {
                team2.removeEntry(player3.getName());
            }
            return;
        }, this.\u0163 * 20L);
        if (this.\u016a != null) {
            player.playSound(player.getLocation(), this.\u016a, this.\u0173, this.\u016b);
            player2.playSound(player2.getLocation(), this.\u016a, this.\u0173, this.\u016b);
        }
        final CostumesItemsListener1 languageManager = Main.getLanguageManager();
        if (languageManager != null) {
            final String replace = languageManager.CostumesItemsListener6("costume.kostium-przeciwzakazeniowy.infection-received").replace("%duration%", String.valueOf(this.\u0163));
            if (replace != null && !replace.isEmpty() && !replace.contains("Missing language key")) {
                player2.sendMessage(replace);
            }
            else {
                player2.sendMessage("§cZosta\u0142e\u015b zara\u017cony! CostumesItemsListener2\u0119dziesz otrzymywa\u0142 wi\u0119ksze obra\u017cenia przez " + this.\u0163 + " sekund!");
            }
        }
        else {
            player2.sendMessage("§cZosta\u0142e\u015b zara\u017cony! CostumesItemsListener2\u0119dziesz otrzymywa\u0142 wi\u0119ksze obra\u017cenia przez " + this.\u0163 + " sekund!");
        }
        Bukkit.getScheduler().runTaskLater((Plugin)Main.getInstance(), () -> CostumesItemsListener7.\u0171.remove(player4.getUniqueId()), this.\u0163 * 20L);
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!(entityDamageByEntityEvent.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityDamageByEntityEvent.getEntity();
        final Long n = CostumesItemsListener7.\u0171.get(player.getUniqueId());
        if (n == null || System.currentTimeMillis() > n) {
            return;
        }
        if (entityDamageByEntityEvent.getDamager() instanceof final Player player2) {
            final CostumesItemsListener2 regionManager = Main.getInstance().getRegionManager();
            if (regionManager != null) {
                final boolean a = regionManager.CostumesItemsListener1(player2);
                final boolean a2 = regionManager.CostumesItemsListener1(player);
                if (a || a2) {
                    return;
                }
            }
        }
        entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() * this.\u0160);
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerDamage(final EntityDamageEvent entityDamageEvent) {
        if (!(entityDamageEvent.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityDamageEvent.getEntity();
        if (!this.\u017c || !L.CostumesItemsListener6(player) || !(L.CostumesItemsListener1(player) instanceof CostumesItemsListener7)) {
            return;
        }
        final EntityDamageEvent.DamageCause cause = entityDamageEvent.getCause();
        if (cause == EntityDamageEvent.DamageCause.POISON || cause == EntityDamageEvent.DamageCause.WITHER || cause == EntityDamageEvent.DamageCause.MAGIC) {
            entityDamageEvent.setCancelled(true);
        }
    }
    
    public String getHelmetTexture() {
        return this.\u0170;
    }
    
    public Color getChestplateColor() {
        return this.\u016c;
    }
    
    public Color getLeggingsColor() {
        return this.\u017b;
    }
    
    public Color getBootsColor() {
        return this.\u0166;
    }
    
    private boolean I(final Player player) {
        final Long n = CostumesItemsListener7.\u016d.get(player.getUniqueId());
        return n != null && System.currentTimeMillis() < n;
    }
    
    private long CostumesItemsListener8(final Player player) {
        final Long n = CostumesItemsListener7.\u016d.get(player.getUniqueId());
        if (n == null) {
            return 0L;
        }
        return Math.max(0L, (n - System.currentTimeMillis()) / 1000L);
    }
    
    private void L(final Player player) {
        CostumesItemsListener7.\u016d.put(player.getUniqueId(), System.currentTimeMillis() + this.\u0177 * 1000L);
        Bukkit.getScheduler().runTaskLater((Plugin)Main.getInstance(), () -> CostumesItemsListener7.\u016d.remove(player2.getUniqueId()), this.\u0177 * 20L);
    }
    
    private void CostumesItemsListener6(final ItemStack itemStack, final ItemStack itemStack2) {
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
            final double e = this.CostumesItemsListener5(itemStack.getType());
            final double f = this.CostumesItemsListener6(itemStack.getType());
            final double g = this.CostumesItemsListener7(itemStack.getType());
            if (e > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "costume_armor", e, AttributeModifier.Operation.ADD_NUMBER, this.CostumesItemsListener8(itemStack2.getType())));
            }
            if (f > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "costume_toughness", f, AttributeModifier.Operation.ADD_NUMBER, this.CostumesItemsListener8(itemStack2.getType())));
            }
            if (g > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "costume_knockback_resistance", g, AttributeModifier.Operation.ADD_NUMBER, this.CostumesItemsListener8(itemStack2.getType())));
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
    
    private double CostumesItemsListener5(final Material material) {
        switch (CostumesItemsListener7$1.CostumesItemsListener1[material.ordinal()]) {
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
    
    private double CostumesItemsListener6(final Material material) {
        switch (CostumesItemsListener7$1.CostumesItemsListener1[material.ordinal()]) {
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
    
    private double CostumesItemsListener7(final Material material) {
        switch (CostumesItemsListener7$1.CostumesItemsListener1[material.ordinal()]) {
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
    
    private EquipmentSlot CostumesItemsListener8(final Material material) {
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
        \u0162 = UUID.fromString("22222222-3333-4444-5555-666666666666");
        \u015e = UUID.fromString("77777777-8888-9999-aaaa-bbbbbbbbbbbb");
        \u0161 = new HashMap<UUID, Boolean>();
        \u0171 = new HashMap<UUID, Long>();
        \u016d = new HashMap<UUID, Long>();
        \u0164 = new HashMap<UUID, Long>();
        CostumesItemsListener7.\u017d = false;
    }
}
