// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pl.ziffy.STORMSZAFKA.utils.update.ListenersListener1;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.Main;
import pl.ziffy.STORMSZAFKA.pets.PetsPetService4;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.Listener;

public class ListenersListener2 implements Listener
{
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent playerJoinEvent) {
        final Player player = playerJoinEvent.getPlayer();
        E.ListenersListener3(player);
        if ((player.hasPermission("stormszafka.admin") || player.isOp()) && Main.getInstance().getEconomyManager() != null && !Main.getInstance().getEconomyManager().ListenersListener2()) {
            player.sendMessage("§8[§x§F§F§ListenersListener3§F§0§0\u26a0§8] §7Nie wykryto pluginu §x§F§F§E§0§5§CVault§7! System §fprzed\u0142u\u017cania kostium\u00f3w §7nie b\u0119dzie dzia\u0142a\u0142!");
        }
        if (Main.getInstance().getConfig().getBoolean("settings.check-updates", true)) {
            Bukkit.getScheduler().runTaskLater((Plugin)Main.getInstance(), () -> {
                if (player2.hasPermission("stormszafka.admin") || player2.isOp()) {
                    Main.getInstance().getDescription().getVersion();
                    final ListenersListener1 a = new ListenersListener1(Main.getInstance(), 126020);
                    final String s;
                    a.ListenersListener1(s, b -> {
                        if (b != null && b) {
                            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> a2.ListenersListener1(s2 -> {
                                if (s2 != null) {
                                    Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                                        player4.sendMessage(Main.translateHexColors("&8[&#B600D0&l\ud83d\udee1&8] &7Dost\u0119pna jest nowa wersja pluginu: &#FF00D5" + s4 + " &7(aktualna: &f" + s3 + (s3.toUpperCase().endsWith("T") ? " §8(§cWERSJA TESTOWA§8)" : "") + "&7)"));
                                        player4.sendMessage(Main.translateHexColors("&8[&#B600D0&l\ud83d\udee1&8] &7Pobierz aktualizacj\u0119 ze strony: &fhttps://www.spigotmc.org/resources/126020/"));
                                    });
                                }
                            }));
                        }
                        else if (player3.hasPermission("stormszafka.admin") || player3.isOp()) {
                            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> player5.sendMessage(Main.translateHexColors("&8[&#B600D0&l\ud83d\udee1&8] &7Plugin &#FF00D5STORMSZAFKA &7jest w\u0142\u0105czony w wersji: &f" + s5 + (s5.toUpperCase().endsWith("T") ? " §8(§cWERSJA TESTOWA§8)" : ""))));
                        }
                    });
                }
            }, 40L);
        }
    }
}
