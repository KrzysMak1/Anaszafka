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
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.HandlerList;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
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

public class J implements D, Listener
{
    private ArmorStand \u0128;
    private ArmorStand \u013b;
    private Player \u0126;
    private final String \u0127 = "reniferek";
    private double \u012a;
    private String \u0125;
    private Date \u0138;
    private static final SimpleDateFormat \u012d;
    private boolean \u0136;
    private G \u012e;
    private static final UUID \u0134;
    private double \u0137;
    private double \u0135;
    private double \u0132;
    private int \u012b;
    private boolean \u0133;
    private boolean \u0129;
    private int \u013a;
    private boolean \u0139;
    private int \u012f;
    private boolean \u0131;
    private int \u012c;
    private boolean \u0130;
    
    public J() {
        this.\u012a = 0.0;
        this.\u0136 = false;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u012e = Main.getPetConfigManager();
        this.K();
    }
    
    private void K() {
        try {
            final Map<String, Object> d = this.\u012e.D("reniferek");
            if (d != null) {
                final Object value = d.get("height");
                final Object value2 = d.get("speed");
                final Object value3 = d.get("distance");
                this.\u0135 = ((value instanceof Number) ? ((Number)value).doubleValue() : 0.9);
                this.\u0137 = ((value2 instanceof Number) ? ((Number)value2).doubleValue() : 0.025);
                this.\u0132 = ((value3 instanceof Number) ? ((Number)value3).doubleValue() : 1.0);
            }
            else {
                this.\u0135 = 0.9;
                this.\u0137 = 0.025;
                this.\u0132 = 1.0;
            }
            final Map<String, Object> d2 = this.\u012e.D("reniferek", "speed");
            if (d2 != null) {
                final Object value4 = d2.get("level");
                final Object value5 = d2.get("visible");
                this.\u012b = ((value4 instanceof Number) ? ((Number)value4).intValue() : 1);
                this.\u0133 = (value5 instanceof Boolean && (boolean)value5);
            }
            else {
                this.\u012b = 1;
                this.\u0133 = false;
            }
            final Map<String, Object> d3 = this.\u012e.D("reniferek", "hunger");
            if (d3 != null) {
                final Object value6 = d3.get("enabled");
                final Object value7 = d3.get("level");
                final Object value8 = d3.get("visible");
                this.\u0129 = (!(value6 instanceof Boolean) || (boolean)value6);
                this.\u013a = ((value7 instanceof Number) ? ((Number)value7).intValue() : 20);
                this.\u0139 = (value8 instanceof Boolean && (boolean)value8);
            }
            else {
                this.\u0129 = true;
                this.\u013a = 20;
                this.\u0139 = false;
            }
            final Map<String, Object> d4 = this.\u012e.D("reniferek", "dripstone_protection");
            if (d4 != null) {
                final Object value9 = d4.get("percentage");
                final Object value10 = d4.get("visible");
                this.\u012f = ((value9 instanceof Number) ? ((Number)value9).intValue() : 50);
                this.\u0131 = (value10 instanceof Boolean && (boolean)value10);
            }
            else {
                this.\u012f = 50;
                this.\u0131 = false;
            }
            final Map<String, Object> d5 = this.\u012e.D("reniferek", "health");
            if (d5 != null) {
                final Object value11 = d5.get("amount");
                final Object value12 = d5.get("visible");
                this.\u012c = ((value11 instanceof Number) ? ((Number)value11).intValue() : 1);
                this.\u0130 = (!(value12 instanceof Boolean) || (boolean)value12);
            }
            else {
                this.\u012c = 1;
                this.\u0130 = true;
            }
        }
        catch (final Exception ex) {
            this.\u0135 = 0.9;
            this.\u0137 = 0.025;
            this.\u0132 = 1.0;
            this.\u012b = 1;
            this.\u0133 = false;
            this.\u0129 = true;
            this.\u013a = 20;
            this.\u0139 = false;
            this.\u012f = 50;
            this.\u0131 = false;
            this.\u012c = 1;
            this.\u0130 = true;
            ex.printStackTrace();
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u0126 != null && this.\u0128 != null && this.\u013b != null) {
            this.\u0136 = true;
            this.\u0126.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0128);
            this.\u0126.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u013b);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u0126 != null && this.\u0128 != null && this.\u013b != null) {
            this.\u0136 = false;
            this.\u0126.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0128);
            this.\u0126.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u013b);
        }
    }
    
    @Override
    public void spawn(final Player \u0127, final String s) {
        this.\u0126 = \u0127;
        this.\u0125 = null;
        this.\u0138 = null;
        final Location location = \u0127.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0132));
        String string;
        if (this.\u012e != null) {
            final Object b = this.\u012e.B("reniferek", "item.texture.value");
            if (b instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u012e.G("reniferek").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmI3ZjU2OTQxNTYyMTA5ZGRlNWExMzg2MGE5ODI3ZDU2YWYzOGZhYTU0NzE3MWVkMWRiZTdhNmEwNWZjOGZmMiJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmI3ZjU2OTQxNTYyMTA5ZGRlNWExMzg2MGE5ODI3ZDU2YWYzOGZhYTU0NzE3MWVkMWRiZTdhNmEwNWZjOGZmMiJ9fX0=";
        }
        E.B(this.\u0128 = (ArmorStand)\u0127.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(G.C(this.\u012e.L("reniferek") + " &8\u25cf &f" + \u0127.getName()));
            this.I(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u0127.getUniqueId());
        final Map<String, Object> a = this.\u012e.A("reniferek");
        E.A(this.\u013b = (ArmorStand)\u0127.getWorld().spawn(add.clone().add(0.0, (a != null && a.get("height") instanceof Number) ? ((Number)a.get("height")).doubleValue() : 2.3, 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(G.C(s + " &8\u25cf &f" + \u0127.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u0127.getUniqueId());
        if (\u0127.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().noneMatch(attributeModifier -> attributeModifier.getUniqueId().equals(J.\u0134))) {
            \u0127.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier(J.\u0134, "Reniferek hearts", this.\u012c * 2.0, AttributeModifier.Operation.ADD_NUMBER));
        }
        if (this.\u0129) {
            \u0127.setFoodLevel(this.\u013a);
            \u0127.setSaturation((float)this.\u013a);
        }
        \u0127.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u012b - 1, false, false, this.\u0133));
    }
    
    @Override
    public void update() {
        if (this.\u0126 == null || this.\u0128 == null || this.\u013b == null || !this.\u0126.isOnline()) {
            return;
        }
        if (!this.\u0126.hasPotionEffect(PotionEffectType.SPEED)) {
            this.\u0126.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u012b - 1, false, false, this.\u0133));
        }
        if (this.\u0129 && this.\u0126.getFoodLevel() < this.\u013a) {
            this.\u0126.setFoodLevel(this.\u013a);
            this.\u0126.setSaturation((float)this.\u013a);
        }
        final boolean hasPotionEffect = this.\u0126.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u0126.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0132));
        this.\u012a += this.\u0137;
        final double n = this.\u012a % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u0135) : ((2.0 - n) * this.\u0135), 0.0);
        add.setYaw(location.getYaw());
        this.\u0128.teleport(add);
        final Map<String, Object> a = this.\u012e.A("reniferek");
        this.\u013b.teleport(add.clone().add(0.0, (a != null && a.get("height") instanceof Number) ? ((Number)a.get("height")).doubleValue() : 2.3, 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u0126) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0128);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u013b);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u0126 || !this.\u0136) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0128);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u013b);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u0128 != null) {
            this.\u0128.remove();
        }
        if (this.\u013b != null) {
            this.\u013b.remove();
        }
        HandlerList.unregisterAll((Listener)this);
        if (this.\u0126 != null && this.\u0126.isOnline()) {
            this.\u0126.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().filter(attributeModifier -> attributeModifier.getUniqueId().equals(J.\u0134)).findFirst().ifPresent(attributeModifier2 -> this.\u0126.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier2));
            this.\u0126.removePotionEffect(PotionEffectType.SPEED);
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.\u012e.G("reniferek").getString("name", "Reniferek");
    }
    
    @EventHandler
    public void onFoodLevelChange(final FoodLevelChangeEvent foodLevelChangeEvent) {
        if (this.\u0126 != null && foodLevelChangeEvent.getEntity() instanceof Player && this.\u0129) {
            final Player player = (Player)foodLevelChangeEvent.getEntity();
            if (player.getUniqueId().equals(this.\u0126.getUniqueId()) && foodLevelChangeEvent.getFoodLevel() < player.getFoodLevel()) {
                foodLevelChangeEvent.setCancelled(true);
                player.setFoodLevel(this.\u013a);
                player.setSaturation((float)this.\u013a);
            }
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.\u0126 != null && entityDamageEvent.getEntity() instanceof Player && ((Player)entityDamageEvent.getEntity()).getUniqueId().equals(this.\u0126.getUniqueId()) && entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK) {
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u012f / 100.0));
        }
    }
    
    private void I(final SkullMeta skullMeta, final String s) {
        C.D(skullMeta, s);
    }
    
    static {
        \u012d = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        \u0134 = UUID.fromString("aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee");
    }
}
