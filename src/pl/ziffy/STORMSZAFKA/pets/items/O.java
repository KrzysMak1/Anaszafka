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

public class O implements D, Listener
{
    private ArmorStand \u0198;
    private ArmorStand \u019a;
    private Player \u0190;
    private final String \u0197 = "pancernik";
    private double \u0192;
    private String \u0195;
    private Date \u0196;
    private static final SimpleDateFormat \u0199;
    private boolean \u019b;
    private G \u0191;
    private double \u0193;
    private double \u0194;
    private double \u018e;
    private int \u018f;
    
    public O() {
        this.\u0192 = 0.0;
        this.\u019b = false;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u0191 = Main.getPetConfigManager();
        this.Q();
    }
    
    private void Q() {
        final Map<String, Object> d = this.\u0191.D("pancernik");
        this.\u0194 = (double)d.get("height");
        this.\u0193 = (double)d.get("speed");
        this.\u018e = (double)d.get("distance");
        this.\u018f = this.\u0191.D("pancernik", "defense").get("percentage");
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u0190 != null && this.\u0198 != null && this.\u019a != null) {
            this.\u019b = true;
            this.\u0190.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0198);
            this.\u0190.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u019a);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u0190 != null && this.\u0198 != null && this.\u019a != null) {
            this.\u019b = false;
            this.\u0190.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0198);
            this.\u0190.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u019a);
        }
    }
    
    @Override
    public void spawn(final Player \u025b, final String s) {
        this.\u0190 = \u025b;
        this.\u0195 = null;
        this.\u0196 = null;
        final Location location = \u025b.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u018e));
        String string;
        if (this.\u0191 != null) {
            final Object b = this.\u0191.B("pancernik", "item.texture.value");
            if (b instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u0191.G("pancernik").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzcwMThhMGRmMzYyNjNjZTQ3NjIwNmNhM2JmMGQ4OTRlNzJmZDBlNjU1YTU3NTNhNzdhNzNmMTQyNDViN2RhIn19fQ==");
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzcwMThhMGRmMzYyNjNjZTQ3NjIwNmNhM2JmMGQ4OTRlNzJmZDBlNjU1YTU3NTNhNzdhNzNmMTQyNDViN2RhIn19fQ==";
        }
        E.B(this.\u0198 = (ArmorStand)\u025b.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(G.C(this.\u0191.L("pancernik") + " &8\u25cf &f" + \u025b.getName()));
            this.N(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u025b.getUniqueId());
        final Map<String, Object> a = this.\u0191.A("pancernik");
        E.A(this.\u019a = (ArmorStand)\u025b.getWorld().spawn(add.clone().add(0.0, (double)a.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(G.C(s + " &8\u25cf &f" + \u025b.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u025b.getUniqueId());
    }
    
    @Override
    public void update() {
        if (this.\u0190 == null || this.\u0198 == null || this.\u019a == null || !this.\u0190.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u0190.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u0190.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u018e));
        this.\u0192 += this.\u0193;
        final double n = this.\u0192 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u0194) : ((2.0 - n) * this.\u0194), 0.0);
        add.setYaw(location.getYaw());
        this.\u0198.teleport(add);
        this.\u019a.teleport(add.clone().add(0.0, (double)this.\u0191.A("pancernik").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u0190) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0198);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u019a);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u0190 || !this.\u019b) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0198);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u019a);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u0198 != null) {
            this.\u0198.remove();
        }
        if (this.\u019a != null) {
            this.\u019a.remove();
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.\u0191.G("pancernik").getString("name", "Pancernik");
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.\u0190 != null && entityDamageEvent.getEntity() instanceof Player && ((Player)entityDamageEvent.getEntity()).getUniqueId().equals(this.\u0190.getUniqueId())) {
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u018f / 100.0));
        }
    }
    
    private void N(final SkullMeta skullMeta, final String s) {
        C.D(skullMeta, s);
    }
    
    static {
        \u0199 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
