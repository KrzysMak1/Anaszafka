// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.persistence;

import org.bukkit.configuration.ConfigurationSection;
import java.io.File;

public class E
{
    public static B A(final String s, final File file, final ConfigurationSection configurationSection) {
        final String upperCase = s.toUpperCase();
        switch (upperCase) {
            case "H2": {
                return new C(file, configurationSection);
            }
            case "YAML": {
                return new D(file);
            }
            default: {
                return new C(file, configurationSection);
            }
        }
    }
}
