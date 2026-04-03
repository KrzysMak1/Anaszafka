// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.sTORMSZAFKA.bstats.charts;

import java.util.Iterator;
import pl.ziffy.sTORMSZAFKA.bstats.json.JsonObjectBuilder;
import java.util.Map;
import java.util.concurrent.Callable;

public class MultiLineChart extends CustomChart
{
    private final Callable<Map<String, Integer>> D;
    
    public MultiLineChart(final String s, final Callable<Map<String, Integer>> d) {
        super(s);
        this.D = d;
    }
    
    @Override
    protected JsonObjectBuilder.JsonObject getChartData() throws Exception {
        final JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        final Map map = this.D.call();
        if (map == null || map.isEmpty()) {
            return null;
        }
        boolean b = true;
        for (final Map.Entry entry : map.entrySet()) {
            if ((int)entry.getValue() == 0) {
                continue;
            }
            b = false;
            jsonObjectBuilder.appendField((String)entry.getKey(), (int)entry.getValue());
        }
        if (b) {
            return null;
        }
        return new JsonObjectBuilder().appendField("values", jsonObjectBuilder.build()).build();
    }
}
