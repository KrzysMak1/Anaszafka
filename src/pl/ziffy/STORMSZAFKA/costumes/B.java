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
import pl.ziffy.STORMSZAFKA.costumes.items.D;
import pl.ziffy.STORMSZAFKA.costumes.items.H;
import pl.ziffy.STORMSZAFKA.costumes.items.F;
import pl.ziffy.STORMSZAFKA.costumes.items.G;
import pl.ziffy.STORMSZAFKA.costumes.items.A;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.EquipmentSlot;
import pl.ziffy.STORMSZAFKA.costumes.items.E;
import pl.ziffy.STORMSZAFKA.Main;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;

public class B implements Listener
{
    private final Plugin A;
    
    public void registerInventoryListener() {
    }
    
    public B(final Plugin a) {
        this.A = a;
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
                        if (L.F(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.A languageManager = Main.getLanguageManager();
                            if (languageManager != null) {
                                player.sendMessage(languageManager.F("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        L.A(player, new E());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.A, (Object)"zabojczykrolik"));
                    }
                }
                if (displayName.toLowerCase().contains("walentynkowy") || displayName.toLowerCase().contains("valentine")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (L.F(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.A languageManager2 = Main.getLanguageManager();
                            if (languageManager2 != null) {
                                player.sendMessage(languageManager2.F("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        L.A(player, new A());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.A, (Object)"walentynkowy"));
                    }
                }
                if (displayName.toLowerCase().contains("przeciwzaka\u017ceniowy") || displayName.toLowerCase().contains("przeciwzakazeniowy")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (L.F(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.A languageManager3 = Main.getLanguageManager();
                            if (languageManager3 != null) {
                                player.sendMessage(languageManager3.F("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        L.A(player, new G());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.A, (Object)"przeciwzakazeniowy"));
                    }
                }
                if (displayName.toLowerCase().contains("mima")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (L.F(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.A languageManager4 = Main.getLanguageManager();
                            if (languageManager4 != null) {
                                player.sendMessage(languageManager4.F("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        L.A(player, new pl.ziffy.STORMSZAFKA.costumes.items.B());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.A, (Object)"mima"));
                    }
                }
                if (displayName.toLowerCase().contains("pirata")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (L.F(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.A languageManager5 = Main.getLanguageManager();
                            if (languageManager5 != null) {
                                player.sendMessage(languageManager5.F("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        L.A(player, new F());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.A, (Object)"pirata"));
                    }
                }
                if (displayName.toLowerCase().contains("nurek") || displayName.toLowerCase().contains("g\u0142\u0119binowy") || displayName.toLowerCase().contains("gl\u0119binowy")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (L.F(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.A languageManager6 = Main.getLanguageManager();
                            if (languageManager6 != null) {
                                player.sendMessage(languageManager6.F("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        L.A(player, new pl.ziffy.STORMSZAFKA.costumes.items.C());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.A, (Object)"nurkglebinowy"));
                    }
                }
                if (displayName.toLowerCase().contains("ma\u0142ego urwisa") || displayName.toLowerCase().contains("malyurwis") || displayName.toLowerCase().contains("ma\u0142y urwis")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (L.F(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.A languageManager7 = Main.getLanguageManager();
                            if (languageManager7 != null) {
                                player.sendMessage(languageManager7.F("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        L.A(player, new H());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.A, (Object)"malyurwis"));
                    }
                }
                if (displayName.toLowerCase().contains("wampira") || displayName.toLowerCase().contains("wampir")) {
                    b = true;
                    playerInteractEvent.setCancelled(true);
                    if (playerInteractEvent.getAction().name().contains("RIGHT_CLICK")) {
                        if (L.F(player)) {
                            final pl.ziffy.STORMSZAFKA.messages.A languageManager8 = Main.getLanguageManager();
                            if (languageManager8 != null) {
                                player.sendMessage(languageManager8.F("costume.already-active"));
                            }
                            else {
                                player.sendMessage("§cMasz ju\u017c aktywny kostium!");
                            }
                            return;
                        }
                        L.A(player, new D());
                        if (playerInteractEvent.getHand() == EquipmentSlot.HAND) {
                            player.getInventory().setItemInMainHand((ItemStack)null);
                        }
                        else if (playerInteractEvent.getHand() == EquipmentSlot.OFF_HAND) {
                            player.getInventory().setItemInOffHand((ItemStack)null);
                        }
                        player.setMetadata("costume_item_type", (MetadataValue)new FixedMetadataValue(this.A, (Object)"wampir"));
                    }
                }
            }
            if (b) {
                playerInteractEvent.setCancelled(true);
                player.setMetadata("costume_interaction", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
                Bukkit.getScheduler().runTaskLater(this.A, () -> {
                    if (player2.hasMetadata("costume_interaction")) {
                        player2.removeMetadata("costume_interaction", this.A);
                    }
                    return;
                }, 5L);
            }
        }
        if ("wampir".equals(L.D(player))) {
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
        L.F(player);
        if (inventoryOpenEvent.getView().getType() == InventoryType.PLAYER || inventoryOpenEvent.getView().getType() == InventoryType.CRAFTING) {
            this.D(player);
        }
    }
    
    private void D(final Player player) {
        player.setMetadata("costume_inventory_open", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
        player.setMetadata("costume_survival_inventory", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
        if (L.F(player)) {
            final I playerArmorSnapshot = J.getPlayerArmorSnapshot(player.getUniqueId());
            if (playerArmorSnapshot != null) {
                if (playerArmorSnapshot.C() != null) {
                    player.getInventory().setHelmet(playerArmorSnapshot.C().clone());
                }
                else {
                    player.getInventory().setHelmet((ItemStack)null);
                }
                if (!playerArmorSnapshot.D()) {
                    if (playerArmorSnapshot.E() != null) {
                        player.getInventory().setChestplate(playerArmorSnapshot.E().clone());
                    }
                    else {
                        player.getInventory().setChestplate((ItemStack)null);
                    }
                }
                if (playerArmorSnapshot.B() != null) {
                    player.getInventory().setLeggings(playerArmorSnapshot.B().clone());
                }
                else {
                    player.getInventory().setLeggings((ItemStack)null);
                }
                if (playerArmorSnapshot.A() != null) {
                    player.getInventory().setBoots(playerArmorSnapshot.A().clone());
                }
                else {
                    player.getInventory().setBoots((ItemStack)null);
                }
            }
        }
    }
    
    private ItemStack A(final Material material, final ItemStack itemStack, final Player player) {
        String displayName = "§7Nieznany kostium";
        final C a = L.A(player);
        ItemStack itemStack2;
        if (a instanceof final E e) {
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
        else if (a instanceof final A a2) {
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
        else if (a instanceof final G g) {
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
        else if (a instanceof final H h) {
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
        else if (a instanceof final pl.ziffy.STORMSZAFKA.costumes.items.B b) {
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
        else if (a instanceof final F f) {
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
        else if (a instanceof final D d) {
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
            this.A(itemStack, itemStack2);
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
    
    private ItemStack A(final Material material, final Player player) {
        return this.A(material, null, player);
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
            final double d = this.D(itemStack.getType());
            final double c = this.C(itemStack.getType());
            final double b = this.B(itemStack.getType());
            if (d > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), "costume_armor", d, AttributeModifier.Operation.ADD_NUMBER, this.A(itemStack2.getType())));
            }
            if (c > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), "costume_toughness", c, AttributeModifier.Operation.ADD_NUMBER, this.A(itemStack2.getType())));
            }
            if (b > 0.0) {
                itemMeta2.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "costume_knockback_resistance", b, AttributeModifier.Operation.ADD_NUMBER, this.A(itemStack2.getType())));
            }
            itemStack2.setItemMeta(itemMeta2);
        }
        catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private double D(final Material material) {
        switch (B$2.A[material.ordinal()]) {
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
    
    private double C(final Material material) {
        switch (B$2.A[material.ordinal()]) {
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
    
    private double B(final Material material) {
        switch (B$2.A[material.ordinal()]) {
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
    
    private EquipmentSlot A(final Material material) {
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
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClose(final InventoryCloseEvent inventoryCloseEvent) {
        if (!(inventoryCloseEvent.getPlayer() instanceof Player)) {
            return;
        }
        final Player player = (Player)inventoryCloseEvent.getPlayer();
        final boolean b = inventoryCloseEvent.getView().getType() == InventoryType.CRAFTING || inventoryCloseEvent.getView().getType() == InventoryType.PLAYER || player.hasMetadata("costume_survival_inventory") || player.hasMetadata("costume_inventory_open");
        if (player.hasMetadata("costume_survival_inventory")) {
            this.F(player);
            return;
        }
        final boolean hasMetadata = player.hasMetadata("costume_inventory_open");
        if (b) {
            player.removeMetadata("costume_toggle_helmet", this.A);
            player.removeMetadata("costume_toggle_chestplate", this.A);
            player.removeMetadata("costume_toggle_leggings", this.A);
            player.removeMetadata("costume_toggle_boots", this.A);
            player.removeMetadata("costume_edit_mode", this.A);
            player.removeMetadata("costume_inventory_open", this.A);
            player.removeMetadata("costume_survival_inventory", this.A);
        }
        if (L.F(player)) {
            if (hasMetadata) {}
            if (hasMetadata) {
                player.setMetadata("was_inventory", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
            }
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                if (player2.isOnline() && L.F(player2)) {
                    if (!player2.isSneaking() && !player2.hasMetadata("costume_sneaking")) {
                        if (player2.hasMetadata("was_inventory")) {
                            player2.removeMetadata("was_inventory", this.A);
                            L.A(player2);
                            final C c;
                            if (c != null) {
                                player2.hasMetadata("costume_silent_refresh");
                                c.restoreCostume(player2);
                                final boolean b2;
                                if (!b2 && player2.hasMetadata("costume_silent_refresh")) {
                                    player2.removeMetadata("costume_silent_refresh", this.A);
                                }
                                Bukkit.getScheduler().runTaskLater(this.A, () -> {
                                    if (player3.isOnline()) {
                                        player3.getNearbyEntities(50.0, 50.0, 50.0).iterator();
                                        final Iterator iterator;
                                        while (iterator.hasNext()) {
                                            final Entity entity = iterator.next();
                                            if (entity instanceof final Player player4) {
                                                player4.hidePlayer(this.A, player3);
                                                player4.showPlayer(this.A, player3);
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
                                    final pl.ziffy.STORMSZAFKA.data.E e;
                                    if (e != null) {
                                        e.B(player2);
                                    }
                                }
                                return;
                            }
                        }
                        J.getPlayerArmorSnapshot(player2.getUniqueId());
                        final I i;
                        if (i != null) {
                            player2.getInventory().getHelmet();
                            player2.getInventory().getChestplate();
                            player2.getInventory().getLeggings();
                            player2.getInventory().getBoots();
                            final ItemStack itemStack;
                            if (itemStack != null && !this.A(itemStack)) {
                                i.A(itemStack.clone());
                            }
                            else if (itemStack == null) {
                                i.A(null);
                            }
                            final ItemStack itemStack2;
                            if (itemStack2 != null && !this.A(itemStack2)) {
                                i.D(itemStack2.clone());
                            }
                            else if (itemStack2 == null) {
                                i.D(null);
                            }
                            final ItemStack itemStack3;
                            if (itemStack3 != null && !this.A(itemStack3)) {
                                i.B(itemStack3.clone());
                            }
                            else if (itemStack3 == null) {
                                i.B(null);
                            }
                            final ItemStack itemStack4;
                            if (itemStack4 != null && !this.A(itemStack4)) {
                                i.C(itemStack4.clone());
                            }
                            else if (itemStack4 == null) {
                                i.C(null);
                            }
                            this.A(Material.LEATHER_HELMET, i.C(), player2);
                            this.A(Material.LEATHER_CHESTPLATE, i.E(), player2);
                            this.A(Material.LEATHER_LEGGINGS, i.B(), player2);
                            this.A(Material.LEATHER_BOOTS, i.A(), player2);
                            final ItemStack helmet;
                            player2.getInventory().setHelmet(helmet);
                            if (!i.D()) {
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
                                final pl.ziffy.STORMSZAFKA.data.E e2;
                                if (e2 != null) {
                                    e2.B(player2);
                                }
                            }
                        }
                        else {
                            L.B(player2);
                        }
                    }
                }
            }, 2L);
        }
    }
    
    private void F(final Player player) {
        player.removeMetadata("costume_toggle_helmet", this.A);
        player.removeMetadata("costume_toggle_chestplate", this.A);
        player.removeMetadata("costume_toggle_leggings", this.A);
        player.removeMetadata("costume_toggle_boots", this.A);
        player.removeMetadata("costume_survival_inventory", this.A);
        player.removeMetadata("costume_inventory_open", this.A);
        player.removeMetadata("costume_edit_mode", this.A);
        if (L.F(player)) {
            if (player.isSneaking() || player.hasMetadata("costume_sneaking")) {
                return;
            }
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                if (player2.isOnline() && L.F(player2)) {
                    L.A(player2);
                    final C c;
                    if (c != null) {
                        J.getPlayerArmorSnapshot(player2.getUniqueId());
                        final I i;
                        if (i != null) {
                            player2.getInventory().getHelmet();
                            player2.getInventory().getChestplate();
                            player2.getInventory().getLeggings();
                            player2.getInventory().getBoots();
                            final ItemStack itemStack;
                            if (itemStack != null && !this.A(itemStack)) {
                                i.A(itemStack.clone());
                            }
                            else if (itemStack == null) {
                                i.A(null);
                            }
                            final ItemStack itemStack2;
                            if (itemStack2 != null && !this.A(itemStack2)) {
                                i.D(itemStack2.clone());
                            }
                            else if (itemStack2 == null) {
                                i.D(null);
                            }
                            final ItemStack itemStack3;
                            if (itemStack3 != null && !this.A(itemStack3)) {
                                i.B(itemStack3.clone());
                            }
                            else if (itemStack3 == null) {
                                i.B(null);
                            }
                            final ItemStack itemStack4;
                            if (itemStack4 != null && !this.A(itemStack4)) {
                                i.C(itemStack4.clone());
                            }
                            else if (itemStack4 == null) {
                                i.C(null);
                            }
                        }
                        if (i != null) {
                            this.A(Material.LEATHER_HELMET, i.C(), player2);
                            this.A(Material.LEATHER_CHESTPLATE, i.E(), player2);
                            this.A(Material.LEATHER_LEGGINGS, i.B(), player2);
                            this.A(Material.LEATHER_BOOTS, i.A(), player2);
                            final ItemStack helmet;
                            player2.getInventory().setHelmet(helmet);
                            if (!i.D()) {
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
    
    private boolean A(final ItemStack itemStack) {
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
        if (L.F(player)) {
            if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
                return;
            }
            L.I(player);
            new BukkitRunnable() {
                public void run() {
                    if (player.isOnline() && L.F(player)) {
                        if (player.isSneaking() || player.hasMetadata("costume_sneaking")) {
                            return;
                        }
                        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
                            return;
                        }
                        L.B(player);
                    }
                }
            }.runTaskLater(this.A, 4L);
        }
    }
    
    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent playerQuitEvent) {
        final Player player = playerQuitEvent.getPlayer();
        final Main instance = Main.getInstance();
        if (instance != null) {
            final pl.ziffy.STORMSZAFKA.data.E costumeDataManager = instance.getCostumeDataManager();
            if (costumeDataManager != null) {
                costumeDataManager.B(player);
                costumeDataManager.H();
            }
        }
        pl.ziffy.STORMSZAFKA.pets.editors.B.cleanup(player.getUniqueId());
        pl.ziffy.STORMSZAFKA.pets.editors.D.cleanup(player.getUniqueId());
        pl.ziffy.STORMSZAFKA.costumes.editors.C.cleanup(player.getUniqueId());
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
        if (L.F(player)) {
            L.A(player, false, false);
        }
        if (pl.ziffy.STORMSZAFKA.pets.E.K(player)) {
            pl.ziffy.STORMSZAFKA.pets.E.M(player);
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
                        if (e.C(player)) {
                            e.D(player);
                        }
                        e.A(player);
                        this.G(player);
                    }
                    return;
                }, 20L);
            }
            Bukkit.getScheduler().runTaskLater((Plugin)instance, () -> {
                if (player2.isOnline()) {
                    pl.ziffy.STORMSZAFKA.pets.E.C(player2);
                }
            }, 40L);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(final PlayerDeathEvent playerDeathEvent) {
        final Player entity = playerDeathEvent.getEntity();
        final Main instance = Main.getInstance();
        if (instance != null) {
            final pl.ziffy.STORMSZAFKA.data.E costumeDataManager = instance.getCostumeDataManager();
            if (costumeDataManager != null) {
                costumeDataManager.B(entity);
            }
        }
        if (L.F(entity)) {
            playerDeathEvent.getDrops().removeIf(this::A);
            L.C(entity);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerRespawn(final PlayerRespawnEvent playerRespawnEvent) {
        playerRespawnEvent.getPlayer();
        final Main instance = Main.getInstance();
        if (instance != null && instance.getCostumeDataManager() != null) {
            Bukkit.getScheduler().runTaskLater((Plugin)instance, () -> {
                if (player.isOnline()) {
                    e.A(player);
                }
            }, 20L);
        }
    }
    
    private void G(final Player player) {
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerToggleSneak(final PlayerToggleSneakEvent playerToggleSneakEvent) {
        final Player player = playerToggleSneakEvent.getPlayer();
        if (!L.F(player)) {
            return;
        }
        if (playerToggleSneakEvent.isSneaking()) {
            L.I(player);
            player.setMetadata("costume_sneaking", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
        }
        else {
            if (player.hasMetadata("costume_sneaking")) {
                player.removeMetadata("costume_sneaking", this.A);
                player.setMetadata("was_sneaking", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
            }
            if (player.hasMetadata("costume_edit_mode")) {
                player.removeMetadata("costume_edit_mode", this.A);
                final C a = L.A(player);
                if (a != null && a.getType().equals("zabojczykrolik")) {
                    player.sendMessage("§7Wy\u0142\u0105czono tryb edycji zbroi.");
                }
            }
            if (L.A(player) != null) {
                Bukkit.getScheduler().runTaskLater(this.A, () -> {
                    if (player2.isOnline() && L.F(player2)) {
                        if (!player2.hasMetadata("costume_inventory_open") && !player2.hasMetadata("costume_survival_inventory")) {
                            player2.setMetadata("costume_silent_refresh", (MetadataValue)new FixedMetadataValue(this.A, (Object)true));
                            c.restoreCostume(player2);
                            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                                if (player3.isOnline()) {
                                    player3.removeMetadata("costume_silent_refresh", this.A);
                                }
                            }, 5L);
                        }
                    }
                }, 1L);
            }
        }
    }
}
