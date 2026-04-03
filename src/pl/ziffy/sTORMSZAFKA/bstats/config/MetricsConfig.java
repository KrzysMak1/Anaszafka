// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.sTORMSZAFKA.bstats.config;

import java.util.Iterator;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;
import java.util.Optional;
import java.util.function.Function;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;

public class MetricsConfig
{
    private final File D;
    private final boolean B;
    private String G;
    private boolean C;
    private boolean F;
    private boolean E;
    private boolean H;
    private boolean A;
    
    public MetricsConfig(final File d, final boolean b) throws IOException {
        this.A = true;
        this.D = d;
        this.B = b;
        this.B();
    }
    
    public String getServerUUID() {
        return this.G;
    }
    
    public boolean isEnabled() {
        return this.C;
    }
    
    public boolean isLogErrorsEnabled() {
        return this.F;
    }
    
    public boolean isLogSentDataEnabled() {
        return this.E;
    }
    
    public boolean isLogResponseStatusTextEnabled() {
        return this.H;
    }
    
    public boolean didExistBefore() {
        return this.A;
    }
    
    private void B() throws IOException {
        if (!this.D.exists()) {
            this.A = false;
            this.C();
        }
        this.A();
        if (this.G == null) {
            this.C();
            this.A();
        }
    }
    
    private void C() throws IOException {
        final ArrayList list = new ArrayList();
        list.add("# bStats (https://bStats.org) collects some basic information for plugin authors, like");
        list.add("# how many people use their plugin and their total player count. It's recommended to keep");
        list.add("# bStats enabled, but if you're not comfortable with this, you can turn this setting off.");
        list.add("# There is no performance penalty associated with having metrics enabled, and data sent to");
        list.add("# bStats is fully anonymous.");
        list.add("enabled=" + this.B);
        list.add("server-uuid=" + UUID.randomUUID().toString());
        list.add("log-errors=false");
        list.add("log-sent-data=false");
        list.add("log-response-status-text=false");
        this.A(this.D, list);
    }
    
    private void A() throws IOException {
        final List<String> a = this.A(this.D);
        if (a == null) {
            throw new AssertionError((Object)"Content of newly created file is null");
        }
        this.C = this.A("enabled", a).map((Function<? super String, ?>)"true"::equals).orElse(true);
        this.G = this.A("server-uuid", a).orElse(null);
        this.F = this.A("log-errors", a).map((Function<? super String, ?>)"true"::equals).orElse(false);
        this.E = this.A("log-sent-data", a).map((Function<? super String, ?>)"true"::equals).orElse(false);
        this.H = this.A("log-response-status-text", a).map((Function<? super String, ?>)"true"::equals).orElse(false);
    }
    
    private Optional<String> A(final String s, final List<String> list) {
        return list.stream().filter(s2 -> s2.startsWith(str + "=")).map(s3 -> s3.replaceFirst(Pattern.quote(str2 + "="), "")).findFirst();
    }
    
    private List<String> A(final File file) throws IOException {
        if (!file.exists()) {
            return null;
        }
        try (final FileReader in = new FileReader(file);
             final BufferedReader bufferedReader = new BufferedReader(in)) {
            final List<? super String> list = bufferedReader.lines().collect((Collector<? super String, ?, List<? super String>>)Collectors.toList());
            return (List<String>)list;
        }
    }
    
    private void A(final File file, final List<String> list) throws IOException {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        try (final FileWriter out = new FileWriter(file);
             final BufferedWriter bufferedWriter = new BufferedWriter(out)) {
            final Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                bufferedWriter.write(iterator.next());
                bufferedWriter.newLine();
            }
        }
    }
}
