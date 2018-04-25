package com.command;

import java.util.Collections;
import java.util.List;

public class AllCommands
{
    private static final List<Command> COMMANDS = List.of(
        GetVolumeCommand.instance(),
        SetVolumeCommand.instance(),
        ShutdownCommand.instance(),
        KeyboardCommand.instance(),
        MoveMouseCommand.instance(),
        SkipCommand.instance(),
        SpecialCharacters.instance(),
        PlaySongCommand.instance(),
        PauseSongCommand.instance(),
        ResumeSongCommand.instance(),
        TogglePlayCommand.instance(),
        RegisterCommand.instance()
    );

    private AllCommands() { /* Intentionally empty */ }

    public static List<Command> getCommands() { return Collections.unmodifiableList(COMMANDS); }
}
