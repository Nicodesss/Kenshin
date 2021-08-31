package com.neyyco.bots;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;

import java.util.TimerTask;

public class Description extends TimerTask {
    private int count = 0;
    private final JDA jda = Main.getJda();
    private final String[] message = {"BTS BIOT", "MAKING MILO", "SAND NIGGER", "!Tabang"};

    @Override
    public void run(){
        if (jda != null) {
            jda.getPresence().setActivity(Activity.watching(message[count]));
            count = (count + 1 )%message.length;

        }

    }
}
