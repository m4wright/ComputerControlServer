package com.computer.control;

import com.command.AllCommands;
import com.command.Command;
import com.google.gson.Gson;
import com.music.Artist;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "ControlServlet")
public class ControlServlet extends HttpServlet
{
    private static final String COMMAND_PARAMETER_NAME = "command";

    private static final Map<String, Command> aCommands = new HashMap<>();
    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String CONTENT_TYPE = "application/json";

    private static final Map<String, Artist> artists = new HashMap<>();
    private static final String MUSIC_DIRECTORY = "/home/mathew/Music";

    public ControlServlet()
    {
        initializeCommandsList();
        initializeSongs();
    }


    private static void initializeCommandsList()
    {
        AllCommands.getCommands().forEach(ControlServlet::addCommand);
    }

    private static void addSongsFromDirectory(File directory, String artistName)
    {
        if (!artists.containsKey(artistName)) {
            artists.put(artistName, new Artist(artistName));
        }

        Artist artist = artists.get(artistName);


        File[] files = directory.listFiles();
        if (files != null)
        {
            for (File file: files)
            {
                if (file.isDirectory())
                {
                    addSongsFromDirectory(file, artistName);
                }
                else
                {
                    String songName = FilenameUtils.removeExtension(file.getName());
                    try
                    {
                        artist.addSong(file, songName);
                        System.out.println("Adding " + artist.getSong(songName));
                    }
                    catch (Exception ignored) {}
                }
            }
        }
    }

    private static void initializeSongs()
    {
        File musicDirectory = new File(MUSIC_DIRECTORY);
        File[] artistDirectories = musicDirectory.listFiles();
        if (artistDirectories != null)
        {
            for (File artistDirectory: artistDirectories)
            {
                if (artistDirectory.isDirectory())
                {
                    addSongsFromDirectory(artistDirectory, artistDirectory.getName());
                }
            }
        }
    }

    public static Artist getArtist(String artist)
    {
        return artists.get(artist);
    }


    public static void addCommand(Command pCommand)
    {
        String name = pCommand.getName();
        aCommands.put(name, pCommand);
    }


    private Map<String, String> getParameterMap(Map pMap)
    {
        Map<String, String> parameters = new HashMap<>();

        pMap.forEach((Object parameter, Object valueList) ->
        {
            String paramString = (String) parameter;
            String[] valueArray = (String[]) valueList;

            parameters.put(paramString, valueArray[0]);
        });

        return parameters;
    }



    @Override
    protected void doGet(HttpServletRequest pRequest, HttpServletResponse pResponse) throws ServletException, IOException
    {
        String commandType = pRequest.getParameter(COMMAND_PARAMETER_NAME);


        if ("get_song".equals(commandType))
        {
            String artist = pRequest.getParameter("artist");
            String song_name = pRequest.getParameter("song_name");
            System.out.printf("Artist = %s, song = %s\n", artist, song_name);
            pResponse.setContentType("audio/mp");
            try
            {
                InputStream songStream = artists.get(artist).getSong(song_name).getSongFile();
                IOUtils.copy(songStream, pResponse.getOutputStream());
                return;
            }
            catch (Exception e)
            {
                pResponse.sendError(400, "Missing or invalid song name or artist");
                return;
            }
        }


        pRequest.setCharacterEncoding(CHARACTER_ENCODING);
        pResponse.setContentType(CONTENT_TYPE);



        if ("get_artists".equals(commandType))
        {
            String result = new Gson().toJson(artists.keySet());
            try (PrintWriter out = pResponse.getWriter())
            {
                out.write(result);
            }
            return;
        }

        if ("get_songs".equals(commandType))
        {
            String result = new Gson().toJson(artists);
            try (PrintWriter out = pResponse.getWriter())
            {
                out.write(result);
            }
            return;
        }



        Map<String, String> parameters = getParameterMap(pRequest.getParameterMap());

        if (aCommands.containsKey(commandType))
        {
            if ("register".equals(commandType))
            {
                parameters.put("address", pRequest.getRemoteAddr());
            }
            try
            {
                String outputString = aCommands.get(commandType).execute(parameters);
                try (PrintWriter out = pResponse.getWriter())
                {
                    out.write(outputString);
                }
            } catch (Exception e)
            {
                pResponse.sendError(400, e.getMessage());
            }
        }
        else
        {
            pResponse.sendError(400, String.format("Unsupported command: '%s'", commandType));
        }
    }
}
