package pers.xiaoming.javaweb;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestCounter implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext context = sre.getServletContext();

        long count = (long) context.getAttribute("request_count");

        context.setAttribute("request_count", ++count);

        // there is no %ld in java
        System.out.printf("\nTotally number %d request\n", count);
    }
}
