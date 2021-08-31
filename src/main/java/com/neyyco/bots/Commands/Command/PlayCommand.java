package com.neyyco.bots.Commands.Command;

import com.neyyco.bots.Commands.Types.ServerCommand;
import com.neyyco.bots.Main;

import com.neyyco.bots.Music.MusicController;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.youtube.YoutubeSearchMusicResultLoader;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.managers.AudioManager;

import java.net.URI;
import java.net.URISyntaxException;

public class PlayCommand implements ServerCommand {


    @Override
    public void performCommand(String[] arguments, Guild guild, Member member, TextChannel textChannel, Message message) {
        if(arguments.length == 2){
            GuildVoiceState voiceState;
            if ((voiceState = member.getVoiceState()) != null) {
                VoiceChannel voiceChannel;
                if ((voiceChannel = voiceState.getChannel())!= null) {
                    MusicController musicController = Main.getAudioManager().getMusicController(voiceChannel.getGuild().getIdLong());
                    AudioPlayer player = musicController.getAudioPlayer();
                    AudioPlayerManager audioPlayerManager = Main.getAudioPlayerManager();
                    AudioManager audioManager = voiceState.getGuild().getAudioManager();

                    audioManager.openAudioConnection(voiceChannel);
                    StringBuilder builder = new StringBuilder();
                    for (int i = 1; i < arguments.length; i++) builder.append(arguments[i] + " ");

                    String rawLink = builder.toString().trim();
                    if(!rawLink.startsWith("http")) {
                        rawLink = "ytsearch: " + rawLink;
                    }

                    final String url = rawLink;

                    audioPlayerManager.loadItem(url, new AudioLoadResultHandler() {
                        @Override
                        public void trackLoaded(AudioTrack audioTrack) {
                            musicController.getAudioPlayer().playTrack(audioTrack);

                        }

                        @Override
                        public void playlistLoaded(AudioPlaylist audioPlaylist) {
                            audioPlaylist.getTracks();
                        }

                        @Override
                        public void noMatches() {

                        }

                        @Override
                        public void loadFailed(FriendlyException e) {

                        }
                    });

                }else{
                    textChannel.sendMessage("Sulod sag voice channel!").queue();
                }
            }else {
                textChannel.sendMessage("Sulod sag voice channel!").queue();
            }
        }

    }

}
