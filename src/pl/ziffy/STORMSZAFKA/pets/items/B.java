// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.utils.C;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPotionEffectEvent;
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
import java.util.UUID;
import pl.ziffy.STORMSZAFKA.pets.G;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.D;

public class B implements D, Listener
{
    private ArmorStand D;
    private ArmorStand U;
    private Player B;
    private final String C = "pajak";
    private double F;
    private String A;
    private Date T;
    private static final SimpleDateFormat J;
    private boolean R;
    private G K;
    private static final UUID P;
    private double S;
    private double Q;
    private double M;
    private int I;
    private boolean H;
    private int G;
    private boolean N;
    private boolean L;
    private boolean E;
    private boolean O;
    
    public B() {
        this.F = 0.0;
        this.R = false;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.K = Main.getPetConfigManager();
        this.A();
    }
    
    private void A() {
        try {
            final Map<String, Object> d = this.K.D("pajak");
            if (d != null) {
                this.Q = (double)(d.containsKey("height") ? d.get("height") : 1.0);
                this.S = (double)(d.containsKey("speed") ? d.get("speed") : 0.025);
                this.M = (double)(d.containsKey("distance") ? d.get("distance") : 1.0);
            }
            else {
                this.Q = 1.0;
                this.S = 0.025;
                this.M = 1.0;
            }
            final Map<String, Object> d2 = this.K.D("pajak", "jump");
            if (d2 != null) {
                this.I = (int)(d2.containsKey("level") ? d2.get("level") : 1);
                this.H = (d2.containsKey("visible") && (boolean)d2.get("visible"));
            }
            else {
                this.I = 1;
                this.H = false;
            }
            final Map<String, Object> d3 = this.K.D("pajak", "speed");
            if (d3 != null) {
                this.G = (int)(d3.containsKey("level") ? d3.get("level") : 0);
                this.N = (d3.containsKey("visible") && (boolean)d3.get("visible"));
            }
            else {
                this.G = 0;
                this.N = false;
            }
            final Map<String, Object> d4 = this.K.D("pajak", "hunger_protection");
            if (d4 != null) {
                this.L = (!d4.containsKey("enabled") || (boolean)d4.get("enabled"));
            }
            else {
                this.L = true;
            }
            final Map<String, Object> d5 = this.K.D("pajak", "negative_effects_protection");
            if (d5 != null) {
                this.E = (!d5.containsKey("enabled") || (boolean)d5.get("enabled"));
            }
            else {
                this.E = true;
            }
            final Map<String, Object> d6 = this.K.D("pajak", "fall_damage_protection");
            if (d6 != null) {
                this.O = (!d6.containsKey("enabled") || (boolean)d6.get("enabled"));
            }
            else {
                this.O = true;
            }
        }
        catch (final Exception ex) {
            this.Q = 1.0;
            this.S = 0.025;
            this.M = 1.0;
            this.I = 1;
            this.H = false;
            this.G = 0;
            this.N = false;
            this.L = true;
            this.E = true;
            this.O = true;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.B != null && this.D != null && this.U != null) {
            this.R = true;
            this.B.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.D);
            this.B.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.U);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.B != null && this.D != null && this.U != null) {
            this.R = false;
            this.B.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.D);
            this.B.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.U);
        }
    }
    
    @Override
    public void spawn(final Player b, final String s) {
        this.B = b;
        this.A = null;
        this.T = null;
        final Location location = b.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.M));
        String string;
        if (this.K != null) {
            final Object b2 = this.K.B("pajak", "item.texture.value");
            if (b2 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.K.G("pajak").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmYWM1Zjc0NDg1YmM5Y2VlODdkNmY4MmE3ZWUwZWM0ZjY2OWM2MGY0MjVkNDliM2VlNTNiOWU2YzU4MzAifX19");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmYWM1Zjc0NDg1YmM5Y2VlODdkNmY4MmE3ZWUwZWM0ZjY2OWM2MGY0MjVkNDliM2VlNTNiOWU2YzU4MzAifX19";
        }
        pl.ziffy.STORMSZAFKA.pets.E.B(this.D = (ArmorStand)b.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(pl.ziffy.STORMSZAFKA.pets.G.C(this.K.L("pajak") + " &8\u25cf &f" + b.getName()));
            this.A(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), b.getUniqueId());
        final Map<String, Object> a = this.K.A("pajak");
        pl.ziffy.STORMSZAFKA.pets.E.A(this.U = (ArmorStand)b.getWorld().spawn(add.clone().add(0.0, (double)a.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(pl.ziffy.STORMSZAFKA.pets.G.C(s + " &8\u25cf &f" + b.getName()));
            armorStand.setCustomNameVisible(true);
        }), b.getUniqueId());
        if (this.L) {
            b.setFoodLevel(20);
            b.setSaturation(20.0f);
        }
        b.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, this.I - 1, false, this.H, true));
        b.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.G - 1, false, this.N, true));
    }
    
    @Override
    public void update() {
        if (this.B == null || this.D == null || this.U == null || !this.B.isOnline()) {
            return;
        }
        if (!this.B.hasPotionEffect(PotionEffectType.JUMP)) {
            this.B.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, this.I - 1, false, this.H, true));
        }
        if (!this.B.hasPotionEffect(PotionEffectType.SPEED)) {
            this.B.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.G - 1, false, this.N, true));
        }
        if (this.L && this.B.getFoodLevel() < 20) {
            this.B.setFoodLevel(20);
            this.B.setSaturation(20.0f);
        }
        final boolean hasPotionEffect = this.B.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.B.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.M));
        this.F += this.S;
        final double n = this.F % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.Q) : ((2.0 - n) * this.Q), 0.0);
        add.setYaw(location.getYaw());
        this.D.teleport(add);
        this.U.teleport(add.clone().add(0.0, (double)this.K.A("pajak").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.B) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.D);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.U);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.B || !this.R) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.D);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.U);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.D != null) {
            this.D.remove();
        }
        if (this.U != null) {
            this.U.remove();
        }
        HandlerList.unregisterAll((Listener)this);
        if (this.B != null && this.B.isOnline()) {
            this.B.removePotionEffect(PotionEffectType.JUMP);
            this.B.removePotionEffect(PotionEffectType.SPEED);
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.K.G("pajak").getString("name", "Paj\u0105k");
    }
    
    @EventHandler
    public void onPotionEffect(final EntityPotionEffectEvent entityPotionEffectEvent) {
        if (!this.E) {
            return;
        }
        if (this.B != null && entityPotionEffectEvent.getEntity().getUniqueId().equals(this.B.getUniqueId()) && (entityPotionEffectEvent.getAction() == EntityPotionEffectEvent.Action.ADDED || entityPotionEffectEvent.getAction() == EntityPotionEffectEvent.Action.CHANGED)) {
            final PotionEffectType modifiedType = entityPotionEffectEvent.getModifiedType();
            if (modifiedType.equals((Object)PotionEffectType.POISON) || modifiedType.equals((Object)PotionEffectType.WITHER) || modifiedType.equals((Object)PotionEffectType.HUNGER) || modifiedType.equals((Object)PotionEffectType.WEAKNESS) || modifiedType.equals((Object)PotionEffectType.SLOW) || modifiedType.equals((Object)PotionEffectType.SLOW_DIGGING) || modifiedType.equals((Object)PotionEffectType.CONFUSION) || modifiedType.equals((Object)PotionEffectType.BLINDNESS) || modifiedType.equals((Object)PotionEffectType.HARM)) {
                entityPotionEffectEvent.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (!this.O) {
            return;
        }
        if (this.B != null && entityDamageEvent.getEntity() instanceof Player && ((Player)entityDamageEvent.getEntity()).getUniqueId().equals(this.B.getUniqueId()) && entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALL) {
            entityDamageEvent.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onFoodLevelChange(final FoodLevelChangeEvent foodLevelChangeEvent) {
        if (!this.L) {
            return;
        }
        if (this.B != null && foodLevelChangeEvent.getEntity() instanceof Player) {
            final Player player = (Player)foodLevelChangeEvent.getEntity();
            if (player.getUniqueId().equals(this.B.getUniqueId()) && foodLevelChangeEvent.getFoodLevel() < player.getFoodLevel()) {
                foodLevelChangeEvent.setCancelled(true);
                player.setFoodLevel(20);
                player.setSaturation(20.0f);
            }
        }
    }
    
    private void A(final SkullMeta skullMeta, final String s) {
        pl.ziffy.STORMSZAFKA.utils.C.D(skullMeta, s);
    }
    
    public int getJumpLevel() {
        return this.I;
    }
    
    public boolean isJumpEffectVisible() {
        return this.H;
    }
    
    public int getSpeedLevel() {
        return this.G;
    }
    
    public boolean isSpeedEffectVisible() {
        return this.N;
    }
    
    public boolean isHungerProtectionEnabled() {
        return this.L;
    }
    
    public boolean isNegativeEffectsProtectionEnabled() {
        return this.E;
    }
    
    public boolean isFallDamageProtectionEnabled() {
        return this.O;
    }
    
    static {
        J = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        P = UUID.fromString("55555555-6666-7777-8888-999999999999");
    }
}
