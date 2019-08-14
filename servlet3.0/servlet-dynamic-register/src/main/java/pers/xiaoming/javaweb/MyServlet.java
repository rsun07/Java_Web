package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Messages.SERVLET_REG_SUCCESS.print(resp.getWriter());

        // another way to get servlet init params
        Enumeration<String> names = this.getInitParameterNames();

        while(names.hasMoreElements()) {
            String name = names.nextElement();
            String value = this.getInitParameter(name);
            System.out.println("This: Init param, Key: " + name + "; Value: " + value);
        }
    }
}
