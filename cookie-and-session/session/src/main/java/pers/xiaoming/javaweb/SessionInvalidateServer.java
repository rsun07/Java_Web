package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionInvalidateServer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Don't create a new session if session not exist
        HttpSession session = req.getSession(false);

        PrintWriter out = resp.getWriter();

        String username = null;

        if (session != null) {
            username = (String) session.getAttribute("username");

            out.println("Name before invalidate is : " + username);

            // invalidate/expire session
            session.invalidate();

            username = (String) session.getAttribute("username");

            out.println("Name after invalidate is : " + username);
        }
    }
}
