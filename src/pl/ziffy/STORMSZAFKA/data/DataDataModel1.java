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

public class DataDataModel1
{
    private static final DateTimeFormatter DataDataModel4;
    private final JavaPlugin DataDataModel2;
    private final File DataDataModel3;
    private final Map<UUID, DataDataModel4> DataDataModel1;
    private A D;
    private boolean A;
    
    public DataDataModel1(final JavaPlugin c) {
        this.A = true;
        this.DataDataModel2 = c;
        this.DataDataModel3 = ((Main)c).getCustomDataFolder();
        this.DataDataModel1 = new ConcurrentHashMap<UUID, DataDataModel4>();
    }
    
    public void A(final DataDataModel2 c) {
        if (c != null && c.DataDataModel3()) {
            this.D = new A(c);
            this.A = true;
        }
        else {
            this.A = false;
        }
    }
    
    public void H() {
        if (this.A && this.D != null) {
            this.DataDataModel1();
        }
        else {
            this.D();
        }
    }
    
    private void DataDataModel1() {
        final Map<UUID, DataDataModel4> c = this.D.DataDataModel2();
        this.DataDataModel1.putAll(c);
        if (c.isEmpty()) {
            this.DataDataModel3();
        }
    }
    
    private void D() {
        final File parent = new File(this.DataDataModel3, "data");
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
                this.DataDataModel1.put(UUID.fromString(name), new DataDataModel4(loadConfiguration.getDouble(name + ".dropMultiplier", 1.0), loadConfiguration.getBoolean(name + ".bonusActive", false), loadConfiguration.getString(name + ".bonusExpiration", (String)null), loadConfiguration.getInt(name + ".totalDrops", 0)));
            }
            catch (final IllegalArgumentException ex2) {}
        }
    }
    
    private void DataDataModel3() {
        final File file = new File(this.DataDataModel3, "data");
        final File file2 = new File(file, "SakiewkaData.yml");
        if (!file2.exists()) {
            return;
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file2);
        int n = 0;
        for (String name : loadConfiguration.getKeys(false)) {
            try {
                final UUID fromString = UUID.fromString(name);
                final DataDataModel4 f = new DataDataModel4(loadConfiguration.getDouble(name + ".dropMultiplier", 1.0), loadConfiguration.getBoolean(name + ".bonusActive", false), loadConfiguration.getString(name + ".bonusExpiration", (String)null), loadConfiguration.getInt(name + ".totalDrops", 0));
                this.DataDataModel1.put(fromString, f);
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
            this.DataDataModel2();
        }
        else {
            this.DataDataModel4();
        }
    }
    
    private void DataDataModel2() {
        this.D.A(this.DataDataModel1);
    }
    
    private void DataDataModel4() {
        final File parent = new File(this.DataDataModel3, "data");
        if (!parent.exists()) {
            parent.mkdirs();
        }
        final File file = new File(parent, "SakiewkaData.yml");
        final YamlConfiguration yamlConfiguration = new YamlConfiguration();
        for (Map.Entry entry : this.DataDataModel1.entrySet()) {
            final String string = ((UUID)entry.getKey()).toString();
            final DataDataModel4 f = (DataDataModel4)entry.getValue();
            yamlConfiguration.set(string + ".dropMultiplier", (Object)f.DataDataModel2);
            yamlConfiguration.set(string + ".bonusActive", (Object)f.A);
            yamlConfiguration.set(string + ".bonusExpiration", (Object)f.D);
            yamlConfiguration.set(string + ".totalDrops", (Object)f.DataDataModel1);
        }
        try {
            yamlConfiguration.save(file);
        }
        catch (final IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public DataDataModel4 DataDataModel1(final Player player) {
        return this.DataDataModel2(player.getUniqueId());
    }
    
    public DataDataModel4 DataDataModel2(final UUID key) {
        return this.DataDataModel1.computeIfAbsent(key, p0 -> new DataDataModel4());
    }
    
    public void A(final Player player, final double n) {
        this.A(player.getUniqueId(), n);
    }
    
    public void A(final UUID uuid, final double c) {
        this.DataDataModel2(uuid).DataDataModel2 = c;
        if (this.A && this.D != null) {
            this.D.A(uuid, c);
        }
    }
    
    public void A(final Player player, final double n, final int n2) {
        this.A(player.getUniqueId(), n, n2);
    }
    
    public void A(final UUID uuid, final double c, final int n) {
        final DataDataModel4 c2 = this.DataDataModel2(uuid);
        c2.DataDataModel2 = c;
        c2.A = true;
        c2.D = LocalDateTime.now().plusMinutes(n).format(pl.ziffy.STORMSZAFKA.data.DataDataModel1.DataDataModel4);
        if (this.A && this.D != null) {
            this.D.A(uuid, c2);
        }
    }
    
    public void D(final Player player) {
        this.D(player.getUniqueId());
    }
    
    public void D(final UUID uuid) {
        final DataDataModel4 c = this.DataDataModel2(uuid);
        c.DataDataModel2 = 1.0;
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
        final DataDataModel4 c = this.DataDataModel2(uuid);
        c.DataDataModel1 += n;
        if (this.A && this.D != null) {
            this.D.A(uuid, n);
        }
    }
    
    public double DataDataModel3(final Player player) {
        return this.DataDataModel1(player.getUniqueId());
    }
    
    public double DataDataModel1(final UUID uuid) {
        final DataDataModel4 c = this.DataDataModel2(uuid);
        if (c.A && c.DataDataModel1()) {
            this.D(uuid);
            return 1.0;
        }
        return c.A();
    }
    
    public boolean DataDataModel2(final Player player) {
        return this.A(player.getUniqueId());
    }
    
    public boolean A(final UUID uuid) {
        final DataDataModel4 c = this.DataDataModel2(uuid);
        return c.A && !c.DataDataModel1();
    }
    
    public int A(final Player player) {
        return this.DataDataModel4(player.getUniqueId());
    }
    
    public int DataDataModel4(final UUID uuid) {
        return this.DataDataModel2(uuid).DataDataModel1;
    }
    
    public boolean A() {
        return this.A && this.D != null;
    }
    
    public Map<UUID, DataDataModel4> G() {
        return new HashMap<UUID, DataDataModel4>(this.DataDataModel1);
    }
    
    static {
        DataDataModel4 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
}
