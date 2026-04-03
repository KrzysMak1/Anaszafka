// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.items;

import java.util.HashMap;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
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

public class CostumesItemsListener6 extends J implements Listener
{
    private FileConfiguration \u015a;
    private File \u0156;
    private boolean \u015b;
    private double \u0147;
    private boolean \u013e;
    private double \u0149;
    private boolean \u013f;
    private double \u0145;
    private boolean \u014e;
    private Material \u014d;
    private String \u0152;
    private String \u0140;
    private List<String> \u0155;
    private int \u0141;
    private boolean \u014f;
    private List<String> \u0159;
    private Color \u0154;
    private String \u0150;
    private List<String> \u0146;
    private Color \u0143;
    private Color \u0144;
    private Color \u014c;
    private String \u0157;
    private boolean \u0148;
    private List<String> \u015d;
    private Sound \u0158;
    private float \u0142;
    private float \u0151;
    private String \u0153;
    private String \u014b;
    private static final Map<UUID, Boolean> \u015c;
    private static boolean \u014a;
    
    public CostumesItemsListener6() {
        super("pirata", "Pirat");
        this.\u0156 = new File(Main.getInstance().getCustomDataFolder(), "costumes/KostiumPirata.yml");
        this.T();
        if (this.plugin != null && !CostumesItemsListener6.\u014a) {
            Bukkit.getPluginManager().registerEvents((Listener)this, this.plugin);
            CostumesItemsListener6.\u014a = true;
        }
    }
    
    private void T() {
        try {
            if (!this.\u0156.exists()) {
                this.S();
            }
            this.\u015a = (FileConfiguration)YamlConfiguration.loadConfiguration(this.\u0156);
            this.U();
        }
        catch (final Exception ex) {
            this.R();
        }
    }
    
    private void S() {
        try {
            final File parentFile = this.\u0156.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                if (Main.getInstance().getResource("costumes/KostiumPirata.yml") != null) {
                    Main.getInstance().saveResource("costumes/KostiumPirata.yml", false);
                    return;
                }
            }
            catch (final Exception ex) {}
            if (!this.\u0156.exists()) {
                this.\u0156.createNewFile();
            }
        }
        catch (final Exception ex2) {
            Main.getInstance().getLogger().severe("Failed to create default configuration for KostiumPirata: " + ex2.getMessage());
        }
    }
    
    private void U() {
        this.\u015b = this.\u015a.getBoolean("effects.extra_damage.enabled", true);
        this.\u0147 = this.\u015a.getDouble("effects.extra_damage.multiplier", 1.13);
        this.\u013e = this.\u015a.getBoolean("effects.reduced_defense.enabled", true);
        this.\u0149 = this.\u015a.getDouble("effects.reduced_defense.multiplier", 1.05);
        this.\u013f = this.\u015a.getBoolean("effects.money_steal.enabled", true);
        this.\u0145 = this.\u015a.getDouble("effects.money_steal.percentage", 3.0);
        this.\u014e = this.\u015a.getBoolean("effects.money_steal.requires_vault", true);
        this.\u014d = Material.valueOf(this.\u015a.getString("activation_item.material", "LEATHER_CHESTPLATE"));
        this.\u0152 = this.O(this.\u015a.getString("activation_item.display_name", "&7Kostium &6pirata"));
        this.\u0140 = this.O(this.\u015a.getString("activation_item.preview_display_name", "&7Kostium &6pirata"));
        this.\u0155 = (List)this.\u015a.getStringList("activation_item.lore").stream().map(this::O).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.\u0141 = this.\u015a.getInt("activation_item.custom_model_data", 0);
        this.\u014f = this.\u015a.getBoolean("activation_item.unbreakable", true);
        this.\u0159 = this.\u015a.getStringList("activation_item.item_flags");
        this.\u0154 = this.M(this.\u015a.getString("activation_item.leather_color", "101,67,33"));
        this.\u0150 = this.O(this.\u015a.getString("armor_appearance.display_name", "&7Zbroja &6Pirata"));
        this.\u0146 = (List)this.\u015a.getStringList("armor_appearance.base_lore").stream().map(this::O).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.\u0143 = this.M(this.\u015a.getString("armor_appearance.armor_colors.chestplate", "101,67,33"));
        this.\u0144 = this.M(this.\u015a.getString("armor_appearance.armor_colors.leggings", "101,67,33"));
        this.\u014c = this.M(this.\u015a.getString("armor_appearance.armor_colors.boots", "101,67,33"));
        this.\u0157 = this.\u015a.getString("armor_appearance.helmet.primary_texture", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2E1MTMzYzFlNDAwODQyNWFkYjE0NTBlYjhmNmU4YjZhNGRiNDY1OTI1OWRmMjNlYWQ3ODc0MjU2ZjhjYmM0NyJ9fX0=");
        this.\u0148 = this.\u015a.getBoolean("armor_appearance.unbreakable", true);
        this.\u015d = this.\u015a.getStringList("armor_appearance.item_flags");
        this.\u0158 = Sound.valueOf(this.\u015a.getString("effects.sounds.equip", "ITEM_ARMOR_EQUIP_LEATHER"));
        this.\u0142 = (float)this.\u015a.getDouble("effects.sounds.equip_volume", 1.0);
        this.\u0151 = (float)this.\u015a.getDouble("effects.sounds.equip_pitch", 1.0);
        this.\u0153 = this.O(this.\u015a.getString("messages.costume_equipped", "&7Za\u0142o\u017cono kostium &6Pirata&7!"));
        this.\u014b = this.O(this.\u015a.getString("messages.costume_removed", "&7Zdj\u0119to kostium &6Pirata&7!"));
    }
    
    private void R() {
        this.\u015b = true;
        this.\u0147 = 1.13;
        this.\u013e = true;
        this.\u0149 = 1.05;
        this.\u013f = true;
        this.\u0145 = 3.0;
        this.\u014e = true;
        this.\u014d = Material.LEATHER_CHESTPLATE;
        this.\u0152 = "§7Kostium §6pirata";
        this.\u0140 = "§7Kostium §6pirata";
        this.\u0155 = new ArrayList<String>(List.of("§8Unikatowa wersja!"));
        this.\u0141 = 0;
        this.\u014f = true;
        this.\u0159 = new ArrayList<String>(List.of("HIDE_ATTRIBUTES", "HIDE_UNBREAKABLE"));
        this.\u0154 = Color.fromRGB(101, 67, 33);
        this.\u0150 = "§7Zbroja §6Pirata";
        this.\u0146 = new ArrayList<String>(List.of("§7", "§e§lKliknij§r §7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 §fzbroj\u0119§7!"));
        this.\u0143 = Color.fromRGB(101, 67, 33);
        this.\u0144 = Color.fromRGB(101, 67, 33);
        this.\u014c = Color.fromRGB(101, 67, 33);
        this.\u0157 = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2E1MTMzYzFlNDAwODQyNWFkYjE0NTBlYjhmNmU4YjZhNGRiNDY1OTI1OWRmMjNlYWQ3ODc0MjU2ZjhjYmM0NyJ9fX0=";
        this.\u0148 = true;
        this.\u015d = new ArrayList<String>(List.of("HIDE_ATTRIBUTES", "HIDE_UNBREAKABLE"));
        this.\u0158 = Sound.ITEM_ARMOR_EQUIP_LEATHER;
        this.\u0142 = 1.0f;
        this.\u0151 = 1.0f;
        this.\u0153 = "§7Za\u0142o\u017cono kostium §6Pirata§7!";
        this.\u014b = "§7Zdj\u0119to kostium §6Pirata§7!";
    }
    
    private String O(String n) {
        if (n == null) {
            return null;
        }
        n = this.N(n);
        return ChatColor.translateAlternateColorCodes('&', n);
    }
    
    private String N(final String s) {
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
    
    private Color M(final String s) {
        try {
            final String[] split = s.split(",");
            if (split.length == 3) {
                return Color.fromRGB(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()), Integer.parseInt(split[2].trim()));
            }
        }
        catch (final Exception ex) {}
        return Color.fromRGB(101, 67, 33);
    }
    
    public void apply(final Player player) {
        this.takeArmorSnapshot(player);
        final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
        final ItemStack customHead = this.createCustomHead(this.\u0157);
        final ItemStack coloredArmor = this.createColoredArmor(Material.LEATHER_CHESTPLATE, this.\u0143);
        final ItemStack coloredArmor2 = this.createColoredArmor(Material.LEATHER_LEGGINGS, this.\u0144);
        final ItemStack coloredArmor3 = this.createColoredArmor(Material.LEATHER_BOOTS, this.\u014c);
        if (playerArmorSnapshot != null) {
            if (playerArmorSnapshot.CostumesItemsListener3() != null) {
                this.CostumesItemsListener5(playerArmorSnapshot.CostumesItemsListener3(), customHead);
            }
            if (playerArmorSnapshot.CostumesItemsListener5() != null) {
                this.CostumesItemsListener5(playerArmorSnapshot.CostumesItemsListener5(), coloredArmor);
            }
            if (playerArmorSnapshot.CostumesItemsListener2() != null) {
                this.CostumesItemsListener5(playerArmorSnapshot.CostumesItemsListener2(), coloredArmor2);
            }
            if (playerArmorSnapshot.CostumesItemsListener1() != null) {
                this.CostumesItemsListener5(playerArmorSnapshot.CostumesItemsListener1(), coloredArmor3);
            }
        }
        this.CostumesItemsListener5(customHead, "helmet");
        this.CostumesItemsListener5(coloredArmor, "chestplate");
        this.CostumesItemsListener5(coloredArmor2, "leggings");
        this.CostumesItemsListener5(coloredArmor3, "boots");
        player.getInventory().setHelmet(customHead);
        if (playerArmorSnapshot == null || !playerArmorSnapshot.CostumesItemsListener4()) {
            player.getInventory().setChestplate(coloredArmor);
        }
        player.getInventory().setLeggings(coloredArmor2);
        player.getInventory().setBoots(coloredArmor3);
        if (this.\u0158 != null) {
            player.playSound(player.getLocation(), this.\u0158, this.\u0142, this.\u0151);
        }
        this.applyEffects(player);
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
    
    private void CostumesItemsListener5(final ItemStack itemStack, final String s) {
        if (itemStack == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return;
        }
        itemMeta.setDisplayName(this.\u0150);
        itemMeta.setLore((List)new ArrayList(this.\u0146));
        itemMeta.setUnbreakable(this.\u0148);
        for (final String s2 : this.\u015d) {
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
    
    private void CostumesItemsListener5(final ItemStack itemStack, final ItemStack itemStack2) {
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
        CostumesItemsListener6.playerArmorMap.remove(player.getUniqueId());
    }
    
    public void update() {
    }
    
    public ItemStack getCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u014d);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u0152);
            itemMeta.setLore((List)new ArrayList(this.\u0155));
            if (this.\u0141 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u0141));
            }
            itemMeta.setUnbreakable(this.\u014f);
            for (final String s : this.\u0159) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u0154);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public ItemStack getPreviewCostumeItem() {
        final ItemStack itemStack = new ItemStack(this.\u014d);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(this.\u0140);
            itemMeta.setLore((List)new ArrayList(this.\u0155));
            if (this.\u0141 > 0) {
                itemMeta.setCustomModelData(Integer.valueOf(this.\u0141));
            }
            itemMeta.setUnbreakable(this.\u014f);
            for (final String s : this.\u0159) {
                try {
                    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.valueOf(s) });
                }
                catch (final IllegalArgumentException ex) {}
            }
            if (itemMeta instanceof final LeatherArmorMeta leatherArmorMeta) {
                leatherArmorMeta.setColor(this.\u0154);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public void showOriginalArmor(final Player player) {
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        final I i = CostumesItemsListener6.playerArmorMap.get(player.getUniqueId());
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
        CostumesItemsListener6.\u015c.put(player.getUniqueId(), true);
    }
    
    public void removeEffects(final Player player) {
        CostumesItemsListener6.\u015c.remove(player.getUniqueId());
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!this.\u015b) {
            return;
        }
        if (entityDamageByEntityEvent.getDamager() instanceof Player && entityDamageByEntityEvent.getEntity() instanceof Player && CostumesItemsListener6.\u015c.containsKey(((Player)entityDamageByEntityEvent.getDamager()).getUniqueId())) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() * this.\u0147);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerTakeDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!this.\u013e) {
            return;
        }
        if (entityDamageByEntityEvent.getEntity() instanceof Player && CostumesItemsListener6.\u015c.containsKey(((Player)entityDamageByEntityEvent.getEntity()).getUniqueId())) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() * this.\u0149);
        }
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerKill(final PlayerDeathEvent playerDeathEvent) {
        if (!this.\u013f) {
            return;
        }
        final Player entity = playerDeathEvent.getEntity();
        final Player killer = entity.getKiller();
        if (killer != null && CostumesItemsListener6.\u015c.containsKey(killer.getUniqueId()) && this.\u014e && Main.getInstance().getServer().getPluginManager().getPlugin("Vault") != null) {
            try {
                final Economy economy = Main.getInstance().getEconomy();
                if (economy != null) {
                    final double d = economy.getBalance((OfflinePlayer)entity) * (this.\u0145 / 100.0);
                    if (d > 0.0) {
                        economy.withdrawPlayer((OfflinePlayer)entity, d);
                        economy.depositPlayer((OfflinePlayer)killer, d);
                        killer.sendMessage(this.O("&7Ukrad\u0142e\u015b &e" + String.format("%.2f", d) + "$ &7graczowi &f" + entity.getName() + "&7!"));
                    }
                }
            }
            catch (final Exception ex) {}
        }
    }
    
    public String getHelmetTexture() {
        return this.\u0157;
    }
    
    public Color getChestplateColor() {
        return this.\u0143;
    }
    
    public Color getLeggingsColor() {
        return this.\u0144;
    }
    
    public Color getBootsColor() {
        return this.\u014c;
    }
    
    static {
        \u015c = new HashMap<UUID, Boolean>();
        CostumesItemsListener6.\u014a = false;
    }
}
