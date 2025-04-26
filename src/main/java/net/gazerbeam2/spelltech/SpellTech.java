package net.gazerbeam2.spelltech;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.gazerbeam2.spelltech.block.ModBlocks;
import net.gazerbeam2.spelltech.item.ModItemGroups;
import net.gazerbeam2.spelltech.item.ModItems;
import net.gazerbeam2.spelltech.component.ModComponents;
import net.gazerbeam2.spelltech.util.LevelUtil;
import net.gazerbeam2.spelltech.util.ModLootTableModifiers;
import net.gazerbeam2.spelltech.world.feature.ManaCrystalOreFeature;
import net.gazerbeam2.spelltech.world.gen.ModWorldGeneration;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
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
		ModComponents.initialize();

		// Initialize player level when they join
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			PlayerEntity player = handler.getPlayer();
			int levelCheck = player.getOrDefault(ModComponents.LEVEL, 0);
			// Check if the player has a level already
			if (levelCheck <= 0) {
				player.set(ModComponents.LEVEL, 0);
			}
		});

		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(
					CommandManager.literal("levelup")
							.requires(source -> source.hasPermissionLevel(2))
							.executes(context -> {
								ServerPlayerEntity player = context.getSource().getPlayer();
								LevelUtil.addLevel(player, 1);
                                assert player != null;
                                int newLevel = LevelUtil.getLevel(player);
								System.out.println("you are now level" + newLevel);
								return 1;
							})
			);
		});

		ModLootTableModifiers.modifyLootTables();
//		StripWorldEnchantments.register();
		ModWorldGeneration.generateModWorldGen();

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}