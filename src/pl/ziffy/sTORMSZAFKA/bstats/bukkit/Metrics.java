// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.sTORMSZAFKA.bstats.bukkit;

import java.lang.reflect.Method;
import org.bukkit.entity.Player;
import java.util.Collection;
import pl.ziffy.sTORMSZAFKA.bstats.charts.CustomChart;
import pl.ziffy.sTORMSZAFKA.bstats.json.JsonObjectBuilder;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.Objects;
import org.bukkit.Bukkit;
import java.io.IOException;
import java.util.UUID;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import org.bukkit.plugin.java.JavaPlugin;
import pl.ziffy.sTORMSZAFKA.bstats.MetricsBase;
import org.bukkit.plugin.Plugin;

public class Metrics
{
    private final Plugin A;
    private final MetricsBase B;
    
    public Metrics(final JavaPlugin javaPlugin, final int n) {
        this.A = (Plugin)javaPlugin;
        final File file = new File(new File(javaPlugin.getDataFolder().getParentFile(), "bStats"), "config.yml");
        final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
        if (!loadConfiguration.isSet("serverUuid")) {
            loadConfiguration.addDefault("enabled", (Object)true);
            loadConfiguration.addDefault("serverUuid", (Object)UUID.randomUUID().toString());
            loadConfiguration.addDefault("logFailedRequests", (Object)false);
            loadConfiguration.addDefault("logSentData", (Object)false);
            loadConfiguration.addDefault("logResponseStatusText", (Object)false);
            loadConfiguration.options().header("bStats (https://bStats.org) collects some basic information for plugin authors, like how\nmany people use their plugin and their total player count. It's recommended to keep bStats\nenabled, but if you're not comfortable with this, you can turn this setting off. There is no\nperformance penalty associated with having metrics enabled, and data sent to bStats is fully\nanonymous.").copyDefaults(true);
            try {
                loadConfiguration.save(file);
            }
            catch (final IOException ex) {}
        }
        final boolean boolean1 = loadConfiguration.getBoolean("enabled", true);
        final String string = loadConfiguration.getString("serverUuid");
        final boolean boolean2 = loadConfiguration.getBoolean("logFailedRequests", false);
        final boolean boolean3 = loadConfiguration.getBoolean("logSentData", false);
        final boolean boolean4 = loadConfiguration.getBoolean("logResponseStatusText", false);
        final String s = "bukkit";
        final String s2 = string;
        final boolean b = boolean1;
        final Consumer<JsonObjectBuilder> consumer = this::B;
        final Consumer<JsonObjectBuilder> consumer2 = this::A;
        final Consumer consumer3 = runnable -> Bukkit.getScheduler().runTask((Plugin)javaPlugin2, runnable);
        Objects.requireNonNull(javaPlugin);
        this.B = new MetricsBase(s, s2, n, b, consumer, consumer2, consumer3, javaPlugin::isEnabled, (msg, thrown) -> this.A.getLogger().log(Level.WARNING, msg, thrown), msg2 -> this.A.getLogger().log(Level.INFO, msg2), boolean2, boolean3, boolean4);
    }
    
    public void shutdown() {
        this.B.shutdown();
    }
    
    public void addCustomChart(final CustomChart customChart) {
        this.B.addCustomChart(customChart);
    }
    
    private void B(final JsonObjectBuilder jsonObjectBuilder) {
        jsonObjectBuilder.appendField("playerAmount", this.A());
        jsonObjectBuilder.appendField("onlineMode", Bukkit.getOnlineMode() ? 1 : 0);
        jsonObjectBuilder.appendField("bukkitVersion", Bukkit.getVersion());
        jsonObjectBuilder.appendField("bukkitName", Bukkit.getName());
        jsonObjectBuilder.appendField("javaVersion", System.getProperty("java.version"));
        jsonObjectBuilder.appendField("osName", System.getProperty("os.name"));
        jsonObjectBuilder.appendField("osArch", System.getProperty("os.arch"));
        jsonObjectBuilder.appendField("osVersion", System.getProperty("os.version"));
        jsonObjectBuilder.appendField("coreCount", Runtime.getRuntime().availableProcessors());
    }
    
    private void A(final JsonObjectBuilder jsonObjectBuilder) {
        jsonObjectBuilder.appendField("pluginVersion", this.A.getDescription().getVersion());
    }
    
    private int A() {
        try {
            final Method method = Class.forName("org.bukkit.Server").getMethod("getOnlinePlayers", (Class<?>[])new Class[0]);
            return method.getReturnType().equals(Collection.class) ? ((Collection)method.invoke(Bukkit.getServer(), new Object[0])).size() : ((Player[])method.invoke(Bukkit.getServer(), new Object[0])).length;
        }
        catch (final Exception ex) {
            return Bukkit.getOnlinePlayers().size();
        }
    }
}
