// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.lang.reflect.Field;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.GameProfile;
import java.net.URL;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.inventory.meta.SkullMeta;
import java.lang.reflect.Method;

public class UtilsUtilityService2
{
    private static int UtilsUtilityService3;
    private static Method F;
    private static Method UtilsUtilityService2;
    private static Class<?> UtilsUtilityService1;
    private static Class<?> E;
    private static Method UtilsListener1;
    private static Class<?> H;
    private static Class<?> G;
    
    public static void UtilsUtilityService3(final SkullMeta skullMeta, final String s) {
        if (skullMeta == null || s == null || s.isEmpty()) {
            return;
        }
        if (pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService3 == -1) {
            UtilsListener1();
        }
        boolean b = false;
        if (pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService3 == 2) {
            b = UtilsUtilityService1(skullMeta, s);
        }
        if (!b && pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService3 >= 1) {
            b = UtilsListener1(skullMeta, s);
        }
        if (!b) {
            UtilsUtilityService2(skullMeta, s);
        }
    }
    
    private static void UtilsListener1() {
        try {
            pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.H = Class.forName("com.destroystokyo.paper.profile.PlayerProfile");
            pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.G = Class.forName("com.destroystokyo.paper.profile.ProfileProperty");
            pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsListener1 = Bukkit.class.getMethod("createProfile", UUID.class, String.class);
            pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService3 = 2;
            try {
                pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService1 = Class.forName("org.bukkit.profile.PlayerProfile");
                pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.E = Class.forName("org.bukkit.profile.PlayerTextures");
                pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.F = Bukkit.class.getMethod("createPlayerProfile", UUID.class, String.class);
                pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService2 = SkullMeta.class.getMethod("setOwnerProfile", pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService1);
            }
            catch (final Exception ex) {}
        }
        catch (final Exception ex2) {
            try {
                pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService1 = Class.forName("org.bukkit.profile.PlayerProfile");
                pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.E = Class.forName("org.bukkit.profile.PlayerTextures");
                pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.F = Bukkit.class.getMethod("createPlayerProfile", UUID.class, String.class);
                pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService2 = SkullMeta.class.getMethod("setOwnerProfile", pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService1);
                pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService3 = 1;
            }
            catch (final Exception ex3) {
                pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService3 = 0;
            }
        }
    }
    
    private static boolean UtilsListener1(final SkullMeta obj, final String s) {
        try {
            if (pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.F == null || pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService2 == null) {
                return false;
            }
            final Object invoke = pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.F.invoke(null, UUID.randomUUID(), "");
            final Object invoke2 = pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService1.getMethod("getTextures", (Class<?>[])new Class[0]).invoke(invoke, new Object[0]);
            final String a = UtilsListener1(s);
            if (a == null) {
                return false;
            }
            pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.E.getMethod("setSkin", URL.class).invoke(invoke2, new URL(a));
            pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService2.invoke(obj, invoke);
            return true;
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    private static boolean UtilsUtilityService1(final SkullMeta obj, final String s) {
        try {
            final Object invoke = pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsListener1.invoke(null, UUID.randomUUID(), "");
            final Object invoke2 = pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.H.getMethod("getProperties", (Class<?>[])new Class[0]).invoke(invoke, new Object[0]);
            invoke2.getClass().getMethod("add", Object.class).invoke(invoke2, pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.G.getConstructor(String.class, String.class).newInstance("textures", s));
            obj.getClass().getMethod("setPlayerProfile", pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.H).invoke(obj, invoke);
            return true;
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    private static void UtilsUtilityService2(final SkullMeta obj, final String s) {
        try {
            final GameProfile value = new GameProfile(UUID.randomUUID(), "");
            value.getProperties().put((Object)"textures", (Object)new Property("textures", s));
            final Field a = UtilsListener1(obj);
            if (a != null) {
                a.setAccessible(true);
                a.set(obj, value);
            }
        }
        catch (final Exception ex) {}
    }
    
    private static Field UtilsListener1(final SkullMeta skullMeta) {
        Class clazz = skullMeta.getClass();
        final String[] array = { "profile", "serializedProfile", "playerProfile" };
        while (clazz != null && clazz != Object.class) {
            final String[] array2 = array;
            final int length = array2.length;
            int i = 0;
            while (i < length) {
                final String name = array2[i];
                try {
                    return clazz.getDeclaredField(name);
                }
                catch (final NoSuchFieldException ex) {
                    ++i;
                    continue;
                }
                break;
            }
            for (final Field field : clazz.getDeclaredFields()) {
                final String name2 = field.getType().getName();
                if (name2.contains("GameProfile") || name2.contains("PlayerProfile")) {
                    return field;
                }
            }
            clazz = clazz.getSuperclass();
        }
        return null;
    }
    
    private static String UtilsListener1(final String src) {
        try {
            final String s = new String(Base64.getDecoder().decode(src), StandardCharsets.UTF_8);
            final int index = s.indexOf("\"url\"");
            if (index == -1) {
                final int index2 = s.indexOf("url:");
                if (index2 == -1) {
                    return null;
                }
                final int index3 = s.indexOf(":", index2);
                if (index3 == -1) {
                    return null;
                }
                final int index4 = s.indexOf("\"", index3);
                if (index4 == -1) {
                    return null;
                }
                final int index5 = s.indexOf("\"", index4 + 1);
                if (index5 == -1) {
                    return null;
                }
                return s.substring(index4 + 1, index5);
            }
            else {
                final int index6 = s.indexOf("\"", index + 5);
                if (index6 == -1) {
                    return null;
                }
                final int index7 = s.indexOf("\"", index6 + 1);
                if (index7 == -1) {
                    return null;
                }
                return s.substring(index6 + 1, index7);
            }
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    static {
        pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService3 = -1;
        pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.F = null;
        pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService2 = null;
        pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsUtilityService1 = null;
        pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.E = null;
        pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.UtilsListener1 = null;
        pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.H = null;
        pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.G = null;
    }
}
