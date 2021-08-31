package com.neyyco.bots.Commands.Command;

import com.neyyco.bots.Commands.Types.ServerCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;

import java.util.List;

public class ClearCommand implements ServerCommand {


    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        if(arguments.length < 2){
            textChannel.sendMessage("engk gamita ang **!hawan** + amount").queue();
        }else {
            try {
                try {
                message.delete().queue();
                }catch (InsufficientPermissionException exception){
                textChannel.sendMessage("Dili nako kaya ma delete").queue();
                }

                List<Message> messageList = textChannel.getHistory().retrievePast(Integer.parseInt(arguments[1])).complete();
                textChannel.deleteMessages(messageList).queue();

                textChannel.sendMessage("Na delete " + arguments[1] + " nga message sa" + textChannel.getAsMention()).queue();
            }catch (IllegalArgumentException exception){
                if(exception.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")){
                    textChannel.sendMessage("Dili mag abusar").queue();
                }else {
                    textChannel.sendMessage("Dili na nako ma delete ang sauna").queue();
                }
            }
        }

    }
}
