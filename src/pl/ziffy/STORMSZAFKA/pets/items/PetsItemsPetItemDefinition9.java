// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.HandlerList;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition5;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Bukkit;
import java.util.HashMap;
import org.bukkit.scheduler.BukkitTask;
import java.util.UUID;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition7;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition4;

public class PetsItemsPetItemDefinition9 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand \u0111;
    private ArmorStand \u0124;
    private Player \u010e;
    private final String \u010f = "sowa";
    private double \u0114;
    private String \u010d;
    private Date \u0121;
    private static final SimpleDateFormat \u0118;
    private boolean \u011f;
    private boolean \u011d;
    private PetsItemsPetItemDefinition7 \u0119;
    private double \u0120;
    private double \u011e;
    private double \u011a;
    private int \u0116;
    private boolean \u0112;
    private boolean \u0113;
    private int \u0123;
    private boolean \u0122;
    private boolean \u0117;
    private boolean \u0110;
    private int \u0115;
    private boolean \u011c;
    private Map<UUID, BukkitTask> \u011b;
    
    public PetsItemsPetItemDefinition9() {
        this.\u0114 = 0.0;
        this.\u011f = false;
        this.\u011d = true;
        this.\u011b = new HashMap<UUID, BukkitTask>();
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u0119 = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition10();
    }
    
    private void PetsItemsPetItemDefinition10() {
        try {
            final Map<String, Object> d = this.\u0119.PetsItemsPetItemDefinition4("sowa");
            if (d != null) {
                this.\u011e = (double)(d.containsKey("height") ? d.get("height") : 0.9);
                this.\u0120 = (double)(d.containsKey("speed") ? d.get("speed") : 0.025);
                this.\u011a = (double)(d.containsKey("distance") ? d.get("distance") : 1.0);
            }
            else {
                this.\u011e = 0.9;
                this.\u0120 = 0.025;
                this.\u011a = 1.0;
            }
            final Map<String, Object> d2 = this.\u0119.PetsItemsPetItemDefinition4("sowa", "damage");
            if (d2 != null) {
                this.\u0116 = (int)(d2.containsKey("amount") ? d2.get("amount") : 3);
                this.\u0112 = (d2.containsKey("visible") && (boolean)d2.get("visible"));
            }
            else {
                this.\u0116 = 3;
                this.\u0112 = false;
            }
            final Map<String, Object> d3 = this.\u0119.PetsItemsPetItemDefinition4("sowa", "hunger");
            if (d3 != null) {
                this.\u0113 = (!d3.containsKey("enabled") || (boolean)d3.get("enabled"));
                this.\u0123 = (int)(d3.containsKey("level") ? d3.get("level") : 20);
                this.\u0122 = (d3.containsKey("visible") && (boolean)d3.get("visible"));
            }
            else {
                this.\u0113 = true;
                this.\u0123 = 20;
                this.\u0122 = false;
            }
            final Map<String, Object> d4 = this.\u0119.PetsItemsPetItemDefinition4("sowa", "health_view");
            if (d4 != null) {
                this.\u0117 = (!d4.containsKey("enabled") || (boolean)d4.get("enabled"));
                this.\u0110 = (d4.containsKey("visible") && (boolean)d4.get("visible"));
            }
            else {
                this.\u0117 = true;
                this.\u0110 = false;
            }
            final Map<String, Object> d5 = this.\u0119.PetsItemsPetItemDefinition4("sowa", "speed");
            if (d5 != null) {
                this.\u0115 = (int)(d5.containsKey("level") ? d5.get("level") : 1);
                this.\u011c = (d5.containsKey("visible") && (boolean)d5.get("visible"));
            }
            else {
                this.\u0115 = 1;
                this.\u011c = false;
            }
        }
        catch (final Exception ex) {
            this.\u011e = 0.9;
            this.\u0120 = 0.025;
            this.\u011a = 1.0;
            this.\u0116 = 3;
            this.\u0112 = false;
            this.\u0113 = true;
            this.\u0123 = 20;
            this.\u0122 = false;
            this.\u0117 = true;
            this.\u0110 = false;
            this.\u0115 = 1;
            this.\u011c = false;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u010e != null && this.\u0111 != null && this.\u0124 != null) {
            this.\u011f = true;
            this.\u010e.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0111);
            this.\u010e.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0124);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u010e != null && this.\u0111 != null && this.\u0124 != null) {
            this.\u011f = false;
            this.\u010e.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0111);
            this.\u010e.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0124);
        }
    }
    
    @Override
    public void spawn(final Player \u010f, final String s) {
        this.\u010e = \u010f;
        this.\u010d = null;
        this.\u0121 = null;
        final Location location = \u010f.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u011a));
        String string;
        if (this.\u0119 != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u0119.PetsItemsPetItemDefinition2("sowa", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u0119.PetsItemsPetItemDefinition7("sowa").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTg2OWY2Nzk2MWYzZWU1YjY4ZTM4Zjc5ODU3MDY4ZWQxNmNiZGYwZjhjOWNlYTJkNzUwNGZjOGRmODcxZDFkNyJ9fX0=");
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTg2OWY2Nzk2MWYzZWU1YjY4ZTM4Zjc5ODU3MDY4ZWQxNmNiZGYwZjhjOWNlYTJkNzUwNGZjOGRmODcxZDFkNyJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u0111 = (ArmorStand)\u010f.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u0119.PetsItemsPetItemDefinition12("sowa") + " &8\u25cf &f" + \u010f.getName()));
            this.PetsItemsPetItemDefinition8(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u010f.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u0119.PetsItemsPetItemDefinition1("sowa");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u0124 = (ArmorStand)\u010f.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u010f.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u010f.getUniqueId());
        if (this.\u0113) {
            \u010f.setFoodLevel(this.\u0123);
            \u010f.setSaturation((float)this.\u0123);
        }
        if (this.\u0115 > 0) {
            \u010f.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u0115 - 1, false, false, this.\u011c));
        }
    }
    
    @Override
    public void update() {
        if (this.\u010e == null || this.\u0111 == null || this.\u0124 == null || !this.\u010e.isOnline()) {
            return;
        }
        if (this.\u0115 > 0 && !this.\u010e.hasPotionEffect(PotionEffectType.SPEED)) {
            this.\u010e.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u0115 - 1, false, false, this.\u011c));
        }
        if (this.\u0113 && this.\u010e.getFoodLevel() < this.\u0123) {
            this.\u010e.setFoodLevel(this.\u0123);
            this.\u010e.setSaturation((float)this.\u0123);
        }
        final boolean hasPotionEffect = this.\u010e.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u010e.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u011a));
        this.\u0114 += this.\u0120;
        final double n = this.\u0114 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u011e) : ((2.0 - n) * this.\u011e), 0.0);
        add.setYaw(location.getYaw());
        this.\u0111.teleport(add);
        this.\u0124.teleport(add.clone().add(0.0, (double)this.\u0119.PetsItemsPetItemDefinition1("sowa").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u010e) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0111);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0124);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u010e || !this.\u011f) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0111);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0124);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u0111 != null) {
            this.\u0111.remove();
        }
        if (this.\u0124 != null) {
            this.\u0124.remove();
        }
        final Iterator<BukkitTask> iterator = this.\u011b.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().cancel();
        }
        this.\u011b.clear();
        HandlerList.unregisterAll((Listener)this);
        if (this.\u0115 > 0 && this.\u010e != null && this.\u010e.isOnline()) {
            this.\u010e.removePotionEffect(PotionEffectType.SPEED);
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.\u0119.PetsItemsPetItemDefinition7("sowa").getString("name", "Sowa");
    }
    
    @EventHandler
    public void onFoodLevelChange(final FoodLevelChangeEvent foodLevelChangeEvent) {
        if (this.\u010e != null && foodLevelChangeEvent.getEntity() instanceof Player && this.\u0113) {
            final Player player = (Player)foodLevelChangeEvent.getEntity();
            if (player.getUniqueId().equals(this.\u010e.getUniqueId()) && foodLevelChangeEvent.getFoodLevel() < player.getFoodLevel()) {
                foodLevelChangeEvent.setCancelled(true);
                player.setFoodLevel(this.\u0123);
                player.setSaturation((float)this.\u0123);
            }
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (this.\u010e != null && entityDamageByEntityEvent.getDamager() instanceof Player && this.\u011d && ((Player)entityDamageByEntityEvent.getDamager()).getUniqueId().equals(this.\u010e.getUniqueId())) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() + this.\u0116);
            if (this.\u0117 && entityDamageByEntityEvent.getEntity() instanceof Player) {
                this.PetsItemsPetItemDefinition8((Player)entityDamageByEntityEvent.getEntity());
            }
        }
    }
    
    private void PetsItemsPetItemDefinition8(final Player player) {
        if (this.\u011b.containsKey(player.getUniqueId())) {
            this.\u011b.get(player.getUniqueId()).cancel();
        }
        this.\u011b.put(player.getUniqueId(), Bukkit.getScheduler().runTaskTimer(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> this.PetsItemsPetItemDefinition5(player2), 0L, 20L));
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> {
            if (this.\u011b.containsKey(player3.getUniqueId())) {
                this.\u011b.get(player3.getUniqueId()).cancel();
                this.\u011b.remove(player3.getUniqueId());
                if (this.\u010e != null && this.\u010e.isOnline()) {
                    this.\u010e.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(""));
                }
            }
        }, 100L);
    }
    
    private void PetsItemsPetItemDefinition5(final Player player) {
        if (this.\u010e != null && this.\u010e.isOnline() && player.isOnline()) {
            final double health = player.getHealth();
            final double value = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
            final int n = (int)Math.ceil(health / 2.0);
            final int n2 = (int)Math.ceil(value / 2.0);
            final StringBuilder sb = new StringBuilder();
            sb.append(ChatColor.RED).append(player.getName()).append(": ");
            for (int i = 0; i < n; ++i) {
                sb.append(ChatColor.RED).append("\u2764");
            }
            for (int j = n; j < n2; ++j) {
                sb.append(ChatColor.GRAY).append("\u2764");
            }
            this.\u010e.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(sb.toString()));
        }
    }
    
    private void PetsItemsPetItemDefinition8(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    public int getDamageAmount() {
        return this.\u0116;
    }
    
    public boolean isDamageVisible() {
        return this.\u0112;
    }
    
    public boolean isHungerEnabled() {
        return this.\u0113;
    }
    
    public int getHungerLevel() {
        return this.\u0123;
    }
    
    public boolean isHungerVisible() {
        return this.\u0122;
    }
    
    public boolean isHealthViewEnabled() {
        return this.\u0117;
    }
    
    public boolean isHealthViewVisible() {
        return this.\u0110;
    }
    
    public int getSpeedLevel() {
        return this.\u0115;
    }
    
    public boolean isSpeedVisible() {
        return this.\u011c;
    }
    
    static {
        \u0118 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
