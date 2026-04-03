// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.regions;

import org.bukkit.World;
import org.bukkit.Bukkit;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.configuration.file.FileConfiguration;
import java.io.File;
import org.bukkit.Location;
import java.util.UUID;
import java.util.Map;
import org.bukkit.plugin.Plugin;

public class RegionsRegionService2
{
    private final Plugin RegionsListener1;
    private final Map<UUID, Location> D;
    private final Map<String, _A> E;
    private File RegionsRegionService2;
    private FileConfiguration RegionsRegionService1;
    
    public RegionsRegionService2(final Plugin c) {
        this.D = new HashMap<UUID, Location>();
        this.E = new HashMap<String, _A>();
        this.RegionsListener1 = c;
        this.RegionsRegionService2 = new File(c.getDataFolder(), "regions.yml");
        this.RegionsListener1();
    }
    
    public void RegionsRegionService2(final Player player, final Location location) {
        this.D.put(player.getUniqueId(), location);
        player.sendMessage("§8[§x§RegionsRegionService2§3§0§0§F§F\ud83e\ude93§8] §7Zaznaczono §fpozycj\u0119 1§7: §f" + this.RegionsListener1(location));
    }
    
    public void RegionsRegionService1(final Player player, final Location location) {
        final Location location2 = this.D.get(player.getUniqueId());
        if (location2 == null) {
            player.sendMessage("§8[§x§RegionsRegionService2§3§0§0§F§F\ud83e\ude93§8] §cNie zaznaczono pierwszej pozycji!");
            return;
        }
        if (!location2.getWorld().equals((Object)location.getWorld())) {
            player.sendMessage("§8[§x§RegionsRegionService2§3§0§0§F§F\ud83e\ude93§8] §cObie pozycje musz\u0105 by\u0107 w tym samym \u015bwiecie!");
            this.D.remove(player.getUniqueId());
            return;
        }
        player.sendMessage("§8[§x§RegionsRegionService2§3§0§0§F§F\ud83e\ude93§8] §7Zaznaczono §fpozycj\u0119 2§7: §f" + this.RegionsListener1(location));
        player.sendMessage("§8[§x§RegionsRegionService2§3§0§0§F§F\ud83e\ude93§8] §7Selekcja gotowa! U\u017cyj: §f/stormszafka region create <nazwa>");
    }
    
    public boolean RegionsRegionService2(final Player player) {
        return this.D.containsKey(player.getUniqueId());
    }
    
    public boolean RegionsRegionService1(final Player player, final String s) {
        final Location location = this.D.get(player.getUniqueId());
        if (location == null) {
            return false;
        }
        if (this.E.containsKey(s.toLowerCase())) {
            return false;
        }
        this.E.put(s.toLowerCase(), new _A(s, location));
        this.D();
        return true;
    }
    
    public boolean RegionsRegionService2(final Player player, final String s) {
        final Location location = this.D.get(player.getUniqueId());
        if (location == null) {
            return false;
        }
        final _A a = this.E.get(s.toLowerCase());
        if (a == null) {
            return false;
        }
        a.RegionsRegionService1(location);
        this.D();
        return true;
    }
    
    public boolean RegionsRegionService1(final String s) {
        if (this.E.remove(s.toLowerCase()) != null) {
            this.D();
            return true;
        }
        return false;
    }
    
    public boolean RegionsRegionService2(final String s) {
        return this.E.containsKey(s.toLowerCase());
    }
    
    public List<String> RegionsRegionService1() {
        return new ArrayList<String>(this.E.keySet());
    }
    
    public void RegionsListener1(final Player player) {
        this.D.remove(player.getUniqueId());
    }
    
    public boolean RegionsRegionService1(final Location location, final String s) {
        final _A a = this.E.get(s.toLowerCase());
        return a != null && a.RegionsRegionService2(location);
    }
    
    public String RegionsRegionService1(final Location location) {
        for (final _A a : this.E.values()) {
            if (a.RegionsRegionService2(location)) {
                return a.RegionsRegionService2();
            }
        }
        return null;
    }
    
    public boolean RegionsRegionService2(final Location location) {
        if (location == null) {
            return false;
        }
        final Iterator<_A> iterator = this.E.values().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().RegionsRegionService2(location)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean RegionsRegionService1(final Player player) {
        return player != null && this.RegionsRegionService2(player.getLocation());
    }
    
    private void D() {
        try {
            if (!this.RegionsRegionService2.exists()) {
                this.RegionsRegionService2.getParentFile().mkdirs();
                this.RegionsRegionService2.createNewFile();
            }
            (this.RegionsRegionService1 = (FileConfiguration)YamlConfiguration.loadConfiguration(this.RegionsRegionService2)).set("regions", (Object)null);
            for (_A a : this.E.values()) {
                final String s = "regions." + a.RegionsRegionService2().toLowerCase();
                this.RegionsRegionService1.set(s + ".world", (Object)a.RegionsRegionService1().getWorld().getName());
                this.RegionsRegionService1.set(s + ".x", (Object)a.RegionsRegionService1().getX());
                this.RegionsRegionService1.set(s + ".y", (Object)a.RegionsRegionService1().getY());
                this.RegionsRegionService1.set(s + ".z", (Object)a.RegionsRegionService1().getZ());
            }
            this.RegionsRegionService1.save(this.RegionsRegionService2);
        }
        catch (final IOException ex) {
            this.RegionsListener1.getLogger().severe("RegionsRegionService2\u0142\u0105d podczas zapisywania region\u00f3w: " + ex.getMessage());
        }
    }
    
    public void RegionsRegionService2() {
        this.E.clear();
        this.RegionsListener1();
    }
    
    private void RegionsListener1() {
        try {
            if (!this.RegionsRegionService2.exists()) {
                this.RegionsRegionService2.getParentFile().mkdirs();
                this.RegionsRegionService2.createNewFile();
            }
            this.RegionsRegionService1 = (FileConfiguration)YamlConfiguration.loadConfiguration(this.RegionsRegionService2);
            if (this.RegionsRegionService1.contains("regions")) {
                for (String s : this.RegionsRegionService1.getConfigurationSection("regions").getKeys(false)) {
                    final String s2 = "regions." + s;
                    final String string = this.RegionsRegionService1.getString(s2 + ".world");
                    final double double1 = this.RegionsRegionService1.getDouble(s2 + ".x");
                    final double double2 = this.RegionsRegionService1.getDouble(s2 + ".y");
                    final double double3 = this.RegionsRegionService1.getDouble(s2 + ".z");
                    final World world = Bukkit.getWorld(string);
                    if (world != null) {
                        this.E.put(s.toLowerCase(), new _A(s, new Location(world, double1, double2, double3)));
                    }
                }
            }
        }
        catch (final IOException ex) {
            this.RegionsListener1.getLogger().severe("RegionsRegionService2\u0142\u0105d podczas \u0142adowania region\u00f3w: " + ex.getMessage());
        }
    }
    
    private String RegionsListener1(final Location location) {
        return String.format("%s (%.0f, %.0f, %.0f)", location.getWorld().getName(), location.getX(), location.getY(), location.getZ());
    }
    
    public static class _A
    {
        private final String RegionsRegionService2;
        private Location RegionsRegionService1;
        
        public _A(final String b, final Location a) {
            this.RegionsRegionService2 = b;
            this.RegionsRegionService1 = a;
        }
        
        public String RegionsRegionService2() {
            return this.RegionsRegionService2;
        }
        
        public Location RegionsRegionService1() {
            return this.RegionsRegionService1;
        }
        
        public void RegionsRegionService1(final Location a) {
            this.RegionsRegionService1 = a;
        }
        
        public boolean RegionsRegionService2(final Location location) {
            return location.getWorld().equals((Object)this.RegionsRegionService1.getWorld()) && location.distance(this.RegionsRegionService1) <= 50.0;
        }
    }
}
