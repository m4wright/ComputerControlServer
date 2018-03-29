package com.command;

import com.google.gson.Gson;
import com.notifier.Controller;
import com.notifier.NetworkStateListener;
import com.notifier.StateListener;

import java.util.Map;

public class RegisterCommand implements Command
{
    private static final String COMMAND_NAME = "register";
    private static final RegisterCommand RegisterCommandInstance = new RegisterCommand();
    private static final int REMOTE_PORT = 4567;

    private RegisterCommand() { /* Intentionally empty */ }

    public static RegisterCommand instance() { return RegisterCommandInstance; }

    @Override
    public String execute(Map<String, String> pParameters) throws Exception
    {
        String address = pParameters.get("address");
        String registerDeviceURI = String.format("http://%s:%d/notify", address, REMOTE_PORT);
        StateListener listener = new NetworkStateListener(registerDeviceURI);
        Controller.instance().addListener(listener);

        System.out.println("Registering " + registerDeviceURI);

        return new Gson().toJson("Device registered with address " + registerDeviceURI);
    }

    @Override
    public String getName() {
        return COMMAND_NAME;
    }
}
