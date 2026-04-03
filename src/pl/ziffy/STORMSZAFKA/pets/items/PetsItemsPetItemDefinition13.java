// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import java.util.HashSet;
import java.util.Arrays;
import org.bukkit.inventory.meta.ItemMeta;
import pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3;
import org.bukkit.inventory.meta.SkullMeta;
import java.util.Collection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
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
import org.bukkit.Material;
import java.util.Set;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition7;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition4;

public class PetsItemsPetItemDefinition13 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand \u0396;
    private ArmorStand \u03a7;
    private Player \u0390;
    private final String \u0392 = "balwanek";
    private double \u0397;
    private String \u038f;
    private Date \u03a6;
    private static final SimpleDateFormat \u0399;
    private boolean \u03a3;
    private boolean \u03a0;
    private PetsItemsPetItemDefinition7 \u039a;
    private double \u03a4;
    private double \u03a1;
    private double \u039d;
    private int \u0394;
    private boolean \u0391;
    private int \u0398;
    private boolean \u039e;
    private int \u039b;
    private boolean \u0395;
    private int \u0393;
    private boolean \u03a5;
    private static final Set<Material> \u039c;
    private static final Set<Material> \u039f;
    
    public PetsItemsPetItemDefinition13() {
        this.\u0397 = 0.0;
        this.\u03a3 = false;
        this.\u03a0 = true;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u039a = Main.getPetConfigManager();
        this.e();
    }
    
    private void e() {
        try {
            final Map<String, Object> d = this.\u039a.PetsItemsPetItemDefinition4("balwanek");
            if (d != null) {
                final Object value = d.get("height");
                final Object value2 = d.get("speed");
                final Object value3 = d.get("distance");
                this.\u03a1 = ((value instanceof Number) ? ((Number)value).doubleValue() : 1.0);
                this.\u03a4 = ((value2 instanceof Number) ? ((Number)value2).doubleValue() : 0.025);
                this.\u039d = ((value3 instanceof Number) ? ((Number)value3).doubleValue() : 1.0);
            }
            else {
                this.\u03a1 = 1.0;
                this.\u03a4 = 0.025;
                this.\u039d = 1.0;
            }
            final Map<String, Object> d2 = this.\u039a.PetsItemsPetItemDefinition4("balwanek", "defense");
            if (d2 != null) {
                final Object value4 = d2.get("percentage");
                final Object value5 = d2.get("visible");
                this.\u0394 = ((value4 instanceof Number) ? ((Number)value4).intValue() : 10);
                this.\u0391 = (!(value5 instanceof Boolean) || (boolean)value5);
            }
            else {
                this.\u0394 = 10;
                this.\u0391 = true;
            }
            final Map<String, Object> d3 = this.\u039a.PetsItemsPetItemDefinition4("balwanek", "speed");
            if (d3 != null) {
                final Object value6 = d3.get("level");
                final Object value7 = d3.get("visible");
                this.\u0398 = ((value6 instanceof Number) ? ((Number)value6).intValue() : 1);
                this.\u039e = (value7 instanceof Boolean && (boolean)value7);
            }
            else {
                this.\u0398 = 1;
                this.\u039e = false;
            }
            final Map<String, Object> d4 = this.\u039a.PetsItemsPetItemDefinition4("balwanek", "damage");
            if (d4 != null) {
                final Object value8 = d4.get("increase");
                final Object value9 = d4.get("visible");
                this.\u039b = ((value8 instanceof Number) ? ((Number)value8).intValue() : 2);
                this.\u0395 = (!(value9 instanceof Boolean) || (boolean)value9);
            }
            else {
                this.\u039b = 2;
                this.\u0395 = true;
            }
            final Map<String, Object> d5 = this.\u039a.PetsItemsPetItemDefinition4("balwanek", "drop");
            if (d5 != null) {
                final Object value10 = d5.get("multiplier");
                final Object value11 = d5.get("visible");
                this.\u0393 = ((value10 instanceof Number) ? ((Number)value10).intValue() : 2);
                this.\u03a5 = (!(value11 instanceof Boolean) || (boolean)value11);
            }
            else {
                this.\u0393 = 2;
                this.\u03a5 = true;
            }
        }
        catch (final Exception ex) {
            this.\u03a1 = 1.0;
            this.\u03a4 = 0.025;
            this.\u039d = 1.0;
            this.\u0394 = 10;
            this.\u0391 = true;
            this.\u0398 = 1;
            this.\u039e = false;
            this.\u039b = 2;
            this.\u0395 = true;
            this.\u0393 = 2;
            this.\u03a5 = true;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u0390 != null && this.\u0396 != null && this.\u03a7 != null) {
            this.\u03a3 = true;
            this.\u0390.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0396);
            this.\u0390.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03a7);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u0390 != null && this.\u0396 != null && this.\u03a7 != null) {
            this.\u03a3 = false;
            this.\u0390.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0396);
            this.\u0390.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03a7);
        }
    }
    
    @Override
    public void spawn(final Player \u0390, final String s) {
        this.\u0390 = \u0390;
        this.\u038f = null;
        this.\u03a6 = null;
        final Location location = \u0390.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u039d));
        String string;
        if (this.\u039a != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u039a.PetsItemsPetItemDefinition2("balwanek", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u039a.PetsItemsPetItemDefinition7("balwanek").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODdiYTE0NjI0NWRhMDE2NWU2YTQ1OWQwZGMyZDEyZDc3YTk2OTAzMmQxYzU2YWEwYjA5MTYwNTlmMjAyZGRkIn19fQ==");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODdiYTE0NjI0NWRhMDE2NWU2YTQ1OWQwZGMyZDEyZDc3YTk2OTAzMmQxYzU2YWEwYjA5MTYwNTlmMjAyZGRkIn19fQ==";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u0396 = (ArmorStand)\u0390.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u039a.PetsItemsPetItemDefinition12("balwanek") + " &8\u25cf &f" + \u0390.getName()));
            this.PetsItemsPetItemDefinition24(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u0390.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u039a.PetsItemsPetItemDefinition1("balwanek");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u03a7 = (ArmorStand)\u0390.getWorld().spawn(add.clone().add(0.0, (PetsItemsPetItemDefinition13 != null && PetsItemsPetItemDefinition13.get("height") instanceof Number) ? ((Number)PetsItemsPetItemDefinition13.get("height")).doubleValue() : 2.0, 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u0390.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u0390.getUniqueId());
        \u0390.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u0398 - 1, false, this.\u039e, true));
    }
    
    @Override
    public void update() {
        if (this.\u0390 == null || this.\u0396 == null || this.\u03a7 == null || !this.\u0390.isOnline()) {
            return;
        }
        if (!this.\u0390.hasPotionEffect(PotionEffectType.SPEED)) {
            this.\u0390.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u0398 - 1, false, this.\u039e, true));
        }
        final boolean hasPotionEffect = this.\u0390.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u0390.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u039d));
        this.\u0397 += this.\u03a4;
        final double n = this.\u0397 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u03a1) : ((2.0 - n) * this.\u03a1), 0.0);
        add.setYaw(location.getYaw());
        this.\u0396.teleport(add);
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u039a.PetsItemsPetItemDefinition1("balwanek");
        this.\u03a7.teleport(add.clone().add(0.0, (PetsItemsPetItemDefinition13 != null && PetsItemsPetItemDefinition13.get("height") instanceof Number) ? ((Number)PetsItemsPetItemDefinition13.get("height")).doubleValue() : 2.0, 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u0390) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0396);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03a7);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u0390 || !this.\u03a3) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u0396);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03a7);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u0396 != null) {
            this.\u0396.remove();
        }
        if (this.\u03a7 != null) {
            this.\u03a7.remove();
        }
        HandlerList.unregisterAll((Listener)this);
        if (this.\u0390 != null && this.\u0390.isOnline()) {
            this.\u0390.removePotionEffect(PotionEffectType.SPEED);
        }
        this.deactivateEffect();
    }
    
    @Override
    public String getDisplayName() {
        return this.\u039a.PetsItemsPetItemDefinition7("balwanek").getString("name", "Ba\u0142wanek");
    }
    
    public void deactivateEffect() {
        this.\u03a0 = false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.\u0390 != null && entityDamageEvent.getEntity() instanceof Player && ((Player)entityDamageEvent.getEntity()).getUniqueId().equals(this.\u0390.getUniqueId())) {
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u0394 / 100.0));
        }
    }
    
    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (this.\u0390 != null && entityDamageByEntityEvent.getDamager() instanceof Player && this.\u03a0 && ((Player)entityDamageByEntityEvent.getDamager()).getUniqueId().equals(this.\u0390.getUniqueId())) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() + this.\u039b);
        }
    }
    
    @EventHandler
    public void onBlockBreak(final BlockBreakEvent blockBreakEvent) {
        if (this.\u0390 == null || !blockBreakEvent.getPlayer().getUniqueId().equals(this.\u0390.getUniqueId())) {
            return;
        }
        final Material type = blockBreakEvent.getBlock().getType();
        if (PetsItemsPetItemDefinition13.\u039c.contains(type) || PetsItemsPetItemDefinition13.\u039f.contains(type)) {
            final Collection drops = blockBreakEvent.getBlock().getDrops(blockBreakEvent.getPlayer().getInventory().getItemInMainHand());
            if (PetsItemsPetItemDefinition13.\u039f.contains(type) && blockBreakEvent.getBlock().getBlockData() instanceof Ageable) {
                final Ageable ageable = (Ageable)blockBreakEvent.getBlock().getBlockData();
                if (ageable.getAge() < ageable.getMaximumAge()) {
                    return;
                }
            }
            for (int i = 1; i < this.\u0393; ++i) {
                for (final ItemStack itemStack : drops) {
                    if (itemStack != null && itemStack.getType() != Material.AIR) {
                        blockBreakEvent.getBlock().getWorld().dropItemNaturally(blockBreakEvent.getBlock().getLocation(), itemStack.clone());
                    }
                }
            }
        }
    }
    
    private void PetsItemsPetItemDefinition24(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    public int getSpeedEffectLevel() {
        return this.\u0398;
    }
    
    public boolean isSpeedEffectVisible() {
        return this.\u039e;
    }
    
    public int getDefensePercentage() {
        return this.\u0394;
    }
    
    public boolean isDefenseEffectVisible() {
        return this.\u0391;
    }
    
    public int getDamageIncrease() {
        return this.\u039b;
    }
    
    public boolean isDamageEffectVisible() {
        return this.\u0395;
    }
    
    public int getDropMultiplier() {
        return this.\u0393;
    }
    
    public boolean isDropEffectVisible() {
        return this.\u03a5;
    }
    
    static {
        \u0399 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        \u039c = new HashSet<Material>(Arrays.asList(Material.COAL_ORE, Material.DEEPSLATE_COAL_ORE, Material.IRON_ORE, Material.DEEPSLATE_IRON_ORE, Material.COPPER_ORE, Material.DEEPSLATE_COPPER_ORE, Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE, Material.REDSTONE_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.EMERALD_ORE, Material.DEEPSLATE_EMERALD_ORE, Material.LAPIS_ORE, Material.DEEPSLATE_LAPIS_ORE, Material.DIAMOND_ORE, Material.DEEPSLATE_DIAMOND_ORE, Material.NETHER_GOLD_ORE, Material.NETHER_QUARTZ_ORE, Material.ANCIENT_DEBRIS, Material.RAW_IRON_BLOCK, Material.RAW_GOLD_BLOCK, Material.RAW_COPPER_BLOCK));
        \u039f = new HashSet<Material>(Arrays.asList(Material.WHEAT, Material.BEETROOTS, Material.CARROTS, Material.POTATOES, Material.MELON, Material.PUMPKIN, Material.SUGAR_CANE, Material.BAMBOO, Material.COCOA, Material.SWEET_BERRY_BUSH, Material.KELP, Material.SEA_PICKLE, Material.CACTUS, Material.BROWN_MUSHROOM, Material.RED_MUSHROOM, Material.NETHER_WART));
    }
}
