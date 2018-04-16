package pers.xiaoming.javaweb.thread.unblock;

import pers.xiaoming.javaweb.common.Messages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/async/thread/unblock")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        Messages.MAIN_THREAD_START.print(out);

        Thread thread = new Thread(new CalculateThread(out));
        thread.start();

        Messages.MAIN_THREAD_COMPLETE.print(out);

    }
}
