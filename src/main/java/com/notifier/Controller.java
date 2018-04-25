package com.notifier;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Controller
{
    private static final Controller ControllerInstance = new Controller();
    private Controller() { /*Intentionally empty*/ }
    public static Controller instance() { return ControllerInstance; }

    private final Map<String, StateListener> listeners = new ConcurrentHashMap<>();

    public void addListener(StateListener listener)
    {
        listeners.put(listener.getLocation(), listener);
    }

    void removeListener(StateListener listener)
    {
        System.out.println("Removing listener for " + listener);
        listeners.remove(listener.getLocation());
    }

    public void notifyListeners(String message)
    {
        listeners.values().forEach(listener -> listener.notifyListener(message));
    }
}
