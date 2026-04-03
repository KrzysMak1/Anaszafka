// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.fragments;

import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import java.util.regex.Pattern;
import java.util.Iterator;
import java.util.Collection;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.CommandExecutor;

public class A implements CommandExecutor, TabCompleter
{
    private final Main A;
    
    public A(final Main a) {
        this.A = a;
    }
    
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] array) {
        if (array.length == 0) {
            return false;
        }
        final String lowerCase = array[0].toLowerCase();
        if (!lowerCase.equals("odlamek") && !lowerCase.equals("fragment")) {
            return false;
        }
        if (array.length < 2) {
            commandSender.sendMessage(this.A("&7U\u017cycie: &f/stormszafka odlamek &8<&fustaw&8|&fgive&8>"));
            return true;
        }
        final String lowerCase2 = array[1].toLowerCase();
        if (lowerCase2.equals("ustaw") || lowerCase2.equals("set")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(this.A("&8» &7Ta komenda mo\u017ce by\u0107 u\u017cyta tylko przez &#FF0000gracza&7!"));
                return true;
            }
            if (!commandSender.hasPermission("stormszafka.fragment.set")) {
                commandSender.sendMessage(this.A("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                return true;
            }
            final Player player = (Player)commandSender;
            final ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
            if (itemInMainHand == null || itemInMainHand.getType().isAir()) {
                player.sendMessage(this.A("&8» &7Musisz trzyma\u0107 &#FF0000przedmiot &7w r\u0119ce!"));
                return true;
            }
            B.B(itemInMainHand);
            player.sendMessage(this.A("&8» &7Pomy\u015blnie ustawiono &#27FF00od\u0142amek peta&7!"));
            return true;
        }
        else {
            if (!lowerCase2.equals("give") && !lowerCase2.equals("daj")) {
                commandSender.sendMessage(this.A("&7U\u017cycie: &f/stormszafka odlamek &8<&fustaw&8|&fgive&8>"));
                return true;
            }
            if (!commandSender.hasPermission("stormszafka.fragment.give")) {
                commandSender.sendMessage(this.A("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                return true;
            }
            if (array.length < 3) {
                commandSender.sendMessage(this.A("&7U\u017cycie: &f/stormszafka odlamek give &8<&fgracz&8> [&filo\u015b\u0107&8]"));
                return true;
            }
            final Player player2 = Bukkit.getPlayer(array[2]);
            if (player2 == null) {
                commandSender.sendMessage(this.A("&8» &7Gracz nie jest &#FF0000online&7!"));
                return true;
            }
            int int1 = 1;
            if (array.length >= 4) {
                try {
                    int1 = Integer.parseInt(array[3]);
                    if (int1 <= 0) {
                        commandSender.sendMessage(this.A("&8» &7Ilo\u015b\u0107 musi by\u0107 &#FF0000wi\u0119ksza od 0&7!"));
                        return true;
                    }
                }
                catch (final NumberFormatException ex) {
                    commandSender.sendMessage(this.A("&8» &7Nieprawid\u0142owa &#FF0000ilo\u015b\u0107&7!"));
                    return true;
                }
            }
            B.A(player2, int1);
            commandSender.sendMessage(this.A("&8» &7Dano &f" + int1 + " &7od\u0142amk\u00f3w graczowi &#27FF00" + player2.getName() + "&7!"));
            player2.sendMessage(this.A("&8» &7Otrzyma\u0142e\u015b &f" + int1 + " &#27FF00od\u0142amk\u00f3w peta&7!"));
            return true;
        }
    }
    
    public List<String> onTabComplete(final CommandSender commandSender, final Command command, final String s, final String[] array) {
        final ArrayList list = new ArrayList();
        if (array.length == 1) {
            list.add("odlamek");
        }
        else if (array.length == 2 && (array[0].equalsIgnoreCase("odlamek") || array[0].equalsIgnoreCase("fragment"))) {
            list.add("ustaw");
            list.add("give");
        }
        else if (array.length == 3 && (array[1].equalsIgnoreCase("give") || array[1].equalsIgnoreCase("daj"))) {
            final Iterator iterator = Bukkit.getOnlinePlayers().iterator();
            while (iterator.hasNext()) {
                list.add(((Player)iterator.next()).getName());
            }
        }
        else if (array.length == 4 && (array[1].equalsIgnoreCase("give") || array[1].equalsIgnoreCase("daj"))) {
            list.addAll(Arrays.asList("1", "5", "10", "64"));
        }
        return list;
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
