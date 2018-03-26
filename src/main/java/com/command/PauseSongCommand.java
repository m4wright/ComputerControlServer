package com.command;

import com.google.gson.Gson;
import com.music.MediaPlayer;

import java.util.Map;

public class PauseSongCommand implements Command
{
    private static final String COMMAND_NAME = "pause_song";
    private static final PauseSongCommand PauseSongCommandInstance = new PauseSongCommand();

    private static final MediaPlayer mediaPlayer = MediaPlayer.instance();

    static PauseSongCommand instance() { return PauseSongCommandInstance; }
    private PauseSongCommand() { /* Intentionally empty */ }

    @Override
    public String execute(Map<String, String> pParameters) throws Exception
    {
        mediaPlayer.pause();
        return new Gson().toJson("Pausing song");
    }

    @Override
    public String getName() {
        return COMMAND_NAME;
    }
}