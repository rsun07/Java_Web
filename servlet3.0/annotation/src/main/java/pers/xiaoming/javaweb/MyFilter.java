package pers.xiaoming.javaweb;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "myfilter",
           servletNames = {"myservlet", "redirect-servlet"},
           urlPatterns = {"/annotation/my/*", "/annotation/myservlet/*"},
           dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.INCLUDE})
public class MyFilter implements Filter {
    private static final String MESSAGE = "\tExecuting my filter\t";
    private static final String MESSAGE_AGAIN = "\tExecuting my filter AGAIN\t";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(MESSAGE);
        response.getWriter().print(MESSAGE);

        chain.doFilter(request, response);

        System.out.println(MESSAGE_AGAIN);
        response.getWriter().print(MESSAGE_AGAIN);
    }

    @Override
    public void destroy() {

    }
}
