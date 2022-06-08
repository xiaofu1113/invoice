package com.example.invoice.utils;

/**
 * @Classname Task
 * @Description TODO
 * @Date 2022/5/30 16:46
 * @Author by fuxf
 */
public class Task extends Thread {
    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println(Thread.currentThread().getName()+"线程停止了");
                System.out.println(123);
                System.out.println(123456);
                System.out.println(123456789);
                System.out.println("abc");
                break;
            }
        }
    }
}
