package com.command;

import com.computer.control.ExecuteSystemCommand;
import com.google.gson.Gson;

import java.util.Map;

public class SetVolumeCommand implements Command
{
    private static final String VOLUME_PARAMETER = "volume";
                                                                                                        // change back to volume after fixing client and other back-ends
    private static final String CHANGE_VOLUME_TEMPLATE = "/usr/bin/amixer -D pulse set Master %d%%";
    private static final String COMMAND_NAME = "set_volume";

    private static final SetVolumeCommand SetVolumeCommandInstance = new SetVolumeCommand();



    private SetVolumeCommand() { /* Intentionally empty */ }
    static Command instance() { return SetVolumeCommandInstance; }




    private int getVolume(String pVolumeString) throws IllegalArgumentException
    {
        if (pVolumeString != null) {
            try
            {
                int volume = Integer.parseInt(pVolumeString);
                if (volume >= 0 && volume <= 100) return volume;
                else throw new IllegalArgumentException(String.format("%s must be between 0 and 100", VOLUME_PARAMETER));
            }
            catch (NumberFormatException e)
            {
                throw new IllegalArgumentException(String.format("%s must be an integer", VOLUME_PARAMETER));
            }
        } else {
            throw new IllegalArgumentException(String.format("Missing parameter '%s'", VOLUME_PARAMETER));
        }
    }


    @Override
    public String execute(Map<String, String> pParameters) throws Exception
    {
        int volume = getVolume(pParameters.get(VOLUME_PARAMETER));
        String commandString = String.format(CHANGE_VOLUME_TEMPLATE, volume);
        ExecuteSystemCommand systemCommand = new ExecuteSystemCommand(commandString);

        systemCommand.execute();

        return new Gson().toJson(String.format("Volume set to %d%%", volume));
    }

    @Override
    public String getName()
    {
        return COMMAND_NAME;
    }


}
