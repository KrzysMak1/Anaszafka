// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

public class CostumesCostumeService2
{
    private static CostumesListener6 CostumesListener2;
    private static CostumesListener4 CostumesListener1;
    private static pl.ziffy.STORMSZAFKA.data.CostumesCostumeService2 CostumesCostumeService1;
    
    public static void CostumesListener1(final CostumesListener6 b) {
        CostumesCostumeService2.CostumesListener2 = b;
    }
    
    public static CostumesListener6 CostumesListener1() {
        return CostumesCostumeService2.CostumesListener2;
    }
    
    public static void CostumesListener1(final CostumesListener4 a) {
        CostumesCostumeService2.CostumesListener1 = a;
    }
    
    public static CostumesListener4 CostumesCostumeService1() {
        return CostumesCostumeService2.CostumesListener1;
    }
    
    public static void CostumesListener1(final pl.ziffy.STORMSZAFKA.data.CostumesCostumeService2 c) {
        CostumesCostumeService2.CostumesCostumeService1 = c;
    }
    
    public static pl.ziffy.STORMSZAFKA.data.CostumesCostumeService2 CostumesListener2() {
        return CostumesCostumeService2.CostumesCostumeService1;
    }
}
