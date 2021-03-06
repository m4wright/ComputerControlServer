package com.music;

import com.notifier.Controller;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javazoom.jl.decoder.JavaLayerException;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public class MusicPlayer
{
    private MusicPlayer()
    {
        new JFXPanel();                 // needed to perform JavaFX initialization to be able to use MediaPlayer
    }


    private static final MusicPlayer MUSIC_PLAYER = new MusicPlayer();
    public static MusicPlayer instance() { return MUSIC_PLAYER; }


    private volatile MediaPlayer player;




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

    private synchronized void play(String songPath) throws LineUnavailableException, IOException
    {
        if (player != null) {
            player.stop();
        }
        player = new MediaPlayer(new Media(songPath));
        player.setOnEndOfMedia(() -> {
            System.out.println("Done song!");
            Controller.instance().notifyListeners("done_song");
        });
        player.setOnError(() -> {
            System.out.println("Error playing song :(");
            player.getError().printStackTrace();
        });
        player.play();
    }

    public void play(Song song) throws IOException, LineUnavailableException
    {
        play(song.getSongURI().toString());
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
