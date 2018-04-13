package pers.xiaoming.javaweb;

class CURDEventImpl implements CURDEvent {

    private EventSource eventSource;
    private EventType eventType;

    CURDEventImpl(EventSource eventSource, EventType eventType) {
        this.eventSource = eventSource;
        this.eventType = eventType;
    }

    @Override
    public EventSource getEventSource() {
        return eventSource;
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }
}
