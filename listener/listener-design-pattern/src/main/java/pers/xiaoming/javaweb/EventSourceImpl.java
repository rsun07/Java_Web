package pers.xiaoming.javaweb;

import java.util.ArrayList;
import java.util.List;

public class EventSourceImpl implements EventSource {
    private List<Listener> listeners;

    EventSourceImpl() {
        listeners = new ArrayList<>();
    }

    @Override
    public void setListener(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void triggerListener(CURDEvent event) {
        for (Listener listener : listeners) {
            listener.handle(event);
        }
    }

    @Override
    public void save() {
        CURDEvent event = new CURDEventImpl(this, CURDEvent.EventType.CREATE_EVENT);
        triggerListener(event);
    }

    @Override
    public void modify() {
        CURDEvent event = new CURDEventImpl(this, CURDEvent.EventType.UPDATE_EVENT);
        triggerListener(event);
    }

    @Override
    public void remove() {
        CURDEvent event = new CURDEventImpl(this, CURDEvent.EventType.DELETE_EVENT);
        triggerListener(event);
    }

    @Override
    public void find() {
        CURDEvent event = new CURDEventImpl(this, CURDEvent.EventType.RETRIEVE_EVENT);
        triggerListener(event);
    }
}
