// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

import org.bukkit.inventory.ItemStack;

public class CostumesCostumeService4
{
    private ItemStack CostumesListener2;
    private ItemStack CostumesListener3;
    private ItemStack CostumesCostumeService1;
    private ItemStack CostumesListener1;
    
    public CostumesCostumeService4(final ItemStack itemStack, final ItemStack itemStack2, final ItemStack itemStack3, final ItemStack itemStack4) {
        this.CostumesListener2 = ((itemStack != null) ? itemStack.clone() : null);
        this.CostumesListener3 = ((itemStack2 != null) ? itemStack2.clone() : null);
        this.CostumesCostumeService1 = ((itemStack3 != null) ? itemStack3.clone() : null);
        this.CostumesListener1 = ((itemStack4 != null) ? itemStack4.clone() : null);
    }
    
    public ItemStack CostumesCostumeService1() {
        return this.CostumesListener2;
    }
    
    public void CostumesListener1(final ItemStack itemStack) {
        this.CostumesListener2 = ((itemStack != null) ? itemStack.clone() : null);
    }
    
    public ItemStack CostumesCostumeService2() {
        return this.CostumesListener3;
    }
    
    public void CostumesListener3(final ItemStack itemStack) {
        this.CostumesListener3 = ((itemStack != null) ? itemStack.clone() : null);
    }
    
    public ItemStack CostumesListener2() {
        return this.CostumesCostumeService1;
    }
    
    public void CostumesListener2(final ItemStack itemStack) {
        this.CostumesCostumeService1 = ((itemStack != null) ? itemStack.clone() : null);
    }
    
    public ItemStack CostumesListener1() {
        return this.CostumesListener1;
    }
    
    public void CostumesCostumeService1(final ItemStack itemStack) {
        this.CostumesListener1 = ((itemStack != null) ? itemStack.clone() : null);
    }
    
    public boolean CostumesListener3() {
        return this.CostumesListener3 != null && this.CostumesListener3.getType().name().equals("ELYTRA");
    }
}
