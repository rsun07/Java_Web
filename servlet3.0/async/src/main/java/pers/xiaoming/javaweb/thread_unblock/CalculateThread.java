package pers.xiaoming.javaweb.thread_unblock;

import java.io.PrintWriter;

public class CalculateThread implements Runnable {

    private PrintWriter out;

    public CalculateThread(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            out.println("Thread Calculation start!");
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
                sum += i;
                Thread.sleep(500);
            }
            out.println("sum = " + sum);
            out.println("Thread Calculation completed!");
        } catch (Exception e) {
            // do nothing
            e.printStackTrace();
        }
    }
}
