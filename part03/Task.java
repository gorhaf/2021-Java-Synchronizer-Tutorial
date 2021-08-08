package main;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {
    /**
     * 重用同步器
     */
    private final CyclicBarrier cyclicBarrier;

    public Task(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            // 模拟匹配时长
            Thread.sleep((long) (Math.random() * 3000));
            System.out.println(Thread.currentThread().getName() + "匹配成功！");
            // 所有线程在此集合，一起往下执行
            cyclicBarrier.await();

            // 模拟准备时长
            Thread.sleep((long) (Math.random() * 3000));
            System.out.println(Thread.currentThread().getName() + "准备好了～");
            // 所有线程在此集合，一起往下执行
            cyclicBarrier.await();

            // 模拟加载时长
            Thread.sleep((long) (Math.random() * 3000));
            System.out.println(Thread.currentThread().getName() + "加载完成。");
            // 所有线程在此集合，一起往下执行
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}