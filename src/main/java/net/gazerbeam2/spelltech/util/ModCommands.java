package net.gazerbeam2.spelltech.util;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.gazerbeam2.spelltech.SpellTech;
import net.gazerbeam2.spelltech.component.ModComponents;
import net.gazerbeam2.spelltech.component.SpellLevelComponent;
import net.minecraft.command.ControlFlowAware;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;

public class ModCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                literal("getlevel")
                        .then(CommandManager.argument("player", EntityArgumentType.player())
                                .executes(ctx -> {
                                    PlayerEntity player = EntityArgumentType.getPlayer(ctx, "player");

                                    // Get the level component for the player
                                    SpellLevelComponent levelComponent = ModComponents.LEVEL.get(player);

                                    SpellTech.LOGGER.info("Getting level for player: {}", player.getName().getString());

                                    if (levelComponent == null) {
                                        SpellTech.LOGGER.error("Failed to get level component for player: {}", player.getName().getString());
                                    } else {
                                        int level = levelComponent.getLevel();
                                        // Send feedback to the command executor
                                        ctx.getSource().sendFeedback(() -> Text.literal(player.getName().getString() + "'s level is " + level), false);
                                    }

                                    return ControlFlowAware.Command.SINGLE_SUCCESS;
                                })
                        )
        );

        dispatcher.register(
            literal("setlevel")
                .then(CommandManager.argument("player", EntityArgumentType.player())
                    .then(CommandManager.argument("level", integer(1, 100))  // Set level range to 1-100
                        .executes(ctx -> {
                                PlayerEntity player = EntityArgumentType.getPlayer(ctx, "player");
                                int level = getInteger(ctx, "level");

                                // Get or create the component for the player
                                SpellLevelComponent levelComponent = ModComponents.LEVEL.get(player);

                                SpellTech.LOGGER.info("Setting level for player: {}", player.getName().getString());
                                SpellTech.LOGGER.info("Level: {}", level);

                            if (levelComponent == null) {
                                SpellTech.LOGGER.error("Failed to get level component for player: {}", player.getName().getString());
                            } else {
                                // Set the level
                                levelComponent.setLevel(level);
                                SpellLevelComponent.sync(player);  // Sync level change to client

                                // Send feedback to the command executor
                                ctx.getSource().sendFeedback(() -> Text.literal("Set " + player.getName().getString() + "'s level to " + level), false);
                            }
                                return ControlFlowAware.Command.SINGLE_SUCCESS;
                        })
                    )
                )
        );
    }

    private static LiteralArgumentBuilder<ServerCommandSource> literal(String name) {
        return CommandManager.literal(name);
    }

    private static RequiredArgumentBuilder<ServerCommandSource, Integer> argument(String name, ArgumentType<Integer> type) {
        return CommandManager.argument(name, type);
    }
}
