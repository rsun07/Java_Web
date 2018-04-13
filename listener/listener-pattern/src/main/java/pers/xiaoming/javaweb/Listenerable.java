package pers.xiaoming.javaweb;

interface Listenerable {
    void setListener(Listener listener);

    void triggerListener(CURDEvent event);
}
