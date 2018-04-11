package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MyServletEmptyInit extends MyGenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Executing MyServlet Empty Init service method!");

    }

    @Override
    public void init() {
        System.out.println("Initialize MyServlet overrides empty init()!");
    }
}
