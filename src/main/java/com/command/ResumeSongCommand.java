package com.command;

import com.google.gson.Gson;
import com.music.MusicPlayer;

import java.util.Map;

public class ResumeSongCommand implements Command
{
    private static final String COMMAND_NAME = "resume_song";
    private static final ResumeSongCommand ResumeSongCommandInstance = new ResumeSongCommand();

    private static final MusicPlayer MUSIC_PLAYER = MusicPlayer.instance();

    static ResumeSongCommand instance() { return ResumeSongCommandInstance; }
    private ResumeSongCommand() { /* Intentionally empty */ }

    @Override
    public String execute(Map<String, String> pParameters) throws Exception
    {
        MUSIC_PLAYER.resume();
        return new Gson().toJson("Resuming song");
    }

    @Override
    public String getName() {
        return COMMAND_NAME;
    }
}

