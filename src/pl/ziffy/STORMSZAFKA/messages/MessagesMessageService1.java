// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.messages;

import java.util.Collection;
import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.CopyOption;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import pl.ziffy.STORMSZAFKA.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class MessagesMessageService1
{
    private Plugin E;
    private String D;
    FileConfiguration G;
    private static final Pattern C;
    private static final Pattern B;
    private List<String> F;
    private static MessagesMessageService1 MessagesMessageService1;
    
    public MessagesMessageService1(final Plugin e) {
        this.E = e;
        pl.ziffy.STORMSZAFKA.messages.MessagesMessageService1.MessagesMessageService1 = this;
        this.F = new ArrayList<String>();
        this.D();
        this.C();
    }
    
    public static MessagesMessageService1 E() {
        return pl.ziffy.STORMSZAFKA.messages.MessagesMessageService1.MessagesMessageService1;
    }
    
    private void D() {
        this.F.clear();
        this.F.add("POL");
        this.F.add("ENG");
        final File file = new File(((Main)this.E).getCustomDataFolder(), "lang");
        if (!file.exists()) {
            file.mkdirs();
            return;
        }
        final File[] listFiles = file.listFiles((p0, s) -> s.endsWith(".yml"));
        if (listFiles != null) {
            final File[] array = listFiles;
            for (int length = array.length, i = 0; i < length; ++i) {
                final String replace = array[i].getName().replace(".yml", "");
                if (!this.F.contains(replace)) {
                    this.F.add(replace);
                }
            }
        }
    }
    
    public void C() {
        this.D();
        this.D = this.E.getConfig().getString("settings.language", "POL");
        if (!this.C(this.D)) {
            this.E.getLogger().warning("Invalid language " + this.D + ", falling back to POL");
            this.D = "POL";
        }
        final File file = new File(((Main)this.E).getCustomDataFolder(), "lang");
        if (!file.exists()) {
            file.mkdirs();
        }
        this.E("POL.yml");
        this.E("ENG.yml");
        final File file2 = new File(String.valueOf(((Main)this.E).getCustomDataFolder()) + "/lang", this.D + ".yml");
        if (!file2.exists()) {
            this.E.getLogger().severe("Language file does not exist: " + file2.getAbsolutePath());
        }
        this.G = (FileConfiguration)YamlConfiguration.loadConfiguration(file2);
        if (this.G.getString("menu.main-title") == null) {
            this.E.getLogger().severe("Language file loaded but test key 'menu.main-title' is missing!");
        }
    }
    
    private void E(final String child) {
        final File file = new File(String.valueOf(((Main)this.E).getCustomDataFolder()) + "/lang", child);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                final InputStream resource = this.E.getResource("lang/" + child);
                if (resource != null) {
                    Files.copy(resource, file.toPath(), new CopyOption[0]);
                    resource.close();
                }
                else {
                    this.E.getLogger().warning("Could not find language file in resources: lang/" + child);
                }
            }
            catch (final IOException ex) {
                this.E.getLogger().severe("Failed to copy language file " + child + ": " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    
    private boolean C(final String s) {
        return this.F.contains(s);
    }
    
    public String F(final String s) {
        final String string = this.G.getString(s);
        if (string == null) {
            return "§cMissing language key: " + s;
        }
        return B(string);
    }
    
    public String MessagesMessageService1(final String s, final Map<String, String> map) {
        String s2 = this.F(s);
        for (Map.Entry entry : map.entrySet()) {
            s2 = s2.replace("%" + (String)entry.getKey(), (CharSequence)entry.getValue());
        }
        return s2;
    }
    
    public String MessagesMessageService1(final String s, final String s2, final String s3) {
        final HashMap hashMap = new HashMap();
        hashMap.put(s2, s3);
        return this.MessagesMessageService1(s, hashMap);
    }
    
    public void MessagesMessageService1(final Player player, final String s) {
        this.MessagesMessageService1(player, s, new HashMap<String, String>());
    }
    
    public void MessagesMessageService1(final Player player, final String s, final Map<String, String> map) {
        final Object value = this.G.get(s);
        if (value == null) {
            player.sendMessage("§cMissing language key: " + s);
            return;
        }
        if (value instanceof String) {
            player.sendMessage(this.MessagesMessageService1(s, map));
            return;
        }
        if (value instanceof final ConfigurationSection configurationSection) {
            if (configurationSection.contains("chat")) {
                final String string = configurationSection.getString("chat");
                if (string != null && !string.isEmpty()) {
                    String s2 = B(string);
                    for (Map.Entry entry : map.entrySet()) {
                        s2 = s2.replace("%" + (String)entry.getKey(), (CharSequence)entry.getValue());
                    }
                    player.sendMessage(s2);
                }
            }
            if (configurationSection.contains("title") || configurationSection.contains("subtitle")) {
                final String string2 = configurationSection.getString("title", "");
                final String string3 = configurationSection.getString("subtitle", "");
                final int int1 = configurationSection.getInt("fade-in", 10);
                final int int2 = configurationSection.getInt("stay", 70);
                final int int3 = configurationSection.getInt("fade-out", 20);
                String s3 = B(string2);
                String s4 = B(string3);
                for (Map.Entry entry2 : map.entrySet()) {
                    s3 = s3.replace("%" + (String)entry2.getKey(), (CharSequence)entry2.getValue());
                    s4 = s4.replace("%" + (String)entry2.getKey(), (CharSequence)entry2.getValue());
                }
                player.sendTitle(s3, s4, int1, int2, int3);
            }
            if (configurationSection.contains("actionbar")) {
                final String string4 = configurationSection.getString("actionbar");
                if (string4 != null && !string4.isEmpty()) {
                    String s5 = B(string4);
                    for (Map.Entry entry3 : map.entrySet()) {
                        s5 = s5.replace("%" + (String)entry3.getKey(), (CharSequence)entry3.getValue());
                    }
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(s5));
                }
            }
            return;
        }
        player.sendMessage("§eUnknown message format for: " + s);
    }
    
    public void MessagesMessageService1(final Player player, final String s, final String s2, final String s3) {
        final HashMap hashMap = new HashMap();
        hashMap.put(s2, s3);
        this.MessagesMessageService1(player, s, hashMap);
    }
    
    public static String B(final String input) {
        if (input == null) {
            return "";
        }
        final Matcher matcher = pl.ziffy.STORMSZAFKA.messages.MessagesMessageService1.C.matcher(input);
        final StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            final String group = matcher.group(1);
            final StringBuilder sb2 = new StringBuilder("&x");
            final char[] charArray = group.toCharArray();
            for (int length = charArray.length, i = 0; i < length; ++i) {
                sb2.append("&").append(charArray[i]);
            }
            matcher.appendReplacement(sb, sb2.toString());
        }
        matcher.appendTail(sb);
        return ChatColor.translateAlternateColorCodes('&', sb.toString());
    }
    
    public String B() {
        return this.D;
    }
    
    public List<String> MessagesMessageService1() {
        return new ArrayList<String>(this.F);
    }
    
    public boolean MessagesMessageService1(final String d) {
        if (!this.C(d)) {
            return false;
        }
        this.E.getConfig().set("settings.language", (Object)d);
        try {
            this.E.saveConfig();
        }
        catch (final Exception ex) {
            return false;
        }
        this.D = d;
        this.C();
        return true;
    }
    
    public boolean D(final String s) {
        return this.G.get(s) instanceof ConfigurationSection;
    }
    
    static {
        C = Pattern.compile("&#([MessagesMessageService1-Fa-f0-9]{6})");
        B = Pattern.compile("%([a-zA-Z0-9_]+)%");
    }
}
