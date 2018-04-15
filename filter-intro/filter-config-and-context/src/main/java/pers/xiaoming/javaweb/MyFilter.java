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
        ServletContext context = request.getServletContext();

        String contextNamespace = (String) context.getAttribute("namespace");
        System.out.println("In Filter, Context Init param, namespace : " + contextNamespace);

        Enumeration<String> params = config.getInitParameterNames();
        while (params.hasMoreElements()) {
            System.out.println("Filter Init Param : " + params.nextElement());
        }

        context.setAttribute("filter_attr", "set_by_filter");
        chain.doFilter(request, response);

        String setByServlet = (String) context.getAttribute("servlet_attr");
        System.out.println("Servlet set attribute, servlet_attr : " + contextNamespace);
    }

    @Override
    public void destroy() {
    }
}
