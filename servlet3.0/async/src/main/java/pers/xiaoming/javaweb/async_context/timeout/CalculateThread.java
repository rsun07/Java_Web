package pers.xiaoming.javaweb.async_context.timeout;

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
