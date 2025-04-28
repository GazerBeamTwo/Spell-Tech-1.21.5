package net.gazerbeam2.spelltech.component;

import net.minecraft.entity.player.PlayerEntity;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public interface SpellLevelComponent extends AutoSyncedComponent {

    int getLevel();
    void setLevel(int level);
    void sync();

    static void sync(PlayerEntity player) {
        ModComponents.LEVEL.sync(player);
    }
}