package pers.xiaoming.javaweb.async_context_complete;

import pers.xiaoming.javaweb.Messages;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// remember to set async support to true
@WebServlet(value = "/async/context/complete", asyncSupported = true)
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        AsyncContext asyncContext = req.startAsync();

        Messages.MAIN_THREAD_START.print(out);

        Thread thread = new Thread(new CalculateThread(asyncContext));

        // start async context
        asyncContext.start(thread);

        Messages.MAIN_THREAD_COMPLETE.print(out);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
