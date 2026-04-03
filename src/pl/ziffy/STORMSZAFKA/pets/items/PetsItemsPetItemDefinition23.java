// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import java.util.Iterator;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Location;
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

public class PetsItemsPetItemDefinition23 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand \u0217;
    private ArmorStand \u0252;
    private Player \u020d;
    private final String \u0215 = "pudzianek";
    private double \u0210;
    private String \u0213;
    private Date \u0214;
    private static final SimpleDateFormat \u0251;
    private boolean \u0253;
    private boolean \u020f;
    private PetsItemsPetItemDefinition7 \u020e;
    private double \u0211;
    private double \u0212;
    private double \u020c;
    private double \u0250;
    private boolean \u0216;
    
    public PetsItemsPetItemDefinition23() {
        this.\u0210 = 0.0;
        this.\u0253 = false;
        this.\u020f = true;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u020e = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition26();
    }
    
    private void PetsItemsPetItemDefinition26() {
        try {
            final Map<String, Object> d = this.\u020e.PetsItemsPetItemDefinition4("pudzianek");
            if (d != null) {
                final Object value = d.get("height");
                final Object value2 = d.get("speed");
                final Object value3 = d.get("distance");
                this.\u0212 = ((value instanceof Number) ? ((Number)value).doubleValue() : 0.9);
                this.\u0211 = ((value2 instanceof Number) ? ((Number)value2).doubleValue() : 0.02);
                this.\u020c = ((value3 instanceof Number) ? ((Number)value3).doubleValue() : 1.0);
            }
            else {
                this.\u0212 = 0.9;
                this.\u0211 = 0.02;
                this.\u020c = 1.0;
            }
            final Map<String, Object> d2 = this.\u020e.PetsItemsPetItemDefinition4("pudzianek", "damage");
            if (d2 != null) {
                final Object value4 = d2.get("amount");
                final Object value5 = d2.get("visible");
                this.\u0250 = ((value4 instanceof Number) ? ((Number)value4).doubleValue() : 2.0);
                this.\u0216 = (value5 instanceof Boolean && (boolean)value5);
            }
            else {
                this.\u0250 = 2.0;
                this.\u0216 = false;
            }
        }
        catch (final Exception ex) {
            this.\u0212 = 0.9;
            this.\u0211 = 0.02;
            this.\u020c = 1.0;
            this.\u0250 = 2.0;
            this.\u0216 = false;
            ex.printStackTrace();
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u020d != null && this.\u0217 != null && this.\u0252 != null) {
            this.\u0253 = true;
            this.\u020d.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0217);
            this.\u020d.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0252);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u020d != null && this.\u0217 != null && this.\u0252 != null) {
            this.\u0253 = false;
            this.\u020d.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0217);
            this.\u020d.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0252);
        }
    }
    
    @Override
    public void spawn(final Player \u020d, final String s) {
        this.\u020d = \u020d;
        this.\u0213 = null;
        this.\u0214 = null;
        final Location location = \u020d.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u020c));
        String string;
        if (this.\u020e != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u020e.PetsItemsPetItemDefinition2("pudzianek", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u020e.PetsItemsPetItemDefinition7("pudzianek").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjE3OWFlNzlkMGNjZmE0MGNmMWQwMDczNjkwY2MzNjMwNjUzYjA3ZGUyYTA5ZDhlOTRlYjU4NTM4N2E2YjBkMiJ9fX0=");
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjE3OWFlNzlkMGNjZmE0MGNmMWQwMDczNjkwY2MzNjMwNjUzYjA3ZGUyYTA5ZDhlOTRlYjU4NTM4N2E2YjBkMiJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u0217 = (ArmorStand)\u020d.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u020e.PetsItemsPetItemDefinition12("pudzianek") + " &8\u25cf &f" + \u020d.getName()));
            this.PetsItemsPetItemDefinition22(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u020d.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u020e.PetsItemsPetItemDefinition1("pudzianek");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u0252 = (ArmorStand)\u020d.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u020d.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u020d.getUniqueId());
    }
    
    @Override
    public void update() {
        if (this.\u020d == null || this.\u0217 == null || this.\u0252 == null || !this.\u020d.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u020d.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u020d.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u020c));
        this.\u0210 += this.\u0211;
        final double n = this.\u0210 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u0212) : ((2.0 - n) * this.\u0212), 0.0);
        add.setYaw(location.getYaw());
        this.\u0217.teleport(add);
        this.\u0252.teleport(add.clone().add(0.0, (double)this.\u020e.PetsItemsPetItemDefinition1("pudzianek").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u020d) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0217);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0252);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u020d || !this.\u0253) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0217);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0252);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u0217 != null) {
            this.\u0217.remove();
        }
        if (this.\u0252 != null) {
            this.\u0252.remove();
        }
        this.deactivateEffect();
    }
    
    @Override
    public String getDisplayName() {
        return this.\u020e.PetsItemsPetItemDefinition7("pudzianek").getString("name", "Pudzianek");
    }
    
    public void deactivateEffect() {
        this.\u020f = false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (this.\u020d != null && entityDamageByEntityEvent.getDamager() instanceof Player && this.\u020f && ((Player)entityDamageByEntityEvent.getDamager()).getUniqueId().equals(this.\u020d.getUniqueId())) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() + this.\u0250);
        }
    }
    
    private void PetsItemsPetItemDefinition22(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    static {
        \u0251 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
