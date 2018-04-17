package pers.xiaoming.javaweb;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

public class SourceCode {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();

        tomcat.setHostname("localhost");
        tomcat.setPort(8080);
        tomcat.setBaseDir(System.getProperty("user.dir"));

        String contextPath = "";

        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(context);

        tomcat.addServlet(contextPath, "myservlet", new MyServlet());
        context.addServletMappingDecoded("/tomcat/myservlet", "myservlet");

        tomcat.start();

        tomcat.getServer().await();
    }
}
