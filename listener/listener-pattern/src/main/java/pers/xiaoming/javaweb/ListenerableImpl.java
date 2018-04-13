package pers.xiaoming.javaweb;

public class ListenerableImpl implements Listenerable {
    private Listener listener;

    @Override
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void triggerListener(CURDEvent event) {
        this.listener.handle(event);
    }
}
