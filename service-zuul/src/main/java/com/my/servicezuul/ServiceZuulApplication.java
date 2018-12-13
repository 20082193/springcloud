package com.my.servicezuul;

import org.bouncycastle.asn1.x509.sigi.PersonalData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ServiceZuulApplication {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue s;
        BlockingQueue<Data> queue = new LinkedBlockingQueue<>(100);
        AtomicInteger i = new AtomicInteger(0);
        ff((BlockingQueue<Data>) queue, i);
        ff((BlockingQueue<Data>) queue, i);
        ff((BlockingQueue<Data>) queue, i);
        new Thread(()->{
            while (true) {
                try {
                    Data take = queue.take();
                    System.out.println(take.string);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void ff(BlockingQueue<Data> queue, AtomicInteger i) {
        new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (queue.offer(new Data("" + i.incrementAndGet()))) {
                    System.out.println("入队列成功");
                }
            }
        }).start();
    }

    static class Data{
        String string;

        Data(String s) {
            this.string = s;
        }
    }
}
