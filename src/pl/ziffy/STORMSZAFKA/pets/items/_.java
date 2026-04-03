// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.utils.C;
import org.bukkit.inventory.meta.SkullMeta;
import java.util.Iterator;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Location;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
import pl.ziffy.STORMSZAFKA.pets.E;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import org.bukkit.Bukkit;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import java.util.UUID;
import pl.ziffy.STORMSZAFKA.pets.G;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import pl.ziffy.STORMSZAFKA.pets.D;

public class _ implements D
{
    private ArmorStand \u0389;
    private ArmorStand \u038c;
    private Player \u02d0;
    private final String \u0388 = "aniolek";
    private double \u02e0;
    private String \u02e4;
    private Date \u0386;
    private static final SimpleDateFormat \u038a;
    private boolean \u038e;
    private G \u02d1;
    private double \u02e2;
    private double \u02e3;
    private double \u02c1;
    private double \u02e1;
    private static final UUID \u037a;
    
    public _() {
        this.\u02e0 = 0.0;
        this.\u038e = false;
        this.\u02d1 = Main.getPetConfigManager();
        this.d();
    }
    
    private void d() {
        final Map<String, Object> d = this.\u02d1.D("aniolek");
        this.\u02e3 = (double)d.get("height");
        this.\u02e2 = (double)d.get("speed");
        this.\u02c1 = (double)d.get("distance");
        final Map<String, Object> d2 = this.\u02d1.D("aniolek", "health");
        this.\u02e1 = (double)(d2.containsKey("bonus") ? d2.get("bonus") : 4.0);
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u02d0 != null && this.\u0389 != null && this.\u038c != null) {
            this.\u038e = true;
            this.\u02d0.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0389);
            this.\u02d0.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u038c);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u02d0 != null && this.\u0389 != null && this.\u038c != null) {
            this.\u038e = false;
            this.\u02d0.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0389);
            this.\u02d0.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u038c);
        }
    }
    
    @Override
    public void spawn(final Player \u02d0, final String s) {
        this.\u02d0 = \u02d0;
        this.\u02e4 = null;
        this.\u0386 = null;
        final Location location = \u02d0.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u02c1));
        String string;
        if (this.\u02d1 != null) {
            final Object b = this.\u02d1.B("aniolek", "item.texture.value");
            if (b instanceof final String s3) {
                string = s3;
            }
            else {
                final Object b2 = this.\u02d1.B("aniolek", "texture");
                if (b2 instanceof final String s2) {
                    string = s2;
                }
                else {
                    string = this.\u02d1.G("aniolek").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQyODA3Mjk2YjQxOWFmMDYxZjJmOWQzNmRkMTlhODhiZjc1NGQyYWJjODVmNzMxZDQ1ZjJlN2JiYzkyOTk5ZCJ9fX0=");
                }
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQyODA3Mjk2YjQxOWFmMDYxZjJmOWQzNmRkMTlhODhiZjc1NGQyYWJjODVmNzMxZDQ1ZjJlN2JiYzkyOTk5ZCJ9fX0=";
        }
        E.B(this.\u0389 = (ArmorStand)\u02d0.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(G.C(this.\u02d1.L("aniolek") + " &8\u25cf &f" + \u02d0.getName()));
            this.Z(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u02d0.getUniqueId());
        final Map<String, Object> a = this.\u02d1.A("aniolek");
        E.A(this.\u038c = (ArmorStand)\u02d0.getWorld().spawn(add.clone().add(0.0, (double)a.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(G.C(s + " &8\u25cf &f" + \u02d0.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u02d0.getUniqueId());
        try {
            \u02d0.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().filter(attributeModifier -> attributeModifier.getUniqueId().equals(_.\u037a)).forEach(attributeModifier2 -> player.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier2));
            \u02d0.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier(_.\u037a, "aniolek_health_bonus", this.\u02e1, AttributeModifier.Operation.ADD_NUMBER));
            \u02d0.setHealth(Math.min(\u02d0.getHealth() + this.\u02e1, \u02d0.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void update() {
        if (this.\u02d0 == null || this.\u0389 == null || this.\u038c == null || !this.\u02d0.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u02d0.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u02d0.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u02c1));
        this.\u02e0 += this.\u02e2;
        final double n = this.\u02e0 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u02e3) : ((2.0 - n) * this.\u02e3), 0.0);
        add.setYaw(location.getYaw());
        this.\u0389.teleport(add);
        this.\u038c.teleport(add.clone().add(0.0, (double)this.\u02d1.A("aniolek").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u02d0) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0389);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u038c);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u02d0 || !this.\u038e) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0389);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u038c);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u0389 != null) {
            this.\u0389.remove();
        }
        if (this.\u038c != null) {
            this.\u038c.remove();
        }
        try {
            if (this.\u02d0 != null && this.\u02d0.isOnline()) {
                this.\u02d0.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().filter(attributeModifier -> attributeModifier.getUniqueId().equals(_.\u037a)).forEach(attributeModifier2 -> this.\u02d0.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier2));
                if (this.\u02d0.getHealth() > this.\u02d0.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
                    this.\u02d0.setHealth(this.\u02d0.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                }
            }
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.\u02d1.G("aniolek").getString("name", "Anio\u0142ek");
    }
    
    private void Z(final SkullMeta skullMeta, final String s) {
        C.D(skullMeta, s);
    }
    
    static {
        \u038a = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        \u037a = UUID.fromString("bbbbbbbb-cccc-dddd-eeee-ffffffffffff");
    }
}
