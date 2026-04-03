// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

import java.util.List;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.Sound;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffect;
import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import java.util.HashMap;
import java.util.UUID;
import java.util.Map;
import org.bukkit.scheduler.BukkitTask;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.event.Listener;

public class CostumesListener6 implements Listener
{
    private final Main CostumesListener5;
    private BukkitTask CostumesCostumeService2;
    private final Map<UUID, Long> CostumesCostumeService3;
    private static final long M = 500L;
    private boolean CostumesCostumeService5;
    private boolean CostumesListener1;
    private int CostumesListener3;
    private boolean CostumesCostumeService1;
    private int CostumesCostumeService6;
    private boolean O;
    private double CostumesCostumeService4;
    private boolean CostumesListener4;
    private int N;
    private int Q;
    private boolean P;
    private boolean CostumesListener6;
    private boolean CostumesListener2;
    
    public CostumesListener6(final Main h) {
        this.CostumesCostumeService3 = new HashMap<UUID, Long>();
        this.CostumesListener5 = h;
        this.CostumesListener1();
        if (!this.CostumesCostumeService5) {
            return;
        }
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)h);
        this.CostumesListener2();
    }
    
    private void CostumesListener1() {
        this.CostumesCostumeService5 = this.CostumesListener5.getConfig().getBoolean("costumes.enchanted_books.enabled", true);
        this.CostumesListener1 = this.CostumesListener5.getConfig().getBoolean("costumes.enchanted_books.debug", false);
        this.CostumesListener3 = this.CostumesListener5.getConfig().getInt("costumes.enchanted_books.check_interval", 60);
        this.CostumesCostumeService1 = this.CostumesListener5.getConfig().getBoolean("costumes.enchanted_books.enchantments.niepodpalenie.enabled", true);
        this.CostumesCostumeService6 = this.CostumesListener5.getConfig().getInt("costumes.enchanted_books.enchantments.niepodpalenie.effect_duration", 100);
        this.O = this.CostumesListener5.getConfig().getBoolean("costumes.enchanted_books.enchantments.wytrzymalosc.enabled", true);
        this.CostumesCostumeService4 = this.CostumesListener5.getConfig().getDouble("costumes.enchanted_books.enchantments.wytrzymalosc.reduction_chance", 0.5);
        this.CostumesListener4 = this.CostumesListener5.getConfig().getBoolean("costumes.enchanted_books.enchantments.regeneracja.enabled", true);
        this.N = this.CostumesListener5.getConfig().getInt("costumes.enchanted_books.enchantments.regeneracja.effect_duration", 160);
        this.Q = this.CostumesListener5.getConfig().getInt("costumes.enchanted_books.enchantments.regeneracja.effect_level", 1);
        this.P = this.CostumesListener5.getConfig().getBoolean("costumes.enchanted_books.enchantments.unik.enabled", true);
        this.CostumesListener6 = this.CostumesListener5.getConfig().getBoolean("costumes.enchanted_books.enchantments.unik.message_enabled", true);
        this.CostumesListener2 = this.CostumesListener5.getConfig().getBoolean("costumes.enchanted_books.enchantments.ulaskawienie.enabled", true);
    }
    
    public void reloadConfig() {
        this.CostumesListener1();
        this.CostumesListener2();
    }
    
    private void CostumesListener2() {
        if (this.CostumesCostumeService2 != null) {
            this.CostumesCostumeService2.cancel();
        }
        this.CostumesCostumeService2 = Bukkit.getScheduler().runTaskTimer((Plugin)this.CostumesListener5, () -> {
            Bukkit.getOnlinePlayers().iterator();
            final Iterator iterator;
            while (iterator.hasNext()) {
                final Player player = iterator.next();
                if (pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.CostumesListener4(player)) {
                    this.checkAndApplyEnchantmentEffects(player);
                }
            }
        }, (long)this.CostumesListener3, (long)this.CostumesListener3);
    }
    
    public void cleanup() {
        if (this.CostumesCostumeService2 != null) {
            this.CostumesCostumeService2.cancel();
            this.CostumesCostumeService2 = null;
            if (this.CostumesListener1) {}
        }
    }
    
    public void checkAndApplyEnchantmentEffects(final Player player) {
        if (!this.CostumesCostumeService5) {
            return;
        }
        if (!pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.CostumesListener4(player)) {
            return;
        }
        final UUID uniqueId = player.getUniqueId();
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.CostumesCostumeService3.containsKey(uniqueId) && currentTimeMillis - this.CostumesCostumeService3.get(uniqueId) < 500L) {
            return;
        }
        this.CostumesCostumeService3.put(uniqueId, currentTimeMillis);
        PotionEffect potionEffect = null;
        for (final PotionEffect potionEffect2 : player.getActivePotionEffects()) {
            if (potionEffect2.getType().equals((Object)PotionEffectType.FAST_DIGGING) && potionEffect2.getDuration() == Integer.MAX_VALUE) {
                potionEffect = potionEffect2;
                break;
            }
        }
        this.CostumesListener1(player, this.CostumesCostumeService2(player, "helmet"), "helmet");
        this.CostumesListener1(player, this.CostumesCostumeService2(player, "chestplate"), "chestplate");
        this.CostumesListener1(player, this.CostumesCostumeService2(player, "leggings"), "leggings");
        this.CostumesListener1(player, this.CostumesCostumeService2(player, "boots"), "boots");
        if (potionEffect != null) {
            boolean b = false;
            for (final PotionEffect potionEffect3 : player.getActivePotionEffects()) {
                if (potionEffect3.getType().equals((Object)PotionEffectType.FAST_DIGGING) && potionEffect3.getDuration() == Integer.MAX_VALUE) {
                    b = true;
                    break;
                }
            }
            if (!b) {
                player.addPotionEffect(potionEffect);
                if (this.CostumesListener1) {}
            }
        }
    }
    
    private void CostumesListener1(final Player player, final ItemStack itemStack, final String s) {
        if (itemStack == null || !itemStack.hasItemMeta()) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (this.CostumesCostumeService1) {
            this.CostumesListener1(player, itemMeta);
        }
    }
    
    private void CostumesListener1(final Player player, final ItemMeta itemMeta) {
        if (itemMeta.getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_niepodpalenie"), PersistentDataType.DOUBLE)) {
            player.setFireTicks(0);
            if (!player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, this.CostumesCostumeService6, 0, true, false, true));
                if (this.CostumesListener1) {}
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onItemDamage(final PlayerItemDamageEvent playerItemDamageEvent) {
        if (!this.CostumesCostumeService5 || !this.O) {
            return;
        }
        final Player player = playerItemDamageEvent.getPlayer();
        if (!pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.CostumesListener4(player)) {
            return;
        }
        final ItemStack item = playerItemDamageEvent.getItem();
        if (!this.CostumesListener4(item)) {
            return;
        }
        if (this.CostumesListener3(player)) {
            final CostumesCostumeService4 playerArmorSnapshot = pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService5.getPlayerArmorSnapshot(player.getUniqueId());
            if (playerArmorSnapshot != null) {
                if (this.CostumesCostumeService2(item)) {
                    this.CostumesListener1(playerArmorSnapshot.CostumesCostumeService1(), playerItemDamageEvent.getDamage());
                    playerArmorSnapshot.CostumesListener1(playerArmorSnapshot.CostumesCostumeService1());
                }
                else if (this.CostumesListener3(item)) {
                    this.CostumesListener1(playerArmorSnapshot.CostumesCostumeService2(), playerItemDamageEvent.getDamage());
                    playerArmorSnapshot.CostumesListener3(playerArmorSnapshot.CostumesCostumeService2());
                }
                else if (this.CostumesListener1(item)) {
                    this.CostumesListener1(playerArmorSnapshot.CostumesListener2(), playerItemDamageEvent.getDamage());
                    playerArmorSnapshot.CostumesListener2(playerArmorSnapshot.CostumesListener2());
                }
                else if (this.CostumesListener2(item)) {
                    this.CostumesListener1(playerArmorSnapshot.CostumesListener1(), playerItemDamageEvent.getDamage());
                    playerArmorSnapshot.CostumesCostumeService1(playerArmorSnapshot.CostumesListener1());
                }
                playerItemDamageEvent.setCancelled(true);
                return;
            }
        }
        final ItemStack itemStack = item;
        if (itemStack != null && itemStack.hasItemMeta() && itemStack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_wytrzymalosc"), PersistentDataType.DOUBLE) && Math.random() < this.CostumesCostumeService4) {
            playerItemDamageEvent.setCancelled(true);
            if (this.CostumesListener1) {}
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerDamage(final EntityDamageEvent entityDamageEvent) {
        if (!this.CostumesCostumeService5) {
            return;
        }
        if (!(entityDamageEvent.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityDamageEvent.getEntity();
        if (!pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.CostumesListener4(player)) {
            return;
        }
        final ItemStack chestplate = this.CostumesCostumeService2(player, "chestplate");
        final ItemStack leggings = this.CostumesCostumeService2(player, "leggings");
        if (this.CostumesListener3(player)) {
            this.CostumesListener2(entityDamageEvent, player);
        }
        if (this.CostumesListener4 && chestplate != null && chestplate.hasItemMeta()) {
            final ItemMeta itemMeta = chestplate.getItemMeta();
            final NamespacedKey namespacedKey = new NamespacedKey("stormitemy", "enchant_regeneracja");
            if (itemMeta.getPersistentDataContainer().has(namespacedKey, PersistentDataType.DOUBLE) && Math.random() < (double)itemMeta.getPersistentDataContainer().get(namespacedKey, PersistentDataType.DOUBLE)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, this.N, this.Q, true, true, true));
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8f, 1.5f);
                if (this.CostumesListener1) {}
            }
        }
        if (this.P && entityDamageEvent instanceof EntityDamageByEntityEvent && leggings != null && leggings.hasItemMeta()) {
            final ItemMeta itemMeta2 = leggings.getItemMeta();
            final NamespacedKey namespacedKey2 = new NamespacedKey("stormitemy", "enchant_unik");
            if (itemMeta2.getPersistentDataContainer().has(namespacedKey2, PersistentDataType.DOUBLE) && Math.random() < (double)itemMeta2.getPersistentDataContainer().get(namespacedKey2, PersistentDataType.DOUBLE)) {
                entityDamageEvent.setCancelled(true);
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.7f, 1.2f);
                if (this.CostumesListener6) {
                    player.sendTitle("", "§bUnikn\u0105\u0142e\u015b ciosu!", 10, 30, 10);
                }
                if (this.CostumesListener1) {}
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(final PlayerDeathEvent playerDeathEvent) {
        if (!this.CostumesCostumeService5 || !this.CostumesListener2) {
            return;
        }
        final Player entity = playerDeathEvent.getEntity();
        if (!pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.CostumesListener4(entity)) {
            return;
        }
        final ItemStack helmet = this.CostumesCostumeService2(entity, "helmet");
        final ItemStack chestplate = this.CostumesCostumeService2(entity, "chestplate");
        final ItemStack leggings = this.CostumesCostumeService2(entity, "leggings");
        final ItemStack boots = this.CostumesCostumeService2(entity, "boots");
        if (this.CostumesCostumeService1(helmet) || this.CostumesCostumeService1(chestplate) || this.CostumesCostumeService1(leggings) || this.CostumesCostumeService1(boots)) {
            entity.setMetadata("ulaskawienie_activated", (MetadataValue)new FixedMetadataValue((Plugin)this.CostumesListener5, (Object)true));
            if (this.CostumesListener1) {}
        }
    }
    
    private boolean CostumesCostumeService1(final ItemStack itemStack) {
        return itemStack != null && itemStack.hasItemMeta() && itemStack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_ulaskawienie"), PersistentDataType.DOUBLE);
    }
    
    private boolean CostumesCostumeService2(final ItemStack itemStack) {
        return itemStack != null && (itemStack.getType().name().endsWith("_HELMET") || itemStack.getType().name().equals("PLAYER_HEAD"));
    }
    
    private boolean CostumesListener3(final ItemStack itemStack) {
        return itemStack != null && itemStack.getType().name().endsWith("_CHESTPLATE");
    }
    
    private boolean CostumesListener1(final ItemStack itemStack) {
        return itemStack != null && itemStack.getType().name().endsWith("_LEGGINGS");
    }
    
    private boolean CostumesListener2(final ItemStack itemStack) {
        return itemStack != null && itemStack.getType().name().endsWith("_BOOTS");
    }
    
    private boolean CostumesListener4(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if ((itemStack.getType().name().contains("LEATHER_") || itemStack.getType() == Material.PLAYER_HEAD) && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            final String lowerCase = itemStack.getItemMeta().getDisplayName().toLowerCase();
            return lowerCase.contains("kostium") || lowerCase.contains("costume") || lowerCase.contains("zbroja");
        }
        return false;
    }

    private boolean CostumesListener3(final Player player) {
        return player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory");
    }

    private ItemStack CostumesCostumeService2(final Player player, final String s) {
        ItemStack itemStack = null;
        if ("helmet".equals(s)) {
            itemStack = player.getInventory().getHelmet();
        }
        else if ("chestplate".equals(s)) {
            itemStack = player.getInventory().getChestplate();
        }
        else if ("leggings".equals(s)) {
            itemStack = player.getInventory().getLeggings();
        }
        else if ("boots".equals(s)) {
            itemStack = player.getInventory().getBoots();
        }
        if (!this.CostumesListener3(player) || itemStack == null || !this.CostumesListener4(itemStack)) {
            return itemStack;
        }
        final CostumesCostumeService4 playerArmorSnapshot = pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService5.getPlayerArmorSnapshot(player.getUniqueId());
        if (playerArmorSnapshot == null) {
            return itemStack;
        }
        if ("helmet".equals(s)) {
            return playerArmorSnapshot.CostumesCostumeService1();
        }
        if ("chestplate".equals(s)) {
            return playerArmorSnapshot.CostumesCostumeService2();
        }
        if ("leggings".equals(s)) {
            return playerArmorSnapshot.CostumesListener2();
        }
        if ("boots".equals(s)) {
            return playerArmorSnapshot.CostumesListener1();
        }
        return itemStack;
    }

    private void CostumesListener1(final ItemStack itemStack, final int n) {
        if (itemStack == null || n <= 0 || !itemStack.hasItemMeta()) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (!(itemMeta instanceof Damageable)) {
            return;
        }
        final Damageable damageable = (Damageable)itemMeta;
        damageable.setDamage(Math.max(0, damageable.getDamage() + n));
        itemStack.setItemMeta(itemMeta);
    }

    private void CostumesListener2(final EntityDamageEvent entityDamageEvent, final Player player) {
        final CostumesCostumeService4 playerArmorSnapshot = pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService5.getPlayerArmorSnapshot(player.getUniqueId());
        if (playerArmorSnapshot == null) {
            return;
        }
        final int n = this.CostumesCostumeService1(player.getInventory().getHelmet()) + this.CostumesCostumeService1(player.getInventory().getChestplate()) + this.CostumesCostumeService1(player.getInventory().getLeggings()) + this.CostumesCostumeService1(player.getInventory().getBoots());
        final int n2 = this.CostumesCostumeService1(playerArmorSnapshot.CostumesCostumeService1()) + this.CostumesCostumeService1(playerArmorSnapshot.CostumesCostumeService2()) + this.CostumesCostumeService1(playerArmorSnapshot.CostumesListener2()) + this.CostumesCostumeService1(playerArmorSnapshot.CostumesListener1());
        if (n2 <= n) {
            return;
        }
        final double min = Math.min(20, n) / 25.0;
        final double min2 = Math.min(20, n2) / 25.0;
        final double damage = entityDamageEvent.getDamage();
        final double max = Math.max(0.0, 1.0 - min);
        final double max2 = Math.max(0.0, 1.0 - min2);
        if (max <= 0.0) {
            entityDamageEvent.setDamage(0.0);
            return;
        }
        entityDamageEvent.setDamage(Math.max(0.0, damage * (max2 / max)));
    }

    private int CostumesCostumeService1(final ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }
        final String name = itemStack.getType().name();
        if (name.equals("NETHERITE_HELMET")) return 3;
        if (name.equals("NETHERITE_CHESTPLATE")) return 8;
        if (name.equals("NETHERITE_LEGGINGS")) return 6;
        if (name.equals("NETHERITE_BOOTS")) return 3;
        if (name.equals("DIAMOND_HELMET")) return 3;
        if (name.equals("DIAMOND_CHESTPLATE")) return 8;
        if (name.equals("DIAMOND_LEGGINGS")) return 6;
        if (name.equals("DIAMOND_BOOTS")) return 3;
        if (name.equals("IRON_HELMET")) return 2;
        if (name.equals("IRON_CHESTPLATE")) return 6;
        if (name.equals("IRON_LEGGINGS")) return 5;
        if (name.equals("IRON_BOOTS")) return 2;
        if (name.equals("CHAINMAIL_HELMET")) return 2;
        if (name.equals("CHAINMAIL_CHESTPLATE")) return 5;
        if (name.equals("CHAINMAIL_LEGGINGS")) return 4;
        if (name.equals("CHAINMAIL_BOOTS")) return 1;
        if (name.equals("GOLDEN_HELMET")) return 2;
        if (name.equals("GOLDEN_CHESTPLATE")) return 5;
        if (name.equals("GOLDEN_LEGGINGS")) return 3;
        if (name.equals("GOLDEN_BOOTS")) return 1;
        if (name.equals("LEATHER_HELMET")) return 1;
        if (name.equals("LEATHER_CHESTPLATE")) return 3;
        if (name.equals("LEATHER_LEGGINGS")) return 2;
        if (name.equals("LEATHER_BOOTS")) return 1;
        return 0;
    }
    
    public void copyEnchantsToLore(final ItemStack itemStack, final ItemStack itemStack2) {
        if (itemStack == null || itemStack2 == null || !itemStack.hasItemMeta()) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        final ItemMeta itemMeta2 = itemStack2.getItemMeta();
        if (itemMeta2 == null) {
            return;
        }
        final ArrayList lore = new ArrayList();
        boolean b = false;
        if (itemMeta.hasLore()) {
            final List lore2 = itemMeta.getLore();
            if (this.CostumesListener1) {
                for (int i = 0; i < lore2.size(); ++i) {}
                for (NamespacedKey namespacedKey : itemMeta.getPersistentDataContainer().getKeys()) {}
            }
            for (final String s : lore2) {
                boolean b2 = false;
                final String replaceAll = s.toLowerCase().replaceAll("§[0-9a-fk-or]", "");
                if (replaceAll.contains("niepodpalenie") && itemMeta.getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_niepodpalenie"), PersistentDataType.DOUBLE)) {
                    lore.add(s);
                    b = true;
                    b2 = true;
                    if (this.CostumesListener1) {}
                }
                if ((replaceAll.contains("wytrzyma\u0142o\u015b\u0107") || replaceAll.contains("wytrzymalosc")) && itemMeta.getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_wytrzymalosc"), PersistentDataType.DOUBLE)) {
                    lore.add(s);
                    b = true;
                    b2 = true;
                    if (this.CostumesListener1) {}
                }
                if (replaceAll.contains("regeneracja")) {
                    if (itemMeta.getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_regeneracja"), PersistentDataType.DOUBLE)) {
                        lore.add(s);
                        b = true;
                        b2 = true;
                        if (this.CostumesListener1) {}
                    }
                    else if (this.CostumesListener1) {}
                }
                if (replaceAll.contains("unik") && itemMeta.getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_unik"), PersistentDataType.DOUBLE)) {
                    lore.add(s);
                    b = true;
                    b2 = true;
                    if (this.CostumesListener1) {}
                }
                if ((replaceAll.contains("u\u0142askawienie") || replaceAll.contains("ulaskawienie")) && itemMeta.getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_ulaskawienie"), PersistentDataType.DOUBLE)) {
                    lore.add(s);
                    b = true;
                    b2 = true;
                    if (this.CostumesListener1) {}
                }
                if (!b2 || this.CostumesListener1) {}
            }
        }
        else if (this.CostumesListener1) {}
        lore.add("§7");
        lore.add("§e§lKliknij§r §7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 §fzbroj\u0119§7!");
        itemMeta2.setLore((List)lore);
        itemStack2.setItemMeta(itemMeta2);
        if (!this.CostumesListener1 || b) {}
    }
    
    private String CostumesListener1(final double n) {
        final int n2 = (int)n;
        if (n2 <= 0) {
            return "CostumesCostumeService4";
        }
        switch (n2) {
            case 1: {
                return "CostumesCostumeService4";
            }
            case 2: {
                return "II";
            }
            case 3: {
                return "III";
            }
            case 4: {
                return "IV";
            }
            case 5: {
                return "V";
            }
            case 6: {
                return "VI";
            }
            case 7: {
                return "VII";
            }
            case 8: {
                return "VIII";
            }
            case 9: {
                return "IX";
            }
            case 10: {
                return "X";
            }
            default: {
                return (n2 > 10) ? "X+" : "CostumesCostumeService4";
            }
        }
    }
}
