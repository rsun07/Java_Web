package pers.xiaoming.javaweb;

interface CURDEvent {
    enum EventType {
        CREATE_EVENT("create event"),
        UPDATE_EVENT("update event"),
        RETRIEVE_EVENT("retrieve event"),
        DELETE_EVENT("delete event"),
        CANNOT_HANDLE_EVENT("Cannot hanle event");

        private String name;

        EventType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    EventSource getEventSource();

    EventType getEventType();
}
