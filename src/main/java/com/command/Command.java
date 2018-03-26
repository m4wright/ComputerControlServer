package com.command;

import java.util.Map;

public interface Command
{
    String execute(Map<String, String> pParameters) throws Exception;
    String getName();
}
