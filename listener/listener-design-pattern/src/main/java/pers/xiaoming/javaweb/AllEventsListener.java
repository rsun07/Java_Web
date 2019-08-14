package pers.xiaoming.javaweb;

public class AllEventsListener implements Listener {
    @Override
    public void handle(CURDEvent event) {
        System.out.println("All events listener triggered");
    }
}
