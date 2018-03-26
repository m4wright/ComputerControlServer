package com.command;

import com.google.gson.Gson;
import com.music.MusicPlayer;

import java.util.Map;

public class TogglePlayCommand implements Command
{
    private static final String COMMAND_NAME = "toggle_play";
    private static final TogglePlayCommand TogglePlayCommandInstance = new TogglePlayCommand();

    private static final MusicPlayer MUSIC_PLAYER = MusicPlayer.instance();

    static TogglePlayCommand instance() { return TogglePlayCommandInstance; }
    private TogglePlayCommand() { /* Intentionally empty */ }

    @Override
    public String execute(Map<String, String> pParameters) throws Exception
    {
        MUSIC_PLAYER.togglePlay();
        if (MUSIC_PLAYER.currentlyPlaying())
        {
            return new Gson().toJson("Resuming song");
        }
        else
        {
            return new Gson().toJson("Pausing song");
        }
    }

    @Override
    public String getName() {
        return COMMAND_NAME;
    }
}

