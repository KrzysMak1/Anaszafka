// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA;

import java.util.HashSet;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.time.format.DateTimeFormatter;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import java.util.Map;
import pl.ziffy.sTORMSZAFKA.bstats.charts.SimplePie;
import pl.ziffy.sTORMSZAFKA.bstats.charts.DrilldownPie;
import pl.ziffy.sTORMSZAFKA.bstats.charts.CustomChart;
import pl.ziffy.sTORMSZAFKA.bstats.charts.SingleLineChart;
import pl.ziffy.sTORMSZAFKA.bstats.bukkit.Metrics;
import org.bukkit.event.Listener;
import java.util.Iterator;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.CopyOption;
import java.io.File;
import pl.ziffy.STORMSZAFKA.data.DataDataModel2;
import pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService3;
import org.bukkit.scheduler.BukkitTask;
import pl.ziffy.STORMSZAFKA.costumes.CostumesListener6;
import pl.ziffy.STORMSZAFKA.costumes.CostumesListener5;
import pl.ziffy.STORMSZAFKA.costumes.CostumesListener4;
import pl.ziffy.STORMSZAFKA.data.DataDataModel3;
import pl.ziffy.STORMSZAFKA.ui.gui.UiGuiView1;
import pl.ziffy.STORMSZAFKA.pets.PetsPetService6;
import java.util.Set;
import pl.ziffy.STORMSZAFKA.pets.PetsPetService1;
import java.util.UUID;
import java.util.HashMap;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    public static HashMap<UUID, A> savedPetMap;
    public static Set<String> disabledPets;
    private static G O;
    private static B J;
    private static pl.ziffy.STORMSZAFKA.messages.MessagesMessageService1 F;
    private static Main S;
    private pl.ziffy.STORMSZAFKA.costumes.CostumesListener2 I;
    private pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService3 K;
    private pl.ziffy.STORMSZAFKA.costumes.CostumesListener1 A;
    private E N;
    private pl.ziffy.STORMSZAFKA.pets.PetsPetService2 G;
    private F P;
    private H M;
    private K Q;
    private BukkitTask H;
    private D R;
    private pl.ziffy.STORMSZAFKA.regions.RegionsRegionService2 E;
    private pl.ziffy.STORMSZAFKA.regions.RegionsRegionService1 B;
    private C D;
    private pl.ziffy.STORMSZAFKA.data.DataDataModel1 C;
    private String L;
    
    public File getCustomDataFolder() {
        final File parentFile = this.getDataFolder().getParentFile();
        final File file = new File(parentFile, "STORMSZAFKA");
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        final File file2 = new File(parentFile, "STORMPETY");
        if (file2.exists() && file2.isDirectory()) {
            return file2;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
    
    public void copyResourceToCustomFolder(final String child) {
        final File file = new File(this.getCustomDataFolder(), child);
        if (!file.exists()) {
            try {
                final File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                final InputStream resource = this.getResource(child);
                if (resource != null) {
                    Files.copy(resource, file.toPath(), new CopyOption[0]);
                    resource.close();
                }
            }
            catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void K() {
        for (final Player player : Bukkit.getOnlinePlayers()) {
            if (Main.savedPetMap.containsKey(player.getUniqueId()) && !pl.ziffy.STORMSZAFKA.pets.PetsPetService4.K(player)) {
                try {
                    final A a = Main.savedPetMap.get(player.getUniqueId());
                    String a2 = a.A;
                    if (a2 == null || a2.isEmpty()) {
                        a2 = "brak";
                    }
                    if (this.A(a.C) != null) {
                        if (a.B != null && !a.B.equals("brak")) {
                            pl.ziffy.STORMSZAFKA.pets.PetsPetService4.A(player, a.C, a2, a.B);
                        }
                        else {
                            pl.ziffy.STORMSZAFKA.pets.PetsPetService4.A(player, a.C, a2);
                        }
                        if (a.D) {
                            Bukkit.getScheduler().runTaskLater((Plugin)this, () -> pl.ziffy.STORMSZAFKA.pets.PetsPetService4.D(player2), 5L);
                        }
                    }
                    Main.savedPetMap.remove(player.getUniqueId());
                }
                catch (final Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    private void F() {
        this.P = new F(this);
        this.M = new H(this);
        this.Q = new K(this);
        pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService2.A(this.P);
        pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService2.A(this.Q);
        pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService2.A(this.N);
    }
    
    private void E() {
        final Listener[] array = { (Listener)new pl.ziffy.STORMSZAFKA.listeners.ListenersListener1(), (Listener)new pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener1(), (Listener)new pl.ziffy.STORMSZAFKA.listeners.ListenersListener2(), (Listener)new pl.ziffy.STORMSZAFKA.regions.RegionsListener1(this.E, this.B), (Listener)new pl.ziffy.STORMSZAFKA.utils.UtilsListener1(), (Listener)new pl.ziffy.STORMSZAFKA.pets.PetsListener1(this), (Listener)new pl.ziffy.STORMSZAFKA.costumes.CostumesListener3(this), (Listener)new pl.ziffy.STORMSZAFKA.costumes.CostumesListener2((Plugin)this), (Listener)new pl.ziffy.STORMSZAFKA.costumes.CostumesListener1((Plugin)this), (Listener)new pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1(), (Listener)new pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener2(), (Listener)new pl.ziffy.STORMSZAFKA.listeners.ListenersListener4(), (Listener)new pl.ziffy.STORMSZAFKA.listeners.ListenersListener3(), (Listener)new pl.ziffy.STORMSZAFKA.ui.gui.UiGuiListener1(), (Listener)new pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener1(), (Listener)new pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsListener2(), (Listener)new pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener3(), (Listener)new pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener1(), (Listener)new pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener2(), (Listener)new pl.ziffy.STORMSZAFKA.costumes.editors.CostumesEditorsListener4() };
        for (int length = array.length, i = 0; i < length; ++i) {
            this.getServer().getPluginManager().registerEvents(array[i], (Plugin)this);
        }
    }
    
    private void A() {
        Main.F = new pl.ziffy.STORMSZAFKA.messages.MessagesMessageService1((Plugin)this);
        Main.O = new G((Plugin)this);
        Main.J = new B((Plugin)this);
        if (Main.J != null) {
            pl.ziffy.STORMSZAFKA.ui.menu.UiMenuListener1.setConfigManager(Main.J);
            pl.ziffy.STORMSZAFKA.pets.editors.PetsEditorsPetEditorController2.A(Main.J);
            pl.ziffy.STORMSZAFKA.costumes.preview.CostumesPreviewListener1.setConfigManager(Main.J);
            pl.ziffy.STORMSZAFKA.utils.UtilsListener1.setConfigManager(Main.J);
        }
        if (Main.O != null) {
            Main.O.J("bobas");
            Main.O.J("zaj\u0105czek");
        }
    }
    
    private void D() {
        final String[] array = { "costumes/KostiumMa\u0142egoUrwisa.yml", "costumes/KostiumPrzeciwzaka\u017ceniowy.yml", "costumes/KostiumWalentynkowy.yml", "costumes/KostiumZab\u00f3jczegoKr\u00f3lika.yml", "costumes/KostiumPirata.yml", "costumes/KostiumNurkaG\u0142\u0119binowego.yml", "costumes/KostiumMima.yml" };
        final String[] array2 = { "pets/aniolek.yml", "pets/balwanek.yml", "pets/biznesmenik.yml", "pets/bobas.yml", "pets/cukiereczek.yml", "pets/discordzik.yml", "pets/drakula.yml", "pets/duszek.yml", "pets/elfik.yml", "pets/enderman.yml", "pets/eustachy.yml", "pets/glodomorek.yml", "pets/golemik.yml", "pets/leniuszek.yml", "pets/nietoperek.yml", "pets/paczus.yml", "pets/pajak.yml", "pets/pancernik.yml", "pets/pedziwiatr.yml", "pets/pierniczek.yml", "pets/pisklak.yml", "pets/pudzianek.yml", "pets/reniferek.yml", "pets/rozdymek.yml", "pets/skalniaczek.yml", "pets/sowa.yml", "pets/telekrolik.yml", "pets/zajaczek.yml" };
        final String[] array3 = { "lang/POL.yml", "lang/ENG.yml" };
        final String[] array4 = array;
        for (int length = array4.length, i = 0; i < length; ++i) {
            this.copyResourceToCustomFolder(array4[i]);
        }
        final String[] array5 = array2;
        for (int length2 = array5.length, j = 0; j < length2; ++j) {
            this.copyResourceToCustomFolder(array5[j]);
        }
        final String[] array6 = array3;
        for (int length3 = array6.length, k = 0; k < length3; ++k) {
            this.copyResourceToCustomFolder(array6[k]);
        }
    }
    
    public void onEnable() {
        this.L = this.getDescription().getVersion();
        Bukkit.getConsoleSender().sendMessage(translateHexColors("&8[&#B600D0&lS&#C500D1&lT&#D300D2&lO&#E200D3&lR&#F000D4&lM&#FF00D5&lS&#F000D4&lZ&#E200D3&lA&#D300D2&lF&#C500D1&lK&#B600D0&lA&8] &7Plugin &fSTORMSZAFKA &7zosta\u0142 &#00F90Dw\u0142\u0105czony&7! Wersja: &f" + this.L));
        (Main.S = this).reloadConfig();
        if (this.getConfig().getBoolean("settings.bStats", true)) {
            final Metrics metrics = new Metrics(this, 25974);
            metrics.addCustomChart(new SingleLineChart("active_pets", () -> pl.ziffy.STORMSZAFKA.pets.PetsPetService4.F.size()));
            metrics.addCustomChart(new DrilldownPie("pet_types", () -> {
                final HashMap hashMap = new HashMap();
                final HashMap hashMap2 = new HashMap();
                pl.ziffy.STORMSZAFKA.pets.PetsPetService4.F.values().iterator();
                final Iterator iterator2;
                while (iterator2.hasNext()) {
                    pl.ziffy.STORMSZAFKA.pets.PetsPetService4.A(iterator2.next().A);
                    final String key;
                    hashMap2.put(key, (int)hashMap2.getOrDefault(key, 0) + 1);
                }
                hashMap.put("Active Pets", hashMap2);
                return hashMap;
            }));
            metrics.addCustomChart(new SimplePie("minecraft_version", () -> Bukkit.getVersion().split("MC: ")[1].split("\\)")[0]));
        }
        this.getCustomDataFolder();
        this.copyResourceToCustomFolder("config.yml");
        this.copyResourceToCustomFolder("MenuConfig.yml");
        this.copyResourceToCustomFolder("PetMenuConfig.yml");
        this.copyResourceToCustomFolder("CostumeMenuConfig.yml");
        this.copyResourceToCustomFolder("pets.yml");
        this.D();
        this.A();
        if (this.getConfig().getBoolean("database.enabled", true)) {
            this.D = new C((Plugin)this, this.getCustomDataFolder());
            if (!this.D.C()) {
                this.D = null;
            }
        }
        else {
            this.D = null;
        }
        (this.G = new pl.ziffy.STORMSZAFKA.pets.PetsPetService2(this, Main.savedPetMap)).A(this.D);
        (this.C = new pl.ziffy.STORMSZAFKA.data.DataDataModel1(this)).A(this.D);
        this.G.A(Main.disabledPets);
        pl.ziffy.STORMSZAFKA.pets.PetsPetService4.A(this);
        pl.ziffy.STORMSZAFKA.fragments.FragmentsFragmentModel1.C();
        pl.ziffy.STORMSZAFKA.fragments.FragmentsFragmentModel1.A();
        pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.A(this);
        this.E = new pl.ziffy.STORMSZAFKA.regions.RegionsRegionService2((Plugin)this);
        this.B = new pl.ziffy.STORMSZAFKA.regions.RegionsRegionService1((Plugin)this);
        new pl.ziffy.STORMSZAFKA.commands.CommandsCommandExecutor3(this).setRegionCommand(new pl.ziffy.STORMSZAFKA.commands.CommandsCommandExecutor4(this, this.E, this.B));
        this.E();
        this.G.B();
        this.K();
        this.N = new E((Plugin)this);
        this.A = new pl.ziffy.STORMSZAFKA.costumes.CostumesListener1((Plugin)this);
        this.getServer().getPluginManager().registerEvents((Listener)this.A, (Plugin)this);
        this.K = new pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService3(this);
        this.F();
        (this.R = new D(this)).A();
        final Iterator iterator = Bukkit.getOnlinePlayers().iterator();
        while (iterator.hasNext()) {
            this.N.A((Player)iterator.next());
        }
        this.H = Bukkit.getScheduler().runTaskTimer((Plugin)this, () -> this.N.I(), 12000L, 12000L);
        this.G();
    }
    
    private void G() {
        if (!this.getConfig().getBoolean("settings.check-updates", true)) {
            return;
        }
        new pl.ziffy.STORMSZAFKA.utils.update.UtilsUpdateUtilityService1(this, 126020).A(this.L, b -> {
            if (b == null) {
                this.getLogger().warning("Nie uda\u0142o si\u0119 sprawdzi\u0107 aktualizacji.");
            }
            else {
                final String s = this.L.toUpperCase().endsWith("T") ? " &8(&cWERSJA TESTOWA&8)" : "";
                if (!b) {
                    Bukkit.getConsoleSender().sendMessage(translateHexColors("&8[&#B600D0&lSTORMSZAFKA&8] &7Plugin jest aktualny (wersja &f" + this.L + s + "&7)"));
                }
                else {
                    a.A(s3 -> {
                        if (s3 != null) {
                            Bukkit.getConsoleSender().sendMessage(translateHexColors("&8[&#B600D0&lSTORMSZAFKA&8] &7Znaleziono now\u0105 wersj\u0119: &f" + s3 + " &7(aktualna: &f" + this.L + s2 + "&7)"));
                            Bukkit.getConsoleSender().sendMessage(translateHexColors("&8[&#B600D0&lSTORMSZAFKA&8] &7Pobierz aktualizacj\u0119 ze strony: &fhttps://www.spigotmc.org/resources/126020/"));
                        }
                    });
                }
            }
        });
    }
    
    private pl.ziffy.STORMSZAFKA.pets.PetsPetService3 A(final String s) {
        return pl.ziffy.STORMSZAFKA.pets.PetsPetService5.A(s);
    }
    
    public void onDisable() {
        this.J();
    }
    
    private void J() {
        if (this.N != null) {
            final Iterator iterator = Bukkit.getOnlinePlayers().iterator();
            while (iterator.hasNext()) {
                this.N.B((Player)iterator.next());
            }
            this.N.H();
        }
        int n = 0;
        for (final Player player : Bukkit.getOnlinePlayers()) {
            if (pl.ziffy.STORMSZAFKA.pets.PetsPetService4.K(player)) {
                try {
                    final pl.ziffy.STORMSZAFKA.pets.PetsPetService4._A a = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.F.get(player.getUniqueId());
                    if (a == null) {
                        continue;
                    }
                    final String c = a.C;
                    final boolean i = pl.ziffy.STORMSZAFKA.pets.PetsPetService4.I(player);
                    final String b = a.B;
                    String format = null;
                    if (a.F != null) {
                        format = a.F.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    }
                    Main.savedPetMap.put(player.getUniqueId(), new A(c, (format != null) ? format : "brak", i, b));
                    ++n;
                }
                catch (final Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (this.G != null) {
            this.G.E();
        }
        if (this.C != null) {
            this.C.I();
        }
        pl.ziffy.STORMSZAFKA.pets.PetsPetService4.E();
        pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.M();
        if (this.P != null) {
            this.P.cleanup();
        }
        if (this.Q != null) {
            this.Q.cleanup();
        }
        for (final Player player2 : Bukkit.getOnlinePlayers()) {
            if (pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.F(player2)) {
                pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.C(player2);
            }
        }
        if (this.N != null) {
            this.N.B();
        }
        if (this.H != null) {
            this.H.cancel();
        }
        if (this.D != null) {
            this.D.A();
        }
        Bukkit.getConsoleSender().sendMessage(translateHexColors("&8[&#B600D0&lS&#C500D1&lT&#D300D2&lO&#E200D3&lR&#F000D4&lM&#FF00D5&lS&#F000D4&lZ&#E200D3&lA&#D300D2&lF&#C500D1&lK&#B600D0&lA&8] &7Plugin &fSTORMSZAFKA &7zosta\u0142 &#F90000wy\u0142\u0105czony&7!"));
    }
    
    public void reloadConfig() {
        final File file = new File(this.getCustomDataFolder(), "config.yml");
        try {
            if (file.exists()) {
                final YamlConfiguration loadConfiguration = YamlConfiguration.loadConfiguration(file);
                super.reloadConfig();
                final FileConfiguration config = super.getConfig();
                for (final String s : ((FileConfiguration)loadConfiguration).getKeys(true)) {
                    if (((FileConfiguration)loadConfiguration).isSet(s)) {
                        config.set(s, ((FileConfiguration)loadConfiguration).get(s));
                    }
                }
            }
            else {
                this.copyResourceToCustomFolder("config.yml");
                super.reloadConfig();
            }
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            super.reloadConfig();
        }
        if (Main.F != null) {
            try {
                Main.F.C();
            }
            catch (final Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }
    
    public void saveConfig() {
        final File file = new File(this.getCustomDataFolder(), "config.yml");
        try {
            super.getConfig().save(file);
        }
        catch (final IOException ex) {
            super.saveConfig();
        }
    }
    
    public void performFullReload() {
        try {
            this.reloadConfig();
            if (Main.O != null) {
                Main.O.A();
                Main.O.J("bobas");
            }
            if (Main.J != null) {}
            if (this.N != null) {
                this.N.D();
            }
            if (this.P != null) {}
            if (this.M != null) {}
            if (this.Q != null) {}
            pl.ziffy.STORMSZAFKA.pets.PetsPetService4.B();
            pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6.A();
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public static G getPetConfigManager() {
        if (Main.O == null) {
            if (Main.S != null) {
                try {
                    Main.O = new G((Plugin)Main.S);
                }
                catch (final Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return Main.O;
    }
    
    public static Main getInstance() {
        return Main.S;
    }
    
    public pl.ziffy.STORMSZAFKA.pets.PetsPetService4 getPetManager() {
        return (Bukkit.getServicesManager().getRegistration((Class)pl.ziffy.STORMSZAFKA.pets.PetsPetService4.class) != null) ? ((pl.ziffy.STORMSZAFKA.pets.PetsPetService4)Bukkit.getServicesManager().getRegistration((Class)pl.ziffy.STORMSZAFKA.pets.PetsPetService4.class).getProvider()) : null;
    }
    
    public static B getMenuConfigManager() {
        return Main.J;
    }
    
    public static pl.ziffy.STORMSZAFKA.messages.MessagesMessageService1 getLanguageManager() {
        return Main.F;
    }
    
    public E getCostumeDataManager() {
        return this.N;
    }
    
    public F getKoronaAnarchiiSupport() {
        return this.P;
    }
    
    public H getSakiewkaDropuSupport() {
        return this.M;
    }
    
    public K getEnchantedBookSupport() {
        return this.Q;
    }
    
    public static String translateHexColors(final String s) {
        return pl.ziffy.STORMSZAFKA.utils.UtilsUtilityService1.A(s);
    }
    
    public D getEconomyManager() {
        return this.R;
    }
    
    public Economy getEconomy() {
        return (this.R != null) ? this.R.C() : null;
    }
    
    public C getDatabaseManager() {
        return this.D;
    }
    
    public pl.ziffy.STORMSZAFKA.data.DataDataModel1 getSakiewkaDataManager() {
        return this.C;
    }
    
    public pl.ziffy.STORMSZAFKA.pets.PetsPetService2 getPetDataManager() {
        return this.G;
    }
    
    public pl.ziffy.STORMSZAFKA.regions.RegionsRegionService2 getRegionManager() {
        return this.E;
    }
    
    static {
        Main.savedPetMap = new HashMap<UUID, A>();
        Main.disabledPets = new HashSet<String>();
    }
}
