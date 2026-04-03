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
import pl.ziffy.STORMSZAFKA.pets.items.C;
import pl.ziffy.STORMSZAFKA.pets.items.P;
import pl.ziffy.STORMSZAFKA.pets.items.F;
import pl.ziffy.STORMSZAFKA.pets.items.M;
import pl.ziffy.STORMSZAFKA.pets.items.R;
import pl.ziffy.STORMSZAFKA.pets.items.W;
import pl.ziffy.STORMSZAFKA.pets.items.Y;
import pl.ziffy.STORMSZAFKA.pets.items.I;
import pl.ziffy.STORMSZAFKA.pets.items.B;
import pl.ziffy.STORMSZAFKA.pets.items.L;
import pl.ziffy.STORMSZAFKA.pets.items.V;
import pl.ziffy.STORMSZAFKA.pets.items.S;
import pl.ziffy.STORMSZAFKA.pets.items.Q;
import pl.ziffy.STORMSZAFKA.pets.items.Z;
import pl.ziffy.STORMSZAFKA.pets.items.H;
import pl.ziffy.STORMSZAFKA.pets.items.b;
import pl.ziffy.STORMSZAFKA.pets.items.a;
import pl.ziffy.STORMSZAFKA.pets.items.J;
import pl.ziffy.STORMSZAFKA.pets.items.K;
import pl.ziffy.STORMSZAFKA.pets.items.T;
import pl.ziffy.STORMSZAFKA.pets.items.G;
import pl.ziffy.STORMSZAFKA.pets.items.X;
import pl.ziffy.STORMSZAFKA.pets.items.N;
import pl.ziffy.STORMSZAFKA.pets.items.U;
import pl.ziffy.STORMSZAFKA.pets.items.O;
import pl.ziffy.STORMSZAFKA.pets.items._;
import java.util.ArrayList;
import java.time.chrono.ChronoLocalDateTime;
import java.time.LocalDateTime;
import org.bukkit.inventory.ItemStack;
import pl.ziffy.STORMSZAFKA.utils.time.A;
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

public class E
{
    public static final Map<UUID, _A> F;
    private static Main D;
    private static BukkitTask C;
    private static final DateTimeFormatter B;
    public static final String E = "STORMSZAFKA_PET";
    public static final String A = "STORMSZAFKA_PET_HOLOGRAM";
    
    public static void A(final Main d) {
        pl.ziffy.STORMSZAFKA.pets.E.D = d;
        A();
        C();
    }
    
    public static int A() {
        int n = 0;
        final Iterator iterator = Bukkit.getWorlds().iterator();
        while (iterator.hasNext()) {
            for (final Entity entity : ((World)iterator.next()).getEntities()) {
                if (entity instanceof final ArmorStand armorStand) {
                    if (armorStand.hasMetadata("STORMSZAFKA_PET") || armorStand.hasMetadata("STORMSZAFKA_PET_HOLOGRAM")) {
                        boolean b = true;
                        for (final _A a : pl.ziffy.STORMSZAFKA.pets.E.F.values()) {
                            if (a.A != null && A(a.A, armorStand)) {
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
                        if (!A(armorStand)) {
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
        if (n > 0 && pl.ziffy.STORMSZAFKA.pets.E.D != null) {
            pl.ziffy.STORMSZAFKA.pets.E.D.getLogger().info("[PetManager] Usuni\u0119to " + n + " osieroconych ArmorStand\u00f3w pet\u00f3w.");
        }
        return n;
    }
    
    private static boolean A(final ArmorStand armorStand) {
        return !armorStand.isVisible() && !armorStand.hasGravity() && armorStand.isMarker();
    }
    
    private static boolean A(final D d, final ArmorStand armorStand) {
        return false;
    }
    
    public static void B(final ArmorStand armorStand, final UUID uuid) {
        if (pl.ziffy.STORMSZAFKA.pets.E.D != null && armorStand != null) {
            armorStand.setMetadata("STORMSZAFKA_PET", (MetadataValue)new FixedMetadataValue((Plugin)pl.ziffy.STORMSZAFKA.pets.E.D, (Object)uuid.toString()));
        }
    }
    
    public static void A(final ArmorStand armorStand, final UUID uuid) {
        if (pl.ziffy.STORMSZAFKA.pets.E.D != null && armorStand != null) {
            armorStand.setMetadata("STORMSZAFKA_PET_HOLOGRAM", (MetadataValue)new FixedMetadataValue((Plugin)pl.ziffy.STORMSZAFKA.pets.E.D, (Object)uuid.toString()));
        }
    }
    
    public static void E() {
        if (pl.ziffy.STORMSZAFKA.pets.E.C != null) {
            pl.ziffy.STORMSZAFKA.pets.E.C.cancel();
        }
        for (final _A a : pl.ziffy.STORMSZAFKA.pets.E.F.values()) {
            if (a.A != null) {
                a.A.remove();
            }
        }
        pl.ziffy.STORMSZAFKA.pets.E.F.clear();
    }
    
    public static boolean A(final Player player, final String s, final String s2) {
        if (K(player)) {
            A(player, false, false);
        }
        final D k = K(s);
        if (k == null) {
            return false;
        }
        final _A a = new _A(s, k, s2, pl.ziffy.STORMSZAFKA.utils.time.A.J(s2));
        pl.ziffy.STORMSZAFKA.pets.E.F.put(player.getUniqueId(), a);
        k.spawn(player, s2);
        Plugin plugin = Bukkit.getPluginManager().getPlugin("STORMSZAFKA");
        if (plugin == null) {
            plugin = Bukkit.getPluginManager().getPlugin("stormszafka");
        }
        if (plugin != null) {
            a.E = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
                if (!player2.isOnline() || !pl.ziffy.STORMSZAFKA.pets.E.F.containsKey(player2.getUniqueId())) {
                    return;
                }
                else {
                    d.update();
                    return;
                }
            }, 0L, 1L);
        }
        B(player, s);
        return true;
    }
    
    public static boolean A(final Player player, final String s, final String s2, final String s3) {
        if (K(player)) {
            A(player, false, false);
        }
        final D k = K(s);
        if (k == null) {
            return false;
        }
        final _A a = new _A(s, k, s2, pl.ziffy.STORMSZAFKA.utils.time.A.A(s3));
        pl.ziffy.STORMSZAFKA.pets.E.F.put(player.getUniqueId(), a);
        k.spawn(player, s2);
        Plugin plugin = Bukkit.getPluginManager().getPlugin("STORMSZAFKA");
        if (plugin == null) {
            plugin = Bukkit.getPluginManager().getPlugin("stormszafka");
        }
        if (plugin != null) {
            a.E = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
                if (!player2.isOnline() || !pl.ziffy.STORMSZAFKA.pets.E.F.containsKey(player2.getUniqueId())) {
                    return;
                }
                else {
                    d.update();
                    return;
                }
            }, 0L, 1L);
        }
        B(player, s);
        return true;
    }
    
    public static void A(final Player player, final boolean b) {
        A(player, b, true);
    }
    
    public static void A(final Player player, final boolean b, final boolean b2) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.E.F.remove(player.getUniqueId());
        if (a != null && a.A != null) {
            final String c = a.C;
            final String b3 = a.B;
            final LocalDateTime f = a.F;
            if (a.E != null) {
                a.E.cancel();
            }
            a.A.remove();
            Main.savedPetMap.remove(player.getUniqueId());
            if (pl.ziffy.STORMSZAFKA.pets.E.D != null && pl.ziffy.STORMSZAFKA.pets.E.D.getPetDataManager() != null) {
                pl.ziffy.STORMSZAFKA.pets.E.D.getPetDataManager().B(player.getUniqueId());
            }
            if (b2) {
                final ItemStack a2 = A(c, b3, f);
                if (a2 != null) {
                    if (player.getInventory().firstEmpty() == -1) {
                        player.getWorld().dropItemNaturally(player.getLocation(), a2);
                        final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
                        if (e != null) {
                            e.A(player, "pet.inventory-full", "pet_type", c);
                        }
                    }
                    else {
                        player.getInventory().addItem(new ItemStack[] { a2 });
                        final pl.ziffy.STORMSZAFKA.messages.A e2 = pl.ziffy.STORMSZAFKA.messages.A.E();
                        if (e2 != null) {
                            e2.A(player, "pet.received-item", "pet_type", c);
                        }
                    }
                }
            }
            if (b) {
                C(player, c);
            }
        }
    }
    
    public static void M(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.E.F.get(player.getUniqueId());
        if (a != null && a.A != null) {
            final pl.ziffy.STORMSZAFKA.pets.A value = new pl.ziffy.STORMSZAFKA.pets.A(a.C, (a.F != null) ? a.F.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : "brak", a.D, a.B);
            Main.savedPetMap.put(player.getUniqueId(), value);
            if (pl.ziffy.STORMSZAFKA.pets.E.D != null && pl.ziffy.STORMSZAFKA.pets.E.D.getPetDataManager() != null) {
                pl.ziffy.STORMSZAFKA.pets.E.D.getPetDataManager().A(player.getUniqueId(), value);
            }
            if (a.E != null) {
                a.E.cancel();
            }
            a.A.remove();
            pl.ziffy.STORMSZAFKA.pets.E.F.remove(player.getUniqueId());
        }
    }
    
    public static void C(final Player player) {
        pl.ziffy.STORMSZAFKA.pets.A a = Main.savedPetMap.get(player.getUniqueId());
        if (a == null && pl.ziffy.STORMSZAFKA.pets.E.D != null && pl.ziffy.STORMSZAFKA.pets.E.D.getPetDataManager() != null) {
            a = pl.ziffy.STORMSZAFKA.pets.E.D.getPetDataManager().A(player.getUniqueId());
        }
        if (a != null && !K(player)) {
            final String c = a.C;
            String a2 = a.A;
            final String b = a.B;
            final boolean d = a.D;
            if (a2 == null || a2.isEmpty()) {
                a2 = "brak";
            }
            if (b != null && !b.equals("brak")) {
                final LocalDateTime a3 = pl.ziffy.STORMSZAFKA.utils.time.A.A(b);
                if (a3 != null && LocalDateTime.now().isAfter(a3)) {
                    Main.savedPetMap.remove(player.getUniqueId());
                    if (pl.ziffy.STORMSZAFKA.pets.E.D != null && pl.ziffy.STORMSZAFKA.pets.E.D.getPetDataManager() != null) {
                        pl.ziffy.STORMSZAFKA.pets.E.D.getPetDataManager().B(player.getUniqueId());
                    }
                    return;
                }
            }
            if (b != null && !b.equals("brak")) {
                A(player, c, a2, b);
            }
            else {
                A(player, c, a2);
            }
            if (d) {
                Bukkit.getScheduler().runTaskLater((Plugin)pl.ziffy.STORMSZAFKA.pets.E.D, () -> D(player2), 5L);
            }
            Main.savedPetMap.remove(player.getUniqueId());
        }
    }
    
    public static boolean K(final Player player) {
        return pl.ziffy.STORMSZAFKA.pets.E.F.containsKey(player.getUniqueId());
    }
    
    public static ItemStack J(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.E.F.get(player.getUniqueId());
        if (a == null) {
            return null;
        }
        return A(a.C, a.B, a.F);
    }
    
    public static String A(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.E.F.get(player.getUniqueId());
        return (a != null) ? a.C : null;
    }
    
    public static String G(final Player player) {
        return A(player);
    }
    
    public static boolean I(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.E.F.get(player.getUniqueId());
        return a != null && a.D;
    }
    
    public static void D(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.E.F.get(player.getUniqueId());
        if (a != null && a.A != null) {
            a.D = true;
            a.A.hideFromOwner();
        }
    }
    
    public static void E(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.E.F.get(player.getUniqueId());
        if (a != null && a.A != null) {
            a.D = false;
            a.A.showToOwner();
        }
    }
    
    public static void H(final Player player) {
        final _A a = pl.ziffy.STORMSZAFKA.pets.E.F.remove(player.getUniqueId());
        if (a != null && a.A != null) {
            final String c = a.C;
            if (a.E != null) {
                a.E.cancel();
            }
            a.A.remove();
            final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
            if (e != null) {
                e.A(player, "pet.removed-disabled", "pet_type", c);
            }
        }
    }
    
    public static void D() {
        final LocalDateTime now = LocalDateTime.now();
        final ArrayList list = new ArrayList();
        for (final Map.Entry entry : pl.ziffy.STORMSZAFKA.pets.E.F.entrySet()) {
            final _A a = (_A)entry.getValue();
            if (a.F != null && now.isAfter(a.F)) {
                list.add(entry.getKey());
            }
        }
        for (final UUID key : list) {
            final Player player = Bukkit.getPlayer(key);
            if (player != null && player.isOnline()) {
                final String c = pl.ziffy.STORMSZAFKA.pets.E.F.get(key).C;
                A(player, false, false);
                A(player, c);
            }
            else {
                pl.ziffy.STORMSZAFKA.pets.E.F.remove(key);
                Main.savedPetMap.remove(key);
                if (pl.ziffy.STORMSZAFKA.pets.E.D == null || pl.ziffy.STORMSZAFKA.pets.E.D.getPetDataManager() == null) {
                    continue;
                }
                pl.ziffy.STORMSZAFKA.pets.E.D.getPetDataManager().B(key);
            }
        }
    }
    
    private static D K(final String s) {
        final String lowerCase = s.toLowerCase();
        switch (lowerCase) {
            case "cyber-obronca": {
                return new pl.ziffy.STORMSZAFKA.pets.items.E();
            }
            case "aniolek": {
                return new _();
            }
            case "pancernik": {
                return new O();
            }
            case "pudzianek": {
                return new U();
            }
            case "pedziwiatr": {
                return new pl.ziffy.STORMSZAFKA.pets.items.A();
            }
            case "glodomorek": {
                return new pl.ziffy.STORMSZAFKA.pets.items.D();
            }
            case "skalniaczek": {
                return new N();
            }
            case "biznesmenik": {
                return new X();
            }
            case "discordzik": {
                return new G();
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
                return new B();
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
                return new F();
            }
            case "telekrolik": {
                return new P();
            }
            case "bobas": {
                return new C();
            }
            default: {
                return null;
            }
        }
    }
    
    private static void B(final Player player, final String s) {
        final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
        if (e != null) {
            e.A(player, "pet.activated", "pet_name", s);
        }
        final pl.ziffy.STORMSZAFKA.pets.G petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null) {
            A(player, petConfigManager.F());
        }
    }
    
    private static void C(final Player player, final String s) {
        final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
        if (e != null) {
            e.A(player, "pet.removed", "pet_name", s);
        }
        final pl.ziffy.STORMSZAFKA.pets.G petConfigManager = Main.getPetConfigManager();
        if (petConfigManager != null) {
            A(player, petConfigManager.H());
        }
    }
    
    private static void A(final Player player, final String s) {
        final pl.ziffy.STORMSZAFKA.messages.A e = pl.ziffy.STORMSZAFKA.messages.A.E();
        if (e != null) {
            e.A(player, "pet.expired", "pet_name", s);
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
        if (pl.ziffy.STORMSZAFKA.pets.E.D != null) {
            pl.ziffy.STORMSZAFKA.pets.E.C = Bukkit.getScheduler().runTaskTimer((Plugin)pl.ziffy.STORMSZAFKA.pets.E.D, pl.ziffy.STORMSZAFKA.pets.E::D, 600L, 600L);
        }
    }
    
    public static void B() {
    }
    
    public static void A(final Player player, final String s, final D d) {
        pl.ziffy.STORMSZAFKA.pets.E.F.put(player.getUniqueId(), new _A(B(d), d, s, pl.ziffy.STORMSZAFKA.utils.time.A.J(s)));
        d.spawn(player, s);
    }
    
    public static void F(final Player player) {
        A(player, false, false);
    }
    
    public static void L(final Player player) {
        A(player, true);
    }
    
    public static String A(final D d) {
        return B(d);
    }
    
    private static String B(final D d) {
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
        return A("P\u0119dziwiatr", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack V(final String s) {
        return A("Anio\u0142ek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack H(final String s) {
        return A("Pancernik", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack P(final String s) {
        return A("Pudzianek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack N(final String s) {
        return A("G\u0142odomorek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack S(final String s) {
        return A("Skalniaczek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack a(final String s) {
        return A("Biznesmen", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack L(final String s) {
        return A("Discordzik", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack C(final String s) {
        return A("Duszek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack b(final String s) {
        return A("Nietoperek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack Z(final String s) {
        return A("Reniferek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack J(final String s) {
        return A("Ba\u0142wanek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack R(final String s) {
        return A("Golemik", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack M(final String s) {
        return A("Eustachy", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack U(final String s) {
        return A("Enderman", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack E(final String s) {
        return A("Zaj\u0105czek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack B(final String s) {
        return A("Pisklak", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack A(final String s) {
        return A("Cukiereczek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack _(final String s) {
        return A("Rozdymek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack W(final String s) {
        return A("Paj\u0105k", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack d(final String s) {
        return A("Sowa", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack c(final String s) {
        return A("Drakula", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack G(final String s) {
        return A("Leniuszek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack T(final String s) {
        return A("Elfik", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack D(final String s) {
        return A("Pierniczek", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack I(final String s) {
        return A("Paczu\u015b", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack O(final String s) {
        return A("Telekr\u00f3lik", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack X(final String s) {
        return A("Bobas", Material.PLAYER_HEAD, s);
    }
    
    public static ItemStack F(final String s) {
        return A("Cyber-Obro\u0144ca", Material.PLAYER_HEAD, s);
    }
    
    private static ItemStack A(final String s, final Material material, final String s2) {
        final ItemStack itemStack = new ItemStack(material);
        final ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta != null) {
            itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b" + s));
            final ArrayList lore = new ArrayList();
            lore.add(ChatColor.translateAlternateColorCodes('&', "&7Kliknij prawym, aby aktywowa\u0107"));
            if (!s2.equals("brak")) {
                final LocalDateTime j = pl.ziffy.STORMSZAFKA.utils.time.A.J(s2);
                if (j != null) {
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&7Pet wyga\u015bnie: &f" + j.format(pl.ziffy.STORMSZAFKA.pets.E.B)));
                }
            }
            itemMeta.setLore((List)lore);
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public static ItemStack A(final String s, final String s2, final LocalDateTime localDateTime) {
        final pl.ziffy.STORMSZAFKA.pets.G petConfigManager = Main.getPetConfigManager();
        if (petConfigManager == null) {
            return A(s, Material.PLAYER_HEAD, (s2 != null) ? s2 : "brak");
        }
        String l = petConfigManager.L(s);
        final List<String> i = petConfigManager.I(s);
        final String k = petConfigManager.K(s);
        if (l == null) {
            l = "&7Pet &b" + s + " &7na czas " + pl.ziffy.STORMSZAFKA.utils.time.A.A();
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
                        replacement = pl.ziffy.STORMSZAFKA.utils.time.A.G(s2);
                    }
                    else {
                        replacement = pl.ziffy.STORMSZAFKA.utils.time.A.A();
                    }
                    s3 = l.replace("{time}", replacement);
                }
                else if (s2 != null && !s2.equals("brak") && !s2.equals("INFINITE")) {
                    s3 = l.replace("NA ZAWSZE", pl.ziffy.STORMSZAFKA.utils.time.A.G(s2));
                }
                itemMeta.setDisplayName(Y(s3));
            }
            if (localDateTime != null) {
                list.add("&r");
                list.add("&7Pet wyga\u015bnie: &f" + localDateTime.format(pl.ziffy.STORMSZAFKA.pets.E.B));
            }
            final ArrayList lore = new ArrayList();
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                lore.add(Y((String)iterator.next()));
            }
            itemMeta.setLore((List)lore);
            if (k != null && itemMeta instanceof SkullMeta) {
                A((SkullMeta)itemMeta, k);
            }
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    public static ItemStack A(final String s, final String s2) {
        return A(s, s2, true);
    }
    
    public static ItemStack A(final String s, final String s2, final boolean b) {
        final pl.ziffy.STORMSZAFKA.pets.G petConfigManager = Main.getPetConfigManager();
        if (petConfigManager == null) {
            return A(s, Material.PLAYER_HEAD, s2);
        }
        String s3 = b ? petConfigManager.A(s, s2) : petConfigManager.L(s);
        final List<String> i = petConfigManager.I(s);
        final String k = petConfigManager.K(s);
        if (s3 == null) {
            s3 = "&7Pet &b" + s + " &7na czas " + pl.ziffy.STORMSZAFKA.utils.time.A.A();
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
                A((SkullMeta)itemMeta, k);
            }
            try {
                itemMeta.getPersistentDataContainer().set(new NamespacedKey((Plugin)Main.getInstance(), "pet_type"), PersistentDataType.STRING, (Object)s);
            }
            catch (final Exception ex) {}
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    
    private static void A(final SkullMeta skullMeta, final String s) {
        pl.ziffy.STORMSZAFKA.utils.C.D(skullMeta, s);
    }
    
    public static String Y(String translateHexColors) {
        if (translateHexColors == null) {
            return null;
        }
        translateHexColors = Main.translateHexColors(translateHexColors);
        return ChatColor.translateAlternateColorCodes('&', translateHexColors);
    }
    
    static {
        F = new ConcurrentHashMap<UUID, _A>();
        B = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    }
    
    public static class _A
    {
        public final String C;
        public final D A;
        public final String B;
        public final LocalDateTime F;
        public boolean D;
        public BukkitTask E;
        
        public _A(final String c, final D a, final String b, final LocalDateTime f) {
            this.C = c;
            this.A = a;
            this.B = b;
            this.F = f;
            this.D = false;
            this.E = null;
        }
    }
}
