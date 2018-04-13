package pers.xiaoming.javaweb;

interface CURDEvent {
    enum EventType {
        CREATE_EVENT("create event"),
        UPDATE_EVENT("update event"),
        RETRIEVE_EVENT("retrieve event"),
        DELEtE_EVENT("delete event");

        private String name;

        EventType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    Listenerable getEventSource();

    EventType getEventType();
}
