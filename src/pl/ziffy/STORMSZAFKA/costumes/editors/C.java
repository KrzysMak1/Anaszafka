// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.editors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.plugin.Plugin;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.Sound;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.ziffy.STORMSZAFKA.pets.editors.A;
import pl.ziffy.STORMSZAFKA.pets.E;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import pl.ziffy.STORMSZAFKA.fragments.B;
import org.bukkit.inventory.ItemFlag;
import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import java.util.List;
import java.util.UUID;
import java.util.Map;
import org.bukkit.event.Listener;

public class C implements Listener
{
    private static final Map<UUID, String> B;
    private static final List<String> A;
    
    public static void openFragmentCostEditor(final Player player) {
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 54, ChatColor.translateAlternateColorCodes('&', B("&x&F&F&F&9&1&A\u26a1 &8\u1d07\u1d05\u028f\u1d04\u1d0a\u1d00 \u1d0b\u1d0f\ua731\u1d22\u1d1b\u00f3\u1d21")));
        final int[] array = { 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43 };
        for (int i = 0; i < Math.min(C.A.size(), array.length); ++i) {
            inventory.setItem(array[i], A(C.A.get(i)));
        }
        final boolean a = D.A();
        final ItemStack itemStack = new ItemStack(a ? Material.RED_DYE : Material.LIME_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (a) {
            itemMeta.setDisplayName(B("&#FF1A1AWy\u0142\u0105cz system przed\u0142u\u017cania kostium\u00f3w"));
            final ArrayList lore = new ArrayList();
            lore.add(B("&7"));
            lore.add(B("&8 » &7System jest obecnie &aw\u0142\u0105czony"));
            lore.add(B("&8 » &7Kliknij, aby &cwy\u0142\u0105czy\u0107 &7system!"));
            lore.add(B("&7"));
            itemMeta.setLore((List)lore);
        }
        else {
            itemMeta.setDisplayName(B("&#1DFF1AW\u0142\u0105cz system przed\u0142u\u017cania kostium\u00f3w"));
            final ArrayList lore2 = new ArrayList();
            lore2.add(B("&7"));
            lore2.add(B("&8 » &7System jest obecnie &cwy\u0142\u0105czony"));
            lore2.add(B("&8 » &7Kliknij, aby &aw\u0142\u0105czy\u0107 &7system!"));
            lore2.add(B("&7"));
            itemMeta.setLore((List)lore2);
        }
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(47, itemStack);
        final ItemStack itemStack2 = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta2 = itemStack2.getItemMeta();
        itemMeta2.setDisplayName(B("&#FF0000Powr\u00f3t"));
        itemMeta2.addItemFlags(ItemFlag.values());
        itemStack2.setItemMeta(itemMeta2);
        inventory.setItem(49, itemStack2);
        final boolean g = pl.ziffy.STORMSZAFKA.fragments.B.G();
        final ItemStack itemStack3 = new ItemStack(g ? Material.RED_DYE : Material.LIME_DYE);
        final ItemMeta itemMeta3 = itemStack3.getItemMeta();
        if (g) {
            itemMeta3.setDisplayName(B("&#FF1A1AWy\u0142\u0105cz system przed\u0142u\u017cania"));
            final ArrayList lore3 = new ArrayList();
            lore3.add(B("&7"));
            lore3.add(B("&8 » &7System jest obecnie &aw\u0142\u0105czony"));
            lore3.add(B("&8 » &7Kliknij, aby &cwy\u0142\u0105czy\u0107 &7system!"));
            lore3.add(B("&7"));
            itemMeta3.setLore((List)lore3);
        }
        else {
            itemMeta3.setDisplayName(B("&#1DFF1AW\u0142\u0105cz system przed\u0142u\u017cania"));
            final ArrayList lore4 = new ArrayList();
            lore4.add(B("&7"));
            lore4.add(B("&8 » &7System jest obecnie &cwy\u0142\u0105czony"));
            lore4.add(B("&8 » &7Kliknij, aby &aw\u0142\u0105czy\u0107 &7system!"));
            lore4.add(B("&7"));
            itemMeta3.setLore((List)lore4);
        }
        itemMeta3.addItemFlags(ItemFlag.values());
        itemStack3.setItemMeta(itemMeta3);
        inventory.setItem(51, itemStack3);
        player.openInventory(inventory);
    }
    
    private static ItemStack A(final String s) {
        ItemStack a = E.A(s, "brak");
        if (a == null) {
            a = new ItemStack(Material.PLAYER_HEAD);
        }
        final ItemMeta itemMeta = a.getItemMeta();
        String s2 = pl.ziffy.STORMSZAFKA.pets.editors.A.E(s);
        if (s2.contains("{time}")) {
            s2 = s2.replace("{time}", "").replace("na czas", "").trim();
        }
        itemMeta.setDisplayName(B(s2));
        final int b = pl.ziffy.STORMSZAFKA.fragments.B.B(s);
        final ArrayList lore = new ArrayList();
        lore.add(B("&7"));
        lore.add(B("&8 » &7Aktualny koszt: &c" + b + " serc"));
        lore.add(B("&7"));
        lore.add(B("&7\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a &#21FB08&n\u029f\u1d07\u1d21\u028f\u1d0d&7, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u1d0b\u1d0f\ua731\u1d22\u1d1b!"));
        lore.add(B("&7\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a &#FF0000&n\ua731\u029c\u026a\ua730\u1d1b + \u1d18\u0280\u1d00\u1d21\u028f&7, \u1d00\u0299\u028f \u1d22\u0280\u1d07\ua731\u1d07\u1d1b\u1d0f\u1d21\u1d00\u0107!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        a.setItemMeta(itemMeta);
        return a;
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        if (!inventoryClickEvent.getView().getTitle().equals(ChatColor.translateAlternateColorCodes('&', B("&x&F&F&F&9&1&A\u26a1 &8\u1d07\u1d05\u028f\u1d04\u1d0a\u1d00 \u1d0b\u1d0f\ua731\u1d22\u1d1b\u00f3\u1d21")))) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if (currentItem == null || currentItem.getType() == Material.AIR) {
            return;
        }
        final int rawSlot = inventoryClickEvent.getRawSlot();
        final ClickType click = inventoryClickEvent.getClick();
        if (rawSlot == 47) {
            final boolean a = D.A();
            D.A(!a);
            if (!a) {
                player.sendMessage(B("&8» &7Pomy\u015blnie &#27FF00w\u0142\u0105czono &7system przed\u0142u\u017cania kostium\u00f3w!"));
            }
            else {
                player.sendMessage(B("&8» &7Pomy\u015blnie &#FF0000wy\u0142\u0105czono &7system przed\u0142u\u017cania kostium\u00f3w!"));
            }
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            openFragmentCostEditor(player);
            return;
        }
        if (rawSlot == 49) {
            pl.ziffy.STORMSZAFKA.ui.menu.B.openMainPanel(player);
            return;
        }
        if (rawSlot == 51) {
            final boolean g = pl.ziffy.STORMSZAFKA.fragments.B.G();
            pl.ziffy.STORMSZAFKA.fragments.B.A(!g);
            if (!g) {
                player.sendMessage(B("&8» &7Pomy\u015blnie &#27FF00w\u0142\u0105czono &7system przed\u0142u\u017cania pet\u00f3w sercami!"));
            }
            else {
                player.sendMessage(B("&8» &7Pomy\u015blnie &#FF0000wy\u0142\u0105czono &7system przed\u0142u\u017cania pet\u00f3w sercami!"));
            }
            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            openFragmentCostEditor(player);
            return;
        }
        final int[] array = { 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43 };
        for (int n = 0; n < array.length && n < C.A.size(); ++n) {
            if (rawSlot == array[n]) {
                final String s = C.A.get(n);
                if (click == ClickType.RIGHT) {
                    C.B.put(player.getUniqueId(), s);
                    player.closeInventory();
                    player.sendMessage(B("&8» &7Wpisz &#FFD300nowy koszt &7przed\u0142u\u017cenia dla peta &f" + s + " &8(&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
                    player.sendTitle(B(""), B("&7Wpisz &#FFD300nowy koszt &7na &fchacie&7!"), 10, 60, 15);
                    return;
                }
                if (click == ClickType.SHIFT_RIGHT) {
                    pl.ziffy.STORMSZAFKA.fragments.B.A(s);
                    player.sendMessage(B("&8» &7Zresetowano koszt przed\u0142u\u017cenia dla peta &f" + s + " &#27FF00sukces&7!"));
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0f, 1.0f);
                    openFragmentCostEditor(player);
                    return;
                }
            }
        }
    }
    
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent asyncPlayerChatEvent) {
        final UUID uniqueId = asyncPlayerChatEvent.getPlayer().getUniqueId();
        if (!C.B.containsKey(uniqueId)) {
            return;
        }
        asyncPlayerChatEvent.setCancelled(true);
        final String s3 = C.B.remove(uniqueId);
        final String message = asyncPlayerChatEvent.getMessage();
        if (message.equalsIgnoreCase("anuluj")) {
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                openFragmentCostEditor(player);
                player.sendTitle(B(""), B("&fEdycja &7zosta\u0142a &#FF0000anulowana&7!"), 10, 60, 15);
            });
            return;
        }
        try {
            if (Integer.parseInt(message) <= 0) {
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                    openFragmentCostEditor(player2);
                    player2.sendMessage(B("&8» &7Koszt musi by\u0107 &#FF0000wi\u0119kszy od 0&7!"));
                });
                return;
            }
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                final String s3;
                final int n2;
                pl.ziffy.STORMSZAFKA.fragments.B.A(s3, n2);
                openFragmentCostEditor(player3);
                if (b) {
                    player3.sendMessage(B("&8» &7Zmieniono koszt przed\u0142u\u017cenia dla peta &f" + s2 + " &7na &f" + n + " &#27FF00serc&7!"));
                    player3.sendTitle(B(""), B("&fKoszt &7zosta\u0142 &#27FF00zmieniony&7!"), 10, 60, 15);
                }
                else {
                    player3.sendMessage(B("&8» &7B\u0142\u0105d podczas zapisywania &#FF0000kosztu&7!"));
                }
            });
        }
        catch (final NumberFormatException ex) {
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                openFragmentCostEditor(player4);
                player4.sendMessage(B("&8» &7Wpisz poprawn\u0105 &#FF0000liczb\u0119&7!"));
            });
        }
    }
    
    private static String B(final String s) {
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
    
    public static void cleanup(final UUID uuid) {
        C.B.remove(uuid);
    }
    
    static {
        B = new HashMap<UUID, String>();
        A = Arrays.asList("aniolek", "balwanek", "biznesmenik", "bobas", "cukiereczek", "cyber-obronca", "discordzik", "drakula", "duszek", "elfik", "enderman", "eustachy", "glodomorek", "golemik", "leniuszek", "nietoperek", "paczus", "pajak", "pancernik", "pedziwiatr", "pierniczek", "pisklak", "pudzianek", "reniferek", "rozdymek", "skalniaczek", "sowa", "telekrolik", "zajaczek");
    }
}
