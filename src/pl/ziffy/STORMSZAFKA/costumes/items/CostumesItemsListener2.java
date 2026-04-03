// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.items;

import java.util.HashMap;
import org.bukkit.scheduler.BukkitTask;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.event.EventHandler;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.enchantments.Enchantment;
import java.util.Iterator;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
import pl.ziffy.STORMSZAFKA.utils.CostumesItemsListener3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemStack;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService4;
import org.bukkit.entity.Player;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.ChatColor;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.function.Function;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.Main;
import java.text.DecimalFormat;
import java.util.UUID;
import java.util.Map;
import org.bukkit.Sound;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.Color;
import org.bukkit.Particle;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService5;

public class CostumesItemsListener2 extends J implements Listener
{
    private FileConfiguration g;
    private File w;
    private boolean J;
    private int N;
    private long W;
    private int p;
    private double x;
    private int CostumesItemsListener6;
    private Particle CostumesItemsListener5;
    private Color m;
    private double i;
    private double s;
    private boolean Q;
    private double U;
    private boolean CostumesItemsListener4;
    private int e;
    private Material o;
    private String l;
    private String CostumesItemsListener8;
    private List<String> r;
    private int Z;
    private boolean u;
    private List<String> _tmp;
    private Color X;
    private String M;
    private List<String> n;
    private Color T;
    private Color j;
    private Color K;
    private String Y;
    private boolean V;
    private List<String> O;
    private Sound f;
    private float CostumesItemsListener2;
    private float h;
    private Sound P;
    private float CostumesItemsListener3;
    private float R;
    private String CostumesItemsListener7;
    private String S;
    private String d;
    private String t;
    private static final Map<UUID, Long> a;
    private static final Map<UUID, Integer> CostumesItemsListener1;
    private static final Map<UUID, _A> c;
    private static final Map<UUID, Long> I;
    private static final Map<UUID, Double> b;
    private static final Map<UUID, Boolean> q;
    private static final long v = 180000L;
    private static final DecimalFormat L;
    private static boolean k;
    
    public CostumesItemsListener2() {
        super("mima", "Mim");
        this.w = new File(Main.getInstance().getCustomDataFolder(), "costumes/KostiumMima.yml");
        this.CostumesItemsListener3();
        if (this.plugin != null && !pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.k) {
            Bukkit.getPluginManager().registerEvents((Listener)this, this.plugin);
            pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.k = true;
        }
    }
    
    private void CostumesItemsListener3() {
        try {
            if (!this.w.exists()) {
                this.CostumesItemsListener2();
            }
            this.g = (FileConfiguration)YamlConfiguration.loadConfiguration(this.w);
            this.CostumesItemsListener4();
        }
        catch (final Exception ex) {
            this.CostumesItemsListener1();
        }
    }
    
    private void CostumesItemsListener2() {
        try {
            final File parentFile = this.w.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                if (Main.getInstance().getResource("costumes/KostiumMima.yml") != null) {
                    Main.getInstance().saveResource("costumes/KostiumMima.yml", false);
                    return;
                }
            }
            catch (final Exception ex) {}
            if (!this.w.exists()) {
                this.w.createNewFile();
            }
        }
        catch (final Exception ex2) {
            Main.getInstance().getLogger().severe("Failed to create default configuration for KostiumMima: " + ex2.getMessage());
        }
    }
    
    private void CostumesItemsListener4() {
        this.J = this.g.getBoolean("effects.pain_mirror.enabled", true);
        this.N = this.g.getInt("effects.pain_mirror.activation_shifts", 3);
        this.W = this.g.getLong("effects.pain_mirror.shift_timeout", 500L);
        this.p = this.g.getInt("effects.pain_mirror.duration", 200);
        this.x = this.g.getDouble("effects.pain_mirror.damage_reduction", 0.95);
        this.CostumesItemsListener6 = this.g.getInt("effects.pain_mirror.particle_interval", 30);
        try {
            this.CostumesItemsListener5 = Particle.valueOf(this.g.getString("effects.pain_mirror.particle_type", "REDSTONE"));
        }
        catch (final Exception ex) {
            this.CostumesItemsListener5 = Particle.REDSTONE;
        }
        this.m = this.CostumesItemsListener2(this.g.getString("effects.pain_mirror.particle_color", "85,0,127"));
        this.i = this.g.getDouble("effects.pain_mirror.particle_radius", 0.75);
        this.s = this.g.getDouble("effects.pain_mirror.particle_height_multiplier", 0.5);
        this.Q = this.g.getBoolean("effects.extra_damage.enabled", true);
        this.U = this.g.getDouble("effects.extra_damage.multiplier", 1.11);
        this.CostumesItemsListener4 = this.g.getBoolean("effects.extra_hearts.enabled", true);
        this.e = this.g.getInt("effects.extra_hearts.hearts", 4);
        this.o = Material.valueOf(this.g.getString("activation_item.material", "LEATHER_CHESTPLATE"));
        this.l = this.CostumesItemsListener4(this.g.getString("activation_item.display_name", "&7Kostium &5mima"));
        this.CostumesItemsListener8 = this.CostumesItemsListener4(this.g.getString("activation_item.preview_display_name", "&7Kostium &5mima"));
        this.r = (List)this.g.getStringList("activation_item.lore").stream().map(this::CostumesItemsListener4).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.Z = this.g.getInt("activation_item.custom_model_data", 0);
        this.u = this.g.getBoolean("activation_item.unbreakable", true);
        this._tmp = this.g.getStringList("activation_item.item_flags");
        this.X = this.CostumesItemsListener2(this.g.getString("activation_item.leather_color", "0,0,0"));
        this.M = this.CostumesItemsListener4(this.g.getString("armor_appearance.display_name", "&7Zbroja &5Mima"));
        this.n = (List)this.g.getStringList("armor_appearance.base_lore").stream().map(this::CostumesItemsListener4).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.T = this.CostumesItemsListener2(this.g.getString("armor_appearance.armor_colors.chestplate", "0,0,0"));
        this.j = this.CostumesItemsListener2(this.g.getString("armor_appearance.armor_colors.leggings", "255,255,255"));
        this.K = this.CostumesItemsListener2(this.g.getString("armor_appearance.armor_colors.boots", "0,0,0"));
        this.Y = this.g.getString("armor_appearance.helmet.primary_texture", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjUxMmE3ZWI2ZDMxNmU2NDNmMWViM2FhMDU1NDAxMDQ1ZmE3NDA4NmZiOGMzMmFiZWNhMmFhMzVhMTE3OWIifX19");
        this.V = this.g.getBoolean("armor_appearance.unbreakable", true);
        this.O = this.g.getStringList("armor_appearance.item_flags");
        this.f = Sound.valueOf(this.g.getString("effects.sounds.equip", "ITEM_ARMOR_EQUIP_LEATHER"));
        this.CostumesItemsListener2 = (float)this.g.getDouble("effects.sounds.equip_volume", 1.0);
        this.h = (float)this.g.getDouble("effects.sounds.equip_pitch", 1.0);
        this.P = Sound.valueOf(this.g.getString("effects.sounds.mirror_activate", "BLOCK_BEACON_ACTIVATE"));
        this.CostumesItemsListener3 = (float)this.g.getDouble("effects.sounds.mirror_activate_volume", 1.0);
        this.R = (float)this.g.getDouble("effects.sounds.mirror_activate_pitch", 1.5);
        this.CostumesItemsListener7 = this.CostumesItemsListener4(this.g.getString("messages.costume_equipped", "&7Za\u0142o\u017cono kostium &5Mima&7!"));
        this.S = this.CostumesItemsListener4(this.g.getString("messages.costume_removed", "&7Zdj\u0119to kostium &5Mima&7!"));
        this.d = this.CostumesItemsListener4(this.g.getString("messages.mirror_activated", "&5Lustro b\u00f3lu &7zosta\u0142o aktywowane na &f10 sekund&7!"));
        this.t = this.g.getString("messages.mirror_damage_message", "&7Zadasz &c{damage} obra\u017ce\u0144 &7za &f{time}s&7!");
    }
    
    private void CostumesItemsListener1() {
        this.J = true;
        this.N = 3;
        this.W = 500L;
        this.p = 200;
        this.x = 0.95;
        this.CostumesItemsListener6 = 30;
        this.CostumesItemsListener5 = Particle.REDSTONE;
        this.m = Color.fromRGB(85, 0, 127);
        this.i = 0.75;
        this.s = 0.5;
        this.Q = true;
        this.U = 1.11;
        this.CostumesItemsListener4 = true;
        this.e = 4;
        this.o = Material.LEATHER_CHESTPLATE;
        this.l = "§7Kostium §5mima";
        this.CostumesItemsListener8 = "§7Kostium §5mima";
        this.r = new ArrayList<String>(List.of("§8Unikatowa wersja!"));
        this.Z = 0;
        this.u = true;
        this._tmp = new ArrayList<String>(List.of("HIDE_ATTRIBUTES", "HIDE_UNBREAKABLE", "HIDE_DYE"));
        this.X = Color.fromRGB(0, 0, 0);
        this.M = "§7Zbroja §5Mima";
        this.n = new ArrayList<String>(List.of("§7", "§e§lKliknij§r §7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 §fzbroj\u0119§7!"));
        this.T = Color.fromRGB(0, 0, 0);
        this.j = Color.fromRGB(255, 255, 255);
        this.K = Color.fromRGB(0, 0, 0);
        this.Y = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjUxMmE3ZWI2ZDMxNmU2NDNmMWViM2FhMDU1NDAxMDQ1ZmE3NDA4NmZiOGMzMmFiZWNhMmFhMzVhMTE3OWIifX19";
        this.V = true;
        this.O = new ArrayList<String>(List.of("HIDE_ATTRIBUTES", "HIDE_UNBREAKABLE", "HIDE_DYE"));
        this.f = Sound.ITEM_ARMOR_EQUIP_LEATHER;
        this.CostumesItemsListener2 = 1.0f;
        this.h = 1.0f;
        this.P = Sound.BLOCK_BEACON_ACTIVATE;
        this.CostumesItemsListener3 = 1.0f;
        this.R = 1.5f;
        this.CostumesItemsListener7 = "§7Za\u0142o\u017cono kostium §5Mima§7!";
        this.S = "§7Zdj\u0119to kostium §5Mima§7!";
        this.d = "§5Lustro b\u00f3lu §7zosta\u0142o aktywowane na §f10 sekund§7!";
        this.t = "&7Zadasz &c{damage} obra\u017ce\u0144 &7za &f{time}s&7!";
    }
    
    private String CostumesItemsListener4(String c) {
        if (c == null) {
            return null;
        }
        c = this.CostumesItemsListener3(c);
        return ChatColor.translateAlternateColorCodes('&', c);
    }
    
    private String CostumesItemsListener3(final String s) {
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
    
    private Color CostumesItemsListener2(final String s) {
        try {
            final String[] split = s.split(",");
            if (split.length == 3) {
                return Color.fromRGB(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()), Integer.parseInt(split[2].trim()));
            }
        }
        catch (final Exception ex) {}
        return Color.fromRGB(0, 0, 0);
    }
    
    public void apply(final Player player) {
        this.takeArmorSnapshot(player);
        final I playerArmorSnapshot = pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService5.getPlayerArmorSnapshot(player.getUniqueId());
        final ItemStack customHead = this.createCustomHead(this.Y);
        final ItemStack coloredArmor = this.createColoredArmor(Material.LEATHER_CHESTPLATE, this.T);
        final ItemStack coloredArmor2 = this.createColoredArmor(Material.LEATHER_LEGGINGS, this.j);
        final ItemStack coloredArmor3 = this.createColoredArmor(Material.LEATHER_BOOTS, this.K);
        if (playerArmorSnapshot != null) {
            if (playerArmorSnapshot.CostumesItemsListener3() != null) {
                this.CostumesItemsListener1(playerArmorSnapshot.CostumesItemsListener3(), customHead);
            }
            if (playerArmorSnapshot.CostumesItemsListener5() != null) {
                this.CostumesItemsListener1(playerArmorSnapshot.CostumesItemsListener5(), coloredArmor);
            }
            if (playerArmorSnapshot.CostumesItemsListener2() != null) {
                this.CostumesItemsListener1(playerArmorSnapshot.CostumesItemsListener2(), coloredArmor2);
            }
            if (playerArmorSnapshot.CostumesItemsListener1() != null) {
                this.CostumesItemsListener1(playerArmorSnapshot.CostumesItemsListener1(), coloredArmor3);
            }
        }
        this.CostumesItemsListener1(customHead, "helmet");
        this.CostumesItemsListener1(coloredArmor, "chestplate");
        this.CostumesItemsListener1(coloredArmor2, "leggings");
        this.CostumesItemsListener1(coloredArmor3, "boots");
        player.getInventory().setHelmet(customHead);
        if (playerArmorSnapshot == null || !playerArmorSnapshot.CostumesItemsListener4()) {
            player.getInventory().setChestplate(coloredArmor);
        }
        player.getInventory().setLeggings(coloredArmor2);
        player.getInventory().setBoots(coloredArmor3);
        this.applyEffects(player);
        if (this.f != null) {
            player.playSound(player.getLocation(), this.f, this.CostumesItemsListener2, this.h);
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
    
    private void CostumesItemsListener1(final ItemStack itemStack, final String s) {
        if (itemStack == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return;
        }
        itemMeta.setDisplayName(this.M);
        itemMeta.setLore((List)new ArrayList(this.n));
        itemMeta.setUnbreakable(this.V);
        for (final String s2 : this.O) {
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
    
    private void CostumesItemsListener1(final ItemStack itemStack, final ItemStack itemStack2) {
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
        this.copyCustomEnchantsToLore(itemStack, itemStack2);
        itemStack2.setItemMeta(itemMeta2);
    }
    
    public void remove(final Player player) {
        this.removeEffects(player);
        this.restoreArmorFromSnapshot(player);
        pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.playerArmorMap.remove(player.getUniqueId());
        final UUID uniqueId = player.getUniqueId();
        final _A a = pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.c.remove(uniqueId);
        if (a != null && a.CostumesItemsListener4 != null) {
            a.CostumesItemsListener4.cancel();
        }
        pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.a.remove(uniqueId);
        pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.CostumesItemsListener1.remove(uniqueId);
        pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.q.remove(uniqueId);
    }
    
    public void update() {
        final long currentTimeMillis = System.currentTimeMillis();
        final ArrayList list = new ArrayList();
        for (final Map.Entry entry : pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.c.entrySet()) {
            if (currentTimeMillis >= ((_A)entry.getValue()).CostumesItemsListener1) {
                list.add(entry.getKey());
            }
        }
        final Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            this.CostumesItemsListener1((UUID)iterator2.next());
        }
    }
    
    public ItemStack getCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.o);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.l);
            itemMeta.setLore((List)new ArrayList(this.r));
            if (this.Z > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.Z));
            }
            itemMeta.setUnbreakable(this.u);
            for (final String s : this._tmp) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.X);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public ItemStack getPreviewCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.o);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.CostumesItemsListener8);
            itemMeta.setLore((List)new ArrayList(this.r));
            if (this.Z > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.Z));
            }
            itemMeta.setUnbreakable(this.u);
            for (final String s : this._tmp) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.X);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public void showOriginalArmor(final Player player) {
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        final I i = pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.playerArmorMap.get(player.getUniqueId());
        if (i == null) {
            return;
        }
        if (i.CostumesItemsListener3() != null) {
            player.getInventory().setHelmet(i.CostumesItemsListener3().clone());
        }
        else {
            player.getInventory().setHelmet((ItemStack)null);
        }
        if (!i.CostumesItemsListener4()) {
            if (i.CostumesItemsListener5() != null) {
                player.getInventory().setChestplate(i.CostumesItemsListener5().clone());
            }
            else {
                player.getInventory().setChestplate((ItemStack)null);
            }
        }
        if (i.CostumesItemsListener2() != null) {
            player.getInventory().setLeggings(i.CostumesItemsListener2().clone());
        }
        else {
            player.getInventory().setLeggings((ItemStack)null);
        }
        if (i.CostumesItemsListener1() != null) {
            player.getInventory().setBoots(i.CostumesItemsListener1().clone());
        }
        else {
            player.getInventory().setBoots((ItemStack)null);
        }
    }
    
    public void restoreCostume(final Player player) {
        this.apply(player);
    }
    
    public void applyEffects(final Player player) {
        if (this.CostumesItemsListener4) {
            final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            if (attribute != null) {
                final UUID uniqueId = player.getUniqueId();
                if (pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.b.containsKey(uniqueId)) {
                    final double baseValue = pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.b.get(uniqueId) + this.e * 2;
                    if (attribute.getBaseValue() != baseValue) {
                        attribute.setBaseValue(baseValue);
                    }
                    return;
                }
                pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.b.put(uniqueId, attribute.getBaseValue());
                final double n = attribute.getBaseValue() + this.e * 2;
                attribute.setBaseValue(n);
                player.setHealth(Math.min(player.getHealth() + this.e * 2, n));
            }
        }
    }
    
    public void removeEffects(final Player player) {
        if (this.CostumesItemsListener4 && pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.b.containsKey(player.getUniqueId())) {
            final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            if (attribute != null) {
                final double doubleValue = pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.b.remove(player.getUniqueId());
                attribute.setBaseValue(doubleValue);
                if (player.getHealth() > doubleValue) {
                    player.setHealth(doubleValue);
                }
            }
        }
    }
    
    @EventHandler
    public void onPlayerSneak(final PlayerToggleSneakEvent playerToggleSneakEvent) {
        if (!this.J) {
            return;
        }
        final Player player = playerToggleSneakEvent.getPlayer();
        final UUID uniqueId = player.getUniqueId();
        if (!"mima".equals(pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.CostumesItemsListener4(player))) {
            pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.q.remove(uniqueId);
            return;
        }
        if (pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.c.containsKey(uniqueId)) {
            return;
        }
        if (playerToggleSneakEvent.isSneaking()) {
            if (pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.q.getOrDefault(uniqueId, false)) {
                return;
            }
            pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.q.put(uniqueId, true);
            final long currentTimeMillis = System.currentTimeMillis();
            final Long n = pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.I.get(uniqueId);
            if (n != null) {
                final long n2 = currentTimeMillis - n;
                if (n2 < 180000L) {
                    player.sendMessage(this.CostumesItemsListener4("&cLustro b\u00f3lu jest na cooldownie! Pozosta\u0142o: &f" + (180000L - n2) / 1000L));
                    pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.CostumesItemsListener1.put(uniqueId, 0);
                    pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.a.remove(uniqueId);
                    return;
                }
            }
            final Long n3 = pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.a.get(uniqueId);
            if (n3 != null && currentTimeMillis - n3 > this.W) {
                pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.CostumesItemsListener1.put(uniqueId, 1);
                pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.a.put(uniqueId, currentTimeMillis);
                return;
            }
            final int i = pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.CostumesItemsListener1.getOrDefault(uniqueId, 0) + 1;
            pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.CostumesItemsListener1.put(uniqueId, i);
            pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.a.put(uniqueId, currentTimeMillis);
            if (i >= this.N) {
                final pl.ziffy.STORMSZAFKA.regions.CostumesItemsListener2 regionManager = Main.getInstance().getRegionManager();
                if (regionManager != null && regionManager.CostumesItemsListener1(player)) {
                    player.sendMessage(this.CostumesItemsListener4("&cNie mo\u017cesz u\u017cy\u0107 &5Lustra b\u00f3lu &cw tym regionie!"));
                    pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.CostumesItemsListener1.put(uniqueId, 0);
                    pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.a.remove(uniqueId);
                    return;
                }
                this.CostumesItemsListener2(player);
                pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.CostumesItemsListener1.put(uniqueId, 0);
                pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.a.remove(uniqueId);
            }
        }
        else {
            pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.q.put(uniqueId, false);
        }
    }
    
    private void CostumesItemsListener2(final Player player) {
        final UUID uniqueId = player.getUniqueId();
        final long currentTimeMillis = System.currentTimeMillis();
        final _A a = new _A(currentTimeMillis + this.p * 50L);
        pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.c.put(uniqueId, a);
        pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.I.put(uniqueId, currentTimeMillis);
        if (this.P != null) {
            player.playSound(player.getLocation(), this.P, this.CostumesItemsListener3, this.R);
        }
        if (this.d != null && !this.d.isEmpty()) {
            player.sendMessage(this.d);
        }
        a.CostumesItemsListener4 = new BukkitRunnable() {
            public void run() {
                final _A a = pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.c.get(uniqueId);
                if (a == null || System.currentTimeMillis() >= a.CostumesItemsListener1) {
                    pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.this.CostumesItemsListener1(uniqueId);
                    this.cancel();
                    return;
                }
                final Player player = Bukkit.getPlayer(uniqueId);
                if (player == null || !player.isOnline()) {
                    pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.this.CostumesItemsListener1(uniqueId);
                    this.cancel();
                    return;
                }
                pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.this.CostumesItemsListener1(player);
            }
        }.runTaskTimer(this.plugin, 0L, (long)this.CostumesItemsListener6);
    }
    
    private void CostumesItemsListener1(final Player player) {
        final Location location = player.getLocation();
        final double n = player.getHeight() * this.s;
        for (int n2 = 5, i = 0; i < n2; ++i) {
            final double n3 = n - n * i / (n2 - 1);
            for (int j = 0; j < 20; ++j) {
                final double n4 = 6.283185307179586 * j / 20.0;
                final Location location2 = new Location(location.getWorld(), location.getX() + this.i * Math.cos(n4), location.getY() + n3, location.getZ() + this.i * Math.sin(n4));
                if (this.CostumesItemsListener5 == Particle.REDSTONE) {
                    player.getWorld().spawnParticle(this.CostumesItemsListener5, location2, 1, 0.0, 0.0, 0.0, 0.0, (Object)new Particle.DustOptions(this.m, 1.0f));
                }
                else {
                    player.getWorld().spawnParticle(this.CostumesItemsListener5, location2, 1, 0.0, 0.0, 0.0, 0.0);
                }
            }
        }
    }
    
    private void CostumesItemsListener1(final UUID uuid) {
        final _A a = pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.c.remove(uuid);
        if (a == null) {
            return;
        }
        if (a.CostumesItemsListener4 != null) {
            a.CostumesItemsListener4.cancel();
        }
        if (a.CostumesItemsListener3 != null && a.CostumesItemsListener6 > 0.0) {
            final Player player = Bukkit.getPlayer(a.CostumesItemsListener3);
            final Player player2 = Bukkit.getPlayer(uuid);
            if (player != null && player.isOnline()) {
                final pl.ziffy.STORMSZAFKA.regions.CostumesItemsListener2 regionManager = Main.getInstance().getRegionManager();
                if (regionManager != null) {
                    final boolean a2 = regionManager.CostumesItemsListener1(player);
                    final boolean b = player2 != null && regionManager.CostumesItemsListener1(player2);
                    if (a2 || b) {
                        if (player2 != null) {
                            player2.sendMessage(this.CostumesItemsListener4("&cObra\u017cenia nie zosta\u0142y odbite - jeden z graczy jest w chronionym regionie!"));
                        }
                        return;
                    }
                }
                player.damage(a.CostumesItemsListener6);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!(entityDamageByEntityEvent.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityDamageByEntityEvent.getEntity();
        final UUID uniqueId = player.getUniqueId();
        final _A a = pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.c.get(uniqueId);
        if (a != null) {
            if (!"mima".equals(pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.CostumesItemsListener4(player))) {
                final _A a2 = pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.c.remove(uniqueId);
                if (a2 != null && a2.CostumesItemsListener4 != null) {
                    a2.CostumesItemsListener4.cancel();
                }
            }
            else if (entityDamageByEntityEvent.getDamager() instanceof final Player player2) {
                final pl.ziffy.STORMSZAFKA.regions.CostumesItemsListener2 regionManager = Main.getInstance().getRegionManager();
                if (regionManager != null) {
                    final boolean a3 = regionManager.CostumesItemsListener1(player2);
                    final boolean a4 = regionManager.CostumesItemsListener1(player);
                    if (a3 || a4) {
                        return;
                    }
                }
                final double damage = entityDamageByEntityEvent.getDamage();
                entityDamageByEntityEvent.setDamage(damage * (1.0 - this.x));
                a.CostumesItemsListener1(player2.getUniqueId(), damage);
                player.sendMessage(this.CostumesItemsListener4(this.t).replace("{damage}", pl.ziffy.STORMSZAFKA.costumes.items.CostumesItemsListener2.L.format(a.CostumesItemsListener6)).replace("{time}", String.valueOf(a.CostumesItemsListener1())));
            }
        }
        if (this.Q && entityDamageByEntityEvent.getDamager() instanceof Player && "mima".equals(pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.CostumesItemsListener4((Player)entityDamageByEntityEvent.getDamager()))) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() * this.U);
        }
    }
    
    public String getHelmetTexture() {
        return this.Y;
    }
    
    public Color getChestplateColor() {
        return this.T;
    }
    
    public Color getLeggingsColor() {
        return this.j;
    }
    
    public Color getBootsColor() {
        return this.K;
    }
    
    static {
        a = new ConcurrentHashMap<UUID, Long>();
        CostumesItemsListener1 = new ConcurrentHashMap<UUID, Integer>();
        c = new ConcurrentHashMap<UUID, _A>();
        I = new ConcurrentHashMap<UUID, Long>();
        b = new ConcurrentHashMap<UUID, Double>();
        q = new ConcurrentHashMap<UUID, Boolean>();
        L = new DecimalFormat("#.##");
        CostumesItemsListener2.k = false;
    }
    
    private static class _A
    {
        double CostumesItemsListener6;
        UUID CostumesItemsListener3;
        double CostumesItemsListener5;
        Map<UUID, Double> CostumesItemsListener2;
        long CostumesItemsListener1;
        BukkitTask CostumesItemsListener4;
        
        _A(final long a) {
            this.CostumesItemsListener6 = 0.0;
            this.CostumesItemsListener3 = null;
            this.CostumesItemsListener5 = 0.0;
            this.CostumesItemsListener2 = new HashMap<UUID, Double>();
            this.CostumesItemsListener1 = a;
        }
        
        void CostumesItemsListener1(final UUID uuid, final double n) {
            this.CostumesItemsListener6 += n;
            final double n2 = this.CostumesItemsListener2.getOrDefault(uuid, 0.0) + n;
            this.CostumesItemsListener2.put(uuid, n2);
            if (n2 > this.CostumesItemsListener5) {
                this.CostumesItemsListener5 = n2;
                this.CostumesItemsListener3 = uuid;
            }
        }
        
        long CostumesItemsListener1() {
            return Math.max(0L, (this.CostumesItemsListener1 - System.currentTimeMillis()) / 1000L);
        }
    }
}
