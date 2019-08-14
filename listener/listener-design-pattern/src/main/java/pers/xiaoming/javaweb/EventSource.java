package pers.xiaoming.javaweb;

// Listenerable
interface EventSource {
    void setListener(Listener listener);

    void triggerListener(CURDEvent event);

    void save();

    void modify();

    void remove();

    void find();
}
