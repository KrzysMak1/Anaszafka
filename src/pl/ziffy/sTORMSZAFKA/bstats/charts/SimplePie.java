// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.sTORMSZAFKA.bstats.charts;

import pl.ziffy.sTORMSZAFKA.bstats.json.JsonObjectBuilder;
import java.util.concurrent.Callable;

public class SimplePie extends CustomChart
{
    private final Callable<String> H;
    
    public SimplePie(final String s, final Callable<String> h) {
        super(s);
        this.H = h;
    }
    
    @Override
    protected JsonObjectBuilder.JsonObject getChartData() throws Exception {
        final String s = this.H.call();
        if (s == null || s.isEmpty()) {
            return null;
        }
        return new JsonObjectBuilder().appendField("value", s).build();
    }
}
