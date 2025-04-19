package net.gazerbeam2.spelltech;

import net.fabricmc.api.ModInitializer;
import net.gazerbeam2.spelltech.block.ModBlocks;
import net.gazerbeam2.spelltech.item.ModItemGroups;
import net.gazerbeam2.spelltech.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpellTech implements ModInitializer {
	public static final String MOD_ID = "spelltech";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}