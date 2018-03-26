package com.music;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Song
{
    private final String artist;
    private final String songName;
    transient private final File songFile;


    private static final Set<String> VALID_EXTENSIONS = new HashSet<>(Arrays.asList("mp3"));




    public Song(String songName, String artist, String path)
    {
        this.artist = artist;
        this.songName = songName;
        this.songFile = new File(path);
        validateInput();
    }

    private void validateInput() {
        if (!this.songFile.exists() || this.songFile.isDirectory())
        {
            throw new MissingSongException();
        }

        String extension = FilenameUtils.getExtension(this.songFile.getName());
        if (!VALID_EXTENSIONS.contains(extension))
        {
            throw new MissingSongException();
        }

        if (artist == null || songName == null)
        {
            throw new IllegalArgumentException();
        }
    }

    public InputStream getSongFile() {
        try
        {
            return new FileInputStream(songFile);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        return artist.equals(song.artist) && songName.equals(song.songName);
    }

    @Override
    public int hashCode() {
        int result = artist.hashCode();
        result = 31 * result + songName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s by %s", songName, artist);
    }
}
