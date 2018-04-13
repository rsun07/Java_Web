package pers.xiaoming.javaweb;

import org.junit.Test;

public class ListenerTest {
    @Test
    public void test() {

        // define listener
        Listener listener = new ListenerImpl();

        // define event source
        Listenerable eventSource = new ListenerableImpl();

        // register listener
        eventSource.setListener(listener);

        // define an event
        CURDEvent createEvent = new CURDEventImpl(eventSource, "save");
        CURDEvent retrieveEvent = new CURDEventImpl(eventSource, "find");
        CURDEvent cannotHandleEvent = new CURDEventImpl(eventSource, "cannot");

        eventSource.triggerListener(createEvent);
        eventSource.triggerListener(retrieveEvent);
        eventSource.triggerListener(cannotHandleEvent);
    }
}
