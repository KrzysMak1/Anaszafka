// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import java.util.HashMap;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import java.util.UUID;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.event.Listener;

public class CostumesListener4 implements Listener
{
    private final Main CostumesCostumeService1;
    private final Map<UUID, BukkitTask> CostumesCostumeService2;
    private String CostumesListener3;
    private boolean CostumesListener1;
    private final Map<PotionEffectType, _A> CostumesListener2;
    
    public CostumesListener4(final Main c) {
        this.CostumesCostumeService2 = new HashMap<UUID, BukkitTask>();
        this.CostumesListener2 = new HashMap<PotionEffectType, _A>();
        this.CostumesCostumeService1 = c;
        this.CostumesListener3();
        if (this.CostumesListener1) {
            Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)c);
            this.CostumesListener1();
        }
    }
    
    private void CostumesListener3() {
        final ConfigurationSection configurationSection = this.CostumesCostumeService1.getConfig().getConfigurationSection("costumes.korona_anarchii");
        if (configurationSection == null) {
            this.CostumesListener1 = true;
            this.CostumesListener3 = "§6Korona ANARCHII";
            this.CostumesListener2();
            return;
        }
        this.CostumesListener1 = configurationSection.getBoolean("enabled", true);
        this.CostumesListener3 = configurationSection.getString("item_name", "§6Korona ANARCHII");
        final ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection("effects");
        if (configurationSection2 == null) {
            this.CostumesListener2();
            return;
        }
        this.CostumesListener1(configurationSection2, "speed", PotionEffectType.SPEED);
        this.CostumesListener1(configurationSection2, "fire_resistance", PotionEffectType.FIRE_RESISTANCE);
        this.CostumesListener1(configurationSection2, "strength", PotionEffectType.INCREASE_DAMAGE);
        this.CostumesListener1(configurationSection2, "resistance", PotionEffectType.DAMAGE_RESISTANCE);
        this.CostumesListener1(configurationSection2, "luck", PotionEffectType.LUCK);
    }
    
    public void reloadConfig() {
        this.CostumesListener2.clear();
        this.CostumesListener3();
    }
    
    private void CostumesListener1(final ConfigurationSection configurationSection, final String s, final PotionEffectType potionEffectType) {
        final ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection(s);
        if (configurationSection2 == null) {
            int n = 100;
            if (potionEffectType == PotionEffectType.SPEED || potionEffectType == PotionEffectType.FIRE_RESISTANCE) {
                n = 160;
            }
            this.CostumesListener2.put(potionEffectType, new _A(true, this.CostumesListener1(potionEffectType), n));
            return;
        }
        final boolean boolean1 = configurationSection2.getBoolean("enabled", true);
        final int int1 = configurationSection2.getInt("level", this.CostumesListener1(potionEffectType));
        int int2 = configurationSection2.getInt("duration", 100);
        if ((potionEffectType == PotionEffectType.SPEED || potionEffectType == PotionEffectType.FIRE_RESISTANCE) && !configurationSection2.contains("duration")) {
            int2 = 160;
        }
        this.CostumesListener2.put(potionEffectType, new _A(boolean1, int1, int2));
    }
    
    private int CostumesListener1(final PotionEffectType potionEffectType) {
        if (potionEffectType == PotionEffectType.SPEED) {
            return 1;
        }
        if (potionEffectType == PotionEffectType.INCREASE_DAMAGE) {
            return 1;
        }
        if (potionEffectType == PotionEffectType.DAMAGE_RESISTANCE) {
            return 2;
        }
        return 0;
    }
    
    private void CostumesListener2() {
        this.CostumesListener2.put(PotionEffectType.SPEED, new _A(true, 1, 160));
        this.CostumesListener2.put(PotionEffectType.FIRE_RESISTANCE, new _A(true, 0, 160));
        this.CostumesListener2.put(PotionEffectType.INCREASE_DAMAGE, new _A(true, 1, 100));
        this.CostumesListener2.put(PotionEffectType.DAMAGE_RESISTANCE, new _A(true, 2, 100));
        this.CostumesListener2.put(PotionEffectType.LUCK, new _A(true, 0, 100));
    }
    
    private void CostumesListener1() {
        Bukkit.getScheduler().runTaskTimer((Plugin)this.CostumesCostumeService1, () -> {
            Bukkit.getOnlinePlayers().iterator();
            final Iterator iterator;
            while (iterator.hasNext()) {
                this.checkAndApplyEffects(iterator.next());
            }
        }, 60L, 60L);
    }
    
    public void checkAndApplyEffects(final Player player) {
        if (!this.CostumesListener1) {
            return;
        }
        if (!CostumesCostumeService6.CostumesListener4(player)) {
            return;
        }
        final CostumesCostumeService4 playerArmorSnapshot = CostumesCostumeService5.getPlayerArmorSnapshot(player.getUniqueId());
        if (playerArmorSnapshot == null) {
            return;
        }
        if (this.CostumesListener1(playerArmorSnapshot.CostumesCostumeService1())) {
            this.CostumesListener2(player);
        }
        else {
            this.CostumesListener1(player.getUniqueId());
        }
    }
    
    private boolean CostumesListener1(final ItemStack itemStack) {
        return itemStack != null && itemStack.getType() == Material.GOLDEN_HELMET && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equals(this.CostumesListener3);
    }
    
    private void CostumesListener2(final Player player) {
        final UUID uniqueId = player.getUniqueId();
        this.CostumesListener1(uniqueId);
        this.CostumesCostumeService2.put(uniqueId, new BukkitRunnable() {
            public void run() {
                if (!player.isOnline() || !CostumesCostumeService6.CostumesListener4(player)) {
                    CostumesListener4.this.CostumesListener1(uniqueId);
                    return;
                }
                for (final Map.Entry entry : CostumesListener4.this.CostumesListener2.entrySet()) {
                    final _A a = (_A)entry.getValue();
                    final PotionEffectType potionEffectType = (PotionEffectType)entry.getKey();
                    if (a.CostumesListener1) {
                        player.addPotionEffect(new PotionEffect(potionEffectType, a.CostumesCostumeService1, a.CostumesListener2, potionEffectType == PotionEffectType.SPEED || potionEffectType == PotionEffectType.FIRE_RESISTANCE, false), true);
                    }
                }
            }
        }.runTaskTimer((Plugin)this.CostumesCostumeService1, 0L, 60L));
    }
    
    private void CostumesListener1(final UUID uuid) {
        final BukkitTask bukkitTask = this.CostumesCostumeService2.remove(uuid);
        if (bukkitTask != null) {
            bukkitTask.cancel();
        }
    }
    
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent playerJoinEvent) {
        if (!this.CostumesListener1) {
            return;
        }
        Bukkit.getScheduler().runTaskLater((Plugin)this.CostumesCostumeService1, () -> {
            playerJoinEvent2.getPlayer();
            if (player.isOnline()) {
                this.checkAndApplyEffects(player);
            }
        }, 40L);
    }
    
    public void cleanup() {
        final Iterator<BukkitTask> iterator = this.CostumesCostumeService2.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().cancel();
        }
        this.CostumesCostumeService2.clear();
    }
    
    private static class _A
    {
        public final boolean CostumesListener1;
        public final int CostumesListener2;
        public final int CostumesCostumeService1;
        
        public _A(final boolean a, final int b, final int c) {
            this.CostumesListener1 = a;
            this.CostumesListener2 = b;
            this.CostumesCostumeService1 = c;
        }
    }
}
