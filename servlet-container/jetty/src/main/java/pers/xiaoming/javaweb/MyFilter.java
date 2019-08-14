package pers.xiaoming.javaweb;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "myfilter",
           urlPatterns = "/myservlet")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterConfig Class in Filter : " + filterConfig.getClass());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Request Class in Filter : " + request.getClass());
        System.out.println("Response Class in Filter : " + response.getClass());
        System.out.println("FilterChain Class in Filter : " + chain.getClass());

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
