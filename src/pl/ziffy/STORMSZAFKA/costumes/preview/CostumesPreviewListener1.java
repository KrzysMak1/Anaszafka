// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.preview;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.configuration.file.FileConfiguration;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.ChatColor;
import java.util.Collection;
import java.util.ArrayList;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import java.util.Iterator;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.List;
import java.util.Map;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.ziffy.STORMSZAFKA.ui.gui.UiGuiView1;
import org.bukkit.event.Listener;

public class CostumesPreviewListener1 implements Listener
{
    private static B CostumesPreviewListener1;
    
    public static void setConfigManager(final B a) {
        pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1 = a;
    }
    
    public static void openPreviewMenu(final Player player) {
        int h = 54;
        String r = "§8Lista kostium\u00f3w";
        if (pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1 != null) {
            h = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.H();
            r = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.R();
        }
        final Inventory inventory = Bukkit.createInventory((InventoryHolder)null, h, r);
        if (pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1 != null) {
            final Map<List<Integer>, ItemStack> e = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.E();
            if (e != null) {
                for (final Map.Entry entry : e.entrySet()) {
                    for (final Integer n : (List)entry.getKey()) {
                        if (n >= 0 && n < h) {
                            inventory.setItem((int)n, (ItemStack)entry.getValue());
                        }
                    }
                }
            }
        }
        else {
            CostumesPreviewListener1(inventory);
        }
        CostumesPreviewListener1(inventory, player);
        if (pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1 != null) {
            final ItemStack c = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("return");
            final int e2 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.E("return", 49);
            if (c != null) {
                inventory.setItem(e2, c);
            }
            else {
                inventory.setItem(49, CostumesPreviewListener1());
            }
        }
        else {
            inventory.setItem(49, CostumesPreviewListener1());
        }
        player.openInventory(inventory);
    }
    
    private static void CostumesPreviewListener1(final Inventory inventory) {
        final ItemStack itemStack = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(" ");
        itemStack.setItemMeta(itemMeta);
        for (int i = 0; i < 9; ++i) {
            inventory.setItem(i, itemStack);
        }
        for (int j = 45; j < 54; ++j) {
            inventory.setItem(j, itemStack);
        }
        for (int k = 9; k < 45; k += 9) {
            inventory.setItem(k, itemStack);
            inventory.setItem(k + 8, itemStack);
        }
    }
    
    private static void CostumesPreviewListener1(final Inventory inventory, final Player player) {
        int c = 22;
        int c2 = 20;
        int c3 = 21;
        int c4 = 23;
        int c5 = 24;
        int c6 = 30;
        int c7 = 32;
        int c8 = 31;
        if (pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1 != null) {
            c = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("zabojczykrolik", 22);
            c2 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("walentynkowy", 20);
            c3 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("przeciwzakazeniowy", 21);
            c4 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("malyurwis", 23);
            c5 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("pirata", 24);
            c6 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("nurekglebinowy", 30);
            c7 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("wampir", 32);
            c8 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("mima", 31);
        }
        final ItemStack e = L.E("zabojczykrolik");
        if (e != null) {
            inventory.setItem(c, CostumesPreviewListener1(e, "zabojczykrolik"));
        }
        final ItemStack e2 = L.E("walentynkowy");
        if (e2 != null) {
            inventory.setItem(c2, CostumesPreviewListener1(e2, "walentynkowy"));
        }
        final ItemStack e3 = L.E("przeciwzakazeniowy");
        if (e3 != null) {
            inventory.setItem(c3, CostumesPreviewListener1(e3, "przeciwzakazeniowy"));
        }
        final ItemStack e4 = L.E("malyurwis");
        if (e4 != null) {
            inventory.setItem(c4, CostumesPreviewListener1(e4, "malyurwis"));
        }
        final ItemStack e5 = L.E("pirata");
        if (e5 != null) {
            inventory.setItem(c5, CostumesPreviewListener1(e5, "pirata"));
        }
        final ItemStack e6 = L.E("nurekglebinowy");
        if (e6 != null) {
            inventory.setItem(c6, CostumesPreviewListener1(e6, "nurekglebinowy"));
        }
        final ItemStack e7 = L.E("wampir");
        if (e7 != null) {
            inventory.setItem(c7, CostumesPreviewListener1(e7, "wampir"));
        }
        final ItemStack e8 = L.E("mima");
        if (e8 != null) {
            inventory.setItem(c8, CostumesPreviewListener1(e8, "mima"));
        }
    }
    
    private static ItemStack CostumesPreviewListener1(final ItemStack itemStack) {
        return CostumesPreviewListener1(itemStack, null);
    }
    
    private static ItemStack CostumesPreviewListener1(final ItemStack itemStack, final String s) {
        if (itemStack == null) {
            return null;
        }
        final ItemStack clone = itemStack.clone();
        final ItemMeta itemMeta = clone.getItemMeta();
        if (itemMeta != null) {
            ArrayList lore;
            if (itemMeta.hasLore()) {
                lore = new ArrayList(itemMeta.getLore());
                lore.removeIf(s2 -> {
                    ChatColor.stripColor(s2);
                    final String s3;
                    return s3.contains("Kliknij prawym") || s3.contains("Click to activate");
                });
            }
            else {
                lore = new ArrayList();
            }
            if (s != null) {
                final int c = L.C(s);
                final FileConfiguration config = Main.getInstance().getConfig();
                final String string = config.getString("costumes.preview.extension_cost_prefix", "");
                final String string2 = config.getString("costumes.preview.extension_cost_line", "&7Koszt przed\u0142u\u017cenia: &c{cost}$ na dzie\u0144");
                if (string != null && !string.isEmpty()) {
                    lore.add(CostumesPreviewListener1(string));
                }
                else {
                    lore.add("");
                }
                lore.add(CostumesPreviewListener1(string2.replace("{cost}", String.valueOf(c))));
            }
            itemMeta.setLore((List)lore);
            clone.setItemMeta(itemMeta);
        }
        return clone;
    }
    
    private static ItemStack CostumesPreviewListener1() {
        final ItemStack itemStack = new ItemStack(Material.BARRIER);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(CostumesPreviewListener1("&#FF0000Powr\u00f3t do poprzedniego menu"));
        itemMeta.addItemFlags(ItemFlag.values());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    
    private static String CostumesPreviewListener1(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = Pattern.compile("&#([CostumesPreviewListener1-Fa-f0-9]{6})").matcher(s);
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
    
    @EventHandler
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        String r = "§8Lista kostium\u00f3w";
        if (pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1 != null) {
            r = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.R();
        }
        if (!inventoryClickEvent.getView().getTitle().equals(r)) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if (currentItem == null) {
            return;
        }
        int e = 49;
        if (pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1 != null) {
            e = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.E("return", 49);
        }
        int c = 22;
        int c2 = 20;
        int c3 = 21;
        int c4 = 23;
        int c5 = 24;
        int c6 = 30;
        int c7 = 32;
        int c8 = 33;
        if (pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1 != null) {
            c = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("zabojczykrolik", 22);
            c2 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("walentynkowy", 20);
            c3 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("przeciwzakazeniowy", 21);
            c4 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("malyurwis", 23);
            c5 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("pirata", 24);
            c6 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("nurekglebinowy", 30);
            c7 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("wampir", 32);
            c8 = pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.CostumesPreviewListener1.C("mima", 33);
        }
        final int rawSlot = inventoryClickEvent.getRawSlot();
        if (rawSlot == e) {
            pl.ziffy.STORMSZAFKA.ui.menu.CostumesPreviewListener1.openMainMenu(player);
            return;
        }
        if (rawSlot != c || currentItem.getType() != Material.BLACK_STAINED_GLASS_PANE) {}
        if (rawSlot != c2 || currentItem.getType() != Material.BLACK_STAINED_GLASS_PANE) {}
        if (rawSlot != c3 || currentItem.getType() != Material.BLACK_STAINED_GLASS_PANE) {}
        if (rawSlot != c4 || currentItem.getType() != Material.BLACK_STAINED_GLASS_PANE) {}
        if (rawSlot != c5 || currentItem.getType() != Material.BLACK_STAINED_GLASS_PANE) {}
        if (rawSlot != c6 || currentItem.getType() != Material.BLACK_STAINED_GLASS_PANE) {}
        if (rawSlot != c7 || currentItem.getType() != Material.BLACK_STAINED_GLASS_PANE) {}
        if (rawSlot != c8 || currentItem.getType() != Material.BLACK_STAINED_GLASS_PANE) {}
    }
}
