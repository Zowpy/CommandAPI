package me.zowpy.commandapi.command;

import lombok.AllArgsConstructor;
import me.zowpy.commandapi.CommandAPI;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.utils.PermissionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This Project is property of Zowpy © 2021
 * Redistribution of this Project is not allowed
 *
 * @author Zowpy
 * Created: 8/8/2021
 * Project: CommandAPI
 */

@AllArgsConstructor
public class CommandHandler extends ListenerAdapter {

    private CommandAPI commandAPI;

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        Member member = event.getMember();
        String message = event.getMessage().getContentRaw();
        String[] args = message.split("\\s+");

        if (message.startsWith(commandAPI.getPrefix())) {
            Command command = commandAPI.getCommands().keySet().stream().filter(command1 -> command1.getName().equalsIgnoreCase(args[0].replace(commandAPI.getPrefix(), ""))).findFirst().orElse(null);

            if (command == null) {
                event.getChannel().sendMessage("Couldn't find that command!").queue();
                return;
            }

            CommandExecutor executor = commandAPI.getCommands().get(command);

            if (command.isNeedPermission() && PermissionUtil.checkPermission(member, command.getPermission())) {
                List<String> toReturn = new ArrayList<>();
                if (args.length > 1) {
                    for (int i = 1; i < args.length; i++) {
                        toReturn.add(args[i]);
                    }
                }

                executor.execute(member, event.getMessage(), event.getChannel(), args.length == 1 ? new String[]{} : toReturn.toArray(new String[]{}));

            }else if (!command.isNeedPermission()) {
                List<String> toReturn = new ArrayList<>();
                if (args.length > 1) {
                    for (int i = 1; i < args.length; i++) {
                        toReturn.add(args[i]);
                    }
                }

                executor.execute(member, event.getMessage(), event.getChannel(), args.length == 1 ? new String[]{} : toReturn.toArray(new String[]{}));
            }




        }
    }
}
