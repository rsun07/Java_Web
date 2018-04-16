package pers.xiaoming.javaweb.thread_unblock;

import pers.xiaoming.javaweb.common.Calculator;

import java.io.PrintWriter;

public class CalculateThread implements Runnable {

    private PrintWriter out;

    CalculateThread(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void run() {
        Calculator.calculate(out);
    }
}
