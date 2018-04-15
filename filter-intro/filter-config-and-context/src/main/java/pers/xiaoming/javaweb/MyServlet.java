package pers.xiaoming.javaweb;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = request.getServletContext();

        String contextNamespace = (String) context.getAttribute("namespace");
        System.out.println("In Servlet, Context Init param, namespace : " + contextNamespace);

        String setByFilter = (String) context.getAttribute("filter_attr");
        System.out.println("Filter set attribute, servlet_attr : " + setByFilter);

        context.setAttribute("servlet_attr", "set_by_servlet");
    }
}
