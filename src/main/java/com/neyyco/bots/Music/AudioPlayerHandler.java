package com.neyyco.bots.Music;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.track.playback.AudioFrame;
import net.dv8tion.jda.api.audio.AudioSendHandler;
import org.jetbrains.annotations.Nullable;

import java.nio.ByteBuffer;

public class AudioPlayerHandler implements AudioSendHandler {

    private final AudioPlayer audioPlayer;
    private AudioFrame audioFrame;

    public AudioPlayerHandler(AudioPlayer audioPlayer){
        this.audioPlayer = audioPlayer;

    }
    @Override
    public boolean canProvide() {
        audioFrame = audioPlayer.provide();
        return audioFrame != null;
    }

    @Nullable
    @Override
    public ByteBuffer provide20MsAudio() {
        return ByteBuffer.wrap(audioFrame.getData());
    }

    @Override
    public boolean isOpus(){
        return  true;
    }
}
