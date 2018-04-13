package pers.xiaoming.javaweb;

public class ListenerImpl implements Listener {

    @Override
    public void handle(CURDEvent event) {
        CURDEvent.EventType evenType = event.getEventType();

        System.out.println(evenType.getName());
    }
}
