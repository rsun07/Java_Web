package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HyperlinkRedirectServer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        HttpSession session = req.getSession();

        session.setAttribute("username", username + "_session");

        String uri = "/session/get";
        uri = resp.encodeRedirectURL(uri);
        resp.getWriter().println("<a href='" + uri + "'> Redirect </a> to SessionGetServer");
    }
}
