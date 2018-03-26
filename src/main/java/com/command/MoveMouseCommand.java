package com.command;

import com.google.gson.Gson;

import java.awt.*;
import java.util.Map;

public class MoveMouseCommand implements Command
{
    private static final String COMMAND_NAME = "move_mouse";
    private static final String POS_X_ARG = "pos_x";
    private static final String POS_Y_ARG = "pos_y";
    private static final int DELAY_LENGTH = 50;

    private Robot aRobot;

    private static final MoveMouseCommand MoveMouseCommandInstance = new MoveMouseCommand();

    static MoveMouseCommand instance() { return MoveMouseCommandInstance; }

    private MoveMouseCommand()
    {
        try {
            aRobot = new Robot();
            aRobot.setAutoDelay(DELAY_LENGTH);
        } catch (AWTException e) {
            System.err.println("Could not initialize MoveMouseCommand");
        }
    }



    @Override
    public String execute(Map<String, String> pParameters) throws Exception
    {
        int posX = Integer.parseInt(pParameters.get(POS_X_ARG));
        int posY = Integer.parseInt(pParameters.get(POS_Y_ARG));

        aRobot.mouseMove(posX, posY);

        return new Gson().toJson(
                String.format("Successfully moved mouse to (%d, %d)", posX, posY)
        );
    }

    @Override
    public String getName() { return COMMAND_NAME; }
}
