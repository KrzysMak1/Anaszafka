// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.editors;

import java.util.HashMap;
import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import java.util.regex.Pattern;
import org.bukkit.plugin.Plugin;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;
import java.util.Collections;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.Collection;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.UUID;
import java.util.Map;
import org.bukkit.event.Listener;

public class PetsEditorsListener2 implements Listener
{
    private static final Map<UUID, String> PetsEditorsPetEditorController2;
    private static final Map<UUID, String> PetsEditorsPetEditorController1;
    private static final int PetsEditorsListener1 = 14;
    
    public static void openLoreEditor(final Player player, final String s) {
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 45, "§x§F§F§F§9§1§PetsEditorsPetEditorController1\u26a1 §8\u1d07\u1d05\u028f\u1d04\u1d0a\u1d00 \u1d18\u1d07\u1d1b\u1d00 " + PetsEditorsListener1(s) + " \u029f\u1d0f\u0280\u1d07");
        PetsEditorsListener2.PetsEditorsPetEditorController2.put(player.getUniqueId(), s);
        final List<String> c = PetsEditorsPetEditorController2(s);
        final int[] array = { 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25 };
        for (int n = 0; n < c.size() && n < array.length; ++n) {
            inventory.setItem(array[n], PetsEditorsPetEditorController1((String)c.get(n), n + 1));
        }
        final ItemStack itemStack = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(PetsEditorsPetEditorController1("&#FF0000Powr\u00f3t do poprzedniego menu"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(39, itemStack);
        final boolean b = c.size() < 14;
        final ItemStack itemStack2 = new ItemStack(b ? Material.LIME_DYE : Material.LIGHT_GRAY_DYE);
        final ItemMeta itemMeta2 = itemStack2.getItemMeta();
        if (b) {
            itemMeta2.setDisplayName(PetsEditorsPetEditorController1("&#1DFF1ADodaj linijk\u0119 lore"));
        }
        else {
            itemMeta2.setDisplayName(PetsEditorsPetEditorController1("&7Dodaj linijk\u0119 lore"));
            final ArrayList lore = new ArrayList();
            lore.add(PetsEditorsPetEditorController1("&cOsi\u0105gni\u0119to maksymaln\u0105 liczb\u0119 linijek (14)"));
            itemMeta2.setLore((List)lore);
        }
        itemMeta2.addItemFlags(ItemFlag.values());
        itemStack2.setItemMeta(itemMeta2);
        inventory.setItem(41, itemStack2);
        player.openInventory(inventory);
    }
    
    private static ItemStack PetsEditorsPetEditorController1(final String s, final int n) {
        final ItemStack itemStack = new ItemStack(Material.PAPER);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(PetsEditorsPetEditorController1("&#FFD700Linijka " + n));
        final ArrayList lore = new ArrayList();
        lore.add(PetsEditorsPetEditorController1("&7"));
        lore.add(PetsEditorsPetEditorController1("&7Tre\u015b\u0107: &f" + s));
        lore.add(PetsEditorsPetEditorController1("&7"));
        lore.add(PetsEditorsPetEditorController1("&7\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a &#08B8FB&n\u029f\u1d07\u1d21\u028f\u1d0d&7, \u1d00\u0299\u028f \u1d18\u0280\u1d22\u1d07\ua731\u1d1c\u0274\u1d00\u0107 \u1d21 \u0262\u00f3\u0280\u1d07!"));
        lore.add(PetsEditorsPetEditorController1("&7\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a &#21FB08&n\u1d18\u0280\u1d00\u1d21\u028f\u1d0d&7, \u1d00\u0299\u028f \u1d18\u0280\u1d22\u1d07\ua731\u1d1c\u0274\u1d00\u0107 \u1d21 \u1d05\u00f3\u029f!"));
        lore.add(PetsEditorsPetEditorController1("&7\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a &#FF0000&n\ua731\u029c\u026a\ua730\u1d1b + \u1d18\u0280\u1d00\u1d21\u028f&7, \u1d00\u0299\u028f \u1d22\u0280\u1d07\ua731\u1d07\u1d1b\u1d0f\u1d21\u1d00\u0107!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static List<String> PetsEditorsPetEditorController2(final String s) {
        final FileConfiguration d = pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsPetEditorController1.PetsEditorsListener2(s);
        if (d == null) {
            return new ArrayList<String>();
        }
        return new ArrayList<String>(d.getStringList("item.lore"));
    }
    
    private static void PetsEditorsPetEditorController1(final String s, final List<String> list) {
        final FileConfiguration d = pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsPetEditorController1.PetsEditorsListener2(s);
        if (d == null) {
            return;
        }
        d.set("item.lore", (Object)list);
        pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsPetEditorController1.PetsEditorsPetEditorController1(s, d);
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        if (!inventoryClickEvent.getView().getTitle().contains("\u029f\u1d0f\u0280\u1d07")) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if (currentItem == null || currentItem.getType() == Material.AIR) {
            return;
        }
        final String s = PetsEditorsListener2.PetsEditorsPetEditorController2.get(player.getUniqueId());
        if (s == null) {
            return;
        }
        final int rawSlot = inventoryClickEvent.getRawSlot();
        if (rawSlot == 39) {
            PetsEditorsListener2.PetsEditorsPetEditorController2.remove(player.getUniqueId());
            pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.openPetEditor(player, s);
            return;
        }
        if (rawSlot == 41 && currentItem.getType() == Material.LIME_DYE) {
            PetsEditorsListener2.PetsEditorsPetEditorController1.put(player.getUniqueId(), "add");
            player.closeInventory();
            player.sendMessage(PetsEditorsPetEditorController1("&8» &7Wpisz &#FFD300now\u0105 &7linijk\u0119 lore &fpeta &8(&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
            player.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&7Wpisz &#FFD300now\u0105 &7linijk\u0119 lore na &fchacie&7!"), 10, 60, 15);
            E(player, "ENTITY_EXPERIENCE_ORB_PICKUP");
            return;
        }
        final int[] array = { 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25 };
        int n = -1;
        for (int i = 0; i < array.length; ++i) {
            if (rawSlot == array[i]) {
                n = i;
                break;
            }
        }
        if (n != -1 && currentItem.getType() == Material.PAPER) {
            final List<String> c = PetsEditorsPetEditorController2(s);
            if (n >= c.size()) {
                return;
            }
            if (inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT) {
                c.remove(n);
                PetsEditorsPetEditorController1(s, c);
                openLoreEditor(player, s);
                player.sendMessage(PetsEditorsPetEditorController1("&8» &7Linijka lore zosta\u0142a &#FF0000usuni\u0119ta&7!"));
                player.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fLinijka &7zosta\u0142a &#FF0000usuni\u0119ta&7!"), 10, 60, 15);
                E(player, "ENTITY_ENDERMAN_TELEPORT");
                return;
            }
            if (inventoryClickEvent.getClick() == ClickType.LEFT && n > 0) {
                Collections.swap(c, n, n - 1);
                PetsEditorsPetEditorController1(s, c);
                openLoreEditor(player, s);
                return;
            }
            if (inventoryClickEvent.getClick() == ClickType.RIGHT && n < c.size() - 1) {
                Collections.swap(c, n, n + 1);
                PetsEditorsPetEditorController1(s, c);
                openLoreEditor(player, s);
            }
        }
    }
    
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent asyncPlayerChatEvent) {
        final UUID uniqueId = asyncPlayerChatEvent.getPlayer().getUniqueId();
        if (!PetsEditorsListener2.PetsEditorsPetEditorController1.containsKey(uniqueId)) {
            return;
        }
        asyncPlayerChatEvent.setCancelled(true);
        final String s = PetsEditorsListener2.PetsEditorsPetEditorController1.remove(uniqueId);
        final String s2 = PetsEditorsListener2.PetsEditorsPetEditorController2.get(uniqueId);
        final String message = asyncPlayerChatEvent.getMessage();
        if (s2 == null) {
            return;
        }
        if (message.equalsIgnoreCase("anuluj")) {
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                openLoreEditor(player, s3);
                player.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fLinijka lore &7zosta\u0142a &#FF0000anulowana&7!"), 10, 60, 15);
                E(player, "ENTITY_ENDERMAN_TELEPORT");
            });
            return;
        }
        if (s.equals("add")) {
            final List<String> c = PetsEditorsPetEditorController2(s2);
            if (c.size() >= 14) {
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                    openLoreEditor(player2, s4);
                    player2.sendMessage(PetsEditorsPetEditorController1("&8» &7Osi\u0105gni\u0119to maksymaln\u0105 liczb\u0119 &#FF0000linijek&7!"));
                    player2.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fLinijka lore &7osi\u0105gn\u0119\u0142a &#FF0000limit&7!"), 10, 60, 15);
                    E(player2, "ENTITY_ENDERMAN_TELEPORT");
                });
                return;
            }
            c.add(message);
            PetsEditorsPetEditorController1(s2, c);
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                openLoreEditor(player3, s5);
                player3.sendMessage(PetsEditorsPetEditorController1("&8» &7Dodano now\u0105 &flinijk\u0119 &7lore &#27FF00pomy\u015blnie&7!"));
                player3.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fLinijka lore &7zosta\u0142a &#27FF00dodana&7!"), 10, 60, 15);
                E(player3, "ENTITY_PLAYER_LEVELUP");
            });
        }
        else if (s.startsWith("edit_")) {
            final int int1 = Integer.parseInt(s.split("_tmp")[1]);
            final List<String> c2 = PetsEditorsPetEditorController2(s2);
            if (int1 >= c2.size()) {
                return;
            }
            c2.set(int1, message);
            PetsEditorsPetEditorController1(s2, c2);
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                openLoreEditor(player4, s6);
                player4.sendMessage(PetsEditorsPetEditorController1("&8» &7Linijka lore zosta\u0142a &#27FF00zedytowana&7!"));
                player4.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fLinijka lore &7zosta\u0142a &#27FF00zedytowana&7!"), 10, 60, 15);
                E(player4, "ENTITY_PLAYER_LEVELUP");
            });
        }
    }
    
    private static void E(final Player player, final String s) {
        try {
            player.playSound(player.getLocation(), s, 1.0f, 1.0f);
        }
        catch (final Exception ex) {}
    }
    
    private static String PetsEditorsListener1(final String s) {
        final StringBuilder sb = new StringBuilder();
        for (final char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(c);
            }
            else if (Character.isLowerCase(c)) {
                sb.append(PetsEditorsPetEditorController1(c));
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private static char PetsEditorsPetEditorController1(final char c) {
        switch (c) {
            case 'a': {
                return '\u1d00';
            }
            case 'b': {
                return '\u0299';
            }
            case 'c': {
                return '\u1d04';
            }
            case 'd': {
                return '\u1d05';
            }
            case 'e': {
                return '\u1d07';
            }
            case 'f': {
                return '\ua730';
            }
            case 'g': {
                return '\u0262';
            }
            case 'h': {
                return '\u029c';
            }
            case 'i': {
                return '\u026a';
            }
            case 'j': {
                return '\u1d0a';
            }
            case 'k': {
                return '\u1d0b';
            }
            case 'l': {
                return '\u029f';
            }
            case 'm': {
                return '\u1d0d';
            }
            case 'n': {
                return '\u0274';
            }
            case 'o': {
                return '\u1d0f';
            }
            case 'p': {
                return '\u1d18';
            }
            case 'q': {
                return '\u1d0f';
            }
            case 'r': {
                return '\u0280';
            }
            case 's': {
                return '\ua731';
            }
            case 't': {
                return '\u1d1b';
            }
            case 'u': {
                return '\u1d1c';
            }
            case 'v': {
                return '\u1d20';
            }
            case 'w': {
                return '\u1d21';
            }
            case 'x': {
                return '\u1d22';
            }
            case 'y': {
                return '\u028f';
            }
            case 'z': {
                return '\u1d22';
            }
            case '\u00f3': {
                return '\u00f3';
            }
            case '\u015b': {
                return '\u015b';
            }
            case '\u017a': {
                return '\u017a';
            }
            case '\u017c': {
                return '\u017c';
            }
            case '\u0107': {
                return '\u0107';
            }
            default: {
                return c;
            }
        }
    }
    
    private static String PetsEditorsPetEditorController1(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = Pattern.compile("&#([PetsEditorsPetEditorController1-Fa-f0-9]{6})").matcher(s);
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
        PetsEditorsListener2.PetsEditorsPetEditorController2.remove(uuid);
        PetsEditorsListener2.PetsEditorsPetEditorController1.remove(uuid);
    }
    
    static {
        PetsEditorsPetEditorController2 = new HashMap<UUID, String>();
        PetsEditorsPetEditorController1 = new HashMap<UUID, String>();
    }
}
