package net.gazerbeam2.spelltech.util;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
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

import java.util.Optional;

import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static com.mojang.brigadier.arguments.IntegerArgumentType.integer;

public class ModCommands {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                literal("getlevel")
                        .executes(ctx -> {
                            // No player argument: get the command source's own player
                            PlayerEntity player = ctx.getSource().getPlayer();
                            SpellLevelComponent levelComponent = ModComponents.LEVEL.get(player);

                            int level = levelComponent.getLevel();
                            SpellLevelUtil.SpellRank rank = SpellLevelUtil.SpellRank.fromLevel(level);

                            ctx.getSource().sendFeedback(() -> Text.literal("Your level is " + level + " (" + rank.name + ")").formatted(rank.color), false);

                            return ControlFlowAware.Command.SINGLE_SUCCESS;
                        })
                        .then(CommandManager.argument("player", EntityArgumentType.player())
                                .executes(ctx -> {
                                    // Player argument provided: get their level
                                    PlayerEntity player = EntityArgumentType.getPlayer(ctx, "player");
                                    SpellLevelComponent levelComponent = ModComponents.LEVEL.get(player);

                                    int level = levelComponent.getLevel();
                                    SpellLevelUtil.SpellRank rank = SpellLevelUtil.SpellRank.fromLevel(level);

                                    ctx.getSource().sendFeedback(() -> Text.literal(player.getName().getString() + "'s level is " + level + " (" + rank.name + ")").formatted(rank.color), false);

                                    return ControlFlowAware.Command.SINGLE_SUCCESS;
                                })
                        )
        );

        dispatcher.register(
                literal("setlevel")
                        .then(CommandManager.argument("rank", StringArgumentType.word())
                                .suggests((context, builder) -> {
                                    for (SpellLevelUtil.SpellRank rank : SpellLevelUtil.SpellRank.values()) {
                                        builder.suggest(rank.name.toLowerCase());
                                    }
                                    return builder.buildFuture();
                                })
                                .executes(ctx -> {
                                    // No player argument: set the command source's own rank
                                    PlayerEntity player = ctx.getSource().getPlayer();
                                    String input = StringArgumentType.getString(ctx, "rank");

                                    Optional<SpellLevelUtil.SpellRank> optionalRank = SpellLevelUtil.SpellRank.fromName(input);
                                    if (optionalRank.isEmpty()) {
                                        ctx.getSource().sendError(Text.literal("Unknown rank: " + input));
                                        return 0;
                                    }

                                    int level = optionalRank.get().minLevel;
                                    SpellLevelComponent levelComponent = ModComponents.LEVEL.get(player);

                                    SpellTech.LOGGER.info("Setting own rank for player: {}", player.getName().getString());
                                    SpellTech.LOGGER.info("Rank: {} (Level: {})", optionalRank.get().name, level);

                                    if (levelComponent == null) {
                                        SpellTech.LOGGER.error("Failed to get level component for player: {}", player.getName().getString());
                                    } else {
                                        levelComponent.setLevel(level);
                                        SpellLevelComponent.sync(player);

                                        ctx.getSource().sendFeedback(() -> Text.literal("Set your rank to " + optionalRank.get().name)
                                                .formatted(optionalRank.get().color), false);
                                    }

                                    return ControlFlowAware.Command.SINGLE_SUCCESS;
                                })
                        )
                        .then(CommandManager.argument("player", EntityArgumentType.player())
                                .then(CommandManager.argument("rank", StringArgumentType.word())
                                        .suggests((context, builder) -> {
                                            for (SpellLevelUtil.SpellRank rank : SpellLevelUtil.SpellRank.values()) {
                                                builder.suggest(rank.name.toLowerCase());
                                            }
                                            return builder.buildFuture();
                                        })
                                        .executes(ctx -> {
                                            PlayerEntity player = EntityArgumentType.getPlayer(ctx, "player");
                                            String input = StringArgumentType.getString(ctx, "rank");

                                            Optional<SpellLevelUtil.SpellRank> optionalRank = SpellLevelUtil.SpellRank.fromName(input);
                                            if (optionalRank.isEmpty()) {
                                                ctx.getSource().sendError(Text.literal("Unknown rank: " + input));
                                                return 0;
                                            }

                                            int level = optionalRank.get().minLevel;
                                            SpellLevelComponent levelComponent = ModComponents.LEVEL.get(player);

                                            SpellTech.LOGGER.info("Setting rank for player: {}", player.getName().getString());
                                            SpellTech.LOGGER.info("Rank: {} (Level: {})", optionalRank.get().name, level);

                                            if (levelComponent == null) {
                                                SpellTech.LOGGER.error("Failed to get level component for player: {}", player.getName().getString());
                                            } else {
                                                levelComponent.setLevel(level);
                                                SpellLevelComponent.sync(player);

                                                ctx.getSource().sendFeedback(() -> Text.literal("Set " + player.getName().getString() +
                                                        "'s rank to " + optionalRank.get().name).formatted(optionalRank.get().color), false);
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
