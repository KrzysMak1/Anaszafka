// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.persistence;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.configuration.ConfigurationSection;
import java.io.File;

public class C implements B
{
    private final File B;
    private final ConfigurationSection A;
    
    public C(final File b, final ConfigurationSection a) {
        this.B = b;
        this.A = a;
    }
    
    @Override
    public void A(final Plugin plugin) {
    }
    
    @Override
    public void A(final Player player, final String s, final String s2, final String s3) {
    }
    
    @Override
    public A B(final Player player) {
        return null;
    }
    
    @Override
    public void C(final Player player) {
    }
    
    @Override
    public boolean A(final Player player) {
        return false;
    }
    
    @Override
    public void B() {
    }
    
    @Override
    public String A() {
        return "H2";
    }
}
