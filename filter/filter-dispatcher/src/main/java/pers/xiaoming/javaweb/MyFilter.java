package pers.xiaoming.javaweb;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class MyFilter implements Filter {

    private static final String MSG = "\tExecuting My Filter\t";
    private static final String MSG2 = "\tExecuting My Filter again\t";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(MSG);
        response.getWriter().write(MSG);
        chain.doFilter(request, response);
        System.out.println(MSG2);
        response.getWriter().write(MSG2);
    }

    @Override
    public void destroy() {
    }
}
