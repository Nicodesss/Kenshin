package com.neyyco.bots.Commands.Command;

import com.neyyco.bots.Commands.Types.ServerCommand;
import com.neyyco.bots.Data.LiteSQL;
import com.neyyco.bots.Main;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

public class RestartCommand implements ServerCommand{
    private final JDA jda = Main.getJda();



    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        if (member.hasPermission(Permission.ADMINISTRATOR)) {

            textChannel.sendMessage("Balik rako...").queue();
            jda.getPresence().setStatus(OnlineStatus.OFFLINE);
            jda.shutdown();
            Main.main(null);
            LiteSQL.disconnect();

        }else {
            textChannel.sendMessage("wakay katungod mo restart nako!").queue();
        }
    }
}
