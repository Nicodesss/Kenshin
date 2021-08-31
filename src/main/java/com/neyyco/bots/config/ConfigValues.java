package com.neyyco.bots.config;

public class ConfigValues {
    public static String BOT_TOKEN;
    public static void  loadValues(){
        BOT_TOKEN = ConfigManager.getKeys("token");


    }
}
