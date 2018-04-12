package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class CreateServer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String caller = req.getHeader("caller");
        String username = req.getParameter("username");

        req.setAttribute("caller", caller);
        req.setAttribute("username", username);

        HttpSession session = req.getSession();

        session.setAttribute("caller", caller);
        session.setAttribute("username", username);

        resp.getWriter().print(String.format("caller is : %s, username is : %s", caller, username));
    }
}
