package com.command;

import com.google.gson.Gson;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class KeyboardCommand implements Command
{
    private static final String COMMAND_NAME = "keyboard";
    private static final KeyboardCommand KeyboardCommandInstance = new KeyboardCommand();
    private static final String KEYS_TO_PRESS_ARGS = "word";

    private static final int DELAY_LENGTH = 50;

    private static Robot aRobot;






    private KeyboardCommand()
    {
        try {
            aRobot = new Robot();
            aRobot.setAutoDelay(DELAY_LENGTH);
        } catch (AWTException e) {
            System.err.println("Could not initialize KeyboardCommand");
        }
    }

    static KeyboardCommand instance() { return KeyboardCommandInstance; }


    private void pressKey(int keyCode)
    {
        aRobot.keyPress(keyCode);
    }

    private void releaseKey(int keyCode)
    {
        aRobot.keyRelease(keyCode);
    }

    private void TypeCharacter(char pKeyToType)
    {
        List<Integer> commandsToPress = CharacterCommands.getCommands(pKeyToType);
        commandsToPress.forEach(this::pressKey);
        commandsToPress.forEach(this::releaseKey);
    }

    private void TypeString(String pStringToType)
    {
        for (char c: pStringToType.toCharArray())
        {
            TypeCharacter(c);
        }
    }


    @Override
    public String execute(Map<String, String> pParameters) throws Exception
    {
        String stringToType = pParameters.get(KEYS_TO_PRESS_ARGS);
        TypeString(stringToType);

        return new Gson().toJson("Successfully typed " + stringToType);
    }

    @Override
    public String getName()
    {
        return COMMAND_NAME;
    }
}
