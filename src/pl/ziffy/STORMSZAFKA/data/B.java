// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.data;

import java.util.HashMap;
import java.time.LocalDateTime;
import org.bukkit.entity.Player;
import java.util.Iterator;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import pl.ziffy.STORMSZAFKA.Main;
import java.util.UUID;
import java.util.Map;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;
import java.time.format.DateTimeFormatter;

public class B
{
    private static final DateTimeFormatter F;
    private final JavaPlugin C;
    private final File E;
    private final Map<UUID, F> B;
    private A D;
    private boolean A;
    
    public B(final JavaPlugin c) {
        this.A = true;
        this.C = c;
        this.E = ((Main)c).getCustomDataFolder();
        this.B = new ConcurrentHashMap<UUID, F>();
    }
    
    public void A(final C c) {
        if (c != null && c.E()) {
            this.D = new A(c);
            this.A = true;
        }
        else {
            this.A = false;
        }
    }
    
    public void H() {
        if (this.A && this.D != null) {
            this.B();
        }
        else {
            this.D();
        }
    }
    
    private void B() {
        final Map<UUID, F> c = this.D.C();
        this.B.putAll(c);
        if (c.isEmpty()) {
            this.E();
        }
    }
    
    private void D() {
        final File parent = new File(this.E, "data");
        if (!parent.exists()) {
            parent.mkdirs();
        }
        final File file = new File(parent, "SakiewkaData.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
        for (String name : loadConfiguration.getKeys(false)) {
            try {
                this.B.put(UUID.fromString(name), new F(loadConfiguration.getDouble(name + ".dropMultiplier", 1.0), loadConfiguration.getBoolean(name + ".bonusActive", false), loadConfiguration.getString(name + ".bonusExpiration", (String)null), loadConfiguration.getInt(name + ".totalDrops", 0)));
            }
            catch (final IllegalArgumentException ex2) {}
        }
    }
    
    private void E() {
        final File file = new File(this.E, "data");
        final File file2 = new File(file, "SakiewkaData.yml");
        if (!file2.exists()) {
            return;
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file2);
        int n = 0;
        for (String name : loadConfiguration.getKeys(false)) {
            try {
                final UUID fromString = UUID.fromString(name);
                final F f = new F(loadConfiguration.getDouble(name + ".dropMultiplier", 1.0), loadConfiguration.getBoolean(name + ".bonusActive", false), loadConfiguration.getString(name + ".bonusExpiration", (String)null), loadConfiguration.getInt(name + ".totalDrops", 0));
                this.B.put(fromString, f);
                if (this.D == null) {
                    continue;
                }
                this.D.A(fromString, f);
                ++n;
            }
            catch (final IllegalArgumentException ex) {}
        }
        if (n > 0) {
            final File dest = new File(file, "SakiewkaData.yml.backup");
            if (!dest.exists()) {
                file2.renameTo(dest);
            }
        }
    }
    
    public void I() {
        if (this.A && this.D != null) {
            this.C();
        }
        else {
            this.F();
        }
    }
    
    private void C() {
        this.D.A(this.B);
    }
    
    private void F() {
        final File parent = new File(this.E, "data");
        if (!parent.exists()) {
            parent.mkdirs();
        }
        final File file = new File(parent, "SakiewkaData.yml");
        final YamlConfiguration yamlConfiguration = new YamlConfiguration();
        for (Map.Entry entry : this.B.entrySet()) {
            final String string = ((UUID)entry.getKey()).toString();
            final F f = (F)entry.getValue();
            yamlConfiguration.set(string + ".dropMultiplier", (Object)f.C);
            yamlConfiguration.set(string + ".bonusActive", (Object)f.A);
            yamlConfiguration.set(string + ".bonusExpiration", (Object)f.D);
            yamlConfiguration.set(string + ".totalDrops", (Object)f.B);
        }
        try {
            yamlConfiguration.save(file);
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public F B(final Player player) {
        return this.C(player.getUniqueId());
    }
    
    public F C(final UUID key) {
        return this.B.computeIfAbsent(key, p0 -> new F());
    }
    
    public void A(final Player player, final double n) {
        this.A(player.getUniqueId(), n);
    }
    
    public void A(final UUID uuid, final double c) {
        this.C(uuid).C = c;
        if (this.A && this.D != null) {
            this.D.A(uuid, c);
        }
    }
    
    public void A(final Player player, final double n, final int n2) {
        this.A(player.getUniqueId(), n, n2);
    }
    
    public void A(final UUID uuid, final double c, final int n) {
        final F c2 = this.C(uuid);
        c2.C = c;
        c2.A = true;
        c2.D = LocalDateTime.now().plusMinutes(n).format(pl.ziffy.STORMSZAFKA.data.B.F);
        if (this.A && this.D != null) {
            this.D.A(uuid, c2);
        }
    }
    
    public void D(final Player player) {
        this.D(player.getUniqueId());
    }
    
    public void D(final UUID uuid) {
        final F c = this.C(uuid);
        c.C = 1.0;
        c.A = false;
        c.D = null;
        if (this.A && this.D != null) {
            this.D.A(uuid, false, null);
        }
    }
    
    public void A(final Player player, final int n) {
        this.A(player.getUniqueId(), n);
    }
    
    public void A(final UUID uuid, final int n) {
        final F c = this.C(uuid);
        c.B += n;
        if (this.A && this.D != null) {
            this.D.A(uuid, n);
        }
    }
    
    public double E(final Player player) {
        return this.B(player.getUniqueId());
    }
    
    public double B(final UUID uuid) {
        final F c = this.C(uuid);
        if (c.A && c.B()) {
            this.D(uuid);
            return 1.0;
        }
        return c.A();
    }
    
    public boolean C(final Player player) {
        return this.A(player.getUniqueId());
    }
    
    public boolean A(final UUID uuid) {
        final F c = this.C(uuid);
        return c.A && !c.B();
    }
    
    public int A(final Player player) {
        return this.F(player.getUniqueId());
    }
    
    public int F(final UUID uuid) {
        return this.C(uuid).B;
    }
    
    public boolean A() {
        return this.A && this.D != null;
    }
    
    public Map<UUID, F> G() {
        return new HashMap<UUID, F>(this.B);
    }
    
    static {
        F = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
}
