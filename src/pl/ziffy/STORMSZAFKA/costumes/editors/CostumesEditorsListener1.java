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
import org.bukkit.inventory.meta.LeatherArmorMeta;
import pl.ziffy.STORMSZAFKA.utils.CostumesEditorsListener3;
import org.bukkit.inventory.meta.ItemMeta;
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

public class CostumesEditorsListener1 implements Listener
{
    private static final Map<UUID, String> CostumesEditorsListener2;
    private static final Map<UUID, String> CostumesEditorsListener1;
    
    public static void openCostumeEditor(final Player player, final String s) {
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 45, "§x§F§F§F§9§1§CostumesEditorsListener1\u26a1 §8\u1d07\u1d05\u028f\u1d04\u1d0a\u1d00 \u1d0b\u1d0f\ua731\u1d1b\u026a\u1d1c\u1d0d\u1d1c " + CostumesEditorsListener2(s));
        pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener2.put(player.getUniqueId(), s);
        final ItemStack itemStack = new ItemStack(Material.NAME_TAG);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(CostumesEditorsListener1("&#DD00FFEdytuj nazw\u0119 kostiumu"));
        final ArrayList lore = new ArrayList();
        lore.add(CostumesEditorsListener1("&7"));
        lore.add(CostumesEditorsListener1("&8 » &7Tutaj mo\u017cesz &fedytowa\u0107"));
        lore.add(CostumesEditorsListener1("&8 » &fnazw\u0119 &7kostiumu na przedmiocie!"));
        lore.add(CostumesEditorsListener1("&7"));
        lore.add(CostumesEditorsListener1("&8 » &7Aktualna nazwa kostiumu:"));
        lore.add(CostumesEditorsListener1(CostumesEditorsCostumeEditorController1.F(s)));
        lore.add(CostumesEditorsListener1("&7"));
        lore.add(CostumesEditorsListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u0274\u1d00\u1d22\u1d21\u1d07!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(11, itemStack);
        final ItemStack itemStack2 = new ItemStack(Material.WRITABLE_BOOK);
        final ItemMeta itemMeta2 = itemStack2.getItemMeta();
        itemMeta2.setDisplayName(CostumesEditorsListener1("&#DD00FFEdytuj lore kostiumu"));
        final ArrayList lore2 = new ArrayList();
        lore2.add(CostumesEditorsListener1("&7"));
        lore2.add(CostumesEditorsListener1("&8 » &7Tutaj mo\u017cesz &fedytowa\u0107"));
        lore2.add(CostumesEditorsListener1("&8 » &flore &7kostiumu na przedmiocie!"));
        lore2.add(CostumesEditorsListener1("&7"));
        lore2.add(CostumesEditorsListener1("&8 » &7Aktualna lore kostiumu:"));
        final List<String> j = CostumesEditorsCostumeEditorController1.J(s);
        if (j.isEmpty()) {
            lore2.add(CostumesEditorsListener1("&7Brak lore"));
        }
        else {
            for (int min = Math.min(9, j.size()), i = 0; i < min; ++i) {
                lore2.add(CostumesEditorsListener1((String)j.get(i)));
            }
            if (j.size() > 9) {
                lore2.add(CostumesEditorsListener1("&7... (+" + (j.size() - 9) + " wi\u0119cej)"));
            }
        }
        lore2.add(CostumesEditorsListener1("&7"));
        lore2.add(CostumesEditorsListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u029f\u1d0f\u0280\u1d07!"));
        itemMeta2.setLore((List)lore2);
        itemMeta2.addItemFlags(ItemFlag.values());
        itemStack2.setItemMeta(itemMeta2);
        inventory.setItem(12, itemStack2);
        final ItemStack itemStack3 = new ItemStack(Material.TURTLE_HELMET);
        final ItemMeta itemMeta3 = itemStack3.getItemMeta();
        itemMeta3.setDisplayName(CostumesEditorsListener1("&#DD00FFEdytuj kolor zbroi"));
        final ArrayList lore3 = new ArrayList();
        lore3.add(CostumesEditorsListener1("&7"));
        lore3.add(CostumesEditorsListener1("&8 » &7Tutaj mo\u017cesz &fedytowa\u0107"));
        lore3.add(CostumesEditorsListener1("&8 » &fkolory &7poszczeg\u00f3lnych cz\u0119\u015bci zbroi!"));
        lore3.add(CostumesEditorsListener1("&7"));
        lore3.add(CostumesEditorsListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d0f\u1d1b\u1d21\u1d0f\u0280\u1d22\u028f\u0107 \u1d07\u1d05\u028f\u1d1b\u1d0f\u0280!"));
        itemMeta3.setLore((List)lore3);
        itemMeta3.addItemFlags(ItemFlag.values());
        itemStack3.setItemMeta(itemMeta3);
        inventory.setItem(13, itemStack3);
        final ItemStack itemStack4 = new ItemStack(Material.PLAYER_HEAD);
        final SkullMeta itemMeta4 = (SkullMeta)itemStack4.getItemMeta();
        if (itemMeta4 != null) {
            itemMeta4.setDisplayName(CostumesEditorsListener1("&#DD00FFEdytuj tekstur\u0119 he\u0142mu"));
            final ArrayList lore4 = new ArrayList();
            lore4.add(CostumesEditorsListener1("&7"));
            lore4.add(CostumesEditorsListener1("&8 » &7Tutaj mo\u017cesz &fedytowa\u0107"));
            lore4.add(CostumesEditorsListener1("&8 » &ftekstur\u0119 g\u0142\u00f3wki&7 he\u0142mu kostiumu!"));
            lore4.add(CostumesEditorsListener1("&7"));
            lore4.add(CostumesEditorsListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u1d1b\u1d07\u1d0b\ua731\u1d1b\u1d1c\u0280\u1d07!"));
            itemMeta4.setLore((List)lore4);
            itemMeta4.addItemFlags(ItemFlag.values());
            itemStack4.setItemMeta((ItemMeta)itemMeta4);
            final String e = CostumesEditorsCostumeEditorController1.CostumesEditorsListener4(s);
            if (e != null && !e.isEmpty()) {
                final SkullMeta itemMeta5 = (SkullMeta)itemStack4.getItemMeta();
                if (itemMeta5 != null) {
                    CostumesEditorsListener3.CostumesEditorsCostumeEditorController1(itemMeta5, e);
                    itemStack4.setItemMeta((ItemMeta)itemMeta5);
                }
            }
        }
        else {
            final SkullMeta itemMeta6 = (SkullMeta)Bukkit.getItemFactory().getItemMeta(Material.PLAYER_HEAD);
            if (itemMeta6 != null) {
                itemMeta6.setDisplayName(CostumesEditorsListener1("&#DD00FFEdytuj tekstur\u0119 he\u0142mu"));
                final ArrayList lore5 = new ArrayList();
                lore5.add(CostumesEditorsListener1("&7"));
                lore5.add(CostumesEditorsListener1("&8 » &7Tutaj mo\u017cesz &fedytowa\u0107"));
                lore5.add(CostumesEditorsListener1("&8 » &ftekstur\u0119 g\u0142\u00f3wki&7 he\u0142mu kostiumu!"));
                lore5.add(CostumesEditorsListener1("&7"));
                lore5.add(CostumesEditorsListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u1d1b\u1d07\u1d0b\ua731\u1d1b\u1d1c\u0280\u1d07!"));
                itemMeta6.setLore((List)lore5);
                itemMeta6.addItemFlags(ItemFlag.values());
                itemStack4.setItemMeta((ItemMeta)itemMeta6);
            }
        }
        inventory.setItem(14, itemStack4);
        final ItemStack itemStack5 = new ItemStack(Material.LEATHER_CHESTPLATE);
        final LeatherArmorMeta itemMeta7 = (LeatherArmorMeta)itemStack5.getItemMeta();
        itemMeta7.setDisplayName(CostumesEditorsListener1("&#DD00FFKolor przedmiotu kostiumu"));
        final Color h = CostumesEditorsCostumeEditorController1.H(s);
        itemMeta7.setColor(h);
        final ArrayList lore6 = new ArrayList();
        lore6.add(CostumesEditorsListener1("&7"));
        lore6.add(CostumesEditorsListener1("&8 » &7Tutaj mo\u017cesz &fedytowa\u0107"));
        lore6.add(CostumesEditorsListener1("&8 » &fkolor &7przedmiotu aktywacyjnego!"));
        lore6.add(CostumesEditorsListener1("&7"));
        lore6.add(CostumesEditorsListener1("&8 » &7Aktualny kolor:"));
        lore6.add(CostumesEditorsListener1("&f#" + String.format("%06X", h.asRGB())));
        lore6.add(CostumesEditorsListener1("&7"));
        lore6.add(CostumesEditorsListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u1d0b\u1d0f\u029f\u1d0f\u0280!"));
        itemMeta7.setLore((List)lore6);
        itemMeta7.addItemFlags(ItemFlag.values());
        itemStack5.setItemMeta((ItemMeta)itemMeta7);
        inventory.setItem(15, itemStack5);
        final ItemStack itemStack6 = new ItemStack(Material.GOLD_INGOT);
        final ItemMeta itemMeta8 = itemStack6.getItemMeta();
        itemMeta8.setDisplayName(CostumesEditorsListener1("&#DD00FFCena przed\u0142u\u017cania"));
        final int g = CostumesEditorsCostumeEditorController1.G(s);
        final String b = CostumesEditorsListener2(g);
        CostumesEditorsListener1(g);
        final ArrayList lore7 = new ArrayList();
        lore7.add(CostumesEditorsListener1("&7"));
        lore7.add(CostumesEditorsListener1("&8 » &7Tutaj mo\u017cesz &fedytowa\u0107"));
        lore7.add(CostumesEditorsListener1("&8 » &fcen\u0119 &7przed\u0142u\u017cania kostiumu!"));
        lore7.add(CostumesEditorsListener1("&7"));
        lore7.add(CostumesEditorsListener1("&8 » &7Aktualna cena: &#FFDF00" + b));
        lore7.add(CostumesEditorsListener1("&7"));
        lore7.add(CostumesEditorsListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \u1d04\u1d07\u0274\u1d07!"));
        itemMeta8.setLore((List)lore7);
        itemMeta8.addItemFlags(ItemFlag.values());
        itemStack6.setItemMeta(itemMeta8);
        inventory.setItem(21, itemStack6);
        final ItemStack itemStack7 = new ItemStack(Material.REPEATER);
        final ItemMeta itemMeta9 = itemStack7.getItemMeta();
        itemMeta9.setDisplayName(CostumesEditorsListener1("&#DD00FFEdytuj slot w menu"));
        final int k = CostumesEditorsCostumeEditorController1.I(s);
        final ArrayList lore8 = new ArrayList();
        lore8.add(CostumesEditorsListener1("&7"));
        lore8.add(CostumesEditorsListener1("&8 » &7Tutaj mo\u017cesz &fedytowa\u0107"));
        lore8.add(CostumesEditorsListener1("&8 » &fslot &7kostiumu w menu podgl\u0105du!"));
        lore8.add(CostumesEditorsListener1("&7"));
        if (k >= 0) {
            lore8.add(CostumesEditorsListener1("&8 » &7Aktualny slot: &f" + k));
        }
        else {
            lore8.add(CostumesEditorsListener1("&8 » &7Slot: &fnie ustawiony"));
        }
        lore8.add(CostumesEditorsListener1("&7"));
        lore8.add(CostumesEditorsListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107 \ua731\u029f\u1d0f\u1d1b!"));
        itemMeta9.setLore((List)lore8);
        itemMeta9.addItemFlags(ItemFlag.values());
        itemStack7.setItemMeta(itemMeta9);
        inventory.setItem(22, itemStack7);
        final ItemStack itemStack8 = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta10 = itemStack8.getItemMeta();
        itemMeta10.setDisplayName(CostumesEditorsListener1("&#FF0000Powr\u00f3t"));
        itemMeta10.addItemFlags(ItemFlag.values());
        itemStack8.setItemMeta(itemMeta10);
        inventory.setItem(40, itemStack8);
        final boolean b2 = CostumesEditorsCostumeEditorController1.CostumesEditorsListener2(s);
        final ItemStack itemStack9 = new ItemStack(b2 ? Material.LIME_DYE : Material.GRAY_DYE);
        final ItemMeta itemMeta11 = itemStack9.getItemMeta();
        if (b2) {
            itemMeta11.setDisplayName(CostumesEditorsListener1("&#1DFF1AKostium w\u0142\u0105czony"));
        }
        else {
            itemMeta11.setDisplayName(CostumesEditorsListener1("&#FF1A1AKostium wy\u0142\u0105czony"));
        }
        final ArrayList lore9 = new ArrayList();
        lore9.add(CostumesEditorsListener1("&7"));
        lore9.add(CostumesEditorsListener1("&8 » &7Tutaj mo\u017cesz &fw\u0142\u0105czy\u0107/wy\u0142\u0105czy\u0107"));
        lore9.add(CostumesEditorsListener1("&8 » &7kostium dla wszystkich graczy!"));
        lore9.add(CostumesEditorsListener1("&7"));
        lore9.add(CostumesEditorsListener1("&8 » &7Status: " + (b2 ? "&#1DFF1AW\u0142\u0105czony" : "&#FF1A1AWy\u0142\u0105czony")));
        lore9.add(CostumesEditorsListener1("&7"));
        lore9.add(CostumesEditorsListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d22\u1d0d\u026a\u1d07\u0274\u026a\u0107!"));
        itemMeta11.setLore((List)lore9);
        itemMeta11.addItemFlags(ItemFlag.values());
        itemStack9.setItemMeta(itemMeta11);
        inventory.setItem(41, itemStack9);
        player.openInventory(inventory);
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        if (!inventoryClickEvent.getView().getTitle().startsWith("§x§F§F§F§9§1§CostumesEditorsListener1\u26a1 §8\u1d07\u1d05\u028f\u1d04\u1d0a\u1d00 \u1d0b\u1d0f\ua731\u1d1b\u026a\u1d1c\u1d0d\u1d1c")) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if (currentItem == null || currentItem.getType() == Material.AIR) {
            return;
        }
        final int rawSlot = inventoryClickEvent.getRawSlot();
        final String s = pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener2.get(player.getUniqueId());
        if (s == null) {
            return;
        }
        if (rawSlot == 11) {
            pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener1.put(player.getUniqueId(), "name");
            player.closeInventory();
            player.sendMessage(CostumesEditorsListener1("&8» &7Wpisz &#FFD300now\u0105 &7nazw\u0119 &fkostiumu &8(&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
            player.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&7Wpisz &#FFD300now\u0105 &7nazw\u0119 kostiumu na &fchacie&7!"), 10, 60, 15);
            CostumesEditorsListener1(player, "ENTITY_EXPERIENCE_ORB_PICKUP");
            return;
        }
        if (rawSlot == 12) {
            CostumesEditorsListener4.openLoreEditor(player, s);
            return;
        }
        if (rawSlot == 13) {
            pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2.openArmorColorEditor(player, s);
            return;
        }
        if (rawSlot == 14) {
            pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener1.put(player.getUniqueId(), "texture");
            player.closeInventory();
            player.sendMessage(CostumesEditorsListener1("&8» &7Wpisz &#FFD300tekstur\u0119 &fhe\u0142mu &8(&7Base64 z &fmineskin.org&8) (&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
            player.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&7Wpisz &#FFD300tekstur\u0119 &7he\u0142mu na &fchacie&7!"), 10, 60, 15);
            CostumesEditorsListener1(player, "ENTITY_EXPERIENCE_ORB_PICKUP");
            return;
        }
        if (rawSlot == 15) {
            pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener1.put(player.getUniqueId(), "itemcolor");
            player.closeInventory();
            player.sendMessage(CostumesEditorsListener1("&8» &7Wpisz &#FFD300kolor HEX &fprzedmiotu &8(&7np. &fFF0000&8) (&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
            player.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&7Wpisz &#FFD300kolor HEX &7na &fchacie&7!"), 10, 60, 15);
            CostumesEditorsListener1(player, "ENTITY_EXPERIENCE_ORB_PICKUP");
            return;
        }
        if (rawSlot == 21 && currentItem.getType() == Material.GOLD_INGOT) {
            pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener1.put(player.getUniqueId(), "extensioncost");
            player.closeInventory();
            player.sendMessage(CostumesEditorsListener1("&8» &7Wpisz &#FFD300now\u0105 cen\u0119 &fprzed\u0142u\u017cania &8(&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
            player.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&7Wpisz &#FFD300now\u0105 cen\u0119 &7na &fchacie&7!"), 10, 60, 15);
            CostumesEditorsListener1(player, "ENTITY_EXPERIENCE_ORB_PICKUP");
            return;
        }
        if (rawSlot == 22 && currentItem.getType() == Material.REPEATER) {
            pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener1.put(player.getUniqueId(), "slot");
            player.closeInventory();
            player.sendMessage(CostumesEditorsListener1("&8» &7Wpisz &#FFD300numer slotu &fprzedmiotu &8(&70-53&8) (&7Wpisz &#FF0000anuluj&7, aby anulowa\u0107&8)&7!"));
            player.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&7Wpisz &#FFD300numer slotu &7na &fchacie&7!"), 10, 60, 15);
            CostumesEditorsListener1(player, "ENTITY_EXPERIENCE_ORB_PICKUP");
            return;
        }
        if (rawSlot == 40) {
            pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener2.remove(player.getUniqueId());
            pl.ziffy.STORMSZAFKA.ui.gui.CostumesEditorsListener1.openEditorMenu(player);
            return;
        }
        if (rawSlot == 41) {
            final boolean b = !CostumesEditorsCostumeEditorController1.CostumesEditorsListener2(s);
            if (CostumesEditorsCostumeEditorController1.CostumesEditorsListener1(s, b)) {
                if (b) {
                    player.sendMessage(CostumesEditorsListener1("&8» &7Kostium &f" + s + " &7zosta\u0142 &#27FF00w\u0142\u0105czony&7!"));
                    player.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fKostium &7zosta\u0142 &#27FF00w\u0142\u0105czony&7!"), 10, 60, 15);
                }
                else {
                    player.sendMessage(CostumesEditorsListener1("&8» &7Kostium &f" + s + " &7zosta\u0142 &#FF0000wy\u0142\u0105czony&7!"));
                    player.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fKostium &7zosta\u0142 &#FF0000wy\u0142\u0105czony&7!"), 10, 60, 15);
                }
                CostumesEditorsListener1(player, "ENTITY_PLAYER_LEVELUP");
                openCostumeEditor(player, s);
            }
            else {
                player.sendMessage(CostumesEditorsListener1("&8» &7B\u0142\u0105d podczas zmiany &#FF0000statusu &7kostiumu!"));
                player.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fStatus &7kostiumu &#FF0000b\u0142\u0105d&7!"), 10, 60, 15);
                CostumesEditorsListener1(player, "ENTITY_ENDERMAN_TELEPORT");
            }
        }
    }
    
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent asyncPlayerChatEvent) {
        final UUID uniqueId = asyncPlayerChatEvent.getPlayer().getUniqueId();
        if (!pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener1.containsKey(uniqueId)) {
            return;
        }
        asyncPlayerChatEvent.setCancelled(true);
        final String s = pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener1.remove(uniqueId);
        final String s22 = pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener2.get(uniqueId);
        final String s10 = asyncPlayerChatEvent.getMessage();
        if (s22 == null) {
            return;
        }
        if (s10.equalsIgnoreCase("anuluj")) {
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                openCostumeEditor(player, s4);
                player.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fEdycja &7zosta\u0142a &#FF0000anulowana&7!"), 10, 60, 15);
                CostumesEditorsListener1(player, "ENTITY_ENDERMAN_TELEPORT");
            });
            return;
        }
        if (s.equals("name")) {
            if (!s10.contains("{time}")) {
                pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener1.put(uniqueId, "name");
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                    player2.sendMessage(CostumesEditorsListener1("&8» &7Nazwa kostiumu musi zawiera\u0107 &#FF0000{time}&7!"));
                    player2.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fNazwa &7musi zawiera\u0107 &#FF0000{time}&7!"), 10, 60, 15);
                    CostumesEditorsListener1(player2, "ENTITY_ENDERMAN_TELEPORT");
                });
                return;
            }
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                final String s22;
                final String s10;
                CostumesEditorsCostumeEditorController1.CostumesEditorsListener1(s22, s10);
                openCostumeEditor(player3, s5);
                if (b) {
                    player3.sendMessage(CostumesEditorsListener1("&8» &7Nazwa kostiumu zosta\u0142a &#27FF00zmieniona&7!"));
                    player3.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fNazwa &7zosta\u0142a &#27FF00zmieniona&7!"), 10, 60, 15);
                    CostumesEditorsListener1(player3, "ENTITY_PLAYER_LEVELUP");
                }
                else {
                    player3.sendMessage(CostumesEditorsListener1("&8» &7B\u0142\u0105d podczas zapisywania &#FF0000nazwy&7!"));
                    player3.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fNazwa &7b\u0142\u0105d &#FF0000zapisu&7!"), 10, 60, 15);
                    CostumesEditorsListener1(player3, "ENTITY_ENDERMAN_TELEPORT");
                }
            });
        }
        else if (s.equals("texture")) {
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                final String s22;
                final String s10;
                CostumesEditorsCostumeEditorController1.CostumesEditorsListener3(s22, s10);
                openCostumeEditor(player4, s8);
                if (b2) {
                    player4.sendMessage(CostumesEditorsListener1("&8» &7Tekstura he\u0142mu zosta\u0142a &#27FF00zmieniona&7!"));
                    player4.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fTekstura &7zosta\u0142a &#27FF00zmieniona&7!"), 10, 60, 15);
                    CostumesEditorsListener1(player4, "ENTITY_PLAYER_LEVELUP");
                }
                else {
                    player4.sendMessage(CostumesEditorsListener1("&8» &7B\u0142\u0105d podczas zapisywania &#FF0000tekstury&7!"));
                    player4.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fTekstura &7b\u0142\u0105d &#FF0000zapisu&7!"), 10, 60, 15);
                    CostumesEditorsListener1(player4, "ENTITY_ENDERMAN_TELEPORT");
                }
            });
        }
        else if (s.equals("itemcolor")) {
            String s14 = s10.trim().toUpperCase();
            if (s14.startsWith("#")) {
                s14 = s14.substring(1);
            }
            if (!s14.matches("[0-9A-F]{6}")) {
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                    openCostumeEditor(player5, s11);
                    player5.sendMessage(CostumesEditorsListener1("&8» &7Kolor musi by\u0107 w &fformacie hex &8(&7np. &#FFD300FF0000&8)&7!"));
                    player5.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fKolor &7format &#FF0000nieprawid\u0142owy&7!"), 10, 60, 15);
                    CostumesEditorsListener1(player5, "ENTITY_ENDERMAN_TELEPORT");
                });
                return;
            }
            try {
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                    final String s22;
                    final String s14;
                    CostumesEditorsCostumeEditorController1.CostumesEditorsListener1(s22, Color.fromRGB(Integer.parseInt(s14, 16)));
                    openCostumeEditor(player6, s12);
                    if (b3) {
                        player6.sendMessage(CostumesEditorsListener1("&8» &7Kolor przedmiotu zosta\u0142 &#27FF00zmieniony&7!"));
                        player6.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fKolor &7zosta\u0142 &#27FF00zmieniony&7!"), 10, 60, 15);
                        CostumesEditorsListener1(player6, "ENTITY_PLAYER_LEVELUP");
                    }
                    else {
                        player6.sendMessage(CostumesEditorsListener1("&8» &7B\u0142\u0105d podczas zapisywania &#FF0000koloru&7!"));
                        player6.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fKolor &7b\u0142\u0105d &#FF0000zapisu&7!"), 10, 60, 15);
                        CostumesEditorsListener1(player6, "ENTITY_ENDERMAN_TELEPORT");
                    }
                });
            }
            catch (final NumberFormatException ex) {
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                    openCostumeEditor(player7, s15);
                    player7.sendMessage(CostumesEditorsListener1("&8» &7B\u0142\u0105d podczas &#FF0000konwersji &7koloru!"));
                    player7.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fKolor &7b\u0142\u0105d &#FF0000konwersji&7!"), 10, 60, 15);
                    CostumesEditorsListener1(player7, "ENTITY_ENDERMAN_TELEPORT");
                });
            }
        }
        else if (s.equals("extensioncost")) {
            try {
                if (Integer.parseInt(s10.trim()) < 0) {
                    Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                        openCostumeEditor(player8, s16);
                        player8.sendMessage(CostumesEditorsListener1("&8» &7Cena &7nie mo\u017ce by\u0107 &#FF0000ujemna&7!"));
                        player8.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fCena &7musi by\u0107 &#FF0000dodatnia&7!"), 10, 60, 15);
                        CostumesEditorsListener1(player8, "ENTITY_ENDERMAN_TELEPORT");
                    });
                    return;
                }
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                    final String s22;
                    final int n2;
                    CostumesEditorsCostumeEditorController1.CostumesEditorsListener1(s22, n2);
                    openCostumeEditor(player9, s17);
                    if (b4) {
                        player9.sendMessage(CostumesEditorsListener1("&8» &7Cena przed\u0142u\u017cania zosta\u0142a &#27FF00zmieniona&7 na &f" + CostumesEditorsListener2(n) + "$&7!"));
                        player9.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fCena &7zmieniona na &f" + CostumesEditorsListener2(n)), 10, 60, 15);
                        CostumesEditorsListener1(player9, "ENTITY_PLAYER_LEVELUP");
                    }
                    else {
                        player9.sendMessage(CostumesEditorsListener1("&8» &7B\u0142\u0105d podczas zapisywania &#FF0000ceny&7!"));
                        player9.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fCena &7b\u0142\u0105d &#FF0000zapisu&7!"), 10, 60, 15);
                        CostumesEditorsListener1(player9, "ENTITY_ENDERMAN_TELEPORT");
                    }
                });
            }
            catch (final NumberFormatException ex2) {
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                    openCostumeEditor(player10, s19);
                    player10.sendMessage(CostumesEditorsListener1("&8» &7Cena musi by\u0107 &#FF0000liczb\u0105&7!"));
                    player10.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fCena &7musi by\u0107 &#FF0000liczb\u0105&7!"), 10, 60, 15);
                    CostumesEditorsListener1(player10, "ENTITY_ENDERMAN_TELEPORT");
                });
            }
        }
        else if (s.equals("slot")) {
            try {
                final int n4 = Integer.parseInt(s10.trim());
                if (n4 < 0 || n4 > 53) {
                    Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                        openCostumeEditor(player11, s20);
                        player11.sendMessage(CostumesEditorsListener1("&8» &7Slot musi by\u0107 mi\u0119dzy &#FFD3000 &7a &#FFD30053&7!"));
                        player11.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fSlot &7musi by\u0107 &#FF0000mi\u0119dzy 0-53&7!"), 10, 60, 15);
                        CostumesEditorsListener1(player11, "ENTITY_ENDERMAN_TELEPORT");
                    });
                    return;
                }
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                    final String s22;
                    final int n4;
                    CostumesEditorsCostumeEditorController1.CostumesEditorsListener2(s22, n4);
                    openCostumeEditor(player12, s21);
                    if (b5) {
                        player12.sendMessage(CostumesEditorsListener1("&8» &7Slot kostiumu zosta\u0142 &#27FF00zmieniony&7 na &f" + n3 + "&7!"));
                        player12.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fSlot &7zmieniony na &f" + n3), 10, 60, 15);
                        CostumesEditorsListener1(player12, "ENTITY_PLAYER_LEVELUP");
                    }
                    else {
                        player12.sendMessage(CostumesEditorsListener1("&8» &7B\u0142\u0105d podczas zapisywania &#FF0000slotu&7!"));
                        player12.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fSlot &7b\u0142\u0105d &#FF0000zapisu&7!"), 10, 60, 15);
                        CostumesEditorsListener1(player12, "ENTITY_ENDERMAN_TELEPORT");
                    }
                });
            }
            catch (final NumberFormatException ex3) {
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> {
                    openCostumeEditor(player13, s23);
                    player13.sendMessage(CostumesEditorsListener1("&8» &7Slot musi by\u0107 &#FF0000liczb\u0105&7!"));
                    player13.sendTitle(CostumesEditorsListener1(""), CostumesEditorsListener1("&fSlot &7musi by\u0107 &#FF0000liczb\u0105&7!"), 10, 60, 15);
                    CostumesEditorsListener1(player13, "ENTITY_ENDERMAN_TELEPORT");
                });
            }
        }
    }
    
    private static void CostumesEditorsListener1(final Player player, final String s) {
        try {
            player.playSound(player.getLocation(), s, 1.0f, 1.0f);
        }
        catch (final Exception ex) {}
    }
    
    private static String CostumesEditorsListener2(final String s) {
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
    
    private static String CostumesEditorsListener1(final String s) {
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
    
    private static String CostumesEditorsListener2(final int i) {
        final String value = String.valueOf(i);
        final StringBuilder sb = new StringBuilder();
        int n = 0;
        for (int j = value.length() - 1; j >= 0; --j) {
            if (n == 3) {
                sb.insert(0, ",");
                n = 0;
            }
            sb.insert(0, value.charAt(j));
            ++n;
        }
        return sb.toString();
    }
    
    private static String CostumesEditorsListener1(final int i) {
        if (i >= 1000000) {
            return i / 1000000 + "MLN";
        }
        if (i >= 1000) {
            return "" + i / 1000;
        }
        return String.valueOf(i);
    }
    
    public static void cleanup(final UUID uuid) {
        pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener2.remove(uuid);
        pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1.CostumesEditorsListener1.remove(uuid);
    }
    
    static {
        CostumesEditorsListener2 = new HashMap<UUID, String>();
        CostumesEditorsListener1 = new HashMap<UUID, String>();
    }
}
