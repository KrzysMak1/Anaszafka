// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.persistence;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import java.io.File;

public class D implements B
{
    private final File C;
    
    public D(final File c) {
        this.C = c;
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
        return "YAML";
    }
}
