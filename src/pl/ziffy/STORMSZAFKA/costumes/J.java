// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

import java.util.HashMap;
import java.util.Iterator;
import org.bukkit.enchantments.Enchantment;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import java.util.UUID;
import java.util.Map;

public abstract class J implements C
{
    protected static final Map<UUID, I> playerArmorMap;
    protected static final Map<UUID, Long> doubleJumpCooldowns;
    protected final Plugin plugin;
    protected final String costumeType;
    protected final String displayName;
    
    public J(final String costumeType, final String displayName) {
        this.costumeType = costumeType;
        this.displayName = displayName;
        Object plugin = Bukkit.getPluginManager().getPlugin("STORMSZAFKA");
        if (plugin == null) {
            plugin = Bukkit.getPluginManager().getPlugin("STORMSZAFKA");
        }
        if (plugin == null) {
            plugin = Main.getInstance();
        }
        this.plugin = (Plugin)plugin;
    }
    
    @Override
    public String getType() {
        return this.costumeType;
    }
    
    @Override
    public String getDisplayName() {
        return this.displayName;
    }
    
    protected void takeArmorSnapshot(final Player player) {
        J.playerArmorMap.put(player.getUniqueId(), new I(player.getInventory().getHelmet(), player.getInventory().getChestplate(), player.getInventory().getLeggings(), player.getInventory().getBoots()));
    }
    
    protected void restoreArmorFromSnapshot(final Player player) {
        final I i = J.playerArmorMap.get(player.getUniqueId());
        if (i != null) {
            player.getInventory().setHelmet(i.C());
            player.getInventory().setChestplate(i.E());
            player.getInventory().setLeggings(i.B());
            player.getInventory().setBoots(i.A());
        }
    }
    
    public ItemStack createColoredArmor(final Material material, final Color color) {
        final ItemStack itemStack = new ItemStack(material);
        final LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        itemMeta.setColor(color);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_DYE });
        itemStack.setItemMeta((ItemMeta)itemMeta);
        return itemStack;
    }
    
    protected String formatColors(String a) {
        if (a == null) {
            return null;
        }
        a = this.A(a);
        return ChatColor.translateAlternateColorCodes('&', a);
    }
    
    private String A(final String s) {
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
    
    public static boolean hasCostume(final Player player) {
        return J.playerArmorMap.containsKey(player.getUniqueId());
    }
    
    public static I getPlayerArmorSnapshot(final UUID uuid) {
        return J.playerArmorMap.get(uuid);
    }
    
    public static void storeArmorSnapshot(final UUID uuid, final I i) {
        J.playerArmorMap.put(uuid, i);
    }
    
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
            itemStack2.setItemMeta(itemMeta2);
        }
    }
    
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
    
    static {
        playerArmorMap = new HashMap<UUID, I>();
        doubleJumpCooldowns = new HashMap<UUID, Long>();
    }
}
