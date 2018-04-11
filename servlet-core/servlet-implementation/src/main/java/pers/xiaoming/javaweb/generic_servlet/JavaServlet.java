package pers.xiaoming.javaweb.generic_servlet;

import javax.servlet.*;
import java.io.IOException;

public class JavaServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Executing Java Servlet service method!");

        String param = this.getInitParameter("namespace");
        String servletName = this.getServletName();

        ServletContext context = this.getServletContext();
        String contextParam = context.getInitParameter("namespace");

        System.out.printf("\nInit param in servlet [%s] for namespace is : [%s]", servletName, param);
        System.out.printf("\nContext param get by servlet [%s] for namespace is : [%s]", servletName, contextParam);
    }

    @Override
    public void init() {
        System.out.println("Initialize Java Servlet overrides empty init()!");
    }
}
