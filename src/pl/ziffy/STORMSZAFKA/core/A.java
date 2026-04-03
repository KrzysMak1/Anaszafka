// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.core;

import org.bukkit.plugin.Plugin;
import pl.ziffy.STORMSZAFKA.fragments.B;
import pl.ziffy.STORMSZAFKA.pets.E;
import pl.ziffy.STORMSZAFKA.costumes.L;
import pl.ziffy.STORMSZAFKA.Main;

public class A
{
    private static Main A;
    
    public static void A(final Main a) {
        pl.ziffy.STORMSZAFKA.core.A.A = a;
        B();
        A();
        C();
    }
    
    private static void B() {
        try {
            L.A(pl.ziffy.STORMSZAFKA.core.A.A);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void A() {
        try {
            E.A(pl.ziffy.STORMSZAFKA.core.A.A);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void C() {
        try {
            B.A((Plugin)pl.ziffy.STORMSZAFKA.core.A.A);
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
            B.B();
        }
        catch (final Exception ex3) {}
    }
}
