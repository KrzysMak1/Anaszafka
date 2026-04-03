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

public class K implements Listener
{
    private final Main H;
    private BukkitTask E;
    private final Map<UUID, Long> G;
    private static final long M = 500L;
    private boolean J;
    private boolean A;
    private int D;
    private boolean C;
    private int L;
    private boolean O;
    private double I;
    private boolean F;
    private int N;
    private int Q;
    private boolean P;
    private boolean K;
    private boolean B;
    
    public K(final Main h) {
        this.G = new HashMap<UUID, Long>();
        this.H = h;
        this.A();
        if (!this.J) {
            return;
        }
        Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)h);
        this.B();
    }
    
    private void A() {
        this.J = this.H.getConfig().getBoolean("costumes.enchanted_books.enabled", true);
        this.A = this.H.getConfig().getBoolean("costumes.enchanted_books.debug", false);
        this.D = this.H.getConfig().getInt("costumes.enchanted_books.check_interval", 60);
        this.C = this.H.getConfig().getBoolean("costumes.enchanted_books.enchantments.niepodpalenie.enabled", true);
        this.L = this.H.getConfig().getInt("costumes.enchanted_books.enchantments.niepodpalenie.effect_duration", 100);
        this.O = this.H.getConfig().getBoolean("costumes.enchanted_books.enchantments.wytrzymalosc.enabled", true);
        this.I = this.H.getConfig().getDouble("costumes.enchanted_books.enchantments.wytrzymalosc.reduction_chance", 0.5);
        this.F = this.H.getConfig().getBoolean("costumes.enchanted_books.enchantments.regeneracja.enabled", true);
        this.N = this.H.getConfig().getInt("costumes.enchanted_books.enchantments.regeneracja.effect_duration", 160);
        this.Q = this.H.getConfig().getInt("costumes.enchanted_books.enchantments.regeneracja.effect_level", 1);
        this.P = this.H.getConfig().getBoolean("costumes.enchanted_books.enchantments.unik.enabled", true);
        this.K = this.H.getConfig().getBoolean("costumes.enchanted_books.enchantments.unik.message_enabled", true);
        this.B = this.H.getConfig().getBoolean("costumes.enchanted_books.enchantments.ulaskawienie.enabled", true);
    }
    
    public void reloadConfig() {
        this.A();
        this.B();
    }
    
    private void B() {
        if (this.E != null) {
            this.E.cancel();
        }
        this.E = Bukkit.getScheduler().runTaskTimer((Plugin)this.H, () -> {
            Bukkit.getOnlinePlayers().iterator();
            final Iterator iterator;
            while (iterator.hasNext()) {
                final Player player = iterator.next();
                if (pl.ziffy.STORMSZAFKA.costumes.L.F(player)) {
                    this.checkAndApplyEnchantmentEffects(player);
                }
            }
        }, (long)this.D, (long)this.D);
    }
    
    public void cleanup() {
        if (this.E != null) {
            this.E.cancel();
            this.E = null;
            if (this.A) {}
        }
    }
    
    public void checkAndApplyEnchantmentEffects(final Player player) {
        if (!this.J) {
            return;
        }
        if (!pl.ziffy.STORMSZAFKA.costumes.L.F(player)) {
            return;
        }
        final UUID uniqueId = player.getUniqueId();
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.G.containsKey(uniqueId) && currentTimeMillis - this.G.get(uniqueId) < 500L) {
            return;
        }
        this.G.put(uniqueId, currentTimeMillis);
        PotionEffect potionEffect = null;
        for (final PotionEffect potionEffect2 : player.getActivePotionEffects()) {
            if (potionEffect2.getType().equals((Object)PotionEffectType.FAST_DIGGING) && potionEffect2.getDuration() == Integer.MAX_VALUE) {
                potionEffect = potionEffect2;
                break;
            }
        }
        final I playerArmorSnapshot = pl.ziffy.STORMSZAFKA.costumes.J.getPlayerArmorSnapshot(uniqueId);
        if (playerArmorSnapshot == null) {
            return;
        }
        this.A(player, playerArmorSnapshot.C(), "helmet");
        this.A(player, playerArmorSnapshot.E(), "chestplate");
        this.A(player, playerArmorSnapshot.B(), "leggings");
        this.A(player, playerArmorSnapshot.A(), "boots");
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
                if (this.A) {}
            }
        }
    }
    
    private void A(final Player player, final ItemStack itemStack, final String s) {
        if (itemStack == null || !itemStack.hasItemMeta()) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (this.C) {
            this.A(player, itemMeta);
        }
    }
    
    private void A(final Player player, final ItemMeta itemMeta) {
        if (itemMeta.getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_niepodpalenie"), PersistentDataType.DOUBLE)) {
            player.setFireTicks(0);
            if (!player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, this.L, 0, true, false, true));
                if (this.A) {}
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onItemDamage(final PlayerItemDamageEvent playerItemDamageEvent) {
        if (!this.J || !this.O) {
            return;
        }
        final Player player = playerItemDamageEvent.getPlayer();
        if (!pl.ziffy.STORMSZAFKA.costumes.L.F(player)) {
            return;
        }
        final I playerArmorSnapshot = pl.ziffy.STORMSZAFKA.costumes.J.getPlayerArmorSnapshot(player.getUniqueId());
        if (playerArmorSnapshot == null) {
            return;
        }
        ItemStack itemStack = null;
        final ItemStack item = playerItemDamageEvent.getItem();
        if (!this.F(item)) {
            return;
        }
        if (this.E(item)) {
            itemStack = playerArmorSnapshot.C();
        }
        else if (this.D(item)) {
            itemStack = playerArmorSnapshot.E();
        }
        else if (this.A(item)) {
            itemStack = playerArmorSnapshot.B();
        }
        else if (this.B(item)) {
            itemStack = playerArmorSnapshot.A();
        }
        if (itemStack != null && itemStack.hasItemMeta() && itemStack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_wytrzymalosc"), PersistentDataType.DOUBLE) && Math.random() < this.I) {
            playerItemDamageEvent.setCancelled(true);
            if (this.A) {}
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerDamage(final EntityDamageEvent entityDamageEvent) {
        if (!this.J) {
            return;
        }
        if (!(entityDamageEvent.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityDamageEvent.getEntity();
        if (!pl.ziffy.STORMSZAFKA.costumes.L.F(player)) {
            return;
        }
        final I playerArmorSnapshot = pl.ziffy.STORMSZAFKA.costumes.J.getPlayerArmorSnapshot(player.getUniqueId());
        if (playerArmorSnapshot == null) {
            return;
        }
        if (this.F && playerArmorSnapshot.E() != null && playerArmorSnapshot.E().hasItemMeta()) {
            final ItemMeta itemMeta = playerArmorSnapshot.E().getItemMeta();
            final NamespacedKey namespacedKey = new NamespacedKey("stormitemy", "enchant_regeneracja");
            if (itemMeta.getPersistentDataContainer().has(namespacedKey, PersistentDataType.DOUBLE) && Math.random() < (double)itemMeta.getPersistentDataContainer().get(namespacedKey, PersistentDataType.DOUBLE)) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, this.N, this.Q, true, true, true));
                player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8f, 1.5f);
                if (this.A) {}
            }
        }
        if (this.P && entityDamageEvent instanceof EntityDamageByEntityEvent && playerArmorSnapshot.B() != null && playerArmorSnapshot.B().hasItemMeta()) {
            final ItemMeta itemMeta2 = playerArmorSnapshot.B().getItemMeta();
            final NamespacedKey namespacedKey2 = new NamespacedKey("stormitemy", "enchant_unik");
            if (itemMeta2.getPersistentDataContainer().has(namespacedKey2, PersistentDataType.DOUBLE) && Math.random() < (double)itemMeta2.getPersistentDataContainer().get(namespacedKey2, PersistentDataType.DOUBLE)) {
                entityDamageEvent.setCancelled(true);
                player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.7f, 1.2f);
                if (this.K) {
                    player.sendTitle("", "§bUnikn\u0105\u0142e\u015b ciosu!", 10, 30, 10);
                }
                if (this.A) {}
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(final PlayerDeathEvent playerDeathEvent) {
        if (!this.J || !this.B) {
            return;
        }
        final Player entity = playerDeathEvent.getEntity();
        if (!pl.ziffy.STORMSZAFKA.costumes.L.F(entity)) {
            return;
        }
        final I playerArmorSnapshot = pl.ziffy.STORMSZAFKA.costumes.J.getPlayerArmorSnapshot(entity.getUniqueId());
        if (playerArmorSnapshot == null) {
            return;
        }
        if (this.C(playerArmorSnapshot.C()) || this.C(playerArmorSnapshot.E()) || this.C(playerArmorSnapshot.B()) || this.C(playerArmorSnapshot.A())) {
            entity.setMetadata("ulaskawienie_activated", (MetadataValue)new FixedMetadataValue((Plugin)this.H, (Object)true));
            if (this.A) {}
        }
    }
    
    private boolean C(final ItemStack itemStack) {
        return itemStack != null && itemStack.hasItemMeta() && itemStack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_ulaskawienie"), PersistentDataType.DOUBLE);
    }
    
    private boolean E(final ItemStack itemStack) {
        return itemStack != null && (itemStack.getType().name().endsWith("_HELMET") || itemStack.getType().name().equals("PLAYER_HEAD"));
    }
    
    private boolean D(final ItemStack itemStack) {
        return itemStack != null && itemStack.getType().name().endsWith("_CHESTPLATE");
    }
    
    private boolean A(final ItemStack itemStack) {
        return itemStack != null && itemStack.getType().name().endsWith("_LEGGINGS");
    }
    
    private boolean B(final ItemStack itemStack) {
        return itemStack != null && itemStack.getType().name().endsWith("_BOOTS");
    }
    
    private boolean F(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if ((itemStack.getType().name().contains("LEATHER_") || itemStack.getType() == Material.PLAYER_HEAD) && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            final String lowerCase = itemStack.getItemMeta().getDisplayName().toLowerCase();
            return lowerCase.contains("kostium") || lowerCase.contains("costume") || lowerCase.contains("zbroja");
        }
        return false;
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
            if (this.A) {
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
                    if (this.A) {}
                }
                if ((replaceAll.contains("wytrzyma\u0142o\u015b\u0107") || replaceAll.contains("wytrzymalosc")) && itemMeta.getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_wytrzymalosc"), PersistentDataType.DOUBLE)) {
                    lore.add(s);
                    b = true;
                    b2 = true;
                    if (this.A) {}
                }
                if (replaceAll.contains("regeneracja")) {
                    if (itemMeta.getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_regeneracja"), PersistentDataType.DOUBLE)) {
                        lore.add(s);
                        b = true;
                        b2 = true;
                        if (this.A) {}
                    }
                    else if (this.A) {}
                }
                if (replaceAll.contains("unik") && itemMeta.getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_unik"), PersistentDataType.DOUBLE)) {
                    lore.add(s);
                    b = true;
                    b2 = true;
                    if (this.A) {}
                }
                if ((replaceAll.contains("u\u0142askawienie") || replaceAll.contains("ulaskawienie")) && itemMeta.getPersistentDataContainer().has(new NamespacedKey("stormitemy", "enchant_ulaskawienie"), PersistentDataType.DOUBLE)) {
                    lore.add(s);
                    b = true;
                    b2 = true;
                    if (this.A) {}
                }
                if (!b2 || this.A) {}
            }
        }
        else if (this.A) {}
        lore.add("§7");
        lore.add("§e§lKliknij§r §7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 §fzbroj\u0119§7!");
        itemMeta2.setLore((List)lore);
        itemStack2.setItemMeta(itemMeta2);
        if (!this.A || b) {}
    }
    
    private String A(final double n) {
        final int n2 = (int)n;
        if (n2 <= 0) {
            return "I";
        }
        switch (n2) {
            case 1: {
                return "I";
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
                return (n2 > 10) ? "X+" : "I";
            }
        }
    }
}
