package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionGetServer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usernameAttri = req.getParameter("username");

        // Don't create a new session if session not exist
        HttpSession session = req.getSession(false);

        String usernameSession = null;
        if (session != null) {
            usernameSession = (String) session.getAttribute("username");
        }

        Class sessionClass = null;

        if (session != null) {
            sessionClass = session.getClass();
        }

        String response = String.format(
                "attribute username is : %s \n"
                + "session username is : %s \n"
                + "Session implementation class is, %s " ,
                usernameAttri, usernameSession, sessionClass);

        resp.getWriter().println(response);
    }
}
