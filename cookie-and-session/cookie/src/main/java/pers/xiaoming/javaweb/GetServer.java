package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetServer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        PrintWriter out = resp.getWriter();

        out.println("Cookie implementation class : " + cookies[0].getClass());

        for (Cookie cookie : cookies) {
            out.println(cookie.getName() + " = " + cookie.getValue() + " version: " + cookie.getVersion());
            if ("version".equals(cookie.getName())) {
                cookie.setVersion(cookie.getVersion() + 1);
                resp.addCookie(cookie);
            }
        }
    }
}
