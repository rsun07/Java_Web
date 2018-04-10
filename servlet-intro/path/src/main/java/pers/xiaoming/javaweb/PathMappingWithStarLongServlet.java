package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class PathMappingWithStarLongServlet extends BaseServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Path Mapping with star Long Servlet");
    }
}
