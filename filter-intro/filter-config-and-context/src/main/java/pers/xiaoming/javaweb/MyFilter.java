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

        context.setAttribute("filter_attr", "set_by_filter");
        chain.doFilter(request, response);

        System.out.println("\n\nBack to Filter:");
        String setByServlet = (String) context.getAttribute("servlet_attr");
        System.out.println("Servlet set attribute, servlet_attr : " + setByServlet);
    }

    @Override
    public void destroy() {
    }
}
