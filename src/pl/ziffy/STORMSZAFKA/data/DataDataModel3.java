// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.data;

import org.bukkit.configuration.file.FileConfiguration;
import java.util.UUID;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService5;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService4;
import java.util.Iterator;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import java.time.chrono.ChronoLocalDateTime;
import java.time.LocalDateTime;
import pl.ziffy.STORMSZAFKA.utils.time.UtilsTimeUtilityService1;
import java.time.format.DateTimeFormatter;
import pl.ziffy.STORMSZAFKA.costumes.CostumesCostumeService6;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.Main;
import java.io.File;
import org.bukkit.plugin.Plugin;

public class DataDataModel3
{
    private final Plugin A;
    private final File DataDataModel1;
    private G DataDataModel2;
    
    public DataDataModel3(final Plugin a) {
        this.A = a;
        this.DataDataModel1 = ((Main)a).getCustomDataFolder();
        if (!this.DataDataModel1.exists()) {
            this.DataDataModel1.mkdirs();
        }
        this.G();
        Bukkit.getScheduler().runTaskLater(a, () -> {
            if (this.DataDataModel3() > 0) {}
        }, 40L);
    }
    
    private void G() {
        final DataDataModel2 databaseManager = ((Main)this.A).getDatabaseManager();
        if (databaseManager != null && databaseManager.DataDataModel3()) {
            this.DataDataModel2 = new G(databaseManager);
        }
    }
    
    public void DataDataModel1(final Player player) {
        final boolean f = L.DataDataModel4(player);
        String lowerCase = null;
        String a = null;
        String format = null;
        if (f) {
            final pl.ziffy.STORMSZAFKA.costumes.DataDataModel2 a2 = L.A(player);
            if (a2 != null) {
                lowerCase = a2.getType().toLowerCase();
                final L._A g = L.G(player);
                if (g != null) {
                    a = g.A;
                    if (g.DataDataModel2 != null) {
                        format = g.DataDataModel2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    }
                }
            }
        }
        if (this.DataDataModel2 != null) {
            if (f && lowerCase != null) {
                this.DataDataModel2.A(player.getUniqueId(), lowerCase, a, format);
            }
            else {
                this.DataDataModel2.A(player.getUniqueId());
            }
        }
    }
    
    public void A(final Player player) {
        if (this.DataDataModel2 != null && this.DataDataModel2.DataDataModel2(player.getUniqueId()) && this.DataDataModel2.DataDataModel1(player.getUniqueId()) != null) {
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                final pl.ziffy.STORMSZAFKA.costumes.persistence.CostumesPersistenceCostumeRepository1 a2;
                final Object a = a2.A;
                final Object c = a2.DataDataModel2;
                final Object b = a2.DataDataModel1;
                if (player2.isOnline()) {
                    if (s != null && !s.equals("brak")) {
                        pl.ziffy.STORMSZAFKA.utils.time.UtilsTimeUtilityService1.A(s);
                        final LocalDateTime other;
                        if (other != null && LocalDateTime.now().isAfter(other)) {
                            this.DataDataModel2.A(player2.getUniqueId());
                        }
                        else {
                            L.A(player2, s2, s3, s, false);
                        }
                    }
                    else {
                        L.A(player2, s2, (s3 != null) ? s3 : "brak", false);
                    }
                }
            }, 40L);
        }
    }
    
    private ItemStack A(final ItemStack itemStack, final String s, final String s2) {
        if (itemStack != null && this.A(itemStack)) {
            return null;
        }
        return itemStack;
    }
    
    private boolean A(final ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        if ((itemStack.getType() == Material.PLAYER_HEAD || itemStack.getType() == Material.LEATHER_CHESTPLATE || itemStack.getType() == Material.LEATHER_LEGGINGS || itemStack.getType() == Material.LEATHER_BOOTS) && itemStack.hasItemMeta() && itemStack.getItemMeta().hasDisplayName()) {
            final String lowerCase = itemStack.getItemMeta().getDisplayName().toLowerCase();
            return lowerCase.contains("kostium") || lowerCase.contains("costume") || lowerCase.contains("zbroja") || lowerCase.contains("zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("zabojczego krolika") || lowerCase.contains("zbroja zab\u00f3jczego kr\u00f3lika") || lowerCase.contains("walentynkowy") || lowerCase.contains("valentine") || lowerCase.contains("przeciwzaka\u017ceniowy") || lowerCase.contains("przeciwzakazeniowy") || lowerCase.contains("anti-infection") || lowerCase.contains("ma\u0142ego urwisa") || lowerCase.contains("malyurwis") || lowerCase.contains("ma\u0142y urwis");
        }
        return false;
    }
    
    public void I() {
        final Iterator iterator = Bukkit.getOnlinePlayers().iterator();
        while (iterator.hasNext()) {
            this.DataDataModel1((Player)iterator.next());
        }
    }
    
    public void DataDataModel4() {
        for (final Player player : Bukkit.getOnlinePlayers()) {
            if (L.DataDataModel4(player)) {
                this.DataDataModel1(player);
                L.DataDataModel2(player);
            }
        }
    }
    
    public void D(final Player player) {
        final UUID uniqueId = player.getUniqueId();
        if (this.DataDataModel2 != null) {
            this.DataDataModel2.A(uniqueId);
        }
        J.storeArmorSnapshot(uniqueId, new I(this.A(player.getInventory().getHelmet(), "helmet", player.getName()), this.A(player.getInventory().getChestplate(), "chestplate", player.getName()), this.A(player.getInventory().getLeggings(), "leggings", player.getName()), this.A(player.getInventory().getBoots(), "boots", player.getName())));
    }
    
    public void D() {
    }
    
    public void J() {
    }
    
    public int DataDataModel3() {
        return 0;
    }
    
    public boolean DataDataModel2(final Player player) {
        return false;
    }
    
    @Deprecated
    public FileConfiguration A() {
        return null;
    }
    
    public void H() {
    }
    
    public void DataDataModel1() {
    }
}
