// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.editors;

import java.util.HashMap;
import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import java.util.regex.Pattern;
import org.bukkit.plugin.Plugin;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.Color;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemFlag;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.UUID;
import java.util.Map;
import org.bukkit.event.Listener;

public class CostumesEditorsListener2 implements Listener
{
    private static final Map<UUID, String> CostumesEditorsListener1;
    private static final Map<UUID, String> CostumesEditorsListener2;
    
    public static void openArmorColorEditor(final Player player, final String s) {
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 36, "§x§F§F§F§9§1§CostumesEditorsListener1\u26a1 §8\u1d07\u1d05\u028f\u1d04\u1d0a\u1d00 \u1d0b\u1d0f\ua731\u1d1b\u026a\u1d1c\u1d0d\u1d1c " + CostumesEditorsListener1(s));
        pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2.CostumesEditorsListener1.put(player.getUniqueId(), s);
        final Color b = CostumesEditorsCostumeEditorController1.CostumesEditorsListener2(s, "chestplate");
        final Color b2 = CostumesEditorsCostumeEditorController1.CostumesEditorsListener2(s, "leggings");
        final Color b3 = CostumesEditorsCostumeEditorController1.CostumesEditorsListener2(s, "boots");
        final ItemStack itemStack = new ItemStack(Material.LEATHER_CHESTPLATE);
        final LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        itemMeta.setDisplayName(CostumesEditorsListener2("&#DD00FFKolor napier\u015bnika"));
        itemMeta.setColor(b);
        final ArrayList lore = new ArrayList();
        lore.add(CostumesEditorsListener2("&7"));
        lore.add(CostumesEditorsListener2("&8 » &7Aktualny kolor:"));
        lore.add(CostumesEditorsListener2("&f#" + String.format("%06X", b.asRGB())));
        lore.add(CostumesEditorsListener2("&7"));
        lore.add(CostumesEditorsListener2("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u1d0b\u1d0f\u029f\u1d0f\u0280!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta((ItemMeta)itemMeta);
        inventory.setItem(12, itemStack);
        final ItemStack itemStack2 = new ItemStack(Material.LEATHER_LEGGINGS);
        final LeatherArmorMeta itemMeta2 = (LeatherArmorMeta)itemStack2.getItemMeta();
        itemMeta2.setDisplayName(CostumesEditorsListener2("&#DD00FFKolor nogawic"));
        itemMeta2.setColor(b2);
        final ArrayList lore2 = new ArrayList();
        lore2.add(CostumesEditorsListener2("&7"));
        lore2.add(CostumesEditorsListener2("&8 » &7Aktualny kolor:"));
        lore2.add(CostumesEditorsListener2("&f#" + String.format("%06X", b2.asRGB())));
        lore2.add(CostumesEditorsListener2("&7"));
        lore2.add(CostumesEditorsListener2("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u1d0b\u1d0f\u029f\u1d0f\u0280!"));
        itemMeta2.setLore((List)lore2);
        itemMeta2.addItemFlags(ItemFlag.values());
        itemStack2.setItemMeta((ItemMeta)itemMeta2);
        inventory.setItem(13, itemStack2);
        final ItemStack itemStack3 = new ItemStack(Material.LEATHER_BOOTS);
        final LeatherArmorMeta itemMeta3 = (LeatherArmorMeta)itemStack3.getItemMeta();
        itemMeta3.setDisplayName(CostumesEditorsListener2("&#DD00FFKolor but\u00f3w"));
        itemMeta3.setColor(b3);
        final ArrayList lore3 = new ArrayList();
        lore3.add(CostumesEditorsListener2("&7"));
        lore3.add(CostumesEditorsListener2("&8 » &7Aktualny kolor:"));
        lore3.add(CostumesEditorsListener2("&f#" + String.format("%06X", b3.asRGB())));
        lore3.add(CostumesEditorsListener2("&7"));
        lore3.add(CostumesEditorsListener2("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u1d0b\u1d0f\u029f\u1d0f\u0280!"));
        itemMeta3.setLore((List)lore3);
        itemMeta3.addItemFlags(ItemFlag.values());
        itemStack3.setItemMeta((ItemMeta)itemMeta3);
        inventory.setItem(14, itemStack3);
        final ItemStack itemStack4 = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta4 = itemStack4.getItemMeta();
        itemMeta4.setDisplayName(CostumesEditorsListener2("&#FF0000Powr\u00f3t"));
        itemMeta4.addItemFlags(ItemFlag.values());
        itemStack4.setItemMeta(itemMeta4);
        inventory.setItem(31, itemStack4);
        player.openInventory(inventory);
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        if (!inventoryClickEvent.getView().getTitle().contains("\u1d07\u1d05\u028f\u1d04\u1d0a\u1d00 \u1d0b\u1d0f\ua731\u1d1b\u026a\u1d1c\u1d0d\u1d1c")) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if (currentItem == null || currentItem.getType() == Material.AIR) {
            return;
        }
        final int rawSlot = inventoryClickEvent.getRawSlot();
        final String s = pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2.CostumesEditorsListener1.get(player.getUniqueId());
        if (s == null) {
            return;
        }
        if (rawSlot == 12 && currentItem.getType() == Material.LEATHER_CHESTPLATE) {
            pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2.CostumesEditorsListener2.put(player.getUniqueId(), "chestplate");
            player.closeInventory();
            player.sendMessage(CostumesEditorsListener2("&8» &7Wpisz &#FFD300kolor HEX &fnapier\u015bnika &8(&7np. &fFF0000&8) (&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
            player.sendTitle(CostumesEditorsListener2(""), CostumesEditorsListener2("&7Wpisz &#FFD300kolor HEX &7na &fchacie&7!"), 10, 60, 15);
            CostumesEditorsCostumeEditorController1(player, "ENTITY_EXPERIENCE_ORB_PICKUP");
            return;
        }
        if (rawSlot == 13 && currentItem.getType() == Material.LEATHER_LEGGINGS) {
            pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2.CostumesEditorsListener2.put(player.getUniqueId(), "leggings");
            player.closeInventory();
            player.sendMessage(CostumesEditorsListener2("&8» &7Wpisz &#FFD300kolor HEX &fnogawic &8(&7np. &fFF0000&8) (&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
            player.sendTitle(CostumesEditorsListener2(""), CostumesEditorsListener2("&7Wpisz &#FFD300kolor HEX &7na &fchacie&7!"), 10, 60, 15);
            CostumesEditorsCostumeEditorController1(player, "ENTITY_EXPERIENCE_ORB_PICKUP");
            return;
        }
        if (rawSlot == 14 && currentItem.getType() == Material.LEATHER_BOOTS) {
            pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2.CostumesEditorsListener2.put(player.getUniqueId(), "boots");
            player.closeInventory();
            player.sendMessage(CostumesEditorsListener2("&8» &7Wpisz &#FFD300kolor HEX &fbut\u00f3w &8(&7np. &fFF0000&8) (&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
            player.sendTitle(CostumesEditorsListener2(""), CostumesEditorsListener2("&7Wpisz &#FFD300kolor HEX &7na &fchacie&7!"), 10, 60, 15);
            CostumesEditorsCostumeEditorController1(player, "ENTITY_EXPERIENCE_ORB_PICKUP");
            return;
        }
        if (rawSlot == 31) {
            pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2.CostumesEditorsListener1.remove(player.getUniqueId());
            pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.openCostumeEditor(player, s);
        }
    }
    
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent asyncPlayerChatEvent) {
        final UUID uniqueId = asyncPlayerChatEvent.getPlayer().getUniqueId();
        if (!pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2.CostumesEditorsListener2.containsKey(uniqueId)) {
            return;
        }
        asyncPlayerChatEvent.setCancelled(true);
        final String s9 = pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2.CostumesEditorsListener2.remove(uniqueId);
        final String s8 = pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2.CostumesEditorsListener1.get(uniqueId);
        final String message = asyncPlayerChatEvent.getMessage();
        if (s8 == null) {
            return;
        }
        if (message.equalsIgnoreCase("anuluj")) {
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                openArmorColorEditor(player, s4);
                player.sendTitle(CostumesEditorsListener2(""), CostumesEditorsListener2("&fEdycja &7zosta\u0142a &#FF0000anulowana&7!"), 10, 60, 15);
                CostumesEditorsCostumeEditorController1(player, "ENTITY_ENDERMAN_TELEPORT");
            });
            return;
        }
        String s10 = message.trim().toUpperCase();
        if (s10.startsWith("#")) {
            s10 = s10.substring(1);
        }
        if (!s10.matches("[0-9A-F]{6}")) {
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                openArmorColorEditor(player2, s5);
                player2.sendMessage(CostumesEditorsListener2("&8» &7Kolor musi by\u0107 w &fformacie hex &8(&7np. &#FFD300FF0000&8)&7!"));
                player2.sendTitle(CostumesEditorsListener2(""), CostumesEditorsListener2("&fKolor &7format &#FF0000nieprawid\u0142owy&7!"), 10, 60, 15);
                CostumesEditorsCostumeEditorController1(player2, "ENTITY_ENDERMAN_TELEPORT");
            });
            return;
        }
        try {
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                final String s9;
                final String s8;
                final String s10;
                CostumesEditorsCostumeEditorController1.CostumesEditorsListener1(s8, s9, Color.fromRGB(Integer.parseInt(s10, 16)));
                openArmorColorEditor(player3, s6);
                if (b) {
                    player3.sendMessage(CostumesEditorsListener2("&8» &7Kolor " + CostumesEditorsListener3(s7) + " zosta\u0142 &#27FF00zmieniony&7!"));
                    player3.sendTitle(CostumesEditorsListener2(""), CostumesEditorsListener2("&fKolor &7zosta\u0142 &#27FF00zmieniony&7!"), 10, 60, 15);
                    CostumesEditorsCostumeEditorController1(player3, "ENTITY_PLAYER_LEVELUP");
                }
                else {
                    player3.sendMessage(CostumesEditorsListener2("&8» &7B\u0142\u0105d podczas zapisywania &#FF0000koloru&7!"));
                    player3.sendTitle(CostumesEditorsListener2(""), CostumesEditorsListener2("&fKolor &7b\u0142\u0105d &#FF0000zapisu&7!"), 10, 60, 15);
                    CostumesEditorsCostumeEditorController1(player3, "ENTITY_ENDERMAN_TELEPORT");
                }
            });
        }
        catch (final NumberFormatException ex) {
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                openArmorColorEditor(player4, s11);
                player4.sendMessage(CostumesEditorsListener2("&8» &7B\u0142\u0105d podczas &#FF0000konwersji &7koloru!"));
                player4.sendTitle(CostumesEditorsListener2(""), CostumesEditorsListener2("&fKolor &7b\u0142\u0105d &#FF0000konwersji&7!"), 10, 60, 15);
                CostumesEditorsCostumeEditorController1(player4, "ENTITY_ENDERMAN_TELEPORT");
            });
        }
    }
    
    private static void CostumesEditorsCostumeEditorController1(final Player player, final String s) {
        try {
            player.playSound(player.getLocation(), s, 1.0f, 1.0f);
        }
        catch (final Exception ex) {}
    }
    
    private static String CostumesEditorsListener3(final String s) {
        switch (s) {
            case "chestplate": {
                return "napier\u015bnika";
            }
            case "leggings": {
                return "nogawic";
            }
            case "boots": {
                return "but\u00f3w";
            }
            default: {
                return s;
            }
        }
    }
    
    private static String CostumesEditorsListener1(final String s) {
        final StringBuilder sb = new StringBuilder();
        for (final char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(c);
            }
            else if (Character.isLowerCase(c)) {
                sb.append(CostumesEditorsListener1(c));
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private static char CostumesEditorsListener1(final char c) {
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
    
    private static String CostumesEditorsListener2(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = Pattern.compile("&#([CostumesEditorsListener1-Fa-f0-9]{6})").matcher(s);
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
        pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2.CostumesEditorsListener1.remove(uuid);
        pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2.CostumesEditorsListener2.remove(uuid);
    }
    
    static {
        CostumesEditorsListener1 = new HashMap<UUID, String>();
        CostumesEditorsListener2 = new HashMap<UUID, String>();
    }
}
