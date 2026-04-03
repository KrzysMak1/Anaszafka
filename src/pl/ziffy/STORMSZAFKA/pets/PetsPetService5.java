// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets;

import pl.ziffy.STORMSZAFKA.pets.items.PetsListener1;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition18;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition15;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition20;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition26;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition28;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition9;
import pl.ziffy.STORMSZAFKA.pets.items.PetsPetService2;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition12;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition25;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition21;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition19;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition29;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition8;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition14;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition13;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition10;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition11;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition22;
import pl.ziffy.STORMSZAFKA.pets.items.PetsPetService6;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition27;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition16;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition23;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition17;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition24;
import pl.ziffy.STORMSZAFKA.pets.items.PetsPetService1;
import java.util.HashMap;
import java.util.Map;

public class PetsPetService5
{
    private static final Map<String, Class<? extends PetsPetService3>> PetsPetService1;
    
    public static PetsPetService3 PetsPetService1(final String s) {
        final Class clazz = PetsPetService5.PetsPetService1.get(s);
        if (clazz == null) {
            return null;
        }
        try {
            return (PetsPetService3)clazz.getDeclaredConstructor((Class[])new Class[0]).newInstance(new Object[0]);
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    public static boolean PetsPetService2(final String s) {
        return PetsPetService5.PetsPetService1.containsKey(s);
    }
    
    static {
        (PetsPetService1 = new HashMap<String, Class<? extends PetsPetService3>>()).put("pedziwiatr", PetsPetService1.class);
        PetsPetService5.PetsPetService1.put("aniolek", _.class);
        PetsPetService5.PetsPetService1.put("pancernik", O.class);
        PetsPetService5.PetsPetService1.put("pudzianek", U.class);
        PetsPetService5.PetsPetService1.put("glodomorek", pl.ziffy.STORMSZAFKA.pets.items.PetsPetService3.class);
        PetsPetService5.PetsPetService1.put("skalniaczek", N.class);
        PetsPetService5.PetsPetService1.put("biznesmenik", X.class);
        PetsPetService5.PetsPetService1.put("discordzik", PetsPetService6.class);
        PetsPetService5.PetsPetService1.put("duszek", T.class);
        PetsPetService5.PetsPetService1.put("nietoperek", K.class);
        PetsPetService5.PetsPetService1.put("reniferek", J.class);
        PetsPetService5.PetsPetService1.put("balwanek", a.class);
        PetsPetService5.PetsPetService1.put("golemik", b.class);
        PetsPetService5.PetsPetService1.put("eustachy", H.class);
        PetsPetService5.PetsPetService1.put("enderman", Z.class);
        PetsPetService5.PetsPetService1.put("zaj\u0105czek", Q.class);
        PetsPetService5.PetsPetService1.put("pisklak", S.class);
        PetsPetService5.PetsPetService1.put("cukiereczek", V.class);
        PetsPetService5.PetsPetService1.put("rozdymek", L.class);
        PetsPetService5.PetsPetService1.put("pajak", PetsPetService2.class);
        PetsPetService5.PetsPetService1.put("sowa", I.class);
        PetsPetService5.PetsPetService1.put("drakula", Y.class);
        PetsPetService5.PetsPetService1.put("leniuszek", W.class);
        PetsPetService5.PetsPetService1.put("elfik", R.class);
        PetsPetService5.PetsPetService1.put("pierniczek", M.class);
        PetsPetService5.PetsPetService1.put("paczus", pl.ziffy.STORMSZAFKA.pets.items.PetsPetService5.class);
        PetsPetService5.PetsPetService1.put("telekrolik", P.class);
        PetsPetService5.PetsPetService1.put("bobas", PetsListener1.class);
    }
}
