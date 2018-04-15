package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IncludeReceiptor extends HttpServlet {
    private static final String MSG = "\tExecuting Include Receiptor\t";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(MSG);
        resp.getWriter().write(MSG);
    }
}
