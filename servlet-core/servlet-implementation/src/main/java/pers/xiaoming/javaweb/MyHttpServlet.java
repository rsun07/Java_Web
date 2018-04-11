package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServlet extends MyGenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Executing My http servlet");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String method = request.getMethod();
        System.out.println("request method is : " + method);

        if ("POST".equals(method)) {
            doPost();
        } else if ("GET".equals(method)) {
            doGet();
        }
    }

    private void doPost() {
        System.out.println("DO POST");
    }

    private void doGet() {
        System.out.println("DO GET");
    }
}
