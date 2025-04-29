package net.gazerbeam2.spelltech.spelltree;

import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellRegistry {
    private static final Map<String, SpellNode> SPELLS = new HashMap<>();

    public static void register(SpellNode spell) {
        SPELLS.put(spell.getId(), spell);
    }

    public static SpellNode get(String id) {
        return SPELLS.get(id);
    }

    public static Collection<SpellNode> getAll() {
        return SPELLS.values();
    }

    public static void registerAllSpells() {
        register(new SpellNode(
                "fire_starter_1",
                "Ember",
                Identifier.of("spelltech", "textures/gui/spells/ember.png"),
                0,
                List.of(),
                (server, player) -> true,
                0
        ));

        register(new SpellNode(
                "fire_basic_1",
                "Flame Burst",
                Identifier.of("spelltech", "textures/gui/spells/flame_burst.png"),
                1,
                List.of("fire_starter_1"),
                (server, player) -> player.experienceLevel >= 10, // Custom condition
                5 // Required SpellLevelComponent rank
        ));
    }
}