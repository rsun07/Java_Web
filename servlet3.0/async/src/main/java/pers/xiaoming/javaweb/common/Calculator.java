package pers.xiaoming.javaweb.common;

import java.io.PrintWriter;

public class Calculator {
    public static int calculate() {
        int sum = 0;
        try {
            Messages.BACKGROUND_THREAD_START.print();

            sum = cal();

            Messages.BACKGROUND_THREAD_COMPLETE.print();
        } catch (Exception e) {
            // do nothing
            e.printStackTrace();
        }
        return sum;
    }

    public static int calculate(PrintWriter out) {
        int sum = 0;
        try {
            Messages.BACKGROUND_THREAD_START.print(out);

            sum = cal();

            Messages.BACKGROUND_THREAD_COMPLETE.print(out);
        } catch (Exception e) {
            // do nothing
            e.printStackTrace();
        }
        return sum;
    }

    private static int cal() throws InterruptedException {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
            sum += i;
            Thread.sleep(500);
        }
        return sum;
    }
}
