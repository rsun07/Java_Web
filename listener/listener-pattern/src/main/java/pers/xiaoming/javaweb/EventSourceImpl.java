package pers.xiaoming.javaweb;

public class EventSourceImpl implements EventSource {
    private Listener listener;

    @Override
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void triggerListener(CURDEvent event) {
        this.listener.handle(event);
    }

    @Override
    public void save() {
        CURDEvent event = new CURDEventImpl(this, CURDEvent.EventType.CREATE_EVENT);
        this.listener.handle(event);
    }

    @Override
    public void modify() {
        CURDEvent event = new CURDEventImpl(this, CURDEvent.EventType.UPDATE_EVENT);
        this.listener.handle(event);
    }

    @Override
    public void remove() {
        CURDEvent event = new CURDEventImpl(this, CURDEvent.EventType.DELETE_EVENT);
        this.listener.handle(event);
    }

    @Override
    public void find() {
        CURDEvent event = new CURDEventImpl(this, CURDEvent.EventType.RETRIEVE_EVENT);
        this.listener.handle(event);
    }
}
