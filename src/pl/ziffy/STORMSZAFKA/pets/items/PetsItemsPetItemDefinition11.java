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
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.HandlerList;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
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

public class PetsItemsPetItemDefinition11 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand \u0140;
    private ArmorStand \u014d;
    private Player \u013d;
    private final String \u013f = "nietoperek";
    private double \u0141;
    private String \u013c;
    private Date \u014c;
    private static final SimpleDateFormat \u0143;
    private boolean \u0149;
    private boolean \u0147;
    private PetsItemsPetItemDefinition7 \u0144;
    private double \u014b;
    private double \u0148;
    private double \u0145;
    private double \u014a;
    private int \u013e;
    private int \u0142;
    private boolean \u0146;
    
    public PetsItemsPetItemDefinition11() {
        this.\u0141 = 0.0;
        this.\u0149 = false;
        this.\u0147 = true;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u0144 = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition12();
    }
    
    private void PetsItemsPetItemDefinition12() {
        final Map<String, Object> d = this.\u0144.PetsItemsPetItemDefinition4("nietoperek");
        this.\u0148 = (double)d.get("height");
        this.\u014b = (double)d.get("speed");
        this.\u0145 = (double)d.get("distance");
        final Map<String, Object> d2 = this.\u0144.PetsItemsPetItemDefinition4("nietoperek", "void_damage_reduction");
        this.\u014a = (double)(d2.containsKey("reduction") ? d2.get("reduction") : 0.5);
        final Map<String, Object> d3 = this.\u0144.PetsItemsPetItemDefinition4("nietoperek", "speed");
        this.\u013e = (int)(d3.containsKey("duration") ? d3.get("duration") : 12000);
        this.\u0142 = (int)(d3.containsKey("level") ? d3.get("level") : 2);
        this.\u0146 = (d3.containsKey("visible") && (boolean)d3.get("visible"));
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u013d != null && this.\u0140 != null && this.\u014d != null) {
            this.\u0149 = true;
            this.\u013d.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0140);
            this.\u013d.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u014d);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u013d != null && this.\u0140 != null && this.\u014d != null) {
            this.\u0149 = false;
            this.\u013d.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0140);
            this.\u013d.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u014d);
        }
    }
    
    @Override
    public void spawn(final Player \u013e, final String s) {
        this.\u013d = \u013e;
        this.\u013c = null;
        this.\u014c = null;
        final Location location = \u013e.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0145));
        String string;
        if (this.\u0144 != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u0144.PetsItemsPetItemDefinition2("nietoperek", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u0144.PetsItemsPetItemDefinition7("nietoperek").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjc2NjA1ODA3MDgzOWYxZmY0YzU4YTUyM2E3ZGI5MDVkN2E4YmFhYjZhMjU5MDYzYmMwOTQ2YTNiNzRhZmU5ZSJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjc2NjA1ODA3MDgzOWYxZmY0YzU4YTUyM2E3ZGI5MDVkN2E4YmFhYjZhMjU5MDYzYmMwOTQ2YTNiNzRhZmU5ZSJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u0140 = (ArmorStand)\u013e.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u0144.PetsItemsPetItemDefinition12("nietoperek") + " &8\u25cf &f" + \u013e.getName()));
            this.PetsItemsPetItemDefinition10(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u013e.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u0144.PetsItemsPetItemDefinition1("nietoperek");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u014d = (ArmorStand)\u013e.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u013e.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u013e.getUniqueId());
        \u013e.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, this.\u013e, this.\u0142 - 1, false, this.\u0146));
    }
    
    @Override
    public void update() {
        if (this.\u013d == null || this.\u0140 == null || this.\u014d == null || !this.\u013d.isOnline()) {
            return;
        }
        if (!this.\u013d.hasPotionEffect(PotionEffectType.SPEED) && this.\u0147) {
            this.\u013d.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, this.\u013e, this.\u0142 - 1, false, this.\u0146));
        }
        final boolean hasPotionEffect = this.\u013d.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u013d.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0145));
        this.\u0141 += this.\u014b;
        final double n = this.\u0141 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u0148) : ((2.0 - n) * this.\u0148), 0.0);
        add.setYaw(location.getYaw());
        this.\u0140.teleport(add);
        this.\u014d.teleport(add.clone().add(0.0, (double)this.\u0144.PetsItemsPetItemDefinition1("nietoperek").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u013d) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0140);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u014d);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u013d || !this.\u0149) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0140);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u014d);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u0140 != null) {
            this.\u0140.remove();
        }
        if (this.\u014d != null) {
            this.\u014d.remove();
        }
        if (this.\u013d != null && this.\u013d.isOnline()) {
            this.\u013d.removePotionEffect(PotionEffectType.SPEED);
        }
        HandlerList.unregisterAll((Listener)this);
    }
    
    @Override
    public String getDisplayName() {
        return this.\u0144.PetsItemsPetItemDefinition7("nietoperek").getString("name", "Nietoperek");
    }
    
    public void deactivateEffect() {
        this.\u0147 = false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.\u013d == null || !entityDamageEvent.getEntity().equals((Object)this.\u013d)) {
            return;
        }
        if (entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.VOID) {
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u014a));
        }
    }
    
    private void PetsItemsPetItemDefinition10(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    static {
        \u0143 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
