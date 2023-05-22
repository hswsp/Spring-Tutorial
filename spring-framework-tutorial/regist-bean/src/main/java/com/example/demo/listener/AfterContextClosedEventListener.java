package com.example.demo.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.Ordered;

public class AfterContextClosedEventListener implements ApplicationListener<ContextClosedEvent>, Ordered {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("AfterContextClosedEventr: " + event.getApplicationContext().getId());
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}
