// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.core;

import org.bukkit.plugin.Plugin;
import pl.ziffy.STORMSZAFKA.fragments.CoreCoreService2;
import pl.ziffy.STORMSZAFKA.pets.PetsPetService4;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import pl.ziffy.STORMSZAFKA.Main;

public class CoreCoreService1
{
    private static Main CoreCoreService1;
    
    public static void CoreCoreService1(final Main a) {
        pl.ziffy.STORMSZAFKA.core.CoreCoreService1.CoreCoreService1 = a;
        CoreCoreService2();
        CoreCoreService1();
        C();
    }
    
    private static void CoreCoreService2() {
        try {
            L.CoreCoreService1(pl.ziffy.STORMSZAFKA.core.CoreCoreService1.CoreCoreService1);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void CoreCoreService1() {
        try {
            E.CoreCoreService1(pl.ziffy.STORMSZAFKA.core.CoreCoreService1.CoreCoreService1);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void C() {
        try {
            CoreCoreService2.CoreCoreService1((Plugin)pl.ziffy.STORMSZAFKA.core.CoreCoreService1.CoreCoreService1);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void D() {
        try {
            L.M();
        }
        catch (final Exception ex) {}
        try {
            E.E();
        }
        catch (final Exception ex2) {}
        try {
            CoreCoreService2.CoreCoreService2();
        }
        catch (final Exception ex3) {}
    }
}
