// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;

public interface CostumesCostumeService1
{
    void apply(final Player p0);
    
    void remove(final Player p0);
    
    void update();
    
    String getDisplayName();
    
    ItemStack getCostumeItem();
    
    void showOriginalArmor(final Player p0);
    
    void restoreCostume(final Player p0);
    
    void applyEffects(final Player p0);
    
    void removeEffects(final Player p0);
    
    String getType();
}
