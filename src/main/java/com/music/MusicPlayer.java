package com.music;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javazoom.jl.decoder.JavaLayerException;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.nio.file.Paths;

public class MusicPlayer
{
    private MusicPlayer()
    {
        new JFXPanel();                 // needed to perform JavaFX initialization to be able to use MediaPlayer
    }


    private static final MusicPlayer MUSIC_PLAYER = new MusicPlayer();
    public static MusicPlayer instance() { return MUSIC_PLAYER; }



    private MediaPlayer player;




    public boolean currentlyPlaying()
    {
        return (player != null && player.getStatus().equals(MediaPlayer.Status.PLAYING));
    }

    public void togglePlay() throws JavaLayerException
    {
        if (currentlyPlaying())
        {
            pause();
        } else if (player.getStatus().equals(MediaPlayer.Status.PAUSED))
        {
            resume();
        }
    }

    private void play(String songPath) throws LineUnavailableException, IOException
    {
        player = new MediaPlayer(new Media(songPath));

        player.play();
    }

    public void play(Song song) throws IOException, LineUnavailableException
    {
        play(Paths.get(song.getSongPath()).toUri().toString());
    }

    public void resume()
    {
        if (player.getStatus().equals(MediaPlayer.Status.PAUSED))
        {
            player.play();
        }
    }

    public void pause()
    {
        if (player.getStatus().equals(MediaPlayer.Status.PLAYING))
        {
            player.pause();
        }
    }
}
