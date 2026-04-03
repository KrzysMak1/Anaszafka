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
import org.bukkit.Location;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
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

public class PetsItemsPetItemDefinition5 implements PetsItemsPetItemDefinition4, Listener
{
    private ArmorStand º;
    private ArmorStand \u00cf;
    private Player £;
    private final String ¥ = "cyber-obronca";
    private double \u00c1;
    private String ¢;
    private Date \u00ce;
    private static final SimpleDateFormat \u00c4;
    private boolean \u00cc;
    private boolean \u00c9;
    private PetsItemsPetItemDefinition7 \u00c5;
    private double \u00cd;
    private double \u00cb;
    private double \u00c7;
    private int \u00c2;
    private boolean \u00c0;
    private boolean \u00c3;
    private boolean µ;
    private int \u00ca;
    private boolean ¤;
    private int \u00c6;
    private boolean ª;
    private Map<UUID, BukkitTask> \u00c8;
    
    public PetsItemsPetItemDefinition5() {
        this.\u00c1 = 0.0;
        this.\u00cc = false;
        this.\u00c9 = true;
        this.\u00c8 = new HashMap<UUID, BukkitTask>();
        Bukkit.getPluginManager().registerEvents((Listener)this, Bukkit.getPluginManager().getPlugin("STORMSZAFKA"));
        this.\u00c5 = Main.getPetConfigManager();
        this.PetsItemsPetItemDefinition6();
    }
    
    private void PetsItemsPetItemDefinition6() {
        try {
            final Map<String, Object> d = this.\u00c5.PetsItemsPetItemDefinition4("cyber-obronca");
            if (d != null) {
                this.\u00cb = (double)(d.containsKey("height") ? d.get("height") : 0.9);
                this.\u00cd = (double)(d.containsKey("speed") ? d.get("speed") : 0.025);
                this.\u00c7 = (double)(d.containsKey("distance") ? d.get("distance") : 1.0);
            }
            else {
                this.\u00cb = 0.9;
                this.\u00cd = 0.025;
                this.\u00c7 = 1.0;
            }
            final Map<String, Object> d2 = this.\u00c5.PetsItemsPetItemDefinition4("cyber-obronca", "damage");
            if (d2 != null) {
                this.\u00c2 = (int)(d2.containsKey("amount") ? d2.get("amount") : 2);
                this.\u00c0 = (d2.containsKey("visible") && (boolean)d2.get("visible"));
            }
            else {
                this.\u00c2 = 2;
                this.\u00c0 = false;
            }
            final Map<String, Object> d3 = this.\u00c5.PetsItemsPetItemDefinition4("cyber-obronca", "health_view");
            if (d3 != null) {
                this.\u00c3 = (!d3.containsKey("enabled") || (boolean)d3.get("enabled"));
                this.µ = (d3.containsKey("visible") && (boolean)d3.get("visible"));
            }
            else {
                this.\u00c3 = true;
                this.µ = false;
            }
            final Map<String, Object> d4 = this.\u00c5.PetsItemsPetItemDefinition4("cyber-obronca", "haste");
            if (d4 != null) {
                this.\u00ca = (int)(d4.containsKey("level") ? d4.get("level") : 2);
                this.¤ = (d4.containsKey("visible") && (boolean)d4.get("visible"));
            }
            else {
                this.\u00ca = 2;
                this.¤ = false;
            }
            final Map<String, Object> d5 = this.\u00c5.PetsItemsPetItemDefinition4("cyber-obronca", "water_resistance");
            if (d5 != null) {
                this.\u00c6 = (int)(d5.containsKey("percentage") ? d5.get("percentage") : 30);
                this.ª = (d5.containsKey("visible") && (boolean)d5.get("visible"));
            }
            else {
                this.\u00c6 = 30;
                this.ª = false;
            }
        }
        catch (final Exception ex) {
            this.\u00cb = 0.9;
            this.\u00cd = 0.025;
            this.\u00c7 = 1.0;
            this.\u00c2 = 2;
            this.\u00c0 = false;
            this.\u00c3 = true;
            this.µ = false;
            this.\u00ca = 2;
            this.¤ = false;
            this.\u00c6 = 30;
            this.ª = false;
        }
    }
    
    @Override
    public void hideFromOwner() {
        if (this.£ != null && this.º != null && this.\u00cf != null) {
            this.\u00cc = true;
            this.£.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.º);
            this.£.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00cf);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.£ != null && this.º != null && this.\u00cf != null) {
            this.\u00cc = false;
            this.£.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.º);
            this.£.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00cf);
        }
    }
    
    @Override
    public void spawn(final Player £, final String s) {
        this.£ = £;
        this.¢ = null;
        this.\u00ce = null;
        final Location location = £.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u00c7));
        String string;
        if (this.\u00c5 != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u00c5.PetsItemsPetItemDefinition2("cyber-obronca", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u00c5.PetsItemsPetItemDefinition7("cyber-obronca").getString("texture.value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTE2Mzk1NDQ0NjZlNTU1OWE4YzViYzNjN2YwYzVmNzM4NjcwNmY3N2IwYTAwOTljZTU1NTU5OWRlNmJmZTk1NSJ9fX0=");
            }
        }
        else {
            string = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTE2Mzk1NDQ0NjZlNTU1OWE4YzViYzNjN2YwYzVmNzM4NjcwNmY3N2IwYTAwOTljZTU1NTU5OWRlNmJmZTk1NSJ9fX0=";
        }
        pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.º = (ArmorStand)£.getWorld().spawn(add, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u00c5.PetsItemsPetItemDefinition12("cyber-obronca") + " &8\u25cf &f" + £.getName()));
            this.PetsItemsPetItemDefinition4(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), £.getUniqueId());
        final Map<String, Object> PetsItemsPetItemDefinition13 = this.\u00c5.PetsItemsPetItemDefinition1("cyber-obronca");
        pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u00cf = (ArmorStand)£.getWorld().spawn(add.clone().add(0.0, (double)PetsItemsPetItemDefinition13.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + £.getName()));
            armorStand.setCustomNameVisible(true);
        }), £.getUniqueId());
        if (this.\u00ca > 0) {
            £.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, this.\u00ca - 1, false, false, this.¤));
        }
    }
    
    @Override
    public void update() {
        if (this.£ == null || this.º == null || this.\u00cf == null || !this.£.isOnline()) {
            return;
        }
        if (this.\u00ca > 0 && !this.£.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
            this.£.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, this.\u00ca - 1, false, false, this.¤));
        }
        final boolean hasPotionEffect = this.£.hasPotionEffect(PotionEffectType.INVISIBILITY);
        final Location location = this.£.getLocation();
        final Vector direction = location.getDirection();
        final Location add = location.clone().add(new Vector(-direction.getZ(), 0.0, direction.getX()).normalize().multiply(this.\u00c7));
        this.\u00c1 += this.\u00cd;
        final double n = this.\u00c1 % 2.0;
        add.add(0.0, (n <= 1.0) ? (n * this.\u00cb) : ((2.0 - n) * this.\u00cb), 0.0);
        add.setYaw(location.getYaw());
        this.º.teleport(add);
        this.\u00cf.teleport(add.clone().add(0.0, (double)this.\u00c5.PetsItemsPetItemDefinition1("cyber-obronca").get("height"), 0.0));
        if (hasPotionEffect) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.£) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.º);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00cf);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.£ || !this.\u00cc) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.º);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u00cf);
                }
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.º != null) {
            this.º.remove();
        }
        if (this.\u00cf != null) {
            this.\u00cf.remove();
        }
        final Iterator<BukkitTask> iterator = this.\u00c8.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().cancel();
        }
        this.\u00c8.clear();
        HandlerList.unregisterAll((Listener)this);
        if (this.\u00ca > 0 && this.£ != null && this.£.isOnline()) {
            this.£.removePotionEffect(PotionEffectType.FAST_DIGGING);
        }
    }
    
    @Override
    public String getDisplayName() {
        return this.\u00c5.PetsItemsPetItemDefinition7("cyber-obronca").getString("name", "Cyber-Obro\u0144ca");
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (this.£ != null && entityDamageByEntityEvent.getDamager() instanceof Player && this.\u00c9 && ((Player)entityDamageByEntityEvent.getDamager()).getUniqueId().equals(this.£.getUniqueId())) {
            entityDamageByEntityEvent.setDamage(entityDamageByEntityEvent.getDamage() + this.\u00c2);
            if (this.\u00c3 && entityDamageByEntityEvent.getEntity() instanceof Player) {
                this.PetsItemsPetItemDefinition1((Player)entityDamageByEntityEvent.getEntity());
            }
        }
    }
    
    @EventHandler
    public void onPlayerDamage(final EntityDamageEvent entityDamageEvent) {
        if (this.£ != null && entityDamageEvent.getEntity() instanceof Player && this.\u00c9) {
            final Player player = (Player)entityDamageEvent.getEntity();
            if (player.getUniqueId().equals(this.£.getUniqueId()) && player.isInWater()) {
                final double damage = entityDamageEvent.getDamage();
                entityDamageEvent.setDamage(damage - damage * (this.\u00c6 / 100.0));
            }
        }
    }
    
    private void PetsItemsPetItemDefinition1(final Player player) {
        if (this.\u00c8.containsKey(player.getUniqueId())) {
            this.\u00c8.get(player.getUniqueId()).cancel();
        }
        this.\u00c8.put(player.getUniqueId(), Bukkit.getScheduler().runTaskTimer(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> this.PetsItemsPetItemDefinition4(player2), 0L, 20L));
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), () -> {
            if (this.\u00c8.containsKey(player3.getUniqueId())) {
                this.\u00c8.get(player3.getUniqueId()).cancel();
                this.\u00c8.remove(player3.getUniqueId());
                if (this.£ != null && this.£.isOnline()) {
                    this.£.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(""));
                }
            }
        }, 100L);
    }
    
    private void PetsItemsPetItemDefinition4(final Player player) {
        if (this.£ != null && this.£.isOnline() && player.isOnline()) {
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
            this.£.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(sb.toString()));
        }
    }
    
    private void PetsItemsPetItemDefinition4(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    static {
        \u00c4 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
