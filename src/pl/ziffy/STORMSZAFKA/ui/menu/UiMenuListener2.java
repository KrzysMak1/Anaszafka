// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.ui.menu;

import java.util.Arrays;
import java.util.HashMap;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.EventHandler;
import pl.ziffy.STORMSZAFKA.ui.gui.UiMenuListener1;
import pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener3;
import org.bukkit.Sound;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import pl.ziffy.STORMSZAFKA.pets.PetsPetService4;
import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.List;
import java.util.UUID;
import java.util.Map;
import org.bukkit.event.Listener;

public class UiMenuListener2 implements Listener
{
    private static final String I = "&x&F&F&F&9&1&UiMenuListener1\u26a1 &8\ua731\u1d1b\u1d0f\u0280\u1d0d\ua731\u1d22\u1d00\ua730\u1d0b\u1d00 \u1d201.1";
    private static final String H = "&x&F&F&F&9&1&UiMenuListener1\u26a1 &8\u1d18\u1d00\u0274\u1d07\u029f \u1d18\u1d07\u1d1b\u00f3\u1d21";
    private static final String C = "&x&F&F&F&9&1&UiMenuListener1\u26a1 &8\u1d18\u1d00\u0274\u1d07\u029f \u1d0b\u1d0f\ua731\u1d1b\u026a\u1d1c\u1d0d\u00f3\u1d21";
    private static final Map<UUID, String> UiMenuListener2;
    private static final Map<UUID, String> F;
    private static final Map<UUID, Boolean> D;
    private static final Map<UUID, Boolean> G;
    private static final List<String> E;
    private static final List<String> UiMenuListener1;
    
    public static void openMainPanel(final Player player) {
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 45, UiMenuListener1("&x&F&F&F&9&1&UiMenuListener1\u26a1 &8\ua731\u1d1b\u1d0f\u0280\u1d0d\ua731\u1d22\u1d00\ua730\u1d0b\u1d00 \u1d201.1"));
        inventory.setItem(11, D());
        inventory.setItem(12, UiMenuListener1());
        inventory.setItem(13, G());
        final ItemStack itemStack = new ItemStack(Material.RED_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(UiMenuListener1("&#DD00FFEdytor koszt\u00f3w przed\u0142u\u017cania"));
        final ArrayList lore = new ArrayList();
        lore.add(UiMenuListener1("&7"));
        lore.add(UiMenuListener1("&8 » &7Zarz\u0105dzaj kosztami"));
        lore.add(UiMenuListener1("&8 » &7przed\u0142u\u017cania pet\u00f3w sercami!"));
        lore.add(UiMenuListener1("&7"));
        lore.add(UiMenuListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d0f\u1d1b\u1d21\u1d0f\u0280\u1d22\u028f\u0107!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        inventory.setItem(15, itemStack);
        inventory.setItem(31, C());
        player.openInventory(inventory);
    }
    
    public static void startTimeInput(final Player player) {
        pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.D.put(player.getUniqueId(), true);
        player.closeInventory();
        player.sendMessage(UiMenuListener1("&8[&#B300FF\ud83d\udee1&8] &7Wpisz na chacie &#08FB0Dczas trwania&7 pet\u00f3w &8(&7np. &f30s&7, &f10m&7, &f12h&7, &f30d&7, &fINFINITY&8)&7, lub wpisz &#FB0808anuluj&7, \u017ceby wyj\u015b\u0107 z tego procesu."));
    }
    
    public static void startCostumeTimeInput(final Player player) {
        pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.G.put(player.getUniqueId(), true);
        player.closeInventory();
        player.sendMessage(UiMenuListener1("&8[&#B300FF\ud83d\udee1&8] &7Wpisz na chacie &#08FB0Dczas trwania&7 kostium\u00f3w &8(&7np. &f30s&7, &f10m&7, &f12h&7, &f30d&7, &fINFINITY&8)&7, lub wpisz &#FB0808anuluj&7, \u017ceby wyj\u015b\u0107 z tego procesu."));
    }
    
    public static void openPetsPanel(final Player player, final int n) {
        String s = pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.UiMenuListener2.getOrDefault(player.getUniqueId(), "INFINITE");
        if (s == null) {
            s = "INFINITE";
        }
        openPetsPanel(player, n, s);
    }
    
    public static void openPetsPanel(final Player player, final int n, final String s) {
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 54, UiMenuListener1("&x&F&F&F&9&1&UiMenuListener1\u26a1 &8\u1d18\u1d00\u0274\u1d07\u029f \u1d18\u1d07\u1d1b\u00f3\u1d21") + " - \ua731\u1d1b\u0280\u1d0f\u0274\u1d00 " + n);
        final int[] array = { 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43 };
        final int length = array.length;
        final int n2 = (n - 1) * length;
        for (int min = Math.min(n2 + length, pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.E.size()), i = n2; i < min; ++i) {
            inventory.setItem(array[i - n2], UiMenuListener1(pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.E.get(i), s));
        }
        final int n3 = (int)Math.ceil(pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.E.size() / (double)length);
        if (n > 1) {
            inventory.setItem(48, E());
        }
        inventory.setItem(49, F());
        if (n < n3) {
            inventory.setItem(50, UiMenuListener2());
        }
        player.openInventory(inventory);
    }
    
    public static void openCostumesPanel(final Player player) {
        String s = pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.F.getOrDefault(player.getUniqueId(), "INFINITE");
        if (s == null) {
            s = "INFINITE";
        }
        openCostumesPanel(player, s);
    }
    
    public static void openCostumesPanel(final Player player, final String s) {
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 54, UiMenuListener1("&x&F&F&F&9&1&UiMenuListener1\u26a1 &8\u1d18\u1d00\u0274\u1d07\u029f \u1d0b\u1d0f\ua731\u1d1b\u026a\u1d1c\u1d0d\u00f3\u1d21"));
        final int[] array = { 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43 };
        for (int i = 0; i < Math.min(pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.UiMenuListener1.size(), array.length); ++i) {
            inventory.setItem(array[i], UiMenuListener2(pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.UiMenuListener1.get(i), s));
        }
        inventory.setItem(49, F());
        player.openInventory(inventory);
    }
    
    private static ItemStack D() {
        final ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        final SkullMeta itemMeta = (SkullMeta)itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(UiMenuListener1("&#DD00FFPety"));
            final ArrayList lore = new ArrayList();
            lore.add(UiMenuListener1("&7"));
            lore.add(UiMenuListener1("&8 » &7W tej kategorii znajdziesz"));
            lore.add(UiMenuListener1("&8 » &7wszystkie &fpety&7 na serwerze!"));
            lore.add(UiMenuListener1("&7"));
            lore.add(UiMenuListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a \u1d18\u0280\u1d00\u1d21\u028f\u1d0d, \u1d00\u0299\u028f \u1d18\u0280\u1d22\u1d07\u1d0a\u015b\u0107!"));
            itemMeta.setLore((List)lore);
            UiMenuListener1(itemMeta, "e3RleHR1cmVzOntTS0lOOnt1cmw6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmM4NGQxYTkwOTVhNjNmNDc1NDY3MjBmZTdmNmVkZjAzZTEyMjc2ZTA2MmI4NTNlMjA3YTVjNjk3ZjFlNTIxIn19fQ==");
            itemStack.setItemMeta((ItemMeta)itemMeta);
        }
        return itemStack;
    }
    
    private static ItemStack UiMenuListener1() {
        final ItemStack itemStack = new ItemStack(Material.LEATHER_CHESTPLATE);
        final LeatherArmorMeta itemMeta = (LeatherArmorMeta)itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(UiMenuListener1("&#DD00FFKostiumy"));
            itemMeta.setColor(Color.fromRGB(221, 0, 255));
            final ArrayList lore = new ArrayList();
            lore.add(UiMenuListener1("&7"));
            lore.add(UiMenuListener1("&8 » &7W tej kategorii znajdziesz"));
            lore.add(UiMenuListener1("&8 » &7wszystkie &fkostiumy&7 na serwerze!"));
            lore.add(UiMenuListener1("&7"));
            lore.add(UiMenuListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a \u1d18\u0280\u1d00\u1d21\u028f\u1d0d, \u1d00\u0299\u028f \u1d18\u0280\u1d22\u1d07\u1d0a\u015b\u0107!"));
            itemMeta.setLore((List)lore);
            itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
            itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_DESTROYS });
            itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_DYE });
            itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
            itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_PLACED_ON });
            itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_POTION_EFFECTS });
            itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
            itemStack.setItemMeta((ItemMeta)itemMeta);
        }
        return itemStack;
    }
    
    private static ItemStack G() {
        final ItemStack itemStack = new ItemStack(Material.PARROT_SPAWN_EGG);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(UiMenuListener1("&#DD00FFPapugi"));
            final ArrayList lore = new ArrayList();
            lore.add(UiMenuListener1("&7"));
            lore.add(UiMenuListener1("&8 » &7W tej kategorii znajdziesz"));
            lore.add(UiMenuListener1("&8 » &7wszystkie &fpapugi&7 na serwerze!"));
            lore.add(UiMenuListener1("&7"));
            lore.add(UiMenuListener1("&#1DFF1A\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a \u1d18\u0280\u1d00\u1d21\u028f\u1d0d, \u1d00\u0299\u028f \u1d18\u0280\u1d22\u1d07\u1d0a\u015b\u0107!"));
            itemMeta.setLore((List)lore);
            itemMeta.addItemFlags(ItemFlag.values());
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    private static ItemStack UiMenuListener1(final String s, final String s2) {
        final ItemStack a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.UiMenuListener1(s, s2);
        final ItemMeta itemMeta = a.getItemMeta();
        if (itemMeta != null) {
            List lore = itemMeta.getLore();
            if (lore == null) {
                lore = new ArrayList();
            }
            lore.add(UiMenuListener1("&7"));
            lore.add(UiMenuListener1("&#0EFF00\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d0f\u1d1b\u0280\u1d22\u028f\u1d0d\u1d00\u0107 \u1d18\u1d07\u1d1b\u1d00!"));
            itemMeta.setLore(lore);
            a.setItemMeta(itemMeta);
        }
        return a;
    }
    
    private static ItemStack UiMenuListener2(final String s, final String s2) {
        final ItemStack a = L.UiMenuListener1(s, s2);
        if (a == null) {
            return new ItemStack(Material.BARRIER);
        }
        final ItemMeta itemMeta = a.getItemMeta();
        if (itemMeta != null) {
            List lore = itemMeta.getLore();
            if (lore == null) {
                lore = new ArrayList();
            }
            lore.add(UiMenuListener1("&7"));
            lore.add(UiMenuListener1("&#0EFF00\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a, \u1d00\u0299\u028f \u1d0f\u1d1b\u0280\u1d22\u028f\u1d0d\u1d00\u0107 \u1d0b\u1d0f\ua731\u1d1b\u026a\u1d1c\u1d0d!"));
            itemMeta.setLore(lore);
            a.setItemMeta(itemMeta);
        }
        return a;
    }
    
    private static ItemStack C() {
        final ItemStack itemStack = new ItemStack(Material.OAK_SIGN);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(UiMenuListener1("&#DD00FFEdycja przedmiot\u00f3w"));
        final ArrayList lore = new ArrayList();
        lore.add(UiMenuListener1("&7"));
        lore.add(UiMenuListener1("&8 » &7W tej kategorii mo\u017cesz edytowa\u0107"));
        lore.add(UiMenuListener1("&8 » &7przedmioty &fkostium\u00f3w &7oraz &fpet\u00f3w&7!"));
        lore.add(UiMenuListener1("&7"));
        lore.add(UiMenuListener1("&#0EFF00\u1d0b\u029f\u026a\u1d0b\u0274\u026a\u1d0a \u1d18\u0280\u1d00\u1d21\u028f\u1d0d, \u1d00\u0299\u028f \u1d18\u0280\u1d22\u1d07\u1d0a\u015b\u0107!"));
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static ItemStack F() {
        final ItemStack itemStack = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(UiMenuListener1("&#FF0000Powr\u00f3t do poprzedniego menu"));
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    private static ItemStack E() {
        final ItemStack itemStack = new ItemStack(Material.LIGHT_BLUE_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(UiMenuListener1("&#1A99FFPoprzednia strona"));
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    private static ItemStack UiMenuListener2() {
        final ItemStack itemStack = new ItemStack(Material.LIME_DYE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(UiMenuListener1("&#1DFF1ANast\u0119pna strona"));
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        final String title = inventoryClickEvent.getView().getTitle();
        final String a = UiMenuListener1("&x&F&F&F&9&1&UiMenuListener1\u26a1 &8\u1d18\u1d00\u0274\u1d07\u029f \u1d18\u1d07\u1d1b\u00f3\u1d21");
        final String a2 = UiMenuListener1("&x&F&F&F&9&1&UiMenuListener1\u26a1 &8\u1d18\u1d00\u0274\u1d07\u029f \u1d0b\u1d0f\ua731\u1d1b\u026a\u1d1c\u1d0d\u00f3\u1d21");
        if (!title.equals(UiMenuListener1("&x&F&F&F&9&1&UiMenuListener1\u26a1 &8\ua731\u1d1b\u1d0f\u0280\u1d0d\ua731\u1d22\u1d00\ua730\u1d0b\u1d00 \u1d201.1")) && !title.startsWith(a) && !title.startsWith(a2)) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if (currentItem == null || currentItem.getType() == Material.AIR) {
            return;
        }
        if (title.equals(UiMenuListener1("&x&F&F&F&9&1&UiMenuListener1\u26a1 &8\ua731\u1d1b\u1d0f\u0280\u1d0d\ua731\u1d22\u1d00\ua730\u1d0b\u1d00 \u1d201.1"))) {
            if (inventoryClickEvent.getSlot() == 11) {
                startTimeInput(player);
            }
            else if (inventoryClickEvent.getSlot() == 12) {
                startCostumeTimeInput(player);
            }
            else if (inventoryClickEvent.getSlot() == 13 && currentItem.getType() == Material.PARROT_SPAWN_EGG) {
                player.sendMessage(UiMenuListener1("&8» &7Ta funkcja zostanie &#FFD300wprowadzona &7w przysz\u0142ej aktualizacji!"));
                player.sendTitle(UiMenuListener1(""), UiMenuListener1("&7Ta funkcja zostanie &#FFD300wprowadzona &7w przysz\u0142ej aktualizacji!"), 10, 60, 15);
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0f, 1.0f);
            }
            else if (inventoryClickEvent.getSlot() == 15 && currentItem.getType() == Material.RED_DYE) {
                pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener3.openFragmentCostEditor(player);
            }
            else if (inventoryClickEvent.getSlot() == 31 && currentItem.getType() == Material.OAK_SIGN) {
                pl.ziffy.STORMSZAFKA.ui.gui.UiMenuListener1.openEditorMenu(player);
            }
        }
        else if (title.startsWith(a)) {
            final int b = this.UiMenuListener2(title);
            String s = pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.UiMenuListener2.getOrDefault(player.getUniqueId(), "INFINITE");
            if (s == null) {
                s = "INFINITE";
            }
            if (inventoryClickEvent.getSlot() == 48) {
                if (b > 1) {
                    openPetsPanel(player, b - 1, s);
                }
            }
            else if (inventoryClickEvent.getSlot() == 49) {
                openMainPanel(player);
            }
            else if (inventoryClickEvent.getSlot() == 50) {
                if (b < (int)Math.ceil(pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.E.size() / 28.0)) {
                    openPetsPanel(player, b + 1, s);
                }
            }
            else {
                this.UiMenuListener1(player, inventoryClickEvent.getSlot(), currentItem, b);
            }
        }
        else if (title.startsWith(a2)) {
            if (pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.F.getOrDefault(player.getUniqueId(), "INFINITE") == null) {}
            if (inventoryClickEvent.getSlot() == 49) {
                openMainPanel(player);
            }
            else {
                this.UiMenuListener1(player, inventoryClickEvent.getSlot(), currentItem);
            }
        }
    }
    
    private int UiMenuListener2(final String s) {
        try {
            final String[] split = s.split(" - Strona ");
            if (split.length == 2) {
                String s2 = split[1];
                if (s2.contains(" (")) {
                    s2 = s2.split(" \\(")[0];
                }
                return Integer.parseInt(s2.trim());
            }
        }
        catch (final NumberFormatException ex) {}
        return 1;
    }
    
    private void UiMenuListener1(final Player player, final int n, final ItemStack itemStack, final int n2) {
        final int[] array = { 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43 };
        int n3 = -1;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == n) {
                n3 = i;
                break;
            }
        }
        if (n3 >= 0) {
            final int n4 = (n2 - 1) * array.length + n3;
            if (n4 < pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.E.size()) {
                final String s = pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.E.get(n4);
                if (!player.hasPermission("stormszafka.admin") && !player.isOp()) {
                    player.sendMessage(UiMenuListener1("&8[&#B300FF\ud83d\udee1&8] &#FB0808Nie masz uprawnie\u0144 &7do otrzymywania pet\u00f3w z panelu!"));
                    return;
                }
                String s2 = pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.UiMenuListener2.getOrDefault(player.getUniqueId(), "INFINITE");
                if (s2 == null) {
                    s2 = "INFINITE";
                }
                final ItemStack a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.UiMenuListener1(s, s2);
                if (player.getInventory().firstEmpty() == -1) {
                    player.getWorld().dropItemNaturally(player.getLocation(), a);
                    player.sendMessage(UiMenuListener1("&8[&#B300FF\ud83d\udee1&8] &7Tw\u00f3j ekwipunek jest &#FB0808pe\u0142ny&7! Przedmiot peta &#08FB0D" + s + " &7zosta\u0142 upuszczony na ziemi\u0119."));
                }
                else {
                    player.getInventory().addItem(new ItemStack[] { a });
                    player.sendMessage(UiMenuListener1("&8[&#B300FF\ud83d\udee1&8] &fOtrzyma\u0142e\u015b &7peta &#08FB0D" + s + " &7do ekwipunku!"));
                }
            }
        }
    }
    
    private void UiMenuListener1(final Player player, final int n, final ItemStack itemStack) {
        final int[] array = { 10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43 };
        int n2 = -1;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == n) {
                n2 = i;
                break;
            }
        }
        if (n2 >= 0 && n2 < pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.UiMenuListener1.size()) {
            final String s = pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.UiMenuListener1.get(n2);
            if (!player.hasPermission("stormszafka.admin") && !player.isOp()) {
                player.sendMessage(UiMenuListener1("&8[&#B300FF\ud83d\udee1&8] &#FB0808Nie masz uprawnie\u0144 &7do otrzymywania kostium\u00f3w z panelu!"));
                return;
            }
            String s2 = pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.F.getOrDefault(player.getUniqueId(), "INFINITE");
            if (s2 == null) {
                s2 = "INFINITE";
            }
            final ItemStack a = L.UiMenuListener1(s, s2);
            if (player.getInventory().firstEmpty() == -1) {
                player.getWorld().dropItemNaturally(player.getLocation(), a);
                player.sendMessage(UiMenuListener1("&8[&#B300FF\ud83d\udee1&8] &7Tw\u00f3j ekwipunek jest &#FB0808pe\u0142ny&7! Przedmiot kostiumu &#08FB0D" + s + " &7zosta\u0142 upuszczony na ziemi\u0119."));
            }
            else {
                player.getInventory().addItem(new ItemStack[] { a });
                player.sendMessage(UiMenuListener1("&8[&#B300FF\ud83d\udee1&8] &fOtrzyma\u0142e\u015b &7kostium &#08FB0D" + s + " &7do ekwipunku!"));
            }
        }
    }
    
    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent asyncPlayerChatEvent) {
        final Player player = asyncPlayerChatEvent.getPlayer();
        final UUID uniqueId = player.getUniqueId();
        final boolean booleanValue = pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.D.getOrDefault(uniqueId, false);
        final boolean booleanValue2 = pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.G.getOrDefault(uniqueId, false);
        if (!booleanValue && !booleanValue2) {
            return;
        }
        asyncPlayerChatEvent.setCancelled(true);
        pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.D.remove(uniqueId);
        pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.G.remove(uniqueId);
        final String trim = asyncPlayerChatEvent.getMessage().trim();
        if (trim.equalsIgnoreCase("anuluj") || trim.equalsIgnoreCase("cancel")) {
            player.sendMessage(UiMenuListener1("&8[&#B300FF\ud83d\udee1&8] &#FB0808Anulowano &7wprowadzanie czasu."));
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> openMainPanel(player2));
            return;
        }
        if (!pl.ziffy.STORMSZAFKA.utils.time.UiMenuListener1.H(trim) && !trim.equalsIgnoreCase("brak")) {
            player.sendMessage(UiMenuListener1("&8[&#B300FF\ud83d\udee1&8] &#FB0808Nieprawid\u0142owy &7format czasu: &f" + trim + "&7!"));
            if (booleanValue) {
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> startTimeInput(player3));
            }
            else {
                Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> startCostumeTimeInput(player4));
            }
            return;
        }
        if (booleanValue) {
            pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.UiMenuListener2.put(uniqueId, trim);
            player.sendMessage(UiMenuListener1("&8[&#B300FF\ud83d\udee1&8] &#08FB0DUstawiono &7czas trwania pet\u00f3w na &f" + trim + "&7!"));
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> openPetsPanel(player5, 1, s));
        }
        else {
            pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2.F.put(uniqueId, trim);
            player.sendMessage(UiMenuListener1("&8[&#B300FF\ud83d\udee1&8] &#08FB0DUstawiono &7czas trwania kostium\u00f3w na &f" + trim + "&7!"));
            Bukkit.getScheduler().runTask((Plugin)Main.getInstance(), () -> openCostumesPanel(player6, s2));
        }
    }
    
    private static void UiMenuListener1(final SkullMeta skullMeta, final String s) {
        pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService2.D(skullMeta, s);
    }
    
    private static String UiMenuListener1(String translateHexColors) {
        if (translateHexColors == null) {
            return null;
        }
        translateHexColors = Main.translateHexColors(translateHexColors);
        return ChatColor.translateAlternateColorCodes('&', translateHexColors);
    }
    
    static {
        UiMenuListener2 = new HashMap<UUID, String>();
        F = new HashMap<UUID, String>();
        D = new HashMap<UUID, Boolean>();
        G = new HashMap<UUID, Boolean>();
        E = Arrays.asList("aniolek", "balwanek", "biznesmenik", "bobas", "cukiereczek", "cyber-obronca", "discordzik", "drakula", "duszek", "elfik", "enderman", "eustachy", "glodomorek", "golemik", "leniuszek", "nietoperek", "paczus", "pajak", "pancernik", "pedziwiatr", "pierniczek", "pisklak", "pudzianek", "reniferek", "rozdymek", "skalniaczek", "sowa", "telekrolik", "zajaczek");
        UiMenuListener1 = Arrays.asList("malyurwis", "mima", "nurekglebinowy", "pirata", "przeciwzakazeniowy", "walentynkowy", "wampir", "zabojczykrolik");
    }
}
