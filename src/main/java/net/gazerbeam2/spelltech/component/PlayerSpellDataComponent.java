package net.gazerbeam2.spelltech.component;

import net.minecraft.entity.player.PlayerEntity;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

import java.util.Set;

public interface PlayerSpellDataComponent extends AutoSyncedComponent {
    boolean hasUnlocked(String spellId);
    void unlock(String spellId);
    Set<String> getUnlockedSpells();
    void sync();

    static void sync(PlayerEntity player) {
        ModComponents.SPELL_DATA.sync(player);
    }

    static PlayerSpellDataComponent get(PlayerEntity player) {
        return ModComponents.SPELL_DATA.get(player);
    }
}
