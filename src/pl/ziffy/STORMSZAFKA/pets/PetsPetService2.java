// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets;

import java.util.Set;
import java.util.Iterator;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.IOException;
import pl.ziffy.STORMSZAFKA.data.PetsListener1;
import pl.ziffy.STORMSZAFKA.Main;
import pl.ziffy.STORMSZAFKA.data.PetsPetService3;
import java.util.UUID;
import java.util.Map;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;

public class PetsPetService2
{
    private final JavaPlugin PetsPetService1;
    private final File PetsListener1;
    private final Map<UUID, PetsPetService1> PetsPetService3;
    private PetsPetService3 PetsPetService2;
    
    public PetsPetService2(final JavaPlugin a, final Map<UUID, PetsPetService1> d) {
        this.PetsPetService1 = a;
        this.PetsPetService3 = d;
        this.PetsListener1 = ((Main)a).getCustomDataFolder();
    }
    
    public void PetsPetService1(final PetsListener1 c) {
        if (c != null && c.PetsPetService4()) {
            this.PetsPetService2 = new PetsPetService3(c);
        }
    }
    
    public void PetsPetService2() {
        if (this.PetsPetService2 != null) {
            this.PetsPetService3();
        }
    }
    
    private void PetsPetService3() {
        final Map<UUID, PetsPetService1> c = this.PetsPetService2.PetsListener1();
        this.PetsPetService3.putAll(c);
        if (c.isEmpty()) {
            this.PetsPetService5();
        }
    }
    
    private void PetsPetService1() {
        final File parent = new File(this.PetsListener1, "data");
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
                this.PetsPetService3.put(UUID.fromString(name), new PetsPetService1(string, string2, boolean1, string3));
            }
            catch (final IllegalArgumentException ex2) {}
        }
    }
    
    private void PetsPetService5() {
        final File file = new File(this.PetsListener1, "data");
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
                final PetsPetService1 a = new PetsPetService1(string, string2, boolean1, string3);
                this.PetsPetService3.put(fromString, a);
                if (this.PetsPetService2 == null) {
                    continue;
                }
                this.PetsPetService2.PetsPetService1(fromString, a);
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
    
    public void PetsPetService4() {
        if (this.PetsPetService2 != null) {
            this.H();
        }
    }
    
    private void H() {
        this.PetsPetService2.PetsPetService1(this.PetsPetService3);
    }
    
    private void PetsPetService6() {
    }
    
    public void PetsPetService1(final UUID uuid, final PetsPetService1 a) {
        if (this.PetsPetService2 != null) {
            this.PetsPetService2.PetsPetService1(uuid, a);
        }
    }
    
    public PetsPetService1 PetsPetService1(final UUID uuid) {
        if (this.PetsPetService2 != null) {
            return this.PetsPetService2.PetsListener1(uuid);
        }
        return null;
    }
    
    public void PetsPetService2(final UUID uuid) {
        this.PetsPetService3.remove(uuid);
        if (this.PetsPetService2 != null) {
            this.PetsPetService2.PetsPetService2(uuid);
        }
    }
    
    public void PetsPetService1(final Set<String> set) {
        if (!set.isEmpty()) {
            final PetsPetService6 petConfigManager = Main.getPetConfigManager();
            if (petConfigManager != null) {
                for (final String s : set) {
                    if (petConfigManager.H(s)) {
                        petConfigManager.PetsPetService1(s, false);
                    }
                }
            }
            set.clear();
        }
    }
    
    public boolean PetsListener1() {
        return this.PetsPetService2 != null;
    }
}
