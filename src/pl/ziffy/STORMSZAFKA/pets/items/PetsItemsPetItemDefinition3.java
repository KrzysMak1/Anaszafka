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

public class PetsItemsPetItemDefinition3 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand PetsItemsPetItemDefinition29;
    private ArmorStand l;
    private Player PetsItemsPetItemDefinition26;
    private final String PetsItemsPetItemDefinition27 = "bobas";
    private double PetsItemsPetItemDefinition13;
    private String PetsItemsPetItemDefinition25;
    private Date k;
    private static final SimpleDateFormat c;
    private boolean i;
    private boolean f;
    private PetsItemsPetItemDefinition7 d;
    private double j;
    private double h;
    private double e;
    private double PetsItemsPetItemDefinition14;
    private double PetsItemsPetItemDefinition28;
    private boolean PetsItemsPetItemDefinition24;
    private static final UUID g;
    
    public PetsItemsPetItemDefinition3() {
        this.PetsItemsPetItemDefinition13 = 0.0;
        this.i = false;
        this.f = true;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.d = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition4();
    }
    
    private void PetsItemsPetItemDefinition4() {
        try {
            final Map<String, Object> d = this.d.PetsItemsPetItemDefinition4("bobas");
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
                this.PetsItemsPetItemDefinition14 = this.d.PetsItemsPetItemDefinition7("bobas").getDouble("bonuses.damage", 2.0);
                this.PetsItemsPetItemDefinition28 = this.d.PetsItemsPetItemDefinition7("bobas").getDouble("bonuses.health", 4.0);
                this.PetsItemsPetItemDefinition24 = this.d.PetsItemsPetItemDefinition7("bobas").getBoolean("bonuses.damage_visible", true);
            }
            else {
                this.PetsItemsPetItemDefinition14 = 2.0;
                this.PetsItemsPetItemDefinition28 = 4.0;
                this.PetsItemsPetItemDefinition24 = true;
            }
        }
        catch (final Exception ex) {
            this.h = 0.3;
            this.j = 0.05;
            this.e = 2.0;
            this.PetsItemsPetItemDefinition14 = 2.0;
            this.PetsItemsPetItemDefinition28 = 4.0;
            this.PetsItemsPetItemDefinition24 = true;
            ex.printStackTrace();
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.PetsItemsPetItemDefinition26 != null && this.PetsItemsPetItemDefinition29 != null && this.l != null) {
            this.i = true;
            this.PetsItemsPetItemDefinition26.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.PetsItemsPetItemDefinition29);
            this.PetsItemsPetItemDefinition26.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.l);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.PetsItemsPetItemDefinition26 != null && this.PetsItemsPetItemDefinition29 != null && this.l != null) {
            this.i = false;
            this.PetsItemsPetItemDefinition26.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.PetsItemsPetItemDefinition29);
            this.PetsItemsPetItemDefinition26.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.l);
        }
    }
    
    @Override
    public void spawn(final Player w, final String s) {
        this.PetsItemsPetItemDefinition26 = w;
        this.PetsItemsPetItemDefinition25 = null;
        this.k = null;
        final Location location = w.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.e));
        String string;
        if (this.d != null) {
            final Object PetsItemsPetItemDefinition14 = this.d.PetsItemsPetItemDefinition2("bobas", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s3) {
                string = s3;
            }
            else {
                final Object b2 = this.d.PetsItemsPetItemDefinition2("bobas", "texture.value");
                if (b2 instanceof final String s2) {
                    string = s2;
                }
                else {
                    string = this.d.PetsItemsPetItemDefinition7("bobas").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTQ2N2IyYThmY2E4YmQxNTljMmUxOTQ3OTQ3YmQxZDU2MmZiYzI3MTZlZmVlNDhkNTU3OTRmZTUzNWVmYmEifX19");
                }
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTQ2N2IyYThmY2E4YmQxNTljMmUxOTQ3OTQ3YmQxZDU2MmZiYzI3MTZlZmVlNDhkNTU3OTRmZTUzNWVmYmEifX19";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.PetsItemsPetItemDefinition29 = (ArmorStand)w.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.d.PetsItemsPetItemDefinition12("bobas") + " &8\u25cf &f" + w.getName()));
            this.PetsItemsPetItemDefinition2(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), w.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.d.PetsItemsPetItemDefinition1("bobas");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.l = (ArmorStand)w.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + w.getName()));
            armorStand.setCustomNameVisible(true);
        }), w.getUniqueId());
        this.PetsItemsPetItemDefinition3();
        w.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999, 0, false, false));
    }
    
    @Override
    public void update() {
        if (this.PetsItemsPetItemDefinition26 == null || this.PetsItemsPetItemDefinition29 == null || this.l == null || !this.PetsItemsPetItemDefinition26.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.PetsItemsPetItemDefinition26.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.PetsItemsPetItemDefinition26.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.e));
        this.PetsItemsPetItemDefinition13 += this.j;
        final double n = this.PetsItemsPetItemDefinition13 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.h) : ((2.0 - n) * this.h), 0.0);
        add.setYaw(location.getYaw());
        this.PetsItemsPetItemDefinition29.teleport(add);
        this.l.teleport(add.clone().add(0.0, (double)this.d.PetsItemsPetItemDefinition1("bobas").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.PetsItemsPetItemDefinition26) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.PetsItemsPetItemDefinition29);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.l);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.PetsItemsPetItemDefinition26 || !this.i) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.PetsItemsPetItemDefinition29);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.l);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.PetsItemsPetItemDefinition29 != null) {
            this.PetsItemsPetItemDefinition29.remove();
        }
        if (this.l != null) {
            this.l.remove();
        }
        this.PetsItemsPetItemDefinition2();
        this.PetsItemsPetItemDefinition26.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
        this.deactivateEffect();
    }
    
    @Override
    public String getDisplayName() {
        return this.d.PetsItemsPetItemDefinition7("bobas").getString("name", "Bobas");
    }
    
    public void deactivateEffect() {
        this.f = false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (!this.f) {
            return;
        }
        if (entityDamageByEntityEvent.getDamager() instanceof Player && ((Player)entityDamageByEntityEvent.getDamager()).equals((Object)this.PetsItemsPetItemDefinition26)) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() + this.PetsItemsPetItemDefinition14);
            if (this.PetsItemsPetItemDefinition24) {}
        }
        if (entityDamageByEntityEvent.getEntity() instanceof Player && ((Player)entityDamageByEntityEvent.getEntity()).equals((Object)this.PetsItemsPetItemDefinition26)) {
            final ItemStack itemStack = (entityDamageByEntityEvent.getDamager() instanceof Player) ? ((Player)entityDamageByEntityEvent.getDamager()).getInventory().getItemInMainHand() : null;
            if (itemStack != null && this.PetsItemsPetItemDefinition1(itemStack.getType())) {
                final double damage = entityDamageByEntityEvent.getDamage();
                entityDamageByEntityEvent.setDamage(damage - damage * 0.1);
                if (this.PetsItemsPetItemDefinition24) {}
            }
        }
    }
    
    private boolean PetsItemsPetItemDefinition1(final Material material) {
        return material == Material.WOODEN_SWORD || material == Material.STONE_SWORD || material == Material.IRON_SWORD || material == Material.GOLDEN_SWORD || material == Material.DIAMOND_SWORD || material == Material.NETHERITE_SWORD;
    }
    
    private void PetsItemsPetItemDefinition3() {
        if (this.PetsItemsPetItemDefinition26 != null && !this.PetsItemsPetItemDefinition26.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().anyMatch(attributeModifier -> attributeModifier.getUniqueId().equals(PetsItemsPetItemDefinition3.g))) {
            this.PetsItemsPetItemDefinition26.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier(PetsItemsPetItemDefinition3.g, "BobasHealthBonus", this.PetsItemsPetItemDefinition28, AttributeModifier.Operation.ADD_NUMBER));
            this.PetsItemsPetItemDefinition26.setHealth(Math.min(this.PetsItemsPetItemDefinition26.getHealth() + this.PetsItemsPetItemDefinition28, this.PetsItemsPetItemDefinition26.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
        }
    }
    
    private void PetsItemsPetItemDefinition2() {
        if (this.PetsItemsPetItemDefinition26 != null) {
            for (final AttributeModifier attributeModifier : this.PetsItemsPetItemDefinition26.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers()) {
                if (attributeModifier.getUniqueId().equals(PetsItemsPetItemDefinition3.g)) {
                    this.PetsItemsPetItemDefinition26.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier);
                    break;
                }
            }
            final double value = this.PetsItemsPetItemDefinition26.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            if (this.PetsItemsPetItemDefinition26.getHealth() > value) {
                this.PetsItemsPetItemDefinition26.setHealth(value);
            }
        }
    }
    
    private void PetsItemsPetItemDefinition2(final SkullMeta skullMeta, final String s) {
        pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    static {
        c = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        g = UUID.fromString("bbbbaaaa-cccc-dddd-eeee-fffffffffaaa");
    }
}
