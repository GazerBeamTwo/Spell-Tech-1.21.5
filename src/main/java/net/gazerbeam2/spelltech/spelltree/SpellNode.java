package net.gazerbeam2.spelltech.spelltree;

import net.gazerbeam2.spelltech.component.PlayerSpellDataComponent;
import net.gazerbeam2.spelltech.component.SpellLevelComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.List;

public class SpellNode {
    private final String id;                      // Unique spell ID (e.g., "fire_basic_0")
    private final String name;                    // Display name (e.g., "Ember Bolt")
    private final Identifier icon;                // Path to the icon texture
    private final String description;
    private final int tier;                       // Tier in the spell tree (e.g., 0 for base, 3 for advanced)
    private final boolean isActive;
    private final List<String> prerequisites;     // Other spell IDs that must be unlocked
    private final UnlockCondition unlockCondition; // A custom condition (more on this below)
    public final int requiredLevelComponentRank; // The required rank in the level component

    public SpellNode(String id, String name, Identifier icon, String description, int tier, boolean isActive, List<String> prerequisites, UnlockCondition unlockCondition, int requiredLevelComponentRank) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.description = description;
        this.tier = tier;
        this.isActive = isActive;
        this.prerequisites = prerequisites;
        this.unlockCondition = unlockCondition;
        this.requiredLevelComponentRank = requiredLevelComponentRank;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public Identifier getIcon() { return icon; }
    public int getTier() { return tier; }
    public String getDescription() { return description; }
    public boolean getActive() { return isActive; };
    public List<String> getPrerequisites() { return prerequisites; }
    public UnlockCondition getUnlockCondition() { return unlockCondition; }
    public int requiredLevelComponentRank() { return requiredLevelComponentRank; }

    public boolean canUnlock(MinecraftServer server, ServerPlayerEntity player, PlayerSpellDataComponent spellData, SpellLevelComponent levelComponent) {
        // 1. Check if all prerequisite spells are unlocked
        for (String prereqId : prerequisites) {
            if (!spellData.hasUnlocked(prereqId)) {
                return false;
            }
        }

        // 2. Check level requirement
        if (levelComponent.getLevel() < requiredLevelComponentRank) {
            return false;
        }

        // 3. Final custom condition — only evaluated *after* other requirements pass
        return unlockCondition == null || unlockCondition.canUnlock(server, player);
    }

}