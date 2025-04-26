package net.gazerbeam2.spelltech.component;


import com.mojang.serialization.Codec;
import net.gazerbeam2.spelltech.SpellTech;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModComponents {

    public static final ComponentType<Integer> LEVEL = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of("spelltech", "level"),
            ComponentType.<Integer>builder().codec(Codec.INT).build()
    );

    public static void initialize() {
        SpellTech.LOGGER.info("Registering components " + SpellTech.MOD_ID);
        // Technically this method can stay empty, but some developers like to notify
        // the console, that certain parts of the mod have been successfully initialized
    }
}
