// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.utils.C;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
import pl.ziffy.STORMSZAFKA.pets.E;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.Main;
import java.util.Map;
import java.util.UUID;
import pl.ziffy.STORMSZAFKA.pets.G;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.D;

public class Y implements D, Listener
{
    private ArmorStand \u028d;
    private ArmorStand \u02a3;
    private Player \u028a;
    private final String \u028b = "drakula";
    private double \u028f;
    private String \u0289;
    private Date \u02a2;
    private static final SimpleDateFormat \u0295;
    private boolean \u029e;
    private G \u0296;
    private static final UUID \u029c;
    private double \u02a0;
    private double \u029d;
    private double \u029a;
    private int \u028c;
    private int \u028e;
    private int \u0293;
    private int \u0290;
    private boolean \u029f;
    private boolean \u0297;
    private boolean \u0299;
    private boolean \u029b;
    private int \u0291;
    private int \u0292;
    private int \u02a1;
    private static final Map<UUID, Long> \u0298;
    private static boolean \u0294;
    
    public Y() {
        this.\u028f = 0.0;
        this.\u029e = false;
        this.\u0296 = Main.getPetConfigManager();
        this.b();
    }
    
    private void b() {
        try {
            final Map<String, Object> d = this.\u0296.D("drakula");
            if (d != null) {
                final Object value = d.get("height");
                final Object value2 = d.get("speed");
                final Object value3 = d.get("distance");
                this.\u029d = ((value instanceof Number) ? ((Number)value).doubleValue() : 1.0);
                this.\u02a0 = ((value2 instanceof Number) ? ((Number)value2).doubleValue() : 0.025);
                this.\u029a = ((value3 instanceof Number) ? ((Number)value3).doubleValue() : 1.0);
            }
            else {
                this.\u029d = 1.0;
                this.\u02a0 = 0.025;
                this.\u029a = 1.0;
            }
            final Map<String, Object> d2 = this.\u0296.D("drakula", "durability");
            if (d2 != null) {
                final Object value4 = d2.get("percentage");
                final Object value5 = d2.get("visible");
                this.\u028c = ((value4 instanceof Number) ? ((Number)value4).intValue() : 20);
                this.\u029f = (value5 instanceof Boolean && (boolean)value5);
            }
            else {
                this.\u028c = 20;
                this.\u029f = false;
            }
            final Map<String, Object> d3 = this.\u0296.D("drakula", "life_steal");
            if (d3 != null) {
                final Object value6 = d3.get("percentage");
                final Object value7 = d3.get("visible");
                this.\u028e = ((value6 instanceof Number) ? ((Number)value6).intValue() : 10);
                this.\u0297 = (!(value7 instanceof Boolean) || (boolean)value7);
            }
            else {
                this.\u028e = 10;
                this.\u0297 = true;
            }
            final Map<String, Object> d4 = this.\u0296.D("drakula", "health");
            if (d4 != null) {
                final Object value8 = d4.get("amount");
                final Object value9 = d4.get("visible");
                this.\u0293 = ((value8 instanceof Number) ? ((Number)value8).intValue() : 2);
                this.\u0299 = (!(value9 instanceof Boolean) || (boolean)value9);
            }
            else {
                this.\u0293 = 2;
                this.\u0299 = true;
            }
            final Map<String, Object> d5 = this.\u0296.D("drakula", "speed");
            if (d5 != null) {
                final Object value10 = d5.get("level");
                final Object value11 = d5.get("visible");
                this.\u0290 = ((value10 instanceof Number) ? ((Number)value10).intValue() : 2);
                this.\u029b = (value11 instanceof Boolean && (boolean)value11);
            }
            else {
                this.\u0290 = 2;
                this.\u029b = false;
            }
            final Map<String, Object> d6 = this.\u0296.D("drakula", "vampirism");
            if (d6 != null) {
                final Object value12 = d6.get("percentage");
                final Object value13 = d6.get("chance");
                final Object value14 = d6.get("cooldown");
                this.\u0291 = ((value12 instanceof Number) ? ((Number)value12).intValue() : 150);
                this.\u0292 = ((value13 instanceof Number) ? ((Number)value13).intValue() : 100);
                this.\u02a1 = ((value14 instanceof Number) ? ((Number)value14).intValue() : 20);
            }
            else {
                this.\u0291 = 150;
                this.\u0292 = 100;
                this.\u02a1 = 20;
            }
            if (!Y.\u0294) {
                Bukkit.getPluginManager().registerEvents((Listener)this, (Plugin)Main.getInstance());
                Y.\u0294 = true;
            }
        }
        catch (final Exception ex) {
            this.\u029d = 1.0;
            this.\u02a0 = 0.025;
            this.\u029a = 1.0;
            this.\u028c = 20;
            this.\u029f = false;
            this.\u028e = 10;
            this.\u0297 = true;
            this.\u0293 = 2;
            this.\u0299 = true;
            this.\u0290 = 2;
            this.\u029b = false;
            ex.printStackTrace();
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u028a != null && this.\u028d != null && this.\u02a3 != null) {
            this.\u029e = true;
            this.\u028a.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u028d);
            this.\u028a.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u02a3);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u028a != null && this.\u028d != null && this.\u02a3 != null) {
            this.\u029e = false;
            this.\u028a.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u028d);
            this.\u028a.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u02a3);
        }
    }
    
    @Override
    public void spawn(final Player \u028a, final String s) {
        this.\u028a = \u028a;
        this.\u0289 = null;
        this.\u02a2 = null;
        final Location location = \u028a.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u029a));
        String string;
        if (this.\u0296 != null) {
            final Object b = this.\u0296.B("drakula", "item.texture.value");
            if (b instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u0296.G("drakula").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGMwNTk4ZjY4YzAyNGFhMTQ2OTgzZTg2OTRjMDBjMGEyZjNmMWVhMWQ3OWIyYjM4MWJhYzc5ZTU4NjhkNjRjYSJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGMwNTk4ZjY4YzAyNGFhMTQ2OTgzZTg2OTRjMDBjMGEyZjNmMWVhMWQ3OWIyYjM4MWJhYzc5ZTU4NjhkNjRjYSJ9fX0=";
        }
        E.B(this.\u028d = (ArmorStand)\u028a.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(G.C(this.\u0296.L("drakula") + " &8\u25cf &f" + \u028a.getName()));
            this.X(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u028a.getUniqueId());
        final Map<String, Object> a = this.\u0296.A("drakula");
        E.A(this.\u02a3 = (ArmorStand)\u028a.getWorld().spawn(add.clone().add(0.0, (double)a.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(G.C(s + " &8\u25cf &f" + \u028a.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u028a.getUniqueId());
        if (\u028a.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().noneMatch(attributeModifier -> attributeModifier.getUniqueId().equals(Y.\u029c))) {
            \u028a.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier(Y.\u029c, "Drakula hearts", this.\u0293 * 2.0, AttributeModifier.Operation.ADD_NUMBER));
        }
        \u028a.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, this.\u0290 - 1, false, this.\u029b));
    }
    
    @Override
    public void update() {
        if (this.\u028a == null || this.\u028d == null || this.\u02a3 == null || !this.\u028a.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u028a.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u028a.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u029a));
        this.\u028f += this.\u02a0;
        final double n = this.\u028f % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u029d) : ((2.0 - n) * this.\u029d), 0.0);
        add.setYaw(location.getYaw());
        this.\u028d.teleport(add);
        this.\u02a3.teleport(add.clone().add(0.0, (double)this.\u0296.A("drakula").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u028a) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u028d);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u02a3);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u028a || !this.\u029e) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u028d);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u02a3);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u028d != null) {
            this.\u028d.remove();
        }
        if (this.\u02a3 != null) {
            this.\u02a3.remove();
        }
        if (this.\u028a != null && this.\u028a.isOnline()) {
            this.\u028a.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().filter(attributeModifier -> attributeModifier.getUniqueId().equals(Y.\u029c)).findFirst().ifPresent(attributeModifier2 -> this.\u028a.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier2));
            this.\u028a.removePotionEffect(PotionEffectType.SPEED);
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.\u0296.G("drakula").getString("name", "Drakula");
    }
    
    public int getDurabilityPercentage() {
        return this.\u028c;
    }
    
    public int getLifeStealPercentage() {
        return this.\u028e;
    }
    
    public boolean isDurabilityVisible() {
        return this.\u029f;
    }
    
    public boolean isLifeStealVisible() {
        return this.\u0297;
    }
    
    @EventHandler
    public void onPlayerDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!(entityDamageByEntityEvent.getDamager() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityDamageByEntityEvent.getDamager();
        if (!E.K(player) || !"drakula".equals(E.G(player))) {
            return;
        }
        if (this.\u028a == null || !this.\u028a.getUniqueId().equals(player.getUniqueId())) {
            return;
        }
        if (Math.random() * 100.0 > this.\u0292) {
            return;
        }
        final UUID uniqueId = player.getUniqueId();
        final long currentTimeMillis = System.currentTimeMillis();
        if (Y.\u0298.containsKey(uniqueId) && currentTimeMillis - Y.\u0298.get(uniqueId) < this.\u02a1 * 1000L) {
            return;
        }
        player.setHealth(Math.min(player.getHealth() + entityDamageByEntityEvent.getDamage() * (this.\u0291 / 100.0), player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        Y.\u0298.put(uniqueId, currentTimeMillis);
    }
    
    private void X(final SkullMeta skullMeta, final String s) {
        C.D(skullMeta, s);
    }
    
    static {
        \u0295 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        \u029c = UUID.fromString("bbbbbbbb-cccc-dddd-eeee-ffffffffffff");
        \u0298 = new ConcurrentHashMap<UUID, Long>();
        Y.\u0294 = false;
    }
}
