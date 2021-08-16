package main;

import java.util.concurrent.Phaser;

public class ReduceTask implements Runnable {
    /**
     * 阶段同步器
     */
    private final Phaser phaser;

    public ReduceTask(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        try {
            // 模拟收集时长
            Thread.sleep((long) (Math.random() * 3000));
            System.out.println(Thread.currentThread().getName() + "收集完毕！");
            // 无需等待其他参与者
            phaser.arrive();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}