package pers.xiaoming.javaweb;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VisitorCounter implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String ip = request.getRemoteAddr();

        ServletContext context = request.getServletContext();
        Map<String, Set<HttpSession>> ipToSessionMap = (Map<String, Set<HttpSession>>) context.getAttribute("ips");

        HttpSession session = request.getSession();

        // this is to resolve session cannot get HttpRequest
        // then cannot use HttpRequest to getRemoteAddr()
        session.setAttribute("ip", ip);

        if (ipToSessionMap.containsKey(ip)) {
            Set<HttpSession> sessionSet = ipToSessionMap.get(ip);
            if (!sessionSet.contains(session)) {
                // if not contains, means the same ip create a new session
                // still not count as a new user visit
                sessionSet.add(session);
                ipToSessionMap.put(ip, sessionSet);
            } else {
                // if contains, do noting
                // means the same ip using the same session to request again
            }
        } else {
            // new ip
            Set<HttpSession> sessionSet = new HashSet<>();
            sessionSet.add(session);
            ipToSessionMap.put(ip, sessionSet);
        }

        context.setAttribute("ips", ipToSessionMap);

        String responseInfo = "Current visiting client number is : " + ipToSessionMap.size();
        System.out.println(responseInfo);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }
}
