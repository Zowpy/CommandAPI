package me.zowpy.commandapi.example;

import me.zowpy.commandapi.command.CommandExecutor;
import me.zowpy.commandapi.command.CommandMeta;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

/**
 * This Project is property of Zowpy © 2021
 * Redistribution of this Project is not allowed
 *
 * @author Zowpy
 * Created: 8/8/2021
 * Project: CommandAPI
 */
@CommandMeta(name = "say")
public class SayCommand implements CommandExecutor {

    @Override
    public void execute(Member member, Message message, TextChannel channel, String[] args) {
        message.delete().queue();
        StringBuilder stringBuilder = new StringBuilder();

        for (String str : args) {
            stringBuilder.append(str).append(" ");
        }

        channel.sendMessage(stringBuilder.toString()).queue();
    }
}
