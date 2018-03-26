package com.command;

import com.google.gson.Gson;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static java.awt.event.KeyEvent.*;

public class SpecialCharacters implements Command
{
    private static final String COMMAND_NAME = "special_character_command";
    private static final Map<String, Integer> aCharacterMap = new HashMap<>();
    private static final String CHARACTER_PARAMETER = "special_char";
    private static final int DELAY_LENGTH = 50;

    private static final SpecialCharacters SPECIAL_CHARACTERS_INSTANCE = new SpecialCharacters();

    public static SpecialCharacters instance() { return SPECIAL_CHARACTERS_INSTANCE; }

    private Robot aRobot;

    static
    {
        aCharacterMap.put("enter", VK_ENTER);
        aCharacterMap.put("tab", VK_TAB);
        aCharacterMap.put("backspace", VK_BACK_SPACE);
        aCharacterMap.put("up_arrow", VK_UP);
        aCharacterMap.put("down_arrow", VK_DOWN);
        aCharacterMap.put("left_arrow", VK_LEFT);
        aCharacterMap.put("right_arrow", VK_RIGHT);
    }

    private SpecialCharacters()
    {
        try
        {
            aRobot = new Robot();
            aRobot.setAutoDelay(DELAY_LENGTH);
        }
        catch (AWTException e)
        {
            System.err.println("Could not initialize robot");
        }
    }

    @Override
    public String execute(Map<String, String> pParameters) throws Exception
    {
        if (!pParameters.containsKey(CHARACTER_PARAMETER))
        {
            throw new Exception("Missing special character to type");
        }
        String character = pParameters.get(CHARACTER_PARAMETER);

        if (!aCharacterMap.containsKey(character))
        {
            throw new Exception(String.format("Invalid special character to type: %s is not supported", character));
        }

        int keyCommand = aCharacterMap.get(character);

        aRobot.keyPress(keyCommand);
        aRobot.keyRelease(keyCommand);

        return new Gson().toJson(String.format("Successfully type command %s", character));
    }

    @Override
    public String getName()
    {
        return COMMAND_NAME;
    }
}
