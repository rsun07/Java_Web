package pers.xiaoming.javaweb;

import javax.servlet.*;
import java.io.IOException;

public class ServletLifeCycle implements Servlet {

    private ServletConfig config;

    public ServletLifeCycle() {
        System.out.println("Create Servlet");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        System.out.println("Init Servlet");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletContext context = config.getServletContext();

        config.getInitParameterNames();

        context.setAttribute("email", "myeamil@email.com");

        System.out.println("service Servlet");

        context.getContextPath();

        context.getRealPath("/image");

        context.getAttribute("");
        context.removeAttribute("");
    }

    @Override
    public String getServletInfo() {
        String info = "Servlet info, author, version and so on";
        System.out.println("Get Servlet Info " + info);
        return info;
    }

    @Override
    public void destroy() {
        System.out.println("Destroying Servlet");
    }
}
