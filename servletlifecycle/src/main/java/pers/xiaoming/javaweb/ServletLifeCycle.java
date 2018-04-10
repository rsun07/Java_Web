package pers.xiaoming.javaweb;

import javax.servlet.*;
import java.io.IOException;

public class ServletLifeCycle implements Servlet {

    public ServletLifeCycle() {
        System.out.println("Create Servlet");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Init Servlet");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Destroying Servlet");
    }
}
