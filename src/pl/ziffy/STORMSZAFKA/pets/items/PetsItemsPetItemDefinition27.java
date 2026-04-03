// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.block.BlockBreakEvent;
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
import java.util.Random;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition7;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition4;

public class PetsItemsPetItemDefinition27 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand \u0284;
    private ArmorStand \u0287;
    private Player \u027a;
    private final String \u0283 = "biznesmenik";
    private double \u027d;
    private String \u0280;
    private Date \u0282;
    private static final SimpleDateFormat \u0286;
    private boolean \u0288;
    private PetsItemsPetItemDefinition7 \u027b;
    private double \u027e;
    private double \u027f;
    private double \u0279;
    private double \u0281;
    private boolean \u0285;
    private static final Random \u027c;
    
    public PetsItemsPetItemDefinition27() {
        this.\u027d = 0.0;
        this.\u0288 = false;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u027b = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition13();
    }
    
    private void PetsItemsPetItemDefinition13() {
        final Map<String, Object> d = this.\u027b.PetsItemsPetItemDefinition4("biznesmenik");
        this.\u027f = (double)d.get("height");
        this.\u027e = (double)d.get("speed");
        this.\u0279 = (double)d.get("distance");
        final Map<String, Object> d2 = this.\u027b.PetsItemsPetItemDefinition4("biznesmenik", "drop_multiplier");
        this.\u0281 = (double)(d2.containsKey("multiplier") ? d2.get("multiplier") : 2.0);
        this.\u0285 = (!d2.containsKey("include_experience") || (boolean)d2.get("include_experience"));
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u027a != null && this.\u0284 != null && this.\u0287 != null) {
            this.\u0288 = true;
            this.\u027a.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0284);
            this.\u027a.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0287);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u027a != null && this.\u0284 != null && this.\u0287 != null) {
            this.\u0288 = false;
            this.\u027a.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0284);
            this.\u027a.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0287);
        }
    }
    
    @Override
    public void spawn(final Player \u027a, final String s) {
        this.\u027a = \u027a;
        this.\u0280 = null;
        this.\u0282 = null;
        final Location location = \u027a.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0279));
        String string;
        if (this.\u027b != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u027b.PetsItemsPetItemDefinition2("biznesmenik", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u027b.PetsItemsPetItemDefinition7("biznesmenik").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWFhMWE2MTk5NjBhYzY4NjBjYjVjOWI2ZDNjODg3NDVkNmVmNjQwMzAwOWFmNWJhMGQwODM4Yjg3YjEyZGYwNCJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWFhMWE2MTk5NjBhYzY4NjBjYjVjOWI2ZDNjODg3NDVkNmVmNjQwMzAwOWFmNWJhMGQwODM4Yjg3YjEyZGYwNCJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u0284 = (ArmorStand)\u027a.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u027b.PetsItemsPetItemDefinition12("biznesmenik") + " &8\u25cf &f" + \u027a.getName()));
            this.PetsItemsPetItemDefinition26(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u027a.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u027b.PetsItemsPetItemDefinition1("biznesmenik");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u0287 = (ArmorStand)\u027a.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u027a.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u027a.getUniqueId());
    }
    
    @Override
    public void update() {
        if (this.\u027a == null || this.\u0284 == null || this.\u0287 == null || !this.\u027a.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u027a.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u027a.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0279));
        this.\u027d += this.\u027e;
        final double n = this.\u027d % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u027f) : ((2.0 - n) * this.\u027f), 0.0);
        add.setYaw(location.getYaw());
        this.\u0284.teleport(add);
        this.\u0287.teleport(add.clone().add(0.0, (double)this.\u027b.PetsItemsPetItemDefinition1("biznesmenik").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u027a) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0284);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0287);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u027a || !this.\u0288) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0284);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0287);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u0284 != null) {
            this.\u0284.remove();
        }
        if (this.\u0287 != null) {
            this.\u0287.remove();
        }
        HandlerList.unregisterAll((Listener)this);
    }
    
    @Override
    public String getDisplayName() {
        return this.\u027b.PetsItemsPetItemDefinition7("biznesmenik").getString("name", "Biznesmenik");
    }
    
    @EventHandler
    public void onBlockBreak(final BlockBreakEvent blockBreakEvent) {
        if (this.\u027a == null || !blockBreakEvent.getPlayer().equals((Object)this.\u027a)) {
            return;
        }
        if (blockBreakEvent.getBlock().getDrops().isEmpty()) {
            return;
        }
        if (PetsItemsPetItemDefinition27.\u027c.nextDouble() < Math.min(1.0, this.\u0281 - 1.0)) {
            for (final ItemStack itemStack : blockBreakEvent.getBlock().getDrops(blockBreakEvent.getPlayer().getInventory().getItemInMainHand(), (Entity)blockBreakEvent.getPlayer())) {
                final ItemStack clone = itemStack.clone();
                final int amount = (int)Math.floor((this.\u0281 - 1.0) * itemStack.getAmount());
                if (amount > 0) {
                    clone.setAmount(amount);
                    blockBreakEvent.getBlock().getWorld().dropItemNaturally(blockBreakEvent.getBlock().getLocation(), clone);
                }
            }
            if (this.\u0285 && blockBreakEvent.getExpToDrop() > 0) {
                blockBreakEvent.setExpToDrop(blockBreakEvent.getExpToDrop() + (int)Math.floor((this.\u0281 - 1.0) * blockBreakEvent.getExpToDrop()));
            }
        }
    }
    
    private void PetsItemsPetItemDefinition26(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    static {
        \u0286 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        \u027c = new Random();
    }
}
