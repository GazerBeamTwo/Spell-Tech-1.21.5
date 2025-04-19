package net.gazerbeam2.spelltech.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.gazerbeam2.spelltech.SpellTech;
import net.gazerbeam2.spelltech.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup MANA_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SpellTech.MOD_ID, "mana_crystal"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MANA_SHARD))
                    .displayName(Text.translatable("itemgroup.spelltech.mana_crystal.blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MANA_SHARD);

                    }).build());

    public static void registerItemGroups() {
        SpellTech.LOGGER.info("Registering Item Groups for " + SpellTech.MOD_ID);
    }
}
