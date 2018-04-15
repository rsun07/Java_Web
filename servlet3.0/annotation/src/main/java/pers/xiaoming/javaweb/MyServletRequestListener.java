package pers.xiaoming.javaweb;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    private static final String MESSAGE = "\tExecuting my servlet request listener\t";

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println(MESSAGE);
    }
}
