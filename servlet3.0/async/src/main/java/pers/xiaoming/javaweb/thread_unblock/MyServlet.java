package pers.xiaoming.javaweb.thread_unblock;

import pers.xiaoming.javaweb.Messages;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/async/thread_unblock")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        System.out.println(Messages.MAIN_THREAD_START);
        out.println(Messages.MAIN_THREAD_START);

        Thread thread = new Thread(new CalculateThread(out));
        thread.start();

        System.out.println(Messages.MAIN_THREAD_COMPLETE);
        out.println(Messages.MAIN_THREAD_COMPLETE);
    }
}
