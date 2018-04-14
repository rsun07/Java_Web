package pers.xiaoming.javaweb;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();
        HttpSession session = req.getSession();

        String ip = req.getRemoteAddr();

        Map<String, Set<HttpSession>> ipToSessionMap = (Map<String, Set<HttpSession>>) context.getAttribute("ips");

        if (ipToSessionMap.containsKey(ip)) {
            Set<HttpSession> set = ipToSessionMap.get(ip);
            if (set == null || set.size() == 0) {
                ipToSessionMap.remove(ip);
            } else if (set.contains(session)) {
                if (set.size() == 1) {
                    ipToSessionMap.remove(ip);
                } else {
                    set.remove(session);
                    ipToSessionMap.put(ip, set);
                }
            } else {
                // session not exist,
                // log
                // exception
            }
        }

        context.setAttribute("ips", ipToSessionMap);
        String responseInfo = "Current visiting client number is : " + ipToSessionMap.size();
        System.out.println(responseInfo);
        resp.getWriter().println(responseInfo);
    }
}
