// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.data;

import org.bukkit.configuration.file.FileConfiguration;
import java.util.UUID;
import pl.ziffy.STORMSZAFKA.costumes.J;
import pl.ziffy.STORMSZAFKA.costumes.I;
import java.util.Iterator;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import java.time.chrono.ChronoLocalDateTime;
import java.time.LocalDateTime;
import pl.ziffy.STORMSZAFKA.utils.time.A;
import java.time.format.DateTimeFormatter;
import pl.ziffy.STORMSZAFKA.costumes.L;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import pl.ziffy.STORMSZAFKA.Main;
import java.io.File;
import org.bukkit.plugin.Plugin;

public class E
{
    private final Plugin A;
    private final File B;
    private G C;
    
    public E(final Plugin a) {
        this.A = a;
        this.B = ((Main)a).getCustomDataFolder();
        if (!this.B.exists()) {
            this.B.mkdirs();
        }
        this.G();
        Bukkit.getScheduler().runTaskLater(a, () -> {
            if (this.E() > 0) {}
        }, 40L);
    }
    
    private void G() {
        final C databaseManager = ((Main)this.A).getDatabaseManager();
        if (databaseManager != null && databaseManager.E()) {
            this.C = new G(databaseManager);
        }
    }
    
    public void B(final Player player) {
        final boolean f = L.F(player);
        String lowerCase = null;
        String a = null;
        String format = null;
        if (f) {
            final pl.ziffy.STORMSZAFKA.costumes.C a2 = L.A(player);
            if (a2 != null) {
                lowerCase = a2.getType().toLowerCase();
                final L._A g = L.G(player);
                if (g != null) {
                    a = g.A;
                    if (g.C != null) {
                        format = g.C.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    }
                }
            }
        }
        if (this.C != null) {
            if (f && lowerCase != null) {
                this.C.A(player.getUniqueId(), lowerCase, a, format);
            }
            else {
                this.C.A(player.getUniqueId());
            }
        }
    }
    
    public void A(final Player player) {
        if (this.C != null && this.C.C(player.getUniqueId()) && this.C.B(player.getUniqueId()) != null) {
            Bukkit.getScheduler().runTaskLater(this.A, () -> {
                final pl.ziffy.STORMSZAFKA.costumes.persistence.A a2;
                final Object a = a2.A;
                final Object c = a2.C;
                final Object b = a2.B;
                if (player2.isOnline()) {
                    if (s != null && !s.equals("brak")) {
                        pl.ziffy.STORMSZAFKA.utils.time.A.A(s);
                        final LocalDateTime other;
                        if (other != null && LocalDateTime.now().isAfter(other)) {
                            this.C.A(player2.getUniqueId());
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
            this.B((Player)iterator.next());
        }
    }
    
    public void F() {
        for (final Player player : Bukkit.getOnlinePlayers()) {
            if (L.F(player)) {
                this.B(player);
                L.C(player);
            }
        }
    }
    
    public void D(final Player player) {
        final UUID uniqueId = player.getUniqueId();
        if (this.C != null) {
            this.C.A(uniqueId);
        }
        J.storeArmorSnapshot(uniqueId, new I(this.A(player.getInventory().getHelmet(), "helmet", player.getName()), this.A(player.getInventory().getChestplate(), "chestplate", player.getName()), this.A(player.getInventory().getLeggings(), "leggings", player.getName()), this.A(player.getInventory().getBoots(), "boots", player.getName())));
    }
    
    public void D() {
    }
    
    public void J() {
    }
    
    public int E() {
        return 0;
    }
    
    public boolean C(final Player player) {
        return false;
    }
    
    @Deprecated
    public FileConfiguration A() {
        return null;
    }
    
    public void H() {
    }
    
    public void B() {
    }
}
