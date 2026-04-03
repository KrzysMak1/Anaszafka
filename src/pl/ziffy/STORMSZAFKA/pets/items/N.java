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

public class N implements D, Listener
{
    private ArmorStand \u018a;
    private ArmorStand \u018c;
    private Player \u0182;
    private final String \u0189 = "skalniaczek";
    private double \u0184;
    private String \u0187;
    private Date \u0188;
    private static final SimpleDateFormat \u018b;
    private boolean \u018d;
    private G \u0183;
    private double \u0185;
    private double \u0186;
    private double \u0180;
    private double \u0181;
    
    public N() {
        this.\u0184 = 0.0;
        this.\u018d = false;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u0183 = Main.getPetConfigManager();
        this.P();
    }
    
    private void P() {
        final Map<String, Object> d = this.\u0183.D("skalniaczek");
        this.\u0186 = (double)d.get("height");
        this.\u0185 = (double)d.get("speed");
        this.\u0180 = (double)d.get("distance");
        final Map<String, Object> d2 = this.\u0183.D("skalniaczek", "dripstone_protection");
        this.\u0181 = (double)(d2.containsKey("reduction") ? d2.get("reduction") : 0.5);
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u0182 != null && this.\u018a != null && this.\u018c != null) {
            this.\u018d = true;
            this.\u0182.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u018a);
            this.\u0182.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u018c);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u0182 != null && this.\u018a != null && this.\u018c != null) {
            this.\u018d = false;
            this.\u0182.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u018a);
            this.\u0182.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u018c);
        }
    }
    
    @Override
    public void spawn(final Player \u0183, final String s) {
        this.\u0182 = \u0183;
        this.\u0187 = null;
        this.\u0188 = null;
        final Location location = \u0183.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0180));
        String string;
        if (this.\u0183 != null) {
            final Object b = this.\u0183.B("skalniaczek", "item.texture.value");
            if (b instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u0183.G("skalniaczek").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzk4NWY3MGI1YWM0M2RlNzJhYTgwNzcyZTE0MWU0ZjUzOGIyMzIwYzdhM2IyZWFmM2Q5NGMwOWEzMzI0MTNmMiJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzk4NWY3MGI1YWM0M2RlNzJhYTgwNzcyZTE0MWU0ZjUzOGIyMzIwYzdhM2IyZWFmM2Q5NGMwOWEzMzI0MTNmMiJ9fX0=";
        }
        E.B(this.\u018a = (ArmorStand)\u0183.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(G.C(this.\u0183.L("skalniaczek") + " &8\u25cf &f" + \u0183.getName()));
            this.M(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u0183.getUniqueId());
        final Map<String, Object> a = this.\u0183.A("skalniaczek");
        E.A(this.\u018c = (ArmorStand)\u0183.getWorld().spawn(add.clone().add(0.0, (double)a.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(G.C(s + " &8\u25cf &f" + \u0183.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u0183.getUniqueId());
    }
    
    @Override
    public void update() {
        if (this.\u0182 == null || this.\u018a == null || this.\u018c == null || !this.\u0182.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u0182.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u0182.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0180));
        this.\u0184 += this.\u0185;
        final double n = this.\u0184 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u0186) : ((2.0 - n) * this.\u0186), 0.0);
        add.setYaw(location.getYaw());
        this.\u018a.teleport(add);
        this.\u018c.teleport(add.clone().add(0.0, (double)this.\u0183.A("skalniaczek").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u0182) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u018a);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u018c);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u0182 || !this.\u018d) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u018a);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u018c);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u018a != null) {
            this.\u018a.remove();
        }
        if (this.\u018c != null) {
            this.\u018c.remove();
        }
        HandlerList.unregisterAll((Listener)this);
    }
    
    @Override
    public String getDisplayName() {
        return this.\u0183.G("skalniaczek").getString("name", "Skalniaczek");
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.\u0182 == null || !entityDamageEvent.getEntity().equals((Object)this.\u0182)) {
            return;
        }
        if (entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK) {
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u0181));
        }
    }
    
    private void M(final SkullMeta skullMeta, final String s) {
        C.D(skullMeta, s);
    }
    
    static {
        \u018b = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
