// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.commands;

import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import java.util.regex.Pattern;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.entity.Player;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import pl.ziffy.STORMSZAFKA.data.DataDataModel3;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService3;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.CommandExecutor;

public class CommandsCommandExecutor2 implements CommandExecutor, TabCompleter
{
    private final G CommandsCommandExecutor1;
    private final E CommandsCommandExecutor2;
    
    public CommandsCommandExecutor2(final G a, final E b) {
        this.CommandsCommandExecutor1 = a;
        this.CommandsCommandExecutor2 = b;
    }
    
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] array) {
        if (command.getName().equalsIgnoreCase("STORMSZAFKA")) {
            if (array.length >= 1) {
                if (this.CommandsCommandExecutor1.CommandsCommandExecutor1(commandSender, array)) {
                    return true;
                }
                if (array[0].equalsIgnoreCase("resetcostume") && array.length >= 2) {
                    if (!commandSender.hasPermission("stormszafka.admin")) {
                        commandSender.sendMessage(this.CommandsCommandExecutor1("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                        return true;
                    }
                    final Player player = Bukkit.getPlayer(array[1]);
                    if (player == null) {
                        commandSender.sendMessage(this.CommandsCommandExecutor1("&8» &7Gracz &f" + array[1] + " &7nie jest &#FF0000online&7!"));
                        return true;
                    }
                    if (L.F(player)) {
                        L.CommandsCommandExecutor3(player);
                    }
                    this.CommandsCommandExecutor2.CommandsCommandExecutor4(player);
                    commandSender.sendMessage(this.CommandsCommandExecutor1("&8» &7Zresetowano dane kostiumu dla gracza &f" + player.getName() + " &#27FF00sukces&7!"));
                    player.sendMessage(this.CommandsCommandExecutor1("&8» &7Zresetowano twoje dane &#27FF00kostiumu&7!"));
                    return true;
                }
                else if (array[0].equalsIgnoreCase("fixcostumes")) {
                    if (!commandSender.hasPermission("stormszafka.admin")) {
                        commandSender.sendMessage(this.CommandsCommandExecutor1("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                        return true;
                    }
                    commandSender.sendMessage(this.CommandsCommandExecutor1("&8» &7Sprawdzanie i naprawianie uszkodzonych danych &#FFD700kostium\u00f3w&7..."));
                    final int e = this.CommandsCommandExecutor2.E();
                    if (e > 0) {
                        commandSender.sendMessage(this.CommandsCommandExecutor1("&8» &7Naprawiono &f" + e + " &7uszkodzonych wpis\u00f3w danych &#27FF00kostium\u00f3w&7!"));
                    }
                    else {
                        commandSender.sendMessage(this.CommandsCommandExecutor1("&8» &7Nie znaleziono uszkodzonych danych &#27FF00kostium\u00f3w&7."));
                    }
                    return true;
                }
            }
            commandSender.sendMessage("§8» §7U\u017cycie: §f/stormszafka give kostium <nazwa> [gracz]");
            commandSender.sendMessage("§8» §7U\u017cycie: §f/stormszafka resetcostume <gracz>");
            if (commandSender.hasPermission("stormszafka.admin")) {
                commandSender.sendMessage("§8» §7U\u017cycie: §f/stormszafka fixcostumes");
            }
            return true;
        }
        return false;
    }
    
    public List<String> onTabComplete(final CommandSender commandSender, final Command command, final String s, final String[] array) {
        if (command.getName().equalsIgnoreCase("STORMSZAFKA")) {
            if (array.length == 1) {
                final ArrayList list = new ArrayList();
                list.add("give");
                if (commandSender.hasPermission("stormszafka.admin")) {
                    list.add("resetcostume");
                    list.add("fixcostumes");
                }
                return (List)list.stream().filter(s2 -> s2.toLowerCase().startsWith(array2[0].toLowerCase())).collect(Collectors.toList());
            }
            if (array.length >= 2) {
                if (array[0].equalsIgnoreCase("give")) {
                    final List<String> b = this.CommandsCommandExecutor1.CommandsCommandExecutor2(commandSender, array);
                    if (!b.isEmpty()) {
                        return b;
                    }
                }
                else if (array[0].equalsIgnoreCase("resetcostume") && array.length == 2 && commandSender.hasPermission("stormszafka.admin")) {
                    return Bukkit.getOnlinePlayers().stream().map((Function<? super Object, ?>)Player::getName).filter(s3 -> s3.toLowerCase().startsWith(array3[1].toLowerCase())).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
                }
            }
        }
        return new ArrayList<String>();
    }
    
    private String CommandsCommandExecutor1(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = Pattern.compile("&#([CommandsCommandExecutor1-Fa-f0-9]{6})").matcher(s);
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
