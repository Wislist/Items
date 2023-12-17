package com.wilsit.schedule.test.哲学家就餐问题;

import java.util.concurrent.Semaphore;

/**
 * Todo: 哲学家就餐问题
 * @Author Wislist
 */
class Philosopher implements Runnable {
    private int id;
    private Semaphore[] forks;

    public Philosopher(int id, Semaphore[] forks) {
        this.id = id;
        this.forks = forks;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 哲学家思考
                System.out.println("Philosopher " + id + " is thinking.");
                Thread.sleep(1000);

                // 哲学家饥饿，尝试拿起筷子
                System.out.println("Philosopher " + id + " is hungry.");

                // 获取左手边的筷子
                forks[id].acquire();
                System.out.println("Philosopher " + id + " picks up left fork.");

                // 获取右手边的筷子（编号为(id + 1) % forks.length）
                forks[(id + 1) % forks.length].acquire();
                System.out.println("Philosopher " + id + " picks up right fork.");

                // 哲学家进餐
                System.out.println("Philosopher " + id + " is eating.");
                Thread.sleep(1000);

                // 进餐完成，放下筷子
                forks[id].release();
                System.out.println("Philosopher " + id + " puts down left fork.");

                forks[(id + 1) % forks.length].release();
                System.out.println("Philosopher " + id + " puts down right fork.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        int numPhilosophers = 5; // 哲学家的数量
        Semaphore[] forks = new Semaphore[numPhilosophers];

        // 初始化筷子信号量
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Semaphore(1);
        }

        // 创建哲学家线程
        Thread[] threads = new Thread[numPhilosophers];
        for (int i = 0; i < numPhilosophers; i++) {
            threads[i] = new Thread(new Philosopher(i, forks));
            threads[i].start();
        }

        // 等待哲学家线程结束
        try {
            for (int i = 0; i < numPhilosophers; i++) {
                threads[i].join();
            }
        } finally {
            System.out.println("shit");
        }
    }
}