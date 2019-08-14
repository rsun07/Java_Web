package pers.xiaoming.javaweb;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.util.Map;
import java.util.Set;

public class LogoutListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    /*
     *  Session cannot get request info
     *  Without http request info, we cannot get ip
     *  In this project, we use ip to define a single user.
     *
     *  Session cannot get request info but request could get session reference.
     *  This is because, one session could be used by multi requests.
     *
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();

        // session cannot get request
        // String ip = req.getRemoteAddr();

        String ip = (String) session.getAttribute("ip");

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
    }
}
