// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.persistence;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.configuration.ConfigurationSection;
import java.io.File;

public class CostumesPersistenceCostumeRepository3 implements CostumesPersistenceCostumeRepository2
{
    private final File CostumesPersistenceCostumeRepository2;
    private final ConfigurationSection CostumesPersistenceCostumeRepository1;
    
    public CostumesPersistenceCostumeRepository3(final File b, final ConfigurationSection a) {
        this.CostumesPersistenceCostumeRepository2 = b;
        this.CostumesPersistenceCostumeRepository1 = a;
    }
    
    @Override
    public void CostumesPersistenceCostumeRepository1(final Plugin plugin) {
    }
    
    @Override
    public void CostumesPersistenceCostumeRepository1(final Player player, final String s, final String s2, final String s3) {
    }
    
    @Override
    public CostumesPersistenceCostumeRepository1 CostumesPersistenceCostumeRepository2(final Player player) {
        return null;
    }
    
    @Override
    public void CostumesPersistenceCostumeRepository3(final Player player) {
    }
    
    @Override
    public boolean CostumesPersistenceCostumeRepository1(final Player player) {
        return false;
    }
    
    @Override
    public void CostumesPersistenceCostumeRepository2() {
    }
    
    @Override
    public String CostumesPersistenceCostumeRepository1() {
        return "H2";
    }
}
