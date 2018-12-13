package com.my.servicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceFeignApplication {

    public static void main(String[] args) {
        try {
            ff(5);
            System.out.println(5);
        } catch (Exception e){
            System.out.println(4);
        }
    }

    private static void ff(int i) {
        if (i < 6) {
            System.out.println(11);
        } else {
            if (i > 8) {

            }
        }
    }
}
