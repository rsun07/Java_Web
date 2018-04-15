package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/annotation/redirect", name = "redirect-servlet")

public class RedirectServlet extends HttpServlet {

    private static final String MESSAGE = "\tExecuting redirect servlet\t";
    private static final String MESSAGE_AFTER_FORWARD = "\tExecuting redirect servlet AFTER FORWARD\t";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(MESSAGE);
        resp.getWriter().print(MESSAGE);

        req.getRequestDispatcher("/annotation/myservlet").forward(req, resp);

        System.out.println(MESSAGE_AFTER_FORWARD);
        resp.getWriter().print(MESSAGE_AFTER_FORWARD);
    }
}
