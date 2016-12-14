package com.gmail.grzegorz2047.kckrestserver;

public class Command {

    private final long id;
    private final String content;

    public Command(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}