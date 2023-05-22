package com.sm.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyAnnotationEventListener implements Ordered {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Async// 异步
//    @EventListener(classes = {MyEvent.class, ContextRefreshedEvent.class, ContextClosedEvent.class})
//    public void onMyEventPublished(ApplicationEvent event) {
//        if (event instanceof MyEvent) {
//            logger.info("监听到MyEvent事件，我的优先级较低");
//        }
//        if (event instanceof ContextRefreshedEvent) {
//            logger.info("监听到ContextRefreshedEvent事件");
//        }
//        if (event instanceof ContextClosedEvent) {
//            logger.info("监听到ContextClosedEvent事件");
//        }
//    }

    @EventListener(classes = {MyEvent.class}, condition = "#event.flag")
    public void onMyEventPublished(ApplicationEvent event) {
        if (event instanceof MyEvent) {
            logger.info("监听到MyEvent事件，我的优先级较低");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}