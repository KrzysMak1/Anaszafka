// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.commands;

import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.HashMap;
import pl.ziffy.STORMSZAFKA.costumes.L;
import pl.ziffy.STORMSZAFKA.ui.menu.B;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;
import pl.ziffy.STORMSZAFKA.pets.E;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.ui.menu.A;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.List;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.CommandExecutor;

public class C implements CommandExecutor, TabCompleter
{
    private final Main C;
    private D A;
    private static final List<String> B;
    
    public C(final Main c) {
        this.C = c;
        c.getCommand("stormszafka").setExecutor((CommandExecutor)this);
        c.getCommand("stormszafka").setTabCompleter((TabCompleter)this);
        c.getCommand("szafka").setExecutor((CommandExecutor)this);
        c.getCommand("szafka").setTabCompleter((TabCompleter)this);
    }
    
    public void setRegionCommand(final D a) {
        this.A = a;
    }
    
    public boolean onCommand(final CommandSender commandSender, final Command command, final String s, final String[] array) {
        if (command.getName().equalsIgnoreCase("szafka")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(this.B("&8» &7Ta komenda mo\u017ce by\u0107 u\u017cyta tylko przez &#FF0000gracza&7!"));
                return true;
            }
            pl.ziffy.STORMSZAFKA.ui.menu.A.openMainMenu((Player)commandSender);
            return true;
        }
        else {
            if (!command.getName().equalsIgnoreCase("stormszafka")) {
                return false;
            }
            final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
            if (array.length == 0) {
                this.A(commandSender);
                return true;
            }
            final String lowerCase = array[0].toLowerCase();
            switch (lowerCase) {
                case "give": {
                    return this.C(commandSender, array, e);
                }
                case "remove": {
                    return this.A(commandSender, array, e);
                }
                case "panel": {
                    return this.D(commandSender, array);
                }
                case "heart":
                case "fragment": {
                    return this.B(commandSender, array);
                }
                case "version": {
                    return this.C(commandSender, array);
                }
                case "reload": {
                    return this.A(commandSender, array);
                }
                case "region": {
                    return this.A(commandSender, command, array);
                }
                case "help": {
                    this.A(commandSender);
                    return true;
                }
                default: {
                    this.A(commandSender);
                    return true;
                }
            }
        }
    }
    
    private boolean C(final CommandSender commandSender, final String[] array, final pl.ziffy.STORMSZAFKA.messages.A a) {
        if (array.length >= 2 && array[1].equalsIgnoreCase("kostium")) {
            return this.B(commandSender, array, a);
        }
        if (array.length < 4) {
            commandSender.sendMessage(this.B("&7Poprawne u\u017cycie: &f/stormszafka &x&D&0&6&0&F&Fgive &x&D&0&6&0&F&Fpet &8<&fpet&8> &8<&fczas&8> &8[<&fgracz&8>]"));
            return true;
        }
        if (!array[1].equalsIgnoreCase("pet")) {
            commandSender.sendMessage(this.B("&8» &7Nieprawid\u0142owa podkomenda. U\u017cyj: &fgive pet &7lub &fgive kostium"));
            return true;
        }
        final String lowerCase = array[2].toLowerCase();
        final String s = array[3];
        if (!pl.ziffy.STORMSZAFKA.commands.C.B.contains(lowerCase)) {
            commandSender.sendMessage(this.B("&8» &7Nieznany pet: &#FF0000" + lowerCase));
            return true;
        }
        if (!pl.ziffy.STORMSZAFKA.utils.time.A.H(s) && !s.equalsIgnoreCase("brak")) {
            commandSender.sendMessage(this.B("&8» &7Nieprawid\u0142owy format czasu: &#FF0000" + s + " &8(&760s, 10m, 12h, 30d, INFINITE&8)"));
            return true;
        }
        Player player;
        if (array.length >= 5) {
            player = Bukkit.getPlayer(array[4]);
            if (player == null) {
                commandSender.sendMessage(this.B("&8» &7Gracz &f" + array[4] + " &7nie jest &#FF0000online&7!"));
                return true;
            }
            if (!commandSender.hasPermission("stormszafka.give.others")) {
                if (a != null && commandSender instanceof Player) {
                    a.A((Player)commandSender, "general.no-permission");
                }
                else {
                    commandSender.sendMessage(this.B("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                }
                return true;
            }
        }
        else {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(this.B("&8» &7Musisz poda\u0107 &#FF0000gracza&7!"));
                return true;
            }
            player = (Player)commandSender;
            if (!commandSender.hasPermission("stormszafka.give.self")) {
                if (a != null) {
                    a.A((Player)commandSender, "general.no-permission");
                }
                else {
                    commandSender.sendMessage(this.B("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                }
                return true;
            }
        }
        final Main c = this.C;
        if (Main.getPetConfigManager() != null) {
            final Main c2 = this.C;
            if (!Main.getPetConfigManager().H(lowerCase)) {
                commandSender.sendMessage(this.B("&8» &7Pet &f" + lowerCase + " &7jest obecnie &#FF0000wy\u0142\u0105czony&7!"));
                return true;
            }
        }
        final ItemStack b = this.B(lowerCase, s);
        if (b != null) {
            if (player.getInventory().firstEmpty() == -1) {
                player.getWorld().dropItemNaturally(player.getLocation(), b);
                if (player == commandSender) {
                    commandSender.sendMessage(this.B("&8[&#B300FF\ud83d\udee1&8] &7Tw\u00f3j ekwipunek jest &#FB0808pe\u0142ny&7! Przedmiot peta &#08FB0D" + lowerCase + " &7zosta\u0142 upuszczony na ziemi\u0119."));
                }
                else {
                    commandSender.sendMessage(this.B("&8[&#B300FF\ud83d\udee1&8] &7Ekwipunek gracza &f" + player.getName() + " &7jest &#FB0808pe\u0142ny&7! Przedmiot upuszczony."));
                    player.sendMessage(this.B("&8[&#B300FF\ud83d\udee1&8] &7Tw\u00f3j ekwipunek jest &#FB0808pe\u0142ny&7! Przedmiot peta &#08FB0D" + lowerCase + " &7zosta\u0142 upuszczony na ziemi\u0119."));
                }
            }
            else {
                player.getInventory().addItem(new ItemStack[] { b });
                if (player == commandSender) {
                    commandSender.sendMessage(this.B("&8[&#B300FF\ud83d\udee1&8] &fOtrzyma\u0142e\u015b &7peta &#08FB0D" + lowerCase + " &7do ekwipunku!"));
                }
                else {
                    commandSender.sendMessage(this.B("&8[&#B300FF\ud83d\udee1&8] &7Dano przedmiot peta &#08FB0D" + lowerCase + " &7graczowi &f" + player.getName() + "&7!"));
                    player.sendMessage(this.B("&8[&#B300FF\ud83d\udee1&8] &fOtrzyma\u0142e\u015b &7peta &#08FB0D" + lowerCase + " &7do ekwipunku!"));
                }
            }
        }
        else {
            commandSender.sendMessage(this.B("&8» &7Nie uda\u0142o si\u0119 utworzy\u0107 przedmiotu &#FF0000peta&7!"));
        }
        return true;
    }
    
    private boolean A(final CommandSender commandSender, final String[] array, final pl.ziffy.STORMSZAFKA.messages.A a) {
        Player player;
        if (array.length >= 2) {
            player = Bukkit.getPlayer(array[1]);
            if (player == null) {
                commandSender.sendMessage(this.B("&8» &7Gracz &f" + array[1] + " &7nie jest &#FF0000online&7!"));
                return true;
            }
            if (!commandSender.hasPermission("stormszafka.remove.others")) {
                if (a != null && commandSender instanceof Player) {
                    a.A((Player)commandSender, "general.no-permission");
                }
                else {
                    commandSender.sendMessage(this.B("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                }
                return true;
            }
        }
        else {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(this.B("&8» &7Musisz poda\u0107 &#FF0000gracza&7!"));
                return true;
            }
            player = (Player)commandSender;
            if (!commandSender.hasPermission("stormszafka.remove.self")) {
                if (a != null) {
                    a.A((Player)commandSender, "general.no-permission");
                }
                else {
                    commandSender.sendMessage(this.B("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                }
                return true;
            }
        }
        if (!E.K(player)) {
            if (a != null) {
                a.A(player, "pet.not-active");
            }
            else {
                commandSender.sendMessage(this.B("&8» &7Nie masz &#FF0000aktywnego &7peta!"));
            }
            return true;
        }
        final String a2 = E.A(player);
        E.A(player, true);
        if (a != null) {
            a.A(player, "pet.removed", "pet_name", a2);
        }
        else {
            commandSender.sendMessage(this.B("&8» &7Usuni\u0119to peta: &#27FF00" + a2));
        }
        return true;
    }
    
    private boolean B(final CommandSender commandSender, final String[] array, final pl.ziffy.STORMSZAFKA.messages.A a) {
        if (array.length < 4) {
            commandSender.sendMessage(this.B("&7Poprawne u\u017cycie: &f/stormszafka &x&D&0&6&0&F&Fgive &x&D&0&6&0&F&Fkostium &8<&fkostium&8> &8<&fczas&8> &8[<&fgracz&8>]"));
            return true;
        }
        final String lowerCase = array[2].toLowerCase();
        final String s = array[3];
        if (!this.A(lowerCase)) {
            commandSender.sendMessage(this.B("&8» &7Nieznany kostium: &#FF0000" + lowerCase));
            return true;
        }
        if (!pl.ziffy.STORMSZAFKA.utils.time.A.H(s) && !s.equalsIgnoreCase("brak")) {
            commandSender.sendMessage(this.B("&8» &7Nieprawid\u0142owy format czasu: &#FF0000" + s + " &8(&760s, 10m, 12h, 30d, INFINITE&8)"));
            return true;
        }
        Player player;
        if (array.length >= 5) {
            player = Bukkit.getPlayer(array[4]);
            if (player == null) {
                commandSender.sendMessage(this.B("&8» &7Gracz &f" + array[4] + " &7nie jest &#FF0000online&7!"));
                return true;
            }
            if (!commandSender.hasPermission("stormszafka.give.others")) {
                if (a != null && commandSender instanceof Player) {
                    a.A((Player)commandSender, "general.no-permission");
                }
                else {
                    commandSender.sendMessage(this.B("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                }
                return true;
            }
        }
        else {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(this.B("&8» &7Musisz poda\u0107 &#FF0000gracza&7!"));
                return true;
            }
            player = (Player)commandSender;
            if (!commandSender.hasPermission("stormszafka.give.self")) {
                if (a != null) {
                    a.A((Player)commandSender, "general.no-permission");
                }
                else {
                    commandSender.sendMessage(this.B("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                }
                return true;
            }
        }
        final ItemStack a2 = this.A(lowerCase, s);
        if (a2 == null) {
            commandSender.sendMessage(this.B("&8» &7Nie uda\u0142o si\u0119 utworzy\u0107 przedmiotu &#FF0000kostiumu&7!"));
            return true;
        }
        if (player.getInventory().firstEmpty() == -1) {
            player.getWorld().dropItemNaturally(player.getLocation(), a2);
            if (player == commandSender) {
                commandSender.sendMessage(this.B("&8[&#B300FF\ud83d\udee1&8] &7Tw\u00f3j ekwipunek jest &#FB0808pe\u0142ny&7! Przedmiot kostiumu &#08FB0D" + lowerCase + " &7zosta\u0142 upuszczony na ziemi\u0119."));
            }
            else {
                commandSender.sendMessage(this.B("&8[&#B300FF\ud83d\udee1&8] &7Ekwipunek gracza &f" + player.getName() + " &7jest &#FB0808pe\u0142ny&7! Przedmiot upuszczony."));
                player.sendMessage(this.B("&8[&#B300FF\ud83d\udee1&8] &7Tw\u00f3j ekwipunek jest &#FB0808pe\u0142ny&7! Przedmiot kostiumu &#08FB0D" + lowerCase + " &7zosta\u0142 upuszczony na ziemi\u0119."));
            }
        }
        else {
            player.getInventory().addItem(new ItemStack[] { a2 });
            if (player == commandSender) {
                commandSender.sendMessage(this.B("&8[&#B300FF\ud83d\udee1&8] &fOtrzyma\u0142e\u015b &7kostium &#08FB0D" + lowerCase + " &7do ekwipunku!"));
            }
            else {
                commandSender.sendMessage(this.B("&8[&#B300FF\ud83d\udee1&8] &7Dano przedmiot kostiumu &#08FB0D" + lowerCase + " &7graczowi &f" + player.getName() + "&7!"));
                player.sendMessage(this.B("&8[&#B300FF\ud83d\udee1&8] &fOtrzyma\u0142e\u015b &7kostium &#08FB0D" + lowerCase + " &7do ekwipunku!"));
            }
        }
        return true;
    }
    
    private boolean A(final String s) {
        return s.equalsIgnoreCase("zabojczykrolik") || s.equalsIgnoreCase("walentynkowy") || s.equalsIgnoreCase("przeciwzakazeniowy") || s.equalsIgnoreCase("malyurwis") || s.equalsIgnoreCase("pirata") || s.equalsIgnoreCase("nurekglebinowy") || s.equalsIgnoreCase("mima") || s.equalsIgnoreCase("wampir");
    }
    
    private String C(final String s) {
        final String lowerCase = s.toLowerCase();
        switch (lowerCase) {
            case "zabojczykrolik": {
                return "Zab\u00f3jczy Kr\u00f3lik";
            }
            case "walentynkowy": {
                return "Kostium Walentynkowy";
            }
            case "przeciwzakazeniowy": {
                return "Kostium Przeciwzaka\u017ceniowy";
            }
            case "malyurwis": {
                return "Kostium Ma\u0142ego Urwisa";
            }
            case "pirata": {
                return "Kostium Pirata";
            }
            case "nurekglebinowy": {
                return "Kostium Nurka G\u0142\u0119binowego";
            }
            case "mima": {
                return "Kostium Mima";
            }
            case "wampir": {
                return "Kostium Wampira";
            }
            default: {
                return s;
            }
        }
    }
    
    private boolean A(final CommandSender commandSender, final Command command, final String[] array) {
        if (this.A == null) {
            commandSender.sendMessage(this.B("&8» &cSystem region\u00f3w nie jest zainicjalizowany!"));
            return true;
        }
        final String[] array2 = new String[array.length - 1];
        System.arraycopy(array, 1, array2, 0, array.length - 1);
        return this.A.onCommand(commandSender, command, "stormszafka", array2);
    }
    
    private void A(final CommandSender commandSender) {
        commandSender.sendMessage(this.B("G\u0142\u00f3wna komenda pluginu STORMSZAFKA."));
        commandSender.sendMessage(this.B("  §x§C§4§5§B§F§FCentrum pomocy dla §x§A§3§0§8§F§B§nSTORMSZAFKA§x§C§4§5§B§F§F:"));
        commandSender.sendMessage(this.B("  §f/stormszafka give §8<§ftyp§8> <§fgracz§8> <§fczas§8> §8- §x§F§F§3§D§B§2Daj przedmiot graczowi."));
        commandSender.sendMessage(this.B("  §f/stormszafka remove §8<§fgracz§8> §8- §x§F§F§3§D§B§2Usu\u0144 przedmiot od gracza."));
        commandSender.sendMessage(this.B("  §f/stormszafka panel §8- §x§F§F§3§D§B§2Otw\u00f3rz g\u0142\u00f3wny panel pluginu."));
        commandSender.sendMessage(this.B("  §f/stormszafka heart §8- §x§F§F§3§D§B§2Zarz\u0105dzaj sercami pet\u00f3w."));
        commandSender.sendMessage(this.B("  §f/stormszafka version §8- §x§F§F§3§D§B§2Sprawd\u017a wersj\u0119 pluginu i aktualizacje."));
        commandSender.sendMessage(this.B("  §f/stormszafka reload §8- §x§F§F§3§D§B§2Prze\u0142aduj konfiguracj\u0119 pluginu."));
        commandSender.sendMessage(this.B("  §f/stormszafka region §8- §x§F§F§3§D§B§2Zarz\u0105dzaj regionami pluginu."));
        commandSender.sendMessage(this.B("  §f/stormszafka help §8- §x§F§F§3§D§B§2Wy\u015bwietl t\u0119 wiadomo\u015b\u0107 pomocy."));
    }
    
    public List<String> onTabComplete(final CommandSender commandSender, final Command command, final String s, final String[] array) {
        final ArrayList list = new ArrayList();
        if (command.getName().equalsIgnoreCase("szafka")) {
            return list;
        }
        if (array.length == 1) {
            return Arrays.asList("give", "remove", "panel", "heart", "version", "reload", "help", "region").stream().filter(s2 -> s2.toLowerCase().startsWith(array3[0].toLowerCase())).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
        }
        if (array[0].equalsIgnoreCase("region") && this.A != null) {
            final String[] array2 = new String[array.length - 1];
            System.arraycopy(array, 1, array2, 0, array.length - 1);
            return this.A.onTabComplete(commandSender, command, s, array2);
        }
        if (array.length == 2 && (array[0].equalsIgnoreCase("heart") || array[0].equalsIgnoreCase("fragment"))) {
            return Arrays.asList("set", "give").stream().filter(s3 -> s3.toLowerCase().startsWith(array4[1].toLowerCase())).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
        }
        if (array.length == 3 && (array[0].equalsIgnoreCase("heart") || array[0].equalsIgnoreCase("fragment")) && array[1].equalsIgnoreCase("give")) {
            return Bukkit.getOnlinePlayers().stream().map((Function<? super Object, ?>)Player::getName).filter(s4 -> s4.toLowerCase().startsWith(array5[2].toLowerCase())).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
        }
        if (array.length == 4 && (array[0].equalsIgnoreCase("heart") || array[0].equalsIgnoreCase("fragment")) && array[1].equalsIgnoreCase("give")) {
            return Arrays.asList("1", "5", "10", "64").stream().filter(s5 -> s5.startsWith(array6[3])).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
        }
        if (array.length == 2 && array[0].equalsIgnoreCase("give")) {
            return Arrays.asList("pet", "kostium").stream().filter(s6 -> s6.toLowerCase().startsWith(array7[1].toLowerCase())).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
        }
        if (array.length == 3 && array[0].equalsIgnoreCase("give")) {
            if (array[1].equalsIgnoreCase("pet")) {
                return pl.ziffy.STORMSZAFKA.commands.C.B.stream().filter(s7 -> s7.toLowerCase().startsWith(array8[2].toLowerCase())).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
            }
            if (array[1].equalsIgnoreCase("kostium")) {
                return Arrays.asList("zabojczykrolik", "walentynkowy", "przeciwzakazeniowy", "malyurwis", "pirata", "nurekglebinowy", "mima", "wampir").stream().filter(s8 -> s8.toLowerCase().startsWith(array9[2].toLowerCase())).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
            }
        }
        if (array.length == 4 && array[0].equalsIgnoreCase("give") && (array[1].equalsIgnoreCase("pet") || array[1].equalsIgnoreCase("kostium"))) {
            return Arrays.asList("30s", "5m", "1h", "1d", "7d", "30d", "INFINITE", "brak").stream().filter(s9 -> s9.toLowerCase().startsWith(array10[3].toLowerCase())).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
        }
        if ((array.length == 5 && array[0].equalsIgnoreCase("give") && (array[1].equalsIgnoreCase("pet") || array[1].equalsIgnoreCase("kostium"))) || (array.length == 2 && array[0].equalsIgnoreCase("remove"))) {
            return Bukkit.getOnlinePlayers().stream().map((Function<? super Object, ?>)Player::getName).filter(s10 -> s10.toLowerCase().startsWith(array11[array11.length - 1].toLowerCase())).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
        }
        return list;
    }
    
    private ItemStack B(final String s, final String s2) {
        return E.A(s, s2);
    }
    
    private boolean D(final CommandSender commandSender, final String[] array) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(this.B("&8» &7Ta komenda mo\u017ce by\u0107 u\u017cyta tylko przez &#FF0000gracza&7!"));
            return true;
        }
        final Player player = (Player)commandSender;
        final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
        if (!player.hasPermission("stormszafka.admin") && !player.isOp()) {
            if (e != null) {
                e.A(player, "general.no-permission");
            }
            else {
                player.sendMessage(this.B("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
            }
            return true;
        }
        pl.ziffy.STORMSZAFKA.ui.menu.B.openMainPanel(player);
        return true;
    }
    
    private boolean C(final CommandSender commandSender, final String[] array) {
        commandSender.sendMessage(this.B("§x§C§4§5§B§F§FStormItemy §x§A§3§0§8§F§B§nv" + this.C.getDescription().getVersion()));
        commandSender.sendMessage(this.B("§x§F§F§3§D§B§2Plugin by Komentarz"));
        return true;
    }
    
    private boolean A(final CommandSender commandSender, final String[] array) {
        if (!commandSender.hasPermission("stormszafka.admin")) {
            if (commandSender instanceof Player) {
                final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
                if (e != null) {
                    e.A((Player)commandSender, "general.no-permission");
                }
                else {
                    commandSender.sendMessage(this.B("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                }
            }
            else {
                commandSender.sendMessage(this.B("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
            }
            return true;
        }
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            final ArrayList list = new ArrayList();
            if (this.C.getRegionManager() != null) {
                this.C.getRegionManager().B();
                list.add("regions.yml");
            }
            final Main c = this.C;
            if (Main.getPetConfigManager() != null) {
                final Main c2 = this.C;
                Main.getPetConfigManager().A();
                list.add("pets/ (wszystkie pliki)");
            }
            L.F();
            list.add("costumes/ (wszystkie pliki)");
            if (Main.getMenuConfigManager() != null) {
                Main.getMenuConfigManager().J();
                list.add("MenuConfig.yml");
                list.add("PetMenuConfig.yml");
                list.add("CostumeMenuConfig.yml");
            }
            pl.ziffy.STORMSZAFKA.fragments.B.A();
            list.add("fragment_costs.yml");
            pl.ziffy.STORMSZAFKA.fragments.B.C();
            list.add("fragment.yml");
            final long l = System.currentTimeMillis() - currentTimeMillis;
            if (commandSender instanceof final Player player) {
                final pl.ziffy.STORMSZAFKA.messages.A e2 = pl.ziffy.STORMSZAFKA.messages.A.E();
                if (e2 != null) {
                    final HashMap hashMap = new HashMap();
                    hashMap.put("time", String.valueOf(l));
                    e2.A(player, "reload", hashMap);
                }
                else {
                    commandSender.sendMessage(this.B("§x§1D§F§F§1A§2Plugin configuration reloaded successfully! (" + l + "ms)"));
                }
            }
            else {
                commandSender.sendMessage(this.B("§x§1D§F§F§1A§2Plugin configuration reloaded successfully! (" + l + "ms)"));
            }
        }
        catch (final Exception ex) {
            commandSender.sendMessage(this.B("&8» &cB\u0142\u0105d podczas prze\u0142adowywania: &f" + ex.getMessage()));
            ex.printStackTrace();
        }
        return true;
    }
    
    private ItemStack A(final String s, final String s2) {
        return L.A(s, s2);
    }
    
    private boolean B(final CommandSender commandSender, final String[] array) {
        if (array.length < 2) {
            commandSender.sendMessage(this.B("&7Poprawne u\u017cycie: &f/stormszafka &x&D&0&6&0&F&Fheart &8<&fset&8|&fgive&8>"));
            return true;
        }
        final String lowerCase = array[1].toLowerCase();
        final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
        if (lowerCase.equals("set")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(this.B("&8» &7Ta komenda mo\u017ce by\u0107 u\u017cyta tylko przez &#FF0000gracza&7!"));
                return true;
            }
            if (!commandSender.hasPermission("stormszafka.fragment.set")) {
                if (e != null) {
                    e.A((Player)commandSender, "general.no-permission");
                }
                else {
                    commandSender.sendMessage(this.B("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                }
                return true;
            }
            final Player player = (Player)commandSender;
            final ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
            if (itemInMainHand == null || itemInMainHand.getType().isAir()) {
                if (e != null) {
                    e.A(player, "heart.set-error");
                }
                else {
                    player.sendMessage(this.B("&8» &7Musisz trzyma\u0107 &#FF0000przedmiot &7w r\u0119ce!"));
                }
                return true;
            }
            pl.ziffy.STORMSZAFKA.fragments.B.B(itemInMainHand);
            if (e != null) {
                e.A(player, "heart.set-success");
            }
            else {
                player.sendMessage(this.B("&8» &7Pomy\u015blnie ustawiono &#27FF00serce peta&7!"));
            }
            return true;
        }
        else {
            if (!lowerCase.equals("give")) {
                commandSender.sendMessage(this.B("&7Poprawne u\u017cycie: &f/stormszafka &x&D&0&6&0&F&Fheart &8<&fset&8|&fgive&8>"));
                return true;
            }
            if (!commandSender.hasPermission("stormszafka.fragment.give")) {
                if (e != null && commandSender instanceof Player) {
                    e.A((Player)commandSender, "general.no-permission");
                }
                else {
                    commandSender.sendMessage(this.B("&8» &7Nie masz &#FF0000uprawnie\u0144&7!"));
                }
                return true;
            }
            if (array.length < 3) {
                commandSender.sendMessage(this.B("&7Poprawne u\u017cycie: &f/stormszafka &x&D&0&6&0&F&Fheart &x&D&0&6&0&F&Fgive &8<&fgracz&8> &8[<&filo\u015b\u0107&8>]"));
                return true;
            }
            final Player player2 = Bukkit.getPlayer(array[2]);
            if (player2 == null) {
                if (e != null && commandSender instanceof Player) {
                    e.A((Player)commandSender, "heart.give-error-player");
                }
                else {
                    commandSender.sendMessage(this.B("&8» &7Gracz nie jest &#FF0000online&7!"));
                }
                return true;
            }
            int int1 = 1;
            if (array.length >= 4) {
                try {
                    int1 = Integer.parseInt(array[3]);
                    if (int1 <= 0) {
                        if (e != null && commandSender instanceof Player) {
                            e.A((Player)commandSender, "heart.give-error-amount");
                        }
                        else {
                            commandSender.sendMessage(this.B("&8» &7Ilo\u015b\u0107 musi by\u0107 &#FF0000wi\u0119ksza od 0&7!"));
                        }
                        return true;
                    }
                }
                catch (final NumberFormatException ex) {
                    if (e != null && commandSender instanceof Player) {
                        e.A((Player)commandSender, "heart.give-error-amount");
                    }
                    else {
                        commandSender.sendMessage(this.B("&8» &7Nieprawid\u0142owa &#FF0000ilo\u015b\u0107&7!"));
                    }
                    return true;
                }
            }
            pl.ziffy.STORMSZAFKA.fragments.B.A(player2, int1);
            if (e != null && commandSender instanceof Player) {
                final HashMap hashMap = new HashMap();
                hashMap.put("amount", String.valueOf(int1));
                hashMap.put("player", player2.getName());
                e.A((Player)commandSender, "heart.give-success", hashMap);
                e.A(player2, "heart.give-received", "amount", String.valueOf(int1));
            }
            else {
                commandSender.sendMessage(this.B("&8» &7Dano &f" + int1 + " &7serc graczowi &#27FF00" + player2.getName() + "&7!"));
                player2.sendMessage(this.B("&8» &7Otrzyma\u0142e\u015b &f" + int1 + " &#27FF00serc peta&7!"));
            }
            return true;
        }
    }
    
    private String B(final String s) {
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
    
    static {
        B = Arrays.asList("aniolek", "balwanek", "biznesmenik", "bobas", "cukiereczek", "cyber-obronca", "discordzik", "drakula", "duszek", "elfik", "enderman", "eustachy", "glodomorek", "golemik", "leniuszek", "nietoperek", "paczus", "pajak", "pancernik", "pedziwiatr", "pierniczek", "pisklak", "pudzianek", "reniferek", "rozdymek", "skalniaczek", "sowa", "telekrolik", "zajaczek");
    }
}
