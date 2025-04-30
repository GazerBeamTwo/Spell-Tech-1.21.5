package net.gazerbeam2.spelltech.spelltree;

import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellRegistry {
    private static final Map<String, SpellNode> SPELLS = new HashMap<>();

    public static final Map<String, List<String>> SPELL_PREREQUISITES = new HashMap<>();


    public static void register(SpellNode spell) {
        SPELLS.put(spell.getId(), spell);
    }

    public static SpellNode get(String id) {
        return SPELLS.get(id);
    }

    public static Collection<SpellNode> getAll() {
        return SPELLS.values();
    }

    private static final int[] spellLevReq = {0, 5, 15, 25, 35, 45};
    private static final int[] spellTier = {0, 1, 2, 3, 4, 5};


    static {
        SPELL_PREREQUISITES.put("air_basic_0", List.of("air_starter_0"));
        SPELL_PREREQUISITES.put("air_basic_1", List.of("air_starter_0"));
        SPELL_PREREQUISITES.put("air_basic_2", List.of("air_starter_0"));

        SPELL_PREREQUISITES.put("air_intermediate_0", List.of("air_basic_0"));
        SPELL_PREREQUISITES.put("air_intermediate_1", List.of("air_basic_0", "air_basic_1"));
        SPELL_PREREQUISITES.put("air_intermediate_2", List.of("air_basic_1", "air_basic_2"));
        SPELL_PREREQUISITES.put("air_intermediate_3", List.of("air_basic_2"));

        SPELL_PREREQUISITES.put("air_advanced_0", List.of("air_intermediate_0"));
        SPELL_PREREQUISITES.put("air_advanced_1", List.of("air_intermediate_0", "air_intermediate_1"));
        SPELL_PREREQUISITES.put("air_advanced_2", List.of("air_intermediate_1", "air_intermediate_2"));
        SPELL_PREREQUISITES.put("air_advanced_3", List.of("air_intermediate_2", "air_intermediate_3"));
        SPELL_PREREQUISITES.put("air_advanced_4", List.of("air_intermediate_3"));

        SPELL_PREREQUISITES.put("air_master_0", List.of("air_advanced_0", "air_advanced_1"));
        SPELL_PREREQUISITES.put("air_master_1", List.of("air_advanced_1", "air_advanced_2"));
        SPELL_PREREQUISITES.put("air_master_2", List.of("air_advanced_2", "air_advanced_3"));
        SPELL_PREREQUISITES.put("air_master_3", List.of("air_advanced_3", "air_advanced_4"));

        SPELL_PREREQUISITES.put("air_ultimate_0", List.of("air_master_0", "air_master_1", "air_master_2", "air_master_3"));



        SPELL_PREREQUISITES.put("earth_basic_0", List.of("earth_starter_0"));
        SPELL_PREREQUISITES.put("earth_basic_1", List.of("earth_starter_0"));
        SPELL_PREREQUISITES.put("earth_basic_2", List.of("earth_starter_0"));

        SPELL_PREREQUISITES.put("earth_intermediate_0", List.of("earth_basic_0"));
        SPELL_PREREQUISITES.put("earth_intermediate_1", List.of("earth_basic_0", "earth_basic_1"));
        SPELL_PREREQUISITES.put("earth_intermediate_2", List.of("earth_basic_1", "earth_basic_2"));
        SPELL_PREREQUISITES.put("earth_intermediate_3", List.of("earth_basic_2"));

        SPELL_PREREQUISITES.put("earth_advanced_0", List.of("earth_intermediate_0"));
        SPELL_PREREQUISITES.put("earth_advanced_1", List.of("earth_intermediate_0", "earth_intermediate_1"));
        SPELL_PREREQUISITES.put("earth_advanced_2", List.of("earth_intermediate_1", "earth_intermediate_2"));
        SPELL_PREREQUISITES.put("earth_advanced_3", List.of("earth_intermediate_2", "earth_intermediate_3"));
        SPELL_PREREQUISITES.put("earth_advanced_4", List.of("earth_intermediate_3"));

        SPELL_PREREQUISITES.put("earth_master_0", List.of("earth_advanced_0", "earth_advanced_1"));
        SPELL_PREREQUISITES.put("earth_master_1", List.of("earth_advanced_1", "earth_advanced_2"));
        SPELL_PREREQUISITES.put("earth_master_2", List.of("earth_advanced_2", "earth_advanced_3"));
        SPELL_PREREQUISITES.put("earth_master_3", List.of("earth_advanced_3", "earth_advanced_4"));

        SPELL_PREREQUISITES.put("earth_ultimate_0", List.of("earth_master_0", "earth_master_1", "earth_master_2", "earth_master_3"));



        SPELL_PREREQUISITES.put("fire_basic_0", List.of("fire_starter_0"));
        SPELL_PREREQUISITES.put("fire_basic_1", List.of("fire_starter_0"));
        SPELL_PREREQUISITES.put("fire_basic_2", List.of("fire_starter_0"));

        SPELL_PREREQUISITES.put("fire_intermediate_0", List.of("fire_basic_0"));
        SPELL_PREREQUISITES.put("fire_intermediate_1", List.of("fire_basic_0", "fire_basic_1"));
        SPELL_PREREQUISITES.put("fire_intermediate_2", List.of("fire_basic_1", "fire_basic_2"));
        SPELL_PREREQUISITES.put("fire_intermediate_3", List.of("fire_basic_2"));

        SPELL_PREREQUISITES.put("fire_advanced_0", List.of("fire_intermediate_0"));
        SPELL_PREREQUISITES.put("fire_advanced_1", List.of("fire_intermediate_0", "fire_intermediate_1"));
        SPELL_PREREQUISITES.put("fire_advanced_2", List.of("fire_intermediate_1", "fire_intermediate_2"));
        SPELL_PREREQUISITES.put("fire_advanced_3", List.of("fire_intermediate_2", "fire_intermediate_3"));
        SPELL_PREREQUISITES.put("fire_advanced_4", List.of("fire_intermediate_3"));

        SPELL_PREREQUISITES.put("fire_master_0", List.of("fire_advanced_0", "fire_advanced_1"));
        SPELL_PREREQUISITES.put("fire_master_1", List.of("fire_advanced_1", "fire_advanced_2"));
        SPELL_PREREQUISITES.put("fire_master_2", List.of("fire_advanced_2", "fire_advanced_3"));
        SPELL_PREREQUISITES.put("fire_master_3", List.of("fire_advanced_3", "fire_advanced_4"));

        SPELL_PREREQUISITES.put("fire_ultimate_0", List.of("fire_master_0", "fire_master_1", "fire_master_2", "fire_master_3"));



        SPELL_PREREQUISITES.put("water_basic_0", List.of("water_starter_0"));
        SPELL_PREREQUISITES.put("water_basic_1", List.of("water_starter_0"));
        SPELL_PREREQUISITES.put("water_basic_2", List.of("water_starter_0"));

        SPELL_PREREQUISITES.put("water_intermediate_0", List.of("water_basic_0"));
        SPELL_PREREQUISITES.put("water_intermediate_1", List.of("water_basic_0", "water_basic_1"));
        SPELL_PREREQUISITES.put("water_intermediate_2", List.of("water_basic_1", "water_basic_2"));
        SPELL_PREREQUISITES.put("water_intermediate_3", List.of("water_basic_2"));

        SPELL_PREREQUISITES.put("water_advanced_0", List.of("water_intermediate_0"));
        SPELL_PREREQUISITES.put("water_advanced_1", List.of("water_intermediate_0", "water_intermediate_1"));
        SPELL_PREREQUISITES.put("water_advanced_2", List.of("water_intermediate_1", "water_intermediate_2"));
        SPELL_PREREQUISITES.put("water_advanced_3", List.of("water_intermediate_2", "water_intermediate_3"));
        SPELL_PREREQUISITES.put("water_advanced_4", List.of("water_intermediate_3"));

        SPELL_PREREQUISITES.put("water_master_0", List.of("water_advanced_0", "water_advanced_1"));
        SPELL_PREREQUISITES.put("water_master_1", List.of("water_advanced_1", "water_advanced_2"));
        SPELL_PREREQUISITES.put("water_master_2", List.of("water_advanced_2", "water_advanced_3"));
        SPELL_PREREQUISITES.put("water_master_3", List.of("water_advanced_3", "water_advanced_4"));

        SPELL_PREREQUISITES.put("water_ultimate_0", List.of("water_master_0", "water_master_1", "water_master_2", "water_master_3"));



        SPELL_PREREQUISITES.put("light_basic_0", List.of("light_starter_0"));
        SPELL_PREREQUISITES.put("light_basic_1", List.of("light_starter_0"));
        SPELL_PREREQUISITES.put("light_basic_2", List.of("light_starter_0"));

        SPELL_PREREQUISITES.put("light_intermediate_0", List.of("light_basic_0"));
        SPELL_PREREQUISITES.put("light_intermediate_1", List.of("light_basic_0", "light_basic_1"));
        SPELL_PREREQUISITES.put("light_intermediate_2", List.of("light_basic_1", "light_basic_2"));
        SPELL_PREREQUISITES.put("light_intermediate_3", List.of("light_basic_2"));

        SPELL_PREREQUISITES.put("light_advanced_0", List.of("light_intermediate_0"));
        SPELL_PREREQUISITES.put("light_advanced_1", List.of("light_intermediate_0", "light_intermediate_1"));
        SPELL_PREREQUISITES.put("light_advanced_2", List.of("light_intermediate_1", "light_intermediate_2"));
        SPELL_PREREQUISITES.put("light_advanced_3", List.of("light_intermediate_2", "light_intermediate_3"));
        SPELL_PREREQUISITES.put("light_advanced_4", List.of("light_intermediate_3"));

        SPELL_PREREQUISITES.put("light_master_0", List.of("light_advanced_0", "light_advanced_1"));
        SPELL_PREREQUISITES.put("light_master_1", List.of("light_advanced_1", "light_advanced_2"));
        SPELL_PREREQUISITES.put("light_master_2", List.of("light_advanced_2", "light_advanced_3"));
        SPELL_PREREQUISITES.put("light_master_3", List.of("light_advanced_3", "light_advanced_4"));

        SPELL_PREREQUISITES.put("light_ultimate_0", List.of("light_master_0", "light_master_1", "light_master_2", "light_master_3"));



        SPELL_PREREQUISITES.put("dark_basic_0", List.of("dark_starter_0"));
        SPELL_PREREQUISITES.put("dark_basic_1", List.of("dark_starter_0"));
        SPELL_PREREQUISITES.put("dark_basic_2", List.of("dark_starter_0"));

        SPELL_PREREQUISITES.put("dark_intermediate_0", List.of("dark_basic_0"));
        SPELL_PREREQUISITES.put("dark_intermediate_1", List.of("dark_basic_0", "dark_basic_1"));
        SPELL_PREREQUISITES.put("dark_intermediate_2", List.of("dark_basic_1", "dark_basic_2"));
        SPELL_PREREQUISITES.put("dark_intermediate_3", List.of("dark_basic_2"));

        SPELL_PREREQUISITES.put("dark_advanced_0", List.of("dark_intermediate_0"));
        SPELL_PREREQUISITES.put("dark_advanced_1", List.of("dark_intermediate_0", "dark_intermediate_1"));
        SPELL_PREREQUISITES.put("dark_advanced_2", List.of("dark_intermediate_1", "dark_intermediate_2"));
        SPELL_PREREQUISITES.put("dark_advanced_3", List.of("dark_intermediate_2", "dark_intermediate_3"));
        SPELL_PREREQUISITES.put("dark_advanced_4", List.of("dark_intermediate_3"));

        SPELL_PREREQUISITES.put("dark_master_0", List.of("dark_advanced_0", "dark_advanced_1"));
        SPELL_PREREQUISITES.put("dark_master_1", List.of("dark_advanced_1", "dark_advanced_2"));
        SPELL_PREREQUISITES.put("dark_master_2", List.of("dark_advanced_2", "dark_advanced_3"));
        SPELL_PREREQUISITES.put("dark_master_3", List.of("dark_advanced_3", "dark_advanced_4"));

        SPELL_PREREQUISITES.put("dark_ultimate_0", List.of("dark_master_0", "dark_master_1", "dark_master_2", "dark_master_3"));



        SPELL_PREREQUISITES.put("void_basic_0", List.of("void_starter_0"));
        SPELL_PREREQUISITES.put("void_basic_1", List.of("void_starter_0"));
        SPELL_PREREQUISITES.put("void_basic_2", List.of("void_starter_0"));

        SPELL_PREREQUISITES.put("void_intermediate_0", List.of("void_basic_0"));
        SPELL_PREREQUISITES.put("void_intermediate_1", List.of("void_basic_0", "void_basic_1"));
        SPELL_PREREQUISITES.put("void_intermediate_2", List.of("void_basic_1", "void_basic_2"));
        SPELL_PREREQUISITES.put("void_intermediate_3", List.of("void_basic_2"));

        SPELL_PREREQUISITES.put("void_advanced_0", List.of("void_intermediate_0"));
        SPELL_PREREQUISITES.put("void_advanced_1", List.of("void_intermediate_0", "void_intermediate_1"));
        SPELL_PREREQUISITES.put("void_advanced_2", List.of("void_intermediate_1", "void_intermediate_2"));
        SPELL_PREREQUISITES.put("void_advanced_3", List.of("void_intermediate_2", "void_intermediate_3"));
        SPELL_PREREQUISITES.put("void_advanced_4", List.of("void_intermediate_3"));

        SPELL_PREREQUISITES.put("void_master_0", List.of("void_advanced_0", "void_advanced_1"));
        SPELL_PREREQUISITES.put("void_master_1", List.of("void_advanced_1", "void_advanced_2"));
        SPELL_PREREQUISITES.put("void_master_2", List.of("void_advanced_2", "void_advanced_3"));
        SPELL_PREREQUISITES.put("void_master_3", List.of("void_advanced_3", "void_advanced_4"));

        SPELL_PREREQUISITES.put("void_ultimate_0", List.of("void_master_0", "void_master_1", "void_master_2", "void_master_3"));



        SPELL_PREREQUISITES.put("nature_basic_0", List.of("nature_starter_0"));
        SPELL_PREREQUISITES.put("nature_basic_1", List.of("nature_starter_0"));
        SPELL_PREREQUISITES.put("nature_basic_2", List.of("nature_starter_0"));

        SPELL_PREREQUISITES.put("nature_intermediate_0", List.of("nature_basic_0"));
        SPELL_PREREQUISITES.put("nature_intermediate_1", List.of("nature_basic_0", "nature_basic_1"));
        SPELL_PREREQUISITES.put("nature_intermediate_2", List.of("nature_basic_1", "nature_basic_2"));
        SPELL_PREREQUISITES.put("nature_intermediate_3", List.of("nature_basic_2"));

        SPELL_PREREQUISITES.put("nature_advanced_0", List.of("nature_intermediate_0"));
        SPELL_PREREQUISITES.put("nature_advanced_1", List.of("nature_intermediate_0", "nature_intermediate_1"));
        SPELL_PREREQUISITES.put("nature_advanced_2", List.of("nature_intermediate_1", "nature_intermediate_2"));
        SPELL_PREREQUISITES.put("nature_advanced_3", List.of("nature_intermediate_2", "nature_intermediate_3"));
        SPELL_PREREQUISITES.put("nature_advanced_4", List.of("nature_intermediate_3"));

        SPELL_PREREQUISITES.put("nature_master_0", List.of("nature_advanced_0", "nature_advanced_1"));
        SPELL_PREREQUISITES.put("nature_master_1", List.of("nature_advanced_1", "nature_advanced_2"));
        SPELL_PREREQUISITES.put("nature_master_2", List.of("nature_advanced_2", "nature_advanced_3"));
        SPELL_PREREQUISITES.put("nature_master_3", List.of("nature_advanced_3", "nature_advanced_4"));

        SPELL_PREREQUISITES.put("nature_ultimate_0", List.of("nature_master_0", "nature_master_1", "nature_master_2", "nature_master_3"));



        SPELL_PREREQUISITES.put("universal_basic_0", List.of("universal_starter_0"));
        SPELL_PREREQUISITES.put("universal_basic_1", List.of("universal_starter_0"));
        SPELL_PREREQUISITES.put("universal_basic_2", List.of("universal_starter_0"));

        SPELL_PREREQUISITES.put("universal_intermediate_0", List.of("universal_basic_0"));
        SPELL_PREREQUISITES.put("universal_intermediate_1", List.of("universal_basic_0", "universal_basic_1"));
        SPELL_PREREQUISITES.put("universal_intermediate_2", List.of("universal_basic_1", "universal_basic_2"));
        SPELL_PREREQUISITES.put("universal_intermediate_3", List.of("universal_basic_2"));

        SPELL_PREREQUISITES.put("universal_advanced_0", List.of("universal_intermediate_0"));
        SPELL_PREREQUISITES.put("universal_advanced_1", List.of("universal_intermediate_0", "universal_intermediate_1"));
        SPELL_PREREQUISITES.put("universal_advanced_2", List.of("universal_intermediate_1", "universal_intermediate_2"));
        SPELL_PREREQUISITES.put("universal_advanced_3", List.of("universal_intermediate_2", "universal_intermediate_3"));
        SPELL_PREREQUISITES.put("universal_advanced_4", List.of("universal_intermediate_3"));

        SPELL_PREREQUISITES.put("universal_master_0", List.of("universal_advanced_0", "universal_advanced_1"));
        SPELL_PREREQUISITES.put("universal_master_1", List.of("universal_advanced_1", "universal_advanced_2"));
        SPELL_PREREQUISITES.put("universal_master_2", List.of("universal_advanced_2", "universal_advanced_3"));
        SPELL_PREREQUISITES.put("universal_master_3", List.of("universal_advanced_3", "universal_advanced_4"));

        SPELL_PREREQUISITES.put("universal_ultimate_0", List.of("universal_master_0", "universal_master_1", "universal_master_2", "universal_master_3"));
    }

    public static List<String> getPrerequisites(String spellId) {
        return SPELL_PREREQUISITES.getOrDefault(spellId, List.of());
    }

    public static void registerAllSpells() {
        registerAirSpells();
        registerEarthSpells();
        registerFireSpells();
        registerWaterSpells();
        registerLightSpells();
        registerDarkSpells();
        registerVoidSpells();
        registerNatureSpells();
        registerUniversalSpells();
    }

    public static void registerAirSpells() {

        register(new SpellNode("air_starter_0", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[0], List.of(),
                (server, player) -> true, spellLevReq[0]));


        register(new SpellNode("air_basic_0", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[1], List.of("air_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("air_basic_1", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[1], List.of("air_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("air_basic_2", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[1], List.of("air_starter_0"),
                (server, player) -> true, spellLevReq[1]));


        register(new SpellNode("air_intermediate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[2], List.of("air_basic_0"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("air_intermediate_1", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[2], List.of("air_basic_0", "air_basic_1"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("air_intermediate_2", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[2], List.of("air_basic_1", "air_basic_2"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("air_intermediate_3", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[2], List.of("air_basic_2"),
                (server, player) -> true, spellLevReq[2]));


        register(new SpellNode("air_advanced_0", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[3], List.of("air_intermediate_0"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("air_advanced_1", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[3], List.of("air_intermediate_0", "air_intermediate_1"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("air_advanced_2", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[3], List.of("air_intermediate_1", "air_intermediate_2"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("air_advanced_3", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[3], List.of("air_intermediate_2", "air_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("air_advanced_4", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[3], List.of("air_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));


        register(new SpellNode("air_master_0", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[4], List.of("air_advanced_0", "air_advanced_1"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("air_master_1", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[4], List.of("air_advanced_1", "air_advanced_2"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("air_master_2", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[4], List.of("air_advanced_2", "air_advanced_3"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("air_master_3", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[4], List.of("air_advanced_3", "air_advanced_4"),
                (server, player) -> true, spellLevReq[4]));


        register(new SpellNode("air_ultimate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/air/.png"),
                spellTier[5], List.of("air_master_0", "air_master_1", "air_master_2", "air_master_3"),
                (server, player) -> true, spellLevReq[5]));
    }

    public static void registerEarthSpells() {

        register(new SpellNode("earth_starter_0", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[0], List.of(),
                (server, player) -> true, spellLevReq[0]));


        register(new SpellNode("earth_basic_0", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[1], List.of("earth_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("earth_basic_1", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[1], List.of("earth_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("earth_basic_2", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[1], List.of("earth_starter_0"),
                (server, player) -> true, spellLevReq[1]));


        register(new SpellNode("earth_intermediate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[2], List.of("earth_basic_0"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("earth_intermediate_1", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[2], List.of("earth_basic_0", "earth_basic_1"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("earth_intermediate_2", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[2], List.of("earth_basic_1", "earth_basic_2"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("earth_intermediate_3", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[2], List.of("earth_basic_2"),
                (server, player) -> true, spellLevReq[2]));


        register(new SpellNode("earth_advanced_0", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[3], List.of("earth_intermediate_0"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("earth_advanced_1", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[3], List.of("earth_intermediate_0", "earth_intermediate_1"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("earth_advanced_2", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[3], List.of("earth_intermediate_1", "earth_intermediate_2"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("earth_advanced_3", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[3], List.of("earth_intermediate_2", "earth_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("earth_advanced_4", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[3], List.of("earth_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));


        register(new SpellNode("earth_master_0", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[4], List.of("earth_advanced_0", "earth_advanced_1"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("earth_master_1", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[4], List.of("earth_advanced_1", "earth_advanced_2"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("earth_master_2", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[4], List.of("earth_advanced_2", "earth_advanced_3"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("earth_master_3", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[4], List.of("earth_advanced_3", "earth_advanced_4"),
                (server, player) -> true, spellLevReq[4]));


        register(new SpellNode("earth_ultimate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/earth/.png"),
                spellTier[5], List.of("earth_master_0", "earth_master_1", "earth_master_2", "earth_master_3"),
                (server, player) -> true, spellLevReq[5]));
    }


    public static void registerFireSpells() {

        register(new SpellNode("fire_starter_0", "Ember",
                Identifier.of("spelltech", "textures/gui/spells/fire/ember.png"),
                spellTier[0], List.of(),
                (server, player) -> true, spellLevReq[0]));


        register(new SpellNode("fire_basic_0", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[1], List.of("fire_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("fire_basic_1", "Flame Burst",
                Identifier.of("spelltech", "textures/gui/spells/fire/flame_burst.png"),
                spellTier[1], List.of("fire_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("fire_basic_2", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[1], List.of("fire_starter_0"),
                (server, player) -> true, spellLevReq[1]));


        register(new SpellNode("fire_intermediate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[2], List.of("fire_basic_0"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("fire_intermediate_1", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[2], List.of("fire_basic_0", "fire_basic_1"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("fire_intermediate_2", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[2], List.of("fire_basic_1", "fire_basic_2"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("fire_intermediate_3", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[2], List.of("fire_basic_2"),
                (server, player) -> true, spellLevReq[2]));


        register(new SpellNode("fire_advanced_0", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[3], List.of("fire_intermediate_0"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("fire_advanced_1", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[3], List.of("fire_intermediate_0", "fire_intermediate_1"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("fire_advanced_2", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[3], List.of("fire_intermediate_1", "fire_intermediate_2"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("fire_advanced_3", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[3], List.of("fire_intermediate_2", "fire_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("fire_advanced_4", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[3], List.of("fire_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));


        register(new SpellNode("fire_master_0", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[4], List.of("fire_advanced_0", "fire_advanced_1"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("fire_master_1", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[4], List.of("fire_advanced_1", "fire_advanced_2"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("fire_master_2", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[4], List.of("fire_advanced_2", "fire_advanced_3"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("fire_master_3", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[4], List.of("fire_advanced_3", "fire_advanced_4"),
                (server, player) -> true, spellLevReq[4]));


        register(new SpellNode("fire_ultimate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/fire/.png"),
                spellTier[5], List.of("fire_master_0", "fire_master_1", "fire_master_2", "fire_master_3"),
                (server, player) -> true, spellLevReq[5]));
    }

    public static void registerWaterSpells() {

        register(new SpellNode("water_starter_0", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[0], List.of(),
                (server, player) -> true, spellLevReq[0]));


        register(new SpellNode("water_basic_0", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[1], List.of("water_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("water_basic_1", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[1], List.of("water_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("water_basic_2", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[1], List.of("water_starter_0"),
                (server, player) -> true, spellLevReq[1]));


        register(new SpellNode("water_intermediate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[2], List.of("water_basic_0"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("water_intermediate_1", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[2], List.of("water_basic_0", "water_basic_1"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("water_intermediate_2", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[2], List.of("water_basic_1", "water_basic_2"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("water_intermediate_3", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[2], List.of("water_basic_2"),
                (server, player) -> true, spellLevReq[2]));


        register(new SpellNode("water_advanced_0", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[3], List.of("water_intermediate_0"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("water_advanced_1", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[3], List.of("water_intermediate_0", "water_intermediate_1"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("water_advanced_2", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[3], List.of("water_intermediate_1", "water_intermediate_2"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("water_advanced_3", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[3], List.of("water_intermediate_2", "water_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("water_advanced_4", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[3], List.of("water_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));


        register(new SpellNode("water_master_0", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[4], List.of("water_advanced_0", "water_advanced_1"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("water_master_1", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[4], List.of("water_advanced_1", "water_advanced_2"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("water_master_2", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[4], List.of("water_advanced_2", "water_advanced_3"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("water_master_3", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[4], List.of("water_advanced_3", "water_advanced_4"),
                (server, player) -> true, spellLevReq[4]));


        register(new SpellNode("water_ultimate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/water/.png"),
                spellTier[5], List.of("water_master_0", "water_master_1", "water_master_2", "water_master_3"),
                (server, player) -> true, spellLevReq[5]));
    }

    public static void registerLightSpells() {

        register(new SpellNode("light_starter_0", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[0], List.of(),
                (server, player) -> true, spellLevReq[0]));


        register(new SpellNode("light_basic_0", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[1], List.of("light_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("light_basic_1", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[1], List.of("light_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("light_basic_2", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[1], List.of("light_starter_0"),
                (server, player) -> true, spellLevReq[1]));


        register(new SpellNode("light_intermediate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[2], List.of("light_basic_0"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("light_intermediate_1", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[2], List.of("light_basic_0", "light_basic_1"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("light_intermediate_2", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[2], List.of("light_basic_1", "light_basic_2"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("light_intermediate_3", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[2], List.of("light_basic_2"),
                (server, player) -> true, spellLevReq[2]));


        register(new SpellNode("light_advanced_0", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[3], List.of("light_intermediate_0"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("light_advanced_1", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[3], List.of("light_intermediate_0", "light_intermediate_1"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("light_advanced_2", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[3], List.of("light_intermediate_1", "light_intermediate_2"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("light_advanced_3", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[3], List.of("light_intermediate_2", "light_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("light_advanced_4", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[3], List.of("light_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));


        register(new SpellNode("light_master_0", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[4], List.of("light_advanced_0", "light_advanced_1"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("light_master_1", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[4], List.of("light_advanced_1", "light_advanced_2"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("light_master_2", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[4], List.of("light_advanced_2", "light_advanced_3"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("light_master_3", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[4], List.of("light_advanced_3", "light_advanced_4"),
                (server, player) -> true, spellLevReq[4]));


        register(new SpellNode("light_ultimate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/light/.png"),
                spellTier[5], List.of("light_master_0", "light_master_1", "light_master_2", "light_master_3"),
                (server, player) -> true, spellLevReq[5]));
    }

    public static void registerDarkSpells() {

        register(new SpellNode("dark_starter_0", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[0], List.of(),
                (server, player) -> true, spellLevReq[0]));


        register(new SpellNode("dark_basic_0", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[1], List.of("dark_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("dark_basic_1", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[1], List.of("dark_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("dark_basic_2", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[1], List.of("dark_starter_0"),
                (server, player) -> true, spellLevReq[1]));


        register(new SpellNode("dark_intermediate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[2], List.of("dark_basic_0"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("dark_intermediate_1", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[2], List.of("dark_basic_0", "dark_basic_1"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("dark_intermediate_2", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[2], List.of("dark_basic_1", "dark_basic_2"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("dark_intermediate_3", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[2], List.of("dark_basic_2"),
                (server, player) -> true, spellLevReq[2]));


        register(new SpellNode("dark_advanced_0", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[3], List.of("dark_intermediate_0"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("dark_advanced_1", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[3], List.of("dark_intermediate_0", "dark_intermediate_1"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("dark_advanced_2", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[3], List.of("dark_intermediate_1", "dark_intermediate_2"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("dark_advanced_3", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[3], List.of("dark_intermediate_2", "dark_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("dark_advanced_4", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[3], List.of("dark_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));


        register(new SpellNode("dark_master_0", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[4], List.of("dark_advanced_0", "dark_advanced_1"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("dark_master_1", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[4], List.of("dark_advanced_1", "dark_advanced_2"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("dark_master_2", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[4], List.of("dark_advanced_2", "dark_advanced_3"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("dark_master_3", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[4], List.of("dark_advanced_3", "dark_advanced_4"),
                (server, player) -> true, spellLevReq[4]));


        register(new SpellNode("dark_ultimate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/dark/.png"),
                spellTier[5], List.of("dark_master_0", "dark_master_1", "dark_master_2", "dark_master_3"),
                (server, player) -> true, spellLevReq[5]));
    }

    public static void registerVoidSpells() {

        register(new SpellNode("void_starter_0", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[0], List.of(),
                (server, player) -> true, spellLevReq[0]));


        register(new SpellNode("void_basic_0", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[1], List.of("void_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("void_basic_1", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[1], List.of("void_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("void_basic_2", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[1], List.of("void_starter_0"),
                (server, player) -> true, spellLevReq[1]));


        register(new SpellNode("void_intermediate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[2], List.of("void_basic_0"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("void_intermediate_1", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[2], List.of("void_basic_0", "void_basic_1"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("void_intermediate_2", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[2], List.of("void_basic_1", "void_basic_2"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("void_intermediate_3", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[2], List.of("void_basic_2"),
                (server, player) -> true, spellLevReq[2]));


        register(new SpellNode("void_advanced_0", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[3], List.of("void_intermediate_0"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("void_advanced_1", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[3], List.of("void_intermediate_0", "void_intermediate_1"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("void_advanced_2", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[3], List.of("void_intermediate_1", "void_intermediate_2"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("void_advanced_3", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[3], List.of("void_intermediate_2", "void_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("void_advanced_4", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[3], List.of("void_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));


        register(new SpellNode("void_master_0", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[4], List.of("void_advanced_0", "void_advanced_1"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("void_master_1", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[4], List.of("void_advanced_1", "void_advanced_2"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("void_master_2", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[4], List.of("void_advanced_2", "void_advanced_3"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("void_master_3", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[4], List.of("void_advanced_3", "void_advanced_4"),
                (server, player) -> true, spellLevReq[4]));


        register(new SpellNode("void_ultimate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/void/.png"),
                spellTier[5], List.of("void_master_0", "void_master_1", "void_master_2", "void_master_3"),
                (server, player) -> true, spellLevReq[5]));
    }

    public static void registerNatureSpells() {

        register(new SpellNode("nature_starter_0", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[0], List.of(),
                (server, player) -> true, spellLevReq[0]));


        register(new SpellNode("nature_basic_0", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[1], List.of("nature_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("nature_basic_1", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[1], List.of("nature_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("nature_basic_2", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[1], List.of("nature_starter_0"),
                (server, player) -> true, spellLevReq[1]));


        register(new SpellNode("nature_intermediate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[2], List.of("nature_basic_0"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("nature_intermediate_1", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[2], List.of("nature_basic_0", "nature_basic_1"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("nature_intermediate_2", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[2], List.of("nature_basic_1", "nature_basic_2"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("nature_intermediate_3", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[2], List.of("nature_basic_2"),
                (server, player) -> true, spellLevReq[2]));


        register(new SpellNode("nature_advanced_0", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[3], List.of("nature_intermediate_0"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("nature_advanced_1", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[3], List.of("nature_intermediate_0", "nature_intermediate_1"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("nature_advanced_2", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[3], List.of("nature_intermediate_1", "nature_intermediate_2"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("nature_advanced_3", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[3], List.of("nature_intermediate_2", "nature_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("nature_advanced_4", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[3], List.of("nature_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));


        register(new SpellNode("nature_master_0", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[4], List.of("nature_advanced_0", "nature_advanced_1"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("nature_master_1", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[4], List.of("nature_advanced_1", "nature_advanced_2"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("nature_master_2", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[4], List.of("nature_advanced_2", "nature_advanced_3"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("nature_master_3", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[4], List.of("nature_advanced_3", "nature_advanced_4"),
                (server, player) -> true, spellLevReq[4]));


        register(new SpellNode("nature_ultimate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/nature/.png"),
                spellTier[5], List.of("nature_master_0", "nature_master_1", "nature_master_2", "nature_master_3"),
                (server, player) -> true, spellLevReq[5]));
    }

    public static void registerUniversalSpells() {

        register(new SpellNode("universal_starter_0", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[0], List.of(),
                (server, player) -> true, spellLevReq[0]));


        register(new SpellNode("universal_basic_0", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[1], List.of("universal_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("universal_basic_1", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[1], List.of("universal_starter_0"),
                (server, player) -> true, spellLevReq[1]));

        register(new SpellNode("universal_basic_2", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[1], List.of("universal_starter_0"),
                (server, player) -> true, spellLevReq[1]));


        register(new SpellNode("universal_intermediate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[2], List.of("universal_basic_0"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("universal_intermediate_1", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[2], List.of("universal_basic_0", "universal_basic_1"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("universal_intermediate_2", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[2], List.of("universal_basic_1", "universal_basic_2"),
                (server, player) -> true, spellLevReq[2]));

        register(new SpellNode("universal_intermediate_3", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[2], List.of("universal_basic_2"),
                (server, player) -> true, spellLevReq[2]));


        register(new SpellNode("universal_advanced_0", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[3], List.of("universal_intermediate_0"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("universal_advanced_1", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[3], List.of("universal_intermediate_0", "universal_intermediate_1"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("universal_advanced_2", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[3], List.of("universal_intermediate_1", "universal_intermediate_2"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("universal_advanced_3", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[3], List.of("universal_intermediate_2", "universal_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));

        register(new SpellNode("universal_advanced_4", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[3], List.of("universal_intermediate_3"),
                (server, player) -> true, spellLevReq[3]));


        register(new SpellNode("universal_master_0", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[4], List.of("universal_advanced_0", "universal_advanced_1"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("universal_master_1", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[4], List.of("universal_advanced_1", "universal_advanced_2"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("universal_master_2", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[4], List.of("universal_advanced_2", "universal_advanced_3"),
                (server, player) -> true, spellLevReq[4]));

        register(new SpellNode("universal_master_3", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[4], List.of("universal_advanced_3", "universal_advanced_4"),
                (server, player) -> true, spellLevReq[4]));


        register(new SpellNode("universal_ultimate_0", "",
                Identifier.of("spelltech", "textures/gui/spells/universal/.png"),
                spellTier[5], List.of("universal_master_0", "universal_master_1", "universal_master_2", "universal_master_3"),
                (server, player) -> true, spellLevReq[5]));
    }
}