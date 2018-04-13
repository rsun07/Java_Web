package pers.xiaoming.javaweb;

class CURDEventImpl implements CURDEvent {

    private Listenerable eventSource;
    private String eventName;

    CURDEventImpl(Listenerable eventSource, String eventName) {
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
            case "modify" : return EventType.UPDATE_EVENT;
            case "remove" : return EventType.DELETE_EVENT;
            case "find" : return EventType.RETRIEVE_EVENT;
            default : return EventType.CANNOT_HANDLE_EVENT;
        }
    }
}
