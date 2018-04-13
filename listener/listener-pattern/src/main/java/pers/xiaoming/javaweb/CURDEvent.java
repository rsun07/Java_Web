package pers.xiaoming.javaweb;

interface CURDEvent {

    String CREATE_EVENT = "create event";
    String UPDATE_EVENT = "update event";
    String RETRIEVE_EVENT = "retrieve event";
    String DELEtE_EVENT = "delete event";

    Listenerable getEventSource();

    String getEventType();
}
