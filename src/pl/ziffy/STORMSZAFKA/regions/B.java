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

public class B
{
    private final Plugin C;
    private final Map<UUID, Location> D;
    private final Map<String, _A> E;
    private File B;
    private FileConfiguration A;
    
    public B(final Plugin c) {
        this.D = new HashMap<UUID, Location>();
        this.E = new HashMap<String, _A>();
        this.C = c;
        this.B = new File(c.getDataFolder(), "regions.yml");
        this.C();
    }
    
    public void B(final Player player, final Location location) {
        this.D.put(player.getUniqueId(), location);
        player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §7Zaznaczono §fpozycj\u0119 1§7: §f" + this.C(location));
    }
    
    public void A(final Player player, final Location location) {
        final Location location2 = this.D.get(player.getUniqueId());
        if (location2 == null) {
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §cNie zaznaczono pierwszej pozycji!");
            return;
        }
        if (!location2.getWorld().equals((Object)location.getWorld())) {
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §cObie pozycje musz\u0105 by\u0107 w tym samym \u015bwiecie!");
            this.D.remove(player.getUniqueId());
            return;
        }
        player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §7Zaznaczono §fpozycj\u0119 2§7: §f" + this.C(location));
        player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §7Selekcja gotowa! U\u017cyj: §f/stormszafka region create <nazwa>");
    }
    
    public boolean B(final Player player) {
        return this.D.containsKey(player.getUniqueId());
    }
    
    public boolean A(final Player player, final String s) {
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
    
    public boolean B(final Player player, final String s) {
        final Location location = this.D.get(player.getUniqueId());
        if (location == null) {
            return false;
        }
        final _A a = this.E.get(s.toLowerCase());
        if (a == null) {
            return false;
        }
        a.A(location);
        this.D();
        return true;
    }
    
    public boolean A(final String s) {
        if (this.E.remove(s.toLowerCase()) != null) {
            this.D();
            return true;
        }
        return false;
    }
    
    public boolean B(final String s) {
        return this.E.containsKey(s.toLowerCase());
    }
    
    public List<String> A() {
        return new ArrayList<String>(this.E.keySet());
    }
    
    public void C(final Player player) {
        this.D.remove(player.getUniqueId());
    }
    
    public boolean A(final Location location, final String s) {
        final _A a = this.E.get(s.toLowerCase());
        return a != null && a.B(location);
    }
    
    public String A(final Location location) {
        for (final _A a : this.E.values()) {
            if (a.B(location)) {
                return a.B();
            }
        }
        return null;
    }
    
    public boolean B(final Location location) {
        if (location == null) {
            return false;
        }
        final Iterator<_A> iterator = this.E.values().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().B(location)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean A(final Player player) {
        return player != null && this.B(player.getLocation());
    }
    
    private void D() {
        try {
            if (!this.B.exists()) {
                this.B.getParentFile().mkdirs();
                this.B.createNewFile();
            }
            (this.A = (FileConfiguration)YamlConfiguration.loadConfiguration(this.B)).set("regions", (Object)null);
            for (_A a : this.E.values()) {
                final String s = "regions." + a.B().toLowerCase();
                this.A.set(s + ".world", (Object)a.A().getWorld().getName());
                this.A.set(s + ".x", (Object)a.A().getX());
                this.A.set(s + ".y", (Object)a.A().getY());
                this.A.set(s + ".z", (Object)a.A().getZ());
            }
            this.A.save(this.B);
        }
        catch (final IOException ex) {
            this.C.getLogger().severe("B\u0142\u0105d podczas zapisywania region\u00f3w: " + ex.getMessage());
        }
    }
    
    public void B() {
        this.E.clear();
        this.C();
    }
    
    private void C() {
        try {
            if (!this.B.exists()) {
                this.B.getParentFile().mkdirs();
                this.B.createNewFile();
            }
            this.A = (FileConfiguration)YamlConfiguration.loadConfiguration(this.B);
            if (this.A.contains("regions")) {
                for (String s : this.A.getConfigurationSection("regions").getKeys(false)) {
                    final String s2 = "regions." + s;
                    final String string = this.A.getString(s2 + ".world");
                    final double double1 = this.A.getDouble(s2 + ".x");
                    final double double2 = this.A.getDouble(s2 + ".y");
                    final double double3 = this.A.getDouble(s2 + ".z");
                    final World world = Bukkit.getWorld(string);
                    if (world != null) {
                        this.E.put(s.toLowerCase(), new _A(s, new Location(world, double1, double2, double3)));
                    }
                }
            }
        }
        catch (final IOException ex) {
            this.C.getLogger().severe("B\u0142\u0105d podczas \u0142adowania region\u00f3w: " + ex.getMessage());
        }
    }
    
    private String C(final Location location) {
        return String.format("%s (%.0f, %.0f, %.0f)", location.getWorld().getName(), location.getX(), location.getY(), location.getZ());
    }
    
    public static class _A
    {
        private final String B;
        private Location A;
        
        public _A(final String b, final Location a) {
            this.B = b;
            this.A = a;
        }
        
        public String B() {
            return this.B;
        }
        
        public Location A() {
            return this.A;
        }
        
        public void A(final Location a) {
            this.A = a;
        }
        
        public boolean B(final Location location) {
            return location.getWorld().equals((Object)this.A.getWorld()) && location.distance(this.A) <= 50.0;
        }
    }
}
