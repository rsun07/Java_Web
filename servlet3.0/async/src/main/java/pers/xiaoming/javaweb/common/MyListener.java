package pers.xiaoming.javaweb.common;

import pers.xiaoming.javaweb.common.Messages;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        Messages.SERVLET_REQUEST_DESTROY.print();
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }
}
