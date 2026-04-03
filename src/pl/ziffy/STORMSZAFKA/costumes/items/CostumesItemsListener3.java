// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.items;

import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import java.util.Random;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.enchantments.Enchantment;
import java.util.Iterator;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;
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
import java.util.UUID;
import java.util.Map;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Sound;
import org.bukkit.Color;
import java.util.List;
import org.bukkit.Material;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService5;

public class CostumesItemsListener3 extends J implements Listener
{
    private FileConfiguration \u00ce;
    private File \u00dd;
    private boolean \u00d9;
    private int ¢;
    private int \u00d3;
    private int \u00da;
    private int \u00c3;
    private boolean z;
    private double \u00cb;
    private boolean \u00d5;
    private int \u00d1;
    private boolean £;
    private int \u00cc;
    private Material \u00d8;
    private String \u00d4;
    private String ¥;
    private List<String> \u00db;
    private int \u00c8;
    private boolean \u00dc;
    private List<String> \u00c9;
    private Color \u00c6;
    private String µ;
    private List<String> \u00d6;
    private Color \u00c1;
    private Color \u00d0;
    private Color ª;
    private String \u00c7;
    private boolean \u00c4;
    private List<String> º;
    private Sound \u00cd;
    private float y;
    private float \u00cf;
    private String ¤;
    private String \u00c0;
    private BukkitRunnable \u00c2;
    private static final Map<UUID, Double> \u00ca;
    private static boolean \u00d2;
    private static CostumesItemsListener3 \u00c5;
    
    public CostumesItemsListener3() {
        super("nurekglebinowy", "Nurek CostumesItemsListener7\u0142\u0119binowy");
        this.\u00dd = new File(Main.getInstance().getCustomDataFolder(), "costumes/KostiumNurkaG\u0142\u0119binowego.yml");
        this.CostumesItemsListener7();
        if (!CostumesItemsListener3.\u00d2 && this.plugin != null) {
            CostumesItemsListener3.\u00c5 = this;
            Bukkit.getPluginManager().registerEvents((Listener)this, this.plugin);
            CostumesItemsListener3.\u00d2 = true;
        }
        this.CostumesItemsListener8();
    }
    
    private void CostumesItemsListener7() {
        try {
            if (!this.\u00dd.exists()) {
                this.CostumesItemsListener6();
            }
            this.\u00ce = (FileConfiguration)YamlConfiguration.loadConfiguration(this.\u00dd);
            this.I();
        }
        catch (final Exception ex) {
            this.CostumesItemsListener5();
        }
    }
    
    private void CostumesItemsListener6() {
        try {
            final File parentFile = this.\u00dd.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                if (Main.getInstance().getResource("costumes/KostiumNurkaG\u0142\u0119binowego.yml") != null) {
                    Main.getInstance().saveResource("costumes/KostiumNurkaG\u0142\u0119binowego.yml", false);
                    return;
                }
            }
            catch (final Exception ex) {}
            if (!this.\u00dd.exists()) {
                this.\u00dd.createNewFile();
            }
        }
        catch (final Exception ex2) {
            Main.getInstance().getLogger().severe("Failed to create default configuration for KostiumNurkaG\u0142\u0119binowego: " + ex2.getMessage());
        }
    }
    
    private void I() {
        this.\u00d9 = this.\u00ce.getBoolean("effects.dolphins_grace.enabled", true);
        this.¢ = this.\u00ce.getInt("effects.dolphins_grace.duration", 200);
        this.\u00d3 = this.\u00ce.getInt("effects.dolphins_grace.amplifier", 0);
        this.\u00da = this.\u00ce.getInt("effects.dolphins_grace.check_interval_min", 600);
        this.\u00c3 = this.\u00ce.getInt("effects.dolphins_grace.check_interval_max", 1200);
        this.z = this.\u00ce.getBoolean("effects.water_damage_boost.enabled", true);
        this.\u00cb = this.\u00ce.getDouble("effects.water_damage_boost.multiplier", 1.75);
        this.\u00d5 = this.\u00ce.getBoolean("effects.speed.enabled", true);
        this.\u00d1 = this.\u00ce.getInt("effects.speed.amplifier", 1);
        this.£ = this.\u00ce.getBoolean("effects.extra_hearts.enabled", true);
        this.\u00cc = this.\u00ce.getInt("effects.extra_hearts.hearts", 4);
        this.\u00d8 = Material.valueOf(this.\u00ce.getString("activation_item.material", "LEATHER_CHESTPLATE"));
        this.\u00d4 = this.CostumesItemsListener7(this.\u00ce.getString("activation_item.display_name", "&7Kostium &bnurka g\u0142\u0119binowego"));
        this.¥ = this.CostumesItemsListener7(this.\u00ce.getString("activation_item.preview_display_name", "&7Kostium &bnurka g\u0142\u0119binowego"));
        this.\u00db = (List)this.\u00ce.getStringList("activation_item.lore").stream().map(this::CostumesItemsListener7).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.\u00c8 = this.\u00ce.getInt("activation_item.custom_model_data", 0);
        this.\u00dc = this.\u00ce.getBoolean("activation_item.unbreakable", true);
        this.\u00c9 = this.\u00ce.getStringList("activation_item.item_flags");
        this.\u00c6 = this.CostumesItemsListener5(this.\u00ce.getString("activation_item.leather_color", "0,100,100"));
        this.µ = this.CostumesItemsListener7(this.\u00ce.getString("armor_appearance.display_name", "&7Zbroja &bNurka CostumesItemsListener7\u0142\u0119binowego"));
        this.\u00d6 = (List)this.\u00ce.getStringList("armor_appearance.base_lore").stream().map(this::CostumesItemsListener7).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.\u00c1 = this.CostumesItemsListener5(this.\u00ce.getString("armor_appearance.armor_colors.chestplate", "0,100,100"));
        this.\u00d0 = this.CostumesItemsListener5(this.\u00ce.getString("armor_appearance.armor_colors.leggings", "0,100,100"));
        this.ª = this.CostumesItemsListener5(this.\u00ce.getString("armor_appearance.armor_colors.boots", "0,100,100"));
        this.\u00c7 = this.\u00ce.getString("armor_appearance.helmet.primary_texture", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjc2OTgxN2MzMmVjNGIwZDNiM2NkYzUwOGE0ZDZjOGExOTFhMjUyMzA2MzRkMWYwMGU1N2E3NzRkNGNiODhhOCJ9fX0=");
        this.\u00c4 = this.\u00ce.getBoolean("armor_appearance.unbreakable", true);
        this.º = this.\u00ce.getStringList("armor_appearance.item_flags");
        this.\u00cd = Sound.valueOf(this.\u00ce.getString("effects.sounds.equip", "ITEM_ARMOR_EQUIP_LEATHER"));
        this.y = (float)this.\u00ce.getDouble("effects.sounds.equip_volume", 1.0);
        this.\u00cf = (float)this.\u00ce.getDouble("effects.sounds.equip_pitch", 1.0);
        this.¤ = this.CostumesItemsListener7(this.\u00ce.getString("messages.costume_equipped", "&7Za\u0142o\u017cono kostium &bNurka CostumesItemsListener7\u0142\u0119binowego&7!"));
        this.\u00c0 = this.CostumesItemsListener7(this.\u00ce.getString("messages.costume_removed", "&7Zdj\u0119to kostium &bNurka CostumesItemsListener7\u0142\u0119binowego&7!"));
    }
    
    private void CostumesItemsListener5() {
        this.\u00d9 = true;
        this.¢ = 200;
        this.\u00d3 = 0;
        this.\u00da = 600;
        this.\u00c3 = 1200;
        this.z = true;
        this.\u00cb = 1.3;
        this.\u00d5 = true;
        this.\u00d1 = 1;
        this.£ = true;
        this.\u00cc = 4;
        this.\u00d8 = Material.LEATHER_CHESTPLATE;
        this.\u00d4 = "§7Kostium §bnurka g\u0142\u0119binowego";
        this.¥ = "§7Kostium §bnurka g\u0142\u0119binowego";
        this.\u00db = new ArrayList<String>(List.of("§8Unikatowa wersja!"));
        this.\u00c8 = 0;
        this.\u00dc = true;
        this.\u00c9 = new ArrayList<String>(List.of("HIDE_ATTRIBUTES", "HIDE_UNBREAKABLE", "HIDE_DYE"));
        this.\u00c6 = Color.fromRGB(0, 100, 100);
        this.µ = "§7Zbroja §bNurka CostumesItemsListener7\u0142\u0119binowego";
        this.\u00d6 = new ArrayList<String>(List.of("§7", "§e§lKliknij§r §7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 §fzbroj\u0119§7!"));
        this.\u00c1 = Color.fromRGB(0, 100, 100);
        this.\u00d0 = Color.fromRGB(0, 100, 100);
        this.ª = Color.fromRGB(0, 100, 100);
        this.\u00c7 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjc2OTgxN2MzMmVjNGIwZDNiM2NkYzUwOGE0ZDZjOGExOTFhMjUyMzA2MzRkMWYwMGU1N2E3NzRkNGNiODhhOCJ9fX0=";
        this.\u00c4 = true;
        this.º = new ArrayList<String>(List.of("HIDE_ATTRIBUTES", "HIDE_UNBREAKABLE", "HIDE_DYE"));
        this.\u00cd = Sound.ITEM_ARMOR_EQUIP_LEATHER;
        this.y = 1.0f;
        this.\u00cf = 1.0f;
        this.¤ = "§7Za\u0142o\u017cono kostium §bNurka CostumesItemsListener7\u0142\u0119binowego§7!";
        this.\u00c0 = "§7Zdj\u0119to kostium §bNurka CostumesItemsListener7\u0142\u0119binowego§7!";
    }
    
    private String CostumesItemsListener7(String f) {
        if (f == null) {
            return null;
        }
        f = this.CostumesItemsListener6(f);
        return ChatColor.translateAlternateColorCodes('&', f);
    }
    
    private String CostumesItemsListener6(final String s) {
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
    
    private Color CostumesItemsListener5(final String s) {
        try {
            final String[] split = s.split(",");
            if (split.length == 3) {
                return Color.fromRGB(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()), Integer.parseInt(split[2].trim()));
            }
        }
        catch (final Exception ex) {}
        return Color.fromRGB(0, 100, 100);
    }
    
    public void apply(final Player player) {
        this.takeArmorSnapshot(player);
        final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
        final ItemStack customHead = this.createCustomHead(this.\u00c7);
        final ItemStack coloredArmor = this.createColoredArmor(Material.LEATHER_CHESTPLATE, this.\u00c1);
        final ItemStack coloredArmor2 = this.createColoredArmor(Material.LEATHER_LEGGINGS, this.\u00d0);
        final ItemStack coloredArmor3 = this.createColoredArmor(Material.LEATHER_BOOTS, this.ª);
        if (playerArmorSnapshot != null) {
            if (playerArmorSnapshot.CostumesItemsListener3() != null) {
                this.CostumesItemsListener2(playerArmorSnapshot.CostumesItemsListener3(), customHead);
            }
            if (playerArmorSnapshot.CostumesItemsListener5() != null) {
                this.CostumesItemsListener2(playerArmorSnapshot.CostumesItemsListener5(), coloredArmor);
            }
            if (playerArmorSnapshot.CostumesItemsListener2() != null) {
                this.CostumesItemsListener2(playerArmorSnapshot.CostumesItemsListener2(), coloredArmor2);
            }
            if (playerArmorSnapshot.CostumesItemsListener1() != null) {
                this.CostumesItemsListener2(playerArmorSnapshot.CostumesItemsListener1(), coloredArmor3);
            }
        }
        this.CostumesItemsListener2(customHead, "helmet");
        this.CostumesItemsListener2(coloredArmor, "chestplate");
        this.CostumesItemsListener2(coloredArmor2, "leggings");
        this.CostumesItemsListener2(coloredArmor3, "boots");
        player.getInventory().setHelmet(customHead);
        if (playerArmorSnapshot == null || !playerArmorSnapshot.CostumesItemsListener4()) {
            player.getInventory().setChestplate(coloredArmor);
        }
        player.getInventory().setLeggings(coloredArmor2);
        player.getInventory().setBoots(coloredArmor3);
        this.applyEffects(player);
        if (this.\u00cd != null) {
            player.playSound(player.getLocation(), this.\u00cd, this.y, this.\u00cf);
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
    
    private void CostumesItemsListener2(final ItemStack itemStack, final String s) {
        if (itemStack == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return;
        }
        itemMeta.setDisplayName(this.µ);
        itemMeta.setLore((List)new ArrayList(this.\u00d6));
        itemMeta.setUnbreakable(this.\u00c4);
        for (final String s2 : this.º) {
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
    
    private void CostumesItemsListener2(final ItemStack itemStack, final ItemStack itemStack2) {
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
        CostumesItemsListener3.playerArmorMap.remove(player.getUniqueId());
    }
    
    public void update() {
    }
    
    public ItemStack getCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u00d8);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u00d4);
            itemMeta.setLore((List)new ArrayList(this.\u00db));
            if (this.\u00c8 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u00c8));
            }
            itemMeta.setUnbreakable(this.\u00dc);
            for (final String s : this.\u00c9) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u00c6);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public ItemStack getPreviewCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u00d8);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.¥);
            itemMeta.setLore((List)new ArrayList(this.\u00db));
            if (this.\u00c8 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u00c8));
            }
            itemMeta.setUnbreakable(this.\u00dc);
            for (final String s : this.\u00c9) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u00c6);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public void showOriginalArmor(final Player player) {
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        final I i = CostumesItemsListener3.playerArmorMap.get(player.getUniqueId());
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
        if (this.\u00d5) {
            player.removePotionEffect(PotionEffectType.SPEED);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u00d1, false, false));
        }
        if (this.£) {
            final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            if (attribute != null) {
                final UUID uniqueId = player.getUniqueId();
                if (CostumesItemsListener3.\u00ca.containsKey(uniqueId)) {
                    attribute.setBaseValue((double)CostumesItemsListener3.\u00ca.get(uniqueId));
                }
                CostumesItemsListener3.\u00ca.put(uniqueId, attribute.getBaseValue());
                final double n = attribute.getBaseValue() + this.\u00cc * 2;
                attribute.setBaseValue(n);
                player.setHealth(Math.min(player.getHealth() + this.\u00cc * 2, n));
            }
        }
    }
    
    public void removeEffects(final Player player) {
        if (this.\u00d5) {
            player.removePotionEffect(PotionEffectType.SPEED);
        }
        if (this.\u00d9) {
            player.removePotionEffect(PotionEffectType.DOLPHINS_GRACE);
        }
        if (this.£ && CostumesItemsListener3.\u00ca.containsKey(player.getUniqueId())) {
            final AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            if (attribute != null) {
                final double doubleValue = CostumesItemsListener3.\u00ca.remove(player.getUniqueId());
                attribute.setBaseValue(doubleValue);
                if (player.getHealth() > doubleValue) {
                    player.setHealth(doubleValue);
                }
            }
        }
    }
    
    private void CostumesItemsListener8() {
        if (!this.\u00d9) {
            return;
        }
        this.\u00c2 = new BukkitRunnable() {
            private final Random CostumesItemsListener1 = new Random();
            
            public void run() {
                final Iterator iterator = CostumesItemsListener3.playerArmorMap.keySet().iterator();
                while (iterator.hasNext()) {
                    final Player player = Bukkit.getPlayer((UUID)iterator.next());
                    if (player != null && player.isOnline() && "nurekglebinowy".equals(L.CostumesItemsListener4(player)) && player.isInWater()) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, CostumesItemsListener3.this.¢, CostumesItemsListener3.this.\u00d3, false, false));
                    }
                }
            }
        };
        final int n = this.\u00da + new Random().nextInt(this.\u00c3 - this.\u00da + 1);
        this.\u00c2.runTaskTimer(this.plugin, (long)n, (long)n);
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerDamageInWater(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!this.z) {
            return;
        }
        if (entityDamageByEntityEvent.getDamager() instanceof Player && entityDamageByEntityEvent.getEntity() instanceof LivingEntity) {
            final Player player = (Player)entityDamageByEntityEvent.getDamager();
            if ("nurekglebinowy".equals(L.CostumesItemsListener4(player)) && player.isInWater()) {
                final double damage = entityDamageByEntityEvent.getDamage();
                entityDamageByEntityEvent.setDamage(damage + damage * 0.3);
            }
        }
    }
    
    public String getHelmetTexture() {
        return this.\u00c7;
    }
    
    public Color getChestplateColor() {
        return this.\u00c1;
    }
    
    public Color getLeggingsColor() {
        return this.\u00d0;
    }
    
    public Color getBootsColor() {
        return this.ª;
    }
    
    static {
        \u00ca = new ConcurrentHashMap<UUID, Double>();
        CostumesItemsListener3.\u00d2 = false;
        CostumesItemsListener3.\u00c5 = null;
    }
}
