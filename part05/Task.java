package main;

import java.util.concurrent.Semaphore;

public class Task implements Runnable {
    /**
     * 信号量
     */
    private final Semaphore semaphore;

    public Task(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            // 获取许可证
            semaphore.acquire();
            // 模拟业务时长
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "办好了～");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放许可证
            semaphore.release();
        }
    }
}