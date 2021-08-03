package main;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {
    /**
     * 计数器
     */
    private final CountDownLatch countDownLatch;

    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "就位");
        try {
            // 所有线程在此等待
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行~");
    }
}