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

public class F implements Listener
{
    private final Main C;
    private final Map<UUID, BukkitTask> E;
    private String D;
    private boolean A;
    private final Map<PotionEffectType, _A> B;
    
    public F(final Main c) {
        this.E = new HashMap<UUID, BukkitTask>();
        this.B = new HashMap<PotionEffectType, _A>();
        this.C = c;
        this.D();
        if (this.A) {
            Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)c);
            this.A();
        }
    }
    
    private void D() {
        final ConfigurationSection configurationSection = this.C.getConfig().getConfigurationSection("costumes.korona_anarchii");
        if (configurationSection == null) {
            this.A = true;
            this.D = "§6Korona ANARCHII";
            this.B();
            return;
        }
        this.A = configurationSection.getBoolean("enabled", true);
        this.D = configurationSection.getString("item_name", "§6Korona ANARCHII");
        final ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection("effects");
        if (configurationSection2 == null) {
            this.B();
            return;
        }
        this.A(configurationSection2, "speed", PotionEffectType.SPEED);
        this.A(configurationSection2, "fire_resistance", PotionEffectType.FIRE_RESISTANCE);
        this.A(configurationSection2, "strength", PotionEffectType.INCREASE_DAMAGE);
        this.A(configurationSection2, "resistance", PotionEffectType.DAMAGE_RESISTANCE);
        this.A(configurationSection2, "luck", PotionEffectType.LUCK);
    }
    
    public void reloadConfig() {
        this.B.clear();
        this.D();
    }
    
    private void A(final ConfigurationSection configurationSection, final String s, final PotionEffectType potionEffectType) {
        final ConfigurationSection configurationSection2 = configurationSection.getConfigurationSection(s);
        if (configurationSection2 == null) {
            int n = 100;
            if (potionEffectType == PotionEffectType.SPEED || potionEffectType == PotionEffectType.FIRE_RESISTANCE) {
                n = 160;
            }
            this.B.put(potionEffectType, new _A(true, this.A(potionEffectType), n));
            return;
        }
        final boolean boolean1 = configurationSection2.getBoolean("enabled", true);
        final int int1 = configurationSection2.getInt("level", this.A(potionEffectType));
        int int2 = configurationSection2.getInt("duration", 100);
        if ((potionEffectType == PotionEffectType.SPEED || potionEffectType == PotionEffectType.FIRE_RESISTANCE) && !configurationSection2.contains("duration")) {
            int2 = 160;
        }
        this.B.put(potionEffectType, new _A(boolean1, int1, int2));
    }
    
    private int A(final PotionEffectType potionEffectType) {
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
    
    private void B() {
        this.B.put(PotionEffectType.SPEED, new _A(true, 1, 160));
        this.B.put(PotionEffectType.FIRE_RESISTANCE, new _A(true, 0, 160));
        this.B.put(PotionEffectType.INCREASE_DAMAGE, new _A(true, 1, 100));
        this.B.put(PotionEffectType.DAMAGE_RESISTANCE, new _A(true, 2, 100));
        this.B.put(PotionEffectType.LUCK, new _A(true, 0, 100));
    }
    
    private void A() {
        Bukkit.getScheduler().runTaskTimer((Plugin)this.C, () -> {
            Bukkit.getOnlinePlayers().iterator();
            final Iterator iterator;
            while (iterator.hasNext()) {
                this.checkAndApplyEffects(iterator.next());
            }
        }, 60L, 60L);
    }
    
    public void checkAndApplyEffects(final Player player) {
        if (!this.A) {
            return;
        }
        if (!L.F(player)) {
            return;
        }
        final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
        if (playerArmorSnapshot == null) {
            return;
        }
        if (this.A(playerArmorSnapshot.C())) {
            this.B(player);
        }
        else {
            this.A(player.getUniqueId());
        }
    }
    
    private boolean A(final ItemStack itemStack) {
        return itemStack != null && itemStack.getType() == Material.GOLDEN_HELMET && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName() && itemStack.getItemMeta().getDisplayName().equals(this.D);
    }
    
    private void B(final Player player) {
        final UUID uniqueId = player.getUniqueId();
        this.A(uniqueId);
        this.E.put(uniqueId, new BukkitRunnable() {
            public void run() {
                if (!player.isOnline() || !L.F(player)) {
                    F.this.A(uniqueId);
                    return;
                }
                for (final Map.Entry entry : F.this.B.entrySet()) {
                    final _A a = (_A)entry.getValue();
                    final PotionEffectType potionEffectType = (PotionEffectType)entry.getKey();
                    if (a.A) {
                        player.addPotionEffect(new PotionEffect(potionEffectType, a.C, a.B, potionEffectType == PotionEffectType.SPEED || potionEffectType == PotionEffectType.FIRE_RESISTANCE, false), true);
                    }
                }
            }
        }.runTaskTimer((Plugin)this.C, 0L, 60L));
    }
    
    private void A(final UUID uuid) {
        final BukkitTask bukkitTask = this.E.remove(uuid);
        if (bukkitTask != null) {
            bukkitTask.cancel();
        }
    }
    
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent playerJoinEvent) {
        if (!this.A) {
            return;
        }
        Bukkit.getScheduler().runTaskLater((Plugin)this.C, () -> {
            playerJoinEvent2.getPlayer();
            if (player.isOnline()) {
                this.checkAndApplyEffects(player);
            }
        }, 40L);
    }
    
    public void cleanup() {
        final Iterator<BukkitTask> iterator = this.E.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().cancel();
        }
        this.E.clear();
    }
    
    private static class _A
    {
        public final boolean A;
        public final int B;
        public final int C;
        
        public _A(final boolean a, final int b, final int c) {
            this.A = a;
            this.B = b;
            this.C = c;
        }
    }
}
