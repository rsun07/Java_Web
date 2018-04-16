package pers.xiaoming.javaweb;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

// Listener still need register
// otherwise there is no start point for this program
@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Messages.CONTEXT_LISTENER_EXECUTING.print();

        ServletContext context = sce.getServletContext();

        // dynamic register Servlet
        // in real practice, normally read from config file
        ServletRegistration.Dynamic srd = context.addServlet(Configs.MYSERVLET.getName(), Configs.MYSERVLET.getClassPath());

        // add dynamic inti params
        srd.setInitParameter("namespace", "dynamic_namespace");

        // assign url-pattern for Servlet
        srd.addMapping(Configs.MYSERVLET.getUrlPattern());


        // register another servlet
        srd = context.addServlet(Configs.MYSERVLET_WITH_CONFIG.getName(), Configs.MYSERVLET_WITH_CONFIG.getClassPath());

        Map<String, String> params = new HashMap<>();
        params.put("key", "value");
        params.put("inti_params", "inti_params");
        srd.setInitParameters(params);
        srd.setInitParameters(params);

        srd.addMapping(Configs.MYSERVLET_WITH_CONFIG.getUrlPattern());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
