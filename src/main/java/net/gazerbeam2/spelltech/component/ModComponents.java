package net.gazerbeam2.spelltech.component;

import net.gazerbeam2.spelltech.SpellTech;
import net.minecraft.entity.player.PlayerEntity;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

public class ModComponents implements EntityComponentInitializer {

    public static final ComponentKey<SpellLevelComponent> LEVEL = ComponentRegistry.getOrCreate(
            SpellTech.identifier("level"), SpellLevelComponent.class
    );

    public static final ComponentKey<PlayerSpellDataComponent> SPELL_DATA = ComponentRegistry.getOrCreate(
            SpellTech.identifier("spell_data"), PlayerSpellDataComponent.class
    );

    public static void register() {
        SpellTech.LOGGER.info("Registering Mod Components for " + SpellTech.MOD_ID);
        SpellTech.LOGGER.info("Component LEVEL key: {}", LEVEL);
    }

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.beginRegistration(PlayerEntity.class, LEVEL)
                .respawnStrategy(RespawnCopyStrategy.CHARACTER)
                .end(PlayerLevelComponent::new);
        registry.beginRegistration(PlayerEntity.class, SPELL_DATA)
                .respawnStrategy(RespawnCopyStrategy.CHARACTER)
                .end(PlayerSpellDataComponentImpl::new);
    }
}