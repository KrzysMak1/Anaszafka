// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.STORMSZAFKA.pets;

import org.bukkit.entity.Player;

public interface PetsPetService3
{
    void spawn(final Player p0, final String p1);
    
    void update();
    
    void remove();
    
    String getDisplayName();
    
    void hideFromOwner();
    
    void showToOwner();
    
    default boolean shouldFloatUpDown() {
        return true;
    }
    
    default boolean shouldRotateWithPlayer() {
        return true;
    }
    
    default boolean shouldHideWhenPlayerInvisible() {
        return true;
    }
    
    default String getPosition() {
        return "RIGHT";
    }
    
    default boolean hasParticleEffects() {
        return false;
    }
    
    default String getParticleType() {
        return "CLOUD";
    }
    
    default boolean hasSoundEffects() {
        return false;
    }
    
    default String getSoundType() {
        return "ENTITY_BAT_AMBIENT";
    }
    
    default int getSoundInterval() {
        return 30;
    }
}
