package com.neyyco.bots.Commands.Types;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public interface ServerCommand {

    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message);
}
