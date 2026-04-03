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
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPotionEffectEvent;
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
import java.util.UUID;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition7;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition4;

public class PetsItemsPetItemDefinition2 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand PetsItemsPetItemDefinition4;
    private ArmorStand PetsItemsPetItemDefinition23;
    private Player PetsItemsPetItemDefinition2;
    private final String PetsItemsPetItemDefinition3 = "pajak";
    private double PetsItemsPetItemDefinition6;
    private String PetsItemsPetItemDefinition1;
    private Date PetsItemsPetItemDefinition22;
    private static final SimpleDateFormat PetsItemsPetItemDefinition10;
    private boolean PetsItemsPetItemDefinition20;
    private PetsItemsPetItemDefinition7 PetsItemsPetItemDefinition11;
    private static final UUID PetsItemsPetItemDefinition18;
    private double PetsItemsPetItemDefinition21;
    private double PetsItemsPetItemDefinition19;
    private double PetsItemsPetItemDefinition15;
    private int PetsItemsPetItemDefinition9;
    private boolean PetsItemsPetItemDefinition8;
    private int PetsItemsPetItemDefinition7;
    private boolean PetsItemsPetItemDefinition16;
    private boolean PetsItemsPetItemDefinition12;
    private boolean PetsItemsPetItemDefinition5;
    private boolean PetsItemsPetItemDefinition17;
    
    public PetsItemsPetItemDefinition2() {
        this.PetsItemsPetItemDefinition6 = 0.0;
        this.PetsItemsPetItemDefinition20 = false;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.PetsItemsPetItemDefinition11 = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition1();
    }
    
    private void PetsItemsPetItemDefinition1() {
        try {
            final Map<String, Object> d = this.PetsItemsPetItemDefinition11.PetsItemsPetItemDefinition4("pajak");
            if (d != null) {
                this.PetsItemsPetItemDefinition19 = (double)(d.containsKey("height") ? d.get("height") : 1.0);
                this.PetsItemsPetItemDefinition21 = (double)(d.containsKey("speed") ? d.get("speed") : 0.025);
                this.PetsItemsPetItemDefinition15 = (double)(d.containsKey("distance") ? d.get("distance") : 1.0);
            }
            else {
                this.PetsItemsPetItemDefinition19 = 1.0;
                this.PetsItemsPetItemDefinition21 = 0.025;
                this.PetsItemsPetItemDefinition15 = 1.0;
            }
            final Map<String, Object> d2 = this.PetsItemsPetItemDefinition11.PetsItemsPetItemDefinition4("pajak", "jump");
            if (d2 != null) {
                this.PetsItemsPetItemDefinition9 = (int)(d2.containsKey("level") ? d2.get("level") : 1);
                this.PetsItemsPetItemDefinition8 = (d2.containsKey("visible") && (boolean)d2.get("visible"));
            }
            else {
                this.PetsItemsPetItemDefinition9 = 1;
                this.PetsItemsPetItemDefinition8 = false;
            }
            final Map<String, Object> d3 = this.PetsItemsPetItemDefinition11.PetsItemsPetItemDefinition4("pajak", "speed");
            if (d3 != null) {
                this.PetsItemsPetItemDefinition7 = (int)(d3.containsKey("level") ? d3.get("level") : 0);
                this.PetsItemsPetItemDefinition16 = (d3.containsKey("visible") && (boolean)d3.get("visible"));
            }
            else {
                this.PetsItemsPetItemDefinition7 = 0;
                this.PetsItemsPetItemDefinition16 = false;
            }
            final Map<String, Object> d4 = this.PetsItemsPetItemDefinition11.PetsItemsPetItemDefinition4("pajak", "hunger_protection");
            if (d4 != null) {
                this.PetsItemsPetItemDefinition12 = (!d4.containsKey("enabled") || (boolean)d4.get("enabled"));
            }
            else {
                this.PetsItemsPetItemDefinition12 = true;
            }
            final Map<String, Object> d5 = this.PetsItemsPetItemDefinition11.PetsItemsPetItemDefinition4("pajak", "negative_effects_protection");
            if (d5 != null) {
                this.PetsItemsPetItemDefinition5 = (!d5.containsKey("enabled") || (boolean)d5.get("enabled"));
            }
            else {
                this.PetsItemsPetItemDefinition5 = true;
            }
            final Map<String, Object> d6 = this.PetsItemsPetItemDefinition11.PetsItemsPetItemDefinition4("pajak", "fall_damage_protection");
            if (d6 != null) {
                this.PetsItemsPetItemDefinition17 = (!d6.containsKey("enabled") || (boolean)d6.get("enabled"));
            }
            else {
                this.PetsItemsPetItemDefinition17 = true;
            }
        }
        catch (final Exception ex) {
            this.PetsItemsPetItemDefinition19 = 1.0;
            this.PetsItemsPetItemDefinition21 = 0.025;
            this.PetsItemsPetItemDefinition15 = 1.0;
            this.PetsItemsPetItemDefinition9 = 1;
            this.PetsItemsPetItemDefinition8 = false;
            this.PetsItemsPetItemDefinition7 = 0;
            this.PetsItemsPetItemDefinition16 = false;
            this.PetsItemsPetItemDefinition12 = true;
            this.PetsItemsPetItemDefinition5 = true;
            this.PetsItemsPetItemDefinition17 = true;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.PetsItemsPetItemDefinition2 != null && this.PetsItemsPetItemDefinition4 != null && this.PetsItemsPetItemDefinition23 != null) {
            this.PetsItemsPetItemDefinition20 = true;
            this.PetsItemsPetItemDefinition2.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.PetsItemsPetItemDefinition4);
            this.PetsItemsPetItemDefinition2.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.PetsItemsPetItemDefinition23);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.PetsItemsPetItemDefinition2 != null && this.PetsItemsPetItemDefinition4 != null && this.PetsItemsPetItemDefinition23 != null) {
            this.PetsItemsPetItemDefinition20 = false;
            this.PetsItemsPetItemDefinition2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.PetsItemsPetItemDefinition4);
            this.PetsItemsPetItemDefinition2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.PetsItemsPetItemDefinition23);
        }
    }
    
    @Override
    public void spawn(final Player PetsItemsPetItemDefinition14, final String s) {
        this.PetsItemsPetItemDefinition2 = PetsItemsPetItemDefinition14;
        this.PetsItemsPetItemDefinition1 = null;
        this.PetsItemsPetItemDefinition22 = null;
        final Location location = PetsItemsPetItemDefinition14.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.PetsItemsPetItemDefinition15));
        String string;
        if (this.PetsItemsPetItemDefinition11 != null) {
            final Object b2 = this.PetsItemsPetItemDefinition11.PetsItemsPetItemDefinition2("pajak", "item.texture.value");
            if (b2 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.PetsItemsPetItemDefinition11.PetsItemsPetItemDefinition7("pajak").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmYWM1Zjc0NDg1YmM5Y2VlODdkNmY4MmE3ZWUwZWM0ZjY2OWM2MGY0MjVkNDliM2VlNTNiOWU2YzU4MzAifX19");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzNmYWM1Zjc0NDg1YmM5Y2VlODdkNmY4MmE3ZWUwZWM0ZjY2OWM2MGY0MjVkNDliM2VlNTNiOWU2YzU4MzAifX19";
        }
        pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.PetsItemsPetItemDefinition4 = (ArmorStand)PetsItemsPetItemDefinition14.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.PetsItemsPetItemDefinition11.PetsItemsPetItemDefinition12("pajak") + " &8\u25cf &f" + PetsItemsPetItemDefinition14.getName()));
            this.PetsItemsPetItemDefinition1(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), PetsItemsPetItemDefinition14.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.PetsItemsPetItemDefinition11.PetsItemsPetItemDefinition1("pajak");
        pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.PetsItemsPetItemDefinition23 = (ArmorStand)PetsItemsPetItemDefinition14.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + PetsItemsPetItemDefinition14.getName()));
            armorStand.setCustomNameVisible(true);
        }), PetsItemsPetItemDefinition14.getUniqueId());
        if (this.PetsItemsPetItemDefinition12) {
            PetsItemsPetItemDefinition14.setFoodLevel(20);
            PetsItemsPetItemDefinition14.setSaturation(20.0f);
        }
        PetsItemsPetItemDefinition14.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, this.PetsItemsPetItemDefinition9 - 1, false, this.PetsItemsPetItemDefinition8, true));
        PetsItemsPetItemDefinition14.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.PetsItemsPetItemDefinition7 - 1, false, this.PetsItemsPetItemDefinition16, true));
    }
    
    @Override
    public void update() {
        if (this.PetsItemsPetItemDefinition2 == null || this.PetsItemsPetItemDefinition4 == null || this.PetsItemsPetItemDefinition23 == null || !this.PetsItemsPetItemDefinition2.isOnline()) {
            return;
        }
        if (!this.PetsItemsPetItemDefinition2.hasPotionEffect(PotionEffectType.JUMP)) {
            this.PetsItemsPetItemDefinition2.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, this.PetsItemsPetItemDefinition9 - 1, false, this.PetsItemsPetItemDefinition8, true));
        }
        if (!this.PetsItemsPetItemDefinition2.hasPotionEffect(PotionEffectType.SPEED)) {
            this.PetsItemsPetItemDefinition2.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.PetsItemsPetItemDefinition7 - 1, false, this.PetsItemsPetItemDefinition16, true));
        }
        if (this.PetsItemsPetItemDefinition12 && this.PetsItemsPetItemDefinition2.getFoodLevel() < 20) {
            this.PetsItemsPetItemDefinition2.setFoodLevel(20);
            this.PetsItemsPetItemDefinition2.setSaturation(20.0f);
        }
        final boolean hasPotionEffect = this.PetsItemsPetItemDefinition2.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.PetsItemsPetItemDefinition2.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.PetsItemsPetItemDefinition15));
        this.PetsItemsPetItemDefinition6 += this.PetsItemsPetItemDefinition21;
        final double n = this.PetsItemsPetItemDefinition6 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.PetsItemsPetItemDefinition19) : ((2.0 - n) * this.PetsItemsPetItemDefinition19), 0.0);
        add.setYaw(location.getYaw());
        this.PetsItemsPetItemDefinition4.teleport(add);
        this.PetsItemsPetItemDefinition23.teleport(add.clone().add(0.0, (double)this.PetsItemsPetItemDefinition11.PetsItemsPetItemDefinition1("pajak").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.PetsItemsPetItemDefinition2) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.PetsItemsPetItemDefinition4);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.PetsItemsPetItemDefinition23);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.PetsItemsPetItemDefinition2 || !this.PetsItemsPetItemDefinition20) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.PetsItemsPetItemDefinition4);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.PetsItemsPetItemDefinition23);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.PetsItemsPetItemDefinition4 != null) {
            this.PetsItemsPetItemDefinition4.remove();
        }
        if (this.PetsItemsPetItemDefinition23 != null) {
            this.PetsItemsPetItemDefinition23.remove();
        }
        HandlerList.unregisterAll((Listener)this);
        if (this.PetsItemsPetItemDefinition2 != null && this.PetsItemsPetItemDefinition2.isOnline()) {
            this.PetsItemsPetItemDefinition2.removePotionEffect(PotionEffectType.JUMP);
            this.PetsItemsPetItemDefinition2.removePotionEffect(PotionEffectType.SPEED);
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.PetsItemsPetItemDefinition11.PetsItemsPetItemDefinition7("pajak").getString("name", "Paj\u0105k");
    }
    
    @EventHandler
    public void onPotionEffect(final EntityPotionEffectEvent entityPotionEffectEvent) {
        if (!this.PetsItemsPetItemDefinition5) {
            return;
        }
        if (this.PetsItemsPetItemDefinition2 != null && entityPotionEffectEvent.getEntity().getUniqueId().equals(this.PetsItemsPetItemDefinition2.getUniqueId()) && (entityPotionEffectEvent.getAction() == EntityPotionEffectEvent.Action.ADDED || entityPotionEffectEvent.getAction() == EntityPotionEffectEvent.Action.CHANGED)) {
            final PotionEffectType modifiedType = entityPotionEffectEvent.getModifiedType();
            if (modifiedType.equals((Object)PotionEffectType.POISON) || modifiedType.equals((Object)PotionEffectType.WITHER) || modifiedType.equals((Object)PotionEffectType.HUNGER) || modifiedType.equals((Object)PotionEffectType.WEAKNESS) || modifiedType.equals((Object)PotionEffectType.SLOW) || modifiedType.equals((Object)PotionEffectType.SLOW_DIGGING) || modifiedType.equals((Object)PotionEffectType.CONFUSION) || modifiedType.equals((Object)PotionEffectType.BLINDNESS) || modifiedType.equals((Object)PotionEffectType.HARM)) {
                entityPotionEffectEvent.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (!this.PetsItemsPetItemDefinition17) {
            return;
        }
        if (this.PetsItemsPetItemDefinition2 != null && entityDamageEvent.getEntity() instanceof Player && ((Player)entityDamageEvent.getEntity()).getUniqueId().equals(this.PetsItemsPetItemDefinition2.getUniqueId()) && entityDamageEvent.getCause() == EntityDamageEvent.DamageCause.FALL) {
            entityDamageEvent.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onFoodLevelChange(final FoodLevelChangeEvent foodLevelChangeEvent) {
        if (!this.PetsItemsPetItemDefinition12) {
            return;
        }
        if (this.PetsItemsPetItemDefinition2 != null && foodLevelChangeEvent.getEntity() instanceof Player) {
            final Player player = (Player)foodLevelChangeEvent.getEntity();
            if (player.getUniqueId().equals(this.PetsItemsPetItemDefinition2.getUniqueId()) && foodLevelChangeEvent.getFoodLevel() < player.getFoodLevel()) {
                foodLevelChangeEvent.setCancelled(true);
                player.setFoodLevel(20);
                player.setSaturation(20.0f);
            }
        }
    }
    
    private void PetsItemsPetItemDefinition1(final SkullMeta skullMeta, final String s) {
        pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    public int getJumpLevel() {
        return this.PetsItemsPetItemDefinition9;
    }
    
    public boolean isJumpEffectVisible() {
        return this.PetsItemsPetItemDefinition8;
    }
    
    public int getSpeedLevel() {
        return this.PetsItemsPetItemDefinition7;
    }
    
    public boolean isSpeedEffectVisible() {
        return this.PetsItemsPetItemDefinition16;
    }
    
    public boolean isHungerProtectionEnabled() {
        return this.PetsItemsPetItemDefinition12;
    }
    
    public boolean isNegativeEffectsProtectionEnabled() {
        return this.PetsItemsPetItemDefinition5;
    }
    
    public boolean isFallDamageProtectionEnabled() {
        return this.PetsItemsPetItemDefinition17;
    }
    
    static {
        PetsItemsPetItemDefinition10 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        PetsItemsPetItemDefinition18 = UUID.fromString("55555555-6666-7777-8888-999999999999");
    }
}
