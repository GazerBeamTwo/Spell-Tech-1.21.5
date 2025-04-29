package net.gazerbeam2.spelltech;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.gazerbeam2.spelltech.block.ModBlocks;
import net.gazerbeam2.spelltech.item.ModItemGroups;
import net.gazerbeam2.spelltech.item.ModItems;
import net.gazerbeam2.spelltech.component.ModComponents;
import net.gazerbeam2.spelltech.spelltree.SpellAutoUnlockHandler;
import net.gazerbeam2.spelltech.spelltree.SpellNode;
import net.gazerbeam2.spelltech.spelltree.SpellRegistry;
import net.gazerbeam2.spelltech.util.ModCommands;
import net.gazerbeam2.spelltech.util.ModLootTableModifiers;
import net.gazerbeam2.spelltech.world.feature.ManaCrystalOreFeature;
import net.gazerbeam2.spelltech.world.gen.ModWorldGeneration;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpellTech implements ModInitializer {
	public static final String MOD_ID = "spelltech";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ManaCrystalOreFeature MANA_CRYSTAL_ORE_FEATURE =
			Registry.register(Registries.FEATURE,
					Identifier.of("spelltech", "mana_crystal_ore_feature"),
					new ManaCrystalOreFeature(OreFeatureConfig.CODEC));

	@Override
	public void onInitialize() {
		SpellTech.LOGGER.info("Initializing SpellTech...");
		ModComponents.register();

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			ModCommands.register(dispatcher);
		});

		SpellRegistry.registerAllSpells();
		SpellAutoUnlockHandler.register();
		// SpellRegistry.register(new SpellNode());

		ModLootTableModifiers.modifyLootTables();
		ModWorldGeneration.generateModWorldGen();

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}

	public static Identifier identifier(String path) {
		return Identifier.of(SpellTech.MOD_ID, path);
	}
}