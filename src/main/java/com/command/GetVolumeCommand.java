package com.command;

import com.computer.control.ExecuteSystemCommand;
import com.google.gson.Gson;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetVolumeCommand implements Command
{
    private static final GetVolumeCommand GetVolumeCommandInstance = new GetVolumeCommand();
    private static final String COMMAND_NAME = "get_volume";

    private GetVolumeCommand() { /* Intentionally empty */ }
    static GetVolumeCommand instance() { return GetVolumeCommandInstance; }



    private static final String GET_VOLUME_COMMAND = "amixer -D pulse get Master";

    private int extractVolume(String pVolumeDescription) throws Exception
    {
        Pattern volumePattern = Pattern.compile("\\[(\\d+)%\\]");
        Matcher volumeMatcher = volumePattern.matcher(pVolumeDescription);

        if (volumeMatcher.find())
        {
            String volumeString = volumeMatcher.group(1);
            return Integer.parseInt(volumeString);
        }
        else
        {
            throw new Exception("Could not get volume");
        }
    }

    /*
        This class only exists to make the formatted JSON string
     */
    private class VolumeFormatter
    {
        private final int volume;
        VolumeFormatter(int pVolume) { volume = pVolume; }
    }
    

    @Override
    public String execute(Map<String, String> pParameters) throws Exception
    {
        ExecuteSystemCommand systemCommand = new ExecuteSystemCommand(GET_VOLUME_COMMAND);
        systemCommand.execute();

        String commandOutput = systemCommand.getOutput();
        int volume = extractVolume(commandOutput);

        return new Gson().toJson(new VolumeFormatter(volume));
    }

    @Override
    public String getName()
    {
        return COMMAND_NAME;
    }
}
