// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.data;

import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DataDataModel4
{
    public double DataDataModel2;
    public boolean A;
    public String D;
    public int DataDataModel1;
    
    public DataDataModel4() {
        this.DataDataModel2 = 1.0;
        this.A = false;
        this.D = null;
        this.DataDataModel1 = 0;
    }
    
    public DataDataModel4(final double c, final boolean a, final String d, final int b) {
        this.DataDataModel2 = c;
        this.A = a;
        this.D = d;
        this.DataDataModel1 = b;
    }
    
    public boolean DataDataModel1() {
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
        if (this.A && !this.DataDataModel1()) {
            return this.DataDataModel2;
        }
        return 1.0;
    }
    
    @Override
    public String toString() {
        return "SakiewkaEntry{dropMultiplier=" + this.DataDataModel2 + ", bonusActive=" + this.A + ", bonusExpiration='" + this.D + "', totalDrops=" + this.DataDataModel1;
    }
}
