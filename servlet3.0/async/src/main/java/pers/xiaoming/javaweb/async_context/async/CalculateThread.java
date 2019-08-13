package pers.xiaoming.javaweb.async_context.async;

import pers.xiaoming.javaweb.common.Calculator;
import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CalculateThread implements Runnable {

    private AsyncContext asyncContext;

    CalculateThread(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {
        try {

            HttpServletRequest request = (HttpServletRequest) asyncContext.getRequest();
            HttpSession session = request.getSession();

            int sum = Calculator.calculate();

            session.setAttribute("sum", sum);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
