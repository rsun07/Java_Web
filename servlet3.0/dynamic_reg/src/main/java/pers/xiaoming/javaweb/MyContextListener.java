package pers.xiaoming.javaweb;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.util.EnumSet;
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

        regMyServlet(context, Config.MYSERVLET);
        regMyServletWithConfig(context, Config.MYSERVLET_WITH_CONFIG);

        regMyFilterForServlet(context, Config.MYFILTER_FOR_SERVLET);
        regMyFilterURLPattern(context, Config.MYFILTER_URL_PATTERN);
    }

    private void regMyServlet(ServletContext context, Config config) {
        // dynamic register Servlet
        // in real practice, normally read from config file
        ServletRegistration.Dynamic srd = context.addServlet(config.getName(), config.getClassPath());

        // add dynamic inti params
        srd.setInitParameter("namespace", "dynamic_namespace");

        // assign url-pattern for Servlet
        srd.addMapping(config.getUrlPattern());
    }

    private void regMyServletWithConfig(ServletContext context, Config config) {
        // register another servlet
        ServletRegistration.Dynamic srd = context.addServlet(config.getName(), config.getClassPath());

        Map<String, String> params = new HashMap<>();
        params.put("key", "value");
        params.put("inti_params", "inti_params");
        srd.setInitParameters(params);
        srd.setInitParameters(params);

        srd.addMapping(config.getUrlPattern());
    }

    private void regMyFilterForServlet(ServletContext context, Config config) {
        FilterRegistration.Dynamic frd = context.addFilter(config.getName(), config.getClassPath());

        // isMatchAfter is used to decide the filter running sequence
        frd.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, Config.MYSERVLET.getName());
    }

    private void regMyFilterURLPattern(ServletContext context, Config config) {
        FilterRegistration.Dynamic frd = context.addFilter(config.getName(), config.getClassPath());

        // isMatchAfter is used to decide the filter running sequence
        // false means not after, so although MyFilterForServlet is registered before
        // but MyFilterURLPattern will execute first
        frd.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, Config.MYSERVLET.getUrlPattern());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
