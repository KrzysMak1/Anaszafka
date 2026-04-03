// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import java.util.HashSet;
import java.util.Arrays;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Collection;
import pl.ziffy.STORMSZAFKA.utils.C;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.HandlerList;
import java.util.Iterator;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Location;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
import pl.ziffy.STORMSZAFKA.pets.E;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import java.util.Set;
import java.util.UUID;
import pl.ziffy.STORMSZAFKA.pets.G;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.Listener;
import pl.ziffy.STORMSZAFKA.pets.D;

public class S implements D, Listener
{
    private ArmorStand \u01e6;
    private ArmorStand \u01f4;
    private Player \u01e0;
    private final String \u01e2 = "pisklak";
    private double \u01e7;
    private String \u01de;
    private Date \u01f3;
    private static final SimpleDateFormat \u01e8;
    private boolean \u01f0;
    private Random \u01df;
    private G \u01e9;
    private static final UUID \u01ee;
    private double \u01f1;
    private double \u01ef;
    private double \u01ec;
    private int \u01e3;
    private boolean \u01eb;
    private double \u01e5;
    private boolean \u01e1;
    private int \u01e4;
    private boolean \u01f2;
    private static final Set<Material> \u01ea;
    private static final Set<Material> \u01ed;
    
    public S() {
        this.\u01e7 = 0.0;
        this.\u01f0 = false;
        this.\u01df = new Random();
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u01e9 = Main.getPetConfigManager();
        this.U();
    }
    
    private void U() {
        try {
            final Map<String, Object> d = this.\u01e9.D("pisklak");
            if (d != null) {
                this.\u01ef = (double)(d.containsKey("height") ? d.get("height") : 1.0);
                this.\u01f1 = (double)(d.containsKey("speed") ? d.get("speed") : 0.025);
                this.\u01ec = (double)(d.containsKey("distance") ? d.get("distance") : 1.0);
            }
            else {
                this.\u01ef = 1.0;
                this.\u01f1 = 0.025;
                this.\u01ec = 1.0;
            }
            final Map<String, Object> d2 = this.\u01e9.D("pisklak", "health");
            if (d2 != null) {
                this.\u01e3 = (int)(d2.containsKey("bonus") ? d2.get("bonus") : 4);
                this.\u01eb = (!d2.containsKey("visible") || (boolean)d2.get("visible"));
            }
            else {
                this.\u01e3 = 4;
                this.\u01eb = true;
            }
            final Map<String, Object> d3 = this.\u01e9.D("pisklak", "defense");
            if (d3 != null) {
                this.\u01e5 = (double)(d3.containsKey("percentage") ? d3.get("percentage") : 0.1);
                this.\u01e1 = (!d3.containsKey("visible") || (boolean)d3.get("visible"));
            }
            else {
                this.\u01e5 = 0.1;
                this.\u01e1 = true;
            }
            final Map<String, Object> d4 = this.\u01e9.D("pisklak", "drop");
            if (d4 != null) {
                this.\u01e4 = (int)(d4.containsKey("multiplier") ? d4.get("multiplier") : 2);
                this.\u01f2 = (!d4.containsKey("visible") || (boolean)d4.get("visible"));
            }
            else {
                this.\u01e4 = 2;
                this.\u01f2 = true;
            }
        }
        catch (final Exception ex) {
            this.\u01ef = 1.0;
            this.\u01f1 = 0.025;
            this.\u01ec = 1.0;
            this.\u01e3 = 4;
            this.\u01eb = true;
            this.\u01e5 = 0.1;
            this.\u01e1 = true;
            this.\u01e4 = 2;
            this.\u01f2 = true;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u01e0 != null && this.\u01e6 != null && this.\u01f4 != null) {
            this.\u01f0 = true;
            this.\u01e0.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01e6);
            this.\u01e0.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01f4);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u01e0 != null && this.\u01e6 != null && this.\u01f4 != null) {
            this.\u01f0 = false;
            this.\u01e0.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01e6);
            this.\u01e0.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01f4);
        }
    }
    
    @Override
    public void spawn(final Player \u01e1, final String s) {
        this.\u01e0 = \u01e1;
        this.\u01de = null;
        this.\u01f3 = null;
        final Location location = \u01e1.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u01ec));
        String string;
        if (this.\u01e9 != null) {
            final Object b = this.\u01e9.B("pisklak", "item.texture.value");
            if (b instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u01e9.G("pisklak").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzkzMjkyMGY4MWI2YzU2ZmVkNmNkNWUwNzc3MmZkNTQwMjQ2NTgyMjkyYjU2YzAzNDViZWIzMGQwMzNkNmVhYiJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzkzMjkyMGY4MWI2YzU2ZmVkNmNkNWUwNzc3MmZkNTQwMjQ2NTgyMjkyYjU2YzAzNDViZWIzMGQwMzNkNmVhYiJ9fX0=";
        }
        E.B(this.\u01e6 = (ArmorStand)\u01e1.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(G.C(this.\u01e9.L("pisklak") + " &8\u25cf &f" + \u01e1.getName()));
            this.R(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u01e1.getUniqueId());
        final Map<String, Object> a = this.\u01e9.A("pisklak");
        E.A(this.\u01f4 = (ArmorStand)\u01e1.getWorld().spawn(add.clone().add(0.0, (double)a.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(G.C(s + " &8\u25cf &f" + \u01e1.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u01e1.getUniqueId());
        \u01e1.setFoodLevel(20);
        \u01e1.setSaturation(20.0f);
        if (\u01e1.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().noneMatch(attributeModifier -> attributeModifier.getUniqueId().equals(S.\u01ee))) {
            \u01e1.getAttribute(Attribute.GENERIC_MAX_HEALTH).addModifier(new AttributeModifier(S.\u01ee, "Pisklak hearts", (double)this.\u01e3, AttributeModifier.Operation.ADD_NUMBER));
        }
    }
    
    @Override
    public void update() {
        if (this.\u01e0 == null || this.\u01e6 == null || this.\u01f4 == null || !this.\u01e0.isOnline()) {
            return;
        }
        if (this.\u01e0.getFoodLevel() < 20) {
            this.\u01e0.setFoodLevel(20);
            this.\u01e0.setSaturation(20.0f);
        }
        final boolean hasPotionEffect = this.\u01e0.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u01e0.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u01ec));
        this.\u01e7 += this.\u01f1;
        final double n = this.\u01e7 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u01ef) : ((2.0 - n) * this.\u01ef), 0.0);
        add.setYaw(location.getYaw());
        this.\u01e6.teleport(add);
        this.\u01f4.teleport(add.clone().add(0.0, (double)this.\u01e9.A("pisklak").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u01e0) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01e6);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01f4);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u01e0 || !this.\u01f0) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01e6);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01f4);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u01e6 != null) {
            this.\u01e6.remove();
        }
        if (this.\u01f4 != null) {
            this.\u01f4.remove();
        }
        HandlerList.unregisterAll((Listener)this);
        if (this.\u01e0 != null && this.\u01e0.isOnline()) {
            this.\u01e0.getAttribute(Attribute.GENERIC_MAX_HEALTH).getModifiers().stream().filter(attributeModifier -> attributeModifier.getUniqueId().equals(S.\u01ee)).findFirst().ifPresent(attributeModifier2 -> this.\u01e0.getAttribute(Attribute.GENERIC_MAX_HEALTH).removeModifier(attributeModifier2));
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.\u01e9.G("pisklak").getString("name", "Pisklak");
    }
    
    @EventHandler
    public void onFoodLevelChange(final FoodLevelChangeEvent foodLevelChangeEvent) {
        if (this.\u01e0 != null && foodLevelChangeEvent.getEntity() instanceof Player) {
            final Player player = (Player)foodLevelChangeEvent.getEntity();
            if (player.getUniqueId().equals(this.\u01e0.getUniqueId()) && foodLevelChangeEvent.getFoodLevel() < player.getFoodLevel()) {
                foodLevelChangeEvent.setCancelled(true);
                player.setFoodLevel(20);
                player.setSaturation(20.0f);
            }
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.\u01e0 != null && entityDamageEvent.getEntity() instanceof Player && ((Player)entityDamageEvent.getEntity()).getUniqueId().equals(this.\u01e0.getUniqueId())) {
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u01e5));
        }
    }
    
    @EventHandler
    public void onBlockBreak(final BlockBreakEvent blockBreakEvent2) {
        if (this.\u01e0 == null || !blockBreakEvent2.getPlayer().getUniqueId().equals(this.\u01e0.getUniqueId())) {
            return;
        }
        final Material type = blockBreakEvent2.getBlock().getType();
        if (S.\u01ea.contains(type) || S.\u01ed.contains(type)) {
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
                    iterator.next().clone();
                    final ItemStack itemStack;
                    if (this.\u01e4 > 1) {
                        itemStack.setAmount(itemStack.getAmount() * (this.\u01e4 - 1));
                    }
                    blockBreakEvent3.getBlock().getWorld().dropItemNaturally(location, itemStack);
                }
            }, 1L);
        }
    }
    
    private void R(final SkullMeta skullMeta, final String s) {
        C.D(skullMeta, s);
    }
    
    public int getHealthBonus() {
        return this.\u01e3;
    }
    
    public boolean isHealthBonusVisible() {
        return this.\u01eb;
    }
    
    public double getDefensePercentage() {
        return this.\u01e5;
    }
    
    public boolean isDefenseVisible() {
        return this.\u01e1;
    }
    
    public int getDropMultiplier() {
        return this.\u01e4;
    }
    
    public boolean isDropMultiplierVisible() {
        return this.\u01f2;
    }
    
    static {
        \u01e8 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        \u01ee = UUID.fromString("cccccccc-dddd-eeee-ffff-000000000000");
        \u01ea = new HashSet<Material>(Arrays.asList(Material.COAL_ORE, Material.DEEPSLATE_COAL_ORE, Material.IRON_ORE, Material.DEEPSLATE_IRON_ORE, Material.COPPER_ORE, Material.DEEPSLATE_COPPER_ORE, Material.GOLD_ORE, Material.DEEPSLATE_GOLD_ORE, Material.REDSTONE_ORE, Material.DEEPSLATE_REDSTONE_ORE, Material.EMERALD_ORE, Material.DEEPSLATE_EMERALD_ORE, Material.LAPIS_ORE, Material.DEEPSLATE_LAPIS_ORE, Material.DIAMOND_ORE, Material.DEEPSLATE_DIAMOND_ORE, Material.NETHER_GOLD_ORE, Material.NETHER_QUARTZ_ORE, Material.ANCIENT_DEBRIS, Material.RAW_IRON_BLOCK, Material.RAW_GOLD_BLOCK, Material.RAW_COPPER_BLOCK));
        \u01ed = new HashSet<Material>(Arrays.asList(Material.WHEAT, Material.BEETROOTS, Material.CARROTS, Material.POTATOES, Material.MELON, Material.PUMPKIN, Material.SUGAR_CANE, Material.BAMBOO, Material.COCOA, Material.SWEET_BERRY_BUSH, Material.KELP, Material.SEA_PICKLE, Material.CACTUS, Material.BROWN_MUSHROOM, Material.RED_MUSHROOM, Material.NETHER_WART));
    }
}
