// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import pl.ziffy.STORMSZAFKA.utils.C;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.entity.Arrow;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.HandlerList;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.ziffy.STORMSZAFKA.pets.E;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.pets.G;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.D;

public class L implements D, Listener
{
    private ArmorStand \u0154;
    private ArmorStand \u0164;
    private Player \u0150;
    private final String \u0152 = "rozdymek";
    private double \u0156;
    private String \u014e;
    private Date \u0163;
    private static final SimpleDateFormat \u0158;
    private boolean \u0161;
    private boolean \u015f;
    private Random \u014f;
    private G \u0159;
    private double \u0162;
    private double \u0160;
    private double \u015d;
    private int \u0157;
    private boolean \u015e;
    private boolean \u015a;
    private boolean \u0153;
    private double \u0151;
    private boolean \u015c;
    private double \u0155;
    private boolean \u015b;
    
    public L() {
        this.\u0156 = 0.0;
        this.\u0161 = false;
        this.\u015f = true;
        this.\u014f = new Random();
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u0159 = Main.getPetConfigManager();
        this.M();
    }
    
    private void M() {
        try {
            final Map<String, Object> d = this.\u0159.D("rozdymek");
            if (d != null) {
                this.\u0160 = (double)(d.containsKey("height") ? d.get("height") : 1.0);
                this.\u0162 = (double)(d.containsKey("speed") ? d.get("speed") : 0.025);
                this.\u015d = (double)(d.containsKey("distance") ? d.get("distance") : 1.0);
            }
            else {
                this.\u0160 = 1.0;
                this.\u0162 = 0.025;
                this.\u015d = 1.0;
            }
            final Map<String, Object> d2 = this.\u0159.D("rozdymek", "speed");
            if (d2 != null) {
                this.\u0157 = (int)(d2.containsKey("level") ? d2.get("level") : 1);
                this.\u015e = (d2.containsKey("visible") && (boolean)d2.get("visible"));
            }
            else {
                this.\u0157 = 1;
                this.\u015e = false;
            }
            final Map<String, Object> d3 = this.\u0159.D("rozdymek", "water_breathing");
            if (d3 != null) {
                this.\u015a = (!d3.containsKey("enabled") || (boolean)d3.get("enabled"));
                this.\u0153 = (d3.containsKey("visible") && (boolean)d3.get("visible"));
            }
            else {
                this.\u015a = true;
                this.\u0153 = false;
            }
            final Map<String, Object> d4 = this.\u0159.D("rozdymek", "extra_fishing");
            if (d4 != null) {
                this.\u0151 = (double)(d4.containsKey("chance") ? d4.get("chance") : 0.5);
                this.\u015c = (!d4.containsKey("visible") || (boolean)d4.get("visible"));
            }
            else {
                this.\u0151 = 0.5;
                this.\u015c = true;
            }
            final Map<String, Object> d5 = this.\u0159.D("rozdymek", "negative_effect_reduction");
            if (d5 != null) {
                this.\u0155 = (double)(d5.containsKey("percentage") ? d5.get("percentage") : 0.5);
                this.\u015b = (!d5.containsKey("visible") || (boolean)d5.get("visible"));
            }
            else {
                this.\u0155 = 0.5;
                this.\u015b = true;
            }
        }
        catch (final Exception ex) {
            this.\u0160 = 1.0;
            this.\u0162 = 0.025;
            this.\u015d = 1.0;
            this.\u0157 = 1;
            this.\u015e = false;
            this.\u015a = true;
            this.\u0153 = false;
            this.\u0151 = 0.5;
            this.\u015c = true;
            this.\u0155 = 0.5;
            this.\u015b = true;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u0150 != null && this.\u0154 != null && this.\u0164 != null) {
            this.\u0161 = true;
            this.\u0150.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0154);
            this.\u0150.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0164);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u0150 != null && this.\u0154 != null && this.\u0164 != null) {
            this.\u0161 = false;
            this.\u0150.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0154);
            this.\u0150.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0164);
        }
    }
    
    @Override
    public void spawn(final Player \u0151, final String s) {
        this.\u0150 = \u0151;
        this.\u014e = null;
        this.\u0163 = null;
        final Location location = \u0151.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u015d));
        String string;
        if (this.\u0159 != null) {
            final Object b = this.\u0159.B("rozdymek", "item.texture.value");
            if (b instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u0159.G("rozdymek").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTI2NmY1NGExZjJiODZmZDhmZDAxNjNhOWQyMmE5YjZiM2E0YzkzODk1Mjk3YmM3ZWU2Nzg4NzA4ZjRkOTc0NSJ9fX0=");
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTI2NmY1NGExZjJiODZmZDhmZDAxNjNhOWQyMmE5YjZiM2E0YzkzODk1Mjk3YmM3ZWU2Nzg4NzA4ZjRkOTc0NSJ9fX0=";
        }
        E.B(this.\u0154 = (ArmorStand)\u0151.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(G.C(this.\u0159.L("rozdymek") + " &8\u25cf &f" + \u0151.getName()));
            this.K(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u0151.getUniqueId());
        final Map<String, Object> a = this.\u0159.A("rozdymek");
        E.A(this.\u0164 = (ArmorStand)\u0151.getWorld().spawn(add.clone().add(0.0, (double)a.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(G.C(s + " &8\u25cf &f" + \u0151.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u0151.getUniqueId());
        \u0151.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, this.\u0157 - 1, false, this.\u015e, true));
        if (this.\u015a) {
            \u0151.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 0, false, this.\u0153, true));
        }
    }
    
    @Override
    public void update() {
        if (this.\u0150 == null || this.\u0154 == null || this.\u0164 == null || !this.\u0150.isOnline()) {
            return;
        }
        if (!this.\u0150.hasPotionEffect(PotionEffectType.SPEED) || this.\u0150.getPotionEffect(PotionEffectType.SPEED).getAmplifier() < this.\u0157 - 1) {
            this.\u0150.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, this.\u0157 - 1, false, this.\u015e, true));
        }
        if (this.\u015a && !this.\u0150.hasPotionEffect(PotionEffectType.WATER_BREATHING)) {
            this.\u0150.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 999999, 0, false, this.\u0153, true));
        }
        final boolean hasPotionEffect = this.\u0150.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u0150.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u015d));
        this.\u0156 += this.\u0162;
        final double n = this.\u0156 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u0160) : ((2.0 - n) * this.\u0160), 0.0);
        add.setYaw(location.getYaw());
        this.\u0154.teleport(add);
        this.\u0164.teleport(add.clone().add(0.0, (double)this.\u0159.A("rozdymek").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u0150) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0154);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0164);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u0150 || !this.\u0161) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0154);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0164);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u0154 != null) {
            this.\u0154.remove();
        }
        if (this.\u0164 != null) {
            this.\u0164.remove();
        }
        this.deactivateEffect();
        if (this.\u0150 != null && this.\u0150.isOnline()) {
            this.\u0150.removePotionEffect(PotionEffectType.SPEED);
            this.\u0150.removePotionEffect(PotionEffectType.WATER_BREATHING);
        }
        HandlerList.unregisterAll((Listener)this);
    }
    
    @Override
    public String getDisplayName() {
        return this.\u0159.G("rozdymek").getString("name", "Rozdymek");
    }
    
    public void deactivateEffect() {
        this.\u015f = false;
    }
    
    @EventHandler
    public void onPlayerFish(final PlayerFishEvent playerFishEvent2) {
        if (!this.\u015f) {
            return;
        }
        if (this.\u0150 != null && playerFishEvent2.getPlayer().getUniqueId().equals(this.\u0150.getUniqueId()) && playerFishEvent2.getState() == PlayerFishEvent.State.CAUGHT_FISH && this.\u014f.nextDouble() < this.\u0151 && playerFishEvent2.getCaught() != null) {
            Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> {
                playerFishEvent2.getCaught().getLocation();
                this.\u0150.getWorld().dropItemNaturally(location, this.N());
            }, 1L);
        }
    }
    
    private ItemStack N() {
        final Material[] array = { Material.COD, Material.SALMON, Material.TROPICAL_FISH, Material.PUFFERFISH, Material.NAME_TAG, Material.SADDLE, Material.NAUTILUS_SHELL, Material.BOW, Material.FISHING_ROD, Material.BOOK, Material.LILY_PAD };
        return new ItemStack(array[this.\u014f.nextInt(array.length)]);
    }
    
    @EventHandler
    public void onPotionEffect(final EntityPotionEffectEvent entityPotionEffectEvent) {
        if (!this.\u015f) {
            return;
        }
        if (this.\u0150 != null && entityPotionEffectEvent.getEntity() instanceof Player && entityPotionEffectEvent.getEntity().getUniqueId().equals(this.\u0150.getUniqueId()) && entityPotionEffectEvent.getAction() == EntityPotionEffectEvent.Action.ADDED) {
            final PotionEffect potionEffect2 = entityPotionEffectEvent.getNewEffect();
            if (potionEffect2 != null && this.A(potionEffect2.getType())) {
                entityPotionEffectEvent.setCancelled(true);
                Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> {
                    final PotionEffect potionEffect2;
                    final Object o = new PotionEffect(potionEffect2.getType(), (int)(potionEffect2.getDuration() * (1.0 - this.\u0155)), potionEffect2.getAmplifier(), potionEffect2.isAmbient(), potionEffect2.hasParticles(), potionEffect2.hasIcon());
                    if (this.\u0150.isOnline()) {
                        this.\u0150.addPotionEffect(potionEffect);
                    }
                }, 1L);
            }
        }
    }
    
    @EventHandler
    public void onArrowHit(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!this.\u015f) {
            return;
        }
        if (this.\u0150 != null && entityDamageByEntityEvent.getEntity() instanceof Player && entityDamageByEntityEvent.getEntity().getUniqueId().equals(this.\u0150.getUniqueId()) && entityDamageByEntityEvent.getDamager() instanceof Arrow) {
            final Arrow arrow = (Arrow)entityDamageByEntityEvent.getDamager();
            if (arrow.hasCustomEffects()) {
                arrow.getCustomEffects().forEach(potionEffect -> {
                    if (this.A(potionEffect.getType())) {
                        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> {
                            if (this.\u0150.isOnline() && this.\u0150.hasPotionEffect(potionEffect2.getType())) {
                                this.\u0150.removePotionEffect(potionEffect2.getType());
                                this.\u0150.addPotionEffect(new PotionEffect(potionEffect2.getType(), (int)(potionEffect2.getDuration() * (1.0 - this.\u0155)), potionEffect2.getAmplifier(), potionEffect2.isAmbient(), potionEffect2.hasParticles(), potionEffect2.hasIcon()));
                            }
                        }, 1L);
                    }
                });
            }
        }
    }
    
    private boolean A(final PotionEffectType potionEffectType) {
        return potionEffectType == PotionEffectType.POISON || potionEffectType == PotionEffectType.WITHER || potionEffectType == PotionEffectType.BLINDNESS || potionEffectType == PotionEffectType.CONFUSION || potionEffectType == PotionEffectType.HARM || potionEffectType == PotionEffectType.HUNGER || potionEffectType == PotionEffectType.SLOW || potionEffectType == PotionEffectType.SLOW_DIGGING || potionEffectType == PotionEffectType.WEAKNESS || potionEffectType == PotionEffectType.UNLUCK || potionEffectType == PotionEffectType.LEVITATION || potionEffectType == PotionEffectType.BAD_OMEN || potionEffectType == PotionEffectType.DARKNESS;
    }
    
    private void K(final SkullMeta skullMeta, final String s) {
        C.D(skullMeta, s);
    }
    
    public int getSpeedLevel() {
        return this.\u0157;
    }
    
    public boolean isSpeedEffectVisible() {
        return this.\u015e;
    }
    
    public boolean isWaterBreathingEnabled() {
        return this.\u015a;
    }
    
    public boolean isWaterBreathingVisible() {
        return this.\u0153;
    }
    
    public double getExtraFishingChance() {
        return this.\u0151;
    }
    
    public boolean isExtraFishingVisible() {
        return this.\u015c;
    }
    
    public double getNegativeEffectReduction() {
        return this.\u0155;
    }
    
    public boolean isNegativeEffectReductionVisible() {
        return this.\u015b;
    }
    
    static {
        \u0158 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
