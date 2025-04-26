package net.gazerbeam2.spelltech.util;

import net.gazerbeam2.spelltech.component.ModComponents;
import net.minecraft.entity.player.PlayerEntity;

public class LevelUtil {
    public static int getLevel(PlayerEntity player) {
        return player.getOrDefault(ModComponents.LEVEL, 0);
    }

    public static void setLevel(PlayerEntity player, int level) {
        System.out.println("setting " + player + " Level to " + level);
        player.setComponent(ModComponents.LEVEL, level);
        System.out.println("you are now level" + player.get(ModComponents.LEVEL));
    }

    public static void addLevel(PlayerEntity player, int delta) {
        setLevel(player, 1);
    }
}
