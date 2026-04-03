// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
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
import java.util.UUID;
import pl.ziffy.STORMSZAFKA.pets.G;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.D;

public class C implements D, Listener
{
    private ArmorStand Z;
    private ArmorStand l;
    private Player W;
    private final String X = "bobas";
    private double a;
    private String V;
    private Date k;
    private static final SimpleDateFormat c;
    private boolean i;
    private boolean f;
    private G d;
    private double j;
    private double h;
    private double e;
    private double b;
    private double Y;
    private boolean _;
    private static final UUID g;
    
    public C() {
        this.a = 0.0;
        this.i = false;
        this.f = true;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.d = Main.getPetConfigManager();
        this.D();
    }
    
    private void D() {
        try {
            final Map<String, Object> d = this.d.D("bobas");
            if (d != null) {
                final Object value = d.get("height");
                final Object value2 = d.get("speed");
                final Object value3 = d.get("distance");
                this.h = ((value instanceof Number) ? ((Number)value).doubleValue() : 0.3);
                this.j = ((value2 instanceof Number) ? ((Number)value2).doubleValue() : 0.05);
                this.e = ((value3 instanceof Number) ? ((Number)value3).doubleValue() : 2.0);
            }
            else {
                this.h = 0.3;
                this.j = 0.05;
                this.e = 2.0;
            }
            if (this.d != null) {
                this.b = this.d.G("bobas").getDouble("bonuses.damage", 2.0);
                this.Y = this.d.G("bobas").getDouble("bonuses.health", 4.0);
                this._ = this.d.G("bobas").getBoolean("bonuses.damage_visible", true);
            }
            else {
                this.b = 2.0;
                this.Y = 4.0;
                this._ = true;
            }
        }
        catch (final Exception ex) {
            this.h = 0.3;
            this.j = 0.05;
            this.e = 2.0;
            this.b = 2.0;
            this.Y = 4.0;
            this._ = true;
            ex.printStackTrace();
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.W != null && this.Z != null && this.l != null) {
            this.i = true;
            this.W.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.Z);
            this.W.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.l);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.W != null && this.Z != null && this.l != null) {
            this.i = false;
            this.W.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.Z);
            this.W.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.l);
        }
    }
    
    @Override
    public void spawn(final Player w, final String s) {
        this.W = w;
        this.V = null;
        this.k = null;
        final Location location = w.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.e));
        String string;
        if (this.d != null) {
            final Object b = this.d.B("bobas", "item.texture.value");
            if (b instanceof final String s3) {
                string = s3;
            }
            else {
                final Object b2 = this.d.B("bobas", "texture.value");
                if (b2 instanceof final String s2) {
                    string = s2;
                }
                else {
                    string = this.d.G("bobas").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTQ2N2IyYThmY2E4YmQxNTljMmUxOTQ3OTQ3YmQxZDU2MmZiYzI3MTZlZmVlNDhkNTU3OTRmZTUzNWVmYmEifX19");
                }
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTQ2N2IyYThmY2E4YmQxNTljMmUxOTQ3OTQ3YmQxZDU2MmZiYzI3MTZlZmVlNDhkNTU3OTRmZTUzNWVmYmEifX19";
        }
        E.B(this.Z = (ArmorStand)w.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(G.C(this.d.L("bobas") + " &8\u25cf &f" + w.getName()));
            this.B(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), w.getUniqueId());
        final Map<String, Object> a = this.d.A("bobas");
        E.A(this.l = (ArmorStand)w.getWorld().spawn(add.clone().add(0.0, (double)a.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(G.C(s + " &8\u25cf &f" + w.getName()));
            armorStand.setCustomNameVisible(true);
        }), w.getUniqueId());
        this.C();
        w.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, false, false));
    }
    
    @Override
    public void update() {
        if (this.W == null || this.Z == null || this.l == null || !this.W.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.W.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.W.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.e));
        this.a += this.j;
        final double n = this.a % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.h) : ((2.0 - n) * this.h), 0.0);
        add.setYaw(location.getYaw());
        this.Z.teleport(add);
        this.l.teleport(add.clone().add(0.0, (double)this.d.A("bobas").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.W) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.Z);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.l);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.W || !this.i) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.Z);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.l);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.Z != null) {
            this.Z.remove();
        }
        if (this.l != null) {
            this.l.remove();
        }
        this.B();
        this.W.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
        this.deactivateEffect();
    }
    
    @Override
    public String getDisplayName() {
        return this.d.G("bobas").getString("name", "Bobas");
    }
    
    public void deactivateEffect() {
        this.f = false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!this.f) {
            return;
        }
        if (entityDamageByEntityEvent.getDamager() instanceof Player && ((Player)entityDamageByEntityEvent.getDamager()).equals((Object)this.W)) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() + this.b);
            if (this._) {}
        }
        if (entityDamageByEntityEvent.getEntity() instanceof Player && ((Player)entityDamageByEntityEvent.getEntity()).equals((Object)this.W)) {
            final ItemStack itemStack = (entityDamageByEntityEvent.getDamager() instanceof Player) ? ((Player)entityDamageByEntityEvent.getDamager()).getInventory().getItemInMainHand() : null;
            if (itemStack != null && this.A(itemStack.getType())) {
                final double damage = entityDamageByEntityEvent.getDamage();
                entityDamageByEntityEvent.setDamage(damage - damage * 0.1);
                if (this._) {}
            }
        }
    }
    
    private boolean A(final Material material) {
        return material == Material.WOODEN_SWORD || material == Material.STONE_SWORD || material == Material.IRON_SWORD || material == Material.GOLDEN_SWORD || material == Material.DIAMOND_SWORD || material == Material.NETHERITE_SWORD;
    }
    
    private void C() {
        if (this.W != null && !this.W.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().anyMatch(attributeModifier -> attributeModifier.getUniqueId().equals(C.g))) {
            this.W.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier(C.g, "BobasHealthBonus", this.Y, AttributeModifier.Operation.ADD_NUMBER));
            this.W.setHealth(Math.min(this.W.getHealth() + this.Y, this.W.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        }
    }
    
    private void B() {
        if (this.W != null) {
            for (final AttributeModifier attributeModifier : this.W.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers()) {
                if (attributeModifier.getUniqueId().equals(C.g)) {
                    this.W.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier);
                    break;
                }
            }
            final double value = this.W.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            if (this.W.getHealth() > value) {
                this.W.setHealth(value);
            }
        }
    }
    
    private void B(final SkullMeta skullMeta, final String s) {
        pl.ziffy.STORMSZAFKA.utils.C.D(skullMeta, s);
    }
    
    static {
        c = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        g = UUID.fromString("bbbbaaaa-cccc-dddd-eeee-fffffffffaaa");
    }
}
