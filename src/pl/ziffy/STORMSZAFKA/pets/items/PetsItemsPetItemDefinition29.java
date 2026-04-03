// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.HandlerList;
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
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition4;

public class PetsItemsPetItemDefinition29 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand \u02a8;
    private ArmorStand \u02c0;
    private Player \u02a6;
    private final String \u02a7 = "enderman";
    private double \u02b2;
    private String \u02a4;
    private Date \u02bf;
    private static final SimpleDateFormat \u02b3;
    private boolean \u02bd;
    private boolean \u02bb;
    private Random \u02a5;
    private PetsItemsPetItemDefinition7 \u02b4;
    private double \u02be;
    private double \u02bc;
    private double \u02b8;
    private int \u02b5;
    private boolean \u02b0;
    private int \u02b7;
    private double \u02b6;
    private boolean \u02b1;
    
    public PetsItemsPetItemDefinition29() {
        this.\u02b2 = 0.0;
        this.\u02bd = false;
        this.\u02bb = true;
        this.\u02a5 = new Random();
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u02b4 = Main.getPetConfigManager();
        this.c();
    }
    
    private void c() {
        try {
            final Map<String, Object> d = this.\u02b4.PetsItemsPetItemDefinition4("enderman");
            if (d != null) {
                final Object value = d.get("height");
                final Object value2 = d.get("speed");
                final Object value3 = d.get("distance");
                this.\u02bc = ((value instanceof Number) ? ((Number)value).doubleValue() : 1.0);
                this.\u02be = ((value2 instanceof Number) ? ((Number)value2).doubleValue() : 0.025);
                this.\u02b8 = ((value3 instanceof Number) ? ((Number)value3).doubleValue() : 1.0);
            }
            else {
                this.\u02bc = 1.0;
                this.\u02be = 0.025;
                this.\u02b8 = 1.0;
            }
            final Map<String, Object> d2 = this.\u02b4.PetsItemsPetItemDefinition4("enderman", "damage");
            if (d2 != null) {
                final Object value4 = d2.get("increase");
                final Object value5 = d2.get("visible");
                this.\u02b5 = ((value4 instanceof Number) ? ((Number)value4).intValue() : 3);
                this.\u02b0 = (!(value5 instanceof Boolean) || (boolean)value5);
            }
            else {
                this.\u02b5 = 3;
                this.\u02b0 = true;
            }
            final Map<String, Object> d3 = this.\u02b4.PetsItemsPetItemDefinition4("enderman", "pearl");
            if (d3 != null) {
                final Object value6 = d3.get("bonus");
                final Object value7 = d3.get("looting_bonus");
                final Object value8 = d3.get("visible");
                this.\u02b7 = ((value6 instanceof Number) ? ((Number)value6).intValue() : 1);
                this.\u02b6 = ((value7 instanceof Number) ? ((Number)value7).doubleValue() : 0.1);
                this.\u02b1 = (!(value8 instanceof Boolean) || (boolean)value8);
            }
            else {
                this.\u02b7 = 1;
                this.\u02b6 = 0.1;
                this.\u02b1 = true;
            }
        }
        catch (final Exception ex) {
            this.\u02bc = 1.0;
            this.\u02be = 0.025;
            this.\u02b8 = 1.0;
            this.\u02b5 = 3;
            this.\u02b0 = true;
            this.\u02b7 = 1;
            this.\u02b6 = 0.1;
            this.\u02b1 = true;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u02a6 != null && this.\u02a8 != null && this.\u02c0 != null) {
            this.\u02bd = true;
            this.\u02a6.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u02a8);
            this.\u02a6.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u02c0);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u02a6 != null && this.\u02a8 != null && this.\u02c0 != null) {
            this.\u02bd = false;
            this.\u02a6.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u02a8);
            this.\u02a6.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u02c0);
        }
    }
    
    @Override
    public void spawn(final Player \u02a6, final String s) {
        this.\u02a6 = \u02a6;
        this.\u02a4 = null;
        this.\u02bf = null;
        final Location location = \u02a6.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u02b8));
        String string;
        if (this.\u02b4 != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u02b4.PetsItemsPetItemDefinition2("enderman", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u02b4.PetsItemsPetItemDefinition7("enderman").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmE2NDlhM2QxYWFlODgwYWNjYzQ3M2M2YzE1YTYzZWU1Y2IwMGYwNjAzMTkzZmM5ZjdjYzkxODdkODAzNmM3ZSJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmE2NDlhM2QxYWFlODgwYWNjYzQ3M2M2YzE1YTYzZWU1Y2IwMGYwNjAzMTkzZmM5ZjdjYzkxODdkODAzNmM3ZSJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u02a8 = (ArmorStand)\u02a6.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u02b4.PetsItemsPetItemDefinition12("enderman") + " &8\u25cf &f" + \u02a6.getName()));
            this.PetsItemsPetItemDefinition28(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u02a6.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u02b4.PetsItemsPetItemDefinition1("enderman");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u02c0 = (ArmorStand)\u02a6.getWorld().spawn(add.clone().add(0.0, (PetsItemsPetItemDefinition13 != null && PetsItemsPetItemDefinition13.get("height") instanceof Number) ? ((Number)PetsItemsPetItemDefinition13.get("height")).doubleValue() : 2.0, 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u02a6.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u02a6.getUniqueId());
    }
    
    @Override
    public void update() {
        if (this.\u02a6 == null || this.\u02a8 == null || this.\u02c0 == null || !this.\u02a6.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u02a6.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u02a6.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u02b8));
        this.\u02b2 += this.\u02be;
        final double n = this.\u02b2 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u02bc) : ((2.0 - n) * this.\u02bc), 0.0);
        add.setYaw(location.getYaw());
        this.\u02a8.teleport(add);
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u02b4.PetsItemsPetItemDefinition1("enderman");
        this.\u02c0.teleport(add.clone().add(0.0, (PetsItemsPetItemDefinition13 != null && PetsItemsPetItemDefinition13.get("height") instanceof Number) ? ((Number)PetsItemsPetItemDefinition13.get("height")).doubleValue() : 2.0, 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u02a6) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u02a8);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u02c0);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u02a6 || !this.\u02bd) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u02a8);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u02c0);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u02a8 != null) {
            this.\u02a8.remove();
        }
        if (this.\u02c0 != null) {
            this.\u02c0.remove();
        }
        HandlerList.unregisterAll((Listener)this);
        this.deactivateEffect();
    }
    
    @Override
    public String getDisplayName() {
        return this.\u02b4.PetsItemsPetItemDefinition7("enderman").getString("name", "Enderman");
    }
    
    public void deactivateEffect() {
        this.\u02bb = false;
    }
    
    @EventHandler
    public void onEntityDeath(final EntityDeathEvent entityDeathEvent) {
        if (this.\u02a6 == null || !this.\u02bb) {
            return;
        }
        if (entityDeathEvent.getEntity().getKiller() != null && entityDeathEvent.getEntity().getKiller().equals((Object)this.\u02a6) && entityDeathEvent.getEntityType() == EntityType.ENDERMAN) {
            int enchantmentLevel = 0;
            if (this.\u02a6.getInventory().getItemInMainHand() != null) {
                enchantmentLevel = this.\u02a6.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
            }
            int \u02b7 = this.\u02b7;
            if (enchantmentLevel > 0) {
                for (int i = 0; i < enchantmentLevel; ++i) {
                    if (this.\u02a5.nextDouble() <= this.\u02b6) {
                        ++\u02b7;
                    }
                }
            }
            entityDeathEvent.getDrops().add(new ItemStack(Material.ENDER_PEARL, \u02b7));
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (this.\u02a6 != null && entityDamageByEntityEvent.getDamager() instanceof Player && this.\u02bb && ((Player)entityDamageByEntityEvent.getDamager()).getUniqueId().equals(this.\u02a6.getUniqueId())) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() + this.\u02b5);
        }
    }
    
    private void PetsItemsPetItemDefinition28(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    public int getDamageIncrease() {
        return this.\u02b5;
    }
    
    public boolean isDamageEffectVisible() {
        return this.\u02b0;
    }
    
    public int getPearlBonus() {
        return this.\u02b7;
    }
    
    public double getPearlLootingBonus() {
        return this.\u02b6;
    }
    
    public boolean isPearlBonusVisible() {
        return this.\u02b1;
    }
    
    static {
        \u02b3 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
