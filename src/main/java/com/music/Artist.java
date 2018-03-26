package com.music;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Artist
{
    private final String artistName;
    private final Map<String, Song> songs = new HashMap<>();


    public Artist(String artistName)
    {
        this.artistName = artistName;
    }

    public void addSong(File song)
    {
        String songName = FilenameUtils.removeExtension(song.getName());
        addSong(song, songName);
    }

    public void addSong(File song, String songName)
    {
        if (validateSong(song))
        {
            songs.put(songName, new Song(songName, artistName, song.getAbsolutePath()));
        }
    }

    public boolean hasSong(String songName)
    {
        return songs.containsKey(songName);
    }

    public Song getSong(String songName)
    {
        return songs.get(songName);
    }

    private boolean validateSong(File song) { return song != null && !song.isDirectory(); }
}
