// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.utils;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import net.milkbowl.vault.economy.Economy;

public class UtilsUtilityService3
{
    private Economy UtilsListener1;
    private final JavaPlugin UtilsUtilityService1;
    
    public UtilsUtilityService3(final JavaPlugin b) {
        this.UtilsListener1 = null;
        this.UtilsUtilityService1 = b;
    }
    
    public void UtilsListener1() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            return;
        }
        final RegisteredServiceProvider registration = Bukkit.getServicesManager().getRegistration((Class)Economy.class);
        if (registration == null) {
            return;
        }
        this.UtilsListener1 = (Economy)registration.getProvider();
    }
    
    public Economy UtilsUtilityService2() {
        return this.UtilsListener1;
    }
    
    public boolean UtilsUtilityService1() {
        return this.UtilsListener1 != null;
    }
}
