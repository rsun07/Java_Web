package pers.xiaoming.javaweb.async_context.dispatch;

import pers.xiaoming.javaweb.common.Calculator;
import pers.xiaoming.javaweb.common.Messages;

import javax.servlet.AsyncContext;
import java.io.PrintWriter;

public class CalculateThread implements Runnable {

    private AsyncContext asyncContext;

    CalculateThread(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = asyncContext.getResponse().getWriter();

            Calculator.calculate(out);

            // Don't run this
            // asyncContext.complete();

            asyncContext.dispatch("/index.jsp");

            Thread.sleep(500);

            Messages.BACKGROUND_THREAD_AFTER_COMPLETE.print(out);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
