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
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.HandlerList;
import java.util.Iterator;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Location;
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

public class PetsItemsPetItemDefinition18 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand \u01a0;
    private ArmorStand \u01b0;
    private Player \u019d;
    private final String \u019f = "telekrolik";
    private double \u01a3;
    private String \u019c;
    private Date \u01af;
    private static final SimpleDateFormat \u01a6;
    private boolean \u01ad;
    private boolean \u01ab;
    private PetsItemsPetItemDefinition7 \u01a7;
    private double \u01ae;
    private double \u01ac;
    private double \u01a9;
    private int \u01a4;
    private boolean \u01a1;
    private double \u01a5;
    private boolean \u019e;
    private int \u01a8;
    private boolean \u01a2;
    private Map<UUID, BukkitTask> \u01aa;
    
    public PetsItemsPetItemDefinition18() {
        this.\u01a3 = 0.0;
        this.\u01ad = false;
        this.\u01ab = true;
        this.\u01aa = new HashMap<UUID, BukkitTask>();
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u01a7 = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition20();
    }
    
    private void PetsItemsPetItemDefinition20() {
        try {
            final Map<String, Object> d = this.\u01a7.PetsItemsPetItemDefinition4("telekrolik");
            if (d != null) {
                this.\u01ac = (double)(d.containsKey("height") ? d.get("height") : 0.9);
                this.\u01ae = (double)(d.containsKey("speed") ? d.get("speed") : 0.025);
                this.\u01a9 = (double)(d.containsKey("distance") ? d.get("distance") : 1.0);
            }
            else {
                this.\u01ac = 0.9;
                this.\u01ae = 0.025;
                this.\u01a9 = 1.0;
            }
            final Map<String, Object> d2 = this.\u01a7.PetsItemsPetItemDefinition4("telekrolik", "damage");
            if (d2 != null) {
                this.\u01a4 = (int)(d2.containsKey("amount") ? d2.get("amount") : 3);
                this.\u01a1 = (d2.containsKey("visible") && (boolean)d2.get("visible"));
            }
            else {
                this.\u01a4 = 3;
                this.\u01a1 = false;
            }
            final Map<String, Object> d3 = this.\u01a7.PetsItemsPetItemDefinition4("telekrolik", "damage_reduction");
            if (d3 != null) {
                this.\u01a5 = (double)(d3.containsKey("percentage") ? d3.get("percentage") : 0.1);
                this.\u019e = (d3.containsKey("visible") && (boolean)d3.get("visible"));
            }
            else {
                this.\u01a5 = 0.1;
                this.\u019e = false;
            }
            final Map<String, Object> d4 = this.\u01a7.PetsItemsPetItemDefinition4("telekrolik", "health_tracking");
            if (d4 != null) {
                this.\u01a8 = (int)(d4.containsKey("duration") ? d4.get("duration") : 5);
                this.\u01a2 = (d4.containsKey("visible") && (boolean)d4.get("visible"));
            }
            else {
                this.\u01a8 = 5;
                this.\u01a2 = false;
            }
        }
        catch (final Exception ex) {
            this.\u01ac = 0.9;
            this.\u01ae = 0.025;
            this.\u01a9 = 1.0;
            this.\u01a4 = 3;
            this.\u01a1 = false;
            this.\u01a5 = 0.1;
            this.\u019e = false;
            this.\u01a8 = 5;
            this.\u01a2 = false;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u019d != null && this.\u01a0 != null && this.\u01b0 != null) {
            this.\u01ad = true;
            this.\u019d.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01a0);
            this.\u019d.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01b0);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u019d != null && this.\u01a0 != null && this.\u01b0 != null) {
            this.\u01ad = false;
            this.\u019d.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01a0);
            this.\u019d.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01b0);
        }
    }
    
    @Override
    public void spawn(final Player \u0272, final String s) {
        this.\u019d = \u0272;
        this.\u019c = null;
        this.\u01af = null;
        final Location location = \u0272.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u01a9));
        String string;
        if (this.\u01a7 != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u01a7.PetsItemsPetItemDefinition2("telekrolik", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u01a7.PetsItemsPetItemDefinition7("telekrolik").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2RmMjkyNmU5NzA2MTFhNjlkZTczMjZiZjgzNWY2YzA1OTI1M2NiNmUzN2UzZjgxZTc2NzZiZTE4MWQ4Mzg4MCJ9fX0=");
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2RmMjkyNmU5NzA2MTFhNjlkZTczMjZiZjgzNWY2YzA1OTI1M2NiNmUzN2UzZjgxZTc2NzZiZTE4MWQ4Mzg4MCJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u01a0 = (ArmorStand)\u0272.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u01a7.PetsItemsPetItemDefinition12("telekrolik") + " &8\u25cf &f" + \u0272.getName()));
            this.PetsItemsPetItemDefinition17(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u0272.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u01a7.PetsItemsPetItemDefinition1("telekrolik");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u01b0 = (ArmorStand)\u0272.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u0272.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u0272.getUniqueId());
    }
    
    @Override
    public void update() {
        if (this.\u019d == null || this.\u01a0 == null || this.\u01b0 == null || !this.\u019d.isOnline()) {
            return;
        }
        final boolean hasPotionEffect = this.\u019d.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.\u019d.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u01a9));
        this.\u01a3 += this.\u01ae;
        final double n = this.\u01a3 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u01ac) : ((2.0 - n) * this.\u01ac), 0.0);
        add.setYaw(location.getYaw());
        this.\u01a0.teleport(add);
        this.\u01b0.teleport(add.clone().add(0.0, (double)this.\u01a7.PetsItemsPetItemDefinition1("telekrolik").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u019d) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01a0);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01b0);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u019d || !this.\u01ad) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01a0);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u01b0);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u01a0 != null) {
            this.\u01a0.remove();
        }
        if (this.\u01b0 != null) {
            this.\u01b0.remove();
        }
        final Iterator<BukkitTask> iterator = this.\u01aa.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().cancel();
        }
        this.\u01aa.clear();
        this.deactivateEffect();
        HandlerList.unregisterAll((Listener)this);
    }
    
    @Override
    public String getDisplayName() {
        return this.\u01a7.PetsItemsPetItemDefinition7("telekrolik").getString("name", "Telekr\u00f3lik");
    }
    
    public void deactivateEffect() {
        this.\u01ab = false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (this.\u019d != null && entityDamageByEntityEvent.getDamager() instanceof Player && this.\u01ab && ((Player)entityDamageByEntityEvent.getDamager()).getUniqueId().equals(this.\u019d.getUniqueId())) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() + this.\u01a4);
            if (entityDamageByEntityEvent.getEntity() instanceof final Player player) {
                this.PetsItemsPetItemDefinition12(player);
            }
        }
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.\u019d != null && entityDamageEvent.getEntity() instanceof Player && this.\u01ab && ((Player)entityDamageEvent.getEntity()).getUniqueId().equals(this.\u019d.getUniqueId())) {
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() * (1.0 - this.\u01a5));
        }
    }
    
    private void PetsItemsPetItemDefinition12(final Player player) {
        if (this.\u01aa.containsKey(player.getUniqueId())) {
            this.\u01aa.get(player.getUniqueId()).cancel();
        }
        this.\u01aa.put(player.getUniqueId(), Bukkit.getScheduler().runTaskTimer(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> this.PetsItemsPetItemDefinition9(player2), 0L, 20L));
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> {
            if (this.\u01aa.containsKey(player3.getUniqueId())) {
                this.\u01aa.get(player3.getUniqueId()).cancel();
                this.\u01aa.remove(player3.getUniqueId());
                if (this.\u019d != null && this.\u019d.isOnline()) {
                    this.\u019d.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(""));
                }
            }
        }, this.\u01a8 * 20L);
    }
    
    private void PetsItemsPetItemDefinition9(final Player player) {
        if (this.\u019d != null && this.\u019d.isOnline() && player.isOnline()) {
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
            this.\u019d.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(sb.toString()));
        }
    }
    
    private void PetsItemsPetItemDefinition17(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    public int getDamageAmount() {
        return this.\u01a4;
    }
    
    public boolean isDamageVisible() {
        return this.\u01a1;
    }
    
    public double getDamageReduction() {
        return this.\u01a5;
    }
    
    public boolean isDamageReductionVisible() {
        return this.\u019e;
    }
    
    public int getHealthTrackingDuration() {
        return this.\u01a8;
    }
    
    public boolean isHealthTrackingVisible() {
        return this.\u01a2;
    }
    
    static {
        \u01a6 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
