package com.neyyco.bots.Commands.Command;

import com.neyyco.bots.Commands.Types.ServerCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class HelpCommand implements ServerCommand {


    @Override
    public void performCommand(String[] arguements, Guild guild, Member member, TextChannel textChannel, Message message) {
        EmbedBuilder embedBuilder = new EmbedBuilder();

        embedBuilder.setColor(0xf242f5);
        embedBuilder.setTitle("**Mga sugo**");
        embedBuilder.setDescription("**!kanta** - play music \n **!Towgsa** - restart kenshin \n **!Staph** - pagsugod usab ni kenshin \n **!hawan** - e delete ang mag mensahe");

        textChannel.sendMessage(embedBuilder.build()).queue();

    }
}
