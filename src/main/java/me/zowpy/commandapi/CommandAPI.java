package me.zowpy.commandapi;

import lombok.Getter;
import lombok.SneakyThrows;
import me.zowpy.commandapi.command.Command;
import me.zowpy.commandapi.command.CommandExecutor;
import me.zowpy.commandapi.command.CommandHandler;
import me.zowpy.commandapi.command.CommandMeta;
import me.zowpy.commandapi.command.exception.CommandMetaNotFoundException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;

import java.util.HashMap;

/**
 * This Project is property of Zowpy © 2021
 *
 * @author Zowpy
 * Created: 8/8/2021
 * Project: CommandAPI
 */

@Getter
public class CommandAPI {

    private String prefix;
    private final JDA jda;
    private final HashMap<Command, CommandExecutor> commands = new HashMap<>();

    public CommandAPI(String prefix, JDA jda) {
        this.prefix = prefix;
        this.jda = jda;
        jda.addEventListener(new CommandHandler(this));
    }

    @SneakyThrows
    public void registerCommand(CommandExecutor commandExecutor) {
        Class<? extends CommandExecutor> clazz = commandExecutor.getClass();

        if (!clazz.isAnnotationPresent(CommandMeta.class)) {
            throw new CommandMetaNotFoundException();
        }

        CommandMeta commandMeta = clazz.getAnnotation(CommandMeta.class);

        if (commandMeta == null) {
            throw new CommandMetaNotFoundException();
        }

        Command command = new Command(commandMeta.name());
        command.setPermission(commandMeta.permission());
        command.setNeedPermission(command.getPermission() != Permission.UNKNOWN);

        commands.put(command, commandExecutor);
    }

}
