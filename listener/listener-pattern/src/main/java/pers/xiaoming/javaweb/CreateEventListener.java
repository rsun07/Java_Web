package pers.xiaoming.javaweb;

public class CreateEventListener implements Listener {
    @Override
    public void handle(CURDEvent event) {
        if (event.getEventType().equals(CURDEvent.EventType.CREATE_EVENT)) {
            System.out.println("Create Event Triggered");
        }
    }
}
