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
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.HandlerList;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
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

public class F implements D, Listener
{
    private ArmorStand \u00d3;
    private ArmorStand \u00e4;
    private Player \u00d1;
    private final String \u00d2 = "paczus";
    private double \u00d5;
    private String \u00d0;
    private Date \u00e1;
    private static final SimpleDateFormat \u00d8;
    private boolean \u00df;
    private G \u00d9;
    private double \u00e0;
    private double \u00de;
    private double \u00dc;
    private boolean \u00d4;
    private int \u00e5;
    private boolean \u00e6;
    private int \u00da;
    private boolean \u00d6;
    private int \u00e3;
    private boolean \u00dd;
    private int \u00db;
    private boolean \u00e2;
    
    public F() {
        this.\u00d5 = 0.0;
        this.\u00df = false;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u00d9 = Main.getPetConfigManager();
        this.G();
    }
    
    private void G() {
        try {
            final Map<String, Object> d = this.\u00d9.D("paczus");
            if (d != null) {
                this.\u00de = (double)(d.containsKey("height") ? d.get("height") : 0.9);
                this.\u00e0 = (double)(d.containsKey("speed") ? d.get("speed") : 0.025);
                this.\u00dc = (double)(d.containsKey("distance") ? d.get("distance") : 1.0);
            }
            else {
                this.\u00de = 0.9;
                this.\u00e0 = 0.025;
                this.\u00dc = 1.0;
            }
            final Map<String, Object> d2 = this.\u00d9.D("paczus", "hunger");
            if (d2 != null) {
                this.\u00d4 = (!d2.containsKey("enabled") || (boolean)d2.get("enabled"));
                this.\u00e5 = (int)(d2.containsKey("level") ? d2.get("level") : 20);
                this.\u00e6 = (d2.containsKey("visible") && (boolean)d2.get("visible"));
            }
            else {
                this.\u00d4 = true;
                this.\u00e5 = 20;
                this.\u00e6 = false;
            }
            final Map<String, Object> d3 = this.\u00d9.D("paczus", "resistance");
            if (d3 != null) {
                this.\u00da = (int)(d3.containsKey("level") ? d3.get("level") : 2);
                this.\u00d6 = (d3.containsKey("visible") && (boolean)d3.get("visible"));
            }
            else {
                this.\u00da = 2;
                this.\u00d6 = false;
            }
            final Map<String, Object> d4 = this.\u00d9.D("paczus", "slow");
            if (d4 != null) {
                this.\u00e3 = (int)(d4.containsKey("level") ? d4.get("level") : 1);
                this.\u00dd = (d4.containsKey("visible") && (boolean)d4.get("visible"));
            }
            else {
                this.\u00e3 = 1;
                this.\u00dd = false;
            }
            final Map<String, Object> d5 = this.\u00d9.D("paczus", "regeneration");
            if (d5 != null) {
                this.\u00db = (int)(d5.containsKey("level") ? d5.get("level") : 1);
                this.\u00e2 = (d5.containsKey("visible") && (boolean)d5.get("visible"));
            }
            else {
                this.\u00db = 1;
                this.\u00e2 = false;
            }
        }
        catch (final Exception ex) {
            this.\u00de = 0.9;
            this.\u00e0 = 0.025;
            this.\u00dc = 1.0;
            this.\u00d4 = true;
            this.\u00e5 = 20;
            this.\u00e6 = false;
            this.\u00da = 2;
            this.\u00d6 = false;
            this.\u00e3 = 1;
            this.\u00dd = false;
            this.\u00db = 1;
            this.\u00e2 = false;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u00d1 != null && this.\u00d3 != null && this.\u00e4 != null) {
            this.\u00df = true;
            this.\u00d1.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00d3);
            this.\u00d1.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00e4);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u00d1 != null && this.\u00d3 != null && this.\u00e4 != null) {
            this.\u00df = false;
            this.\u00d1.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00d3);
            this.\u00d1.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00e4);
        }
    }
    
    @Override
    public void spawn(final Player \u00f1, final String s) {
        this.\u00d1 = \u00f1;
        this.\u00d0 = null;
        this.\u00e1 = null;
        final Location location = \u00f1.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u00dc));
        String string;
        if (this.\u00d9 != null) {
            final Object b = this.\u00d9.B("paczus", "item.texture.value");
            if (b instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u00d9.G("paczus").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTgxNzE3M2ZiMTJmMjYwZjc2NzAxNGMxMmQ4NWFhZTVlMjIyMmEwZTU0M2UzYTZmNjdkMTI0YmI1N2IzN2U2ZiJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTgxNzE3M2ZiMTJmMjYwZjc2NzAxNGMxMmQ4NWFhZTVlMjIyMmEwZTU0M2UzYTZmNjdkMTI0YmI1N2IzN2U2ZiJ9fX0=";
        }
        E.B(this.\u00d3 = (ArmorStand)\u00f1.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(G.C(this.\u00d9.L("paczus") + " &8\u25cf &f" + \u00f1.getName()));
            this.E(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u00f1.getUniqueId());
        final Map<String, Object> a = this.\u00d9.A("paczus");
        E.A(this.\u00e4 = (ArmorStand)\u00f1.getWorld().spawn(add.clone().add(0.0, (double)a.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(G.C(s + " &8\u25cf &f" + \u00f1.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u00f1.getUniqueId());
        if (this.\u00d4) {
            \u00f1.setFoodLevel(this.\u00e5);
            \u00f1.setSaturation((float)this.\u00e5);
        }
        if (this.\u00da > 0) {
            \u00f1.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, this.\u00da - 1, false, false, this.\u00d6));
        }
        if (this.\u00e3 > 0) {
            \u00f1.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, this.\u00e3 - 1, false, false, this.\u00dd));
        }
        if (this.\u00db > 0) {
            \u00f1.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999, this.\u00db - 1, false, false, this.\u00e2));
        }
    }
    
    @Override
    public void update() {
        if (this.\u00d1 == null || this.\u00d3 == null || this.\u00e4 == null || !this.\u00d1.isOnline()) {
            return;
        }
        if (this.\u00d4 && this.\u00d1.getFoodLevel() < this.\u00e5) {
            this.\u00d1.setFoodLevel(this.\u00e5);
            this.\u00d1.setSaturation((float)this.\u00e5);
        }
        final boolean hasPotionEffect = this.\u00d1.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u00d1.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u00dc));
        this.\u00d5 += this.\u00e0;
        final double n = this.\u00d5 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u00de) : ((2.0 - n) * this.\u00de), 0.0);
        add.setYaw(location.getYaw());
        this.\u00d3.teleport(add);
        this.\u00e4.teleport(add.clone().add(0.0, (double)this.\u00d9.A("paczus").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u00d1) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00d3);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00e4);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u00d1 || !this.\u00df) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00d3);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00e4);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u00d3 != null) {
            this.\u00d3.remove();
        }
        if (this.\u00e4 != null) {
            this.\u00e4.remove();
        }
        HandlerList.unregisterAll((Listener)this);
        if (this.\u00d1 != null && this.\u00d1.isOnline()) {
            if (this.\u00da > 0) {
                this.\u00d1.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
            }
            if (this.\u00e3 > 0) {
                this.\u00d1.removePotionEffect(PotionEffectType.SLOW);
            }
            if (this.\u00db > 0) {
                this.\u00d1.removePotionEffect(PotionEffectType.REGENERATION);
            }
            this.\u00d1.setSaturation(5.0f);
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.\u00d9.G("paczus").getString("name", "P\u0105czu\u015b");
    }
    
    @EventHandler
    public void onFoodLevelChange(final FoodLevelChangeEvent foodLevelChangeEvent) {
        if (this.\u00d1 != null && foodLevelChangeEvent.getEntity() instanceof Player && this.\u00d4) {
            final Player player = (Player)foodLevelChangeEvent.getEntity();
            if (player.getUniqueId().equals(this.\u00d1.getUniqueId()) && foodLevelChangeEvent.getFoodLevel() < player.getFoodLevel()) {
                foodLevelChangeEvent.setCancelled(true);
                player.setFoodLevel(this.\u00e5);
                player.setSaturation((float)this.\u00e5);
            }
        }
    }
    
    private void E(final SkullMeta skullMeta, final String s) {
        C.D(skullMeta, s);
    }
    
    public boolean isHungerEnabled() {
        return this.\u00d4;
    }
    
    public int getHungerLevel() {
        return this.\u00e5;
    }
    
    public boolean isHungerVisible() {
        return this.\u00e6;
    }
    
    public int getResistanceLevel() {
        return this.\u00da;
    }
    
    public boolean isResistanceVisible() {
        return this.\u00d6;
    }
    
    public int getSlowLevel() {
        return this.\u00e3;
    }
    
    public boolean isSlowVisible() {
        return this.\u00dd;
    }
    
    public int getRegenerationLevel() {
        return this.\u00db;
    }
    
    public boolean isRegenerationVisible() {
        return this.\u00e2;
    }
    
    static {
        \u00d8 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
