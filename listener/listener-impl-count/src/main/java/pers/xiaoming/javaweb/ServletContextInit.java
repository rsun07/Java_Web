package pers.xiaoming.javaweb;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServletContextInit implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext context = sce.getServletContext();

        // init request count
        long reqCount = 0L;
        context.setAttribute("request_count", reqCount);


        // init visitor count map
        Map<String, Set<HttpSession>> ipToSessionMap = new HashMap<>();
        context.setAttribute("ips", ipToSessionMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
