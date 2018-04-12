package pers.xiaoming.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateServer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie rootCookie = new Cookie("root", "root_cookie");
        Cookie pathCookie = new Cookie("path", "path_cookie");
        Cookie versionCookie = new Cookie("version", "version_cookie");
        Cookie ttlCookie = new Cookie("ttl", "ttl_cookie");

        pathCookie.setPath(req.getContextPath() + "/cookie/cookiepath");
        versionCookie.setVersion(2);
        // ttl in second
        ttlCookie.setMaxAge(10);

        resp.addCookie(rootCookie);
        resp.addCookie(pathCookie);
        resp.addCookie(versionCookie);
        resp.addCookie(ttlCookie);
    }
}
