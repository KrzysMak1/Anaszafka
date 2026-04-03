// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.utils.C;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.D;

public class G implements D, Listener
{
    private ArmorStand \u00eb;
    private ArmorStand \u00f9;
    private Player \u00e8;
    private final String \u00e9 = "discordzik";
    private double \u00ec;
    private String \u00e7;
    private Date \u00f8;
    private static final SimpleDateFormat \u00ed;
    private boolean \u00f5;
    private boolean \u00f1;
    private pl.ziffy.STORMSZAFKA.pets.G \u00ee;
    private double \u00f6;
    private double \u00f3;
    private double \u00f0;
    private double \u00f4;
    private double \u00ef;
    private double \u00ea;
    private static final UUID \u00f2;
    
    public G() {
        this.\u00ec = 0.0;
        this.\u00f5 = false;
        this.\u00f1 = true;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u00ee = Main.getPetConfigManager();
        this.H();
    }
    
    private void H() {
        final Map<String, Object> d = this.\u00ee.D("discordzik");
        this.\u00f3 = (double)d.get("height");
        this.\u00f6 = (double)d.get("speed");
        this.\u00f0 = (double)d.get("distance");
        final Map<String, Object> d2 = this.\u00ee.D("discordzik", "fall_damage_reduction");
        this.\u00f4 = (double)(d2.containsKey("reduction") ? d2.get("reduction") : 0.75);
        final Map<String, Object> d3 = this.\u00ee.D("discordzik", "damage_bonus");
        this.\u00ef = (double)(d3.containsKey("bonus") ? d3.get("bonus") : 1.0);
        final Map<String, Object> d4 = this.\u00ee.D("discordzik", "health");
        this.\u00ea = (double)(d4.containsKey("bonus") ? d4.get("bonus") : 2.0);
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u00e8 != null && this.\u00eb != null && this.\u00f9 != null) {
            this.\u00f5 = true;
            this.\u00e8.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00eb);
            this.\u00e8.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00f9);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u00e8 != null && this.\u00eb != null && this.\u00f9 != null) {
            this.\u00f5 = false;
            this.\u00e8.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00eb);
            this.\u00e8.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00f9);
        }
    }
    
    @Override
    public void spawn(final Player \u00e8, final String s) {
        this.\u00e8 = \u00e8;
        this.\u00e7 = null;
        this.\u00f8 = null;
        final Location location = \u00e8.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u00f0));
        String string;
        if (this.\u00ee != null) {
            final Object b = this.\u00ee.B("discordzik", "item.texture.value");
            if (b instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u00ee.G("discordzik").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmM4NGQxYTkwOTVhNjNmNDc1NDY3MjBmZTdmNmVkZjAzZTEyMjc2ZTA2MmI4NTNlMjA3YTVjNjk3ZjFlNTIxIn19fQ==");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmM4NGQxYTkwOTVhNjNmNDc1NDY3MjBmZTdmNmVkZjAzZTEyMjc2ZTA2MmI4NTNlMjA3YTVjNjk3ZjFlNTIxIn19fQ==";
        }
        E.B(this.\u00eb = (ArmorStand)\u00e8.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(pl.ziffy.STORMSZAFKA.pets.G.C(this.\u00ee.L("discordzik") + " &8\u25cf &f" + \u00e8.getName()));
            this.F(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u00e8.getUniqueId());
        final Map<String, Object> a = this.\u00ee.A("discordzik");
        E.A(this.\u00f9 = (ArmorStand)\u00e8.getWorld().spawn(add.clone().add(0.0, (double)a.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(pl.ziffy.STORMSZAFKA.pets.G.C(s + " &8\u25cf &f" + \u00e8.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u00e8.getUniqueId());
        try {
            \u00e8.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().filter(attributeModifier -> attributeModifier.getUniqueId().equals(G.\u00f2)).forEach(attributeModifier2 -> player.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier2));
            \u00e8.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier(G.\u00f2, "discordzik_health_bonus", this.\u00ea, AttributeModifier.Operation.ADD_NUMBER));
            \u00e8.setHealth(Math.min(\u00e8.getHealth() + this.\u00ea, \u00e8.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        }
        catch (final Exception ex) {}
    }
    
    @Override
    public void update() {
        if (this.\u00e8 == null || this.\u00eb == null || this.\u00f9 == null || !this.\u00e8.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u00e8.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u00e8.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u00f0));
        this.\u00ec += this.\u00f6;
        final double n = this.\u00ec % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u00f3) : ((2.0 - n) * this.\u00f3), 0.0);
        add.setYaw(location.getYaw());
        this.\u00eb.teleport(add);
        this.\u00f9.teleport(add.clone().add(0.0, (double)this.\u00ee.A("discordzik").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u00e8) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00eb);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00f9);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u00e8 || !this.\u00f5) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00eb);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00f9);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u00eb != null) {
            this.\u00eb.remove();
        }
        if (this.\u00f9 != null) {
            this.\u00f9.remove();
        }
        try {
            if (this.\u00e8 != null && this.\u00e8.isOnline()) {
                this.\u00e8.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().filter(attributeModifier -> attributeModifier.getUniqueId().equals(G.\u00f2)).forEach(attributeModifier2 -> this.\u00e8.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier2));
                if (this.\u00e8.getHealth() > this.\u00e8.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
                    this.\u00e8.setHealth(this.\u00e8.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                }
            }
        }
        catch (final Exception ex) {}
        this.deactivateEffect();
        HandlerList.unregisterAll((Listener)this);
    }
    
    @Override
    public String getDisplayName() {
        return this.\u00ee.G("discordzik").getString("name", "Discordzik");
    }
    
    public void deactivateEffect() {
        this.\u00f1 = false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (this.\u00e8 == null || !entityDamageByEntityEvent.getDamager().equals((Object)this.\u00e8) || !this.\u00f1) {
            return;
        }
        entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() + this.\u00ef);
    }
    
    @EventHandler
    public void onFallDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.\u00e8 == null || !entityDamageEvent.getEntity().equals((Object)this.\u00e8)) {
            return;
        }
        if (entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALL) {
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u00f4));
        }
    }
    
    private void F(final SkullMeta skullMeta, final String s) {
        C.D(skullMeta, s);
    }
    
    static {
        \u00ed = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        \u00f2 = UUID.fromString("cccccccc-dddd-eeee-ffff-aaaaaaaaaaaa");
    }
}
