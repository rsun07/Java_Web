package pers.xiaoming.javaweb;

import org.junit.Test;

public class ListenerTest {
    @Test
    public void test() {

        // define listener
        Listener listener = new ListenerImpl();

        // define event source
        EventSource eventSource = new EventSourceImpl();

        // register listener
        eventSource.setListener(listener);

        eventSource.save();
        eventSource.find();
        eventSource.remove();
    }
}
