package pers.xiaoming.javaweb;

// Listenerable, 被监听者
interface EventSource {
    void setListener(Listener listener);

    void triggerListener(CURDEvent event);

    void save();

    void modify();

    void remove();

    void find();
}
