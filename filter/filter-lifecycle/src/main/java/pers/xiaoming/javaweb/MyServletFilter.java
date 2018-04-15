package pers.xiaoming.javaweb;

import javax.servlet.*;
import java.io.IOException;

public class MyServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Do MyServlet Filter before filter chain");
        chain.doFilter(request, response);
        System.out.println("Do MyServlet Filter after filter chain");
    }

    @Override
    public void destroy() {
    }
}
