// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.utils;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.economy.Economy;

public class D
{
    private Economy A;
    private final JavaPlugin B;
    
    public D(final JavaPlugin b) {
        this.A = null;
        this.B = b;
    }
    
    public void A() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return;
        }
        final RegisteredServiceProvider registration = Bukkit.getServicesManager().getRegistration((Class)Economy.class);
        if (registration == null) {
            return;
        }
        this.A = (Economy)registration.getProvider();
    }
    
    public Economy C() {
        return this.A;
    }
    
    public boolean B() {
        return this.A != null;
    }
}
