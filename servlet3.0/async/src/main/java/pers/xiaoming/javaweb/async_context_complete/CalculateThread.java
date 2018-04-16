package pers.xiaoming.javaweb.async_context_complete;

import pers.xiaoming.javaweb.Messages;

import javax.servlet.AsyncContext;
import java.io.PrintWriter;

public class CalculateThread implements Runnable {

    private AsyncContext asyncContext;

    public CalculateThread(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = asyncContext.getResponse().getWriter();

            Messages.BACKGROUND_THREAD_START.print(out);
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
                sum += i;
                Thread.sleep(500);
            }
            out.println("sum = " + sum);

            Messages.BACKGROUND_THREAD_COMPLETE.print(out);

            // notify the completion of async context
            // and destroy request and response instance
            asyncContext.complete();

            Thread.sleep(500);

            Messages.BACKGROUND_THREAD_AFTER_COMPLETE.print(out);
        } catch (Exception e) {
            // do nothing
            e.printStackTrace();
        }
    }
}
