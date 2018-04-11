package pers.xiaoming.javaweb.redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IncludeServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("attribute", "MyAttribute");

        PrintWriter out = resp.getWriter();

        // in forward, the output stream hasn't open yet
        // so this line and the last line won't show up
        out.write("Before Redirect Include Server redirect ");

        req.getRequestDispatcher("includereceiptor").include(req, resp);

        out.write("After Redirect Include Server redirect ");
    }
}
