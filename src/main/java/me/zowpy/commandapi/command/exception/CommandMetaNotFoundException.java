package me.zowpy.commandapi.command.exception;

/**
 * This Project is property of Zowpy © 2021
 *
 * @author Zowpy
 * Created: 8/8/2021
 * Project: CommandAPI
 */

public class CommandMetaNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "CommandMeta annotation is missing!";
    }
}
