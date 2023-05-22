package com.sm;

import com.sm.event.MyEventPublisher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableAsync
public class MyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MyApplication.class, args);
        MyEventPublisher publisher = context.getBean(MyEventPublisher.class);
        publisher.publishEvent();
    }
}
