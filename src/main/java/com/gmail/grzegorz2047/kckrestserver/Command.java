package com.gmail.grzegorz2047.kckrestserver;

public class Command {

    private final long id;
    private final String command;

    public Command(long id, String command) {
        this.id = id;
        this.command = command;
    }

    public long getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}