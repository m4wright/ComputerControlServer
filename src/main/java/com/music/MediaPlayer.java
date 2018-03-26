package com.music;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.InputStream;

public class MediaPlayer
{
    private MediaPlayer() { /*Intentionally empty*/ }
    private static final MediaPlayer mediaPlayer = new MediaPlayer();
    public static MediaPlayer instance() { return mediaPlayer; }

    private Song currentSong;

    private PLAYER_STATUS playerStatus = PLAYER_STATUS.NOT_RUNNING;

    private AdvancedPlayer player;
    private int pausedOnFrame = 0;

    private void reset()
    {
        if (player != null) {
            player.close();
            pausedOnFrame = 0;
            playerStatus = PLAYER_STATUS.NOT_RUNNING;
        }
    }

    public boolean currentlyPlaying()
    {
        return playerStatus == PLAYER_STATUS.PLAYING;
    }

    public void togglePlay() throws JavaLayerException
    {
        if (currentlyPlaying())
        {
            pause();
        } else if (playerStatus == PLAYER_STATUS.PAUSED)
        {
            resume();
        }
    }

    private void play(InputStream song) throws JavaLayerException
    {
        reset();

        player = new AdvancedPlayer(song);
        player.setPlayBackListener(new PlaybackListener() {
            @Override
            public void playbackFinished(PlaybackEvent event)
            {
                pausedOnFrame = event.getFrame();
                System.out.println("Playback finished called. pausedOnFrame set to " + pausedOnFrame);
            }
        });

        new Thread(() -> {
            try
            {
                player.play();
                if (playerStatus == PLAYER_STATUS.PLAYING)
                {
                    playerStatus = PLAYER_STATUS.NOT_RUNNING;
                }
            }
            catch (JavaLayerException e)
            {
                playerStatus = PLAYER_STATUS.NOT_RUNNING;
            }
        }).start();

        playerStatus = PLAYER_STATUS.PLAYING;

    }

    public void play(Song song) throws JavaLayerException
    {
        play(song.getSongFile());
        currentSong = song;
    }

    public void resume() throws JavaLayerException
    {
        System.out.println("Resume called");
        if (playerStatus == PLAYER_STATUS.PAUSED)
        {
            player = new AdvancedPlayer(currentSong.getSongFile());

            new Thread(() -> {
                try
                {
                    player.play(pausedOnFrame, Integer.MAX_VALUE);
                    if (playerStatus == PLAYER_STATUS.PLAYING)
                    {
                        playerStatus = PLAYER_STATUS.NOT_RUNNING;
                    }
                }
                catch (JavaLayerException e)
                {
                    playerStatus = PLAYER_STATUS.NOT_RUNNING;
                }
            }).start();

            playerStatus = PLAYER_STATUS.PLAYING;
        }
        System.out.println("Player status is now " + playerStatus);
    }

    public void pause()
    {
        System.out.println("Pause called");
        if (playerStatus == PLAYER_STATUS.PLAYING)
        {
            player.stop();
            playerStatus = PLAYER_STATUS.PAUSED;
        }
        System.out.println("Player status is now " + playerStatus);
    }
}
