package pers.xiaoming.javaweb.generic_servlet;

import javax.servlet.*;
import java.io.IOException;

public class MyServlet extends MyGenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Executing MyServlet service method!");

        String param = this.getInitParameter("namespace");
        String servletName = this.getServletName();

        ServletContext context = this.getServletContext();
        String contextParam = context.getInitParameter("namespace");

        System.out.printf("\nInit param in servlet [%s] for namespace is : [%s]", servletName, param);
        System.out.printf("\nContext param get by servlet [%s] for namespace is : [%s]", servletName, contextParam);
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        System.out.println("Initialize My Servlet");
    }
}
