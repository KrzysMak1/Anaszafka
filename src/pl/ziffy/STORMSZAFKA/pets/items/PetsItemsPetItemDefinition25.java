// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.HandlerList;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition5;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition7;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition4;

public class PetsItemsPetItemDefinition25 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand \u0259;
    private ArmorStand \u0269;
    private Player \u0255;
    private final String \u0257 = "cukiereczek";
    private double \u025a;
    private String \u0254;
    private Date \u0268;
    private static final SimpleDateFormat \u025c;
    private boolean \u0266;
    private boolean \u0263;
    private PetsItemsPetItemDefinition7 \u025d;
    private double \u0267;
    private double \u0265;
    private double \u0261;
    private int \u025b;
    private boolean \u0262;
    private boolean \u0256;
    private boolean \u0264;
    private int \u025e;
    private boolean \u0258;
    private double \u0260;
    private boolean \u025f;
    
    public PetsItemsPetItemDefinition25() {
        this.\u025a = 0.0;
        this.\u0266 = false;
        this.\u0263 = true;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u025d = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition27();
    }
    
    private void PetsItemsPetItemDefinition27() {
        try {
            final Map<String, Object> d = this.\u025d.PetsItemsPetItemDefinition4("cukiereczek");
            if (d != null) {
                this.\u0265 = (double)(d.containsKey("height") ? d.get("height") : 1.0);
                this.\u0267 = (double)(d.containsKey("speed") ? d.get("speed") : 0.025);
                this.\u0261 = (double)(d.containsKey("distance") ? d.get("distance") : 1.0);
            }
            else {
                this.\u0265 = 1.0;
                this.\u0267 = 0.025;
                this.\u0261 = 1.0;
            }
            final Map<String, Object> d2 = this.\u025d.PetsItemsPetItemDefinition4("cukiereczek", "speed");
            if (d2 != null) {
                this.\u025b = (int)(d2.containsKey("level") ? d2.get("level") : 1);
                this.\u0262 = (d2.containsKey("visible") && (boolean)d2.get("visible"));
            }
            else {
                this.\u025b = 1;
                this.\u0262 = false;
            }
            final Map<String, Object> d3 = this.\u025d.PetsItemsPetItemDefinition4("cukiereczek", "fire_resistance");
            if (d3 != null) {
                this.\u0256 = (!d3.containsKey("enabled") || (boolean)d3.get("enabled"));
                this.\u0264 = (d3.containsKey("visible") && (boolean)d3.get("visible"));
            }
            else {
                this.\u0256 = true;
                this.\u0264 = false;
            }
            final Map<String, Object> d4 = this.\u025d.PetsItemsPetItemDefinition4("cukiereczek", "damage");
            if (d4 != null) {
                this.\u025e = (int)(d4.containsKey("value") ? d4.get("value") : 2);
                this.\u0258 = (!d4.containsKey("visible") || (boolean)d4.get("visible"));
            }
            else {
                this.\u025e = 2;
                this.\u0258 = true;
            }
            final Map<String, Object> d5 = this.\u025d.PetsItemsPetItemDefinition4("cukiereczek", "sword_defense");
            if (d5 != null) {
                this.\u0260 = (double)(d5.containsKey("percentage") ? d5.get("percentage") : 0.15);
                this.\u025f = (!d5.containsKey("visible") || (boolean)d5.get("visible"));
            }
            else {
                this.\u0260 = 0.15;
                this.\u025f = true;
            }
        }
        catch (final Exception ex) {
            this.\u0265 = 1.0;
            this.\u0267 = 0.025;
            this.\u0261 = 1.0;
            this.\u025b = 1;
            this.\u0262 = false;
            this.\u0256 = true;
            this.\u0264 = false;
            this.\u025e = 2;
            this.\u0258 = true;
            this.\u0260 = 0.15;
            this.\u025f = true;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u0255 != null && this.\u0259 != null && this.\u0269 != null) {
            this.\u0266 = true;
            this.\u0255.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0259);
            this.\u0255.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0269);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u0255 != null && this.\u0259 != null && this.\u0269 != null) {
            this.\u0266 = false;
            this.\u0255.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0259);
            this.\u0255.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0269);
        }
    }
    
    @Override
    public void spawn(final Player \u0255, final String s) {
        this.\u0255 = \u0255;
        this.\u0254 = null;
        this.\u0268 = null;
        final Location location = \u0255.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0261));
        String string;
        if (this.\u025d != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u025d.PetsItemsPetItemDefinition2("cukiereczek", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u025d.PetsItemsPetItemDefinition7("cukiereczek").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWI0YjVjNzQ4MzA2MDlmOWNlN2JmYjhjYTI2ZmFjMTcxZWRiYzZiMjdjNjM3ZWExMDFmYzFhZTFhMmZhYzQ0MSJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWI0YjVjNzQ4MzA2MDlmOWNlN2JmYjhjYTI2ZmFjMTcxZWRiYzZiMjdjNjM3ZWExMDFmYzFhZTFhMmZhYzQ0MSJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u0259 = (ArmorStand)\u0255.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u025d.PetsItemsPetItemDefinition12("cukiereczek") + " &8\u25cf &f" + \u0255.getName()));
            this.PetsItemsPetItemDefinition23(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u0255.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u025d.PetsItemsPetItemDefinition1("cukiereczek");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u0269 = (ArmorStand)\u0255.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u0255.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u0255.getUniqueId());
        \u0255.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, this.\u025b, false, this.\u0262, true));
        if (this.\u0256) {
            \u0255.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, false, this.\u0264, true));
        }
    }
    
    @Override
    public void update() {
        if (this.\u0255 == null || this.\u0259 == null || this.\u0269 == null || !this.\u0255.isOnline()) {
            return;
        }
        if (!this.\u0255.hasPotionEffect(PotionEffectType.SPEED) || this.\u0255.getPotionEffect(PotionEffectType.SPEED).getAmplifier() < this.\u025b) {
            this.\u0255.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, this.\u025b, false, this.\u0262, true));
        }
        if (this.\u0256 && !this.\u0255.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
            this.\u0255.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, false, this.\u0264, true));
        }
        final boolean hasPotionEffect = this.\u0255.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u0255.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0261));
        this.\u025a += this.\u0267;
        final double n = this.\u025a % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u0265) : ((2.0 - n) * this.\u0265), 0.0);
        add.setYaw(location.getYaw());
        this.\u0259.teleport(add);
        this.\u0269.teleport(add.clone().add(0.0, (double)this.\u025d.PetsItemsPetItemDefinition1("cukiereczek").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u0255) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0259);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0269);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u0255 || !this.\u0266) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0259);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0269);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u0259 != null) {
            this.\u0259.remove();
        }
        if (this.\u0269 != null) {
            this.\u0269.remove();
        }
        this.deactivateEffect();
        if (this.\u0255 != null && this.\u0255.isOnline()) {
            this.\u0255.removePotionEffect(PotionEffectType.SPEED);
            this.\u0255.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
        }
        HandlerList.unregisterAll((Listener)this);
    }
    
    @Override
    public String getDisplayName() {
        return this.\u025d.PetsItemsPetItemDefinition7("cukiereczek").getString("name", "Cukiereczek");
    }
    
    public void deactivateEffect() {
        this.\u0263 = false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!this.\u0263) {
            return;
        }
        if (this.\u0255 != null && entityDamageByEntityEvent.getDamager() instanceof Player && ((Player)entityDamageByEntityEvent.getDamager()).getUniqueId().equals(this.\u0255.getUniqueId())) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() + this.\u025e);
        }
        if (this.\u0255 != null && entityDamageByEntityEvent.getEntity() instanceof Player && ((Player)entityDamageByEntityEvent.getEntity()).getUniqueId().equals(this.\u0255.getUniqueId()) && entityDamageByEntityEvent.getDamager() instanceof Player && this.PetsItemsPetItemDefinition2(((Player)entityDamageByEntityEvent.getDamager()).getInventory().getItemInMainHand().getType())) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() * (1.0 - this.\u0260));
        }
    }
    
    @EventHandler
    public void onFireDamage(final EntityDamageEvent entityDamageEvent) {
        if (!this.\u0263 || !this.\u0256) {
            return;
        }
        if (this.\u0255 != null && entityDamageEvent.getEntity() instanceof Player && ((Player)entityDamageEvent.getEntity()).getUniqueId().equals(this.\u0255.getUniqueId())) {
            final EntityDamageEvent.DamageCause cause = entityDamageEvent.getCause();
            if (cause == EntityDamageEvent.DamageCause.FIRE || cause == EntityDamageEvent.DamageCause.FIRE_TICK || cause == EntityDamageEvent.DamageCause.LAVA || cause == EntityDamageEvent.DamageCause.HOT_FLOOR || cause == EntityDamageEvent.DamageCause.MELTING) {
                entityDamageEvent.setCancelled(true);
            }
        }
    }
    
    private boolean PetsItemsPetItemDefinition2(final Material material) {
        return material == Material.WOODEN_SWORD || material == Material.STONE_SWORD || material == Material.IRON_SWORD || material == Material.GOLDEN_SWORD || material == Material.DIAMOND_SWORD || material == Material.NETHERITE_SWORD;
    }
    
    private void PetsItemsPetItemDefinition23(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    public int getSpeedEffectLevel() {
        return this.\u025b;
    }
    
    public boolean isSpeedEffectVisible() {
        return this.\u0262;
    }
    
    public boolean isFireResistanceEnabled() {
        return this.\u0256;
    }
    
    public boolean isFireResistanceVisible() {
        return this.\u0264;
    }
    
    public int getDamageIncrease() {
        return this.\u025e;
    }
    
    public boolean isDamageEffectVisible() {
        return this.\u0258;
    }
    
    public double getSwordDefensePercentage() {
        return this.\u0260;
    }
    
    public boolean isSwordDefenseVisible() {
        return this.\u025f;
    }
    
    static {
        \u025c = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
