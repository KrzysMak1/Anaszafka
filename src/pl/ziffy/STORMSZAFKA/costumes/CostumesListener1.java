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
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener3;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener4;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener2;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener5;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService3;
import org.bukkit.Color;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
import java.util.Map;
import java.util.HashMap;
import pl.ziffy.STORMSZAFKA.data.CostumesCostumeService2;
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

public class CostumesListener1 implements Listener
{
    private final Plugin CostumesListener1;
    
    public CostumesListener1(final Plugin a) {
        this.CostumesListener1 = a;
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerInteractBlockArmor(final PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR && playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }
        if (!CostumesCostumeService6.CostumesListener4(playerInteractEvent.getPlayer())) {
            return;
        }
        final ItemStack item = playerInteractEvent.getItem();
        if (item == null) {
            return;
        }
        final Material type = item.getType();
        if ((type == Material.PLAYER_HEAD || type == Material.LEATHER_HELMET || type == Material.LEATHER_CHESTPLATE || type == Material.LEATHER_LEGGINGS || type == Material.LEATHER_BOOTS) && (this.CostumesCostumeService2(item) || this.CostumesListener2(item))) {
            playerInteractEvent.setCancelled(true);
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> this.Q(player), 1L);
        }
    }
    
    private void Q(final Player player) {
        final ItemStack helmet = player.getInventory().getHelmet();
        final ItemStack chestplate = player.getInventory().getChestplate();
        final ItemStack leggings = player.getInventory().getLeggings();
        final ItemStack boots = player.getInventory().getBoots();
        if (helmet != null && helmet.getType() == Material.PLAYER_HEAD && !this.CostumesListener3(helmet)) {
            player.getInventory().setHelmet((ItemStack)null);
        }
        if (helmet != null && (this.CostumesCostumeService2(helmet) || this.CostumesListener2(helmet))) {
            player.getInventory().setHelmet((ItemStack)null);
        }
        if (chestplate != null && (this.CostumesCostumeService2(chestplate) || this.CostumesListener2(chestplate))) {
            player.getInventory().setChestplate((ItemStack)null);
        }
        if (leggings != null && (this.CostumesCostumeService2(leggings) || this.CostumesListener2(leggings))) {
            player.getInventory().setLeggings((ItemStack)null);
        }
        if (boots != null && (this.CostumesCostumeService2(boots) || this.CostumesListener2(boots))) {
            player.getInventory().setBoots((ItemStack)null);
        }
    }
    
    private boolean CostumesCostumeService2(final ItemStack itemStack) {
        if (itemStack == null || itemStack.getType() != Material.PLAYER_HEAD) {
            return false;
        }
        if (!itemStack.hasItemMeta()) {
            return false;
        }
        try {
            if (itemStack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(this.CostumesListener1, "pet_type"), PersistentDataType.STRING)) {
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
        if (!CostumesCostumeService6.CostumesListener4(player)) {
            return;
        }
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        final ItemStack cursor = inventoryClickEvent.getCursor();
        if (player.getGameMode() == GameMode.CREATIVE && currentItem != null && this.CostumesListener3(currentItem)) {
            final InventoryAction action = inventoryClickEvent.getAction();
            if (action == InventoryAction.CLONE_STACK || action == InventoryAction.PICKUP_ALL || action == InventoryAction.PICKUP_HALF || action == InventoryAction.PICKUP_ONE || action == InventoryAction.PICKUP_SOME) {
                inventoryClickEvent.setCancelled(true);
                player.setItemOnCursor((ItemStack)null);
                return;
            }
        }
        if (this.CostumesListener2(inventoryClickEvent.getSlot()) && cursor != null && (this.CostumesListener2(cursor) || this.CostumesCostumeService2(cursor))) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if ((inventoryClickEvent.getClick() == ClickType.SHIFT_LEFT || inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT) && currentItem != null && (this.CostumesCostumeService2(currentItem) || this.CostumesListener2(currentItem))) {
            inventoryClickEvent.setCancelled(true);
            return;
        }
        if (inventoryClickEvent.getClick() == ClickType.NUMBER_KEY && this.CostumesListener2(inventoryClickEvent.getSlot())) {
            final ItemStack item = player.getInventory().getItem(inventoryClickEvent.getHotbarButton());
            if (item != null && (this.CostumesCostumeService2(item) || this.CostumesListener2(item))) {
                inventoryClickEvent.setCancelled(true);
                return;
            }
        }
        final String s = (currentItem != null && currentItem.hasItemMeta() && currentItem.getItemMeta().hasDisplayName()) ? currentItem.getItemMeta().getDisplayName() : ((currentItem != null) ? currentItem.getType().name() : "null");
        final String s2 = (cursor != null && cursor.hasItemMeta() && cursor.getItemMeta().hasDisplayName()) ? cursor.getItemMeta().getDisplayName() : ((cursor != null) ? cursor.getType().name() : "null");
        final boolean b = (currentItem != null && (currentItem.getType() == Material.LEATHER_HELMET || currentItem.getType() == Material.LEATHER_CHESTPLATE || currentItem.getType() == Material.LEATHER_LEGGINGS || currentItem.getType() == Material.LEATHER_BOOTS || currentItem.getType() == Material.PLAYER_HEAD)) || (cursor != null && (cursor.getType() == Material.LEATHER_HELMET || cursor.getType() == Material.LEATHER_CHESTPLATE || cursor.getType() == Material.LEATHER_LEGGINGS || cursor.getType() == Material.LEATHER_BOOTS || cursor.getType() == Material.PLAYER_HEAD));
        final boolean b2 = inventoryClickEvent.getView().getType() == InventoryType.PLAYER || inventoryClickEvent.getView().getType() == InventoryType.CRAFTING;
        if (this.CostumesListener2(inventoryClickEvent.getSlot()) && this.CostumesListener3(currentItem)) {
            final InventoryAction action2 = inventoryClickEvent.getAction();
            if (action2 == InventoryAction.MOVE_TO_OTHER_INVENTORY || action2 == InventoryAction.HOTBAR_SWAP || action2 == InventoryAction.SWAP_WITH_CURSOR || action2 == InventoryAction.COLLECT_TO_CURSOR) {
                inventoryClickEvent.setCancelled(true);
                return;
            }
        }
        if (this.CostumesListener2(inventoryClickEvent.getSlot()) && this.CostumesListener3(currentItem)) {
            this.CostumesListener1(inventoryClickEvent, player);
            return;
        }
        if (!this.CostumesListener2(inventoryClickEvent.getSlot()) || currentItem != null) {}
        if (this.CostumesListener2(inventoryClickEvent.getSlot()) && cursor != null && this.CostumesListener4(cursor) && !this.CostumesListener3(cursor)) {
            final CostumesCostumeService4 playerArmorSnapshot = CostumesCostumeService5.getPlayerArmorSnapshot(player.getUniqueId());
            if (playerArmorSnapshot != null && this.CostumesListener1(cursor, inventoryClickEvent.getSlot())) {
                inventoryClickEvent.setCancelled(true);
                this.CostumesListener1(inventoryClickEvent, player, playerArmorSnapshot);
                return;
            }
        }
        if (!this.CostumesListener2(inventoryClickEvent.getSlot()) && currentItem != null && this.CostumesListener3(currentItem) && !this.CostumesListener2(currentItem)) {
            inventoryClickEvent.setCancelled(true);
            player.setItemOnCursor((ItemStack)null);
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> this.CostumesCostumeService1(player2), 1L);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryDrag(final InventoryDragEvent inventoryDragEvent) {
        if (!(inventoryDragEvent.getWhoClicked() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryDragEvent.getWhoClicked();
        if (!CostumesCostumeService6.CostumesListener4(player)) {
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
                if (n != -1 && this.CostumesListener3(player.getInventory().getItem(n))) {
                    inventoryDragEvent.setCancelled(true);
                    return;
                }
                continue;
            }
        }
    }
    
    private void CostumesListener1(final InventoryClickEvent inventoryClickEvent, final Player player) {
        if (!player.hasMetadata("costume_inventory_open")) {
            player.setMetadata("costume_inventory_open", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
        }
        if (!player.hasMetadata("costume_survival_inventory")) {
            player.setMetadata("costume_survival_inventory", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
        }
        final CostumesCostumeService4 playerArmorSnapshot = CostumesCostumeService5.getPlayerArmorSnapshot(player.getUniqueId());
        if (playerArmorSnapshot == null) {
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack currentItem = inventoryClickEvent.getCurrentItem();
        if ((inventoryClickEvent.getClick() == ClickType.SHIFT_LEFT || inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT) && currentItem != null && !this.CostumesListener3(currentItem) && (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory"))) {
            final int slot = inventoryClickEvent.getSlot();
            currentItem.clone();
            switch (inventoryClickEvent.getSlot()) {
                case 39: {
                    playerArmorSnapshot.CostumesListener1(null);
                    break;
                }
                case 38: {
                    playerArmorSnapshot.CostumesListener3(null);
                    break;
                }
                case 37: {
                    playerArmorSnapshot.CostumesListener2(null);
                    break;
                }
                case 36: {
                    playerArmorSnapshot.CostumesCostumeService1(null);
                    break;
                }
            }
            this.P(player);
            inventoryClickEvent.setCancelled(true);
            player.getInventory().setItem(slot, (ItemStack)null);
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                this.CostumesCostumeService1(player2, itemStack);
                player2.playSound(player2.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.5f, 1.0f);
                return;
            }, 1L);
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                if (player3.isOnline() && CostumesCostumeService6.CostumesListener4(player3)) {
                    this.CostumesCostumeService3(player3, CostumesCostumeService5.getPlayerArmorSnapshot(player3.getUniqueId()));
                }
            }, 2L);
            return;
        }
        if (inventoryClickEvent.getCursor() != null && !inventoryClickEvent.getCursor().getType().equals((Object)Material.AIR)) {
            this.CostumesListener1(inventoryClickEvent, player, playerArmorSnapshot);
            return;
        }
        switch (inventoryClickEvent.getSlot()) {
            case 39: {}
            case 38: {}
            case 37: {}
        }
        final boolean b = currentItem != null && this.CostumesListener3(currentItem);
        final boolean b2 = playerArmorSnapshot.CostumesCostumeService1() != null;
        final boolean b3 = playerArmorSnapshot.CostumesCostumeService2() != null;
        final boolean b4 = playerArmorSnapshot.CostumesListener2() != null;
        final boolean b5 = playerArmorSnapshot.CostumesListener1() != null;
        if (b) {
            player.setMetadata("costume_toggle_helmet", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
            player.setMetadata("costume_toggle_chestplate", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
            player.setMetadata("costume_toggle_leggings", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
            player.setMetadata("costume_toggle_boots", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
            player.setMetadata("costume_edit_mode", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
            if (b2) {
                player.getInventory().setHelmet(this.CostumesCostumeService3(playerArmorSnapshot.CostumesCostumeService1()));
            }
            else {
                player.getInventory().setHelmet((ItemStack)null);
            }
            if (b3) {
                player.getInventory().setChestplate(this.CostumesCostumeService3(playerArmorSnapshot.CostumesCostumeService2()));
            }
            else {
                player.getInventory().setChestplate((ItemStack)null);
            }
            if (b4) {
                player.getInventory().setLeggings(this.CostumesCostumeService3(playerArmorSnapshot.CostumesListener2()));
            }
            else {
                player.getInventory().setLeggings((ItemStack)null);
            }
            if (b5) {
                player.getInventory().setBoots(this.CostumesCostumeService3(playerArmorSnapshot.CostumesListener1()));
            }
            else {
                player.getInventory().setBoots((ItemStack)null);
            }
        }
        else {
            if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
                if (player.hasMetadata("costume_toggle_helmet")) {
                    player.removeMetadata("costume_toggle_helmet", this.CostumesListener1);
                }
                if (player.hasMetadata("costume_toggle_chestplate")) {
                    player.removeMetadata("costume_toggle_chestplate", this.CostumesListener1);
                }
                if (player.hasMetadata("costume_toggle_leggings")) {
                    player.removeMetadata("costume_toggle_leggings", this.CostumesListener1);
                }
                if (player.hasMetadata("costume_toggle_boots")) {
                    player.removeMetadata("costume_toggle_boots", this.CostumesListener1);
                }
                if (player.hasMetadata("costume_edit_mode")) {
                    player.removeMetadata("costume_edit_mode", this.CostumesListener1);
                    if (CostumesCostumeService6.CostumesListener4(player)) {
                        final CostumesCostumeService1 a = CostumesCostumeService6.CostumesListener1(player);
                        if (a != null && a.getType().equals("zabojczykrolik")) {
                            player.sendMessage("§7Wy\u0142\u0105czono tryb edycji zbroi.");
                        }
                    }
                }
            }
            if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
                if (playerArmorSnapshot.CostumesCostumeService1() != null) {
                    player.getInventory().setHelmet(playerArmorSnapshot.CostumesCostumeService1().clone());
                }
                else {
                    player.getInventory().setHelmet(this.CostumesListener1(Material.LEATHER_HELMET, player));
                }
                if (!playerArmorSnapshot.CostumesListener3()) {
                    if (playerArmorSnapshot.CostumesCostumeService2() != null) {
                        player.getInventory().setChestplate(playerArmorSnapshot.CostumesCostumeService2().clone());
                    }
                    else {
                        player.getInventory().setChestplate(this.CostumesListener1(Material.LEATHER_CHESTPLATE, player));
                    }
                }
                if (playerArmorSnapshot.CostumesListener2() != null) {
                    player.getInventory().setLeggings(playerArmorSnapshot.CostumesListener2().clone());
                }
                else {
                    player.getInventory().setLeggings(this.CostumesListener1(Material.LEATHER_LEGGINGS, player));
                }
                if (playerArmorSnapshot.CostumesListener1() != null) {
                    player.getInventory().setBoots(playerArmorSnapshot.CostumesListener1().clone());
                }
                else {
                    player.getInventory().setBoots(this.CostumesListener1(Material.LEATHER_BOOTS, player));
                }
            }
            else {
                player.getInventory().setHelmet(this.CostumesListener1(Material.LEATHER_HELMET, player));
                if (!playerArmorSnapshot.CostumesListener3()) {
                    player.getInventory().setChestplate(this.CostumesListener1(Material.LEATHER_CHESTPLATE, player));
                }
                player.getInventory().setLeggings(this.CostumesListener1(Material.LEATHER_LEGGINGS, player));
                player.getInventory().setBoots(this.CostumesListener1(Material.LEATHER_BOOTS, player));
            }
        }
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        if (!b && player.getGameMode() != GameMode.CREATIVE) {
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> this.CostumesListener1(player4, i), 1L);
        }
    }
    
    private void CostumesListener1(final InventoryClickEvent inventoryClickEvent, final Player player, final CostumesCostumeService4 i) {
        final ItemStack cursor = inventoryClickEvent.getCursor();
        if (cursor == null || cursor.getType() == Material.AIR) {
            switch (inventoryClickEvent.getSlot()) {
                case 39: {
                    i.CostumesListener1(null);
                    if (player.hasMetadata("costume_toggle_helmet")) {
                        player.removeMetadata("costume_toggle_helmet", this.CostumesListener1);
                        break;
                    }
                    break;
                }
                case 38: {
                    i.CostumesListener3(null);
                    if (player.hasMetadata("costume_toggle_chestplate")) {
                        player.removeMetadata("costume_toggle_chestplate", this.CostumesListener1);
                        break;
                    }
                    break;
                }
                case 37: {
                    i.CostumesListener2(null);
                    if (player.hasMetadata("costume_toggle_leggings")) {
                        player.removeMetadata("costume_toggle_leggings", this.CostumesListener1);
                        break;
                    }
                    break;
                }
                case 36: {
                    i.CostumesCostumeService1(null);
                    if (player.hasMetadata("costume_toggle_boots")) {
                        player.removeMetadata("costume_toggle_boots", this.CostumesListener1);
                        break;
                    }
                    break;
                }
            }
            this.P(player);
            inventoryClickEvent.setCancelled(false);
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> this.CostumesCostumeService1(player2), 1L);
            if (player.getGameMode() != GameMode.CREATIVE) {
                Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> this.CostumesListener1(player3, j), 1L);
            }
            return;
        }
        if (!this.CostumesListener4(cursor) || !this.CostumesListener1(cursor, inventoryClickEvent.getSlot())) {
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
                i.CostumesListener1(itemStack);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_helmet")) {
                    player.removeMetadata("costume_toggle_helmet", this.CostumesListener1);
                    break;
                }
                break;
            }
            case 38: {
                i.CostumesListener3(itemStack);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_chestplate")) {
                    player.removeMetadata("costume_toggle_chestplate", this.CostumesListener1);
                    break;
                }
                break;
            }
            case 37: {
                i.CostumesListener2(itemStack);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_leggings")) {
                    player.removeMetadata("costume_toggle_leggings", this.CostumesListener1);
                    break;
                }
                break;
            }
            case 36: {
                i.CostumesCostumeService1(itemStack);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_boots")) {
                    player.removeMetadata("costume_toggle_boots", this.CostumesListener1);
                    break;
                }
                break;
            }
        }
        this.P(player);
        if (cursor.getAmount() > 1) {
            cursor.setAmount(cursor.getAmount() - 1);
            player.getOpenInventory().setCursor(cursor);
            final ItemStack g = this.CostumesCostumeService3(itemStack);
            if (g != null) {
                g.setAmount(1);
                player.getInventory().setItem(inventoryClickEvent.getSlot(), g);
            }
        }
        else {
            player.getInventory().setItem(inventoryClickEvent.getSlot(), this.CostumesCostumeService3(itemStack));
            player.getOpenInventory().setCursor((ItemStack)null);
        }
        if (currentItem != null && currentItem.getType() != Material.AIR) {
            this.CostumesCostumeService1(player, this.CostumesCostumeService3(currentItem));
        }
        if (player.getGameMode() != GameMode.CREATIVE && !player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> this.CostumesListener1(player4, k), 1L);
        }
        Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> this.CostumesCostumeService1(player5), 2L);
        if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                if (player6.isOnline() && CostumesCostumeService6.CostumesListener4(player6)) {
                    CostumesCostumeService5.getPlayerArmorSnapshot(player6.getUniqueId());
                    final CostumesCostumeService4 l;
                    if (l != null) {
                        this.CostumesCostumeService3(player6, l);
                        Main.getInstance();
                        final Main main;
                        if (main != null) {
                            main.getCostumeDataManager();
                            final CostumesCostumeService2 e;
                            if (e != null) {
                                e.CostumesListener2(player6);
                            }
                        }
                    }
                }
            }, 5L);
        }
    }
    
    private void CostumesListener1(final Player player, final CostumesCostumeService4 i) {
        final HashMap hashMap = new HashMap();
        this.CostumesListener1(i, hashMap);
        this.CostumesListener1(player, i, hashMap);
    }
    
    private void CostumesListener1(final CostumesCostumeService4 i, final Map<Material, Map<Enchantment, Integer>> map) {
        if (i.CostumesCostumeService1() != null && i.CostumesCostumeService1().hasItemMeta() && i.CostumesCostumeService1().getItemMeta().hasEnchants()) {
            map.put(Material.LEATHER_HELMET, (HashMap)new HashMap(i.CostumesCostumeService1().getEnchantments()));
        }
        if (i.CostumesCostumeService2() != null && i.CostumesCostumeService2().hasItemMeta() && i.CostumesCostumeService2().getItemMeta().hasEnchants()) {
            map.put(Material.LEATHER_CHESTPLATE, (HashMap)new HashMap(i.CostumesCostumeService2().getEnchantments()));
        }
        if (i.CostumesListener2() != null && i.CostumesListener2().hasItemMeta() && i.CostumesListener2().getItemMeta().hasEnchants()) {
            map.put(Material.LEATHER_LEGGINGS, (HashMap)new HashMap(i.CostumesListener2().getEnchantments()));
        }
        if (i.CostumesListener1() != null && i.CostumesListener1().hasItemMeta() && i.CostumesListener1().getItemMeta().hasEnchants()) {
            map.put(Material.LEATHER_BOOTS, (HashMap)new HashMap(i.CostumesListener1().getEnchantments()));
        }
    }
    
    private void CostumesListener2(final CostumesCostumeService4 i, final Map<Material, Map<Enchantment, Integer>> map) {
        if (i.CostumesCostumeService1() != null && map.containsKey(Material.LEATHER_HELMET)) {
            final ItemStack c = i.CostumesCostumeService1();
            final ItemMeta itemMeta = c.getItemMeta();
            for (final Map.Entry entry : map.get(Material.LEATHER_HELMET).entrySet()) {
                if (!itemMeta.hasEnchant((Enchantment)entry.getKey())) {
                    itemMeta.addEnchant((Enchantment)entry.getKey(), (int)entry.getValue(), true);
                }
            }
            c.setItemMeta(itemMeta);
            i.CostumesListener1(c);
        }
        if (i.CostumesCostumeService2() != null && map.containsKey(Material.LEATHER_CHESTPLATE)) {
            final ItemStack e = i.CostumesCostumeService2();
            final ItemMeta itemMeta2 = e.getItemMeta();
            for (final Map.Entry entry2 : map.get(Material.LEATHER_CHESTPLATE).entrySet()) {
                if (!itemMeta2.hasEnchant((Enchantment)entry2.getKey())) {
                    itemMeta2.addEnchant((Enchantment)entry2.getKey(), (int)entry2.getValue(), true);
                }
            }
            e.setItemMeta(itemMeta2);
            i.CostumesListener3(e);
        }
        if (i.CostumesListener2() != null && map.containsKey(Material.LEATHER_LEGGINGS)) {
            final ItemStack b = i.CostumesListener2();
            final ItemMeta itemMeta3 = b.getItemMeta();
            for (final Map.Entry entry3 : map.get(Material.LEATHER_LEGGINGS).entrySet()) {
                if (!itemMeta3.hasEnchant((Enchantment)entry3.getKey())) {
                    itemMeta3.addEnchant((Enchantment)entry3.getKey(), (int)entry3.getValue(), true);
                }
            }
            b.setItemMeta(itemMeta3);
            i.CostumesListener2(b);
        }
        if (i.CostumesListener1() != null && map.containsKey(Material.LEATHER_BOOTS)) {
            final ItemStack a = i.CostumesListener1();
            final ItemMeta itemMeta4 = a.getItemMeta();
            for (final Map.Entry entry4 : map.get(Material.LEATHER_BOOTS).entrySet()) {
                if (!itemMeta4.hasEnchant((Enchantment)entry4.getKey())) {
                    itemMeta4.addEnchant((Enchantment)entry4.getKey(), (int)entry4.getValue(), true);
                }
            }
            a.setItemMeta(itemMeta4);
            i.CostumesCostumeService1(a);
        }
    }
    
    private ItemStack CostumesListener1(final Material material, final ItemStack itemStack, final Map<Enchantment, Integer> map, final Player player) {
        final ItemStack a = this.CostumesListener1(material, itemStack, player);
        if (map != null && !map.isEmpty()) {
            final ItemMeta itemMeta = a.getItemMeta();
            for (final Map.Entry entry : map.entrySet()) {
                itemMeta.addEnchant((Enchantment)entry.getKey(), (int)entry.getValue(), true);
            }
            a.setItemMeta(itemMeta);
        }
        return a;
    }
    
    private void CostumesListener1(final Player player, final CostumesCostumeService4 i, final Map<Material, Map<Enchantment, Integer>> map) {
        if (!CostumesCostumeService6.CostumesListener4(player)) {
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
        final ItemStack a = this.CostumesListener1(Material.LEATHER_HELMET, i.CostumesCostumeService1(), map.getOrDefault(Material.LEATHER_HELMET, (HashMap)new HashMap()), player);
        final ItemStack a2 = this.CostumesListener1(Material.LEATHER_CHESTPLATE, i.CostumesCostumeService2(), map.getOrDefault(Material.LEATHER_CHESTPLATE, (HashMap)new HashMap()), player);
        final ItemStack a3 = this.CostumesListener1(Material.LEATHER_LEGGINGS, i.CostumesListener2(), map.getOrDefault(Material.LEATHER_LEGGINGS, (HashMap)new HashMap()), player);
        final ItemStack a4 = this.CostumesListener1(Material.LEATHER_BOOTS, i.CostumesListener1(), map.getOrDefault(Material.LEATHER_BOOTS, (HashMap)new HashMap()), player);
        if (helmet == null || this.CostumesListener3(helmet)) {
            player.getInventory().setHelmet(a);
        }
        if (!i.CostumesListener3() && (chestplate == null || this.CostumesListener3(chestplate))) {
            player.getInventory().setChestplate(a2);
        }
        if (leggings == null || this.CostumesListener3(leggings)) {
            player.getInventory().setLeggings(a3);
        }
        if (boots == null || this.CostumesListener3(boots)) {
            player.getInventory().setBoots(a4);
        }
    }
    
    private void CostumesListener1(final Player player, final ItemStack currentItem, final int n, final CostumesCostumeService4 i, final InventoryClickEvent inventoryClickEvent) {
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
        if (inventoryClickEvent.getClick() == ClickType.SHIFT_LEFT && this.CostumesListener2(n) && !this.CostumesListener3(currentItem) && (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory"))) {
            inventoryClickEvent.setCancelled(true);
            currentItem.clone();
            switch (n) {
                case 39: {
                    i.CostumesListener1(null);
                    break;
                }
                case 38: {
                    i.CostumesListener3(null);
                    break;
                }
                case 37: {
                    i.CostumesListener2(null);
                    break;
                }
                case 36: {
                    i.CostumesCostumeService1(null);
                    break;
                }
            }
            this.P(player);
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                player2.getInventory().setItem(n2, (ItemStack)null);
                this.CostumesCostumeService1(player2, itemStack2);
                player2.playSound(player2.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.5f, 1.0f);
            }, 1L);
            return;
        }
        inventoryClickEvent.setCancelled(true);
        final ItemStack g = this.CostumesCostumeService3(currentItem);
        if (g != null) {
            g.setAmount(1);
        }
        switch (n) {
            case 39: {
                i.CostumesListener1(g);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_helmet")) {
                    player.removeMetadata("costume_toggle_helmet", this.CostumesListener1);
                    break;
                }
                break;
            }
            case 38: {
                i.CostumesListener3(g);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_chestplate")) {
                    player.removeMetadata("costume_toggle_chestplate", this.CostumesListener1);
                    break;
                }
                break;
            }
            case 37: {
                i.CostumesListener2(g);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_leggings")) {
                    player.removeMetadata("costume_toggle_leggings", this.CostumesListener1);
                    break;
                }
                break;
            }
            case 36: {
                i.CostumesCostumeService1(g);
                if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory") && player.hasMetadata("costume_toggle_boots")) {
                    player.removeMetadata("costume_toggle_boots", this.CostumesListener1);
                    break;
                }
                break;
            }
        }
        this.P(player);
        player.getInventory().setItem(n, this.CostumesCostumeService3(g));
        if (currentItem.getAmount() > 1) {
            currentItem.setAmount(currentItem.getAmount() - 1);
            inventoryClickEvent.setCurrentItem(currentItem);
        }
        else {
            inventoryClickEvent.setCurrentItem((ItemStack)null);
        }
        if (itemStack != null && itemStack.getType() != Material.AIR) {
            this.CostumesCostumeService1(player, this.CostumesCostumeService3(itemStack));
        }
        Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> this.CostumesCostumeService1(player3), 2L);
        if (player.getGameMode() != GameMode.CREATIVE && !player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> this.CostumesListener1(player4, j), 1L);
        }
        if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                if (player5.isOnline() && CostumesCostumeService6.CostumesListener4(player5)) {
                    CostumesCostumeService5.getPlayerArmorSnapshot(player5.getUniqueId());
                    final CostumesCostumeService4 k;
                    if (k != null) {
                        this.CostumesCostumeService3(player5, k);
                        Main.getInstance();
                        final Main main;
                        if (main != null) {
                            main.getCostumeDataManager();
                            final CostumesCostumeService2 e;
                            if (e != null) {
                                e.CostumesListener2(player5);
                            }
                        }
                    }
                }
            }, 5L);
        }
    }
    
    private void CostumesListener1(final Player player, final int n, final CostumesCostumeService4 i) {
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
                itemStack = i.CostumesCostumeService1();
                break;
            }
            case 38: {
                itemStack = i.CostumesCostumeService2();
                break;
            }
            case 37: {
                itemStack = i.CostumesListener2();
                break;
            }
            case 36: {
                itemStack = i.CostumesListener1();
                break;
            }
        }
        if (b) {
            if (itemStack != null) {
                switch (n) {
                    case 39: {
                        player.setMetadata("costume_toggle_helmet", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
                        player.getInventory().setHelmet(this.CostumesCostumeService3(itemStack));
                        break;
                    }
                    case 38: {
                        player.setMetadata("costume_toggle_chestplate", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
                        player.getInventory().setChestplate(this.CostumesCostumeService3(itemStack));
                        break;
                    }
                    case 37: {
                        player.setMetadata("costume_toggle_leggings", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
                        player.getInventory().setLeggings(this.CostumesCostumeService3(itemStack));
                        break;
                    }
                    case 36: {
                        player.setMetadata("costume_toggle_boots", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
                        player.getInventory().setBoots(this.CostumesCostumeService3(itemStack));
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
                                player.removeMetadata("costume_toggle_helmet", this.CostumesListener1);
                            }
                            player.getInventory().setHelmet(this.CostumesListener1(Material.LEATHER_HELMET, itemStack, player));
                            break;
                        }
                        case 38: {
                            if (player.hasMetadata("costume_toggle_chestplate")) {
                                player.removeMetadata("costume_toggle_chestplate", this.CostumesListener1);
                            }
                            if (!i.CostumesListener3()) {
                                player.getInventory().setChestplate(this.CostumesListener1(Material.LEATHER_CHESTPLATE, itemStack, player));
                                break;
                            }
                            break;
                        }
                        case 37: {
                            if (player.hasMetadata("costume_toggle_leggings")) {
                                player.removeMetadata("costume_toggle_leggings", this.CostumesListener1);
                            }
                            player.getInventory().setLeggings(this.CostumesListener1(Material.LEATHER_LEGGINGS, itemStack, player));
                            break;
                        }
                        case 36: {
                            if (player.hasMetadata("costume_toggle_boots")) {
                                player.removeMetadata("costume_toggle_boots", this.CostumesListener1);
                            }
                            player.getInventory().setBoots(this.CostumesListener1(Material.LEATHER_BOOTS, itemStack, player));
                            break;
                        }
                    }
                }
            }
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 2.0f);
        }
        if (!b && player.getGameMode() != GameMode.CREATIVE && !player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> this.CostumesListener1(player2, j), 1L);
        }
        else if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {}
        if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                if (player3.isOnline() && CostumesCostumeService6.CostumesListener4(player3)) {
                    CostumesCostumeService5.getPlayerArmorSnapshot(player3.getUniqueId());
                    final CostumesCostumeService4 k;
                    if (k != null) {
                        this.CostumesCostumeService3(player3, k);
                    }
                }
            }, 2L);
        }
    }
    
    private void CostumesCostumeService3(final Player player, final CostumesCostumeService4 i) {
        if (!CostumesCostumeService6.CostumesListener4(player)) {
            return;
        }
        if (player.hasMetadata("costume_hotbar_equip_in_progress")) {
            return;
        }
        if (!player.hasMetadata("costume_inventory_open") && !player.hasMetadata("costume_survival_inventory")) {
            this.CostumesCostumeService1(player);
        }
        if (player.isSneaking() || player.hasMetadata("costume_sneaking")) {
            return;
        }
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            final HashMap hashMap = new HashMap();
            this.CostumesListener1(i, hashMap);
            player.getInventory().setHelmet(this.CostumesListener1(Material.LEATHER_HELMET, i.CostumesCostumeService1(), (Map<Enchantment, Integer>)hashMap.getOrDefault(Material.LEATHER_HELMET, new HashMap()), player));
            player.getInventory().setChestplate(i.CostumesListener3() ? null : this.CostumesListener1(Material.LEATHER_CHESTPLATE, i.CostumesCostumeService2(), (Map<Enchantment, Integer>)hashMap.getOrDefault(Material.LEATHER_CHESTPLATE, new HashMap()), player));
            player.getInventory().setLeggings(this.CostumesListener1(Material.LEATHER_LEGGINGS, i.CostumesListener2(), (Map<Enchantment, Integer>)hashMap.getOrDefault(Material.LEATHER_LEGGINGS, new HashMap()), player));
            player.getInventory().setBoots(this.CostumesListener1(Material.LEATHER_BOOTS, i.CostumesListener1(), (Map<Enchantment, Integer>)hashMap.getOrDefault(Material.LEATHER_BOOTS, new HashMap()), player));
            return;
        }
        final boolean hasMetadata = player.hasMetadata("costume_toggle_helmet");
        final boolean hasMetadata2 = player.hasMetadata("costume_toggle_chestplate");
        final boolean hasMetadata3 = player.hasMetadata("costume_toggle_leggings");
        final boolean hasMetadata4 = player.hasMetadata("costume_toggle_boots");
        this.P(player);
        final HashMap hashMap = new HashMap();
        this.CostumesListener1(i, hashMap);
        for (Map.Entry entry : hashMap.entrySet()) {}
        final ItemStack a = this.CostumesListener1(Material.LEATHER_HELMET, i.CostumesCostumeService1(), (Map<Enchantment, Integer>)hashMap.getOrDefault(Material.LEATHER_HELMET, new HashMap()), player);
        final ItemStack a2 = this.CostumesListener1(Material.LEATHER_CHESTPLATE, i.CostumesCostumeService2(), (Map<Enchantment, Integer>)hashMap.getOrDefault(Material.LEATHER_CHESTPLATE, new HashMap()), player);
        final ItemStack a3 = this.CostumesListener1(Material.LEATHER_LEGGINGS, i.CostumesListener2(), (Map<Enchantment, Integer>)hashMap.getOrDefault(Material.LEATHER_LEGGINGS, new HashMap()), player);
        final ItemStack a4 = this.CostumesListener1(Material.LEATHER_BOOTS, i.CostumesListener1(), (Map<Enchantment, Integer>)hashMap.getOrDefault(Material.LEATHER_BOOTS, new HashMap()), player);
        final boolean b = player.hasMetadata("costume_temp_clear_39") || player.hasMetadata("costume_block_refresh_39");
        final boolean b2 = player.hasMetadata("costume_temp_clear_38") || player.hasMetadata("costume_block_refresh_38");
        final boolean b3 = player.hasMetadata("costume_temp_clear_37") || player.hasMetadata("costume_block_refresh_37");
        final boolean b4 = player.hasMetadata("costume_temp_clear_36") || player.hasMetadata("costume_block_refresh_36");
        this.CostumesListener1(player, i);
        final ItemStack itemStack = (!hasMetadata && !b) ? a : null;
        final ItemStack itemStack2 = (!i.CostumesListener3() && !hasMetadata2 && !b2) ? a2 : null;
        final ItemStack itemStack3 = (!hasMetadata3 && !b3) ? a3 : null;
        final ItemStack itemStack4 = (!hasMetadata4 && !b4) ? a4 : null;
        this.CostumesListener1(player, itemStack, itemStack2, itemStack3, itemStack4);
        if (player.hasMetadata("costume_temp_clear_39")) {
            player.removeMetadata("costume_temp_clear_39", this.CostumesListener1);
        }
        if (player.hasMetadata("costume_temp_clear_38")) {
            player.removeMetadata("costume_temp_clear_38", this.CostumesListener1);
        }
        if (player.hasMetadata("costume_temp_clear_37")) {
            player.removeMetadata("costume_temp_clear_37", this.CostumesListener1);
        }
        if (player.hasMetadata("costume_temp_clear_36")) {
            player.removeMetadata("costume_temp_clear_36", this.CostumesListener1);
        }
        if (player.hasMetadata("costume_block_refresh_39")) {
            player.removeMetadata("costume_block_refresh_39", this.CostumesListener1);
        }
        if (player.hasMetadata("costume_block_refresh_38")) {
            player.removeMetadata("costume_block_refresh_38", this.CostumesListener1);
        }
        if (player.hasMetadata("costume_block_refresh_37")) {
            player.removeMetadata("costume_block_refresh_37", this.CostumesListener1);
        }
        if (player.hasMetadata("costume_block_refresh_36")) {
            player.removeMetadata("costume_block_refresh_36", this.CostumesListener1);
        }
    }
    
    private void CostumesListener2(final Player player, final CostumesCostumeService4 i) {
        if (!CostumesCostumeService6.CostumesListener4(player)) {
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
        if (CostumesCostumeService6.CostumesListener1(player) != null) {
            final ItemStack b = this.CostumesListener2(Material.LEATHER_HELMET, i.CostumesCostumeService1(), player);
            final ItemStack b2 = this.CostumesListener2(Material.LEATHER_CHESTPLATE, i.CostumesCostumeService2(), player);
            final ItemStack b3 = this.CostumesListener2(Material.LEATHER_LEGGINGS, i.CostumesListener2(), player);
            final ItemStack b4 = this.CostumesListener2(Material.LEATHER_BOOTS, i.CostumesListener1(), player);
            this.CostumesListener1(player, i);
            final ItemStack itemStack = (helmet == null || this.CostumesListener3(helmet)) ? b : null;
            final ItemStack itemStack2 = (!i.CostumesListener3() && (chestplate == null || this.CostumesListener3(chestplate))) ? b2 : null;
            final ItemStack itemStack3 = (leggings == null || this.CostumesListener3(leggings)) ? b3 : null;
            final ItemStack itemStack4 = (boots == null || this.CostumesListener3(boots)) ? b4 : null;
            this.CostumesListener1(player, itemStack, itemStack2, itemStack3, itemStack4);
            player.setMetadata("costume_silent_refresh", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                if (player2.isOnline() && CostumesCostumeService6.CostumesListener4(player2)) {
                    CostumesCostumeService5.getPlayerArmorSnapshot(player2.getUniqueId());
                    final CostumesCostumeService4 j;
                    if (j != null) {
                        this.CostumesCostumeService3(player2, j);
                    }
                }
                return;
            }, 1L);
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                if (player3.isOnline()) {
                    player3.removeMetadata("costume_silent_refresh", this.CostumesListener1);
                }
            }, 20L);
        }
    }

    private void CostumesListener1(final Player player, final CostumesCostumeService4 i) {
        if (i == null) {
            return;
        }
        player.getInventory().setHelmet((i.CostumesCostumeService1() != null) ? i.CostumesCostumeService1().clone() : null);
        player.getInventory().setChestplate((i.CostumesCostumeService2() != null) ? i.CostumesCostumeService2().clone() : null);
        player.getInventory().setLeggings((i.CostumesListener2() != null) ? i.CostumesListener2().clone() : null);
        player.getInventory().setBoots((i.CostumesListener1() != null) ? i.CostumesListener1().clone() : null);
    }

    private void CostumesListener1(final Player player, final ItemStack itemStack, final ItemStack itemStack2, final ItemStack itemStack3, final ItemStack itemStack4) {
        for (final Player player2 : Bukkit.getOnlinePlayers()) {
            if (player2 == null || !player2.isOnline()) {
                continue;
            }
            player2.sendEquipmentChange(player, EquipmentSlot.HEAD, (itemStack != null) ? itemStack : player.getInventory().getHelmet());
            player2.sendEquipmentChange(player, EquipmentSlot.CHEST, (itemStack2 != null) ? itemStack2 : player.getInventory().getChestplate());
            player2.sendEquipmentChange(player, EquipmentSlot.LEGS, (itemStack3 != null) ? itemStack3 : player.getInventory().getLeggings());
            player2.sendEquipmentChange(player, EquipmentSlot.FEET, (itemStack4 != null) ? itemStack4 : player.getInventory().getBoots());
        }
    }
    
    private void CostumesCostumeService1(final Player player) {
        this.M(player);
    }
    
    private void M(final Player player) {
        final ItemStack helmet = player.getInventory().getHelmet();
        final ItemStack chestplate = player.getInventory().getChestplate();
        final ItemStack leggings = player.getInventory().getLeggings();
        final ItemStack boots = player.getInventory().getBoots();
        if (chestplate != null && this.CostumesListener2(chestplate)) {
            player.getInventory().setChestplate((ItemStack)null);
        }
        if (helmet != null && this.CostumesListener2(helmet)) {
            player.getInventory().setHelmet((ItemStack)null);
        }
        if (leggings != null && this.CostumesListener2(leggings)) {
            player.getInventory().setLeggings((ItemStack)null);
        }
        if (boots != null && this.CostumesListener2(boots)) {
            player.getInventory().setBoots((ItemStack)null);
        }
        for (int i = 0; i < 36; ++i) {
            final ItemStack item = player.getInventory().getItem(i);
            if (item != null) {
                final String s = (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) ? item.getItemMeta().getDisplayName() : item.getType().name();
            }
            if (item != null && this.CostumesListener3(item) && !this.CostumesListener2(item)) {
                final CostumesCostumeService4 playerArmorSnapshot = CostumesCostumeService5.getPlayerArmorSnapshot(player.getUniqueId());
                if (playerArmorSnapshot != null) {
                    ItemStack itemStack = null;
                    if (item.getType() == Material.LEATHER_HELMET || item.getType() == Material.PLAYER_HEAD) {
                        itemStack = playerArmorSnapshot.CostumesCostumeService1();
                    }
                    else if (item.getType() == Material.LEATHER_CHESTPLATE) {
                        itemStack = playerArmorSnapshot.CostumesCostumeService2();
                    }
                    else if (item.getType() == Material.LEATHER_LEGGINGS) {
                        itemStack = playerArmorSnapshot.CostumesListener2();
                    }
                    else if (item.getType() == Material.LEATHER_BOOTS) {
                        itemStack = playerArmorSnapshot.CostumesListener1();
                    }
                    if (!this.CostumesListener2(item)) {
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
    
    private void CostumesListener1(final Player player, final ItemStack itemStack, final int n, final CostumesCostumeService4 i) {
        this.CostumesListener1(player, itemStack, n, player.getInventory().getHeldItemSlot(), player.getInventory().getItem(n), i);
    }
    
    private boolean CostumesCostumeService4(final Player player) {
        for (int i = 0; i < 36; ++i) {
            final ItemStack item = player.getInventory().getItem(i);
            if (item != null && this.CostumesListener3(item)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean CostumesListener5(final Player player) {
        final boolean b = player.hasMetadata("costume_toggle_helmet") || player.hasMetadata("costume_toggle_chestplate") || player.hasMetadata("costume_toggle_leggings") || player.hasMetadata("costume_toggle_boots");
        final boolean b2 = player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory");
        final boolean hasMetadata = player.hasMetadata("costume_sneaking");
        final boolean hasMetadata2 = player.hasMetadata("costume_edit_mode");
        return b || b2 || hasMetadata || hasMetadata2;
    }
    
    private boolean CostumesListener2(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if (itemStack.hasItemMeta()) {
            try {
                if (itemStack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(this.CostumesListener1, "costume_type"), PersistentDataType.STRING)) {
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
    
    private boolean CostumesListener3(final ItemStack itemStack) {
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
    
    private boolean CostumesListener4(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        final Material type = itemStack.getType();
        if (type == Material.PLAYER_HEAD) {
            return !this.CostumesCostumeService2(itemStack);
        }
        return type.name().contains("HELMET") || type.name().contains("CHESTPLATE") || type.name().contains("LEGGINGS") || type.name().contains("BOOTS") || type == Material.ELYTRA;
    }
    
    private boolean CostumesListener2(final int n) {
        return n == 36 || n == 37 || n == 38 || n == 39;
    }
    
    private int CostumesCostumeService1(final ItemStack itemStack) {
        if (itemStack == null) {
            return -1;
        }
        final Material type = itemStack.getType();
        if (type.name().contains("HELMET")) {
            return 39;
        }
        if (type == Material.PLAYER_HEAD && !this.CostumesCostumeService2(itemStack)) {
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
    
    private boolean CostumesListener1(final ItemStack itemStack, final int n) {
        return itemStack != null && this.CostumesCostumeService1(itemStack) == n;
    }
    
    private ItemStack CostumesCostumeService3(final ItemStack itemStack) {
        return (itemStack != null) ? itemStack.clone() : null;
    }
    
    private void CostumesListener1(final String str, final ItemStack itemStack) {
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
            final CostumesCostumeService2 costumeDataManager = instance.getCostumeDataManager();
            if (costumeDataManager != null) {
                costumeDataManager.CostumesListener2(player);
            }
        }
    }
    
    private void CostumesCostumeService1(final Player player, final ItemStack itemStack) {
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
    
    private ItemStack CostumesListener1(final Material material, final Player player) {
        return this.CostumesListener2(material, null, player);
    }
    
    private ItemStack CostumesListener2(final Material material, final ItemStack itemStack, final Player player) {
        final CostumesCostumeService1 a = CostumesCostumeService6.CostumesListener1(player);
        String displayName;
        ItemStack itemStack2;
        if (a instanceof final pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService2 e) {
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
        else if (a instanceof final pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener1 a2) {
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
        else if (a instanceof final CostumesCostumeService3 g) {
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
        else if (a instanceof final CostumesListener5 h) {
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
        else if (a instanceof final CostumesListener2 b) {
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
        else if (a instanceof final pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService1 c) {
            displayName = "§7Zbroja §bNurka CostumesCostumeService3\u0142\u0119binowego";
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
        else if (a instanceof final CostumesListener2 b2) {
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
        else if (a instanceof final pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService1 c2) {
            displayName = "§7Zbroja §bNurka CostumesCostumeService3\u0142\u0119binowego";
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
        else if (a instanceof final CostumesListener4 f) {
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
        else if (a instanceof final CostumesListener3 d) {
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
            final pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService2 e2 = new pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService2();
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
                final CostumesListener6 enchantedBookSupport = instance.getEnchantedBookSupport();
                if (enchantedBookSupport != null) {
                    enchantedBookSupport.copyEnchantsToLore(itemStack, itemStack2);
                }
            }
        }
        return itemStack2;
    }
    
    private ItemStack CostumesListener1(final Material material, final ItemStack itemStack, final Player player) {
        if (itemStack == null) {
            return this.CostumesListener1(material, player);
        }
        final ItemStack b = this.CostumesListener2(material, itemStack, player);
        if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasEnchants()) {
            final ItemMeta itemMeta = b.getItemMeta();
            for (final Enchantment enchantment : itemStack.getEnchantments().keySet()) {
                itemMeta.addEnchant(enchantment, itemStack.getEnchantmentLevel(enchantment), true);
            }
            b.setItemMeta(itemMeta);
        }
        this.CostumesListener1(itemStack, b);
        return b;
    }
    
    private void CostumesListener1(final ItemStack itemStack, final ItemStack itemStack2) {
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
            final double a = this.CostumesListener1(itemStack.getType());
            final double b = this.CostumesListener2(itemStack.getType());
            final double c = this.CostumesCostumeService1(itemStack.getType());
            if (a > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "costume_armor", a, AttributeModifier.Operation.ADD_NUMBER, this.CostumesListener3(itemStack2.getType())));
            }
            if (b > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "costume_toughness", b, AttributeModifier.Operation.ADD_NUMBER, this.CostumesListener3(itemStack2.getType())));
            }
            if (c > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "costume_knockback_resistance", c, AttributeModifier.Operation.ADD_NUMBER, this.CostumesListener3(itemStack2.getType())));
            }
            itemStack2.setItemMeta(itemMeta2);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private double CostumesListener1(final Material material) {
        switch (CostumesListener1$1.CostumesListener1[material.ordinal()]) {
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
    
    private double CostumesListener2(final Material material) {
        switch (CostumesListener1$1.CostumesListener1[material.ordinal()]) {
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
    
    private double CostumesCostumeService1(final Material material) {
        switch (CostumesListener1$1.CostumesListener1[material.ordinal()]) {
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
    
    private EquipmentSlot CostumesListener3(final Material material) {
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
    
    private ItemStack CostumesListener1(final String s) {
        final ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        final SkullMeta itemMeta = (SkullMeta)itemStack.getItemMeta();
        if (itemMeta != null) {
            pl.ziffy.STORMSZAFKA.utils.CostumesCostumeService1.CostumesListener3(itemMeta, s);
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
        if (!CostumesCostumeService6.CostumesListener4(player)) {
            return;
        }
        if ((inventoryClickEvent.getClick() == ClickType.SHIFT_LEFT || inventoryClickEvent.getClick() == ClickType.SHIFT_RIGHT) && this.CostumesListener2(inventoryClickEvent.getSlot()) && inventoryClickEvent.getCurrentItem() != null && !this.CostumesListener3(inventoryClickEvent.getCurrentItem()) && this.CostumesListener4(inventoryClickEvent.getCurrentItem())) {
            final CostumesCostumeService4 playerArmorSnapshot = CostumesCostumeService5.getPlayerArmorSnapshot(player.getUniqueId());
            if (playerArmorSnapshot == null) {
                return;
            }
            switch (inventoryClickEvent.getSlot()) {
                case 39: {
                    playerArmorSnapshot.CostumesListener1(null);
                    break;
                }
                case 38: {
                    playerArmorSnapshot.CostumesListener3(null);
                    break;
                }
                case 37: {
                    playerArmorSnapshot.CostumesListener2(null);
                    break;
                }
                case 36: {
                    playerArmorSnapshot.CostumesCostumeService1(null);
                    break;
                }
            }
            this.P(player);
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                if (player2.isOnline() && CostumesCostumeService6.CostumesListener4(player2)) {
                    this.CostumesCostumeService3(player2, i);
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
        if (!CostumesCostumeService6.CostumesListener4(player)) {
            return;
        }
        final ItemStack item = playerInteractEvent.getItem();
        if (item == null) {
            return;
        }
        if (this.CostumesCostumeService2(item) || this.CostumesListener2(item)) {
            return;
        }
        if (!this.CostumesListener4(item) || this.CostumesListener3(item)) {
            return;
        }
        if (player.hasMetadata("costume_hotbar_equip_in_progress")) {
            playerInteractEvent.setCancelled(true);
            return;
        }
        final CostumesCostumeService4 playerArmorSnapshot = CostumesCostumeService5.getPlayerArmorSnapshot(player.getUniqueId());
        if (playerArmorSnapshot == null) {
            return;
        }
        final int c = this.CostumesCostumeService1(item);
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
        this.CostumesListener1(player, item, c, heldItemSlot, item2, playerArmorSnapshot);
    }
    
    private void CostumesListener1(final Player player, final ItemStack itemStack, final int n, final int n2, final ItemStack itemStack2, final CostumesCostumeService4 i) {
        ItemStack itemStack3 = null;
        switch (n) {
            case 39: {
                itemStack3 = i.CostumesCostumeService1();
                break;
            }
            case 38: {
                itemStack3 = i.CostumesCostumeService2();
                break;
            }
            case 37: {
                itemStack3 = i.CostumesListener2();
                break;
            }
            case 36: {
                itemStack3 = i.CostumesListener1();
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
                i.CostumesListener1(clone);
                break;
            }
            case 38: {
                i.CostumesListener3(clone);
                break;
            }
            case 37: {
                i.CostumesListener2(clone);
                break;
            }
            case 36: {
                i.CostumesCostumeService1(clone);
                break;
            }
        }
        player.setMetadata("costume_hotbar_equip_in_progress", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
        player.getInventory().setItem(n2, (itemStack3 != null) ? itemStack3.clone() : null);
        player.getInventory().setItem(n, clone);
        this.P(player);
        CostumesCostumeService5.storeArmorSnapshot(player.getUniqueId(), i);
        Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
            if (player2.isOnline() && CostumesCostumeService6.CostumesListener4(player2)) {
                player2.removeMetadata("costume_hotbar_equip_in_progress", this.CostumesListener1);
                CostumesCostumeService5.getPlayerArmorSnapshot(player2.getUniqueId());
                final CostumesCostumeService4 j;
                if (j != null) {
                    this.CostumesListener2(player2, j);
                }
                player2.playSound(player2.getLocation(), this.CostumesListener1(itemStack4), 1.0f, 1.0f);
            }
        }, 1L);
    }
    
    private Sound CostumesListener1(final ItemStack itemStack) {
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
    
    private String CostumesListener1(final int n) {
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
