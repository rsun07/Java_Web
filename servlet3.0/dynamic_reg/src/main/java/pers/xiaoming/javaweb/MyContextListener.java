package pers.xiaoming.javaweb;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

// Listener still need register
// otherwise there is no start point for this program
@WebListener
public class MyContextListener implements ServletContextListener {
    private static final String SERVLET_NAME = "MyServlet";
    private static final String SERVLET_CLASS = "pers.xiaoming.javaweb.MyServlet";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Messages.CONTEXT_LISTENER_EXECUTING.print();

        ServletContext context = sce.getServletContext();

        // dynamic register Servlet
        // in real practice, normally read from config file
        ServletRegistration.Dynamic srd = context.addServlet(SERVLET_NAME, SERVLET_CLASS);

        // add dynamic inti params
        srd.setInitParameter("namespace", "dynamic_namespace");

        Map<String, String> params = new HashMap<>();
        params.put("key", "value");
        params.put("inti_params", "inti_params");
        srd.setInitParameters(params);


        // assign url-pattern for Servlet
        srd.addMapping("/dynamic/servlet");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
