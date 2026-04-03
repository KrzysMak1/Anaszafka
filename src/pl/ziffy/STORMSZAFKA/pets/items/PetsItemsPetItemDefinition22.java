// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.HandlerList;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition5;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Bukkit;
import java.util.UUID;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition7;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition4;

public class PetsItemsPetItemDefinition22 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand \u01fd;
    private ArmorStand \u020b;
    private Player \u01fa;
    private final String \u01fc = "duszek";
    private double \u01fe;
    private String \u01f5;
    private Date \u020a;
    private static final SimpleDateFormat \u01ff;
    private boolean \u0208;
    private boolean \u0205;
    private PetsItemsPetItemDefinition7 \u0200;
    private double \u0209;
    private double \u0207;
    private double \u0203;
    private int \u0201;
    private boolean \u0202;
    private double \u0204;
    private double \u01fb;
    private static final UUID \u0206;
    
    public PetsItemsPetItemDefinition22() {
        this.\u01fe = 0.0;
        this.\u0208 = false;
        this.\u0205 = true;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u0200 = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition25();
    }
    
    private void PetsItemsPetItemDefinition25() {
        final Map<String, Object> d = this.\u0200.PetsItemsPetItemDefinition4("duszek");
        this.\u0207 = (double)d.get("height");
        this.\u0209 = (double)d.get("speed");
        this.\u0203 = (double)d.get("distance");
        final Map<String, Object> d2 = this.\u0200.PetsItemsPetItemDefinition4("duszek", "speed");
        this.\u0201 = (int)d2.get("level");
        this.\u0202 = (boolean)d2.get("visible");
        final Map<String, Object> d3 = this.\u0200.PetsItemsPetItemDefinition4("duszek", "dripstone_protection");
        this.\u0204 = (double)(d3.containsKey("reduction") ? d3.get("reduction") : 0.5);
        final Map<String, Object> d4 = this.\u0200.PetsItemsPetItemDefinition4("duszek", "health");
        this.\u01fb = (double)(d4.containsKey("bonus") ? d4.get("bonus") : 2.0);
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u01fa != null && this.\u01fd != null && this.\u020b != null) {
            this.\u0208 = true;
            this.\u01fa.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01fd);
            this.\u01fa.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u020b);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u01fa != null && this.\u01fd != null && this.\u020b != null) {
            this.\u0208 = false;
            this.\u01fa.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01fd);
            this.\u01fa.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u020b);
        }
    }
    
    @Override
    public void spawn(final Player \u01fb, final String s) {
        this.\u01fa = \u01fb;
        this.\u01f5 = null;
        this.\u020a = null;
        final Location location = \u01fb.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0203));
        String string;
        if (this.\u0200 != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u0200.PetsItemsPetItemDefinition2("duszek", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u0200.PetsItemsPetItemDefinition7("duszek").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWFhMWE2MTk5NjBhYzY4NjBjYjVjOWI2ZDNjODg3NDVkNmVmNjQwMzAwOWFmNWJhMGQwODM4Yjg3YjEyZGYwNCJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWFhMWE2MTk5NjBhYzY4NjBjYjVjOWI2ZDNjODg3NDVkNmVmNjQwMzAwOWFmNWJhMGQwODM4Yjg3YjEyZGYwNCJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u01fd = (ArmorStand)\u01fb.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u0200.PetsItemsPetItemDefinition12("duszek") + " &8\u25cf &f" + \u01fb.getName()));
            this.PetsItemsPetItemDefinition21(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u01fb.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u0200.PetsItemsPetItemDefinition1("duszek");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u020b = (ArmorStand)\u01fb.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u01fb.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u01fb.getUniqueId());
        \u01fb.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u0201 - 1, false, this.\u0202));
        try {
            \u01fb.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().filter(attributeModifier -> attributeModifier.getUniqueId().equals(PetsItemsPetItemDefinition22.\u0206)).forEach(attributeModifier2 -> player.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier2));
            \u01fb.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier(PetsItemsPetItemDefinition22.\u0206, "duszek_health_bonus", this.\u01fb, AttributeModifier.Operation.ADD_NUMBER));
            \u01fb.setHealth(Math.min(\u01fb.getHealth() + this.\u01fb, \u01fb.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        }
        catch (final Exception ex) {}
    }
    
    @Override
    public void update() {
        if (this.\u01fa == null || this.\u01fd == null || this.\u020b == null || !this.\u01fa.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u01fa.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u01fa.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0203));
        this.\u01fe += this.\u0209;
        final double n = this.\u01fe % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u0207) : ((2.0 - n) * this.\u0207), 0.0);
        add.setYaw(location.getYaw());
        this.\u01fd.teleport(add);
        this.\u020b.teleport(add.clone().add(0.0, (double)this.\u0200.PetsItemsPetItemDefinition1("duszek").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u01fa) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01fd);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u020b);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u01fa || !this.\u0208) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01fd);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u020b);
                }
            }
        }
        if (this.\u0205 && !this.\u01fa.hasPotionEffect(PotionEffectType.SPEED)) {
            this.\u01fa.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u0201 - 1, false, this.\u0202));
        }
    }
    
    @Override
    public void remove() {
        if (this.\u01fd != null) {
            this.\u01fd.remove();
        }
        if (this.\u020b != null) {
            this.\u020b.remove();
        }
        if (this.\u01fa != null && this.\u01fa.isOnline()) {
            this.\u01fa.removePotionEffect(PotionEffectType.SPEED);
        }
        try {
            if (this.\u01fa != null && this.\u01fa.isOnline()) {
                this.\u01fa.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().filter(attributeModifier -> attributeModifier.getUniqueId().equals(PetsItemsPetItemDefinition22.\u0206)).forEach(attributeModifier2 -> this.\u01fa.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier2));
                if (this.\u01fa.getHealth() > this.\u01fa.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
                    this.\u01fa.setHealth(this.\u01fa.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                }
            }
        }
        catch (final Exception ex) {}
        HandlerList.unregisterAll((Listener)this);
    }
    
    @Override
    public String getDisplayName() {
        return this.\u0200.PetsItemsPetItemDefinition7("duszek").getString("name", "Duszek");
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.\u01fa == null || !entityDamageEvent.getEntity().equals((Object)this.\u01fa)) {
            return;
        }
        if (entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALLING_BLOCK) {
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u0204));
        }
    }
    
    @EventHandler
    public void onFoodLevelChange(final FoodLevelChangeEvent foodLevelChangeEvent) {
        if (this.\u01fa == null || !foodLevelChangeEvent.getEntity().equals((Object)this.\u01fa)) {
            return;
        }
        if (foodLevelChangeEvent.getFoodLevel() < ((Player)foodLevelChangeEvent.getEntity()).getFoodLevel()) {
            foodLevelChangeEvent.setCancelled(true);
        }
    }
    
    private void PetsItemsPetItemDefinition21(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    static {
        \u01ff = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        \u0206 = UUID.fromString("cccccccc-dddd-eeee-ffff-aaaaaaaaaa00");
    }
}
