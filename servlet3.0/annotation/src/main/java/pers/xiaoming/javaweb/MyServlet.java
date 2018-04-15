package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/annotation/my/*", "/annotation/myservlet"},
            name = "myservlet",
            initParams = {@WebInitParam(name="namespace", value = "my_servlet_namespace"),
                          @WebInitParam(name="address", value = "/annotation/myservlet")},
            loadOnStartup = 1)

public class MyServlet extends HttpServlet {
    private static final String MESSAGE = "\tExecuting my servlet\t";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(MESSAGE);
        resp.getWriter().print(MESSAGE);
    }
}
