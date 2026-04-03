// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.costumes.persistence;

import org.bukkit.configuration.ConfigurationSection;
import java.io.File;

public class CostumesPersistenceCostumeRepository5
{
    public static CostumesPersistenceCostumeRepository2 CostumesPersistenceCostumeRepository1(final String s, final File file, final ConfigurationSection configurationSection) {
        final String upperCase = s.toUpperCase();
        switch (upperCase) {
            case "H2": {
                return new CostumesPersistenceCostumeRepository3(file, configurationSection);
            }
            case "YAML": {
                return new CostumesPersistenceCostumeRepository4(file);
            }
            default: {
                return new CostumesPersistenceCostumeRepository3(file, configurationSection);
            }
        }
    }
}
