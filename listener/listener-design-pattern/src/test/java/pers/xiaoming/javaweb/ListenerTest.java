package pers.xiaoming.javaweb;

import org.junit.Test;

public class ListenerTest {
    @Test
    public void test() {

        // define listener
        Listener allEventsListener = new AllEventsListener();
        Listener createEventListener = new CreateEventListener();

        // define event source
        EventSource eventSource = new EventSourceImpl();

        // register listener
        eventSource.setListener(allEventsListener);
        eventSource.setListener(createEventListener);

        eventSource.save();
        eventSource.find();
        eventSource.remove();
    }
}
