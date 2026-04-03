// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.utils.C;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.HandlerList;
import java.util.Iterator;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Location;
import pl.ziffy.STORMSZAFKA.pets.E;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.pets.G;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.D;

public class R implements D, Listener
{
    private ArmorStand \u01cf;
    private ArmorStand \u01dd;
    private Player \u01c8;
    private final String \u01ca = "elfik";
    private double \u01d0;
    private String \u01c7;
    private Date \u01da;
    private static final SimpleDateFormat \u01d2;
    private boolean \u01d8;
    private boolean \u01d6;
    private G \u01d3;
    private double \u01d9;
    private double \u01d7;
    private double \u01d4;
    private double \u01cc;
    private boolean \u01c9;
    private double \u01d5;
    private boolean \u01cb;
    private int \u01d1;
    private boolean \u01ce;
    private boolean \u01cd;
    private int \u01dc;
    private boolean \u01db;
    
    public R() {
        this.\u01d0 = 0.0;
        this.\u01d8 = false;
        this.\u01d6 = true;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u01d3 = Main.getPetConfigManager();
        this.T();
    }
    
    private void T() {
        try {
            final Map<String, Object> d = this.\u01d3.D("elfik");
            if (d != null) {
                this.\u01d7 = (double)(d.containsKey("height") ? d.get("height") : 0.9);
                this.\u01d9 = (double)(d.containsKey("speed") ? d.get("speed") : 0.025);
                this.\u01d4 = (double)(d.containsKey("distance") ? d.get("distance") : 1.0);
            }
            else {
                this.\u01d7 = 0.9;
                this.\u01d9 = 0.025;
                this.\u01d4 = 1.0;
            }
            final Map<String, Object> d2 = this.\u01d3.D("elfik", "defense");
            if (d2 != null) {
                this.\u01cc = (d2.containsKey("percentage") ? ((double)(int)d2.get("percentage")) : 20.0);
                this.\u01c9 = (d2.containsKey("visible") && (boolean)d2.get("visible"));
            }
            else {
                this.\u01cc = 20.0;
                this.\u01c9 = false;
            }
            final Map<String, Object> d3 = this.\u01d3.D("elfik", "dripstone_reduction");
            if (d3 != null) {
                this.\u01d5 = (double)(d3.containsKey("percentage") ? d3.get("percentage") : 0.5);
                this.\u01cb = (d3.containsKey("visible") && (boolean)d3.get("visible"));
            }
            else {
                this.\u01d5 = 0.5;
                this.\u01cb = false;
            }
            final Map<String, Object> d4 = this.\u01d3.D("elfik", "damage");
            if (d4 != null) {
                this.\u01d1 = (int)(d4.containsKey("amount") ? d4.get("amount") : 3);
                this.\u01ce = (d4.containsKey("visible") && (boolean)d4.get("visible"));
            }
            else {
                this.\u01d1 = 3;
                this.\u01ce = false;
            }
            final Map<String, Object> d5 = this.\u01d3.D("elfik", "hunger");
            if (d5 != null) {
                this.\u01cd = (!d5.containsKey("enabled") || (boolean)d5.get("enabled"));
                this.\u01dc = (int)(d5.containsKey("level") ? d5.get("level") : 20);
                this.\u01db = (d5.containsKey("visible") && (boolean)d5.get("visible"));
            }
            else {
                this.\u01cd = true;
                this.\u01dc = 20;
                this.\u01db = false;
            }
        }
        catch (final Exception ex) {
            this.\u01d7 = 0.9;
            this.\u01d9 = 0.025;
            this.\u01d4 = 1.0;
            this.\u01cc = 20.0;
            this.\u01c9 = false;
            this.\u01d5 = 0.5;
            this.\u01cb = false;
            this.\u01d1 = 3;
            this.\u01ce = false;
            this.\u01cd = true;
            this.\u01dc = 20;
            this.\u01db = false;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u01c8 != null && this.\u01cf != null && this.\u01dd != null) {
            this.\u01d8 = true;
            this.\u01c8.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01cf);
            this.\u01c8.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01dd);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u01c8 != null && this.\u01cf != null && this.\u01dd != null) {
            this.\u01d8 = false;
            this.\u01c8.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01cf);
            this.\u01c8.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01dd);
        }
    }
    
    @Override
    public void spawn(final Player \u01c9, final String s) {
        this.\u01c8 = \u01c9;
        this.\u01c7 = null;
        this.\u01da = null;
        final Location location = \u01c9.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u01d4));
        String string;
        if (this.\u01d3 != null) {
            final Object b = this.\u01d3.B("elfik", "item.texture.value");
            if (b instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u01d3.G("elfik").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGFkMzNhYjY0YzgxYjQzYmY0YmY1MjYxZGZkZDg0YjgxMjkxNTJkZDdiMTIyNjFmNWRhY2I3NzM2MjkyMmE1ZCJ9fX0=");
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGFkMzNhYjY0YzgxYjQzYmY0YmY1MjYxZGZkZDg0YjgxMjkxNTJkZDdiMTIyNjFmNWRhY2I3NzM2MjkyMmE1ZCJ9fX0=";
        }
        E.B(this.\u01cf = (ArmorStand)\u01c9.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(G.C(this.\u01d3.L("elfik") + " &8\u25cf &f" + \u01c9.getName()));
            this.Q(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u01c9.getUniqueId());
        final Map<String, Object> a = this.\u01d3.A("elfik");
        E.A(this.\u01dd = (ArmorStand)\u01c9.getWorld().spawn(add.clone().add(0.0, (double)a.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(G.C(s + " &8\u25cf &f" + \u01c9.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u01c9.getUniqueId());
        if (this.\u01cd) {
            \u01c9.setFoodLevel(this.\u01dc);
            \u01c9.setSaturation((float)this.\u01dc);
        }
    }
    
    @Override
    public void update() {
        if (this.\u01c8 == null || this.\u01cf == null || this.\u01dd == null || !this.\u01c8.isOnline()) {
            return;
        }
        if (this.\u01cd && this.\u01c8.getFoodLevel() < this.\u01dc) {
            this.\u01c8.setFoodLevel(this.\u01dc);
            this.\u01c8.setSaturation((float)this.\u01dc);
        }
        final boolean hasPotionEffect = this.\u01c8.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u01c8.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u01d4));
        this.\u01d0 += this.\u01d9;
        final double n = this.\u01d0 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u01d7) : ((2.0 - n) * this.\u01d7), 0.0);
        add.setYaw(location.getYaw());
        this.\u01cf.teleport(add);
        this.\u01dd.teleport(add.clone().add(0.0, (double)this.\u01d3.A("elfik").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u01c8) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01cf);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01dd);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u01c8 || !this.\u01d8) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01cf);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01dd);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u01cf != null) {
            this.\u01cf.remove();
        }
        if (this.\u01dd != null) {
            this.\u01dd.remove();
        }
        HandlerList.unregisterAll((Listener)this);
        this.deactivateEffect();
        if (this.\u01c8 != null && this.\u01c8.isOnline()) {
            this.\u01c8.setSaturation(5.0f);
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.\u01d3.G("elfik").getString("name", "Elfik");
    }
    
    public void deactivateEffect() {
        this.\u01d6 = false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.\u01c8 != null && entityDamageEvent.getEntity() instanceof Player && this.\u01d6 && ((Player)entityDamageEvent.getEntity()).getUniqueId().equals(this.\u01c8.getUniqueId())) {
            if (entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK) {
                entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u01d5));
            }
            else {
                entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u01cc / 100.0));
            }
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (this.\u01c8 != null && entityDamageByEntityEvent.getDamager() instanceof Player && this.\u01d6 && ((Player)entityDamageByEntityEvent.getDamager()).getUniqueId().equals(this.\u01c8.getUniqueId())) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() + this.\u01d1);
        }
    }
    
    @EventHandler
    public void onFoodLevelChange(final FoodLevelChangeEvent foodLevelChangeEvent) {
        if (this.\u01c8 != null && foodLevelChangeEvent.getEntity() instanceof Player && this.\u01cd) {
            final Player player = (Player)foodLevelChangeEvent.getEntity();
            if (player.getUniqueId().equals(this.\u01c8.getUniqueId()) && foodLevelChangeEvent.getFoodLevel() < player.getFoodLevel()) {
                foodLevelChangeEvent.setCancelled(true);
                player.setFoodLevel(this.\u01dc);
                player.setSaturation((float)this.\u01dc);
            }
        }
    }
    
    private void Q(final SkullMeta skullMeta, final String s) {
        C.D(skullMeta, s);
    }
    
    public double getDefensePercentage() {
        return this.\u01cc;
    }
    
    public boolean isDefenseVisible() {
        return this.\u01c9;
    }
    
    public double getDripstoneReduction() {
        return this.\u01d5;
    }
    
    public boolean isDripstoneReductionVisible() {
        return this.\u01cb;
    }
    
    public int getDamageAmount() {
        return this.\u01d1;
    }
    
    public boolean isDamageVisible() {
        return this.\u01ce;
    }
    
    public boolean isHungerEnabled() {
        return this.\u01cd;
    }
    
    public int getHungerLevel() {
        return this.\u01dc;
    }
    
    public boolean isHungerVisible() {
        return this.\u01db;
    }
    
    static {
        \u01d2 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
