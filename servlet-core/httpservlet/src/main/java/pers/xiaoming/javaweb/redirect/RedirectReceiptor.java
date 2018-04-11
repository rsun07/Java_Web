package pers.xiaoming.javaweb.redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RedirectReceiptor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String attribute = (String) req.getAttribute("attribute");

        PrintWriter out = resp.getWriter();

        String output = String.format("Executing Redirect Receiptor.\n"
                + "The attribute is, [%s] \n"
                + "The request implementation is, [%s] \n"
                + "The response implementation is, [%s] \n"
                , attribute, req.getClass(), resp.getClass());

        System.out.println(output);

        out.write(output);
    }
}
