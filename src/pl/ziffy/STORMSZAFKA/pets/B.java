// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets;

import java.util.Set;
import java.util.Iterator;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.IOException;
import pl.ziffy.STORMSZAFKA.data.C;
import pl.ziffy.STORMSZAFKA.Main;
import pl.ziffy.STORMSZAFKA.data.D;
import java.util.UUID;
import java.util.Map;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

public class B
{
    private final JavaPlugin A;
    private final File C;
    private final Map<UUID, A> D;
    private D B;
    
    public B(final JavaPlugin a, final Map<UUID, A> d) {
        this.A = a;
        this.D = d;
        this.C = ((Main)a).getCustomDataFolder();
    }
    
    public void A(final C c) {
        if (c != null && c.E()) {
            this.B = new D(c);
        }
    }
    
    public void B() {
        if (this.B != null) {
            this.D();
        }
    }
    
    private void D() {
        final Map<UUID, A> c = this.B.C();
        this.D.putAll(c);
        if (c.isEmpty()) {
            this.F();
        }
    }
    
    private void A() {
        final File parent = new File(this.C, "data");
        if (!parent.exists()) {
            parent.mkdirs();
        }
        final File file = new File(parent, "PetData.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
        for (String name : loadConfiguration.getKeys(false)) {
            final String string = loadConfiguration.getString(name + ".petType", "");
            final String string2 = loadConfiguration.getString(name + ".expiration", "brak");
            final boolean boolean1 = loadConfiguration.getBoolean(name + ".isHidden", false);
            final String string3 = loadConfiguration.getString(name + ".originalDuration", (String)null);
            try {
                this.D.put(UUID.fromString(name), new A(string, string2, boolean1, string3));
            }
            catch (final IllegalArgumentException ex2) {}
        }
    }
    
    private void F() {
        final File file = new File(this.C, "data");
        final File file2 = new File(file, "PetData.yml");
        if (!file2.exists()) {
            return;
        }
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file2);
        int n = 0;
        for (String name : loadConfiguration.getKeys(false)) {
            final String string = loadConfiguration.getString(name + ".petType", "");
            final String string2 = loadConfiguration.getString(name + ".expiration", "brak");
            final boolean boolean1 = loadConfiguration.getBoolean(name + ".isHidden", false);
            final String string3 = loadConfiguration.getString(name + ".originalDuration", (String)null);
            try {
                final UUID fromString = UUID.fromString(name);
                final A a = new A(string, string2, boolean1, string3);
                this.D.put(fromString, a);
                if (this.B == null) {
                    continue;
                }
                this.B.A(fromString, a);
                ++n;
            }
            catch (final IllegalArgumentException ex) {}
        }
        if (n > 0) {
            final File dest = new File(file, "PetData.yml.backup");
            if (!dest.exists()) {
                file2.renameTo(dest);
            }
        }
    }
    
    public void E() {
        if (this.B != null) {
            this.H();
        }
    }
    
    private void H() {
        this.B.A(this.D);
    }
    
    private void G() {
    }
    
    public void A(final UUID uuid, final A a) {
        if (this.B != null) {
            this.B.A(uuid, a);
        }
    }
    
    public A A(final UUID uuid) {
        if (this.B != null) {
            return this.B.C(uuid);
        }
        return null;
    }
    
    public void B(final UUID uuid) {
        this.D.remove(uuid);
        if (this.B != null) {
            this.B.B(uuid);
        }
    }
    
    public void A(final Set<String> set) {
        if (!set.isEmpty()) {
            final G petConfigManager = Main.getPetConfigManager();
            if (petConfigManager != null) {
                for (final String s : set) {
                    if (petConfigManager.H(s)) {
                        petConfigManager.A(s, false);
                    }
                }
            }
            set.clear();
        }
    }
    
    public boolean C() {
        return this.B != null;
    }
}
