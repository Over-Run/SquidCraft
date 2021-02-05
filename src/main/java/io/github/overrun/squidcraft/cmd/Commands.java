package io.github.overrun.squidcraft.cmd;

import io.github.overrun.squidcraft.config.Configs;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.text.TranslatableText;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;
import static com.mojang.brigadier.arguments.StringArgumentType.*;
import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

/**
 * @author squid233
 * @since 2021/01/03
 */
public final class Commands {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
                    dispatcher.register(literal("squidcraft").then(literal("config").then(
                            literal("reload").executes(context -> {
                                context.getSource().sendFeedback(
                                        new TranslatableText("commands.reload.success"),
                                        false);
                                return Configs.init() ? SINGLE_SUCCESS : 0;
                            }))));
                    dispatcher.register(literal("squidcraft").then(literal("fun").then(literal("translate")
                            .then(argument("key", string()).executes(context -> {
                                context.getSource().sendFeedback(new TranslatableText(getString(context, "key")), false);
                                return SINGLE_SUCCESS;
                            }))
                    )));
                }
        );
    }
}
