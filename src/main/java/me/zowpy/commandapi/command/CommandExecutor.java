package me.zowpy.commandapi.command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * This Project is property of Zowpy © 2021
 *
 * @author Zowpy
 * Created: 8/8/2021
 * Project: CommandAPI
 */

public interface CommandExecutor {

    void execute(Member member, Message message, TextChannel channel, String[] args);

}
