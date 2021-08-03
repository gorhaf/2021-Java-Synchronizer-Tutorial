package main;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {
    /**
     * 计数器
     */
    private final CountDownLatch countDownLatch;
    /**
     * 标记
     */
    private static boolean flag = false;

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
        // 秒杀
        onlyOne();
    }

    private static synchronized void onlyOne() {
        // 当标记为 false 时
        if (!flag) {
            System.out.println(Thread.currentThread().getName() + "抢到了～");
            // 将标记改为 true
            flag = true;
        }
    }
}