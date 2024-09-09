package com.nubeero.brokersvc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages="com.nubeero.client")
public class BrokerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrokerServiceApplication.class,args);
    }
}
