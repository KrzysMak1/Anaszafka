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
import org.bukkit.event.entity.FoodLevelChangeEvent;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;

public class PetsItemsPetItemDefinition4 implements pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand w;
    private ArmorStand y;
    private Player n;
    private final String v = "glodomorek";
    private double q;
    private String t;
    private Date u;
    private static final SimpleDateFormat x;
    private boolean z;
    private boolean p;
    private PetsItemsPetItemDefinition7 o;
    private double r;
    private double s;
    private double m;
    
    public PetsItemsPetItemDefinition4() {
        this.q = 0.0;
        this.z = false;
        this.p = true;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.o = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition5();
    }
    
    private void PetsItemsPetItemDefinition5() {
        final Map<String, Object> d = this.o.PetsItemsPetItemDefinition4("glodomorek");
        this.s = (double)d.get("height");
        this.r = (double)d.get("speed");
        this.m = (double)d.get("distance");
    }
    
    @Override
    public void hideFromOwner() {
        if (this.n != null && this.w != null && this.y != null) {
            this.z = true;
            this.n.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.w);
            this.n.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.y);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.n != null && this.w != null && this.y != null) {
            this.z = false;
            this.n.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.w);
            this.n.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.y);
        }
    }
    
    @Override
    public void spawn(final Player n, final String s) {
        this.n = n;
        this.t = null;
        this.u = null;
        final Location location = n.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.m));
        String string;
        if (this.o != null) {
            final Object PetsItemsPetItemDefinition14 = this.o.PetsItemsPetItemDefinition2("glodomorek", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.o.PetsItemsPetItemDefinition7("glodomorek").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmIxNmMzZmEzMWYzNDMzNmM4YzM0ZGRhNzg4OGVjYjU5ZTVhNjdjZDE5ZjQ3MGE4ZmEzNTE3MmZjYTE1MzNhNSJ9fX0=");
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmIxNmMzZmEzMWYzNDMzNmM4YzM0ZGRhNzg4OGVjYjU5ZTVhNjdjZDE5ZjQ3MGE4ZmEzNTE3MmZjYTE1MzNhNSJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.w = (ArmorStand)n.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.o.PetsItemsPetItemDefinition12("glodomorek") + " &8\u25cf &f" + n.getName()));
            this.PetsItemsPetItemDefinition3(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), n.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.o.PetsItemsPetItemDefinition1("glodomorek");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.y = (ArmorStand)n.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + n.getName()));
            armorStand.setCustomNameVisible(true);
        }), n.getUniqueId());
        n.setFoodLevel(20);
        n.setSaturation(20.0f);
    }
    
    @Override
    public void update() {
        if (this.n == null || this.w == null || this.y == null || !this.n.isOnline()) {
            return;
        }
        if (this.n.getFoodLevel() < 20) {
            this.n.setFoodLevel(20);
            this.n.setSaturation(20.0f);
        }
        final boolean hasPotionEffect = this.n.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.n.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.m));
        this.q += this.r;
        final double n = this.q % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.s) : ((2.0 - n) * this.s), 0.0);
        add.setYaw(location.getYaw());
        this.w.teleport(add);
        this.y.teleport(add.clone().add(0.0, (double)this.o.PetsItemsPetItemDefinition1("glodomorek").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.n) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.w);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.y);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.n || !this.z) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.w);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.y);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.w != null) {
            this.w.remove();
        }
        if (this.y != null) {
            this.y.remove();
        }
        HandlerList.unregisterAll((Listener)this);
        this.deactivateEffect();
    }
    
    @Override
    public String getDisplayName() {
        return this.o.PetsItemsPetItemDefinition7("glodomorek").getString("name", "PetsItemsPetItemDefinition7\u0142odomorek");
    }
    
    public void deactivateEffect() {
        this.p = false;
    }
    
    @EventHandler
    public void onFoodLevelChange(final FoodLevelChangeEvent foodLevelChangeEvent) {
        if (this.n != null && foodLevelChangeEvent.getEntity() instanceof Player && this.p) {
            final Player player = (Player)foodLevelChangeEvent.getEntity();
            if (player.getUniqueId().equals(this.n.getUniqueId()) && foodLevelChangeEvent.getFoodLevel() < player.getFoodLevel()) {
                foodLevelChangeEvent.setCancelled(true);
                player.setFoodLevel(20);
                player.setSaturation(20.0f);
            }
        }
    }
    
    private void PetsItemsPetItemDefinition3(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    static {
        x = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
