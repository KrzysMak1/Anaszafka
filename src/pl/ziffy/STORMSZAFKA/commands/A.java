// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.commands;

import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import java.util.regex.Pattern;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import pl.ziffy.STORMSZAFKA.regions.B;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.command.CommandExecutor;

public class A implements CommandExecutor
{
    private final Main C;
    private final C B;
    private final D A;
    
    public A(final Main c) {
        this.C = c;
        this.B = new C(c);
        this.A = new D(c, new B((Plugin)c), new pl.ziffy.STORMSZAFKA.regions.A((Plugin)c));
    }
    
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] array) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(this.A("&8» &7Ta komenda mo\u017ce by\u0107 u\u017cyta tylko przez &#FF0000gracza&7!"));
            return true;
        }
        final Player player = (Player)commandSender;
        final String lowerCase = command.getName().toLowerCase();
        switch (lowerCase) {
            case "szafka": {
                return this.B(player, array);
            }
            case "stormszafka": {
                return this.E(player, array);
            }
            case "pet": {
                return this.B.onCommand(commandSender, command, s, array);
            }
            case "region": {
                return this.A.onCommand(commandSender, command, s, array);
            }
            default: {
                return false;
            }
        }
    }
    
    private boolean B(final Player player, final String[] array) {
        try {
            pl.ziffy.STORMSZAFKA.ui.menu.A.openMainMenu(player);
            return true;
        }
        catch (final Exception ex) {
            player.sendMessage(this.A("&8» &7B\u0142\u0105d podczas otwierania &#FF0000menu&7!"));
            ex.printStackTrace();
            return false;
        }
    }
    
    private boolean E(final Player player, final String[] array) {
        if (array.length == 0) {
            player.sendMessage(this.A("&7U\u017cycie: &f/stormszafka &8<&fsubcommand&8>"));
            return false;
        }
        final String lowerCase;
        final String s = lowerCase = array[0].toLowerCase();
        switch (lowerCase) {
            case "give": {
                return this.A(player, array);
            }
            case "remove": {
                return this.D(player, array);
            }
            case "list": {
                return this.C(player, array);
            }
            case "reload": {
                return this.A(player);
            }
            default: {
                player.sendMessage(this.A("&8» &7Nieznana podkomenda: &#FF0000" + s));
                return false;
            }
        }
    }
    
    private boolean A(final Player player, final String[] array) {
        if (array.length < 2) {
            player.sendMessage(this.A("&7U\u017cycie: &f/stormszafka give &8<&fpet&8|&fkostium&8> <&ftyp&8> [&fczas&8] [&fgracz&8]"));
            return false;
        }
        final String lowerCase = array[1].toLowerCase();
        if (lowerCase.equals("pet")) {
            return this.B.onCommand((CommandSender)player, null, "pet", array);
        }
        if (lowerCase.equals("costume")) {
            player.sendMessage(this.A("&8» &7Komenda kostiumu &#FFD700nie zaimplementowana&7!"));
            return false;
        }
        player.sendMessage(this.A("&8» &7Nieznany typ: &#FF0000" + lowerCase));
        return false;
    }
    
    private boolean D(final Player player, final String[] array) {
        player.sendMessage(this.A("&8» &7Komenda remove &#FFD700nie zaimplementowana&7!"));
        return false;
    }
    
    private boolean C(final Player player, final String[] array) {
        player.sendMessage(this.A("&8» &7Komenda list &#FFD700nie zaimplementowana&7!"));
        return false;
    }
    
    private boolean A(final Player player) {
        if (!player.hasPermission("stormszafka.reload")) {
            player.sendMessage(this.A("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
            return false;
        }
        player.sendMessage(this.A("&8» &7Prze\u0142adowywanie &#FFD700pluginu&7..."));
        this.C.reloadConfig();
        player.sendMessage(this.A("&8» &7Plugin zosta\u0142 &#27FF00prze\u0142adowany&7!"));
        return true;
    }
    
    private String A(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = Pattern.compile("&#([A-Fa-f0-9]{6})").matcher(s);
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
}
