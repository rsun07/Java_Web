package pers.xiaoming.javaweb;

public class CURDEventImpl implements CURDEvent {

    private Listenerable eventSource;
    private String eventName;

    public CURDEventImpl(Listenerable eventSource, String eventName) {
        this.eventSource = eventSource;
        this.eventName = eventName;
    }

    @Override
    public Listenerable getEventSource() {
        return eventSource;
    }

    @Override
    public EventType getEventType() {
        switch (eventName) {
            case "save" : return EventType.CREATE_EVENT;
            case "update" : return EventType.UPDATE_EVENT;
            case "delete" : return EventType.DELEtE_EVENT;
            case "find" : return EventType.RETRIEVE_EVENT;
            default : return null;
        }
    }
}
