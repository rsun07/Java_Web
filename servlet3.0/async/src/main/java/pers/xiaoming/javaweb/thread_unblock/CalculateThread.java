package pers.xiaoming.javaweb.thread_unblock;

import pers.xiaoming.javaweb.Messages;

import java.io.PrintWriter;

public class CalculateThread implements Runnable {

    private PrintWriter out;

    CalculateThread(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            Messages.BACKGROUND_THREAD_START.print(out);

            int sum = 0;
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
                sum += i;
                Thread.sleep(500);
            }
            out.println("sum = " + sum);

            Messages.BACKGROUND_THREAD_COMPLETE.print(out);

        } catch (Exception e) {
            // do nothing
            e.printStackTrace();
        }
    }
}
