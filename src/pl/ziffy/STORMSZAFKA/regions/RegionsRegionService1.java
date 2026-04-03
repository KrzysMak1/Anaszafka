// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.regions;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class RegionsRegionService1
{
    private final Plugin RegionsRegionService1;
    
    public RegionsRegionService1(final Plugin a) {
        this.RegionsRegionService1 = a;
    }
    
    public ItemStack RegionsRegionService1() {
        final ItemStack itemStack = new ItemStack(Material.BLAZE_ROD);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName("§x§RegionsRegionService2§3§0§0§F§F\ud83e\ude93 §7R\u00f3\u017cd\u017cka Region\u00f3w");
            itemMeta.setCustomModelData(Integer.valueOf(1));
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public boolean RegionsRegionService1(final ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() != Material.BLAZE_ROD) {
            return false;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) {
            return false;
        }
        final String displayName = itemMeta.getDisplayName();
        return displayName != null && displayName.contains("R\u00f3\u017cd\u017cka Region\u00f3w");
    }
}
