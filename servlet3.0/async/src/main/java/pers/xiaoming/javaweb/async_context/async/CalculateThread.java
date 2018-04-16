package pers.xiaoming.javaweb.async_context.async;

import pers.xiaoming.javaweb.common.Calculator;
import pers.xiaoming.javaweb.common.Messages;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.io.PrintWriter;

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
