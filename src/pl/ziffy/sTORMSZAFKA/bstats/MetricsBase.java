// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.sTORMSZAFKA.bstats;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.util.function.Predicate;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.HashSet;
import pl.ziffy.sTORMSZAFKA.bstats.charts.CustomChart;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import pl.ziffy.sTORMSZAFKA.bstats.json.JsonObjectBuilder;
import java.util.function.Consumer;
import java.util.concurrent.ScheduledExecutorService;

public class MetricsBase
{
    public static final String METRICS_VERSION = "3.0.2";
    private static final String P = "https://bStats.org/api/v2/data/%s";
    private final ScheduledExecutorService H;
    private final String D;
    private final String B;
    private final int O;
    private final Consumer<JsonObjectBuilder> A;
    private final Consumer<JsonObjectBuilder> G;
    private final Consumer<Runnable> J;
    private final Supplier<Boolean> M;
    private final BiConsumer<String, Throwable> N;
    private final Consumer<String> L;
    private final boolean I;
    private final boolean E;
    private final boolean F;
    private final Set<CustomChart> C;
    private final boolean K;
    
    public MetricsBase(final String d, final String b, final int o, final boolean k, final Consumer<JsonObjectBuilder> a, final Consumer<JsonObjectBuilder> g, final Consumer<Runnable> j, final Supplier<Boolean> m, final BiConsumer<String, Throwable> n, final Consumer<String> l, final boolean i, final boolean e, final boolean f) {
        this.C = new HashSet<CustomChart>();
        final ScheduledThreadPoolExecutor h = new ScheduledThreadPoolExecutor(1, task -> new Thread(task, "bStats-Metrics"));
        h.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        this.H = h;
        this.D = d;
        this.B = b;
        this.O = o;
        this.K = k;
        this.A = a;
        this.G = g;
        this.J = j;
        this.M = m;
        this.N = n;
        this.L = l;
        this.I = i;
        this.E = e;
        this.F = f;
        this.D();
        if (k) {
            this.C();
        }
    }
    
    public void addCustomChart(final CustomChart customChart) {
        this.C.add(customChart);
    }
    
    public void shutdown() {
        this.H.shutdown();
    }
    
    private void C() {
        final Runnable runnable = () -> {
            if (!this.K || !this.M.get()) {
                this.H.shutdown();
                return;
            }
            else {
                if (this.J != null) {
                    this.J.accept(this::A);
                }
                else {
                    this.A();
                }
                return;
            }
        };
        final long n = (long)(60000.0 * (3.0 + Math.random() * 3.0));
        final long n2 = (long)(60000.0 * (Math.random() * 30.0));
        this.H.schedule(runnable, n, TimeUnit.MILLISECONDS);
        this.H.scheduleAtFixedRate(runnable, n + n2, 1800000L, TimeUnit.MILLISECONDS);
    }
    
    private void A() {
        final JsonObjectBuilder jsonObjectBuilder3 = new JsonObjectBuilder();
        this.A.accept(jsonObjectBuilder3);
        final JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
        this.G.accept(jsonObjectBuilder2);
        final JsonObjectBuilder.JsonObject[] array = this.C.stream().map(customChart -> customChart.getRequestJsonObject(this.N, this.I)).filter(Objects::nonNull).toArray(JsonObjectBuilder.JsonObject[]::new);
        jsonObjectBuilder2.appendField("id", this.O);
        jsonObjectBuilder2.appendField("customCharts", array);
        jsonObjectBuilder3.appendField("service", jsonObjectBuilder2.build());
        jsonObjectBuilder3.appendField("serverUUID", this.B);
        jsonObjectBuilder3.appendField("metricsVersion", "3.0.2");
        this.H.execute(() -> {
            final JsonObjectBuilder jsonObjectBuilder3;
            jsonObjectBuilder3.build();
            try {
                this.B(jsonObject);
            }
            catch (final Exception ex) {
                if (this.I) {
                    this.N.accept("Could not submit bStats metrics data", ex);
                }
            }
        });
    }
    
    private void B(final JsonObjectBuilder.JsonObject jsonObject) throws Exception {
        if (this.E) {
            this.L.accept("Sent bStats metrics data: " + jsonObject.toString());
        }
        final HttpsURLConnection httpsURLConnection = (HttpsURLConnection)new URL(String.format("https://bStats.org/api/v2/data/%s", this.D)).openConnection();
        final byte[] a = A(jsonObject.toString());
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.addRequestProperty("Accept", "application/json");
        httpsURLConnection.addRequestProperty("Connection", "close");
        httpsURLConnection.addRequestProperty("Content-Encoding", "gzip");
        httpsURLConnection.addRequestProperty("Content-Length", String.valueOf(a.length));
        httpsURLConnection.setRequestProperty("Content-Type", "application/json");
        httpsURLConnection.setRequestProperty("User-Agent", "Metrics-Service/1");
        httpsURLConnection.setDoOutput(true);
        try (final DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream())) {
            dataOutputStream.write(a);
        }
        final StringBuilder obj = new StringBuilder();
        try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                obj.append(line);
            }
        }
        if (this.F) {
            this.L.accept("Sent data to bStats and received response: " + (Object)obj);
        }
    }
    
    private void D() {
        if (System.getProperty("bstats.relocatecheck") == null || !System.getProperty("bstats.relocatecheck").equals("false")) {
            final String prefix = new String(new byte[] { 111, 114, 103, 46, 98, 115, 116, 97, 116, 115 });
            final String prefix2 = new String(new byte[] { 121, 111, 117, 114, 46, 112, 97, 99, 107, 97, 103, 101 });
            if (MetricsBase.class.getPackage().getName().startsWith(prefix) || MetricsBase.class.getPackage().getName().startsWith(prefix2)) {
                throw new IllegalStateException("bStats Metrics class has not been relocated correctly!");
            }
        }
    }
    
    private static byte[] A(final String s) throws IOException {
        if (s == null) {
            return null;
        }
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(out)) {
            gzipOutputStream.write(s.getBytes(StandardCharsets.UTF_8));
        }
        return out.toByteArray();
    }
}
