package com.command;

import com.google.gson.Gson;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Map;

public class SkipCommand implements Command
{
    private static final String COMMAND_NAME = "skip";
    private static final SkipCommand SKIP_COMMAND_INSTANCE = new SkipCommand();
    private static final String DIRECTION_ARG = "direction";


    private static Robot aRobot;

    private static final String LEFT_DIRECTION = "left";
    private static final String RIGHT_DIRECTION = "right";

    private static final int DEFAULT_AUTO_DELAY = 30;

    private SkipCommand()
    {
        try {
            aRobot = new Robot();
            aRobot.setAutoDelay(DEFAULT_AUTO_DELAY);
        } catch (AWTException e) {
            System.err.println("Could not initialize SkipCommand");
        }
    }

    static SkipCommand instance()
    {
        return SKIP_COMMAND_INSTANCE;
    }

    @Override
    public String execute(Map<String, String> pParameters) throws Exception
    {
        if (!pParameters.containsKey(DIRECTION_ARG))
        {
            throw new IllegalArgumentException("Missing direction");
        }

        String direction = pParameters.get(DIRECTION_ARG);

        if (LEFT_DIRECTION.equalsIgnoreCase(direction))
        {
            skip(KeyEvent.VK_LEFT);
        }
        else if (RIGHT_DIRECTION.equalsIgnoreCase(direction))
        {
            skip(KeyEvent.VK_RIGHT);
        }
        else
        {
            throw new IllegalArgumentException("Invalid direction");
        }

        return new Gson().toJson("Skipped sucsessfully");
    }

    private void skip(int pDirection)
    {
        aRobot.keyPress(pDirection);
        aRobot.keyRelease(pDirection);
        aRobot.keyPress(KeyEvent.VK_ENTER);
        aRobot.keyRelease(KeyEvent.VK_ENTER);
    }

    @Override
    public String getName()
    {
        return COMMAND_NAME;
    }
}
