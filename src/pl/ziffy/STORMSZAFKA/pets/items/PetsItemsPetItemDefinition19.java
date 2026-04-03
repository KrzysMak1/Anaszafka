// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
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

public class PetsItemsPetItemDefinition19 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand \u01b6;
    private ArmorStand \u01c6;
    private Player \u01b2;
    private final String \u01b3 = "zaj\u0105czek";
    private double \u01b7;
    private String \u01b1;
    private Date \u01c5;
    private static final SimpleDateFormat \u01bc;
    private boolean \u01c3;
    private boolean \u01c1;
    private PetsItemsPetItemDefinition7 \u01bd;
    private double \u01c4;
    private double \u01c2;
    private double \u01bf;
    private int \u01b9;
    private boolean \u01c0;
    private int \u01ba;
    private boolean \u01b8;
    private int \u01be;
    private boolean \u01b5;
    private double \u01bb;
    private boolean \u01b4;
    
    public PetsItemsPetItemDefinition19() {
        this.\u01b7 = 0.0;
        this.\u01c3 = false;
        this.\u01c1 = true;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u01bd = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition21();
    }
    
    private void PetsItemsPetItemDefinition21() {
        try {
            final Map<String, Object> d = this.\u01bd.PetsItemsPetItemDefinition4("zaj\u0105czek");
            if (d != null) {
                this.\u01c2 = (double)(d.containsKey("height") ? d.get("height") : 1.0);
                this.\u01c4 = (double)(d.containsKey("speed") ? d.get("speed") : 0.025);
                this.\u01bf = (double)(d.containsKey("distance") ? d.get("distance") : 1.0);
            }
            else {
                this.\u01c2 = 1.0;
                this.\u01c4 = 0.025;
                this.\u01bf = 1.0;
            }
            final Map<String, Object> d2 = this.\u01bd.PetsItemsPetItemDefinition4("zaj\u0105czek", "speed");
            if (d2 != null) {
                this.\u01b9 = (int)(d2.containsKey("level") ? d2.get("level") : 0);
                this.\u01c0 = (!d2.containsKey("visible") || (boolean)d2.get("visible"));
            }
            else {
                this.\u01b9 = 0;
                this.\u01c0 = true;
            }
            final Map<String, Object> d3 = this.\u01bd.PetsItemsPetItemDefinition4("zaj\u0105czek", "jump");
            if (d3 != null) {
                this.\u01ba = (int)(d3.containsKey("level") ? d3.get("level") : 1);
                this.\u01b8 = (!d3.containsKey("visible") || (boolean)d3.get("visible"));
            }
            else {
                this.\u01ba = 1;
                this.\u01b8 = true;
            }
            final Map<String, Object> d4 = this.\u01bd.PetsItemsPetItemDefinition4("zaj\u0105czek", "damage");
            if (d4 != null) {
                this.\u01be = (int)(d4.containsKey("value") ? d4.get("value") : 4);
                this.\u01b5 = (!d4.containsKey("visible") || (boolean)d4.get("visible"));
            }
            else {
                this.\u01be = 4;
                this.\u01b5 = true;
            }
            final Map<String, Object> d5 = this.\u01bd.PetsItemsPetItemDefinition4("zaj\u0105czek", "fall_damage");
            if (d5 != null) {
                this.\u01bb = (double)(d5.containsKey("reduction") ? d5.get("reduction") : 0.5);
                this.\u01b4 = (!d5.containsKey("visible") || (boolean)d5.get("visible"));
            }
            else {
                this.\u01bb = 0.5;
                this.\u01b4 = true;
            }
        }
        catch (final Exception ex) {
            this.\u01c2 = 1.0;
            this.\u01c4 = 0.025;
            this.\u01bf = 1.0;
            this.\u01b9 = 0;
            this.\u01c0 = true;
            this.\u01ba = 1;
            this.\u01b8 = true;
            this.\u01be = 4;
            this.\u01b5 = true;
            this.\u01bb = 0.5;
            this.\u01b4 = true;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u01b2 != null && this.\u01b6 != null && this.\u01c6 != null) {
            this.\u01c3 = true;
            this.\u01b2.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01b6);
            this.\u01b2.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01c6);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u01b2 != null && this.\u01b6 != null && this.\u01c6 != null) {
            this.\u01c3 = false;
            this.\u01b2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01b6);
            this.\u01b2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01c6);
        }
    }
    
    @Override
    public void spawn(final Player \u028b, final String s) {
        this.\u01b2 = \u028b;
        this.\u01b1 = null;
        this.\u01c5 = null;
        final Location location = \u028b.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u01bf));
        String string;
        if (this.\u01bd != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u01bd.PetsItemsPetItemDefinition2("zaj\u0105czek", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u01bd.PetsItemsPetItemDefinition7("zaj\u0105czek").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjYxODBiYmY4YTI4MDNiNjM3YWVjMjM1NjQ1NTQ5NjJhY2JlYjkwMTBhMDBkMTM2MzYxM2FjMzk4Nzc3NDlkMyJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjYxODBiYmY4YTI4MDNiNjM3YWVjMjM1NjQ1NTQ5NjJhY2JlYjkwMTBhMDBkMTM2MzYxM2FjMzk4Nzc3NDlkMyJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u01b6 = (ArmorStand)\u028b.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u01bd.PetsItemsPetItemDefinition12("zaj\u0105czek") + " &8\u25cf &f" + \u028b.getName()));
            this.PetsItemsPetItemDefinition18(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u028b.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u01bd.PetsItemsPetItemDefinition1("zaj\u0105czek");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u01c6 = (ArmorStand)\u028b.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u028b.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u028b.getUniqueId());
        \u028b.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u01b9 - 1, false, this.\u01c0, true));
        \u028b.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, this.\u01ba - 1, false, this.\u01b8, true));
    }
    
    @Override
    public void update() {
        if (this.\u01b2 == null || this.\u01b6 == null || this.\u01c6 == null || !this.\u01b2.isOnline()) {
            return;
        }
        if (!this.\u01b2.hasPotionEffect(PotionEffectType.SPEED) || (this.\u01b2.hasPotionEffect(PotionEffectType.SPEED) && this.\u01b2.getPotionEffect(PotionEffectType.SPEED).getAmplifier() < this.\u01b9 - 1)) {
            this.\u01b2.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u01b9 - 1, false, this.\u01c0, true));
        }
        if (!this.\u01b2.hasPotionEffect(PotionEffectType.JUMP) || (this.\u01b2.hasPotionEffect(PotionEffectType.JUMP) && this.\u01b2.getPotionEffect(PotionEffectType.JUMP).getAmplifier() < this.\u01ba - 1)) {
            this.\u01b2.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, this.\u01ba - 1, false, this.\u01b8, true));
        }
        final boolean hasPotionEffect = this.\u01b2.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u01b2.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u01bf));
        this.\u01b7 += this.\u01c4;
        final double n = this.\u01b7 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u01c2) : ((2.0 - n) * this.\u01c2), 0.0);
        add.setYaw(location.getYaw());
        this.\u01b6.teleport(add);
        this.\u01c6.teleport(add.clone().add(0.0, (double)this.\u01bd.PetsItemsPetItemDefinition1("zaj\u0105czek").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u01b2) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01b6);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01c6);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u01b2 || !this.\u01c3) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01b6);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01c6);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u01b6 != null) {
            this.\u01b6.remove();
        }
        if (this.\u01c6 != null) {
            this.\u01c6.remove();
        }
        if (this.\u01b2 != null && this.\u01b2.isOnline()) {
            final PotionEffect potionEffect = this.\u01b2.getPotionEffect(PotionEffectType.SPEED);
            if (potionEffect != null && potionEffect.getAmplifier() == this.\u01b9) {
                this.\u01b2.removePotionEffect(PotionEffectType.SPEED);
            }
            final PotionEffect potionEffect2 = this.\u01b2.getPotionEffect(PotionEffectType.JUMP);
            if (potionEffect2 != null && potionEffect2.getAmplifier() == this.\u01ba) {
                this.\u01b2.removePotionEffect(PotionEffectType.JUMP);
            }
        }
        HandlerList.unregisterAll((Listener)this);
        this.deactivateEffect();
    }
    
    @Override
    public String getDisplayName() {
        return this.\u01bd.PetsItemsPetItemDefinition7("zaj\u0105czek").getString("name", "Zaj\u0105czek");
    }
    
    public void deactivateEffect() {
        this.\u01c1 = false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.\u01b2 == null || !this.\u01c1 || !(entityDamageEvent.getEntity() instanceof Player)) {
            return;
        }
        if (((Player)entityDamageEvent.getEntity()).getUniqueId().equals(this.\u01b2.getUniqueId()) && entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALL) {
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u01bb));
        }
    }
    
    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (this.\u01b2 != null && entityDamageByEntityEvent.getDamager() instanceof Player && this.\u01c1 && ((Player)entityDamageByEntityEvent.getDamager()).getUniqueId().equals(this.\u01b2.getUniqueId())) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() + this.\u01be);
        }
    }
    
    private void PetsItemsPetItemDefinition18(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    public int getSpeedEffectLevel() {
        return this.\u01b9;
    }
    
    public boolean isSpeedEffectVisible() {
        return this.\u01c0;
    }
    
    public int getJumpEffectLevel() {
        return this.\u01ba;
    }
    
    public boolean isJumpEffectVisible() {
        return this.\u01b8;
    }
    
    public int getDamageIncrease() {
        return this.\u01be;
    }
    
    public boolean isDamageEffectVisible() {
        return this.\u01b5;
    }
    
    public double getFallReduction() {
        return this.\u01bb;
    }
    
    public boolean isFallReductionVisible() {
        return this.\u01b4;
    }
    
    static {
        \u01bc = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
