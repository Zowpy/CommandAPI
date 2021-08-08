package me.zowpy.commandapi.example;

import me.zowpy.commandapi.command.CommandExecutor;
import me.zowpy.commandapi.command.CommandMeta;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Arrays;

/**
 * This Project is property of Zowpy © 2021
 * Redistribution of this Project is not allowed
 *
 * @author Zowpy
 * Created: 8/8/2021
 * Project: CommandAPI
 */
@CommandMeta(name = "hello")
public class HelloCommand implements CommandExecutor {


    @Override
    public void execute(Member member, Message message, TextChannel channel, String[] args) {
        channel.sendMessage("hello!").queue();
    }
}
