package pers.xiaoming.javaweb;

interface Listenerable {
    void setListener(Listerner listener);

    void triggerListener(CURDEvent event);
}
