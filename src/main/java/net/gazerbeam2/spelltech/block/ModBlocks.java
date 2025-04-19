package net.gazerbeam2.spelltech.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gazerbeam2.spelltech.SpellTech;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block MANA_CRYSTAL = registerBlock("mana_crystal",
            new Block (AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SpellTech.MOD_ID, "mana_crystal")))
                    .mapColor(MapColor.PURPLE)
                    .solid()
                    .nonOpaque()
                    .sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                    .strength(1.5F)
                    .luminance(state -> 5)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SpellTech.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(SpellTech.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SpellTech.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        SpellTech.LOGGER.info("Registering Mod Blocks for " + SpellTech.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.MANA_CRYSTAL);
        });
    }
}