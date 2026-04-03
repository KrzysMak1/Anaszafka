// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.EquipmentSlot;
import java.util.UUID;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.inventory.ItemFlag;
import pl.ziffy.STORMSZAFKA.costumes.items.D;
import pl.ziffy.STORMSZAFKA.costumes.items.F;
import pl.ziffy.STORMSZAFKA.costumes.items.B;
import pl.ziffy.STORMSZAFKA.costumes.items.H;
import pl.ziffy.STORMSZAFKA.costumes.items.G;
import org.bukkit.Color;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
import java.util.Map;
import java.util.HashMap;
import pl.ziffy.STORMSZAFKA.data.E;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Sound;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.FixedMetadataValue;
import java.util.Iterator;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.GameMode;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;

public class A implements Listener
{
    private final Plugin A;
    
    public A(final Plugin a) {
        this.A = a;
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerInteractBlockArmor(final PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR && playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (!L.F(playerInteractEvent.getPlayer())) {
            return;
        }
        final ItemStack item = playerInteractEvent.getItem();
        if (item == null) {
            return;
        }
        final Material type = item.getType();
        if ((type == Material.PLAYER_HEAD || type == Material.LEATHER_HELMET || type == Material.LEATHER_CHESTPLATE || type == Material.LEATHER_LEGGINGS || type == Material.LEATHER_BOOTS) && (this.E(item) || this.B(item))) {
            playerInteractEvent.setCancelled(true);
            Bukkit.getScheduler().runTaskLater(this.A, () -> this.Q(player), 1L);
        }
    }
    
    private void Q(final Player player) {
        final ItemStack helmet = player.getInventory().getHelmet();
        final ItemStack chestplate = player.getInventory().getChestplate();
        final ItemStack leggings = player.getInventory().getLeggings();
        final ItemStack boots = player.getInventory().getBoots();
        if (helmet != null && helmet.getType() == Material.PLAYER_HEAD && !this.D(helmet)) {
            player.getInventory().setHelmet((ItemStack)null);
        }
        if (helmet != null && (this.E(helmet) || this.B(helmet))) {
            player.getInventory().setHelmet((ItemStack)null);
        }
        if (chestplate != null && (this.E(chestplate) || this.B(chestplate))) {
            player.getInventory().setChestplate((ItemStack)null);
        }
        if (leggings != null && (this.E(leggings) || this.B(leggings))) {
            player.getInventory().setLeggings((ItemStack)null);
        }
        if (boots != null && (this.E(boots) || this.B(boots))) {
            player.getInventory().setBoots((ItemStack)null);
        }
    }
    
    private boolean E(final ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() != Material.PLAYER_HEAD) {
            return false;
        }
        if (!itemStack.hasItemMeta()) {
            return false;
        }
        try {
            if (itemStack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(this.A, "pet_type"), PersistentDataType.STRING)) {
                return true;
            }
        }
        catch (final Exception ex) {}
        return itemStack.getItemMeta().hasDisplayName() && ChatColor.stripColor(itemStack.getItemMeta().getDisplayName()).toLowerCase().contains("pet");
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        if (!L.F(player)) {
            return;
        }
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        final ItemStack cursor = inventoryClickEvent.getCursor();
        if (player.getGameMode() == GameMode.CREATIVE && currentItem != null && this.D(currentItem)) {
            final InventoryAction action = inventoryClickEvent.getAction();
            if (action == InventoryAction.CLONE_STACK || action == InventoryAction.PICKUP_ALL || action == InventoryAction.PICKUP_HALF || action == InventoryAction.PICKUP_ONE || action == InventoryAction.PICKUP_SOME) {
                inventoryClickEvent.setCancelled(true);
                player.setItemOnCursor((ItemStack)null);
                return;
            }
        }
        if (this.B(inventoryClickEvent.getSlot()) && cursor != null && (this.B(cursor) || this.E(cursor))) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if ((inventoryClickEvent.getClick() == ClickType.SHIFT_LEFT || inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT) && currentItem != null && (this.E(currentItem) || this.B(currentItem))) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if (inventoryClickEvent.getClick() == ClickType.NUMBER_KEY && this.B(inventoryClickEvent.getSlot())) {
            final ItemStack item = player.getInventory().getItem(inventoryClickEvent.getHotbarButton());
            if (item != null && (this.E(item) || this.B(item))) {
                inventoryClickEvent.setCancelled(true);
                return;
            }
        }
        final String s = (currentItem != null && currentItem.hasItemMeta() && currentItem.getItemMeta().hasDisplayName()) ? currentItem.getItemMeta().getDisplayName() : ((currentItem != null) ? currentItem.getType().name() : "null");
        final String s2 = (cursor != null && cursor.hasItemMeta() && cursor.getItemMeta().hasDisplayName()) ? cursor.getItemMeta().getDisplayName() : ((cursor != null) ? cursor.getType().name() : "null");
        final boolean b = (currentItem != null && (currentItem.getType() == Material.LEATHER_HELMET || currentItem.getType() == Material.LEATHER_CHESTPLATE || currentItem.getType() == Material.LEATHER_LEGGINGS || currentItem.getType() == Material.LEATHER_BOOTS || currentItem.getType() == Material.PLAYER_HEAD)) || (cursor != null && (cursor.getType() == Material.LEATHER_HELMET || cursor.getType() == Material.LEATHER_CHESTPLATE || cursor.getType() == Material.LEATHER_LEGGINGS || cursor.getType() == Material.LEATHER_BOOTS || cursor.getType() == Material.PLAYER_HEAD));
        final boolean b2 = inventoryClickEvent.getView().getType() == InventoryType.PLAYER || inventoryClickEvent.getView().getType() == InventoryType.CRAFTING;
        if (this.B(inventoryClickEvent.getSlot()) && this.D(currentItem)) {
            final InventoryAction action2 = inventoryClickEvent.getAction();
            if (action2 == InventoryAction.MOVE_TO_OTHER_INVENTORY || action2 == InventoryAction.HOTBAR_SWAP || action2 == InventoryAction.SWAP_WITH_CURSOR || action2 == InventoryAction.COLLECT_TO_CURSOR) {
                inventoryClickEvent.setCancelled(true);
                return;
            }
        }
        if (this.B(inventoryClickEvent.getSlot()) && this.D(currentItem)) {
            this.A(inventoryClickEvent, player);
            return;
        }
        if (!this.B(inventoryClickEvent.getSlot()) || currentItem != null) {}
        if (this.B(inventoryClickEvent.getSlot()) && cursor != null && this.F(cursor) && !this.D(cursor)) {
            final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
            if (playerArmorSnapshot != null && this.A(cursor, inventoryClickEvent.getSlot())) {
                inventoryClickEvent.setCancelled(true);
                this.A(inventoryClickEvent, player, playerArmorSnapshot);
                return;
            }
        }
        if (!this.B(inventoryClickEvent.getSlot()) && currentItem != null && this.D(currentItem) && !this.B(currentItem)) {
            inventoryClickEvent.setCancelled(true);
            player.setItemOnCursor((ItemStack)null);
            Bukkit.getScheduler().runTaskLater(this.A, () -> this.C(player2), 1L);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryDrag(final InventoryDragEvent inventoryDragEvent) {
        if (!(inventoryDragEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryDragEvent.getWhoClicked();
        if (!L.F(player)) {
            return;
        }
        for (final int intValue : inventoryDragEvent.getRawSlots()) {
            if (intValue >= 5 && intValue <= 8) {
                int n = -1;
                switch (intValue) {
                    case 5: {
                        n = 39;
                        break;
                    }
                    case 6: {
                        n = 38;
                        break;
                    }
                    case 7: {
                        n = 37;
                        break;
                    }
                    case 8: {
                        n = 36;
                        break;
                    }
                }
                if (n != -1 && this.D(player.getInventory().getItem(n))) {
                    inventoryDragEvent.setCancelled(true);
                    return;
                }
                continue;
            }
        }
    }
    
    private void A(final InventoryClickEvent inventoryClickEvent, final Player player) {
        if (!player.hasMetadata("costume_inventory_open")) {
            player.setMetadata("costume_inventory_open", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
        }
        if (!player.hasMetadata("costume_survival_inventory")) {
            player.setMetadata("costume_survival_inventory", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
        }
        final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
        if (playerArmorSnapshot == null) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if ((inventoryClickEvent.getClick() == ClickType.SHIFT_LEFT || inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT) && currentItem != null && !this.D(currentItem) && (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory"))) {
            final int slot = inventoryClickEvent.getSlot();
            currentItem.clone();
            switch (inventoryClickEvent.getSlot()) {
                case 39: {
                    playerArmorSnapshot.A(null);
                    break;
                }
                case 38: {
                    playerArmorSnapshot.D(null);
                    break;
                }
                case 37: {
                    playerArmorSnapshot.B(null);
                    break;
                }
                case 36: {
                    playerArmorSnapshot.C(null);
                    break;
                }
            }
            this.P(player);
            inventoryClickEvent.setCancelled(true);
            player.getInventory().setItem(slot, (ItemStack)null);
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                this.C(player2, itemStack);
                player2.playSound(player2.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.5f, 1.0f);
                return;
            }, 1L);
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                if (player3.isOnline() && L.F(player3)) {
                    this.G(player3, J.getPlayerArmorSnapshot(player3.getUniqueId()));
                }
            }, 2L);
            return;
        }
        if (inventoryClickEvent.getCursor() != null && !inventoryClickEvent.getCursor().getType().equals((Object)Material.AIR)) {
            this.A(inventoryClickEvent, player, playerArmorSnapshot);
            return;
        }
        switch (inventoryClickEvent.getSlot()) {
            case 39: {}
            case 38: {}
            case 37: {}
        }
        final boolean b = currentItem != null && this.D(currentItem);
        final boolean b2 = playerArmorSnapshot.C() != null;
        final boolean b3 = playerArmorSnapshot.E() != null;
        final boolean b4 = playerArmorSnapshot.B() != null;
        final boolean b5 = playerArmorSnapshot.A() != null;
        if (b) {
            player.setMetadata("costume_toggle_helmet", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
            player.setMetadata("costume_toggle_chestplate", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
            player.setMetadata("costume_toggle_leggings", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
            player.setMetadata("costume_toggle_boots", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
            player.setMetadata("costume_edit_mode", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
            if (b2) {
                player.getInventory().setHelmet(this.G(playerArmorSnapshot.C()));
            }
            else {
                player.getInventory().setHelmet((ItemStack)null);
            }
            if (b3) {
                player.getInventory().setChestplate(this.G(playerArmorSnapshot.E()));
            }
            else {
                player.getInventory().setChestplate((ItemStack)null);
            }
            if (b4) {
                player.getInventory().setLeggings(this.G(playerArmorSnapshot.B()));
            }
            else {
                player.getInventory().setLeggings((ItemStack)null);
            }
            if (b5) {
                player.getInventory().setBoots(this.G(playerArmorSnapshot.A()));
            }
            else {
                player.getInventory().setBoots((ItemStack)null);
            }
        }
        else {
            if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
                if (player.hasMetadata("costume_toggle_helmet")) {
                    player.removeMetadata("costume_toggle_helmet", this.A);
                }
                if (player.hasMetadata("costume_toggle_chestplate")) {
                    player.removeMetadata("costume_toggle_chestplate", this.A);
                }
                if (player.hasMetadata("costume_toggle_leggings")) {
                    player.removeMetadata("costume_toggle_leggings", this.A);
                }
                if (player.hasMetadata("costume_toggle_boots")) {
                    player.removeMetadata("costume_toggle_boots", this.A);
                }
                if (player.hasMetadata("costume_edit_mode")) {
                    player.removeMetadata("costume_edit_mode", this.A);
                    if (L.F(player)) {
                        final C a = L.A(player);
                        if (a != null && a.getType().equals("zabojczykrolik")) {
                            player.sendMessage("§7Wy\u0142\u0105czono tryb edycji zbroi.");
                        }
                    }
                }
            }
            if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
                if (playerArmorSnapshot.C() != null) {
                    player.getInventory().setHelmet(playerArmorSnapshot.C().clone());
                }
                else {
                    player.getInventory().setHelmet(this.A(Material.LEATHER_HELMET, player));
                }
                if (!playerArmorSnapshot.D()) {
                    if (playerArmorSnapshot.E() != null) {
                        player.getInventory().setChestplate(playerArmorSnapshot.E().clone());
                    }
                    else {
                        player.getInventory().setChestplate(this.A(Material.LEATHER_CHESTPLATE, player));
                    }
                }
                if (playerArmorSnapshot.B() != null) {
                    player.getInventory().setLeggings(playerArmorSnapshot.B().clone());
                }
                else {
                    player.getInventory().setLeggings(this.A(Material.LEATHER_LEGGINGS, player));
                }
                if (playerArmorSnapshot.A() != null) {
                    player.getInventory().setBoots(playerArmorSnapshot.A().clone());
                }
                else {
                    player.getInventory().setBoots(this.A(Material.LEATHER_BOOTS, player));
                }
            }
            else {
                player.getInventory().setHelmet(this.A(Material.LEATHER_HELMET, player));
                if (!playerArmorSnapshot.D()) {
                    player.getInventory().setChestplate(this.A(Material.LEATHER_CHESTPLATE, player));
                }
                player.getInventory().setLeggings(this.A(Material.LEATHER_LEGGINGS, player));
                player.getInventory().setBoots(this.A(Material.LEATHER_BOOTS, player));
            }
        }
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        if (!b && player.getGameMode() != GameMode.CREATIVE) {
            Bukkit.getScheduler().runTaskLater(this.A, () -> this.A(player4, i), 1L);
        }
    }
    
    private void A(final InventoryClickEvent inventoryClickEvent, final Player player, final I i) {
        final ItemStack cursor = inventoryClickEvent.getCursor();
        if (cursor == null || cursor.getType() == Material.AIR) {
            switch (inventoryClickEvent.getSlot()) {
                case 39: {
                    i.A(null);
                    if (player.hasMetadata("costume_toggle_helmet")) {
                        player.removeMetadata("costume_toggle_helmet", this.A);
                        break;
                    }
                    break;
                }
                case 38: {
                    i.D(null);
                    if (player.hasMetadata("costume_toggle_chestplate")) {
                        player.removeMetadata("costume_toggle_chestplate", this.A);
                        break;
                    }
                    break;
                }
                case 37: {
                    i.B(null);
                    if (player.hasMetadata("costume_toggle_leggings")) {
                        player.removeMetadata("costume_toggle_leggings", this.A);
                        break;
                    }
                    break;
                }
                case 36: {
                    i.C(null);
                    if (player.hasMetadata("costume_toggle_boots")) {
                        player.removeMetadata("costume_toggle_boots", this.A);
                        break;
                    }
                    break;
                }
            }
            this.P(player);
            inventoryClickEvent.setCancelled(false);
            Bukkit.getScheduler().runTaskLater(this.A, () -> this.C(player2), 1L);
            if (player.getGameMode() != GameMode.CREATIVE) {
                Bukkit.getScheduler().runTaskLater(this.A, () -> this.A(player3, j), 1L);
            }
            return;
        }
        if (!this.F(cursor) || !this.A(cursor, inventoryClickEvent.getSlot())) {
            return;
        }
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if (currentItem != null && cursor != null && currentItem.getType() == cursor.getType()) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack itemStack = (cursor != null) ? cursor.clone() : null;
        if (itemStack != null) {
            itemStack.setAmount(1);
        }
        switch (inventoryClickEvent.getSlot()) {
            case 39: {
                i.A(itemStack);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_helmet")) {
                    player.removeMetadata("costume_toggle_helmet", this.A);
                    break;
                }
                break;
            }
            case 38: {
                i.D(itemStack);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_chestplate")) {
                    player.removeMetadata("costume_toggle_chestplate", this.A);
                    break;
                }
                break;
            }
            case 37: {
                i.B(itemStack);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_leggings")) {
                    player.removeMetadata("costume_toggle_leggings", this.A);
                    break;
                }
                break;
            }
            case 36: {
                i.C(itemStack);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_boots")) {
                    player.removeMetadata("costume_toggle_boots", this.A);
                    break;
                }
                break;
            }
        }
        this.P(player);
        if (cursor.getAmount() > 1) {
            cursor.setAmount(cursor.getAmount() - 1);
            player.getOpenInventory().setCursor(cursor);
            final ItemStack g = this.G(itemStack);
            if (g != null) {
                g.setAmount(1);
                player.getInventory().setItem(inventoryClickEvent.getSlot(), g);
            }
        }
        else {
            player.getInventory().setItem(inventoryClickEvent.getSlot(), this.G(itemStack));
            player.getOpenInventory().setCursor((ItemStack)null);
        }
        if (currentItem != null && currentItem.getType() != Material.AIR) {
            this.C(player, this.G(currentItem));
        }
        if (player.getGameMode() != GameMode.CREATIVE && !player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            Bukkit.getScheduler().runTaskLater(this.A, () -> this.A(player4, k), 1L);
        }
        Bukkit.getScheduler().runTaskLater(this.A, () -> this.C(player5), 2L);
        if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                if (player6.isOnline() && L.F(player6)) {
                    J.getPlayerArmorSnapshot(player6.getUniqueId());
                    final I l;
                    if (l != null) {
                        this.G(player6, l);
                        Main.getInstance();
                        final Main main;
                        if (main != null) {
                            main.getCostumeDataManager();
                            final E e;
                            if (e != null) {
                                e.B(player6);
                            }
                        }
                    }
                }
            }, 5L);
        }
    }
    
    private void A(final Player player, final I i) {
        final HashMap hashMap = new HashMap();
        this.A(i, hashMap);
        this.A(player, i, hashMap);
    }
    
    private void A(final I i, final Map<Material, Map<Enchantment, Integer>> map) {
        if (i.C() != null && i.C().hasItemMeta() && i.C().getItemMeta().hasEnchants()) {
            map.put(Material.LEATHER_HELMET, (HashMap)new HashMap(i.C().getEnchantments()));
        }
        if (i.E() != null && i.E().hasItemMeta() && i.E().getItemMeta().hasEnchants()) {
            map.put(Material.LEATHER_CHESTPLATE, (HashMap)new HashMap(i.E().getEnchantments()));
        }
        if (i.B() != null && i.B().hasItemMeta() && i.B().getItemMeta().hasEnchants()) {
            map.put(Material.LEATHER_LEGGINGS, (HashMap)new HashMap(i.B().getEnchantments()));
        }
        if (i.A() != null && i.A().hasItemMeta() && i.A().getItemMeta().hasEnchants()) {
            map.put(Material.LEATHER_BOOTS, (HashMap)new HashMap(i.A().getEnchantments()));
        }
    }
    
    private void B(final I i, final Map<Material, Map<Enchantment, Integer>> map) {
        if (i.C() != null && map.containsKey(Material.LEATHER_HELMET)) {
            final ItemStack c = i.C();
            final ItemMeta itemMeta = c.getItemMeta();
            for (final Map.Entry entry : map.get(Material.LEATHER_HELMET).entrySet()) {
                if (!itemMeta.hasEnchant((Enchantment)entry.getKey())) {
                    itemMeta.addEnchant((Enchantment)entry.getKey(), (int)entry.getValue(), true);
                }
            }
            c.setItemMeta(itemMeta);
            i.A(c);
        }
        if (i.E() != null && map.containsKey(Material.LEATHER_CHESTPLATE)) {
            final ItemStack e = i.E();
            final ItemMeta itemMeta2 = e.getItemMeta();
            for (final Map.Entry entry2 : map.get(Material.LEATHER_CHESTPLATE).entrySet()) {
                if (!itemMeta2.hasEnchant((Enchantment)entry2.getKey())) {
                    itemMeta2.addEnchant((Enchantment)entry2.getKey(), (int)entry2.getValue(), true);
                }
            }
            e.setItemMeta(itemMeta2);
            i.D(e);
        }
        if (i.B() != null && map.containsKey(Material.LEATHER_LEGGINGS)) {
            final ItemStack b = i.B();
            final ItemMeta itemMeta3 = b.getItemMeta();
            for (final Map.Entry entry3 : map.get(Material.LEATHER_LEGGINGS).entrySet()) {
                if (!itemMeta3.hasEnchant((Enchantment)entry3.getKey())) {
                    itemMeta3.addEnchant((Enchantment)entry3.getKey(), (int)entry3.getValue(), true);
                }
            }
            b.setItemMeta(itemMeta3);
            i.B(b);
        }
        if (i.A() != null && map.containsKey(Material.LEATHER_BOOTS)) {
            final ItemStack a = i.A();
            final ItemMeta itemMeta4 = a.getItemMeta();
            for (final Map.Entry entry4 : map.get(Material.LEATHER_BOOTS).entrySet()) {
                if (!itemMeta4.hasEnchant((Enchantment)entry4.getKey())) {
                    itemMeta4.addEnchant((Enchantment)entry4.getKey(), (int)entry4.getValue(), true);
                }
            }
            a.setItemMeta(itemMeta4);
            i.C(a);
        }
    }
    
    private ItemStack A(final Material material, final ItemStack itemStack, final Map<Enchantment, Integer> map, final Player player) {
        final ItemStack a = this.A(material, itemStack, player);
        if (map != null && !map.isEmpty()) {
            final ItemMeta itemMeta = a.getItemMeta();
            for (final Map.Entry entry : map.entrySet()) {
                itemMeta.addEnchant((Enchantment)entry.getKey(), (int)entry.getValue(), true);
            }
            a.setItemMeta(itemMeta);
        }
        return a;
    }
    
    private void A(final Player player, final I i, final Map<Material, Map<Enchantment, Integer>> map) {
        if (!L.F(player)) {
            return;
        }
        if (player.hasMetadata("costume_toggle_helmet") || player.hasMetadata("costume_toggle_chestplate") || player.hasMetadata("costume_toggle_leggings") || player.hasMetadata("costume_toggle_boots")) {
            return;
        }
        if (player.isSneaking() || player.hasMetadata("costume_sneaking")) {
            return;
        }
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        final ItemStack helmet = player.getInventory().getHelmet();
        final ItemStack chestplate = player.getInventory().getChestplate();
        final ItemStack leggings = player.getInventory().getLeggings();
        final ItemStack boots = player.getInventory().getBoots();
        final ItemStack a = this.A(Material.LEATHER_HELMET, i.C(), map.getOrDefault(Material.LEATHER_HELMET, (HashMap)new HashMap()), player);
        final ItemStack a2 = this.A(Material.LEATHER_CHESTPLATE, i.E(), map.getOrDefault(Material.LEATHER_CHESTPLATE, (HashMap)new HashMap()), player);
        final ItemStack a3 = this.A(Material.LEATHER_LEGGINGS, i.B(), map.getOrDefault(Material.LEATHER_LEGGINGS, (HashMap)new HashMap()), player);
        final ItemStack a4 = this.A(Material.LEATHER_BOOTS, i.A(), map.getOrDefault(Material.LEATHER_BOOTS, (HashMap)new HashMap()), player);
        if (helmet == null || this.D(helmet)) {
            player.getInventory().setHelmet(a);
        }
        if (!i.D() && (chestplate == null || this.D(chestplate))) {
            player.getInventory().setChestplate(a2);
        }
        if (leggings == null || this.D(leggings)) {
            player.getInventory().setLeggings(a3);
        }
        if (boots == null || this.D(boots)) {
            player.getInventory().setBoots(a4);
        }
    }
    
    private void A(final Player player, final ItemStack currentItem, final int n, final I i, final InventoryClickEvent inventoryClickEvent) {
        ItemStack itemStack = null;
        switch (n) {
            case 39: {
                itemStack = player.getInventory().getHelmet();
                break;
            }
            case 38: {
                itemStack = player.getInventory().getChestplate();
                break;
            }
            case 37: {
                itemStack = player.getInventory().getLeggings();
                break;
            }
            case 36: {
                itemStack = player.getInventory().getBoots();
                break;
            }
        }
        if (itemStack != null && itemStack.getType() == currentItem.getType()) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if (itemStack != null && currentItem != null && itemStack.getType() == currentItem.getType()) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if (inventoryClickEvent.getClick() == ClickType.SHIFT_LEFT && this.B(n) && !this.D(currentItem) && (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory"))) {
            inventoryClickEvent.setCancelled(true);
            currentItem.clone();
            switch (n) {
                case 39: {
                    i.A(null);
                    break;
                }
                case 38: {
                    i.D(null);
                    break;
                }
                case 37: {
                    i.B(null);
                    break;
                }
                case 36: {
                    i.C(null);
                    break;
                }
            }
            this.P(player);
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                player2.getInventory().setItem(n2, (ItemStack)null);
                this.C(player2, itemStack2);
                player2.playSound(player2.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.5f, 1.0f);
            }, 1L);
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack g = this.G(currentItem);
        if (g != null) {
            g.setAmount(1);
        }
        switch (n) {
            case 39: {
                i.A(g);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_helmet")) {
                    player.removeMetadata("costume_toggle_helmet", this.A);
                    break;
                }
                break;
            }
            case 38: {
                i.D(g);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_chestplate")) {
                    player.removeMetadata("costume_toggle_chestplate", this.A);
                    break;
                }
                break;
            }
            case 37: {
                i.B(g);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_leggings")) {
                    player.removeMetadata("costume_toggle_leggings", this.A);
                    break;
                }
                break;
            }
            case 36: {
                i.C(g);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_boots")) {
                    player.removeMetadata("costume_toggle_boots", this.A);
                    break;
                }
                break;
            }
        }
        this.P(player);
        player.getInventory().setItem(n, this.G(g));
        if (currentItem.getAmount() > 1) {
            currentItem.setAmount(currentItem.getAmount() - 1);
            inventoryClickEvent.setCurrentItem(currentItem);
        }
        else {
            inventoryClickEvent.setCurrentItem((ItemStack)null);
        }
        if (itemStack != null && itemStack.getType() != Material.AIR) {
            this.C(player, this.G(itemStack));
        }
        Bukkit.getScheduler().runTaskLater(this.A, () -> this.C(player3), 2L);
        if (player.getGameMode() != GameMode.CREATIVE && !player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            Bukkit.getScheduler().runTaskLater(this.A, () -> this.A(player4, j), 1L);
        }
        if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                if (player5.isOnline() && L.F(player5)) {
                    J.getPlayerArmorSnapshot(player5.getUniqueId());
                    final I k;
                    if (k != null) {
                        this.G(player5, k);
                        Main.getInstance();
                        final Main main;
                        if (main != null) {
                            main.getCostumeDataManager();
                            final E e;
                            if (e != null) {
                                e.B(player5);
                            }
                        }
                    }
                }
            }, 5L);
        }
    }
    
    private void A(final Player player, final int n, final I i) {
        boolean b = true;
        switch (n) {
            case 39: {
                b = !player.hasMetadata("costume_toggle_helmet");
                break;
            }
            case 38: {
                b = !player.hasMetadata("costume_toggle_chestplate");
                break;
            }
            case 37: {
                b = !player.hasMetadata("costume_toggle_leggings");
                break;
            }
            case 36: {
                b = !player.hasMetadata("costume_toggle_boots");
                break;
            }
        }
        ItemStack itemStack = null;
        switch (n) {
            case 39: {
                itemStack = i.C();
                break;
            }
            case 38: {
                itemStack = i.E();
                break;
            }
            case 37: {
                itemStack = i.B();
                break;
            }
            case 36: {
                itemStack = i.A();
                break;
            }
        }
        if (b) {
            if (itemStack != null) {
                switch (n) {
                    case 39: {
                        player.setMetadata("costume_toggle_helmet", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
                        player.getInventory().setHelmet(this.G(itemStack));
                        break;
                    }
                    case 38: {
                        player.setMetadata("costume_toggle_chestplate", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
                        player.getInventory().setChestplate(this.G(itemStack));
                        break;
                    }
                    case 37: {
                        player.setMetadata("costume_toggle_leggings", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
                        player.getInventory().setLeggings(this.G(itemStack));
                        break;
                    }
                    case 36: {
                        player.setMetadata("costume_toggle_boots", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
                        player.getInventory().setBoots(this.G(itemStack));
                        break;
                    }
                }
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.5f);
            }
            else {
                switch (n) {
                    case 39: {}
                    case 38: {}
                    case 37: {}
                }
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 0.5f);
            }
        }
        else {
            if (!player.hasMetadata("costume_inventory_open")) {
                if (!player.hasMetadata("costume_survival_inventory")) {
                    switch (n) {
                        case 39: {
                            if (player.hasMetadata("costume_toggle_helmet")) {
                                player.removeMetadata("costume_toggle_helmet", this.A);
                            }
                            player.getInventory().setHelmet(this.A(Material.LEATHER_HELMET, itemStack, player));
                            break;
                        }
                        case 38: {
                            if (player.hasMetadata("costume_toggle_chestplate")) {
                                player.removeMetadata("costume_toggle_chestplate", this.A);
                            }
                            if (!i.D()) {
                                player.getInventory().setChestplate(this.A(Material.LEATHER_CHESTPLATE, itemStack, player));
                                break;
                            }
                            break;
                        }
                        case 37: {
                            if (player.hasMetadata("costume_toggle_leggings")) {
                                player.removeMetadata("costume_toggle_leggings", this.A);
                            }
                            player.getInventory().setLeggings(this.A(Material.LEATHER_LEGGINGS, itemStack, player));
                            break;
                        }
                        case 36: {
                            if (player.hasMetadata("costume_toggle_boots")) {
                                player.removeMetadata("costume_toggle_boots", this.A);
                            }
                            player.getInventory().setBoots(this.A(Material.LEATHER_BOOTS, itemStack, player));
                            break;
                        }
                    }
                }
            }
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
        if (!b && player.getGameMode() != GameMode.CREATIVE && !player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            Bukkit.getScheduler().runTaskLater(this.A, () -> this.A(player2, j), 1L);
        }
        else if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {}
        if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                if (player3.isOnline() && L.F(player3)) {
                    J.getPlayerArmorSnapshot(player3.getUniqueId());
                    final I k;
                    if (k != null) {
                        this.G(player3, k);
                    }
                }
            }, 2L);
        }
    }
    
    private void G(final Player player, final I i) {
        if (!L.F(player)) {
            return;
        }
        if (player.hasMetadata("costume_hotbar_equip_in_progress")) {
            return;
        }
        if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            this.C(player);
        }
        if (player.isSneaking() || player.hasMetadata("costume_sneaking")) {
            return;
        }
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            if (i.C() != null) {
                player.getInventory().setHelmet(i.C().clone());
            }
            else {
                player.getInventory().setHelmet((ItemStack)null);
            }
            if (!i.D()) {
                if (i.E() != null) {
                    player.getInventory().setChestplate(i.E().clone());
                }
                else {
                    player.getInventory().setChestplate((ItemStack)null);
                }
            }
            if (i.B() != null) {
                player.getInventory().setLeggings(i.B().clone());
            }
            else {
                player.getInventory().setLeggings((ItemStack)null);
            }
            if (i.A() != null) {
                player.getInventory().setBoots(i.A().clone());
            }
            else {
                player.getInventory().setBoots((ItemStack)null);
            }
            return;
        }
        final boolean hasMetadata = player.hasMetadata("costume_toggle_helmet");
        final boolean hasMetadata2 = player.hasMetadata("costume_toggle_chestplate");
        final boolean hasMetadata3 = player.hasMetadata("costume_toggle_leggings");
        final boolean hasMetadata4 = player.hasMetadata("costume_toggle_boots");
        this.P(player);
        final HashMap hashMap = new HashMap();
        this.A(i, hashMap);
        for (Map.Entry entry : hashMap.entrySet()) {}
        final ItemStack a = this.A(Material.LEATHER_HELMET, i.C(), (Map<Enchantment, Integer>)hashMap.getOrDefault(Material.LEATHER_HELMET, new HashMap()), player);
        final ItemStack a2 = this.A(Material.LEATHER_CHESTPLATE, i.E(), (Map<Enchantment, Integer>)hashMap.getOrDefault(Material.LEATHER_CHESTPLATE, new HashMap()), player);
        final ItemStack a3 = this.A(Material.LEATHER_LEGGINGS, i.B(), (Map<Enchantment, Integer>)hashMap.getOrDefault(Material.LEATHER_LEGGINGS, new HashMap()), player);
        final ItemStack a4 = this.A(Material.LEATHER_BOOTS, i.A(), (Map<Enchantment, Integer>)hashMap.getOrDefault(Material.LEATHER_BOOTS, new HashMap()), player);
        final boolean b = player.hasMetadata("costume_temp_clear_39") || player.hasMetadata("costume_block_refresh_39");
        final boolean b2 = player.hasMetadata("costume_temp_clear_38") || player.hasMetadata("costume_block_refresh_38");
        final boolean b3 = player.hasMetadata("costume_temp_clear_37") || player.hasMetadata("costume_block_refresh_37");
        final boolean b4 = player.hasMetadata("costume_temp_clear_36") || player.hasMetadata("costume_block_refresh_36");
        if (!hasMetadata && !b) {
            player.getInventory().setHelmet(a);
        }
        else if (i.C() != null && !b) {
            player.getInventory().setHelmet(i.C().clone());
        }
        else if (b) {}
        if (!i.D() && !hasMetadata2 && !b2) {
            player.getInventory().setChestplate(a2);
        }
        else if (!i.D() && hasMetadata2 && i.E() != null && !b2) {
            player.getInventory().setChestplate(i.E().clone());
        }
        else if (b2) {}
        if (!hasMetadata3 && !b3) {
            player.getInventory().setLeggings(a3);
        }
        else if (i.B() != null && !b3) {
            player.getInventory().setLeggings(i.B().clone());
        }
        else if (b3) {}
        if (!hasMetadata4 && !b4) {
            player.getInventory().setBoots(a4);
        }
        else if (i.A() != null && !b4) {
            player.getInventory().setBoots(i.A().clone());
        }
        else if (b4) {}
        if (player.hasMetadata("costume_temp_clear_39")) {
            player.removeMetadata("costume_temp_clear_39", this.A);
        }
        if (player.hasMetadata("costume_temp_clear_38")) {
            player.removeMetadata("costume_temp_clear_38", this.A);
        }
        if (player.hasMetadata("costume_temp_clear_37")) {
            player.removeMetadata("costume_temp_clear_37", this.A);
        }
        if (player.hasMetadata("costume_temp_clear_36")) {
            player.removeMetadata("costume_temp_clear_36", this.A);
        }
        if (player.hasMetadata("costume_block_refresh_39")) {
            player.removeMetadata("costume_block_refresh_39", this.A);
        }
        if (player.hasMetadata("costume_block_refresh_38")) {
            player.removeMetadata("costume_block_refresh_38", this.A);
        }
        if (player.hasMetadata("costume_block_refresh_37")) {
            player.removeMetadata("costume_block_refresh_37", this.A);
        }
        if (player.hasMetadata("costume_block_refresh_36")) {
            player.removeMetadata("costume_block_refresh_36", this.A);
        }
    }
    
    private void B(final Player player, final I i) {
        if (!L.F(player)) {
            return;
        }
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        if (player.isSneaking() || player.hasMetadata("costume_sneaking")) {
            return;
        }
        this.M(player);
        this.P(player);
        final ItemStack helmet = player.getInventory().getHelmet();
        final ItemStack chestplate = player.getInventory().getChestplate();
        final ItemStack leggings = player.getInventory().getLeggings();
        final ItemStack boots = player.getInventory().getBoots();
        if (L.A(player) != null) {
            final ItemStack b = this.B(Material.LEATHER_HELMET, i.C(), player);
            final ItemStack b2 = this.B(Material.LEATHER_CHESTPLATE, i.E(), player);
            final ItemStack b3 = this.B(Material.LEATHER_LEGGINGS, i.B(), player);
            final ItemStack b4 = this.B(Material.LEATHER_BOOTS, i.A(), player);
            if (helmet == null || this.D(helmet)) {
                player.getInventory().setHelmet(b);
            }
            if (!i.D() && (chestplate == null || this.D(chestplate))) {
                player.getInventory().setChestplate(b2);
            }
            if (leggings == null || this.D(leggings)) {
                player.getInventory().setLeggings(b3);
            }
            if (boots == null || this.D(boots)) {
                player.getInventory().setBoots(b4);
            }
            player.setMetadata("costume_silent_refresh", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                if (player2.isOnline() && L.F(player2)) {
                    J.getPlayerArmorSnapshot(player2.getUniqueId());
                    final I j;
                    if (j != null) {
                        this.G(player2, j);
                    }
                }
                return;
            }, 1L);
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                if (player3.isOnline()) {
                    player3.removeMetadata("costume_silent_refresh", this.A);
                }
            }, 20L);
        }
    }
    
    private void C(final Player player) {
        this.M(player);
    }
    
    private void M(final Player player) {
        final ItemStack helmet = player.getInventory().getHelmet();
        final ItemStack chestplate = player.getInventory().getChestplate();
        final ItemStack leggings = player.getInventory().getLeggings();
        final ItemStack boots = player.getInventory().getBoots();
        if (chestplate != null && this.B(chestplate)) {
            player.getInventory().setChestplate((ItemStack)null);
        }
        if (helmet != null && this.B(helmet)) {
            player.getInventory().setHelmet((ItemStack)null);
        }
        if (leggings != null && this.B(leggings)) {
            player.getInventory().setLeggings((ItemStack)null);
        }
        if (boots != null && this.B(boots)) {
            player.getInventory().setBoots((ItemStack)null);
        }
        for (int i = 0; i < 36; ++i) {
            final ItemStack item = player.getInventory().getItem(i);
            if (item != null) {
                final String s = (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) ? item.getItemMeta().getDisplayName() : item.getType().name();
            }
            if (item != null && this.D(item) && !this.B(item)) {
                final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
                if (playerArmorSnapshot != null) {
                    ItemStack itemStack = null;
                    if (item.getType() == Material.LEATHER_HELMET || item.getType() == Material.PLAYER_HEAD) {
                        itemStack = playerArmorSnapshot.C();
                    }
                    else if (item.getType() == Material.LEATHER_CHESTPLATE) {
                        itemStack = playerArmorSnapshot.E();
                    }
                    else if (item.getType() == Material.LEATHER_LEGGINGS) {
                        itemStack = playerArmorSnapshot.B();
                    }
                    else if (item.getType() == Material.LEATHER_BOOTS) {
                        itemStack = playerArmorSnapshot.A();
                    }
                    if (!this.B(item)) {
                        if (itemStack != null) {
                            player.getInventory().setItem(i, itemStack.clone());
                        }
                        else {
                            player.getInventory().setItem(i, (ItemStack)null);
                        }
                    }
                }
                else {
                    player.getInventory().setItem(i, (ItemStack)null);
                }
            }
        }
    }
    
    private void A(final Player player, final ItemStack itemStack, final int n, final I i) {
        this.A(player, itemStack, n, player.getInventory().getHeldItemSlot(), player.getInventory().getItem(n), i);
    }
    
    private boolean I(final Player player) {
        for (int i = 0; i < 36; ++i) {
            final ItemStack item = player.getInventory().getItem(i);
            if (item != null && this.D(item)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean H(final Player player) {
        final boolean b = player.hasMetadata("costume_toggle_helmet") || player.hasMetadata("costume_toggle_chestplate") || player.hasMetadata("costume_toggle_leggings") || player.hasMetadata("costume_toggle_boots");
        final boolean b2 = player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory");
        final boolean hasMetadata = player.hasMetadata("costume_sneaking");
        final boolean hasMetadata2 = player.hasMetadata("costume_edit_mode");
        return b || b2 || hasMetadata || hasMetadata2;
    }
    
    private boolean B(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (itemStack.hasItemMeta()) {
            try {
                if (itemStack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(this.A, "costume_type"), PersistentDataType.STRING)) {
                    return true;
                }
            }
            catch (final Exception ex) {}
        }
        if (itemStack.getType() == Material.LEATHER_CHESTPLATE && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            final String lowerCase = itemStack.getItemMeta().getDisplayName().toLowerCase();
            return lowerCase.contains("kostium") && !lowerCase.contains("zbroja");
        }
        return false;
    }
    
    private boolean D(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if ((itemStack.getType() == Material.PLAYER_HEAD || itemStack.getType() == Material.LEATHER_HELMET || itemStack.getType() == Material.LEATHER_CHESTPLATE || itemStack.getType() == Material.LEATHER_LEGGINGS || itemStack.getType() == Material.LEATHER_BOOTS) && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            final String lowerCase = itemStack.getItemMeta().getDisplayName().toLowerCase();
            final boolean b = lowerCase.contains("zbroja") || lowerCase.contains("kostium");
            final boolean b2 = lowerCase.contains("na ") && (lowerCase.contains("dni") || lowerCase.contains("godzin") || lowerCase.contains("minut") || lowerCase.contains("sekund") || lowerCase.contains("zawsze"));
            return b && !b2;
        }
        return false;
    }
    
    private boolean F(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        final Material type = itemStack.getType();
        if (type == Material.PLAYER_HEAD) {
            return !this.E(itemStack);
        }
        return type.name().contains("HELMET") || type.name().contains("CHESTPLATE") || type.name().contains("LEGGINGS") || type.name().contains("BOOTS") || type == Material.ELYTRA;
    }
    
    private boolean B(final int n) {
        return n == 36 || n == 37 || n == 38 || n == 39;
    }
    
    private int C(final ItemStack itemStack) {
        if (itemStack == null) {
            return -1;
        }
        final Material type = itemStack.getType();
        if (type.name().contains("HELMET")) {
            return 39;
        }
        if (type == Material.PLAYER_HEAD && !this.E(itemStack)) {
            return 39;
        }
        if (type.name().contains("CHESTPLATE") || type == Material.ELYTRA) {
            return 38;
        }
        if (type.name().contains("LEGGINGS")) {
            return 37;
        }
        if (type.name().contains("BOOTS")) {
            return 36;
        }
        return -1;
    }
    
    private boolean A(final ItemStack itemStack, final int n) {
        return itemStack != null && this.C(itemStack) == n;
    }
    
    private ItemStack G(final ItemStack itemStack) {
        return (itemStack != null) ? itemStack.clone() : null;
    }
    
    private void A(final String str, final ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        if (!itemStack.hasItemMeta() || !itemStack.getItemMeta().hasEnchants()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("[COSTUME-ARMOR] ").append(str).append(" enchantments: ");
        for (final Map.Entry entry : itemStack.getEnchantments().entrySet()) {
            sb.append(((Enchantment)entry.getKey()).getKey()).append(":").append(entry.getValue()).append(", ");
        }
    }
    
    private void P(final Player player) {
        final Main instance = Main.getInstance();
        if (instance != null) {
            final E costumeDataManager = instance.getCostumeDataManager();
            if (costumeDataManager != null) {
                costumeDataManager.B(player);
            }
        }
    }
    
    private void C(final Player player, final ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        final HashMap addItem = player.getInventory().addItem(new ItemStack[] { itemStack });
        if (!addItem.isEmpty()) {
            final Iterator iterator = addItem.values().iterator();
            while (iterator.hasNext()) {
                player.getWorld().dropItemNaturally(player.getLocation(), (ItemStack)iterator.next());
            }
        }
    }
    
    private ItemStack A(final Material material, final Player player) {
        return this.B(material, null, player);
    }
    
    private ItemStack B(final Material material, final ItemStack itemStack, final Player player) {
        final C a = L.A(player);
        String displayName;
        ItemStack itemStack2;
        if (a instanceof final pl.ziffy.STORMSZAFKA.costumes.items.E e) {
            displayName = "§7Zbroja §fZab\u00f3jczego Kr\u00f3lika";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = e.createCustomHead(e.getHelmetTexture());
            }
            else {
                Color color = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color = e.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color = e.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color = e.getBootsColor();
                }
                itemStack2 = e.createColoredArmor(material, color);
            }
        }
        else if (a instanceof final pl.ziffy.STORMSZAFKA.costumes.items.A a2) {
            displayName = "§7Kostium §dWalentynkowy";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = a2.createCustomHead(a2.getHelmetTexture());
            }
            else {
                Color color2 = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color2 = a2.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color2 = a2.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color2 = a2.getBootsColor();
                }
                itemStack2 = a2.createColoredArmor(material, color2);
            }
        }
        else if (a instanceof final G g) {
            displayName = "§7Kostium §aPrzeciwzaka\u017ceniowy";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = g.createCustomHead(g.getHelmetTexture());
            }
            else {
                Color color3 = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color3 = g.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color3 = g.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color3 = g.getBootsColor();
                }
                itemStack2 = g.createColoredArmor(material, color3);
            }
        }
        else if (a instanceof final H h) {
            displayName = "§7Kostium §6Ma\u0142ego Urwisa";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = h.createCustomHead(h.getHelmetTexture());
            }
            else {
                Color color4 = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color4 = h.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color4 = h.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color4 = h.getBootsColor();
                }
                itemStack2 = h.createColoredArmor(material, color4);
            }
        }
        else if (a instanceof final B b) {
            displayName = "§7Zbroja §5Mima";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = b.createCustomHead(b.getHelmetTexture());
            }
            else {
                Color color5 = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color5 = b.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color5 = b.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color5 = b.getBootsColor();
                }
                itemStack2 = b.createColoredArmor(material, color5);
            }
        }
        else if (a instanceof final pl.ziffy.STORMSZAFKA.costumes.items.C c) {
            displayName = "§7Zbroja §bNurka G\u0142\u0119binowego";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = c.createCustomHead(c.getHelmetTexture());
            }
            else {
                Color color6 = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color6 = c.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color6 = c.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color6 = c.getBootsColor();
                }
                itemStack2 = c.createColoredArmor(material, color6);
            }
        }
        else if (a instanceof final B b2) {
            displayName = "§7Zbroja §5Mima";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = b2.createCustomHead(b2.getHelmetTexture());
            }
            else {
                Color color7 = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color7 = b2.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color7 = b2.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color7 = b2.getBootsColor();
                }
                itemStack2 = b2.createColoredArmor(material, color7);
            }
        }
        else if (a instanceof final pl.ziffy.STORMSZAFKA.costumes.items.C c2) {
            displayName = "§7Zbroja §bNurka G\u0142\u0119binowego";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = c2.createCustomHead(c2.getHelmetTexture());
            }
            else {
                Color color8 = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color8 = c2.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color8 = c2.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color8 = c2.getBootsColor();
                }
                itemStack2 = c2.createColoredArmor(material, color8);
            }
        }
        else if (a instanceof final F f) {
            displayName = "§7Zbroja §6Pirata";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = f.createCustomHead(f.getHelmetTexture());
            }
            else {
                Color color9 = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color9 = f.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color9 = f.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color9 = f.getBootsColor();
                }
                itemStack2 = f.createColoredArmor(material, color9);
            }
        }
        else if (a instanceof final D d) {
            displayName = "§7Zbroja §cwampira";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = d.createCustomHead(d.getHelmetTexture());
            }
            else {
                Color color10 = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color10 = d.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color10 = d.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color10 = d.getBootsColor();
                }
                itemStack2 = d.createColoredArmor(material, color10);
            }
        }
        else {
            final pl.ziffy.STORMSZAFKA.costumes.items.E e2 = new pl.ziffy.STORMSZAFKA.costumes.items.E();
            displayName = "§7Zbroja §fZab\u00f3jczego Kr\u00f3lika";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = e2.createCustomHead(e2.getHelmetTexture());
            }
            else {
                Color color11 = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color11 = e2.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color11 = e2.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color11 = e2.getBootsColor();
                }
                itemStack2 = e2.createColoredArmor(material, color11);
            }
        }
        final ItemMeta itemMeta = itemStack2.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_DESTROYS });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_PLACED_ON });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_POTION_EFFECTS });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_DYE });
        final ArrayList lore = new ArrayList();
        lore.add("§7");
        lore.add("§e§lKliknij§r §7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 §fzbroj\u0119§7!");
        itemMeta.setLore((List)lore);
        itemStack2.setItemMeta(itemMeta);
        if (itemStack != null) {
            final Main instance = Main.getInstance();
            if (instance != null) {
                final K enchantedBookSupport = instance.getEnchantedBookSupport();
                if (enchantedBookSupport != null) {
                    enchantedBookSupport.copyEnchantsToLore(itemStack, itemStack2);
                }
            }
        }
        return itemStack2;
    }
    
    private ItemStack A(final Material material, final ItemStack itemStack, final Player player) {
        if (itemStack == null) {
            return this.A(material, player);
        }
        final ItemStack b = this.B(material, itemStack, player);
        if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasEnchants()) {
            final ItemMeta itemMeta = b.getItemMeta();
            for (final Enchantment enchantment : itemStack.getEnchantments().keySet()) {
                itemMeta.addEnchant(enchantment, itemStack.getEnchantmentLevel(enchantment), true);
            }
            b.setItemMeta(itemMeta);
        }
        this.A(itemStack, b);
        return b;
    }
    
    private void A(final ItemStack itemStack, final ItemStack itemStack2) {
        if (itemStack == null || itemStack2 == null) {
            return;
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        final ItemMeta itemMeta2 = itemStack2.getItemMeta();
        if (itemMeta == null || itemMeta2 == null) {
            return;
        }
        try {
            if (itemMeta.hasAttributeModifiers()) {
                for (final Attribute attribute : itemMeta.getAttributeModifiers().keySet()) {
                    final Iterator iterator2 = itemMeta.getAttributeModifiers(attribute).iterator();
                    while (iterator2.hasNext()) {
                        itemMeta2.addAttributeModifier(attribute, (AttributeModifier)iterator2.next());
                    }
                }
            }
            final double a = this.A(itemStack.getType());
            final double b = this.B(itemStack.getType());
            final double c = this.C(itemStack.getType());
            if (a > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "costume_armor", a, AttributeModifier.Operation.ADD_NUMBER, this.D(itemStack2.getType())));
            }
            if (b > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "costume_toughness", b, AttributeModifier.Operation.ADD_NUMBER, this.D(itemStack2.getType())));
            }
            if (c > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "costume_knockback_resistance", c, AttributeModifier.Operation.ADD_NUMBER, this.D(itemStack2.getType())));
            }
            itemStack2.setItemMeta(itemMeta2);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private double A(final Material material) {
        switch (A$1.A[material.ordinal()]) {
            case 1: {
                return 1.0;
            }
            case 2: {
                return 3.0;
            }
            case 3: {
                return 2.0;
            }
            case 4: {
                return 1.0;
            }
            case 5: {
                return 2.0;
            }
            case 6: {
                return 5.0;
            }
            case 7: {
                return 4.0;
            }
            case 8: {
                return 1.0;
            }
            case 9: {
                return 2.0;
            }
            case 10: {
                return 6.0;
            }
            case 11: {
                return 5.0;
            }
            case 12: {
                return 2.0;
            }
            case 13: {
                return 2.0;
            }
            case 14: {
                return 5.0;
            }
            case 15: {
                return 3.0;
            }
            case 16: {
                return 1.0;
            }
            case 17: {
                return 3.0;
            }
            case 18: {
                return 8.0;
            }
            case 19: {
                return 6.0;
            }
            case 20: {
                return 3.0;
            }
            case 21: {
                return 3.0;
            }
            case 22: {
                return 8.0;
            }
            case 23: {
                return 6.0;
            }
            case 24: {
                return 3.0;
            }
            case 25: {
                return 2.0;
            }
            default: {
                return 0.0;
            }
        }
    }
    
    private double B(final Material material) {
        switch (A$1.A[material.ordinal()]) {
            case 17:
            case 18:
            case 19:
            case 20: {
                return 2.0;
            }
            case 21:
            case 22:
            case 23:
            case 24: {
                return 3.0;
            }
            default: {
                return 0.0;
            }
        }
    }
    
    private double C(final Material material) {
        switch (A$1.A[material.ordinal()]) {
            case 21:
            case 22:
            case 23:
            case 24: {
                return 0.1;
            }
            default: {
                return 0.0;
            }
        }
    }
    
    private EquipmentSlot D(final Material material) {
        final String name = material.name();
        if (name.contains("HELMET") || name.equals("TURTLE_HELMET") || material == Material.PLAYER_HEAD) {
            return EquipmentSlot.HEAD;
        }
        if (name.contains("CHESTPLATE")) {
            return EquipmentSlot.CHEST;
        }
        if (name.contains("LEGGINGS")) {
            return EquipmentSlot.LEGS;
        }
        if (name.contains("BOOTS")) {
            return EquipmentSlot.FEET;
        }
        return EquipmentSlot.CHEST;
    }
    
    private ItemStack A(final String s) {
        final ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        final SkullMeta itemMeta = (SkullMeta)itemStack.getItemMeta();
        if (itemMeta != null) {
            pl.ziffy.STORMSZAFKA.utils.C.D(itemMeta, s);
            itemStack.setItemMeta((ItemMeta)itemMeta);
        }
        return itemStack;
    }
    
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onArmorShiftClick(final InventoryClickEvent inventoryClickEvent) {
        if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryClickEvent.getWhoClicked();
        if (!L.F(player)) {
            return;
        }
        if ((inventoryClickEvent.getClick() == ClickType.SHIFT_LEFT || inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT) && this.B(inventoryClickEvent.getSlot()) && inventoryClickEvent.getCurrentItem() != null && !this.D(inventoryClickEvent.getCurrentItem()) && this.F(inventoryClickEvent.getCurrentItem())) {
            final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
            if (playerArmorSnapshot == null) {
                return;
            }
            switch (inventoryClickEvent.getSlot()) {
                case 39: {
                    playerArmorSnapshot.A(null);
                    break;
                }
                case 38: {
                    playerArmorSnapshot.D(null);
                    break;
                }
                case 37: {
                    playerArmorSnapshot.B(null);
                    break;
                }
                case 36: {
                    playerArmorSnapshot.C(null);
                    break;
                }
            }
            this.P(player);
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                if (player2.isOnline() && L.F(player2)) {
                    this.G(player2, i);
                }
            }, 2L);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onArmorRightClick(final PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR && playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        final Player player = playerInteractEvent.getPlayer();
        if (!L.F(player)) {
            return;
        }
        final ItemStack item = playerInteractEvent.getItem();
        if (item == null) {
            return;
        }
        if (this.E(item) || this.B(item)) {
            return;
        }
        if (!this.F(item) || this.D(item)) {
            return;
        }
        if (player.hasMetadata("costume_hotbar_equip_in_progress")) {
            playerInteractEvent.setCancelled(true);
            return;
        }
        final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
        if (playerArmorSnapshot == null) {
            return;
        }
        final int c = this.C(item);
        if (c == -1) {
            return;
        }
        playerInteractEvent.setCancelled(true);
        final ItemStack item2 = player.getInventory().getItem(c);
        int heldItemSlot = player.getInventory().getHeldItemSlot();
        final ItemStack item3 = player.getInventory().getItem(heldItemSlot);
        if (item3 == null || !item3.equals((Object)item)) {
            for (int i = 0; i < 9; ++i) {
                final ItemStack item4 = player.getInventory().getItem(i);
                if (item4 != null && item4.equals((Object)item)) {
                    heldItemSlot = i;
                    break;
                }
            }
        }
        this.A(player, item, c, heldItemSlot, item2, playerArmorSnapshot);
    }
    
    private void A(final Player player, final ItemStack itemStack, final int n, final int n2, final ItemStack itemStack2, final I i) {
        ItemStack itemStack3 = null;
        switch (n) {
            case 39: {
                itemStack3 = i.C();
                break;
            }
            case 38: {
                itemStack3 = i.E();
                break;
            }
            case 37: {
                itemStack3 = i.B();
                break;
            }
            case 36: {
                itemStack3 = i.A();
                break;
            }
        }
        if (n == 38 && itemStack2 != null && itemStack2.getType() == Material.ELYTRA) {
            player.sendMessage("§cNie mo\u017cna zast\u0105pi\u0107 elytry kostiumem!");
            return;
        }
        final ItemStack clone = itemStack.clone();
        switch (n) {
            case 39: {
                i.A(clone);
                break;
            }
            case 38: {
                i.D(clone);
                break;
            }
            case 37: {
                i.B(clone);
                break;
            }
            case 36: {
                i.C(clone);
                break;
            }
        }
        player.setMetadata("costume_hotbar_equip_in_progress", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
        player.getInventory().setItem(n2, (itemStack3 != null) ? itemStack3.clone() : null);
        player.getInventory().setItem(n, clone);
        this.P(player);
        J.storeArmorSnapshot(player.getUniqueId(), i);
        Bukkit.getScheduler().runTaskLater(this.A, () -> {
            if (player2.isOnline() && L.F(player2)) {
                player2.removeMetadata("costume_hotbar_equip_in_progress", this.A);
                J.getPlayerArmorSnapshot(player2.getUniqueId());
                final I j;
                if (j != null) {
                    this.B(player2, j);
                }
                player2.playSound(player2.getLocation(), this.A(itemStack4), 1.0f, 1.0f);
            }
        }, 1L);
    }
    
    private Sound A(final ItemStack itemStack) {
        final Material type = itemStack.getType();
        if (type.name().contains("LEATHER")) {
            return Sound.ITEM_ARMOR_EQUIP_LEATHER;
        }
        if (type.name().contains("CHAIN")) {
            return Sound.ITEM_ARMOR_EQUIP_CHAIN;
        }
        if (type.name().contains("IRON")) {
            return Sound.ITEM_ARMOR_EQUIP_IRON;
        }
        if (type.name().contains("GOLD")) {
            return Sound.ITEM_ARMOR_EQUIP_GOLD;
        }
        if (type.name().contains("DIAMOND")) {
            return Sound.ITEM_ARMOR_EQUIP_DIAMOND;
        }
        if (type.name().contains("NETHERITE")) {
            return Sound.ITEM_ARMOR_EQUIP_NETHERITE;
        }
        if (type == Material.TURTLE_HELMET) {
            return Sound.ITEM_ARMOR_EQUIP_TURTLE;
        }
        return Sound.ITEM_ARMOR_EQUIP_GENERIC;
    }
    
    private String A(final int n) {
        switch (n) {
            case 39: {
                return "§fhe\u0142m";
            }
            case 38: {
                return "§fnapier\u015bnik";
            }
            case 37: {
                return "§fnogawice";
            }
            case 36: {
                return "§fbuty";
            }
            default: {
                return "§fzbroj\u0119";
            }
        }
    }
}
