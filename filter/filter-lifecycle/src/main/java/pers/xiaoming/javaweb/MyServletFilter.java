package pers.xiaoming.javaweb;

import javax.servlet.*;
import java.io.IOException;
import java.io.OutputStream;

public class MyServletFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Do MyServlet Filter before filter chain");
        response.getWriter().write("Filter header.\t\t\t");

        chain.doFilter(request, response);

        response.getWriter().write("\t\t\t Filter tail.");
        System.out.println("Do MyServlet Filter after filter chain");

        OutputStream stream = response.getOutputStream();
        System.out.println(stream.toString());
    }

    @Override
    public void destroy() {
    }
}
