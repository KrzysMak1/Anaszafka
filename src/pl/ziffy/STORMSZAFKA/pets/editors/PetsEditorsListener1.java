// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets.editors;

import java.util.HashMap;
import java.util.regex.Matcher;
import org.bukkit.ChatColor;
import java.util.regex.Pattern;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.ziffy.STORMSZAFKA.pets.PetsPetService6;
import org.bukkit.inventory.Inventory;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.inventory.meta.ItemMeta;
import pl.ziffy.STORMSZAFKA.utils.PetsEditorsPetEditorController2;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemFlag;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.UUID;
import java.util.Map;
import org.bukkit.event.Listener;

public class PetsEditorsListener1 implements Listener
{
    private static final Map<UUID, String> PetsEditorsListener1;
    private static final Map<UUID, String> PetsEditorsPetEditorController1;
    
    public static void openPetEditor(final Player player, final String s) {
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 36, "§x§F§F§F§9§1§PetsEditorsPetEditorController1\u26a1 §8\u1d07\u1d05\u028f\u1d04\u1d0a\u1d00 \u1d18\u1d07\u1d1b\u1d00 " + PetsEditorsListener1(s));
        pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.PetsEditorsListener1.put(player.getUniqueId(), s);
        final ItemStack itemStack = new ItemStack(Material.NAME_TAG);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(PetsEditorsPetEditorController1("&#DD00FFEdytuj nazw\u0119 peta"));
        final ArrayList lore = new ArrayList();
        lore.add(PetsEditorsPetEditorController1("&7"));
        lore.add(PetsEditorsPetEditorController1("&8 » &7Tutaj mo\u017cesz &fedytowa\u0107"));
        lore.add(PetsEditorsPetEditorController1("&8 » &fnazw\u0119 &7peta na przedmiocie!"));
        lore.add(PetsEditorsPetEditorController1("&7"));
        lore.add(PetsEditorsPetEditorController1("&8 » &7Aktualna nazwa peta:"));
        lore.add(PetsEditorsPetEditorController1("&f" + pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsPetEditorController1.E(s)));
        lore.add(PetsEditorsPetEditorController1("&7"));
        lore.add(PetsEditorsPetEditorController1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u0274\u1d00\u1d22\u1d21\u1d07!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(11, itemStack);
        final ItemStack itemStack2 = new ItemStack(Material.WRITABLE_BOOK);
        final ItemMeta itemMeta2 = itemStack2.getItemMeta();
        itemMeta2.setDisplayName(PetsEditorsPetEditorController1("&#DD00FFEdytuj lore peta"));
        final ArrayList lore2 = new ArrayList();
        lore2.add(PetsEditorsPetEditorController1("&7"));
        lore2.add(PetsEditorsPetEditorController1("&8 » &7Tutaj mo\u017cesz &fedytowa\u0107"));
        lore2.add(PetsEditorsPetEditorController1("&8 » &flore &7peta na przedmiocie!"));
        lore2.add(PetsEditorsPetEditorController1("&7"));
        lore2.add(PetsEditorsPetEditorController1("&8 » &7Aktualna lore peta:"));
        final List<String> c = pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsPetEditorController1.PetsEditorsPetEditorController2(s);
        for (int min = Math.min(9, c.size()), i = 0; i < min; ++i) {
            lore2.add(PetsEditorsPetEditorController1("&f" + (String)c.get(i)));
        }
        if (c.size() > 9) {
            lore2.add(PetsEditorsPetEditorController1("&7... (+" + (c.size() - 9) + " wi\u0119cej)"));
        }
        lore2.add(PetsEditorsPetEditorController1("&7"));
        lore2.add(PetsEditorsPetEditorController1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u029f\u1d0f\u0280\u1d07!"));
        itemMeta2.setLore((List)lore2);
        itemMeta2.addItemFlags(ItemFlag.values());
        itemStack2.setItemMeta(itemMeta2);
        inventory.setItem(12, itemStack2);
        final ItemStack itemStack3 = new ItemStack(Material.PLAYER_HEAD);
        final SkullMeta itemMeta3 = (SkullMeta)itemStack3.getItemMeta();
        if (itemMeta3 != null) {
            final String b = pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsPetEditorController1.PetsEditorsListener1(s);
            if (b != null && !b.isEmpty()) {
                PetsEditorsPetEditorController2.PetsEditorsListener2(itemMeta3, b);
            }
            itemMeta3.setDisplayName(PetsEditorsPetEditorController1("&#DD00FFEdytuj tekstur\u0119 peta"));
            final ArrayList lore3 = new ArrayList();
            lore3.add(PetsEditorsPetEditorController1("&7"));
            lore3.add(PetsEditorsPetEditorController1("&8 » &7Tutaj mo\u017cesz &fedytowa\u0107"));
            lore3.add(PetsEditorsPetEditorController1("&8 » &ftekstur\u0119 g\u0142\u00f3wki&7 peta"));
            lore3.add(PetsEditorsPetEditorController1("&8 » &7na przedmiocie!"));
            lore3.add(PetsEditorsPetEditorController1("&7"));
            lore3.add(PetsEditorsPetEditorController1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u1d1b\u1d07\u1d0b\ua731\u1d1b\u1d1c\u0280\u1d07!"));
            itemMeta3.setLore((List)lore3);
            itemMeta3.addItemFlags(ItemFlag.values());
            itemStack3.setItemMeta((ItemMeta)itemMeta3);
        }
        inventory.setItem(13, itemStack3);
        final ItemStack itemStack4 = new ItemStack(Material.PRISMARINE_SHARD);
        final ItemMeta itemMeta4 = itemStack4.getItemMeta();
        itemMeta4.setDisplayName(PetsEditorsPetEditorController1("&#DD00FFEdytuj hologram peta"));
        final ArrayList lore4 = new ArrayList();
        lore4.add(PetsEditorsPetEditorController1("&7"));
        lore4.add(PetsEditorsPetEditorController1("&8 » &7Tutaj mo\u017cesz &fedytowa\u0107 hologram"));
        lore4.add(PetsEditorsPetEditorController1("&8 » &7wy\u015bwietlany nad petem!"));
        lore4.add(PetsEditorsPetEditorController1("&7"));
        lore4.add(PetsEditorsPetEditorController1("&8 » &7Aktualny hologram peta:"));
        lore4.add(PetsEditorsPetEditorController1("&f" + pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsPetEditorController1.PetsEditorsPetEditorController1(s)));
        lore4.add(PetsEditorsPetEditorController1("&7"));
        lore4.add(PetsEditorsPetEditorController1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u029c\u1d0f\u029f\u1d0f\u0262\u0280\u1d00\u1d0d!"));
        itemMeta4.setLore((List)lore4);
        itemMeta4.addItemFlags(ItemFlag.values());
        itemStack4.setItemMeta(itemMeta4);
        inventory.setItem(14, itemStack4);
        boolean h = true;
        Main.getInstance();
        final G petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null) {
            h = petConfigManager.H(s);
        }
        final ItemStack itemStack5 = new ItemStack(h ? Material.LIME_DYE : Material.RED_DYE);
        final ItemMeta itemMeta5 = itemStack5.getItemMeta();
        if (h) {
            itemMeta5.setDisplayName(PetsEditorsPetEditorController1("&#DD00FFWy\u0142\u0105cz peta"));
            final ArrayList lore5 = new ArrayList();
            lore5.add(PetsEditorsPetEditorController1("&7"));
            lore5.add(PetsEditorsPetEditorController1("&8 » &7Pet jest obecnie &fw\u0142\u0105czony&7!"));
            lore5.add(PetsEditorsPetEditorController1("&7"));
            lore5.add(PetsEditorsPetEditorController1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d21\u028f\u029f\u1d00\u1d04\u1d22\u028f\u0107!"));
            itemMeta5.setLore((List)lore5);
        }
        else {
            itemMeta5.setDisplayName(PetsEditorsPetEditorController1("&#DD00FFW\u0142\u0105cz peta"));
            final ArrayList lore6 = new ArrayList();
            lore6.add(PetsEditorsPetEditorController1("&7"));
            lore6.add(PetsEditorsPetEditorController1("&8 » &7Pet jest obecnie &fwy\u0142\u0105czony&7!"));
            lore6.add(PetsEditorsPetEditorController1("&7"));
            lore6.add(PetsEditorsPetEditorController1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d21\u029f\u1d00\u1d04\u1d22\u028f\u0107!"));
            itemMeta5.setLore((List)lore6);
        }
        itemMeta5.addItemFlags(ItemFlag.values());
        itemStack5.setItemMeta(itemMeta5);
        inventory.setItem(15, itemStack5);
        final ItemStack itemStack6 = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta6 = itemStack6.getItemMeta();
        itemMeta6.setDisplayName(PetsEditorsPetEditorController1("&#FF0000Powr\u00f3t"));
        itemMeta6.addItemFlags(ItemFlag.values());
        itemStack6.setItemMeta(itemMeta6);
        inventory.setItem(31, itemStack6);
        player.openInventory(inventory);
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        if (!inventoryClickEvent.getView().getTitle().startsWith("§x§F§F§F§9§1§PetsEditorsPetEditorController1\u26a1 §8\u1d07\u1d05\u028f\u1d04\u1d0a\u1d00 \u1d18\u1d07\u1d1b\u1d00")) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if (currentItem == null || currentItem.getType() == Material.AIR) {
            return;
        }
        final int rawSlot = inventoryClickEvent.getRawSlot();
        final String s = pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.PetsEditorsListener1.get(player.getUniqueId());
        if (s == null) {
            return;
        }
        if (rawSlot == 11) {
            pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.PetsEditorsPetEditorController1.put(player.getUniqueId(), "name");
            player.closeInventory();
            player.sendMessage(PetsEditorsPetEditorController1("&8» &7Wpisz &#FFD300now\u0105 &7nazw\u0119 &fpeta &8(&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
            player.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&7Wpisz &#FFD300now\u0105 &7nazw\u0119 peta na &fchacie&7!"), 10, 60, 15);
            PetsEditorsListener1(player, "ENTITY_EXPERIENCE_ORB_PICKUP");
            return;
        }
        if (rawSlot == 12) {
            PetsEditorsListener2.openLoreEditor(player, s);
            return;
        }
        if (rawSlot == 13) {
            pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.PetsEditorsPetEditorController1.put(player.getUniqueId(), "texture");
            player.closeInventory();
            player.sendMessage(PetsEditorsPetEditorController1("&8» &7Wpisz &#FFD300tekstur\u0119 &fpeta &8(&7Base64 z &fmineskin.org&8) (&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
            player.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&7Wpisz &#FFD300tekstur\u0119 &7peta na &fchacie&7!"), 10, 60, 15);
            PetsEditorsListener1(player, "ENTITY_EXPERIENCE_ORB_PICKUP");
            return;
        }
        if (rawSlot == 14) {
            pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.PetsEditorsPetEditorController1.put(player.getUniqueId(), "hologram");
            player.closeInventory();
            player.sendMessage(PetsEditorsPetEditorController1("&8» &7Wpisz &#FFD300hologram &fpeta &8(&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
            player.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&7Wpisz &#FFD300hologram &7peta na &fchacie&7!"), 10, 60, 15);
            PetsEditorsListener1(player, "ENTITY_EXPERIENCE_ORB_PICKUP");
            return;
        }
        if (rawSlot == 15) {
            Main.getInstance();
            final G petConfigManager = Main.getPetConfigManager();
            if (petConfigManager != null) {
                final boolean b = !petConfigManager.H(s);
                if (petConfigManager.PetsEditorsPetEditorController1(s, b)) {
                    if (b) {
                        player.sendMessage(PetsEditorsPetEditorController1("&8» &7Pet &f" + s + " &7zosta\u0142 &#27FF00w\u0142\u0105czony&7!"));
                        player.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fPet &7zosta\u0142 &#27FF00w\u0142\u0105czony&7!"), 10, 60, 15);
                    }
                    else {
                        player.sendMessage(PetsEditorsPetEditorController1("&8» &7Pet &f" + s + " &7zosta\u0142 &#FF0000wy\u0142\u0105czony&7!"));
                        player.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fPet &7zosta\u0142 &#FF0000wy\u0142\u0105czony&7!"), 10, 60, 15);
                    }
                    PetsEditorsListener1(player, "ENTITY_PLAYER_LEVELUP");
                    openPetEditor(player, s);
                }
                else {
                    player.sendMessage(PetsEditorsPetEditorController1("&8» &7B\u0142\u0105d podczas zmiany &#FF0000statusu &7peta!"));
                    player.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fStatus &7peta &#FF0000b\u0142\u0105d&7!"), 10, 60, 15);
                    PetsEditorsListener1(player, "ENTITY_ENDERMAN_TELEPORT");
                }
            }
            return;
        }
        if (rawSlot == 31) {
            pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.PetsEditorsListener1.remove(player.getUniqueId());
            pl.ziffy.STORMSZAFKA.ui.gui.PetsEditorsPetEditorController1.openEditorMenu(player);
        }
    }
    
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent asyncPlayerChatEvent) {
        final UUID uniqueId = asyncPlayerChatEvent.getPlayer().getUniqueId();
        if (!pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.PetsEditorsPetEditorController1.containsKey(uniqueId)) {
            return;
        }
        asyncPlayerChatEvent.setCancelled(true);
        final String s = pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.PetsEditorsPetEditorController1.remove(uniqueId);
        final String s11 = pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.PetsEditorsListener1.get(uniqueId);
        final String s12 = asyncPlayerChatEvent.getMessage();
        if (s11 == null) {
            return;
        }
        if (s12.equalsIgnoreCase("anuluj")) {
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                openPetEditor(player, s3);
                player.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fEdycja &7zosta\u0142a &#FF0000anulowana&7!"), 10, 60, 15);
                PetsEditorsListener1(player, "ENTITY_ENDERMAN_TELEPORT");
            });
            return;
        }
        if (s.equals("name")) {
            if (!s12.contains("{time}")) {
                pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.PetsEditorsPetEditorController1.put(uniqueId, "name");
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                    player2.sendMessage(PetsEditorsPetEditorController1("&8» &7Nazwa peta musi zawiera\u0107 &#FF0000{time}&7!"));
                    player2.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fNazwa &7musi zawiera\u0107 &#FF0000{time}&7!"), 10, 60, 15);
                    PetsEditorsListener1(player2, "ENTITY_ENDERMAN_TELEPORT");
                });
                return;
            }
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                final String s11;
                final String s12;
                pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsPetEditorController1.PetsEditorsPetEditorController2(s11, s12);
                openPetEditor(player3, s4);
                if (b) {
                    player3.sendMessage(PetsEditorsPetEditorController1("&8» &7Nazwa peta zosta\u0142a &#27FF00zmieniona&7!"));
                    player3.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fNazwa &7zosta\u0142a &#27FF00zmieniona&7!"), 10, 60, 15);
                    PetsEditorsListener1(player3, "ENTITY_PLAYER_LEVELUP");
                }
                else {
                    player3.sendMessage(PetsEditorsPetEditorController1("&8» &7B\u0142\u0105d podczas zapisywania &#FF0000nazwy&7!"));
                    player3.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fNazwa &7b\u0142\u0105d &#FF0000zapisu&7!"), 10, 60, 15);
                    PetsEditorsListener1(player3, "ENTITY_ENDERMAN_TELEPORT");
                }
            });
        }
        else if (s.equals("texture")) {
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                final String s11;
                final String s12;
                pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsPetEditorController1.PetsEditorsListener1(s11, s12);
                openPetEditor(player4, s7);
                if (b2) {
                    player4.sendMessage(PetsEditorsPetEditorController1("&8» &7Tekstura peta zosta\u0142a &#27FF00zmieniona&7!"));
                    player4.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fTekstura &7zosta\u0142a &#27FF00zmieniona&7!"), 10, 60, 15);
                    PetsEditorsListener1(player4, "ENTITY_PLAYER_LEVELUP");
                }
                else {
                    player4.sendMessage(PetsEditorsPetEditorController1("&8» &7B\u0142\u0105d podczas zapisywania &#FF0000tekstury&7!"));
                    player4.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fTekstura &7b\u0142\u0105d &#FF0000zapisu&7!"), 10, 60, 15);
                    PetsEditorsListener1(player4, "ENTITY_ENDERMAN_TELEPORT");
                }
            });
        }
        else if (s.equals("hologram")) {
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                final String s11;
                final String s12;
                pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsPetEditorController1.PetsEditorsPetEditorController1(s11, s12);
                openPetEditor(player5, s10);
                if (b3) {
                    player5.sendMessage(PetsEditorsPetEditorController1("&8» &7Hologram peta zosta\u0142 &#27FF00zmieniony&7!"));
                    player5.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fHologram &7zosta\u0142 &#27FF00zmieniony&7!"), 10, 60, 15);
                    PetsEditorsListener1(player5, "ENTITY_PLAYER_LEVELUP");
                }
                else {
                    player5.sendMessage(PetsEditorsPetEditorController1("&8» &7B\u0142\u0105d podczas zapisywania &#FF0000hologramu&7!"));
                    player5.sendTitle(PetsEditorsPetEditorController1(""), PetsEditorsPetEditorController1("&fHologram &7b\u0142\u0105d &#FF0000zapisu&7!"), 10, 60, 15);
                    PetsEditorsListener1(player5, "ENTITY_ENDERMAN_TELEPORT");
                }
            });
        }
    }
    
    private static void PetsEditorsListener1(final Player player, final String s) {
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
        pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.PetsEditorsListener1.remove(uuid);
        pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1.PetsEditorsPetEditorController1.remove(uuid);
    }
    
    static {
        PetsEditorsListener1 = new HashMap<UUID, String>();
        PetsEditorsPetEditorController1 = new HashMap<UUID, String>();
    }
}
