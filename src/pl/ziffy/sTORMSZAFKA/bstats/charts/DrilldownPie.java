// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.sTORMSZAFKA.bstats.charts;

import java.util.Iterator;
import pl.ziffy.sTORMSZAFKA.bstats.json.JsonObjectBuilder;
import java.util.Map;
import java.util.concurrent.Callable;

public class DrilldownPie extends CustomChart
{
    private final Callable<Map<String, Map<String, Integer>>> F;
    
    public DrilldownPie(final String s, final Callable<Map<String, Map<String, Integer>>> f) {
        super(s);
        this.F = f;
    }
    
    public JsonObjectBuilder.JsonObject getChartData() throws Exception {
        final JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        final Map map = this.F.call();
        if (map == null || map.isEmpty()) {
            return null;
        }
        boolean b = true;
        for (final Map.Entry entry : map.entrySet()) {
            final JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
            boolean b2 = true;
            for (final Map.Entry entry2 : ((Map)map.get(entry.getKey())).entrySet()) {
                jsonObjectBuilder2.appendField((String)entry2.getKey(), (int)entry2.getValue());
                b2 = false;
            }
            if (!b2) {
                b = false;
                jsonObjectBuilder.appendField((String)entry.getKey(), jsonObjectBuilder2.build());
            }
        }
        if (b) {
            return null;
        }
        return new JsonObjectBuilder().appendField("values", jsonObjectBuilder.build()).build();
    }
}
