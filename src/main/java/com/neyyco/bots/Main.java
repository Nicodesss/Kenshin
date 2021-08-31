package com.neyyco.bots;

import com.neyyco.bots.Commands.CommandManager;
import com.neyyco.bots.Data.LiteSQL;
import com.neyyco.bots.Music.AudioManager;
import com.neyyco.bots.config.ConfigFile;
import com.neyyco.bots.config.ConfigValues;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.Timer;


public class Main {

    private static JDA jda;
    private static JDABuilder jdaBuilder;
    private static AudioPlayerManager audioPlayerManager;
    private static AudioManager audioManager;


    public static void main(String[] args) {
        LiteSQL.openConnection();
        ConfigFile.loadConfig();
        ConfigValues.loadValues();

        jdaBuilder = JDABuilder.createDefault(ConfigValues.BOT_TOKEN);

        jdaBuilder.setStatus(OnlineStatus.IDLE);
        jdaBuilder.setActivity(Activity.playing("BTS BIOT"));


        audioPlayerManager = new DefaultAudioPlayerManager();
        audioManager = new AudioManager();


        try {
            jda = jdaBuilder.build();

        } catch (LoginException exception) {
            exception.printStackTrace();
        }

        AudioSourceManagers.registerRemoteSources(audioPlayerManager);

        registerCommand();
        setDescription();
    }

    public static JDA getJda(){
        if (jda != null) {
            return jda;
        }
       return null;
    }

    private static void registerCommand(){
        CommandManager commandManager = new CommandManager();
        jda.addEventListener(commandManager);

    }

    public static AudioPlayerManager getAudioPlayerManager() {
        if(audioPlayerManager != null){
            return audioPlayerManager;
        }
        return null;
    }

    public static AudioManager getAudioManager(){
        if (audioManager != null) {
            return audioManager;
        }
        return null;
    }

    private static void setDescription(){
        Description description = new Description();
        Timer timer = new Timer();
        timer.schedule(description, 0, 5000);

    }
}

