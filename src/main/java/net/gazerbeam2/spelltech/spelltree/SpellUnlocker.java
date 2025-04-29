package net.gazerbeam2.spelltech.spelltree;

import net.gazerbeam2.spelltech.component.ModComponents;
import net.gazerbeam2.spelltech.component.SpellLevelComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

import java.util.Set;

public class SpellUnlocker {

    public static void tryUnlockSpell(SpellNode spell, ServerPlayerEntity player, MinecraftServer server, Set<String> unlockedSpells) {
        // Step 1: Check prerequisites
        if (!unlockedSpells.containsAll(spell.getPrerequisites())) return;

        // Step 2: Check level component rank
        SpellLevelComponent levelComponent = ModComponents.LEVEL.get(player);
        if (levelComponent.getLevel() < spell.requiredLevelComponentRank()) return;

        // Step 3: Check final custom unlock condition
        if (!spell.getUnlockCondition().canUnlock(server, player)) return;

        // Step 4: Unlock the spell
        unlockedSpells.add(spell.getId());
        player.sendMessage(Text.literal("You have unlocked the spell: " + spell.getName()), false);

        // TODO: Persist unlocked spells and sync with client if needed
    }
}
