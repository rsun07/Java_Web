package pers.xiaoming.javaweb;

import javax.servlet.*;
import java.io.IOException;

public class NoChainFilter implements Filter {

    public NoChainFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Do No Chain Filter before filter chain");

        // Don't run FilterChian's doFilter()
        // chain.doFilter(request, response);
        System.out.println("Do No Chain Filter after filter chain");
    }

    @Override
    public void destroy() {
    }
}
