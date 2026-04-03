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
import pl.ziffy.STORMSZAFKA.pets.E;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import org.bukkit.Bukkit;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import pl.ziffy.STORMSZAFKA.pets.G;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import pl.ziffy.STORMSZAFKA.pets.D;

public class W implements D
{
    private ArmorStand \u0275;
    private ArmorStand \u0277;
    private Player \u026c;
    private final String \u0274 = "leniuszek";
    private double \u026e;
    private String \u0271;
    private Date \u0273;
    private static final SimpleDateFormat \u0276;
    private boolean \u0278;
    private G \u026d;
    private double \u026f;
    private double \u0270;
    private double \u026a;
    private double \u026b;
    private boolean \u0272;
    
    public W() {
        this.\u026e = 0.0;
        this.\u0278 = false;
        this.\u026d = Main.getPetConfigManager();
        this.Z();
    }
    
    private void Z() {
        try {
            final Map<String, Object> d = this.\u026d.D("leniuszek");
            if (d != null) {
                final Object value = d.get("height");
                final Object value2 = d.get("speed");
                final Object value3 = d.get("distance");
                this.\u0270 = ((value instanceof Number) ? ((Number)value).doubleValue() : 0.8);
                this.\u026f = ((value2 instanceof Number) ? ((Number)value2).doubleValue() : 0.02);
                this.\u026a = ((value3 instanceof Number) ? ((Number)value3).doubleValue() : 1.0);
            }
            else {
                this.\u0270 = 0.8;
                this.\u026f = 0.02;
                this.\u026a = 1.0;
            }
            final Map<String, Object> d2 = this.\u026d.D("leniuszek", "afk_drop_multiplier");
            if (d2 != null) {
                final Object value4 = d2.get("multiplier");
                final Object value5 = d2.get("visible");
                this.\u026b = ((value4 instanceof Number) ? ((Number)value4).doubleValue() : 2.0);
                this.\u0272 = (!(value5 instanceof Boolean) || (boolean)value5);
            }
            else {
                this.\u026b = 2.0;
                this.\u0272 = true;
            }
        }
        catch (final Exception ex) {
            this.\u0270 = 0.8;
            this.\u026f = 0.02;
            this.\u026a = 1.0;
            this.\u026b = 2.0;
            this.\u0272 = true;
            ex.printStackTrace();
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u026c != null && this.\u0275 != null && this.\u0277 != null) {
            this.\u0278 = true;
            this.\u026c.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0275);
            this.\u026c.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0277);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u026c != null && this.\u0275 != null && this.\u0277 != null) {
            this.\u0278 = false;
            this.\u026c.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0275);
            this.\u026c.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0277);
        }
    }
    
    @Override
    public void spawn(final Player \u026c, final String s) {
        this.\u026c = \u026c;
        this.\u0271 = null;
        this.\u0273 = null;
        final Location location = \u026c.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u026a));
        String string;
        if (this.\u026d != null) {
            final Object b = this.\u026d.B("leniuszek", "item.texture.value");
            if (b instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u026d.G("leniuszek").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmIwZmQwODM4ZDY4NmY2NGQwNDdiYmVjNzY5NWY3YzhjNjJlMmI1OTQ4OTg2ZjJmYzM3NGE5YjU1NGZiNDRkOCJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmIwZmQwODM4ZDY4NmY2NGQwNDdiYmVjNzY5NWY3YzhjNjJlMmI1OTQ4OTg2ZjJmYzM3NGE5YjU1NGZiNDRkOCJ9fX0=";
        }
        E.B(this.\u0275 = (ArmorStand)\u026c.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(G.C(this.\u026d.L("leniuszek") + " &8\u25cf &f" + \u026c.getName()));
            this.V(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u026c.getUniqueId());
        final Map<String, Object> a = this.\u026d.A("leniuszek");
        E.A(this.\u0277 = (ArmorStand)\u026c.getWorld().spawn(add.clone().add(0.0, (double)a.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(G.C(s + " &8\u25cf &f" + \u026c.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u026c.getUniqueId());
    }
    
    @Override
    public void update() {
        if (this.\u026c == null || this.\u0275 == null || this.\u0277 == null || !this.\u026c.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u026c.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u026c.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u026a));
        this.\u026e += this.\u026f;
        final double n = this.\u026e % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u0270) : ((2.0 - n) * this.\u0270), 0.0);
        add.setYaw(location.getYaw());
        this.\u0275.teleport(add);
        this.\u0277.teleport(add.clone().add(0.0, (double)this.\u026d.A("leniuszek").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u026c) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0275);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0277);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u026c || !this.\u0278) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0275);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0277);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u0275 != null) {
            this.\u0275.remove();
        }
        if (this.\u0277 != null) {
            this.\u0277.remove();
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.\u026d.G("leniuszek").getString("name", "Leniuszek");
    }
    
    public double Y() {
        return this.\u026b;
    }
    
    public boolean _() {
        return this.\u0272;
    }
    
    private void V(final SkullMeta skullMeta, final String s) {
        C.D(skullMeta, s);
    }
    
    static {
        \u0276 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
