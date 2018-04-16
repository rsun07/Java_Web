package pers.xiaoming.javaweb.common;

import java.io.PrintWriter;

public enum Messages {
    MAIN_THREAD_START("Main Thread start!"),
    MAIN_THREAD_COMPLETE("Main Thread completed!"),

    BACKGROUND_THREAD_START("Background Thread start!"),
    BACKGROUND_THREAD_COMPLETE("Background Thread completed!"),

    BACKGROUND_THREAD_AFTER_COMPLETE("after async context complete, won't show up in response");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public void print(PrintWriter out) {
        out.println(this.message);
        System.out.println(this.message);
    }
}
