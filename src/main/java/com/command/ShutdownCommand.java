package com.command;

import com.computer.control.ExecuteSystemCommand;
import com.google.gson.Gson;

import java.util.Map;

public class ShutdownCommand implements Command
{
    private static final String COMMAND_NAME = "shutdown";
    private static final ShutdownCommand ShutdownCommandInstance = new ShutdownCommand();
    private static final String SHUTDOWN_COMMAND = "systemctl poweroff";

    static ShutdownCommand instance() { return ShutdownCommandInstance; }

    private ShutdownCommand() { /* Intentionally empty */ }

    @Override
    public String execute(Map<String, String> pParameters) throws Exception
    {
        ExecuteSystemCommand systemCommand = new ExecuteSystemCommand(SHUTDOWN_COMMAND);
        systemCommand.execute();

        return new Gson().toJson("shutting down");
    }

    @Override
    public String getName()
    {
        return COMMAND_NAME;
    }
}
