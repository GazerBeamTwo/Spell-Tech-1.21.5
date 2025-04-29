package net.gazerbeam2.spelltech.spelltree;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.gazerbeam2.spelltech.component.ModComponents;
import net.gazerbeam2.spelltech.component.SpellLevelComponent;
import net.gazerbeam2.spelltech.component.PlayerSpellDataComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;

public class SpellAutoUnlockHandler {

    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(SpellAutoUnlockHandler::onWorldTick);
    }

    private static void onWorldTick(ServerWorld world) {
        MinecraftServer server = world.getServer();

        for (ServerPlayerEntity player : world.getPlayers()) {
            PlayerSpellDataComponent spellData = PlayerSpellDataComponent.get(player);
            SpellLevelComponent levelComponent = ModComponents.LEVEL.get(player);

            for (SpellNode node : SpellRegistry.getAll()) {
                if (!spellData.hasUnlocked(node.getId())
                        && node.canUnlock(server, player, spellData, levelComponent)) {

                    System.out.println("Unlocking spell: " + node.getId());
                    spellData.unlock(node.getId());
                    player.sendMessage(Text.literal("You unlocked: " + node.getName()), true);
                }
            }
        }
    }
}
