package pers.xiaoming.javaweb;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;
import java.util.Set;

/*
 * This class is for demo use only
 *
 * The project never use this servlet
 */
public class VisitorLogout implements HttpSessionListener {
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
        ServletContext context = se.getSession().getServletContext();
        Map<String, Set<HttpSession>> ipToSessionMap = (Map<String, Set<HttpSession>>) context.getAttribute("ips");
    }
}
