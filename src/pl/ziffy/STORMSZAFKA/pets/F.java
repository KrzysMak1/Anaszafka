// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets;

import pl.ziffy.STORMSZAFKA.pets.items.C;
import pl.ziffy.STORMSZAFKA.pets.items.P;
import pl.ziffy.STORMSZAFKA.pets.items.M;
import pl.ziffy.STORMSZAFKA.pets.items.R;
import pl.ziffy.STORMSZAFKA.pets.items.W;
import pl.ziffy.STORMSZAFKA.pets.items.Y;
import pl.ziffy.STORMSZAFKA.pets.items.I;
import pl.ziffy.STORMSZAFKA.pets.items.B;
import pl.ziffy.STORMSZAFKA.pets.items.L;
import pl.ziffy.STORMSZAFKA.pets.items.V;
import pl.ziffy.STORMSZAFKA.pets.items.S;
import pl.ziffy.STORMSZAFKA.pets.items.Q;
import pl.ziffy.STORMSZAFKA.pets.items.Z;
import pl.ziffy.STORMSZAFKA.pets.items.H;
import pl.ziffy.STORMSZAFKA.pets.items.b;
import pl.ziffy.STORMSZAFKA.pets.items.a;
import pl.ziffy.STORMSZAFKA.pets.items.J;
import pl.ziffy.STORMSZAFKA.pets.items.K;
import pl.ziffy.STORMSZAFKA.pets.items.T;
import pl.ziffy.STORMSZAFKA.pets.items.G;
import pl.ziffy.STORMSZAFKA.pets.items.X;
import pl.ziffy.STORMSZAFKA.pets.items.N;
import pl.ziffy.STORMSZAFKA.pets.items.U;
import pl.ziffy.STORMSZAFKA.pets.items.O;
import pl.ziffy.STORMSZAFKA.pets.items._;
import pl.ziffy.STORMSZAFKA.pets.items.A;
import java.util.HashMap;
import java.util.Map;

public class F
{
    private static final Map<String, Class<? extends D>> A;
    
    public static D A(final String s) {
        final Class clazz = F.A.get(s);
        if (clazz == null) {
            return null;
        }
        try {
            return (D)clazz.getDeclaredConstructor((Class[])new Class[0]).newInstance(new Object[0]);
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    public static boolean B(final String s) {
        return F.A.containsKey(s);
    }
    
    static {
        (A = new HashMap<String, Class<? extends D>>()).put("pedziwiatr", A.class);
        F.A.put("aniolek", _.class);
        F.A.put("pancernik", O.class);
        F.A.put("pudzianek", U.class);
        F.A.put("glodomorek", pl.ziffy.STORMSZAFKA.pets.items.D.class);
        F.A.put("skalniaczek", N.class);
        F.A.put("biznesmenik", X.class);
        F.A.put("discordzik", G.class);
        F.A.put("duszek", T.class);
        F.A.put("nietoperek", K.class);
        F.A.put("reniferek", J.class);
        F.A.put("balwanek", a.class);
        F.A.put("golemik", b.class);
        F.A.put("eustachy", H.class);
        F.A.put("enderman", Z.class);
        F.A.put("zaj\u0105czek", Q.class);
        F.A.put("pisklak", S.class);
        F.A.put("cukiereczek", V.class);
        F.A.put("rozdymek", L.class);
        F.A.put("pajak", B.class);
        F.A.put("sowa", I.class);
        F.A.put("drakula", Y.class);
        F.A.put("leniuszek", W.class);
        F.A.put("elfik", R.class);
        F.A.put("pierniczek", M.class);
        F.A.put("paczus", pl.ziffy.STORMSZAFKA.pets.items.F.class);
        F.A.put("telekrolik", P.class);
        F.A.put("bobas", C.class);
    }
}
