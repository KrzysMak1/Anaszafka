// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.utils.C;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.HandlerList;
import java.util.Iterator;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Location;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
import pl.ziffy.STORMSZAFKA.pets.E;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Bukkit;
import java.util.UUID;
import pl.ziffy.STORMSZAFKA.pets.G;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.D;

public class b implements D, Listener
{
    private ArmorStand \u03ad;
    private ArmorStand \u03bb;
    private Player \u03a9;
    private final String \u03ab = "golemik";
    private double \u03ae;
    private String \u03a8;
    private Date \u03ba;
    private static final SimpleDateFormat \u03b0;
    private boolean \u03b8;
    private G \u03b1;
    private static final UUID \u03b6;
    private double \u03b9;
    private double \u03b7;
    private double \u03b5;
    private int \u03ac;
    private int \u03b2;
    private int \u03af;
    private boolean \u03aa;
    private boolean \u03b4;
    private boolean \u03b3;
    
    public b() {
        this.\u03ae = 0.0;
        this.\u03b8 = false;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u03b1 = Main.getPetConfigManager();
        this.f();
    }
    
    private void f() {
        try {
            final Map<String, Object> d = this.\u03b1.D("golemik");
            if (d != null) {
                final Object value = d.get("height");
                final Object value2 = d.get("speed");
                final Object value3 = d.get("distance");
                this.\u03b7 = ((value instanceof Number) ? ((Number)value).doubleValue() : 0.7);
                this.\u03b9 = ((value2 instanceof Number) ? ((Number)value2).doubleValue() : 0.02);
                this.\u03b5 = ((value3 instanceof Number) ? ((Number)value3).doubleValue() : 1.0);
            }
            else {
                this.\u03b7 = 0.7;
                this.\u03b9 = 0.02;
                this.\u03b5 = 1.0;
            }
            final Map<String, Object> d2 = this.\u03b1.D("golemik", "defense");
            if (d2 != null) {
                final Object value4 = d2.get("percentage");
                final Object value5 = d2.get("visible");
                this.\u03ac = ((value4 instanceof Number) ? ((Number)value4).intValue() : 10);
                this.\u03aa = (value5 instanceof Boolean && (boolean)value5);
            }
            else {
                this.\u03ac = 10;
                this.\u03aa = false;
            }
            final Map<String, Object> d3 = this.\u03b1.D("golemik", "dripstone_protection");
            if (d3 != null) {
                final Object value6 = d3.get("percentage");
                final Object value7 = d3.get("visible");
                this.\u03b2 = ((value6 instanceof Number) ? ((Number)value6).intValue() : 50);
                this.\u03b4 = (value7 instanceof Boolean && (boolean)value7);
            }
            else {
                this.\u03b2 = 50;
                this.\u03b4 = false;
            }
            final Map<String, Object> d4 = this.\u03b1.D("golemik", "health");
            if (d4 != null) {
                final Object value8 = d4.get("amount");
                final Object value9 = d4.get("visible");
                this.\u03af = ((value8 instanceof Number) ? ((Number)value8).intValue() : 1);
                this.\u03b3 = (!(value9 instanceof Boolean) || (boolean)value9);
            }
            else {
                this.\u03af = 1;
                this.\u03b3 = true;
            }
        }
        catch (final Exception ex) {
            this.\u03b7 = 0.7;
            this.\u03b9 = 0.02;
            this.\u03b5 = 1.0;
            this.\u03ac = 10;
            this.\u03aa = false;
            this.\u03b2 = 50;
            this.\u03b4 = false;
            this.\u03af = 1;
            this.\u03b3 = true;
            ex.printStackTrace();
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u03a9 != null && this.\u03ad != null && this.\u03bb != null) {
            this.\u03b8 = true;
            this.\u03a9.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03ad);
            this.\u03a9.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03bb);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u03a9 != null && this.\u03ad != null && this.\u03bb != null) {
            this.\u03b8 = false;
            this.\u03a9.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03ad);
            this.\u03a9.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03bb);
        }
    }
    
    @Override
    public void spawn(final Player \u03c9, final String s) {
        this.\u03a9 = \u03c9;
        this.\u03a8 = null;
        this.\u03ba = null;
        final Location location = \u03c9.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u03b5));
        String string;
        if (this.\u03b1 != null) {
            final Object b = this.\u03b1.B("golemik", "item.texture.value");
            if (b instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u03b1.G("golemik").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGE2ZTA0MjljY2FhYmI2ZjVmMGM1ZDUxM2M3OTViZWQ2ZDgwZmNlNzJmNTdmNGJjM2E2MTZhZWUyM2UxMjU3MiJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGE2ZTA0MjljY2FhYmI2ZjVmMGM1ZDUxM2M3OTViZWQ2ZDgwZmNlNzJmNTdmNGJjM2E2MTZhZWUyM2UxMjU3MiJ9fX0=";
        }
        E.B(this.\u03ad = (ArmorStand)\u03c9.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(G.C(this.\u03b1.L("golemik") + " &8\u25cf &f" + \u03c9.getName()));
            this.a(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u03c9.getUniqueId());
        final Map<String, Object> a = this.\u03b1.A("golemik");
        E.A(this.\u03bb = (ArmorStand)\u03c9.getWorld().spawn(add.clone().add(0.0, (a != null && a.get("height") instanceof Number) ? ((Number)a.get("height")).doubleValue() : 2.3, 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(G.C(s + " &8\u25cf &f" + \u03c9.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u03c9.getUniqueId());
        if (\u03c9.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().noneMatch(attributeModifier -> attributeModifier.getUniqueId().equals(b.\u03b6))) {
            \u03c9.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier(b.\u03b6, "Golemin hearts", this.\u03af * 2.0, AttributeModifier.Operation.ADD_NUMBER));
        }
    }
    
    @Override
    public void update() {
        if (this.\u03a9 == null || this.\u03ad == null || this.\u03bb == null || !this.\u03a9.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u03a9.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u03a9.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u03b5));
        this.\u03ae += this.\u03b9;
        final double n = this.\u03ae % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u03b7) : ((2.0 - n) * this.\u03b7), 0.0);
        add.setYaw(location.getYaw());
        this.\u03ad.teleport(add);
        final Map<String, Object> a = this.\u03b1.A("golemik");
        this.\u03bb.teleport(add.clone().add(0.0, (a != null && a.get("height") instanceof Number) ? ((Number)a.get("height")).doubleValue() : 2.3, 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u03a9) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03ad);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03bb);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u03a9 || !this.\u03b8) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03ad);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03bb);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u03ad != null) {
            this.\u03ad.remove();
        }
        if (this.\u03bb != null) {
            this.\u03bb.remove();
        }
        HandlerList.unregisterAll((Listener)this);
        if (this.\u03a9 != null && this.\u03a9.isOnline()) {
            this.\u03a9.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().filter(attributeModifier -> attributeModifier.getUniqueId().equals(b.\u03b6)).findFirst().ifPresent(attributeModifier2 -> this.\u03a9.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier2));
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.\u03b1.G("golemik").getString("name", "Golemik");
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.\u03a9 != null && entityDamageEvent.getEntity() instanceof Player && ((Player)entityDamageEvent.getEntity()).getUniqueId().equals(this.\u03a9.getUniqueId())) {
            final double damage = entityDamageEvent.getDamage();
            double damage2;
            if (entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK) {
                damage2 = damage * (1.0 - this.\u03b2 / 100.0);
            }
            else {
                damage2 = damage * (1.0 - this.\u03ac / 100.0);
            }
            entityDamageEvent.setDamage(damage2);
        }
    }
    
    private void a(final SkullMeta skullMeta, final String s) {
        C.D(skullMeta, s);
    }
    
    static {
        \u03b0 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        \u03b6 = UUID.fromString("cccccccc-dddd-eeee-ffff-aaaaaaaaaaaa");
    }
}
