// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets;

import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.SkullMeta;
import java.util.Collection;
import java.util.List;
import org.bukkit.Sound;
import pl.ziffy.STORMSZAFKA.pets.items.PetsListener1;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition18;
import pl.ziffy.STORMSZAFKA.pets.items.PetsPetService5;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition15;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition20;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition26;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition28;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition9;
import pl.ziffy.STORMSZAFKA.pets.items.PetsPetService2;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition12;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition25;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition21;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition19;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition29;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition8;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition14;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition13;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition10;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition11;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition22;
import pl.ziffy.STORMSZAFKA.pets.items.PetsPetService6;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition27;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition16;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition23;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition17;
import pl.ziffy.STORMSZAFKA.pets.items.PetsItemsPetItemDefinition24;
import java.util.ArrayList;
import java.time.chrono.ChronoLocalDateTime;
import java.time.LocalDateTime;
import org.bukkit.inventory.ItemStack;
import pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.entity.Player;
import java.util.Iterator;
import org.bukkit.Material;
import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.World;
import org.bukkit.Bukkit;
import java.time.format.DateTimeFormatter;
import org.bukkit.scheduler.BukkitTask;
import pl.ziffy.STORMSZAFKA.Main;
import java.util.UUID;
import java.util.Map;

public class PetsPetService4
{
    public static final Map<UUID, _A> PetsPetService5;
    private static Main PetsPetService3;
    private static BukkitTask PetsListener1;
    private static final DateTimeFormatter PetsPetService2;
    public static final String PetsPetService4 = "STORMSZAFKA_PET";
    public static final String PetsPetService1 = "STORMSZAFKA_PET_HOLOGRAM";
    
    public static void PetsPetService1(final Main d) {
        pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3 = d;
        PetsPetService1();
        PetsListener1();
    }
    
    public static int PetsPetService1() {
        int n = 0;
        final Iterator iterator = Bukkit.getWorlds().iterator();
        while (iterator.hasNext()) {
            for (final Entity entity : ((World)iterator.next()).getEntities()) {
                if (entity instanceof final ArmorStand armorStand) {
                    if (armorStand.hasMetadata("STORMSZAFKA_PET") || armorStand.hasMetadata("STORMSZAFKA_PET_HOLOGRAM")) {
                        boolean b = true;
                        for (final _A a : pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.values()) {
                            if (a.PetsPetService1 != null && PetsPetService1(a.PetsPetService1, armorStand)) {
                                b = false;
                                break;
                            }
                        }
                        if (!b) {
                            continue;
                        }
                        armorStand.remove();
                        ++n;
                    }
                    else {
                        if (!PetsPetService1(armorStand)) {
                            continue;
                        }
                        final String customName = armorStand.getCustomName();
                        if (customName != null && customName.contains("\u25cf")) {
                            final String[] split = customName.split("\u25cf");
                            if (split.length < 2) {
                                continue;
                            }
                            final Player playerExact = Bukkit.getPlayerExact(ChatColor.stripColor(split[split.length - 1].trim()));
                            if (playerExact != null && K(playerExact)) {
                                continue;
                            }
                            armorStand.remove();
                            ++n;
                        }
                        else {
                            if (armorStand.getEquipment() == null || armorStand.getEquipment().getHelmet() == null || armorStand.getEquipment().getHelmet().getType() != Material.PLAYER_HEAD) {
                                continue;
                            }
                            final ItemMeta itemMeta = armorStand.getEquipment().getHelmet().getItemMeta();
                            if (itemMeta == null || !itemMeta.hasDisplayName() || !itemMeta.getDisplayName().contains("\u25cf")) {
                                continue;
                            }
                            final String[] split2 = itemMeta.getDisplayName().split("\u25cf");
                            if (split2.length < 2) {
                                continue;
                            }
                            final Player playerExact2 = Bukkit.getPlayerExact(ChatColor.stripColor(split2[split2.length - 1].trim()));
                            if (playerExact2 != null && K(playerExact2)) {
                                continue;
                            }
                            armorStand.remove();
                            ++n;
                        }
                    }
                }
            }
        }
        if (n > 0 && pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3 != null) {
            pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3.getLogger().info("[PetManager] Usuni\u0119to " + n + " osieroconych ArmorStand\u00f3w pet\u00f3w.");
        }
        return n;
    }
    
    private static boolean PetsPetService1(final ArmorStand armorStand) {
        return !armorStand.isVisible() && !armorStand.hasGravity() && armorStand.isMarker();
    }
    
    private static boolean PetsPetService1(final PetsPetService3 d, final ArmorStand armorStand) {
        return false;
    }
    
    public static void PetsPetService2(final ArmorStand armorStand, final UUID uuid) {
        if (pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3 != null && armorStand != null) {
            armorStand.setMetadata("STORMSZAFKA_PET", (MetadataValue)new FixedMetadataValue((Plugin)pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3, (Object)uuid.toString()));
        }
    }
    
    public static void PetsPetService1(final ArmorStand armorStand, final UUID uuid) {
        if (pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3 != null && armorStand != null) {
            armorStand.setMetadata("STORMSZAFKA_PET_HOLOGRAM", (MetadataValue)new FixedMetadataValue((Plugin)pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3, (Object)uuid.toString()));
        }
    }
    
    public static void PetsPetService4() {
        if (pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsListener1 != null) {
            pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsListener1.cancel();
        }
        for (final _A a : pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.values()) {
            if (a.PetsPetService1 != null) {
                a.PetsPetService1.remove();
            }
        }
        pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.clear();
    }
    
    public static boolean PetsPetService1(final Player player, final String s, final String s2) {
        if (K(player)) {
            PetsPetService1(player, false, false);
        }
        final PetsPetService3 k = K(s);
        if (k == null) {
            return false;
        }
        final _A a = new _A(s, k, s2, pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.J(s2));
        pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.put(player.getUniqueId(), a);
        k.spawn(player, s2);
        Plugin plugin = Bukkit.getPluginManager().getPlugin("STORMSZAFKA");
        if (plugin == null) {
            plugin = Bukkit.getPluginManager().getPlugin("stormszafka");
        }
        if (plugin != null) {
            a.PetsPetService4 = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
                if (!player2.isOnline() || !pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.containsKey(player2.getUniqueId())) {
                    return;
                }
                else {
                    d.update();
                    return;
                }
            }, 0L, 1L);
        }
        PetsPetService2(player, s);
        return true;
    }
    
    public static boolean PetsPetService1(final Player player, final String s, final String s2, final String s3) {
        if (K(player)) {
            PetsPetService1(player, false, false);
        }
        final PetsPetService3 k = K(s);
        if (k == null) {
            return false;
        }
        final _A a = new _A(s, k, s2, pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.PetsPetService1(s3));
        pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.put(player.getUniqueId(), a);
        k.spawn(player, s2);
        Plugin plugin = Bukkit.getPluginManager().getPlugin("STORMSZAFKA");
        if (plugin == null) {
            plugin = Bukkit.getPluginManager().getPlugin("stormszafka");
        }
        if (plugin != null) {
            a.PetsPetService4 = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
                if (!player2.isOnline() || !pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.containsKey(player2.getUniqueId())) {
                    return;
                }
                else {
                    d.update();
                    return;
                }
            }, 0L, 1L);
        }
        PetsPetService2(player, s);
        return true;
    }
    
    public static void PetsPetService1(final Player player, final boolean b) {
        PetsPetService1(player, b, true);
    }
    
    public static void PetsPetService1(final Player player, final boolean b, final boolean b2) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.remove(player.getUniqueId());
        if (a != null && a.PetsPetService1 != null) {
            final String c = a.PetsListener1;
            final String b3 = a.PetsPetService2;
            final LocalDateTime f = a.PetsPetService5;
            if (a.PetsPetService4 != null) {
                a.PetsPetService4.cancel();
            }
            a.PetsPetService1.remove();
            Main.savedPetMap.remove(player.getUniqueId());
            if (pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3 != null && pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3.getPetDataManager() != null) {
                pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3.getPetDataManager().PetsPetService2(player.getUniqueId());
            }
            if (b2) {
                final ItemStack a2 = PetsPetService1(c, b3, f);
                if (a2 != null) {
                    if (player.getInventory().firstEmpty() == -1) {
                        player.getWorld().dropItemNaturally(player.getLocation(), a2);
                        final pl.ziffy.STORMSZAFKA.messages.PetsPetService1 e = pl.ziffy.STORMSZAFKA.messages.PetsPetService1.PetsPetService4();
                        if (e != null) {
                            e.PetsPetService1(player, "pet.inventory-full", "pet_type", c);
                        }
                    }
                    else {
                        player.getInventory().addItem(new ItemStack[] { a2 });
                        final pl.ziffy.STORMSZAFKA.messages.PetsPetService1 e2 = pl.ziffy.STORMSZAFKA.messages.PetsPetService1.PetsPetService4();
                        if (e2 != null) {
                            e2.PetsPetService1(player, "pet.received-item", "pet_type", c);
                        }
                    }
                }
            }
            if (b) {
                PetsListener1(player, c);
            }
        }
    }
    
    public static void M(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.get(player.getUniqueId());
        if (a != null && a.PetsPetService1 != null) {
            final pl.ziffy.STORMSZAFKA.pets.PetsPetService1 value = new pl.ziffy.STORMSZAFKA.pets.PetsPetService1(a.PetsListener1, (a.PetsPetService5 != null) ? a.PetsPetService5.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : "brak", a.PetsPetService3, a.PetsPetService2);
            Main.savedPetMap.put(player.getUniqueId(), value);
            if (pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3 != null && pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3.getPetDataManager() != null) {
                pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3.getPetDataManager().PetsPetService1(player.getUniqueId(), value);
            }
            if (a.PetsPetService4 != null) {
                a.PetsPetService4.cancel();
            }
            a.PetsPetService1.remove();
            pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.remove(player.getUniqueId());
        }
    }
    
    public static void PetsListener1(final Player player) {
        pl.ziffy.STORMSZAFKA.pets.PetsPetService1 a = Main.savedPetMap.get(player.getUniqueId());
        if (a == null && pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3 != null && pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3.getPetDataManager() != null) {
            a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3.getPetDataManager().PetsPetService1(player.getUniqueId());
        }
        if (a != null && !K(player)) {
            final String c = a.PetsListener1;
            String a2 = a.PetsPetService1;
            final String b = a.PetsPetService2;
            final boolean d = a.PetsPetService3;
            if (a2 == null || a2.isEmpty()) {
                a2 = "brak";
            }
            if (b != null && !b.equals("brak")) {
                final LocalDateTime a3 = pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.PetsPetService1(b);
                if (a3 != null && LocalDateTime.now().isAfter(a3)) {
                    Main.savedPetMap.remove(player.getUniqueId());
                    if (pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3 != null && pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3.getPetDataManager() != null) {
                        pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3.getPetDataManager().PetsPetService2(player.getUniqueId());
                    }
                    return;
                }
            }
            if (b != null && !b.equals("brak")) {
                PetsPetService1(player, c, a2, b);
            }
            else {
                PetsPetService1(player, c, a2);
            }
            if (d) {
                Bukkit.getScheduler().runTaskLater((Plugin)pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3, () -> PetsPetService3(player2), 5L);
            }
            Main.savedPetMap.remove(player.getUniqueId());
        }
    }
    
    public static boolean K(final Player player) {
        return pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.containsKey(player.getUniqueId());
    }
    
    public static ItemStack J(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.get(player.getUniqueId());
        if (a == null) {
            return null;
        }
        return PetsPetService1(a.PetsListener1, a.PetsPetService2, a.PetsPetService5);
    }
    
    public static String PetsPetService1(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.get(player.getUniqueId());
        return (a != null) ? a.PetsListener1 : null;
    }
    
    public static String PetsPetService6(final Player player) {
        return PetsPetService1(player);
    }
    
    public static boolean I(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.get(player.getUniqueId());
        return a != null && a.PetsPetService3;
    }
    
    public static void PetsPetService3(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.get(player.getUniqueId());
        if (a != null && a.PetsPetService1 != null) {
            a.PetsPetService3 = true;
            a.PetsPetService1.hideFromOwner();
        }
    }
    
    public static void PetsPetService4(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.get(player.getUniqueId());
        if (a != null && a.PetsPetService1 != null) {
            a.PetsPetService3 = false;
            a.PetsPetService1.showToOwner();
        }
    }
    
    public static void H(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.remove(player.getUniqueId());
        if (a != null && a.PetsPetService1 != null) {
            final String c = a.PetsListener1;
            if (a.PetsPetService4 != null) {
                a.PetsPetService4.cancel();
            }
            a.PetsPetService1.remove();
            final pl.ziffy.STORMSZAFKA.messages.PetsPetService1 e = pl.ziffy.STORMSZAFKA.messages.PetsPetService1.PetsPetService4();
            if (e != null) {
                e.PetsPetService1(player, "pet.removed-disabled", "pet_type", c);
            }
        }
    }
    
    public static void PetsPetService3() {
        final LocalDateTime now = LocalDateTime.now();
        final ArrayList list = new ArrayList();
        for (final Map.Entry entry : pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.entrySet()) {
            final _A a = (_A)entry.getValue();
            if (a.PetsPetService5 != null && now.isAfter(a.PetsPetService5)) {
                list.add(entry.getKey());
            }
        }
        for (final UUID key : list) {
            final Player player = Bukkit.getPlayer(key);
            if (player != null && player.isOnline()) {
                final String c = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.get(key).PetsListener1;
                PetsPetService1(player, false, false);
                PetsPetService1(player, c);
            }
            else {
                pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.remove(key);
                Main.savedPetMap.remove(key);
                if (pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3 == null || pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3.getPetDataManager() == null) {
                    continue;
                }
                pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3.getPetDataManager().PetsPetService2(key);
            }
        }
    }
    
    private static PetsPetService3 K(final String s) {
        final String lowerCase = s.toLowerCase();
        switch (lowerCase) {
            case "cyber-obronca": {
                return new pl.ziffy.STORMSZAFKA.pets.items.PetsPetService4();
            }
            case "aniolek": {
                return new _tmp();
            }
            case "pancernik": {
                return new O();
            }
            case "pudzianek": {
                return new U();
            }
            case "pedziwiatr": {
                return new pl.ziffy.STORMSZAFKA.pets.items.PetsPetService1();
            }
            case "glodomorek": {
                return new pl.ziffy.STORMSZAFKA.pets.items.PetsPetService3();
            }
            case "skalniaczek": {
                return new N();
            }
            case "biznesmenik": {
                return new X();
            }
            case "discordzik": {
                return new PetsPetService6();
            }
            case "duszek": {
                return new T();
            }
            case "nietoperek": {
                return new K();
            }
            case "reniferek": {
                return new J();
            }
            case "balwanek": {
                return new a();
            }
            case "golemik": {
                return new b();
            }
            case "eustachy": {
                return new H();
            }
            case "enderman": {
                return new Z();
            }
            case "zaj\u0105czek": {
                return new Q();
            }
            case "pisklak": {
                return new S();
            }
            case "cukiereczek": {
                return new V();
            }
            case "rozdymek": {
                return new L();
            }
            case "pajak": {
                return new PetsPetService2();
            }
            case "sowa": {
                return new I();
            }
            case "drakula": {
                return new Y();
            }
            case "leniuszek": {
                return new W();
            }
            case "elfik": {
                return new R();
            }
            case "pierniczek": {
                return new M();
            }
            case "paczus": {
                return new PetsPetService5();
            }
            case "telekrolik": {
                return new P();
            }
            case "bobas": {
                return new PetsListener1();
            }
            default: {
                return null;
            }
        }
    }
    
    private static void PetsPetService2(final Player player, final String s) {
        final pl.ziffy.STORMSZAFKA.messages.PetsPetService1 e = pl.ziffy.STORMSZAFKA.messages.PetsPetService1.PetsPetService4();
        if (e != null) {
            e.PetsPetService1(player, "pet.activated", "pet_name", s);
        }
        final pl.ziffy.STORMSZAFKA.pets.PetsPetService6 petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null) {
            PetsPetService1(player, petConfigManager.PetsPetService5());
        }
    }
    
    private static void PetsListener1(final Player player, final String s) {
        final pl.ziffy.STORMSZAFKA.messages.PetsPetService1 e = pl.ziffy.STORMSZAFKA.messages.PetsPetService1.PetsPetService4();
        if (e != null) {
            e.PetsPetService1(player, "pet.removed", "pet_name", s);
        }
        final pl.ziffy.STORMSZAFKA.pets.PetsPetService6 petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null) {
            PetsPetService1(player, petConfigManager.H());
        }
    }
    
    private static void PetsPetService1(final Player player, final String s) {
        final pl.ziffy.STORMSZAFKA.messages.PetsPetService1 e = pl.ziffy.STORMSZAFKA.messages.PetsPetService1.PetsPetService4();
        if (e != null) {
            e.PetsPetService1(player, "pet.expired", "pet_name", s);
        }
        final pl.ziffy.STORMSZAFKA.pets.PetsPetService6 petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null) {
            PetsPetService1(player, petConfigManager.J());
        }
    }
    
    private static void PetsPetService1(final Player player, final Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (!map.getOrDefault("enabled", true)) {
            return;
        }
        try {
            player.playSound(player.getLocation(), Sound.valueOf((String)map.getOrDefault("type", "ENTITY_PLAYER_LEVELUP")), (float)((Number)map.getOrDefault("volume", 0.5)).doubleValue(), (float)((Number)map.getOrDefault("pitch", 1.0)).doubleValue());
        }
        catch (final IllegalArgumentException ex) {}
    }
    
    private static void PetsListener1() {
        if (pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3 != null) {
            pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsListener1 = Bukkit.getScheduler().runTaskTimer((Plugin)pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService3, pl.ziffy.STORMSZAFKA.pets.PetsPetService4::PetsPetService3, 600L, 600L);
        }
    }
    
    public static void PetsPetService2() {
    }
    
    public static void PetsPetService1(final Player player, final String s, final PetsPetService3 d) {
        pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService5.put(player.getUniqueId(), new _A(PetsPetService2(d), d, s, pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.J(s)));
        d.spawn(player, s);
    }
    
    public static void PetsPetService5(final Player player) {
        PetsPetService1(player, false, false);
    }
    
    public static void L(final Player player) {
        PetsPetService1(player, true);
    }
    
    public static String PetsPetService1(final PetsPetService3 d) {
        return PetsPetService2(d);
    }
    
    private static String PetsPetService2(final PetsPetService3 d) {
        final String lowerCase;
        final String s = lowerCase = d.getClass().getSimpleName().toLowerCase();
        switch (lowerCase) {
            case "ba\u0142wanek": {
                return "balwanek";
            }
            case "paj\u0105k": {
                return "pajak";
            }
            case "zaj\u0105czek": {
                return "zaj\u0105czek";
            }
            default: {
                return s;
            }
        }
    }
    
    public static ItemStack Q(final String s) {
        return PetsPetService1("P\u0119dziwiatr", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack V(final String s) {
        return PetsPetService1("Anio\u0142ek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack H(final String s) {
        return PetsPetService1("Pancernik", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack P(final String s) {
        return PetsPetService1("Pudzianek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack N(final String s) {
        return PetsPetService1("PetsPetService6\u0142odomorek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack S(final String s) {
        return PetsPetService1("Skalniaczek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack a(final String s) {
        return PetsPetService1("Biznesmen", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack L(final String s) {
        return PetsPetService1("Discordzik", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack PetsListener1(final String s) {
        return PetsPetService1("Duszek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack b(final String s) {
        return PetsPetService1("Nietoperek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack Z(final String s) {
        return PetsPetService1("Reniferek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack J(final String s) {
        return PetsPetService1("Ba\u0142wanek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack R(final String s) {
        return PetsPetService1("Golemik", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack M(final String s) {
        return PetsPetService1("Eustachy", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack U(final String s) {
        return PetsPetService1("Enderman", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack PetsPetService4(final String s) {
        return PetsPetService1("Zaj\u0105czek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack PetsPetService2(final String s) {
        return PetsPetService1("Pisklak", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack PetsPetService1(final String s) {
        return PetsPetService1("Cukiereczek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack _tmp(final String s) {
        return PetsPetService1("Rozdymek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack W(final String s) {
        return PetsPetService1("Paj\u0105k", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack d(final String s) {
        return PetsPetService1("Sowa", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack c(final String s) {
        return PetsPetService1("Drakula", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack PetsPetService6(final String s) {
        return PetsPetService1("Leniuszek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack T(final String s) {
        return PetsPetService1("Elfik", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack PetsPetService3(final String s) {
        return PetsPetService1("Pierniczek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack I(final String s) {
        return PetsPetService1("Paczu\u015b", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack O(final String s) {
        return PetsPetService1("Telekr\u00f3lik", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack X(final String s) {
        return PetsPetService1("Bobas", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack PetsPetService5(final String s) {
        return PetsPetService1("Cyber-Obro\u0144ca", Material.PLAYER_HEAD, s);
    }
    
    private static ItemStack PetsPetService1(final String s, final Material material, final String s2) {
        final ItemStack itemStack = new ItemStack(material);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b" + s));
            final ArrayList lore = new ArrayList();
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Kliknij prawym, aby aktywowa\u0107"));
            if (!s2.equals("brak")) {
                final LocalDateTime j = pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.J(s2);
                if (j != null) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7Pet wyga\u015bnie: &f" + j.format(pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService2)));
                }
            }
            itemMeta.setLore((List)lore);
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public static ItemStack PetsPetService1(final String s, final String s2, final LocalDateTime localDateTime) {
        final pl.ziffy.STORMSZAFKA.pets.PetsPetService6 petConfigManager = Main.getPetConfigManager();
        if (petConfigManager == null) {
            return PetsPetService1(s, Material.PLAYER_HEAD, (s2 != null) ? s2 : "brak");
        }
        String l = petConfigManager.L(s);
        final List<String> i = petConfigManager.I(s);
        final String k = petConfigManager.K(s);
        if (l == null) {
            l = "&7Pet &b" + s + " &7na czas " + pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.PetsPetService1();
        }
        ArrayList list;
        if (i == null) {
            list = new ArrayList();
            list.add("&8Przedmiot pospolity");
            list.add("&r");
            list.add("&fPet bez konfiguracji");
        }
        else {
            list = new ArrayList(i);
        }
        final ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            if (l != null) {
                String s3 = l;
                if (l.contains("{time}")) {
                    String replacement;
                    if (s2 != null && !s2.equals("brak") && !s2.equals("INFINITE")) {
                        replacement = pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.PetsPetService6(s2);
                    }
                    else {
                        replacement = pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.PetsPetService1();
                    }
                    s3 = l.replace("{time}", replacement);
                }
                else if (s2 != null && !s2.equals("brak") && !s2.equals("INFINITE")) {
                    s3 = l.replace("NA ZAWSZE", pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.PetsPetService6(s2));
                }
                itemMeta.setDisplayName(Y(s3));
            }
            if (localDateTime != null) {
                list.add("&r");
                list.add("&7Pet wyga\u015bnie: &f" + localDateTime.format(pl.ziffy.STORMSZAFKA.pets.PetsPetService4.PetsPetService2));
            }
            final ArrayList lore = new ArrayList();
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                lore.add(Y((String)iterator.next()));
            }
            itemMeta.setLore((List)lore);
            if (k != null && itemMeta instanceof SkullMeta) {
                PetsPetService1((SkullMeta)itemMeta, k);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public static ItemStack PetsPetService1(final String s, final String s2) {
        return PetsPetService1(s, s2, true);
    }
    
    public static ItemStack PetsPetService1(final String s, final String s2, final boolean b) {
        final pl.ziffy.STORMSZAFKA.pets.PetsPetService6 petConfigManager = Main.getPetConfigManager();
        if (petConfigManager == null) {
            return PetsPetService1(s, Material.PLAYER_HEAD, s2);
        }
        String s3 = b ? petConfigManager.PetsPetService1(s, s2) : petConfigManager.L(s);
        final List<String> i = petConfigManager.I(s);
        final String k = petConfigManager.K(s);
        if (s3 == null) {
            s3 = "&7Pet &b" + s + " &7na czas " + pl.ziffy.STORMSZAFKA.utils.time.PetsPetService1.PetsPetService1();
        }
        ArrayList list;
        if (i == null) {
            list = new ArrayList();
            list.add("&8Przedmiot pospolity");
            list.add("&r");
            list.add("&fPet bez konfiguracji");
        }
        else {
            list = new ArrayList(i);
        }
        final ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            if (s3 != null) {
                itemMeta.setDisplayName(Y(s3));
            }
            final ArrayList lore = new ArrayList();
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                lore.add(Y((String)iterator.next()));
            }
            itemMeta.setLore((List)lore);
            if (k != null && itemMeta instanceof SkullMeta) {
                PetsPetService1((SkullMeta)itemMeta, k);
            }
            try {
                itemMeta.getPersistentDataContainer().set(new NamespacedKey((Plugin)Main.getInstance(), "pet_type"), PersistentDataType.STRING, (Object)s);
            }
            catch (final Exception ex) {}
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    private static void PetsPetService1(final SkullMeta skullMeta, final String s) {
        pl.ziffy.STORMSZAFKA.utils.PetsListener1.PetsPetService3(skullMeta, s);
    }
    
    public static String Y(String translateHexColors) {
        if (translateHexColors == null) {
            return null;
        }
        translateHexColors = Main.translateHexColors(translateHexColors);
        return ChatColor.translateAlternateColorCodes('&', translateHexColors);
    }
    
    static {
        PetsPetService5 = new ConcurrentHashMap<UUID, _A>();
        PetsPetService2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    }
    
    public static class _A
    {
        public final String PetsListener1;
        public final PetsPetService3 PetsPetService1;
        public final String PetsPetService2;
        public final LocalDateTime PetsPetService5;
        public boolean PetsPetService3;
        public BukkitTask PetsPetService4;
        
        public _A(final String c, final PetsPetService3 a, final String b, final LocalDateTime f) {
            this.PetsListener1 = c;
            this.PetsPetService1 = a;
            this.PetsPetService2 = b;
            this.PetsPetService5 = f;
            this.PetsPetService3 = false;
            this.PetsPetService4 = null;
        }
    }
}
