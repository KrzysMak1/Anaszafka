// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.commands;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import pl.ziffy.STORMSZAFKA.regions.A;
import pl.ziffy.STORMSZAFKA.regions.B;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.CommandExecutor;

public class D implements CommandExecutor, TabCompleter
{
    private final Main A;
    private final B C;
    private final A B;
    
    public D(final Main a, final B c, final A b) {
        this.A = a;
        this.C = c;
        this.B = b;
    }
    
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] array) {
        try {
            if (!this.A(commandSender, array)) {
                return true;
            }
            final Player player = (commandSender instanceof Player) ? commandSender : null;
            if (!this.A(player)) {
                return true;
            }
            if (array.length == 0) {
                this.A(commandSender);
                return true;
            }
            return this.A(player, commandSender, array);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            commandSender.sendMessage("§cWyst\u0105pi\u0142 b\u0142\u0105d podczas wykonywania komendy.");
            return true;
        }
    }
    
    private boolean A(final CommandSender commandSender, final String[] array) {
        if (!(commandSender instanceof Player) && (array.length == 0 || (!array[0].equals("list") && !array[0].equals("delete")))) {
            commandSender.sendMessage("§cTa komenda mo\u017ce by\u0107 u\u017cywana tylko przez graczy!");
            return false;
        }
        return true;
    }
    
    private boolean A(final Player player) {
        if (player != null && !player.hasPermission("stormszafka.region")) {
            final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
            if (e != null) {
                e.A(player, "general.no-permission");
            }
            else {
                player.sendMessage("§cNie masz uprawnie\u0144 do u\u017cywania tej komendy!");
            }
            return false;
        }
        return true;
    }
    
    private boolean A(final Player player, final CommandSender commandSender, final String[] array) {
        final String lowerCase = array[0].toLowerCase();
        switch (lowerCase) {
            case "wand": {
                return this.B(player);
            }
            case "create": {
                return this.B(player, array);
            }
            case "recreate": {
                return this.A(player, array);
            }
            case "delete": {
                return this.B(commandSender, array);
            }
            case "list": {
                this.B(commandSender);
                return true;
            }
            default: {
                this.A(commandSender);
                return true;
            }
        }
    }
    
    private boolean B(final Player player) {
        if (player == null) {
            return false;
        }
        try {
            player.getInventory().addItem(new ItemStack[] { this.B.A() });
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §7Otrzyma\u0142e\u015b §x§D§0§6§0§F§Fr\u00f3\u017cd\u017ck\u0119 §7do tworzenia §fregion\u00f3w§7!");
        }
        catch (final Exception ex) {
            player.sendMessage("§cWyst\u0105pi\u0142 b\u0142\u0105d podczas dawania r\u00f3\u017cd\u017cki!");
        }
        return true;
    }
    
    private boolean B(final Player player, final String[] array) {
        if (player == null) {
            return false;
        }
        if (array.length < 2) {
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §7U\u017cycie: §f/stormszafka region create <nazwa>");
            return true;
        }
        this.B(player, array[1].toLowerCase());
        return true;
    }
    
    private boolean A(final Player player, final String[] array) {
        if (player == null) {
            return false;
        }
        if (array.length < 2) {
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §7U\u017cycie: §f/stormszafka region recreate <nazwa>");
            return true;
        }
        this.A(player, array[1].toLowerCase());
        return true;
    }
    
    private boolean B(final CommandSender commandSender, final String[] array) {
        if (array.length < 2) {
            commandSender.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §7U\u017cycie: §f/stormszafka region delete <nazwa>");
            return true;
        }
        this.A(commandSender, array[1].toLowerCase());
        return true;
    }
    
    private void A(final CommandSender commandSender) {
        commandSender.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §7Komendy systemu region\u00f3w:");
        commandSender.sendMessage("§f/stormszafka region wand §8- §7Pobierz r\u00f3\u017cd\u017ck\u0119 do zaznaczania region\u00f3w");
        commandSender.sendMessage("§f/stormszafka region create <nazwa> §8- §7Utw\u00f3rz nowy region");
        commandSender.sendMessage("§f/stormszafka region recreate <nazwa> §8- §7Zaktualizuj istniej\u0105cy region");
        commandSender.sendMessage("§f/stormszafka region delete <nazwa> §8- §7Usu\u0144 region");
        commandSender.sendMessage("§f/stormszafka region list §8- §7Wy\u015bwietl list\u0119 region\u00f3w");
    }
    
    private void B(final Player player, final String s) {
        if (this.C.B(s)) {
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §cRegion §f" + s + " §cju\u017c istnieje!");
            return;
        }
        if (!this.C.B(player)) {
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §cNie zaznaczono obu pozycji!");
            return;
        }
        if (this.C.A(player, s)) {
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §7Region §f" + s + " §7zosta\u0142 §acreated§7!");
            this.C.C(player);
        }
        else {
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §cB\u0142\u0105d podczas tworzenia regionu!");
        }
    }
    
    private void A(final Player player, final String s) {
        if (!this.C.B(s)) {
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §cRegion §f" + s + " §cnie istnieje!");
            return;
        }
        if (!this.C.B(player)) {
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §cNie zaznaczono obu pozycji!");
            return;
        }
        if (this.C.B(player, s)) {
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §7Region §f" + s + " §7zosta\u0142 §aupdated§7!");
            this.C.C(player);
        }
        else {
            player.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §cB\u0142\u0105d podczas aktualizacji regionu!");
        }
    }
    
    private void A(final CommandSender commandSender, final String s) {
        if (!this.C.B(s)) {
            commandSender.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §cRegion §f" + s + " §cnie istnieje!");
            return;
        }
        if (this.C.A(s)) {
            commandSender.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §7Region §f" + s + " §7zosta\u0142 §cusuni\u0119ty§7!");
        }
        else {
            commandSender.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §cB\u0142\u0105d podczas usuwania regionu!");
        }
    }
    
    private void B(final CommandSender commandSender) {
        final List<String> a = this.C.A();
        if (a.isEmpty()) {
            commandSender.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §cBrak region\u00f3w!");
        }
        else {
            commandSender.sendMessage("§8[§x§B§3§0§0§F§F\ud83e\ude93§8] §7Regiony (§f" + a.size() + "§7):");
            final Iterator iterator = a.iterator();
            while (iterator.hasNext()) {
                commandSender.sendMessage("§8  » §f" + (String)iterator.next());
            }
        }
    }
    
    public List<String> onTabComplete(final CommandSender commandSender, final Command command, final String s, final String[] array) {
        if (array.length == 1) {
            return Arrays.asList("region", "wand", "create", "recreate", "delete", "list").stream().filter(s2 -> s2.toLowerCase().startsWith(array2[0].toLowerCase())).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
        }
        if (array.length == 2) {
            if (array[0].equalsIgnoreCase("region")) {
                return Arrays.asList("wand", "create", "recreate", "delete", "list").stream().filter(s3 -> s3.toLowerCase().startsWith(array3[1].toLowerCase())).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
            }
        }
        else if (array.length == 3 && array[0].equalsIgnoreCase("region") && (array[1].equalsIgnoreCase("delete") || array[1].equalsIgnoreCase("recreate"))) {
            return this.C.A().stream().filter(s4 -> s4.toLowerCase().startsWith(array4[2].toLowerCase())).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
        }
        return null;
    }
}
