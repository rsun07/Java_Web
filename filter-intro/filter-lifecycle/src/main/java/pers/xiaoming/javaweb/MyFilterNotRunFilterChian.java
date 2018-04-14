package pers.xiaoming.javaweb;

import javax.servlet.*;
import java.io.IOException;

public class MyFilterNotRunFilterChian implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Do Filter before filter chain");

        // does not run the filter chain's doFilter() method
        // chain.doFilter(request, response);
        System.out.println("Do Filter after filter chain");
    }

    @Override
    public void destroy() {
    }
}
