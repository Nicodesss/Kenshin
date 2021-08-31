package com.neyyco.bots.Commands;

import com.neyyco.bots.Commands.Command.ClearCommand;
import com.neyyco.bots.Commands.Command.HelpCommand;
import com.neyyco.bots.Commands.Command.PlayCommand;
import com.neyyco.bots.Commands.Command.RestartCommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class CommandManager extends ListenerAdapter {

    private final HelpCommand helpCommand;
    private RestartCommand restartCommand;
    private final PlayCommand playCommand;
    private final ClearCommand clearCommand;


    public CommandManager() {
        this.helpCommand = new HelpCommand();
        this.restartCommand =new RestartCommand();
        this.playCommand = new PlayCommand();
        this.clearCommand = new ClearCommand();
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event){
        if(!event.getMember().getUser().isBot()){
            String[] arguments = event.getMessage().getContentRaw().split(" ");

            Guild guild = event.getGuild();
            TextChannel textChannel = event.getChannel();
            Message message = event.getMessage();
            Member member = event.getMember();

            switch (arguments[0]){
                case "!Tabang":

                    this.helpCommand.performCommand(arguments, guild, member, textChannel, message);
                    break;
                case "!Towgsa" :
                case "!Staph":
                    this.restartCommand.performCommand(arguments, guild, member, textChannel, message);
                    break;
                case "!kanta" :
                    this.playCommand.performCommand(arguments, guild, member, textChannel, message);
                    break;
                case "!hawan" :
                    this.clearCommand.performCommand(arguments, guild, member, textChannel, message);
                    break;
            }

        }

    }

}
