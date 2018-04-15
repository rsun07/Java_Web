package pers.xiaoming.javaweb;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    public MyFilter() {
        System.out.println("Constructing My Filter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Initialize My Filter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Do Filter before filter chain");

        // this doFilter() method is from FilterChain rather than Filter
        chain.doFilter(request, response);
        System.out.println("Do Filter after filter chain");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy My Filter");
    }
}
