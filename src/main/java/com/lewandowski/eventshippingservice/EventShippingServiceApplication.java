package com.lewandowski.eventshippingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class EventShippingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventShippingServiceApplication.class, args);
    }

}
