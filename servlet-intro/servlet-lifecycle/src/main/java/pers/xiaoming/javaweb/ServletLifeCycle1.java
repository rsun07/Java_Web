package pers.xiaoming.javaweb;

import javax.servlet.*;
import java.io.IOException;

public class ServletLifeCycle1 implements Servlet {

    private ServletConfig config;

    public ServletLifeCycle1() {
        System.out.println("Create Servlet 1");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        System.out.println("Init Servlet 1");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Executing Servlet 1");
    }

    @Override
    public String getServletInfo() {
        String info = "Servlet info, author, version and so on";
        System.out.println("Get Servlet Info " + info);
        return info;
    }

    @Override
    public void destroy() {
        System.out.println("Destroying Servlet 1");
    }
}
