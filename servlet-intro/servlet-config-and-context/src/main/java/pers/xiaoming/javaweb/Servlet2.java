package pers.xiaoming.javaweb;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class Servlet2 implements Servlet {

    private ServletConfig config;

    public Servlet2() {
        System.out.println("Create Servlet 2");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        System.out.println("Init Servlet 2");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Executing Servlet 2");

        Enumeration<String> elements = config.getInitParameterNames();

        while (elements.hasMoreElements()) {
            String name = elements.nextElement();
            String value = config.getInitParameter(name);
            System.out.printf("\nInit Parameter key is <%s>, value is <%s>\n", name, value);
        }

        ServletContext context = config.getServletContext();

        System.out.println("Servlet 2 : Context Attribute namespace is: " + context.getAttribute("namespace"));

        System.out.println("Servlet 2 : Context Attribute email is: " + context.getAttribute("email"));
    }

    @Override
    public String getServletInfo() {
        String info = "Servlet info, author, version and so on";
        System.out.println("Get Servlet Info " + info);
        return info;
    }

    @Override
    public void destroy() {
        System.out.println("Destroying Servlet 2");
    }
}
