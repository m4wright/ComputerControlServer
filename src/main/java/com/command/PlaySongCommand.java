package com.command;

import com.computer.control.ControlServlet;
import com.google.gson.Gson;
import com.music.Artist;
import com.music.MusicPlayer;
import com.music.Song;

import java.util.Map;

public class PlaySongCommand implements Command
{
    private static final String COMMAND_NAME = "play_song";
    private static final String ARTIST = "artist";
    private static final String SONG_NAME = "song_name";
    private static final PlaySongCommand PlaySongCommandInstance = new PlaySongCommand();

    private static final MusicPlayer MUSIC_PLAYER = MusicPlayer.instance();

    static PlaySongCommand instance() { return PlaySongCommandInstance; }
    private PlaySongCommand() { /* Intentionally empty */ }

    @Override
    public String execute(Map<String, String> pParameters) throws Exception
    {
        String artist_name = pParameters.get(ARTIST);
        String song_name = pParameters.get(SONG_NAME);

        Artist artist = ControlServlet.getArtist(artist_name);
        Song song = artist.getSong(song_name);

        MUSIC_PLAYER.play(song);


        return new Gson().toJson("Playing " + artist.getSong(song_name));
    }

    @Override
    public String getName() {
        return COMMAND_NAME;
    }
}
