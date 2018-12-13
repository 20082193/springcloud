package com.my.eurekaserver;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ppp
 * @date 2018-11-12 14:34
 */

public class CyclicBarrierDemo {
    public static class Soldier implements Runnable {
        private String solider;
        private final CyclicBarrier cyclicBarrier;

        public Soldier(String solider, CyclicBarrier cyclicBarrier) {
            this.solider = solider;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                doWork();
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (InterruptedException e) {

            }
            System.out.println("任务完成");
        }
    }

    public static class BarrierRun implements Runnable {
        boolean flag;
        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令：[士兵" + N + "个完成任务");
            } else {
                System.out.println("司令：[士兵" + N + "个，集合完毕");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("集合队伍");
        for (int i = 0; i < N; i++) {
            System.out.println("士兵" + i + "报道");
            allSoldier[i] = new Thread(new Soldier("士兵" + i, cyclicBarrier));
            allSoldier[i].start();
        }
    }

}
