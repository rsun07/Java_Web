package pers.xiaoming.javaweb.redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RedirectServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("attribute", "MyAttribute");

        PrintWriter out = resp.getWriter();

        out.write("Before Redirect Server forward ");

        resp.sendRedirect("/httpservlet/redirect/redirectreceiptor");

        out.write("After Redirect Server forward ");
    }
}
