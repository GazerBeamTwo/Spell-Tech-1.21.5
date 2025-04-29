package net.gazerbeam2.spelltech.util;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Optional;

public class SpellLevelUtil {

    public enum SpellRank {
        NOVICE("Novice", Formatting.GRAY, 0),
        APPRENTICE("Apprentice", Formatting.GREEN, 5),
        ADEPT("Adept", Formatting.AQUA, 15),
        EXPERT("Expert", Formatting.BLUE, 25),
        MASTER("Master", Formatting.LIGHT_PURPLE, 35),
        ARCHMAGE("Archmage", Formatting.GOLD, 45),
        ASCENDED("Ascended", Formatting.DARK_PURPLE, 55);

        public final String name;
        public final Formatting color;
        public final int minLevel;

        SpellRank(String name, Formatting color, int minLevel) {
            this.name = name;
            this.color = color;
            this.minLevel = minLevel;
        }

        public Text asText() {
            return Text.literal(name).formatted(color);
        }

        public static SpellRank fromLevel(int level) {
            SpellRank current = NOVICE;
            for (SpellRank rank : values()) {
                if (level >= rank.minLevel) {
                    current = rank;
                } else {
                    break;
                }
            }
            return current;
        }

        public static Optional<SpellRank> fromName(String input) {
            String normalized = input.trim().toLowerCase();
            for (SpellRank rank : values()) {
                if (rank.name.toLowerCase().equals(normalized)) {
                    return Optional.of(rank);
                }
            }
            return Optional.empty();
        }
    }
}
