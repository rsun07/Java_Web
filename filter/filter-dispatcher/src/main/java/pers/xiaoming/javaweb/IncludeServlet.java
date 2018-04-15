package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IncludeServlet extends HttpServlet {
    private static final String MSG = "\tExecuting Include Servlet\t";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(MSG);
        response.getWriter().write(MSG);

        request.getRequestDispatcher("/filter/include/redirect").include(request, response);
    }
}
