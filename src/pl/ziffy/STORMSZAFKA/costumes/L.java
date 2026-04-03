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
import pl.ziffy.STORMSZAFKA.costumes.items.D;
import pl.ziffy.STORMSZAFKA.costumes.items.B;
import pl.ziffy.STORMSZAFKA.costumes.items.F;
import pl.ziffy.STORMSZAFKA.costumes.items.H;
import pl.ziffy.STORMSZAFKA.costumes.items.G;
import pl.ziffy.STORMSZAFKA.costumes.items.E;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;
import java.time.LocalDateTime;
import pl.ziffy.STORMSZAFKA.utils.time.A;
import org.bukkit.entity.Player;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;
import pl.ziffy.STORMSZAFKA.Main;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.Map;

public class L
{
    public static final Map<UUID, _A> C;
    private static final DateTimeFormatter A;
    private static Main D;
    private static BukkitTask B;
    
    public static void A(final Main d) {
        L.D = d;
        C();
    }
    
    public static void M() {
        if (L.B != null) {
            L.B.cancel();
        }
        for (final Map.Entry entry : L.C.entrySet()) {
            final _A a = (_A)entry.getValue();
            if (a.B != null) {
                final Player player = Bukkit.getPlayer((UUID)entry.getKey());
                if (player == null) {
                    continue;
                }
                a.B.remove(player);
            }
        }
        L.C.clear();
    }
    
    public static boolean A(final Player player, final String s, final String s2) {
        return A(player, s, s2, true);
    }
    
    public static boolean A(final Player player, final String s, final String s2, final boolean b) {
        if (F(player)) {
            A(player, false, false);
        }
        final C a = A(s);
        if (a == null) {
            return false;
        }
        L.C.put(player.getUniqueId(), new _A(a, s, s2, pl.ziffy.STORMSZAFKA.utils.time.A.J(s2)));
        a.apply(player);
        if (b) {
            C(player, s);
        }
        return true;
    }
    
    public static boolean A(final Player player, final String s, final String s2, final String s3) {
        return A(player, s, s2, s3, true);
    }
    
    public static boolean A(final Player player, final String s, final String s2, final String s3, final boolean b) {
        if (F(player)) {
            A(player, false, false);
        }
        final C a = A(s);
        if (a == null) {
            return false;
        }
        L.C.put(player.getUniqueId(), new _A(a, s, s2, pl.ziffy.STORMSZAFKA.utils.time.A.A(s3)));
        a.apply(player);
        if (b) {
            C(player, s);
        }
        return true;
    }
    
    public static void A(final Player player, final C c) {
        if (L.C.containsKey(player.getUniqueId())) {
            C(player);
        }
        c.apply(player);
        L.C.put(player.getUniqueId(), new _A(c, "unknown", "brak", null));
    }
    
    public static void C(final Player player) {
        A(player, true, true);
    }
    
    public static void A(final Player player, final boolean b, final boolean b2) {
        final _A a = L.C.remove(player.getUniqueId());
        if (a != null && a.B != null) {
            final String d = a.D;
            final String a2 = a.A;
            final LocalDateTime c = a.C;
            a.B.remove(player);
            if (b2) {
                final ItemStack a3 = A(d, a2, c);
                if (a3 != null) {
                    if (player.getInventory().firstEmpty() == -1) {
                        player.getWorld().dropItemNaturally(player.getLocation(), a3);
                        player.sendMessage(String.valueOf(ChatColor.YELLOW) + "Tw\u00f3j ekwipunek jest pe\u0142ny! Przedmiot kostiumu " + String.valueOf(ChatColor.AQUA) + F(d) + String.valueOf(ChatColor.YELLOW) + " zosta\u0142 upuszczony na ziemi\u0119.");
                    }
                    else {
                        player.getInventory().addItem(new ItemStack[] { a3 });
                    }
                }
            }
            if (b) {
                A(player, d);
            }
        }
    }
    
    public static boolean F(final Player player) {
        return L.C.containsKey(player.getUniqueId());
    }
    
    public static ItemStack E(final Player player) {
        final _A a = L.C.get(player.getUniqueId());
        if (a == null) {
            return null;
        }
        return A(a.D, a.A, a.C);
    }
    
    public static void A(final Player player, final ItemStack itemStack) {
    }
    
    public static ItemStack B(final String s) {
        if (s.equalsIgnoreCase("zabojczykrolik")) {
            return D();
        }
        if (s.equalsIgnoreCase("walentynkowy")) {
            return G();
        }
        if (s.equalsIgnoreCase("przeciwzakazeniowy")) {
            return E();
        }
        if (s.equalsIgnoreCase("malyurwis")) {
            return K();
        }
        if (s.equalsIgnoreCase("pirata")) {
            return I();
        }
        if (s.equalsIgnoreCase("nurekglebinowy")) {
            return J();
        }
        if (s.equalsIgnoreCase("mima")) {
            return B();
        }
        if (s.equalsIgnoreCase("wampir")) {
            return H();
        }
        return null;
    }
    
    public static ItemStack E(final String s) {
        if (s.equalsIgnoreCase("zabojczykrolik")) {
            return new E().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("walentynkowy")) {
            return new pl.ziffy.STORMSZAFKA.costumes.items.A().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("przeciwzakazeniowy")) {
            return new G().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("malyurwis")) {
            return new H().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("pirata")) {
            return new F().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("nurekglebinowy")) {
            return new pl.ziffy.STORMSZAFKA.costumes.items.C().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("mima")) {
            return new B().getPreviewCostumeItem();
        }
        if (s.equalsIgnoreCase("wampir")) {
            return new D().getPreviewCostumeItem();
        }
        return null;
    }
    
    public static int C(final String s) {
        try {
            final File file = new File(Main.getInstance().getCustomDataFolder(), "costumes/" + D(s));
            if (file.exists()) {
                return ((FileConfiguration)YamlConfiguration.loadConfiguration(file)).getInt("extension.cost_per_day", 5000);
            }
        }
        catch (final Exception ex) {}
        return 5000;
    }
    
    private static String D(final String s) {
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
    
    private static ItemStack D() {
        return new E().getCostumeItem();
    }
    
    private static ItemStack G() {
        return new pl.ziffy.STORMSZAFKA.costumes.items.A().getCostumeItem();
    }
    
    private static ItemStack E() {
        return new G().getCostumeItem();
    }
    
    private static ItemStack K() {
        return new H().getCostumeItem();
    }
    
    private static ItemStack I() {
        return new F().getCostumeItem();
    }
    
    private static ItemStack J() {
        return new pl.ziffy.STORMSZAFKA.costumes.items.C().getCostumeItem();
    }
    
    private static ItemStack B() {
        return new B().getCostumeItem();
    }
    
    private static ItemStack H() {
        return new D().getCostumeItem();
    }
    
    public static void A() {
        final Iterator<_A> iterator = L.C.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().B.update();
        }
    }
    
    public static C A(final Player player) {
        final _A a = L.C.get(player.getUniqueId());
        return (a != null) ? a.B : null;
    }
    
    public static void I(final Player player) {
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        final C a = A(player);
        if (a != null) {
            a.showOriginalArmor(player);
        }
    }
    
    public static void B(final Player player) {
        if (player.hasMetadata("costume_inventory_open") || player.hasMetadata("costume_survival_inventory")) {
            return;
        }
        final C a = A(player);
        if (a != null) {
            a.restoreCostume(player);
        }
    }
    
    private static boolean A(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if ((itemStack.getType() == Material.PLAYER_HEAD || itemStack.getType() == Material.LEATHER_CHESTPLATE || itemStack.getType() == Material.LEATHER_LEGGINGS || itemStack.getType() == Material.LEATHER_BOOTS) && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            final String lowerCase = itemStack.getItemMeta().getDisplayName().toLowerCase();
            return lowerCase.contains("kostium") || lowerCase.contains("costume") || lowerCase.contains("zbroja") || lowerCase.contains("zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("zabojczego krolika") || lowerCase.contains("zbroja zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("walentynkowy") || lowerCase.contains("valentine") || lowerCase.contains("ma\u0142ego urwisa") || lowerCase.contains("malogo urwisa") || lowerCase.contains("przeciwzaka\u017ceniowy") || lowerCase.contains("przeciwzakazeniowy") || lowerCase.contains("wampira") || lowerCase.contains("wampir");
        }
        return false;
    }
    
    public static String D(final Player player) {
        final _A a = L.C.get(player.getUniqueId());
        return (a != null) ? a.D : null;
    }
    
    public static void L() {
        final LocalDateTime now = LocalDateTime.now();
        final ArrayList list = new ArrayList();
        for (final Map.Entry entry : L.C.entrySet()) {
            final _A a = (_A)entry.getValue();
            if (a.C != null && now.isAfter(a.C)) {
                list.add(entry.getKey());
            }
        }
        for (final UUID uuid : list) {
            final Player player = Bukkit.getPlayer(uuid);
            if (player != null && player.isOnline()) {
                final String d = L.C.get(uuid).D;
                A(player, false, false);
                B(player, d);
            }
            else {
                L.C.remove(uuid);
            }
        }
    }
    
    private static C A(final String s) {
        final String lowerCase = s.toLowerCase();
        switch (lowerCase) {
            case "zabojczykrolik": {
                return new E();
            }
            case "walentynkowy": {
                return new pl.ziffy.STORMSZAFKA.costumes.items.A();
            }
            case "przeciwzakazeniowy": {
                return new G();
            }
            case "malyurwis": {
                return new H();
            }
            case "pirata": {
                return new F();
            }
            case "nurekglebinowy": {
                return new pl.ziffy.STORMSZAFKA.costumes.items.C();
            }
            case "mima": {
                return new B();
            }
            case "wampir": {
                return new D();
            }
            default: {
                return null;
            }
        }
    }
    
    public static ItemStack A(final String s, final String s2, final LocalDateTime localDateTime) {
        final ItemStack b = B(s);
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
                    replacement = pl.ziffy.STORMSZAFKA.utils.time.A.G(s2);
                }
                else {
                    replacement = pl.ziffy.STORMSZAFKA.utils.time.A.A();
                }
                itemMeta.setDisplayName(displayName.replace("{time}", replacement));
            }
            if (localDateTime != null) {
                final ArrayList lore = itemMeta.hasLore() ? new ArrayList(itemMeta.getLore()) : new ArrayList();
                lore.add((Object)ChatColor.translateAlternateColorCodes('&', "&r"));
                lore.add((Object)ChatColor.translateAlternateColorCodes('&', "&7Kostium wyga\u015bnie: &f" + localDateTime.format(L.A)));
                itemMeta.setLore((List)lore);
            }
            b.setItemMeta(itemMeta);
        }
        return b;
    }
    
    public static ItemStack A(final String s, final String s2) {
        return A(s, s2, true);
    }
    
    public static ItemStack A(final String s, final String s2, final boolean b) {
        final ItemStack b2 = B(s);
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
                    replacement = pl.ziffy.STORMSZAFKA.utils.time.A.A();
                }
                else {
                    replacement = pl.ziffy.STORMSZAFKA.utils.time.A.G(s2);
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
    
    private static void C(final Player player, final String s) {
        if (player.hasMetadata("costume_silent_refresh")) {
            return;
        }
        final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
        if (e != null) {
            e.A(player, "costume.activated", "costume_name", s);
        }
        final pl.ziffy.STORMSZAFKA.pets.G petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null) {
            A(player, petConfigManager.F());
        }
    }
    
    private static void A(final Player player, final String s) {
        final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
        if (e != null) {
            e.A(player, "costume.removed", "costume_name", s);
        }
        final pl.ziffy.STORMSZAFKA.pets.G petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null) {
            A(player, petConfigManager.H());
        }
    }
    
    private static void B(final Player player, final String s) {
        final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
        if (e != null) {
            e.A(player, "costume.expired", "costume_name", s);
        }
        final pl.ziffy.STORMSZAFKA.pets.G petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null) {
            A(player, petConfigManager.J());
        }
    }
    
    private static void A(final Player player, final Map<String, Object> map) {
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
    
    private static void C() {
        if (L.D != null) {
            L.B = Bukkit.getScheduler().runTaskTimer((Plugin)L.D, L::L, 600L, 600L);
        }
    }
    
    private static String F(final String s) {
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
                return "Kostium G\u0142\u0119binowego nurka";
            }
            default: {
                return s;
            }
        }
    }
    
    public static _A G(final Player player) {
        return L.C.get(player.getUniqueId());
    }
    
    public static void A(final Player player, final int n) {
        final _A a = L.C.get(player.getUniqueId());
        if (a == null || a.C == null) {
            return;
        }
        L.C.put(player.getUniqueId(), new _A(a.B, a.D, a.A, a.C.plusDays(n)));
    }
    
    public static String H(final Player player) {
        final _A a = L.C.get(player.getUniqueId());
        if (a != null) {
            return a.A;
        }
        return null;
    }
    
    public static void F() {
    }
    
    static {
        C = new ConcurrentHashMap<UUID, _A>();
        A = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    }
    
    public static class _A
    {
        public final C B;
        public final String D;
        public final String A;
        public final LocalDateTime C;
        
        public _A(final C b, final String d, final String a, final LocalDateTime c) {
            this.B = b;
            this.D = d;
            this.A = a;
            this.C = c;
        }
    }
}
