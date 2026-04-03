// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes;

import org.bukkit.configuration.file.FileConfiguration;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Sound;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.Collection;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.NamespacedKey;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener3;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener2;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener4;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener5;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService3;
import pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService2;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;
import java.time.LocalDateTime;
import pl.ziffy.STORMSZAFKA.utils.time.CostumesListener1;
import org.bukkit.entity.Player;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;
import pl.ziffy.STORMSZAFKA.Main;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.Map;

public class CostumesCostumeService6
{
    public static final Map<UUID, _A> CostumesCostumeService1;
    private static final DateTimeFormatter CostumesListener1;
    private static Main CostumesListener3;
    private static BukkitTask CostumesListener2;
    
    public static void CostumesListener1(final Main d) {
        CostumesCostumeService6.CostumesListener3 = d;
        CostumesCostumeService1();
    }
    
    public static void M() {
        if (CostumesCostumeService6.CostumesListener2 != null) {
            CostumesCostumeService6.CostumesListener2.cancel();
        }
        for (final Map.Entry entry : CostumesCostumeService6.CostumesCostumeService1.entrySet()) {
            final _A a = (_A)entry.getValue();
            if (a.CostumesListener2 != null) {
                final Player player = Bukkit.getPlayer((UUID)entry.getKey());
                if (player == null) {
                    continue;
                }
                a.CostumesListener2.remove(player);
            }
        }
        CostumesCostumeService6.CostumesCostumeService1.clear();
    }
    
    public static boolean CostumesListener1(final Player player, final String s, final String s2) {
        return CostumesListener1(player, s, s2, true);
    }
    
    public static boolean CostumesListener1(final Player player, final String s, final String s2, final boolean b) {
        if (CostumesListener4(player)) {
            CostumesListener1(player, false, false);
        }
        final CostumesCostumeService1 a = CostumesListener1(s);
        if (a == null) {
            return false;
        }
        CostumesCostumeService6.CostumesCostumeService1.put(player.getUniqueId(), new _A(a, s, s2, pl.ziffy.STORMSZAFKA.utils.time.CostumesListener1.CostumesCostumeService5(s2)));
        a.apply(player);
        if (b) {
            CostumesCostumeService1(player, s);
        }
        return true;
    }
    
    public static boolean CostumesListener1(final Player player, final String s, final String s2, final String s3) {
        return CostumesListener1(player, s, s2, s3, true);
    }
    
    public static boolean CostumesListener1(final Player player, final String s, final String s2, final String s3, final boolean b) {
        if (CostumesListener4(player)) {
            CostumesListener1(player, false, false);
        }
        final CostumesCostumeService1 a = CostumesListener1(s);
        if (a == null) {
            return false;
        }
        CostumesCostumeService6.CostumesCostumeService1.put(player.getUniqueId(), new _A(a, s, s2, pl.ziffy.STORMSZAFKA.utils.time.CostumesListener1.CostumesListener1(s3)));
        a.apply(player);
        if (b) {
            CostumesCostumeService1(player, s);
        }
        return true;
    }
    
    public static void CostumesListener1(final Player player, final CostumesCostumeService1 c) {
        if (CostumesCostumeService6.CostumesCostumeService1.containsKey(player.getUniqueId())) {
            CostumesCostumeService1(player);
        }
        c.apply(player);
        CostumesCostumeService6.CostumesCostumeService1.put(player.getUniqueId(), new _A(c, "unknown", "brak", null));
    }
    
    public static void CostumesCostumeService1(final Player player) {
        CostumesListener1(player, true, true);
    }
    
    public static void CostumesListener1(final Player player, final boolean b, final boolean b2) {
        final _A a = CostumesCostumeService6.CostumesCostumeService1.remove(player.getUniqueId());
        if (a != null && a.CostumesListener2 != null) {
            final String d = a.CostumesListener3;
            final String a2 = a.CostumesListener1;
            final LocalDateTime c = a.CostumesCostumeService1;
            a.CostumesListener2.remove(player);
            CostumesCostumeService3(player);
            if (b2) {
                final ItemStack a3 = CostumesListener1(d, a2, c);
                if (a3 != null) {
                    if (player.getInventory().firstEmpty() == -1) {
                        player.getWorld().dropItemNaturally(player.getLocation(), a3);
                        player.sendMessage(String.valueOf(ChatColor.YELLOW) + "Tw\u00f3j ekwipunek jest pe\u0142ny! Przedmiot kostiumu " + String.valueOf(ChatColor.AQUA) + CostumesListener4(d) + String.valueOf(ChatColor.YELLOW) + " zosta\u0142 upuszczony na ziemi\u0119.");
                    }
                    else {
                        player.getInventory().addItem(new ItemStack[] { a3 });
                    }
                }
            }
            if (b) {
                CostumesListener1(player, d);
            }
        }
    }

    private static void CostumesCostumeService3(final Player player) {
        for (final Player player2 : Bukkit.getOnlinePlayers()) {
            if (player2 == null || !player2.isOnline()) {
                continue;
            }
            player2.sendEquipmentChange(player, org.bukkit.inventory.EquipmentSlot.HEAD, player.getInventory().getHelmet());
            player2.sendEquipmentChange(player, org.bukkit.inventory.EquipmentSlot.CHEST, player.getInventory().getChestplate());
            player2.sendEquipmentChange(player, org.bukkit.inventory.EquipmentSlot.LEGS, player.getInventory().getLeggings());
            player2.sendEquipmentChange(player, org.bukkit.inventory.EquipmentSlot.FEET, player.getInventory().getBoots());
        }
    }
    
    public static boolean CostumesListener4(final Player player) {
        return CostumesCostumeService6.CostumesCostumeService1.containsKey(player.getUniqueId());
    }
    
    public static ItemStack CostumesCostumeService2(final Player player) {
        final _A a = CostumesCostumeService6.CostumesCostumeService1.get(player.getUniqueId());
        if (a == null) {
            return null;
        }
        return CostumesListener1(a.CostumesListener3, a.CostumesListener1, a.CostumesCostumeService1);
    }
    
    public static void CostumesListener1(final Player player, final ItemStack itemStack) {
    }
    
    public static ItemStack CostumesListener2(final String s) {
        if (s.equalsIgnoreCase("zabojczykrolik")) {
            return CostumesListener3();
        }
        if (s.equalsIgnoreCase("walentynkowy")) {
            return CostumesCostumeService3();
        }
        if (s.equalsIgnoreCase("przeciwzakazeniowy")) {
            return CostumesCostumeService2();
        }
        if (s.equalsIgnoreCase("malyurwis")) {
            return CostumesListener6();
        }
        if (s.equalsIgnoreCase("pirata")) {
            return CostumesCostumeService4();
        }
        if (s.equalsIgnoreCase("nurekglebinowy")) {
            return CostumesCostumeService5();
        }
        if (s.equalsIgnoreCase("mima")) {
            return CostumesListener2();
        }
        if (s.equalsIgnoreCase("wampir")) {
            return CostumesListener5();
        }
        return null;
    }
    
    public static ItemStack CostumesCostumeService2(final String s) {
        if (s.equalsIgnoreCase("zabojczykrolik")) {
            return new CostumesCostumeService2().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("walentynkowy")) {
            return new pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener1().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("przeciwzakazeniowy")) {
            return new CostumesCostumeService3().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("malyurwis")) {
            return new CostumesListener5().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("pirata")) {
            return new CostumesListener4().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("nurekglebinowy")) {
            return new pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService1().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("mima")) {
            return new CostumesListener2().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("wampir")) {
            return new CostumesListener3().getPreviewCostumeItem();
        }
        return null;
    }
    
    public static int CostumesCostumeService1(final String s) {
        try {
            final File file = new File(Main.getInstance().getCustomDataFolder(), "costumes/" + CostumesListener3(s));
            if (file.exists()) {
                return ((FileConfiguration)YamlConfiguration.loadConfiguration(file)).getInt("extension.cost_per_day", 5000);
            }
        }
        catch (final Exception ex) {}
        return 5000;
    }
    
    private static String CostumesListener3(final String s) {
        final String lowerCase = s.toLowerCase();
        switch (lowerCase) {
            case "zabojczykrolik": {
                return "KostiumZab\u00f3jczegoKr\u00f3lika.yml";
            }
            case "walentynkowy": {
                return "KostiumWalentynkowy.yml";
            }
            case "przeciwzakazeniowy": {
                return "KostiumPrzeciwzaka\u017ceniowy.yml";
            }
            case "malyurwis": {
                return "KostiumMa\u0142egoUrwisa.yml";
            }
            case "pirata": {
                return "KostiumPirata.yml";
            }
            case "nurekglebinowy": {
                return "KostiumNurkaG\u0142\u0119binowego.yml";
            }
            case "mima": {
                return "KostiumMima.yml";
            }
            case "wampir": {
                return "KostiumWampira.yml";
            }
            default: {
                return s + ".yml";
            }
        }
    }
    
    private static ItemStack CostumesListener3() {
        return new CostumesCostumeService2().getCostumeItem();
    }
    
    private static ItemStack CostumesCostumeService3() {
        return new pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener1().getCostumeItem();
    }
    
    private static ItemStack CostumesCostumeService2() {
        return new CostumesCostumeService3().getCostumeItem();
    }
    
    private static ItemStack CostumesListener6() {
        return new CostumesListener5().getCostumeItem();
    }
    
    private static ItemStack CostumesCostumeService4() {
        return new CostumesListener4().getCostumeItem();
    }
    
    private static ItemStack CostumesCostumeService5() {
        return new pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService1().getCostumeItem();
    }
    
    private static ItemStack CostumesListener2() {
        return new CostumesListener2().getCostumeItem();
    }
    
    private static ItemStack CostumesListener5() {
        return new CostumesListener3().getCostumeItem();
    }
    
    public static void CostumesListener1() {
        final Iterator<_A> iterator = CostumesCostumeService6.CostumesCostumeService1.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().CostumesListener2.update();
        }
    }
    
    public static CostumesCostumeService1 CostumesListener1(final Player player) {
        final _A a = CostumesCostumeService6.CostumesCostumeService1.get(player.getUniqueId());
        return (a != null) ? a.CostumesListener2 : null;
    }
    
    public static void CostumesCostumeService4(final Player player) {
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        final CostumesCostumeService1 a = CostumesListener1(player);
        if (a != null) {
            a.showOriginalArmor(player);
        }
    }
    
    public static void CostumesListener2(final Player player) {
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        final CostumesCostumeService1 a = CostumesListener1(player);
        if (a != null) {
            a.restoreCostume(player);
        }
    }
    
    private static boolean CostumesListener1(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if ((itemStack.getType() == Material.PLAYER_HEAD || itemStack.getType() == Material.LEATHER_CHESTPLATE || itemStack.getType() == Material.LEATHER_LEGGINGS || itemStack.getType() == Material.LEATHER_BOOTS) && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            final String lowerCase = itemStack.getItemMeta().getDisplayName().toLowerCase();
            return lowerCase.contains("kostium") || lowerCase.contains("costume") || lowerCase.contains("zbroja") || lowerCase.contains("zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("zabojczego krolika") || lowerCase.contains("zbroja zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("walentynkowy") || lowerCase.contains("valentine") || lowerCase.contains("ma\u0142ego urwisa") || lowerCase.contains("malogo urwisa") || lowerCase.contains("przeciwzaka\u017ceniowy") || lowerCase.contains("przeciwzakazeniowy") || lowerCase.contains("wampira") || lowerCase.contains("wampir");
        }
        return false;
    }
    
    public static String CostumesListener3(final Player player) {
        final _A a = CostumesCostumeService6.CostumesCostumeService1.get(player.getUniqueId());
        return (a != null) ? a.CostumesListener3 : null;
    }
    
    public static void CostumesCostumeService6() {
        final LocalDateTime now = LocalDateTime.now();
        final ArrayList list = new ArrayList();
        for (final Map.Entry entry : CostumesCostumeService6.CostumesCostumeService1.entrySet()) {
            final _A a = (_A)entry.getValue();
            if (a.CostumesCostumeService1 != null && now.isAfter(a.CostumesCostumeService1)) {
                list.add(entry.getKey());
            }
        }
        for (final UUID uuid : list) {
            final Player player = Bukkit.getPlayer(uuid);
            if (player != null && player.isOnline()) {
                final String d = CostumesCostumeService6.CostumesCostumeService1.get(uuid).CostumesListener3;
                CostumesListener1(player, false, false);
                CostumesListener2(player, d);
            }
            else {
                CostumesCostumeService6.CostumesCostumeService1.remove(uuid);
            }
        }
    }
    
    private static CostumesCostumeService1 CostumesListener1(final String s) {
        final String lowerCase = s.toLowerCase();
        switch (lowerCase) {
            case "zabojczykrolik": {
                return new CostumesCostumeService2();
            }
            case "walentynkowy": {
                return new pl.ziffy.STORMSZAFKA.costumes.items.CostumesListener1();
            }
            case "przeciwzakazeniowy": {
                return new CostumesCostumeService3();
            }
            case "malyurwis": {
                return new CostumesListener5();
            }
            case "pirata": {
                return new CostumesListener4();
            }
            case "nurekglebinowy": {
                return new pl.ziffy.STORMSZAFKA.costumes.items.CostumesCostumeService1();
            }
            case "mima": {
                return new CostumesListener2();
            }
            case "wampir": {
                return new CostumesListener3();
            }
            default: {
                return null;
            }
        }
    }
    
    public static ItemStack CostumesListener1(final String s, final String s2, final LocalDateTime localDateTime) {
        final ItemStack b = CostumesListener2(s);
        if (b == null) {
            return null;
        }
        final ItemMeta itemMeta = b.getItemMeta();
        if (itemMeta != null) {
            itemMeta.getPersistentDataContainer().set(new NamespacedKey((Plugin)Main.getInstance(), "costume_type"), PersistentDataType.STRING, (Object)s);
            if (itemMeta.hasDisplayName()) {
                final String displayName = itemMeta.getDisplayName();
                String replacement;
                if (s2 != null && !s2.equals("brak") && !s2.equals("INFINITE")) {
                    replacement = pl.ziffy.STORMSZAFKA.utils.time.CostumesListener1.CostumesCostumeService3(s2);
                }
                else {
                    replacement = pl.ziffy.STORMSZAFKA.utils.time.CostumesListener1.CostumesListener1();
                }
                itemMeta.setDisplayName(displayName.replace("{time}", replacement));
            }
            if (localDateTime != null) {
                final ArrayList lore = itemMeta.hasLore() ? new ArrayList(itemMeta.getLore()) : new ArrayList();
                lore.add((Object)ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add((Object)ChatColor.translateAlternateColorCodes('&', "&7Kostium wyga\u015bnie: &f" + localDateTime.format(CostumesCostumeService6.CostumesListener1)));
                itemMeta.setLore((List)lore);
            }
            b.setItemMeta(itemMeta);
        }
        return b;
    }
    
    public static ItemStack CostumesListener1(final String s, final String s2) {
        return CostumesListener1(s, s2, true);
    }
    
    public static ItemStack CostumesListener1(final String s, final String s2, final boolean b) {
        final ItemStack b2 = CostumesListener2(s);
        if (b2 == null) {
            return null;
        }
        final ItemMeta itemMeta = b2.getItemMeta();
        if (itemMeta != null) {
            itemMeta.getPersistentDataContainer().set(new NamespacedKey((Plugin)Main.getInstance(), "costume_type"), PersistentDataType.STRING, (Object)s);
            String replace = itemMeta.hasDisplayName() ? itemMeta.getDisplayName() : "";
            if (b) {
                String replacement;
                if (s2 == null || s2.isEmpty() || s2.equalsIgnoreCase("brak") || s2.equalsIgnoreCase("INFINITE")) {
                    replacement = pl.ziffy.STORMSZAFKA.utils.time.CostumesListener1.CostumesListener1();
                }
                else {
                    replacement = pl.ziffy.STORMSZAFKA.utils.time.CostumesListener1.CostumesCostumeService3(s2);
                }
                replace = replace.replace("{time}", replacement);
            }
            if (!replace.isEmpty()) {
                itemMeta.setDisplayName(replace);
            }
            b2.setItemMeta(itemMeta);
        }
        return b2;
    }
    
    private static void CostumesCostumeService1(final Player player, final String s) {
        if (player.hasMetadata("costume_silent_refresh")) {
            return;
        }
        final pl.ziffy.STORMSZAFKA.messages.CostumesListener1 e = pl.ziffy.STORMSZAFKA.messages.CostumesListener1.CostumesCostumeService2();
        if (e != null) {
            e.CostumesListener1(player, "costume.activated", "costume_name", s);
        }
        final pl.ziffy.STORMSZAFKA.pets.CostumesCostumeService3 petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null) {
            CostumesListener1(player, petConfigManager.CostumesListener4());
        }
    }
    
    private static void CostumesListener1(final Player player, final String s) {
        final pl.ziffy.STORMSZAFKA.messages.CostumesListener1 e = pl.ziffy.STORMSZAFKA.messages.CostumesListener1.CostumesCostumeService2();
        if (e != null) {
            e.CostumesListener1(player, "costume.removed", "costume_name", s);
        }
        final pl.ziffy.STORMSZAFKA.pets.CostumesCostumeService3 petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null) {
            CostumesListener1(player, petConfigManager.CostumesListener5());
        }
    }
    
    private static void CostumesListener2(final Player player, final String s) {
        final pl.ziffy.STORMSZAFKA.messages.CostumesListener1 e = pl.ziffy.STORMSZAFKA.messages.CostumesListener1.CostumesCostumeService2();
        if (e != null) {
            e.CostumesListener1(player, "costume.expired", "costume_name", s);
        }
        final pl.ziffy.STORMSZAFKA.pets.CostumesCostumeService3 petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null) {
            CostumesListener1(player, petConfigManager.CostumesCostumeService5());
        }
    }
    
    private static void CostumesListener1(final Player player, final Map<String, Object> map) {
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
    
    private static void CostumesCostumeService1() {
        if (CostumesCostumeService6.CostumesListener3 != null) {
            CostumesCostumeService6.CostumesListener2 = Bukkit.getScheduler().runTaskTimer((Plugin)CostumesCostumeService6.CostumesListener3, CostumesCostumeService6::CostumesCostumeService6, 600L, 600L);
        }
    }
    
    private static String CostumesListener4(final String s) {
        final String lowerCase = s.toLowerCase();
        switch (lowerCase) {
            case "zabojczykrolik": {
                return "Zab\u00f3jczy Kr\u00f3lik";
            }
            case "walentynkowy": {
                return "Kostium Walentynkowy";
            }
            case "przeciwzakazeniowy": {
                return "Kostium Przeciwzaka\u017ceniowy";
            }
            case "malyurwis": {
                return "Kostium Ma\u0142ego Urwisa";
            }
            case "mima": {
                return "Kostium Mima";
            }
            case "pirata": {
                return "Kostium Pirata";
            }
            case "g\u0142ebinowegonurka": {
                return "Kostium CostumesCostumeService3\u0142\u0119binowego nurka";
            }
            default: {
                return s;
            }
        }
    }
    
    public static _A CostumesCostumeService3(final Player player) {
        return CostumesCostumeService6.CostumesCostumeService1.get(player.getUniqueId());
    }
    
    public static void CostumesListener1(final Player player, final int n) {
        final _A a = CostumesCostumeService6.CostumesCostumeService1.get(player.getUniqueId());
        if (a == null || a.CostumesCostumeService1 == null) {
            return;
        }
        CostumesCostumeService6.CostumesCostumeService1.put(player.getUniqueId(), new _A(a.CostumesListener2, a.CostumesListener3, a.CostumesListener1, a.CostumesCostumeService1.plusDays(n)));
    }
    
    public static String CostumesListener5(final Player player) {
        final _A a = CostumesCostumeService6.CostumesCostumeService1.get(player.getUniqueId());
        if (a != null) {
            return a.CostumesListener1;
        }
        return null;
    }
    
    public static void CostumesListener4() {
    }
    
    static {
        CostumesCostumeService1 = new ConcurrentHashMap<UUID, _A>();
        CostumesListener1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    }
    
    public static class _A
    {
        public final CostumesCostumeService1 CostumesListener2;
        public final String CostumesListener3;
        public final String CostumesListener1;
        public final LocalDateTime CostumesCostumeService1;
        
        public _A(final CostumesCostumeService1 b, final String d, final String a, final LocalDateTime c) {
            this.CostumesListener2 = b;
            this.CostumesListener3 = d;
            this.CostumesListener1 = a;
            this.CostumesCostumeService1 = c;
        }
    }
}
