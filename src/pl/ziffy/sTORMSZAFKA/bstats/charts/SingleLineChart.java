// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.sTORMSZAFKA.bstats.charts;

import pl.ziffy.sTORMSZAFKA.bstats.json.JsonObjectBuilder;
import java.util.concurrent.Callable;

public class SingleLineChart extends CustomChart
{
    private final Callable<Integer> C;
    
    public SingleLineChart(final String s, final Callable<Integer> c) {
        super(s);
        this.C = c;
    }
    
    @Override
    protected JsonObjectBuilder.JsonObject getChartData() throws Exception {
        final int intValue = this.C.call();
        if (intValue == 0) {
            return null;
        }
        return new JsonObjectBuilder().appendField("value", intValue).build();
    }
}
