package pers.xiaoming.javaweb.common;

import java.io.PrintWriter;

public enum Messages {
    MAIN_THREAD_START("Main Thread start!"),
    MAIN_THREAD_COMPLETE("Main Thread completed!"),

    BACKGROUND_THREAD_START("Background Thread start!"),
    BACKGROUND_THREAD_COMPLETE("Background Thread completed!"),

    BACKGROUND_THREAD_AFTER_COMPLETE("after async context complete, won't show up in response"),

    SERVLET_REQUEST_DESTROY("servlet request destroy"),

    RESULT_SERVLET_TRY("Result servlet, trying to get from session!"),
    RESULT_SERVLET_TRY_FAIL("Result servlet, fail to get sum"),
    RESULT_SERVLET_GET_RESULT("Successfully get Result");

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
