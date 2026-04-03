// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.utils.color;

import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import java.util.regex.Pattern;

public class UtilsColorUtilityService1
{
    private static final Pattern UtilsColorUtilityService1;
    
    public static String UtilsColorUtilityService1(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = pl.ziffy.STORMSZAFKA.utils.color.UtilsColorUtilityService1.UtilsColorUtilityService1.matcher(s);
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
        return input != null && pl.ziffy.STORMSZAFKA.utils.color.UtilsColorUtilityService1.UtilsColorUtilityService1.matcher(input).find();
    }
    
    public static String C(String replaceAll) {
        if (replaceAll == null) {
            return null;
        }
        replaceAll = replaceAll.replaceAll("&#[UtilsColorUtilityService1-Fa-f0-9]{6}", "");
        return ChatColor.stripColor(replaceAll);
    }
    
    static {
        UtilsColorUtilityService1 = Pattern.compile("&#([UtilsColorUtilityService1-Fa-f0-9]{6})");
    }
}
