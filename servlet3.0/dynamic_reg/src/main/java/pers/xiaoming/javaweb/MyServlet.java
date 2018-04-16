package pers.xiaoming.javaweb;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MyServlet extends HttpServlet {

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Messages.SERVLET_REG_SUCCESS.print(resp.getWriter());

        Enumeration<String> params = config.getInitParameterNames();

        while(params.hasMoreElements()) {
            String name = params.nextElement();
            String value = config.getInitParameter(name);
            System.out.println("Init param, Key: " + name + "; Value: " + value);
        }
    }
}
