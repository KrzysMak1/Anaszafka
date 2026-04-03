// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.sTORMSZAFKA.bstats.charts;

import pl.ziffy.sTORMSZAFKA.bstats.json.JsonObjectBuilder;
import java.util.function.BiConsumer;

public abstract class CustomChart
{
    private final String A;
    
    protected CustomChart(final String a) {
        if (a == null) {
            throw new IllegalArgumentException("chartId must not be null");
        }
        this.A = a;
    }
    
    public JsonObjectBuilder.JsonObject getRequestJsonObject(final BiConsumer<String, Throwable> biConsumer, final boolean b) {
        final JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        jsonObjectBuilder.appendField("chartId", this.A);
        try {
            final JsonObjectBuilder.JsonObject chartData = this.getChartData();
            if (chartData == null) {
                return null;
            }
            jsonObjectBuilder.appendField("data", chartData);
        }
        catch (final Throwable t) {
            if (b) {
                biConsumer.accept("Failed to get data for custom chart with id " + this.A, t);
            }
            return null;
        }
        return jsonObjectBuilder.build();
    }
    
    protected abstract JsonObjectBuilder.JsonObject getChartData() throws Exception;
}
