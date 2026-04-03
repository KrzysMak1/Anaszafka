// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.utils.time;

import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import pl.ziffy.STORMSZAFKA.Main;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

public class UtilsTimeUtilityService1
{
    private static final SimpleDateFormat C;
    private static final Pattern D;
    private static final String UtilsTimeUtilityService1 = "&#00FF00NA ZAWSZE";
    private static final String B = "na zawsze";
    
    public static String UtilsTimeUtilityService1() {
        try {
            if (Main.getInstance() != null && Main.getInstance().getConfig() != null) {
                return I(Main.getInstance().getConfig().getString("infinite_duration.display_text", "&#00FF00NA ZAWSZE"));
            }
        }
        catch (final Exception ex) {}
        return I("&#00FF00NA ZAWSZE");
    }
    
    public static String B() {
        try {
            if (Main.getInstance() != null && Main.getInstance().getConfig() != null) {
                return Main.getInstance().getConfig().getString("infinite_duration.polish_text", "na zawsze");
            }
        }
        catch (final Exception ex) {}
        return "na zawsze";
    }
    
    private static String I(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = Pattern.compile("&#([UtilsTimeUtilityService1-Fa-f0-9]{6})").matcher(s);
        final StringBuilder sb = new StringBuilder();
        int end = 0;
        while (matcher.find()) {
            sb.append(s, end, matcher.start());
            final String group = matcher.group(1);
            final StringBuilder s2 = new StringBuilder("§x");
            final char[] charArray = group.toCharArray();
            for (int length = charArray.length, i = 0; i < length; ++i) {
                s2.append("§").append(Character.toLowerCase(charArray[i]));
            }
            sb.append((CharSequence)s2);
            end = matcher.end();
        }
        sb.append(s.substring(end));
        return ChatColor.translateAlternateColorCodes('&', sb.toString());
    }
    
    public static long E(final String s) {
        if (s == null || s.isEmpty()) {
            return -1L;
        }
        if (s.equalsIgnoreCase("INFINITE")) {
            return -1L;
        }
        final Matcher matcher = pl.ziffy.STORMSZAFKA.utils.time.UtilsTimeUtilityService1.D.matcher(s.toLowerCase());
        if (!matcher.matches()) {
            return -1L;
        }
        final int int1 = Integer.parseInt(matcher.group(1));
        final String group = matcher.group(2);
        switch (group) {
            case "s": {
                return int1 * 1000L;
            }
            case "m": {
                return int1 * 60 * 1000L;
            }
            case "h": {
                return int1 * 60 * 60 * 1000L;
            }
            case "d": {
                return int1 * 24 * 60 * 60 * 1000L;
            }
            default: {
                return -1L;
            }
        }
    }
    
    public static boolean H(final String s) {
        return s != null && !s.isEmpty() && (s.equalsIgnoreCase("INFINITE") || pl.ziffy.STORMSZAFKA.utils.time.UtilsTimeUtilityService1.D.matcher(s.toLowerCase()).matches());
    }
    
    public static String G(final String source) {
        if (source == null || source.isEmpty()) {
            return B();
        }
        if (source.equalsIgnoreCase("INFINITE")) {
            return B();
        }
        if (source.matches("\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}")) {
            try {
                final long n = pl.ziffy.STORMSZAFKA.utils.time.UtilsTimeUtilityService1.C.parse(source).getTime() - new Date().getTime();
                if (n <= 0L) {
                    return "wygas\u0142";
                }
                final long n2 = n / 86400000L;
                final long n3 = n % 86400000L / 3600000L;
                final long n4 = n % 3600000L / 60000L;
                if (n2 > 0L) {
                    return n2 + ((n2 == 1L) ? " dzie\u0144" : " dni");
                }
                if (n3 > 0L) {
                    return n3 + ((n3 == 1L) ? " godzina" : ((n3 < 5L) ? " godziny" : " godzin"));
                }
                if (n4 > 0L) {
                    return n4 + ((n4 == 1L) ? " minuta" : ((n4 < 5L) ? " minuty" : " minut"));
                }
                return "mniej ni\u017c minuta";
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                return B();
            }
        }
        final Matcher matcher = pl.ziffy.STORMSZAFKA.utils.time.UtilsTimeUtilityService1.D.matcher(source.toLowerCase());
        if (!matcher.matches()) {
            return B();
        }
        final int int1 = Integer.parseInt(matcher.group(1));
        final String group = matcher.group(2);
        switch (group) {
            case "s": {
                if (int1 == 1) {
                    return "1 sekunda";
                }
                if (int1 < 5) {
                    return int1 + " sekundy";
                }
                return int1 + " sekund";
            }
            case "m": {
                if (int1 == 1) {
                    return "1 minuta";
                }
                if (int1 < 5) {
                    return int1 + " minuty";
                }
                return int1 + " minut";
            }
            case "h": {
                if (int1 == 1) {
                    return "1 godzina";
                }
                if (int1 < 5) {
                    return int1 + " godziny";
                }
                return int1 + " godzin";
            }
            case "d": {
                if (int1 == 1) {
                    return "1 dzie\u0144";
                }
                return int1 + " dni";
            }
            default: {
                return B();
            }
        }
    }
    
    public static Date B(final String s) {
        final long e = E(s);
        if (e == -1L) {
            return null;
        }
        final Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(instance.getTimeInMillis() + e);
        return instance.getTime();
    }
    
    public static String C(final Date date) {
        if (date == null) {
            return null;
        }
        return pl.ziffy.STORMSZAFKA.utils.time.UtilsTimeUtilityService1.C.format(date);
    }
    
    public static boolean B(final Date when) {
        return when != null && new Date().after(when);
    }
    
    public static boolean F(final String source) {
        if (source == null || source.equals("brak") || source.equals("INFINITE")) {
            return false;
        }
        try {
            return B(pl.ziffy.STORMSZAFKA.utils.time.UtilsTimeUtilityService1.C.parse(source));
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    public static String D(final Date date) {
        if (date == null) {
            return "INFINITE";
        }
        return pl.ziffy.STORMSZAFKA.utils.time.UtilsTimeUtilityService1.C.format(date);
    }
    
    public static Date D(final String s) {
        return B(s);
    }
    
    public static String UtilsTimeUtilityService1(final Date date) {
        return pl.ziffy.STORMSZAFKA.utils.time.UtilsTimeUtilityService1.C.format(date);
    }
    
    public static Date C(final String s) {
        if (s == null || s.equalsIgnoreCase("INFINITE") || s.equalsIgnoreCase("aktywny")) {
            return null;
        }
        final long e = E(s);
        if (e == -1L) {
            return null;
        }
        final Calendar instance = Calendar.getInstance();
        instance.add(14, (int)e);
        return instance.getTime();
    }
    
    public static LocalDateTime J(final String s) {
        if (s == null || s.equalsIgnoreCase("INFINITE") || s.equalsIgnoreCase("brak") || s.equalsIgnoreCase("aktywny")) {
            return null;
        }
        final long e = E(s);
        if (e == -1L) {
            return null;
        }
        return LocalDateTime.now().plusSeconds(e / 1000L);
    }
    
    public static LocalDateTime UtilsTimeUtilityService1(final String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        try {
            return LocalDateTime.parse(s, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        }
        catch (final Exception ex) {
            try {
                return LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
            catch (final Exception ex2) {
                System.err.println("B\u0142\u0105d parsowania daty wyga\u015bni\u0119cia: " + s);
                return null;
            }
        }
    }
    
    public static String UtilsTimeUtilityService1(final LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }
    
    public static boolean B(final LocalDateTime other) {
        return other != null && LocalDateTime.now().isAfter(other);
    }
    
    static {
        C = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        D = Pattern.compile("^(\\d+)([smhd])$");
    }
}
