// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

import org.bukkit.inventory.ItemStack;

public class I
{
    private ItemStack B;
    private ItemStack D;
    private ItemStack C;
    private ItemStack A;
    
    public I(final ItemStack itemStack, final ItemStack itemStack2, final ItemStack itemStack3, final ItemStack itemStack4) {
        this.B = ((itemStack != null) ? itemStack.clone() : null);
        this.D = ((itemStack2 != null) ? itemStack2.clone() : null);
        this.C = ((itemStack3 != null) ? itemStack3.clone() : null);
        this.A = ((itemStack4 != null) ? itemStack4.clone() : null);
    }
    
    public ItemStack C() {
        return this.B;
    }
    
    public void A(final ItemStack itemStack) {
        this.B = ((itemStack != null) ? itemStack.clone() : null);
    }
    
    public ItemStack E() {
        return this.D;
    }
    
    public void D(final ItemStack itemStack) {
        this.D = ((itemStack != null) ? itemStack.clone() : null);
    }
    
    public ItemStack B() {
        return this.C;
    }
    
    public void B(final ItemStack itemStack) {
        this.C = ((itemStack != null) ? itemStack.clone() : null);
    }
    
    public ItemStack A() {
        return this.A;
    }
    
    public void C(final ItemStack itemStack) {
        this.A = ((itemStack != null) ? itemStack.clone() : null);
    }
    
    public boolean D() {
        return this.D != null && this.D.getType().name().equals("ELYTRA");
    }
}
