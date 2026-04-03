// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.items;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import pl.ziffy.STORMSZAFKA.utils.PetsItemsPetItemDefinition3;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.Vector;
import java.util.Iterator;
import org.bukkit.Sound;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition5;
import org.bukkit.entity.Entity;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.Map;
import pl.ziffy.STORMSZAFKA.Main;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition7;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.entity.ArmorStand;
import pl.ziffy.STORMSZAFKA.pets.PetsItemsPetItemDefinition4;

public class PetsItemsPetItemDefinition1 implements PetsItemsPetItemDefinition4
{
    private ArmorStand \u03c2;
    private ArmorStand \u03d5;
    private Player \u03bd;
    private final String \u03c1 = "pedziwiatr";
    private double \u03c4;
    private String \u03bc;
    private Date \u03d3;
    private static final SimpleDateFormat \u03c6;
    private boolean \u03d1;
    private PetsItemsPetItemDefinition7 \u03c7;
    private long \u03c5;
    private double \u03d2;
    private double \u03ce;
    private double \u03cb;
    private int \u03c9;
    private int \u03bf;
    private boolean \u03ca;
    private boolean \u03cc;
    private boolean \u03c8;
    private boolean \u03c0;
    private boolean \u03be;
    private String \u03d4;
    private boolean \u03d0;
    private String \u03cd;
    private int \u03c3;
    
    public PetsItemsPetItemDefinition1() {
        this.\u03c4 = 0.0;
        this.\u03d1 = false;
        this.\u03c5 = 0L;
        this.\u03cc = true;
        this.\u03c7 = Main.getPetConfigManager();
        this.h();
    }
    
    private void h() {
        final Map<String, Object> d = this.\u03c7.PetsItemsPetItemDefinition4("pedziwiatr");
        this.\u03ce = (double)d.get("height");
        this.\u03d2 = (double)d.get("speed");
        this.\u03cb = (double)d.get("distance");
        final Map<String, Object> d2 = this.\u03c7.PetsItemsPetItemDefinition4("pedziwiatr", "speed");
        this.\u03c9 = (int)(d2.containsKey("level") ? d2.get("level") : 1);
        this.\u03bf = (int)(d2.containsKey("duration") ? d2.get("duration") : 12000);
        this.\u03ca = (d2.containsKey("visible") && (boolean)d2.get("visible"));
        final FileConfiguration g = this.\u03c7.PetsItemsPetItemDefinition7("pedziwiatr");
        final FileConfiguration config = Main.getInstance().getConfig();
        this.\u03c8 = (g.isSet("animation.floating_enabled") ? g.getBoolean("animation.floating_enabled") : config.getBoolean("pets.animation.floating_enabled", true));
        this.\u03c0 = (g.isSet("animation.rotate_with_player") ? g.getBoolean("animation.rotate_with_player") : config.getBoolean("pets.animation.rotate_with_player", true));
        this.\u03be = (g.isSet("animation.hide_when_player_invisible") ? g.getBoolean("animation.hide_when_player_invisible") : config.getBoolean("pets.animation.hide_when_player_invisible", true));
        this.\u03d4 = (g.isSet("animation.position") ? g.getString("animation.position") : config.getString("pets.animation.default_position", "RIGHT"));
        this.\u03d0 = (g.isSet("animation.sounds_enabled") ? g.getBoolean("animation.sounds_enabled") : config.getBoolean("pets.animation.sounds_enabled", false));
        this.\u03cd = (g.isSet("animation.sound_type") ? g.getString("animation.sound_type") : "ENTITY_BAT_AMBIENT");
        this.\u03c3 = (g.isSet("animation.sound_interval") ? g.getInt("animation.sound_interval") : 30);
    }
    
    @Override
    public void hideFromOwner() {
        if (this.\u03bd != null && this.\u03c2 != null && this.\u03d5 != null) {
            this.\u03d1 = true;
            this.\u03bd.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03c2);
            this.\u03bd.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03d5);
        }
    }
    
    @Override
    public void showToOwner() {
        if (this.\u03bd != null && this.\u03c2 != null && this.\u03d5 != null) {
            this.\u03d1 = false;
            this.\u03bd.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03c2);
            this.\u03bd.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03d5);
        }
    }
    
    @Override
    public void spawn(final Player \u03bd, final String s) {
        this.\u03bd = \u03bd;
        this.\u03bc = null;
        this.\u03d3 = null;
        final Location location = \u03bd.getLocation();
        final Location PetsItemsPetItemDefinition13 = this.PetsItemsPetItemDefinition1(location, location.getDirection());
        String string;
        if (this.\u03c7 != null) {
            final Object PetsItemsPetItemDefinition14 = this.\u03c7.PetsItemsPetItemDefinition2("pedziwiatr", "item.texture.value");
            if (PetsItemsPetItemDefinition14 instanceof final String s2) {
                string = s2;
            }
            else {
                string = this.\u03c7.PetsItemsPetItemDefinition7("pedziwiatr").getString("texture.value", "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzYyNmIxZmY1ZmQyY2IwYzFhZWI1MzYxMzIzMmZmZThhYjgxYmQzM2Q1NWJlMWYzYTkyZTdkNmZjN2ZkNjNhMCJ9fX0=");
            }
        }
        else {
            string = "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzYyNmIxZmY1ZmQyY2IwYzFhZWI1MzYxMzIzMmZmZThhYjgxYmQzM2Q1NWJlMWYzYTkyZTdkNmZjN2ZkNjNhMCJ9fX0=";
        }
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition2(this.\u03c2 = (ArmorStand)\u03bd.getWorld().spawn(PetsItemsPetItemDefinition13, (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomNameVisible(false);
            final ItemStack helmet = new ItemStack(Material.PLAYER_HEAD);
            final SkullMeta itemMeta = (SkullMeta)helmet.getItemMeta();
            itemMeta.setDisplayName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(this.\u03c7.PetsItemsPetItemDefinition12("pedziwiatr") + " &8\u25cf &f" + \u03bd.getName()));
            this.PetsItemsPetItemDefinition14(itemMeta, string);
            helmet.setItemMeta((ItemMeta)itemMeta);
            armorStand.setHelmet(helmet);
        }), \u03bd.getUniqueId());
        final Map<String, Object> a2 = this.\u03c7.PetsItemsPetItemDefinition1("pedziwiatr");
        PetsItemsPetItemDefinition5.PetsItemsPetItemDefinition1(this.\u03d5 = (ArmorStand)\u03bd.getWorld().spawn(PetsItemsPetItemDefinition13.clone().add(0.0, (double)a2.get("height"), 0.0), (Class)ArmorStand.class, armorStand -> {
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.setCustomName(PetsItemsPetItemDefinition7.PetsItemsPetItemDefinition3(s + " &8\u25cf &f" + \u03bd.getName()));
            armorStand.setCustomNameVisible(true);
        }), \u03bd.getUniqueId());
        \u03bd.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, this.\u03bf, this.\u03c9 - 1, false, this.\u03ca));
    }
    
    @Override
    public void update() {
        if (this.\u03bd == null || this.\u03c2 == null || this.\u03d5 == null || !this.\u03bd.isOnline()) {
            return;
        }
        if (!this.\u03bd.hasPotionEffect(PotionEffectType.SPEED) && this.\u03cc) {
            this.\u03bd.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, this.\u03bf, this.\u03c9 - 1, false, this.\u03ca));
        }
        final boolean PetsItemsPetItemDefinition14 = this.\u03bd.hasPotionEffect(PotionEffectType.INVISIBILITY) || this.\u03bd.getGameMode() == GameMode.SPECTATOR;
        final Location location = this.\u03bd.getLocation();
        final Location PetsItemsPetItemDefinition13 = this.PetsItemsPetItemDefinition1(location, location.getDirection());
        if (this.\u03c8) {
            this.\u03c4 += this.\u03d2;
            final double n = this.\u03c4 % 2.0;
            PetsItemsPetItemDefinition13.add(0.0, (n <= 1.0) ? (n * this.\u03ce) : ((2.0 - n) * this.\u03ce), 0.0);
        }
        if (this.\u03c0) {
            PetsItemsPetItemDefinition13.setYaw(location.getYaw());
        }
        this.\u03c2.teleport(PetsItemsPetItemDefinition13);
        this.\u03d5.teleport(PetsItemsPetItemDefinition13.clone().add(0.0, (double)this.\u03c7.PetsItemsPetItemDefinition1("pedziwiatr").get("height"), 0.0));
        if (this.\u03d0) {
            final long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.\u03c5 > this.\u03c3 * 1000) {
                try {
                    this.\u03bd.getWorld().playSound(PetsItemsPetItemDefinition13, Sound.valueOf(this.\u03cd), 0.5f, 1.0f);
                    this.\u03c5 = currentTimeMillis;
                }
                catch (final IllegalArgumentException ex) {}
            }
        }
        if (PetsItemsPetItemDefinition14 && this.\u03be) {
            for (final Player player : Bukkit.getOnlinePlayers()) {
                if (player != this.\u03bd) {
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03c2);
                    player.hideEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03d5);
                }
            }
        }
        else {
            for (final Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2 != this.\u03bd || !this.\u03d1) {
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03c2);
                    player2.showEntity(Bukkit.getPluginManager().getPlugin("STORMSZAFKA"), (Entity)this.\u03d5);
                }
            }
        }
    }
    
    private Location PetsItemsPetItemDefinition1(final Location location, final Vector vector) {
        final Vector normalize = new Vector(-vector.getZ(), 0.0, vector.getX()).normalize();
        final Vector normalize2 = vector.clone().normalize();
        final String upperCase = this.\u03d4.toUpperCase();
        switch (upperCase) {
            case "LEFT": {
                return location.clone().add(normalize.clone().multiply(-this.\u03cb));
            }
            case "FRONT": {
                return location.clone().add(normalize2.multiply(this.\u03cb));
            }
            case "BACK": {
                return location.clone().add(normalize2.multiply(-this.\u03cb));
            }
            default: {
                return location.clone().add(normalize.multiply(this.\u03cb));
            }
        }
    }
    
    @Override
    public void remove() {
        if (this.\u03c2 != null) {
            this.\u03c2.remove();
        }
        if (this.\u03d5 != null) {
            this.\u03d5.remove();
        }
        if (this.\u03bd != null && this.\u03bd.isOnline()) {
            this.\u03bd.removePotionEffect(PotionEffectType.SPEED);
        }
        this.\u03cc = false;
    }
    
    @Override
    public String getDisplayName() {
        return this.\u03c7.PetsItemsPetItemDefinition7("pedziwiatr").getString("name", "PetsItemsPetItemDefinition18\u0119dziwiatr");
    }
    
    private void PetsItemsPetItemDefinition14(final SkullMeta skullMeta, final String s) {
        PetsItemsPetItemDefinition3.PetsItemsPetItemDefinition4(skullMeta, s);
    }
    
    public int i() {
        return this.\u03c9;
    }
    
    public boolean g() {
        return this.\u03ca;
    }
    
    @Override
    public boolean shouldFloatUpDown() {
        return this.\u03c8;
    }
    
    @Override
    public boolean shouldRotateWithPlayer() {
        return this.\u03c0;
    }
    
    @Override
    public boolean shouldHideWhenPlayerInvisible() {
        return this.\u03be;
    }
    
    @Override
    public String getPosition() {
        return this.\u03d4;
    }
    
    @Override
    public boolean hasParticleEffects() {
        return false;
    }
    
    @Override
    public String getParticleType() {
        return "CLOUD";
    }
    
    @Override
    public boolean hasSoundEffects() {
        return this.\u03d0;
    }
    
    @Override
    public String getSoundType() {
        return this.\u03cd;
    }
    
    @Override
    public int getSoundInterval() {
        return this.\u03c3;
    }
    
    static {
        \u03c6 = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
    }
}
