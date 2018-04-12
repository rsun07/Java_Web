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
        String callerAttri = req.getParameter("caller");
        String usernameAttri = req.getParameter("username");

        // Don't create a new session if session not exist
        HttpSession session = req.getSession(false);

        String callerSession = null;
        String usernameSession = null;
        if (session != null) {
            callerSession = (String) session.getAttribute("caller");
            usernameSession = (String) session.getAttribute("username");
        }

        String response = String.format(
                "attribute caller is : %s \n"
                + "attribute username is : %s \n"
                + "attribute caller is : %s \n"
                + "attribute username is : %s \n",
                callerAttri, usernameAttri, callerSession, usernameSession );

        resp.getWriter().println(response);
    }
}
