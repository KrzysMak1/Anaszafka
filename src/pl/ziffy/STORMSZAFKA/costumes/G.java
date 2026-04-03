// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import pl.ziffy.STORMSZAFKA.Main;

public class G
{
    private final Main A;
    
    public G(final Main a) {
        this.A = a;
    }
    
    public boolean A(final CommandSender commandSender, final String[] array) {
        if (array.length < 2 || !array[0].equalsIgnoreCase("give") || !array[1].equalsIgnoreCase("kostium")) {
            return false;
        }
        if (!commandSender.hasPermission("stormszafka.admin")) {
            return true;
        }
        if (array.length < 3) {
            return true;
        }
        final String lowerCase = array[2].toLowerCase();
        if (!this.A(lowerCase)) {
            return true;
        }
        Player player;
        if (array.length >= 4) {
            player = Bukkit.getPlayer(array[3]);
            if (player == null) {
                return true;
            }
        }
        else {
            if (!(commandSender instanceof Player)) {
                return true;
            }
            player = (Player)commandSender;
        }
        final ItemStack b = L.B(lowerCase);
        if (b == null) {
            return true;
        }
        player.getInventory().addItem(new ItemStack[] { b });
        return true;
    }
    
    public List<String> B(final CommandSender commandSender, final String[] array) {
        final ArrayList list = new ArrayList();
        if (array.length == 2 && array[0].equalsIgnoreCase("give")) {
            list.add("kostium");
        }
        else if (array.length == 3 && array[0].equalsIgnoreCase("give") && array[1].equalsIgnoreCase("kostium")) {
            list.add("zabojczykrolik");
            list.add("walentynkowy");
            list.add("przeciwzakazeniowy");
            list.add("malyurwis");
            list.add("pirata");
            list.add("nurekglebinowy");
            list.add("mima");
            list.add("wampir");
        }
        else if (array.length == 4 && array[0].equalsIgnoreCase("give") && array[1].equalsIgnoreCase("kostium")) {
            final Iterator iterator = Bukkit.getOnlinePlayers().iterator();
            while (iterator.hasNext()) {
                list.add(((Player)iterator.next()).getName());
            }
        }
        return list;
    }
    
    private boolean A(final String s) {
        return s.equalsIgnoreCase("zabojczykrolik") || s.equalsIgnoreCase("walentynkowy") || s.equalsIgnoreCase("przeciwzakazeniowy") || s.equalsIgnoreCase("malyurwis") || s.equalsIgnoreCase("pirata") || s.equalsIgnoreCase("nurekglebinowy") || s.equalsIgnoreCase("mima") || s.equalsIgnoreCase("wampir");
    }
    
    private String B(final String s) {
        if (s.equalsIgnoreCase("zabojczykrolik")) {
            return "Zab\u00f3jczy Kr\u00f3lik";
        }
        if (s.equalsIgnoreCase("walentynkowy")) {
            return "Kostium Walentynkowy";
        }
        return s;
    }
}
