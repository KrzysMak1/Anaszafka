// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.utils;

import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import java.util.regex.Pattern;

public class B
{
    private static final Pattern A;
    
    public static String A(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = B.A.matcher(s);
        final StringBuilder sb = new StringBuilder();
        int end = 0;
        while (matcher.find()) {
            sb.append(s, end, matcher.start());
            final String group = matcher.group(1);
            sb.append("§x");
            final char[] charArray = group.toCharArray();
            for (int length = charArray.length, i = 0; i < length; ++i) {
                sb.append("§").append(charArray[i]);
            }
            end = matcher.end();
        }
        sb.append(s.substring(end));
        return ChatColor.translateAlternateColorCodes('&', sb.toString());
    }
    
    public static boolean B(final String input) {
        return input != null && B.A.matcher(input).find();
    }
    
    public static String C(String replaceAll) {
        if (replaceAll == null) {
            return null;
        }
        replaceAll = replaceAll.replaceAll("&#[A-Fa-f0-9]{6}", "");
        return ChatColor.stripColor(replaceAll);
    }
    
    static {
        A = Pattern.compile("&#([A-Fa-f0-9]{6})");
    }
}
