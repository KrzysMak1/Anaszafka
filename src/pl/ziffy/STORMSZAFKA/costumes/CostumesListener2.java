// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import java.util.function.Predicate;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.meta.SkullMeta;
import java.util.UUID;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.Attribute;
import java.util.Iterator;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.Color;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener3;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener5;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener4;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService3;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener1;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.EquipmentSlot;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService2;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;

public class CostumesListener2 implements Listener
{
    private final Plugin CostumesListener1;
    
    public void registerInventoryListener() {
    }
    
    public CostumesListener2(final Plugin a) {
        this.CostumesListener1 = a;
        this.registerInventoryListener();
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(final PlayerInteractEvent playerInteractEvent) {
        if (playerInteractEvent.isCancelled()) {
            return;
        }
        final Player player = playerInteractEvent.getPlayer();
        final ItemStack item = playerInteractEvent.getItem();
        if (item != null && item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
            final String displayName = item.getItemMeta().getDisplayName();
            boolean b = false;
            if (item.getType() == Material.LEATHER_CHESTPLATE || item.getType() == Material.LEATHER_HELMET || item.getType() == Material.LEATHER_LEGGINGS || item.getType() == Material.LEATHER_BOOTS) {
                if (displayName.toLowerCase().contains("kostium") || displayName.toLowerCase().contains("costume")) {
                    b = true;
                }
                if (displayName.toLowerCase().contains("zab\u00f3jczego kr\u00f3lika") || displayName.toLowerCase().contains("zabojczego krolika")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (CostumesCostumeService6.CostumesListener4(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.CostumesListener1 languageManager = Main.getLanguageManager();
                            if (languageManager != null) {
                                player.sendMessage(languageManager.CostumesListener4("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        CostumesCostumeService6.CostumesListener1(player, new CostumesCostumeService2());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)"zabojczykrolik"));
                    }
                }
                if (displayName.toLowerCase().contains("walentynkowy") || displayName.toLowerCase().contains("valentine")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (CostumesCostumeService6.CostumesListener4(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.CostumesListener1 languageManager2 = Main.getLanguageManager();
                            if (languageManager2 != null) {
                                player.sendMessage(languageManager2.CostumesListener4("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        CostumesCostumeService6.CostumesListener1(player, new CostumesListener1());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)"walentynkowy"));
                    }
                }
                if (displayName.toLowerCase().contains("przeciwzaka\u017ceniowy") || displayName.toLowerCase().contains("przeciwzakazeniowy")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (CostumesCostumeService6.CostumesListener4(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.CostumesListener1 languageManager3 = Main.getLanguageManager();
                            if (languageManager3 != null) {
                                player.sendMessage(languageManager3.CostumesListener4("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        CostumesCostumeService6.CostumesListener1(player, new CostumesCostumeService3());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)"przeciwzakazeniowy"));
                    }
                }
                if (displayName.toLowerCase().contains("mima")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (CostumesCostumeService6.CostumesListener4(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.CostumesListener1 languageManager4 = Main.getLanguageManager();
                            if (languageManager4 != null) {
                                player.sendMessage(languageManager4.CostumesListener4("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        CostumesCostumeService6.CostumesListener1(player, new pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener2());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)"mima"));
                    }
                }
                if (displayName.toLowerCase().contains("pirata")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (CostumesCostumeService6.CostumesListener4(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.CostumesListener1 languageManager5 = Main.getLanguageManager();
                            if (languageManager5 != null) {
                                player.sendMessage(languageManager5.CostumesListener4("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        CostumesCostumeService6.CostumesListener1(player, new CostumesListener4());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)"pirata"));
                    }
                }
                if (displayName.toLowerCase().contains("nurek") || displayName.toLowerCase().contains("g\u0142\u0119binowy") || displayName.toLowerCase().contains("gl\u0119binowy")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (CostumesCostumeService6.CostumesListener4(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.CostumesListener1 languageManager6 = Main.getLanguageManager();
                            if (languageManager6 != null) {
                                player.sendMessage(languageManager6.CostumesListener4("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        CostumesCostumeService6.CostumesListener1(player, new pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService1());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)"nurkglebinowy"));
                    }
                }
                if (displayName.toLowerCase().contains("ma\u0142ego urwisa") || displayName.toLowerCase().contains("malyurwis") || displayName.toLowerCase().contains("ma\u0142y urwis")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (CostumesCostumeService6.CostumesListener4(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.CostumesListener1 languageManager7 = Main.getLanguageManager();
                            if (languageManager7 != null) {
                                player.sendMessage(languageManager7.CostumesListener4("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        CostumesCostumeService6.CostumesListener1(player, new CostumesListener5());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)"malyurwis"));
                    }
                }
                if (displayName.toLowerCase().contains("wampira") || displayName.toLowerCase().contains("wampir")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (CostumesCostumeService6.CostumesListener4(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.CostumesListener1 languageManager8 = Main.getLanguageManager();
                            if (languageManager8 != null) {
                                player.sendMessage(languageManager8.CostumesListener4("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        CostumesCostumeService6.CostumesListener1(player, new CostumesListener3());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)"wampir"));
                    }
                }
            }
            if (b) {
                playerInteractEvent.setCancelled(true);
                player.setMetadata("costume_interaction", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
                Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                    if (player2.hasMetadata("costume_interaction")) {
                        player2.removeMetadata("costume_interaction", this.CostumesListener1);
                    }
                    return;
                }, 5L);
            }
        }
        if ("wampir".equals(CostumesCostumeService6.CostumesListener3(player))) {
            if (item != null && item.getType().name().contains("SHULKER_BOX")) {
                playerInteractEvent.setCancelled(false);
            }
            else if (playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK && playerInteractEvent.getClickedBlock() != null && playerInteractEvent.getClickedBlock().getType().name().contains("SHULKER_BOX")) {
                playerInteractEvent.setCancelled(false);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryOpen(final InventoryOpenEvent inventoryOpenEvent) {
        if (!(inventoryOpenEvent.getPlayer() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryOpenEvent.getPlayer();
        CostumesCostumeService6.CostumesListener4(player);
        if (inventoryOpenEvent.getView().getType() == InventoryType.PLAYER || inventoryOpenEvent.getView().getType() == InventoryType.CRAFTING) {
            this.CostumesListener3(player);
        }
    }
    
    private void CostumesListener3(final Player player) {
        player.setMetadata("costume_inventory_open", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
        player.setMetadata("costume_survival_inventory", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
        if (CostumesCostumeService6.CostumesListener4(player)) {
            final CostumesCostumeService4 playerArmorSnapshot = CostumesCostumeService5.getPlayerArmorSnapshot(player.getUniqueId());
            if (playerArmorSnapshot != null) {
                if (playerArmorSnapshot.CostumesCostumeService1() != null) {
                    player.getInventory().setHelmet(playerArmorSnapshot.CostumesCostumeService1().clone());
                }
                else {
                    player.getInventory().setHelmet((ItemStack)null);
                }
                if (!playerArmorSnapshot.CostumesListener3()) {
                    if (playerArmorSnapshot.CostumesCostumeService2() != null) {
                        player.getInventory().setChestplate(playerArmorSnapshot.CostumesCostumeService2().clone());
                    }
                    else {
                        player.getInventory().setChestplate((ItemStack)null);
                    }
                }
                if (playerArmorSnapshot.CostumesListener2() != null) {
                    player.getInventory().setLeggings(playerArmorSnapshot.CostumesListener2().clone());
                }
                else {
                    player.getInventory().setLeggings((ItemStack)null);
                }
                if (playerArmorSnapshot.CostumesListener1() != null) {
                    player.getInventory().setBoots(playerArmorSnapshot.CostumesListener1().clone());
                }
                else {
                    player.getInventory().setBoots((ItemStack)null);
                }
            }
        }
    }
    
    private ItemStack CostumesListener1(final Material material, final ItemStack itemStack, final Player player) {
        String displayName = "§7Nieznany kostium";
        final CostumesCostumeService1 a = CostumesCostumeService6.CostumesListener1(player);
        ItemStack itemStack2;
        if (a instanceof final CostumesCostumeService2 e) {
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
        else if (a instanceof final CostumesListener1 a2) {
            displayName = "§7Kostium §dwalentynkowy";
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
            displayName = "§7Kostium §aprzeciwzaka\u017ceniowy";
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
            displayName = "§7Kostium §fma\u0142ego urwisa";
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
        else if (a instanceof final pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener2 b) {
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
        else if (a instanceof final CostumesListener4 f) {
            displayName = "§7Zbroja §6Pirata";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = f.createCustomHead(f.getHelmetTexture());
            }
            else {
                Color color7 = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color7 = f.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color7 = f.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color7 = f.getBootsColor();
                }
                itemStack2 = f.createColoredArmor(material, color7);
            }
        }
        else if (a instanceof final CostumesListener3 d) {
            displayName = "§7Zbroja §cwampira";
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = d.createCustomHead(d.getHelmetTexture());
            }
            else {
                Color color8 = Color.WHITE;
                if (material == Material.LEATHER_CHESTPLATE) {
                    color8 = d.getChestplateColor();
                }
                else if (material == Material.LEATHER_LEGGINGS) {
                    color8 = d.getLeggingsColor();
                }
                else if (material == Material.LEATHER_BOOTS) {
                    color8 = d.getBootsColor();
                }
                itemStack2 = d.createColoredArmor(material, color8);
            }
        }
        else {
            itemStack2 = new ItemStack(material);
            if (material == Material.LEATHER_HELMET) {
                itemStack2 = new ItemStack(Material.PLAYER_HEAD);
            }
        }
        final ItemMeta itemMeta = itemStack2.getItemMeta();
        itemMeta.setDisplayName(displayName);
        final ArrayList lore = new ArrayList();
        lore.add("§7");
        lore.add("§e§lKliknij§r §7aby prze\u0142\u0105czy\u0107 ca\u0142\u0105 §fzbroj\u0119§7!");
        itemMeta.setLore((List)lore);
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_DESTROYS });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_PLACED_ON });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_POTION_EFFECTS });
        itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_DYE });
        itemStack2.setItemMeta(itemMeta);
        if (itemStack != null) {
            if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasEnchants()) {
                final ItemMeta itemMeta2 = itemStack2.getItemMeta();
                for (final Enchantment enchantment : itemStack.getEnchantments().keySet()) {
                    itemMeta2.addEnchant(enchantment, itemStack.getEnchantmentLevel(enchantment), true);
                }
                itemStack2.setItemMeta(itemMeta2);
            }
            this.CostumesListener1(itemStack, itemStack2);
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
    
    private ItemStack CostumesListener1(final Material material, final Player player) {
        return this.CostumesListener1(material, null, player);
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
            final double d = this.CostumesListener3(itemStack.getType());
            final double c = this.CostumesCostumeService1(itemStack.getType());
            final double b = this.CostumesListener2(itemStack.getType());
            if (d > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "costume_armor", d, AttributeModifier.Operation.ADD_NUMBER, this.CostumesListener1(itemStack2.getType())));
            }
            if (c > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "costume_toughness", c, AttributeModifier.Operation.ADD_NUMBER, this.CostumesListener1(itemStack2.getType())));
            }
            if (b > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "costume_knockback_resistance", b, AttributeModifier.Operation.ADD_NUMBER, this.CostumesListener1(itemStack2.getType())));
            }
            itemStack2.setItemMeta(itemMeta2);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private double CostumesListener3(final Material material) {
        switch (CostumesListener2$2.CostumesListener1[material.ordinal()]) {
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
    
    private double CostumesCostumeService1(final Material material) {
        switch (CostumesListener2$2.CostumesListener1[material.ordinal()]) {
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
    
    private double CostumesListener2(final Material material) {
        switch (CostumesListener2$2.CostumesListener1[material.ordinal()]) {
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
    
    private EquipmentSlot CostumesListener1(final Material material) {
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
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClose(final InventoryCloseEvent inventoryCloseEvent) {
        if (!(inventoryCloseEvent.getPlayer() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryCloseEvent.getPlayer();
        final boolean b = inventoryCloseEvent.getView().getType() == InventoryType.CRAFTING || inventoryCloseEvent.getView().getType() == InventoryType.PLAYER || player.hasMetadata("costume_survival_inventory") || player.hasMetadata("costume_inventory_open");
        if (player.hasMetadata("costume_survival_inventory")) {
            this.CostumesListener4(player);
            return;
        }
        final boolean hasMetadata = player.hasMetadata("costume_inventory_open");
        if (b) {
            player.removeMetadata("costume_toggle_helmet", this.CostumesListener1);
            player.removeMetadata("costume_toggle_chestplate", this.CostumesListener1);
            player.removeMetadata("costume_toggle_leggings", this.CostumesListener1);
            player.removeMetadata("costume_toggle_boots", this.CostumesListener1);
            player.removeMetadata("costume_edit_mode", this.CostumesListener1);
            player.removeMetadata("costume_inventory_open", this.CostumesListener1);
            player.removeMetadata("costume_survival_inventory", this.CostumesListener1);
        }
        if (CostumesCostumeService6.CostumesListener4(player)) {
            if (hasMetadata) {}
            if (hasMetadata) {
                player.setMetadata("was_inventory", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
            }
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                if (player2.isOnline() && CostumesCostumeService6.CostumesListener4(player2)) {
                    if (!player2.isSneaking() && !player2.hasMetadata("costume_sneaking")) {
                        if (player2.hasMetadata("was_inventory")) {
                            player2.removeMetadata("was_inventory", this.CostumesListener1);
                            CostumesCostumeService6.CostumesListener1(player2);
                            final CostumesCostumeService1 c;
                            if (c != null) {
                                player2.hasMetadata("costume_silent_refresh");
                                c.restoreCostume(player2);
                                final boolean b2;
                                if (!b2 && player2.hasMetadata("costume_silent_refresh")) {
                                    player2.removeMetadata("costume_silent_refresh", this.CostumesListener1);
                                }
                                Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                                    if (player3.isOnline()) {
                                        player3.getNearbyEntities(50.0, 50.0, 50.0).iterator();
                                        final Iterator iterator;
                                        while (iterator.hasNext()) {
                                            final Entity entity = iterator.next();
                                            if (entity instanceof final Player player4) {
                                                player4.hidePlayer(this.CostumesListener1, player3);
                                                player4.showPlayer(this.CostumesListener1, player3);
                                            }
                                        }
                                    }
                                    return;
                                }, 2L);
                                player2.playSound(player2.getLocation(), Sound.ITEM_ARMOR_EQUIP_LEATHER, 1.0f, 1.0f);
                                Main.getInstance();
                                final Main main;
                                if (main != null) {
                                    main.getCostumeDataManager();
                                    final pl.ziffy.STORMSZAFKA.data.CostumesCostumeService2 e;
                                    if (e != null) {
                                        e.CostumesListener2(player2);
                                    }
                                }
                                return;
                            }
                        }
                        CostumesCostumeService5.getPlayerArmorSnapshot(player2.getUniqueId());
                        final CostumesCostumeService4 i;
                        if (i != null) {
                            player2.getInventory().getHelmet();
                            player2.getInventory().getChestplate();
                            player2.getInventory().getLeggings();
                            player2.getInventory().getBoots();
                            final ItemStack itemStack;
                            if (itemStack != null && !this.CostumesListener1(itemStack)) {
                                i.CostumesListener1(itemStack.clone());
                            }
                            else if (itemStack == null) {
                                i.CostumesListener1(null);
                            }
                            final ItemStack itemStack2;
                            if (itemStack2 != null && !this.CostumesListener1(itemStack2)) {
                                i.CostumesListener3(itemStack2.clone());
                            }
                            else if (itemStack2 == null) {
                                i.CostumesListener3(null);
                            }
                            final ItemStack itemStack3;
                            if (itemStack3 != null && !this.CostumesListener1(itemStack3)) {
                                i.CostumesListener2(itemStack3.clone());
                            }
                            else if (itemStack3 == null) {
                                i.CostumesListener2(null);
                            }
                            final ItemStack itemStack4;
                            if (itemStack4 != null && !this.CostumesListener1(itemStack4)) {
                                i.CostumesCostumeService1(itemStack4.clone());
                            }
                            else if (itemStack4 == null) {
                                i.CostumesCostumeService1(null);
                            }
                            this.CostumesListener1(Material.LEATHER_HELMET, i.CostumesCostumeService1(), player2);
                            this.CostumesListener1(Material.LEATHER_CHESTPLATE, i.CostumesCostumeService2(), player2);
                            this.CostumesListener1(Material.LEATHER_LEGGINGS, i.CostumesListener2(), player2);
                            this.CostumesListener1(Material.LEATHER_BOOTS, i.CostumesListener1(), player2);
                            final ItemStack helmet;
                            player2.getInventory().setHelmet(helmet);
                            if (!i.CostumesListener3()) {
                                final ItemStack chestplate;
                                player2.getInventory().setChestplate(chestplate);
                            }
                            final ItemStack leggings;
                            player2.getInventory().setLeggings(leggings);
                            final ItemStack boots;
                            player2.getInventory().setBoots(boots);
                            Main.getInstance();
                            final Main main2;
                            if (main2 != null) {
                                main2.getCostumeDataManager();
                                final pl.ziffy.STORMSZAFKA.data.CostumesCostumeService2 e2;
                                if (e2 != null) {
                                    e2.CostumesListener2(player2);
                                }
                            }
                        }
                        else {
                            CostumesCostumeService6.CostumesListener2(player2);
                        }
                    }
                }
            }, 2L);
        }
    }
    
    private void CostumesListener4(final Player player) {
        player.removeMetadata("costume_toggle_helmet", this.CostumesListener1);
        player.removeMetadata("costume_toggle_chestplate", this.CostumesListener1);
        player.removeMetadata("costume_toggle_leggings", this.CostumesListener1);
        player.removeMetadata("costume_toggle_boots", this.CostumesListener1);
        player.removeMetadata("costume_survival_inventory", this.CostumesListener1);
        player.removeMetadata("costume_inventory_open", this.CostumesListener1);
        player.removeMetadata("costume_edit_mode", this.CostumesListener1);
        if (CostumesCostumeService6.CostumesListener4(player)) {
            if (player.isSneaking() || player.hasMetadata("costume_sneaking")) {
                return;
            }
            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                if (player2.isOnline() && CostumesCostumeService6.CostumesListener4(player2)) {
                    CostumesCostumeService6.CostumesListener1(player2);
                    final CostumesCostumeService1 c;
                    if (c != null) {
                        CostumesCostumeService5.getPlayerArmorSnapshot(player2.getUniqueId());
                        final CostumesCostumeService4 i;
                        if (i != null) {
                            player2.getInventory().getHelmet();
                            player2.getInventory().getChestplate();
                            player2.getInventory().getLeggings();
                            player2.getInventory().getBoots();
                            final ItemStack itemStack;
                            if (itemStack != null && !this.CostumesListener1(itemStack)) {
                                i.CostumesListener1(itemStack.clone());
                            }
                            else if (itemStack == null) {
                                i.CostumesListener1(null);
                            }
                            final ItemStack itemStack2;
                            if (itemStack2 != null && !this.CostumesListener1(itemStack2)) {
                                i.CostumesListener3(itemStack2.clone());
                            }
                            else if (itemStack2 == null) {
                                i.CostumesListener3(null);
                            }
                            final ItemStack itemStack3;
                            if (itemStack3 != null && !this.CostumesListener1(itemStack3)) {
                                i.CostumesListener2(itemStack3.clone());
                            }
                            else if (itemStack3 == null) {
                                i.CostumesListener2(null);
                            }
                            final ItemStack itemStack4;
                            if (itemStack4 != null && !this.CostumesListener1(itemStack4)) {
                                i.CostumesCostumeService1(itemStack4.clone());
                            }
                            else if (itemStack4 == null) {
                                i.CostumesCostumeService1(null);
                            }
                        }
                        if (i != null) {
                            this.CostumesListener1(Material.LEATHER_HELMET, i.CostumesCostumeService1(), player2);
                            this.CostumesListener1(Material.LEATHER_CHESTPLATE, i.CostumesCostumeService2(), player2);
                            this.CostumesListener1(Material.LEATHER_LEGGINGS, i.CostumesListener2(), player2);
                            this.CostumesListener1(Material.LEATHER_BOOTS, i.CostumesListener1(), player2);
                            final ItemStack helmet;
                            player2.getInventory().setHelmet(helmet);
                            if (!i.CostumesListener3()) {
                                final ItemStack chestplate;
                                player2.getInventory().setChestplate(chestplate);
                            }
                            final ItemStack leggings;
                            player2.getInventory().setLeggings(leggings);
                            final ItemStack boots;
                            player2.getInventory().setBoots(boots);
                            player2.playSound(player2.getLocation(), Sound.ITEM_ARMOR_EQUIP_LEATHER, 1.0f, 1.0f);
                        }
                        else {
                            c.restoreCostume(player2);
                        }
                    }
                }
            }, 2L);
        }
    }
    
    private boolean CostumesListener1(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if ((itemStack.getType() == Material.PLAYER_HEAD || itemStack.getType() == Material.LEATHER_CHESTPLATE || itemStack.getType() == Material.LEATHER_LEGGINGS || itemStack.getType() == Material.LEATHER_BOOTS) && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            final String lowerCase = itemStack.getItemMeta().getDisplayName().toLowerCase();
            return lowerCase.contains("kostium") || lowerCase.contains("costume") || lowerCase.contains("zbroja") || lowerCase.contains("zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("zabojczego krolika") || lowerCase.contains("zbroja zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("walentynkowy") || lowerCase.contains("valentine") || lowerCase.contains("przeciwzaka\u017ceniowy") || lowerCase.contains("mima") || lowerCase.contains("przeciwzakazeniowy") || lowerCase.contains("ma\u0142ego urwisa") || lowerCase.contains("malogo urwisa");
        }
        return false;
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerDamage(final EntityDamageEvent entityDamageEvent) {
        if (entityDamageEvent.isCancelled() || !(entityDamageEvent.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)entityDamageEvent.getEntity();
        if (CostumesCostumeService6.CostumesListener4(player)) {
            if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
                return;
            }
            CostumesCostumeService6.CostumesCostumeService4(player);
            new BukkitRunnable() {
                public void run() {
                    if (player.isOnline() && CostumesCostumeService6.CostumesListener4(player)) {
                        if (player.isSneaking() || player.hasMetadata("costume_sneaking")) {
                            return;
                        }
                        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
                            return;
                        }
                        CostumesCostumeService6.CostumesListener2(player);
                    }
                }
            }.runTaskLater(this.CostumesListener1, 4L);
        }
    }
    
    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent playerQuitEvent) {
        final Player player = playerQuitEvent.getPlayer();
        final Main instance = Main.getInstance();
        if (instance != null) {
            final pl.ziffy.STORMSZAFKA.data.CostumesCostumeService2 costumeDataManager = instance.getCostumeDataManager();
            if (costumeDataManager != null) {
                costumeDataManager.CostumesListener2(player);
                costumeDataManager.CostumesListener5();
            }
        }
        pl.ziffy.STORMSZAFKA.pets.editors.CostumesListener2.cleanup(player.getUniqueId());
        pl.ziffy.STORMSZAFKA.pets.editors.CostumesListener3.cleanup(player.getUniqueId());
        pl.ziffy.STORMSZAFKA.costumes.editors.CostumesCostumeService1.cleanup(player.getUniqueId());
        if (player.hasMetadata("costume_toggle_helmet")) {
            player.removeMetadata("costume_toggle_helmet", (Plugin)instance);
        }
        if (player.hasMetadata("costume_toggle_chestplate")) {
            player.removeMetadata("costume_toggle_chestplate", (Plugin)instance);
        }
        if (player.hasMetadata("costume_toggle_leggings")) {
            player.removeMetadata("costume_toggle_leggings", (Plugin)instance);
        }
        if (player.hasMetadata("costume_toggle_boots")) {
            player.removeMetadata("costume_toggle_boots", (Plugin)instance);
        }
        if (player.hasMetadata("costume_edit_mode")) {
            player.removeMetadata("costume_edit_mode", (Plugin)instance);
        }
        if (player.hasMetadata("costume_inventory_open")) {
            player.removeMetadata("costume_inventory_open", (Plugin)instance);
        }
        if (player.hasMetadata("costume_survival_inventory")) {
            player.removeMetadata("costume_survival_inventory", (Plugin)instance);
        }
        if (player.hasMetadata("costume_sneaking")) {
            player.removeMetadata("costume_sneaking", (Plugin)instance);
        }
        if (CostumesCostumeService6.CostumesListener4(player)) {
            CostumesCostumeService6.CostumesListener1(player, false, false);
        }
        if (pl.ziffy.STORMSZAFKA.pets.CostumesCostumeService2.CostumesListener6(player)) {
            pl.ziffy.STORMSZAFKA.pets.CostumesCostumeService2.M(player);
        }
    }
    
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent playerJoinEvent) {
        playerJoinEvent.getPlayer();
        final Main instance = Main.getInstance();
        if (instance != null) {
            if (instance.getCostumeDataManager() != null) {
                Bukkit.getScheduler().runTaskLater((Plugin)instance, () -> {
                    if (player.isOnline()) {
                        if (e.CostumesCostumeService1(player)) {
                            e.CostumesListener3(player);
                        }
                        e.CostumesListener1(player);
                        this.CostumesCostumeService3(player);
                    }
                    return;
                }, 20L);
            }
            Bukkit.getScheduler().runTaskLater((Plugin)instance, () -> {
                if (player2.isOnline()) {
                    pl.ziffy.STORMSZAFKA.pets.CostumesCostumeService2.CostumesCostumeService1(player2);
                }
            }, 40L);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(final PlayerDeathEvent playerDeathEvent) {
        final Player entity = playerDeathEvent.getEntity();
        final Main instance = Main.getInstance();
        if (instance != null) {
            final pl.ziffy.STORMSZAFKA.data.CostumesCostumeService2 costumeDataManager = instance.getCostumeDataManager();
            if (costumeDataManager != null) {
                costumeDataManager.CostumesListener2(entity);
            }
        }
        if (CostumesCostumeService6.CostumesListener4(entity)) {
            playerDeathEvent.getDrops().removeIf(this::CostumesListener1);
            CostumesCostumeService6.CostumesCostumeService1(entity);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerRespawn(final PlayerRespawnEvent playerRespawnEvent) {
        playerRespawnEvent.getPlayer();
        final Main instance = Main.getInstance();
        if (instance != null && instance.getCostumeDataManager() != null) {
            Bukkit.getScheduler().runTaskLater((Plugin)instance, () -> {
                if (player.isOnline()) {
                    e.CostumesListener1(player);
                }
            }, 20L);
        }
    }
    
    private void CostumesCostumeService3(final Player player) {
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerToggleSneak(final PlayerToggleSneakEvent playerToggleSneakEvent) {
        final Player player = playerToggleSneakEvent.getPlayer();
        if (!CostumesCostumeService6.CostumesListener4(player)) {
            return;
        }
        if (playerToggleSneakEvent.isSneaking()) {
            CostumesCostumeService6.CostumesCostumeService4(player);
            player.setMetadata("costume_sneaking", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
        }
        else {
            if (player.hasMetadata("costume_sneaking")) {
                player.removeMetadata("costume_sneaking", this.CostumesListener1);
                player.setMetadata("was_sneaking", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
            }
            if (player.hasMetadata("costume_edit_mode")) {
                player.removeMetadata("costume_edit_mode", this.CostumesListener1);
                final CostumesCostumeService1 a = CostumesCostumeService6.CostumesListener1(player);
                if (a != null && a.getType().equals("zabojczykrolik")) {
                    player.sendMessage("§7Wy\u0142\u0105czono tryb edycji zbroi.");
                }
            }
            if (CostumesCostumeService6.CostumesListener1(player) != null) {
                Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                    if (player2.isOnline() && CostumesCostumeService6.CostumesListener4(player2)) {
                        if (!player2.hasMetadata("costume_inventory_open") && !player2.hasMetadata("costume_survival_inventory")) {
                            player2.setMetadata("costume_silent_refresh", (MetadataValue)new FixedMetadataValue(this.CostumesListener1, (Object)true));
                            c.restoreCostume(player2);
                            Bukkit.getScheduler().runTaskLater(this.CostumesListener1, () -> {
                                if (player3.isOnline()) {
                                    player3.removeMetadata("costume_silent_refresh", this.CostumesListener1);
                                }
                            }, 5L);
                        }
                    }
                }, 1L);
            }
        }
    }
}
