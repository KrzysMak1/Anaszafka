// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.data;

import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class F
{
    public double C;
    public boolean A;
    public String D;
    public int B;
    
    public F() {
        this.C = 1.0;
        this.A = false;
        this.D = null;
        this.B = 0;
    }
    
    public F(final double c, final boolean a, final String d, final int b) {
        this.C = c;
        this.A = a;
        this.D = d;
        this.B = b;
    }
    
    public boolean B() {
        if (!this.A || this.D == null) {
            return true;
        }
        try {
            return LocalDateTime.now().isAfter(LocalDateTime.parse(this.D, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        catch (final Exception ex) {
            return true;
        }
    }
    
    public double A() {
        if (this.A && !this.B()) {
            return this.C;
        }
        return 1.0;
    }
    
    @Override
    public String toString() {
        return "SakiewkaEntry{dropMultiplier=" + this.C + ", bonusActive=" + this.A + ", bonusExpiration='" + this.D + "', totalDrops=" + this.B;
    }
}
