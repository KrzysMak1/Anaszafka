// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import java.util.HashSet;
import java.util.Arrays;
import org.bukkit.inventory.meta.ItemMeta;
import pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.EventHandler;
import java.util.Collection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.block.BlockBreakEvent;
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

public class PetsItemsPetItemDefinition8 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand \u00fe;
    private ArmorStand \u010c;
    private Player \u00fb;
    private final String \u00fc = "eustachy";
    private double \u00ff;
    private String \u00fa;
    private Date \u010a;
    private static final SimpleDateFormat \u0101;
    private boolean \u0108;
    private PetsItemsPetItemDefinition7 \u0102;
    private double \u0109;
    private double \u0107;
    private double \u0104;
    private int \u0100;
    private boolean \u0105;
    private int \u00fd;
    private boolean \u010b;
    private static final Set<Material> \u0103;
    private static final Set<Material> \u0106;
    
    public PetsItemsPetItemDefinition8() {
        this.\u00ff = 0.0;
        this.\u0108 = false;
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u0102 = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition9();
    }
    
    private void PetsItemsPetItemDefinition9() {
        try {
            final Map<String, Object> d = this.\u0102.PetsItemsPetItemDefinition4("eustachy");
            if (d != null) {
                final Object value = d.get("height");
                final Object value2 = d.get("speed");
                final Object value3 = d.get("distance");
                this.\u0107 = ((value instanceof Number) ? ((Number)value).doubleValue() : 1.0);
                this.\u0109 = ((value2 instanceof Number) ? ((Number)value2).doubleValue() : 0.025);
                this.\u0104 = ((value3 instanceof Number) ? ((Number)value3).doubleValue() : 1.0);
            }
            else {
                this.\u0107 = 1.0;
                this.\u0109 = 0.025;
                this.\u0104 = 1.0;
            }
            final Map<String, Object> d2 = this.\u0102.PetsItemsPetItemDefinition4("eustachy", "speed");
            if (d2 != null) {
                final Object value4 = d2.get("level");
                final Object value5 = d2.get("visible");
                this.\u0100 = ((value4 instanceof Number) ? ((Number)value4).intValue() : 1);
                this.\u0105 = (value5 instanceof Boolean && (boolean)value5);
            }
            else {
                this.\u0100 = 1;
                this.\u0105 = false;
            }
            final Map<String, Object> d3 = this.\u0102.PetsItemsPetItemDefinition4("eustachy", "drop");
            if (d3 != null) {
                final Object value6 = d3.get("multiplier");
                final Object value7 = d3.get("visible");
                this.\u00fd = ((value6 instanceof Number) ? ((Number)value6).intValue() : 2);
                this.\u010b = (!(value7 instanceof Boolean) || (boolean)value7);
            }
            else {
                this.\u00fd = 2;
                this.\u010b = true;
            }
        }
        catch (final Exception ex) {
            this.\u0107 = 1.0;
            this.\u0109 = 0.025;
            this.\u0104 = 1.0;
            this.\u0100 = 1;
            this.\u0105 = false;
            this.\u00fd = 2;
            this.\u010b = true;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u00fb != null && this.\u00fe != null && this.\u010c != null) {
            this.\u0108 = true;
            this.\u00fb.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00fe);
            this.\u00fb.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u010c);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u00fb != null && this.\u00fe != null && this.\u010c != null) {
            this.\u0108 = false;
            this.\u00fb.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00fe);
            this.\u00fb.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u010c);
        }
    }
    
    @Override
    public void spawn(final Player \u00fb, final String s) {
        this.\u00fb = \u00fb;
        this.\u00fa = null;
        this.\u010a = null;
        final Location location = \u00fb.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0104));
        String string;
        if (this.\u0102 != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u0102.PetsItemsPetItemDefinition2("eustachy", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u0102.PetsItemsPetItemDefinition7("eustachy").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDAxZTAzNWEzZDhkNjEyNjA3MmJjYmU1MmE5NzkxM2FjZTkzNTUyYTk5OTk1YjVkNDA3MGQ2NzgzYTMxZTkwOSJ9fX0=");
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDAxZTAzNWEzZDhkNjEyNjA3MmJjYmU1MmE5NzkxM2FjZTkzNTUyYTk5OTk1YjVkNDA3MGQ2NzgzYTMxZTkwOSJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u00fe = (ArmorStand)\u00fb.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u0102.PetsItemsPetItemDefinition12("eustachy") + " &8\u25cf &f" + \u00fb.getName()));
            this.PetsItemsPetItemDefinition7(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u00fb.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u0102.PetsItemsPetItemDefinition1("eustachy");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u010c = (ArmorStand)\u00fb.getWorld().spawn(add.clone().add(0.0, (PetsItemsPetItemDefinition13 != null && PetsItemsPetItemDefinition13.get("height") instanceof Number) ? ((Number)PetsItemsPetItemDefinition13.get("height")).doubleValue() : 2.0, 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u00fb.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u00fb.getUniqueId());
        \u00fb.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u0100, false, this.\u0105, true));
    }
    
    @Override
    public void update() {
        if (this.\u00fb == null || this.\u00fe == null || this.\u010c == null || !this.\u00fb.isOnline()) {
            return;
        }
        if (!this.\u00fb.hasPotionEffect(PotionEffectType.SPEED) || (this.\u00fb.hasPotionEffect(PotionEffectType.SPEED) && this.\u00fb.getPotionEffect(PotionEffectType.SPEED).getAmplifier() < this.\u0100)) {
            this.\u00fb.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, this.\u0100, false, this.\u0105, true));
        }
        final boolean hasPotionEffect = this.\u00fb.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u00fb.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0104));
        this.\u00ff += this.\u0109;
        final double n = this.\u00ff % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u0107) : ((2.0 - n) * this.\u0107), 0.0);
        add.setYaw(location.getYaw());
        this.\u00fe.teleport(add);
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u0102.PetsItemsPetItemDefinition1("eustachy");
        this.\u010c.teleport(add.clone().add(0.0, (PetsItemsPetItemDefinition13 != null && PetsItemsPetItemDefinition13.get("height") instanceof Number) ? ((Number)PetsItemsPetItemDefinition13.get("height")).doubleValue() : 2.0, 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u00fb) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00fe);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u010c);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u00fb || !this.\u0108) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00fe);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u010c);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u00fe != null) {
            this.\u00fe.remove();
        }
        if (this.\u010c != null) {
            this.\u010c.remove();
        }
        if (this.\u00fb != null && this.\u00fb.isOnline()) {
            final PotionEffect potionEffect = this.\u00fb.getPotionEffect(PotionEffectType.SPEED);
            if (potionEffect != null && potionEffect.getAmplifier() == this.\u0100) {
                this.\u00fb.removePotionEffect(PotionEffectType.SPEED);
            }
        }
        HandlerList.unregisterAll((Listener)this);
    }
    
    @Override
    public String getDisplayName() {
        return this.\u0102.PetsItemsPetItemDefinition7("eustachy").getString("name", "Eustachy");
    }
    
    @EventHandler
    public void onBlockBreak(final BlockBreakEvent blockBreakEvent) {
        if (this.\u00fb == null || !blockBreakEvent.getPlayer().getUniqueId().equals(this.\u00fb.getUniqueId())) {
            return;
        }
        final Material type = blockBreakEvent.getBlock().getType();
        if (PetsItemsPetItemDefinition8.\u0103.contains(type) || PetsItemsPetItemDefinition8.\u0106.contains(type)) {
            if (blockBreakEvent.getBlock().getBlockData() instanceof final Ageable ageable) {
                if (ageable.getAge() < ageable.getMaximumAge()) {
                    return;
                }
            }
            final Collection drops = blockBreakEvent.getBlock().getDrops(blockBreakEvent.getPlayer().getInventory().getItemInMainHand());
            for (int i = 1; i < this.\u00fd; ++i) {
                for (final ItemStack itemStack : drops) {
                    if (itemStack != null && itemStack.getType() != Material.AIR) {
                        blockBreakEvent.getBlock().getWorld().dropItemNaturally(blockBreakEvent.getBlock().getLocation(), itemStack.clone());
                    }
                }
            }
        }
    }
    
    private void PetsItemsPetItemDefinition7(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    public int getSpeedEffectLevel() {
        return this.\u0100;
    }
    
    public boolean isSpeedEffectVisible() {
        return this.\u0105;
    }
    
    public int getDropMultiplier() {
        return this.\u00fd;
    }
    
    public boolean isDropEffectVisible() {
        return this.\u010b;
    }
    
    static {
        \u0101 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        \u0103 = new HashSet<Material>(Arrays.asList(Material.COAL_ORE, Material.DEEPSLATE_COAL_ORE, Material.IRON_ORE, Material.DEEPSLATE_IRON_ORE, Material.COPPER_ORE, Material.DEEPSLATE_COPPER_ORE, Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE, Material.REDSTONE_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.EMERALD_ORE, Material.DEEPSLATE_EMERALD_ORE, Material.LAPIS_ORE, Material.DEEPSLATE_LAPIS_ORE, Material.DIAMOND_ORE, Material.DEEPSLATE_DIAMOND_ORE, Material.NETHER_GOLD_ORE, Material.NETHER_QUARTZ_ORE, Material.ANCIENT_DEBRIS, Material.RAW_IRON_BLOCK, Material.RAW_GOLD_BLOCK, Material.RAW_COPPER_BLOCK));
        \u0106 = new HashSet<Material>(Arrays.asList(Material.WHEAT, Material.BEETROOTS, Material.CARROTS, Material.POTATOES, Material.MELON, Material.PUMPKIN, Material.SUGAR_CANE, Material.BAMBOO, Material.COCOA, Material.SWEET_BERRY_BUSH, Material.KELP, Material.SEA_PICKLE, Material.CACTUS, Material.BROWN_MUSHROOM, Material.RED_MUSHROOM, Material.NETHER_WART));
    }
}
