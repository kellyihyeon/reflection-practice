package com.github.kelly;

public class Task {

    private long number;
    private String title;

    public Task(long number, String title) {
        this.number = number;
        this.title = title;
    }

    private Task() {

    }

    public long getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }
}
