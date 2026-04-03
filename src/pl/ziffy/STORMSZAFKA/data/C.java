// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.data;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.io.File;
import org.bukkit.plugin.Plugin;

public class C
{
    private final Plugin D;
    private final File E;
    private Connection C;
    private boolean G;
    public static final String F = "pets";
    public static final String B = "sakiewka";
    public static final String A = "costumes";
    
    public C(final Plugin d, final File e) {
        this.G = false;
        this.D = d;
        this.E = e;
    }
    
    public boolean C() {
        try {
            if (!this.E.exists()) {
                this.E.mkdirs();
            }
            final String url = "jdbc:sqlite:" + new File(this.E, "stormszafka.db").getAbsolutePath();
            Class.forName("org.sqlite.JDBC");
            this.C = DriverManager.getConnection(url);
            try (final Statement statement = this.C.createStatement()) {
                statement.execute("PRAGMA foreign_keys = ON");
            }
            this.B();
            return this.G = true;
        }
        catch (final ClassNotFoundException ex) {
            return false;
        }
        catch (final SQLException ex2) {
            return false;
        }
    }
    
    private void B() throws SQLException {
        final String s = """
                         CREATE TABLE IF NOT EXISTS pets (
                             uuid TEXT PRIMARY KEY,
                             pet_type TEXT NOT NULL,
                             expiration TEXT,
                             is_hidden INTEGER DEFAULT 0,
                             original_duration TEXT,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                         )
                         """;
        final String s2 = """
                          CREATE TABLE IF NOT EXISTS sakiewka (
                              uuid TEXT PRIMARY KEY,
                              drop_multiplier REAL DEFAULT 1.0,
                              bonus_active INTEGER DEFAULT 0,
                              bonus_expiration TEXT,
                              total_drops INTEGER DEFAULT 0,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                          )
                          """;
        final String s3 = """
                          CREATE TABLE IF NOT EXISTS costumes (
                              uuid TEXT PRIMARY KEY,
                              costume_type TEXT NOT NULL,
                              original_duration TEXT,
                              expiration_time TEXT,
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                          )
                          """;
        try (final Statement statement = this.C.createStatement()) {
            statement.execute(s);
            statement.execute(s2);
            statement.execute(s3);
            statement.execute("CREATE INDEX IF NOT EXISTS idx_pets_pet_type ON pets(pet_type)");
            statement.execute("CREATE INDEX IF NOT EXISTS idx_sakiewka_bonus_active ON sakiewka(bonus_active)");
            statement.execute("CREATE INDEX IF NOT EXISTS idx_costumes_costume_type ON costumes(costume_type)");
        }
    }
    
    public Connection D() {
        try {
            if (this.C == null || this.C.isClosed()) {
                this.C();
            }
        }
        catch (final SQLException ex) {}
        return this.C;
    }
    
    public boolean E() {
        return this.G;
    }
    
    public void A() {
        if (this.C != null) {
            try {
                this.C.close();
            }
            catch (final SQLException ex) {}
        }
        this.G = false;
    }
    
    public int B(final String s, final Object... array) {
        try (final PreparedStatement prepareStatement = this.D().prepareStatement(s)) {
            this.A(prepareStatement, array);
            return prepareStatement.executeUpdate();
        }
        catch (final SQLException ex) {
            return -1;
        }
    }
    
    public ResultSet A(final String s, final Object... array) {
        try {
            final PreparedStatement prepareStatement = this.D().prepareStatement(s);
            this.A(prepareStatement, array);
            return prepareStatement.executeQuery();
        }
        catch (final SQLException ex) {
            return null;
        }
    }
    
    private void A(final PreparedStatement preparedStatement, final Object... array) throws SQLException {
        for (int i = 0; i < array.length; ++i) {
            final Object o = array[i];
            if (o == null) {
                preparedStatement.setNull(i + 1, 0);
            }
            else if (o instanceof final String s) {
                preparedStatement.setString(i + 1, s);
            }
            else if (o instanceof Integer) {
                preparedStatement.setInt(i + 1, (int)o);
            }
            else if (o instanceof Long) {
                preparedStatement.setLong(i + 1, (long)o);
            }
            else if (o instanceof Double) {
                preparedStatement.setDouble(i + 1, (double)o);
            }
            else if (o instanceof Boolean) {
                preparedStatement.setInt(i + 1, ((boolean)o) ? 1 : 0);
            }
            else {
                preparedStatement.setObject(i + 1, o);
            }
        }
    }
    
    public boolean A(final String s, final String s2) {
        final String s3 = "SELECT 1 FROM " + s + " WHERE uuid = ?";
        try (final ResultSet a = this.A(s3, new Object[] { s2 })) {
            return a != null && a.next();
        }
        catch (final SQLException ex) {
            return false;
        }
    }
}
