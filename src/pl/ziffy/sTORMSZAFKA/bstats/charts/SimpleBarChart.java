// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.sTORMSZAFKA.bstats.charts;

import java.util.Iterator;
import pl.ziffy.sTORMSZAFKA.bstats.json.JsonObjectBuilder;
import java.util.Map;
import java.util.concurrent.Callable;

public class SimpleBarChart extends CustomChart
{
    private final Callable<Map<String, Integer>> E;
    
    public SimpleBarChart(final String s, final Callable<Map<String, Integer>> e) {
        super(s);
        this.E = e;
    }
    
    @Override
    protected JsonObjectBuilder.JsonObject getChartData() throws Exception {
        final JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        final Map map = this.E.call();
        if (map == null || map.isEmpty()) {
            return null;
        }
        for (final Map.Entry entry : map.entrySet()) {
            jsonObjectBuilder.appendField((String)entry.getKey(), new int[] { (int)entry.getValue() });
        }
        return new JsonObjectBuilder().appendField("values", jsonObjectBuilder.build()).build();
    }
}
