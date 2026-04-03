// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.utils.update;

import java.net.URLConnection;
import org.bukkit.plugin.Plugin;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URL;
import org.bukkit.Bukkit;
import java.util.function.Consumer;
import org.bukkit.plugin.java.JavaPlugin;

public class A
{
    private final JavaPlugin C;
    private final int E;
    private static final long B = 3600000L;
    private static String D;
    private static long A;
    
    public A(final JavaPlugin c, final int e) {
        this.C = c;
        this.E = e;
    }
    
    public void A(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously((Plugin)this.C, () -> {
            if (pl.ziffy.STORMSZAFKA.utils.update.A.D != null && System.currentTimeMillis() - pl.ziffy.STORMSZAFKA.utils.update.A.A < 3600000L) {
                consumer2.accept(pl.ziffy.STORMSZAFKA.utils.update.A.D);
            }
            else {
                try {
                    new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.E).openConnection();
                    final URLConnection urlConnection;
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.setReadTimeout(5000);
                    urlConnection.addRequestProperty("User-Agent", "StormSzafka-UpdateChecker");
                    new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    try {
                        final BufferedReader bufferedReader2;
                        bufferedReader2.readLine();
                        final String s;
                        if (s != null && !s.trim().isEmpty()) {
                            pl.ziffy.STORMSZAFKA.utils.update.A.D = s.trim();
                            pl.ziffy.STORMSZAFKA.utils.update.A.A = System.currentTimeMillis();
                            consumer2.accept(pl.ziffy.STORMSZAFKA.utils.update.A.D);
                        }
                        else {
                            consumer2.accept(null);
                        }
                        bufferedReader2.close();
                    }
                    catch (final Throwable t) {
                        try {
                            final BufferedReader bufferedReader2;
                            bufferedReader2.close();
                        }
                        catch (final Throwable exception) {
                            t.addSuppressed(exception);
                        }
                        throw t;
                    }
                }
                catch (final Exception ex) {
                    this.C.getLogger().warning("Nie uda\u0142o si\u0119 sprawdzi\u0107 aktualizacji: " + ex.getMessage());
                    consumer2.accept(null);
                }
            }
        });
    }
    
    private static int A(String trim, String trim2) {
        if (trim == null || trim2 == null) {
            return 0;
        }
        trim = trim.replaceAll("[Tt]$", "").trim();
        trim2 = trim2.replaceAll("[Tt]$", "").trim();
        final String[] split = trim.split("\\.");
        final String[] split2 = trim2.split("\\.");
        for (int max = Math.max(split.length, split2.length), i = 0; i < max; ++i) {
            int int1 = 0;
            int int2 = 0;
            if (i < split.length) {
                try {
                    int1 = Integer.parseInt(split[i]);
                }
                catch (final NumberFormatException ex) {
                    int1 = 0;
                }
            }
            if (i < split2.length) {
                try {
                    int2 = Integer.parseInt(split2[i]);
                }
                catch (final NumberFormatException ex2) {
                    int2 = 0;
                }
            }
            if (int1 < int2) {
                return -1;
            }
            if (int1 > int2) {
                return 1;
            }
        }
        return 0;
    }
    
    public void A(final String s, final Consumer<Boolean> consumer) {
        this.A(s3 -> {
            if (s3 == null) {
                consumer2.accept(false);
            }
            else {
                consumer2.accept(A(s3, s2) > 0);
            }
        });
    }
    
    static {
        pl.ziffy.STORMSZAFKA.utils.update.A.D = null;
        pl.ziffy.STORMSZAFKA.utils.update.A.A = 0L;
    }
}
