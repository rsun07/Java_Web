package pers.xiaoming.javaweb.thread_unblock;

import pers.xiaoming.javaweb.Messages;

import java.io.PrintWriter;

public class CalculateThread implements Runnable {

    private PrintWriter out;

    public CalculateThread(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            System.out.println(Messages.BACKGROUND_THREAD_START);
            out.println(Messages.BACKGROUND_THREAD_START);
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
                sum += i;
                Thread.sleep(500);
            }
            out.println("sum = " + sum);

            System.out.println(Messages.BACKGROUND_THREAD_COMPLETE);
            out.println(Messages.BACKGROUND_THREAD_COMPLETE);
        } catch (Exception e) {
            // do nothing
            e.printStackTrace();
        }
    }
}
