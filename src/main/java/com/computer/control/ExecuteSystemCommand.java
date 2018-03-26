package com.computer.control;


import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteSystemCommand
{
    private final String[] aCommands;
    private String aOutput;

    public ExecuteSystemCommand(String ...pCommands)
    {
        aCommands = pCommands;                  // this is safe since varargs can't be modified
    }

    public ExecuteSystemCommand(String pCommand)
    {
        this(pCommand.split(" "));
    }

    public void execute() throws IOException, InterruptedException
    {
        ProcessBuilder pb = new ProcessBuilder(aCommands);
        Process pc = pb.start();

        getOutputOfProcess(pc);
    }

    public String getOutput()
    {
        return aOutput;
    }


    private void getOutputOfProcess(Process pProcess) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(pProcess.getInputStream())
        );

        aOutput = IOUtils.toString(bufferedReader);
    }
}
