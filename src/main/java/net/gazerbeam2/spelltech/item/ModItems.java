package net.gazerbeam2.spelltech.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gazerbeam2.spelltech.SpellTech;
import net.gazerbeam2.spelltech.block.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import java.util.function.Function;

public class ModItems {
    public static final Item MANA_SHARD = registerItem("mana_shard", Item::new, new Item.Settings());
    public static final Item MANA_CRYSTAL = registerItem("mana_crystal", settings -> new BlockItem(ModBlocks.MANA_CRYSTAL, settings), new Item.Settings().useItemPrefixedTranslationKey());

    public static Item registerItem(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SpellTech.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        SpellTech.LOGGER.info("Registering Mod Items for " + SpellTech.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(MANA_SHARD);
        });
    }
}
