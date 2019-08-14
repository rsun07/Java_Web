package pers.xiaoming.javaweb;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilterForServlet implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        Messages.EXECUTING_FILTER_FOR_SERVLET.print(out);
        chain.doFilter(request, response);
        Messages.EXECUTING_FILTER_FOR_SERVLET.print(out);
    }

    @Override
    public void destroy() {

    }
}
