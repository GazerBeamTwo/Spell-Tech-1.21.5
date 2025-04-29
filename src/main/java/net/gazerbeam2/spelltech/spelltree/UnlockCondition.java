package net.gazerbeam2.spelltech.spelltree;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

@FunctionalInterface
public interface UnlockCondition {
    boolean canUnlock(MinecraftServer server, ServerPlayerEntity player);
}
