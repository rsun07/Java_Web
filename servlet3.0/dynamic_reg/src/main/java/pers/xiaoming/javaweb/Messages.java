package pers.xiaoming.javaweb;

import java.io.PrintWriter;

public enum Messages {
    SERVLET_REG_SUCCESS("Successfully register servlet!"),
    CONTEXT_LISTENER_EXECUTING("Executing context listener");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(this.message);
    }

    public void print(PrintWriter out) {
        out.println(this.message);
        System.out.println(this.message);
    }
}
