// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import java.util.HashSet;
import java.util.Arrays;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Collection;
import pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.HandlerList;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition5;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import java.util.Set;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition7;
import java.util.UUID;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition4;

public class PetsItemsPetItemDefinition15 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand \u016b;
    private ArmorStand \u017f;
    private Player \u0167;
    private final String \u0168 = "pierniczek";
    private double \u016d;
    private String \u0165;
    private Date \u017e;
    private static final SimpleDateFormat \u0170;
    private boolean \u017c;
    private Random \u0166;
    private static final UUID \u017a;
    private PetsItemsPetItemDefinition7 \u0171;
    private double \u017d;
    private double \u017b;
    private double \u0176;
    private double \u0169;
    private boolean \u0175;
    private int \u016e;
    private boolean \u0177;
    private double \u016f;
    private boolean \u016a;
    private double \u0173;
    private boolean \u016c;
    private int \u0174;
    private boolean \u0178;
    private static final Set<Material> \u0172;
    private static final Set<Material> \u0179;
    
    public PetsItemsPetItemDefinition15() {
        this.\u016d = 0.0;
        this.\u017c = false;
        this.\u0166 = new Random();
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u0171 = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition17();
    }
    
    private void PetsItemsPetItemDefinition17() {
        try {
            final Map<String, Object> d = this.\u0171.PetsItemsPetItemDefinition4("pierniczek");
            if (d != null) {
                this.\u017b = (double)(d.containsKey("height") ? d.get("height") : 0.9);
                this.\u017d = (double)(d.containsKey("speed") ? d.get("speed") : 0.025);
                this.\u0176 = (double)(d.containsKey("distance") ? d.get("distance") : 1.0);
            }
            else {
                this.\u017b = 0.9;
                this.\u017d = 0.025;
                this.\u0176 = 1.0;
            }
            final Map<String, Object> d2 = this.\u0171.PetsItemsPetItemDefinition4("pierniczek", "health");
            if (d2 != null) {
                this.\u0169 = (double)(d2.containsKey("bonus") ? d2.get("bonus") : 4.0);
                this.\u0175 = (d2.containsKey("visible") && (boolean)d2.get("visible"));
            }
            else {
                this.\u0169 = 4.0;
                this.\u0175 = false;
            }
            final Map<String, Object> d3 = this.\u0171.PetsItemsPetItemDefinition4("pierniczek", "speed");
            if (d3 != null) {
                this.\u016e = (int)(d3.containsKey("level") ? d3.get("level") : 1);
                this.\u0177 = (d3.containsKey("visible") && (boolean)d3.get("visible"));
            }
            else {
                this.\u016e = 1;
                this.\u0177 = false;
            }
            final Map<String, Object> d4 = this.\u0171.PetsItemsPetItemDefinition4("pierniczek", "ore_duplication");
            if (d4 != null) {
                this.\u016f = (double)(d4.containsKey("chance") ? d4.get("chance") : 1.0);
                this.\u016a = (d4.containsKey("visible") && (boolean)d4.get("visible"));
            }
            else {
                this.\u016f = 1.0;
                this.\u016a = false;
            }
            final Map<String, Object> d5 = this.\u0171.PetsItemsPetItemDefinition4("pierniczek", "crop_duplication");
            if (d5 != null) {
                this.\u0173 = (double)(d5.containsKey("chance") ? d5.get("chance") : 1.0);
                this.\u016c = (d5.containsKey("visible") && (boolean)d5.get("visible"));
            }
            else {
                this.\u0173 = 1.0;
                this.\u016c = false;
            }
            final Map<String, Object> d6 = this.\u0171.PetsItemsPetItemDefinition4("pierniczek", "stone_xp");
            if (d6 != null) {
                this.\u0174 = (int)(d6.containsKey("amount") ? d6.get("amount") : 2);
                this.\u0178 = (d6.containsKey("visible") && (boolean)d6.get("visible"));
            }
            else {
                this.\u0174 = 2;
                this.\u0178 = false;
            }
        }
        catch (final Exception ex) {
            this.\u017b = 0.9;
            this.\u017d = 0.025;
            this.\u0176 = 1.0;
            this.\u0169 = 4.0;
            this.\u0175 = false;
            this.\u016e = 1;
            this.\u0177 = false;
            this.\u016f = 1.0;
            this.\u016a = false;
            this.\u0173 = 1.0;
            this.\u016c = false;
            this.\u0174 = 2;
            this.\u0178 = false;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u0167 != null && this.\u016b != null && this.\u017f != null) {
            this.\u017c = true;
            this.\u0167.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u016b);
            this.\u0167.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u017f);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u0167 != null && this.\u016b != null && this.\u017f != null) {
            this.\u017c = false;
            this.\u0167.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u016b);
            this.\u0167.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u017f);
        }
    }
    
    @Override
    public void spawn(final Player \u0167, final String s) {
        this.\u0167 = \u0167;
        this.\u0165 = null;
        this.\u017e = null;
        final Location location = \u0167.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0176));
        String string;
        if (this.\u0171 != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u0171.PetsItemsPetItemDefinition2("pierniczek", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u0171.PetsItemsPetItemDefinition7("pierniczek").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWU2MzQ5MTJjNTI5NTNmMDMzZmExMTY2ODg2NjljOWE2ZDRkNTdkMzI1NjI5MTdiNTdkYTU4MzgwMmQ5ZjJlZSJ9fX0=");
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWU2MzQ5MTJjNTI5NTNmMDMzZmExMTY2ODg2NjljOWE2ZDRkNTdkMzI1NjI5MTdiNTdkYTU4MzgwMmQ5ZjJlZSJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u016b = (ArmorStand)\u0167.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u0171.PetsItemsPetItemDefinition12("pierniczek") + " &8\u25cf &f" + \u0167.getName()));
            this.PetsItemsPetItemDefinition12(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u0167.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u0171.PetsItemsPetItemDefinition1("pierniczek");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u017f = (ArmorStand)\u0167.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u0167.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u0167.getUniqueId());
        if (this.\u0169 > 0.0 && \u0167.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().noneMatch(attributeModifier -> attributeModifier.getUniqueId().equals(PetsItemsPetItemDefinition15.\u017a))) {
            \u0167.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier(PetsItemsPetItemDefinition15.\u017a, "Pierniczek hearts", this.\u0169, AttributeModifier.Operation.ADD_NUMBER));
        }
        if (this.\u016e > 0) {
            \u0167.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, this.\u016e - 1, false, false, this.\u0177));
        }
    }
    
    @Override
    public void update() {
        if (this.\u0167 == null || this.\u016b == null || this.\u017f == null || !this.\u0167.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u0167.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u0167.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u0176));
        this.\u016d += this.\u017d;
        final double n = this.\u016d % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u017b) : ((2.0 - n) * this.\u017b), 0.0);
        add.setYaw(location.getYaw());
        this.\u016b.teleport(add);
        this.\u017f.teleport(add.clone().add(0.0, (double)this.\u0171.PetsItemsPetItemDefinition1("pierniczek").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u0167) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u016b);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u017f);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u0167 || !this.\u017c) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u016b);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u017f);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u016b != null) {
            this.\u016b.remove();
        }
        if (this.\u017f != null) {
            this.\u017f.remove();
        }
        HandlerList.unregisterAll((Listener)this);
        if (this.\u0167 != null && this.\u0167.isOnline()) {
            this.\u0167.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().filter(attributeModifier -> attributeModifier.getUniqueId().equals(PetsItemsPetItemDefinition15.\u017a)).findFirst().ifPresent(attributeModifier2 -> this.\u0167.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier2));
            if (this.\u016e > 0) {
                this.\u0167.removePotionEffect(PotionEffectType.SPEED);
            }
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.\u0171.PetsItemsPetItemDefinition7("pierniczek").getString("name", "Pierniczek");
    }
    
    @EventHandler
    public void onBlockBreak(final BlockBreakEvent blockBreakEvent2) {
        if (this.\u0167 == null || !blockBreakEvent2.getPlayer().getUniqueId().equals(this.\u0167.getUniqueId())) {
            return;
        }
        final Material type = blockBreakEvent2.getBlock().getType();
        if ((PetsItemsPetItemDefinition15.\u0172.contains(type) && this.\u0166.nextDouble() < this.\u016f) || (PetsItemsPetItemDefinition15.\u0179.contains(type) && this.\u0166.nextDouble() < this.\u0173)) {
            if (blockBreakEvent2.getBlock().getBlockData() instanceof final Ageable ageable) {
                if (ageable.getAge() < ageable.getMaximumAge()) {
                    return;
                }
            }
            Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> {
                blockBreakEvent2.getBlock().getDrops(blockBreakEvent2.getPlayer().getInventory().getItemInMainHand());
                blockBreakEvent2.getBlock().getLocation().add(0.5, 0.5, 0.5);
                collection.iterator();
                final Iterator iterator;
                while (iterator.hasNext()) {
                    blockBreakEvent3.getBlock().getWorld().dropItemNaturally(location, iterator.next().clone());
                }
                return;
            }, 1L);
        }
        if ((type == Material.STONE || type == Material.DEEPSLATE) && this.\u0174 > 0) {
            blockBreakEvent2.setExpToDrop(blockBreakEvent2.getExpToDrop() + (this.\u0166.nextInt(this.\u0174) + 1));
        }
    }
    
    private void PetsItemsPetItemDefinition12(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    public double getHealthBonus() {
        return this.\u0169;
    }
    
    public boolean isHealthVisible() {
        return this.\u0175;
    }
    
    public int getSpeedLevel() {
        return this.\u016e;
    }
    
    public boolean isSpeedVisible() {
        return this.\u0177;
    }
    
    public double getOreDuplicationChance() {
        return this.\u016f;
    }
    
    public boolean isOreDuplicationVisible() {
        return this.\u016a;
    }
    
    public double getCropDuplicationChance() {
        return this.\u0173;
    }
    
    public boolean isCropDuplicationVisible() {
        return this.\u016c;
    }
    
    public int getStoneXpAmount() {
        return this.\u0174;
    }
    
    public boolean isStoneXpVisible() {
        return this.\u0178;
    }
    
    static {
        \u0170 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        \u017a = UUID.fromString("bbbbbbbb-cccc-dddd-eeee-ffffffffffff");
        \u0172 = new HashSet<Material>(Arrays.asList(Material.COAL_ORE, Material.DEEPSLATE_COAL_ORE, Material.IRON_ORE, Material.DEEPSLATE_IRON_ORE, Material.COPPER_ORE, Material.DEEPSLATE_COPPER_ORE, Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE, Material.REDSTONE_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.EMERALD_ORE, Material.DEEPSLATE_EMERALD_ORE, Material.LAPIS_ORE, Material.DEEPSLATE_LAPIS_ORE, Material.DIAMOND_ORE, Material.DEEPSLATE_DIAMOND_ORE, Material.NETHER_GOLD_ORE, Material.NETHER_QUARTZ_ORE, Material.ANCIENT_DEBRIS, Material.RAW_IRON_BLOCK, Material.RAW_GOLD_BLOCK, Material.RAW_COPPER_BLOCK));
        \u0179 = new HashSet<Material>(Arrays.asList(Material.WHEAT, Material.BEETROOTS, Material.CARROTS, Material.POTATOES, Material.MELON, Material.PUMPKIN, Material.SUGAR_CANE, Material.BAMBOO, Material.COCOA, Material.SWEET_BERRY_BUSH, Material.KELP, Material.SEA_PICKLE, Material.CACTUS, Material.BROWN_MUSHROOM, Material.RED_MUSHROOM, Material.NETHER_WART));
    }
}
