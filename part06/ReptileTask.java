package main;

import java.util.concurrent.Phaser;

public class ReptileTask implements Runnable {
    /**
     * 阶段同步器
     */
    private final Phaser phaser;

    public ReptileTask(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        try {
            // 模拟爬虫时长
            Thread.sleep((long) (Math.random() * 3000));
            System.out.println(Thread.currentThread().getName() + "已爬完～");
            // 等待其他参与者
            phaser.arriveAndAwaitAdvance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}