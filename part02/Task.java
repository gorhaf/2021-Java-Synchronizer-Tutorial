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
        try {
            // 模拟下载时长
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "已下载完成～");
        // 计数-1
        countDownLatch.countDown();
    }
}