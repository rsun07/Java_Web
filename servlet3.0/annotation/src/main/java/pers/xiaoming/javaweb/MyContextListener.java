package pers.xiaoming.javaweb;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    private static final String MESSAGE = "\tExecuting my context listener\t";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(MESSAGE);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
