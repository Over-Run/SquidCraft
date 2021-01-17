package io.github.overrun.squidcraft.cmd;

import io.github.overrun.squidcraft.config.Configs;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.TranslatableText;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;
import static com.mojang.brigadier.arguments.StringArgumentType.getString;
import static com.mojang.brigadier.arguments.StringArgumentType.greedyString;
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
            dispatcher.register(literal("squidcraft").then(literal("config").then(
                    literal("add").then(CommandManager.argument("k_and_v",
                            greedyString()).executes(context -> {
                        String arg = getString(context, "k_and_v");
                        String[] args = arg.split("=", 2);
                        if (args.length >= 2) {
                            Configs.CONFIG.put(args[0], args[1]);
                            Configs.store();
                            context.getSource().sendFeedback(
                                    new TranslatableText(
                                            "commands.squidcraft.config.add",
                                            arg),
                                    false);
                            context.getSource().sendFeedback(
                                    new TranslatableText(
                                            "commands.squidcraft.config.add.restart"
                                    ),
                                    false
                            );
                        } else {
                            return 0;
                        }
                        return SINGLE_SUCCESS;
                    }))
            )));
        });
    }
}
