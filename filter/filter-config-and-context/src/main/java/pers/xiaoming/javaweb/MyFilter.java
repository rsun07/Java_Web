package pers.xiaoming.javaweb;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class MyFilter implements Filter {

    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("\n\nRunning Filter:");

        ServletContext context = request.getServletContext();

        String contextNamespace = context.getInitParameter("namespace");
        System.out.println("Context Init param, namespace : " + contextNamespace);

        Enumeration<String> params = config.getInitParameterNames();
        while (params.hasMoreElements()) {
            String name = params.nextElement();
            String value = config.getInitParameter(name);
            System.out.println("Filter Init Param, name is " + name + ", value is " + value);
        }

        context.setAttribute("filter_attr", "context_filter_attr");
        request.setAttribute("filter_attr", "request_filter_attr");
        chain.doFilter(request, response);

        System.out.println("\n\nBack to Filter:");
        String contextAttr = (String) context.getAttribute("servlet_attr");
        String requestAttr = (String) request.getAttribute("servlet_attr");
        System.out.println("Servlet context attribute, servlet_attr : " + contextAttr);
        System.out.println("Servlet request attribute, servlet_attr : " + requestAttr);
    }

    @Override
    public void destroy() {
    }
}
