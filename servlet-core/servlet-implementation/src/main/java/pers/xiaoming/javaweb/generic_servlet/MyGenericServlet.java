package pers.xiaoming.javaweb.generic_servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/*
 * If we could have a generic servlet, which already implements javax.servlet.Servlet
 * and .
 * Then other feature servlet doesn't need to implement all those common methods.
 *
 * It uses the Adapter Design pattern, leave the sub class to implement the service function.
 *
 * In fact, javax.servlet.GenericServlet already did the job.
 * Here is just a simpler version for learning.
 *
 */
public abstract class MyGenericServlet implements Servlet, ServletConfig {

    private ServletConfig config;

    // Five methods for Servlet
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
        System.out.println("Initialize My Generic Servlet");
        init();
    }

    // A convenience method which can be overridden so that there's no need
    // to call <code>super.init(config)</code>.
    public void init() {

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }


    // The following four are methods in ServletConfig
    @Override
    public String getServletName() {
        return config.getServletName();
    }

    @Override
    public ServletContext getServletContext() {
        return config.getServletContext();
    }

    @Override
    public String getInitParameter(String name) {
        return config.getInitParameter(name);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return config.getInitParameterNames();
    }
}
